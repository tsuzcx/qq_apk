import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class aaza
  extends AsyncTask<Void, Void, Integer>
{
  private static rqa jdField_a_of_type_Rqa;
  public static ConcurrentHashMap<Long, aaza> dn = new ConcurrentHashMap();
  private boolean Fg;
  private aaza.a jdField_a_of_type_Aaza$a = new aazc(this);
  private aaza.d jdField_a_of_type_Aaza$d;
  private boolean aAW;
  private String aYX;
  private String azU;
  private boolean bBl = true;
  public boolean bBm;
  private byte[] bH;
  private byte[] bK;
  private String bN;
  private boolean byp;
  private aaza.c c;
  private Context context;
  private String fakeVid;
  private int gP;
  public PublishVideoEntry h;
  private boolean isCanceled;
  public MessageForShortVideo l;
  private int mThumbWidth;
  private String mVideoPath;
  
  public aaza(Context paramContext, String paramString, boolean paramBoolean, aaza.d paramd)
  {
    this(paramContext, paramString, paramBoolean, paramd, false);
  }
  
  public aaza(Context paramContext, String paramString, boolean paramBoolean1, aaza.d paramd, boolean paramBoolean2)
  {
    this.context = paramContext;
    this.fakeVid = paramString;
    this.jdField_a_of_type_Aaza$d = paramd;
    this.byp = paramBoolean1;
    if (paramd != null) {
      this.bN = paramd.path;
    }
    this.aAW = paramBoolean2;
  }
  
  public aaza(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, aaza.d paramd, MessageForShortVideo paramMessageForShortVideo)
  {
    this(paramContext, paramString, paramBoolean, paramd, false);
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.busiType == 1) && (paramQQAppInterface != null))
    {
      this.l = paramMessageForShortVideo;
      paramMessageForShortVideo.videoFileStatus = 998;
    }
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.b().c(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "encodeVideoTask uniseq:" + this.l.uniseq);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("EncodeVideoTask", 2, "CompressTask Init", paramQQAppInterface);
    }
  }
  
  private static void a(String paramString, PublishVideoEntry paramPublishVideoEntry, aaza.a parama)
  {
    String str = ShortVideoUtils.s(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_Rqa == null) {
      jdField_a_of_type_Rqa = rqa.a(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_Rqa.LT())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      aaza.e locale = new aaza.e(paramPublishVideoEntry, paramString, str, parama);
      jdField_a_of_type_Rqa.sH(str);
      jdField_a_of_type_Rqa.a(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, locale);
      return;
    }
    catch (Exception paramString)
    {
      parama.onError(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  public static void aq(long paramLong, int paramInt)
  {
    y(paramLong, paramInt, 0);
  }
  
  public static void y(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong <= 0L) {}
    label129:
    label133:
    for (;;)
    {
      return;
      String str = "";
      HashMap localHashMap;
      if (paramInt1 == 1)
      {
        str = "actShortVideoGenerateSource";
        if (paramInt2 == 0) {
          break label129;
        }
        localHashMap = new HashMap();
        localHashMap.put("hcState", String.valueOf(paramInt2));
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label133;
        }
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
        return;
        if (paramInt1 == 2)
        {
          str = "actShortVideoGenerateAudio";
          break;
        }
        if (paramInt1 == 3)
        {
          str = "actShortVideoGeneratePic";
          break;
        }
        if (paramInt1 == 4)
        {
          str = "actMediaCodecMergeEdit";
          break;
        }
        if (paramInt1 != 5) {
          break;
        }
        str = "actMediaCodecMergeSelfAudio";
        break;
        localHashMap = null;
      }
    }
  }
  
  public void Dm(boolean paramBoolean)
  {
    this.bBl = paramBoolean;
  }
  
  public void Dn(boolean paramBoolean)
  {
    this.Fg = paramBoolean;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.byp) {
      return c(paramVarArgs);
    }
    return b(paramVarArgs);
  }
  
  public void a(int paramInt, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.publishState == 0)) {}
    label336:
    label339:
    for (;;)
    {
      return;
      if (paramPublishVideoEntry != null)
      {
        paramPublishVideoEntry.publishState = 0;
        QQStoryContext.a().getEntityManagerFactory().createEntityManager().update(paramPublishVideoEntry);
      }
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        if (paramInt != 0) {
          break label99;
        }
      }
      label99:
      for (String str = "1";; str = "0")
      {
        rar.a("AIOMergeVideoSuc", bool, 0L, new String[] { str });
        if (paramInt == 0) {
          break label107;
        }
        rar.a("AIOMergeVideoError", true, 0L, new String[] { String.valueOf(paramInt) });
        return;
        bool = false;
        break;
      }
      label107:
      if (paramLong == 0L)
      {
        paramLong = 0L;
        if ((paramPublishVideoEntry == null) || (!paramPublishVideoEntry.isPicture)) {
          break label336;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((!axvu.dwO) || (paramInt != 0) || (!axvu.g.isEnabled())) {
          break label339;
        }
        long l1 = axvu.g.t[0];
        long l2 = axvu.g.t[1];
        long l3 = axvu.g.t[2];
        long l4 = axvu.g.t[3];
        long l5 = axvu.g.t[4];
        if ((rar.d(paramLong, 0L, 120000L)) && (rar.d(l1, 0L, 120000L)) && (rar.d(l2, 0L, 120000L)) && (rar.d(l3, 0L, 10000L)) && (rar.d(l4, 0L, 120000L)) && (rar.d(l5, 0L, 120000L))) {
          rar.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        axvu.g.stopMonitor();
        return;
        paramLong = System.currentTimeMillis() - paramLong;
        break;
      }
    }
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.fakeVid))
    {
      this.jdField_a_of_type_Aaza$a.a(-61, null, null, null, 0L);
      return Integer.valueOf(-61);
    }
    long l1 = SystemClock.uptimeMillis();
    int i = tzc.a().a(0, 1, 1, Process.myTid(), 8000, 603, 1L, Process.myTid(), "video", true);
    int j = g().intValue();
    if (j != 0) {
      this.jdField_a_of_type_Aaza$a.a(j, null, null, null, 0L);
    }
    if (i != 0) {
      tzc.a().stop(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, new Object[] { "encode cost=" + (SystemClock.uptimeMillis() - l1), " ret:", Integer.valueOf(j) });
    }
    return Integer.valueOf(j);
  }
  
  public void b(aaza.c paramc)
  {
    this.c = paramc;
  }
  
  protected Integer c(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.fakeVid)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = pog.a(this.fakeVid);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.fakeVid);
      }
      return Integer.valueOf(-2);
    }
    aniq.bQi = (int)localPublishVideoEntry.recordTime;
    aniq.dHk = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      aniq.bsT = localPublishVideoEntry.saveMode;
    }
    int i;
    label131:
    int j;
    Object localObject2;
    Object localObject1;
    long l1;
    if (localPublishVideoEntry.businessId == 2)
    {
      i = 0;
      aniq.dHn = i;
      if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
        break label385;
      }
      i = 1;
      if (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)) {
        break label390;
      }
      j = 1;
      localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
      localObject1 = ShortVideoUtils.t((File)localObject2);
      paramVarArgs = (Void[])localObject1;
      if (i == 0)
      {
        paramVarArgs = (Void[])localObject1;
        if (j == 0) {
          paramVarArgs = ShortVideoUtils.s((File)localObject2);
        }
      }
      l1 = System.currentTimeMillis();
      localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
      ((EncodeThread)localObject1).PW(false);
      ((EncodeThread)localObject1).CN(false);
      ((EncodeThread)localObject1).PY(localPublishVideoEntry.isMuteRecordVoice);
      if (localPublishVideoEntry.mMosaicMask != null) {
        ((EncodeThread)localObject1).q(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
      }
      ((EncodeThread)localObject1).run();
      aq(System.currentTimeMillis() - l1, 1);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l1) / 1000.0D);
      }
      if (i == 0) {
        break label415;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ShortVideoUtils.u((File)localObject2);
        l1 = ShortVideoUtils.getDurationOfVideo(paramVarArgs);
        localObject2 = new aaza.b(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((aaza.b)localObject2).a(this.jdField_a_of_type_Aaza$a);
        rqj.b(this.context, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l1, (String)localObject1, (rpz)localObject2);
        return Integer.valueOf(0);
        i = 1;
        break;
        label385:
        i = 0;
        break label131;
        label390:
        j = 0;
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      label415:
      this.jdField_a_of_type_Aaza$a.c(localPublishVideoEntry, paramVarArgs);
    }
  }
  
  public boolean cancel()
  {
    if (!this.bBm)
    {
      this.h.isCancel = true;
      this.isCanceled = true;
      boolean bool = ankf.axF();
      rqj.bvT();
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "shortVideoCancel, cancelMerge:" + bool);
      }
      return true;
    }
    return false;
  }
  
  protected Integer g()
  {
    long l1 = System.currentTimeMillis();
    if (axvu.dwO) {
      axvu.g.startMonitor();
    }
    PublishVideoEntry localPublishVideoEntry = pog.a(this.fakeVid);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeVid:" + this.fakeVid);
      }
      return Integer.valueOf(-62);
    }
    this.h = localPublishVideoEntry;
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeId:" + this.fakeVid + ", EntryId:" + localPublishVideoEntry.fakeVid);
      }
      ambe.j(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    String str = ShortVideoUtils.s(new File(localPublishVideoEntry.mLocalRawVideoDir).getParentFile());
    new pog().a(localPublishVideoEntry, str, false, true, new aazb(this, localPublishVideoEntry, str, l1));
    return Integer.valueOf(0);
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInteger.intValue()));
    anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
    if (paramInteger.intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, localHashMap, "");
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EncodeVideoTask", 2, "onPostExecute result:" + paramInteger);
        }
        this.c.onError(paramInteger.intValue());
      }
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong);
    
    public abstract void c(PublishVideoEntry paramPublishVideoEntry, String paramString);
    
    public abstract void d(PublishVideoEntry paramPublishVideoEntry, String paramString);
    
    public abstract void onError(int paramInt);
  }
  
  public static class b
    extends rpz
  {
    aaza.a b;
    String baM;
    PublishVideoEntry g;
    long mStartTime;
    String sourcePath;
    
    public b(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
    {
      this.g = paramPublishVideoEntry;
      this.sourcePath = paramString1;
      this.baM = paramString2;
      this.mStartTime = System.currentTimeMillis();
    }
    
    public void a(aaza.a parama)
    {
      this.b = parama;
    }
    
    public void onFailure(String paramString)
    {
      this.b.onError(-11);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|second step fail:" + paramString);
      }
    }
    
    public void onFinish(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|second step cost:" + (System.currentTimeMillis() - this.mStartTime) / 1000.0D + ", isSuccess:" + paramBoolean);
      }
      if (paramBoolean) {
        this.b.c(this.g, this.baM);
      }
    }
    
    public void onStart()
    {
      super.onStart();
    }
    
    public void onSuccess(String paramString)
    {
      aqhq.deleteFile(this.sourcePath);
      aaza.aq(System.currentTimeMillis() - this.mStartTime, 2);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
    
    public abstract void onError(int paramInt);
  }
  
  public static class d
  {
    public String beI;
    public byte[] cG;
    public int cmM;
    public String path;
    public int width;
    
    public d() {}
    
    public d(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.path = paramString1;
      this.beI = paramString2;
      this.cG = paramArrayOfByte;
      this.width = paramInt1;
      this.cmM = paramInt2;
    }
  }
  
  public static class e
    implements rqi
  {
    String Kc;
    aaza.a c;
    PublishVideoEntry g;
    long mStartTime;
    String sourcePath;
    
    public e(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, aaza.a parama)
    {
      this.g = paramPublishVideoEntry;
      this.c = parama;
      this.sourcePath = paramString1;
      this.Kc = paramString2;
      this.mStartTime = System.currentTimeMillis();
    }
    
    public void onFailure(String paramString)
    {
      this.c.onError(-12);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|third step fail:" + paramString);
      }
    }
    
    public void onFinish(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|third step cost:" + (System.currentTimeMillis() - this.mStartTime) / 1000.0D + ", isSuccess:" + paramBoolean);
      }
      if (paramBoolean) {
        this.c.d(this.g, this.Kc);
      }
    }
    
    public void onProgress(String paramString) {}
    
    public void onStart() {}
    
    public void onSuccess(String paramString)
    {
      rox.broadcastCarmera(BaseApplication.getContext(), new File(this.Kc));
      aqhq.deleteFile(this.sourcePath);
      aaza.aq(System.currentTimeMillis() - this.mStartTime, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaza
 * JD-Core Version:    0.7.0.1
 */