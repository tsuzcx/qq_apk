package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class PublicTransFragmentActivity
  extends PublicFragmentActivity
{
  public static void start(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicTransFragmentActivity
 * JD-Core Version:    0.7.0.1
 */