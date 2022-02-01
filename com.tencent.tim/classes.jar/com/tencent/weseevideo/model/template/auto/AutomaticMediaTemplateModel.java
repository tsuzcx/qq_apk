package com.tencent.weseevideo.model.template.auto;

import android.text.TextUtils;
import com.tencent.weseevideo.model.BaseMediaModel;
import java.util.ArrayList;
import java.util.List;

public class AutomaticMediaTemplateModel
  extends BaseMediaModel
{
  private String assetDir = "";
  private String imagePagAssetDir = "";
  private boolean isRhythmTemplate;
  private boolean isSwitchToTemplateByUser;
  private int randomIndex;
  private int randomType;
  private String rhythmEffectID;
  private List<Integer> rhythmSecondEffectIndices = new ArrayList();
  private String templateDir = "";
  private String templateFileName = "";
  
  public void clearAllRhythmCache()
  {
    setRhythmTemplate(false);
    setRhythmEffectID(null);
    clearSegmentModels();
    clearSecondEffectIndices();
    setRandomIndex(0);
    setRandomType(0);
  }
  
  public void clearSecondEffectIndices()
  {
    if (this.rhythmSecondEffectIndices != null) {
      this.rhythmSecondEffectIndices.clear();
    }
  }
  
  public void clearSegmentModels() {}
  
  public String getAssetDir()
  {
    return this.assetDir;
  }
  
  public String getImagePagAssetDir()
  {
    return this.imagePagAssetDir;
  }
  
  public int getRandomIndex()
  {
    return this.randomIndex;
  }
  
  public int getRandomType()
  {
    return this.randomType;
  }
  
  public String getRhythmEffectID()
  {
    return this.rhythmEffectID;
  }
  
  public List<Integer> getRhythmSecondEffectIndices()
  {
    return this.rhythmSecondEffectIndices;
  }
  
  public String getTemplateDir()
  {
    return this.templateDir;
  }
  
  public String getTemplateFileName()
  {
    return this.templateFileName;
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.assetDir)) && (TextUtils.isEmpty(this.templateDir)) && (TextUtils.isEmpty(this.templateFileName));
  }
  
  public boolean isRhythmTemplate()
  {
    return this.isRhythmTemplate;
  }
  
  public boolean isSwitchToTemplateByUser()
  {
    return this.isSwitchToTemplateByUser;
  }
  
  public void setAssetDir(String paramString)
  {
    this.assetDir = paramString;
  }
  
  public void setImagePagAssetDir(String paramString)
  {
    this.imagePagAssetDir = paramString;
  }
  
  public void setRandomIndex(int paramInt)
  {
    this.randomIndex = paramInt;
  }
  
  public void setRandomType(int paramInt)
  {
    this.randomType = paramInt;
  }
  
  public void setRhythmEffectID(String paramString)
  {
    this.rhythmEffectID = paramString;
  }
  
  public void setRhythmSecondEffectIndices(List<Integer> paramList)
  {
    this.rhythmSecondEffectIndices = paramList;
  }
  
  public void setRhythmTemplate(boolean paramBoolean)
  {
    this.isRhythmTemplate = paramBoolean;
  }
  
  public void setSwitchToTemplateByUser(boolean paramBoolean)
  {
    this.isSwitchToTemplateByUser = paramBoolean;
  }
  
  public void setTemplateDir(String paramString)
  {
    this.templateDir = paramString;
  }
  
  public void setTemplateFileName(String paramString)
  {
    this.templateFileName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AutomaticMediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */