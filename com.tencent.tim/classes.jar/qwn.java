import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public class qwn
  implements Handler.Callback, IEventReceiver, pxd.a, qza.c
{
  private pxd jdField_a_of_type_Pxd;
  private qwn.a jdField_a_of_type_Qwn$a;
  private qwn.b jdField_a_of_type_Qwn$b;
  protected qza a;
  private boolean aDA = true;
  private ConcurrentHashMap<String, StoryVideoItem> ag = new ConcurrentHashMap();
  private psu b = (psu)psx.a(5);
  private int bor = 1;
  private int bos = 0;
  private pxd c;
  private ConcurrentHashMap<String, String> ci = new ConcurrentHashMap();
  private Handler mHandler = new Handler(paramLooper, this);
  
  public qwn(Looper paramLooper)
  {
    this.jdField_a_of_type_Qza = new qza();
    this.jdField_a_of_type_Qza.a(this);
    this.jdField_a_of_type_Qwn$b = new qwn.b(this);
    this.jdField_a_of_type_Qwn$a = new qwn.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qwn$b);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qwn$a);
  }
  
  private boolean filter(String paramString)
  {
    if (this.ag.get(paramString) != null) {}
    do
    {
      return true;
      paramString = this.b.a(paramString);
    } while ((paramString != null) && (g(paramString)));
    return false;
  }
  
  public void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, List<qwa> paramList)
  {
    StoryVideoItem localStoryVideoItem = paramQQStoryAutoPlayView.b();
    if (localStoryVideoItem == null) {
      rar.b("story_home_dev", "feed_play_req", 0, 3, new String[0]);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_Qza.a(this.b.a(localStoryVideoItem.mVid), paramList);
      bool = StoryVideoItem.isPlayable(localStoryVideoItem.mVid, false);
      paramList = null;
      if (bool) {
        paramList = pnh.a(localStoryVideoItem.mVid, 0, false, false);
      }
      if (g(localStoryVideoItem)) {
        break;
      }
      ram.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that need to req the storyVideoItem vid=%s cover=%s", localStoryVideoItem.mVid, localStoryVideoItem.getThumbUrl());
    } while (this.ci.get(localStoryVideoItem.mVid) != null);
    paramQQStoryAutoPlayView = new ArrayList();
    paramQQStoryAutoPlayView.add(localStoryVideoItem.mVid);
    eI(paramQQStoryAutoPlayView);
    rar.b("story_home_dev", "feed_play_req", 0, 2, new String[] { localStoryVideoItem.mVid });
    return;
    if ((bool) && (paramList != null))
    {
      ram.d("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that have the mp4 file,do play now vid+" + localStoryVideoItem.mVid + " cover=" + localStoryVideoItem.getThumbUrl());
      if (localStoryVideoItem.mErrorCode != 0) {
        ram.e("Q.qqstory.home.AutoPlayManager", "AutoPlayManager request the error video to auto play error code=" + localStoryVideoItem.mErrorCode);
      }
      File localFile = pnh.a(localStoryVideoItem.mVid, 1, false, false);
      rom.checkNotNull(paramList);
      paramQQStoryAutoPlayView.d(paramList, localFile);
      rar.b("story_home_dev", "feed_play_req", 1, 0, new String[] { localStoryVideoItem.mVid });
      return;
    }
    rar.b("story_home_dev", "feed_play_req", 0, 1, new String[] { localStoryVideoItem.mVid });
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    ram.d("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onError = " + paramString1);
    this.ci.remove(paramString1);
    rar.b("auto_play", "rsp_down", 1, 0, new String[] { paramString1 });
  }
  
  public void cx(String paramString1, String paramString2)
  {
    ram.d("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onPause = " + paramString1);
    this.ci.remove(paramString1);
    rar.b("auto_play", "rsp_down", 2, 0, new String[] { paramString1 });
  }
  
  public StoryVideoItem e(String paramString)
  {
    StoryVideoItem localStoryVideoItem2 = (StoryVideoItem)this.ag.get(paramString);
    StoryVideoItem localStoryVideoItem1;
    if ((localStoryVideoItem2 != null) && (!TextUtils.isEmpty(localStoryVideoItem2.mVideoUrl)) && (localStoryVideoItem2.mVideoDuration >= 0L))
    {
      localStoryVideoItem1 = localStoryVideoItem2;
      if (localStoryVideoItem2.mSourceType != -1) {}
    }
    else
    {
      localStoryVideoItem1 = this.b.a(paramString);
    }
    return localStoryVideoItem1;
  }
  
  public void eI(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!filter(str)) {
        localArrayList.add(str);
      }
    }
    ram.b("Q.qqstory.home.AutoPlayManager", "fetchStoryVideoItemByVid, request=%s, original=%s", new JSONArray(localArrayList), new JSONArray(paramList));
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_Pxd = pxd.a(localArrayList);
      this.jdField_a_of_type_Pxd.setTag("Q.qqstory.home.AutoPlayManager");
      this.jdField_a_of_type_Pxd.a(this);
      this.jdField_a_of_type_Pxd.run();
    }
  }
  
  public void eJ(List<StoryVideoItem> paramList)
  {
    if (this.mHandler != null) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramList));
    }
  }
  
  public boolean g(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    while ((TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) || (paramStoryVideoItem.mSourceType == -1) || (paramStoryVideoItem.mVideoDuration < 0L)) {
      return false;
    }
    this.ag.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = ((List)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramMessage.next();
        if ((localStoryVideoItem.mErrorCode == 0) && ((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (localStoryVideoItem.mVideoDuration < 0L) || (localStoryVideoItem.mSourceType == -1))) {
          rom.fail("handleMessage is illegal debug info=%s", new Object[] { localStoryVideoItem });
        }
        this.ag.put(localStoryVideoItem.mVid, localStoryVideoItem);
        this.ci.remove(localStoryVideoItem.mVid);
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    ram.d("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onSuccess = " + paramString1);
    paramString2 = new qyk.g();
    paramString2.vid = paramString1;
    pmi.a().dispatch(paramString2);
    this.ci.remove(paramString1);
    rar.b("auto_play", "rsp_down", 0, 0, new String[] { paramString1 });
  }
  
  public void release()
  {
    this.aDA = false;
    this.ag.clear();
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qwn$b);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qwn$a);
    this.jdField_a_of_type_Qza.onDestroy();
    if (this.jdField_a_of_type_Pxd != null) {
      this.jdField_a_of_type_Pxd.destroy();
    }
    if (this.c != null) {
      this.c.destroy();
    }
  }
  
  public int sS()
  {
    return this.bor;
  }
  
  public int sT()
  {
    return this.bos;
  }
  
  public void sx(boolean paramBoolean) {}
  
  public void wE(int paramInt)
  {
    this.bor = paramInt;
  }
  
  public void wF(int paramInt)
  {
    this.bos = paramInt;
  }
  
  public class a
    extends QQUIEventReceiver<qwn, pse.a>
  {
    public a(@NonNull qwn paramqwn)
    {
      super();
    }
    
    public void a(@NonNull qwn paramqwn, @NonNull pse.a parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
      }
      paramqwn.eJ(parama.mw);
    }
    
    public Class acceptEventClass()
    {
      return pse.a.class;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<qwn, pyc.a>
  {
    public b(@NonNull qwn paramqwn)
    {
      super();
    }
    
    public void a(@NonNull qwn paramqwn, @NonNull pyc.a parama)
    {
      if ((parama.b.isFail()) || (parama.mVideoList == null)) {
        return;
      }
      paramqwn.eJ(parama.mVideoList);
    }
    
    public Class acceptEventClass()
    {
      return pyc.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwn
 * JD-Core Version:    0.7.0.1
 */