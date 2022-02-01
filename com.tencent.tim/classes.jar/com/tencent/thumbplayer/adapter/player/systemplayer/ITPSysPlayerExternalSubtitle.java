package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

public abstract interface ITPSysPlayerExternalSubtitle
{
  public abstract void pauseAsync();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setDataSource(String paramString, long paramLong);
  
  public abstract void setOnSubTitleListener(IOnSubTitleListener paramIOnSubTitleListener);
  
  public abstract void setPlayerPositionListener(IPlayPositionListener paramIPlayPositionListener);
  
  public abstract void setSubtitleRenderModel(TPSubtitleRenderModel paramTPSubtitleRenderModel);
  
  public abstract void setSubtitleType(int paramInt);
  
  public abstract void setTrackSelectListener(IOnTrackSelectListener paramIOnTrackSelectListener);
  
  public abstract void startAsync();
  
  public abstract void stop();
  
  public static abstract interface IOnSubTitleListener
  {
    public abstract void onEventInfo();
    
    public abstract void onSubtitleFrameData(TPSubtitleFrame paramTPSubtitleFrame);
    
    public abstract void onSubtitleInfo(ITPSysPlayerExternalSubtitle.SubtitleData paramSubtitleData);
  }
  
  public static abstract interface IOnTrackSelectListener
  {
    public abstract void onTrackSelectFailure(int paramInt, long paramLong);
    
    public abstract void onTrackSelectSuccess(long paramLong);
  }
  
  public static abstract interface IPlayPositionListener
  {
    public abstract long getCurrentPosition();
  }
  
  public static class SubtitleData
  {
    String text;
    
    public SubtitleData(String paramString)
    {
      this.text = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.ITPSysPlayerExternalSubtitle
 * JD-Core Version:    0.7.0.1
 */