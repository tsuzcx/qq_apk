package com.tencent.tim.filemanager.fileviewer;

import agsa;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmj;
import atvp;
import atvz;
import atwb;
import atxa;
import atxb;
import atxc;
import atxd;
import atxe;
import atxf;
import atxy;
import atyo;
import atyq;
import atyr;
import audw;
import audx;
import aueh;
import auen;
import aufa.b;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import wja;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements agsa, View.OnClickListener
{
  private static final String UU;
  private static final String bIi = new String(o);
  private static final char[] i = { '…' };
  private static final char[] o;
  private View KJ;
  private TextView Sy;
  private TextView Sz;
  public atxf a;
  private atyq jdField_a_of_type_Atyq;
  atyr jdField_a_of_type_Atyr = new atxc(this);
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  private TextView afi;
  private AdapterView.OnItemClickListener b = new atxb(this);
  protected int bPd = 10000;
  private BroadcastReceiver bd;
  private boolean ceN;
  private boolean ceO;
  boolean ceP = false;
  private boolean ev;
  private ShareActionSheetBuilder f;
  private GestureDetector mGestureDetector;
  private String mUin;
  private ImageView zN;
  
  static
  {
    UU = new String(i);
    o = new char[] { '‥' };
  }
  
  private void a(Object paramObject, String paramString, a... paramVarArgs)
  {
    int j = 0;
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
        int k = arrayOfClass.length;
        while (j < k)
        {
          arrayOfClass[j] = paramVarArgs[j].getType();
          arrayOfObject[j] = paramVarArgs[j].getObject();
          j += 1;
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
  
  private static List<ShareActionSheetBuilder.ActionSheetItem>[] a(ArrayList<aufa.b> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramArrayList.size())
    {
      aufa.b localb = (aufa.b)paramArrayList.get(j);
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = localb.cIq;
      localActionSheetItem.icon = localb.erp;
      localActionSheetItem.listener = localb.gD;
      localActionSheetItem.argus = "";
      localArrayList.add(localActionSheetItem);
      j += 1;
    }
    return (List[])new ArrayList[] { localArrayList };
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
        this.bd = new atxd(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.mobileqq.qlink.destory.fmactivity");
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
  
  private void euB()
  {
    this.Sy = ((TextView)findViewById(2131369627));
    this.Sy.setTextSize(1, 19.0F);
    this.Sy.setText(this.jdField_a_of_type_Atxf.vE());
  }
  
  private void io()
  {
    this.mGestureDetector = new GestureDetector(null, new atxa(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.mGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void su()
  {
    if (this.jdField_a_of_type_Atxf != null)
    {
      String str = this.jdField_a_of_type_Atxf.vE();
      this.Sy.post(new FileBrowserActivity.2(this, str));
    }
  }
  
  @TargetApi(14)
  protected boolean U(Intent paramIntent)
  {
    atyo localatyo = new atyo(this.app);
    if ((this.mUin != null) && (this.mUin.trim().length() != 0)) {
      localatyo.setUin(this.mUin);
    }
    if (!localatyo.V(paramIntent)) {
      return false;
    }
    if (this.jdField_a_of_type_Atxf == null)
    {
      this.jdField_a_of_type_Atxf = new atxf(this, this, localatyo.a(this));
      this.jdField_a_of_type_Atxf.a(this.jdField_a_of_type_Atyr);
    }
    if (!this.jdField_a_of_type_Atxf.b(a(), new RelativeLayout.LayoutParams(-1, -1)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
      }
      return false;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramIntent = (RelativeLayout)findViewById(2131377547);
      paramIntent.setFitsSystemWindows(true);
      paramIntent.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
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
    this.zN.setContentDescription("菜单");
    this.zN.setOnClickListener(this);
    this.Sz = ((TextView)findViewById(2131369579));
    this.Sz.setOnClickListener(this);
    this.Sy = ((TextView)findViewById(2131369627));
    this.Sy.setTextSize(1, 19.0F);
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
    for (int j = 0;; j = 8)
    {
      localRelativeLayout.setVisibility(j);
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
    return false;
  }
  
  public boolean bY()
  {
    return this.ceN;
  }
  
  public boolean bZ()
  {
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mGestureDetector != null) && (this.mGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Atxf != null) {
      this.jdField_a_of_type_Atxf.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.bPd);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_Atyq == null)
      {
        this.jdField_a_of_type_Atyq = new atyq();
        this.jdField_a_of_type_Atyq.a(getIntent());
      }
      if ((this.jdField_a_of_type_Atyq.ams()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = atvz.b(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramBundle != null) {}
    try
    {
      j = Integer.parseInt(paramBundle);
      if (1 == j) {
        setRequestedOrientation(-1);
      }
      paramBundle = new Intent(getIntent());
      localObject = paramBundle.getParcelableExtra("fileinfo");
      if ((localObject instanceof ForwardFileInfo)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)localObject);
      }
      this.mUin = paramBundle.getStringExtra("c2c_discussion_recentfile");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (NumberFormatException paramBundle)
    {
      Object localObject;
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
        }
        int j = 0;
      }
      if ((-1L == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.fR()) && (audx.mI(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getLocalPath())))
      {
        localObject = new FileInfo();
        ((FileInfo)localObject).setSize(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getFileSize());
        ((FileInfo)localObject).setName(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getFileName());
        ((FileInfo)localObject).setPath(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getLocalPath());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        atwb.en(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.p(audx.a((FileInfo)localObject).nSessionId);
      }
      this.bPd = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.getType();
      if (10004 == this.bPd)
      {
        this.ceN = true;
        audw.JH("0X8004BB3");
      }
      for (;;)
      {
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.ceN = true;
        }
        if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
          this.ceO = true;
        }
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
        audw.JH("0X8004BC8");
      }
      su();
      it();
      audw.JH("0X8004C01");
      dfb();
      io();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131377547);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (!audx.amK())
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
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, " FileBrowser doOnDestroy");
    }
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    djg();
    dfc();
    if (this.jdField_a_of_type_Atxf != null) {
      this.jdField_a_of_type_Atxf.cqt();
    }
    atxy.a().onDestroy(this);
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_Atxf != null)
    {
      this.jdField_a_of_type_Atxf.doOnPause();
      if (isFinishing()) {
        this.jdField_a_of_type_Atxf.cqt();
      }
    }
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (this.jdField_a_of_type_Atxf != null) {
      this.jdField_a_of_type_Atxf.doOnResume();
    }
    super.doOnResume();
  }
  
  public void euC()
  {
    if (this.afi != null)
    {
      ((RelativeLayout)findViewById(2131377547)).removeView(this.afi);
      this.afi = null;
      aqmj.e(this.app.getApp(), this.app.getCurrentAccountUin(), "team_work_file_import_guide_tips", false);
    }
  }
  
  protected void euD()
  {
    Object localObject = this.jdField_a_of_type_Atxf.getLocalFilePath();
    if ((!aueh.fileExistsAndNotEmpty((String)localObject)) || (!auen.sW((String)localObject)) || (!auen.cx(this.app))) {}
    int j;
    do
    {
      do
      {
        return;
        j = atvp.n(this.app.getApp(), this.app.getCurrentAccountUin(), "WpsFileEditGuideTipsCount");
      } while (j >= 1);
      localObject = (RelativeLayout)findViewById(2131377547);
    } while (localObject == null);
    if (this.KJ == null)
    {
      int k = ImmersiveUtils.getStatusBarHeight(this);
      int m = getTitleBarHeight();
      this.KJ = LayoutInflater.from(this).inflate(2131563380, null, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.rightMargin = wja.dp2px(2.0F, getResources());
      localLayoutParams.leftMargin = wja.dp2px(2.0F, getResources());
      localLayoutParams.topMargin = (k + m - wja.dp2px(30.0F, getResources()));
      ((RelativeLayout)localObject).addView(this.KJ, localLayoutParams);
      ((RelativeLayout)localObject).findViewById(2131368817).setOnClickListener(new atxe(this));
    }
    for (;;)
    {
      atvp.n(this.app.getApp(), this.app.getCurrentAccountUin(), "WpsFileEditGuideTipsCount", j + 1);
      return;
      this.KJ.setVisibility(0);
    }
  }
  
  public void euE()
  {
    if (this.KJ != null) {
      this.KJ.setVisibility(8);
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public void hV() {}
  
  public void ir()
  {
    this.jdField_a_of_type_Atxf.a(a(), new ViewGroup.LayoutParams(-1, -1));
    it();
  }
  
  public void is() {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void it()
  {
    if (this.jdField_a_of_type_Atxf == null) {
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_Atxf.eq();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.f = new ShareActionSheetBuilder(this);
      this.f.setActionSheetTitle(this.jdField_a_of_type_Atxf.vE() + "(" + aueh.g(this.jdField_a_of_type_Atxf.getFileSize()) + ")");
      this.f.setActionSheetItems(a(this.jdField_a_of_type_Atxf.eq()));
      this.f.setItemClickListener(this.b);
      this.zN.setVisibility(0);
      euD();
      return;
    }
    this.zN.setVisibility(8);
    euC();
    euE();
  }
  
  public void iu() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.f != null) {
        this.f.show();
      }
      euC();
      euE();
      continue;
      onBackEvent();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool = true;
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Atxf != null)
    {
      this.jdField_a_of_type_Atxf.c(paramConfiguration);
      if (this.jdField_a_of_type_Atxf.amj())
      {
        setRequestedOrientation(-1);
        if (!this.ceP) {
          this.jdField_a_of_type_Atyr.as(true);
        }
        if (this.ceP) {
          break label67;
        }
      }
    }
    for (;;)
    {
      this.ceP = bool;
      return;
      label67:
      bool = false;
    }
  }
  
  public boolean shouldDisplayColorNote()
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */