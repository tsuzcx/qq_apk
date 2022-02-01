package com.tencent.mobileqq.troop.activity;

import acbn;
import acfp;
import ahgq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ankt;
import anot;
import aoiz;
import aomc;
import aoti;
import aotj;
import aotk;
import aotl;
import aotm;
import aotn;
import aoto;
import aotp;
import aotq;
import apqw;
import apuh;
import aput;
import apvp;
import aqha;
import aqiw;
import aqju;
import aqul;
import ausj;
import auss;
import ayxa;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.b;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import ivv;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;
import rpq;
import rvx;
import wja;
import yuy;
import zri;
import zta;
import ztd;
import ztd.a;
import ztd.c;
import zti;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.c, DragView.b, ztd.a, ztd.c
{
  private long Kh;
  public aput a;
  public apvp a;
  private a jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected DragView a;
  public ztd a;
  protected ImageButton aH;
  public String aWb;
  protected Gallery b;
  yuy jdField_b_of_type_Yuy;
  ztd jdField_b_of_type_Ztd;
  protected int bFL;
  protected boolean cOC = true;
  public boolean cOD;
  protected boolean cOE;
  protected String cmY;
  protected boolean cvT;
  Set<String> df = new HashSet();
  public GridView e;
  protected View fP;
  protected Button hl;
  private LinearLayout kL;
  protected ImageView mBackView;
  public int mIndex = -1;
  protected Rect mSrcRect;
  public String mTroopUin;
  
  private void bZl()
  {
    if (this.jdField_b_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    Object localObject = this.jdField_b_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368820)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(2131694752, 1);
    localausj.addButton(2131694762, 1);
    if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
      ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localausj));
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new aotq(this, localausj, (URLDrawable)localObject));
    localausj.show();
  }
  
  private void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void cw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Ztd == null) {}
    do
    {
      do
      {
        return;
        if (!this.cOC) {
          break;
        }
        localObject = this.jdField_a_of_type_Ztd.dr();
        if (QLog.isColorLevel()) {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Arrays.deepToString(((List)localObject).toArray()) }));
        }
        if ((this.jdField_a_of_type_Aput != null) && (paramBoolean2)) {
          this.jdField_a_of_type_Aput.mU((List)localObject);
        }
      } while ((this.jdField_a_of_type_Apvp == null) || (!paramBoolean1));
      this.jdField_a_of_type_Apvp.mU((List)localObject);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a.Wi(this.jdField_a_of_type_Apvp.getCount());
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a.Wh(this.mIndex);
    return;
    Object localObject = this.jdField_a_of_type_Ztd.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject }));
    }
    ArrayList localArrayList = new ArrayList(1);
    Button localButton;
    if (localObject != null)
    {
      localArrayList.add(localObject);
      localButton = this.hl;
      if (((zri)localObject).isUploading) {
        break label247;
      }
    }
    label247:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localButton.setEnabled(paramBoolean1);
      if (this.jdField_a_of_type_Apvp == null) {
        break;
      }
      this.jdField_a_of_type_Apvp.mU(localArrayList);
      return;
    }
  }
  
  private void d(URLDrawable paramURLDrawable, String paramString)
  {
    new aotl(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void dK(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ztd == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      paramIntent = paramIntent.getStringExtra("key_clip_info");
    } while (TextUtils.isEmpty(str));
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
    }
    this.jdField_a_of_type_Ztd.ag(str, paramIntent);
  }
  
  private void dWP()
  {
    if ((this.cvT) && (this.cOC))
    {
      this.aH.setVisibility(0);
      this.aH.setOnClickListener(this);
      this.aH.setContentDescription(getResources().getString(2131692498));
    }
    for (;;)
    {
      if ((!this.cOC) && (this.cvT))
      {
        this.hl.setVisibility(0);
        this.hl.setOnClickListener(this);
      }
      this.kL = ((LinearLayout)findViewById(2131369149));
      if ((!this.cOC) || (this.cvT)) {
        break;
      }
      this.kL.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a = new a(this.kL);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a.Wi(this.jdField_a_of_type_Apvp.getCount());
      return;
      this.aH.setVisibility(8);
    }
    this.kL.setVisibility(8);
  }
  
  private void dWQ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject2 = zti.f(apqw.oL(apqw.p(zri.baD, this.mTroopUin, 0)));
    if (localObject2 == null)
    {
      Fw(1);
      return;
    }
    File localFile2 = aoiz.getFile(((URL)localObject2).toString());
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ((localFile2 == null) || (!localFile2.exists())) {
        break label264;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", new Object[] { localObject2, Boolean.valueOf(bool) }));
      Object localObject1;
      if (localFile2 != null)
      {
        localObject1 = localFile2;
        if (localFile2.exists()) {}
      }
      else
      {
        localObject1 = new DownloadParams();
        ((DownloadParams)localObject1).url = ((URL)localObject2);
        ((DownloadParams)localObject1).urlStr = ((URL)localObject2).toString();
        localObject2 = new aomc();
      }
      try
      {
        localObject1 = ((aomc)localObject2).loadImageFile((DownloadParams)localObject1, new aotm(this));
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label284;
          }
          if (this.jdField_b_of_type_Ztd == null)
          {
            this.jdField_b_of_type_Ztd = new zta(this, this, this.app, this.mTroopUin);
            this.jdField_b_of_type_Ztd.a(this);
          }
          runOnUiThread(new TroopAvatarWallEditActivity.15(this, (File)localObject1));
          return;
          label264:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          File localFile1 = localFile2;
          continue;
          bool = false;
        }
        label284:
        Fw(3);
      }
    }
  }
  
  private void dp(Bundle paramBundle)
  {
    boolean bool = false;
    this.e = ((GridView)findViewById(2131363209));
    if ((this.cOC) && (this.cvT))
    {
      this.e.setVisibility(0);
      this.e.setOnItemClickListener(this);
      this.e.setEdgeEffectEnabled(false);
      paramBundle = new WeakReference(this);
      GridView localGridView = this.e;
      QQAppInterface localQQAppInterface = this.app;
      String str = this.mTroopUin;
      if (!this.cOD) {
        bool = true;
      }
      this.jdField_a_of_type_Aput = new aput(paramBundle, localGridView, localQQAppInterface, str, bool, this.cvT, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_Aput.u(this);
      ((RelativeLayout)findViewById(2131377426)).setMinimumHeight(i * 2 + rpq.dip2px(this, 10.0F));
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void dq(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.jdField_b_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367833));
    View localView = findViewById(2131377421);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Object localObject = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.cOC) && (this.cvT))
    {
      localObject = zti.a(this, 103);
      localLayoutParams.bottomMargin = wja.dp2px(45.0F, getResources());
      localLayoutParams.width = ((Point)localObject).x;
      localLayoutParams.height = ((Point)localObject).y;
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Apvp = new apvp(this, this.app, this.mTroopUin, ((Point)localObject).x, ((Point)localObject).y, this.jdField_b_of_type_ComTencentWidgetGallery);
      this.jdField_a_of_type_Apvp.Ua(this.cmY);
      localObject = this.jdField_a_of_type_Apvp;
      if (paramBundle.getBoolean("from_photo_wall", false)) {
        break label570;
      }
      bool1 = true;
      label195:
      ((apvp)localObject).So(bool1);
      this.jdField_a_of_type_Apvp.Sp(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Apvp.Sr(this.cOC);
      this.jdField_a_of_type_Apvp.ce(this.cvT);
      paramBundle = zti.a(this, 103);
      this.jdField_a_of_type_Apvp.ke(paramBundle.x, paramBundle.y);
      this.jdField_b_of_type_ComTencentWidgetGallery.setContentDescription(acfp.m(2131715566));
      this.jdField_b_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297406));
      paramBundle = this.jdField_b_of_type_ComTencentWidgetGallery;
      if (this.cvT) {
        break label576;
      }
      bool1 = true;
      label306:
      paramBundle.enableDoubleTap(bool1);
      paramBundle = this.jdField_b_of_type_ComTencentWidgetGallery;
      if (this.cvT) {
        break label582;
      }
    }
    label570:
    label576:
    label582:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBundle.enableScaleGesture(bool1);
      this.jdField_b_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Apvp);
      if ((this.cOC) && (!this.cvT)) {
        this.jdField_b_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new aoti(this));
      }
      if (!this.cvT) {
        this.jdField_b_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aotn(this));
      }
      this.jdField_b_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new aoto(this));
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131366139));
      this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
      paramBundle = this.jdField_a_of_type_ComTencentWidgetDragView;
      bool1 = bool2;
      if (!this.cvT) {
        bool1 = true;
      }
      paramBundle.setEnableDrag(bool1);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      if (this.mSrcRect != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.mSrcRect);
      }
      return;
      if ((this.cOC) && (this.cvT))
      {
        ((Point)localObject).set(i, zti.fD(i));
        break;
      }
      int k = wja.dp2px(60.0F, getResources());
      ((Point)localObject).set(i, j - k);
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = k;
      break;
      bool1 = false;
      break label195;
      bool1 = false;
      break label306;
    }
  }
  
  private void l(URLDrawable paramURLDrawable)
  {
    if (this.cmY != null) {
      anot.a(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.cmY, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((VersionUtils.isM()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
        localObject = new TroopAvatarWallEditActivity.9(this);
        this.jdField_b_of_type_Yuy = new yuy();
        this.jdField_b_of_type_Yuy.eQ = ((Runnable)localObject);
        this.jdField_b_of_type_Yuy.eP = paramURLDrawable;
        requestPermissions(this, 1, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      v(paramURLDrawable);
      return;
    }
  }
  
  private void v(URLDrawable paramURLDrawable)
  {
    String str = acbn.oM;
    new File(str).mkdirs();
    str = str + this.mTroopUin + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {
      try
      {
        if (localFile.createNewFile()) {
          d(paramURLDrawable, localFile.getPath());
        }
        return;
      }
      catch (IOException paramURLDrawable)
      {
        QQToast.a(this, getString(2131696986), 0).show();
        return;
      }
    }
    aqha.a(this, 230).setTitle(getString(2131718959)).setMessage(getString(2131696979)).setPositiveButton(getString(2131718798), new aotk(this, paramURLDrawable, str)).setNegativeButton(getString(2131696322), new aotj(this)).show();
  }
  
  protected void Fw(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_Ztd != null) {
        this.jdField_a_of_type_Ztd.Fw(paramInt);
      }
      return;
    }
    runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
  }
  
  public void b(zri paramzri, TroopUploadingThread.a parama)
  {
    if (this.cOC)
    {
      if ((paramzri.type == 1) && (this.cOE)) {
        if (parama.dWB == 1)
        {
          this.cOE = false;
          dWR();
        }
      }
      while (this.jdField_a_of_type_Aput == null)
      {
        do
        {
          return;
        } while (parama.dWB != 2);
        Fw(5);
        return;
      }
      this.jdField_a_of_type_Aput.c(paramzri, parama);
      return;
    }
    Button localButton;
    if (this.jdField_a_of_type_Apvp.a(0) == paramzri)
    {
      localButton = this.hl;
      if (paramzri.isUploading) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      this.jdField_a_of_type_Apvp.c(paramzri, parama);
      if ((paramzri.type != 1) || (parama.dWB != 1)) {
        break;
      }
      ztd.showToast(zti.d(this, 0), 2);
      return;
    }
  }
  
  public void c(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.cmY != null) {
      anot.a(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.cmY, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = aqul.getSDKPrivatePath(acbn.bmS);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = paramString + this.mTroopUin + Utils.Crc64String(paramURLDrawable.getURL().toString());
    paramString = (String)localObject;
    if (!new File((String)localObject).exists()) {}
    try
    {
      paramString = paramURLDrawable.saveTo((String)localObject);
      localBundle.putString("forward_filepath", paramString);
      localBundle.putString("forward_thumb", paramString);
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtras(localBundle);
      ahgq.f(this, paramURLDrawable, 21);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      for (;;)
      {
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", paramURLDrawable);
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public void d(zri paramzri)
  {
    if (this.cOC) {
      cw(true, true);
    }
  }
  
  protected void dWR()
  {
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.startUpload();
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    if ((this.jdField_b_of_type_Yuy != null) && (this.jdField_b_of_type_Yuy.eQ != null)) {
      this.jdField_b_of_type_Yuy.eQ.run();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 257: 
      do
      {
        return;
      } while (this.jdField_a_of_type_Ztd == null);
      this.jdField_a_of_type_Ztd.crK();
      return;
    }
    bm(paramIntent.getExtras());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
    {
      finish();
      return false;
    }
    setContentView(2131560769);
    Object localObject1 = getIntent().getExtras();
    findViewById(2131377549).setVisibility(0);
    this.fP = findViewById(2131363236);
    this.fP.setBackgroundColor(-16777216);
    this.aH = ((ImageButton)findViewById(2131365679));
    this.hl = ((Button)findViewById(2131363806));
    this.cvT = ((Bundle)localObject1).getBoolean("IS_EDIT");
    this.cOC = ((Bundle)localObject1).getBoolean("IS_COVER", true);
    this.cOE = ((Bundle)localObject1).getBoolean("isUseClassAvatar", false);
    if (((Bundle)localObject1).getInt("vistor_type", 1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.cOD = bool;
      paramBundle = ((Bundle)localObject1).getParcelableArrayList("PHOTO_LIST");
      this.mTroopUin = ((Bundle)localObject1).getString("troop_uin");
      if ((!this.cOD) || ((paramBundle != null) && (paramBundle.size() != 0))) {
        break;
      }
      finish();
      return true;
    }
    if ((!this.cOD) && (TextUtils.isEmpty(this.mTroopUin)))
    {
      finish();
      return true;
    }
    this.mIndex = ((Bundle)localObject1).getInt("index", -1);
    this.bFL = ((Bundle)localObject1).getInt("troop_auth_submit_time", 0);
    this.mSrcRect = ((Rect)((Bundle)localObject1).getParcelable("KEY_THUMBNAL_BOUND"));
    Object localObject2;
    if ((this.mSrcRect != null) && (ayxa.hasInitHasNotch) && (ayxa.sHasNotch))
    {
      int i = ayxa.getNotchInScreenHeight(this);
      localObject2 = this.mSrcRect;
      ((Rect)localObject2).top -= i;
      localObject2 = this.mSrcRect;
      ((Rect)localObject2).bottom -= i;
    }
    if (!this.cvT) {
      setTheme(2131756577);
    }
    this.mBackView = ((ImageView)findViewById(2131363222));
    this.mBackView.setVisibility(0);
    this.mBackView.setContentDescription(acfp.m(2131715564));
    this.mBackView.setOnClickListener(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject2 = getResources().getDrawable(2130840368);
      ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      this.mBackView.setImageDrawable((Drawable)localObject2);
    }
    dp((Bundle)localObject1);
    dq((Bundle)localObject1);
    dWP();
    if (!this.cOD) {
      if (this.cOC)
      {
        paramBundle = new ztd(this, this, this.app, this.mTroopUin);
        this.jdField_a_of_type_Ztd = paramBundle;
        this.jdField_a_of_type_Ztd.a(this);
        this.jdField_a_of_type_Ztd.Fx(this.bFL);
        this.jdField_a_of_type_Ztd.BU(false);
        this.jdField_a_of_type_Ztd.onItemSelect(this.mIndex);
        this.jdField_a_of_type_Ztd.a(this);
      }
    }
    for (;;)
    {
      dK(getIntent());
      return true;
      paramBundle = new zta(this, this, this.app, this.mTroopUin);
      break;
      localObject1 = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (TroopClipPic)paramBundle.next();
        if (localObject2 != null) {
          ((List)localObject1).add(zri.a((TroopClipPic)localObject2, null));
        }
      }
      if (this.jdField_a_of_type_Apvp != null)
      {
        this.jdField_a_of_type_Apvp.mU((List)localObject1);
        this.jdField_b_of_type_ComTencentWidgetGallery.setSelection(this.mIndex);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a.Wi(this.jdField_a_of_type_Apvp.getCount());
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$a.Wh(this.mIndex);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Apvp != null) {
      this.jdField_a_of_type_Apvp.onDestroy();
    }
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.onDestroy();
    }
    if (this.jdField_b_of_type_Ztd != null) {
      this.jdField_b_of_type_Ztd.onDestroy();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    dK(paramIntent);
  }
  
  public void e(zri paramzri)
  {
    if (this.cOC)
    {
      if ((paramzri.fromType == 1) && (!TextUtils.isEmpty(paramzri.baF)) && (apqw.isNumeric(paramzri.baF))) {
        this.df.add(paramzri.baF);
      }
      if (this.jdField_a_of_type_Ztd.dr().size() == 0) {
        finish();
      }
      cw(true, true);
      if (this.mIndex >= 0) {
        this.jdField_a_of_type_Ztd.onItemSelect(this.mIndex);
      }
    }
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.df.size() > 0) {
      localIntent.putStringArrayListExtra("key_del_pics", new ArrayList(this.df));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("finish delPics=%s", new Object[] { Arrays.toString(this.df.toArray()) }));
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user grant = ");
    if (VersionUtils.isM())
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (this.jdField_b_of_type_Yuy != null) && (this.jdField_b_of_type_Yuy.eP != null)) {
        this.jdField_b_of_type_Yuy.eP.run();
      }
    }
  }
  
  public void hO(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    localIntent.putExtra("report_params", rvx.a(null, paramString2, null, null, null, 7));
    startActivity(localIntent);
  }
  
  public boolean hq(int paramInt)
  {
    if ((this.cOE) && (paramInt == 0))
    {
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.13(this), null, true);
      return true;
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
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
      if (!aqiw.isNetSupport(this))
      {
        QQToast.a(this, getString(2131696348), 0).show(getResources().getDimensionPixelOffset(2131299627));
      }
      else
      {
        ausj localausj = (ausj)auss.a(this, null);
        localausj.addButton(2131694749, 3);
        localausj.addCancelButton(2131721058);
        localausj.a(new aotp(this, localausj));
        localausj.show();
        continue;
        if ((this.cOC) && (!this.cvT))
        {
          bZl();
          continue;
          finish();
          continue;
          this.jdField_a_of_type_Ztd.crH();
        }
      }
    }
  }
  
  public void onClickDragView()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onClickDragView", new Object[0]));
    }
    finish();
  }
  
  public void onContentMove(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onContentMove %.1f", new Object[] { Float.valueOf(paramFloat) }));
    }
    this.fP.setAlpha(paramFloat);
    this.mBackView.setVisibility(8);
    if (this.cOC) {
      this.kL.setVisibility(8);
    }
  }
  
  public void onDataSetChanged()
  {
    cw(true, true);
  }
  
  public void onGestureFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onGestureFinish");
    }
    finish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ztd == null) {}
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Aput.a(paramInt);
      if (paramAdapterView != null)
      {
        if (4 != paramAdapterView.fromType)
        {
          this.jdField_a_of_type_Ztd.onItemSelect(paramInt);
          return;
        }
        if (!aqiw.isNetSupport(this))
        {
          QQToast.a(this, getString(2131696348), 0).show(getResources().getDimensionPixelOffset(2131299627));
          return;
        }
        this.jdField_a_of_type_Ztd.crH();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troop_avatar_wall", 2, "avatarInfo = null, position=" + paramInt);
  }
  
  public void onItemSelect(int paramInt)
  {
    if (this.cOC)
    {
      if (this.jdField_b_of_type_ComTencentWidgetGallery.getSelectedItemPosition() != paramInt) {
        this.jdField_b_of_type_ComTencentWidgetGallery.setSelection(paramInt);
      }
      cw(false, true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      if ((this.cOC) && (!this.cvT)) {
        bZl();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    ivv.o(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResetPosition()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onResetPosition", new Object[0]));
    }
    if (this.cvT) {}
    do
    {
      return;
      this.fP.setAlpha(1.0F);
      this.mBackView.setVisibility(0);
    } while (!this.cOC);
    this.kL.setVisibility(0);
  }
  
  public void onResume()
  {
    super.onResume();
    ivv.o(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
  
  public static final class a
  {
    private Drawable cP;
    private Drawable cQ;
    LinearLayout.LayoutParams d;
    private LinearLayout mContainer;
    private Context mContext;
    
    a(@NonNull LinearLayout paramLinearLayout)
    {
      this.mContext = paramLinearLayout.getContext();
      this.mContainer = paramLinearLayout;
      this.cP = apuh.a(this.mContext.getResources(), Color.parseColor("#66ffffff"), this.mContext.getResources().getDrawable(2130844522));
      this.cQ = apuh.a(this.mContext.getResources(), Color.parseColor("#ffffffff"), this.mContext.getResources().getDrawable(2130844522));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        this.cP.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        this.cQ.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
      int i = ankt.dip2px(7.5F);
      this.d = new LinearLayout.LayoutParams(i, i);
      this.d.leftMargin = ankt.dip2px(7.0F);
    }
    
    public void Wh(int paramInt)
    {
      int j = this.mContainer.getChildCount();
      if ((paramInt < 0) || (paramInt >= j)) {
        return;
      }
      int i = 0;
      label20:
      View localView;
      if (i < j)
      {
        localView = this.mContainer.getChildAt(i);
        if (paramInt != i) {
          break label60;
        }
      }
      label60:
      for (Drawable localDrawable = this.cQ;; localDrawable = this.cP)
      {
        localView.setBackgroundDrawable(localDrawable);
        i += 1;
        break label20;
        break;
      }
    }
    
    void Wi(int paramInt)
    {
      if (this.mContainer.getChildCount() != paramInt)
      {
        this.mContainer.removeAllViews();
        while (paramInt > 0)
        {
          View localView = new View(this.mContext);
          localView.setLayoutParams(this.d);
          this.mContainer.addView(localView);
          paramInt -= 1;
        }
      }
      Wh(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */