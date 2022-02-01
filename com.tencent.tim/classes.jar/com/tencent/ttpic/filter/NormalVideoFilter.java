package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.manager.TouchTriggerManager;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.PTFaceLogUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  protected float audioScaleFactor = 1.0F;
  protected long firstTriggerInStateTime = 0L;
  protected int frameIndex;
  protected long frameStartTime;
  private boolean gotSpritePicture = false;
  protected ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isFirstTriggered;
  protected boolean isImageReady;
  protected boolean isInState = false;
  protected boolean isRenderForBitmap;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  private boolean mIsLastPause = false;
  private boolean mIsNeedSeekTime = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected int playMode = 0;
  private int spritePictureColumn;
  private int spritePictureHeight;
  private int spritePictureRow;
  private int spritePictureWidth;
  private int[] tex = new int[2];
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    this.item = paramStickerItem;
    this.dataPath = paramString;
    initParams();
    initAudio();
  }
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2, paramString3);
    this.item = paramStickerItem;
    this.dataPath = paramString1;
    initParams();
    initAudio();
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
      }
      else {
        return;
      }
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private int getNextFrame(int paramInt)
  {
    if (VideoMaterialUtil.isEmptyItem(this.item)) {
      return this.tex[0];
    }
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      if (this.mVideoDecoder.updateFrame()) {
        this.isImageReady = true;
      }
      this.lastImageIndex = paramInt;
    }
    label404:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0) {
        if ((this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
        {
          if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0)
          {
            this.isImageReady = true;
            this.lastImageIndex = paramInt;
          }
        }
        else
        {
          Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
          if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.isRenderForBitmap)))
          {
            localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
            localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          }
          for (int i = 1;; i = 0) {
            for (;;)
            {
              if (!BitmapUtils.isLegal((Bitmap)localObject)) {
                break label404;
              }
              BenchUtil.benchStart("normal loadTexture");
              try
              {
                GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
                BenchUtil.benchEnd("normal loadTexture");
                this.spritePictureWidth = ((Bitmap)localObject).getWidth();
                this.spritePictureHeight = ((Bitmap)localObject).getHeight();
                if (i != 0)
                {
                  ((Bitmap)localObject).recycle();
                  this.isImageReady = true;
                  this.lastImageIndex = paramInt;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  PTFaceLogUtil.e(TAG, "getNextFrame:loadTexture Exception:" + localException.getMessage());
                  continue;
                  VideoMemoryManager.getInstance().recycleBitmap(this.item.id, (Bitmap)localObject);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {}
    for (;;)
    {
      return;
      if ((this.item != null) && (!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
      {
        String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
        if (str.startsWith("assets://")) {}
        for (this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), str.replace("assets://", ""), false); this.mPlayer != null; this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), str, false))
        {
          TouchTriggerManager.getInstance().setMusicDuration(this.mPlayer.getDuration());
          return;
        }
      }
    }
  }
  
  private boolean isFullScreenRender(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return false;
    }
    paramAttributeParam = paramAttributeParam.vertices;
    int j = paramAttributeParam.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  private void recordMusicStartInfo(boolean paramBoolean)
  {
    if (this.mPlayer == null) {
      return;
    }
    if (TouchTriggerManager.getInstance().getMusicStartTime() <= 0L) {
      TouchTriggerManager.getInstance().setMusicStartTime(System.currentTimeMillis());
    }
    if ((!this.mIsLastPause) && (paramBoolean)) {
      TouchTriggerManager.getInstance().setMusicCurrentPosition(this.mPlayer.getCurrentPosition());
    }
    this.mIsLastPause = paramBoolean;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GlUtil.createEtcTexture(this.tex);
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG))
    {
      String str2 = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id;
      String str1 = str2;
      if (!str2.endsWith(".mp4")) {
        str1 = str2 + ".mp4";
      }
      this.mVideoDecoder = new ActVideoDecoder(str1, this.tex[0]);
    }
    if (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) {
      VideoMemoryManager.getInstance().initInGLThread(this.item.id, this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2) && (!this.item.isDisplacementMaterial());
  }
  
  public void clearGLSLSelf()
  {
    int i = 0;
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    try
    {
      while (i < this.tex.length)
      {
        this.tex[i] = 0;
        i += 1;
      }
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.release();
        this.mVideoDecoder = null;
      }
      return;
    }
    finally {}
  }
  
  protected void clearTextureParam()
  {
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    destroyAudio();
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  public int getFrameIndex()
  {
    return this.frameIndex;
  }
  
  public long getFrameStartTime()
  {
    return this.frameStartTime;
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public StickerItem getStickerItem()
  {
    return this.item;
  }
  
  protected int getTextureId()
  {
    return this.tex[0];
  }
  
  public void initParams()
  {
    int i;
    int j;
    if (this.item.transformType == 1)
    {
      i = -1;
      j = 1;
    }
    for (;;)
    {
      addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
      addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
      addParam(new UniformParam.IntParam("texNeedTransform", 1));
      addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
      addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
      addParam(new UniformParam.FloatParam("texScale", 1.0F));
      addParam(new UniformParam.FloatParam("texScaleX", j));
      addParam(new UniformParam.FloatParam("texScaleY", i));
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
      addParam(new UniformParam.FloatParam("alpha", 1.0F));
      addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
      addParam(new UniformParam.Float2fParam("displacement", this.item.displacementX, this.item.displacementY));
      Object localObject = this.dataPath + File.separator + this.item.displacementLutPath;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.item.isDisplacementMaterial()))
      {
        localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1);
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          addParam(new UniformParam.TextureBitmapParam("inputImageTexture4", (Bitmap)localObject, 33988, true));
          addParam(new UniformParam.IntParam("displacementEnableLut", 1));
        }
      }
      for (;;)
      {
        addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
        return;
        if (this.item.transformType != 2) {
          break label477;
        }
        j = -1;
        i = 1;
        break;
        addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
        continue;
        addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
      }
      label477:
      i = 1;
      j = 1;
    }
  }
  
  public boolean isFirstTriggered()
  {
    return this.isFirstTriggered;
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean isStaticSticker()
  {
    return (this.item != null) && ((this.item.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type));
  }
  
  public boolean needCopyTex()
  {
    if (this.item == null) {}
    while (((this.item.blendMode < 2) || (this.item.blendMode > 12)) && (!this.item.isDisplacementMaterial())) {
      return false;
    }
    return true;
  }
  
  boolean needLoadImage()
  {
    return (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type) && (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.SNAP_SHOT.type);
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void pauseAndSeekToOrigin()
  {
    PlayerUtil.pauseAndSeekToOrigin(this.mPlayer);
  }
  
  public void reset()
  {
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
    this.mAudioPause = false;
    pauseAndSeekToOrigin();
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setAudioScaleFactor(float paramFloat)
  {
    this.audioScaleFactor = paramFloat;
  }
  
  public void setFirstTriggerInStateTime(long paramLong)
  {
    this.firstTriggerInStateTime = paramLong;
  }
  
  public void setFirstTriggered(boolean paramBoolean)
  {
    this.isFirstTriggered = paramBoolean;
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setFrameStartTime(long paramLong)
  {
    this.frameStartTime = paramLong;
  }
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setIsInState(boolean paramBoolean)
  {
    this.isInState = paramBoolean;
  }
  
  public void setLastFrameIndex(int paramInt)
  {
    this.lastImageIndex = paramInt;
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.isRenderForBitmap = paramBoolean;
  }
  
  public void setTriggered(boolean paramBoolean)
  {
    this.triggered = paramBoolean;
  }
  
  protected void updateCatFacePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat) {}
  
  public void updateHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    if (paramArrayList != null) {
      this.hotAreaPositions.addAll(paramArrayList);
    }
  }
  
  protected void updatePlayer(boolean paramBoolean)
  {
    if (!this.triggered)
    {
      destroyAudio();
      if ((this.playMode == 1) && (this.isInState)) {
        this.mIsNeedSeekTime = true;
      }
    }
    do
    {
      do
      {
        return;
        if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause)) {
          break;
        }
        initAudio();
      } while (this.mPlayer == null);
      if (this.item.audioLoopCount <= 0) {
        break;
      }
    } while (!paramBoolean);
    if (this.playMode == 0)
    {
      PlayerUtil.startPlayer(this.mPlayer, true);
      recordMusicStartInfo(false);
      return;
    }
    long l;
    if ((this.playMode == 1) && (this.mIsNeedSeekTime))
    {
      l = System.currentTimeMillis();
      PlayerUtil.seekPlayer(this.mPlayer, (int)(l - this.firstTriggerInStateTime) % this.mPlayer.getDuration());
      this.mIsNeedSeekTime = false;
      return;
    }
    PlayerUtil.startPlayer(this.mPlayer, false);
    recordMusicStartInfo(false);
    return;
    if (this.playMode == 0)
    {
      PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
      recordMusicStartInfo(false);
      return;
    }
    if ((this.playMode == 1) && (this.mIsNeedSeekTime))
    {
      l = System.currentTimeMillis();
      PlayerUtil.seekPlayer(this.mPlayer, (int)(l - this.firstTriggerInStateTime) % this.mPlayer.getDuration());
      this.mIsNeedSeekTime = false;
      return;
    }
    PlayerUtil.startPlayer(this.mPlayer, false);
    recordMusicStartInfo(false);
    return;
    PlayerUtil.stopPlayer(this.mPlayer);
    recordMusicStartInfo(true);
  }
  
  protected void updatePositions(List<PointF> paramList) {}
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt) {}
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((!this.item.isDisplacementMaterial()) || (paramObject.displacementMaskFrame == null) || (paramObject.displacementMaskFrame.getLastRenderTextureId() <= 0)) {
        break label140;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture5", paramObject.displacementMaskFrame.getLastRenderTextureId(), 33989));
      addParam(new UniformParam.FloatParam("useDisplacementMask", 1.0F));
    }
    int i;
    for (;;)
    {
      if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      updatePlayer(this.isFirstTriggered);
      i = this.frameIndex;
      if (needRenderTexture()) {
        break;
      }
      clearTextureParam();
      VideoMemoryManager.getInstance().reset(this.item.id);
      updateTextureParam(0, paramObject.timestamp);
      return;
      label140:
      addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
      addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0F));
    }
    if (VideoMaterialUtil.isGestureItem(this.item)) {
      updatePositions(paramObject.handPoints);
    }
    for (;;)
    {
      updateTextureParam(i, paramObject.timestamp);
      return;
      if (VideoMaterialUtil.isBodyDetectItem(this.item))
      {
        if (VideoMaterialUtil.isBody4AnchorItem(this.item)) {
          updatePositionsForMultiAnchor(paramObject.bodyPoints, 4);
        }
        for (;;)
        {
          if (this.mHasBodyDetected) {
            break label279;
          }
          paramObject.bodyPoints = null;
          break;
          if (VideoMaterialUtil.isBody2AnchorItem(this.item)) {
            updatePositionsForMultiAnchor(paramObject.bodyPoints, 2);
          } else {
            updatePositions(paramObject.bodyPoints);
          }
        }
      }
      else
      {
        label279:
        if (VideoMaterialUtil.isCatItem(this.item)) {
          updateCatFacePositions(paramObject.catFacePoints, paramObject.catFaceAngles, paramObject.phoneAngle);
        } else {
          updatePositions(paramObject.facePoints, paramObject.faceAngles, paramObject.phoneAngle);
        }
      }
    }
  }
  
  public void updateRandomGroupValue(int paramInt) {}
  
  public void updateTextureParam(int paramInt)
  {
    if (needLoadImage()) {
      return;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
    this.isImageReady = true;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (!needLoadImage()) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramInt != this.lastImageIndex)
      {
        if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
          this.mVideoDecoder.reset();
        }
        if (this.item.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type)
        {
          ETC1Util.ETC1Texture localETC1Texture1 = VideoMemoryManager.getInstance().loadETCRGBTexture(this.item.id, paramInt);
          ETC1Util.ETC1Texture localETC1Texture2 = VideoMemoryManager.getInstance().loadETCAlphaTexture(this.item.id, paramInt);
          if ((localETC1Texture1 == null) || (localETC1Texture2 == null)) {
            break;
          }
          BenchUtil.benchStart("mPkmReader loadTexture");
          GlUtil.loadTexture(this.tex[0], localETC1Texture1);
          GlUtil.loadTexture(this.tex[1], localETC1Texture2);
          BenchUtil.benchEnd("mPkmReader loadTexture");
          addParam(new UniformParam.TextureParam("inputImageTexture2", this.tex[0], 33986));
          addParam(new UniformParam.TextureParam("inputImageTexture3", this.tex[1], 33987));
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
          return;
        }
        if (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.SPIRITE.type) {
          break label453;
        }
        if (!this.gotSpritePicture)
        {
          addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
          this.gotSpritePicture = true;
          if ((this.item.frameSize == null) || (this.item.frameSize.length < 2)) {
            break label441;
          }
          this.spritePictureColumn = (this.spritePictureWidth / this.item.frameSize[0]);
          this.spritePictureRow = (this.spritePictureHeight / this.item.frameSize[1]);
        }
        while (paramInt < this.spritePictureColumn * this.spritePictureRow)
        {
          float f1 = 1.0F / this.spritePictureRow * Math.min(this.spritePictureRow - 1, paramInt / this.spritePictureColumn);
          float f2 = Math.min(1.0F / this.spritePictureRow + f1, 1.0F);
          float f3 = 1.0F / this.spritePictureColumn * (paramInt % this.spritePictureColumn);
          float f4 = Math.min(1.0F / this.spritePictureColumn + f3, 1.0F);
          setTexCords(new float[] { f3, f1, f3, f2, f4, f2, f4, f1 });
          this.lastImageIndex = paramInt;
          return;
          label441:
          LogUtils.e(TAG, "SPIRITE Invalid frameSize.");
        }
      }
    }
    label453:
    addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(paramInt), 33986));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */