package com.tencent.weseevideo.model.template;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.weseevideo.model.BaseMediaModel;
import com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.weseevideo.model.template.movie.MovieMediaTemplateModel;

public class MediaTemplateModel
  extends BaseMediaModel
{
  private AutomaticMediaTemplateModel automaticMediaTemplateModel = new AutomaticMediaTemplateModel();
  private MovieMediaTemplateModel movieMediaTemplateModel = new MovieMediaTemplateModel();
  private String smartMatchTemplateTips;
  
  @NonNull
  public AutomaticMediaTemplateModel getAutomaticMediaTemplateModel()
  {
    return this.automaticMediaTemplateModel;
  }
  
  @NonNull
  public MovieMediaTemplateModel getMovieMediaTemplateModel()
  {
    return this.movieMediaTemplateModel;
  }
  
  @Nullable
  public String getSmartMatchTemplateTips()
  {
    return this.smartMatchTemplateTips;
  }
  
  public boolean isEmpty()
  {
    return (this.movieMediaTemplateModel.isEmpty()) && (this.automaticMediaTemplateModel.isEmpty());
  }
  
  public void setAutomaticMediaTemplateModel(@NonNull AutomaticMediaTemplateModel paramAutomaticMediaTemplateModel)
  {
    this.automaticMediaTemplateModel = paramAutomaticMediaTemplateModel;
  }
  
  public void setMovieMediaTemplateModel(@NonNull MovieMediaTemplateModel paramMovieMediaTemplateModel)
  {
    this.movieMediaTemplateModel = paramMovieMediaTemplateModel;
  }
  
  public void setSmartMatchTemplateTips(@Nullable String paramString)
  {
    this.smartMatchTemplateTips = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.MediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */