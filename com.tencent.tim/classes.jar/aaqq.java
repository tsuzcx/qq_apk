import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class aaqq
  extends AsyncTask<Void, Void, Integer>
{
  private static AtomicLong w = new AtomicLong(0L);
  private aaqq.a jdField_a_of_type_Aaqq$a;
  private ankk.a jdField_a_of_type_Ankk$a = new ankk.a();
  private String aIf;
  private String bdH;
  private String bdJ = "";
  private String bdL;
  private int ciD;
  private ProgressDialog e;
  private int eK;
  private String id;
  private long mSessionId;
  private TextView yw;
  
  public aaqq(aaqq.a parama)
  {
    this.jdField_a_of_type_Aaqq$a = parama;
    this.mSessionId = w.getAndIncrement();
    this.bdJ = ("MediaCodecSendTask_[mSessionId=" + this.mSessionId + "]");
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
  
  private void cV(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_RECORDED", true);
    paramIntent.putExtra("file_video_source_dir", this.bdL);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Aaqq$a.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Aaqq$a.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Aaqq$a.gP);
    paramIntent.putExtra("thumbfile_md5", this.aIf);
    paramIntent.putExtra("file_send_duration", this.ciD * 1000);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Aaqq$a.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_Aaqq$a.bxp);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_Aaqq$a.bxq);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", aniq.dFI);
    localBundle.putInt("sv_encode_min_bitrate", aniq.dFJ);
    localBundle.putInt("sv_total_record_time", this.ciD);
    paramIntent.putExtra("encode_video_params", localBundle);
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
    if (paramThrowable != null)
    {
      QLog.i(this.bdJ, 1, "[@] " + paramString, paramThrowable);
      return;
    }
    QLog.i(this.bdJ, 1, "[@] " + paramString);
  }
  
  private int yS()
  {
    this.bdL = this.jdField_a_of_type_Aaqq$a.bdL;
    j("cacheDir=" + this.bdL, null);
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aaqq$a.aAu))
    {
      j("video file empty! path=" + this.jdField_a_of_type_Aaqq$a.aAu, null);
      return -300;
    }
    if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aaqq$a.mThumbFilePath))
    {
      j("thumb file empty! path=" + this.jdField_a_of_type_Aaqq$a.mThumbFilePath, null);
      return -301;
    }
    Intent localIntent = this.jdField_a_of_type_Aaqq$a.E.getIntent();
    this.eK = localIntent.getIntExtra("param_entrance", 0);
    this.bdH = localIntent.getStringExtra("bless_ptv_mp4_path");
    this.id = localIntent.getStringExtra("fake_id");
    int i = ankk.a(this.jdField_a_of_type_Aaqq$a.aAu, this.jdField_a_of_type_Ankk$a);
    if (i != 0)
    {
      j("MediaMetadataUtils: errcode=" + i, null);
      return i;
    }
    if (localIntent.getBooleanExtra("from_qzone_slideshow", false)) {}
    for (i = this.jdField_a_of_type_Aaqq$a.ciC;; i = this.jdField_a_of_type_Ankk$a.mMetaData[3])
    {
      this.ciD = ((i + 500) / 1000);
      if ((this.jdField_a_of_type_Aaqq$a.mThumbWidth <= 0) || (this.jdField_a_of_type_Aaqq$a.gP <= 0))
      {
        i = this.jdField_a_of_type_Ankk$a.mMetaData[2];
        this.jdField_a_of_type_Aaqq$a.mThumbWidth = this.jdField_a_of_type_Ankk$a.mMetaData[0];
        this.jdField_a_of_type_Aaqq$a.gP = this.jdField_a_of_type_Ankk$a.mMetaData[1];
        if ((i == 90) || (i == 270))
        {
          this.jdField_a_of_type_Aaqq$a.mThumbWidth = this.jdField_a_of_type_Aaqq$a.gP;
          this.jdField_a_of_type_Aaqq$a.gP = this.jdField_a_of_type_Ankk$a.mMetaData[0];
        }
      }
      return yT();
    }
  }
  
  /* Error */
  private int yT()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   4: getfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   11: getfield 316	aaqq$a:bo	D
    //   14: aload_0
    //   15: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   18: getfield 319	aaqq$a:bp	D
    //   21: invokestatic 324	aqhu:a	(Ljava/lang/String;DD)Z
    //   24: pop
    //   25: new 326	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   33: getfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   36: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 331	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   48: getfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   51: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 335	java/io/File:length	()J
    //   61: invokestatic 341	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   64: invokestatic 347	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   67: putfield 167	aaqq:aIf	Ljava/lang/String;
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 350	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 167	aaqq:aIf	Ljava/lang/String;
    //   82: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +23 -> 108
    //   88: aload_0
    //   89: ldc_w 358
    //   92: aconst_null
    //   93: invokespecial 86	aaqq:j	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: sipush -302
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 361	java/io/IOException:printStackTrace	()V
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: getfield 167	aaqq:aIf	Ljava/lang/String;
    //   112: ldc_w 363
    //   115: invokestatic 369	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   123: getfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 373	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   137: aload_1
    //   138: putfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_1
    //   144: invokestatic 248	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   147: ifne -6 -> 141
    //   150: aload_0
    //   151: new 60	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 375
    //   161: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 52	aaqq:jdField_a_of_type_Aaqq$a	Laaqq$a;
    //   168: getfield 150	aaqq$a:mThumbFilePath	Ljava/lang/String;
    //   171: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 377
    //   177: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokespecial 86	aaqq:j	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	205	0	this	aaqq
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
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_Aaqq$a.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_Aaqq$a.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_Aaqq$a.gP);
    paramIntent.putExtra("thumbfile_md5", this.aIf);
    paramIntent.putExtra("file_send_duration", this.ciD);
    paramIntent.putExtra("sv_total_record_time", this.ciD);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_Aaqq$a.mContent);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_Aaqq$a.mPriv);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_Aaqq$a.eo);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_Aaqq$a.bxk);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_Aaqq$a.topicId);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_Aaqq$a.topicSyncQzone);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_Aaqq$a.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_Aaqq$a.bxp);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_Aaqq$a.bxq);
    paramIntent.putExtra("qzone_video_sync_to_qqstory", this.jdField_a_of_type_Aaqq$a.isSyncToQQStory);
    paramIntent.putExtra("qzone_video_topic", this.jdField_a_of_type_Aaqq$a.qzoneVerticalVideoTopicInfo);
    paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_Aaqq$a.bxr);
    paramIntent.putExtra("video_sync_to_story", this.jdField_a_of_type_Aaqq$a.syncToStory);
    paramIntent.putExtra("param.fromAIO", this.jdField_a_of_type_Aaqq$a.isFromAIO);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_Aaqq$a.fontId);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_Aaqq$a.fontFormatType);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_Aaqq$a.fontUrl);
    paramIntent.putExtra("extra_key_super_font_id", this.jdField_a_of_type_Aaqq$a.superFontId);
    paramIntent.putExtra("extra_key_super_font_info", this.jdField_a_of_type_Aaqq$a.bdK);
    paramIntent.putExtra("sv_encode_max_bitrate", aniq.dFI);
    paramIntent.putExtra("sv_encode_min_bitrate", aniq.dFJ);
    if ((this.jdField_a_of_type_Aaqq$a.ciC > 0) && (this.jdField_a_of_type_Aaqq$a.ciI > 0)) {
      anjk.aT("sv_filter_mediacodec_fps", this.jdField_a_of_type_Aaqq$a.ciI * 1000 / this.jdField_a_of_type_Aaqq$a.ciC);
    }
    String str = this.jdField_a_of_type_Aaqq$a.E.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    int i = 1;
    cancleProgressDailog();
    if (paramInteger.intValue() == 0)
    {
      if (this.jdField_a_of_type_Aaqq$a.cii == 3)
      {
        paramInteger = new Intent(this.jdField_a_of_type_Aaqq$a.E.getIntent());
        cV(paramInteger);
        paramInteger.setFlags(536870912);
        if (paramInteger.getStringExtra("qzone_plugin_activity_name") == null) {
          QzonePluginProxyActivity.x(paramInteger, "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
        }
        avpw.a(this.jdField_a_of_type_Aaqq$a.E, "", paramInteger, -1);
        this.jdField_a_of_type_Aaqq$a.E.finish();
        this.jdField_a_of_type_Aaqq$a.E = null;
        return;
      }
      if (this.jdField_a_of_type_Aaqq$a.cii == 5)
      {
        paramInteger = new Intent(this.jdField_a_of_type_Aaqq$a.E.getIntent());
        cV(paramInteger);
        paramInteger.setClass(this.jdField_a_of_type_Aaqq$a.E, NewPhotoListActivity.class);
        paramInteger.addFlags(603979776);
        this.jdField_a_of_type_Aaqq$a.E.startActivity(paramInteger);
        this.jdField_a_of_type_Aaqq$a.E.finish();
        this.jdField_a_of_type_Aaqq$a.E = null;
        return;
      }
      paramInteger = new Intent();
      cU(paramInteger);
      if (this.jdField_a_of_type_Aaqq$a.a != null)
      {
        this.jdField_a_of_type_Aaqq$a.a.r(this.jdField_a_of_type_Aaqq$a.E, paramInteger);
        this.jdField_a_of_type_Aaqq$a.E.finish();
        this.jdField_a_of_type_Aaqq$a.E = null;
        return;
      }
      paramInteger.putExtra("uin", this.jdField_a_of_type_Aaqq$a.mUin);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_Aaqq$a.mUinType);
      paramInteger.putExtra("troop_uin", this.jdField_a_of_type_Aaqq$a.mTroopUin);
      paramInteger.putExtra("file_send_business_type", 2);
      j("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.bdL, null);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_Aaqq$a.E.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("param_key_redbag_type", this.jdField_a_of_type_Aaqq$a.btb);
      paramInteger.putExtra("special_video_type", this.jdField_a_of_type_Aaqq$a.specialVideoType);
      if ((this.jdField_a_of_type_Aaqq$a.mUin != null) && (this.jdField_a_of_type_Aaqq$a.mUin.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.bdH);
        paramInteger.setClass(this.jdField_a_of_type_Aaqq$a.E, BlessSelectMemberActivity.class);
        paramInteger.putExtra("param_type", 9003);
        paramInteger.putExtra("param_only_friends", true);
        paramInteger.putExtra("param_donot_need_contacts", true);
        paramInteger.putExtra("param_title", this.jdField_a_of_type_Aaqq$a.E.getString(2131690914));
        paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_Aaqq$a.E.getString(2131691970));
        paramInteger.putExtra("param_exit_animation", 1);
        paramInteger.putExtra("param_entrance", this.eK);
        paramInteger.putExtra("param_blesstype", 2);
        paramInteger.putExtra("encode_type", 1);
        paramInteger.putExtra("fake_id", this.id);
        this.jdField_a_of_type_Aaqq$a.E.startActivityForResult(paramInteger, 10007);
        if (i == 0) {
          this.jdField_a_of_type_Aaqq$a.E.finish();
        }
        this.jdField_a_of_type_Aaqq$a.E = null;
        return;
      }
      paramInteger.setClass(this.jdField_a_of_type_Aaqq$a.E, SendVideoActivity.class);
      this.jdField_a_of_type_Aaqq$a.E.startActivity(paramInteger);
    }
    for (;;)
    {
      i = 0;
      break;
      QQToast.a(this.jdField_a_of_type_Aaqq$a.E, acfp.m(2131708071), 0).show(this.jdField_a_of_type_Aaqq$a.E.getResources().getDimensionPixelSize(2131299627));
      QLog.e(this.bdJ, 1, "" + paramInteger);
      j("onPostExecute(), MediaCodecSendTask error = " + paramInteger, null);
    }
  }
  
  protected void onPreExecute()
  {
    U(this.jdField_a_of_type_Aaqq$a.E, 2131696921);
  }
  
  public static class a
  {
    public Activity E;
    public aaqj a;
    public String aAu;
    public String bdK;
    public String bdL;
    public double bo;
    public double bp;
    public int btb;
    public boolean bxk;
    public boolean bxm;
    public boolean bxp;
    public boolean bxq;
    public boolean bxr;
    public int ciC;
    public int ciH;
    public int ciI;
    public int cii;
    public ArrayList<String> eo;
    public String fakeVid;
    public int fontFormatType;
    public int fontId;
    public String fontUrl;
    public int gP;
    public boolean isFromAIO;
    public boolean isSyncToQQStory;
    public String mAudioFilePath;
    public String mContent;
    public int mPriv;
    public String mThumbFilePath;
    public int mThumbWidth;
    public String mTroopUin;
    public String mUin;
    public int mUinType;
    public QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
    public int specialVideoType;
    public int superFontId;
    public boolean syncToStory;
    public String topicId;
    public boolean topicSyncQzone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */