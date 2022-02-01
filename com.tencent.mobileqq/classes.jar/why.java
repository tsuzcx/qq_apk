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
public class why
  extends wjo<wjr>
  implements IEventReceiver
{
  private wij jdField_a_of_type_Wij;
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    for (;;)
    {
      List localList;
      try
      {
        EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
        why localwhy = (why)wpm.a(3);
        localList = localEntityManager.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
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
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.update(localPublishVideoEntry);
          localwhy.a(localPublishVideoEntry);
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
      wik.a().a();
    }
    wjr localwjr = new wjr(paramPublishVideoEntry);
    super.b(localwjr);
    wii localwii;
    if (!localwjr.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      wik.a().a(paramPublishVideoEntry.fakeVid, bool1);
      localwii = new wii(true);
      if (localwjr.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      localwii.jdField_b_of_type_Boolean = bool1;
      localObject1 = (wpj)wpm.a(5);
      Object localObject2 = localwjr.a();
      localwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wpj)localObject1).a(localwjr.a(), (StoryVideoItem)localObject2);
      localwii.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwjr.a();
      localObject1 = localwjr.a();
      if ((localObject1 == null) || (((wrd)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label297;
      }
      localwii.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wrd)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new wih();
        ((wih)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yij.a((String)localObject3, localwjr.a().mLocalDate);
        ((wih)localObject2).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject3 = new wig();
        ((wig)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwii.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((wih)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        localwii.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
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
      if ((wpf.c()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (wpf.d()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().a().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localwjr, localwii), 8, new wic(this, localwjr), false);
  }
  
  public static void a(String paramString)
  {
    ((why)wpm.a().b(3)).c(paramString);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (wpf)wpm.a(10);
      boolean bool1 = ((Boolean)((wpf)localObject).b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((wpf)localObject).b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = zfc.a(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        zkr.c(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new woc(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().persistOrReplace(paramString);
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.a(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      yqp.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      zkb.a(paramString);
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      wpj localwpj = (wpj)wpm.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localwpj.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().b();
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = yij.a();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (zlx.a() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((wpy)wpm.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localwpj.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    wfo.a().dispatch(new wif());
  }
  
  public static void a(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
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
      wpj localwpj;
      Object localObject5;
      try
      {
        localVideoListFeedItem = yij.a(paramString, yij.a());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localwpj = (wpj)wpm.a(5);
        localObject1 = new wii(true);
        ((wii)localObject1).jdField_b_of_type_Boolean = false;
        ((wii)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wih();
        ((wii)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        ((wih)localObject2).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new wig();
          ((wig)localObject5).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localwpj.a((StoryVideoItem)localObject4);
          ((wih)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          continue;
        }
        wfo.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new wyc(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      wlb.a().a(paramString, new wia(localVideoListFeedItem, paramList, localwpj));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!bgnt.g(paramActivity)) {
      QQToast.a(paramActivity, 1, anni.a(2131713256), 0).a();
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
        else if (wii.a(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
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
    paramList = bglp.a(paramActivity, 230);
    paramList.setTitle(anni.a(2131713257));
    paramList.setMessage(anni.a(2131713259));
    paramList.setPositiveButton(anni.a(2131713258), new whz(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!bgnt.g(paramContext))
    {
      QQToast.a(paramContext, 1, anni.a(2131713255), 0).a();
      return false;
    }
    ((why)wpm.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  public static void b(String paramString)
  {
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new wib("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  private void f()
  {
    yqp.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new wie(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  protected BasePublishTask a(wjr paramwjr)
  {
    return new StoryVideoUploadTask(paramwjr);
  }
  
  public void a()
  {
    super.a();
    f();
    this.jdField_a_of_type_Wij = new wij(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Wij);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (wkf.a(paramStoryVideoItem))
    {
      yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask == null) {
      wik.a().a();
    }
    wjr localwjr = new wjr(paramStoryVideoItem);
    localwjr.jdField_b_of_type_Int += 1;
    super.b(localwjr);
    Object localObject1;
    if (!localwjr.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      wik.a().a(paramStoryVideoItem.mVid, bool);
      localObject1 = (wpj)wpm.a(5);
      paramStoryVideoItem = new wii(false);
      if (localwjr.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.jdField_b_of_type_Boolean = bool;
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wpj)localObject1).a(localwjr.a(), localwjr.a());
      paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = localwjr.a();
      localObject1 = localwjr.a();
      if ((localObject1 == null) || (((wrd)localObject1).jdField_b_of_type_JavaUtilList == null)) {
        break label327;
      }
      paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = ((wrd)localObject1).jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        wih localwih = new wih();
        localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yij.a((String)localObject2, localwjr.a().mLocalDate);
        localwih.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localObject2 = new wig();
        ((wig)localObject2).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localwih.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramStoryVideoItem.jdField_a_of_type_JavaUtilArrayList.add(localwih);
      }
      bool = false;
      break;
    }
    label327:
    wfo.a().dispatch(paramStoryVideoItem);
    super.d();
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localwjr });
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
        localObject1 = (wjr)((Iterator)localObject3).next();
      } while (!paramString1.equals(((wjr)localObject1).a()));
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((wjr)((BasePublishTask)localObject3).a()).a())) {
            localObject2 = (wjr)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((wjr)localObject2).jdField_a_of_type_JavaLangString = paramString2;
        localObject1 = (wpj)wpm.a(5);
        localObject3 = ((wjr)localObject2).a();
        ((wpj)localObject1).a(((wjr)localObject2).a(), (StoryVideoItem)localObject3);
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  protected void a(wjr paramwjr)
  {
    if (b()) {
      yqp.c("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label133:
    label195:
    label603:
    label1002:
    do
    {
      return;
      if (paramwjr.b())
      {
        localObject1 = wgw.a(paramwjr.jdField_g_of_type_JavaLangString, paramwjr.d, 0, false, false);
        if (!zkr.b(paramwjr.jdField_a_of_type_JavaLangString, (String)localObject1)) {
          break label942;
        }
        paramwjr.jdField_a_of_type_JavaLangString = ((String)localObject1);
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = wgw.a(paramwjr.jdField_g_of_type_JavaLangString, paramwjr.d, 2, false, false);
        if (!zkr.b(paramwjr.jdField_b_of_type_JavaLangString, (String)localObject1)) {
          break label953;
        }
        paramwjr.jdField_c_of_type_JavaLangString = paramwjr.jdField_b_of_type_JavaLangString;
        paramwjr.jdField_b_of_type_JavaLangString = ((String)localObject1);
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(paramwjr.e))
        {
          localObject1 = wgw.a(paramwjr.jdField_g_of_type_JavaLangString, paramwjr.d, 6, false, false);
          if (!zkr.b(paramwjr.e, (String)localObject1)) {
            break label964;
          }
          paramwjr.e = ((String)localObject1);
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwjr.jdField_f_of_type_JavaLangString))
        {
          localObject1 = wgw.a(paramwjr.jdField_g_of_type_JavaLangString, paramwjr.d, 6, false, false);
          if (!zkr.b(paramwjr.jdField_f_of_type_JavaLangString, (String)localObject1)) {
            break label975;
          }
          paramwjr.jdField_f_of_type_JavaLangString = ((String)localObject1);
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(paramwjr.m))
        {
          localObject1 = wgw.a(paramwjr.jdField_g_of_type_JavaLangString, paramwjr.d, 5, false, false);
          if (!zkr.b(paramwjr.m, (String)localObject1)) {
            break label986;
          }
          paramwjr.m = ((String)localObject1);
          yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (paramwjr.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = paramwjr.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = paramwjr.a().getStringExtra("pk_comment_content", null);
            int i = paramwjr.a().getIntExtra("pk_comment_type", 0);
            localObject3 = paramwjr.a().getStringExtra("pk_vid", null);
            localObject4 = paramwjr.a().getStringExtra("post_pk_comment_style", null);
            wlr.a((String)localObject1, (String)localObject2, i, paramwjr.jdField_g_of_type_JavaLangString, paramwjr.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (wpj)wpm.a(5);
      Object localObject2 = (yij)wpm.a(11);
      Object localObject4 = ((wpj)localObject3).a(paramwjr.a(), paramwjr.a());
      yqp.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new wii(false);
      boolean bool;
      Object localObject5;
      wih localwih;
      wig localwig;
      Object localObject6;
      xai localxai;
      if (!paramwjr.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((wii)localObject1).jdField_b_of_type_Boolean = bool;
        ((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        ((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem = paramwjr.a();
        localObject4 = paramwjr.a();
        if ((localObject4 == null) || (((wrd)localObject4).jdField_b_of_type_JavaUtilList == null)) {
          break label1069;
        }
        ((wii)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject4 = ((wrd)localObject4).jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1069;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localwih = new wih();
        localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = yij.a((String)localObject5, paramwjr.a().mLocalDate);
        localwih.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
        localwig = new wig();
        localwig.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (paramwjr.jdField_b_of_type_JavaUtilList != null))
        {
          localObject6 = paramwjr.jdField_b_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localxai = (xai)((Iterator)localObject6).next();
            if (((String)localObject5).equals(localxai.jdField_a_of_type_JavaLangString)) {
              if ((!(localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) || (!localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(localxai.jdField_b_of_type_JavaLangString))) {
                break label1002;
              }
            }
          }
        }
      }
      for (localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);; localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((yij)localObject2).a(localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)localxai.jdField_a_of_type_JavaUtilMap.get(paramwjr.jdField_g_of_type_JavaLangString));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        zkb.a(((StoryVideoItem)localObject5).mVid);
        localwig.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wpj)localObject3).a((StoryVideoItem)localObject5);
        ((yij)localObject2).a(localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((yij)localObject2).a(localxai.jdField_b_of_type_JavaLangString, (List)localObject6, false);
        localwih.jdField_a_of_type_JavaUtilArrayList.add(localwig);
        ((wii)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localwih);
        break label603;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label133;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label195;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label257;
        yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label318;
        bool = false;
        break label529;
        localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        localwih.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = localxai.jdField_b_of_type_JavaLangString;
        zkb.a(localxai.jdField_b_of_type_JavaLangString);
      }
      long l1;
      if ((paramwjr.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        long l2 = SystemClock.elapsedRealtime() - paramwjr.jdField_a_of_type_Long;
        yqu.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { yqu.b(paramwjr.jdField_f_of_type_Int) + "", paramwjr.jdField_b_of_type_Long + "", "", paramwjr.jdField_g_of_type_Int + "" });
        if (bosd.c)
        {
          l1 = bosd.h.a[0] + l2;
          long l3 = bosd.h.a[1];
          bosd.h.a(2, l2 - l3);
          if (bosd.h.a())
          {
            l2 = bosd.h.a[0];
            l3 = bosd.h.a[1];
            long l4 = bosd.h.a[2];
            if ((yqu.a(l1, 0L, 120000L)) && (yqu.a(l2, 0L, 120000L)) && (yqu.a(l3, 0L, 120000L)) && (yqu.a(l4, 0L, 120000L))) {
              yqu.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            bosd.h.c();
          }
        }
      }
      if ((paramwjr.jdField_a_of_type_Int == 5) || (paramwjr.jdField_a_of_type_Int == 3) || (paramwjr.jdField_a_of_type_Int == 6))
      {
        this.jdField_a_of_type_Boolean = false;
        yqu.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - paramwjr.jdField_a_of_type_Long), new String[] { yqu.b(paramwjr.jdField_f_of_type_Int) + "", paramwjr.jdField_b_of_type_Long + "", "", paramwjr.jdField_g_of_type_Int + "" });
      }
      if (((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((wii)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramwjr.a();
        ((wii)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid = paramwjr.jdField_g_of_type_JavaLangString;
        ((wii)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((wpj)localObject3).a(paramwjr.jdField_g_of_type_JavaLangString, ((wii)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        if (((wii)localObject1).jdField_b_of_type_Boolean)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((wii)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
          ((yij)localObject2).a(((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId, (List)localObject3, false);
        }
        if (paramwjr.jdField_b_of_type_Int > 0) {
          yqu.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", paramwjr.jdField_g_of_type_JavaLangString });
        }
        localObject2 = paramwjr.a() + "##:";
        l1 = SystemClock.elapsedRealtime() - paramwjr.jdField_a_of_type_Long;
        yqu.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), yqu.a(BaseApplication.getContext()), String.valueOf(paramwjr.jdField_b_of_type_Int) });
        yqu.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), yqu.a(BaseApplication.getContext()), String.valueOf(paramwjr.jdField_b_of_type_Int) });
        localObject2 = paramwjr.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        yqu.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", paramwjr.h });
        yqq.a(2444494, null);
        yqp.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", paramwjr.a(), Long.valueOf(l1));
        wip.a(paramwjr.a());
      }
      if (((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        wfo.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        yqu.a("mystory", "publish_fail", 0, 0, new String[] { yqu.b(paramwjr.jdField_f_of_type_Int) + "", paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode + "", "", ((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (paramwjr.jdField_b_of_type_Int > 0) {
          yqu.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - paramwjr.jdField_a_of_type_Long;
        localObject1 = String.format(paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(paramwjr.jdField_b_of_type_Int), Integer.valueOf(paramwjr.jdField_c_of_type_Int), paramwjr.a(), paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
        yqu.b("publish_story", "publish_all_old", 0, paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), yqu.a(BaseApplication.getContext()), String.valueOf(paramwjr.jdField_b_of_type_Int) });
        if (!"composite".equals(paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.extraMsg)) {
          yqu.b("publish_story", "publish_all", 0, paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localObject1, String.valueOf(l1), yqu.a(BaseApplication.getContext()), String.valueOf(paramwjr.jdField_b_of_type_Int) });
        }
        localObject2 = paramwjr.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        yqu.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { String.valueOf(bool), localObject1, paramwjr.h });
        yqq.a(2444493, paramwjr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessageForReport());
        yqp.a("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", paramwjr.a(), Long.valueOf(l1));
        return;
      }
    } while (((wii)localObject1).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label257:
    label318:
    label964:
    label975:
    label986:
    wfo.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label529:
    label942:
    label953:
    return;
  }
  
  protected void a(wjr paramwjr, ErrorMessage paramErrorMessage)
  {
    if (paramwjr.jdField_a_of_type_Int == 5) {
      wik.a().a(paramwjr.a(), paramwjr.jdField_g_of_type_JavaLangString);
    }
    while ((paramwjr.jdField_a_of_type_Int != 6) && (paramwjr.jdField_a_of_type_Int != 3) && (paramwjr.jdField_a_of_type_Int != 7)) {
      return;
    }
    wik.a().d(paramwjr.a());
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 147	why:jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBasePublishTask	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 745	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lwjp;
    //   16: checkcast 156	wjr
    //   19: invokevirtual 188	wjr:a	()Ljava/lang/String;
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
    //   37: getfield 737	why:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   40: invokevirtual 454	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 85 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 89 1 0
    //   60: checkcast 156	wjr
    //   63: invokevirtual 188	wjr:a	()Ljava/lang/String;
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
    //   0	89	0	this	why
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
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.b();
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Wij);
  }
  
  public void c(String paramString)
  {
    Object localObject = (wpj)wpm.a(5);
    StoryVideoItem localStoryVideoItem = ((wpj)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        zkr.g(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        zkr.g(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        zkr.g(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((wpj)localObject).a(paramString);
    localObject = new wjr(paramString);
    super.c((wjp)localObject);
    yqp.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    wip.a(((wjr)localObject).a());
    Bosses.get().scheduleJobDelayed(new wid(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public boolean isValidate()
  {
    return !this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     why
 * JD-Core Version:    0.7.0.1
 */