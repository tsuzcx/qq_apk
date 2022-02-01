package com.tencent.weseevideo.model.template.movie;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.weseevideo.model.utils.Utils;
import java.util.ArrayList;

public class MovieMediaTemplateModel
{
  private String filePath = "";
  private boolean isAsset;
  private boolean isRedPacketTemplate = false;
  private CMTime maxDuration;
  private CMTime minDuration;
  private ArrayList<MovieSegmentModel> movieSegmentModels = new ArrayList();
  private ArrayList<MovieStickerTextModel> movieStickerTextModels = new ArrayList();
  private String movieTemplateCateId;
  private String movieTemplateId = "";
  private String movieTemplateType;
  private String segmentInfo;
  
  public void clearSegmentModels()
  {
    if (this.movieSegmentModels != null) {
      this.movieSegmentModels.clear();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MovieMediaTemplateModel)paramObject;
    } while ((this.isAsset == paramObject.isAsset) && (this.isRedPacketTemplate == paramObject.isRedPacketTemplate) && (Utils.equals(this.filePath, paramObject.filePath)) && (Utils.equals(this.movieTemplateId, paramObject.movieTemplateId)) && (Utils.equals(this.movieTemplateCateId, paramObject.movieTemplateCateId)) && ((this.movieSegmentModels == paramObject.movieSegmentModels) || ((this.movieSegmentModels != null) && (this.movieSegmentModels.equals(paramObject.movieSegmentModels)))) && (Utils.equals(this.segmentInfo, paramObject.segmentInfo)) && (this.maxDuration != null) && (this.maxDuration.equalsTo(paramObject.maxDuration)) && ((this.movieStickerTextModels == paramObject.movieStickerTextModels) || ((this.movieStickerTextModels != null) && (this.movieStickerTextModels.equals(paramObject.movieStickerTextModels)))) && (this.minDuration != null) && (this.minDuration.equals(paramObject.minDuration)) && (Utils.equals(this.movieTemplateType, paramObject.movieTemplateType)));
    return false;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public CMTime getMaxDuration()
  {
    return this.maxDuration;
  }
  
  public CMTime getMinDuration()
  {
    return this.minDuration;
  }
  
  public ArrayList<MovieSegmentModel> getMovieSegmentModels()
  {
    return this.movieSegmentModels;
  }
  
  public ArrayList<MovieStickerTextModel> getMovieStickerTextModels()
  {
    return this.movieStickerTextModels;
  }
  
  public String getMovieTemplateCateId()
  {
    return this.movieTemplateCateId;
  }
  
  public String getMovieTemplateId()
  {
    return this.movieTemplateId;
  }
  
  public String getMovieTemplateType()
  {
    return this.movieTemplateType;
  }
  
  public String getSegmentInfo()
  {
    return this.segmentInfo;
  }
  
  public boolean isAsset()
  {
    return this.isAsset;
  }
  
  public boolean isContainSegments()
  {
    return (this.movieSegmentModels != null) && (!this.movieSegmentModels.isEmpty());
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.filePath)) || (!FileUtils.exists(this.filePath));
  }
  
  public boolean isRedPacketTemplate()
  {
    return this.isRedPacketTemplate;
  }
  
  public void setAsset(boolean paramBoolean)
  {
    this.isAsset = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setMaxDuration(CMTime paramCMTime)
  {
    this.maxDuration = paramCMTime;
  }
  
  public void setMinDuration(CMTime paramCMTime)
  {
    this.minDuration = paramCMTime;
  }
  
  public void setMovieSegmentModels(ArrayList<MovieSegmentModel> paramArrayList)
  {
    this.movieSegmentModels = paramArrayList;
  }
  
  public void setMovieStickerTextModels(ArrayList<MovieStickerTextModel> paramArrayList)
  {
    this.movieStickerTextModels = paramArrayList;
  }
  
  public void setMovieTemplateCateId(String paramString)
  {
    this.movieTemplateCateId = paramString;
  }
  
  public void setMovieTemplateId(String paramString)
  {
    this.movieTemplateId = paramString;
  }
  
  public void setMovieTemplateType(String paramString)
  {
    this.movieTemplateType = paramString;
  }
  
  public void setRedPacketTemplate(boolean paramBoolean)
  {
    this.isRedPacketTemplate = paramBoolean;
  }
  
  public void setSegmentInfo(String paramString)
  {
    this.segmentInfo = paramString;
  }
  
  public String toString()
  {
    return "MovieMediaTemplateModel{isAsset=" + this.isAsset + ", filePath='" + this.filePath + '\'' + ", movieTemplateId='" + this.movieTemplateId + '\'' + ", movieTemplateCateId='" + this.movieTemplateCateId + '\'' + ", movieSegmentModels=" + this.movieSegmentModels + ", segmentInfo='" + this.segmentInfo + '\'' + ", maxDuration=" + this.maxDuration + ", isRedPacketTemplate=" + this.isRedPacketTemplate + ", movieStickerTextModels=" + this.movieStickerTextModels + ", movieTemplateType= " + this.movieTemplateType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieMediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */