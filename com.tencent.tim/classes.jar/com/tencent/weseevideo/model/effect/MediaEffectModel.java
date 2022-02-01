package com.tencent.weseevideo.model.effect;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.ArrayList;
import java.util.List;

public class MediaEffectModel
  extends BaseMediaModel
{
  private AEKitModel aeKitModel;
  private AIFilterModel aiFilterModel;
  private CropModel cropModel;
  private LutModel lutModel;
  private MusicModel musicModel = new MusicModel();
  private List<StickerModel> stickerModelList = new ArrayList();
  
  public AEKitModel getAeKitModel()
  {
    return this.aeKitModel;
  }
  
  @Nullable
  public AIFilterModel getAiFilterModel()
  {
    return this.aiFilterModel;
  }
  
  @Nullable
  public CropModel getCropModel()
  {
    return this.cropModel;
  }
  
  @Nullable
  public LutModel getLutModel()
  {
    return this.lutModel;
  }
  
  @NonNull
  public MusicModel getMusicModel()
  {
    return this.musicModel;
  }
  
  @NonNull
  public List<StickerModel> getStickerModelList()
  {
    return this.stickerModelList;
  }
  
  public void setAeKitModel(AEKitModel paramAEKitModel)
  {
    this.aeKitModel = paramAEKitModel;
  }
  
  public void setAiFilterModel(AIFilterModel paramAIFilterModel)
  {
    this.aiFilterModel = paramAIFilterModel;
  }
  
  public void setCropModel(CropModel paramCropModel)
  {
    this.cropModel = paramCropModel;
  }
  
  public void setLutModel(LutModel paramLutModel)
  {
    this.lutModel = paramLutModel;
  }
  
  public void setMusicModel(@NonNull MusicModel paramMusicModel)
  {
    this.musicModel = paramMusicModel;
  }
  
  public void setStickerModelList(@NonNull List<StickerModel> paramList)
  {
    this.stickerModelList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.MediaEffectModel
 * JD-Core Version:    0.7.0.1
 */