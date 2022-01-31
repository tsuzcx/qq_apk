package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@RequiresApi(27)
class TextViewCompat$TextViewCompatApi27Impl
  extends TextViewCompat.TextViewCompatApi26Impl
{
  public int getAutoSizeMaxTextSize(TextView paramTextView)
  {
    return paramTextView.getAutoSizeMaxTextSize();
  }
  
  public int getAutoSizeMinTextSize(TextView paramTextView)
  {
    return paramTextView.getAutoSizeMinTextSize();
  }
  
  public int getAutoSizeStepGranularity(TextView paramTextView)
  {
    return paramTextView.getAutoSizeStepGranularity();
  }
  
  public int[] getAutoSizeTextAvailableSizes(TextView paramTextView)
  {
    return paramTextView.getAutoSizeTextAvailableSizes();
  }
  
  public int getAutoSizeTextType(TextView paramTextView)
  {
    return paramTextView.getAutoSizeTextType();
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
  {
    paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(TextView paramTextView, int paramInt)
  {
    paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat.TextViewCompatApi27Impl
 * JD-Core Version:    0.7.0.1
 */