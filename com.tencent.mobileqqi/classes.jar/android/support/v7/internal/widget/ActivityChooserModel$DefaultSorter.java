package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ActivityChooserModel$DefaultSorter
  implements ActivityChooserModel.ActivitySorter
{
  private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
  private final Map mPackageNameToActivityMap = new HashMap();
  
  private ActivityChooserModel$DefaultSorter(ActivityChooserModel paramActivityChooserModel) {}
  
  public void sort(Intent paramIntent, List paramList1, List paramList2)
  {
    paramIntent = this.mPackageNameToActivityMap;
    paramIntent.clear();
    int j = paramList1.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = (ActivityChooserModel.ActivityResolveInfo)paramList1.get(i);
      ((ActivityChooserModel.ActivityResolveInfo)localObject).weight = 0.0F;
      paramIntent.put(((ActivityChooserModel.ActivityResolveInfo)localObject).resolveInfo.activityInfo.packageName, localObject);
      i += 1;
    }
    i = paramList2.size();
    float f1 = 1.0F;
    i -= 1;
    if (i >= 0)
    {
      localObject = (ActivityChooserModel.HistoricalRecord)paramList2.get(i);
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(((ActivityChooserModel.HistoricalRecord)localObject).activity.getPackageName());
      if (localActivityResolveInfo == null) {
        break label180;
      }
      float f2 = localActivityResolveInfo.weight;
      localActivityResolveInfo.weight = (((ActivityChooserModel.HistoricalRecord)localObject).weight * f1 + f2);
      f1 = 0.95F * f1;
    }
    label180:
    for (;;)
    {
      i -= 1;
      break;
      Collections.sort(paramList1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.DefaultSorter
 * JD-Core Version:    0.7.0.1
 */