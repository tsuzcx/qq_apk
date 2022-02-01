import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedRsp;
import NS_QQ_STORY_META.META.StImage;
import NS_QQ_STORY_META.META.StStoryFeed;
import NS_QQ_STORY_META.META.StVideo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.subscribe.other.story.VSUploadVideoEntry;
import com.tencent.biz.subscribe.other.story.VSUploadVideoManager.2;
import com.tencent.biz.subscribe.other.story.VSUploadVideoManager.3;
import com.tencent.biz.subscribe.other.story.VSUploadVideoManager.4;
import com.tencent.biz.subscribe.other.story.VSUploadVideoManager.6;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sfp
  extends sfb
  implements avzi
{
  private VSUploadVideoEntry a(List<VSUploadVideoEntry> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VSUploadVideoEntry localVSUploadVideoEntry = (VSUploadVideoEntry)paramList.next();
      if (paramString.equals(localVSUploadVideoEntry.fakeId)) {
        return localVSUploadVideoEntry;
      }
    }
    return null;
  }
  
  private void a(VSUploadVideoEntry paramVSUploadVideoEntry, String paramString)
  {
    if ((paramVSUploadVideoEntry != null) && (!TextUtils.isEmpty(paramString)))
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] retryOperationAfterQuery() retry publish => fakeId=" + paramString);
      VSUploadVideoEntry localVSUploadVideoEntry = new VSUploadVideoEntry();
      localVSUploadVideoEntry.copy(paramVSUploadVideoEntry);
      localVSUploadVideoEntry.uploadStatus = 12;
      sfp.a locala = new sfp.a();
      locala.e = localVSUploadVideoEntry;
      if (TextUtils.equals(localVSUploadVideoEntry.uid, QQStoryContext.a().mi())) {
        pmi.a().dispatch(locala);
      }
      paramVSUploadVideoEntry.retryTimes += 1;
      if (this.a != null) {
        this.a.a(paramVSUploadVideoEntry, false);
      }
      a(paramVSUploadVideoEntry);
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryOperationAfterQuery() retry publish , add waiting list => fakeId=" + paramString + " , waiting list.siza:" + bz().size());
      if (a() == null) {
        bmk();
      }
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "retryOperationAfterQuery() retry publish retryEntry or fakeId == null");
  }
  
  protected void a(VSUploadVideoEntry paramVSUploadVideoEntry, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp, ErrorMessage paramErrorMessage)
  {
    VSUploadVideoEntry localVSUploadVideoEntry;
    sfp.a locala;
    Bundle localBundle;
    Object localObject;
    if (paramVSUploadVideoEntry != null)
    {
      localVSUploadVideoEntry = new VSUploadVideoEntry();
      localVSUploadVideoEntry.copy(paramVSUploadVideoEntry);
      locala = new sfp.a();
      locala.e = localVSUploadVideoEntry;
      localBundle = new Bundle();
      localBundle.putString("fakeVid", paramVSUploadVideoEntry.fakeId);
      if (!paramVSUploadVideoEntry.isSuccess()) {
        break label349;
      }
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] handleTaskResult()  task final success ==> fakeId=" + paramVSUploadVideoEntry.fakeId + " , vid=" + paramVSUploadVideoEntry.vid + " , uploadStatus=" + paramVSUploadVideoEntry.statusToInfo());
      if (paramStPublishStoryFeedRsp != null)
      {
        locala.a = paramStPublishStoryFeedRsp.storyFeed;
        if ((paramStPublishStoryFeedRsp.storyFeed != null) && (paramStPublishStoryFeedRsp.storyFeed.id != null))
        {
          localObject = paramStPublishStoryFeedRsp.storyFeed.id.get();
          ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] upload feedid:" + (String)localObject);
          localObject = new META.StStoryFeed();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((META.StStoryFeed)localObject).mergeFrom(paramStPublishStoryFeedRsp.storyFeed.toByteArray());
        ((META.StStoryFeed)localObject).coverImage.url.set(localVSUploadVideoEntry.originalEntry.thumbPath);
        ((META.StStoryFeed)localObject).storyVideo.playUrl.set(localVSUploadVideoEntry.localVideoPath);
        localBundle.putByteArray("storyfeed", ((META.StStoryFeed)localObject).toByteArray());
        localBundle.putBoolean("result", true);
        sfl.a().cn(paramVSUploadVideoEntry.fakeId, paramVSUploadVideoEntry.vid);
        if (this.a != null) {
          this.a.bym();
        }
        if (TextUtils.equals(paramVSUploadVideoEntry.uid, QQStoryContext.a().mi())) {
          pmi.a().dispatch(locala);
        }
        if (this.a != null) {
          this.a.a(paramVSUploadVideoEntry, false);
        }
        aurs.runOnUiThread(new VSUploadVideoManager.3(this, paramVSUploadVideoEntry, paramErrorMessage));
        return;
      }
      catch (Exception paramStPublishStoryFeedRsp)
      {
        paramStPublishStoryFeedRsp.printStackTrace();
        continue;
      }
      label349:
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] handleTaskResult()  task fail ==> fakeId=" + paramVSUploadVideoEntry.fakeId + " , uploadStatus=" + paramVSUploadVideoEntry.statusToInfo() + " , errorCode=" + paramErrorMessage.errorCode + " , errorMsg=" + paramErrorMessage.errorMsg);
      locala.i = paramErrorMessage;
      sfl.a().qZ(paramVSUploadVideoEntry.fakeId);
      localBundle.putBoolean("result", false);
    }
  }
  
  protected void d(VSUploadVideoEntry paramVSUploadVideoEntry)
  {
    if (paramVSUploadVideoEntry != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] handleTaskChange()  task status change ==> fakeId=" + paramVSUploadVideoEntry.fakeId + " , uploadStatus=" + paramVSUploadVideoEntry.statusToInfo());
      VSUploadVideoEntry localVSUploadVideoEntry = new VSUploadVideoEntry();
      localVSUploadVideoEntry.copy(paramVSUploadVideoEntry);
      sfp.a locala = new sfp.a();
      locala.e = localVSUploadVideoEntry;
      if (TextUtils.equals(paramVSUploadVideoEntry.uid, QQStoryContext.a().mi())) {
        pmi.a().dispatch(locala);
      }
      if (this.a != null) {
        this.a.a(paramVSUploadVideoEntry, false);
      }
      if ((paramVSUploadVideoEntry.uploadStatus == 3) && (this.a != null)) {
        this.a.g(paramVSUploadVideoEntry);
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (this.mTaskHandler == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "mTaskHandler == null");
      return;
    }
    this.mTaskHandler.post(new VSUploadVideoManager.2(this, paramString, paramBundle));
  }
  
  public void tb(String paramString)
  {
    if (this.mTaskHandler == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "mTaskHandler == null");
      return;
    }
    this.mTaskHandler.post(new VSUploadVideoManager.6(this, paramString));
    sqn.a("mystatus_post", "fail_dlt", 0, 0, new String[0]);
  }
  
  public void td(String paramString)
  {
    if (this.mTaskHandler == null) {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "mTaskHandler == null");
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] retryUploadVideoTask() hand retry publish => fakeId=" + paramString);
    this.mTaskHandler.post(new VSUploadVideoManager.4(this, paramString));
    sqn.a("mystatus_post", "fail_retry", 0, 0, new String[0]);
  }
  
  public void te(String paramString)
  {
    if (this.a == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "getFailTaskFromDbForRemote() mDbHelper == null");
      return;
    }
    this.a.a(new sfs(this), paramString);
  }
  
  public static final class a
    extends plt
  {
    public META.StStoryFeed a;
    public VSUploadVideoEntry e;
    public ErrorMessage i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfp
 * JD-Core Version:    0.7.0.1
 */