package com.tencent.mobileqq.ocr.activity;

import acfp;
import akmz;
import akmz.a;
import akne;
import akne.a;
import aknn;
import akno;
import aknp;
import aknq;
import aknr;
import akns;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aqfy;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.QQPermissionGrant;
import wja;

public class ScanOcrActivity
  extends ScanBaseActivity
  implements View.OnClickListener
{
  private ImageView BU;
  private View Fu;
  private TextView QI;
  private TextView QJ;
  public akmz.a a;
  private akmz jdField_a_of_type_Akmz;
  private akne jdField_a_of_type_Akne;
  private a jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a;
  public MaskView a;
  private ScanOcrView jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView;
  private long adX;
  private String bTW;
  private String bTX;
  private String bTY;
  akne.a jdField_c_of_type_Akne$a = new akns(this);
  private ScanSuccessView jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView;
  private volatile boolean cth;
  private volatile boolean cti;
  public boolean ctj;
  private boolean ctk;
  private boolean ctl;
  private int dnN;
  public int dnO = 0;
  private View.OnClickListener fy = new aknp(this);
  private View hY;
  private View.OnTouchListener j = new akno(this);
  private ImageView mCloseBtn;
  private int mFrom;
  private boolean mIsPause;
  private ViewGroup mRootView;
  public String mSrc;
  SurfaceHolder.Callback mSurfaceCallback = new aknr(this);
  private SurfaceHolder mSurfaceHolder;
  private SurfaceView mSurfaceView;
  public String mType;
  private TextView ni;
  private ImageView vh;
  
  public ScanOcrActivity()
  {
    this.jdField_a_of_type_Akmz$a = new aknq(this);
  }
  
  private void LA()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, "initCameraView");
    }
    this.mSurfaceView = new SurfaceView(this);
    this.mSurfaceView.getHolder().addCallback(this.mSurfaceCallback);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mRootView.addView(this.mSurfaceView, 0, localLayoutParams);
  }
  
  private void MU(boolean paramBoolean)
  {
    this.cth = false;
    this.dnN = 0;
    this.hY.setVisibility(0);
    this.Fu.setVisibility(0);
    this.vh.setVisibility(4);
    if (this.dnO != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.stopScan();
      dCo();
      if (!paramBoolean)
      {
        if (this.mSurfaceView != null) {
          break label102;
        }
        LA();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "enterScanModel");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(false);
      break;
      label102:
      if ((this.jdField_a_of_type_Akmz != null) && (this.ctl))
      {
        this.jdField_a_of_type_Akmz.open();
        this.jdField_a_of_type_Akne.start();
      }
    }
  }
  
  private void b(int paramInt, OcrRecogResult paramOcrRecogResult, String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a = null;
    this.bTY = null;
    this.cth = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.ScanOcrActivity", 2, "dealOcrResult ocrResult: " + paramOcrRecogResult);
    }
    if ((paramInt == 0) && (paramOcrRecogResult != null) && (!paramOcrRecogResult.isEmpty()) && ((this.dnO != 1) || ((!TextUtils.isEmpty(paramOcrRecogResult.ocrContent)) && (!TextUtils.isEmpty(paramOcrRecogResult.ocrContent.trim())))))
    {
      a(paramOcrRecogResult, paramString);
      anot.a(null, "dc00898", "", "", "0X80082CC", "0X80082CC", 0, 0, "", "", "", "");
      if (this.dnO == 1) {
        anot.a(null, "dc00898", "", "", "0X8008A1F", "0X8008A1F", 0, 0, "", "", "", "");
      }
      dCo();
      ThreadManager.post(new ScanOcrActivity.9(this, paramInt), 5, null, false);
      if (paramLong > 0L)
      {
        if (this.mFrom != 1) {
          break label432;
        }
        anot.a(null, "dc00898", "", "", "0X80082E5", "0X80082E5", 0, 0, String.valueOf(paramLong), "", "", "");
      }
    }
    label265:
    label425:
    label432:
    while (this.mFrom != 0)
    {
      return;
      if (this.dnO == 1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701456, 0).show();
        if ((this.mFrom != 0) && (this.mFrom != 4)) {
          break label425;
        }
        MU(false);
      }
      for (;;)
      {
        anot.a(null, "dc00898", "", "", "0X80082CA", "0X80082CA", 0, 0, "", "", "", "");
        if (this.dnO != 1) {
          break;
        }
        anot.a(null, "dc00898", "", "", "0X8008A20", "0X8008A20", 0, 0, "", "", "", "");
        break;
        if (paramInt == 1)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701453, 0).show();
          break label265;
        }
        if (paramInt == 0)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701455, 0).show();
          break label265;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701451, 0).show();
        break label265;
        finish();
      }
    }
    anot.a(null, "dc00898", "", "", "0X80082E4", "0X80082E4", 0, 0, String.valueOf(paramLong), "", "", "");
  }
  
  private void cD(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.cth)
        {
          QLog.d("Q.ocr.ScanOcrActivity", 1, "recogPic is inRecog picPath:" + paramString + ",isCrop:" + paramBoolean);
          return;
        }
        if (aqiw.isNetSupport(this))
        {
          this.mRootView.postDelayed(new ScanOcrActivity.4(this), 200L);
          this.cth = true;
          this.bTY = paramString;
          this.cti = paramBoolean;
          akne localakne = this.jdField_a_of_type_Akne;
          if (!paramBoolean) {
            bool = true;
          }
          localakne.cD(paramString, bool);
          if (this.mFrom == 1) {
            anot.a(null, "dc00898", "", "", "0X80082C8", "0X80082C8", 0, 0, "", "", "", "");
          }
        }
        else
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701459, 0).show();
        }
      }
      finally {}
    }
  }
  
  private void dCn()
  {
    if (!this.cth) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this);
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      if (this.dnO == 1) {
        break label219;
      }
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(acfp.m(2131714003));
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ankt.SCREEN_WIDTH);
      this.mRootView.addView(this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      if (this.mCloseBtn != null) {
        break;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(40.0F, getResources()), wja.dp2px(40.0F, getResources()));
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = wja.dp2px(40.0F, getResources());
      this.mCloseBtn = new ImageView(this);
      this.mCloseBtn.setImageResource(2130846493);
      this.mCloseBtn.setOnClickListener(this.fy);
      this.mCloseBtn.setContentDescription(getString(2131721058));
      this.mRootView.addView(this.mCloseBtn, localLayoutParams);
      return;
      label219:
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(acfp.m(2131714005));
    }
  }
  
  private void dCo()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      this.mRootView.removeView(this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_c_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    if (this.mCloseBtn != null)
    {
      this.mRootView.removeView(this.mCloseBtn);
      this.mCloseBtn = null;
    }
  }
  
  private void n(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramBoolean1))
    {
      QLog.d("Q.ocr.ScanOcrActivity", 1, "enterPreviewModel picPath:" + paramString + ",isFromCamera:" + paramBoolean1 + ",model:" + this.dnN);
      return;
    }
    this.dnN = 1;
    this.hY.setVisibility(4);
    this.Fu.setVisibility(4);
    this.ni.setVisibility(4);
    if (this.dnO != 1) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.stopScan();
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Akmz != null) {
        this.jdField_a_of_type_Akmz.stopPreview();
      }
      this.adX = System.currentTimeMillis();
      if (this.dnO != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.dCt();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.dCv();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.dCu();
        this.vh.postDelayed(new ScanOcrActivity.3(this), 600L);
      }
      label178:
      while (QLog.isColorLevel())
      {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "enterPreviewModel isFromCamera:" + paramBoolean1 + ",isCrop:" + paramBoolean2 + ",picPath:" + paramString);
        return;
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setModel(true);
      }
    }
    if (this.dnO != 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.setVisibility(4);
      label258:
      if (!this.ctk) {
        break label293;
      }
      this.vh.setVisibility(4);
    }
    for (;;)
    {
      cD(paramString, paramBoolean2);
      break label178;
      break;
      this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(4);
      break label258;
      label293:
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      this.vh.setVisibility(0);
      this.vh.setImageDrawable((Drawable)localObject);
    }
  }
  
  public void a(OcrRecogResult paramOcrRecogResult, String paramString)
  {
    if (this.dnO != 1) {
      return;
    }
    getIntent().putExtra("ocr_result", paramOcrRecogResult.ocrContent);
    getIntent().putExtra("ret_code", 0);
    setResult(-1, getIntent());
    finish();
    overridePendingTransition(0, 2130772013);
  }
  
  public void dCm()
  {
    if ((this.jdField_a_of_type_Akmz != null) && (this.dnN == 0))
    {
      if ((this.jdField_a_of_type_Akmz.asc()) && (this.dnO != 1)) {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.stopScan();
      }
      if (this.dnO == 1) {
        anot.a(null, "dc00898", "", "", "0X8008A1D", "0X8008A1D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      String str = null;
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("ocr_pic_path");
      }
      this.jdField_a_of_type_Akne.start();
      if (!TextUtils.isEmpty(str)) {
        n(str, false, true);
      }
    }
    else
    {
      return;
    }
    if ((this.mFrom == 0) || (this.mFrom == 4))
    {
      MU(false);
      return;
    }
    finish();
  }
  
  public void doOnBackPressed()
  {
    if ((this.dnN == 1) && ((this.mFrom == 0) || (this.mFrom == 4)))
    {
      this.jdField_a_of_type_Akne.dCk();
      MU(false);
      dCo();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.ctk = getIntent().getBooleanExtra("no_preview_model", false);
    if (!this.ctk) {
      setTheme(2131755346);
    }
    getWindow().addFlags(128);
    setContentView(2131561518);
    tP();
    this.mRootView = ((ViewGroup)findViewById(2131377546));
    this.ni = ((TextView)findViewById(2131379752));
    this.vh = ((ImageView)findViewById(2131373571));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView = ((ScanOcrView)findViewById(2131377679));
    this.Fu = findViewById(2131365420);
    this.hY = findViewById(2131379786);
    this.QI = ((TextView)findViewById(2131369579));
    this.QJ = ((TextView)findViewById(2131369561));
    this.BU = ((ImageView)findViewById(2131379247));
    this.QJ.setOnClickListener(this);
    this.QI.setOnClickListener(this);
    this.QJ.setOnTouchListener(this.j);
    this.BU.setOnClickListener(this);
    this.BU.setOnTouchListener(this.j);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView = ((MaskView)findViewById(2131371173));
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips))) {}
    String str;
    for (this.bTW = this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.tips;; this.bTW = getResources().getString(2131701461))
    {
      str = getIntent().getStringExtra("ocr_pic_path");
      this.mFrom = getIntent().getIntExtra("ocr_from_where", -1);
      this.jdField_a_of_type_Akne = new akne(this.app, this.jdField_c_of_type_Akne$a, this.mFrom);
      this.jdField_a_of_type_Akne.start();
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.ScanOcrActivity", 2, "onCreate imagePath:" + str + ",from:" + this.mFrom);
      }
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, acfp.m(2131714006), 0).show();
      finish();
      return true;
    }
    if (this.mFrom == 4)
    {
      this.ctj = getIntent().getBooleanExtra("scanForResult", false);
      this.mSrc = getIntent().getStringExtra("src");
      this.mType = getIntent().getStringExtra("type");
      if (this.ctj)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setIsDisplayRect(true);
        this.dnO = 1;
        this.ni = ((TextView)findViewById(2131379753));
        this.bTW = getResources().getString(2131701462);
        paramBundle = (RelativeLayout.LayoutParams)this.ni.getLayoutParams();
        paramBundle.topMargin = this.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.getPreviewRect().bottom;
        this.ni.setLayoutParams(paramBundle);
        this.mTitleText.setText(2131719029);
      }
      if (TextUtils.isEmpty(this.mSrc))
      {
        paramBundle = "";
        anot.a(null, "dc00898", "", "", "0X8008A1C", "0X8008A1C", 0, 0, "", "", paramBundle, "");
      }
    }
    else
    {
      if ((this.mFrom != 1) && (this.mFrom != 2) && (this.mFrom != 3)) {
        break label717;
      }
      if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
        break label695;
      }
      n(str, false, false);
    }
    for (;;)
    {
      if (this.ctk)
      {
        this.mRootView.setBackgroundColor(0);
        this.vh.setVisibility(4);
      }
      return true;
      paramBundle = this.mSrc;
      break;
      label695:
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131701454, 0).show();
      finish();
      continue;
      label717:
      requestPermissions(new aknn(this), 1, new String[] { "android.permission.CAMERA" });
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Akne != null) {
      this.jdField_a_of_type_Akne.stop();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.ScanOcrActivity", 2, String.format("doOnNewIntent filePath=%s", new Object[] { paramIntent }));
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      this.bTX = paramIntent;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Akmz != null)
    {
      this.jdField_a_of_type_Akmz.stopPreview();
      this.jdField_a_of_type_Akmz.close();
    }
    this.mIsPause = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!TextUtils.isEmpty(this.bTX))
    {
      n(this.bTX, false, false);
      this.bTX = null;
      if (this.dnO == 1) {
        anot.a(null, "dc00898", "", "", "0X8008A1E", "0X8008A1E", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_Akne.start();
    if (this.dnN == 0) {
      if (this.mSurfaceView == null) {
        LA();
      }
    }
    label264:
    for (;;)
    {
      this.mIsPause = false;
      return;
      if ((this.jdField_a_of_type_Akmz != null) && (this.ctl))
      {
        this.jdField_a_of_type_Akmz.open();
        continue;
        if ((!TextUtils.isEmpty(this.bTY)) && (this.cth) && (this.mIsPause))
        {
          if (this.ctk) {
            this.vh.setVisibility(4);
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a == null) || (!this.bTY.equals(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a.imagePath))) {
              break label264;
            }
            b(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a.errCode, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a.d, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a.imagePath, this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$a.costTime);
            break;
            Object localObject = URLDrawable.URLDrawableOptions.obtain();
            localObject = URLDrawable.getDrawable(new File(this.bTY), (URLDrawable.URLDrawableOptions)localObject);
            ((URLDrawable)localObject).downloadImediatly();
            this.vh.setImageDrawable((Drawable)localObject);
            this.vh.setVisibility(0);
          }
        }
      }
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.ctl = true;
    MU(true);
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
      doOnBackPressed();
      continue;
      Intent localIntent = new Intent();
      localIntent.setClass(this, NewPhotoListActivity.class);
      localIntent.putExtra("enter_from", 49);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanOcrActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
      startActivity(localIntent);
      aqfy.anim(this, false, true);
      continue;
      dCm();
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QLog.i("Q.ocr.ScanOcrActivity", 2, "onMultiWindowModeChanged" + paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131714004), 0).show();
      finish();
    }
  }
  
  public static class a
  {
    public long costTime;
    public OcrRecogResult d;
    public int errCode;
    public String imagePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity
 * JD-Core Version:    0.7.0.1
 */