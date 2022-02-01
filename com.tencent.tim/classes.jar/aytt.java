import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class aytt
  extends AsyncTask<Void, Void, Integer>
{
  private static AtomicLong w = new AtomicLong(0L);
  private awtf.a jdField_a_of_type_Awtf$a;
  private aytt.a jdField_a_of_type_Aytt$a;
  private azbt.a jdField_a_of_type_Azbt$a = new azbt.a();
  private String aIf;
  private boolean aVU;
  private String bdH;
  private String bdJ = "";
  private String bdL;
  private int ciD;
  private ProgressDialog e;
  private int eK;
  private String id;
  private boolean mIsLocal;
  private long mSessionId;
  private TextView yw;
  
  public aytt(aytt.a parama, boolean paramBoolean1, boolean paramBoolean2, awtf.a parama1)
  {
    this.jdField_a_of_type_Aytt$a = parama;
    this.mSessionId = w.getAndIncrement();
    this.bdJ = ("MediaCodecSendTask_[mSessionId=" + this.mSessionId + "]");
    this.mIsLocal = paramBoolean1;
    this.aVU = paramBoolean2;
    this.jdField_a_of_type_Awtf$a = parama1;
  }
  
  private void U(Context paramContext, int paramInt)
  {
    j("showProgressDialog", null);
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
        this.e.setCanceledOnTouchOutside(false);
        this.e.show();
        this.e.setContentView(2131559761);
        this.yw = ((TextView)this.e.findViewById(2131373180));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      j("showProgressDialog", paramContext);
    }
  }
  
  private void cancleProgressDailog()
  {
    j("cancleProgressDailog", null);
    try
    {
      if (this.e != null)
      {
        this.e.cancel();
        this.e = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void j(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d(this.bdJ, 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d(this.bdJ, 2, "[@] " + paramString);
  }
  
  private int yS()
  {
    this.bdL = this.jdField_a_of_type_Aytt$a.bdL;
    j("cacheDir=" + this.bdL, null);
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aytt$a.aAu))
    {
      j("video file empty! path=" + this.jdField_a_of_type_Aytt$a.aAu, null);
      return -300;
    }
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aytt$a.mThumbFilePath))
    {
      j("thumb file empty! path=" + this.jdField_a_of_type_Aytt$a.mThumbFilePath, null);
      return -301;
    }
    Intent localIntent = this.jdField_a_of_type_Aytt$a.E.getIntent();
    this.eK = localIntent.getIntExtra("param_entrance", 0);
    this.bdH = localIntent.getStringExtra("bless_ptv_mp4_path");
    this.id = localIntent.getStringExtra("fake_id");
    int i = azbt.a(this.jdField_a_of_type_Aytt$a.aAu, this.jdField_a_of_type_Azbt$a);
    if (i != 0)
    {
      j("MediaMetadataUtils: errcode=" + i, null);
      return i;
    }
    i = this.jdField_a_of_type_Azbt$a.mMetaData[3];
    this.ciD = (((int)ayqw.f(this.jdField_a_of_type_Aytt$a.saveMode, i) + 500) / 1000);
    if ((this.jdField_a_of_type_Aytt$a.mThumbWidth <= 0) || (this.jdField_a_of_type_Aytt$a.gP <= 0))
    {
      i = this.jdField_a_of_type_Azbt$a.mMetaData[2];
      this.jdField_a_of_type_Aytt$a.mThumbWidth = this.jdField_a_of_type_Azbt$a.mMetaData[0];
      this.jdField_a_of_type_Aytt$a.gP = this.jdField_a_of_type_Azbt$a.mMetaData[1];
      if ((i == 90) || (i == 270))
      {
        this.jdField_a_of_type_Aytt$a.mThumbWidth = this.jdField_a_of_type_Aytt$a.gP;
        this.jdField_a_of_type_Aytt$a.gP = this.jdField_a_of_type_Azbt$a.mMetaData[0];
      }
    }
    return yT();
  }
  
  /* Error */
  private int yT()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   4: getfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   11: getfield 256	aytt$a:bo	D
    //   14: aload_0
    //   15: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   18: getfield 259	aytt$a:bp	D
    //   21: invokestatic 264	aqhu:a	(Ljava/lang/String;DD)Z
    //   24: pop
    //   25: new 266	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   33: getfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   36: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 271	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   48: getfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   51: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 275	java/io/File:length	()J
    //   61: invokestatic 281	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   64: invokestatic 287	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   67: putfield 289	aytt:aIf	Ljava/lang/String;
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 292	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 289	aytt:aIf	Ljava/lang/String;
    //   82: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +23 -> 108
    //   88: aload_0
    //   89: ldc_w 300
    //   92: aconst_null
    //   93: invokespecial 96	aytt:j	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: sipush -302
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: getfield 289	aytt:aIf	Ljava/lang/String;
    //   112: ldc_w 305
    //   115: invokestatic 311	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   123: getfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 315	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   137: aload_1
    //   138: putfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_1
    //   144: invokestatic 175	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   147: ifne -6 -> 141
    //   150: aload_0
    //   151: new 64	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 317
    //   161: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 56	aytt:jdField_a_of_type_Aytt$a	Laytt$a;
    //   168: getfield 180	aytt$a:mThumbFilePath	Ljava/lang/String;
    //   171: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 319
    //   177: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokespecial 96	aytt:j	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: sipush -301
    //   194: ireturn
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -128 -> 70
    //   201: astore_2
    //   202: goto -132 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	aytt
    //   54	21	1	localFileInputStream	java.io.FileInputStream
    //   100	2	1	localIOException	java.io.IOException
    //   118	63	1	str	String
    //   195	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	1	1	localObject	Object
    //   39	19	2	localFile	java.io.File
    //   201	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   74	78	100	java/io/IOException
    //   40	55	195	java/io/FileNotFoundException
    //   55	70	201	java/io/FileNotFoundException
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    int i = yS();
    if (i != 0) {
      return Integer.valueOf(i);
    }
    j("doInBackground total:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
    return Integer.valueOf(0);
  }
  
  void cU(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.bdL);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Aytt$a.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Aytt$a.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Aytt$a.gP);
    paramIntent.putExtra("thumbfile_md5", this.aIf);
    paramIntent.putExtra("file_send_duration", this.ciD);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_Aytt$a.mContent);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_Aytt$a.mPriv);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_Aytt$a.eo);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Aytt$a.bxk);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_Aytt$a.topicId);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_Aytt$a.topicSyncQzone);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Aytt$a.fakeVid);
    paramIntent.putExtra("video_sync_to_story", this.jdField_a_of_type_Aytt$a.syncToStory);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_Aytt$a.fontId);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_Aytt$a.fontFormatType);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_Aytt$a.fontUrl);
    paramIntent.putExtra("sv_encode_max_bitrate", aniq.dFI);
    paramIntent.putExtra("sv_encode_min_bitrate", aniq.dFJ);
    if ((this.jdField_a_of_type_Aytt$a.ciC > 0) && (this.jdField_a_of_type_Aytt$a.ciI > 0)) {
      azbl.aT("sv_filter_mediacodec_fps", this.jdField_a_of_type_Aytt$a.ciI * 1000 / this.jdField_a_of_type_Aytt$a.ciC);
    }
    paramIntent.putExtra("dynamic_text", this.jdField_a_of_type_Aytt$a.cXT);
    String str = this.jdField_a_of_type_Aytt$a.E.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aytt$a.templateId))
    {
      paramIntent.putExtra("widgetinfo", this.jdField_a_of_type_Aytt$a.templateId);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aytt$a.templateName)) {
        paramIntent.putExtra("key_camera_material_name", this.jdField_a_of_type_Aytt$a.templateName);
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    int j = 0;
    cancleProgressDailog();
    if (((this.jdField_a_of_type_Aytt$a.E instanceof SplashActivity)) || ((this.jdField_a_of_type_Aytt$a.E instanceof EditVideoActivity))) {}
    for (int i = 0;; i = 1)
    {
      if (paramInteger.intValue() == 0)
      {
        paramInteger = new Intent();
        cU(paramInteger);
        if (this.jdField_a_of_type_Aytt$a.a != null)
        {
          this.jdField_a_of_type_Aytt$a.a.r(this.jdField_a_of_type_Aytt$a.E, paramInteger);
          if (i != 0) {
            this.jdField_a_of_type_Aytt$a.E.finish();
          }
          this.jdField_a_of_type_Aytt$a.E = null;
          return;
        }
        paramInteger.putExtra("uin", this.jdField_a_of_type_Aytt$a.mUin);
        paramInteger.putExtra("uintype", this.jdField_a_of_type_Aytt$a.mUinType);
        paramInteger.putExtra("troop_uin", this.jdField_a_of_type_Aytt$a.mTroopUin);
        paramInteger.putExtra("file_send_business_type", 2);
        j("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.bdL, null);
        paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_Aytt$a.E.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
        paramInteger.putExtra("video_send_aio_key_is_qim", this.jdField_a_of_type_Aytt$a.dAH);
        if (QLog.isColorLevel()) {
          QLog.d("MediaCodecSendTask", 2, "ISQIM MediaCodecSendTask#onPostExecute, isQIM = " + this.jdField_a_of_type_Aytt$a.dAH);
        }
        paramInteger.putExtra("param_key_redbag_type", this.jdField_a_of_type_Aytt$a.btb);
        paramInteger.putExtra("special_video_type", this.jdField_a_of_type_Aytt$a.specialVideoType);
        if ((this.jdField_a_of_type_Aytt$a.mUin != null) && (this.jdField_a_of_type_Aytt$a.mUin.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
        {
          paramInteger.putExtra("bless_ptv_mp4_path", this.bdH);
          paramInteger.setClass(this.jdField_a_of_type_Aytt$a.E, BlessSelectMemberActivity.class);
          paramInteger.putExtra("param_type", 9003);
          paramInteger.putExtra("param_only_friends", true);
          paramInteger.putExtra("param_donot_need_contacts", true);
          paramInteger.putExtra("param_title", this.jdField_a_of_type_Aytt$a.E.getString(2131690914));
          paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_Aytt$a.E.getString(2131691970));
          paramInteger.putExtra("param_exit_animation", 1);
          paramInteger.putExtra("param_entrance", this.eK);
          paramInteger.putExtra("param_blesstype", 2);
          paramInteger.putExtra("encode_type", 1);
          paramInteger.putExtra("fake_id", this.id);
          this.jdField_a_of_type_Aytt$a.E.startActivityForResult(paramInteger, 10007);
          i = j;
          j = i;
          label488:
          if (this.jdField_a_of_type_Awtf$a == null) {
            break label629;
          }
          this.jdField_a_of_type_Awtf$a.onComplete();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Aytt$a.E = null;
        return;
        paramInteger.setClass(this.jdField_a_of_type_Aytt$a.E, SendVideoActivity.class);
        paramInteger.putExtra("src_edited", this.aVU);
        this.jdField_a_of_type_Aytt$a.E.startActivity(paramInteger);
        break;
        QQToast.a(this.jdField_a_of_type_Aytt$a.E, acfp.m(2131708070), 0).show(this.jdField_a_of_type_Aytt$a.E.getResources().getDimensionPixelSize(2131299627));
        j = i;
        if (!QLog.isColorLevel()) {
          break label488;
        }
        QLog.d(this.bdJ, 2, "" + paramInteger);
        j = i;
        break label488;
        label629:
        if (j != 0) {
          this.jdField_a_of_type_Aytt$a.E.finish();
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    U(this.jdField_a_of_type_Aytt$a.E, 2131696921);
  }
  
  public static class a
  {
    public Activity E;
    public aaqj a;
    public String aAu;
    public String bdL;
    public double bo;
    public double bp;
    public int btb;
    public boolean bxk;
    public String cXT;
    public int ciC;
    public int ciH;
    public int ciI;
    public boolean dAH;
    public ArrayList<String> eo;
    public String fakeVid;
    public int fontFormatType;
    public int fontId;
    public String fontUrl;
    public int gP;
    public String mAudioFilePath;
    public String mContent;
    public int mPriv;
    public String mThumbFilePath;
    public int mThumbWidth;
    public String mTroopUin;
    public String mUin;
    public int mUinType;
    public int saveMode;
    public int specialVideoType;
    public boolean syncToStory;
    public String templateId;
    public String templateName;
    public String topicId;
    public boolean topicSyncQzone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytt
 * JD-Core Version:    0.7.0.1
 */