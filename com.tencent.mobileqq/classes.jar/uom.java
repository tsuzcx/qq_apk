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
public class uom
  extends uqc<uqf>
  implements IEventReceiver
{
  private uox jdField_a_of_type_Uox;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        awgf localawgf = QQStoryContext.a().a().createEntityManager();
        uom localuom = (uom)uwa.a(3);
        localList = localawgf.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
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
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localawgf.a(localPublishVideoEntry);
          localuom.a(localPublishVideoEntry);
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
      uoy.a().a();
    }
    uqf localuqf = new uqf(paramPublishVideoEntry);
    super.b(localuqf);
    uow localuow;
    if (!localuqf.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      uoy.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localuow = new uow(true);
      if (localuqf.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localuow.jdField_b_of_type_Boolean = bool1;
      localObject1 = (uvx)uwa.a(5);
      Object localObject2 = localuqf.a();
      localuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uvx)localObject1).a(localuqf.a(), (StoryVideoItem)localObject2);
      localuow.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localuqf.a();
      localObject1 = localuqf.a();
      if ((localObject1 == null) || (((uxr)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localuow.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((uxr)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new uov();
        ((uov)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = woy.a((String)localObject3, localuqf.a().mLocalDate);
        ((uov)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new uou();
        ((uou)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localuow.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((uov)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localuow.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
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
      if ((uvt.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (uvt.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((awgf)localObject1).b(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localuqf, localuow), 8, new uoq(this, localuqf), false);
  }
  
  public static void a(String paramString)
  {
    ((uom)uwa.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (uvt)uwa.a(10);
      boolean bool1 = ((Boolean)((uvt)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((uvt)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = xlr.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        xrg.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new uuq(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().b(paramString);
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      wxe.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      xqq.a(paramString);
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      uvx localuvx = (uvx)uwa.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localuvx.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = woy.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (xsm.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((uwm)uwa.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localuvx.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    umc.a().dispatch(new uot());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
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
      uvx localuvx;
      Object localObject5;
      try
      {
        localVideoListFeedItem = woy.a(paramString, woy.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localuvx = (uvx)uwa.a(5);
        localObject1 = new uow(true);
        ((uow)localObject1).jdField_b_of_type_Boolean = false;
        ((uow)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new uov();
        ((uow)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((uov)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new uou();
          ((uou)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localuvx.a((StoryVideoItem)localObject4);
          ((uov)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        umc.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new veq(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      urp.a().a(paramString, new uoo(localVideoListFeedItem, paramList, localuvx));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bdin.g(paramActivity)) {
      QQToast.a(paramActivity, 1, alud.a(2131714955), 0).a();
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
        else if (uow.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
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
    paramList = bdgm.a(paramActivity, 230);
    paramList.setTitle(alud.a(2131714956));
    paramList.setMessage(alud.a(2131714958));
    paramList.setPositiveButton(alud.a(2131714957), new uon(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bdin.g(paramContext))
    {
      QQToast.a(paramContext, 1, alud.a(2131714954), 0).a();
      return false;
    }
    ((uom)uwa.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new uop("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    wxe.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new uos(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(uqf paramuqf)
  {
    return new StoryVideoUploadTask(paramuqf);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Uox = new uox(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Uox);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (uqt.a(paramStoryVideoItem))
    {
      wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      uoy.a().a();
    }
    uqf localuqf = new uqf(paramStoryVideoItem);
    localuqf.jdField_b_of_type_Int += 1;
    super.b(localuqf);
    Object localObject1;
    if (!localuqf.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      uoy.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (uvx)uwa.a(5);
      paramStoryVideoItem = new uow(false);
      if (localuqf.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uvx)localObject1).a(localuqf.a(), localuqf.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localuqf.a();
      localObject1 = localuqf.a();
      if ((localObject1 == null) || (((uxr)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((uxr)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        uov localuov = new uov();
        localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = woy.a((String)localObject2, localuqf.a().mLocalDate);
        localuov.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new uou();
        ((uou)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localuov.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localuov);
      }
      bool = false;
      break;
    }
    label327:
    umc.a().dispatch(paramStoryVideoItem);
    super.d();
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localuqf });
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
        localObject1 = (uqf)((Iterator)localObject3).next();
      } while (!paramString1.equals(((uqf)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((uqf)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (uqf)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((uqf)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (uvx)uwa.a(5);
        localObject3 = ((uqf)localObject2).a();
        ((uvx)localObject1).a(((uqf)localObject2).a(), (StoryVideoItem)localObject3);
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(uqf paramuqf)
  {
    if (b()) {
      wxe.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramuqf.b())
      {
        localObject1 = unk.a(paramuqf.jdField_g_of_type_JavaLangString, paramuqf.d, 0, false, false);
        if (!xrg.b(paramuqf.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramuqf.jdField_a_of_type_JavaLangString = ((String)localObject1);
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = unk.a(paramuqf.jdField_g_of_type_JavaLangString, paramuqf.d, 2, false, false);
        if (!xrg.b(paramuqf.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramuqf.jdField_c_of_type_JavaLangString = paramuqf.jdField_b_of_type_JavaLangString;
        paramuqf.jdField_b_of_type_JavaLangString = ((String)localObject1);
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramuqf.e))
        {
          localObject1 = unk.a(paramuqf.jdField_g_of_type_JavaLangString, paramuqf.d, 6, false, false);
          if (!xrg.b(paramuqf.e, (String)localObject1)) {
            break label964;
          }
          paramuqf.e = ((String)localObject1);
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramuqf.jdField_f_of_type_JavaLangString))
        {
          localObject1 = unk.a(paramuqf.jdField_g_of_type_JavaLangString, paramuqf.d, 6, false, false);
          if (!xrg.b(paramuqf.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramuqf.jdField_f_of_type_JavaLangString = ((String)localObject1);
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramuqf.m))
        {
          localObject1 = unk.a(paramuqf.jdField_g_of_type_JavaLangString, paramuqf.d, 5, false, false);
          if (!xrg.b(paramuqf.m, (String)localObject1)) {
            break label986;
          }
          paramuqf.m = ((String)localObject1);
          wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramuqf.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramuqf.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramuqf.a().getStringExtra("pk_comment_content", null);
            int i = paramuqf.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramuqf.a().getStringExtra("pk_vid", null);
            localObject4 = paramuqf.a().getStringExtra("post_pk_comment_style", null);
            usf.a((String)localObject1, (String)localObject2, i, paramuqf.jdField_g_of_type_JavaLangString, paramuqf.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (uvx)uwa.a(5);
      Object localObject2 = (woy)uwa.a(11);
      Object localObject4 = ((uvx)localObject3).a(paramuqf.a(), paramuqf.a());
      wxe.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new uow(false);
      boolean bool;
      Object localObject5;
      uov localuov;
      uou localuou;
      Object localObject6;
      vgw localvgw;
      if (!paramuqf.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((uow)localObject1).jdField_b_of_type_Boolean = bool;
        ((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramuqf.a();
        localObject4 = paramuqf.a();
        if ((localObject4 == null) || (((uxr)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((uow)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((uxr)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localuov = new uov();
        localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = woy.a((String)localObject5, paramuqf.a().mLocalDate);
        localuov.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localuou = new uou();
        localuou.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramuqf.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramuqf.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localvgw = (vgw)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localvgw.jdField_a_of_type_JavaLangString)) {
              if ((!(localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localvgw.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((woy)localObject2).a(localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localvgw.jdField_a_of_type_JavaUtilMap.get(paramuqf.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        xqq.a(((StoryVideoItem)localObject5).mVid);
        localuou.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uvx)localObject3).a((StoryVideoItem)localObject5);
        ((woy)localObject2).a(localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((woy)localObject2).a(localvgw.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localuov.jdField_a_of_type_JavaUtilArrayList.add(localuou);
        ((uow)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localuov);
        break label603;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localuov.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localvgw.jdField_b_of_type_JavaLangString;
        xqq.a(localvgw.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramuqf.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramuqf.jdField_a_of_type_Long;
        wxj.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { wxj.b(paramuqf.jdField_f_of_type_Int) + "", paramuqf.jdField_b_of_type_Long + "", "", paramuqf.jdField_g_of_type_Int + "" });
        if (blyz.c)
        {
          l1 = blyz.h.a[0] + l2;
          long l3 = blyz.h.a[1];
          blyz.h.a(2, l2 - l3);
          if (blyz.h.a())
          {
            l2 = blyz.h.a[0];
            l3 = blyz.h.a[1];
            long l4 = blyz.h.a[2];
            if ((wxj.a(l1, 0L, 120000L)) && (wxj.a(l2, 0L, 120000L)) && (wxj.a(l3, 0L, 120000L)) && (wxj.a(l4, 0L, 120000L))) {
              wxj.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            blyz.h.c();
          }
        }
      }
      if ((paramuqf.jdField_a_of_type_Int == 5) || (paramuqf.jdField_a_of_type_Int == 3) || (paramuqf.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        wxj.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramuqf.jdField_a_of_type_Long), new String[] { wxj.b(paramuqf.jdField_f_of_type_Int) + "", paramuqf.jdField_b_of_type_Long + "", "", paramuqf.jdField_g_of_type_Int + "" });
      }
      if (((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((uow)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramuqf.a();
        ((uow)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramuqf.jdField_g_of_type_JavaLangString;
        ((uow)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((uvx)localObject3).a(paramuqf.jdField_g_of_type_JavaLangString, ((uow)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((uow)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((uow)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((woy)localObject2).a(((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramuqf.jdField_b_of_type_Int > 0) {
          wxj.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramuqf.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramuqf.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramuqf.jdField_a_of_type_Long;
        wxj.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), wxj.a(BaseApplication.getContext()), String.valueOf(paramuqf.jdField_b_of_type_Int) });
        wxj.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), wxj.a(BaseApplication.getContext()), String.valueOf(paramuqf.jdField_b_of_type_Int) });
        localObject2 = paramuqf.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        wxj.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramuqf.h });
        wxf.a(2444494, null);
        wxe.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramuqf.a(), Long.valueOf(l1));
        upd.a(paramuqf.a());
      }
      if (((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        umc.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        wxj.a("mystory", "publish_fail", 0, 0, new String[] { wxj.b(paramuqf.jdField_f_of_type_Int) + "", paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramuqf.jdField_b_of_type_Int > 0) {
          wxj.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramuqf.jdField_a_of_type_Long;
        localObject1 = String.format(paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramuqf.jdField_b_of_type_Int), Integer.valueOf(paramuqf.jdField_c_of_type_Int), paramuqf.a(), paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        wxj.b("publish_story", "publish_all_old", 0, paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), wxj.a(BaseApplication.getContext()), String.valueOf(paramuqf.jdField_b_of_type_Int) });
        if (!"composite".equals(paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          wxj.b("publish_story", "publish_all", 0, paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), wxj.a(BaseApplication.getContext()), String.valueOf(paramuqf.jdField_b_of_type_Int) });
        }
        localObject2 = paramuqf.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        wxj.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramuqf.h });
        wxf.a(2444493, paramuqf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        wxe.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramuqf.a(), Long.valueOf(l1));
        return;
      }
    } while (((uow)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    umc.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(uqf paramuqf, ErrorMessage paramErrorMessage)
  {
    if (paramuqf.jdField_a_of_type_Int == 5) {
      uoy.a().a(paramuqf.a(), paramuqf.jdField_g_of_type_JavaLangString);
    }
    while ((paramuqf.jdField_a_of_type_Int != 6) && (paramuqf.jdField_a_of_type_Int != 3) && (paramuqf.jdField_a_of_type_Int != 7)) {
      return;
    }
    uoy.a().d(paramuqf.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 145	uom:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 742	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Luqd;
    //   16: checkcast 154	uqf
    //   19: invokevirtual 186	uqf:a	()Ljava/lang/String;
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
    //   37: getfield 734	uom:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 451	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 84 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 88 1 0
    //   60: checkcast 154	uqf
    //   63: invokevirtual 186	uqf:a	()Ljava/lang/String;
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
    //   0	89	0	this	uom
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
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Uox);
  }
  
  public void c(String paramString)
  {
    Object localObject = (uvx)uwa.a(5);
    StoryVideoItem localStoryVideoItem = ((uvx)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        xrg.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        xrg.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        xrg.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((uvx)localObject).a(paramString);
    localObject = new uqf(paramString);
    super.c((uqd)localObject);
    wxe.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    upd.a(((uqf)localObject).a());
    Bosses.get().scheduleJobDelayed(new uor(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uom
 * JD-Core Version:    0.7.0.1
 */