package com.tencent.weseevideo.model;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;

public class MediaModel
  extends BaseMediaModel
{
  private MediaEffectModel mediaEffectModel = new MediaEffectModel();
  private MediaResourceModel mediaResourceModel = new MediaResourceModel();
  private MediaTemplateModel mediaTemplateModel = new MediaTemplateModel();
  
  @NonNull
  public MediaEffectModel getMediaEffectModel()
  {
    return this.mediaEffectModel;
  }
  
  @NonNull
  public MediaResourceModel getMediaResourceModel()
  {
    return this.mediaResourceModel;
  }
  
  @NonNull
  public MediaTemplateModel getMediaTemplateModel()
  {
    return this.mediaTemplateModel;
  }
  
  public void setMediaEffectModel(MediaEffectModel paramMediaEffectModel)
  {
    this.mediaEffectModel = paramMediaEffectModel;
  }
  
  public void setMediaResourceModel(MediaResourceModel paramMediaResourceModel)
  {
    this.mediaResourceModel = paramMediaResourceModel;
  }
  
  public void setMediaTemplateModel(@NonNull MediaTemplateModel paramMediaTemplateModel)
  {
    this.mediaTemplateModel = paramMediaTemplateModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.MediaModel
 * JD-Core Version:    0.7.0.1
 */