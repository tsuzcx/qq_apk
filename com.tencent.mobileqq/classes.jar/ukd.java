import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

@TargetApi(14)
public class ukd
  extends ult<ulw>
  implements IEventReceiver
{
  private uko jdField_a_of_type_Uko;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        awbw localawbw = QQStoryContext.a().a().createEntityManager();
        ukd localukd = (ukd)urr.a(3);
        localList = localawbw.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
          i = 0;
          return i;
        }
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label288;
        }
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
        long l1 = localPublishVideoEntry.getId();
        String str1 = localPublishVideoEntry.fakeVid;
        int j = localPublishVideoEntry.publishState;
        String str2 = localPublishVideoEntry.videoLabel;
        String str3 = localPublishVideoEntry.videoDoodleDescription;
        long l2 = localPublishVideoEntry.videoDuration;
        String str4 = localPublishVideoEntry.videoLocationDescription;
        if (localPublishVideoEntry.isPicture)
        {
          i = 1;
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localawbw.a(localPublishVideoEntry);
          localukd.a(localPublishVideoEntry);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label288:
      int i = localList.size();
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      ukp.a().a();
    }
    ulw localulw = new ulw(paramPublishVideoEntry);
    super.b(localulw);
    ukn localukn;
    if (!localulw.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      ukp.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localukn = new ukn(true);
      if (localulw.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localukn.jdField_b_of_type_Boolean = bool1;
      localObject1 = (uro)urr.a(5);
      Object localObject2 = localulw.a();
      localukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uro)localObject1).a(localulw.a(), (StoryVideoItem)localObject2);
      localukn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localulw.a();
      localObject1 = localulw.a();
      if ((localObject1 == null) || (((uti)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localukn.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((uti)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new ukm();
        ((ukm)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = wkp.a((String)localObject3, localulw.a().mLocalDate);
        ((ukm)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new ukl();
        ((ukl)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localukn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((ukm)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localukn.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
      bool1 = false;
      break;
    }
    label297:
    bool1 = paramPublishVideoEntry.getBooleanExtra("is_hw_encode", false);
    boolean bool2 = paramPublishVideoEntry.isLocalPublish;
    if ((bool1) || (bool2))
    {
      int i = Math.min(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      int j = Math.max(paramPublishVideoEntry.videoHeight, paramPublishVideoEntry.videoWidth);
      paramPublishVideoEntry.videoWidth = i;
      paramPublishVideoEntry.videoHeight = j;
      if ((urk.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (urk.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((awbw)localObject1).b(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localulw, localukn), 8, new ukh(this, localulw), false);
  }
  
  public static void a(String paramString)
  {
    ((ukd)urr.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (urk)urr.a(10);
      boolean bool1 = ((Boolean)((urk)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((urk)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = xhi.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        xmx.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new uqh(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().b(paramString);
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      wsv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      xmh.a(paramString);
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      uro localuro = (uro)urr.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localuro.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = wkp.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (xod.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((usd)urr.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localuro.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    uht.a().dispatch(new ukk());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
      a(paramString, paramList, 1);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void a(String paramString, List<StoryVideoItem> paramList, int paramInt)
  {
    for (;;)
    {
      VideoListFeedItem localVideoListFeedItem;
      uro localuro;
      Object localObject5;
      try
      {
        localVideoListFeedItem = wkp.a(paramString, wkp.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localuro = (uro)urr.a(5);
        localObject1 = new ukn(true);
        ((ukn)localObject1).jdField_b_of_type_Boolean = false;
        ((ukn)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new ukm();
        ((ukn)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((ukm)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new ukl();
          ((ukl)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localuro.a((StoryVideoItem)localObject4);
          ((ukm)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        uht.a().dispatch((Dispatcher.Dispatchable)localObject1);
      }
      finally {}
      Object localObject1 = new ArrayList(paramList.size());
      Object localObject2 = new ArrayList(paramList.size());
      Object localObject3 = new ArrayList(paramList.size());
      Object localObject4 = paramList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (StoryVideoItem)((Iterator)localObject4).next();
        ((ArrayList)localObject1).add(((StoryVideoItem)localObject5).sourceVid);
        ((ArrayList)localObject2).add(Long.valueOf(((StoryVideoItem)localObject5).mCreateTime));
        ((ArrayList)localObject3).add(Integer.valueOf((int)((StoryVideoItem)localObject5).mTimeZoneOffsetMillis / 1000));
      }
      paramString = new vah(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      ung.a().a(paramString, new ukf(localVideoListFeedItem, paramList, localuro));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bdee.g(paramActivity)) {
      QQToast.a(paramActivity, 1, alpo.a(2131714943), 0).a();
    }
    ArrayList localArrayList1;
    do
    {
      return;
      localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (!TextUtils.isEmpty(localStoryVideoItem.sourceVid))
        {
          localArrayList2.add(localStoryVideoItem);
        }
        else if (ukn.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
        }
        else
        {
          a(localStoryVideoItem, paramActivity);
        }
      }
      if (localArrayList2.size() > 0) {
        a(((StoryVideoItem)localArrayList2.get(0)).shareGroupId, localArrayList2);
      }
    } while ((localArrayList1.size() <= 0) || (paramActivity.isFinishing()));
    paramList = bdcd.a(paramActivity, 230);
    paramList.setTitle(alpo.a(2131714944));
    paramList.setMessage(alpo.a(2131714946));
    paramList.setPositiveButton(alpo.a(2131714945), new uke(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bdee.g(paramContext))
    {
      QQToast.a(paramContext, 1, alpo.a(2131714942), 0).a();
      return false;
    }
    ((ukd)urr.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new ukg("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    wsv.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new ukj(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(ulw paramulw)
  {
    return new StoryVideoUploadTask(paramulw);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Uko = new uko(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Uko);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (umk.a(paramStoryVideoItem))
    {
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      ukp.a().a();
    }
    ulw localulw = new ulw(paramStoryVideoItem);
    localulw.jdField_b_of_type_Int += 1;
    super.b(localulw);
    Object localObject1;
    if (!localulw.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      ukp.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (uro)urr.a(5);
      paramStoryVideoItem = new ukn(false);
      if (localulw.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uro)localObject1).a(localulw.a(), localulw.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localulw.a();
      localObject1 = localulw.a();
      if ((localObject1 == null) || (((uti)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((uti)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        ukm localukm = new ukm();
        localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = wkp.a((String)localObject2, localulw.a().mLocalDate);
        localukm.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new ukl();
        ((ukl)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localukm.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localukm);
      }
      bool = false;
      break;
    }
    label327:
    uht.a().dispatch(paramStoryVideoItem);
    super.d();
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localulw });
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (ulw)((Iterator)localObject3).next();
      } while (!paramString1.equals(((ulw)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((ulw)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (ulw)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((ulw)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (uro)urr.a(5);
        localObject3 = ((ulw)localObject2).a();
        ((uro)localObject1).a(((ulw)localObject2).a(), (StoryVideoItem)localObject3);
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(ulw paramulw)
  {
    if (b()) {
      wsv.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramulw.b())
      {
        localObject1 = ujb.a(paramulw.jdField_g_of_type_JavaLangString, paramulw.d, 0, false, false);
        if (!xmx.b(paramulw.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramulw.jdField_a_of_type_JavaLangString = ((String)localObject1);
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = ujb.a(paramulw.jdField_g_of_type_JavaLangString, paramulw.d, 2, false, false);
        if (!xmx.b(paramulw.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramulw.jdField_c_of_type_JavaLangString = paramulw.jdField_b_of_type_JavaLangString;
        paramulw.jdField_b_of_type_JavaLangString = ((String)localObject1);
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramulw.e))
        {
          localObject1 = ujb.a(paramulw.jdField_g_of_type_JavaLangString, paramulw.d, 6, false, false);
          if (!xmx.b(paramulw.e, (String)localObject1)) {
            break label964;
          }
          paramulw.e = ((String)localObject1);
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramulw.jdField_f_of_type_JavaLangString))
        {
          localObject1 = ujb.a(paramulw.jdField_g_of_type_JavaLangString, paramulw.d, 6, false, false);
          if (!xmx.b(paramulw.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramulw.jdField_f_of_type_JavaLangString = ((String)localObject1);
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramulw.m))
        {
          localObject1 = ujb.a(paramulw.jdField_g_of_type_JavaLangString, paramulw.d, 5, false, false);
          if (!xmx.b(paramulw.m, (String)localObject1)) {
            break label986;
          }
          paramulw.m = ((String)localObject1);
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramulw.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramulw.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramulw.a().getStringExtra("pk_comment_content", null);
            int i = paramulw.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramulw.a().getStringExtra("pk_vid", null);
            localObject4 = paramulw.a().getStringExtra("post_pk_comment_style", null);
            unw.a((String)localObject1, (String)localObject2, i, paramulw.jdField_g_of_type_JavaLangString, paramulw.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (uro)urr.a(5);
      Object localObject2 = (wkp)urr.a(11);
      Object localObject4 = ((uro)localObject3).a(paramulw.a(), paramulw.a());
      wsv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new ukn(false);
      boolean bool;
      Object localObject5;
      ukm localukm;
      ukl localukl;
      Object localObject6;
      vcn localvcn;
      if (!paramulw.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((ukn)localObject1).jdField_b_of_type_Boolean = bool;
        ((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramulw.a();
        localObject4 = paramulw.a();
        if ((localObject4 == null) || (((uti)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((ukn)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((uti)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localukm = new ukm();
        localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = wkp.a((String)localObject5, paramulw.a().mLocalDate);
        localukm.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localukl = new ukl();
        localukl.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramulw.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramulw.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localvcn = (vcn)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localvcn.jdField_a_of_type_JavaLangString)) {
              if ((!(localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localvcn.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((wkp)localObject2).a(localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localvcn.jdField_a_of_type_JavaUtilMap.get(paramulw.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        xmh.a(((StoryVideoItem)localObject5).mVid);
        localukl.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uro)localObject3).a((StoryVideoItem)localObject5);
        ((wkp)localObject2).a(localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((wkp)localObject2).a(localvcn.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localukm.jdField_a_of_type_JavaUtilArrayList.add(localukl);
        ((ukn)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localukm);
        break label603;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localukm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localvcn.jdField_b_of_type_JavaLangString;
        xmh.a(localvcn.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramulw.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramulw.jdField_a_of_type_Long;
        wta.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { wta.b(paramulw.jdField_f_of_type_Int) + "", paramulw.jdField_b_of_type_Long + "", "", paramulw.jdField_g_of_type_Int + "" });
        if (blun.c)
        {
          l1 = blun.h.a[0] + l2;
          long l3 = blun.h.a[1];
          blun.h.a(2, l2 - l3);
          if (blun.h.a())
          {
            l2 = blun.h.a[0];
            l3 = blun.h.a[1];
            long l4 = blun.h.a[2];
            if ((wta.a(l1, 0L, 120000L)) && (wta.a(l2, 0L, 120000L)) && (wta.a(l3, 0L, 120000L)) && (wta.a(l4, 0L, 120000L))) {
              wta.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            blun.h.c();
          }
        }
      }
      if ((paramulw.jdField_a_of_type_Int == 5) || (paramulw.jdField_a_of_type_Int == 3) || (paramulw.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        wta.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramulw.jdField_a_of_type_Long), new String[] { wta.b(paramulw.jdField_f_of_type_Int) + "", paramulw.jdField_b_of_type_Long + "", "", paramulw.jdField_g_of_type_Int + "" });
      }
      if (((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((ukn)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramulw.a();
        ((ukn)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramulw.jdField_g_of_type_JavaLangString;
        ((ukn)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uro)localObject3).a(paramulw.jdField_g_of_type_JavaLangString, ((ukn)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((ukn)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((ukn)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((wkp)localObject2).a(((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramulw.jdField_b_of_type_Int > 0) {
          wta.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramulw.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramulw.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramulw.jdField_a_of_type_Long;
        wta.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), wta.a(BaseApplication.getContext()), String.valueOf(paramulw.jdField_b_of_type_Int) });
        wta.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), wta.a(BaseApplication.getContext()), String.valueOf(paramulw.jdField_b_of_type_Int) });
        localObject2 = paramulw.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        wta.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramulw.h });
        wsw.a(2444494, null);
        wsv.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramulw.a(), Long.valueOf(l1));
        uku.a(paramulw.a());
      }
      if (((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        uht.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        wta.a("mystory", "publish_fail", 0, 0, new String[] { wta.b(paramulw.jdField_f_of_type_Int) + "", paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramulw.jdField_b_of_type_Int > 0) {
          wta.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramulw.jdField_a_of_type_Long;
        localObject1 = String.format(paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramulw.jdField_b_of_type_Int), Integer.valueOf(paramulw.jdField_c_of_type_Int), paramulw.a(), paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        wta.b("publish_story", "publish_all_old", 0, paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), wta.a(BaseApplication.getContext()), String.valueOf(paramulw.jdField_b_of_type_Int) });
        if (!"composite".equals(paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          wta.b("publish_story", "publish_all", 0, paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), wta.a(BaseApplication.getContext()), String.valueOf(paramulw.jdField_b_of_type_Int) });
        }
        localObject2 = paramulw.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        wta.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramulw.h });
        wsw.a(2444493, paramulw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        wsv.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramulw.a(), Long.valueOf(l1));
        return;
      }
    } while (((ukn)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    uht.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(ulw paramulw, ErrorMessage paramErrorMessage)
  {
    if (paramulw.jdField_a_of_type_Int == 5) {
      ukp.a().a(paramulw.a(), paramulw.jdField_g_of_type_JavaLangString);
    }
    while ((paramulw.jdField_a_of_type_Int != 6) && (paramulw.jdField_a_of_type_Int != 3) && (paramulw.jdField_a_of_type_Int != 7)) {
      return;
    }
    ukp.a().d(paramulw.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	ukd:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 742	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lulu;
    //   16: checkcast 154	ulw
    //   19: invokevirtual 186	ulw:a	()Ljava/lang/String;
    //   22: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 734	ukd:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 451	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 84 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 88 1 0
    //   60: checkcast 154	ulw
    //   63: invokevirtual 186	ulw:a	()Ljava/lang/String;
    //   66: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq -27 -> 44
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -44 -> 32
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -49 -> 32
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ukd
    //   0	89	1	paramString	String
    //   25	56	2	bool	boolean
    //   6	49	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	84	finally
    //   11	26	84	finally
    //   36	44	84	finally
    //   44	70	84	finally
  }
  
  public void b()
  {
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Uko);
  }
  
  public void c(String paramString)
  {
    Object localObject = (uro)urr.a(5);
    StoryVideoItem localStoryVideoItem = ((uro)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        xmx.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        xmx.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        xmx.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((uro)localObject).a(paramString);
    localObject = new ulw(paramString);
    super.c((ulu)localObject);
    wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    uku.a(((ulw)localObject).a());
    Bosses.get().scheduleJobDelayed(new uki(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */