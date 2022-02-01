package com.tencent.weseevideo.model.resource;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.ArrayList;
import java.util.List;

public class MediaResourceModel
  extends BaseMediaModel
{
  private List<MediaClipModel> backgroundMusic = new ArrayList();
  private List<MediaClipModel> recordAudios = new ArrayList();
  private List<MediaClipModel> videos = new ArrayList();
  
  @NonNull
  public List<MediaClipModel> getBackgroundMusic()
  {
    return this.backgroundMusic;
  }
  
  @NonNull
  public List<MediaClipModel> getRecordAudios()
  {
    return this.recordAudios;
  }
  
  @NonNull
  public List<MediaClipModel> getVideos()
  {
    return this.videos;
  }
  
  public void setBackgroundMusic(@NonNull List<MediaClipModel> paramList)
  {
    this.backgroundMusic = paramList;
  }
  
  public void setRecordAudios(@NonNull List<MediaClipModel> paramList)
  {
    this.recordAudios = paramList;
  }
  
  public void setVideos(@NonNull List<MediaClipModel> paramList)
  {
    this.videos = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.MediaResourceModel
 * JD-Core Version:    0.7.0.1
 */