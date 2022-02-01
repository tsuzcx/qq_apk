import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class angd
  extends angb
{
  private ArrayList<angd.a> Ay = new ArrayList();
  ISPlayerDownloader b;
  
  public angd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(angi paramangi)
  {
    if ((paramangi == null) || (paramangi.o == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramangi.o.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.mApp.getApplication(), new ange(this, paramangi));
    }
    c(paramangi);
  }
  
  private void c(angi paramangi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + paramangi.o.uniseq);
    }
    this.b = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.a(paramangi.o, "mp4");
    int i;
    if ((paramangi.cJ != null) && (paramangi.cJ.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = paramangi.cJ;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, paramangi.o.getMd5() + paramangi.o.uniseq, (String)localObject);
      i = this.b.startOfflineDownload((SuperPlayerVideoInfo)localObject, new angf(this, paramangi));
      if (i <= 0) {
        break label216;
      }
      paramangi.dFt = i;
    }
    label216:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
      return;
    }
    QLog.e("ShortVideoPreDownloader", 2, " downFullVideo error preLoadId = " + i);
  }
  
  angi a()
  {
    synchronized (this.Es)
    {
      angi localangi1 = a(this.Es);
      if (localangi1 != null)
      {
        log("getShortVideoRequest", "get a short video request from AIORequests");
        return localangi1;
      }
      synchronized (this.Et)
      {
        localangi1 = a(this.Et);
        if (localangi1 != null)
        {
          log("getShortVideoRequest", "get a short video request from C2CRequests");
          return localangi1;
        }
      }
    }
    synchronized (this.Eu)
    {
      angi localangi2 = a(this.Eu);
      if (localangi2 != null)
      {
        log("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localangi2;
      }
    }
    synchronized (this.Ev)
    {
      angi localangi3 = a(this.Ev);
      if (localangi3 != null)
      {
        log("getShortVideoRequest", "get a short video request from GroupRequests");
        return localangi3;
      }
    }
    log("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  angi a(List<angi> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    angi localangi;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localangi = (angi)paramList.get(i - 1);
      paramList.remove(i - 1);
      log("getRequestBySDKStatus", "sdk installed");
      paramList = localangi;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localangi = (angi)localIterator.next();
      if (localangi.b.dFl != 0) {
        paramList.remove(localangi);
      }
    }
    for (paramList = localangi;; paramList = null)
    {
      log("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  protected void a(angi paramangi)
  {
    super.a(paramangi);
    if (paramangi.b.dFl == 0)
    {
      wla localwla = wla.a(this.mApp);
      if (localwla != null)
      {
        paramangi = new angd.a(paramangi);
        this.Ay.add(paramangi);
        localwla.a(paramangi.mView, paramangi);
      }
    }
  }
  
  public void f(ajlp paramajlp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramajlp == null) || (paramajlp.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    o(paramajlp.a.o);
    Object localObject = paramajlp.a.b.peerUin;
    long l = paramajlp.a.b.uniseq;
    localObject = this.mApp.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof aoji))) {
      ((aoji)localObject).cancel();
    }
    a(paramajlp.a);
  }
  
  public void g(ajlp paramajlp)
  {
    if ((paramajlp == null) || (paramajlp.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      o(paramajlp.a.o);
      aqoi localaqoi = this.mApp.a().a(paramajlp.a.b.peerUin, paramajlp.a.b.uniseq);
      if ((localaqoi instanceof aoji)) {
        ((aoji)localaqoi).cancel();
      }
    } while ((this.b == null) || (paramajlp.a.dFt <= 0));
    this.b.stopOfflineDownload(paramajlp.a.dFt);
  }
  
  public class a
    implements wla.a
  {
    private angi b;
    private String[] cJ;
    private String mDomain;
    public View mView;
    
    public a(angi paramangi)
    {
      this.b = paramangi;
      this.mView = new View(BaseApplicationImpl.getApplication());
    }
    
    private void aSU()
    {
      ISPlayerPreDownloader localISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 101);
      String str = ShortVideoUtils.a(this.b.o, "mp4");
      Object localObject = this.b.o.getMd5() + this.b.o.uniseq;
      localObject = SuperPlayerFactory.createVideoInfoForUrl(this.cJ, 101, (String)localObject, str);
      long l1 = this.b.o.videoFileTime;
      long l2 = this.b.o.videoFileSize;
      localISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)localObject, l1 * 1000L, ShortVideoUtils.Jn() * 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
      }
      this.b.o.setBitValue(0, (byte)1);
      this.b.o.serial();
      angd.this.mApp.b().c(this.b.o.frienduin, this.b.o.istroop, this.b.o.uniseq, this.b.o.msgData);
      alar.jf(1000, 100);
    }
    
    private void px()
    {
      if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
        VideoPlaySDKManager.getInstance().initSDKAsync(angd.this.mApp.getApplication(), new angg(this));
      }
      aSU();
      BaseShortVideoOprerator.a(angd.this.mApp, this.b);
    }
    
    public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
    {
      if (paramaoko.uniseq != this.b.o.uniseq) {}
      while ((paramaoko.fileType != 6) && (paramaoko.fileType != 17) && (paramaoko.fileType != 9) && (paramaoko.fileType != 20)) {
        return;
      }
      switch (paramaoko.status)
      {
      default: 
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        if (paramaoko.urls != null)
        {
          this.cJ = paramaoko.urls;
          this.mDomain = paramaoko.domain;
          paramInt1 = 0;
        }
        break;
      case 2004: 
      case 2005: 
      case 5001: 
      case 5002: 
        while (paramInt1 < 1)
        {
          if (!aqmr.isEmpty(this.mDomain))
          {
            paramView = new StringBuilder();
            paramaoko = this.cJ;
            paramaoko[paramInt1] = (paramaoko[paramInt1] + "&txhost=" + this.mDomain);
          }
          paramInt1 += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
          }
          if (this.b.a != null) {
            this.b.a.onComplete(paramaoko.status);
          }
          angd.a(angd.this).remove(this);
          return;
        }
        this.b.cJ = this.cJ;
        if (this.b.cFr) {
          angd.a(angd.this, this.b);
        }
        break;
      }
      for (;;)
      {
        angd.a(angd.this).remove(this);
        return;
        px();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onComplete(int paramInt);
    
    public abstract void onProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angd
 * JD-Core Version:    0.7.0.1
 */