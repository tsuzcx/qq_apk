import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.3;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class angb
  implements Manager
{
  public static long akW = 86400000L;
  List<angi> Es = Collections.synchronizedList(new LinkedList());
  List<angi> Et = Collections.synchronizedList(new LinkedList());
  List<angi> Eu = Collections.synchronizedList(new LinkedList());
  List<angi> Ev = Collections.synchronizedList(new LinkedList());
  angu b;
  public AtomicInteger bL = new AtomicInteger(0);
  public AtomicInteger bM = new AtomicInteger();
  public AtomicBoolean dJ = new AtomicBoolean(true);
  public PriorityBlockingQueue<angi> f = new PriorityBlockingQueue();
  public PriorityBlockingQueue<angi> g = new PriorityBlockingQueue();
  Runnable hz = new ShortVideoPreDownloader.2(this);
  public QQAppInterface mApp;
  Handler mSubHandler = null;
  public Map<String, Integer> mp = Collections.synchronizedMap(new HashMap());
  
  public angb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = new angc(this);
  }
  
  private String a(long paramLong, List<angi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      angi localangi = (angi)paramList.next();
      if ((localangi.o != null) && (localangi.o.uniseq == paramLong))
      {
        this.Es.remove(localangi);
        return localangi.cdE;
      }
    }
    return null;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = akxo.b(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i == 0) || (i == 1))
    {
      int j = paramQQAppInterface.cs(paramMessageForShortVideo.frienduin);
      if ((j == 2) || (j == 3) || (j == 4)) {
        return false;
      }
    }
    if (i == 2)
    {
      acdu localacdu = (acdu)paramQQAppInterface.getManager(53);
      if (localacdu != null)
      {
        paramQQAppInterface = localacdu.a(paramMessageForShortVideo.frienduin, paramQQAppInterface.getCurrentAccountUin());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  angi a()
  {
    int i;
    synchronized (this.Es)
    {
      i = this.Es.size();
      angi localangi1;
      if (i > 0)
      {
        log("getShortVideoRequest", "get a short video request from AIORequests");
        localangi1 = (angi)this.Es.get(i - 1);
        this.Es.remove(i - 1);
        return localangi1;
      }
      synchronized (this.Et)
      {
        i = this.Et.size();
        if (i > 0)
        {
          log("getShortVideoRequest", "get a short video request from C2CRequests");
          localangi1 = (angi)this.Et.get(i - 1);
          this.Et.remove(i - 1);
          return localangi1;
        }
      }
    }
    synchronized (this.Eu)
    {
      i = this.Eu.size();
      if (i > 0)
      {
        log("getShortVideoRequest", "get a short video request from DiscussionRequests");
        angi localangi2 = (angi)this.Eu.get(i - 1);
        this.Eu.remove(i - 1);
        return localangi2;
      }
    }
    synchronized (this.Ev)
    {
      i = this.Ev.size();
      if (i > 0)
      {
        log("getShortVideoRequest", "get a short video request from GroupRequests");
        angi localangi3 = (angi)this.Ev.get(i - 1);
        this.Ev.remove(i - 1);
        return localangi3;
      }
    }
    log("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  Collection<angi> a(int paramInt)
  {
    log("getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.g;
    case 5: 
      return this.Es;
    case 4: 
      return this.Et;
    case 3: 
      return this.Eu;
    }
    return this.Ev;
  }
  
  public void a(angi paramangi)
  {
    anfr.a(paramangi, this.mApp);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + paramangi.o.busiType);
    }
  }
  
  boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    log("filter", "uuid=" + paramMessageForShortVideo.uuid + " uniseq=" + paramMessageForShortVideo.uniseq + " priority=" + paramInt);
    Integer localInteger = (Integer)this.mp.get(paramMessageForShortVideo.uuid);
    if (localInteger == null)
    {
      log("filter", "msg cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection == null)
    {
      log("filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label294:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (angi)localIterator.next();
          if (((angi)localObject2).b.uniseq != paramMessageForShortVideo.uniseq) {
            break label294;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label294;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          log("filter", "No need to update the short video request");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.dFs = localObject1.dFr;
      localObject1.dFr = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.mp.put(paramMessageForShortVideo.uuid, Integer.valueOf(paramInt));
      log("filter", "Updated the short video request");
      return bool1;
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      log("isNeedPredownload", "short video has expired");
      return false;
    }
    if (paramMessageForShortVideo.busiType == 0) {}
    for (AtomicInteger localAtomicInteger = ShortVideoUtils.g(); (!paramBoolean) && (localAtomicInteger.get() == 1); localAtomicInteger = this.bL)
    {
      log("isNeedPredownload", "isFromAIO=false and mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if (localAtomicInteger.get() == 2)
    {
      log("isNeedPredownload", "mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if ((paramMessageForShortVideo.istroop == 0) && (paramMessageForShortVideo.msgtype == -2071)) {}
    for (int i = 1; (i == 0) && (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > akW); i = 0)
    {
      log("isNeedPredownload", "out of validity, no need to pre download");
      return false;
    }
    int j = akxo.Hi();
    if (i != 0)
    {
      if ((j != 0) && (j != 1))
      {
        log("isNeedPredownload", "Not Wifi or 4G, networkType=" + j + ", no need to predownload for lightvideo");
        return false;
      }
    }
    else if (j != 0)
    {
      log("isNeedPredownload", "Not Wifi, networkType=" + j + ", no need to predownload");
      return false;
    }
    return a(this.mApp, paramMessageForShortVideo);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    log("add", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5 + " priority=" + paramInt);
    if ((paramMessageForShortVideo.uuid == null) && (paramMessageForShortVideo.md5 == null))
    {
      log("add", "msg.uuid and md5 are null");
      return;
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      log("add", "MessageRecord isSendFromLocal");
      return;
    }
    if (a(paramMessageForShortVideo, paramInt))
    {
      log("add", "skip uniseq:" + paramMessageForShortVideo.uniseq + "priority:" + paramInt);
      return;
    }
    Object localObject;
    int i;
    if ((paramMessageForShortVideo.isMultiMsg) && (!paramMessageForShortVideo.isSend()))
    {
      localObject = ajlc.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).cZ;
        localObject = ((SessionInfo)localObject).aTl;
      }
    }
    for (;;)
    {
      i = akxo.Hi();
      int j = this.mApp.cs((String)localObject);
      if ((i == 0) || (j != 2)) {
        break;
      }
      log("add", "MSG_FILTER_NUM, no need to pre download short video");
      return;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
      continue;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
    }
    c(paramMessageForShortVideo, paramInt);
  }
  
  protected String bE(long paramLong)
  {
    Object localObject = a(paramLong, this.Es);
    if (localObject != null) {}
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          str = a(paramLong, this.Eu);
          localObject = str;
        } while (str != null);
        str = a(paramLong, this.Ev);
        localObject = str;
      } while (str != null);
      str = a(paramLong, this.Et);
      localObject = str;
    } while (str != null);
    return null;
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    log("handleShortVideo", " START uniseq=" + paramMessageForShortVideo.uniseq + ", uuid=" + paramMessageForShortVideo.uuid + ", priority=" + paramInt);
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (aqhq.fileExistsAndNotEmpty((String)localObject)) {
      log("handleShortVideo", "Video has already existed, path=" + (String)localObject);
    }
    angi localangi;
    do
    {
      return;
      localangi = anfr.a(this.mApp, paramMessageForShortVideo, 2);
    } while (localangi == null);
    localObject = null;
    String str = "";
    int i = akxo.b(this.mApp, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 5)
    {
      localObject = this.Es;
      localangi.dFr = 5;
      paramMessageForShortVideo = "AIORequests";
      switch (i)
      {
      default: 
        localangi.dFs = 2;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        log("handleShortVideo", "successfully to add the short video request to " + paramMessageForShortVideo);
        ((List)localObject).add(localangi);
        this.mp.put(localangi.b.uuid, Integer.valueOf(localangi.dFr));
      }
      paramInt = this.bM.get();
      if (paramInt >= 1) {
        break;
      }
      dPl();
      return;
      localangi.dFs = 4;
      continue;
      localangi.dFs = 3;
      continue;
      paramMessageForShortVideo = str;
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localObject = this.Ev;
          localangi.dFr = 2;
          localangi.dFs = localangi.dFr;
          paramMessageForShortVideo = "GroupRequests";
          break;
        case 3: 
          localObject = this.Et;
          localangi.dFr = 4;
          localangi.dFs = localangi.dFr;
          paramMessageForShortVideo = "C2CRequests";
          break;
        case 2: 
          localObject = this.Eu;
          localangi.dFr = 3;
          localangi.dFs = localangi.dFr;
          paramMessageForShortVideo = "DiscussionRequests";
        }
      }
    }
    log("handleShortVideo", "mHandlingNum(" + paramInt + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
  }
  
  public void dDQ()
  {
    log("off", "mIsPreDownloaderOpen=" + this.dJ.get());
    this.dJ.set(false);
    if (this.mSubHandler != null) {
      this.mSubHandler.removeCallbacks(this.hz);
    }
    for (;;)
    {
      this.mSubHandler.postDelayed(this.hz, 60000L);
      return;
      this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
  }
  
  public void dDR()
  {
    this.dJ.set(true);
    log("on", "ShortVideoPreDownloader is on, mIsPreDownloaderOpen=" + this.dJ.get());
    dPl();
  }
  
  public void dDU()
  {
    log("consumeAllThumbsInPendingQueue", null);
    int i = akxo.Hi();
    if ((!PicPreDownloader.biC) && (i != 0))
    {
      log("consumeAllThumbsInPendingQueue", "screenOFF, no preDownload, networkType: " + i);
      return;
    }
    ThreadManager.post(new ShortVideoPreDownloader.5(this), 5, null, false);
  }
  
  public void dPl()
  {
    log("consumeShortVideo", null);
    if (!this.dJ.get()) {
      akxe.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
    }
    angi localangi;
    do
    {
      return;
      int i = this.bM.get();
      if (i >= 1)
      {
        log("consumeShortVideo", "handlingNum(" + i + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
        return;
      }
      localangi = a();
    } while (localangi == null);
    if (localangi.b == null)
    {
      log("consumeShortVideo", "req.downinfo == null");
      return;
    }
    this.mp.remove(localangi.b.uuid);
    this.g.add(localangi);
    localangi.dFs = localangi.dFr;
    localangi.dFr = 6;
    this.mp.put(localangi.b.uuid, Integer.valueOf(6));
    this.bM.addAndGet(1);
    localangi.c = this.b;
    ThreadManager.post(new ShortVideoPreDownloader.4(this, localangi), 5, null, false);
  }
  
  public boolean g(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002) {
      log("isNeedPredownloadThumb", "short video has expired");
    }
    for (;;)
    {
      return false;
      if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > akW)
      {
        log("isNeedPredownloadThumb", "out of validity, no need to pre download");
        return false;
      }
      boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
      if ((aqiw.getNetworkType(BaseApplication.getContext()) == 1) || (bool)) {}
      for (int i = 1; (akwz.cuM) || (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public void m(MessageForShortVideo paramMessageForShortVideo)
  {
    log("productFromMsg", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5);
    boolean bool = a(paramMessageForShortVideo, false);
    if (bool) {
      b(paramMessageForShortVideo, 1);
    }
    if ((!bool) && (g(paramMessageForShortVideo))) {
      n(paramMessageForShortVideo);
    }
  }
  
  void n(MessageForShortVideo paramMessageForShortVideo)
  {
    log("consumeShortVideoThumb", null);
    Object localObject = ShortVideoUtils.bw(paramMessageForShortVideo.thumbMD5, "jpg");
    if (aqhq.fileExistsAndNotEmpty((String)localObject))
    {
      log("consumeShortVideoThumb", (String)localObject + " exists");
      return;
    }
    angi localangi = anfr.a(2, paramMessageForShortVideo.busiType);
    anfu localanfu = paramMessageForShortVideo.getDownloadInfo(localangi.dFl);
    localanfu.thumbPath = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0)
    {
      localanfu.fileType = 1002;
      localanfu.mRequestType = 2;
      localObject = this.mApp.b();
      if ((!((QQMessageFacade)localObject).Op()) || (!((QQMessageFacade)localObject).oA().equals(paramMessageForShortVideo.frienduin))) {
        break label241;
      }
    }
    label241:
    for (localanfu.mSceneType = 2;; localanfu.mSceneType = 1)
    {
      localangi.c(localanfu);
      localangi.p(paramMessageForShortVideo);
      int i = akxo.Hi();
      if ((PicPreDownloader.biC) || (i == 0)) {
        break label250;
      }
      log("consumeShortVideoThumb", "screenOFF, no preDownload, networkType: " + i);
      this.f.add(localangi);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        localanfu.fileType = 1006;
        break;
      }
      if (paramMessageForShortVideo.istroop != 1) {
        break;
      }
      localanfu.fileType = 1004;
      break;
    }
    label250:
    ThreadManager.post(new ShortVideoPreDownloader.3(this, localanfu, paramMessageForShortVideo, localangi), 5, null, false);
  }
  
  public void o(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = bE(paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo != null) {
      this.mp.remove(paramMessageForShortVideo);
    }
  }
  
  public void onDestroy()
  {
    log("onDestroy", null);
    if (this.mSubHandler != null)
    {
      this.mSubHandler.removeCallbacks(this.hz);
      this.mSubHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angb
 * JD-Core Version:    0.7.0.1
 */