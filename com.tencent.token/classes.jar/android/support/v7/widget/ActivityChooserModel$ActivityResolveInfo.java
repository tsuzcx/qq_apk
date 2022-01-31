package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo
  implements Comparable
{
  public final ResolveInfo resolveInfo;
  public float weight;
  
  public ActivityChooserModel$ActivityResolveInfo(ResolveInfo paramResolveInfo)
  {
    this.resolveInfo = paramResolveInfo;
  }
  
  public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
  {
    return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
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
      paramObject = (ActivityResolveInfo)paramObject;
    } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
    return false;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.weight) + 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserModel.ActivityResolveInfo
 * JD-Core Version:    0.7.0.1
 */