package com.tencent.mobileqq.activity.tim.timme;

import abcg;
import abch;
import abci;
import abcj;
import abck;
import abcl;
import acep;
import adyp;
import adyq;
import adyr;
import akln;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aneo;
import aqhu;
import aqnm;
import augw;
import auje.a;
import auje.b;
import aujf;
import aunq;
import aunr;
import aunu;
import aupd;
import avsd;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.grayversion.ShareAppLogActivity;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class TimLeba
  extends acep
  implements View.OnClickListener, ViewStub.OnInflateListener, auje.b, CommonLoadingView.a, Observer
{
  private long Ni;
  private TextView Pa;
  private TextView Pb;
  private abcg jdField_a_of_type_Abcg;
  private adyq jdField_a_of_type_Adyq = new abck(this);
  private akln jdField_a_of_type_Akln = new abcl(this);
  private auje.a jdField_a_of_type_Auje$a;
  private aupd jdField_b_of_type_Aupd = new abcj(this);
  private GridListView jdField_b_of_type_ComTencentMobileqqWidgetGridListView;
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler = new abch(this);
  private int cnF;
  private RedDotImageView e;
  private ImageView gL;
  private TextView hp;
  private boolean mHasInited;
  private View mRootView;
  private ImageView qQ;
  private ImageView wY;
  
  private void aC()
  {
    View localView = this.mRootView.findViewById(2131379791);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = ImmersiveUtils.getStatusBarHeight(a());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, i + localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      localView.setLayoutParams(localLayoutParams);
    }
    IphoneTitleBarActivity.setLayerType((ViewGroup)findViewById(2131377361));
    localView.setOnClickListener(this);
    this.qQ = ((ImageView)findViewById(2131371199));
    this.qQ.setOnClickListener(this);
    this.e = ((RedDotImageView)findViewById(2131371200));
    this.e.setOnClickListener(this);
    this.e.setReddotXOffsetDp(10);
    this.e.setReddotYOffsetDp(10);
  }
  
  private void bpN()
  {
    this.app.b().deleteObserver(this);
    this.app.removeObserver(this.jdField_b_of_type_Aupd);
    this.app.unRegistObserver(this.jdField_a_of_type_Adyq);
    this.app.unRegistObserver(this.jdField_a_of_type_Akln);
  }
  
  private void cAW()
  {
    this.Ni = 0L;
    this.cnF = 0;
  }
  
  private void cAX()
  {
    startActivity(new Intent(a(), ShareAppLogActivity.class));
  }
  
  private void cAY()
  {
    if (aunq.a().a(26L).bo == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimLeba", 2, "updateTodoItem");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  private void cAZ()
  {
    aunr localaunr = aunq.a().a(23L);
    if ((localaunr != null) && (localaunr.bo == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimLeba", 2, "updateBusinessCardItem");
      }
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  private void initContentView()
  {
    int i = aqnm.dpToPx(11.0F);
    int j = (aqnm.getScreenWidth() - aqnm.dpToPx(22.0F)) / 2;
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131370342));
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(j, -2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setPadding(i, this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.getPaddingTop(), i, this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.getPaddingBottom());
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setNeedCheckSpringback(true);
    View localView = LayoutInflater.from(a()).inflate(2131559527, null);
    localView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.addHeaderView(localView);
    this.gL = ((ImageView)localView.findViewById(2131368375));
    this.hp = ((TextView)localView.findViewById(2131372384));
    this.wY = ((ImageView)localView.findViewById(2131368411));
    this.Pa = ((TextView)localView.findViewById(2131369979));
    this.Pb = ((TextView)localView.findViewById(2131378414));
    this.jdField_a_of_type_Abcg = new abcg(a(), this.app, new abci(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_Abcg);
  }
  
  private void initUI()
  {
    aC();
    ((ViewStub)findViewById(2131378886)).setOnInflateListener(this);
    ((CommonLoadingView)findViewById(2131365078)).setOnFirstDrawListener(this);
  }
  
  public void Bl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.Pa.setText(paramString);
      this.Pa.setVisibility(0);
      return;
    }
    this.Pa.setText("");
    this.Pa.setVisibility(8);
  }
  
  public void Bm(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.Pb.setText(paramString);
      this.Pb.setVisibility(0);
      return;
    }
    this.Pb.setText("");
    this.Pb.setVisibility(8);
  }
  
  public void Bn(String paramString)
  {
    if (this.hp != null)
    {
      this.hp.setText(paramString);
      if (this.app.isLoginByWx()) {
        this.wY.setImageResource(2130841646);
      }
    }
    else
    {
      return;
    }
    this.wY.setImageResource(2130841643);
  }
  
  public boolean PN()
  {
    return this.mHasInited;
  }
  
  public boolean Pp()
  {
    return this.isResume;
  }
  
  boolean XP()
  {
    bool1 = false;
    Object localObject3 = (aneo)this.app.getManager(10);
    if (localObject3 != null)
    {
      i = ((aneo)localObject3).jn(1);
      if (localObject3 == null) {
        break label84;
      }
    }
    label84:
    for (Object localObject1 = ((aneo)localObject3).dF();; localObject1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + i);
      }
      if (i <= 0) {
        break label90;
      }
      return true;
      i = 0;
      break;
    }
    label90:
    if (localObject3 != null)
    {
      i = ((aneo)localObject3).jn(2);
      label102:
      if ((i > 0) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
        break label377;
      }
      if (localObject3 == null) {
        break label379;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((aneo)localObject3).b(6);
        if (localObject3 == null) {
          continue;
        }
        localavsd = ((aneo)localObject3).b(61);
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((aneo)localObject3).b(3);
        str = "";
        if ((localObject1 == null) || (((avsd)localObject1).ES == null) || (((avsd)localObject1).ES.size() <= 0) || (((QZoneCountUserInfo)((avsd)localObject1).ES.get(0)).uin <= 0L) || (((avsd)localObject1).uCount <= 0L)) {
          continue;
        }
        localObject1 = ((avsd)localObject1).strShowMsg;
        i = 1;
      }
      catch (Exception localException)
      {
        avsd localavsd;
        String str;
        boolean bool2;
        label377:
        label379:
        QLog.e("UndealCount.", 1, "updateQZoneRedFlag" + localException);
        continue;
        bool1 = false;
        continue;
        continue;
        continue;
        i = 0;
        Object localObject2 = str;
        continue;
      }
      if ((i != 0) || (localavsd == null) || (localavsd.ES == null) || (localavsd.ES.size() <= 0) || (((QZoneCountUserInfo)localavsd.ES.get(0)).uin <= 0L) || (localavsd.uCount <= 0L)) {
        continue;
      }
      localObject1 = localavsd.strShowMsg;
      i = 1;
      if ((i != 0) || (localObject3 == null) || (((avsd)localObject3).ES == null) || (((avsd)localObject3).ES.size() <= 0) || (((QZoneCountUserInfo)((avsd)localObject3).ES.get(0)).uin <= 0L) || (((avsd)localObject3).uCount <= 0L)) {
        continue;
      }
      localObject1 = ((avsd)localObject3).strShowMsg;
      bool2 = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool2) {
        continue;
      }
      bool1 = true;
      return bool1;
      i = 0;
      break label102;
      break;
      localObject1 = null;
      continue;
      localavsd = null;
      continue;
      localObject3 = null;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.mRootView = paramLayoutInflater.inflate(2131559526, null);
    return this.mRootView;
  }
  
  public void bMe()
  {
    super.bMe();
    bpN();
  }
  
  public void cBa()
  {
    ThreadManagerV2.excute(new TimLeba.9(this), 16, null, true);
  }
  
  public List<augw> cH()
  {
    this.jdField_a_of_type_Auje$a = new aujf(this.app, this);
    return Arrays.asList(new augw[] { this.jdField_a_of_type_Auje$a });
  }
  
  public void hO(List<aunr> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      aunr localaunr = (aunr)localIterator.next();
      if (localaunr.c != null)
      {
        if (!"PKG_TODOLIST".equals(localaunr.c.strPkgName)) {
          break label97;
        }
        ((aunu)this.app.getBusinessHandler(181)).evE();
      }
      for (;;)
      {
        localArrayList.add(Long.valueOf(localaunr.c.uiResId));
        break;
        label97:
        if ("PKG_BUSINESS_CARD".equals(localaunr.c.strPkgName))
        {
          adyp localadyp = (adyp)this.app.getManager(112);
          adyr.a(this.app, localadyp.Cc(), 0, true);
        }
        else if (!"PKG_SCHEDULE".equals(localaunr.c.strPkgName)) {}
      }
    }
    if (this.jdField_a_of_type_Abcg != null) {
      this.jdField_a_of_type_Abcg.hN(paramList);
    }
  }
  
  public boolean onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TimLeba", 2, "Leba on key down");
    }
    if (FrameHelperActivity.ZW())
    {
      FrameHelperActivity.cuA();
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371199: 
    case 2131368375: 
    case 2131368427: 
    case 2131371200: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject = new Intent(a(), QRDisplayActivity.class);
        String str = this.app.getCurrentAccountUin();
        ((Intent)localObject).putExtra("title", getResources().getString(2131717228));
        ((Intent)localObject).putExtra("nick", this.hp.getText());
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("type", 1);
        ((Intent)localObject).putExtra("reportFlag", 1);
        startActivity((Intent)localObject);
        continue;
        localObject = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).nickname = this.app.getCurrentNickname();
        ProfileActivity.b(this.jdField_b_of_type_ComTencentMobileqqWidgetGridListView.getContext(), (ProfileActivity.AllInOne)localObject);
        continue;
        startActivity(new Intent(a(), QQSettingSettingActivity.class));
      }
    }
    if (this.cnF == 0) {
      this.Ni = System.currentTimeMillis();
    }
    for (;;)
    {
      this.cnF += 1;
      if (this.cnF == 3) {
        QQToast.a(a(), "连续点击5次，可以跳转到发送日志页面。", 0).show(a().getTitleBarHeight());
      }
      if ((System.currentTimeMillis() - this.Ni >= 1500L) || (this.cnF != 5)) {
        break;
      }
      cAW();
      cAX();
      break;
      if ((this.cnF >= 1) && (System.currentTimeMillis() - this.Ni > 1000L))
      {
        this.Ni = System.currentTimeMillis();
        this.cnF = 0;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    initUI();
    this.app.b().addObserver(this);
    this.app.addObserver(this.jdField_b_of_type_Aupd);
    this.app.registObserver(this.jdField_a_of_type_Adyq);
    this.app.registObserver(this.jdField_a_of_type_Akln);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    cAW();
    bpN();
  }
  
  public void onFirstDraw()
  {
    new MqqHandler().post(new TimLeba.3(this));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    initContentView();
    onResume(true);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(a().getWindow(), true);
    }
    this.jdField_a_of_type_Auje$a.VQ(this.mHasInited);
    this.jdField_a_of_type_Auje$a.evj();
    cBa();
    cAW();
    this.mHasInited = true;
  }
  
  public void pE(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Abcg != null)
    {
      this.jdField_a_of_type_Abcg.bQ(this.app);
      this.jdField_a_of_type_Abcg.hN(null);
    }
    this.app.b().addObserver(this);
    this.app.addObserver(this.jdField_b_of_type_Aupd);
    this.app.registObserver(this.jdField_a_of_type_Adyq);
    this.app.registObserver(this.jdField_a_of_type_Akln);
    this.mHasInited = false;
    onResume(true);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof RecentUser)) && (((RecentUser)paramObject).getType() == 8001))
    {
      paramObservable = aunq.a().a(17L);
      if ((paramObservable != null) && (paramObservable.bo == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TimLeba", 2, "updateMailItem");
        }
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void wd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (this.gL != null) {
        this.gL.setImageDrawable(aqhu.at());
      }
    }
    for (;;)
    {
      return;
      String str = this.app.getFaceBitmapCacheKey(1, paramString, (byte)1, 0);
      Bitmap localBitmap = this.app.getBitmapFromCache(str);
      if (localBitmap != null) {
        runOnUiThread(new TimLeba.4(this, localBitmap));
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("TimLeba", 4, "updateFace, " + str + "," + localBitmap);
        return;
        ThreadManager.getFileThreadHandler().post(new TimLeba.5(this, paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.tim.timme.TimLeba
 * JD-Core Version:    0.7.0.1
 */