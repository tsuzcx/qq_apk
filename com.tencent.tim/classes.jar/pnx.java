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
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.VideoCompositeRec.1;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
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
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

@TargetApi(14)
public class pnx
  extends pou<pox>
  implements IEventReceiver
{
  private pnx.e a;
  private boolean aAT;
  
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (this.b == null) {
      poe.a().blZ();
    }
    pox localpox = new pox(paramPublishVideoEntry);
    super.b(localpox);
    pnx.d locald;
    if (!localpox.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool1 = true;
      poe.a().aw(paramPublishVideoEntry.fakeVid, bool1);
      locald = new pnx.d(true);
      if (localpox.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label291;
      }
    }
    Object localObject1;
    label291:
    for (boolean bool1 = true;; bool1 = false)
    {
      locald.aAU = bool1;
      localObject1 = (psu)psx.a(5);
      Object localObject2 = localpox.a();
      locald.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((psu)localObject1).a(localpox.mp(), (StoryVideoItem)localObject2);
      locald.a = localpox.a();
      localObject1 = localpox.a();
      if ((localObject1 == null) || (((ptz)localObject1).mB == null)) {
        break label297;
      }
      locald.my = new ArrayList();
      localObject1 = ((ptz)localObject1).mB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        localObject2 = new pnx.c();
        ((pnx.c)localObject2).b = qvf.a((String)localObject3, localpox.a().mLocalDate);
        ((pnx.c)localObject2).hq = new ArrayList(1);
        localObject3 = new pnx.b();
        ((pnx.b)localObject3).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = locald.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        ((pnx.c)localObject2).hq.add(localObject3);
        locald.my.add(localObject2);
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
      if ((psr.IK()) && (Build.VERSION.SDK_INT < 27)) {
        paramPublishVideoEntry.hwBitrateMode = 0;
      }
      if (psr.IL()) {
        paramPublishVideoEntry.isNeedHighProfile = true;
      }
      localObject1 = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
      paramPublishVideoEntry.setStatus(1000);
      ((EntityManager)localObject1).persistOrReplace(paramPublishVideoEntry);
    }
    ThreadManager.post(new StoryVideoUploadManager.4(this, localpox, locald), 8, new pob(this, localpox), false);
  }
  
  public static void a(String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramString != null) && (paramPublishVideoEntry != null) && (!paramPublishVideoEntry.hwEncodeRecordVideo) && (paramPublishVideoEntry.readerConfBytes != null) && (paramPublishVideoEntry.readerConfBytes.length > 0)) {}
    try
    {
      Object localObject = (psr)psx.a(10);
      boolean bool1 = ((Boolean)((psr)localObject).c("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)((psr)localObject).c("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2) && ((paramPublishVideoEntry.readerConfBytes[0] == 1) || (paramPublishVideoEntry.readerConfBytes[0] == 4)))
      {
        localObject = paramPublishVideoEntry.fakeVid;
        String str = rlc.f(1, paramPublishVideoEntry.videoUploadTempDir, ".mp4");
        rox.copyFile(paramString, str);
        paramString = (PublishVideoEntry)paramPublishVideoEntry.deepCopyByReflect();
        paramString.fakeVid = ("fake_vid_" + System.currentTimeMillis() + "-" + new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt());
        paramString.businessId = 1;
        paramString.publishState = 1;
        paramString.mIFrameVideoPath = str;
        paramString.publishFrom = 101;
        paramPublishVideoEntry = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        paramPublishVideoEntry.verifyAuthentication();
        paramPublishVideoEntry.createEntityManager().persistOrReplace(paramString);
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "skip encode video : old=%s, new=%s, conf=%d", new Object[] { paramString.fakeVid, localObject, Byte.valueOf(paramString.readerConfBytes[0]) });
        StoryTransitionActivity.cD(BaseApplicationImpl.getApplication());
      }
      return;
    }
    catch (Throwable paramString)
    {
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "handleVideoEvent", paramString);
    }
  }
  
  public static void a(@NonNull String paramString, @NonNull ArrayList<String> paramArrayList, int paramInt)
  {
    try
    {
      rom.sF(paramString);
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video %s: %s", new Object[] { paramString, paramArrayList });
      psu localpsu = (psu)psx.a(5);
      ArrayList localArrayList = new ArrayList(paramArrayList.size());
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localpsu.a(str);
        paramArrayList = localStoryVideoItem;
        if (localStoryVideoItem == null)
        {
          paramArrayList = new StoryVideoItem();
          paramArrayList.mVid = str;
          paramArrayList.mOwnerUid = QQStoryContext.a().getCurrentUid();
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "vid:%s for storyVideoItem is null", new Object[] { str });
        }
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.copy(paramArrayList);
        localStoryVideoItem.mVideoSource = 1;
        localStoryVideoItem.mVid = StoryVideoItem.makeFakeVid();
        localStoryVideoItem.shareGroupId = paramString;
        localStoryVideoItem.sourceVid = str;
        localStoryVideoItem.mPublishDate = qvf.jf();
        localStoryVideoItem.mUploadStatus = 0;
        localStoryVideoItem.mCreateTime = NetConnInfoCenter.getServerTimeMillis();
        localStoryVideoItem.mTimeZoneOffsetMillis = (rpq.tP() * 1000);
        if (TextUtils.isEmpty(localStoryVideoItem.mOwnerName))
        {
          paramArrayList = ((ptf)psx.a(2)).a();
          if (paramArrayList != null) {
            localStoryVideoItem.mOwnerName = paramArrayList.getDisplayName();
          }
        }
        localpsu.a(localStoryVideoItem.mVid, localStoryVideoItem);
        localArrayList.add(localStoryVideoItem);
      }
      a(paramString, localArrayList, paramInt);
    }
    finally {}
    pmi.a().dispatch(new pnx.a());
  }
  
  private static void a(String paramString, List<StoryVideoItem> paramList, int paramInt)
  {
    for (;;)
    {
      VideoListFeedItem localVideoListFeedItem;
      psu localpsu;
      Object localObject5;
      try
      {
        localVideoListFeedItem = qvf.a(paramString, qvf.jf());
        if ((localVideoListFeedItem != null) && (paramList != null))
        {
          int i = paramList.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        localpsu = (psu)psx.a(5);
        localObject1 = new pnx.d(true);
        ((pnx.d)localObject1).aAU = false;
        ((pnx.d)localObject1).my = new ArrayList(1);
        localObject2 = new pnx.c();
        ((pnx.d)localObject1).my.add(localObject2);
        ((pnx.c)localObject2).b = localVideoListFeedItem;
        localObject3 = paramList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (StoryVideoItem)((Iterator)localObject3).next();
          ((StoryVideoItem)localObject4).mUploadStatus = 4;
          localObject5 = new pnx.b();
          ((pnx.b)localObject5).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localpsu.a((StoryVideoItem)localObject4);
          ((pnx.c)localObject2).hq.add(localObject5);
          continue;
        }
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
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
      paramString = new pyh(paramString, (List)localObject1, (List)localObject2, (List)localObject3, paramInt);
      ppv.a().a(paramString, new pnz(localVideoListFeedItem, paramList, localpsu));
    }
  }
  
  public static void a(List<StoryVideoItem> paramList, Activity paramActivity)
  {
    if (!aqiw.isNetworkAvailable(paramActivity)) {
      QQToast.a(paramActivity, 1, acfp.m(2131714981), 0).show();
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
        else if (pnx.d.eB(localStoryVideoItem.mUpLoadFailedError))
        {
          localArrayList1.add(localStoryVideoItem.mVid);
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "video file not exist, vid:%s", new Object[] { localStoryVideoItem.mVid });
        }
        else
        {
          a(localStoryVideoItem, paramActivity);
        }
      }
      if (localArrayList2.size() > 0) {
        i(((StoryVideoItem)localArrayList2.get(0)).shareGroupId, localArrayList2);
      }
    } while ((localArrayList1.size() <= 0) || (paramActivity.isFinishing()));
    paramList = aqha.a(paramActivity, 230);
    paramList.setTitle(acfp.m(2131714982));
    paramList.setMessage(acfp.m(2131714984));
    paramList.setPositiveButton(acfp.m(2131714983), new pny(localArrayList1));
    paramList.setCancelable(false);
    paramList.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramList.show();
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (!aqiw.isNetworkAvailable(paramContext))
    {
      QQToast.a(paramContext, 1, acfp.m(2131714980), 0).show();
      return false;
    }
    ((pnx)psx.a().b(3)).a(paramStoryVideoItem);
    return true;
  }
  
  private void blY()
  {
    ram.i("Q.qqstory.publish.upload:StoryVideoUploadManager", "start load all fail task");
    Bosses.get().postJob(new pod(this, "Q.qqstory.publish.upload:StoryVideoUploadManager"));
  }
  
  public static void i(String paramString, List<StoryVideoItem> paramList)
  {
    try
    {
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry add shareGroup video %s: %s", new Object[] { paramString, Integer.valueOf(paramList.size()) });
      a(paramString, paramList, 1);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void qT(String paramString)
  {
    ((pnx)psx.a().b(3)).qV(paramString);
  }
  
  public static void qU(String paramString)
  {
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString + " post createStoryVideo ... ");
    Bosses.get().postJob(new poa("Q.qqstory.publish.upload:StoryVideoUploadManager", paramString));
  }
  
  public static int so()
  {
    for (;;)
    {
      List localList;
      try
      {
        EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
        pnx localpnx = (pnx)psx.a(3);
        localList = localEntityManager.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, "createTime ASC", null, null);
        if ((localList == null) || (localList.size() <= 0))
        {
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: 0");
          i = 0;
          return i;
        }
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label297;
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
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo: id=%d, fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s, isPhoto = %d", new Object[] { Long.valueOf(l1), str1, Integer.valueOf(j), str2, str3, Long.valueOf(l2), str4, Integer.valueOf(i) });
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "createStoryVideo detail info:%s", new Object[] { localPublishVideoEntry });
          localPublishVideoEntry.publishState = 0;
          localEntityManager.update(localPublishVideoEntry);
          localpnx.a(localPublishVideoEntry);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label297:
      int i = localList.size();
    }
  }
  
  protected BasePublishTask a(pox parampox)
  {
    return new StoryVideoUploadTask(parampox);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (ppg.e.a(paramStoryVideoItem))
    {
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
      return;
    }
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "can not retry story by multi sender , vid %s", new Object[] { paramStoryVideoItem.mVid });
    if (this.b == null) {
      poe.a().blZ();
    }
    pox localpox = new pox(paramStoryVideoItem);
    localpox.retryTimes += 1;
    super.b(localpox);
    Object localObject1;
    if (!localpox.a().getBooleanExtra("ignorePersonalPublish", false))
    {
      bool = true;
      poe.a().aw(paramStoryVideoItem.mVid, bool);
      localObject1 = (psu)psx.a(5);
      paramStoryVideoItem = new pnx.d(false);
      if (localpox.a().getBooleanExtra("ignorePersonalPublish", false)) {
        break label324;
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      paramStoryVideoItem.aAU = bool;
      paramStoryVideoItem.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((psu)localObject1).a(localpox.mp(), localpox.a());
      paramStoryVideoItem.a = localpox.a();
      localObject1 = localpox.a();
      if ((localObject1 == null) || (((ptz)localObject1).mB == null)) {
        break label329;
      }
      paramStoryVideoItem.my = new ArrayList();
      localObject1 = ((ptz)localObject1).mB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        pnx.c localc = new pnx.c();
        localc.b = qvf.a((String)localObject2, localpox.a().mLocalDate);
        localc.hq = new ArrayList(1);
        localObject2 = new pnx.b();
        ((pnx.b)localObject2).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localc.hq.add(localObject2);
        paramStoryVideoItem.my.add(localc);
      }
      bool = false;
      break;
    }
    label329:
    pmi.a().dispatch(paramStoryVideoItem);
    super.bmk();
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "retry upload video %s", new Object[] { localpox });
  }
  
  protected void a(pox parampox)
  {
    if (isDestroy()) {
      ram.i("Q.qqstory.publish.upload:StoryVideoUploadManager", "manager had stopped");
    }
    Object localObject1;
    label136:
    label199:
    label611:
    label998:
    label1015:
    do
    {
      return;
      if (parampox.isSuccess())
      {
        localObject1 = pnh.a(parampox.vid, parampox.createTime, 0, false, false);
        if (!rox.moveFile(parampox.videoLocalPath, (String)localObject1)) {
          break label950;
        }
        parampox.videoLocalPath = ((String)localObject1);
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir %s", new Object[] { localObject1 });
        localObject1 = pnh.a(parampox.vid, parampox.createTime, 2, false, false);
        if (!rox.moveFile(parampox.aug, (String)localObject1)) {
          break label962;
        }
        parampox.auh = parampox.aug;
        parampox.aug = ((String)localObject1);
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir %s", new Object[] { localObject1 });
        if (!TextUtils.isEmpty(parampox.mPollThumbnailLocalPath))
        {
          localObject1 = pnh.a(parampox.vid, parampox.createTime, 6, false, false);
          if (!rox.moveFile(parampox.mPollThumbnailLocalPath, (String)localObject1)) {
            break label974;
          }
          parampox.mPollThumbnailLocalPath = ((String)localObject1);
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(parampox.mInteractThumbnailLocalPath))
        {
          localObject1 = pnh.a(parampox.vid, parampox.createTime, 6, false, false);
          if (!rox.moveFile(parampox.mInteractThumbnailLocalPath, (String)localObject1)) {
            break label986;
          }
          parampox.mInteractThumbnailLocalPath = ((String)localObject1);
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir %s", new Object[] { localObject1 });
        }
        if (!TextUtils.isEmpty(parampox.atImagePath))
        {
          localObject1 = pnh.a(parampox.vid, parampox.createTime, 5, false, false);
          if (!rox.moveFile(parampox.atImagePath, (String)localObject1)) {
            break label998;
          }
          parampox.atImagePath = ((String)localObject1);
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir %s", new Object[] { localObject1 });
        }
        if (parampox.a().getBooleanExtra("post_pk_comment", false))
        {
          localObject1 = parampox.a().getStringExtra("pk_feedid", null);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "game pk post comment. feedId=%s", new Object[] { localObject1 });
            localObject2 = parampox.a().getStringExtra("pk_comment_content", null);
            int i = parampox.a().getIntExtra("pk_comment_type", 0);
            localObject3 = parampox.a().getStringExtra("pk_vid", null);
            localObject4 = parampox.a().getStringExtra("post_pk_comment_style", null);
            pqf.a((String)localObject1, (String)localObject2, i, parampox.vid, parampox.a().feedId, (String)localObject3, (String)localObject4);
          }
        }
      }
      Object localObject3 = (psu)psx.a(5);
      Object localObject2 = (qvf)psx.a(11);
      Object localObject4 = ((psu)localObject3).a(parampox.mp(), parampox.a());
      ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "task state write:" + localObject4);
      localObject1 = new pnx.d(false);
      boolean bool;
      Object localObject5;
      pnx.c localc;
      pnx.b localb;
      Object localObject6;
      pzx.a locala;
      if (!parampox.a().getBooleanExtra("ignorePersonalPublish", false))
      {
        bool = true;
        ((pnx.d)localObject1).aAU = bool;
        ((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = parampox.result;
        ((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject4);
        ((pnx.d)localObject1).a = parampox.a();
        localObject4 = parampox.a();
        if ((localObject4 == null) || (((ptz)localObject4).mB == null)) {
          break label1082;
        }
        ((pnx.d)localObject1).my = new ArrayList();
        localObject4 = ((ptz)localObject4).mB.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1082;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localc = new pnx.c();
        localc.b = qvf.a((String)localObject5, parampox.a().mLocalDate);
        localc.hq = new ArrayList(1);
        localb = new pnx.b();
        localb.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        if ((((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()) && (parampox.mt != null))
        {
          localObject6 = parampox.mt.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            locala = (pzx.a)((Iterator)localObject6).next();
            if (((String)localObject5).equals(locala.unionId)) {
              if ((!(localc.b instanceof ShareGroupFeedItem)) || (!localc.b.feedId.equals(locala.feedId))) {
                break label1015;
              }
            }
          }
        }
      }
      for (localc.a = ((ShareGroupFeedItem)localc.b);; localc.a = ((ShareGroupFeedItem)((qvf)localObject2).a(localc.a)))
      {
        localObject5 = new StoryVideoItem();
        ((StoryVideoItem)localObject5).copy(((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        ((StoryVideoItem)localObject5).mVid = ((String)locala.fN.get(parampox.vid));
        ((StoryVideoItem)localObject5).mVideoIndex = 0L;
        rom.sF(((StoryVideoItem)localObject5).mVid);
        localb.c = ((psu)localObject3).a((StoryVideoItem)localObject5);
        ((qvf)localObject2).O(localc.a.ownerId, localc.a.date, localc.a.feedId);
        localObject6 = new ArrayList();
        ((ArrayList)localObject6).add(localObject5);
        ((qvf)localObject2).a(locala.feedId, (List)localObject6, false);
        localc.hq.add(localb);
        ((pnx.d)localObject1).my.add(localc);
        break label611;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move video to preload dir fail");
        break;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move thumbnail to preload dir fail");
        break label136;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move poll picture to mine dir fail");
        break label199;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move interact picture to mine dir fail");
        break label262;
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "move at picture to mine dir fail");
        break label324;
        bool = false;
        break label537;
        localc.a = new ShareGroupFeedItem();
        localc.a.copy(localc.b);
        localc.a.feedId = locala.feedId;
        rom.sF(locala.feedId);
      }
      long l1;
      if ((parampox.status == 2) && (!this.aAT))
      {
        this.aAT = true;
        long l2 = SystemClock.elapsedRealtime() - parampox.Aj;
        rar.a("video_shoot_new", "time_upload", 0, (int)l2, new String[] { rar.bY(parampox.bjK) + "", parampox.videoDuration + "", "", parampox.mEntranceType + "" });
        if (axvu.dwO)
        {
          l1 = axvu.h.t[0] + l2;
          long l3 = axvu.h.t[1];
          axvu.h.ay(2, l2 - l3);
          if (axvu.h.isEnabled())
          {
            l2 = axvu.h.t[0];
            l3 = axvu.h.t[1];
            long l4 = axvu.h.t[2];
            if ((rar.d(l1, 0L, 120000L)) && (rar.d(l2, 0L, 120000L)) && (rar.d(l3, 0L, 120000L)) && (rar.d(l4, 0L, 120000L))) {
              rar.a("PublishVideoCost", true, l1, new String[] { String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) });
            }
            axvu.h.stopMonitor();
          }
        }
      }
      if ((parampox.status == 5) || (parampox.status == 3) || (parampox.status == 6))
      {
        this.aAT = false;
        rar.a("video_shoot_new", "time_publish", 0, (int)(SystemClock.elapsedRealtime() - parampox.Aj), new String[] { rar.bY(parampox.bjK) + "", parampox.videoDuration + "", "", parampox.mEntranceType + "" });
      }
      if (((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
      {
        ((pnx.d)localObject1).c = parampox.a();
        ((pnx.d)localObject1).c.mVid = parampox.vid;
        ((pnx.d)localObject1).c = ((psu)localObject3).a(parampox.vid, ((pnx.d)localObject1).c);
        if (((pnx.d)localObject1).aAU)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(((pnx.d)localObject1).c);
          ((qvf)localObject2).a(((pnx.d)localObject1).a.feedId, (List)localObject3, false);
        }
        if (parampox.retryTimes > 0) {
          rar.a("mystory", "retrypub_suc", 0, 0, new String[] { "", "", "", parampox.vid });
        }
        localObject2 = parampox.mp() + "##:";
        l1 = SystemClock.elapsedRealtime() - parampox.Aj;
        rar.b("publish_story", "publish_all", 0, 0, new String[] { localObject2, String.valueOf(l1), rar.getNetworkType(BaseApplication.getContext()), String.valueOf(parampox.retryTimes) });
        rar.b("publish_story", "publish_all_old", 0, 0, new String[] { localObject2, String.valueOf(l1), rar.getNetworkType(BaseApplication.getContext()), String.valueOf(parampox.retryTimes) });
        localObject2 = parampox.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        rar.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, 0, new String[] { String.valueOf(bool), "", parampox.videoUrl });
        ran.aO(2444494, null);
        ram.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s success take time:%d", parampox.mp(), Long.valueOf(l1));
        pog.b(parampox.a());
      }
      if (((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail())
      {
        pmi.a().dispatchDelayed((Dispatcher.Dispatchable)localObject1, 500);
        rar.a("mystory", "publish_fail", 0, 0, new String[] { rar.bY(parampox.bjK) + "", parampox.result.errorCode + "", "", ((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        if (parampox.retryTimes > 0) {
          rar.a("mystory", "retrypub_fail", 0, 0, new String[0]);
        }
        l1 = SystemClock.elapsedRealtime() - parampox.Aj;
        localObject1 = String.format(parampox.result.extraMsg + "##times:%d##lastError:%d##fakeVid:%s##%s", new Object[] { Integer.valueOf(parampox.retryTimes), Integer.valueOf(parampox.bjJ), parampox.mp(), parampox.result.errorMsg });
        rar.b("publish_story", "publish_all_old", 0, parampox.result.errorCode, new String[] { localObject1, String.valueOf(l1), rar.getNetworkType(BaseApplication.getContext()), String.valueOf(parampox.retryTimes) });
        if (!"composite".equals(parampox.result.extraMsg)) {
          rar.b("publish_story", "publish_all", 0, parampox.result.errorCode, new String[] { localObject1, String.valueOf(l1), rar.getNetworkType(BaseApplication.getContext()), String.valueOf(parampox.retryTimes) });
        }
        localObject2 = parampox.a();
        bool = ((PublishVideoEntry)localObject2).getBooleanExtra("useFlowDecode", false);
        rar.b("video_edit", "publish_save_mode", ((PublishVideoEntry)localObject2).saveMode, parampox.result.errorCode, new String[] { String.valueOf(bool), localObject1, parampox.videoUrl });
        ran.aO(2444493, parampox.result.getErrorMessageForReport());
        ram.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "publish vid:%s fail take time:%d", parampox.mp(), Long.valueOf(l1));
        return;
      }
    } while (((pnx.d)localObject1).jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel());
    label262:
    label324:
    label974:
    label986:
    pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
    label537:
    label950:
    label962:
    return;
  }
  
  protected void a(pox parampox, ErrorMessage paramErrorMessage)
  {
    if (parampox.status == 5) {
      poe.a().cn(parampox.mp(), parampox.vid);
    }
    while ((parampox.status != 6) && (parampox.status != 3) && (parampox.status != 7)) {
      return;
    }
    poe.a().qZ(parampox.mp());
  }
  
  public void cm(@NonNull String paramString1, @NonNull String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = this.cF.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (pox)((Iterator)localObject3).next();
      } while (!paramString1.equals(((pox)localObject1).mp()));
      localObject3 = this.b;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (paramString1.equals(((pox)((BasePublishTask)localObject3).a()).mp())) {
            localObject2 = (pox)((BasePublishTask)localObject3).a();
          }
        }
      }
      if (localObject2 != null)
      {
        ((pox)localObject2).videoLocalPath = paramString2;
        localObject1 = (psu)psx.a(5);
        localObject3 = ((pox)localObject2).a();
        ((psu)localObject1).a(((pox)localObject2).mp(), (StoryVideoItem)localObject3);
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "true update video path:%s %s", new Object[] { paramString1, paramString2 });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean eY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	pnx:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BasePublishTask;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +28 -> 36
    //   11: aload_1
    //   12: aload_3
    //   13: invokevirtual 1112	com/tencent/biz/qqstory/base/videoupload/task/BasePublishTask:a	()Lpov;
    //   16: checkcast 47	pox
    //   19: invokevirtual 91	pox:mp	()Ljava/lang/String;
    //   22: invokevirtual 871	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   37: getfield 1107	pnx:cF	Ljava/util/ArrayList;
    //   40: invokevirtual 411	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 131 1 0
    //   50: ifeq +29 -> 79
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 135 1 0
    //   60: checkcast 47	pox
    //   63: invokevirtual 91	pox:mp	()Ljava/lang/String;
    //   66: invokevirtual 871	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   0	89	0	this	pnx
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
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void onDestroy()
  {
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "onDestroy");
    super.onDestroy();
    pmi.a().unRegisterSubscriber(this.a);
  }
  
  public void onInit()
  {
    super.onInit();
    blY();
    this.a = new pnx.e(this);
    pmi.a().registerSubscriber(this.a);
  }
  
  public void qV(String paramString)
  {
    Object localObject = (psu)psx.a(5);
    StoryVideoItem localStoryVideoItem = ((psu)localObject).a(paramString);
    if (localStoryVideoItem != null)
    {
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) {
        rox.fB(localStoryVideoItem.mLocalVideoPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mLocalMaskPath)) {
        rox.fB(localStoryVideoItem.mLocalMaskPath);
      }
      if (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        rox.fB(localStoryVideoItem.mVideoLocalThumbnailPath);
      }
    }
    ((psu)localObject).qV(paramString);
    localObject = new pox(paramString);
    super.c((pov)localObject);
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "delete video %s", new Object[] { paramString });
    pog.b(((pox)localObject).a());
    Bosses.get().scheduleJobDelayed(new poc(this, "Q.qqstory.publish.upload:StoryVideoUploadManager", paramString, localStoryVideoItem), 300);
  }
  
  public static class a
    extends plt
  {}
  
  public static final class b
  {
    public StoryVideoItem b;
    public StoryVideoItem c;
    
    public String toString()
    {
      return "{mFakeStoryVideoItem=" + this.b + ", mSucStoryVideoItem=" + this.c + '}';
    }
  }
  
  public static final class c
  {
    public ShareGroupFeedItem a;
    public VideoListFeedItem b;
    public ArrayList<pnx.b> hq = new ArrayList();
    
    public String toString()
    {
      return "ShareGroupFakeItem{mFeedItem=" + this.b + ", mSucFeedItem=" + this.a + ", mVideos=" + this.hq + '}';
    }
  }
  
  public static final class d
    extends plt
  {
    public GeneralFeedItem a;
    public boolean aAU = true;
    public boolean aAV;
    public StoryVideoItem b;
    public StoryVideoItem c;
    public ArrayList<pnx.c> my;
    public final boolean zU;
    
    public d(boolean paramBoolean)
    {
      this.zU = paramBoolean;
    }
    
    public static boolean eB(int paramInt)
    {
      return (paramInt == 940006) || (paramInt == 940007) || (paramInt == 940017) || (paramInt == 940018) || (paramInt == 941001) || (paramInt == 941002) || (paramInt == aoob.jD(940017)) || (paramInt == aoob.jD(9042)) || (paramInt == aoob.jD(9070)) || (paramInt == aoob.jD(9071)) || (paramInt / 100 == aoob.jD(999000) / 100) || ((paramInt >= 5100) && (paramInt <= 5108));
    }
    
    public static boolean eC(int paramInt)
    {
      return (paramInt == 941001) || (paramInt == 941002);
    }
    
    public boolean IA()
    {
      return this.aAU;
    }
    
    public boolean IB()
    {
      return (this.my != null) && (this.my.size() > 0);
    }
    
    public boolean Iz()
    {
      if (this.b == null) {
        return false;
      }
      return this.b.isTroopLocalVideoOnly();
    }
    
    public String toString()
    {
      return "StoryVideoPublishStatusEvent{mFakeStoryVideoItem=" + this.b + ", mSucStoryVideoItem=" + this.c + ", mCommentLikeFeedItem=" + this.a + ", mShareGroupFakeItems=" + this.my + '}';
    }
  }
  
  public static class e
    extends QQUIEventReceiver<pnx, poj.b>
  {
    public e(@NonNull pnx parampnx)
    {
      super();
    }
    
    public void a(@NonNull pnx parampnx, @NonNull poj.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "get event update  vid:%s video path:%s", paramb.vid, paramb.videoUrl);
        Bosses.get().postLightWeightJob(new StoryVideoUploadManager.VideoCompositeRec.1(this, parampnx, paramb), 0);
      }
    }
    
    public Class acceptEventClass()
    {
      return poj.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnx
 * JD-Core Version:    0.7.0.1
 */