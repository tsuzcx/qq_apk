import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.4;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqstory.model.item.StoryVideoItem;>;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class ujx
  implements IEventReceiver, ujc<ujt>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<ukt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final sgc jdField_a_of_type_Sgc = new uka(this);
  private uiy jdField_a_of_type_Uiy;
  private ukb jdField_a_of_type_Ukb;
  private ukc jdField_a_of_type_Ukc;
  private ukd jdField_a_of_type_Ukd;
  private uke jdField_a_of_type_Uke;
  private ukf jdField_a_of_type_Ukf;
  private ukg jdField_a_of_type_Ukg;
  private ukh jdField_a_of_type_Ukh;
  private uki jdField_a_of_type_Uki;
  private ukj jdField_a_of_type_Ukj;
  private ukk jdField_a_of_type_Ukk;
  private ukl jdField_a_of_type_Ukl;
  private ukm jdField_a_of_type_Ukm;
  private ukn jdField_a_of_type_Ukn;
  private uko jdField_a_of_type_Uko;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ujx(int paramInt, @NonNull ukg paramukg, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ukg = paramukg;
    vkw.a(this.jdField_a_of_type_Ukg);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      vkw.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<ukt> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ukt)paramList.next();
      if ((localObject instanceof ujm))
      {
        localObject = (ujm)localObject;
        if (((GeneralFeedItem)((ujm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((ujm)localObject).a());
        }
      }
    }
    return null;
  }
  
  private ujm a(List<ukt> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ukt)paramList.next();
      if ((localObject instanceof ujm))
      {
        localObject = (ujm)localObject;
        if ((((GeneralFeedItem)((ujm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((ujm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          urk.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private ukv a(List<ukt> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ukt)paramList.next();
      if ((localObject instanceof uks))
      {
        localObject = (ukv)localObject;
        srk localsrk = ((ukv)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localsrk != null) && (TextUtils.equals(paramString1, localsrk.getUnionId())) && (TextUtils.equals(paramString2, ((ukv)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          urk.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<ukt> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(ujt paramujt, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((sqs)sqg.a(2)).a() == null) {
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    label31:
    StoryVideoItem localStoryVideoItem;
    Object localObject;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)localIterator1.next();
        if (localStoryVideoItem.isLocalAddShareGroupVideo())
        {
          if (!a(localStoryVideoItem.shareGroupId))
          {
            urk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramujt.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = uje.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new uks(paramList);
                paramujt.jdField_b_of_type_JavaUtilList.add(0, paramList);
                urk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
              }
            }
            else
            {
              paramList.a(localStoryVideoItem, true);
            }
          }
        }
        else
        {
          localObject = skl.a(localStoryVideoItem.mVid);
          if (localObject != null)
          {
            paramList = localStoryVideoItem.mVideoSpreadGroupList;
            if ((paramList != null) && (paramList.jdField_b_of_type_JavaUtilList != null))
            {
              Iterator localIterator2 = paramList.jdField_b_of_type_JavaUtilList.iterator();
              label234:
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (!a(str))
                {
                  urk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramujt.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new uks(uje.a(str, localStoryVideoItem.mPublishDate));
                  paramujt.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  urk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
                }
              }
            }
          }
        }
      }
    }
    label532:
    label605:
    for (;;)
    {
      paramList.a(localStoryVideoItem, true);
      break label234;
      if ((((PublishVideoEntry)localObject).getBooleanExtra("ignorePersonalPublish", false)) || (!b())) {
        break label31;
      }
      paramList = a(localStoryVideoItem, paramujt.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((sqd)sqg.a(5)).a(localStoryVideoItem.mVid);
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramujt.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = uje.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new ujm(paramList);
        paramujt.jdField_b_of_type_JavaUtilList.add(0, paramList);
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        urk.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        urk.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramujt.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramujt.jdField_b_of_type_JavaUtilList, ujm.jdField_a_of_type_Ukx);
      if (!QLog.isDebugVersion()) {
        break;
      }
      urk.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramujt.jdField_b_of_type_JavaUtilList);
      return;
    }
  }
  
  public static boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      if (paramStoryVideoItem.mUploadStatus != 4) {
        break label92;
      }
      if (Math.abs(paramStoryVideoItem.mCreateTime - NetConnInfoCenter.getServerTimeMillis()) > 600000L)
      {
        paramStoryVideoItem.mUploadStatus = 6;
        paramStoryVideoItem.copy(((sqd)sqg.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (skz.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((sqd)sqg.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    urk.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = uac.a(((uac)sqg.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      urk.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      urk.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          urk.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    snl localsnl = new snl(0, paramCommentEntry.feedId, 1);
    localsnl.c = paramCommentEntry.commentId;
    localsnl.a = paramCommentLikeFeedItem;
    sgi.a().dispatch(localsnl);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localsnl, Integer.valueOf(localsnl.a.mCommentCount), Integer.valueOf(localsnl.a.mFanCommentCount), Integer.valueOf(localsnl.a.mFriendCommentCount));
  }
  
  private void b(ujt paramujt)
  {
    List localList;
    if ((paramujt.jdField_b_of_type_Boolean) || ((paramujt.c) && (paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((sqd)sqg.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramujt, localList);
  }
  
  private static void b(@NonNull ujx paramujx, @NonNull String paramString)
  {
    Object localObject2 = paramujx.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ukt)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof ukv)) {
          continue;
        }
        localObject1 = (ukv)localObject1;
        Iterator localIterator = ((ukv)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((ukv)localObject1).a(localStoryVideoItem);
        paramString = (ujk)sqg.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((ukv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((ukv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((ukv)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((ukv)localObject1).a().size() != 0) {
          break label346;
        }
        paramujx.jdField_a_of_type_JavaUtilArrayList.remove(i);
        uje.b(((VideoListFeedItem)((ukv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramujx.jdField_a_of_type_Ukg.b(((VideoListFeedItem)((ukv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramujx = (sqj)sqg.a(27);
          paramString = new ArrayList();
          paramString.add(((ukv)localObject1).a().feedId);
          paramujx.a(paramString);
          urk.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((ukv)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          urk.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((ukv)localObject1), 2000L);
        }
        return;
        label346:
        paramujx.jdField_a_of_type_Ukg.a((ukv)localObject1);
      }
    }
  }
  
  private static void b(ukv paramukv)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramukv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new syx((List)localObject, true);
    slv.a().a((slz)localObject, new ujz(paramukv));
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int != 11;
  }
  
  private static boolean b(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramCommentLikeFeedItem instanceof VideoListFeedItem))
    {
      paramCommentLikeFeedItem = (VideoListFeedItem)paramCommentLikeFeedItem;
      bool1 = bool2;
      if (paramCommentLikeFeedItem.getOwner().isMe())
      {
        bool1 = bool2;
        if (paramCommentLikeFeedItem.mHasPublicVideo) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c(ujt paramujt)
  {
    long l = 0L;
    if (!paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramujt.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (ukt)((Iterator)???).next();
      if (((localObject2 instanceof ukv)) && (((ukv)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramujt.c) {
        this.jdField_a_of_type_JavaUtilList = ((sqd)sqg.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramujt.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        try
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (uje.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
          {
            ((ArrayList)localObject2).add(localStoryVideoItem);
            localIterator.remove();
          }
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
        }
      }
      if (paramujt.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((ukt)paramujt.jdField_b_of_type_JavaUtilList.get(paramujt.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramujt, (List)localObject2);
  }
  
  private void d(ujt paramujt)
  {
    sqj localsqj = (sqj)sqg.a(27);
    paramujt = paramujt.jdField_b_of_type_JavaUtilList;
    if (paramujt != null)
    {
      paramujt = paramujt.iterator();
      while (paramujt.hasNext())
      {
        Object localObject = (ukt)paramujt.next();
        if ((localObject instanceof ukv))
        {
          localObject = (ukv)localObject;
          ((ukv)localObject).d = localsqj.a(((ukv)localObject).a().feedId, ((ukv)localObject).a());
          urk.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((ukv)localObject).a().feedId, Integer.valueOf(((ukv)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(ujt paramujt)
  {
    Object localObject = paramujt.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramujt = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ukt localukt = (ukt)((Iterator)localObject).next();
      if (((localukt instanceof ujm)) && (!((GeneralFeedItem)localukt.a()).mIsVideoEnd)) {
        paramujt.add(localukt.a().feedId);
      }
    }
    ((sqj)sqg.a(27)).a(paramujt);
  }
  
  public List<ukt> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ukt a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ukt localukt = (ukt)localIterator.next();
      if (localukt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localukt;
      }
    }
    return null;
  }
  
  public void a()
  {
    urk.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Uiy = new uju(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ukm = new ukm(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukm);
      this.jdField_a_of_type_Ukb = new ukb(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukb);
      this.jdField_a_of_type_Ukh = new ukh(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukh);
      this.jdField_a_of_type_Uke = new uke(this);
      sgi.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Uke);
      this.jdField_a_of_type_Ukd = new ukd(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukd);
      this.jdField_a_of_type_Ukc = new ukc(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukc);
      this.jdField_a_of_type_Ukn = new ukn(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukn);
      this.jdField_a_of_type_Uko = new uko(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Uko);
      this.jdField_a_of_type_Ukj = new ukj(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukj);
      this.jdField_a_of_type_Ukk = new ukk(this, this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukk);
      this.jdField_a_of_type_Ukl = new ukl(this, this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukl);
      this.jdField_a_of_type_Uki = new uki(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Uki);
      this.jdField_a_of_type_Ukf = new ukf(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Ukf);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Sgc);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Uiy = new vkr(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Uiy = new ufx(this);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = a(paramString);
    } while (!(localObject instanceof uio));
    Object localObject = (uio)localObject;
    if (((uio)localObject).a().mCommentIsEnd == 0)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new uiv(paramString, 1, ((CommentLikeFeedItem)((uio)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((uje)sqg.a(11)).a().a(localArrayList);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<ukt> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ukt localukt = (ukt)paramList.next();
      if (localHashSet.contains(localukt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localukt });
      }
      else
      {
        localHashSet.add(localukt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(ujt paramujt)
  {
    c(paramujt);
    d(paramujt);
    urk.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramujt.b() });
    e(paramujt);
    a(new ArrayList(paramujt.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramujt));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      uje localuje = (uje)sqg.a(11);
      uja localuja = localuje.jdField_a_of_type_Uja;
      ArrayList localArrayList = localuje.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localuja != null))
      {
        localObject = new ujt(new ErrorMessage());
        ((ujt)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localuje.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((ujt)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((ujt)localObject).jdField_b_of_type_Boolean = true;
        ((ujt)localObject).e = true;
        this.jdField_a_of_type_Uiy.a(localuja);
        urk.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((ujt)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((ujt)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((ujt)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        urk.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((ujt)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (ujt)this.jdField_a_of_type_Uiy.b();
        this.jdField_a_of_type_Boolean = ((ujt)localObject).jdField_a_of_type_Boolean;
        b((ujt)localObject);
        d((ujt)localObject);
      }
    }
    Object localObject = (srz)sqg.a(9);
    ((srz)localObject).a(new ujy(this, (srz)localObject));
    ((srz)localObject).a(1000);
    urk.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ukv paramukv)
  {
    FeedVideoInfo localFeedVideoInfo = paramukv.a().getVideoInfo();
    udh localudh = new udh(0, localFeedVideoInfo);
    localudh.b("HomeFeedPresenter");
    localudh.c();
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramukv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukm);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukb);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukh);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uke);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukd);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukc);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukn);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uko);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukj);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukk);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukl);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uki);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ukf);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Sgc);
    ((uje)sqg.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new ucy(paramString, false).a(true);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      uje localuje = (uje)sqg.a(11);
      localuje.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localuje.jdField_a_of_type_Uja = new uja(this.jdField_a_of_type_Uiy.a());
      localuje.jdField_a_of_type_Boolean = a();
      urk.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    uje localuje = (uje)sqg.a(11);
    localuje.b = new uja(this.jdField_a_of_type_Uiy.a());
    List localList = localuje.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ukt)localIterator.next();
      if ((localObject instanceof ukv))
      {
        ukv localukv = (ukv)localObject;
        int i = uiw.a(localList, ((ukt)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (uiw)localList.remove(i);
          ((uiw)localObject).b = localukv.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((ukt)localObject).a().feedId))
        {
          localArrayList.add(new uiw(((ukt)localObject).a().feedId, 0, ((ukt)localObject).a().getOwner().getUnionId(), ((ukt)localObject).a().date));
        }
        else
        {
          localArrayList.add(new uiw(((ukt)localObject).a().feedId, 0, ((ukt)localObject).a().getOwner().getUnionId(), ((ukt)localObject).a().date));
          urk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((ukt)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localuje.b.jdField_a_of_type_JavaUtilList = localArrayList;
    urk.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Uiy.c();
    urk.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujx
 * JD-Core Version:    0.7.0.1
 */