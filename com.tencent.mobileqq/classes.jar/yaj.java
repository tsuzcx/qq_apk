import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class yaj
  extends AsyncTask
{
  double jdField_a_of_type_Double;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private String c;
  private String d;
  
  public yaj(PeakActivity paramPeakActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPeakActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    long l = System.currentTimeMillis();
    int i = new MergeEditVideo().a(paramString1, paramString2, new MergeEditVideo.EditParam(CodecParam.r, paramPublishVideoEntry));
    a("[videoSynthesis]generate files|first step cost:" + (System.currentTimeMillis() - l) / 1000.0D, null);
    return i;
  }
  
  private String a(PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    for (;;)
    {
      try
      {
        str = ShortVideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir);
        File localFile = new File(str);
        localFile.getParentFile().mkdirs();
        localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130843286);
        if (TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) {
          break label417;
        }
        i = 1;
        if (i != 0)
        {
          paramPublishVideoEntry = BitmapFactory.decodeFile(paramPublishVideoEntry.doodlePath);
          localObject2 = Bitmap.createScaledBitmap(paramPublishVideoEntry, paramInt1, paramInt2, true);
          if (paramPublishVideoEntry != localObject2) {
            paramPublishVideoEntry.recycle();
          }
          localBitmap = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
          if (paramInt1 == 576) {
            break label423;
          }
          f = paramInt1 / 576.0F;
          paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
          localCanvas.drawBitmap(paramPublishVideoEntry, 20.0F, ((Bitmap)localObject2).getHeight() - 20 - paramPublishVideoEntry.getHeight(), null);
          paramPublishVideoEntry.recycle();
          paramPublishVideoEntry = localBitmap;
          if (BitmapUtils.a(paramPublishVideoEntry, Bitmap.CompressFormat.PNG, 100, localFile.getAbsolutePath())) {
            continue;
          }
          BitmapUtils.a(paramPublishVideoEntry);
          if (((Bitmap)localObject1).isRecycled()) {
            break label415;
          }
          BitmapUtils.a((Bitmap)localObject1);
          break label415;
        }
        localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas(localBitmap);
        if (paramInt1 == 576) {
          continue;
        }
        float f = paramInt1 / 576.0F;
        paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
      }
      catch (OutOfMemoryError paramPublishVideoEntry)
      {
        String str;
        Object localObject2;
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
        return null;
        paramPublishVideoEntry = (PublishVideoEntry)localObject1;
        continue;
        BitmapUtils.a(paramPublishVideoEntry);
        if (((Bitmap)localObject1).isRecycled()) {
          continue;
        }
        BitmapUtils.a((Bitmap)localObject1);
        return str;
      }
      catch (Exception paramPublishVideoEntry)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
        continue;
      }
      ((Canvas)localObject2).drawBitmap(paramPublishVideoEntry, 20.0F, paramInt2 - 20 - paramPublishVideoEntry.getHeight(), null);
      paramPublishVideoEntry.recycle();
      paramPublishVideoEntry = localBitmap;
      continue;
      label415:
      return null;
      label417:
      int i = 0;
      continue;
      label423:
      paramPublishVideoEntry = (PublishVideoEntry)localObject1;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    PeakActivity localPeakActivity;
    Object localObject2;
    do
    {
      do
      {
        return;
      } while (a());
      localPeakActivity = (PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject1 = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      localObject2 = localPeakActivity.getIntent();
    } while (localObject2 == null);
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("fakeId");
    PublishVideoEntry localPublishVideoEntry = SaveVideoActivity.a((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      localPeakActivity.setResult(1, localPeakActivity.getIntent());
      localPeakActivity.finish();
      return;
    }
    String str2 = a(localPublishVideoEntry, localPublishVideoEntry.videoWidth, localPublishVideoEntry.videoHeight);
    if (str2 == null)
    {
      a(1, localPublishVideoEntry);
      return;
    }
    if (a())
    {
      a(null, null, str2);
      return;
    }
    String str1 = localPublishVideoEntry.mLocalRawVideoDir;
    Object localObject1 = new File(localPublishVideoEntry.mLocalRawVideoDir);
    if (((File)localObject1).isFile()) {
      str1 = ((File)localObject1).getParent();
    }
    String str3 = ShortVideoUtils.a(str1);
    new File(str3).mkdirs();
    localObject1 = str3 + "mc_audio.mp4";
    int i;
    int j;
    if (localPublishVideoEntry.saveMode <= 5)
    {
      i = localPublishVideoEntry.saveMode;
      localObject2 = AudioEncoder.a(null, null, i);
      ((AudioEncoder.AudioData)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      ((AudioEncoder.AudioData)localObject2).jdField_a_of_type_JavaLangString = this.c;
      j = AudioEncoder.a(this.c);
      if (j == 0) {
        break label618;
      }
      a("checkSourceAudioIsOK: errcode=" + j, null);
      localObject1 = null;
    }
    label786:
    label791:
    label798:
    label935:
    for (;;)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      if (i == 5) {
        if (localPublishVideoEntry.getBooleanExtra("enable_flow_decode", true)) {
          localObject2 = this.jdField_b_of_type_JavaLangString;
        }
      }
      for (;;)
      {
        label342:
        long l1 = System.currentTimeMillis();
        str3 = str3 + "mc_video.mp4";
        i = a((String)localObject2, str3, localPublishVideoEntry);
        File localFile;
        label446:
        long l2;
        if (i != 0)
        {
          if (i == -1)
          {
            localFile = new File(str3);
            if (localFile.exists()) {
              localFile.delete();
            }
            FileUtils.d((String)localObject2, str3);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) || (!FileUtils.a(localPublishVideoEntry.backgroundMusicPath))) {
            break label786;
          }
          i = 1;
          localFile = new File(str1);
          str1 = ShortVideoUtils.c(localFile);
          l2 = System.currentTimeMillis();
          if ((!localPublishVideoEntry.isMuteRecordVoice) && (i == 0)) {
            break label791;
          }
        }
        for (localObject2 = null;; localObject2 = localObject1)
        {
          j = HwVideoMerge.a(str3, (String)localObject2, str1, 0);
          a("[HwVideoMerge.merge]cost:" + (System.currentTimeMillis() - l2) / 1000.0D, null);
          this.jdField_a_of_type_Double = ((System.currentTimeMillis() - l1) / 1000.0D);
          if (QLog.isColorLevel()) {
            QLog.d("SaveVideoActivity", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l1) / 1000.0D + " errorCode= " + j);
          }
          if (!a()) {
            break label798;
          }
          a((String)localObject1, str3, str2);
          return;
          i = 0;
          break;
          label618:
          l1 = System.currentTimeMillis();
          j = AudioEncoder.a((AudioEncoder.AudioData)localObject2);
          a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l1) / 1000.0D, null);
          if (j == 0) {
            break label935;
          }
          a("AudioEncoder.encodeSafely: errcode=" + j, null);
          a((String)localObject1, null, str2);
          localPeakActivity.getIntent().putExtra("error", j);
          a(1, localPublishVideoEntry);
          return;
          localObject2 = this.d;
          break label342;
          a("videoSynthesis[RESULT_FAIL_VIDEO_MERGE]: errcode=" + i, null);
          a((String)localObject1, str3, str2);
          localPeakActivity.getIntent().putExtra("error", i);
          a(1, localPublishVideoEntry);
          return;
          i = 0;
          break label446;
        }
        if (j != 0)
        {
          a((String)localObject1, str3, str2);
          localPeakActivity.getIntent().putExtra("error", j);
          a(1, localPublishVideoEntry);
          return;
        }
        if (i != 0) {}
        for (;;)
        {
          try
          {
            localObject2 = ShortVideoUtils.d(localFile);
            l1 = ShortVideoUtils.b(str1);
            FFmpegUtils.b(localPeakActivity, str1, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l1, (String)localObject2, new yak(this, str1, localPeakActivity, (String)localObject2, str2, localPublishVideoEntry));
            a((String)localObject1, str3, str2);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            a(1, localPublishVideoEntry);
            continue;
          }
          a(localPeakActivity, str1, str2, localPublishVideoEntry);
        }
      }
    }
  }
  
  private void a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isFinishing()))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramPublishVideoEntry);
      localActivity.setResult(a(paramInt), localActivity.getIntent());
      localActivity.finish();
    }
  }
  
  private void a(PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    String str = ShortVideoUtils.b();
    if (SaveVideoActivity.a() == null) {
      SaveVideoActivity.a(FFmpeg.a(paramPeakActivity.getApplicationContext()));
    }
    if (SaveVideoActivity.a().a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SaveVideoActivity", 2, "generate files mFFmpeg is running!");
      }
    }
    do
    {
      return;
      try
      {
        paramPeakActivity = new yam(this, paramPublishVideoEntry, paramString1, str);
        SaveVideoActivity.a().a(str);
        SaveVideoActivity.a().a(paramString2, paramString1, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, paramPeakActivity);
        return;
      }
      catch (Exception paramPeakActivity) {}
    } while (!QLog.isColorLevel());
    QLog.d("SaveVideoActivity", 2, "generate files save alum:" + paramPeakActivity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!"".equals(paramString1)))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
    if ((paramString2 != null) && (!"".equals(paramString2)))
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
    if ((paramString3 != null) && (!"".equals(paramString3))) {}
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("SavehwVideoActivity", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("SavehwVideoActivity", 2, "[@] " + paramString);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        a(0, SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString));
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	yaj:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 96	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: getfield 34	yaj:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   14: invokevirtual 96	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: invokespecial 220	yaj:a	()Z
    //   25: ifne -5 -> 20
    //   28: aload_0
    //   29: getfield 32	yaj:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   32: invokevirtual 96	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   35: checkcast 222	com/tencent/mobileqq/activity/aio/photo/PeakActivity
    //   38: astore 10
    //   40: aload_0
    //   41: getfield 34	yaj:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   44: invokevirtual 96	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 224	com/tencent/common/app/AppInterface
    //   50: astore 11
    //   52: aload 10
    //   54: invokevirtual 228	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   57: astore 12
    //   59: aload 12
    //   61: ifnull -41 -> 20
    //   64: aload_0
    //   65: aload 12
    //   67: ldc 230
    //   69: invokevirtual 235	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 237	yaj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload 11
    //   77: aload_0
    //   78: getfield 237	yaj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokestatic 242	com/tencent/mobileqq/activity/richmedia/SaveVideoActivity:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   84: astore 11
    //   86: aload 11
    //   88: ifnonnull +20 -> 108
    //   91: aload 10
    //   93: iconst_1
    //   94: aload 10
    //   96: invokevirtual 228	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   99: invokevirtual 246	com/tencent/mobileqq/activity/aio/photo/PeakActivity:setResult	(ILandroid/content/Intent;)V
    //   102: aload 10
    //   104: invokevirtual 249	com/tencent/mobileqq/activity/aio/photo/PeakActivity:finish	()V
    //   107: return
    //   108: aload_0
    //   109: aload 11
    //   111: aload 11
    //   113: getfield 252	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   116: aload 11
    //   118: getfield 255	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   121: invokespecial 257	yaj:a	(Lcom/tencent/biz/qqstory/database/PublishVideoEntry;II)Ljava/lang/String;
    //   124: astore 12
    //   126: aload 12
    //   128: ifnonnull +11 -> 139
    //   131: aload_0
    //   132: iconst_1
    //   133: aload 11
    //   135: invokespecial 259	yaj:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   138: return
    //   139: aload_0
    //   140: invokespecial 220	yaj:a	()Z
    //   143: ifne -123 -> 20
    //   146: invokestatic 459	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   149: astore 13
    //   151: invokestatic 464	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   154: invokevirtual 467	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   157: invokevirtual 472	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   160: pop
    //   161: ldc 207
    //   163: ldc_w 474
    //   166: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: invokespecial 220	yaj:a	()Z
    //   173: ifne -153 -> 20
    //   176: invokestatic 483	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   179: ifeq +165 -> 344
    //   182: lconst_0
    //   183: lstore 5
    //   185: aload 13
    //   187: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   190: astore 14
    //   192: aload 14
    //   194: monitorenter
    //   195: aload 13
    //   197: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   200: invokevirtual 40	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   203: istore 9
    //   205: lload 5
    //   207: lstore_3
    //   208: iload 9
    //   210: ifne +79 -> 289
    //   213: lload 5
    //   215: lstore_3
    //   216: ldc 207
    //   218: ldc_w 486
    //   221: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: lload 5
    //   226: lstore_3
    //   227: invokestatic 491	android/os/SystemClock:elapsedRealtime	()J
    //   230: lstore 7
    //   232: lload 5
    //   234: lstore_3
    //   235: aload 13
    //   237: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   240: ldc2_w 492
    //   243: invokevirtual 497	java/lang/Object:wait	(J)V
    //   246: lload 5
    //   248: lstore_3
    //   249: invokestatic 491	android/os/SystemClock:elapsedRealtime	()J
    //   252: lload 7
    //   254: lsub
    //   255: lstore 5
    //   257: lload 5
    //   259: lstore_3
    //   260: ldc 207
    //   262: new 66	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 499
    //   272: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: lload 5
    //   277: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   280: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: lload 5
    //   288: lstore_3
    //   289: aload 14
    //   291: monitorexit
    //   292: ldc 207
    //   294: ldc_w 504
    //   297: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: lload_3
    //   301: ldc2_w 505
    //   304: lcmp
    //   305: ifge +39 -> 344
    //   308: bipush 20
    //   310: lload_3
    //   311: l2i
    //   312: isub
    //   313: istore_2
    //   314: iload_2
    //   315: istore_1
    //   316: iload_2
    //   317: bipush 10
    //   319: if_icmpge +6 -> 325
    //   322: bipush 10
    //   324: istore_1
    //   325: ldc 207
    //   327: ldc_w 508
    //   330: iload_1
    //   331: invokestatic 514	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: invokestatic 517	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   337: iload_1
    //   338: i2l
    //   339: lstore_3
    //   340: lload_3
    //   341: invokestatic 522	java/lang/Thread:sleep	(J)V
    //   344: aload_0
    //   345: invokespecial 220	yaj:a	()Z
    //   348: ifne -328 -> 20
    //   351: aload 11
    //   353: getfield 275	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   356: ifeq +11 -> 367
    //   359: aload 11
    //   361: getfield 275	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   364: putstatic 525	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:J	I
    //   367: aload 11
    //   369: getfield 318	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   372: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +314 -> 689
    //   378: aload 11
    //   380: getfield 318	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   383: invokestatic 321	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   386: ifeq +303 -> 689
    //   389: iconst_1
    //   390: istore_1
    //   391: new 110	java/io/File
    //   394: dup
    //   395: aload 11
    //   397: getfield 103	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   400: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   403: astore 14
    //   405: aload 14
    //   407: invokestatic 324	com/tencent/mobileqq/shortvideo/ShortVideoUtils:c	(Ljava/io/File;)Ljava/lang/String;
    //   410: astore 13
    //   412: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   415: lstore_3
    //   416: new 527	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   419: dup
    //   420: aconst_null
    //   421: aconst_null
    //   422: aload 11
    //   424: getfield 103	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   427: aload 13
    //   429: aconst_null
    //   430: invokespecial 530	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   433: astore 15
    //   435: aload 15
    //   437: iconst_0
    //   438: invokevirtual 532	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   441: aload 15
    //   443: iconst_0
    //   444: invokevirtual 534	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   447: aload 15
    //   449: aload 11
    //   451: getfield 327	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   454: invokevirtual 536	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:d	(Z)V
    //   457: aload 11
    //   459: getfield 540	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   462: ifnull +18 -> 480
    //   465: aload 15
    //   467: aload 11
    //   469: getfield 540	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   472: aload 11
    //   474: getfield 543	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   477: invokevirtual 546	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	([BI)V
    //   480: aload 15
    //   482: invokevirtual 549	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   485: aload 15
    //   487: getfield 551	com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	I
    //   490: istore_2
    //   491: aload_0
    //   492: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   495: lload_3
    //   496: lsub
    //   497: l2d
    //   498: ldc2_w 74
    //   501: ddiv
    //   502: putfield 336	yaj:jdField_a_of_type_Double	D
    //   505: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +48 -> 556
    //   511: ldc 207
    //   513: iconst_2
    //   514: new 66	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 338
    //   524: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   530: lload_3
    //   531: lsub
    //   532: l2d
    //   533: ldc2_w 74
    //   536: ddiv
    //   537: invokevirtual 78	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   540: ldc_w 340
    //   543: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload_2
    //   547: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 343	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: aload_0
    //   557: invokespecial 220	yaj:a	()Z
    //   560: ifne -540 -> 20
    //   563: iload_2
    //   564: ifeq +130 -> 694
    //   567: aload 10
    //   569: invokevirtual 228	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   572: ldc_w 352
    //   575: iload_2
    //   576: invokevirtual 356	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   579: pop
    //   580: aload_0
    //   581: iconst_1
    //   582: aload 11
    //   584: invokespecial 259	yaj:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   587: return
    //   588: astore 14
    //   590: ldc 207
    //   592: ldc_w 553
    //   595: aload 14
    //   597: invokestatic 556	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   600: invokestatic 483	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   603: ifeq -434 -> 169
    //   606: aload 13
    //   608: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   611: astore 14
    //   613: aload 14
    //   615: monitorenter
    //   616: aload 13
    //   618: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   621: iconst_1
    //   622: invokevirtual 559	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   625: aload 13
    //   627: getfield 484	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   630: invokevirtual 562	java/lang/Object:notifyAll	()V
    //   633: aload 14
    //   635: monitorexit
    //   636: goto -467 -> 169
    //   639: astore 10
    //   641: aload 14
    //   643: monitorexit
    //   644: aload 10
    //   646: athrow
    //   647: astore 13
    //   649: ldc 207
    //   651: new 66	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 564
    //   661: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 13
    //   666: invokevirtual 567	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   669: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 479	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -389 -> 289
    //   681: astore 10
    //   683: aload 14
    //   685: monitorexit
    //   686: aload 10
    //   688: athrow
    //   689: iconst_0
    //   690: istore_1
    //   691: goto -300 -> 391
    //   694: iload_1
    //   695: ifeq +71 -> 766
    //   698: aload 14
    //   700: invokestatic 362	com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	(Ljava/io/File;)Ljava/lang/String;
    //   703: astore 14
    //   705: aload 13
    //   707: invokestatic 365	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;)J
    //   710: lstore_3
    //   711: aload 10
    //   713: aload 13
    //   715: aload 11
    //   717: getfield 318	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   720: aload 11
    //   722: getfield 368	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicOffset	I
    //   725: lload_3
    //   726: l2i
    //   727: aload 14
    //   729: new 569	yal
    //   732: dup
    //   733: aload_0
    //   734: aload 13
    //   736: aload 10
    //   738: aload 14
    //   740: aload 12
    //   742: aload 11
    //   744: invokespecial 570	yal:<init>	(Lyaj;Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   747: invokestatic 378	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/tencent/biz/qqstory/utils/ffmpeg/ExecuteBinResponseCallback;)V
    //   750: return
    //   751: astore 10
    //   753: aload 10
    //   755: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   758: aload_0
    //   759: iconst_1
    //   760: aload 11
    //   762: invokespecial 259	yaj:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   765: return
    //   766: aload_0
    //   767: aload 10
    //   769: aload 13
    //   771: aload 12
    //   773: aload 11
    //   775: invokespecial 384	yaj:a	(Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   778: return
    //   779: astore 13
    //   781: goto -437 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	yaj
    //   315	380	1	i	int
    //   313	263	2	j	int
    //   207	519	3	l1	long
    //   183	104	5	l2	long
    //   230	23	7	l3	long
    //   203	6	9	bool	boolean
    //   38	530	10	localPeakActivity1	PeakActivity
    //   639	6	10	localObject1	Object
    //   681	56	10	localPeakActivity2	PeakActivity
    //   751	17	10	localException	Exception
    //   50	724	11	localObject2	Object
    //   57	715	12	localObject3	Object
    //   149	477	13	localObject4	Object
    //   647	123	13	localInterruptedException1	java.lang.InterruptedException
    //   779	1	13	localInterruptedException2	java.lang.InterruptedException
    //   190	216	14	localObject5	Object
    //   588	8	14	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   433	53	15	localEncodeThread	com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
    // Exception table:
    //   from	to	target	type
    //   151	169	588	java/lang/UnsatisfiedLinkError
    //   616	636	639	finally
    //   641	644	639	finally
    //   216	224	647	java/lang/InterruptedException
    //   227	232	647	java/lang/InterruptedException
    //   235	246	647	java/lang/InterruptedException
    //   249	257	647	java/lang/InterruptedException
    //   260	286	647	java/lang/InterruptedException
    //   195	205	681	finally
    //   216	224	681	finally
    //   227	232	681	finally
    //   235	246	681	finally
    //   249	257	681	finally
    //   260	286	681	finally
    //   289	292	681	finally
    //   649	678	681	finally
    //   683	686	681	finally
    //   698	750	751	java/lang/Exception
    //   340	344	779	java/lang/InterruptedException
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      return null;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yaj
 * JD-Core Version:    0.7.0.1
 */