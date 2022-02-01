package com.tencent.tavmovie.base;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import java.util.ArrayList;
import java.util.List;

public class TAVMovieVideoConfiguration
  implements Cloneable
{
  private TAVVideoConfiguration.TAVVideoConfigurationContentMode contentMode = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;
  private List<? extends TAVVideoEffect> effects = new ArrayList();
  private CGRect frame;
  private int preferRotation = 0;
  private Matrix transform;
  
  public TAVMovieVideoConfiguration clone()
  {
    TAVMovieVideoConfiguration localTAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
    if (this.frame != null) {}
    for (CGRect localCGRect = this.frame.clone();; localCGRect = null)
    {
      localTAVMovieVideoConfiguration.frame = localCGRect;
      localTAVMovieVideoConfiguration.contentMode = this.contentMode;
      localTAVMovieVideoConfiguration.transform = new Matrix(this.transform);
      localTAVMovieVideoConfiguration.effects = new ArrayList(this.effects);
      localTAVMovieVideoConfiguration.preferRotation = this.preferRotation;
      return localTAVMovieVideoConfiguration;
    }
  }
  
  public TAVVideoConfiguration convertToConfiguration()
  {
    TAVVideoConfiguration localTAVVideoConfiguration = new TAVVideoConfiguration();
    localTAVVideoConfiguration.setFrame(this.frame);
    localTAVVideoConfiguration.setContentMode(this.contentMode);
    localTAVVideoConfiguration.setTransform(this.transform);
    localTAVVideoConfiguration.getEffects().addAll(this.effects);
    localTAVVideoConfiguration.setPreferRotation(this.preferRotation);
    return localTAVVideoConfiguration;
  }
  
  public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode()
  {
    return this.contentMode;
  }
  
  public CGRect getFrame()
  {
    return this.frame;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  public void setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    this.contentMode = paramTAVVideoConfigurationContentMode;
  }
  
  public void setEffects(List<? extends TAVVideoEffect> paramList)
  {
    this.effects = paramList;
  }
  
  public void setFrame(CGRect paramCGRect)
  {
    this.frame = paramCGRect;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.base.TAVMovieVideoConfiguration
 * JD-Core Version:    0.7.0.1
 */