package com.tencent.mobileqq.filemanager.fileviewer;

import acfp;
import aeay;
import agmx;
import agqe;
import agqf;
import agqg;
import agqh;
import agqi;
import agql;
import agrx;
import agrz;
import agsa;
import agsb;
import ahau;
import ahav;
import ahbr;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdj;
import aqgv;
import ayxa;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import wja;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements agsa, View.OnClickListener
{
  private TextView Sy;
  private TextView Sz;
  public agqi a;
  private agql jdField_a_of_type_Agql;
  private agrz jdField_a_of_type_Agrz;
  agsb jdField_a_of_type_Agsb = new agqg(this);
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  private long[] ah = new long[5];
  protected int bPd = 10000;
  private BroadcastReceiver bd;
  private DynamicAvatarView c;
  private int cYG;
  private boolean ceN;
  private boolean ceO;
  boolean ceP = false;
  private AvatarLayout d;
  private boolean ev;
  private RelativeLayout ko;
  private aeay mColorNoteController;
  private String mCurrentUin;
  private GestureDetector mGestureDetector;
  private String mUin;
  private int nQ = -1;
  private ImageView zN;
  
  private void a(Object paramObject, String paramString, a... paramVarArgs)
  {
    int i = 0;
    if (paramObject == null) {
      return;
    }
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramVarArgs == null) {}
      for (Object[] arrayOfObject = new Object[0];; arrayOfObject = new Object[paramVarArgs.length])
      {
        if (paramVarArgs == null) {
          break label97;
        }
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].getType();
          arrayOfObject[i] = paramVarArgs[i].getObject();
          i += 1;
        }
        arrayOfClass = new Class[paramVarArgs.length];
        break;
      }
      label97:
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private boolean amg()
  {
    return (this.cYG == 1) || (this.cYG == 2) || (this.cYG == 5) || (this.cYG == 6) || (this.cYG == 3) || (this.cYG == 13) || (this.cYG == 4);
  }
  
  private void dfb()
  {
    if (akM())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.bd == null)
      {
        this.bd = new agqh(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.bd, localIntentFilter);
      }
    }
  }
  
  private void dfc()
  {
    if (this.bd != null)
    {
      this.app.getApp().unregisterReceiver(this.bd);
      this.bd = null;
    }
  }
  
  private void djg()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new a[] { new a(localRelativeLayout, View.class) });
  }
  
  private void djh()
  {
    if (!amg()) {}
    String str;
    int i;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.mCurrentUin)) || (this.cYG == 0));
      str = this.mCurrentUin;
      i = ahbr.hO(this.cYG);
    } while (i == -1);
    if (this.jdField_a_of_type_Agql != null) {
      this.jdField_a_of_type_Agql.djl();
    }
    MiniChatActivity.a(this, i, str, aqgv.e(this.app, str, i));
  }
  
  private void gE()
  {
    this.mColorNoteController = new aeay(this, true, true);
    this.mColorNoteController.setServiceInfo(this.jdField_a_of_type_Agqi.b());
    this.mColorNoteController.attachToActivity(this);
    this.mColorNoteController.a(new agqe(this));
    boolean bool = this.jdField_a_of_type_Agqi.aml();
    if (!bool) {
      this.mColorNoteController.cVy();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.mColorNoteController.cVz();
    }
  }
  
  private void io()
  {
    this.mGestureDetector = new GestureDetector(null, new agqf(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.mGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void iv()
  {
    boolean bool;
    if (this.mColorNoteController != null)
    {
      this.mColorNoteController.setServiceInfo(this.jdField_a_of_type_Agqi.b());
      bool = this.jdField_a_of_type_Agqi.aml();
      if (bool) {
        break label79;
      }
      this.mColorNoteController.cVy();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "updateColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      label79:
      this.mColorNoteController.cVz();
    }
  }
  
  private void su()
  {
    Object localObject;
    if (this.jdField_a_of_type_Agqi != null)
    {
      localObject = this.jdField_a_of_type_Agqi.vE();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
        return;
      }
      this.Sy.post(new FileBrowserActivity.4(this, (String)localObject));
    }
    int i = ahbr.hO(this.cYG);
    if ((!TextUtils.isEmpty(this.mCurrentUin)) && (i != -1) && (amg()) && (this.jdField_a_of_type_Agqi.ami()))
    {
      this.jdField_a_of_type_Agql = new agql(this.app, this.mCurrentUin);
      localObject = (ImageView)findViewById(2131368417);
      this.jdField_a_of_type_Agql.z((View)localObject);
      this.ko.setVisibility(0);
      this.d.setVisibility(0);
      this.d.c(0, this.c, false);
      this.d.setOnClickListener(this);
      this.c.setImageDrawable(aqdj.a(this.app, ahbr.a(this.app, i, this.mCurrentUin), this.mCurrentUin));
    }
    while (this.jdField_a_of_type_Agqi.amn())
    {
      this.zN.setVisibility(0);
      return;
      this.ko.setVisibility(8);
      this.d.setVisibility(8);
    }
    this.zN.setVisibility(8);
  }
  
  @TargetApi(14)
  protected boolean U(Intent paramIntent)
  {
    agrx localagrx = new agrx(this.app);
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      localagrx.setUin(this.mUin);
    }
    if (!localagrx.V(paramIntent)) {}
    do
    {
      return false;
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_Agqi == null)
      {
        this.jdField_a_of_type_Agqi = new agqi(this, this, localagrx.a(this));
        this.jdField_a_of_type_Agqi.a(this.jdField_a_of_type_Agsb);
      }
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Agqi.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (this.jdField_a_of_type_Agqi.amj()) {
      setRequestedOrientation(1);
    }
    return true;
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131367043);
  }
  
  public ForwardFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  }
  
  public void aC()
  {
    ((TextView)findViewById(2131369640)).setVisibility(8);
    this.zN = ((ImageView)findViewById(2131369594));
    this.zN.setImageResource(2130840663);
    this.zN.setVisibility(8);
    this.zN.setContentDescription(acfp.m(2131706210));
    this.zN.setOnClickListener(this);
    this.Sz = ((TextView)findViewById(2131369579));
    this.Sz.setOnClickListener(this);
    this.Sy = ((TextView)findViewById(2131369627));
    this.Sy.setTextSize(1, 19.0F);
    this.Sy.setOnClickListener(this);
    this.d = ((AvatarLayout)findViewById(2131368375));
    this.c = ((DynamicAvatarView)findViewById(2131363324));
    this.ko = ((RelativeLayout)findViewById(2131368392));
  }
  
  public boolean akM()
  {
    boolean bool = false;
    if ((getIntent().getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean amh()
  {
    return this.ceO;
  }
  
  public void ar(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361961);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void au(int paramInt) {}
  
  public int bD()
  {
    return getTitleBarHeight();
  }
  
  public boolean bO()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mColorNoteController != null)
    {
      bool1 = bool2;
      if (!this.mColorNoteController.isColorNoteExist())
      {
        if (!this.mColorNoteController.canAddColorNote()) {
          break label44;
        }
        this.mColorNoteController.insertColorNote();
        bool1 = true;
      }
    }
    return bool1;
    label44:
    this.mColorNoteController.onCannotAdd();
    return false;
  }
  
  public boolean bY()
  {
    return this.ceN;
  }
  
  public boolean bZ()
  {
    if (this.mColorNoteController != null) {
      return this.mColorNoteController.isColorNoteExist();
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.bPd);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_Agrz == null)
      {
        this.jdField_a_of_type_Agrz = new agrz();
        this.jdField_a_of_type_Agrz.a(getIntent());
      }
      if ((this.jdField_a_of_type_Agrz.ams()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if (paramInt1 == 14002)
    {
      QLog.d("FileBrowserActivity<FileAssistant>", 2, "FileBrowserAct finish for doc mini program ");
      finish();
      return;
    }
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Agqi != null)
    {
      this.jdField_a_of_type_Agqi.c(paramConfiguration);
      if (this.jdField_a_of_type_Agqi.amj())
      {
        setRequestedOrientation(-1);
        if (this.ceP) {
          break label50;
        }
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.ceP = bool;
      return;
    }
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.init();
    paramBundle = agmx.b(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramBundle != null) {}
    try
    {
      i = Integer.parseInt(paramBundle);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.mUin = paramBundle.getStringExtra("c2c_discussion_recentfile");
      this.mCurrentUin = paramBundle.getStringExtra("file_browser_extra_params_uin");
      this.cYG = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
        }
        int i = 0;
      }
      this.bPd = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getType();
      if (10004 == this.bPd)
      {
        this.ceN = true;
        ahau.JH("0X8004BB3");
      }
      for (;;)
      {
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.ceN = true;
        }
        if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
          this.ceO = true;
        }
        ayxa.initLiuHaiProperty(this);
        setContentViewNoTitle(2131561062);
        aC();
        if (U(paramBundle)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
        }
        finish();
        return false;
        ahau.JH("0X8004BC8");
      }
      this.nQ = this.jdField_a_of_type_Agqi.getFileType();
      gE();
      su();
      ahau.JH("0X8004C01");
      dfb();
      io();
      Object localObject;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131377547);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (!ahav.amK())
      {
        localObject = new Intent(this, WebProcessReceiver.class);
        ((Intent)localObject).setAction("action_download_tbs");
        sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
      }
      init(paramBundle);
      if (Build.VERSION.SDK_INT <= 11) {
        removeWebViewLayerType();
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    djg();
    dfc();
    if (this.mColorNoteController != null)
    {
      this.mColorNoteController.onDestroy();
      if (this.jdField_a_of_type_Agqi.aml()) {
        this.mColorNoteController.addHistoryNote();
      }
    }
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.cqt();
    }
    if (this.jdField_a_of_type_Agql != null) {
      this.jdField_a_of_type_Agql.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.doOnPause();
    }
    if (this.jdField_a_of_type_Agql != null) {
      this.jdField_a_of_type_Agql.onPause();
    }
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onPause();
    }
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.doOnResume();
    }
    if (this.jdField_a_of_type_Agql != null) {
      this.jdField_a_of_type_Agql.onResume();
    }
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onResume();
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    if (this.mColorNoteController != null)
    {
      this.mColorNoteController.exitAnimation();
      return;
    }
    super.finish();
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public void hV()
  {
    if ((this.mColorNoteController != null) && (this.mColorNoteController.isColorNoteExist())) {
      this.mColorNoteController.deleteColorNote();
    }
  }
  
  public void ir()
  {
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public void is()
  {
    finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void it()
  {
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.djj();
    }
    if (this.jdField_a_of_type_Agqi.amn())
    {
      this.zN.setVisibility(0);
      return;
    }
    this.zN.setVisibility(8);
  }
  
  public void iu()
  {
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.dji();
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.doBeforeFinish();
    }
    return bool;
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
      this.jdField_a_of_type_Agqi.dji();
      continue;
      onBackEvent();
      continue;
      djh();
      continue;
      System.arraycopy(this.ah, 1, this.ah, 0, this.ah.length - 1);
      this.ah[(this.ah.length - 1)] = SystemClock.uptimeMillis();
      if ((this.ah[0] >= SystemClock.uptimeMillis() - 1500L) && (this.jdField_a_of_type_Agqi != null)) {
        this.jdField_a_of_type_Agqi.djk();
      }
    }
  }
  
  public boolean shouldDisplayColorNote()
  {
    if (this.mColorNoteController != null) {
      return this.mColorNoteController.shouldDisplayColorNote();
    }
    return false;
  }
  
  public static final class a
  {
    private final Object object;
    private final Class type;
    
    public a(Object paramObject, Class paramClass)
    {
      this.object = paramObject;
      this.type = paramClass;
    }
    
    Object getObject()
    {
      return this.object;
    }
    
    Class getType()
    {
      return this.type;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */