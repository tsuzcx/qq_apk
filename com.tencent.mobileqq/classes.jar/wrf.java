import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public class wrf
  implements Handler.Callback, IEventReceiver, vcd, wvf
{
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper, this);
  private ConcurrentHashMap<String, StoryVideoItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private uvx jdField_a_of_type_Uvx = (uvx)uwa.a(5);
  private vcc jdField_a_of_type_Vcc;
  private wrg jdField_a_of_type_Wrg;
  private wrh jdField_a_of_type_Wrh;
  protected wvb a;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private vcc jdField_b_of_type_Vcc;
  
  public wrf(Looper paramLooper)
  {
    this.jdField_a_of_type_Wvb = new wvb();
    this.jdField_a_of_type_Wvb.a(this);
    this.jdField_a_of_type_Wrh = new wrh(this);
    this.jdField_a_of_type_Wrg = new wrg(this, this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wrh);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wrg);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null) {}
    do
    {
      return true;
      paramString = this.jdField_a_of_type_Uvx.a(paramString);
    } while ((paramString != null) && (a(paramString)));
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem2 = (StoryVideoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    StoryVideoItem localStoryVideoItem1;
    if ((localStoryVideoItem2 != null) && (!TextUtils.isEmpty(localStoryVideoItem2.mVideoUrl)) && (localStoryVideoItem2.mVideoDuration >= 0L))
    {
      localStoryVideoItem1 = localStoryVideoItem2;
      if (localStoryVideoItem2.mSourceType != -1) {}
    }
    else
    {
      localStoryVideoItem1 = this.jdField_a_of_type_Uvx.a(paramString);
    }
    return localStoryVideoItem1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wrh);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wrg);
    this.jdField_a_of_type_Wvb.a();
    if (this.jdField_a_of_type_Vcc != null) {
      this.jdField_a_of_type_Vcc.a();
    }
    if (this.jdField_b_of_type_Vcc != null) {
      this.jdField_b_of_type_Vcc.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, List<wqn> paramList)
  {
    StoryVideoItem localStoryVideoItem = paramQQStoryAutoPlayView.a();
    if (localStoryVideoItem == null) {
      wxj.b("story_home_dev", "feed_play_req", 0, 3, new String[0]);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_Wvb.a(this.jdField_a_of_type_Uvx.a(localStoryVideoItem.mVid), paramList);
      bool = StoryVideoItem.isPlayable(localStoryVideoItem.mVid, false);
      paramList = null;
      if (bool) {
        paramList = unk.a(localStoryVideoItem.mVid, 0, false, false);
      }
      if (a(localStoryVideoItem)) {
        break;
      }
      wxe.a("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that need to req the storyVideoItem vid=%s cover=%s", localStoryVideoItem.mVid, localStoryVideoItem.getThumbUrl());
    } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localStoryVideoItem.mVid) != null);
    paramQQStoryAutoPlayView = new ArrayList();
    paramQQStoryAutoPlayView.add(localStoryVideoItem.mVid);
    a(paramQQStoryAutoPlayView);
    wxj.b("story_home_dev", "feed_play_req", 0, 2, new String[] { localStoryVideoItem.mVid });
    return;
    if ((bool) && (paramList != null))
    {
      wxe.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that have the mp4 file,do play now vid+" + localStoryVideoItem.mVid + " cover=" + localStoryVideoItem.getThumbUrl());
      if (localStoryVideoItem.mErrorCode != 0) {
        wxe.e("Q.qqstory.home.AutoPlayManager", "AutoPlayManager request the error video to auto play error code=" + localStoryVideoItem.mErrorCode);
      }
      File localFile = unk.a(localStoryVideoItem.mVid, 1, false, false);
      xqq.a(paramList);
      paramQQStoryAutoPlayView.a(paramList, localFile);
      wxj.b("story_home_dev", "feed_play_req", 1, 0, new String[] { localStoryVideoItem.mVid });
      return;
    }
    wxj.b("story_home_dev", "feed_play_req", 0, 1, new String[] { localStoryVideoItem.mVid });
  }
  
  public void a(String paramString1, String paramString2)
  {
    wxe.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onSuccess = " + paramString1);
    paramString2 = new wux();
    paramString2.a = paramString1;
    umc.a().dispatch(paramString2);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    wxj.b("auto_play", "rsp_down", 0, 0, new String[] { paramString1 });
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    wxe.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onError = " + paramString1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    wxj.b("auto_play", "rsp_down", 1, 0, new String[] { paramString1 });
  }
  
  public void a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!a(str)) {
        localArrayList.add(str);
      }
    }
    wxe.a("Q.qqstory.home.AutoPlayManager", "fetchStoryVideoItemByVid, request=%s, original=%s", new JSONArray(localArrayList), new JSONArray(paramList));
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_Vcc = vcc.a(localArrayList);
      this.jdField_a_of_type_Vcc.a("Q.qqstory.home.AutoPlayManager");
      this.jdField_a_of_type_Vcc.a(this);
      this.jdField_a_of_type_Vcc.b();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    while ((TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) || (paramStoryVideoItem.mSourceType == -1) || (paramStoryVideoItem.mVideoDuration < 0L)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    wxe.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onPause = " + paramString1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    wxj.b("auto_play", "rsp_down", 2, 0, new String[] { paramString1 });
  }
  
  public void b(List<StoryVideoItem> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramList));
    }
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
          xqq.a("handleMessage is illegal debug info=%s", new Object[] { localStoryVideoItem });
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localStoryVideoItem.mVid, localStoryVideoItem);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localStoryVideoItem.mVid);
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrf
 * JD-Core Version:    0.7.0.1
 */