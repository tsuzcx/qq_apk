import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ahcj
{
  public static String TAG = "UniformDownloader<FileAssistant>";
  final long Zd;
  private ahcj.a a;
  private final Bundle bb;
  private Bundle bc;
  private ahcj.b c = new ahck(this);
  private boolean cfZ;
  private boolean cga;
  private Object dM = new Object();
  private Object dN = new Object();
  private int mDownloadType = 0;
  private List<ahcj.b> mListeners = new ArrayList();
  private int mRetryCount;
  private final String mUrl;
  
  public ahcj(long paramLong, String paramString, Bundle paramBundle)
  {
    this.mUrl = paramString;
    this.bb = paramBundle;
    this.Zd = paramLong;
    this.cga = false;
    this.cfZ = false;
  }
  
  /* Error */
  private boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 91	ahcj:a	Lahcj$a;
    //   8: ifnull +24 -> 32
    //   11: aload_0
    //   12: getfield 91	ahcj:a	Lahcj$a;
    //   15: aconst_null
    //   16: invokeinterface 94 2 0
    //   21: pop
    //   22: aload_0
    //   23: getfield 91	ahcj:a	Lahcj$a;
    //   26: invokeinterface 98 1 0
    //   31: pop
    //   32: iload_1
    //   33: ifeq +96 -> 129
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 46	ahcj:mDownloadType	I
    //   41: aload_0
    //   42: new 100	ahcl
    //   45: dup
    //   46: aload_0
    //   47: getfield 68	ahcj:Zd	J
    //   50: invokespecial 103	ahcl:<init>	(J)V
    //   53: putfield 91	ahcj:a	Lahcj$a;
    //   56: aload_0
    //   57: getfield 91	ahcj:a	Lahcj$a;
    //   60: aload_0
    //   61: getfield 62	ahcj:c	Lahcj$b;
    //   64: invokeinterface 94 2 0
    //   69: pop
    //   70: iload_3
    //   71: istore_1
    //   72: aload_0
    //   73: getfield 91	ahcj:a	Lahcj$a;
    //   76: aload_0
    //   77: getfield 64	ahcj:mUrl	Ljava/lang/String;
    //   80: aload_2
    //   81: invokeinterface 107 3 0
    //   86: ifeq +39 -> 125
    //   89: getstatic 39	ahcj:TAG	Ljava/lang/String;
    //   92: iconst_1
    //   93: new 109	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   100: ldc 112
    //   102: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 68	ahcj:Zd	J
    //   109: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 121
    //   114: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: iload_1
    //   128: ireturn
    //   129: aload_0
    //   130: iconst_2
    //   131: putfield 46	ahcj:mDownloadType	I
    //   134: aload_0
    //   135: new 132	ahcq
    //   138: dup
    //   139: aload_0
    //   140: getfield 68	ahcj:Zd	J
    //   143: invokespecial 133	ahcq:<init>	(J)V
    //   146: putfield 91	ahcj:a	Lahcj$a;
    //   149: goto -93 -> 56
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ahcj
    //   0	157	1	paramBoolean	boolean
    //   0	157	2	paramBundle	Bundle
    //   1	70	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	152	finally
    //   36	56	152	finally
    //   56	70	152	finally
    //   72	123	152	finally
    //   129	149	152	finally
  }
  
  public static String em(int paramInt)
  {
    String str = acfp.m(2131716233);
    switch (paramInt)
    {
    default: 
      return str + "[" + String.valueOf(paramInt) + "]";
    case 0: 
      return "";
    case 1: 
      return str + "[" + String.valueOf(paramInt) + "]";
    case 2: 
      return acfp.m(2131716239);
    case 3: 
      return acfp.m(2131716227);
    case 4: 
      return acfp.m(2131716232);
    case 5: 
      return acfp.m(2131716229);
    case 6: 
      return acfp.m(2131716240);
    case 7: 
      return acfp.m(2131716237);
    case 8: 
      return acfp.m(2131716238);
    case 9: 
      return acfp.m(2131716236);
    case 10: 
      return "SDK下载服务错误";
    case 11: 
      return acfp.m(2131716231);
    case 12: 
      return "下载器DC失败";
    case 13: 
      return acfp.m(2131716230);
    }
    return acfp.m(2131716235);
  }
  
  private List<ahcj.b> fe()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.dN)
    {
      int j = this.mListeners.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add((ahcj.b)this.mListeners.get(i));
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void h(int paramInt, String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloader.2(this, paramBundle, paramInt, paramString));
  }
  
  public boolean A(Bundle paramBundle)
  {
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. >>>init UniformDownloader");
    Object localObject2 = paramBundle.getString("_PARAM_FILENAME");
    long l = paramBundle.getLong("_PARAM_FILESIZE");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. init err. filename=null");
      localObject1 = "unnamefile";
    }
    if (0L == l)
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. init err. filesize=0");
      return false;
    }
    localObject2 = new Bundle();
    String str1 = ahav.kW(ahaf.a().wa() + (String)localObject1);
    String str2 = ahaf.a().vZ() + (String)localObject1;
    ((Bundle)localObject2).putString("_PARAM_FILENAME", (String)localObject1);
    ((Bundle)localObject2).putString("_PARAM_TMP_FILEPATH", str1);
    ((Bundle)localObject2).putString("_PARAM_FILEPATH", str2);
    ((Bundle)localObject2).putLong("_PARAM_FILESIZE", l);
    ((Bundle)localObject2).putLong("_PARAM_POS", 0L);
    paramBundle = paramBundle.getBundle("_PARAM_USER_DATA");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("COOKIE");
      if (!TextUtils.isEmpty(paramBundle)) {
        ((Bundle)localObject2).putString("_PARAM_COOKIE", paramBundle);
      }
    }
    this.bc = ((Bundle)localObject2);
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. >>>init UniformDownload info :: filename:[" + (String)localObject1 + "] fileSize:[" + l + "] tmpPath(maybe change):[" + str1 + "] savePath(maybe change):[" + str2 + "] url:[" + this.mUrl + "]");
    return a(ahch.mJ((String)localObject1), (Bundle)localObject2);
  }
  
  public int EN()
  {
    if (this.a != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. resume. ");
      return this.a.EN();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. resume. mDownloadler = null.");
    return -1;
  }
  
  public int EO()
  {
    if (this.a != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. pauseSlience. ");
      return this.a.EO();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. pauseSlience. mDownloadler = null.");
    return -1;
  }
  
  public void Ki(boolean paramBoolean)
  {
    synchronized (this.dM)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. setNotifyUserStarted." + this.cfZ + "->" + paramBoolean);
      this.cfZ = paramBoolean;
      return;
    }
  }
  
  public void a(ahcj.b paramb)
  {
    synchronized (this.dN)
    {
      if (this.mListeners.contains(paramb)) {
        this.mListeners.remove(paramb);
      }
      return;
    }
  }
  
  public void a(ahcj.b paramb, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.dN)
      {
        int j = this.mListeners.size();
        i = 0;
        if (i >= j) {
          break label244;
        }
        if ((ahcj.b)this.mListeners.get(i) == paramb)
        {
          if (paramBoolean == true)
          {
            if ((!paramBoolean) || (i < 0)) {
              break label109;
            }
            paramb = (ahcj.b)this.mListeners.remove(i);
            this.mListeners.add(paramb);
            this.cga = true;
            return;
          }
          return;
        }
      }
      i += 1;
      continue;
      label109:
      if (paramb != null)
      {
        if (!this.cga) {
          break label230;
        }
        i = this.mListeners.size();
        ahcj.b localb = (ahcj.b)this.mListeners.remove(i - 1);
        this.mListeners.add(paramb);
        this.mListeners.add(localb);
      }
      for (;;)
      {
        QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. addListenser. size=" + this.mListeners.size());
        if (paramBoolean) {
          this.cga = true;
        }
        return;
        label230:
        this.mListeners.add(paramb);
      }
      label244:
      int i = -1;
    }
  }
  
  public boolean amM()
  {
    int i = getStatus();
    if ((1 == i) || (6 == i)) {}
    while ((2 == this.mDownloadType) && (8 == i)) {
      return true;
    }
    return false;
  }
  
  public boolean amN()
  {
    return 2 == getStatus();
  }
  
  public boolean amO()
  {
    synchronized (this.dM)
    {
      boolean bool = this.cfZ;
      return bool;
    }
  }
  
  public int getStatus()
  {
    if (this.a != null) {
      return this.a.getStatus();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. getStatus. mDownloadler = null.");
    return 0;
  }
  
  public int getType()
  {
    return this.mDownloadType;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public int pause()
  {
    if (this.a != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. pause. ");
      return this.a.pause();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. pause. mDownloadler = null.");
    return -1;
  }
  
  public int start()
  {
    if (this.a != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. start. ");
      return this.a.start();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. start. mDownloadler = null.");
    return -1;
  }
  
  public int stop()
  {
    if (this.a != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "]. stop. ");
      return this.a.stop();
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. stop. mDownloadler = null.");
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract int EN();
    
    public abstract int EO();
    
    public abstract int a(ahcj.b paramb);
    
    public abstract int e(String paramString, Bundle paramBundle);
    
    public abstract int getStatus();
    
    public abstract int pause();
    
    public abstract int start();
    
    public abstract int stop();
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, long paramLong, Bundle paramBundle);
    
    public abstract void b(int paramInt, String paramString, Bundle paramBundle);
    
    public abstract void p(int paramInt, Bundle paramBundle);
    
    public abstract void q(int paramInt, Bundle paramBundle);
    
    public abstract void r(int paramInt, Bundle paramBundle);
    
    public abstract void s(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcj
 * JD-Core Version:    0.7.0.1
 */