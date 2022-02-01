package com.tencent.mobileqq.search.ftsentity;

import amns;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;

public class FTSEntitySearchActivity
  extends BaseSearchActivity
{
  static String caW;
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    caW = paramString;
    Intent localIntent = new Intent(paramContext, FTSEntitySearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("extra_key_fts_type", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public BaseSearchFragment a()
  {
    return FTSEntitySearchFragment.a(caW);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    aqoe.a.cUV = true;
  }
  
  public String vm()
  {
    return amns.h(this, this.dCD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */