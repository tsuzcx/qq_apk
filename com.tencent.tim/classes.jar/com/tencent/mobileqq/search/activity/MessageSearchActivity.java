package com.tencent.mobileqq.search.activity;

import acfp;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.MessageSearchFragment;

public class MessageSearchActivity
  extends BaseSearchActivity
{
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MessageSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return new MessageSearchFragment();
  }
  
  protected String vm()
  {
    return acfp.m(2131708237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MessageSearchActivity
 * JD-Core Version:    0.7.0.1
 */