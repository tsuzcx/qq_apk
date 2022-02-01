package com.tencent.mobileqq.activity.emogroupstore;

import acfp;
import aclh;
import afhj;
import afhl;
import afhu;
import afhv;
import afnu;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import aqfo;
import aqgv;
import aqrc;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import wja;
import xsk;
import xtm;
import xuf;
import zcs;
import zct;
import zcu;
import zcv;
import zcw;
import zcx;
import zcy;
import zcy.a;
import zdb;
import zdc;

public class EmoticonGroupStoreFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private TranslateAnimation A;
  private TranslateAnimation B;
  private StringBuilder I = new StringBuilder("    ");
  private TextView Mv;
  private TextView Mw;
  private TextView Mx;
  private afhl jdField_a_of_type_Afhl;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private zcy jdField_a_of_type_Zcy;
  private zdc jdField_a_of_type_Zdc;
  private volatile boolean bqK;
  private volatile boolean bqL;
  private Button et;
  private Button eu;
  private Button ev;
  private Button ew;
  private Button ex;
  private Button ey;
  private View.OnClickListener jdField_ez_of_type_AndroidViewView$OnClickListener = new zct(this);
  private Button jdField_ez_of_type_AndroidWidgetButton;
  aclh f = new zcs(this);
  private Map<String, List<EmoticonFromGroupEntity>> ih;
  private Map<String, zcy.a> ii;
  private RelativeLayout iv;
  private ViewPager jdField_j_of_type_AndroidSupportV4ViewViewPager;
  private SpannableString jdField_j_of_type_AndroidTextSpannableString;
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private View mEmptyView;
  private ListView o;
  public List<EmoticonFromGroupEntity> tQ = new ArrayList();
  private List<EmoticonFromGroupEntity> tR = new CopyOnWriteArrayList();
  private List<EmoticonFromGroupEntity> tS = new CopyOnWriteArrayList();
  private List<zcy.a> tT;
  private List<String> tU = new ArrayList();
  private List<String> tV = new ArrayList();
  private AlphaAnimation u;
  private AlphaAnimation v;
  private View vP;
  private RecyclerView x;
  private View xu;
  private View yA;
  private View yB;
  private View yw;
  private View yx;
  private View yy;
  private View yz;
  
  private void bcK()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.8(this));
  }
  
  private void cog()
  {
    this.jdField_a_of_type_Zdc = new zdc(this.mApp, this, this.jdField_a_of_type_Afhl.CY(), this.yw, this.jdField_j_of_type_AndroidSupportV4ViewViewPager, this.eu);
    this.x.setAdapter(this.jdField_a_of_type_Zdc);
    this.x.setOnScrollListener(new zcw(this));
  }
  
  private void coh()
  {
    ThreadManager.post(new EmoticonGroupStoreFragment.5(this), 5, null, true);
  }
  
  private void coi()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.6(this));
  }
  
  private void coj()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.7(this));
  }
  
  private void cok()
  {
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
    Object localObject1 = this.tR.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonFromGroupEntity)((Iterator)localObject1).next();
      if (localConcurrentHashMap1.containsKey(((EmoticonFromGroupEntity)localObject2).troopUin))
      {
        ((List)localConcurrentHashMap1.get(((EmoticonFromGroupEntity)localObject2).troopUin)).add(localObject2);
      }
      else
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        localConcurrentHashMap1.put(((EmoticonFromGroupEntity)localObject2).troopUin, localObject3);
      }
    }
    Object localObject3 = localConcurrentHashMap1.entrySet().iterator();
    Map.Entry localEntry;
    zcy.a locala;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity;
    if (((Iterator)localObject3).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject3).next();
      locala = new zcy.a();
      localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      if (1 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.mApp.getFaceBitmap(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = aqgv.a(this.mApp, localEmoticonFromGroupEntity.troopUin, true);
      }
    }
    for (;;)
    {
      locala.uin = localEmoticonFromGroupEntity.troopUin;
      locala.bG = ((Bitmap)localObject2);
      locala.isChecked = false;
      locala.name = ((String)localObject1);
      locala.num = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(locala);
      localConcurrentHashMap2.put(locala.uin, locala);
      break;
      if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.mApp.getFaceBitmap(101, localEmoticonFromGroupEntity.troopUin, (byte)1, false, (byte)1, 0);
        localObject1 = aqgv.b(this.mApp, this.mActivity, localEmoticonFromGroupEntity.troopUin);
        continue;
        this.ih = localConcurrentHashMap1;
        this.tT = localCopyOnWriteArrayList;
        this.ii = localConcurrentHashMap2;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.11(this));
          return;
        }
        this.jdField_a_of_type_Zcy.setData(this.tT);
        this.jdField_a_of_type_Zcy.notifyDataSetChanged();
        this.Mx.setText(acfp.m(2131705816) + this.tR.size() + acfp.m(2131705828));
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
    }
  }
  
  private void col()
  {
    if ((this.yA != null) && (this.titleRoot == this.yA.getParent()) && (this.titleRoot == this.yA.getParent()))
    {
      this.yz.startAnimation(this.v);
      this.yA.startAnimation(this.B);
    }
  }
  
  private void com()
  {
    Iterator localIterator = this.tT.iterator();
    while (localIterator.hasNext()) {
      ((zcy.a)localIterator.next()).isChecked = false;
    }
    if (!this.tU.isEmpty()) {
      this.tU.clear();
    }
  }
  
  private void con()
  {
    this.jdField_ez_of_type_AndroidWidgetButton.setBackgroundResource(2130840623);
    this.jdField_ez_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void coo()
  {
    this.jdField_ez_of_type_AndroidWidgetButton.setBackgroundResource(2130840624);
    this.jdField_ez_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void hb(List<EmoticonFromGroupEntity> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (localEmoticonFromGroupEntity != null) {
        if (localEmoticonFromGroupEntity.msg == null)
        {
          MessageForPic localMessageForPic = this.jdField_a_of_type_Afhl.a(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.tR.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.jdField_a_of_type_Afhl.h(localEmoticonFromGroupEntity);
            this.jdField_a_of_type_Afhl.g(localEmoticonFromGroupEntity);
          }
        }
        else
        {
          this.tR.add(localEmoticonFromGroupEntity);
        }
      }
    }
  }
  
  private void hc(List<EmoticonFromGroupEntity> paramList)
  {
    Object localObject1 = (afhu)this.mApp.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getEmoticonDataList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((afhu)localObject1).ez();
    localObject1 = new ArrayList();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject2).get(i)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject2).get(i)).RomaingType))) {
          ((List)localObject1).add(((List)localObject2).get(i));
        }
        i += 1;
      }
    }
    localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (this.jdField_a_of_type_Afhl.g((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.tS.addAll((Collection)localObject2);
  }
  
  private void hd(List<EmoticonFromGroupEntity> paramList)
  {
    int i = 3;
    int k;
    if (paramList == null) {
      k = 0;
    }
    while ((getActivity() != null) && (k != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String str = String.format(getString(2131694504), new Object[] { Integer.valueOf(k) });
      if (k < 3) {
        i = paramList.size();
      }
      k = 0;
      for (;;)
      {
        if (k < i)
        {
          URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_Afhl.a((EmoticonFromGroupEntity)paramList.get(k), 65537, ankt.dip2px(11.0F), null);
          int m = k + 1;
          k = m;
          if (localURLDrawable != null)
          {
            localArrayList.add(localURLDrawable);
            this.I.append(" ");
            k = m;
            if (1 != localURLDrawable.getStatus())
            {
              localURLDrawable.startDownload();
              localURLDrawable.setURLDrawableListener(new zcx(this));
              k = m;
              continue;
              k = paramList.size();
              break;
            }
          }
        }
      }
      this.jdField_j_of_type_AndroidTextSpannableString = new SpannableString(this.I + str);
      paramList = new zdb(this.mApp);
      paramList.M(localArrayList, ankt.dip2px(11.0F));
      paramList.setBounds(0, 0, ankt.dip2px(33.0F), ankt.dip2px(22.0F));
      this.jdField_j_of_type_AndroidTextSpannableString.setSpan(new ImageSpan(paramList, 0), 0, this.I.length() - 4, 17);
      this.Mv.setTextSize(14.0F);
      this.Mv.setTextColor(Color.parseColor("#FF777777"));
      this.Mv.setText(this.jdField_j_of_type_AndroidTextSpannableString);
    }
  }
  
  private void initUI()
  {
    this.leftView.setVisibility(0);
    this.leftView.setText(2131694505);
    this.leftView.setTextColor(getResources().getColor(2131165381));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840658));
    this.centerView.setTextColor(getResources().getColor(2131165381));
    this.jdField_ez_of_type_AndroidWidgetButton.setBackgroundResource(2130840623);
    this.jdField_ez_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.u = new AlphaAnimation(0.0F, 1.0F);
    this.u.setFillAfter(true);
    this.u.setDuration(500L);
    this.v = new AlphaAnimation(1.0F, 0.0F);
    this.v.setFillAfter(true);
    this.v.setDuration(500L);
    this.A = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.A.setFillAfter(true);
    this.A.setDuration(500L);
    this.B = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.B.setAnimationListener(new zcv(this));
    this.B.setFillAfter(true);
    this.B.setDuration(500L);
    cog();
    this.iv.setVisibility(8);
    this.mEmptyView.setVisibility(8);
  }
  
  private void initViews()
  {
    this.Mv = ((TextView)this.mContentView.findViewById(2131381088));
    this.x = ((RecyclerView)this.mContentView.findViewById(2131373272));
    this.et = ((Button)this.mContentView.findViewById(2131363855));
    this.iv = ((RelativeLayout)this.mContentView.findViewById(2131368169));
    this.eu = ((Button)this.mContentView.findViewById(2131363882));
    this.et.setOnClickListener(this);
    this.eu.setOnClickListener(this);
    this.yw = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131562107, this.titleRoot, false);
    this.xu = this.yw.findViewById(2131366323);
    this.vP = this.yw.findViewById(2131366324);
    this.jdField_j_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.yw.findViewById(2131366325));
    this.yx = this.yw.findViewById(2131363853);
    this.yy = this.yw.findViewById(2131363854);
    this.ev = ((Button)this.yw.findViewById(2131363884));
    this.ew = ((Button)this.yw.findViewById(2131363883));
    this.xu.setOnClickListener(this);
    this.vP.setOnClickListener(this);
    this.yx.setOnClickListener(this);
    this.yy.setOnClickListener(this);
    this.ev.setOnClickListener(this);
    this.ew.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.mActivity, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.x.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.Mw = ((TextView)this.mContentView.findViewById(2131381078));
    this.yz = new View(this.titleRoot.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.yz.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.yz.setBackgroundColor(Color.parseColor(getString(2131165397)));
    try
    {
      this.yA = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131562102, this.titleRoot, false);
      this.yB = this.yA.findViewById(2131367092);
      this.yB.setOnClickListener(this);
      this.o = ((ListView)this.yA.findViewById(2131370944));
      this.o.setOnItemClickListener(new zcu(this));
      this.jdField_a_of_type_Zcy = new zcy(this.mActivity);
      this.o.setAdapter(this.jdField_a_of_type_Zcy);
      this.Mx = ((TextView)this.yA.findViewById(2131381086));
      this.ex = ((Button)this.yA.findViewById(2131363866));
      this.ey = ((Button)this.yA.findViewById(2131363865));
      this.ex.setOnClickListener(this);
      this.ey.setOnClickListener(this);
      this.mEmptyView = this.mContentView.findViewById(2131368170);
      ((URLImageView)this.mEmptyView.findViewById(2131369028)).setImageDrawable(URLDrawable.getDrawable("https://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
      this.jdField_ez_of_type_AndroidWidgetButton = new Button(this.mActivity);
      this.jdField_ez_of_type_AndroidWidgetButton.setId(2131379036);
      localObject = new RelativeLayout.LayoutParams(ankt.dip2px(21.0F), ankt.dip2px(20.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 8;
      this.jdField_ez_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.vg.addView(this.jdField_ez_of_type_AndroidWidgetButton);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
      }
    }
  }
  
  public void L(boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      localObject = null;
      i = 0;
      if (i >= localViewGroup.getChildCount()) {
        break label113;
      }
      View localView = localViewGroup.getChildAt(i);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label106;
      }
    }
    label106:
    label113:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      i += 1;
      break;
    }
  }
  
  void bVw()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact;
    if ((this.mActivity != null) && ((this.mActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)this.mActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(this.mActivity.getAppRuntime())) {
          break label122;
        }
        if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
          break label109;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label109:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label122:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      this.mActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  protected void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562105;
  }
  
  public void init(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.init(paramBundle);
    super.setTitle(acfp.m(2131705817));
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      this.mActivity = paramBundle;
      paramBundle = this.mActivity.getAppInterface();
      if (!(paramBundle instanceof QQAppInterface)) {
        break label206;
      }
      this.mApp = ((QQAppInterface)paramBundle);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afhl = ((aqrc)paramBundle.getManager(235)).c;
      paramBundle = (afhv)this.mApp.getManager(103);
      if (paramBundle != null) {
        paramBundle.cYZ();
      }
      this.mApp.addObserver(this.f);
      initViews();
      initUI();
      coh();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
      }
      return;
      QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
      finish();
      break;
      label206:
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putBoolean("PhotoConst.IS_FORWARD", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtras(paramIntent);
      String str = paramIntent.getString("GALLERY.FORWORD_LOCAL_PATH");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str);
      paramInt1 = paramIntent.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
      PhotoUtils.a(this.mActivity, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Zdc != null) && (this.jdField_a_of_type_Zdc.bqM))
    {
      Iterator localIterator = this.tQ.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
      }
      this.tQ.clear();
      this.iv.setVisibility(8);
      this.et.setVisibility(0);
      this.jdField_a_of_type_Zdc.bqM = false;
      this.jdField_a_of_type_Zdc.aF(false);
      this.jdField_a_of_type_Zdc.notifyDataSetChanged();
      con();
      L(true);
      resetLeftButton();
      return true;
    }
    if (this.titleRoot == this.yw.getParent())
    {
      this.titleRoot.removeView(this.yw);
      L(true);
      return true;
    }
    if (this.bqK)
    {
      com();
      col();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return true;
    }
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.Mw.getVisibility() == 0) {
        this.Mw.setVisibility(8);
      }
      coo();
      L(false);
      setLeftButton(acfp.m(2131705849), this.jdField_ez_of_type_AndroidViewView$OnClickListener);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131165381));
      this.et.setVisibility(8);
      this.eu.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.eu.setBackgroundDrawable(getResources().getDrawable(2130845276));
      this.eu.setEnabled(false);
      this.iv.setVisibility(0);
      this.jdField_a_of_type_Zdc.aF(true);
      this.jdField_a_of_type_Zdc.bqM = true;
      this.jdField_a_of_type_Zdc.notifyDataSetChanged();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      this.et.setVisibility(0);
      this.iv.setVisibility(8);
      this.jdField_a_of_type_Zdc.aF(false);
      this.jdField_a_of_type_Zdc.bqM = false;
      this.tS.addAll(this.tQ);
      this.jdField_a_of_type_Afhl.kd(new ArrayList(this.tQ));
      Object localObject1 = this.tQ.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject1).next()).status = 0;
      }
      localObject1 = (afhj)this.mApp.getManager(259);
      ((afhj)localObject1).cQU -= this.tQ.size();
      this.tQ.clear();
      this.jdField_a_of_type_Zdc.notifyDataSetChanged();
      con();
      L(true);
      resetLeftButton();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      if (this.titleRoot == this.yw.getParent())
      {
        AbstractGifImage.pauseAll();
        this.titleRoot.removeView(this.yw);
        L(true);
        continue;
        this.jdField_j_of_type_AndroidSupportV4ViewViewPager.arrowScroll(17);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        continue;
        this.jdField_j_of_type_AndroidSupportV4ViewViewPager.arrowScroll(66);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        continue;
        localObject1 = ((ImgPreviewAdapter)this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if ((localObject1 != null) && (((EmoticonFromGroupEntity)localObject1).msg != null)) {
          xsk.b(new xuf(xtm.a(((EmoticonFromGroupEntity)localObject1).msg)), this.mActivity, 0);
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          break;
          QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
        }
        localObject1 = ((ImgPreviewAdapter)this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if (this.jdField_a_of_type_Afhl.a((EmoticonFromGroupEntity)localObject1))
        {
          this.tS.add(localObject1);
          this.ew.setText(acfp.m(2131705808));
          this.ew.setTextColor(Color.parseColor("#FFBBBBBB"));
          this.ew.setBackgroundDrawable(getResources().getDrawable(2130845276));
          this.ew.setEnabled(false);
          this.jdField_a_of_type_Zdc.notifyDataSetChanged();
        }
        if (localObject1 != null) {
          afnu.c(this.mApp, 4, ((EmoticonFromGroupEntity)localObject1).md5, null);
        }
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        continue;
        if (this.yA == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
          }
        }
        else
        {
          L(false);
          this.bqK = true;
          if (this.titleRoot != this.yz.getParent()) {
            this.titleRoot.addView(this.yz);
          }
          if (this.titleRoot != this.yA.getParent()) {
            this.titleRoot.addView(this.yA);
          }
          this.yz.startAnimation(this.u);
          this.yA.startAnimation(this.A);
          localObject1 = this.tV.iterator();
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.tU.add(localObject2);
            ((zcy.a)this.ii.get(localObject2)).isChecked = true;
          }
          if (!this.bqL)
          {
            this.bqL = true;
            cok();
          }
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          continue;
          com();
          col();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          continue;
          if (!this.tV.isEmpty()) {
            this.tV.clear();
          }
          int i = this.tU.size();
          if (i == 0)
          {
            localObject1 = new ArrayList(this.tR);
            localObject2 = this.jdField_a_of_type_Afhl.f((List)localObject1);
            if (localObject2 != null)
            {
              hd((List)localObject1);
              this.jdField_a_of_type_Zdc.a((Map)localObject2, (List)localObject1);
            }
          }
          for (;;)
          {
            com();
            col();
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", "" + i, "", "", "", "", 0, 0, 0, 0);
            break;
            localObject1 = new ArrayList();
            localObject2 = this.tU.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              this.tV.add(str);
              ((List)localObject1).addAll((Collection)this.ih.get(str));
            }
            Collections.sort((List)localObject1);
            localObject2 = this.jdField_a_of_type_Afhl.f((List)localObject1);
            if (localObject2 != null)
            {
              hd((List)localObject1);
              this.jdField_a_of_type_Zdc.a((Map)localObject2, (List)localObject1);
            }
          }
          com();
          this.jdField_a_of_type_Zcy.notifyDataSetChanged();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.tQ.clear();
    this.jdField_a_of_type_Afhl.kb(this.tS);
    this.jdField_a_of_type_Afhl.kc(this.tS);
    MqqHandler localMqqHandler = this.mApp.getHandler(ChatActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10).sendToTarget();
    }
    this.mApp.removeObserver(this.f);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    bVw();
    AbstractGifImage.resumeAll();
    if (this.jdField_a_of_type_Zdc != null) {
      this.jdField_a_of_type_Zdc.notifyDataSetChanged();
    }
    if ((this.ew != null) && (this.jdField_j_of_type_AndroidSupportV4ViewViewPager != null))
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = ((ImgPreviewAdapter)this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_j_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localEmoticonFromGroupEntity != null)
      {
        if (localEmoticonFromGroupEntity.status != 0) {
          break label123;
        }
        this.ew.setText(acfp.m(2131705851));
        this.ew.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.ew.setBackgroundDrawable(getResources().getDrawable(2130845276));
        this.ew.setEnabled(false);
      }
    }
    return;
    label123:
    this.ew.setText(acfp.m(2131705812));
    this.ew.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.ew.setBackgroundDrawable(getResources().getDrawable(2130845275));
    this.ew.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */