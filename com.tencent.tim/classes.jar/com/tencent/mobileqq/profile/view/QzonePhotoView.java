package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import acfp;
import albb;
import alcn;
import alcs;
import alhf;
import alhg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import aqep;
import aqft;
import aqiw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterViewPagerAdapter;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.XListView.b;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QzonePhotoView
  extends LinearLayout
  implements Handler.Callback, XListView.b
{
  private alcn a;
  public QQAppInterface app;
  private int bmw;
  private List<b> cE;
  private boolean cwG;
  public boolean cwQ;
  private int dtf;
  private int dtv;
  private ImageView hL;
  CoverCacheData j;
  private View jo;
  private Activity mActivity;
  private int[] mB = new int[2];
  View mContentView;
  private float mDensity;
  private Handler mHandler;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private View.OnClickListener mOnClickListener = new alhg(this);
  private int[] mParentLocation = new int[2];
  private int mScreenWidth;
  private int mTouchSlop;
  private String mUin;
  private int photoWidth;
  
  public QzonePhotoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzonePhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void NK(boolean paramBoolean)
  {
    String str = "https://ti.qq.com/photowall/index.html?_wv=1027";
    if (!paramBoolean) {
      str = "https://ti.qq.com/photowall/index.html?_wv=1027" + "&uin=" + this.mUin;
    }
    Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", str);
    if (!paramBoolean)
    {
      this.mActivity.startActivity(localIntent);
      return;
    }
    this.mActivity.startActivityForResult(localIntent, 1022);
  }
  
  private List<b> e(String paramString, List<Map<Integer, String>> paramList)
  {
    int k = 0;
    LinkedList localLinkedList = new LinkedList();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update").append("|type = ").append(paramString).append("|vecUrls = ").append(paramList);
      QLog.i("ProfileCard.QzonePhotoView", 2, localStringBuilder.toString());
    }
    if (this.j == null) {
      this.j = new CoverCacheData();
    }
    this.j.type = paramString;
    this.j.EY = ((ArrayList)paramList);
    this.j.uin = Long.parseLong(this.mUin);
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    while ((k < i) && (k < 16))
    {
      paramString = (Map)paramList.get(k);
      if (paramString != null)
      {
        paramString = new b(k, 100, paramString);
        paramString.cYf = localLinkedList.size();
        localLinkedList.add(paramString);
      }
      k += 1;
      continue;
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverData photoInfo size=" + localLinkedList.size());
    }
    return localLinkedList;
  }
  
  public void a(BaseActivity paramBaseActivity, alcn paramalcn)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "initView");
    }
    this.app = paramBaseActivity.app;
    this.mActivity = paramBaseActivity;
    this.a = paramalcn;
    this.mHandler = new Handler(this);
    this.dtf = 0;
    this.mUin = paramalcn.e.uin;
    this.mContentView = LayoutInflater.from(this.app.getApplication()).inflate(2131562229, this, true);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.mScreenWidth = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i = getResources().getDimensionPixelSize(2131298979);
    this.dtv = getResources().getDimensionPixelSize(2131298978);
    this.photoWidth = ((this.mScreenWidth - i * 2 - this.dtv * 3) / 4);
    if (paramalcn.e.pa == 0) {
      bool = true;
    }
    this.cwG = bool;
    ThreadManager.post(new QzonePhotoView.1(this), 8, null, true);
    paramalcn = Message.obtain();
    paramalcn.what = 100;
    this.mHandler.sendMessage(paramalcn);
    this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramBaseActivity));
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover|isSuc = " + paramBoolean + ",uin=" + paramString + ",mUin=" + this.mUin);
    }
    if (!aqft.equalsWithNullCheck(paramString, this.mUin)) {}
    label193:
    do
    {
      return;
      if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
      {
        paramString = new ArrayList();
        int i = 0;
        while (i < parammobile_sub_get_photo_wall_rsp.vecUrls.size())
        {
          paramString.add(((PhotoWall)parammobile_sub_get_photo_wall_rsp.vecUrls.get(i)).photoUrls);
          i += 1;
        }
        List localList = e("", paramString);
        i = 0;
        parammobile_sub_get_photo_wall_rsp = null;
        paramString = null;
        for (;;)
        {
          paramBoolean = bool;
          if (i < 16)
          {
            if ((this.cE == null) || (this.cE.size() <= i)) {
              break label287;
            }
            paramString = (b)this.cE.get(i);
            if ((localList == null) || (localList.size() <= i)) {
              break label292;
            }
          }
          for (parammobile_sub_get_photo_wall_rsp = (b)localList.get(i);; parammobile_sub_get_photo_wall_rsp = null)
          {
            if (aqft.equalsWithNullCheck(paramString, parammobile_sub_get_photo_wall_rsp)) {
              break label297;
            }
            paramBoolean = true;
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCard.QzonePhotoView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
            }
            if ((!paramBoolean) && ((paramString != null) || (parammobile_sub_get_photo_wall_rsp != null))) {
              break;
            }
            lO(localList);
            return;
            paramString = null;
            break label193;
          }
          i += 1;
        }
      }
    } while ((!aqiw.isWifiEnabled(BaseApplication.getContext())) || (this.dtf >= 3));
    label287:
    label292:
    label297:
    paramString = Message.obtain();
    paramString.what = 100;
    this.mHandler.sendMessage(paramString);
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    ViewPager localViewPager = (ViewPager)this.mContentView.findViewById(2131373114);
    paramView.getLocationInWindow(this.mParentLocation);
    localViewPager.getLocationInWindow(this.mB);
    float f1 = paramMotionEvent.getRawY();
    int i;
    label136:
    boolean bool1;
    if ((localViewPager.getVisibility() == 0) && (f1 >= this.mB[1]) && (f1 < this.mB[1] + localViewPager.getHeight()))
    {
      i = 1;
      paramMotionEvent.offsetLocation(0.0F, this.mParentLocation[1] - this.mB[1]);
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool1 = false;
      }
    }
    label139:
    label585:
    for (;;)
    {
      for (;;)
      {
        if (bool1) {}
        try
        {
          bool2 = localViewPager.dispatchTouchEvent(paramMotionEvent);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.QzonePhotoView", 2, "photo pager dispatchTouchvent ret = " + bool2);
          }
          i = paramMotionEvent.getAction();
          if ((i != 0) && (bool1) && (bool2)) {}
          for (bool1 = bool3;; bool1 = false)
          {
            bool2 = bool1;
            return bool2;
            i = 0;
            break;
            if (i == 0) {
              break label136;
            }
            this.cwQ = true;
            this.bmw = 0;
            this.mInitialMotionX = paramMotionEvent.getX();
            this.mInitialMotionY = paramMotionEvent.getY();
            if (!QLog.isColorLevel()) {
              break label585;
            }
            QLog.d("ProfileCard.QzonePhotoView", 2, "Action down mInitialMotionX = " + this.mInitialMotionX);
            bool1 = true;
            break label139;
            if (i != 0)
            {
              if ((this.cwQ) && (this.bmw == 0))
              {
                f1 = Math.abs(paramMotionEvent.getX() - this.mInitialMotionX);
                f2 = Math.abs(paramMotionEvent.getY() - this.mInitialMotionY);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move curX = " + paramMotionEvent.getX() + " xDiff = " + f1 + " mTouchSlop = " + this.mTouchSlop);
                }
                if ((f1 > this.mTouchSlop) && (f1 * 0.5F > f2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.QzonePhotoView", 2, "Action move beginDragged ");
                  }
                  this.bmw = 1;
                }
              }
              while (-1 != this.bmw) {
                for (;;)
                {
                  float f2;
                  bool4 = this.cwQ;
                  bool1 = bool4;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ProfileCard.QzonePhotoView", 2, "Action move touchHappened =  " + bool4);
                  bool1 = bool4;
                  break;
                  if (f2 > this.mTouchSlop) {
                    this.cwQ = false;
                  }
                }
              }
              return false;
            }
            if (1 != this.bmw) {
              break label136;
            }
            this.bmw = -1;
            bool1 = false;
            break label139;
            boolean bool4 = this.cwQ;
            bool1 = bool4;
            if (!this.cwQ) {
              break label139;
            }
            this.cwQ = false;
            this.bmw = 0;
            bool1 = bool4;
            break label139;
          }
          bool1 = true;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return false;
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.hL.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void f(CoverCacheData paramCoverCacheData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "updateCoverCacheData data = " + paramCoverCacheData);
    }
    if (paramCoverCacheData != null) {
      lO(e(paramCoverCacheData.type, paramCoverCacheData.EY));
    }
    if ((this.j != null) && (aqft.equalsWithNullCheck("PhotoWallCover", this.j.type)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "need get req cover info");
      }
      paramCoverCacheData = Message.obtain();
      paramCoverCacheData.what = 100;
      this.mHandler.sendMessage(paramCoverCacheData);
    }
  }
  
  public CoverCacheData getCoverCacheData()
  {
    return this.j;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "handleMessage() MSG_REQ_ALBUM");
      }
      paramMessage = (CardHandler)this.app.getBusinessHandler(2);
      if (paramMessage != null)
      {
        paramMessage.dq(this.mUin, 2);
        this.dtf += 1;
      }
      this.mHandler.removeMessages(100);
      continue;
      if ((paramMessage.obj instanceof LinkedList)) {
        lO((List)paramMessage.obj);
      }
      this.mHandler.sendEmptyMessage(201);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.QzonePhotoView", 2, "handleMessage MSG_LOAD_PHOTO_WALL");
      }
      ((CardHandler)this.app.getBusinessHandler(2)).eD(this.mUin, "");
      this.mHandler.removeMessages(201);
    }
  }
  
  public void lO(List<b> paramList)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        if ((QLog.isColorLevel()) && (paramList != null)) {
          QLog.i("ProfileCard.QzonePhotoView", 2, "updatePhotoView photoInfo size=" + paramList.size());
        }
        this.cE = paramList;
        if (paramList == null) {
          break label558;
        }
        i = paramList.size();
        this.hL = ((ImageView)this.mContentView.findViewById(2131373655));
        this.jo = this.mContentView.findViewById(2131375573);
        this.jo.setTag(new albb(25, null));
        this.jo.setOnClickListener(this.mOnClickListener);
        localObject2 = aqep.b(this.app, -1L);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = aqep.u(getContext(), 188);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((int)Math.ceil(((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight * 1.0D / 376.0D * 640.0D));
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(getResources().getColor(2131165571));
          localObject2 = URLDrawable.getDrawable(new File((String)localObject2, "qvip_profile_photo_black_addimage_tips.png"), (URLDrawable.URLDrawableOptions)localObject1);
          ((Drawable)localObject2).setBounds(0, 0, ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight);
          this.hL.setImageDrawable((Drawable)localObject2);
        }
        this.hL.setTag(new albb(25, null));
        this.hL.setOnClickListener(this.mOnClickListener);
        localObject1 = (ViewPager)this.mContentView.findViewById(2131373114);
        localObject2 = (CirclePageIndicator)this.mContentView.findViewById(2131372828);
        if (i > 0)
        {
          a locala = new a();
          locala.bF(paramList);
          locala.jh(this.photoWidth, this.photoWidth);
          paramList = new AdapterViewPagerAdapter(getContext(), locala, 8);
          paramList.a(new alhf(this));
          ViewGroup.LayoutParams localLayoutParams = ((ViewPager)localObject1).getLayoutParams();
          localLayoutParams.width = this.mScreenWidth;
          if (locala.getCount() > 4)
          {
            i = this.photoWidth * 2 + this.dtv;
            localLayoutParams.height = i;
            ((ViewPager)localObject1).setLayoutParams(localLayoutParams);
            ((ViewPager)localObject1).setAdapter(paramList);
            i = paramList.getCount();
            ((CirclePageIndicator)localObject2).setViewPager((ViewPager)localObject1);
            this.hL.setVisibility(8);
            this.jo.setVisibility(8);
            ((ViewPager)localObject1).setVisibility(0);
            if (i > 1)
            {
              ((CirclePageIndicator)localObject2).setVisibility(0);
              setVisibility(0);
            }
          }
          else
          {
            i = this.photoWidth + this.dtv;
            continue;
          }
          ((CirclePageIndicator)localObject2).setVisibility(8);
          continue;
        }
        if (!this.cwG) {
          break label533;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      this.hL.setVisibility(0);
      this.jo.setVisibility(0);
      ((ViewPager)localObject1).setVisibility(8);
      ((CirclePageIndicator)localObject2).setVisibility(8);
      setVisibility(0);
      return;
      label533:
      this.hL.setVisibility(8);
      this.jo.setVisibility(8);
      setVisibility(8);
      return;
      label558:
      int i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  class a
    extends BaseAdapter
  {
    List<QzonePhotoView.b> mList;
    int photoHeight;
    int photoWidth;
    
    a() {}
    
    public void bF(List<QzonePhotoView.b> paramList)
    {
      this.mList = paramList;
      int i = paramList.size();
      if (i < 16) {
        if (QzonePhotoView.a(QzonePhotoView.this)) {
          this.mList.add(new QzonePhotoView.b(paramList.size(), 101, null));
        }
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        paramList = (QzonePhotoView.b)this.mList.get(i - 1);
        paramList.type = 102;
        this.mList.set(i - 1, paramList);
      }
    }
    
    public int getCount()
    {
      if (this.mList != null) {
        return this.mList.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.mList != null) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = (QzonePhotoView.b)this.mList.get(paramInt);
      a locala;
      String str2;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      String str1;
      if (paramView == null)
      {
        locala = new a();
        paramView = (RelativeLayout)LayoutInflater.from(QzonePhotoView.this.getContext()).inflate(2131562230, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.photoWidth, this.photoWidth));
        locala.e = ((URLImageView)paramView.findViewById(2131375576));
        locala.e.setTag(new albb(25, Integer.valueOf(paramInt)));
        str2 = aqep.b(QzonePhotoView.this.app, -1L);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = this.photoHeight;
        localURLDrawableOptions.mRequestWidth = this.photoWidth;
        str1 = ((QzonePhotoView.b)localObject).getThumbUrl(this.photoWidth);
        if (((QzonePhotoView.b)localObject).type == 100)
        {
          if (!TextUtils.isEmpty(str1))
          {
            locala.e.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
            locala.e.setContentDescription(acfp.m(2131713253) + (paramInt + 1));
          }
          locala.e.setOnClickListener(QzonePhotoView.a(QzonePhotoView.this));
          paramView.setTag(locala);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (((QzonePhotoView.b)localObject).type == 101)
        {
          alcs.a(locala.e, "src", QzonePhotoView.a(QzonePhotoView.this).b, "photoAddSrc");
          locala.e.setContentDescription(acfp.m(2131713249));
          break;
        }
        if (((QzonePhotoView.b)localObject).type != 102) {
          break;
        }
        if (!TextUtils.isEmpty(str2))
        {
          localObject = new File(str2, "qvip_profile_photo_more.png");
          locala.e.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
        }
        if (!TextUtils.isEmpty(str1)) {
          locala.e.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
        }
        locala.e.setContentDescription(acfp.m(2131713256));
        break;
        localObject = (a)paramView.getTag();
      }
    }
    
    public void jh(int paramInt1, int paramInt2)
    {
      this.photoWidth = paramInt1;
      this.photoHeight = paramInt2;
    }
    
    public class a
    {
      URLImageView e;
      
      public a() {}
    }
  }
  
  public static class b
  {
    public int cYf;
    public int coy = 0;
    public int dtw;
    public String key;
    public Map<Integer, String> mw;
    public int type;
    
    public b(int paramInt1, int paramInt2, Map<Integer, String> paramMap)
    {
      this.mw = paramMap;
      this.key = null;
      this.type = paramInt2;
      if (this.mw != null)
      {
        paramMap = new StringBuilder();
        paramMap.append(paramInt1);
        paramInt1 = 0;
        while (paramInt1 <= 4)
        {
          String str = (String)this.mw.get(Integer.valueOf(paramInt1));
          if (str != null) {
            paramMap.append(str);
          }
          paramInt1 += 1;
        }
        this.key = paramMap.toString();
        if (!TextUtils.isEmpty(this.key)) {
          this.key = MD5.toMD5(this.key);
        }
      }
    }
    
    private String getOther(int paramInt)
    {
      Object localObject = null;
      int i = 1;
      while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
      {
        localObject = (String)this.mw.get(Integer.valueOf((paramInt + i) % 5));
        i += 1;
      }
      return localObject;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if ((paramObject instanceof b)) {
        bool = aqft.equalsWithNullCheck(((b)paramObject).key, this.key);
      }
      return bool;
    }
    
    public String getOriginalUrl()
    {
      Object localObject = null;
      if (this.mw != null)
      {
        String str = (String)this.mw.get(Integer.valueOf(1));
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = getOther(1);
        }
      }
      return localObject;
    }
    
    public String getThumbUrl(int paramInt)
    {
      Object localObject = null;
      if (this.mw != null) {
        if (paramInt > 100) {
          break label51;
        }
      }
      label51:
      for (paramInt = 3;; paramInt = 2)
      {
        String str = (String)this.mw.get(Integer.valueOf(paramInt));
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = getOther(paramInt);
        }
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView
 * JD-Core Version:    0.7.0.1
 */