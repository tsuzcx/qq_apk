package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.TextView;
import anfv;
import angp.a;
import anpc;
import aqiw;
import aurf;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.c;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kct;
import kql;
import kxm;
import lbz;
import lcc;
import lce;
import mjm;
import mjn;
import mjo;
import mkt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import noz;
import wja;

public class ReadInJoyDeliverVideoActivity
  extends ReadInJoyBaseDeliverActivity
  implements Handler.Callback, angp.a, ShortVideoResourceManager.c
{
  private Bundle C;
  private KandianUrlImageView M;
  private int aTw;
  private int aTx;
  private String ajg;
  private String ajh;
  private String aji;
  private String ajj;
  private boolean amS;
  private boolean amT;
  private boolean amW;
  private boolean amX;
  private boolean anb;
  private boolean ane = true;
  private boolean anf;
  private boolean ang;
  private boolean anh;
  private long appId;
  private CircleProgress jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress;
  private kql jdField_b_of_type_Kql;
  private PopupWindow c;
  lce h = new mjm(this);
  private List<ReadInJoyUgcVideoReportItem> ja;
  private ImageView jz;
  private View kV;
  private View kW;
  private View kX;
  private ArrayList<TagInfo> le = new ArrayList();
  private String mImagePath = "";
  private long mVideoDuration;
  private int mVideoHeight;
  private String mVideoPath;
  private int mVideoWidth;
  protected Dialog p;
  private TextView qL;
  private TextView qM;
  private TextView qN;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private long wc;
  private long we;
  private long wf;
  
  private void aPr()
  {
    this.jdField_b_of_type_Kql = new kql();
    this.jdField_b_of_type_Kql.a(new mjn(this));
    PublishParam localPublishParam = (PublishParam)getIntent().getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
    if (localPublishParam != null)
    {
      this.ajh = localPublishParam.fakeVid;
      this.jdField_b_of_type_Kql.bu(this.ajh, this.mVideoPath);
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: performCompositeVideo");
      return;
    }
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: publish param is null, no need to composite");
    this.qL.setVisibility(4);
    this.jz.setVisibility(0);
    this.kV.setClickable(true);
    lW(true);
  }
  
  private void aPs()
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      localObject = ShortVideoTrimmer.o(this.mVideoPath);
      if ((localObject != null) && (localObject.length == 5))
      {
        this.mVideoWidth = localObject[1];
        this.mVideoHeight = localObject[2];
        this.mVideoDuration = localObject[4];
        getIntent().putExtra("arg_video_width", this.mVideoWidth);
        getIntent().putExtra("arg_video_height", this.mVideoHeight);
        getIntent().putExtra("arg_video_duration", this.mVideoDuration);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverVideoActivity", 2, "generateVideoInfo width=" + this.mVideoWidth + ", height=" + this.mVideoHeight + ", duration=" + this.mVideoDuration);
        }
      }
    }
    if (TextUtils.isEmpty(this.ajg)) {
      if (this.mVideoDuration < 3000L) {
        break label251;
      }
    }
    label251:
    for (Object localObject = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath, 640, 3000000L);; localObject = ShortVideoUtils.getVideoThumbnail(this, this.mVideoPath, 640))
    {
      this.ajg = ShortVideoPreviewActivity.f((Bitmap)localObject);
      getIntent().putExtra("arg_video_cover", this.ajg);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "generateVideoInfo cover=" + this.ajg);
      }
      return;
    }
  }
  
  private void aPt()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.uiHandler.post(new ReadInJoyDeliverVideoActivity.6(this));
    }
    do
    {
      return;
      if (this.p == null) {
        this.p.setCanceledOnTouchOutside(false);
      }
    } while (this.p.isShowing());
    this.p.show();
  }
  
  private void aPu()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.uiHandler.post(new ReadInJoyDeliverVideoActivity.7(this));
    }
    while ((this.p == null) || (!this.p.isShowing())) {
      return;
    }
    this.p.dismiss();
  }
  
  private void aPv()
  {
    this.anf = VideoEnvironment.p(this.app);
    this.ang = VideoEnvironment.r(this.app);
    if (!this.anf) {}
    do
    {
      return;
      if (this.ang)
      {
        VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
        return;
      }
      VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    } while (!aqiw.isNetworkAvailable(null));
    ShortVideoResourceManager.b(this.app, this);
    this.amX = true;
  }
  
  private void aPw()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.N.getWindowToken(), 0);
    }
  }
  
  private void aPx()
  {
    this.qN = ((TextView)findViewById(2131364129));
    this.qN.setOnClickListener(this);
    this.c = new PopupWindow(LayoutInflater.from(this).inflate(2131560498, (ViewGroup)this.mContentView, false), -2, -2);
    this.c.setAnimationStyle(2131755551);
    this.ane = true;
  }
  
  private void aPy()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", this.le);
    localIntent.putExtra("EXTRA_TOPIC_ID", this.Zm);
    PublicFragmentActivity.startForResult(this, localIntent, ReadInJoyVideoTagSelectionFragment.class, 1000);
    kbp.a(null, "", "0X80092F1", "0X80092F1", 0, 0, "", "", "", kxm.iS(), false);
  }
  
  private void bT(ArrayList<TagInfo> paramArrayList)
  {
    this.le = paramArrayList;
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder.append(paramArrayList.get(0));
      int j = paramArrayList.size();
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append("，").append(paramArrayList.get(i));
        i += 1;
      }
      paramArrayList = localStringBuilder.toString();
      this.qN.setSelected(true);
    }
    for (;;)
    {
      this.qN.setText(paramArrayList);
      return;
      this.qN.setSelected(false);
      paramArrayList = str;
    }
  }
  
  private Intent m()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("arg_video_path", this.mVideoPath);
    localIntent.putExtra("arg_video_cover", this.mImagePath);
    localIntent.putExtra("supportShortVideo", this.anf);
    localIntent.putExtra("shortVideoSoReady", this.ang);
    localIntent.putExtra("commentString", ii());
    localIntent.putExtra("mFakeVidForComposition", this.ajh);
    localIntent.putParcelableArrayListExtra("mSelectedTagList", this.le);
    localIntent.putExtra("arg_visible_set_params", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam);
    if (this.amS)
    {
      localIntent.putExtra("arg_video_cover", this.ajg);
      localIntent.putExtras(this.C);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
      localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
    Bundle localBundle = localIntent.getExtras();
    localIntent.setClass(getApplicationContext(), KandianVideoUploadService.class);
    ArrayList localArrayList = new ArrayList();
    mkt.a(this.N, this.app.getCurrentAccountUin(), this.afl, localArrayList);
    if (localBundle != null) {
      localBundle.putParcelableArrayList("multiBiuStruct", localArrayList);
    }
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void nE(String paramString)
  {
    Intent localIntent = new Intent(this, ShortVideoPreviewActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyDeliverVideoActivity.class.getName());
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_only", true);
    startActivity(localIntent);
    overridePendingTransition(2130772360, 2130772362);
    kbp.a(this.app, "", "0X80081D9", "0X80081D9", 0, 0, "", "2", "", kct.d(null), false);
  }
  
  private void nF(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover url is null");
      return;
    }
    noz localnoz = new noz();
    try
    {
      localnoz.url = new URL(paramString);
      localnoz.reqHeight = this.M.getHeight();
      localnoz.reqWidth = this.M.getWidth();
      this.M.setImageForImageCollection(localnoz, new mjo(this));
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private int pt()
  {
    if (TextUtils.isEmpty(ii())) {
      return 1;
    }
    return 2;
  }
  
  public void aCT()
  {
    super.aCT();
    kbp.a(null, "", "0X8008243", "0X8008243", 0, 0, String.valueOf(pt()), "", "", kxm.iS(), false);
  }
  
  public void aCV()
  {
    this.mFrom = 2;
    super.aCV();
    kbp.a(null, "", "0X8009577", "0X8009577", 0, 0, "", "", "", kxm.iS(), false);
  }
  
  public void aCW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onEmotionBtn!");
    }
    kbp.a(null, "", "0X8008244", "0X8008244", 0, 0, "", "", "", kxm.iS(), false);
    super.aCW();
  }
  
  public void aFW()
  {
    anfv.jw(3, -1500);
    this.amX = false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    int i = paramEditable.length();
    if (this.nS != null) {
      this.nS.setText(String.valueOf(this.aIM - i));
    }
    if (i - this.aIM > 0)
    {
      if (this.nS != null) {
        this.nS.setTextColor(Color.parseColor("#FF4222"));
      }
      this.afa = true;
      return;
    }
    if (this.nS != null) {
      this.nS.setTextColor(Color.parseColor("#BBBBBB"));
    }
    this.afa = false;
  }
  
  public void cu(int paramInt1, int paramInt2)
  {
    VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        anfv.jw(1, paramInt2);
        this.amX = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        return;
      }
      anfv.jw(1, paramInt1);
      this.amX = false;
      return;
    }
    anfv.jw(1, paramInt2);
    this.amX = false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.we = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    super.setContentView(2131560349);
    initViews();
    initData();
    aPr();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    lcc.a().c(this.h);
    this.uiHandler.removeCallbacksAndMessages(null);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    this.wf = System.currentTimeMillis();
    anpc.a(this).collectPerformance(getAppRuntime().getAccount(), "actReadInJoyEnterVideoDeliverPage", true, this.wf - this.we, 0L, null, "");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void f(String paramString, long paramLong1, long paramLong2) {}
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_Kql != null) {
      this.jdField_b_of_type_Kql.a(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void initData()
  {
    this.afi = true;
    this.afk = true;
    this.afl = true;
    this.aff = true;
    super.initData();
    this.Zp = "0X800865E";
    Object localObject = getIntent();
    this.mVideoPath = ((Intent)localObject).getStringExtra("arg_video_path");
    this.ajg = ((Intent)localObject).getStringExtra("arg_video_cover");
    this.mVideoWidth = ((Intent)localObject).getIntExtra("arg_video_width", 0);
    this.mVideoHeight = ((Intent)localObject).getIntExtra("arg_video_height", 0);
    this.mVideoDuration = ((Intent)localObject).getLongExtra("arg_video_duration", 0L);
    this.amS = ((Intent)localObject).getBooleanExtra("arg_is_from_wang_zhe", false);
    this.appId = ((Intent)localObject).getLongExtra("arg_wang_zhe_app_id", 0L);
    this.amT = ((Intent)localObject).getBooleanExtra("is_from_dian_dian", false);
    this.amW = ((Intent)localObject).getBooleanExtra("is_from_kan_dian", false);
    this.ajj = ((Intent)localObject).getStringExtra("captureMode");
    this.ja = ((Intent)localObject).getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
    lcc.a().b(this.h);
    aPs();
    me(this.ajg);
    int i = ((Intent)localObject).getIntExtra("arg_video_source", 0);
    if (TextUtils.isEmpty(this.Zm))
    {
      localObject = "0";
      if (!this.amT) {
        break label316;
      }
    }
    label316:
    for (String str = "1";; str = "2")
    {
      kbp.a(null, "", "0X8008241", "0X8008241", 0, 0, String.valueOf(i), (String)localObject, str, kxm.iS(), false);
      this.afe = true;
      if ((!this.afe) && (this.hZ != null)) {
        this.hZ.setVisibility(8);
      }
      if (this.amS)
      {
        setRightViewTextDisable(0);
        this.uiHandler.postDelayed(new ReadInJoyDeliverVideoActivity.3(this), 30000L);
      }
      aPv();
      return;
      localObject = String.valueOf(this.Zm);
      break;
    }
  }
  
  public void initViews()
  {
    this.aIO = 178;
    super.initViews();
    this.kV = findViewById(2131381194);
    this.kV.setOnClickListener(this);
    this.kV.setClickable(false);
    this.M = ((KandianUrlImageView)findViewById(2131381195));
    this.jz = ((ImageView)findViewById(2131381196));
    this.qL = ((TextView)findViewById(2131381193));
    this.kX = new View(this);
    this.kX.setBackgroundColor(1996488704);
    addContentView(this.kX, new ViewGroup.LayoutParams(-1, -1));
    this.kX.setVisibility(8);
    this.kW = View.inflate(this, 2131560504, null);
    addContentView(this.kW, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.kW.findViewById(2131381296));
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(5.0F);
    this.jdField_b_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, -1, 100, getResources().getColor(2131167145));
    this.qM = ((TextView)this.kW.findViewById(2131364235));
    this.qM.setOnClickListener(this);
    aPx();
  }
  
  public void lX(boolean paramBoolean)
  {
    super.lX(paramBoolean);
    if (this.kW.getVisibility() == 0) {
      aPt();
    }
  }
  
  public void lY(boolean paramBoolean)
  {
    super.lY(paramBoolean);
    if (this.kW.getVisibility() == 0) {
      aPt();
    }
  }
  
  public void me(String paramString)
  {
    int j = 1;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      this.mImagePath = paramString;
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mImagePath, (BitmapFactory.Options)localObject);
      int i = wja.dp2px(110.0F, getResources());
      int k = wja.dp2px(110.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / k;
      this.aTw = ((BitmapFactory.Options)localObject).outWidth;
      this.aTx = ((BitmapFactory.Options)localObject).outHeight;
      getIntent().putExtra("arg_video_cover_width", this.aTw);
      getIntent().putExtra("arg_video_cover_height", this.aTx);
      i = j;
      if (f1 >= 1.0F)
      {
        i = j;
        if (f2 >= 1.0F) {
          i = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = BitmapFactory.decodeFile(this.mImagePath, (BitmapFactory.Options)localObject);
        localObject = rotaingImageView(U(this.mImagePath), (Bitmap)localObject);
        this.M.setImageBitmap((Bitmap)localObject);
        this.M.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverVideoActivity", 2, "setSelectedImage sampleSize=" + i + ", path=" + paramString);
        }
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        this.M.setImageDrawable(new ColorDrawable(-16777216));
        this.M.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
    }
    this.M.setImageDrawable(new ColorDrawable(-16777216));
    this.M.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void o(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label72;
      }
      anfv.jw(2, paramInt);
    }
    for (;;)
    {
      this.amX = false;
      VideoEnvironment.k("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label72:
      this.ang = true;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      bT(paramIntent.getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST"));
    }
  }
  
  public boolean onBackEvent()
  {
    if (!this.anb)
    {
      if ((this.amS) && (!this.anh)) {
        return super.onBackEvent();
      }
      a(false, 0, this.amS, this.appId);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCancel()
  {
    super.onCancel();
    kbp.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "2", "2", "", kct.d(null), false);
    kbp.a(null, "", "0X8008242", "0X8008242", 0, 0, String.valueOf(pt()), "", "", kxm.iS(), false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.amS)
      {
        nE(this.mVideoPath);
        continue;
        this.uiHandler.sendEmptyMessage(103);
        kbp.a(this.app, "", "0X80081DA", "0X80081DA", 0, 0, "", "", "", kct.d(null), false);
        continue;
        aPy();
      }
    }
  }
  
  public boolean zp()
  {
    this.wc = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver!");
    }
    kbp.a(this.app, "", "0X80081D8", "0X80081D8", 0, 0, "1", "2", "", kct.d(null), false);
    kbp.a(null, "", "0X8008245", "0X8008245", 0, 0, String.valueOf(pt()), "", "", ih(), false);
    if ((this.mImagePath.equals("")) && (!this.amS)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliver no video!");
      }
    }
    do
    {
      do
      {
        return false;
      } while (!super.zp());
      aPw();
    } while (KandianVideoUploadService.pj() >= 2);
    Intent localIntent = m();
    try
    {
      startService(localIntent);
      QLog.d("ReadInJoyDeliverVideoActivity", 1, "start video upload Service!");
      label156:
      if (this.amW) {
        KandianSubscribeManager.P(this, 4);
      }
      for (;;)
      {
        finish();
        return true;
        lbz.a().mY(true);
      }
    }
    catch (Throwable localThrowable)
    {
      break label156;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity
 * JD-Core Version:    0.7.0.1
 */