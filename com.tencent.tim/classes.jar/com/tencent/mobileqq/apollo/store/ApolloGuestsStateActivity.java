package com.tencent.mobileqq.apollo.store;

import abii;
import abiy;
import abja;
import abtg;
import abtk;
import abtl;
import abtm;
import abtn;
import abto;
import abtz;
import abub;
import abvg;
import abxi;
import acej;
import acfp;
import aixg;
import aixk;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import aqzv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import wja;

public class ApolloGuestsStateActivity
  extends BaseActivity
  implements abub, aixg, View.OnClickListener, aqzv
{
  View AT;
  TextView PU;
  TextView PV;
  public abiy a;
  public ApolloTextureView a;
  String aGC;
  private ObjectAnimator aO;
  private ObjectAnimator aP;
  private abtg b;
  boolean bDn = false;
  boolean bFj = false;
  boolean bFk = false;
  boolean bFl;
  private SparseArray<abtz> cd = new SparseArray();
  int cry = 0;
  int crz;
  public Button fC;
  public RelativeLayout jn;
  RelativeLayout jo;
  float mDensity = 0.0F;
  int mFrom;
  Handler mHandler;
  int mRoleId = 0;
  private RelativeLayout mRootView;
  String mUin;
  float sD = 0.0F;
  float sE = 0.0F;
  List<View> ww = new ArrayList();
  ImageView xA;
  private ImageView xz;
  
  public ApolloGuestsStateActivity()
  {
    this.jdField_a_of_type_Abiy = new abtm(this);
  }
  
  private void cFe()
  {
    PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 1.8F, 1.2F });
    PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 1.8F, 1.2F });
    this.aO = ObjectAnimator.ofPropertyValuesHolder(this.fC, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2 });
    this.aO.setDuration(500L);
    this.aO.addListener(new abtl(this));
    this.aO.start();
  }
  
  private void id(List<abtz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i;
    if ((this.ww != null) && (this.ww.size() > 0))
    {
      i = 0;
      while (i < this.ww.size())
      {
        this.jo.removeView((View)this.ww.get(i));
        i += 1;
      }
      this.ww.clear();
    }
    DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      abtz localabtz = (abtz)paramList.next();
      if (!TextUtils.isEmpty(localabtz.mDescription))
      {
        this.cd.put(localabtz.crW, localabtz);
        TextView localTextView = new TextView(this);
        localTextView.setId(localabtz.crW);
        localTextView.setText(localabtz.mDescription);
        localTextView.setTextSize(10.0F);
        localTextView.setTextColor(-1);
        localTextView.setGravity(17);
        label228:
        RelativeLayout.LayoutParams localLayoutParams;
        int j;
        if (localabtz.bFB)
        {
          localTextView.setTag("isRole");
          localTextView.setOnClickListener(this);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(15, -1);
          i = 0;
          Drawable localDrawable = v(localabtz.mTag);
          if (localabtz.mTag != 0)
          {
            localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
            localTextView.setCompoundDrawables(localDrawable, null, null, null);
          }
          if (localabtz.mDirection != 0) {
            break label553;
          }
          ApolloUtil.ab(localTextView, 2130838638);
          localTextView.setPadding((int)(5.0F * localDisplayMetrics.density), 0, (int)(19.0F * localDisplayMetrics.density), 0);
          localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          j = localTextView.getMeasuredWidth();
          i = localTextView.getMeasuredHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "textview measure wiidth=" + localTextView.getMeasuredWidth());
          }
          localArrayList2.add(localTextView);
          localLayoutParams.addRule(9, -1);
          localLayoutParams.leftMargin = Math.max(localabtz.crX - j, 0);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag textview height = " + i);
          }
          localLayoutParams.addRule(12, -1);
          localLayoutParams.bottomMargin = Math.max(localabtz.crY - i / 2, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) {
            break;
          }
          this.jo.addView(localTextView, localLayoutParams);
          localTextView.setVisibility(0);
          this.ww.add(localTextView);
          break;
          localTextView.setTag("isDress");
          break label228;
          label553:
          if (localabtz.mDirection == 1)
          {
            ApolloUtil.ab(localTextView, 2130838639);
            localTextView.setPadding((int)(19.0F * localDisplayMetrics.density), 0, (int)(5.0F * localDisplayMetrics.density), 0);
            localTextView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            j = localTextView.getMeasuredWidth();
            i = localTextView.getMeasuredHeight();
            localArrayList1.add(localTextView);
            localLayoutParams.addRule(11, -1);
            localLayoutParams.rightMargin = Math.max(localabtz.crX - j, 0);
          }
        }
      }
    }
    ie(localArrayList1);
    ie(localArrayList2);
  }
  
  private Drawable v(int paramInt)
  {
    int j = 2130838708;
    int i;
    if (paramInt == 1) {
      i = 2130838707;
    }
    for (;;)
    {
      return super.getResources().getDrawable(i);
      i = j;
      if (paramInt == 2) {
        i = j;
      }
    }
  }
  
  void Ia(int paramInt)
  {
    super.runOnUiThread(new ApolloGuestsStateActivity.2(this, paramInt));
  }
  
  public void Ib(int paramInt)
  {
    Ia(paramInt);
  }
  
  public void aL(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return;
            this.PU.setText("" + paramMessage.arg1);
          } while (paramMessage.arg1 >= paramMessage.arg2);
          i = paramMessage.arg1;
          j = paramMessage.arg2;
          String str = String.valueOf(j);
          paramMessage = str;
          if (j == 99999) {
            paramMessage = str + "+";
          }
          this.PU.setText(paramMessage);
          j -= i;
        } while ((j <= 0) || (i == 0));
        this.PV = ((TextView)this.AT.findViewById(2131362770));
        this.PV.setText("+" + j);
        this.PV.setVisibility(0);
        return;
        id((List)paramMessage.obj);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloGuestsStateActivity", 2, "dress tag list=" + ((List)paramMessage.obj).toString());
      return;
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    paramMessage = new BitmapDrawable(paramMessage);
    this.AT.setBackgroundDrawable(paramMessage);
    BaseApplicationImpl.sImageCache.put(this.mRoleId + "apollo_cmshow_background", paramMessage);
  }
  
  public void aa(String paramString, int paramInt1, int paramInt2)
  {
    this.crz = paramInt1;
    if (this.bFk) {
      gM(this.crz, paramInt2);
    }
    for (;;)
    {
      this.crz = paramInt2;
      return;
      this.PU.setText(paramString);
    }
  }
  
  public void cFb()
  {
    this.AT = super.getLayoutInflater().inflate(2131558726, null, false);
    this.mRootView = new RelativeLayout(this);
    this.mRootView.setBackgroundColor(super.getResources().getColor(2131167202));
    long l1 = Math.max(aqgz.hJ(), aqgz.hI());
    long l2 = Math.min(aqgz.hJ(), aqgz.hI());
    float f1 = (float)(l1 / 1.52D);
    float f2 = (float)(l2 / 1.27D);
    this.sE = f1;
    Object localObject = new RelativeLayout.LayoutParams((int)f2, (int)f1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.mRootView.addView(this.AT, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(l1 / 16.68D + 0.5D), (int)(l1 / 16.68D + 0.5D));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(14);
    localLayoutParams.bottomMargin = ((int)(l1 / 19.899999999999999D + 0.5D));
    this.xz = ((ImageView)localObject);
    this.xz.setOnClickListener(this);
    ((ImageView)localObject).setBackgroundResource(2130838543);
    this.mRootView.addView((View)localObject, localLayoutParams);
    localObject = AnimationUtils.loadAnimation(this, 2130772021);
    this.AT.startAnimation((Animation)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(this.sE + 0.5F));
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)(f2 + 0.5F));
    localObject = abtn.a(true, abxi.biw + "apollo_aio_bg_v3.png", (URLDrawable.URLDrawableOptions)localObject, "https://cmshow.gtimg.cn/client/img/apollo_aio_bg_v3.png");
    this.AT.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jo = ((RelativeLayout)this.AT.findViewById(2131368214));
    ((RelativeLayout.LayoutParams)this.jo.getLayoutParams()).bottomMargin = ((int)((float)l1 / 5.03F + 0.5F));
    this.jo.requestLayout();
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.jo.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(new a(this));
    cFc();
  }
  
  public void cFc()
  {
    Object localObject = (TextView)this.AT.findViewById(2131372361);
    this.aGC = super.getIntent().getStringExtra("extra_guest_nick");
    this.mUin = super.getIntent().getStringExtra("extra_guest_uin");
    this.mFrom = super.getIntent().getIntExtra("extra_guest_from", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "nickname = " + this.aGC + " uin=" + this.mUin);
    }
    if (this.mUin.equals(super.getAppInterface().getCurrentAccountUin())) {
      this.bFk = true;
    }
    QQAppInterface localQQAppInterface = this.app;
    int j = this.mFrom;
    int i;
    if (this.bFk)
    {
      i = 0;
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "yy_dresscheck", j, i, new String[0]);
      if (TextUtils.isEmpty(this.aGC)) {
        break label350;
      }
      ((TextView)localObject).setText(this.aGC);
    }
    for (;;)
    {
      this.PU = ((TextView)this.AT.findViewById(2131362751));
      this.xA = ((ImageView)this.AT.findViewById(2131379764));
      this.jn = ((RelativeLayout)this.AT.findViewById(2131362890));
      cFd();
      localObject = Calendar.getInstance();
      if ((BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0).getBoolean(super.getAppInterface().getCurrentAccountUin() + "apollo_today_has_vote" + this.mUin + ((Calendar)localObject).get(1) + ((Calendar)localObject).get(2) + ((Calendar)localObject).get(5), false)) && (Build.VERSION.SDK_INT >= 11))
      {
        this.bFl = true;
        this.fC.setAlpha(0.5F);
      }
      return;
      i = 1;
      break;
      label350:
      ((TextView)localObject).setText(" ");
    }
  }
  
  @TargetApi(11)
  public void cFd()
  {
    this.fC = ((Button)this.AT.findViewById(2131362769));
    this.fC.setOnClickListener(this);
    this.fC.setOnTouchListener(new abtk(this));
  }
  
  public void cFf()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onExecDispose();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    super.startActivity(localIntent);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().addFlags(16777216);
    super.doOnCreate(paramBundle);
    this.mHandler = aixk.a(this);
    this.mDensity = super.getResources().getDisplayMetrics().density;
    initUI();
    this.b = new abtg(this, (QQAppInterface)super.getAppInterface(), this, this.mUin, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
    this.b.cEX();
    super.setContentView(this.mRootView);
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusColor(0);
      this.mSystemBarComp.setStatusBarColor(0);
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onDestroy();
    }
    if (this.b != null)
    {
      this.b.destroy();
      this.b = null;
    }
    this.ww.clear();
    this.ww = null;
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mHandler = null;
    this.jdField_a_of_type_Abiy = null;
    if (this.aO != null)
    {
      this.aO.cancel();
      this.aO = null;
    }
    if (this.aP != null)
    {
      this.aP.cancel();
      this.aP = null;
    }
  }
  
  public void f(int[] paramArrayOfInt, int paramInt)
  {
    float f = (float)Math.max(aqgz.hJ(), aqgz.hI()) / 3.25F / 368.0F;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) {}
    abii localabii;
    do
    {
      return;
      localabii = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
    } while (localabii == null);
    localabii.a(1, null, paramInt, f, this.sD, 0.0F);
    if (paramInt == 0) {
      localabii.a(1, null, abto.j(paramInt), null);
    }
    for (;;)
    {
      this.mRoleId = paramInt;
      if ((this.bDn) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender() == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_a_of_type_Abiy);
      paramArrayOfInt = abvg.a(4, -1, this.mRoleId, true);
      localabii.a(1, null, 5, 0, paramArrayOfInt[0], paramArrayOfInt[1]);
      this.bDn = true;
      return;
      if ((paramInt > 0) && (paramArrayOfInt != null)) {
        localabii.a(1, null, paramArrayOfInt, this.b);
      }
    }
  }
  
  void gM(int paramInt1, int paramInt2)
  {
    if (this.mHandler != null)
    {
      Message localMessage = this.mHandler.obtainMessage(0);
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.sendToTarget();
    }
  }
  
  public void ie(List<TextView> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size() - 1)
      {
        TextView localTextView1 = (TextView)paramList.get(i);
        TextView localTextView2 = (TextView)paramList.get(i + 1);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localTextView2.getLayoutParams();
        if (localLayoutParams1.bottomMargin - localLayoutParams2.bottomMargin < localTextView1.getMeasuredHeight())
        {
          int j = localTextView1.getMeasuredHeight();
          localLayoutParams2.bottomMargin -= j;
          localTextView2.requestLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGuestsStateActivity", 2, "tag location modify move distence=" + j);
          }
        }
        i += 1;
      }
    }
  }
  
  public void jdMethod_if(List<abtz> paramList)
  {
    if ((this.mHandler != null) && (paramList != null))
    {
      Message localMessage = this.mHandler.obtainMessage(1);
      localMessage.obj = paramList;
      localMessage.sendToTarget();
    }
  }
  
  @TargetApi(11)
  public void initUI()
  {
    cFb();
  }
  
  @TargetApi(14)
  public boolean onBackEvent()
  {
    if (!isFinishing())
    {
      finish();
      overridePendingTransition(0, 0);
    }
    return true;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    if (paramView == this.xz)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().onExecDispose();
        this.bFj = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      if (!isFinishing())
      {
        finish();
        overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() != 2131362769) {
        break;
      }
      if (this.bFk)
      {
        if (this.PV != null) {
          this.PV.setVisibility(8);
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 0, new String[0]);
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://cmshow.qq.com/apollo/html/details.html?_bid=2282&_wv=3&seq=-1");
        startActivity((Intent)localObject);
      }
      else if (this.bFl)
      {
        QQToast.a(this, 1, acfp.m(2131702534), 0).show(super.getResources().getDimensionPixelSize(2131299627));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGuestsStateActivity", 2, "today is flowered");
        }
      }
      else
      {
        VipUtils.a(this.app, "cmshow", "Apollo", "y_dresscheckflower", this.mFrom, 1, new String[0]);
        this.bFl = true;
        cFe();
        this.b.cEY();
      }
    }
    int i = paramView.getId();
    Object localObject = (abtz)this.cd.get(i);
    VipUtils.a(this.app, "cmshow", "Apollo", "dresscheckclick", this.mFrom, 0, new String[] { "" + i });
    if ("isRole".equals((String)paramView.getTag())) {}
    for (localObject = "&view=role," + this.mRoleId;; localObject = "&dressId=" + i + "&roleId=" + this.mRoleId)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", (String)localObject);
      ApolloUtil.a(this, localIntent, "mycmshow", abxi.bju, null);
      break;
      if ((((abtz)localObject).csb > 0) && (((abtz)localObject).csc == 1))
      {
        ApolloUtil.w(this, "&id=" + ((abtz)localObject).csb + "&type=" + 4, "aio");
        break;
      }
    }
  }
  
  static class a
    implements abja
  {
    private SoftReference<ApolloGuestsStateActivity> o;
    
    public a(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
    {
      this.o = new SoftReference(paramApolloGuestsStateActivity);
    }
    
    public void onNotifyLongTouch(String paramString) {}
    
    public void onNotifyStatusChanged(int paramInt, String paramString) {}
    
    public void onSurfaceReady(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsStateActivity", 2, "apollo view is Ready.");
      }
      ApolloGuestsStateActivity localApolloGuestsStateActivity = (ApolloGuestsStateActivity)this.o.get();
      if ((localApolloGuestsStateActivity == null) || (localApolloGuestsStateActivity.a == null) || (ApolloGuestsStateActivity.a(localApolloGuestsStateActivity) == null)) {
        return;
      }
      float f3 = acej.aV() / 16.0F;
      float f2 = localApolloGuestsStateActivity.mDensity;
      float f1 = f2;
      if (0.0F != f3) {
        f1 = f2 / f3;
      }
      localApolloGuestsStateActivity.sD = (paramInt1 / 2 / f1);
      if (localApolloGuestsStateActivity.a.getRenderImpl() != null) {
        localApolloGuestsStateActivity.a.getRenderImpl().onExecDispose();
      }
      ApolloGuestsStateActivity.a(localApolloGuestsStateActivity).cEZ();
      localApolloGuestsStateActivity.cry = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity
 * JD-Core Version:    0.7.0.1
 */