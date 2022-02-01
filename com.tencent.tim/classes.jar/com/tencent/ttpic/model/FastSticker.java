package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.PersonParam;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FastSticker
{
  protected String dataPath;
  protected int height;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  protected boolean mIsRenderForBitmap = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  protected double mScreenScale;
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected RenderParam renderParam = new RenderParam();
  private int[] tex = new int[1];
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered = false;
  protected int width;
  
  FastSticker(StickerItem paramStickerItem, String paramString)
  {
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.renderParam.id = paramStickerItem.id;
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
        return;
      }
      this.mHasSeenValid = false;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private int getNextFrame(int paramInt)
  {
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      this.mVideoDecoder.updateFrame();
      this.isImageReady = true;
      this.lastImageIndex = paramInt;
    }
    label321:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0) {
        if ((this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG) && (!VideoMemoryManager.getInstance().isExtraStickerBitmap(this.item.id)))
        {
          if (VideoMemoryManager.getInstance().loadExtraStickerTxt(this.item.id, paramInt, this.tex[0]) >= 0) {
            this.isImageReady = true;
          }
          this.lastImageIndex = paramInt;
        }
        else
        {
          Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
          if ((localObject == null) && ((VideoMemoryManager.getInstance().isForceLoadFromSdCard()) || (!this.isImageReady) || (this.mIsRenderForBitmap)))
          {
            localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
            localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          }
          for (int i = 1;; i = 0)
          {
            if (!BitmapUtils.isLegal((Bitmap)localObject)) {
              break label321;
            }
            GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
            if (i != 0) {
              ((Bitmap)localObject).recycle();
            }
            for (;;)
            {
              this.isImageReady = true;
              this.lastImageIndex = paramInt;
              break;
              VideoMemoryManager.getInstance().recycleBitmap(this.item.id, (Bitmap)localObject);
            }
          }
        }
      }
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {}
    while ((this.item == null) || (TextUtils.isEmpty(this.dataPath)) || (TextUtils.isEmpty(this.item.id)) || (TextUtils.isEmpty(this.item.audio))) {
      return;
    }
    String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
    if (str.startsWith("assets://"))
    {
      this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), str.replace("assets://", ""), false);
      return;
    }
    this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), str, false);
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.item.charmRange == null) || (this.item.charmRange.isHit())) && ((this.item.ageRange == null) || (this.item.ageRange.isHit())) && ((this.item.genderRange == null) || (this.item.genderRange.isHit())) && ((this.item.popularRange == null) || (this.item.popularRange.isHit())) && ((this.item.cpRange == null) || (this.item.cpRange.isHit()));
  }
  
  private void updateHotArea(int paramInt)
  {
    if ((this.triggered) && (this.item != null) && (this.item.hotArea != null) && (this.item.hotArea.length > 0) && (paramInt >= this.item.redPacketStartFrame) && (paramInt <= this.item.redPacketEndFrame))
    {
      int i = this.item.hotArea.length / 4;
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < i)
      {
        RedPacketPosition localRedPacketPosition = new RedPacketPosition();
        localRedPacketPosition.x = this.item.hotArea[(paramInt * 4)];
        localRedPacketPosition.y = this.item.hotArea[(paramInt * 4 + 1)];
        localRedPacketPosition.width = this.item.hotArea[(paramInt * 4 + 2)];
        localRedPacketPosition.height = this.item.hotArea[(paramInt * 4 + 3)];
        localArrayList.add(localRedPacketPosition);
        paramInt += 1;
      }
      if (this.hotAreaPositions != null) {
        this.hotAreaPositions.addAll(localArrayList);
      }
    }
  }
  
  private void updateTriggerAudio(boolean paramBoolean)
  {
    if (!this.triggered) {
      destroyAudio();
    }
    do
    {
      return;
      if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause)) {
        break label61;
      }
      initAudio();
      if (this.item.audioLoopCount <= 0) {
        break;
      }
    } while (!paramBoolean);
    PlayerUtil.startPlayer(this.mPlayer, true);
    return;
    PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
    return;
    label61:
    PlayerUtil.stopPlayer(this.mPlayer);
  }
  
  public void ApplyGLSLFilter()
  {
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.PAG)) {
      this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4", this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item.blendMode < 2) || (this.item.blendMode > 12);
  }
  
  public void clearGLSLSelf()
  {
    int i = 0;
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
    this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    PlayerUtil.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public String getItemID()
  {
    if (this.item != null) {
      return this.item.id + this.item.hashCode();
    }
    return null;
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public int getTexture()
  {
    return this.tex[0];
  }
  
  public boolean isMatchGender(PersonParam paramPersonParam)
  {
    if (this.item.genderType == 0) {
      return true;
    }
    if (paramPersonParam == null) {
      return false;
    }
    return paramPersonParam.isGenderMatch(this.item.genderType);
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean needRender(int paramInt)
  {
    if ((this.item.personID != -1) && (this.item.personID != paramInt)) {}
    while ((!this.triggered) || (!this.isImageReady)) {
      return false;
    }
    return true;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void reset()
  {
    this.triggered = false;
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void setTriggerCtrlItem(TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.triggerCtrlItem = paramTriggerCtrlItem;
  }
  
  protected abstract void updatePositions(List<PointF> paramList);
  
  protected abstract void updatePositions(List<PointF> paramList, int paramInt);
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat);
  
  protected abstract void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt);
  
  public void updatePreview(Object paramObject)
  {
    int i;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      if (this.triggerCtrlItem == null) {
        break label226;
      }
      i = this.triggerCtrlItem.getFrameIndex();
      updateTriggerAudio(this.triggerCtrlItem.isFirstTriggered());
      this.triggered = this.triggerCtrlItem.isTriggered();
    }
    for (;;)
    {
      updateHotArea(i);
      if (!needRenderTexture())
      {
        clearTextureParam();
        VideoMemoryManager.getInstance().reset(this.item.id);
        updateTextureParam(0);
        return;
      }
      if (VideoMaterialUtil.isFaceItem(this.item)) {
        updatePositions(paramObject.facePoints, paramObject.faceAngles);
      }
      for (;;)
      {
        updateTextureParam(i);
        return;
        if (VideoMaterialUtil.isBodyDetectItem(this.item))
        {
          if (VideoMaterialUtil.isBody4AnchorItem(this.item)) {
            updatePositionsForMultiAnchor(paramObject.bodyPoints, 4);
          }
          for (;;)
          {
            if (this.mHasBodyDetected) {
              break label202;
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
          label202:
          if (VideoMaterialUtil.isGestureItem(this.item)) {
            updatePositions(paramObject.handPoints, 0);
          }
        }
      }
      label226:
      i = 0;
    }
  }
  
  protected void updateTextureParam(int paramInt)
  {
    if (paramInt == this.lastImageIndex) {
      return;
    }
    if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
      this.mVideoDecoder.reset();
    }
    this.renderParam.texture = getNextFrame(paramInt);
  }
  
  public void updateTextureParam(long paramLong)
  {
    if (this.triggerCtrlItem != null)
    {
      int i = this.triggerCtrlItem.getFrameIndex();
      try
      {
        updateTextureParam(i);
        return;
      }
      finally {}
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mScreenScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FastSticker
 * JD-Core Version:    0.7.0.1
 */