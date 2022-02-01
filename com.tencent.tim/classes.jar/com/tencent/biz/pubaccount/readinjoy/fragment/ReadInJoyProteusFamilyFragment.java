package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aqnm;
import auuw;
import auuw.a;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import kgi;
import kgi.b;
import kxb;
import kxb.a;
import kxm;
import lei;
import lej;
import lek;
import lel;
import lem;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyFragment
  extends IphoneTitleBarFragment
  implements kgi.b, kxb.a
{
  private final int DEFAULT_TEXT_COLOR = -16777216;
  public final String TAG = "ReadInJoyProteusFamilyFragment";
  private lem a;
  private Context mContext;
  private TextView oS;
  
  private void aLb()
  {
    setTitle(this.mContext.getString(2131718461));
    kxm.cn(getTitleBarView());
    setTitleTextColor(-16777216);
    Object localObject = this.rightViewImg;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130843678);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setOnClickListener(new lei(this, (ImageView)localObject));
    }
    localObject = getTitleBarView();
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new lej(this));
    }
  }
  
  private void init()
  {
    if (this.mContext != null)
    {
      this.a = new lem((Activity)this.mContext);
      ViewGroup localViewGroup = (ViewGroup)this.mContentView.findViewById(2131373710);
      this.a.i(localViewGroup);
      aLb();
    }
  }
  
  private void setTitleTextColor(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      this.leftView.setBackgroundResource(2130850369);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
  }
  
  public void b(BaseActivity paramBaseActivity, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[3];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 1;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 2;
    tmp24_20;
    String str1 = BaseApplicationImpl.getApplication().getString(2131718461);
    String str2 = BaseApplicationImpl.getApplication().getString(2131718461);
    String str3 = BaseApplicationImpl.getApplication().getString(2131718461);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      auuw.a locala = new auuw.a();
      locala.id = arrayOfInt[i];
      locala.title = new String[] { str1, str2, str3 }[i];
      locala.iconId = new int[] { 2130843671, 2130843672, 2130843671 }[i];
      localArrayList.add(locala);
      i += 1;
    }
    i = aqnm.dip2px(125.0F);
    auuw.a(paramBaseActivity, localArrayList, new lek(this), new lel(this), i, false, -1, 2131755037).showAsDropDown(paramView, -(i - paramView.getWidth()), 0);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    init();
    this.a.onCreate();
    this.oS = ((TextView)this.mContentView.findViewById(2131366995));
    kgi.a().a(8888, this);
  }
  
  public int getContentLayoutId()
  {
    return 2131560447;
  }
  
  public void h(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ReadInJoyProteusFamilyFragment.1(this, paramList));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void mc(String paramString)
  {
    if (this.oS == null) {
      return;
    }
    this.oS.setText(paramString);
    this.oS.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    kxb.a().a(this);
    kxb.a().aHF();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    kxb.a().removeListener();
    if (this.a != null) {
      this.a.onDestroy();
    }
    kgi.a().b(8888, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.a != null) {
      this.a.aBZ();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
    kxm.a(getActivity(), true, kxm.a(getActivity()));
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.a != null) {
      this.a.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.a != null) {
      this.a.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment
 * JD-Core Version:    0.7.0.1
 */