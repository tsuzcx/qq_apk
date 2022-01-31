package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord
{
  public final ComponentName activity;
  public final long time;
  public final float weight;
  
  public ActivityChooserModel$HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    this.activity = paramComponentName;
    this.time = paramLong;
    this.weight = paramFloat;
  }
  
  public ActivityChooserModel$HistoricalRecord(String paramString, long paramLong, float paramFloat)
  {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (HistoricalRecord)paramObject;
      if (this.activity == null)
      {
        if (paramObject.activity != null) {
          return false;
        }
      }
      else if (!this.activity.equals(paramObject.activity)) {
        return false;
      }
      if (this.time != paramObject.time) {
        return false;
      }
    } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
    return false;
  }
  
  public int hashCode()
  {
    if (this.activity == null) {}
    for (int i = 0;; i = this.activity.hashCode()) {
      return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:").append(this.activity);
    localStringBuilder.append("; time:").append(this.time);
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel.HistoricalRecord
 * JD-Core Version:    0.7.0.1
 */