package com.tencent.mobileqq.activity;

import aajx;
import acbn;
import acej;
import acfp;
import acle;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqcw;
import aqdf;
import aqdf.a;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.a;
import com.tencent.widget.RangeButtonView.e;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import uwv;
import uww;
import uwx;
import uwy;
import wkj;
import xov;
import xov.a;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, RangeButtonView.a
{
  aqdf jdField_a_of_type_Aqdf;
  public a a;
  b jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$b;
  c jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$c;
  e jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$e;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  boolean aVX = false;
  boolean aVY = false;
  ViewGroup cS;
  ViewGroup containerView;
  SessionInfo d;
  ViewGroup e;
  ViewPager i;
  ListView j;
  ListView k;
  private Dialog mDialog;
  public boolean needRefresh = false;
  private boolean needReset;
  private float oX = 16.0F;
  ArrayList<View> ph = new ArrayList();
  ArrayList<d> pi = new ArrayList();
  List<ChatMessage> qH;
  private MqqHandler uiHandler = new uwy(this);
  
  private void bNJ()
  {
    this.containerView = ((ViewGroup)findViewById(2131379809));
    this.cS = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131299627));
    eF(this.cS);
    this.containerView.addView(this.cS, 0, localLayoutParams);
  }
  
  private void bNK()
  {
    this.containerView.removeViewAt(0);
    bNJ();
  }
  
  private void bNL()
  {
    if (this.qH == null)
    {
      this.qH = new ArrayList();
      MessageForText localMessageForText = new MessageForText();
      localMessageForText.frienduin = "3405065205";
      localMessageForText.senderuin = "3405065205";
      localMessageForText.issend = 1000;
      Object localObject1 = acfp.m(2131706408);
      localMessageForText.msg = ((String)localObject1);
      localMessageForText.sb = ((CharSequence)localObject1);
      localObject1 = new MessageForText();
      Object localObject2 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject1).frienduin = ((String)localObject2);
      ((MessageForText)localObject1).selfuin = ((String)localObject2);
      ((MessageForText)localObject1).senderuin = ((String)localObject2);
      ((MessageForText)localObject1).issend = 1;
      localObject2 = acfp.m(2131706398);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      ((MessageForText)localObject1).vipBubbleID = ((acle)this.app.getBusinessHandler(13)).AS();
      localObject2 = new MessageForText();
      ((MessageForText)localObject2).frienduin = "3405065205";
      ((MessageForText)localObject2).senderuin = "3405065205";
      ((MessageForText)localObject2).issend = 1000;
      String str = acfp.m(2131706401);
      ((MessageForText)localObject2).msg = str;
      ((MessageForText)localObject2).sb = str;
      this.qH.add(localMessageForText);
      this.qH.add(localObject1);
      this.qH.add(localObject2);
      this.d = new SessionInfo();
      this.d.cZ = 0;
      this.d.cN = ChatTextSizeSettingActivity.ag(this);
      this.d.a = new wkj();
      if (wkj.a(this, this.app.getCurrentAccountUin(), this.d.aTl, true, 7, this.d.a)) {
        this.j.setBackgroundDrawable(this.d.a.img);
      }
    }
  }
  
  private void bNM()
  {
    d locald1 = new d(0, acfp.m(2131701784), acfp.m(2131706402), "3:28PM", "3405065205", 0);
    d locald2 = new d(2130841035, acfp.m(2131691017), acfp.m(2131706397), "3:28PM", acbn.bku, 7000);
    d locald3 = new d(2130841037, acfp.m(2131689481), acfp.m(2131706403), "3:28PM", acbn.bkz, 5000);
    d locald4 = new d(2130845074, acfp.m(2131696154), acfp.m(2131706404), "3:28PM", acbn.bkw, 6000);
    d locald5 = new d(0, acfp.m(2131706409), acfp.m(2131706400), "3:28PM", "2632129500", 0);
    this.pi.add(locald1);
    this.pi.add(locald2);
    this.pi.add(locald3);
    this.pi.add(locald4);
    this.pi.add(locald5);
  }
  
  private void bNO()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup2 = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup2.getChildAt(0);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localView != null)
      {
        localViewGroup1 = localViewGroup2;
        if ((localView instanceof ViewGroup)) {
          localViewGroup1 = (ViewGroup)localView;
        }
      }
      if ((localViewGroup1 instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
      }
    }
  }
  
  private ListView d()
  {
    ListView localListView = new ListView(this);
    ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localListView.setDivider(null);
    localListView.setDividerHeight(0);
    return localListView;
  }
  
  private void eF(View paramView)
  {
    ((TextView)paramView.findViewById(2131369579)).setOnClickListener(new uwv(this));
    ((TextView)paramView.findViewById(2131369627)).setText(acfp.m(2131706399));
    ((TextView)paramView.findViewById(2131369579)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void initViews()
  {
    bNJ();
    this.i = ((ViewPager)findViewById(2131367447));
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$b = new b();
    this.i.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$b);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131367436));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.i);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.j = d();
    bNL();
    this.ph.add(this.j);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$a = new a();
    this.j.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$a);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$c = new c(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$a, this, this.d, null);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$c.a(this.jdField_a_of_type_Aqdf);
    bNM();
    this.k = d();
    bMG();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$e = new e(this, this.app, this.k);
    this.ph.add(this.k);
    this.k.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$e);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$b.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131367439));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.e(acfp.m(2131706407), TypedValue.applyDimension(1, 13.92F, acej.k)));
    localArrayList.add(new RangeButtonView.e("", TypedValue.applyDimension(1, 15.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e(acfp.m(2131706406), TypedValue.applyDimension(1, 16.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e("", TypedValue.applyDimension(1, 17.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e(acfp.m(2131706405), TypedValue.applyDimension(1, 18.0F, acej.k)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(vt());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131692121));
    localArrayList.add(getString(2131692122));
    localArrayList.add(getString(2131692123));
    localArrayList.add(getString(2131692124));
    localArrayList.add(getString(2131692125));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private int vt()
  {
    int n = 2;
    this.oX = acej.aV();
    int m;
    if (this.oX == 13.92F) {
      m = 0;
    }
    do
    {
      do
      {
        return m;
        if (this.oX == 15.0F) {
          return 1;
        }
        m = n;
      } while (this.oX == 16.0F);
      if (this.oX == 17.0F) {
        return 3;
      }
      m = n;
    } while (this.oX != 18.0F);
    return 4;
  }
  
  void bMG()
  {
    if (this.k == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.k.setContentBackground(2130838901);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.k.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.k.setContentBackground(2130838901);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.k.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void bNN()
  {
    if ((this.needReset) && (this.aVX) && (this.aVY))
    {
      this.aVY = false;
      this.aVX = false;
      this.needReset = false;
      acej.dK(this);
    }
  }
  
  public void doOnBackPressed()
  {
    showDialog();
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561364);
    this.e = ((ViewGroup)findViewById(2131377546));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.e.setFitsSystemWindows(true);
      this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.app.setHandler(FontSettingActivity.class, this.uiHandler);
    initViews();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$e.destroy();
    this.app.removeHandler(FontSettingActivity.class);
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bNO();
  }
  
  public void dy(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.oX, "", "", "");
      if (!acej.a(this, this.oX, false)) {
        bool = true;
      }
      this.needReset = bool;
      this.d.cN = ChatTextSizeSettingActivity.ag(this);
      this.k.removeAllViewsInLayout();
      this.j.removeAllViewsInLayout();
      bNK();
      return;
      this.oX = 13.92F;
      continue;
      this.oX = 15.0F;
      continue;
      this.oX = 16.0F;
      continue;
      this.oX = 17.0F;
      continue;
      this.oX = 18.0F;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void showDialog()
  {
    if (this.oX == acej.aV()) {
      finish();
    }
    do
    {
      return;
      this.mDialog = aqcw.a(this, 2131693958, 2131693956, 2131693955, 2131693957, new uww(this), new uwx(this));
    } while (isFinishing());
    this.mDialog.show();
  }
  
  public class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return FontSettingActivity.this.qH.size();
    }
    
    public Object getItem(int paramInt)
    {
      return FontSettingActivity.this.qH.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = FontSettingActivity.this.a.a(paramInt, getCount(), (ChatMessage)FontSettingActivity.this.qH.get(paramInt), paramView, paramViewGroup, null);
      xov.a locala = (xov.a)localView.getTag();
      locala.mText.setOnClickListener(null);
      if ((locala.mText instanceof AnimationTextView)) {
        ((AnimationTextView)locala.mText).onDoubleClick = null;
      }
      if ((FontSettingActivity.a(FontSettingActivity.this)) && (paramInt == FontSettingActivity.this.qH.size() - 1))
      {
        FontSettingActivity.this.aVX = true;
        FontSettingActivity.this.bNN();
      }
      if ((FontSettingActivity.this.needRefresh) && (paramInt == FontSettingActivity.this.qH.size() - 1))
      {
        FontSettingActivity.this.needRefresh = false;
        FontSettingActivity.a(FontSettingActivity.this).postDelayed(new FontSettingActivity.AioListAdapter.1(this), 100L);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  class b
    extends PagerAdapter
  {
    b() {}
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)FontSettingActivity.this.ph.get(paramInt));
    }
    
    public int getCount()
    {
      return FontSettingActivity.this.ph.size();
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      ((ViewPager)paramView).addView((View)FontSettingActivity.this.ph.get(paramInt), 0);
      return FontSettingActivity.this.ph.get(paramInt);
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
  
  class c
    extends xov
  {
    public c(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
    {
      super(paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    }
    
    public void a(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage) {}
    
    public void ej(View paramView) {}
  }
  
  class d
  {
    public int aCw;
    public String subTitle;
    public String time;
    public String title;
    public String uin;
    public int uinType;
    
    public d(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
    {
      this.aCw = paramInt1;
      this.title = paramString1;
      this.subTitle = paramString2;
      this.time = paramString3;
      this.uin = paramString4;
      this.uinType = paramInt2;
    }
  }
  
  class e
    extends BaseAdapter
    implements aqdf.a
  {
    private aajx b = new aajx(paramQQAppInterface, this);
    private LayoutInflater inflater = FontSettingActivity.this.getLayoutInflater();
    
    public e(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView) {}
    
    public void destroy()
    {
      this.b.onDestory();
    }
    
    public int getCount()
    {
      return FontSettingActivity.this.pi.size();
    }
    
    public Object getItem(int paramInt)
    {
      return FontSettingActivity.this.pi.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = this.inflater.inflate(2131562954, paramViewGroup, false);
      FontSettingActivity.d locald = (FontSettingActivity.d)FontSettingActivity.this.pi.get(paramInt);
      ImageView localImageView = (ImageView)paramView.findViewById(2131368698);
      localImageView.setImageDrawable(this.b.a(locald.uinType, locald.uin));
      ((TextView)paramView.findViewById(16908308)).setText(locald.title);
      ((TextView)paramView.findViewById(16908309)).setText(locald.subTitle);
      ((TextView)paramView.findViewById(2131370129)).setText(locald.time);
      a locala = new a();
      locala.uin = locald.uin;
      locala.pV = localImageView;
      locala.a = locald;
      paramView.setTag(locala);
      if ((FontSettingActivity.a(FontSettingActivity.this)) && (paramInt == FontSettingActivity.this.pi.size() - 1))
      {
        FontSettingActivity.this.aVY = true;
        FontSettingActivity.this.bNN();
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      Object localObject1 = null;
      paramInt2 = FontSettingActivity.this.k.getChildCount();
      Object localObject2;
      if (paramBitmap != null)
      {
        paramInt1 = 0;
        if (paramInt1 >= paramInt2) {
          break label105;
        }
        localObject2 = FontSettingActivity.this.k.getChildAt(paramInt1).getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof a))) {
          break label98;
        }
        localObject2 = (a)localObject2;
        localObject1 = localObject2;
        if (!((a)localObject2).uin.equals(paramString)) {
          break label98;
        }
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          ((a)localObject2).pV.setImageBitmap(paramBitmap);
          notifyDataSetChanged();
        }
        return;
        label98:
        paramInt1 += 1;
        break;
        label105:
        localObject2 = localObject1;
      }
    }
    
    class a
    {
      FontSettingActivity.d a;
      ImageView pV;
      String uin;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */