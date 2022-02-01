import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask.1;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class angw
{
  private static angw a;
  private static ConcurrentHashMap<Long, WeakReference<angw.a>> iq = new ConcurrentHashMap();
  
  static
  {
    aoop.dWu();
  }
  
  public static angw a()
  {
    if (a == null) {
      a = new angw();
    }
    return a;
  }
  
  public static void a(angv.c paramc)
  {
    if (paramc == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramc);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, angv.a parama)
  {
    paramHashMap.put("param_des_bps", String.valueOf(parama.ala));
    paramHashMap.put("param_des_fps", String.valueOf(parama.alb));
    paramHashMap.put("param_des_width", String.valueOf(parama.dFA));
    paramHashMap.put("param_des_height", String.valueOf(parama.dFB));
    paramHashMap.put("param_des_res", String.valueOf(parama.dFA * parama.dFB));
  }
  
  private static void a(HashMap<String, String> paramHashMap, angv.c paramc)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramc.fileSize));
    paramHashMap.put("param_video_duration", String.valueOf(paramc.duration));
    paramHashMap.put("param_src_bps", String.valueOf(paramc.ale));
    paramHashMap.put("param_src_fps", String.valueOf(paramc.fps));
    paramHashMap.put("param_src_width", String.valueOf(paramc.width));
    paramHashMap.put("param_src_height", String.valueOf(paramc.height));
    paramHashMap.put("param_src_res", String.valueOf(paramc.width * paramc.height));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, angv.c paramc, angv.a parama, long paramLong2)
  {
    if ((paramc == null) || (parama == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramc);
      a(localHashMap, parama);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramc.fileSize > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramc.fileSize));
      }
      if ((paramLong1 > 0L) && (paramc.duration > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramc.duration));
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public angw.a a(long paramLong)
  {
    if (iq.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)iq.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (angw.a)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong, angw.a parama)
  {
    if (parama != null)
    {
      parama = new WeakReference(parama);
      iq.put(Long.valueOf(paramLong), parama);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)parama.get(), new Void[0]);
    }
  }
  
  public void ln(long paramLong)
  {
    ShortVideoTrimmer.dN.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = a(paramLong);
    if ((localObject != null) && (((angw.a)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((angw.a)localObject).isCancelled())) {
      ((angw.a)localObject).cancel(true);
    }
  }
  
  public void removeTask(long paramLong)
  {
    angw.a locala = a(paramLong);
    if (locala != null) {
      locala.awP();
    }
    iq.remove(Long.valueOf(paramLong));
  }
  
  public static class a
    extends AsyncTask<Void, Void, Integer>
  {
    private angw.b a;
    public Process a;
    private anli b;
    private boolean cFO;
    private boolean cFP;
    private WeakReference<Context> mContext;
    private String mOriginalVideoPath;
    private String mVideoMd5;
    private String mVideoPath;
    private long mVideoSize;
    private WeakReference<QQAppInterface> n;
    public MessageForShortVideo p;
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, angw.b paramb)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.mContext = new WeakReference(paramContext);
      this.jdField_a_of_type_Angw$b = paramb;
      this.p = paramMessageForShortVideo;
      this.mOriginalVideoPath = this.p.videoFileName;
      paramMessageForShortVideo.videoFileStatus = 998;
      try
      {
        paramMessageForShortVideo.serial();
        paramQQAppInterface.b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: messageForShortVideo info uniseq=" + this.p.uniseq + ", OriPath:" + this.mOriginalVideoPath);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          QLog.e("VideoCompressProcessor", 1, "CompressTask Init", paramQQAppInterface);
        }
      }
    }
    
    private int S(String paramString1, String paramString2)
    {
      long l3 = System.currentTimeMillis();
      Object localObject1 = angv.a((QQAppInterface)this.n.get());
      angv.c localc = angv.a(paramString1);
      angw.a(localc);
      boolean bool = angv.a(localc, (angv.b)localObject1);
      this.cFP = bool;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + bool);
      }
      if (this.jdField_a_of_type_Angw$b != null) {
        aurs.runOnUiThread(new VideoCompressProcessor.CompressTask.1(this, bool));
      }
      if (!bool) {
        return -1;
      }
      localObject1 = angv.a(localc, (angv.b)localObject1, this.p.sendRawVideo);
      int i = anig.az((Context)this.mContext.get());
      Object localObject2;
      label290:
      label380:
      long l1;
      label430:
      long l2;
      if ((Build.VERSION.SDK_INT >= 18) && ((i & 0x1) > 0) && ((i & 0x2) > 0))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: isHWCodecSupported = " + bool);
        }
        if (!bool) {
          break label588;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by MediaCodec");
        }
        localObject2 = new angw.c(this.n, paramString1, paramString2, (angv.a)localObject1, new angx(this));
        this.b = new anli();
        if ((!this.b.a(new File(paramString1), (anli.a)localObject2, true)) || (((angw.c)localObject2).e != null)) {
          break label568;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
        }
        i = 0;
        if (i == 0) {
          break label775;
        }
        if (!ShortVideoTrimmer.b((Context)this.mContext.get(), 0, 0)) {
          break label711;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
        }
        localObject2 = new angy(this);
        i = ShortVideoTrimmer.a((Context)this.mContext.get(), paramString1, paramString2, (QQAppInterface)this.n.get(), (ShortVideoTrimmer.b)localObject2, (angv.a)localObject1, localc);
        if (i != 0) {
          break label629;
        }
        QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress retCode=" + i + ", uni=" + this.p.uniseq);
        }
        if (i != 0) {
          break label778;
        }
        this.mVideoPath = paramString2;
        l1 = new File(paramString1).length();
        l2 = new File(this.mVideoPath).length();
        l3 = System.currentTimeMillis() - l3;
        if (i != 0) {
          break label789;
        }
      }
      label775:
      label778:
      label789:
      for (bool = true;; bool = false)
      {
        angw.a(bool, l3, localc, (angv.a)localObject1, l2);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress, cost:" + l3 + "ms, fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.p.uniseq);
        }
        return i;
        bool = false;
        break;
        label568:
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
        }
        i = -1;
        break label290;
        label588:
        if (this.jdField_a_of_type_Angw$b != null) {
          this.jdField_a_of_type_Angw$b.a(this.p, 1.0F);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "不支持硬件压缩，不管软件压缩成功或失败，均默认展示完整呼吸圈");
        }
        i = -1;
        break label290;
        try
        {
          label629:
          localObject2 = new File(paramString2);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          if (this.jdField_a_of_type_JavaLangProcess != null)
          {
            this.jdField_a_of_type_JavaLangProcess.destroy();
            this.jdField_a_of_type_JavaLangProcess = null;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i);
        break label380;
        label711:
        this.mVideoPath = this.p.videoFileName;
        QLog.e("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=" + this.p.uniseq);
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "initVideoTrimError", true, 0L, 0L, null, "", false);
        break label380;
        paramString2 = this.p.videoFileName;
        break label430;
      }
    }
    
    private String zM()
    {
      String str = "";
      if (this.p != null) {
        str = String.valueOf(this.p.uniseq);
      }
      return "uniseq = " + str;
    }
    
    protected Integer a(Void... paramVarArgs)
    {
      boolean bool2 = false;
      if ((this.mContext == null) || (this.mContext.get() == null) || (this.p == null)) {
        return Integer.valueOf(7);
      }
      if (!TextUtils.isEmpty(this.p.md5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Md5 not null, Compressed has been done, uniseq=" + this.p.uniseq);
        }
        return Integer.valueOf(5);
      }
      if ((TextUtils.isEmpty(this.p.videoFileName)) || (!aqhq.fileExistsAndNotEmpty(this.p.videoFileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoCompressProcessor", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.p.videoFileName);
        }
        return Integer.valueOf(3);
      }
      this.mOriginalVideoPath = this.p.videoFileName;
      String str = this.p.videoFileName;
      paramVarArgs = ShortVideoUtils.by(str, "mp4");
      if (TextUtils.isEmpty(paramVarArgs)) {
        return Integer.valueOf(5);
      }
      if (this.p.sendRawVideo)
      {
        paramVarArgs = ShortVideoUtils.bz(str, "mp4");
        l1 = new File(str).length();
        if (l1 < 104345600L) {
          break label368;
        }
      }
      label368:
      for (boolean bool1 = true;; bool1 = false)
      {
        this.cFO = bool1;
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 16) {
          bool1 = ShortVideoUtils.pf(this.mOriginalVideoPath);
        }
        if (bool1) {
          this.cFO = true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.p.uniseq + ", mRawCompress:" + this.cFO + ", output:" + paramVarArgs + ", isH265:" + bool1 + ", size:" + l1);
        }
        if (!TextUtils.isEmpty(paramVarArgs)) {
          break;
        }
        return Integer.valueOf(5);
      }
      if ((this.p.sendRawVideo) && (!this.cFO))
      {
        this.mVideoPath = this.p.videoFileName;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.p.uniseq);
        }
        if (this.jdField_a_of_type_Angw$b != null) {
          this.jdField_a_of_type_Angw$b.a(this.p, 1.0F);
        }
      }
      while (isCancelled())
      {
        return Integer.valueOf(11);
        if (aqhq.fileExistsAndNotEmpty(paramVarArgs))
        {
          this.mVideoPath = paramVarArgs;
          QLog.d("VideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + paramVarArgs + ", uniseq=" + this.p.uniseq);
          if (this.jdField_a_of_type_Angw$b != null) {
            this.jdField_a_of_type_Angw$b.a(this.p, 1.0F);
          }
        }
        else
        {
          if (S(str, paramVarArgs) == 0) {}
          for (;;)
          {
            this.mVideoPath = paramVarArgs;
            break;
            paramVarArgs = this.p.videoFileName;
          }
        }
      }
      if (TextUtils.isEmpty(this.mVideoPath)) {
        this.mVideoPath = this.p.videoFileName;
      }
      long l1 = new File(str).length();
      long l2 = new File(this.mVideoPath).length();
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer Over fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.p.uniseq + ", videoInput=" + str + ", mVideoPath=" + this.mVideoPath);
      }
      if (l2 > l1) {
        this.mVideoPath = this.p.videoFileName;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath = " + this.mVideoPath + ", videoInput = " + str + ", uniseq=" + this.p.uniseq);
      }
      if ((TextUtils.isEmpty(this.mVideoPath)) || (!aqhq.fileExistsAndNotEmpty(this.mVideoPath)))
      {
        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.mVideoPath + ", uniseq=" + this.p.uniseq);
        return Integer.valueOf(3);
      }
      paramVarArgs = new File(this.mVideoPath);
      if (ShortVideoUtils.C(paramVarArgs))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: supportProgressive, uniseq=" + this.p.uniseq);
        }
        this.p.supportProgressive = true;
      }
      for (;;)
      {
        this.mVideoSize = paramVarArgs.length();
        try
        {
          this.mVideoMd5 = aqhs.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(paramVarArgs), this.mVideoSize));
          if (TextUtils.isEmpty(this.mVideoMd5))
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoCompressProcessor", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + this.p.uniseq);
            }
            return Integer.valueOf(5);
            bool1 = aaze.ce.get();
            bool2 = ShortVideoUtils.pc(this.mVideoPath);
            if (QLog.isColorLevel()) {
              QLog.d("VideoCompressProcessor", 2, "CompressTask, step: not supportProgressive => moveMoovAtom, result = " + bool2 + ", uniseq=" + this.p.uniseq + ", enableProgressive = " + bool1);
            }
            this.p.supportProgressive = bool2;
          }
        }
        catch (FileNotFoundException paramVarArgs)
        {
          for (;;)
          {
            paramVarArgs.printStackTrace();
          }
        }
        catch (Exception paramVarArgs)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoCompressProcessor", 2, "", paramVarArgs);
            }
          }
          if (this.mVideoSize < 104345600L)
          {
            this.p.md5 = this.mVideoMd5;
            this.p.videoFileSize = ((int)this.mVideoSize);
            this.p.videoFileName = this.mVideoPath;
            this.p.serial();
            aqhq.copyFile(new File(this.mVideoPath), new File(ShortVideoUtils.a(this.p, "mp4")));
          }
        }
      }
      return Integer.valueOf(1);
    }
    
    public void a(angw.b paramb)
    {
      if (paramb == null) {}
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_Angw$b = paramb;
            if (AsyncTask.Status.FINISHED != getStatus()) {
              break;
            }
          } while (this.jdField_a_of_type_Angw$b == null);
          this.jdField_a_of_type_Angw$b.a(this.p, 1);
          return;
          if (!isCancelled()) {
            break;
          }
        } while (this.jdField_a_of_type_Angw$b == null);
        this.jdField_a_of_type_Angw$b.a(this.p, 3);
        return;
      } while (this.jdField_a_of_type_Angw$b == null);
      this.jdField_a_of_type_Angw$b.a(this.p, this.cFP);
    }
    
    public boolean awP()
    {
      if (this.b != null) {}
      for (boolean bool = this.b.cancel();; bool = false) {
        try
        {
          if (this.jdField_a_of_type_JavaLangProcess != null) {
            this.jdField_a_of_type_JavaLangProcess.destroy();
          }
          return bool;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return false;
        }
      }
    }
    
    public long gU()
    {
      return this.mVideoSize;
    }
    
    protected void onCancelled()
    {
      String str;
      MessageForShortVideo localMessageForShortVideo;
      if (this.n.get() != null)
      {
        str = this.p.md5;
        localMessageForShortVideo = this.p;
        localMessageForShortVideo.videoFileStatus = 1004;
        if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
          aqhq.deleteFile(ShortVideoUtils.a(localMessageForShortVideo, "mp4"));
        }
        if (!TextUtils.isEmpty(this.mOriginalVideoPath)) {
          localMessageForShortVideo.videoFileName = this.mOriginalVideoPath;
        }
        localMessageForShortVideo.md5 = null;
        localMessageForShortVideo.serial();
        ((QQAppInterface)this.n.get()).b().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
        ambj.k((QQAppInterface)this.n.get(), localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        if ((this.mContext != null) && (this.mContext.get() != null) && ((this.mContext.get() instanceof FragmentActivity)))
        {
          localObject = ((FragmentActivity)this.mContext.get()).getChatFragment();
          if (localObject != null)
          {
            localObject = ((ChatFragment)localObject).a();
            if (localObject != null) {
              ((BaseChatPie)localObject).aG(false, false);
            }
          }
        }
        if (!localMessageForShortVideo.sendRawVideo) {
          break label320;
        }
      }
      label320:
      for (Object localObject = ShortVideoUtils.bz(this.mOriginalVideoPath, "mp4");; localObject = ShortVideoUtils.by(this.mOriginalVideoPath, "mp4"))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          aqhq.deleteFile((String)localObject);
        }
        angw.a().removeTask(this.p.uniseq);
        if (QLog.isColorLevel()) {
          QLog.i("VideoCompressProcessor", 2, "CompressTask onCancelled id:" + this.p.uniseq + ", videoFileName:" + localMessageForShortVideo.videoFileName + ", md5:" + str);
        }
        if (this.jdField_a_of_type_Angw$b != null) {
          this.jdField_a_of_type_Angw$b.a(this.p, 3);
        }
        return;
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      int i = 2;
      super.onPostExecute(paramInteger);
      QLog.d("VideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + paramInteger + ", " + zM());
      if (this.jdField_a_of_type_Angw$b != null)
      {
        angw.b localb = this.jdField_a_of_type_Angw$b;
        MessageForShortVideo localMessageForShortVideo = this.p;
        if (paramInteger.intValue() == 1) {
          i = 1;
        }
        localb.a(localMessageForShortVideo, i);
      }
      while (paramInteger.intValue() == 1)
      {
        ShortVideoItemBuilder.a(this.p, (QQAppInterface)this.n.get(), (Context)this.mContext.get());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "onPostExecute, mListener is null ," + zM());
        }
      }
      ShortVideoItemBuilder.b(this.p, (QQAppInterface)this.n.get(), (Context)this.mContext.get());
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
    
    public String zN()
    {
      return this.mOriginalVideoPath;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat);
    
    public abstract void a(MessageForShortVideo paramMessageForShortVideo, int paramInt);
    
    public abstract void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean);
  }
  
  static class c
    implements anli.a
  {
    final String JV;
    angv.a jdField_a_of_type_Angv$a;
    angw.b jdField_a_of_type_Angw$b;
    final String cdL;
    Throwable e;
    WeakReference<QQAppInterface> hS;
    
    c(WeakReference<QQAppInterface> paramWeakReference, String paramString1, String paramString2, angv.a parama, angw.b paramb)
    {
      this.hS = paramWeakReference;
      this.JV = paramString2;
      this.cdL = paramString1;
      this.jdField_a_of_type_Angw$b = paramb;
      this.e = null;
      if (paramString2 == null) {
        throw new IllegalArgumentException("null == outputFilePath");
      }
      this.jdField_a_of_type_Angv$a = parama;
    }
    
    private boolean rk()
    {
      boolean bool = false;
      if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
        bool = true;
      }
      while (Build.VERSION.SDK_INT <= 19) {
        return bool;
      }
      return false;
    }
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      anli.b localb = new anli.b();
      File localFile = new File(this.JV);
      if (localFile.exists()) {
        localFile.delete();
      }
      localb.as = localFile;
      localb.scaleRate = this.jdField_a_of_type_Angv$a.scaleRate;
      localb.videoFrameRate = ((int)this.jdField_a_of_type_Angv$a.alb);
      localb.videoBitRate = ((int)this.jdField_a_of_type_Angv$a.ala);
      localb.cHX = rk();
      return localb;
    }
    
    public void ahK()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
      }
      if (this.jdField_a_of_type_Angw$b != null) {
        this.jdField_a_of_type_Angw$b.a(null, 1);
      }
    }
    
    public void f(Throwable paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
      }
      this.e = paramThrowable;
      if (this.jdField_a_of_type_Angw$b != null) {
        this.jdField_a_of_type_Angw$b.a(null, 2);
      }
    }
    
    public void onCanceled()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
      }
      if (this.jdField_a_of_type_Angw$b != null) {
        this.jdField_a_of_type_Angw$b.a(null, 3);
      }
    }
    
    public void onProgress(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
      }
      if ((this.jdField_a_of_type_Angw$b != null) && (paramInt >= 0) && (paramInt <= 10000)) {
        this.jdField_a_of_type_Angw$b.a(null, paramInt / 10000.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angw
 * JD-Core Version:    0.7.0.1
 */