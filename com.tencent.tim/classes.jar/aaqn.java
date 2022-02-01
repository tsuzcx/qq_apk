import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask.1;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask.3;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class aaqn
  extends AsyncTask<Void, Void, Integer>
{
  static long Mn;
  private static AtomicLong w = new AtomicLong(0L);
  public Activity E;
  long Mm;
  aaqj a;
  boolean aGY;
  boolean aIJ;
  String aIf;
  public String bdG;
  String bdH;
  String bdI;
  public String bdJ = "";
  public String bdK;
  double bo;
  double bp;
  boolean bxk;
  boolean bxl;
  public boolean bxm;
  boolean bxn = false;
  public boolean bxo;
  int ciC;
  int ciD;
  public int ciE;
  int ciF;
  int cii;
  public RMVideoStateMgr d;
  String doodlePath;
  float dw;
  ProgressDialog e;
  int eK;
  ArrayList<String> eo;
  String fakeVid;
  int fontFormatType;
  int fontId;
  String fontUrl;
  int gP;
  String id;
  String mContent;
  int mOrientationDegree = 0;
  int mPriv;
  long mSessionId = 0L;
  long mStartTime;
  String mThumbFilePath;
  int mThumbWidth;
  String mTroopUin;
  String mUin;
  int mUinType;
  int recordFrames;
  int saveMode;
  public int superFontId;
  boolean syncToStory;
  String topicId;
  boolean topicSyncQzone;
  TextView yw;
  
  static
  {
    Mn = 20000L;
    boolean bool = anii.isFoundProductManufacturer(anii.KEY_IO_RW_VERY_SLOW_MODLE);
    if (QLog.isColorLevel()) {
      QLog.d("FlowSendTask", 2, "KEY_IO_RW_VERY_SLOW_MODLE: ioSlow=" + bool);
    }
    if (bool) {
      Mn = 46000L;
    }
  }
  
  public aaqn(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3, String paramString3, int paramInt4, ArrayList<String> paramArrayList, boolean paramBoolean2, String paramString4, boolean paramBoolean3, int paramInt5, int paramInt6, String paramString5)
  {
    this.mContent = paramString3;
    this.mPriv = paramInt4;
    this.eo = paramArrayList;
    this.bxk = paramBoolean2;
    this.topicId = paramString4;
    this.topicSyncQzone = paramBoolean3;
    this.fontId = paramInt5;
    this.fontFormatType = paramInt6;
    this.fontUrl = paramString5;
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt2, paramInt3);
  }
  
  public aaqn(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3, String paramString3, int paramInt4, ArrayList<String> paramArrayList, boolean paramBoolean2, String paramString4, boolean paramBoolean3, String paramString5, String paramString6, int paramInt5, int paramInt6, String paramString7, String paramString8, long paramLong, int paramInt7, boolean paramBoolean4)
  {
    this(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt2, paramInt3, paramString3, paramInt4, paramArrayList, paramBoolean2, paramString4, paramBoolean3, paramString5, paramString6, paramLong);
    this.fakeVid = paramString8;
    this.fontId = paramInt5;
    this.fontFormatType = paramInt6;
    this.fontUrl = paramString7;
    this.saveMode = paramInt7;
    this.aGY = paramBoolean4;
  }
  
  public aaqn(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3, String paramString3, int paramInt4, ArrayList<String> paramArrayList, boolean paramBoolean2, String paramString4, boolean paramBoolean3, String paramString5, String paramString6, int paramInt5, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.mContent = paramString3;
    this.mPriv = paramInt4;
    this.eo = paramArrayList;
    this.bxk = paramBoolean2;
    this.topicId = paramString4;
    this.topicSyncQzone = paramBoolean3;
    this.bdI = paramString5;
    this.doodlePath = paramString6;
    this.saveMode = paramInt5;
    this.syncToStory = paramBoolean5;
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt2, paramInt3);
  }
  
  public aaqn(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3, String paramString3, int paramInt4, ArrayList<String> paramArrayList, boolean paramBoolean2, String paramString4, boolean paramBoolean3, String paramString5, String paramString6, long paramLong)
  {
    this.mContent = paramString3;
    this.mPriv = paramInt4;
    this.eo = paramArrayList;
    this.bxk = paramBoolean2;
    this.topicId = paramString4;
    this.topicSyncQzone = paramBoolean3;
    this.bdI = paramString5;
    this.doodlePath = paramString6;
    this.Mm = paramLong;
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt2, paramInt3);
  }
  
  public aaqn(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    a(paramActivity, paramRMVideoStateMgr, paramString1, paramInt1, paramString2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramaaqj, paramInt2, paramInt3);
  }
  
  private void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, String paramString1, int paramInt1, String paramString2, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, aaqj paramaaqj, int paramInt2, int paramInt3)
  {
    this.E = paramActivity;
    this.d = paramRMVideoStateMgr;
    this.bdG = paramRMVideoStateMgr.bdG;
    if (this.Mm != 0L)
    {
      this.ciC = ((int)this.Mm);
      this.mSessionId = w.getAndIncrement();
      this.bdJ = ("FlowSendTask_[mSessionId=" + this.mSessionId + "]");
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "FlowSendTask(): structureMethod: totalFrame=" + paramInt3);
      }
      if (paramInt3 > 0) {
        break label814;
      }
      this.recordFrames = paramRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "FlowSendTask(): structureMethod: recordFrames=" + this.recordFrames);
      }
      label163:
      this.ciF = (this.d.b.cjI * this.d.b.cjJ * 3 / 2);
      this.a = paramaaqj;
      this.bxn = false;
      this.mOrientationDegree = paramInt2;
      this.mUin = paramString1;
      this.mUinType = paramInt1;
      this.mTroopUin = paramString2;
      this.dw = paramFloat;
      this.bxm = paramBoolean;
      this.aIJ = false;
      this.ciD = ((this.ciC + 500) / 1000);
      this.mThumbWidth = 320;
      if ((RMVideoStateMgr.byU) && (!paramBoolean)) {
        this.mThumbWidth = paramRMVideoStateMgr.b.cjI;
      }
      if (paramBoolean)
      {
        paramActivity = paramActivity.getIntent();
        this.eK = paramActivity.getIntExtra("param_entrance", 0);
        this.bxl = paramActivity.getBooleanExtra("edit_web", false);
        this.id = paramActivity.getStringExtra("fake_id");
        this.bdH = paramActivity.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "FlowSendTask() constructor : isPTV:" + this.bxm + ", mVideoFileDir:" + this.bdG + " recordTime=" + this.ciC + " mVideoRecordTime=" + this.ciD + " recordFrames=" + this.recordFrames);
      }
      this.gP = ((int)(this.mThumbWidth / this.dw));
      if (this.gP % 2 > 0) {
        this.gP -= 1;
      }
      this.ciE = 0;
      if (!VideoEnvironment.awS()) {
        break label823;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new FlowSendTask.1(this));
    }
    for (;;)
    {
      paramActivity = paramRMVideoStateMgr.jdField_a_of_type_Aate.a();
      if ((paramActivity != null) && (paramActivity.thumbPath != null) && (paramActivity.state.get() == 3))
      {
        this.mThumbWidth = paramActivity.width;
        this.gP = paramActivity.height;
        this.mThumbFilePath = paramActivity.thumbPath;
        this.aIf = paramActivity.md5;
        this.aIJ = true;
      }
      boolean bool = anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL);
      if (bool) {
        this.aIJ = false;
      }
      if ((!TextUtils.isEmpty(this.bdI)) && (aqhq.fileExistsAndNotEmpty(this.bdI))) {
        this.mThumbFilePath = this.bdI;
      }
      if (bool) {
        this.mThumbFilePath = null;
      }
      paramRMVideoStateMgr.Xg();
      this.bo = paramDouble1;
      this.bp = paramDouble2;
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "FlowSendTask(): isPTV:" + paramBoolean + ", mVideoFileDir:" + this.bdG + ",mVideoRecordTime: " + this.ciD + ", recordFrames: " + this.recordFrames + ",mThumbWidth: " + this.mThumbWidth + ", mThumbHeight:" + this.gP + ", mLatitude:" + this.bo + ", mLongitude:" + this.bp + ", mThumbOK:" + this.aIJ + ", mergeThumbPath:" + this.bdI + ", saveMode:" + this.saveMode);
      }
      return;
      this.ciC = ((int)paramRMVideoStateMgr.bL);
      break;
      label814:
      this.recordFrames = paramInt3;
      break label163;
      try
      {
        label823:
        aniu.a().a().recordSubmit();
      }
      catch (UnsatisfiedLinkError paramActivity)
      {
        paramActivity.printStackTrace();
        this.ciE = -6;
      }
    }
  }
  
  private void cV(Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.IS_VIDEO_RECORDED", true);
    paramIntent.putExtra("file_video_source_dir", this.bdG);
    paramIntent.putExtra("thumbfile_send_path", this.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.gP);
    paramIntent.putExtra("thumbfile_md5", this.aIf);
    paramIntent.putExtra("file_send_duration", this.ciC);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.aGY);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", aniq.dFI);
    localBundle.putInt("sv_encode_min_bitrate", aniq.dFJ);
    localBundle.putInt("sv_encode_qmax", aniq.dFK);
    localBundle.putInt("sv_encode_qmin", aniq.dFL);
    localBundle.putInt("sv_encode_qmaxdiff", aniq.dFM);
    localBundle.putInt("sv_total_frame_count", this.recordFrames);
    localBundle.putInt("sv_total_record_time", this.ciC);
    paramIntent.putExtra("video_mood_timer_delete", this.bxo);
    localBundle.putInt("sv_encode_totaltime_adjust", aniq.dHo);
    localBundle.putInt("sv_encode_timestamp_fix", aniq.dHp);
    localBundle.putInt("sv_encode_bless_audio_time_low", aniq.dHq);
    localBundle.putInt("sv_encode_bless_audio_time_high", aniq.dHr);
    localBundle.putInt("sv_encode_bless_audio_time_ratio", aniq.dHs);
    paramIntent.putExtra("encode_video_params", localBundle);
  }
  
  public void CN(boolean paramBoolean)
  {
    this.bxn = paramBoolean;
  }
  
  public void Gg(int paramInt)
  {
    this.cii = paramInt;
  }
  
  public void U(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.bdJ, 2, "showProgressDialog");
    }
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
        QLog.e(this.bdJ, 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 609	android/os/SystemClock:elapsedRealtime	()J
    //   4: putfield 611	aaqn:mStartTime	J
    //   7: aload_0
    //   8: getfield 312	aaqn:ciE	I
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: getfield 312	aaqn:ciE	I
    //   18: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: areturn
    //   22: invokestatic 317	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   25: ifeq +269 -> 294
    //   28: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +14 -> 45
    //   34: aload_0
    //   35: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   38: iconst_2
    //   39: ldc_w 619
    //   42: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: lconst_0
    //   46: lstore 7
    //   48: aload_0
    //   49: getfield 191	aaqn:d	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   52: getfield 623	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 191	aaqn:d	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   62: getfield 623	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   65: invokevirtual 627	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   68: istore 9
    //   70: lload 7
    //   72: lstore 5
    //   74: iload 9
    //   76: ifne +128 -> 204
    //   79: lload 7
    //   81: lstore_3
    //   82: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +17 -> 102
    //   88: lload 7
    //   90: lstore_3
    //   91: aload_0
    //   92: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   95: iconst_2
    //   96: ldc_w 629
    //   99: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: lload 7
    //   104: lstore_3
    //   105: invokestatic 609	android/os/SystemClock:elapsedRealtime	()J
    //   108: lstore 5
    //   110: lload 7
    //   112: lstore_3
    //   113: aload_0
    //   114: getfield 189	aaqn:E	Landroid/app/Activity;
    //   117: new 631	com/tencent/mobileqq/activity/richmedia/FlowSendTask$2
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 632	com/tencent/mobileqq/activity/richmedia/FlowSendTask$2:<init>	(Laaqn;)V
    //   125: invokevirtual 635	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   128: lload 7
    //   130: lstore_3
    //   131: aload_0
    //   132: getfield 191	aaqn:d	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   135: getfield 623	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   138: getstatic 87	aaqn:Mn	J
    //   141: invokevirtual 640	java/lang/Object:wait	(J)V
    //   144: lload 7
    //   146: lstore_3
    //   147: invokestatic 609	android/os/SystemClock:elapsedRealtime	()J
    //   150: lload 5
    //   152: lsub
    //   153: lstore 7
    //   155: lload 7
    //   157: lstore 5
    //   159: lload 7
    //   161: lstore_3
    //   162: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +39 -> 204
    //   168: lload 7
    //   170: lstore_3
    //   171: aload_0
    //   172: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   175: iconst_2
    //   176: new 106	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 642
    //   186: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: lload 7
    //   191: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   194: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: lload 7
    //   202: lstore 5
    //   204: aload_1
    //   205: monitorexit
    //   206: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +14 -> 223
    //   212: aload_0
    //   213: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   216: iconst_2
    //   217: ldc_w 644
    //   220: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: lload 5
    //   225: getstatic 87	aaqn:Mn	J
    //   228: lcmp
    //   229: iflt +65 -> 294
    //   232: bipush 249
    //   234: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: areturn
    //   238: astore 10
    //   240: lload_3
    //   241: lstore 5
    //   243: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -42 -> 204
    //   249: aload_0
    //   250: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   253: iconst_2
    //   254: new 106	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 646
    //   264: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 10
    //   269: invokevirtual 649	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: lload_3
    //   282: lstore 5
    //   284: goto -80 -> 204
    //   287: astore 10
    //   289: aload_1
    //   290: monitorexit
    //   291: aload 10
    //   293: athrow
    //   294: aload_0
    //   295: invokevirtual 652	aaqn:yR	()I
    //   298: istore_2
    //   299: iload_2
    //   300: ifeq +42 -> 342
    //   303: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +31 -> 337
    //   309: aload_0
    //   310: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   313: iconst_2
    //   314: new 106	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 654
    //   324: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_2
    //   328: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: iload_2
    //   338: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: areturn
    //   342: aload_0
    //   343: getfield 255	aaqn:aIJ	Z
    //   346: ifne +13 -> 359
    //   349: aload_0
    //   350: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   353: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: ifne +256 -> 612
    //   359: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: aload_0
    //   366: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   369: iconst_2
    //   370: ldc_w 656
    //   373: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload_0
    //   377: getfield 131	aaqn:mOrientationDegree	I
    //   380: bipush 90
    //   382: if_icmpeq +13 -> 395
    //   385: aload_0
    //   386: getfield 131	aaqn:mOrientationDegree	I
    //   389: sipush 270
    //   392: if_icmpne +21 -> 413
    //   395: aload_0
    //   396: getfield 259	aaqn:mThumbWidth	I
    //   399: istore_2
    //   400: aload_0
    //   401: aload_0
    //   402: getfield 310	aaqn:gP	I
    //   405: putfield 259	aaqn:mThumbWidth	I
    //   408: aload_0
    //   409: iload_2
    //   410: putfield 310	aaqn:gP	I
    //   413: aload_0
    //   414: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   417: aload_0
    //   418: getfield 393	aaqn:bo	D
    //   421: aload_0
    //   422: getfield 395	aaqn:bp	D
    //   425: invokestatic 661	aqhu:a	(Ljava/lang/String;DD)Z
    //   428: ifeq +119 -> 547
    //   431: new 663	java/io/File
    //   434: dup
    //   435: aload_0
    //   436: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   439: invokespecial 666	java/io/File:<init>	(Ljava/lang/String;)V
    //   442: astore 10
    //   444: new 668	java/io/FileInputStream
    //   447: dup
    //   448: aload_0
    //   449: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   452: invokespecial 669	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   455: astore_1
    //   456: aload_0
    //   457: aload_1
    //   458: aload 10
    //   460: invokevirtual 672	java/io/File:length	()J
    //   463: invokestatic 678	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   466: invokestatic 684	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   469: putfield 371	aaqn:aIf	Ljava/lang/String;
    //   472: aload_1
    //   473: ifnull +7 -> 480
    //   476: aload_1
    //   477: invokevirtual 687	java/io/FileInputStream:close	()V
    //   480: aload_0
    //   481: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   484: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +33 -> 520
    //   490: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +14 -> 507
    //   496: aload_0
    //   497: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   500: iconst_2
    //   501: ldc_w 689
    //   504: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: iconst_m1
    //   508: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: areturn
    //   512: astore_1
    //   513: aload_1
    //   514: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   517: goto -37 -> 480
    //   520: aload_0
    //   521: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   524: ldc_w 692
    //   527: invokestatic 698	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_0
    //   532: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   535: aload_1
    //   536: invokestatic 702	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   539: ifeq +13 -> 552
    //   542: aload_0
    //   543: aload_1
    //   544: putfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   547: iconst_0
    //   548: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: areturn
    //   552: aload_1
    //   553: invokestatic 388	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   556: ifne -9 -> 547
    //   559: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +44 -> 606
    //   565: aload_0
    //   566: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   569: iconst_2
    //   570: new 106	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 704
    //   580: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_0
    //   584: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   587: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 706
    //   593: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: bipush 254
    //   608: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: areturn
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 196	aaqn:bdG	Ljava/lang/String;
    //   617: aload_0
    //   618: getfield 259	aaqn:mThumbWidth	I
    //   621: aload_0
    //   622: getfield 310	aaqn:gP	I
    //   625: aload_0
    //   626: getfield 131	aaqn:mOrientationDegree	I
    //   629: getstatic 712	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   632: invokestatic 717	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:b	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   635: putfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 131	aaqn:mOrientationDegree	I
    //   642: bipush 90
    //   644: if_icmpeq +13 -> 657
    //   647: aload_0
    //   648: getfield 131	aaqn:mOrientationDegree	I
    //   651: sipush 270
    //   654: if_icmpne +21 -> 675
    //   657: aload_0
    //   658: getfield 259	aaqn:mThumbWidth	I
    //   661: istore_2
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 310	aaqn:gP	I
    //   667: putfield 259	aaqn:mThumbWidth	I
    //   670: aload_0
    //   671: iload_2
    //   672: putfield 310	aaqn:gP	I
    //   675: aload_0
    //   676: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   679: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   682: ifeq +26 -> 708
    //   685: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +14 -> 702
    //   691: aload_0
    //   692: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   695: iconst_2
    //   696: ldc_w 719
    //   699: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: bipush 254
    //   704: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: areturn
    //   708: aload_0
    //   709: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   712: aload_0
    //   713: getfield 393	aaqn:bo	D
    //   716: aload_0
    //   717: getfield 395	aaqn:bp	D
    //   720: invokestatic 661	aqhu:a	(Ljava/lang/String;DD)Z
    //   723: pop
    //   724: new 663	java/io/File
    //   727: dup
    //   728: aload_0
    //   729: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   732: invokespecial 666	java/io/File:<init>	(Ljava/lang/String;)V
    //   735: astore 11
    //   737: aload 11
    //   739: invokevirtual 722	java/io/File:exists	()Z
    //   742: ifeq +473 -> 1215
    //   745: new 668	java/io/FileInputStream
    //   748: dup
    //   749: aload_0
    //   750: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   753: invokespecial 669	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   756: astore 10
    //   758: aload 10
    //   760: astore_1
    //   761: aload_0
    //   762: aload 10
    //   764: aload 11
    //   766: invokevirtual 672	java/io/File:length	()J
    //   769: invokestatic 678	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   772: invokestatic 684	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   775: putfield 371	aaqn:aIf	Ljava/lang/String;
    //   778: aload 10
    //   780: ifnull +8 -> 788
    //   783: aload 10
    //   785: invokevirtual 687	java/io/FileInputStream:close	()V
    //   788: aload_0
    //   789: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   792: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   795: ifeq +33 -> 828
    //   798: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq +14 -> 815
    //   804: aload_0
    //   805: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   808: iconst_2
    //   809: ldc_w 689
    //   812: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: iconst_m1
    //   816: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: areturn
    //   820: astore_1
    //   821: aload_1
    //   822: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   825: goto -37 -> 788
    //   828: aload_0
    //   829: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   832: ldc_w 692
    //   835: invokestatic 698	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   838: astore_1
    //   839: aload_0
    //   840: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   843: aload_1
    //   844: invokestatic 725	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   847: ifeq +13 -> 860
    //   850: aload_0
    //   851: aload_1
    //   852: putfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   855: iconst_0
    //   856: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: areturn
    //   860: aload_1
    //   861: invokestatic 388	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   864: ifne -9 -> 855
    //   867: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   870: ifeq +44 -> 914
    //   873: aload_0
    //   874: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   877: iconst_2
    //   878: new 106	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 704
    //   888: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_0
    //   892: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   895: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 706
    //   901: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_1
    //   905: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: bipush 254
    //   916: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   919: areturn
    //   920: astore 11
    //   922: aconst_null
    //   923: astore 10
    //   925: aload 10
    //   927: astore_1
    //   928: aload 11
    //   930: invokevirtual 726	java/io/FileNotFoundException:printStackTrace	()V
    //   933: aload 10
    //   935: ifnull +8 -> 943
    //   938: aload 10
    //   940: invokevirtual 687	java/io/FileInputStream:close	()V
    //   943: aload_0
    //   944: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   947: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   950: ifeq +33 -> 983
    //   953: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   956: ifeq +14 -> 970
    //   959: aload_0
    //   960: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   963: iconst_2
    //   964: ldc_w 689
    //   967: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   970: iconst_m1
    //   971: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: areturn
    //   975: astore_1
    //   976: aload_1
    //   977: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   980: goto -37 -> 943
    //   983: aload_0
    //   984: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   987: ldc_w 692
    //   990: invokestatic 698	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   993: astore_1
    //   994: aload_0
    //   995: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   998: aload_1
    //   999: invokestatic 725	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1002: ifeq +11 -> 1013
    //   1005: aload_0
    //   1006: aload_1
    //   1007: putfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1010: goto -155 -> 855
    //   1013: aload_1
    //   1014: invokestatic 388	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   1017: ifne -162 -> 855
    //   1020: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1023: ifeq +44 -> 1067
    //   1026: aload_0
    //   1027: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   1030: iconst_2
    //   1031: new 106	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 704
    //   1041: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_0
    //   1045: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1048: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: ldc_w 706
    //   1054: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload_1
    //   1058: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: bipush 254
    //   1069: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1072: areturn
    //   1073: astore 10
    //   1075: aconst_null
    //   1076: astore_1
    //   1077: aload_1
    //   1078: ifnull +7 -> 1085
    //   1081: aload_1
    //   1082: invokevirtual 687	java/io/FileInputStream:close	()V
    //   1085: aload_0
    //   1086: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   1089: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1092: ifeq +33 -> 1125
    //   1095: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1098: ifeq +14 -> 1112
    //   1101: aload_0
    //   1102: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   1105: iconst_2
    //   1106: ldc_w 689
    //   1109: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: iconst_m1
    //   1113: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1116: areturn
    //   1117: astore_1
    //   1118: aload_1
    //   1119: invokevirtual 690	java/io/IOException:printStackTrace	()V
    //   1122: goto -37 -> 1085
    //   1125: aload_0
    //   1126: getfield 371	aaqn:aIf	Ljava/lang/String;
    //   1129: ldc_w 692
    //   1132: invokestatic 698	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1135: astore_1
    //   1136: aload_0
    //   1137: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1140: aload_1
    //   1141: invokestatic 725	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1144: ifeq +11 -> 1155
    //   1147: aload_0
    //   1148: aload_1
    //   1149: putfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1152: aload 10
    //   1154: athrow
    //   1155: aload_1
    //   1156: invokestatic 388	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   1159: ifne -7 -> 1152
    //   1162: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1165: ifeq +44 -> 1209
    //   1168: aload_0
    //   1169: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   1172: iconst_2
    //   1173: new 106	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 704
    //   1183: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload_0
    //   1187: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1190: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc_w 706
    //   1196: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload_1
    //   1200: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1209: bipush 254
    //   1211: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1214: areturn
    //   1215: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1218: ifeq +34 -> 1252
    //   1221: aload_0
    //   1222: getfield 137	aaqn:bdJ	Ljava/lang/String;
    //   1225: iconst_2
    //   1226: new 106	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 728
    //   1236: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload_0
    //   1240: getfield 366	aaqn:mThumbFilePath	Ljava/lang/String;
    //   1243: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1252: bipush 254
    //   1254: invokestatic 617	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1257: areturn
    //   1258: astore 10
    //   1260: goto -183 -> 1077
    //   1263: astore 11
    //   1265: goto -340 -> 925
    //   1268: astore_1
    //   1269: aconst_null
    //   1270: astore_1
    //   1271: goto -799 -> 472
    //   1274: astore 10
    //   1276: goto -804 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1279	0	this	aaqn
    //   0	1279	1	paramVarArgs	Void[]
    //   298	374	2	i	int
    //   81	201	3	l1	long
    //   72	211	5	l2	long
    //   46	155	7	l3	long
    //   68	7	9	bool	boolean
    //   238	30	10	localInterruptedException	java.lang.InterruptedException
    //   287	5	10	localObject1	java.lang.Object
    //   442	497	10	localObject2	java.lang.Object
    //   1073	80	10	localObject3	java.lang.Object
    //   1258	1	10	localObject4	java.lang.Object
    //   1274	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   735	30	11	localFile	File
    //   920	9	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   1263	1	11	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   82	88	238	java/lang/InterruptedException
    //   91	102	238	java/lang/InterruptedException
    //   105	110	238	java/lang/InterruptedException
    //   113	128	238	java/lang/InterruptedException
    //   131	144	238	java/lang/InterruptedException
    //   147	155	238	java/lang/InterruptedException
    //   162	168	238	java/lang/InterruptedException
    //   171	200	238	java/lang/InterruptedException
    //   58	70	287	finally
    //   82	88	287	finally
    //   91	102	287	finally
    //   105	110	287	finally
    //   113	128	287	finally
    //   131	144	287	finally
    //   147	155	287	finally
    //   162	168	287	finally
    //   171	200	287	finally
    //   204	206	287	finally
    //   243	281	287	finally
    //   289	291	287	finally
    //   476	480	512	java/io/IOException
    //   783	788	820	java/io/IOException
    //   745	758	920	java/io/FileNotFoundException
    //   938	943	975	java/io/IOException
    //   745	758	1073	finally
    //   1081	1085	1117	java/io/IOException
    //   761	778	1258	finally
    //   928	933	1258	finally
    //   761	778	1263	java/io/FileNotFoundException
    //   444	456	1268	java/io/FileNotFoundException
    //   456	472	1274	java/io/FileNotFoundException
  }
  
  void cU(Intent paramIntent)
  {
    paramIntent.putExtra("file_video_source_dir", this.bdG);
    paramIntent.putExtra("thumbfile_send_path", this.mThumbFilePath);
    paramIntent.putExtra("thumbfile_send_width", this.mThumbWidth);
    paramIntent.putExtra("thumbfile_send_height", this.gP);
    paramIntent.putExtra("thumbfile_md5", this.aIf);
    paramIntent.putExtra("file_send_duration", this.ciD);
    paramIntent.putExtra("sv_encode_max_bitrate", aniq.dFI);
    paramIntent.putExtra("sv_encode_min_bitrate", aniq.dFJ);
    paramIntent.putExtra("sv_encode_qmax", aniq.dFK);
    paramIntent.putExtra("sv_encode_qmin", aniq.dFL);
    paramIntent.putExtra("sv_encode_qmaxdiff", aniq.dFM);
    paramIntent.putExtra("sv_encode_ref_frame", aniq.dFN);
    paramIntent.putExtra("sv_encode_smooth", aniq.dFO);
    paramIntent.putExtra("sv_total_frame_count", this.recordFrames);
    paramIntent.putExtra("sv_total_record_time", this.ciC);
    paramIntent.putExtra("sv_encode_totaltime_adjust", aniq.dHo);
    paramIntent.putExtra("sv_encode_timestamp_fix", aniq.dHp);
    paramIntent.putExtra("sv_encode_bless_audio_time_low", aniq.dHq);
    paramIntent.putExtra("sv_encode_bless_audio_time_high", aniq.dHr);
    paramIntent.putExtra("sv_encode_bless_audio_time_ratio", aniq.dHs);
    paramIntent.putExtra("sv_encode_baseline_mp4", false);
    paramIntent.putExtra("video_mood_content", this.mContent);
    paramIntent.putExtra("video_mood_priv", this.mPriv);
    paramIntent.putExtra("video_mood_privUinList", this.eo);
    paramIntent.putExtra("enable_edit_video", this.bxk);
    paramIntent.putExtra("video_topic_id", this.topicId);
    paramIntent.putExtra("video_topic_sync_qzone", this.topicSyncQzone);
    paramIntent.putExtra("video_new_fake_vid", this.fakeVid);
    paramIntent.putExtra("video_is_generate_gif", this.aGY);
    paramIntent.putExtra("video_mood_timer_delete", this.bxo);
    paramIntent.putExtra("video_sync_to_story", this.syncToStory);
    paramIntent.putExtra("extra_key_font_id", this.fontId);
    paramIntent.putExtra("extra_key_font_format_type", this.fontFormatType);
    paramIntent.putExtra("extra_key_font_url", this.fontUrl);
    paramIntent.putExtra("extra_key_super_font_id", this.superFontId);
    paramIntent.putExtra("extra_key_super_font_info", this.bdK);
    anjk.aT("sv_filter_mp4_fps", this.recordFrames * 1000 / this.ciC);
    String str = this.E.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
  }
  
  void cancleProgressDailog()
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.bdJ, 2, "cancleProgressDailog");
    }
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
    cancleProgressDailog();
    if (paramInteger.intValue() == 0)
    {
      if (this.a == null) {}
      for (paramInteger = "";; paramInteger = this.a.getRefer())
      {
        boolean bool1 = this.E.getIntent().getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean bool2 = this.E.getIntent().getBooleanExtra("forward_source_from_pre_guide", false);
        if ((!VideoEnvironment.awS()) || ("From_HealthBusiness".equals(paramInteger)) || (bool1) || (bool2)) {
          break label237;
        }
        if ((this.cii != 3) || (!(this.E instanceof NewFlowCameraActivity))) {
          break;
        }
        paramInteger = new Intent(this.E.getIntent());
        String str = paramInteger.getStringExtra("PhotoConst.PLUGIN_APK");
        bool1 = paramInteger.getBooleanExtra("DirectBackToQzone", false);
        if (("qzone_plugin.apk".equals(str)) && (bool1))
        {
          cV(paramInteger);
          paramInteger.setFlags(536870912);
          avpw.a(this.E, "", paramInteger, -1);
        }
        this.E.finish();
        return;
      }
      if (((this.E instanceof FlowCameraActivity2)) || (((this.E instanceof NewFlowCameraActivity)) && (!this.bxm)))
      {
        this.E.setResult(1001);
        this.E.finish();
      }
      label237:
      paramInteger = new Intent();
      cU(paramInteger);
      if (this.a != null)
      {
        this.a.r(this.E, paramInteger);
        return;
      }
      paramInteger.putExtra("uin", this.mUin);
      paramInteger.putExtra("uintype", this.mUinType);
      paramInteger.putExtra("troop_uin", this.mTroopUin);
      if (!this.bxm) {
        break label761;
      }
    }
    label444:
    label761:
    for (int i = 3;; i = 2)
    {
      paramInteger.putExtra("file_send_business_type", i);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.E.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("ab_test_generate_thumb_cost_time", SystemClock.elapsedRealtime() - this.mStartTime);
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "onPostExecute(), SendVideoTask is to start  SendVideoActivity,mVideoFileDir = " + this.bdG);
      }
      if ((this.mUin != null) && (this.mUin.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.bdH);
        if (this.bxl)
        {
          i = 10007;
          paramInteger.setClass(this.E, BlessSelectMemberActivity.class);
          paramInteger.putExtra("param_type", 9003);
          paramInteger.putExtra("param_only_friends", true);
          paramInteger.putExtra("param_donot_need_contacts", true);
          paramInteger.putExtra("param_title", this.E.getString(2131690914));
          paramInteger.putExtra("param_done_button_wording", this.E.getString(2131691970));
          paramInteger.putExtra("param_exit_animation", 1);
          paramInteger.putExtra("param_entrance", this.eK);
          paramInteger.putExtra("param_blesstype", 2);
          paramInteger.putExtra("encode_type", 2);
          paramInteger.putExtra("fake_id", this.id);
          this.E.startActivityForResult(paramInteger, i);
        }
      }
      for (;;)
      {
        this.E = null;
        if (!this.bxn) {
          break;
        }
        aqhq.cn(this.bdG);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.bdJ, 2, "onPostExecute() delete cache...");
        return;
        i = 10003;
        break label444;
        paramInteger.setClass(this.E, SendVideoActivity.class);
        this.E.startActivity(paramInteger);
      }
      QQToast.a(this.E, acfp.m(2131706368), 0).show(this.E.getResources().getDimensionPixelSize(2131299627));
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "onPostExecute(), SendVideoTask error = " + paramInteger);
      }
      if (!VideoEnvironment.awS()) {
        break;
      }
      if ((!this.bxm) && ((this.E instanceof FlowCameraActivity2)))
      {
        ThreadManager.getSubThreadHandler().postDelayed(new FlowSendTask.3(this), 1000L);
        return;
      }
      this.E = null;
      return;
    }
  }
  
  int yR()
  {
    if (this.bdG == null) {}
    File localFile;
    String[] arrayOfString;
    do
    {
      do
      {
        return -3;
        if (this.ciC <= 0) {
          return -9;
        }
        localFile = new File(this.bdG);
      } while ((!localFile.exists()) || (!localFile.isDirectory()));
      arrayOfString = localFile.list();
    } while (arrayOfString == null);
    if (QLog.isColorLevel()) {
      QLog.d(this.bdJ, 2, "checkVideoSourceValidate(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(arrayOfString) + ",filse count = " + localFile.listFiles().length);
    }
    int n = arrayOfString.length;
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < n)
    {
      String str = arrayOfString[i];
      if (QLog.isColorLevel()) {
        QLog.d(this.bdJ, 2, "checkVideoSourceValidate(), current file = " + str);
      }
      if (str.endsWith(".af")) {
        k = 1;
      }
      int m = j;
      if (str.endsWith(".vf"))
      {
        long l = aqhq.getFileSizes(localFile.getAbsolutePath() + "/" + str);
        if (QLog.isColorLevel()) {
          QLog.d(this.bdJ, 2, "checkVideoSourceValidate(), videofilesize = " + l);
        }
        if (this.recordFrames >= 10) {
          this.ciF *= 5;
        }
        m = j;
        if (l > this.ciF) {
          m = 1;
        }
      }
      i += 1;
      j = m;
    }
    if (this.recordFrames <= 0) {
      return -8;
    }
    if (k == 0) {
      return -4;
    }
    if (j == 0) {
      return -5;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqn
 * JD-Core Version:    0.7.0.1
 */