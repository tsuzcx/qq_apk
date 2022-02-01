package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import aryy;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import jyt;
import jyy;

public class AdModuleAdapter
  extends PagerAdapter
{
  private String Uv;
  private jyt a;
  private int aEv;
  private ArrayList<jyy> jE;
  private String mChannelId;
  private Context mContext;
  private String mInfo;
  
  public AdModuleAdapter(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, jyt paramjyt, ArrayList<jyy> paramArrayList)
  {
    this.mContext = paramContext;
    this.Uv = paramString1;
    this.mChannelId = paramString2;
    this.mInfo = paramString3;
    this.aEv = paramInt;
    this.a = paramjyt;
    this.jE = paramArrayList;
  }
  
  public void aBg()
  {
    jyy localjyy = (jyy)this.jE.get(this.jE.size() - 1);
    aryy.a().b(localjyy);
    if (localjyy.b != null) {
      AppNetConnInfo.unregisterNetInfoHandler(localjyy.b);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (jyy)this.jE.get(paramInt);
    paramViewGroup.removeView(paramObject.jn);
    paramObject.onDestroy();
  }
  
  public int getCount()
  {
    if (this.jE != null) {
      return this.jE.size();
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    jyy localjyy = (jyy)this.jE.get(paramInt);
    Context localContext = this.mContext;
    String str1 = this.Uv;
    String str2 = this.mChannelId;
    String str3 = this.mInfo;
    int i = this.aEv;
    jyt localjyt = this.a;
    if (paramInt == getCount() - 1) {}
    for (boolean bool = true;; bool = false)
    {
      localjyy.jn = localjyy.a(localContext, str1, str2, str3, i, localjyt, bool);
      paramViewGroup.addView(localjyy.jn);
      return localjyy.jn;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter
 * JD-Core Version:    0.7.0.1
 */