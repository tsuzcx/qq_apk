package com.tencent.mobileqq.activity.shortvideo;

import aaqi;
import aazf;
import aazg;
import ambj;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import anff;
import anfr;
import angi;
import angt;
import aniq;
import anjo;
import aojn;
import aont;
import aonu;
import aooi;
import aqha;
import aqhq;
import aqhs;
import aqju;
import aqoi;
import aurf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import ylm;

public class SendVideoActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static aurf d;
  
  public static void cY(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      aniq.dFI = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      aniq.dFJ = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      aniq.dFK = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      aniq.dFL = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      aniq.dFM = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      aniq.dFN = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      aniq.dFO = i;
    }
    aniq.dHo = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    aniq.dHp = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    aniq.dHq = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    aniq.dHr = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    aniq.dHs = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    aniq.PV(paramIntent.getBooleanExtra("sv_encode_baseline_mp4", false));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("file_send_business_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "doOnCreate(), ===>> busiType=" + i + ",VideoFileDir = " + getIntent().getStringExtra("file_video_source_dir"));
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
      }
      return true;
      new b(this, null).execute(new Void[0]);
      continue;
      paramBundle = getIntent().getStringExtra("activity_before_enter_send_video");
      if ((paramBundle != null) && (ShortVideoPreviewActivity.class.getName().equals(paramBundle)))
      {
        new a(this).execute(new Void[0]);
      }
      else
      {
        ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
        if (getIntent().getIntExtra("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
        {
          int j = getIntent().getIntExtra("uintype", -1);
          i = 3;
          if (j == 1) {
            i = 1;
          }
          for (;;)
          {
            aaqi.ao("", "0X80088E4", String.valueOf(i));
            anjo.R(this.app, false);
            break;
            if (j == 3000) {
              i = 2;
            }
          }
          paramBundle = getIntent().getStringExtra("uin");
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate, uin= " + paramBundle);
          }
          if ((paramBundle != null) && (paramBundle.equals("0")))
          {
            j = getIntent().getIntExtra("uintype", -1);
            if (j != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SendVideoActivity", 2, "doOnCreate error, uinType= " + j + " busiType= " + i);
              }
              finish();
            }
            else
            {
              d = new aurf(this);
              d.sendEmptyMessageDelayed(1, 45000L);
            }
          }
          else
          {
            ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
            continue;
            ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
          }
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (d != null) {
      d.removeMessages(1);
    }
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
        QLog.i("SendVideoActivity", 2, "handleMessage: send video timeout!");
      }
      paramMessage = ((ylm)getAppInterface().getManager(138)).a();
      if (paramMessage != null)
      {
        aqoi localaqoi = this.app.a().a(paramMessage.frienduin, paramMessage.uniseq);
        if ((localaqoi != null) && (aonu.class.isInstance(localaqoi)))
        {
          boolean bool = ((aojn)localaqoi).isPause();
          int i = paramMessage.videoFileStatus;
          if ((bool) || (i == 1002) || (i == 1001)) {
            this.app.a().B(paramMessage.frienduin, paramMessage.uniseq);
          }
        }
      }
    }
  }
  
  static class SendTask
    implements Runnable
  {
    Intent Q;
    boolean btc;
    BaseActivity mActivity;
    
    public SendTask(BaseActivity paramBaseActivity, Intent paramIntent)
    {
      this.mActivity = paramBaseActivity;
      if (paramIntent != null) {}
      for (this.Q = paramIntent;; this.Q = this.mActivity.getIntent())
      {
        this.btc = this.Q.getExtras().getBoolean("send_in_background");
        return;
      }
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): start");
      }
      SendVideoActivity.cY(this.Q);
      aniq.dHk = this.Q.getIntExtra("sv_total_frame_count", 0);
      aniq.bQi = this.Q.getIntExtra("sv_total_record_time", 0);
      long l1 = this.Q.getLongExtra("ab_test_send_btn_click_time", 0L);
      long l2 = this.Q.getLongExtra("ab_test_generate_thumb_cost_time", 0L);
      if (aont.aAm())
      {
        aont.aqk = l1;
        aont.aql = aniq.bQi;
        aont.aqm = l2;
      }
      aonr.aqj = l1;
      String str = this.Q.getStringExtra("thumbfile_send_path");
      if (aqhq.fileExistsAndNotEmpty(str))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        if (((URLDrawable)localObject).getStatus() == 1) {
          this.mActivity.runOnUiThread(new SendVideoActivity.SendTask.1(this));
        }
      }
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "#SendTask# run(): UrlDrawable status not success, path=" + str);
          }
        } while (this.btc);
        this.mActivity.runOnUiThread(new SendVideoActivity.SendTask.2(this));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "#SendTask# run(): thumb not exist, path=" + str);
        }
      } while (this.btc);
      this.mActivity.runOnUiThread(new SendVideoActivity.SendTask.3(this));
    }
  }
  
  public static class SendVideoInfo
    implements Serializable
  {
    public long duration;
    public long fileSize;
  }
  
  public static class a
    extends AsyncTask<Void, Void, Integer>
  {
    String aIf;
    String bN;
    String beJ;
    String beK;
    ProgressDialog e;
    int gP;
    WeakReference<BaseActivity> mActivity;
    long mDuration;
    int mThumbWidth;
    String mUin;
    int mUinType;
    String mVideoMd5;
    String mVideoPath;
    long mVideoSize;
    TextView yw;
    
    public a(BaseActivity paramBaseActivity)
    {
      this.mActivity = new WeakReference(paramBaseActivity);
      paramBaseActivity = paramBaseActivity.getIntent();
      this.mVideoPath = paramBaseActivity.getExtras().getString("file_send_path");
      this.mDuration = paramBaseActivity.getExtras().getLong("file_send_duration");
      this.mVideoSize = paramBaseActivity.getExtras().getLong("file_send_size");
      this.mUin = paramBaseActivity.getExtras().getString("uin");
      this.mUinType = paramBaseActivity.getIntExtra("uintype", -1);
      this.beK = paramBaseActivity.getStringExtra("file_source");
      this.mVideoMd5 = paramBaseActivity.getExtras().getString("file_shortvideo_md5");
      this.beJ = paramBaseActivity.getExtras().getString("activity_before_enter_send_video");
      this.aIf = paramBaseActivity.getExtras().getString("thumbfile_md5");
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, " SendAppShortVideoTask(),  mVideoPath :" + this.mVideoPath + ", mDuration:" + this.mDuration + ", mFileSize:" + this.mVideoSize + ",mUin" + this.mUin + ",mUinType:" + this.mUinType + ",mFileSource:" + this.beK);
      }
    }
    
    public static void ag(Context paramContext, int paramInt)
    {
      aqha.a(paramContext, 232, null, paramContext.getString(paramInt), new aazf(paramContext), null).show();
    }
    
    void U(Context paramContext, int paramInt)
    {
      try
      {
        if (this.e != null) {
          cancleProgressDailog();
        }
        for (;;)
        {
          this.yw.setText(paramInt);
          if (this.e.isShowing()) {
            break;
          }
          this.e.show();
          return;
          this.e = new ReportProgressDialog(paramContext, 2131756467);
          this.e.setCancelable(true);
          this.e.show();
          this.e.setContentView(2131559761);
          this.yw = ((TextView)this.e.findViewById(2131373180));
        }
        return;
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
        }
      }
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      return Integer.valueOf(zt());
    }
    
    void cancleProgressDailog()
    {
      try
      {
        if (this.e != null) {
          this.e.cancel();
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      if (this.mActivity.get() == null) {
        return;
      }
      cancleProgressDailog();
      switch (paramInteger.intValue())
      {
      default: 
        return;
      case 1: 
        paramInteger = ((BaseActivity)this.mActivity.get()).getIntent();
        paramInteger.putExtra("uin", this.mUin);
        paramInteger.putExtra("uintype", this.mUinType);
        paramInteger.putExtra("file_send_path", this.mVideoPath);
        paramInteger.putExtra("file_send_size", this.mVideoSize);
        paramInteger.putExtra("file_send_duration", (int)(this.mDuration / 1000L));
        paramInteger.putExtra("file_source", this.beK);
        paramInteger.putExtra("thumbfile_send_path", this.bN);
        paramInteger.putExtra("file_shortvideo_md5", this.mVideoMd5);
        paramInteger.putExtra("thumbfile_send_width", this.mThumbWidth);
        paramInteger.putExtra("thumbfile_send_height", this.gP);
        paramInteger.putExtra("thumbfile_md5", this.aIf);
        paramInteger.putExtra("file_send_business_type", 2);
        Object localObject2 = anfr.a(0, 2);
        Object localObject1 = anfr.a(2, paramInteger, (angi)localObject2);
        ((angi)localObject2).c((angt)localObject1);
        localObject2 = new anff(((BaseActivity)this.mActivity.get()).app);
        localObject1 = ((anff)localObject2).a((angt)localObject1);
        ((anff)localObject2).ar((MessageRecord)localObject1);
        localObject2 = (MessageForShortVideo)localObject1;
        localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject2).md5, ((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq, "mp4");
        aqhq.copyFile(this.mVideoPath, (String)localObject2);
        localObject2 = anfr.a(0, 2);
        localObject1 = anfr.a(localObject1, (angi)localObject2);
        ((angt)localObject1).cFz = false;
        ((angi)localObject2).c((angt)localObject1);
        anfr.a((angi)localObject2, ((BaseActivity)this.mActivity.get()).app);
        localObject1 = ((BaseActivity)this.mActivity.get()).getIntent();
        if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
        {
          localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          paramInteger.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "SendAppShortVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
          }
          paramInteger.addFlags(603979776);
          ((BaseActivity)this.mActivity.get()).startActivity(paramInteger);
        }
        ((BaseActivity)this.mActivity.get()).finish();
        ((BaseActivity)this.mActivity.get()).overridePendingTransition(0, 2130771992);
        return;
      case 2: 
      case 6: 
        ag((Context)this.mActivity.get(), 2131720284);
        return;
      case 3: 
        ag((Context)this.mActivity.get(), 2131720279);
        return;
      case 4: 
        ag((Context)this.mActivity.get(), 2131720249);
        return;
      }
      ag((Context)this.mActivity.get(), 2131720276);
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      U((Context)this.mActivity.get(), 2131696921);
    }
    
    /* Error */
    protected int zt()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: iconst_2
      //   3: istore_3
      //   4: aload_0
      //   5: getfield 64	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mVideoPath	Ljava/lang/String;
      //   8: iconst_1
      //   9: invokestatic 397	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
      //   12: astore 8
      //   14: new 117	java/lang/StringBuilder
      //   17: dup
      //   18: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   21: ldc_w 399
      //   24: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: invokestatic 405	java/lang/System:currentTimeMillis	()J
      //   30: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   33: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   36: ldc_w 407
      //   39: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   42: astore 6
      //   44: new 117	java/lang/StringBuilder
      //   47: dup
      //   48: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   51: invokestatic 414	com/tencent/mobileqq/shortvideo/ShortVideoUtils:zJ	()Ljava/lang/String;
      //   54: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: ldc_w 416
      //   60: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   63: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   66: invokestatic 420	aqhq:UD	(Ljava/lang/String;)V
      //   69: new 422	java/io/File
      //   72: dup
      //   73: aload 6
      //   75: invokespecial 424	java/io/File:<init>	(Ljava/lang/String;)V
      //   78: astore 9
      //   80: new 422	java/io/File
      //   83: dup
      //   84: aload 9
      //   86: invokevirtual 427	java/io/File:getParent	()Ljava/lang/String;
      //   89: invokespecial 424	java/io/File:<init>	(Ljava/lang/String;)V
      //   92: astore 4
      //   94: aload 4
      //   96: invokevirtual 430	java/io/File:exists	()Z
      //   99: ifeq +11 -> 110
      //   102: aload 4
      //   104: invokevirtual 433	java/io/File:isDirectory	()Z
      //   107: ifne +9 -> 116
      //   110: aload 4
      //   112: invokevirtual 436	java/io/File:mkdirs	()Z
      //   115: pop
      //   116: aload 9
      //   118: invokevirtual 430	java/io/File:exists	()Z
      //   121: ifeq +11 -> 132
      //   124: aload 9
      //   126: invokevirtual 439	java/io/File:isFile	()Z
      //   129: ifne +9 -> 138
      //   132: aload 9
      //   134: invokevirtual 442	java/io/File:createNewFile	()Z
      //   137: pop
      //   138: new 444	java/io/BufferedOutputStream
      //   141: dup
      //   142: new 446	java/io/FileOutputStream
      //   145: dup
      //   146: aload 9
      //   148: invokespecial 449	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   151: invokespecial 452	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   154: astore 5
      //   156: aload 8
      //   158: ifnull +214 -> 372
      //   161: aload 5
      //   163: astore 4
      //   165: aload 8
      //   167: getstatic 458	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   170: bipush 80
      //   172: aload 5
      //   174: invokevirtual 464	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   177: pop
      //   178: aload 5
      //   180: astore 4
      //   182: aload 5
      //   184: invokevirtual 467	java/io/BufferedOutputStream:flush	()V
      //   187: iload_2
      //   188: istore_1
      //   189: aload 5
      //   191: ifnull +10 -> 201
      //   194: aload 5
      //   196: invokevirtual 470	java/io/BufferedOutputStream:close	()V
      //   199: iload_2
      //   200: istore_1
      //   201: aload 9
      //   203: invokevirtual 430	java/io/File:exists	()Z
      //   206: ifeq +785 -> 991
      //   209: new 472	java/io/FileInputStream
      //   212: dup
      //   213: aload 6
      //   215: invokespecial 473	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   218: astore 4
      //   220: aload 4
      //   222: aload 9
      //   224: invokevirtual 476	java/io/File:length	()J
      //   227: invokestatic 482	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   230: invokestatic 488	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   233: astore 5
      //   235: aload 4
      //   237: ifnull +8 -> 245
      //   240: aload 4
      //   242: invokevirtual 489	java/io/FileInputStream:close	()V
      //   245: aload 5
      //   247: invokestatic 495	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   250: ifeq +361 -> 611
      //   253: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   256: ifeq +807 -> 1063
      //   259: ldc 115
      //   261: iconst_2
      //   262: new 117	java/lang/StringBuilder
      //   265: dup
      //   266: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   269: ldc_w 497
      //   272: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: aload 5
      //   277: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   280: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   283: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   286: aload_0
      //   287: aload 5
      //   289: putfield 107	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:aIf	Ljava/lang/String;
      //   292: aload_0
      //   293: aload 6
      //   295: putfield 265	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:bN	Ljava/lang/String;
      //   298: aload 8
      //   300: ifnull +21 -> 321
      //   303: aload_0
      //   304: aload 8
      //   306: invokevirtual 502	android/graphics/Bitmap:getWidth	()I
      //   309: putfield 269	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mThumbWidth	I
      //   312: aload_0
      //   313: aload 8
      //   315: invokevirtual 505	android/graphics/Bitmap:getHeight	()I
      //   318: putfield 273	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:gP	I
      //   321: new 472	java/io/FileInputStream
      //   324: dup
      //   325: aload_0
      //   326: getfield 64	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mVideoPath	Ljava/lang/String;
      //   329: invokespecial 473	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   332: astore 5
      //   334: aload_0
      //   335: aload 5
      //   337: new 422	java/io/File
      //   340: dup
      //   341: aload_0
      //   342: getfield 64	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mVideoPath	Ljava/lang/String;
      //   345: invokespecial 424	java/io/File:<init>	(Ljava/lang/String;)V
      //   348: invokevirtual 476	java/io/File:length	()J
      //   351: invokestatic 482	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   354: invokestatic 488	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   357: putfield 99	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mVideoMd5	Ljava/lang/String;
      //   360: iload_1
      //   361: ireturn
      //   362: astore 4
      //   364: aload 4
      //   366: invokevirtual 508	java/io/IOException:printStackTrace	()V
      //   369: goto -231 -> 138
      //   372: iconst_2
      //   373: istore_2
      //   374: goto -187 -> 187
      //   377: astore 7
      //   379: aconst_null
      //   380: astore 5
      //   382: aload 5
      //   384: astore 4
      //   386: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   389: ifeq +48 -> 437
      //   392: aload 5
      //   394: astore 4
      //   396: ldc 115
      //   398: iconst_2
      //   399: new 117	java/lang/StringBuilder
      //   402: dup
      //   403: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   406: ldc_w 510
      //   409: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   412: aload 6
      //   414: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: ldc_w 512
      //   420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   423: aload 7
      //   425: invokevirtual 515	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   428: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   431: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   434: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   437: aload 5
      //   439: ifnull +8 -> 447
      //   442: aload 5
      //   444: invokevirtual 470	java/io/BufferedOutputStream:close	()V
      //   447: iconst_2
      //   448: istore_1
      //   449: goto -248 -> 201
      //   452: astore 4
      //   454: iconst_2
      //   455: istore_1
      //   456: goto -255 -> 201
      //   459: astore 7
      //   461: aconst_null
      //   462: astore 5
      //   464: aload 5
      //   466: astore 4
      //   468: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   471: ifeq +48 -> 519
      //   474: aload 5
      //   476: astore 4
      //   478: ldc 115
      //   480: iconst_2
      //   481: new 117	java/lang/StringBuilder
      //   484: dup
      //   485: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   488: ldc_w 510
      //   491: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: aload 6
      //   496: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   499: ldc_w 517
      //   502: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   505: aload 7
      //   507: invokevirtual 518	java/io/IOException:getMessage	()Ljava/lang/String;
      //   510: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   513: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   516: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   519: aload 5
      //   521: ifnull +8 -> 529
      //   524: aload 5
      //   526: invokevirtual 470	java/io/BufferedOutputStream:close	()V
      //   529: iconst_2
      //   530: istore_1
      //   531: goto -330 -> 201
      //   534: astore 4
      //   536: iconst_2
      //   537: istore_1
      //   538: goto -337 -> 201
      //   541: astore 5
      //   543: aconst_null
      //   544: astore 4
      //   546: aload 4
      //   548: ifnull +8 -> 556
      //   551: aload 4
      //   553: invokevirtual 470	java/io/BufferedOutputStream:close	()V
      //   556: aload 5
      //   558: athrow
      //   559: astore 7
      //   561: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   564: ifeq -319 -> 245
      //   567: ldc 115
      //   569: iconst_2
      //   570: new 117	java/lang/StringBuilder
      //   573: dup
      //   574: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   577: ldc_w 520
      //   580: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   583: aload 6
      //   585: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   588: ldc_w 517
      //   591: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   594: aload 7
      //   596: invokevirtual 518	java/io/IOException:getMessage	()Ljava/lang/String;
      //   599: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   602: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   605: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   608: goto -363 -> 245
      //   611: aload 5
      //   613: ldc_w 407
      //   616: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   619: astore 7
      //   621: aload 6
      //   623: aload 7
      //   625: invokestatic 523	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   628: ifeq +432 -> 1060
      //   631: aload 7
      //   633: astore 6
      //   635: goto -349 -> 286
      //   638: astore 5
      //   640: aconst_null
      //   641: astore 4
      //   643: aload 5
      //   645: invokevirtual 524	java/io/FileNotFoundException:printStackTrace	()V
      //   648: aload 4
      //   650: ifnull +8 -> 658
      //   653: aload 4
      //   655: invokevirtual 489	java/io/FileInputStream:close	()V
      //   658: aconst_null
      //   659: invokestatic 495	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   662: ifeq +95 -> 757
      //   665: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   668: ifeq +384 -> 1052
      //   671: ldc 115
      //   673: iconst_2
      //   674: new 117	java/lang/StringBuilder
      //   677: dup
      //   678: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   681: ldc_w 497
      //   684: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   687: aconst_null
      //   688: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   691: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   694: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   697: iconst_2
      //   698: istore_1
      //   699: aconst_null
      //   700: astore 5
      //   702: goto -416 -> 286
      //   705: astore 5
      //   707: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   710: ifeq -52 -> 658
      //   713: ldc 115
      //   715: iconst_2
      //   716: new 117	java/lang/StringBuilder
      //   719: dup
      //   720: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   723: ldc_w 520
      //   726: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   729: aload 6
      //   731: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   734: ldc_w 517
      //   737: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   740: aload 5
      //   742: invokevirtual 518	java/io/IOException:getMessage	()Ljava/lang/String;
      //   745: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   748: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   751: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   754: goto -96 -> 658
      //   757: aconst_null
      //   758: ldc_w 407
      //   761: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   764: astore 5
      //   766: aload 6
      //   768: astore 7
      //   770: aload 6
      //   772: aload 5
      //   774: invokestatic 523	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   777: ifeq +7 -> 784
      //   780: aload 5
      //   782: astore 7
      //   784: iconst_2
      //   785: istore_1
      //   786: aconst_null
      //   787: astore 5
      //   789: aload 7
      //   791: astore 6
      //   793: goto -507 -> 286
      //   796: astore 5
      //   798: aconst_null
      //   799: astore 4
      //   801: aload 4
      //   803: ifnull +8 -> 811
      //   806: aload 4
      //   808: invokevirtual 489	java/io/FileInputStream:close	()V
      //   811: aconst_null
      //   812: invokestatic 495	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   815: ifeq +90 -> 905
      //   818: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   821: ifeq +29 -> 850
      //   824: ldc 115
      //   826: iconst_2
      //   827: new 117	java/lang/StringBuilder
      //   830: dup
      //   831: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   834: ldc_w 497
      //   837: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   840: aconst_null
      //   841: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   844: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   847: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   850: aload 5
      //   852: athrow
      //   853: astore 4
      //   855: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   858: ifeq -47 -> 811
      //   861: ldc 115
      //   863: iconst_2
      //   864: new 117	java/lang/StringBuilder
      //   867: dup
      //   868: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   871: ldc_w 520
      //   874: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   877: aload 6
      //   879: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   882: ldc_w 517
      //   885: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   888: aload 4
      //   890: invokevirtual 518	java/io/IOException:getMessage	()Ljava/lang/String;
      //   893: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   896: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   899: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   902: goto -91 -> 811
      //   905: aload 6
      //   907: aconst_null
      //   908: ldc_w 407
      //   911: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   914: invokestatic 523	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   917: ifeq -67 -> 850
      //   920: goto -70 -> 850
      //   923: astore 6
      //   925: iconst_5
      //   926: istore_2
      //   927: aload 4
      //   929: astore 5
      //   931: iload_2
      //   932: istore_1
      //   933: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   936: ifeq -602 -> 334
      //   939: ldc 115
      //   941: iconst_2
      //   942: new 117	java/lang/StringBuilder
      //   945: dup
      //   946: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   949: ldc_w 526
      //   952: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   955: aload_0
      //   956: getfield 64	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$a:mVideoPath	Ljava/lang/String;
      //   959: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   962: ldc_w 528
      //   965: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   968: aload 6
      //   970: invokevirtual 515	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   973: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   976: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   979: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   982: aload 4
      //   984: astore 5
      //   986: iload_2
      //   987: istore_1
      //   988: goto -654 -> 334
      //   991: iload_3
      //   992: istore_1
      //   993: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   996: ifeq -636 -> 360
      //   999: ldc 115
      //   1001: iconst_2
      //   1002: ldc_w 530
      //   1005: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1008: iconst_2
      //   1009: ireturn
      //   1010: astore 4
      //   1012: iload_2
      //   1013: istore_1
      //   1014: goto -813 -> 201
      //   1017: astore 4
      //   1019: goto -463 -> 556
      //   1022: astore 5
      //   1024: goto -223 -> 801
      //   1027: astore 5
      //   1029: goto -228 -> 801
      //   1032: astore 5
      //   1034: goto -391 -> 643
      //   1037: astore 5
      //   1039: goto -493 -> 546
      //   1042: astore 7
      //   1044: goto -580 -> 464
      //   1047: astore 7
      //   1049: goto -667 -> 382
      //   1052: iconst_2
      //   1053: istore_1
      //   1054: aconst_null
      //   1055: astore 5
      //   1057: goto -771 -> 286
      //   1060: goto -425 -> 635
      //   1063: goto -777 -> 286
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1066	0	this	a
      //   188	866	1	i	int
      //   1	1012	2	j	int
      //   3	989	3	k	int
      //   92	149	4	localObject1	Object
      //   362	3	4	localIOException1	java.io.IOException
      //   384	11	4	localObject2	Object
      //   452	1	4	localIOException2	java.io.IOException
      //   466	11	4	localObject3	Object
      //   534	1	4	localIOException3	java.io.IOException
      //   544	263	4	localObject4	Object
      //   853	130	4	localIOException4	java.io.IOException
      //   1010	1	4	localIOException5	java.io.IOException
      //   1017	1	4	localIOException6	java.io.IOException
      //   154	371	5	localObject5	Object
      //   541	71	5	str1	String
      //   638	6	5	localFileNotFoundException1	java.io.FileNotFoundException
      //   700	1	5	localObject6	Object
      //   705	36	5	localIOException7	java.io.IOException
      //   764	24	5	str2	String
      //   796	55	5	localObject7	Object
      //   929	56	5	localIOException8	java.io.IOException
      //   1022	1	5	localObject8	Object
      //   1027	1	5	localObject9	Object
      //   1032	1	5	localFileNotFoundException2	java.io.FileNotFoundException
      //   1037	1	5	localObject10	Object
      //   1055	1	5	localObject11	Object
      //   42	864	6	localObject12	Object
      //   923	46	6	localFileNotFoundException3	java.io.FileNotFoundException
      //   377	47	7	localFileNotFoundException4	java.io.FileNotFoundException
      //   459	47	7	localIOException9	java.io.IOException
      //   559	36	7	localIOException10	java.io.IOException
      //   619	171	7	localObject13	Object
      //   1042	1	7	localIOException11	java.io.IOException
      //   1047	1	7	localFileNotFoundException5	java.io.FileNotFoundException
      //   12	302	8	localBitmap	Bitmap
      //   78	145	9	localFile	File
      // Exception table:
      //   from	to	target	type
      //   132	138	362	java/io/IOException
      //   138	156	377	java/io/FileNotFoundException
      //   442	447	452	java/io/IOException
      //   138	156	459	java/io/IOException
      //   524	529	534	java/io/IOException
      //   138	156	541	finally
      //   240	245	559	java/io/IOException
      //   209	220	638	java/io/FileNotFoundException
      //   653	658	705	java/io/IOException
      //   209	220	796	finally
      //   806	811	853	java/io/IOException
      //   321	334	923	java/io/FileNotFoundException
      //   194	199	1010	java/io/IOException
      //   551	556	1017	java/io/IOException
      //   220	235	1022	finally
      //   643	648	1027	finally
      //   220	235	1032	java/io/FileNotFoundException
      //   165	178	1037	finally
      //   182	187	1037	finally
      //   386	392	1037	finally
      //   396	437	1037	finally
      //   468	474	1037	finally
      //   478	519	1037	finally
      //   165	178	1042	java/io/IOException
      //   182	187	1042	java/io/IOException
      //   165	178	1047	java/io/FileNotFoundException
      //   182	187	1047	java/io/FileNotFoundException
    }
  }
  
  public static class b
    extends AsyncTask<Void, Void, Integer>
  {
    String aIf;
    boolean bBn;
    String bN;
    String beJ;
    String beK;
    boolean btc;
    int cmN;
    int cmO;
    ProgressDialog e;
    int gP;
    WeakReference<BaseActivity> mActivity;
    Bitmap mBitmap;
    long mDuration;
    int mThumbWidth;
    String mUin;
    int mUinType;
    String mVideoMd5;
    public String mVideoPath;
    long mVideoSize;
    ArrayList<String> rL;
    TextView yw;
    
    public b(BaseActivity paramBaseActivity, Intent paramIntent)
    {
      this.mActivity = new WeakReference(paramBaseActivity);
      paramBaseActivity = paramBaseActivity.getIntent();
      if (paramIntent != null) {}
      for (;;)
      {
        this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
        this.rL = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
        this.mDuration = paramIntent.getExtras().getLong("file_send_duration");
        this.mVideoSize = paramIntent.getExtras().getLong("file_send_size");
        this.mUin = paramIntent.getExtras().getString("uin");
        this.mUinType = paramIntent.getIntExtra("uintype", -1);
        this.beK = paramIntent.getStringExtra("file_source");
        this.mVideoMd5 = paramIntent.getExtras().getString("file_shortvideo_md5");
        this.beJ = paramIntent.getExtras().getString("activity_before_enter_send_video");
        this.btc = paramIntent.getExtras().getBoolean("send_in_background");
        if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
        for (boolean bool = true;; bool = false)
        {
          this.bBn = bool;
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.mVideoPath + ", mDuration:" + this.mDuration + ", mFileSize:" + this.mVideoSize + ",mUin" + this.mUin + ",mUinType:" + this.mUinType + ",mFileSource:" + this.beK + ",mSendBackground = " + this.btc + ", mSendRawVideo:" + this.bBn);
          }
          return;
        }
        paramIntent = paramBaseActivity;
      }
    }
    
    public static void a(BaseActivity paramBaseActivity, int paramInt, boolean paramBoolean)
    {
      aqju localaqju = aqha.a(paramBaseActivity, 232, null, paramBaseActivity.getString(paramInt), new aazg(paramBoolean, paramBaseActivity), null);
      if (!paramBaseActivity.isFinishing()) {
        localaqju.show();
      }
    }
    
    void U(Context paramContext, int paramInt)
    {
      if (this.btc) {
        return;
      }
      for (;;)
      {
        try
        {
          if (this.e == null) {
            break label62;
          }
          cancleProgressDailog();
          this.yw.setText(paramInt);
          if (this.e.isShowing()) {
            break;
          }
          this.e.show();
          return;
        }
        catch (Throwable paramContext) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("SendVideoActivity", 2, "showProgressDialog", paramContext);
        return;
        label62:
        this.e = new ReportProgressDialog(paramContext, 2131756467);
        this.e.setCancelable(true);
        this.e.show();
        this.e.setContentView(2131559761);
        this.yw = ((TextView)this.e.findViewById(2131373180));
      }
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      return Integer.valueOf(uH());
    }
    
    public void cAr()
    {
      Intent localIntent = ((BaseActivity)this.mActivity.get()).getIntent();
      localIntent.putExtra("uin", this.mUin);
      localIntent.putExtra("uintype", this.mUinType);
      localIntent.putExtra("file_send_path", this.mVideoPath);
      localIntent.putExtra("file_send_size", this.mVideoSize);
      localIntent.putExtra("file_send_duration", (int)(this.mDuration / 1000L));
      localIntent.putExtra("file_source", this.beK);
      localIntent.putExtra("thumbfile_send_path", this.bN);
      localIntent.putExtra("file_shortvideo_md5", this.mVideoMd5);
      localIntent.putExtra("thumbfile_send_width", this.mThumbWidth);
      localIntent.putExtra("thumbfile_send_height", this.gP);
      localIntent.putExtra("thumbfile_md5", this.aIf);
      localIntent.putExtra("file_width", this.cmN);
      localIntent.putExtra("file_height", this.cmO);
      localIntent.putExtra("file_raw_size", this.bBn);
      Object localObject1;
      if ((this.beJ != null) && (this.beJ.equals(ShortVideoPreviewActivity.class.getName())))
      {
        localIntent.putExtra("file_send_business_type", 2);
        localObject1 = anfr.a(0, 2);
        ((angi)localObject1).c(anfr.a(2, localIntent, (angi)localObject1));
        anfr.a((angi)localObject1, ((BaseActivity)this.mActivity.get()).app);
      }
      for (;;)
      {
        if (!this.btc)
        {
          localObject1 = ((BaseActivity)this.mActivity.get()).getIntent();
          if (((Intent)localObject1).getBooleanExtra("start_init_activity_after_sended", true))
          {
            localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            localIntent.setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("SendVideoActivity", 2, "SendVideoTask onPostExecute() INIT_ACTIVITY_CLASS_NAME=" + (String)localObject2);
            }
            localIntent.addFlags(603979776);
            ((BaseActivity)this.mActivity.get()).startActivity(localIntent);
          }
          ((BaseActivity)this.mActivity.get()).finish();
          ((BaseActivity)this.mActivity.get()).overridePendingTransition(0, 2130771992);
        }
        return;
        localIntent.putExtra("file_send_business_type", 0);
        Object localObject2 = anfr.a(0, 0);
        localObject1 = anfr.a(0, localIntent, (angi)localObject2);
        ((angi)localObject2).c((angt)localObject1);
        localObject2 = new anff(((BaseActivity)this.mActivity.get()).app);
        localObject1 = ((anff)localObject2).a((angt)localObject1);
        if (((BaseActivity)this.mActivity.get()).app != null) {
          ((ambj)((BaseActivity)this.mActivity.get()).app.getManager(326)).aG(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).uniseq);
        }
        ((anff)localObject2).ar((MessageRecord)localObject1);
      }
    }
    
    void cancleProgressDailog()
    {
      if (this.btc) {}
      for (;;)
      {
        return;
        try
        {
          if (this.e != null)
          {
            this.e.cancel();
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      if (this.mActivity.get() == null) {
        return;
      }
      cancleProgressDailog();
      switch (paramInteger.intValue())
      {
      case 7: 
      case 8: 
      default: 
        return;
      case 1: 
        cAr();
        return;
      case 2: 
      case 6: 
        a((BaseActivity)this.mActivity.get(), 2131720284, this.btc);
        return;
      case 3: 
        a((BaseActivity)this.mActivity.get(), 2131720279, this.btc);
        return;
      case 4: 
        a((BaseActivity)this.mActivity.get(), 2131720249, this.btc);
        return;
      case 5: 
        a((BaseActivity)this.mActivity.get(), 2131720276, this.btc);
        return;
      }
      ((BaseActivity)this.mActivity.get()).finish();
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
      U((Context)this.mActivity.get(), 2131696921);
    }
    
    /* Error */
    public int uH()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 52	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mActivity	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 267	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 441	android/content/Context
      //   10: astore 11
      //   12: aload 11
      //   14: ifnonnull +7 -> 21
      //   17: iconst_5
      //   18: istore_1
      //   19: iload_1
      //   20: ireturn
      //   21: aload_0
      //   22: getfield 82	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:rL	Ljava/util/ArrayList;
      //   25: ifnull +61 -> 86
      //   28: aload_0
      //   29: getfield 82	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:rL	Ljava/util/ArrayList;
      //   32: invokevirtual 455	java/util/ArrayList:isEmpty	()Z
      //   35: ifne +51 -> 86
      //   38: aload_0
      //   39: getfield 52	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mActivity	Ljava/lang/ref/WeakReference;
      //   42: invokevirtual 267	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   45: checkcast 54	com/tencent/mobileqq/app/BaseActivity
      //   48: getfield 341	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   51: aload_0
      //   52: getfield 82	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:rL	Ljava/util/ArrayList;
      //   55: aload_0
      //   56: getfield 98	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mUin	Ljava/lang/String;
      //   59: aload_0
      //   60: getfield 106	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mUinType	I
      //   63: invokestatic 460	aqmd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;Ljava/lang/String;I)V
      //   66: aload_0
      //   67: getfield 74	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mVideoPath	Ljava/lang/String;
      //   70: ifnull +13 -> 83
      //   73: aload_0
      //   74: getfield 74	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mVideoPath	Ljava/lang/String;
      //   77: ldc_w 462
      //   80: if_acmpne +6 -> 86
      //   83: bipush 9
      //   85: ireturn
      //   86: sipush 1280
      //   89: istore_2
      //   90: invokestatic 468	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
      //   93: invokevirtual 472	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
      //   96: checkcast 386	com/tencent/mobileqq/app/QQAppInterface
      //   99: astore 7
      //   101: iload_2
      //   102: istore_1
      //   103: aload 7
      //   105: ifnull +108 -> 213
      //   108: aload 11
      //   110: aload 7
      //   112: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
      //   115: invokestatic 481	aqmj:ah	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
      //   118: astore 7
      //   120: iload_2
      //   121: istore_1
      //   122: aload 7
      //   124: ifnull +89 -> 213
      //   127: iload_2
      //   128: istore_1
      //   129: aload 7
      //   131: invokevirtual 484	java/lang/String:length	()I
      //   134: ifle +79 -> 213
      //   137: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   140: ifeq +30 -> 170
      //   143: ldc 141
      //   145: iconst_2
      //   146: new 143	java/lang/StringBuilder
      //   149: dup
      //   150: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   153: ldc_w 486
      //   156: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: aload 7
      //   161: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   167: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   170: aload 7
      //   172: ldc_w 488
      //   175: invokevirtual 492	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   178: astore 7
      //   180: iload_2
      //   181: istore_1
      //   182: aload 7
      //   184: ifnull +29 -> 213
      //   187: aload 7
      //   189: arraylength
      //   190: istore_3
      //   191: iload_2
      //   192: istore_1
      //   193: iload_3
      //   194: iconst_5
      //   195: if_icmplt +18 -> 213
      //   198: aload 7
      //   200: iconst_0
      //   201: aaload
      //   202: invokestatic 495	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   205: invokevirtual 426	java/lang/Integer:intValue	()I
      //   208: istore_1
      //   209: iload_1
      //   210: ifle +1220 -> 1430
      //   213: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   216: ifeq +29 -> 245
      //   219: ldc 141
      //   221: iconst_2
      //   222: new 143	java/lang/StringBuilder
      //   225: dup
      //   226: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   229: ldc_w 497
      //   232: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: iload_1
      //   236: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   239: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   245: aload 11
      //   247: aload_0
      //   248: getfield 74	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mVideoPath	Ljava/lang/String;
      //   251: iload_1
      //   252: invokestatic 503	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
      //   255: astore 8
      //   257: aload 8
      //   259: ifnonnull +1168 -> 1427
      //   262: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   265: ifeq +12 -> 277
      //   268: ldc 141
      //   270: iconst_2
      //   271: ldc_w 505
      //   274: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   277: aload_0
      //   278: getfield 509	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mBitmap	Landroid/graphics/Bitmap;
      //   281: ifnull +201 -> 482
      //   284: aload_0
      //   285: getfield 509	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mBitmap	Landroid/graphics/Bitmap;
      //   288: astore 8
      //   290: aload_0
      //   291: aload 8
      //   293: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
      //   296: putfield 287	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mThumbWidth	I
      //   299: aload_0
      //   300: aload 8
      //   302: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
      //   305: putfield 291	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:gP	I
      //   308: aload_0
      //   309: getfield 287	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mThumbWidth	I
      //   312: ifeq +10 -> 322
      //   315: aload_0
      //   316: getfield 291	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:gP	I
      //   319: ifne +201 -> 520
      //   322: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   325: ifeq +12 -> 337
      //   328: ldc 141
      //   330: iconst_2
      //   331: ldc_w 519
      //   334: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   337: iconst_0
      //   338: ifeq +11 -> 349
      //   341: new 521	java/lang/NullPointerException
      //   344: dup
      //   345: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   348: athrow
      //   349: iconst_0
      //   350: ifeq +11 -> 361
      //   353: new 521	java/lang/NullPointerException
      //   356: dup
      //   357: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   360: athrow
      //   361: iconst_0
      //   362: ifeq +11 -> 373
      //   365: new 521	java/lang/NullPointerException
      //   368: dup
      //   369: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   372: athrow
      //   373: iconst_2
      //   374: ireturn
      //   375: astore 7
      //   377: iload_2
      //   378: istore_1
      //   379: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   382: ifeq -169 -> 213
      //   385: ldc 141
      //   387: iconst_2
      //   388: ldc_w 524
      //   391: aload 7
      //   393: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   396: iload_2
      //   397: istore_1
      //   398: goto -185 -> 213
      //   401: astore 11
      //   403: aconst_null
      //   404: astore 7
      //   406: aconst_null
      //   407: astore 10
      //   409: aload 7
      //   411: astore 9
      //   413: aload 10
      //   415: astore 8
      //   417: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   420: ifeq +22 -> 442
      //   423: aload 7
      //   425: astore 9
      //   427: aload 10
      //   429: astore 8
      //   431: ldc 141
      //   433: iconst_2
      //   434: ldc_w 526
      //   437: aload 11
      //   439: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   442: iconst_3
      //   443: istore_1
      //   444: iconst_0
      //   445: ifeq +11 -> 456
      //   448: new 521	java/lang/NullPointerException
      //   451: dup
      //   452: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   455: athrow
      //   456: aload 7
      //   458: ifnull +8 -> 466
      //   461: aload 7
      //   463: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   466: aload 10
      //   468: ifnull -449 -> 19
      //   471: aload 10
      //   473: invokevirtual 534	java/io/FileInputStream:close	()V
      //   476: iconst_3
      //   477: ireturn
      //   478: astore 7
      //   480: iconst_3
      //   481: ireturn
      //   482: iconst_0
      //   483: ifeq +11 -> 494
      //   486: new 521	java/lang/NullPointerException
      //   489: dup
      //   490: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   493: athrow
      //   494: iconst_0
      //   495: ifeq +11 -> 506
      //   498: new 521	java/lang/NullPointerException
      //   501: dup
      //   502: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   505: athrow
      //   506: iconst_0
      //   507: ifeq +11 -> 518
      //   510: new 521	java/lang/NullPointerException
      //   513: dup
      //   514: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   517: athrow
      //   518: iconst_2
      //   519: ireturn
      //   520: new 143	java/lang/StringBuilder
      //   523: dup
      //   524: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   527: ldc_w 462
      //   530: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   533: invokestatic 540	java/lang/System:currentTimeMillis	()J
      //   536: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   539: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   542: ldc_w 542
      //   545: invokestatic 546	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   548: astore 12
      //   550: new 143	java/lang/StringBuilder
      //   553: dup
      //   554: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   557: invokestatic 549	com/tencent/mobileqq/shortvideo/ShortVideoUtils:zJ	()Ljava/lang/String;
      //   560: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   563: ldc_w 551
      //   566: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   569: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   572: invokestatic 557	aqhq:UD	(Ljava/lang/String;)V
      //   575: new 559	java/io/File
      //   578: dup
      //   579: aload 12
      //   581: invokespecial 561	java/io/File:<init>	(Ljava/lang/String;)V
      //   584: astore 13
      //   586: new 559	java/io/File
      //   589: dup
      //   590: aload 13
      //   592: invokevirtual 564	java/io/File:getParent	()Ljava/lang/String;
      //   595: invokespecial 561	java/io/File:<init>	(Ljava/lang/String;)V
      //   598: astore 7
      //   600: aload 7
      //   602: invokevirtual 567	java/io/File:exists	()Z
      //   605: ifeq +11 -> 616
      //   608: aload 7
      //   610: invokevirtual 570	java/io/File:isDirectory	()Z
      //   613: ifne +9 -> 622
      //   616: aload 7
      //   618: invokevirtual 573	java/io/File:mkdirs	()Z
      //   621: pop
      //   622: aload 13
      //   624: invokevirtual 567	java/io/File:exists	()Z
      //   627: ifeq +11 -> 638
      //   630: aload 13
      //   632: invokevirtual 576	java/io/File:isFile	()Z
      //   635: ifne +9 -> 644
      //   638: aload 13
      //   640: invokevirtual 579	java/io/File:createNewFile	()Z
      //   643: pop
      //   644: new 528	java/io/BufferedOutputStream
      //   647: dup
      //   648: new 581	java/io/FileOutputStream
      //   651: dup
      //   652: aload 13
      //   654: invokespecial 584	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   657: invokespecial 587	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   660: astore 7
      //   662: aload 8
      //   664: getstatic 593	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   667: bipush 80
      //   669: aload 7
      //   671: invokevirtual 597	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   674: pop
      //   675: aload 7
      //   677: invokevirtual 600	java/io/BufferedOutputStream:flush	()V
      //   680: new 533	java/io/FileInputStream
      //   683: dup
      //   684: aload 13
      //   686: invokespecial 601	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   689: astore 10
      //   691: aload 7
      //   693: astore 9
      //   695: aload 10
      //   697: astore 8
      //   699: aload 13
      //   701: invokevirtual 603	java/io/File:length	()J
      //   704: lstore 5
      //   706: aload 7
      //   708: astore 9
      //   710: aload 10
      //   712: astore 8
      //   714: aload_0
      //   715: aload 10
      //   717: lload 5
      //   719: invokestatic 609	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   722: invokestatic 615	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   725: putfield 295	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:aIf	Ljava/lang/String;
      //   728: aload 7
      //   730: astore 9
      //   732: aload 10
      //   734: astore 8
      //   736: aload_0
      //   737: getfield 295	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:aIf	Ljava/lang/String;
      //   740: invokestatic 620	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   743: ifeq +88 -> 831
      //   746: aload 7
      //   748: astore 9
      //   750: aload 10
      //   752: astore 8
      //   754: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   757: ifeq +40 -> 797
      //   760: aload 7
      //   762: astore 9
      //   764: aload 10
      //   766: astore 8
      //   768: ldc 141
      //   770: iconst_2
      //   771: new 143	java/lang/StringBuilder
      //   774: dup
      //   775: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   778: ldc_w 622
      //   781: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   784: aload_0
      //   785: getfield 295	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:aIf	Ljava/lang/String;
      //   788: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   791: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   794: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   797: iconst_0
      //   798: ifeq +11 -> 809
      //   801: new 521	java/lang/NullPointerException
      //   804: dup
      //   805: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   808: athrow
      //   809: aload 7
      //   811: ifnull +8 -> 819
      //   814: aload 7
      //   816: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   819: aload 10
      //   821: ifnull +8 -> 829
      //   824: aload 10
      //   826: invokevirtual 534	java/io/FileInputStream:close	()V
      //   829: iconst_5
      //   830: ireturn
      //   831: aload 7
      //   833: astore 9
      //   835: aload 10
      //   837: astore 8
      //   839: aload_0
      //   840: aload_0
      //   841: getfield 295	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:aIf	Ljava/lang/String;
      //   844: ldc_w 542
      //   847: invokestatic 546	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   850: putfield 283	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:bN	Ljava/lang/String;
      //   853: aload 7
      //   855: astore 9
      //   857: aload 10
      //   859: astore 8
      //   861: aload 12
      //   863: aload_0
      //   864: getfield 283	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:bN	Ljava/lang/String;
      //   867: invokestatic 626	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   870: istore 4
      //   872: iload 4
      //   874: ifne +37 -> 911
      //   877: iconst_0
      //   878: ifeq +11 -> 889
      //   881: new 521	java/lang/NullPointerException
      //   884: dup
      //   885: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   888: athrow
      //   889: aload 7
      //   891: ifnull +8 -> 899
      //   894: aload 7
      //   896: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   899: aload 10
      //   901: ifnull +8 -> 909
      //   904: aload 10
      //   906: invokevirtual 534	java/io/FileInputStream:close	()V
      //   909: iconst_5
      //   910: ireturn
      //   911: aload 7
      //   913: astore 9
      //   915: aload 10
      //   917: astore 8
      //   919: aload 11
      //   921: lload 5
      //   923: invokestatic 632	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
      //   926: astore 11
      //   928: aload 7
      //   930: astore 9
      //   932: aload 10
      //   934: astore 8
      //   936: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   939: ifeq +38 -> 977
      //   942: aload 7
      //   944: astore 9
      //   946: aload 10
      //   948: astore 8
      //   950: ldc 141
      //   952: iconst_2
      //   953: new 143	java/lang/StringBuilder
      //   956: dup
      //   957: invokespecial 144	java/lang/StringBuilder:<init>	()V
      //   960: ldc_w 634
      //   963: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   966: aload 11
      //   968: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   971: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   974: invokestatic 507	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   977: aload 7
      //   979: astore 9
      //   981: aload 10
      //   983: astore 8
      //   985: aload_0
      //   986: getfield 90	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mDuration	J
      //   989: lconst_0
      //   990: lcmp
      //   991: ifne +22 -> 1013
      //   994: aload 7
      //   996: astore 9
      //   998: aload 10
      //   1000: astore 8
      //   1002: aload_0
      //   1003: aload_0
      //   1004: getfield 74	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mVideoPath	Ljava/lang/String;
      //   1007: invokestatic 637	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
      //   1010: putfield 90	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$b:mDuration	J
      //   1013: iconst_0
      //   1014: ifeq +11 -> 1025
      //   1017: new 521	java/lang/NullPointerException
      //   1020: dup
      //   1021: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   1024: athrow
      //   1025: aload 7
      //   1027: ifnull +8 -> 1035
      //   1030: aload 7
      //   1032: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   1035: aload 10
      //   1037: ifnull +8 -> 1045
      //   1040: aload 10
      //   1042: invokevirtual 534	java/io/FileInputStream:close	()V
      //   1045: iconst_1
      //   1046: ireturn
      //   1047: astore 11
      //   1049: aconst_null
      //   1050: astore 7
      //   1052: aconst_null
      //   1053: astore 10
      //   1055: aload 7
      //   1057: astore 9
      //   1059: aload 10
      //   1061: astore 8
      //   1063: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1066: ifeq +22 -> 1088
      //   1069: aload 7
      //   1071: astore 9
      //   1073: aload 10
      //   1075: astore 8
      //   1077: ldc 141
      //   1079: iconst_2
      //   1080: ldc_w 526
      //   1083: aload 11
      //   1085: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1088: iconst_0
      //   1089: ifeq +11 -> 1100
      //   1092: new 521	java/lang/NullPointerException
      //   1095: dup
      //   1096: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   1099: athrow
      //   1100: aload 7
      //   1102: ifnull +8 -> 1110
      //   1105: aload 7
      //   1107: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   1110: aload 10
      //   1112: ifnull +8 -> 1120
      //   1115: aload 10
      //   1117: invokevirtual 534	java/io/FileInputStream:close	()V
      //   1120: iconst_5
      //   1121: ireturn
      //   1122: astore 11
      //   1124: aconst_null
      //   1125: astore 7
      //   1127: aconst_null
      //   1128: astore 10
      //   1130: aload 7
      //   1132: astore 9
      //   1134: aload 10
      //   1136: astore 8
      //   1138: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1141: ifeq +22 -> 1163
      //   1144: aload 7
      //   1146: astore 9
      //   1148: aload 10
      //   1150: astore 8
      //   1152: ldc 141
      //   1154: iconst_2
      //   1155: ldc_w 639
      //   1158: aload 11
      //   1160: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1163: iconst_4
      //   1164: istore_1
      //   1165: iconst_0
      //   1166: ifeq +11 -> 1177
      //   1169: new 521	java/lang/NullPointerException
      //   1172: dup
      //   1173: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   1176: athrow
      //   1177: aload 7
      //   1179: ifnull +8 -> 1187
      //   1182: aload 7
      //   1184: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   1187: aload 10
      //   1189: ifnull -1170 -> 19
      //   1192: aload 10
      //   1194: invokevirtual 534	java/io/FileInputStream:close	()V
      //   1197: iconst_4
      //   1198: ireturn
      //   1199: astore 7
      //   1201: iconst_4
      //   1202: ireturn
      //   1203: astore 10
      //   1205: aconst_null
      //   1206: astore 7
      //   1208: aconst_null
      //   1209: astore 8
      //   1211: iconst_0
      //   1212: ifeq +11 -> 1223
      //   1215: new 521	java/lang/NullPointerException
      //   1218: dup
      //   1219: invokespecial 522	java/lang/NullPointerException:<init>	()V
      //   1222: athrow
      //   1223: aload 7
      //   1225: ifnull +8 -> 1233
      //   1228: aload 7
      //   1230: invokevirtual 531	java/io/BufferedOutputStream:close	()V
      //   1233: aload 8
      //   1235: ifnull +8 -> 1243
      //   1238: aload 8
      //   1240: invokevirtual 534	java/io/FileInputStream:close	()V
      //   1243: aload 10
      //   1245: athrow
      //   1246: astore 7
      //   1248: goto -754 -> 494
      //   1251: astore 7
      //   1253: goto -747 -> 506
      //   1256: astore 7
      //   1258: goto -740 -> 518
      //   1261: astore 7
      //   1263: goto -914 -> 349
      //   1266: astore 7
      //   1268: goto -907 -> 361
      //   1271: astore 7
      //   1273: goto -900 -> 373
      //   1276: astore 8
      //   1278: goto -469 -> 809
      //   1281: astore 7
      //   1283: goto -464 -> 819
      //   1286: astore 7
      //   1288: goto -459 -> 829
      //   1291: astore 8
      //   1293: goto -404 -> 889
      //   1296: astore 7
      //   1298: goto -399 -> 899
      //   1301: astore 7
      //   1303: goto -394 -> 909
      //   1306: astore 8
      //   1308: goto -283 -> 1025
      //   1311: astore 7
      //   1313: goto -278 -> 1035
      //   1316: astore 7
      //   1318: goto -273 -> 1045
      //   1321: astore 8
      //   1323: goto -867 -> 456
      //   1326: astore 7
      //   1328: goto -862 -> 466
      //   1331: astore 8
      //   1333: goto -233 -> 1100
      //   1336: astore 7
      //   1338: goto -228 -> 1110
      //   1341: astore 7
      //   1343: goto -223 -> 1120
      //   1346: astore 8
      //   1348: goto -171 -> 1177
      //   1351: astore 7
      //   1353: goto -166 -> 1187
      //   1356: astore 9
      //   1358: goto -135 -> 1223
      //   1361: astore 7
      //   1363: goto -130 -> 1233
      //   1366: astore 7
      //   1368: goto -125 -> 1243
      //   1371: astore 10
      //   1373: aconst_null
      //   1374: astore 8
      //   1376: goto -165 -> 1211
      //   1379: astore 10
      //   1381: aload 9
      //   1383: astore 7
      //   1385: goto -174 -> 1211
      //   1388: astore 11
      //   1390: aconst_null
      //   1391: astore 10
      //   1393: goto -263 -> 1130
      //   1396: astore 11
      //   1398: goto -268 -> 1130
      //   1401: astore 11
      //   1403: aconst_null
      //   1404: astore 10
      //   1406: goto -351 -> 1055
      //   1409: astore 11
      //   1411: goto -356 -> 1055
      //   1414: astore 11
      //   1416: aconst_null
      //   1417: astore 10
      //   1419: goto -1010 -> 409
      //   1422: astore 11
      //   1424: goto -1015 -> 409
      //   1427: goto -1137 -> 290
      //   1430: sipush 1280
      //   1433: istore_1
      //   1434: goto -1221 -> 213
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1437	0	this	b
      //   18	1416	1	i	int
      //   89	308	2	j	int
      //   190	6	3	k	int
      //   870	3	4	bool	boolean
      //   704	218	5	l	long
      //   99	100	7	localObject1	Object
      //   375	17	7	localNumberFormatException	java.lang.NumberFormatException
      //   404	58	7	localObject2	Object
      //   478	1	7	localIOException1	java.io.IOException
      //   598	585	7	localObject3	Object
      //   1199	1	7	localIOException2	java.io.IOException
      //   1206	23	7	localObject4	Object
      //   1246	1	7	localIOException3	java.io.IOException
      //   1251	1	7	localIOException4	java.io.IOException
      //   1256	1	7	localIOException5	java.io.IOException
      //   1261	1	7	localIOException6	java.io.IOException
      //   1266	1	7	localIOException7	java.io.IOException
      //   1271	1	7	localIOException8	java.io.IOException
      //   1281	1	7	localIOException9	java.io.IOException
      //   1286	1	7	localIOException10	java.io.IOException
      //   1296	1	7	localIOException11	java.io.IOException
      //   1301	1	7	localIOException12	java.io.IOException
      //   1311	1	7	localIOException13	java.io.IOException
      //   1316	1	7	localIOException14	java.io.IOException
      //   1326	1	7	localIOException15	java.io.IOException
      //   1336	1	7	localIOException16	java.io.IOException
      //   1341	1	7	localIOException17	java.io.IOException
      //   1351	1	7	localIOException18	java.io.IOException
      //   1361	1	7	localIOException19	java.io.IOException
      //   1366	1	7	localIOException20	java.io.IOException
      //   1383	1	7	localObject5	Object
      //   255	984	8	localObject6	Object
      //   1276	1	8	localIOException21	java.io.IOException
      //   1291	1	8	localIOException22	java.io.IOException
      //   1306	1	8	localIOException23	java.io.IOException
      //   1321	1	8	localIOException24	java.io.IOException
      //   1331	1	8	localIOException25	java.io.IOException
      //   1346	1	8	localIOException26	java.io.IOException
      //   1374	1	8	localObject7	Object
      //   411	736	9	localObject8	Object
      //   1356	26	9	localIOException27	java.io.IOException
      //   407	786	10	localFileInputStream	FileInputStream
      //   1203	41	10	localObject9	Object
      //   1371	1	10	localObject10	Object
      //   1379	1	10	localObject11	Object
      //   1391	27	10	localObject12	Object
      //   10	236	11	localContext	Context
      //   401	519	11	localIOException28	java.io.IOException
      //   926	41	11	str1	String
      //   1047	37	11	localException1	Exception
      //   1122	37	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   1388	1	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
      //   1396	1	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
      //   1401	1	11	localException2	Exception
      //   1409	1	11	localException3	Exception
      //   1414	1	11	localIOException29	java.io.IOException
      //   1422	1	11	localIOException30	java.io.IOException
      //   548	314	12	str2	String
      //   584	116	13	localFile	File
      // Exception table:
      //   from	to	target	type
      //   198	209	375	java/lang/NumberFormatException
      //   90	101	401	java/io/IOException
      //   108	120	401	java/io/IOException
      //   129	170	401	java/io/IOException
      //   170	180	401	java/io/IOException
      //   187	191	401	java/io/IOException
      //   198	209	401	java/io/IOException
      //   213	245	401	java/io/IOException
      //   245	257	401	java/io/IOException
      //   262	277	401	java/io/IOException
      //   277	290	401	java/io/IOException
      //   290	322	401	java/io/IOException
      //   322	337	401	java/io/IOException
      //   379	396	401	java/io/IOException
      //   520	616	401	java/io/IOException
      //   616	622	401	java/io/IOException
      //   622	638	401	java/io/IOException
      //   638	644	401	java/io/IOException
      //   644	662	401	java/io/IOException
      //   471	476	478	java/io/IOException
      //   90	101	1047	java/lang/Exception
      //   108	120	1047	java/lang/Exception
      //   129	170	1047	java/lang/Exception
      //   170	180	1047	java/lang/Exception
      //   187	191	1047	java/lang/Exception
      //   198	209	1047	java/lang/Exception
      //   213	245	1047	java/lang/Exception
      //   245	257	1047	java/lang/Exception
      //   262	277	1047	java/lang/Exception
      //   277	290	1047	java/lang/Exception
      //   290	322	1047	java/lang/Exception
      //   322	337	1047	java/lang/Exception
      //   379	396	1047	java/lang/Exception
      //   520	616	1047	java/lang/Exception
      //   616	622	1047	java/lang/Exception
      //   622	638	1047	java/lang/Exception
      //   638	644	1047	java/lang/Exception
      //   644	662	1047	java/lang/Exception
      //   90	101	1122	java/lang/OutOfMemoryError
      //   108	120	1122	java/lang/OutOfMemoryError
      //   129	170	1122	java/lang/OutOfMemoryError
      //   170	180	1122	java/lang/OutOfMemoryError
      //   187	191	1122	java/lang/OutOfMemoryError
      //   198	209	1122	java/lang/OutOfMemoryError
      //   213	245	1122	java/lang/OutOfMemoryError
      //   245	257	1122	java/lang/OutOfMemoryError
      //   262	277	1122	java/lang/OutOfMemoryError
      //   277	290	1122	java/lang/OutOfMemoryError
      //   290	322	1122	java/lang/OutOfMemoryError
      //   322	337	1122	java/lang/OutOfMemoryError
      //   379	396	1122	java/lang/OutOfMemoryError
      //   520	616	1122	java/lang/OutOfMemoryError
      //   616	622	1122	java/lang/OutOfMemoryError
      //   622	638	1122	java/lang/OutOfMemoryError
      //   638	644	1122	java/lang/OutOfMemoryError
      //   644	662	1122	java/lang/OutOfMemoryError
      //   1192	1197	1199	java/io/IOException
      //   90	101	1203	finally
      //   108	120	1203	finally
      //   129	170	1203	finally
      //   170	180	1203	finally
      //   187	191	1203	finally
      //   198	209	1203	finally
      //   213	245	1203	finally
      //   245	257	1203	finally
      //   262	277	1203	finally
      //   277	290	1203	finally
      //   290	322	1203	finally
      //   322	337	1203	finally
      //   379	396	1203	finally
      //   520	616	1203	finally
      //   616	622	1203	finally
      //   622	638	1203	finally
      //   638	644	1203	finally
      //   644	662	1203	finally
      //   486	494	1246	java/io/IOException
      //   498	506	1251	java/io/IOException
      //   510	518	1256	java/io/IOException
      //   341	349	1261	java/io/IOException
      //   353	361	1266	java/io/IOException
      //   365	373	1271	java/io/IOException
      //   801	809	1276	java/io/IOException
      //   814	819	1281	java/io/IOException
      //   824	829	1286	java/io/IOException
      //   881	889	1291	java/io/IOException
      //   894	899	1296	java/io/IOException
      //   904	909	1301	java/io/IOException
      //   1017	1025	1306	java/io/IOException
      //   1030	1035	1311	java/io/IOException
      //   1040	1045	1316	java/io/IOException
      //   448	456	1321	java/io/IOException
      //   461	466	1326	java/io/IOException
      //   1092	1100	1331	java/io/IOException
      //   1105	1110	1336	java/io/IOException
      //   1115	1120	1341	java/io/IOException
      //   1169	1177	1346	java/io/IOException
      //   1182	1187	1351	java/io/IOException
      //   1215	1223	1356	java/io/IOException
      //   1228	1233	1361	java/io/IOException
      //   1238	1243	1366	java/io/IOException
      //   662	691	1371	finally
      //   417	423	1379	finally
      //   431	442	1379	finally
      //   699	706	1379	finally
      //   714	728	1379	finally
      //   736	746	1379	finally
      //   754	760	1379	finally
      //   768	797	1379	finally
      //   839	853	1379	finally
      //   861	872	1379	finally
      //   919	928	1379	finally
      //   936	942	1379	finally
      //   950	977	1379	finally
      //   985	994	1379	finally
      //   1002	1013	1379	finally
      //   1063	1069	1379	finally
      //   1077	1088	1379	finally
      //   1138	1144	1379	finally
      //   1152	1163	1379	finally
      //   662	691	1388	java/lang/OutOfMemoryError
      //   699	706	1396	java/lang/OutOfMemoryError
      //   714	728	1396	java/lang/OutOfMemoryError
      //   736	746	1396	java/lang/OutOfMemoryError
      //   754	760	1396	java/lang/OutOfMemoryError
      //   768	797	1396	java/lang/OutOfMemoryError
      //   839	853	1396	java/lang/OutOfMemoryError
      //   861	872	1396	java/lang/OutOfMemoryError
      //   919	928	1396	java/lang/OutOfMemoryError
      //   936	942	1396	java/lang/OutOfMemoryError
      //   950	977	1396	java/lang/OutOfMemoryError
      //   985	994	1396	java/lang/OutOfMemoryError
      //   1002	1013	1396	java/lang/OutOfMemoryError
      //   662	691	1401	java/lang/Exception
      //   699	706	1409	java/lang/Exception
      //   714	728	1409	java/lang/Exception
      //   736	746	1409	java/lang/Exception
      //   754	760	1409	java/lang/Exception
      //   768	797	1409	java/lang/Exception
      //   839	853	1409	java/lang/Exception
      //   861	872	1409	java/lang/Exception
      //   919	928	1409	java/lang/Exception
      //   936	942	1409	java/lang/Exception
      //   950	977	1409	java/lang/Exception
      //   985	994	1409	java/lang/Exception
      //   1002	1013	1409	java/lang/Exception
      //   662	691	1414	java/io/IOException
      //   699	706	1422	java/io/IOException
      //   714	728	1422	java/io/IOException
      //   736	746	1422	java/io/IOException
      //   754	760	1422	java/io/IOException
      //   768	797	1422	java/io/IOException
      //   839	853	1422	java/io/IOException
      //   861	872	1422	java/io/IOException
      //   919	928	1422	java/io/IOException
      //   936	942	1422	java/io/IOException
      //   950	977	1422	java/io/IOException
      //   985	994	1422	java/io/IOException
      //   1002	1013	1422	java/io/IOException
    }
  }
  
  public static class c
    extends AsyncTask<Void, Void, Integer>
  {
    String aIf;
    String bN;
    String beJ;
    String beK;
    boolean btc;
    int cmN;
    int cmO;
    int cmP;
    int gP;
    Bitmap mBitmap;
    long mDuration;
    int mThumbWidth;
    String mUin;
    int mUinType;
    String mVideoMd5;
    String mVideoPath;
    long mVideoSize;
    
    public c(Intent paramIntent)
    {
      this.mVideoPath = paramIntent.getExtras().getString("file_send_path");
      this.mDuration = paramIntent.getExtras().getLong("file_send_duration");
      this.mVideoSize = paramIntent.getExtras().getLong("file_send_size");
      this.mUin = paramIntent.getExtras().getString("uin");
      this.mUinType = paramIntent.getIntExtra("uintype", -1);
      this.beK = paramIntent.getStringExtra("file_source");
      this.beJ = paramIntent.getExtras().getString("activity_before_enter_send_video");
      this.btc = paramIntent.getExtras().getBoolean("send_in_background");
      this.cmP = paramIntent.getExtras().getInt("short_video_msg_tail_type");
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, " SendVideoTask(),  mVideoPath :" + this.mVideoPath + ", mDuration:" + this.mDuration + ", mFileSize:" + this.mVideoSize + ",mUin" + this.mUin + ",mUinType:" + this.mUinType + ",mFileSource:" + this.beK + ",mSendBackground = " + this.btc + ",mMsgTailType=" + this.cmP);
      }
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      return Integer.valueOf(al(BaseApplicationImpl.getApplication()));
    }
    
    /* Error */
    int al(Context paramContext)
    {
      // Byte code:
      //   0: iconst_5
      //   1: istore_3
      //   2: aload_1
      //   3: ifnonnull +7 -> 10
      //   6: iload_3
      //   7: istore_2
      //   8: iload_2
      //   9: ireturn
      //   10: invokestatic 182	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
      //   13: getstatic 188	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:lvcc	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
      //   16: invokevirtual 191	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
      //   19: ldc 193
      //   21: invokevirtual 197	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   24: astore 7
      //   26: aload 7
      //   28: ifnull +193 -> 221
      //   31: aload 7
      //   33: invokevirtual 203	java/lang/String:length	()I
      //   36: ifle +185 -> 221
      //   39: aload 7
      //   41: ldc 205
      //   43: invokevirtual 209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   46: astore 7
      //   48: aload 7
      //   50: ifnull +171 -> 221
      //   53: aload 7
      //   55: arraylength
      //   56: istore_2
      //   57: iload_2
      //   58: ifle +163 -> 221
      //   61: aload 7
      //   63: iconst_0
      //   64: aaload
      //   65: invokestatic 212	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   68: invokevirtual 215	java/lang/Integer:intValue	()I
      //   71: istore_2
      //   72: aload_1
      //   73: aload_0
      //   74: getfield 51	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mVideoPath	Ljava/lang/String;
      //   77: iload_2
      //   78: invokestatic 221	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
      //   81: astore 7
      //   83: aload 7
      //   85: astore 8
      //   87: aload 7
      //   89: ifnonnull +30 -> 119
      //   92: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   95: ifeq +11 -> 106
      //   98: ldc 110
      //   100: iconst_2
      //   101: ldc 223
      //   103: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   106: aload_0
      //   107: getfield 228	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mBitmap	Landroid/graphics/Bitmap;
      //   110: ifnull +116 -> 226
      //   113: aload_0
      //   114: getfield 228	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mBitmap	Landroid/graphics/Bitmap;
      //   117: astore 8
      //   119: aload_0
      //   120: aload 8
      //   122: invokevirtual 233	android/graphics/Bitmap:getWidth	()I
      //   125: putfield 235	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mThumbWidth	I
      //   128: aload_0
      //   129: aload 8
      //   131: invokevirtual 238	android/graphics/Bitmap:getHeight	()I
      //   134: putfield 240	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:gP	I
      //   137: aload_0
      //   138: getfield 235	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mThumbWidth	I
      //   141: ifeq +10 -> 151
      //   144: aload_0
      //   145: getfield 240	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:gP	I
      //   148: ifne +116 -> 264
      //   151: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   154: ifeq +11 -> 165
      //   157: ldc 110
      //   159: iconst_2
      //   160: ldc 242
      //   162: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   165: iconst_0
      //   166: ifeq +11 -> 177
      //   169: new 244	java/lang/NullPointerException
      //   172: dup
      //   173: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   176: athrow
      //   177: iconst_0
      //   178: ifeq +11 -> 189
      //   181: new 244	java/lang/NullPointerException
      //   184: dup
      //   185: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   188: athrow
      //   189: iconst_0
      //   190: ifeq +11 -> 201
      //   193: new 244	java/lang/NullPointerException
      //   196: dup
      //   197: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   200: athrow
      //   201: iconst_2
      //   202: ireturn
      //   203: astore 7
      //   205: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   208: ifeq +13 -> 221
      //   211: ldc 110
      //   213: iconst_2
      //   214: ldc 247
      //   216: aload 7
      //   218: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   221: iconst_0
      //   222: istore_2
      //   223: goto -151 -> 72
      //   226: iconst_0
      //   227: ifeq +11 -> 238
      //   230: new 244	java/lang/NullPointerException
      //   233: dup
      //   234: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   237: athrow
      //   238: iconst_0
      //   239: ifeq +11 -> 250
      //   242: new 244	java/lang/NullPointerException
      //   245: dup
      //   246: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   249: athrow
      //   250: iconst_0
      //   251: ifeq +11 -> 262
      //   254: new 244	java/lang/NullPointerException
      //   257: dup
      //   258: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   261: athrow
      //   262: iconst_2
      //   263: ireturn
      //   264: new 112	java/lang/StringBuilder
      //   267: dup
      //   268: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   271: ldc 252
      //   273: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: invokestatic 258	java/lang/System:currentTimeMillis	()J
      //   279: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   282: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   285: ldc_w 260
      //   288: invokestatic 263	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   291: astore 11
      //   293: new 112	java/lang/StringBuilder
      //   296: dup
      //   297: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   300: invokestatic 266	com/tencent/mobileqq/shortvideo/ShortVideoUtils:zJ	()Ljava/lang/String;
      //   303: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   306: ldc_w 268
      //   309: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   312: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   315: invokestatic 274	aqhq:UD	(Ljava/lang/String;)V
      //   318: new 276	java/io/File
      //   321: dup
      //   322: aload 11
      //   324: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
      //   327: astore 12
      //   329: new 276	java/io/File
      //   332: dup
      //   333: aload 12
      //   335: invokevirtual 281	java/io/File:getParent	()Ljava/lang/String;
      //   338: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
      //   341: astore 7
      //   343: aload 7
      //   345: invokevirtual 284	java/io/File:exists	()Z
      //   348: ifeq +11 -> 359
      //   351: aload 7
      //   353: invokevirtual 287	java/io/File:isDirectory	()Z
      //   356: ifne +9 -> 365
      //   359: aload 7
      //   361: invokevirtual 290	java/io/File:mkdirs	()Z
      //   364: pop
      //   365: aload 12
      //   367: invokevirtual 284	java/io/File:exists	()Z
      //   370: ifeq +11 -> 381
      //   373: aload 12
      //   375: invokevirtual 293	java/io/File:isFile	()Z
      //   378: ifne +9 -> 387
      //   381: aload 12
      //   383: invokevirtual 296	java/io/File:createNewFile	()Z
      //   386: pop
      //   387: new 298	java/io/BufferedOutputStream
      //   390: dup
      //   391: new 300	java/io/FileOutputStream
      //   394: dup
      //   395: aload 12
      //   397: invokespecial 303	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   400: invokespecial 306	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   403: astore 7
      //   405: aload 8
      //   407: getstatic 312	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   410: bipush 80
      //   412: aload 7
      //   414: invokevirtual 316	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   417: pop
      //   418: aload 7
      //   420: invokevirtual 319	java/io/BufferedOutputStream:flush	()V
      //   423: new 321	java/io/FileInputStream
      //   426: dup
      //   427: aload 12
      //   429: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   432: astore 8
      //   434: aload 7
      //   436: astore 10
      //   438: aload 8
      //   440: astore 9
      //   442: aload 12
      //   444: invokevirtual 324	java/io/File:length	()J
      //   447: lstore 4
      //   449: aload 7
      //   451: astore 10
      //   453: aload 8
      //   455: astore 9
      //   457: aload_0
      //   458: aload 8
      //   460: lload 4
      //   462: invokestatic 330	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
      //   465: invokestatic 336	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
      //   468: putfield 338	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:aIf	Ljava/lang/String;
      //   471: aload 7
      //   473: astore 10
      //   475: aload 8
      //   477: astore 9
      //   479: aload_0
      //   480: getfield 338	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:aIf	Ljava/lang/String;
      //   483: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   486: ifeq +93 -> 579
      //   489: aload 7
      //   491: astore 10
      //   493: aload 8
      //   495: astore 9
      //   497: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   500: ifeq +40 -> 540
      //   503: aload 7
      //   505: astore 10
      //   507: aload 8
      //   509: astore 9
      //   511: ldc 110
      //   513: iconst_2
      //   514: new 112	java/lang/StringBuilder
      //   517: dup
      //   518: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   521: ldc_w 346
      //   524: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   527: aload_0
      //   528: getfield 338	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:aIf	Ljava/lang/String;
      //   531: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   534: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   537: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   540: iconst_0
      //   541: ifeq +11 -> 552
      //   544: new 244	java/lang/NullPointerException
      //   547: dup
      //   548: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   551: athrow
      //   552: aload 7
      //   554: ifnull +8 -> 562
      //   557: aload 7
      //   559: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   562: iload_3
      //   563: istore_2
      //   564: aload 8
      //   566: ifnull -558 -> 8
      //   569: aload 8
      //   571: invokevirtual 350	java/io/FileInputStream:close	()V
      //   574: iconst_5
      //   575: ireturn
      //   576: astore_1
      //   577: iconst_5
      //   578: ireturn
      //   579: aload 7
      //   581: astore 10
      //   583: aload 8
      //   585: astore 9
      //   587: aload_0
      //   588: aload_0
      //   589: getfield 338	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:aIf	Ljava/lang/String;
      //   592: ldc_w 260
      //   595: invokestatic 263	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   598: putfield 352	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:bN	Ljava/lang/String;
      //   601: aload 7
      //   603: astore 10
      //   605: aload 8
      //   607: astore 9
      //   609: aload 11
      //   611: aload_0
      //   612: getfield 352	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:bN	Ljava/lang/String;
      //   615: invokestatic 356	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
      //   618: istore 6
      //   620: iload 6
      //   622: ifne +42 -> 664
      //   625: iconst_0
      //   626: ifeq +11 -> 637
      //   629: new 244	java/lang/NullPointerException
      //   632: dup
      //   633: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   636: athrow
      //   637: aload 7
      //   639: ifnull +8 -> 647
      //   642: aload 7
      //   644: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   647: iload_3
      //   648: istore_2
      //   649: aload 8
      //   651: ifnull -643 -> 8
      //   654: aload 8
      //   656: invokevirtual 350	java/io/FileInputStream:close	()V
      //   659: iconst_5
      //   660: ireturn
      //   661: astore_1
      //   662: iconst_5
      //   663: ireturn
      //   664: aload 7
      //   666: astore 10
      //   668: aload 8
      //   670: astore 9
      //   672: aload_1
      //   673: lload 4
      //   675: invokestatic 362	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
      //   678: astore_1
      //   679: aload 7
      //   681: astore 10
      //   683: aload 8
      //   685: astore 9
      //   687: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   690: ifeq +37 -> 727
      //   693: aload 7
      //   695: astore 10
      //   697: aload 8
      //   699: astore 9
      //   701: ldc 110
      //   703: iconst_2
      //   704: new 112	java/lang/StringBuilder
      //   707: dup
      //   708: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   711: ldc_w 364
      //   714: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   717: aload_1
      //   718: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   721: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   724: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   727: aload 7
      //   729: astore 10
      //   731: aload 8
      //   733: astore 9
      //   735: aload_0
      //   736: getfield 59	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mDuration	J
      //   739: lconst_0
      //   740: lcmp
      //   741: ifne +22 -> 763
      //   744: aload 7
      //   746: astore 10
      //   748: aload 8
      //   750: astore 9
      //   752: aload_0
      //   753: aload_0
      //   754: getfield 51	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mVideoPath	Ljava/lang/String;
      //   757: invokestatic 367	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
      //   760: putfield 59	com/tencent/mobileqq/activity/shortvideo/SendVideoActivity$c:mDuration	J
      //   763: iconst_0
      //   764: ifeq +11 -> 775
      //   767: new 244	java/lang/NullPointerException
      //   770: dup
      //   771: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   774: athrow
      //   775: aload 7
      //   777: ifnull +8 -> 785
      //   780: aload 7
      //   782: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   785: aload 8
      //   787: ifnull +8 -> 795
      //   790: aload 8
      //   792: invokevirtual 350	java/io/FileInputStream:close	()V
      //   795: iconst_1
      //   796: ireturn
      //   797: astore_1
      //   798: aconst_null
      //   799: astore 7
      //   801: aconst_null
      //   802: astore 8
      //   804: aload 7
      //   806: astore 10
      //   808: aload 8
      //   810: astore 9
      //   812: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   815: ifeq +21 -> 836
      //   818: aload 7
      //   820: astore 10
      //   822: aload 8
      //   824: astore 9
      //   826: ldc 110
      //   828: iconst_2
      //   829: ldc_w 369
      //   832: aload_1
      //   833: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   836: iconst_3
      //   837: istore_2
      //   838: iconst_0
      //   839: ifeq +11 -> 850
      //   842: new 244	java/lang/NullPointerException
      //   845: dup
      //   846: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   849: athrow
      //   850: aload 7
      //   852: ifnull +8 -> 860
      //   855: aload 7
      //   857: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   860: aload 8
      //   862: ifnull -854 -> 8
      //   865: aload 8
      //   867: invokevirtual 350	java/io/FileInputStream:close	()V
      //   870: iconst_3
      //   871: ireturn
      //   872: astore_1
      //   873: iconst_3
      //   874: ireturn
      //   875: astore 8
      //   877: aconst_null
      //   878: astore 7
      //   880: aconst_null
      //   881: astore_1
      //   882: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   885: ifeq +14 -> 899
      //   888: ldc 110
      //   890: iconst_2
      //   891: ldc_w 369
      //   894: aload 8
      //   896: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   899: iconst_0
      //   900: ifeq +11 -> 911
      //   903: new 244	java/lang/NullPointerException
      //   906: dup
      //   907: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   910: athrow
      //   911: aload 7
      //   913: ifnull +8 -> 921
      //   916: aload 7
      //   918: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   921: iload_3
      //   922: istore_2
      //   923: aload_1
      //   924: ifnull -916 -> 8
      //   927: aload_1
      //   928: invokevirtual 350	java/io/FileInputStream:close	()V
      //   931: iconst_5
      //   932: ireturn
      //   933: astore_1
      //   934: iconst_5
      //   935: ireturn
      //   936: astore_1
      //   937: aconst_null
      //   938: astore 7
      //   940: aconst_null
      //   941: astore 8
      //   943: aload 7
      //   945: astore 10
      //   947: aload 8
      //   949: astore 9
      //   951: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   954: ifeq +21 -> 975
      //   957: aload 7
      //   959: astore 10
      //   961: aload 8
      //   963: astore 9
      //   965: ldc 110
      //   967: iconst_2
      //   968: ldc_w 371
      //   971: aload_1
      //   972: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   975: iconst_4
      //   976: istore_2
      //   977: iconst_0
      //   978: ifeq +11 -> 989
      //   981: new 244	java/lang/NullPointerException
      //   984: dup
      //   985: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   988: athrow
      //   989: aload 7
      //   991: ifnull +8 -> 999
      //   994: aload 7
      //   996: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   999: aload 8
      //   1001: ifnull -993 -> 8
      //   1004: aload 8
      //   1006: invokevirtual 350	java/io/FileInputStream:close	()V
      //   1009: iconst_4
      //   1010: ireturn
      //   1011: astore_1
      //   1012: iconst_4
      //   1013: ireturn
      //   1014: astore_1
      //   1015: aconst_null
      //   1016: astore 7
      //   1018: aconst_null
      //   1019: astore 9
      //   1021: iconst_0
      //   1022: ifeq +11 -> 1033
      //   1025: new 244	java/lang/NullPointerException
      //   1028: dup
      //   1029: invokespecial 245	java/lang/NullPointerException:<init>	()V
      //   1032: athrow
      //   1033: aload 7
      //   1035: ifnull +8 -> 1043
      //   1038: aload 7
      //   1040: invokevirtual 349	java/io/BufferedOutputStream:close	()V
      //   1043: aload 9
      //   1045: ifnull +8 -> 1053
      //   1048: aload 9
      //   1050: invokevirtual 350	java/io/FileInputStream:close	()V
      //   1053: aload_1
      //   1054: athrow
      //   1055: astore_1
      //   1056: goto -818 -> 238
      //   1059: astore_1
      //   1060: goto -810 -> 250
      //   1063: astore_1
      //   1064: goto -802 -> 262
      //   1067: astore_1
      //   1068: goto -891 -> 177
      //   1071: astore_1
      //   1072: goto -883 -> 189
      //   1075: astore_1
      //   1076: goto -875 -> 201
      //   1079: astore_1
      //   1080: goto -528 -> 552
      //   1083: astore_1
      //   1084: goto -522 -> 562
      //   1087: astore_1
      //   1088: goto -451 -> 637
      //   1091: astore_1
      //   1092: goto -445 -> 647
      //   1095: astore_1
      //   1096: goto -321 -> 775
      //   1099: astore_1
      //   1100: goto -315 -> 785
      //   1103: astore_1
      //   1104: goto -309 -> 795
      //   1107: astore_1
      //   1108: goto -258 -> 850
      //   1111: astore_1
      //   1112: goto -252 -> 860
      //   1115: astore 8
      //   1117: goto -206 -> 911
      //   1120: astore 7
      //   1122: goto -201 -> 921
      //   1125: astore_1
      //   1126: goto -137 -> 989
      //   1129: astore_1
      //   1130: goto -131 -> 999
      //   1133: astore 8
      //   1135: goto -102 -> 1033
      //   1138: astore 7
      //   1140: goto -97 -> 1043
      //   1143: astore 7
      //   1145: goto -92 -> 1053
      //   1148: astore_1
      //   1149: aconst_null
      //   1150: astore 9
      //   1152: goto -131 -> 1021
      //   1155: astore_1
      //   1156: aload 10
      //   1158: astore 7
      //   1160: goto -139 -> 1021
      //   1163: astore 8
      //   1165: aload_1
      //   1166: astore 9
      //   1168: aload 8
      //   1170: astore_1
      //   1171: goto -150 -> 1021
      //   1174: astore_1
      //   1175: aconst_null
      //   1176: astore 8
      //   1178: goto -235 -> 943
      //   1181: astore_1
      //   1182: goto -239 -> 943
      //   1185: astore 8
      //   1187: aconst_null
      //   1188: astore_1
      //   1189: goto -307 -> 882
      //   1192: astore 9
      //   1194: aload 8
      //   1196: astore_1
      //   1197: aload 9
      //   1199: astore 8
      //   1201: goto -319 -> 882
      //   1204: astore_1
      //   1205: aconst_null
      //   1206: astore 8
      //   1208: goto -404 -> 804
      //   1211: astore_1
      //   1212: goto -408 -> 804
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1215	0	this	c
      //   0	1215	1	paramContext	Context
      //   7	970	2	i	int
      //   1	921	3	j	int
      //   447	227	4	l	long
      //   618	3	6	bool	boolean
      //   24	64	7	localObject1	Object
      //   203	14	7	localNumberFormatException	java.lang.NumberFormatException
      //   341	698	7	localObject2	Object
      //   1120	1	7	localIOException1	java.io.IOException
      //   1138	1	7	localIOException2	java.io.IOException
      //   1143	1	7	localIOException3	java.io.IOException
      //   1158	1	7	localObject3	Object
      //   85	781	8	localObject4	Object
      //   875	20	8	localException1	Exception
      //   941	64	8	localObject5	Object
      //   1115	1	8	localIOException4	java.io.IOException
      //   1133	1	8	localIOException5	java.io.IOException
      //   1163	6	8	localObject6	Object
      //   1176	1	8	localObject7	Object
      //   1185	10	8	localException2	Exception
      //   1199	8	8	localObject8	Object
      //   440	727	9	localObject9	Object
      //   1192	6	9	localException3	Exception
      //   436	721	10	localObject10	Object
      //   291	319	11	str	String
      //   327	116	12	localFile	File
      // Exception table:
      //   from	to	target	type
      //   61	72	203	java/lang/NumberFormatException
      //   569	574	576	java/io/IOException
      //   654	659	661	java/io/IOException
      //   10	26	797	java/io/IOException
      //   31	48	797	java/io/IOException
      //   53	57	797	java/io/IOException
      //   61	72	797	java/io/IOException
      //   72	83	797	java/io/IOException
      //   92	106	797	java/io/IOException
      //   106	119	797	java/io/IOException
      //   119	151	797	java/io/IOException
      //   151	165	797	java/io/IOException
      //   205	221	797	java/io/IOException
      //   264	359	797	java/io/IOException
      //   359	365	797	java/io/IOException
      //   365	381	797	java/io/IOException
      //   381	387	797	java/io/IOException
      //   387	405	797	java/io/IOException
      //   865	870	872	java/io/IOException
      //   10	26	875	java/lang/Exception
      //   31	48	875	java/lang/Exception
      //   53	57	875	java/lang/Exception
      //   61	72	875	java/lang/Exception
      //   72	83	875	java/lang/Exception
      //   92	106	875	java/lang/Exception
      //   106	119	875	java/lang/Exception
      //   119	151	875	java/lang/Exception
      //   151	165	875	java/lang/Exception
      //   205	221	875	java/lang/Exception
      //   264	359	875	java/lang/Exception
      //   359	365	875	java/lang/Exception
      //   365	381	875	java/lang/Exception
      //   381	387	875	java/lang/Exception
      //   387	405	875	java/lang/Exception
      //   927	931	933	java/io/IOException
      //   10	26	936	java/lang/OutOfMemoryError
      //   31	48	936	java/lang/OutOfMemoryError
      //   53	57	936	java/lang/OutOfMemoryError
      //   61	72	936	java/lang/OutOfMemoryError
      //   72	83	936	java/lang/OutOfMemoryError
      //   92	106	936	java/lang/OutOfMemoryError
      //   106	119	936	java/lang/OutOfMemoryError
      //   119	151	936	java/lang/OutOfMemoryError
      //   151	165	936	java/lang/OutOfMemoryError
      //   205	221	936	java/lang/OutOfMemoryError
      //   264	359	936	java/lang/OutOfMemoryError
      //   359	365	936	java/lang/OutOfMemoryError
      //   365	381	936	java/lang/OutOfMemoryError
      //   381	387	936	java/lang/OutOfMemoryError
      //   387	405	936	java/lang/OutOfMemoryError
      //   1004	1009	1011	java/io/IOException
      //   10	26	1014	finally
      //   31	48	1014	finally
      //   53	57	1014	finally
      //   61	72	1014	finally
      //   72	83	1014	finally
      //   92	106	1014	finally
      //   106	119	1014	finally
      //   119	151	1014	finally
      //   151	165	1014	finally
      //   205	221	1014	finally
      //   264	359	1014	finally
      //   359	365	1014	finally
      //   365	381	1014	finally
      //   381	387	1014	finally
      //   387	405	1014	finally
      //   230	238	1055	java/io/IOException
      //   242	250	1059	java/io/IOException
      //   254	262	1063	java/io/IOException
      //   169	177	1067	java/io/IOException
      //   181	189	1071	java/io/IOException
      //   193	201	1075	java/io/IOException
      //   544	552	1079	java/io/IOException
      //   557	562	1083	java/io/IOException
      //   629	637	1087	java/io/IOException
      //   642	647	1091	java/io/IOException
      //   767	775	1095	java/io/IOException
      //   780	785	1099	java/io/IOException
      //   790	795	1103	java/io/IOException
      //   842	850	1107	java/io/IOException
      //   855	860	1111	java/io/IOException
      //   903	911	1115	java/io/IOException
      //   916	921	1120	java/io/IOException
      //   981	989	1125	java/io/IOException
      //   994	999	1129	java/io/IOException
      //   1025	1033	1133	java/io/IOException
      //   1038	1043	1138	java/io/IOException
      //   1048	1053	1143	java/io/IOException
      //   405	434	1148	finally
      //   442	449	1155	finally
      //   457	471	1155	finally
      //   479	489	1155	finally
      //   497	503	1155	finally
      //   511	540	1155	finally
      //   587	601	1155	finally
      //   609	620	1155	finally
      //   672	679	1155	finally
      //   687	693	1155	finally
      //   701	727	1155	finally
      //   735	744	1155	finally
      //   752	763	1155	finally
      //   812	818	1155	finally
      //   826	836	1155	finally
      //   951	957	1155	finally
      //   965	975	1155	finally
      //   882	899	1163	finally
      //   405	434	1174	java/lang/OutOfMemoryError
      //   442	449	1181	java/lang/OutOfMemoryError
      //   457	471	1181	java/lang/OutOfMemoryError
      //   479	489	1181	java/lang/OutOfMemoryError
      //   497	503	1181	java/lang/OutOfMemoryError
      //   511	540	1181	java/lang/OutOfMemoryError
      //   587	601	1181	java/lang/OutOfMemoryError
      //   609	620	1181	java/lang/OutOfMemoryError
      //   672	679	1181	java/lang/OutOfMemoryError
      //   687	693	1181	java/lang/OutOfMemoryError
      //   701	727	1181	java/lang/OutOfMemoryError
      //   735	744	1181	java/lang/OutOfMemoryError
      //   752	763	1181	java/lang/OutOfMemoryError
      //   405	434	1185	java/lang/Exception
      //   442	449	1192	java/lang/Exception
      //   457	471	1192	java/lang/Exception
      //   479	489	1192	java/lang/Exception
      //   497	503	1192	java/lang/Exception
      //   511	540	1192	java/lang/Exception
      //   587	601	1192	java/lang/Exception
      //   609	620	1192	java/lang/Exception
      //   672	679	1192	java/lang/Exception
      //   687	693	1192	java/lang/Exception
      //   701	727	1192	java/lang/Exception
      //   735	744	1192	java/lang/Exception
      //   752	763	1192	java/lang/Exception
      //   405	434	1204	java/io/IOException
      //   442	449	1211	java/io/IOException
      //   457	471	1211	java/io/IOException
      //   479	489	1211	java/io/IOException
      //   497	503	1211	java/io/IOException
      //   511	540	1211	java/io/IOException
      //   587	601	1211	java/io/IOException
      //   609	620	1211	java/io/IOException
      //   672	679	1211	java/io/IOException
      //   687	693	1211	java/io/IOException
      //   701	727	1211	java/io/IOException
      //   735	744	1211	java/io/IOException
      //   752	763	1211	java/io/IOException
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
      switch (paramInteger.intValue())
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      default: 
        return;
      }
      paramInteger = new Intent();
      try
      {
        this.mVideoMd5 = aqhs.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(this.mVideoPath), this.mVideoSize));
        paramInteger.putExtra("uin", this.mUin);
        paramInteger.putExtra("uintype", this.mUinType);
        paramInteger.putExtra("file_send_path", this.mVideoPath);
        paramInteger.putExtra("file_send_size", this.mVideoSize);
        paramInteger.putExtra("file_send_duration", (int)(this.mDuration / 1000L));
        paramInteger.putExtra("file_source", this.beK);
        paramInteger.putExtra("thumbfile_send_path", this.bN);
        paramInteger.putExtra("file_shortvideo_md5", this.mVideoMd5);
        paramInteger.putExtra("thumbfile_send_width", this.mThumbWidth);
        paramInteger.putExtra("thumbfile_send_height", this.gP);
        paramInteger.putExtra("thumbfile_md5", this.aIf);
        paramInteger.putExtra("file_width", this.cmN);
        paramInteger.putExtra("file_height", this.cmO);
        paramInteger.putExtra("short_video_msg_tail_type", this.cmP);
        paramInteger.putExtra("file_send_business_type", 0);
        angi localangi = anfr.a(0, 0);
        localangi.c(anfr.a(0, paramInteger, localangi));
        anfr.a(localangi, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SendVideoActivity", 2, "", localException);
          }
        }
      }
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity
 * JD-Core Version:    0.7.0.1
 */