import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class pnb
{
  protected pnb.b a;
  protected pnb.c a;
  protected String atR;
  protected Map<String, png> fC = new ConcurrentHashMap();
  public List<WeakReference<pni.a>> mListeners;
  
  public pnb()
  {
    this.jdField_a_of_type_Pnb$c = new pnb.c(null);
    this.jdField_a_of_type_Pnb$b = new pnb.b(null);
  }
  
  private boolean b(png parampng)
  {
    if ((parampng.downloadUrl != null) && (parampng.downloadUrl.contains("qqstocdnd")))
    {
      String str = ((pmm)psx.a(4)).mk();
      ram.b("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      parampng.downloadUrl = aurr.addParameter(parampng.downloadUrl, "authkey", str);
    }
    return true;
  }
  
  public boolean Iw()
  {
    if (!TextUtils.isEmpty(this.atR))
    {
      png localpng = (png)this.fC.remove(this.atR);
      if (localpng != null) {
        localpng.jdField_a_of_type_Pnb$d.b(localpng);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(png parampng)
  {
    parampng = (png)this.fC.remove(parampng.downloadKey);
    if (parampng != null)
    {
      parampng.jdField_a_of_type_Pnb$d.b(parampng);
      return true;
    }
    return false;
  }
  
  public boolean a(png parampng, pnb.a parama)
  {
    if (parampng == null)
    {
      ram.w("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(parampng.downloadUrl))
    {
      if ((!rnw.fy(parampng.vid)) || ((parampng.fileType != 2) && (parampng.fileType != 0))) {
        break label279;
      }
      QQStoryContext.a();
      localObject1 = rnw.a(QQStoryContext.a(), parampng.vid);
      if (!(localObject1 instanceof MessageForShortVideo)) {
        break label279;
      }
    }
    label279:
    for (Object localObject1 = (MessageForShortVideo)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (parama != null) {
          parama.a(parampng, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!rpc.hasInternet(QQStoryContext.a().getApplication()))
      {
        if (parama != null) {
          parama.a(parampng, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(parampng))
      {
        if (parama != null) {
          parama.a(parampng, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      parampng.jdField_a_of_type_Pnb$a = parama;
      parampng.Af = System.currentTimeMillis();
      if (localObject2 != null) {
        parampng.d = localObject2;
      }
      for (parampng.jdField_a_of_type_Pnb$d = this.jdField_a_of_type_Pnb$b; !parampng.jdField_a_of_type_Pnb$d.Ix(); parampng.jdField_a_of_type_Pnb$d = this.jdField_a_of_type_Pnb$c)
      {
        if (parama != null) {
          parama.a(parampng, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new pnc(this, "AsyncFileDownloader", parampng));
      return true;
    }
  }
  
  public void dU(List<WeakReference<pni.a>> paramList)
  {
    this.mListeners = paramList;
  }
  
  public static abstract interface a
  {
    public abstract void a(png parampng, ErrorMessage paramErrorMessage);
  }
  
  class b
    implements pnb.d
  {
    private b() {}
    
    public boolean Ix()
    {
      return true;
    }
    
    public void a(png parampng)
    {
      QQStoryContext.a();
      QQAppInterface localQQAppInterface = QQStoryContext.a();
      angi localangi = anfr.a(2, 2);
      MessageForShortVideo localMessageForShortVideo = parampng.d;
      anfu localanfu = localMessageForShortVideo.getDownloadInfo(localangi.dFl);
      if (parampng.fileType == 2)
      {
        localanfu.thumbPath = ShortVideoUtils.bw(localMessageForShortVideo.thumbMD5, "jpg");
        localanfu.jv(localMessageForShortVideo.istroop, 1);
      }
      for (;;)
      {
        localangi.c(localanfu);
        localangi.b(new pnd(this, parampng.downloadKey));
        anfr.a(localangi, localQQAppInterface);
        ram.d("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { parampng }));
        return;
        localanfu.localPath = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
        localanfu.jv(localMessageForShortVideo.istroop, 0);
      }
    }
    
    public void b(png parampng) {}
  }
  
  class c
    implements pnb.d
  {
    protected aolm.a b = new pnf(this);
    
    private c() {}
    
    public boolean Ix()
    {
      return true;
    }
    
    public void a(png parampng)
    {
      parampng.bju = 0;
      aoll localaoll = new aoll();
      localaoll.bZ = parampng.downloadUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = parampng.localPath;
      localaoll.mTempPath = parampng.atT;
      localaoll.dPo = parampng.priority;
      localaoll.mContinuErrorLimit = 3;
      localaoll.bw(parampng);
      localaoll.a = this.b;
      parampng.c = localaoll;
      localaoll.f = new pne(this);
      aolm localaolm = c();
      if (localaolm != null) {
        localaolm.a(localaoll);
      }
      ram.b("AsyncFileDownloader", "start download with base downloader, task = %s", parampng);
    }
    
    public void b(png parampng)
    {
      aoll localaoll = parampng.c;
      if (localaoll != null)
      {
        if (c() != null) {
          c().b(localaoll);
        }
        ram.d("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { parampng }));
      }
    }
    
    protected aolm c()
    {
      AppInterface localAppInterface = axov.d();
      if (localAppInterface != null) {
        return localAppInterface.getNetEngine(0);
      }
      return null;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean Ix();
    
    public abstract void a(png parampng);
    
    public abstract void b(png parampng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnb
 * JD-Core Version:    0.7.0.1
 */