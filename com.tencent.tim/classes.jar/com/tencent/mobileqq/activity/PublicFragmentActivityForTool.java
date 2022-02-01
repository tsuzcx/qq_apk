package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class PublicFragmentActivityForTool
  extends PublicFragmentActivity
{
  public static void start(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    PublicFragmentActivity.b.start(paramContext, paramIntent, PublicFragmentActivityForTool.class, paramClass);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicFragmentActivityForTool.class, paramClass, paramInt);
  }
  
  public String getModuleId()
  {
    String str2 = getIntent().getStringExtra("moduleId");
    String str1 = str2;
    if (str2 == null) {
      str1 = super.getModuleId();
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForTool
 * JD-Core Version:    0.7.0.1
 */