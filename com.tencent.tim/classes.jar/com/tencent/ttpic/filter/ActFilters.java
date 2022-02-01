package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.CameraActItem;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CaptureActItem;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FrameSourceItem;
import com.tencent.ttpic.model.SingleScoreActItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StarActItem;
import com.tencent.ttpic.model.TotalScoreActItem;
import com.tencent.ttpic.model.VideoActItem;
import com.tencent.ttpic.openapi.model.Rect;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.ActUtil.FRAME_SOURCE_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActFilters
{
  private static final String TAG = ActFilters.class.getSimpleName();
  private static Comparator<CanvasItem> actItemComparator = new ActFilters.1();
  private String dataPath;
  private long duration;
  private FaceExpression faceExpression;
  private long lastUpdateIndex = 9223372036854775807L;
  private boolean mAudioPause;
  private Frame mCanvasFrame = new Frame();
  private FrameBaseFilter mCopyFilter = new FrameBaseFilter();
  private PlayerUtil.Player mPlayer;
  private FrameVideoFilter mVideoFilter = new FrameVideoFilter();
  private Map<Integer, FrameSourceItem> sourceItems;
  private long startUpdateTime = -1L;
  
  public ActFilters(FaceExpression paramFaceExpression, String paramString)
  {
    this.faceExpression = paramFaceExpression;
    this.duration = (Math.max(paramFaceExpression.frameDuration * paramFaceExpression.frames, 1.0D));
    this.dataPath = paramString;
    initFrameSourceItems(paramFaceExpression);
  }
  
  private void createAudioPlayer()
  {
    String str = this.dataPath + File.separator + "expression" + File.separator + this.faceExpression.audioID;
    if ((!TextUtils.isEmpty(str)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = PlayerUtil.createPlayer(AEModule.getContext(), str, false);
    }
  }
  
  private List<CanvasItem> getCanvasItems(List<CanvasItem> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CanvasItem localCanvasItem = (CanvasItem)paramList.next();
      if ((localCanvasItem.startTime <= paramLong) && (paramLong <= localCanvasItem.endTime)) {
        localArrayList.add(localCanvasItem);
      }
    }
    return localArrayList;
  }
  
  private void initFrameSourceItems(FaceExpression paramFaceExpression)
  {
    if (paramFaceExpression.canvasSize == null) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    if (paramFaceExpression.canvasSize.width * paramFaceExpression.canvasSize.height <= 0) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    this.sourceItems = new HashMap();
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAMERA.value), new CameraActItem(this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.VIDEO.value), new VideoActItem(this.dataPath + File.separator + "expression" + File.separator + paramFaceExpression.videoID, this.mVideoFilter));
    CaptureActItem localCaptureActItem = new CaptureActItem(paramFaceExpression.expressionList, this.dataPath, paramFaceExpression.scoreImageID, this.mCopyFilter);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAPTURE.value), localCaptureActItem);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.STAR_IMAGE.value), new StarActItem(paramFaceExpression.expressionList, this.dataPath, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.TOTAL_SCORE.value), new TotalScoreActItem(localCaptureActItem, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.SINGEL_SCORE.value), new SingleScoreActItem(localCaptureActItem, this.mCopyFilter));
  }
  
  private boolean needResize(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    boolean bool = false;
    if ((Float.compare(paramArrayOfFloat1[0], -1.0F) != 0) || (Float.compare(paramArrayOfFloat1[1], -1.0F) != 0) || (Float.compare(paramArrayOfFloat2[0], 0.0F) != 0) || (Float.compare(paramArrayOfFloat2[1], 0.0F) != 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void render(long paramLong)
  {
    List localList = getCanvasItems(this.faceExpression.canvasItemList, paramLong);
    Collections.sort(localList, actItemComparator);
    int i = 0;
    while (i < localList.size())
    {
      CanvasItem localCanvasItem = (CanvasItem)localList.get(i);
      FrameSourceItem localFrameSourceItem = (FrameSourceItem)this.sourceItems.get(Integer.valueOf(localCanvasItem.type));
      if (((localFrameSourceItem instanceof StarActItem)) || ((!(localFrameSourceItem instanceof SingleScoreActItem)) && ((localFrameSourceItem instanceof StarActItem)))) {}
      localFrameSourceItem.draw(this.mCanvasFrame, localCanvasItem, paramLong);
      i += 1;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    this.mCopyFilter.apply();
    this.mVideoFilter.apply();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).init();
    }
    this.mCanvasFrame.bindFrame(-1, this.faceExpression.canvasSize.width, this.faceExpression.canvasSize.height, 0.0D);
  }
  
  public void clear()
  {
    this.mCopyFilter.clearGLSLSelf();
    this.mVideoFilter.clearGLSLSelf();
    this.mCanvasFrame.clear();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).clear();
    }
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public Map<Integer, FrameSourceItem> getSourceItems()
  {
    return this.sourceItems;
  }
  
  public void reset()
  {
    this.startUpdateTime = -1L;
  }
  
  public void reset(long paramLong)
  {
    this.startUpdateTime = paramLong;
    this.lastUpdateIndex = 9223372036854775807L;
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).reset();
    }
    createAudioPlayer();
    PlayerUtil.startPlayer(this.mPlayer, true);
    LogUtils.d(TAG, "[reset actFilters]");
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mCopyFilter.setRenderMode(paramInt);
    this.mVideoFilter.setRenderMode(paramInt);
  }
  
  public void setSourceItems(Map<Integer, FrameSourceItem> paramMap)
  {
    this.sourceItems = paramMap;
  }
  
  public Frame updateAndRender(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    if (this.startUpdateTime <= 0L) {
      this.startUpdateTime = paramLong;
    }
    int i;
    if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause))
    {
      destroyAudio();
      i = (int)((paramLong - this.startUpdateTime) % this.duration / this.faceExpression.frameDuration);
      if (i >= this.lastUpdateIndex) {
        break label398;
      }
      reset(paramLong);
      i = 0;
    }
    label398:
    for (;;)
    {
      this.lastUpdateIndex = i;
      Iterator localIterator = this.sourceItems.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((FrameSourceItem)localIterator.next()).update(paramFrame, i, paramList, paramList1, paramInt);
          continue;
          if (this.mPlayer == null)
          {
            createAudioPlayer();
            PlayerUtil.seekPlayer(this.mPlayer, (int)((paramLong - this.startUpdateTime) % this.duration));
            break;
          }
          PlayerUtil.startPlayer(this.mPlayer, false);
          break;
        }
      }
      this.mCanvasFrame.bindFrame(-1, this.mCanvasFrame.width, this.mCanvasFrame.height, 0.0D);
      render(i);
      paramList = AlgoUtils.calPositions(new Rect(0, 0, paramFrame.width, paramFrame.height), this.mCanvasFrame.width, this.mCanvasFrame.height, paramFrame.width, paramFrame.height, this.faceExpression.canvasResizeMode);
      paramList1 = AlgoUtils.calTexCords(new Rect(0, 0, paramFrame.width, paramFrame.height), this.mCanvasFrame.width, this.mCanvasFrame.height, this.faceExpression.canvasResizeMode);
      BenchUtil.benchStart(TAG + "[resize]");
      this.mCopyFilter.setPositions(paramList);
      this.mCopyFilter.setTexCords(paramList1);
      this.mCopyFilter.RenderProcess(this.mCanvasFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
      BenchUtil.benchEnd(TAG + "[resize]");
      return paramFrame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.ActFilters
 * JD-Core Version:    0.7.0.1
 */