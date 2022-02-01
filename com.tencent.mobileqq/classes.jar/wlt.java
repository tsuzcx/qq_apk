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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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
public class wlt
  extends wnj<wnm>
  implements IEventReceiver
{
  private wme jdField_a_of_type_Wme;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
        wlt localwlt = (wlt)wth.a(3);
        localList = localEntityManager.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
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
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.update(localPublishVideoEntry);
          localwlt.a(localPublishVideoEntry);
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
      wmf.a().a();
    }
    wnm localwnm = new wnm(paramPublishVideoEntry);
    super.b(localwnm);
    wmd localwmd;
    if (!localwnm.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      wmf.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localwmd = new wmd(true);
      if (localwnm.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localwmd.jdField_b_of_type_Boolean = bool1;
      localObject1 = (wte)wth.a(5);
      Object localObject2 = localwnm.a();
      localwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wte)localObject1).a(localwnm.a(), (StoryVideoItem)localObject2);
      localwmd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwnm.a();
      localObject1 = localwnm.a();
      if ((localObject1 == null) || (((wuy)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localwmd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wuy)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new wmc();
        ((wmc)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yme.a((String)localObject3, localwnm.a().mLocalDate);
        ((wmc)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new wmb();
        ((wmb)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwmd.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((wmc)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localwmd.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
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
      if ((wta.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (wta.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localwnm, localwmd), 8, new wlx(this, localwnm), false);
  }
  
  public static void a(String paramString)
  {
    ((wlt)wth.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (wta)wth.a(10);
      boolean bool1 = ((Boolean)((wta)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((wta)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = zix.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        zom.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new wrx(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().persistOrReplace(paramString);
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      yuk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      znw.a(paramString);
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      wte localwte = (wte)wth.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localwte.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = yme.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (zps.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((wtt)wth.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localwte.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    wjj.a().dispatch(new wma());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
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
      wte localwte;
      Object localObject5;
      try
      {
        localVideoListFeedItem = yme.a(paramString, yme.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localwte = (wte)wth.a(5);
        localObject1 = new wmd(true);
        ((wmd)localObject1).jdField_b_of_type_Boolean = false;
        ((wmd)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wmc();
        ((wmd)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((wmc)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new wmb();
          ((wmb)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwte.a((StoryVideoItem)localObject4);
          ((wmc)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        wjj.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new xbx(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      wow.a().a(paramString, new wlv(localVideoListFeedItem, paramList, localwte));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bhnv.g(paramActivity)) {
      QQToast.a(paramActivity, 1, anzj.a(2131713365), 0).a();
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
        else if (wmd.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
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
    paramList = bhlq.a(paramActivity, 230);
    paramList.setTitle(anzj.a(2131713366));
    paramList.setMessage(anzj.a(2131713368));
    paramList.setPositiveButton(anzj.a(2131713367), new wlu(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bhnv.g(paramContext))
    {
      QQToast.a(paramContext, 1, anzj.a(2131713364), 0).a();
      return false;
    }
    ((wlt)wth.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new wlw("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    yuk.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new wlz(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(wnm paramwnm)
  {
    return new StoryVideoUploadTask(paramwnm);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Wme = new wme(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Wme);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (woa.a(paramStoryVideoItem))
    {
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      wmf.a().a();
    }
    wnm localwnm = new wnm(paramStoryVideoItem);
    localwnm.jdField_b_of_type_Int += 1;
    super.b(localwnm);
    Object localObject1;
    if (!localwnm.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      wmf.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (wte)wth.a(5);
      paramStoryVideoItem = new wmd(false);
      if (localwnm.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wte)localObject1).a(localwnm.a(), localwnm.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwnm.a();
      localObject1 = localwnm.a();
      if ((localObject1 == null) || (((wuy)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wuy)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        wmc localwmc = new wmc();
        localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yme.a((String)localObject2, localwnm.a().mLocalDate);
        localwmc.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wmb();
        ((wmb)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localwmc.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localwmc);
      }
      bool = false;
      break;
    }
    label327:
    wjj.a().dispatch(paramStoryVideoItem);
    super.d();
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localwnm });
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
        localObject1 = (wnm)((Iterator)localObject3).next();
      } while (!paramString1.equals(((wnm)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((wnm)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (wnm)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((wnm)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (wte)wth.a(5);
        localObject3 = ((wnm)localObject2).a();
        ((wte)localObject1).a(((wnm)localObject2).a(), (StoryVideoItem)localObject3);
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(wnm paramwnm)
  {
    if (b()) {
      yuk.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramwnm.b())
      {
        localObject1 = wkr.a(paramwnm.jdField_g_of_type_JavaLangString, paramwnm.d, 0, false, false);
        if (!zom.b(paramwnm.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramwnm.jdField_a_of_type_JavaLangString = ((String)localObject1);
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = wkr.a(paramwnm.jdField_g_of_type_JavaLangString, paramwnm.d, 2, false, false);
        if (!zom.b(paramwnm.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramwnm.jdField_c_of_type_JavaLangString = paramwnm.jdField_b_of_type_JavaLangString;
        paramwnm.jdField_b_of_type_JavaLangString = ((String)localObject1);
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramwnm.e))
        {
          localObject1 = wkr.a(paramwnm.jdField_g_of_type_JavaLangString, paramwnm.d, 6, false, false);
          if (!zom.b(paramwnm.e, (String)localObject1)) {
            break label964;
          }
          paramwnm.e = ((String)localObject1);
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwnm.jdField_f_of_type_JavaLangString))
        {
          localObject1 = wkr.a(paramwnm.jdField_g_of_type_JavaLangString, paramwnm.d, 6, false, false);
          if (!zom.b(paramwnm.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramwnm.jdField_f_of_type_JavaLangString = ((String)localObject1);
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwnm.m))
        {
          localObject1 = wkr.a(paramwnm.jdField_g_of_type_JavaLangString, paramwnm.d, 5, false, false);
          if (!zom.b(paramwnm.m, (String)localObject1)) {
            break label986;
          }
          paramwnm.m = ((String)localObject1);
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramwnm.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramwnm.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramwnm.a().getStringExtra("pk_comment_content", null);
            int i = paramwnm.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramwnm.a().getStringExtra("pk_vid", null);
            localObject4 = paramwnm.a().getStringExtra("post_pk_comment_style", null);
            wpm.a((String)localObject1, (String)localObject2, i, paramwnm.jdField_g_of_type_JavaLangString, paramwnm.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (wte)wth.a(5);
      Object localObject2 = (yme)wth.a(11);
      Object localObject4 = ((wte)localObject3).a(paramwnm.a(), paramwnm.a());
      yuk.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new wmd(false);
      boolean bool;
      Object localObject5;
      wmc localwmc;
      wmb localwmb;
      Object localObject6;
      xed localxed;
      if (!paramwnm.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((wmd)localObject1).jdField_b_of_type_Boolean = bool;
        ((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramwnm.a();
        localObject4 = paramwnm.a();
        if ((localObject4 == null) || (((wuy)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((wmd)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((wuy)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localwmc = new wmc();
        localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yme.a((String)localObject5, paramwnm.a().mLocalDate);
        localwmc.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localwmb = new wmb();
        localwmb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramwnm.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramwnm.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localxed = (xed)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localxed.jdField_a_of_type_JavaLangString)) {
              if ((!(localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localxed.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((yme)localObject2).a(localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localxed.jdField_a_of_type_JavaUtilMap.get(paramwnm.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        znw.a(((StoryVideoItem)localObject5).mVid);
        localwmb.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wte)localObject3).a((StoryVideoItem)localObject5);
        ((yme)localObject2).a(localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((yme)localObject2).a(localxed.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localwmc.jdField_a_of_type_JavaUtilArrayList.add(localwmb);
        ((wmd)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localwmc);
        break label603;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localwmc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localxed.jdField_b_of_type_JavaLangString;
        znw.a(localxed.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramwnm.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramwnm.jdField_a_of_type_Long;
        yup.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { yup.b(paramwnm.jdField_f_of_type_Int) + "", paramwnm.jdField_b_of_type_Long + "", "", paramwnm.jdField_g_of_type_Int + "" });
        if (bpty.c)
        {
          l1 = bpty.h.a[0] + l2;
          long l3 = bpty.h.a[1];
          bpty.h.a(2, l2 - l3);
          if (bpty.h.a())
          {
            l2 = bpty.h.a[0];
            l3 = bpty.h.a[1];
            long l4 = bpty.h.a[2];
            if ((yup.a(l1, 0L, 120000L)) && (yup.a(l2, 0L, 120000L)) && (yup.a(l3, 0L, 120000L)) && (yup.a(l4, 0L, 120000L))) {
              yup.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            bpty.h.c();
          }
        }
      }
      if ((paramwnm.jdField_a_of_type_Int == 5) || (paramwnm.jdField_a_of_type_Int == 3) || (paramwnm.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        yup.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramwnm.jdField_a_of_type_Long), new String[] { yup.b(paramwnm.jdField_f_of_type_Int) + "", paramwnm.jdField_b_of_type_Long + "", "", paramwnm.jdField_g_of_type_Int + "" });
      }
      if (((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((wmd)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramwnm.a();
        ((wmd)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramwnm.jdField_g_of_type_JavaLangString;
        ((wmd)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wte)localObject3).a(paramwnm.jdField_g_of_type_JavaLangString, ((wmd)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((wmd)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((wmd)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((yme)localObject2).a(((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramwnm.jdField_b_of_type_Int > 0) {
          yup.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramwnm.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramwnm.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramwnm.jdField_a_of_type_Long;
        yup.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), yup.a(BaseApplication.getContext()), String.valueOf(paramwnm.jdField_b_of_type_Int) });
        yup.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), yup.a(BaseApplication.getContext()), String.valueOf(paramwnm.jdField_b_of_type_Int) });
        localObject2 = paramwnm.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        yup.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramwnm.h });
        yul.a(2444494, null);
        yuk.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramwnm.a(), Long.valueOf(l1));
        wmk.a(paramwnm.a());
      }
      if (((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        wjj.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        yup.a("mystory", "publish_fail", 0, 0, new String[] { yup.b(paramwnm.jdField_f_of_type_Int) + "", paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramwnm.jdField_b_of_type_Int > 0) {
          yup.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramwnm.jdField_a_of_type_Long;
        localObject1 = String.format(paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramwnm.jdField_b_of_type_Int), Integer.valueOf(paramwnm.jdField_c_of_type_Int), paramwnm.a(), paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        yup.b("publish_story", "publish_all_old", 0, paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), yup.a(BaseApplication.getContext()), String.valueOf(paramwnm.jdField_b_of_type_Int) });
        if (!"composite".equals(paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          yup.b("publish_story", "publish_all", 0, paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), yup.a(BaseApplication.getContext()), String.valueOf(paramwnm.jdField_b_of_type_Int) });
        }
        localObject2 = paramwnm.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        yup.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramwnm.h });
        yul.a(2444493, paramwnm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        yuk.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramwnm.a(), Long.valueOf(l1));
        return;
      }
    } while (((wmd)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    wjj.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(wnm paramwnm, ErrorMessage paramErrorMessage)
  {
    if (paramwnm.jdField_a_of_type_Int == 5) {
      wmf.a().a(paramwnm.a(), paramwnm.jdField_g_of_type_JavaLangString);
    }
    while ((paramwnm.jdField_a_of_type_Int != 6) && (paramwnm.jdField_a_of_type_Int != 3) && (paramwnm.jdField_a_of_type_Int != 7)) {
      return;
    }
    wmf.a().d(paramwnm.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	wlt:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 745	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lwnk;
    //   16: checkcast 156	wnm
    //   19: invokevirtual 188	wnm:a	()Ljava/lang/String;
    //   22: invokevirtual 740	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   37: getfield 737	wlt:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 454	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 85 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 89 1 0
    //   60: checkcast 156	wnm
    //   63: invokevirtual 188	wnm:a	()Ljava/lang/String;
    //   66: invokevirtual 740	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   0	89	0	this	wlt
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
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Wme);
  }
  
  public void c(String paramString)
  {
    Object localObject = (wte)wth.a(5);
    StoryVideoItem localStoryVideoItem = ((wte)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        zom.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        zom.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        zom.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((wte)localObject).a(paramString);
    localObject = new wnm(paramString);
    super.c((wnk)localObject);
    yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    wmk.a(((wnm)localObject).a());
    Bosses.get().scheduleJobDelayed(new wly(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlt
 * JD-Core Version:    0.7.0.1
 */