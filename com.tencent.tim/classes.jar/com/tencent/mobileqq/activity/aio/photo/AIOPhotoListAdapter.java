package com.tencent.mobileqq.activity.aio.photo;

import acfp;
import agmx;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aoop;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import wja;
import xto;
import xub;
import xud;
import xuf;
import xuh;

public class AIOPhotoListAdapter
  extends AbstractImageAdapter
{
  static final Object bT = new Object();
  private xto a;
  public boolean aTT;
  private int aVz;
  xuh b;
  private boolean bjo;
  private boolean bjp;
  private int bvC = -1;
  private GridView e;
  auru i = new auru(ThreadManager.getSubThreadLooper(), null);
  private Context mContext;
  private int mCurType = -1;
  Drawable mFailedDrawable;
  private int mFrom = 0;
  private int mImageWidth;
  private LayoutInflater mInflater;
  
  public AIOPhotoListAdapter(Activity paramActivity, int paramInt, xto paramxto, xuh paramxuh, GridView paramGridView)
  {
    this.mContext = paramActivity;
    this.mInflater = paramActivity.getLayoutInflater();
    this.mImageWidth = paramInt;
    this.a = paramxto;
    paramxto.Dw(4);
    this.b = paramxuh;
    this.e = paramGridView;
    this.aVz = wja.dp2px(40.0F, this.mContext.getResources());
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    String str;
    do
    {
      do
      {
        return;
        r(paramInt2, paramView);
        return;
      } while (!b.class.isInstance(paramObject));
      paramObject = (b)paramObject;
      str = (String)getItem(paramInt2);
      paramObject.mTextView.setText(str);
      if (AppSetting.enableTalkBack)
      {
        paramInt1 = paramInt2 / 4;
        paramObject.mTextView.setContentDescription(acfp.m(2131702272) + (paramInt1 + 1) + acfp.m(2131702275) + str);
      }
    } while (!Pl());
    ViewGroup localViewGroup = (ViewGroup)paramObject.mCheckBox.getParent();
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839637));
    }
    paramObject.mCheckBox.setVisibility(0);
    paramObject.mCheckBox.setChecked(this.a.a.hS(str));
    paramObject.mCheckBox.setClickable(false);
    paramView.setOnClickListener(new xub(this, str));
  }
  
  private void a(View paramView, xuf paramxuf, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView, a parama)
  {
    paramView.setVisibility(0);
    paramView = (AIOShortVideoData)paramxuf.e;
    if (paramView.mBusiType == 0)
    {
      paramImageView.setImageResource(2130839728);
      paramTextView.setText(ShortVideoUtils.stringForTime(paramView.bqB * 1000));
      paramTextView.setVisibility(0);
      paramImageView.setVisibility(0);
      if (paramView.c(0) == null) {
        break label172;
      }
      paramView = paramView.cH(0);
      paramxuf = URLDrawable.URLDrawableOptions.obtain();
      paramImageView = paramURLImageView.getDrawable();
      paramxuf.mRequestWidth = this.mImageWidth;
      paramxuf.mRequestHeight = this.mImageWidth;
      paramxuf.mLoadingDrawable = aoop.TRANSPARENT;
      if (!(paramImageView instanceof URLDrawable)) {
        break label161;
      }
      paramImageView = ((URLDrawable)paramImageView).getURL().toString();
      if ((paramView != null) && (!paramView.equals(paramImageView))) {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramxuf));
      }
    }
    label161:
    label172:
    while (paramView.bio)
    {
      return;
      paramImageView.setImageResource(2130839576);
      parama.Kr.setVisibility(4);
      break;
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramxuf));
      return;
    }
    paramURLImageView.setImageDrawable(aoop.TRANSLUCENT);
    this.i.post(new AIOPhotoListAdapter.2(this, paramView));
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, xuf paramxuf, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    AIOFilePicData localAIOFilePicData = (AIOFilePicData)paramxuf.e;
    paramTextView = localAIOFilePicData.c(18);
    paramImageView = localAIOFilePicData.cH(18);
    if (paramTextView != null)
    {
      if (paramTextView == null) {
        break label163;
      }
      paramTextView = paramURLImageView.getDrawable();
      paramxuf = URLDrawable.URLDrawableOptions.obtain();
      paramxuf.mRequestWidth = this.mImageWidth;
      paramxuf.mRequestHeight = this.mImageWidth;
      paramxuf.mLoadingDrawable = aoop.TRANSLUCENT;
      if (!(paramTextView instanceof URLDrawable)) {
        break label152;
      }
      if (!paramImageView.equals(((URLDrawable)paramTextView).getURL().toString())) {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramxuf));
      }
    }
    label152:
    label163:
    do
    {
      return;
      paramxuf = localAIOFilePicData.c(16);
      paramImageView = localAIOFilePicData.cH(16);
      paramTextView = paramxuf;
      if (paramxuf != null) {
        break;
      }
      paramTextView = localAIOFilePicData.c(20);
      paramImageView = localAIOFilePicData.cH(20);
      break;
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramxuf));
      return;
      if (localAIOFilePicData.bio)
      {
        if (this.mFailedDrawable == null) {
          this.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
        }
        paramURLImageView.setImageDrawable(this.mFailedDrawable);
        return;
      }
      paramURLImageView.setImageDrawable(aoop.TRANSLUCENT);
    } while ((!agmx.alL()) && (this.mFrom == 2));
    this.i.post(new AIOPhotoListAdapter.3(this, localAIOFilePicData));
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, ImageView paramImageView, TextView paramTextView1, View paramView, TextView paramTextView2, URLImageView paramURLImageView)
  {
    paramView.setVisibility(0);
    paramImageView.setImageResource(2130839728);
    paramImageView.setVisibility(0);
    paramTextView1.setText(ShortVideoUtils.g(this.mContext, paramAIOFileVideoData.size));
    paramTextView1.setVisibility(0);
    float f1 = this.mContext.getResources().getDisplayMetrics().density;
    float f2 = this.mImageWidth * 2;
    paramTextView2.setText((String)TextUtils.ellipsize(paramAIOFileVideoData.fileName, paramTextView2.getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
    paramTextView2.setVisibility(0);
    if (paramAIOFileVideoData.c(0) != null)
    {
      paramAIOFileVideoData = paramAIOFileVideoData.cH(16);
      paramImageView = paramURLImageView.getDrawable();
      paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
      paramTextView1.mRequestWidth = this.mImageWidth;
      paramTextView1.mRequestHeight = this.mImageWidth;
      paramTextView1.mLoadingDrawable = aoop.TRANSLUCENT;
      if ((paramImageView instanceof URLDrawable))
      {
        if (!paramAIOFileVideoData.equals(((URLDrawable)paramImageView).getURL().toString())) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
        }
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
      return;
    }
    paramURLImageView.setImageDrawable(null);
    paramURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
  }
  
  private void a(AIOLightVideoData paramAIOLightVideoData, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setImageResource(2130839576);
    paramTextView.setText(ShortVideoUtils.stringForTime(paramAIOLightVideoData.bqB * 1000));
    paramTextView.setVisibility(0);
    paramImageView.setVisibility(0);
    if (paramAIOLightVideoData.c(0) != null)
    {
      paramAIOLightVideoData = paramAIOLightVideoData.cH(0);
      paramImageView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView = paramURLImageView.getDrawable();
      paramImageView.mRequestWidth = this.mImageWidth;
      paramImageView.mRequestHeight = this.mImageWidth;
      paramImageView.mLoadingDrawable = aoop.TRANSPARENT;
      if ((paramTextView instanceof URLDrawable))
      {
        paramTextView = ((URLDrawable)paramTextView).getURL().toString();
        if ((paramAIOLightVideoData != null) && (!paramAIOLightVideoData.equals(paramTextView))) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
        }
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
      return;
    }
    paramURLImageView.setImageDrawable(aoop.TRANSLUCENT);
    this.i.post(new AIOPhotoListAdapter.4(this, paramAIOLightVideoData));
  }
  
  private void a(xuf paramxuf, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (this.aTT) {
      switch (paramxuf.uG())
      {
      default: 
        if (paramImageView1 != null) {
          paramImageView1.setVisibility(4);
        }
        if (paramImageView2 != null) {
          paramImageView2.setVisibility(4);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramImageView1 != null) {
            paramImageView1.setVisibility(0);
          }
        } while (paramImageView2 == null);
        paramImageView2.setImageResource(2130846610);
        paramImageView2.setVisibility(0);
        return;
        if (paramImageView1 != null) {
          paramImageView1.setVisibility(4);
        }
      } while (paramImageView2 == null);
      paramImageView2.setImageResource(2130846607);
      paramImageView2.setVisibility(0);
      return;
      if (paramImageView1 != null) {
        paramImageView1.setVisibility(4);
      }
    } while (paramImageView2 == null);
    paramImageView2.setVisibility(4);
  }
  
  private void a(xuf paramxuf, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    paramxuf = (AIOImageData)paramxuf.e;
    paramTextView = paramxuf.c(1);
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str;
    if (paramTextView != null)
    {
      paramxuf = paramURLImageView.getDrawable();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.mImageWidth;
      localURLDrawableOptions.mRequestHeight = this.mImageWidth;
      localURLDrawableOptions.mLoadingDrawable = aoop.TRANSLUCENT;
      if ((paramxuf instanceof URLDrawable))
      {
        str = ((URLDrawable)paramxuf).getURL().toString();
        paramxuf = "";
      }
    }
    try
    {
      paramImageView = paramTextView.toURI().toURL().toString();
      paramxuf = paramImageView;
    }
    catch (MalformedURLException paramImageView)
    {
      label101:
      break label101;
    }
    if (!paramxuf.equals(str)) {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramTextView, localURLDrawableOptions));
    }
    return;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramTextView, localURLDrawableOptions));
    return;
    if (paramxuf.bio)
    {
      if (this.mFailedDrawable == null) {
        this.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838158);
      }
      paramURLImageView.setImageDrawable(this.mFailedDrawable);
      return;
    }
    paramURLImageView.setImageDrawable(aoop.TRANSLUCENT);
    this.i.post(new AIOPhotoListAdapter.1(this, paramxuf));
  }
  
  public static int fl(int paramInt)
  {
    if (paramInt != -1) {}
    switch (Integer.valueOf(ChatActivityUtils.cs(paramInt)).intValue())
    {
    case 1: 
    case 2: 
    default: 
      return -1;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public void Dy(int paramInt)
  {
    this.mFrom = paramInt;
  }
  
  public boolean Pl()
  {
    return (this.bjp) && (this.bvC != -1);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public boolean ay(boolean paramBoolean)
  {
    if (paramBoolean != this.bjo)
    {
      this.bjo = paramBoolean;
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public void expandAll()
  {
    if (this.a == null) {}
    while (!this.a.SK()) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = this.a.wu();
    int k = j;
    if (this.bjo)
    {
      int m = j % 4;
      k = j;
      if (m > 0) {
        k = j + (4 - m);
      }
      k += 1;
    }
    return k;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.bjo) {
      return this.a.j(paramInt);
    }
    if (paramInt < this.a.wu()) {
      return this.a.j(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return bT;
    }
    return xto.bS;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof xuf)) {}
    do
    {
      return 0;
      if (xto.bS.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (xto.bR.equals(localObject)) {
        return 3;
      }
    } while (!bT.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = getItemViewType(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = null;
      switch (j)
      {
      default: 
        localObject2 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    for (;;)
    {
      a(j, paramInt, (View)localObject1, paramView);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView.getTag();
      break;
      if (a.class.isInstance(localObject1))
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.viewType);
        }
        localObject2 = this.mInflater.inflate(2131561545, null);
        ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.mImageWidth, this.mImageWidth));
        paramView = new a();
        paramView.av = ((URLImageView)((View)localObject2).findViewById(2131373182));
        paramView.av.setAdjustViewBounds(false);
        paramView.tO = ((ImageView)((View)localObject2).findViewById(2131369477));
        paramView.mSelectedIconView = ((ImageView)((View)localObject2).findViewById(2131373187));
        paramView.tP = ((ImageView)((View)localObject2).findViewById(2131373113));
        paramView.Kr = ((TextView)((View)localObject2).findViewById(2131381726));
        paramView.mFileName = ((TextView)((View)localObject2).findViewById(2131367070));
        paramView.xd = ((View)localObject2).findViewById(2131363679);
        ((View)localObject2).setTag(paramView);
        paramView = (View)localObject1;
        localObject1 = localObject2;
        continue;
        if (xto.bS.equals(localObject1))
        {
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new View(this.mContext);
          ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.mImageWidth, this.mImageWidth));
          ((View)localObject2).setTag(xto.bS);
          paramView = (View)localObject1;
          localObject1 = localObject2;
          continue;
          if (b.class.isInstance(localObject1))
          {
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = this.mInflater.inflate(2131561537, null);
            paramView = new b();
            paramView.mTextView = ((TextView)((View)localObject2).findViewById(2131379567));
            paramView.mCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369742));
            localObject1 = new FullWidthFixedViewLayout(this.mContext);
            Object localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
              ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            }
            ((FrameLayout)localObject1).addView((View)localObject2);
            ((View)localObject1).setTag(paramView);
            continue;
            if (xto.bR.equals(localObject1))
            {
              localObject2 = paramView;
              paramView = (View)localObject1;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = new View(this.mContext);
              ((View)localObject2).setMinimumHeight(this.aVz);
              ((View)localObject2).setVisibility(4);
              ((View)localObject2).setTag(xto.bR);
              paramView = (View)localObject1;
              localObject1 = localObject2;
              continue;
              if (bT.equals(localObject1))
              {
                localObject2 = paramView;
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
              else
              {
                localObject2 = new FullWidthFixedViewLayout(this.mContext);
                paramView = this.mInflater.inflate(2131561536, null);
                localObject3 = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams)localObject3).gravity = 17;
                paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                ((FullWidthFixedViewLayout)localObject2).addView(paramView);
                ((View)localObject2).setTag(bT);
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt) {}
  
  public void r(int paramInt, View paramView)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!xuf.class.isInstance(localObject2))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof a))
    {
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (a)localObject1;
    xuf localxuf = (xuf)localObject2;
    URLImageView localURLImageView = ((a)localObject1).av;
    ImageView localImageView1 = ((a)localObject1).tO;
    ImageView localImageView2 = ((a)localObject1).mSelectedIconView;
    ImageView localImageView3 = ((a)localObject1).tP;
    TextView localTextView1 = ((a)localObject1).Kr;
    TextView localTextView2 = ((a)localObject1).mFileName;
    View localView = ((a)localObject1).xd;
    localView.setVisibility(8);
    localTextView2.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    localObject2 = null;
    if (AIOImageData.class.isInstance(localxuf.e))
    {
      a(localxuf, localImageView3, localTextView1, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.enableTalkBack) {
        localObject1 = acfp.m(2131702276);
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        int j = paramInt / 4;
        paramView.setContentDescription(acfp.m(2131702277) + (j + 1) + acfp.m(2131702278) + (paramInt % 4 + 1) + (String)localObject1);
      }
      a(localxuf, localImageView1, localImageView2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localxuf.e);
      return;
      if (AIOShortVideoData.class.isInstance(localxuf.e))
      {
        a(localView, localxuf, localImageView3, localTextView1, localURLImageView, (a)localObject1);
        localObject1 = localObject2;
        if (AppSetting.enableTalkBack) {
          localObject1 = acfp.m(2131702274);
        }
      }
      else
      {
        if (!AIOFilePicData.class.isInstance(localxuf.e)) {
          break label442;
        }
        a(localImageView3, localTextView1, localxuf, localURLImageView);
        localObject1 = localObject2;
        if (AppSetting.enableTalkBack) {
          localObject1 = acfp.m(2131702270);
        }
      }
    }
    label442:
    if (AIOFileVideoData.class.isInstance(localxuf.e))
    {
      a((AIOFileVideoData)localxuf.e, localImageView3, localTextView1, localView, localTextView2, localURLImageView);
      if (!AppSetting.enableTalkBack) {
        break label558;
      }
    }
    label558:
    for (localObject1 = acfp.m(2131702273);; localObject1 = null)
    {
      break;
      localObject1 = localObject2;
      if (!AIOLightVideoData.class.isInstance(localxuf.e)) {
        break;
      }
      localView.setVisibility(0);
      a((AIOLightVideoData)localxuf.e, localImageView3, localTextView1, localURLImageView);
      localObject1 = localObject2;
      if (!AppSetting.enableTalkBack) {
        break;
      }
      localObject1 = acfp.m(2131702271);
      break;
    }
  }
  
  public void setCurType(int paramInt)
  {
    this.mCurType = paramInt;
    this.bvC = fl(this.mCurType);
  }
  
  public void zB(boolean paramBoolean)
  {
    this.bjp = paramBoolean;
  }
  
  class FullWidthFixedViewLayout
    extends FrameLayout
  {
    public FullWidthFixedViewLayout(Context paramContext)
    {
      super();
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = AIOPhotoListAdapter.a(AIOPhotoListAdapter.this).getPaddingLeft() + getPaddingLeft();
      if (i != paramInt1) {
        offsetLeftAndRight(i - paramInt1);
      }
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(AIOPhotoListAdapter.a(AIOPhotoListAdapter.this).getMeasuredWidth() - AIOPhotoListAdapter.a(AIOPhotoListAdapter.this).getPaddingLeft() - AIOPhotoListAdapter.a(AIOPhotoListAdapter.this).getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
    }
  }
  
  public class a
  {
    public TextView Kr;
    public URLImageView av;
    public TextView mFileName;
    public ImageView mSelectedIconView;
    public ImageView tO;
    public ImageView tP;
    public View xd;
    
    public a() {}
  }
  
  public class b
  {
    CheckBox mCheckBox;
    TextView mTextView;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */