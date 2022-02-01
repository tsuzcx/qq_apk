import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class agly
  implements aqoi
{
  protected static final String bIb = ahaf.a().wb();
  private static long id;
  private List<agly.a> Bi = new ArrayList();
  private List<String> Bj = new ArrayList();
  private LinkedHashMap<Long, agly.a> ac = new LinkedHashMap();
  private QQAppInterface app;
  private final int cXC = 3;
  
  public agly(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void IV(String paramString)
  {
    synchronized (this.Bj)
    {
      this.Bj.remove(paramString);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + id + "], Name[" + paramString + "] removeDowloadingList,size:" + this.ac.size());
      return;
    }
  }
  
  private agly.a a(long paramLong)
  {
    synchronized (this.ac)
    {
      agly.a locala = (agly.a)this.ac.get(Long.valueOf(paramLong));
      return locala;
    }
  }
  
  private void a(agly.a parama)
  {
    if (parama.i == null) {}
    try
    {
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + parama.id + "] runDownload...tmpname[" + String.valueOf(parama.bIc) + "]");
      parama.i = new FileOutputStream(parama.bIc, true);
      aqog localaqog = new aqog(parama.strUrl, null, this, true);
      String str = "gprs";
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localaqog.setRequestProperty("Net-type", str);
      localaqog.setRequestProperty("Range", "bytes=0-");
      localaqog.setPriority(5);
      localaqog.SP(true);
      localaqog.fileType = 0;
      localaqog.busiType = 0;
      localaqog.msgId = String.valueOf(parama.id);
      QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + parama.id + "] start runDownload... , url[" + parama.strUrl + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localaqog.busiType) + "]");
      localaqog.setRequestProperty("Accept-Encoding", "identity");
      if (parama.jdField_a_of_type_Agly$b != null) {
        parama.jdField_a_of_type_Agly$b.a(parama.id, localaqog);
      }
      if (!TextUtils.isEmpty(parama.strCookie)) {
        localaqog.setRequestProperty("Cookie", parama.strCookie);
      }
      str = "";
      if (parama.strUrl != null) {
        str = parama.strUrl.toLowerCase();
      }
      if ((parama.isHttps) && (str.startsWith("https")))
      {
        localaqog.mIsHttps = true;
        localaqog.cML = aglb.mp(parama.strUrl);
        localaqog.cux = parama.httpsDomain;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + parama.strCookie);
      }
      this.app.getHttpCommunicatort().a(localaqog);
      parama.jdField_a_of_type_Aqog = localaqog;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      a(parama, true);
      if (parama.jdField_a_of_type_Agly$b != null) {
        parama.jdField_a_of_type_Agly$b.a(parama.id, false, -2, null, parama);
      }
      jy(parama.id);
      IV(parama.bIc);
      dhz();
    }
  }
  
  private void a(agly.a parama, boolean paramBoolean)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      parama.Zb = 0L;
      try
      {
        if (parama.i != null)
        {
          parama.i.close();
          parama.i = null;
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + id + "]. closeFileStream:");
        }
        for (;;)
        {
          if (parama.jdField_a_of_type_Aqog != null) {
            this.app.getHttpCommunicatort().f(parama.jdField_a_of_type_Aqog);
          }
          if (!paramBoolean) {
            break;
          }
          ahbj.deleteFile(parama.bIc);
          return;
          QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + id + "]. closeFileStream.had closed: stream = null:");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          parama.i = null;
          QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + id + "]. closeFileStream: exception");
          localIOException.printStackTrace();
        }
      }
    }
  }
  
  private void b(agly.a parama)
  {
    if (parama == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
      return;
    }
    synchronized (this.ac)
    {
      this.ac.put(Long.valueOf(parama.id), parama);
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + parama.id + "] addDowloadingTask,size:" + this.ac.size());
      return;
    }
  }
  
  private void dhz()
  {
    boolean bool = false;
    QLog.i("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,mWaitDowloadTask.size(" + String.valueOf(this.Bi.size()) + ")");
    synchronized (this.ac)
    {
      int i = this.ac.size();
      if (i >= 8)
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,but is have" + i + " task downloading, waiting....");
        return;
      }
      synchronized (this.Bi)
      {
        if (this.Bi.size() == 0)
        {
          QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
          return;
        }
      }
    }
    agly.a locala = (agly.a)this.Bi.get(0);
    if (locala == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
      this.Bi.remove(0);
      dhz();
      return;
    }
    this.Bi.remove(locala);
    b(locala);
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + locala.id + "] downloadNext send cs get url. thumb task,");
    locala.startTime = System.currentTimeMillis();
    if (locala.jdField_a_of_type_Agly$b != null) {
      bool = locala.jdField_a_of_type_Agly$b.a(locala.id, locala);
    }
    if (!bool)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
      jy(locala.id);
      IV(locala.bIc);
      dhz();
    }
  }
  
  private void jy(long paramLong)
  {
    synchronized (this.ac)
    {
      this.ac.remove(Long.valueOf(paramLong));
      QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] removeDowloadingTask,size:" + this.ac.size());
      return;
    }
  }
  
  private boolean mr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("-441")) && (!paramString.equals("-443")) && (!paramString.equals("-447")) && (!paramString.equals("-29224")) && (!paramString.equals("-31717"))) {
      return false;
    }
    return true;
  }
  
  public void Hp(String paramString) {}
  
  public long a(String paramString, agly.b paramb)
  {
    synchronized (this.Bj)
    {
      if (this.Bj.contains(paramString)) {
        return -1L;
      }
      this.Bj.add(paramString);
      synchronized (this.Bi)
      {
        agly.a locala = new agly.a();
        locala.strFileName = paramString;
        locala.bIc = (paramString + ".tmp");
        locala.jdField_a_of_type_Agly$b = paramb;
        long l = id;
        id = 1L + l;
        locala.id = l;
        this.Bi.add(locala);
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + locala.id + "] add WaitDowloadTask waiting...");
        l = locala.id;
        return l;
      }
    }
  }
  
  public final void a(aqog arg1, aqog paramaqog2)
  {
    long l1 = Long.parseLong(???.msgId);
    int j = 0;
    agly.a locala = a(l1);
    if (locala == null)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode no this task ");
      return;
    }
    if (??? != locala.jdField_a_of_type_Aqog)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode req not match");
      return;
    }
    locala.d = paramaqog2;
    if (paramaqog2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] decode resp = null ");
      a(locala, true);
      if (locala.jdField_a_of_type_Agly$b != null) {
        locala.jdField_a_of_type_Agly$b.a(locala.id, false, -7, null, locala);
      }
      jy(locala.id);
      IV(locala.bIc);
      dhz();
      return;
    }
    int i;
    synchronized (locala.lo)
    {
      if (paramaqog2.getResponseCode() != 206)
      {
        i = j;
        if (paramaqog2.getResponseCode() != 200) {}
      }
      else if (locala.i == null)
      {
        a(locala, true);
        if (locala.jdField_a_of_type_Agly$b != null) {
          locala.jdField_a_of_type_Agly$b.a(locala.id, false, -8, null, locala);
        }
        jy(locala.id);
        IV(locala.bIc);
        dhz();
        return;
      }
    }
    for (;;)
    {
      try
      {
        locala.i.write(paramaqog2.aB());
        if (locala.fileSize == 0L)
        {
          long l2 = paramaqog2.hR();
          QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "]  thumb Size[" + String.valueOf(l2) + "]");
          locala.fileSize = l2;
        }
        locala.Zc = paramaqog2.aB().length;
        locala.Zb += locala.Zc;
        QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + locala.Zc + "],total[" + String.valueOf(locala.Zb) + "] thumb Size[" + String.valueOf(locala.fileSize) + "]");
        if (locala.Zb >= locala.fileSize) {
          locala.jdField_a_of_type_Aqog = null;
        }
      }
      catch (Exception paramaqog2)
      {
        try
        {
          locala.i.flush();
          locala.i.getFD().sync();
          a(locala, false);
          boolean bool = true;
          i = 0;
          if (!aqhq.renameFile(new File(locala.bIc), new File(locala.strFileName)))
          {
            bool = false;
            i = -9;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l1 + "] renameFile failed");
          }
          if (locala.jdField_a_of_type_Agly$b != null) {
            locala.jdField_a_of_type_Agly$b.a(locala.id, bool, i, locala.strFileName, locala);
          }
          jy(locala.id);
          IV(locala.bIc);
          i = 1;
          if (i == 0) {
            break;
          }
          dhz();
          return;
        }
        catch (IOException paramaqog2)
        {
          paramaqog2.printStackTrace();
          a(locala, true);
          if (locala.jdField_a_of_type_Agly$b == null) {
            break label777;
          }
          locala.jdField_a_of_type_Agly$b.a(locala.id, false, -8, null, locala);
          jy(locala.id);
          IV(locala.bIc);
          dhz();
          return;
        }
        paramaqog2 = paramaqog2;
        paramaqog2.printStackTrace();
        a(locala, true);
        if (locala.jdField_a_of_type_Agly$b != null) {
          locala.jdField_a_of_type_Agly$b.a(locala.id, false, -8, null, locala);
        }
        jy(locala.id);
        IV(locala.bIc);
        dhz();
        return;
      }
      label777:
      int k = (int)((float)locala.Zb / (float)locala.fileSize * 10000.0F);
      i = j;
      if (locala.jdField_a_of_type_Agly$b != null)
      {
        locala.jdField_a_of_type_Agly$b.a(locala.id, k, locala);
        i = j;
      }
    }
  }
  
  public final boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return true;
  }
  
  public void b(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6)
  {
    paramString3 = a(paramLong);
    if (paramString3 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetThumbInfo no this task");
      dhz();
      return;
    }
    if (!paramBoolean1)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlCome failed");
      jy(paramString3.id);
      IV(paramString3.bIc);
      dhz();
      return;
    }
    if (paramBoolean2) {
      paramInt = paramShort;
    }
    paramString3.strCookie = paramString4;
    paramString4 = paramString1 + ":" + paramInt;
    paramString1 = new ArrayList(1);
    paramString1.add(paramString4);
    if ((!TextUtils.isEmpty(paramString6)) && (paramString3.jdField_a_of_type_Agly$b != null))
    {
      paramString4 = paramString3.jdField_a_of_type_Agly$b.a(paramLong, paramString6, paramInt);
      if ((paramString4 != null) && (paramString4.size() > 0))
      {
        if (agke.alt())
        {
          QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] debugIsDisableIPv4OnDoubleStack");
          paramString1.clear();
        }
        paramInt = paramString4.size() - 1;
        while (paramInt >= 0)
        {
          paramString1.add(0, (String)paramString4.get(paramInt));
          paramInt -= 1;
        }
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPv6");
      }
    }
    QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] runDownload use IPList:" + paramString1.toString());
    paramString3.b = new aglb(this.app, paramString1, paramString2);
    if (paramBoolean2) {
      paramString3.b.Jj(true);
    }
    paramString3.strUrl = paramString3.b.vg();
    paramString3.isHttps = paramBoolean2;
    paramString3.httpsDomain = paramString5;
    paramString3.ah = paramShort;
    ThreadManager.post(new ThumbHttpDownloader.1(this, paramString3), 8, null, false);
  }
  
  public final void b(aqog paramaqog1, aqog paramaqog2)
  {
    long l = -1L;
    if (paramaqog1 != null) {
      l = Long.parseLong(paramaqog1.msgId);
    }
    agly.a locala = a(l);
    if (locala == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(l) + "]");
      dhz();
      return;
    }
    if (paramaqog2 == null)
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response is null");
      a(locala, true);
      if (locala.jdField_a_of_type_Agly$b != null) {
        locala.jdField_a_of_type_Agly$b.a(locala.id, false, -1, null, locala);
      }
      jy(locala.id);
      IV(locala.bIc);
      dhz();
      return;
    }
    String str2 = paramaqog2.getErrorString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    locala.d = paramaqog2;
    int i = paramaqog2.errCode;
    QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + l + "] handleError retCode[" + i + "], retMsg[" + str1 + "]");
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] net is broken");
      a(locala, true);
      if (locala.jdField_a_of_type_Agly$b != null) {
        locala.jdField_a_of_type_Agly$b.a(locala.id, false, -3, null, locala);
      }
      jy(locala.id);
      IV(locala.bIc);
      dhz();
      return;
    }
    if (paramaqog1 == null)
    {
      i = -6;
      QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] request = null. over");
    }
    for (;;)
    {
      a(locala, true);
      if (locala.jdField_a_of_type_Agly$b != null) {
        locala.jdField_a_of_type_Agly$b.a(locala.id, false, i, null, locala);
      }
      jy(locala.id);
      IV(locala.bIc);
      dhz();
      return;
      if (!paramaqog2.aFq())
      {
        i = -4;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] response.permitRetry = false. over");
      }
      else
      {
        if ((paramaqog2.f == null) || (!mr(paramaqog2.f.getHeaderField("User-ReturnCode")))) {
          break;
        }
        i = -10;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] file over size and server can not create thumb. over");
      }
    }
    if (locala.retryTimes < 3)
    {
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes:" + locala.retryTimes + " eofRetry:" + locala.cXs);
      locala.retryTimes += 1;
      if ((i == 9056) && (locala.cXs < 3))
      {
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] .Error_Exp_Eof retryTimes:" + locala.retryTimes + " eofRetry:" + locala.cXs);
        locala.retryTimes -= 1;
      }
      for (locala.cXs += 1;; locala.cXs = 0)
      {
        a(locala, true);
        if (locala.jdField_a_of_type_Agly$b != null) {
          locala.jdField_a_of_type_Agly$b.a(locala.id, locala);
        }
        locala.cXK += 1;
        a(locala);
        return;
      }
    }
    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] try it. retryTimes > " + 3 + " getNextUrl....");
    if (locala.b != null) {}
    for (paramaqog1 = locala.b.vg();; paramaqog1 = null)
    {
      if (paramaqog1 != null)
      {
        locala.retryTimes = 0;
        locala.cXs = 0;
        locala.strUrl = paramaqog1;
        a(locala, true);
        this.app.getHttpCommunicatort().f(locala.jdField_a_of_type_Aqog);
        if (locala.jdField_a_of_type_Agly$b != null) {
          locala.jdField_a_of_type_Agly$b.b(locala.id, locala);
        }
        locala.cXK += 1;
        a(locala);
        return;
      }
      i = -5;
      QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + l + "] had not nextUrl, over....");
      break;
    }
  }
  
  public void start()
  {
    dhz();
  }
  
  public static class a
  {
    long Zb = 0L;
    long Zc = 0L;
    agly.b jdField_a_of_type_Agly$b;
    aqog jdField_a_of_type_Aqog;
    short ah = 0;
    aglb b;
    String bIc;
    int cXK = 0;
    int cXs = 0;
    aqog d;
    long fileSize = 0L;
    String httpsDomain;
    FileOutputStream i = null;
    long id = -1L;
    boolean isHttps = false;
    int[] lo = new int[0];
    int retryTimes = 0;
    long startTime = 0L;
    String strCookie;
    String strFileName;
    String strUrl;
    int thumbSize = -1;
    
    public String toString()
    {
      return null;
    }
  }
  
  public static abstract interface b
  {
    public abstract List<String> a(long paramLong, String paramString, int paramInt);
    
    public abstract void a(long paramLong, int paramInt, agly.a parama);
    
    public abstract void a(long paramLong, agly.a parama);
    
    public abstract void a(long paramLong, aqog paramaqog);
    
    public abstract void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, agly.a parama);
    
    public abstract boolean a(long paramLong, agly.a parama);
    
    public abstract void b(long paramLong, agly.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agly
 * JD-Core Version:    0.7.0.1
 */