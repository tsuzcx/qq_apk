package com.tencent.weseevideo.camera.mvauto.data;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;

public class CompositionPack
{
  private TAVComposition mComposition;
  private CMTimeRange mTimeRange;
  private int useTemplate = 0;
  
  public TAVComposition getComposition()
  {
    return this.mComposition;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public int getUseTemplate()
  {
    return this.useTemplate;
  }
  
  public void setComposition(TAVComposition paramTAVComposition)
  {
    this.mComposition = paramTAVComposition;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mTimeRange = paramCMTimeRange;
  }
  
  public void setUseTemplate(int paramInt)
  {
    this.useTemplate = paramInt;
  }
  
  public class TemplateConstantType
  {
    public static final int AUTO_TEMPLATE = 1;
    public static final int MOVIE_TEMPLATE = 2;
    public static final int ORIGINAL = 0;
    
    public TemplateConstantType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.data.CompositionPack
 * JD-Core Version:    0.7.0.1
 */