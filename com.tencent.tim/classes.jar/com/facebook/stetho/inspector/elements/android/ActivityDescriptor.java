package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.FragmentActivityAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.common.android.FragmentManagerAccessor;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;
import java.util.List;
import javax.annotation.Nullable;

final class ActivityDescriptor
  extends AbstractChainedDescriptor<Activity>
  implements HighlightableDescriptor
{
  private static void getDialogFragments(@Nullable FragmentCompat paramFragmentCompat, Activity paramActivity, Accumulator<Object> paramAccumulator)
  {
    if ((paramFragmentCompat == null) || (!paramFragmentCompat.getFragmentActivityClass().isInstance(paramActivity))) {}
    for (;;)
    {
      return;
      paramActivity = paramFragmentCompat.forFragmentActivity().getFragmentManager(paramActivity);
      if (paramActivity != null)
      {
        paramActivity = paramFragmentCompat.forFragmentManager().getAddedFragments(paramActivity);
        if (paramActivity != null)
        {
          int i = 0;
          int j = paramActivity.size();
          while (i < j)
          {
            Object localObject = paramActivity.get(i);
            if (paramFragmentCompat.getDialogFragmentClass().isInstance(localObject)) {
              paramAccumulator.store(localObject);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public View getViewForHighlighting(Object paramObject)
  {
    Descriptor.Host localHost = getHost();
    if ((localHost instanceof AndroidDescriptorHost))
    {
      paramObject = ((Activity)paramObject).getWindow();
      return ((AndroidDescriptorHost)localHost).getHighlightingView(paramObject);
    }
    return null;
  }
  
  protected void onGetChildren(Activity paramActivity, Accumulator<Object> paramAccumulator)
  {
    getDialogFragments(FragmentCompat.getMoaiLibInstance(), paramActivity, paramAccumulator);
    getDialogFragments(FragmentCompat.getSupportLibInstance(), paramActivity, paramAccumulator);
    getDialogFragments(FragmentCompat.getFrameworkInstance(), paramActivity, paramAccumulator);
    paramActivity = paramActivity.getWindow();
    if (paramActivity != null) {
      paramAccumulator.store(paramActivity);
    }
  }
  
  protected String onGetNodeName(Activity paramActivity)
  {
    return StringUtil.removePrefix(paramActivity.getClass().getName(), "android.app.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ActivityDescriptor
 * JD-Core Version:    0.7.0.1
 */