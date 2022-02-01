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
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
public class wcn
  extends wdv<wdy>
  implements IEventReceiver
{
  private wcy jdField_a_of_type_Wcy;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
        wcn localwcn = (wcn)wjs.a(3);
        localList = localEntityManager.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
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
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.update(localPublishVideoEntry);
          localwcn.a(localPublishVideoEntry);
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
      wcz.a().a();
    }
    wdy localwdy = new wdy(paramPublishVideoEntry);
    super.b(localwdy);
    wcx localwcx;
    if (!localwdy.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      wcz.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localwcx = new wcx(true);
      if (localwdy.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localwcx.jdField_b_of_type_Boolean = bool1;
      localObject1 = (wjp)wjs.a(5);
      Object localObject2 = localwdy.a();
      localwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wjp)localObject1).a(localwdy.a(), (StoryVideoItem)localObject2);
      localwcx.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwdy.a();
      localObject1 = localwdy.a();
      if ((localObject1 == null) || (((wlj)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localwcx.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wlj)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new wcw();
        ((wcw)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yck.a((String)localObject3, localwdy.a().mLocalDate);
        ((wcw)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new wcv();
        ((wcv)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwcx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((wcw)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localwcx.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
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
      if ((wjl.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (wjl.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localwdy, localwcx), 8, new wcr(this, localwdy), false);
  }
  
  public static void a(String paramString)
  {
    ((wcn)wjs.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (wjl)wjs.a(10);
      boolean bool1 = ((Boolean)((wjl)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((wjl)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = yyq.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        zeb.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new wii(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().persistOrReplace(paramString);
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      zdl.a(paramString);
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      wjp localwjp = (wjp)wjs.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localwjp.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = yck.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (UIUtils.getTimeZoneOffset() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((wke)wjs.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localwjp.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    wad.a().dispatch(new wcu());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
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
      wjp localwjp;
      Object localObject5;
      try
      {
        localVideoListFeedItem = yck.a(paramString, yck.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localwjp = (wjp)wjs.a(5);
        localObject1 = new wcx(true);
        ((wcx)localObject1).jdField_b_of_type_Boolean = false;
        ((wcx)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wcw();
        ((wcx)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((wcw)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new wcv();
          ((wcv)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwjp.a((StoryVideoItem)localObject4);
          ((wcw)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new wsi(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      wfi.a().a(paramString, new wcp(localVideoListFeedItem, paramList, localwjp));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!NetworkUtil.isNetworkAvailable(paramActivity)) {
      QQToast.a(paramActivity, 1, anvx.a(2131713944), 0).a();
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
        else if (wcx.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
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
    paramList = bhdj.a(paramActivity, 230);
    paramList.setTitle(anvx.a(2131713945));
    paramList.setMessage(anvx.a(2131713947));
    paramList.setPositiveButton(anvx.a(2131713946), new wco(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      QQToast.a(paramContext, 1, anvx.a(2131713943), 0).a();
      return false;
    }
    ((wcn)wjs.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new wcq("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    ykq.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new wct(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(wdy paramwdy)
  {
    return new StoryVideoUploadTask(paramwdy);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Wcy = new wcy(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Wcy);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (wem.a(paramStoryVideoItem))
    {
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      wcz.a().a();
    }
    wdy localwdy = new wdy(paramStoryVideoItem);
    localwdy.jdField_b_of_type_Int += 1;
    super.b(localwdy);
    Object localObject1;
    if (!localwdy.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      wcz.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (wjp)wjs.a(5);
      paramStoryVideoItem = new wcx(false);
      if (localwdy.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wjp)localObject1).a(localwdy.a(), localwdy.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwdy.a();
      localObject1 = localwdy.a();
      if ((localObject1 == null) || (((wlj)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wlj)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        wcw localwcw = new wcw();
        localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yck.a((String)localObject2, localwdy.a().mLocalDate);
        localwcw.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wcv();
        ((wcv)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localwcw.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localwcw);
      }
      bool = false;
      break;
    }
    label327:
    wad.a().dispatch(paramStoryVideoItem);
    super.d();
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localwdy });
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
        localObject1 = (wdy)((Iterator)localObject3).next();
      } while (!paramString1.equals(((wdy)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((wdy)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (wdy)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((wdy)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (wjp)wjs.a(5);
        localObject3 = ((wdy)localObject2).a();
        ((wjp)localObject1).a(((wdy)localObject2).a(), (StoryVideoItem)localObject3);
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(wdy paramwdy)
  {
    if (b()) {
      ykq.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramwdy.b())
      {
        localObject1 = wbl.a(paramwdy.jdField_g_of_type_JavaLangString, paramwdy.d, 0, false, false);
        if (!zeb.b(paramwdy.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramwdy.jdField_a_of_type_JavaLangString = ((String)localObject1);
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = wbl.a(paramwdy.jdField_g_of_type_JavaLangString, paramwdy.d, 2, false, false);
        if (!zeb.b(paramwdy.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramwdy.jdField_c_of_type_JavaLangString = paramwdy.jdField_b_of_type_JavaLangString;
        paramwdy.jdField_b_of_type_JavaLangString = ((String)localObject1);
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramwdy.e))
        {
          localObject1 = wbl.a(paramwdy.jdField_g_of_type_JavaLangString, paramwdy.d, 6, false, false);
          if (!zeb.b(paramwdy.e, (String)localObject1)) {
            break label964;
          }
          paramwdy.e = ((String)localObject1);
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwdy.jdField_f_of_type_JavaLangString))
        {
          localObject1 = wbl.a(paramwdy.jdField_g_of_type_JavaLangString, paramwdy.d, 6, false, false);
          if (!zeb.b(paramwdy.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramwdy.jdField_f_of_type_JavaLangString = ((String)localObject1);
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwdy.m))
        {
          localObject1 = wbl.a(paramwdy.jdField_g_of_type_JavaLangString, paramwdy.d, 5, false, false);
          if (!zeb.b(paramwdy.m, (String)localObject1)) {
            break label986;
          }
          paramwdy.m = ((String)localObject1);
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramwdy.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramwdy.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramwdy.a().getStringExtra("pk_comment_content", null);
            int i = paramwdy.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramwdy.a().getStringExtra("pk_vid", null);
            localObject4 = paramwdy.a().getStringExtra("post_pk_comment_style", null);
            wfy.a((String)localObject1, (String)localObject2, i, paramwdy.jdField_g_of_type_JavaLangString, paramwdy.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (wjp)wjs.a(5);
      Object localObject2 = (yck)wjs.a(11);
      Object localObject4 = ((wjp)localObject3).a(paramwdy.a(), paramwdy.a());
      ykq.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new wcx(false);
      boolean bool;
      Object localObject5;
      wcw localwcw;
      wcv localwcv;
      Object localObject6;
      wuo localwuo;
      if (!paramwdy.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((wcx)localObject1).jdField_b_of_type_Boolean = bool;
        ((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramwdy.a();
        localObject4 = paramwdy.a();
        if ((localObject4 == null) || (((wlj)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((wcx)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((wlj)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localwcw = new wcw();
        localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yck.a((String)localObject5, paramwdy.a().mLocalDate);
        localwcw.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localwcv = new wcv();
        localwcv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramwdy.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramwdy.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localwuo = (wuo)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localwuo.jdField_a_of_type_JavaLangString)) {
              if ((!(localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localwuo.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((yck)localObject2).a(localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localwuo.jdField_a_of_type_JavaUtilMap.get(paramwdy.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        zdl.a(((StoryVideoItem)localObject5).mVid);
        localwcv.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wjp)localObject3).a((StoryVideoItem)localObject5);
        ((yck)localObject2).a(localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((yck)localObject2).a(localwuo.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localwcw.jdField_a_of_type_JavaUtilArrayList.add(localwcv);
        ((wcx)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localwcw);
        break label603;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localwcw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localwuo.jdField_b_of_type_JavaLangString;
        zdl.a(localwuo.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramwdy.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramwdy.jdField_a_of_type_Long;
        ykv.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { ykv.b(paramwdy.jdField_f_of_type_Int) + "", paramwdy.jdField_b_of_type_Long + "", "", paramwdy.jdField_g_of_type_Int + "" });
        if (bomw.c)
        {
          l1 = bomw.h.a[0] + l2;
          long l3 = bomw.h.a[1];
          bomw.h.a(2, l2 - l3);
          if (bomw.h.a())
          {
            l2 = bomw.h.a[0];
            l3 = bomw.h.a[1];
            long l4 = bomw.h.a[2];
            if ((ykv.a(l1, 0L, 120000L)) && (ykv.a(l2, 0L, 120000L)) && (ykv.a(l3, 0L, 120000L)) && (ykv.a(l4, 0L, 120000L))) {
              ykv.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            bomw.h.c();
          }
        }
      }
      if ((paramwdy.jdField_a_of_type_Int == 5) || (paramwdy.jdField_a_of_type_Int == 3) || (paramwdy.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        ykv.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramwdy.jdField_a_of_type_Long), new String[] { ykv.b(paramwdy.jdField_f_of_type_Int) + "", paramwdy.jdField_b_of_type_Long + "", "", paramwdy.jdField_g_of_type_Int + "" });
      }
      if (((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((wcx)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramwdy.a();
        ((wcx)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramwdy.jdField_g_of_type_JavaLangString;
        ((wcx)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wjp)localObject3).a(paramwdy.jdField_g_of_type_JavaLangString, ((wcx)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((wcx)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((wcx)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((yck)localObject2).a(((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramwdy.jdField_b_of_type_Int > 0) {
          ykv.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramwdy.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramwdy.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramwdy.jdField_a_of_type_Long;
        ykv.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), ykv.a(BaseApplication.getContext()), String.valueOf(paramwdy.jdField_b_of_type_Int) });
        ykv.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), ykv.a(BaseApplication.getContext()), String.valueOf(paramwdy.jdField_b_of_type_Int) });
        localObject2 = paramwdy.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        ykv.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramwdy.h });
        ykr.a(2444494, null);
        ykq.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramwdy.a(), Long.valueOf(l1));
        VideoCompositeHelper.deleteVideoCache(paramwdy.a());
      }
      if (((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        wad.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        ykv.a("mystory", "publish_fail", 0, 0, new String[] { ykv.b(paramwdy.jdField_f_of_type_Int) + "", paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramwdy.jdField_b_of_type_Int > 0) {
          ykv.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramwdy.jdField_a_of_type_Long;
        localObject1 = String.format(paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramwdy.jdField_b_of_type_Int), Integer.valueOf(paramwdy.jdField_c_of_type_Int), paramwdy.a(), paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        ykv.b("publish_story", "publish_all_old", 0, paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), ykv.a(BaseApplication.getContext()), String.valueOf(paramwdy.jdField_b_of_type_Int) });
        if (!"composite".equals(paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          ykv.b("publish_story", "publish_all", 0, paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), ykv.a(BaseApplication.getContext()), String.valueOf(paramwdy.jdField_b_of_type_Int) });
        }
        localObject2 = paramwdy.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        ykv.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramwdy.h });
        ykr.a(2444493, paramwdy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        ykq.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramwdy.a(), Long.valueOf(l1));
        return;
      }
    } while (((wcx)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(wdy paramwdy, ErrorMessage paramErrorMessage)
  {
    if (paramwdy.jdField_a_of_type_Int == 5) {
      wcz.a().a(paramwdy.a(), paramwdy.jdField_g_of_type_JavaLangString);
    }
    while ((paramwdy.jdField_a_of_type_Int != 6) && (paramwdy.jdField_a_of_type_Int != 3) && (paramwdy.jdField_a_of_type_Int != 7)) {
      return;
    }
    wcz.a().d(paramwdy.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	wcn:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 746	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lwdw;
    //   16: checkcast 156	wdy
    //   19: invokevirtual 188	wdy:a	()Ljava/lang/String;
    //   22: invokevirtual 741	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   37: getfield 738	wcn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 454	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 85 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 89 1 0
    //   60: checkcast 156	wdy
    //   63: invokevirtual 188	wdy:a	()Ljava/lang/String;
    //   66: invokevirtual 741	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   0	89	0	this	wcn
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
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Wcy);
  }
  
  public void c(String paramString)
  {
    Object localObject = (wjp)wjs.a(5);
    StoryVideoItem localStoryVideoItem = ((wjp)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        zeb.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        zeb.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        zeb.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((wjp)localObject).a(paramString);
    localObject = new wdy(paramString);
    super.c((wdw)localObject);
    ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    VideoCompositeHelper.deleteVideoCache(((wdy)localObject).a());
    Bosses.get().scheduleJobDelayed(new wcs(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcn
 * JD-Core Version:    0.7.0.1
 */