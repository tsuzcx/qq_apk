package com.tencent.qqmail.utilities.audio;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.AudioRecordingView;
import java.io.File;

public class QMAudioRecorder
{
  private static final String LOG_TAG = "AudioRecordTest";
  private Handler handler = new Handler();
  private boolean isRecording = false;
  private int keyboardHeight = 0;
  private RecorderCallBack mCallback;
  private Dialog mDialog;
  private String mFileName = null;
  private MediaRecorder mRecorder = null;
  private Button mStartRecord;
  private Button mStopRecord;
  private int timeCnt = 0;
  private Runnable updateAmplitude = new QMAudioRecorder.1(this);
  private Runnable updateTimer = new QMAudioRecorder.2(this);
  
  public QMAudioRecorder(int paramInt)
  {
    this.keyboardHeight = paramInt;
  }
  
  private boolean createDirIfNotExists()
  {
    return FileUtil.tryMkdirs(new File(getAudioPath()));
  }
  
  private String formatTime(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return "" + paramInt;
  }
  
  public static String getAudioPath()
  {
    return FileUtil.getExternalQQMailDirPath() + "audiorecord/";
  }
  
  public void confirmDialog(Context paramContext)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(2131692816)).setMessage(2131692815).addAction(2131691253, new QMAudioRecorder.8(this))).addAction(0, 2131692814, 2, new QMAudioRecorder.7(this))).create().show();
  }
  
  public void createRecordDialog(Context paramContext, RecorderCallBack paramRecorderCallBack)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131755366);
    localReportDialog.setContentView(new AudioRecordingView(this.keyboardHeight));
    localReportDialog.setOnKeyListener(new QMAudioRecorder.3(this, paramContext));
    Object localObject1 = localReportDialog.getWindow();
    ((Window)localObject1).setGravity(80);
    Object localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    localObject1 = (Button)localReportDialog.findViewById(2131378706);
    localObject2 = (Button)localReportDialog.findViewById(2131378782);
    Button localButton = (Button)localReportDialog.findViewById(2131364242);
    this.mStartRecord = ((Button)localObject1);
    this.mStopRecord = ((Button)localObject2);
    this.mDialog = localReportDialog;
    this.mCallback = paramRecorderCallBack;
    localButton.setOnClickListener(new QMAudioRecorder.4(this, paramContext));
    ((Button)localObject1).setOnClickListener(new QMAudioRecorder.5(this));
    ((Button)localObject2).setOnClickListener(new QMAudioRecorder.6(this));
    localReportDialog.setCanceledOnTouchOutside(true);
    localReportDialog.show();
  }
  
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public void performClickRecording(int paramInt)
  {
    paramInt = startRecording(paramInt);
    if ((!this.isRecording) && (paramInt < 0))
    {
      this.mCallback.onError(paramInt);
      return;
    }
    this.mStartRecord.setVisibility(8);
    this.mStopRecord.setVisibility(0);
    this.mDialog.setCanceledOnTouchOutside(false);
    this.handler.post(this.updateTimer);
    this.handler.post(this.updateAmplitude);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public int startRecording(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 275	com/tencent/qqmail/utilities/fileextention/FileUtil:hasSdcard	()Z
    //   3: ifeq +217 -> 220
    //   6: aload_0
    //   7: invokespecial 277	com/tencent/qqmail/utilities/audio/QMAudioRecorder:createDirIfNotExists	()Z
    //   10: ifeq +210 -> 220
    //   13: invokestatic 283	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   16: astore_2
    //   17: aload_0
    //   18: new 109	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 285
    //   28: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: iconst_1
    //   33: invokevirtual 288	java/util/Calendar:get	(I)I
    //   36: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokestatic 293	com/tencent/qqmail/utilities/dateextension/DateExtension:currentTimeString_MMdd	()Ljava/lang/String;
    //   42: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 295
    //   48: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_1
    //   52: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: ldc_w 297
    //   58: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: putfield 40	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mFileName	Ljava/lang/String;
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 42	com/tencent/qqmail/utilities/audio/QMAudioRecorder:isRecording	Z
    //   73: ifeq +7 -> 80
    //   76: aload_0
    //   77: monitorexit
    //   78: iconst_m1
    //   79: ireturn
    //   80: aload_0
    //   81: new 299	android/media/MediaRecorder
    //   84: dup
    //   85: invokespecial 300	android/media/MediaRecorder:<init>	()V
    //   88: putfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   91: aload_0
    //   92: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   95: iconst_1
    //   96: invokevirtual 303	android/media/MediaRecorder:setAudioSource	(I)V
    //   99: aload_0
    //   100: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   103: iconst_1
    //   104: invokevirtual 306	android/media/MediaRecorder:setAudioChannels	(I)V
    //   107: aload_0
    //   108: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   111: sipush 13000
    //   114: invokevirtual 309	android/media/MediaRecorder:setAudioEncodingBitRate	(I)V
    //   117: aload_0
    //   118: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   121: sipush 8000
    //   124: invokevirtual 312	android/media/MediaRecorder:setAudioSamplingRate	(I)V
    //   127: aload_0
    //   128: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   131: iconst_3
    //   132: invokevirtual 315	android/media/MediaRecorder:setOutputFormat	(I)V
    //   135: aload_0
    //   136: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   139: new 109	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   146: invokestatic 98	com/tencent/qqmail/utilities/audio/QMAudioRecorder:getAudioPath	()Ljava/lang/String;
    //   149: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: getfield 40	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mFileName	Ljava/lang/String;
    //   156: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 318	android/media/MediaRecorder:setOutputFile	(Ljava/lang/String;)V
    //   165: aload_0
    //   166: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   169: iconst_1
    //   170: invokevirtual 321	android/media/MediaRecorder:setAudioEncoder	(I)V
    //   173: aload_0
    //   174: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   177: invokevirtual 324	android/media/MediaRecorder:prepare	()V
    //   180: aload_0
    //   181: iconst_1
    //   182: putfield 42	com/tencent/qqmail/utilities/audio/QMAudioRecorder:isRecording	Z
    //   185: aload_0
    //   186: getfield 38	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mRecorder	Landroid/media/MediaRecorder;
    //   189: invokestatic 330	allc:a	(Landroid/media/MediaRecorder;)V
    //   192: aload_0
    //   193: monitorexit
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_2
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 40	com/tencent/qqmail/utilities/audio/QMAudioRecorder:mFileName	Ljava/lang/String;
    //   202: aload_0
    //   203: monitorexit
    //   204: bipush 254
    //   206: ireturn
    //   207: astore_2
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_2
    //   211: athrow
    //   212: astore_2
    //   213: goto -21 -> 192
    //   216: astore_2
    //   217: goto -44 -> 173
    //   220: iconst_m1
    //   221: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	QMAudioRecorder
    //   0	222	1	paramInt	int
    //   16	16	2	localCalendar	java.util.Calendar
    //   196	1	2	localIOException	java.io.IOException
    //   207	4	2	localObject	Object
    //   212	1	2	localRuntimeException1	java.lang.RuntimeException
    //   216	1	2	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   173	185	196	java/io/IOException
    //   69	78	207	finally
    //   80	91	207	finally
    //   91	173	207	finally
    //   173	185	207	finally
    //   185	192	207	finally
    //   192	194	207	finally
    //   197	204	207	finally
    //   208	210	207	finally
    //   185	192	212	java/lang/RuntimeException
    //   91	173	216	java/lang/RuntimeException
  }
  
  public void stopAndCallback()
  {
    stopRecording();
    String str1 = getFileName();
    if (str1 != null)
    {
      String str2 = getAudioPath() + str1;
      File localFile = new File(str2);
      if (localFile.exists()) {
        this.mCallback.onSuccess(str1, str2, localFile.length());
      }
    }
    for (;;)
    {
      this.mDialog.dismiss();
      return;
      this.mCallback.onError(-4);
      continue;
      this.mCallback.onError(-5);
    }
  }
  
  public void stopRecording()
  {
    if ((this.mRecorder != null) && (this.isRecording)) {}
    try
    {
      this.mRecorder.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QMLog.log(6, "AudioRecordTest", "stop failed");
      return;
    }
    finally
    {
      this.mRecorder.release();
      this.mRecorder = null;
      this.isRecording = false;
    }
  }
  
  public static abstract interface RecorderCallBack
  {
    public abstract void onCancel();
    
    public abstract void onError(int paramInt);
    
    public abstract void onSuccess(String paramString1, String paramString2, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.audio.QMAudioRecorder
 * JD-Core Version:    0.7.0.1
 */