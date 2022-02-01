import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class agjw
  implements agly.b
{
  protected LinkedHashMap<Long, agjw.a> Y = new LinkedHashMap();
  protected QQAppInterface app;
  
  public agjw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  protected String C(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      str = "x-video-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-video-";
      continue;
      str = "minni-video-";
      continue;
      str = "small-video-";
      continue;
      str = "middle-video-";
      continue;
      str = "large-video-";
      continue;
      str = "xlarge-video-";
      continue;
      str = "screen-video-";
    }
  }
  
  protected final agjw.a a(long paramLong)
  {
    synchronized (this.Y)
    {
      agjw.a locala = (agjw.a)this.Y.get(Long.valueOf(paramLong));
      return locala;
    }
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt)
  {
    return null;
  }
  
  public void a(long paramLong, int paramInt, agly.a parama) {}
  
  public void a(long paramLong, agly.a parama) {}
  
  public void a(long paramLong, aqog paramaqog) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, agly.a parama)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted suc:" + paramBoolean + " retCode[" + paramInt + "] thumbPath:" + paramString);
    jn(paramLong);
  }
  
  protected final void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlResult suc:" + paramBoolean1 + " strDomain:" + paramString1 + " port:" + paramInt + " urlParam:" + paramString2 + " cookie:" + paramString4);
    this.app.a().a().b(paramLong, paramBoolean1, paramString1, paramInt, paramString2, paramString3, paramString4, paramBoolean2, paramString5, paramShort, paramString6);
  }
  
  protected final void a(agjw.a parama)
  {
    if (parama == null)
    {
      QLog.e("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb] addSession = null");
      return;
    }
    synchronized (this.Y)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + parama.sessionid + "] addSession");
      this.Y.put(Long.valueOf(parama.sessionid), parama);
      if (QLog.isDevelopLevel())
      {
        parama = this.Y.keySet().iterator();
        if (parama.hasNext())
        {
          long l = ((Long)parama.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call addSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
  }
  
  protected void a(agjw.a parama, String paramString)
  {
    if ((parama.h.mContext != null) && ((parama.h.mContext instanceof String)) && ("igonFlow".equalsIgnoreCase((String)parama.h.mContext))) {
      parama.h.mContext = null;
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!agmx.alL()) && (ahav.amK()))
      {
        QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + parama.h.nSessionId + "] size(wh)[" + parama.h.imgWidth + ":" + parama.h.imgHeight + "]autoDownload Thumb switch is off!");
        return;
      }
      long l = this.app.a().a().a(paramString, this);
      if (l == -1L)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + parama.h.nSessionId + "] size(wh)[" + parama.h.imgWidth + ":" + parama.h.imgHeight + "] thumb is Downloading,waiting please!");
        return;
      }
      paramString = parama.h;
      i = paramString.mThumbRetryCount;
      paramString.mThumbRetryCount = (i + 1);
      if (i > 10)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "thumb retry over 10 count, igon!");
        return;
      }
      parama.sessionid = l;
      a(parama);
      this.app.a().a().start();
      return;
    }
  }
  
  public boolean a(long paramLong, agly.a parama)
  {
    return false;
  }
  
  public void b(long paramLong, agly.a parama) {}
  
  protected int cT(String paramString)
  {
    paramString = ahbj.getExtension(paramString);
    if (".mp4".equalsIgnoreCase(paramString)) {
      return 17;
    }
    if (".rmvb".equalsIgnoreCase(paramString)) {
      return 18;
    }
    if (".avi".equalsIgnoreCase(paramString)) {
      return 19;
    }
    if (".wmv".equalsIgnoreCase(paramString)) {
      return 20;
    }
    if (".flv".equalsIgnoreCase(paramString)) {
      return 21;
    }
    if (".3gp".equalsIgnoreCase(paramString)) {
      return 22;
    }
    if (".mkv".equalsIgnoreCase(paramString)) {
      return 23;
    }
    if (".asf".equalsIgnoreCase(paramString)) {
      return 26;
    }
    if (".vob".equalsIgnoreCase(paramString)) {
      return 27;
    }
    if (".m4v".equalsIgnoreCase(paramString)) {
      return 28;
    }
    if (".f4v".equalsIgnoreCase(paramString)) {
      return 29;
    }
    if (".mov".equalsIgnoreCase(paramString)) {
      return 30;
    }
    if (".mpeg".equalsIgnoreCase(paramString)) {
      return 31;
    }
    if (".mpg".equalsIgnoreCase(paramString)) {
      return 32;
    }
    if (".rm".equalsIgnoreCase(paramString)) {
      return 33;
    }
    if (".webm".equalsIgnoreCase(paramString)) {
      return 34;
    }
    return -1;
  }
  
  protected void dhg()
  {
    File localFile = new File(ahaf.a().wb());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  protected String eg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "64*64";
    case 0: 
      return "16*16";
    case 1: 
      return "32*32";
    case 2: 
      return "64*64";
    case 3: 
      return "128*128";
    case 4: 
      return "320*320";
    case 5: 
      return "384*384";
    case 6: 
      return "640*640";
    case 7: 
      return "750*750";
    }
    return "1024*1024";
  }
  
  protected final void jn(long paramLong)
  {
    synchronized (this.Y)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] removeSession");
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.Y.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call removeSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
    this.Y.remove(Long.valueOf(paramLong));
  }
  
  public static class a
  {
    public FileManagerEntity h;
    long sessionid;
    
    public a(FileManagerEntity paramFileManagerEntity)
    {
      this.h = paramFileManagerEntity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agjw
 * JD-Core Version:    0.7.0.1
 */