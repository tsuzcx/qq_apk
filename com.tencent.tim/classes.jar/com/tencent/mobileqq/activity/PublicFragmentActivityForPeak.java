package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import vnk;

public class PublicFragmentActivityForPeak
  extends PublicFragmentActivity
{
  private ArrayList<WeakReference<vnk>> ps;
  
  public static void start(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivityForPeak.class, paramClass);
  }
  
  public void doOnBackPressed()
  {
    Object localObject1 = super.b();
    if ((localObject1 instanceof vnk))
    {
      if (this.ps == null) {
        this.ps = new ArrayList(2);
      }
      this.ps.add(new WeakReference((vnk)localObject1));
    }
    if (this.ps != null)
    {
      localObject1 = this.ps.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (vnk)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((vnk)localObject2).onBackPressed();
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getIntent().putExtra("fling_action_key", 0);
    return super.doOnCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForPeak
 * JD-Core Version:    0.7.0.1
 */