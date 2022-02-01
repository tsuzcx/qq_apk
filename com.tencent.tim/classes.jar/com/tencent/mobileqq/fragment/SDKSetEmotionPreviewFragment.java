package com.tencent.mobileqq.fragment;

import ahor;
import akyr;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import aoop;
import avfp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.List;
import kxm;
import sxx;
import wja;

public class SDKSetEmotionPreviewFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, AdapterView.c
{
  private a a;
  private GridView e;
  private int mImgHeight;
  private int mImgWidth;
  private ArrayList<String> wW;
  
  public static void a(String paramString, Context paramContext, View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("SDKSetEmotionPreviewFragment", 2, "startToAioImagePreviewWithPath: path=" + paramString);
    }
    if ((localQQAppInterface == null) || (paramContext == null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.aVW = paramString;
    localAIOImageData.aVX = paramString;
    localAIOImageData.aVY = paramString;
    localAIOImageData.bjd = false;
    paramString = new Bundle();
    if (paramView != null) {
      paramString.putParcelable("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView));
    }
    avfp.a(paramContext, paramString, new AIOImageProviderService(localQQAppInterface.getCurrentUin(), null, 0, null), localAIOImageData, -1, 4);
  }
  
  private void initData()
  {
    this.a = new a();
    this.e.setAdapter(this.a);
    this.a.kV(this.wW);
  }
  
  private void u(View paramView)
  {
    Object localObject = getResources();
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = wja.dp2px(0.0F, (Resources)localObject);
    int k = wja.dp2px(4.0F, (Resources)localObject);
    int m = wja.dp2px(4.0F, (Resources)localObject);
    this.mImgWidth = ((i - j * 2 - k * 3) / 4);
    this.mImgHeight = this.mImgWidth;
    localObject = ((Resources)localObject).getString(2131692370);
    setTitle((CharSequence)localObject, (String)localObject);
    this.e = ((GridView)paramView.findViewById(2131366340));
    this.e.setScrollBarStyle(0);
    this.e.setNumColumns(4);
    this.e.setColumnWidth(this.mImgWidth);
    this.e.setHorizontalSpacing(k);
    this.e.setVerticalSpacing(m);
    this.e.setPadding(j, this.e.getPaddingTop(), j, this.e.getPaddingBottom());
    this.e.setOnItemClickListener(this);
    this.e.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    u(this.mContentView);
    initData();
  }
  
  protected int getContentLayoutId()
  {
    return 2131559298;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null) {
      this.wW = paramBundle.getStringArrayListExtra("path_list");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    kxm.a(getActivity());
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setContentDescription(getString(2131690700));
      this.leftView.setBackgroundResource(2130850369);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    if (this.vg != null) {
      this.vg.setBackgroundColor(-1);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    LayoutInflater mInflater = SDKSetEmotionPreviewFragment.this.getActivity().getLayoutInflater();
    public List<String> rN = new ArrayList();
    
    public a() {}
    
    public int getCount()
    {
      if (this.rN != null) {
        return this.rN.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return this.rN.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131559283, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(SDKSetEmotionPreviewFragment.a(SDKSetEmotionPreviewFragment.this), SDKSetEmotionPreviewFragment.b(SDKSetEmotionPreviewFragment.this)));
        paramView = new a();
        paramView.aZ = ((URLImageView)localView.findViewById(2131366317));
        localView.setTag(paramView);
      }
      for (;;)
      {
        Object localObject1 = (String)this.rN.get(paramInt);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = akyr.lP((String)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = true;
        localObject2 = URLDrawable.getFileDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        paramView.aZ.setScaleType(ImageView.ScaleType.FIT_CENTER);
        paramView.aZ.setImageDrawable((Drawable)localObject2);
        localObject2 = paramView.aZ;
        paramView.aZ.setOnClickListener(new ahor(this, (String)localObject1, (View)localObject2));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
      }
    }
    
    public void kV(List<String> paramList)
    {
      if (paramList == null)
      {
        if (this.rN.size() != 0)
        {
          this.rN.clear();
          notifyDataSetChanged();
        }
        return;
      }
      this.rN.clear();
      this.rN.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public class a
    {
      public URLImageView aZ;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */