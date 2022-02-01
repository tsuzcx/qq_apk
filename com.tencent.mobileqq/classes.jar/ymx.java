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

public class ymx
  implements IEventReceiver, ymc<ymt>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<ynt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final wjd jdField_a_of_type_Wjd = new yna(this);
  private yly jdField_a_of_type_Yly;
  private ynb jdField_a_of_type_Ynb;
  private ync jdField_a_of_type_Ync;
  private ynd jdField_a_of_type_Ynd;
  private yne jdField_a_of_type_Yne;
  private ynf jdField_a_of_type_Ynf;
  private yng jdField_a_of_type_Yng;
  private ynh jdField_a_of_type_Ynh;
  private yni jdField_a_of_type_Yni;
  private ynj jdField_a_of_type_Ynj;
  private ynk jdField_a_of_type_Ynk;
  private ynl jdField_a_of_type_Ynl;
  private ynm jdField_a_of_type_Ynm;
  private ynn jdField_a_of_type_Ynn;
  private yno jdField_a_of_type_Yno;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ymx(int paramInt, @NonNull yng paramyng, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Yng = paramyng;
    znw.a(this.jdField_a_of_type_Yng);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      znw.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<ynt> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ynt)paramList.next();
      if ((localObject instanceof ymm))
      {
        localObject = (ymm)localObject;
        if (((GeneralFeedItem)((ymm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((ymm)localObject).a());
        }
      }
    }
    return null;
  }
  
  private ymm a(List<ynt> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ynt)paramList.next();
      if ((localObject instanceof ymm))
      {
        localObject = (ymm)localObject;
        if ((((GeneralFeedItem)((ymm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((ymm)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private ynv a(List<ynt> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ynt)paramList.next();
      if ((localObject instanceof yns))
      {
        localObject = (ynv)localObject;
        wul localwul = ((ynv)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localwul != null) && (TextUtils.equals(paramString1, localwul.getUnionId())) && (TextUtils.equals(paramString2, ((ynv)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<ynt> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(ymt paramymt, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((wtt)wth.a(2)).a() == null) {
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
            yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramymt.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = yme.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new yns(paramList);
                paramymt.jdField_b_of_type_JavaUtilList.add(0, paramList);
                yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = wnm.a(localStoryVideoItem.mVid);
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
                  yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramymt.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new yns(yme.a(str, localStoryVideoItem.mPublishDate));
                  paramymt.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramymt.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((wte)wth.a(5)).a(localStoryVideoItem.mVid);
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramymt.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = yme.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new ymm(paramList);
        paramymt.jdField_b_of_type_JavaUtilList.add(0, paramList);
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        yuk.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramymt.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramymt.jdField_b_of_type_JavaUtilList, ymm.jdField_a_of_type_Ynx);
      if (!QLog.isDebugVersion()) {
        break;
      }
      yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramymt.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((wte)wth.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (woa.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((wte)wth.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = ydc.a(((ydc)wth.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    wqm localwqm = new wqm(0, paramCommentEntry.feedId, 1);
    localwqm.c = paramCommentEntry.commentId;
    localwqm.a = paramCommentLikeFeedItem;
    wjj.a().dispatch(localwqm);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localwqm, Integer.valueOf(localwqm.a.mCommentCount), Integer.valueOf(localwqm.a.mFanCommentCount), Integer.valueOf(localwqm.a.mFriendCommentCount));
  }
  
  private void b(ymt paramymt)
  {
    List localList;
    if ((paramymt.jdField_b_of_type_Boolean) || ((paramymt.c) && (paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((wte)wth.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramymt, localList);
  }
  
  private static void b(@NonNull ymx paramymx, @NonNull String paramString)
  {
    Object localObject2 = paramymx.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ynt)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof ynv)) {
          continue;
        }
        localObject1 = (ynv)localObject1;
        Iterator localIterator = ((ynv)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((ynv)localObject1).a(localStoryVideoItem);
        paramString = (ymk)wth.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((ynv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((ynv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((ynv)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((ynv)localObject1).a().size() != 0) {
          break label346;
        }
        paramymx.jdField_a_of_type_JavaUtilArrayList.remove(i);
        yme.b(((VideoListFeedItem)((ynv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramymx.jdField_a_of_type_Yng.b(((VideoListFeedItem)((ynv)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramymx = (wtk)wth.a(27);
          paramString = new ArrayList();
          paramString.add(((ynv)localObject1).a().feedId);
          paramymx.a(paramString);
          yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((ynv)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((ynv)localObject1), 2000L);
        }
        return;
        label346:
        paramymx.jdField_a_of_type_Yng.a((ynv)localObject1);
      }
    }
  }
  
  private static void b(ynv paramynv)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramynv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new xby((List)localObject, true);
    wow.a().a((wpa)localObject, new ymz(paramynv));
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
  
  private void c(ymt paramymt)
  {
    long l = 0L;
    if (!paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramymt.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (ynt)((Iterator)???).next();
      if (((localObject2 instanceof ynv)) && (((ynv)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramymt.c) {
        this.jdField_a_of_type_JavaUtilList = ((wte)wth.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramymt.jdField_a_of_type_Boolean) {}
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
          if (yme.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramymt.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((ynt)paramymt.jdField_b_of_type_JavaUtilList.get(paramymt.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramymt, (List)localObject2);
  }
  
  private void d(ymt paramymt)
  {
    wtk localwtk = (wtk)wth.a(27);
    paramymt = paramymt.jdField_b_of_type_JavaUtilList;
    if (paramymt != null)
    {
      paramymt = paramymt.iterator();
      while (paramymt.hasNext())
      {
        Object localObject = (ynt)paramymt.next();
        if ((localObject instanceof ynv))
        {
          localObject = (ynv)localObject;
          ((ynv)localObject).d = localwtk.a(((ynv)localObject).a().feedId, ((ynv)localObject).a());
          yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((ynv)localObject).a().feedId, Integer.valueOf(((ynv)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(ymt paramymt)
  {
    Object localObject = paramymt.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramymt = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ynt localynt = (ynt)((Iterator)localObject).next();
      if (((localynt instanceof ymm)) && (!((GeneralFeedItem)localynt.a()).mIsVideoEnd)) {
        paramymt.add(localynt.a().feedId);
      }
    }
    ((wtk)wth.a(27)).a(paramymt);
  }
  
  public List<ynt> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ynt a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ynt localynt = (ynt)localIterator.next();
      if (localynt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localynt;
      }
    }
    return null;
  }
  
  public void a()
  {
    yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Yly = new ymu(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ynm = new ynm(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynm);
      this.jdField_a_of_type_Ynb = new ynb(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynb);
      this.jdField_a_of_type_Ynh = new ynh(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynh);
      this.jdField_a_of_type_Yne = new yne(this);
      wjj.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Yne);
      this.jdField_a_of_type_Ynd = new ynd(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynd);
      this.jdField_a_of_type_Ync = new ync(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ync);
      this.jdField_a_of_type_Ynn = new ynn(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynn);
      this.jdField_a_of_type_Yno = new yno(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Yno);
      this.jdField_a_of_type_Ynj = new ynj(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynj);
      this.jdField_a_of_type_Ynk = new ynk(this, this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynk);
      this.jdField_a_of_type_Ynl = new ynl(this, this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynl);
      this.jdField_a_of_type_Yni = new yni(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Yni);
      this.jdField_a_of_type_Ynf = new ynf(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Ynf);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Wjd);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Yly = new znr(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Yly = new yix(this);
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
    } while (!(localObject instanceof ylo));
    Object localObject = (ylo)localObject;
    if (((ylo)localObject).a().mCommentIsEnd == 0)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ylv(paramString, 1, ((CommentLikeFeedItem)((ylo)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((yme)wth.a(11)).a().a(localArrayList);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<ynt> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ynt localynt = (ynt)paramList.next();
      if (localHashSet.contains(localynt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localynt });
      }
      else
      {
        localHashSet.add(localynt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(ymt paramymt)
  {
    c(paramymt);
    d(paramymt);
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramymt.b() });
    e(paramymt);
    a(new ArrayList(paramymt.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramymt));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      yme localyme = (yme)wth.a(11);
      yma localyma = localyme.jdField_a_of_type_Yma;
      ArrayList localArrayList = localyme.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localyma != null))
      {
        localObject = new ymt(new ErrorMessage());
        ((ymt)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localyme.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((ymt)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((ymt)localObject).jdField_b_of_type_Boolean = true;
        ((ymt)localObject).e = true;
        this.jdField_a_of_type_Yly.a(localyma);
        yuk.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((ymt)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((ymt)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((ymt)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((ymt)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (ymt)this.jdField_a_of_type_Yly.b();
        this.jdField_a_of_type_Boolean = ((ymt)localObject).jdField_a_of_type_Boolean;
        b((ymt)localObject);
        d((ymt)localObject);
      }
    }
    Object localObject = (wva)wth.a(9);
    ((wva)localObject).a(new ymy(this, (wva)localObject));
    ((wva)localObject).a(1000);
    yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ynv paramynv)
  {
    FeedVideoInfo localFeedVideoInfo = paramynv.a().getVideoInfo();
    ygh localygh = new ygh(0, localFeedVideoInfo);
    localygh.b("HomeFeedPresenter");
    localygh.c();
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramynv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynm);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynb);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynh);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yne);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynd);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ync);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynn);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yno);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynj);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynk);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynl);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yni);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ynf);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wjd);
    ((yme)wth.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new yfy(paramString, false).a(true);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      yme localyme = (yme)wth.a(11);
      localyme.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localyme.jdField_a_of_type_Yma = new yma(this.jdField_a_of_type_Yly.a());
      localyme.jdField_a_of_type_Boolean = a();
      yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    yme localyme = (yme)wth.a(11);
    localyme.b = new yma(this.jdField_a_of_type_Yly.a());
    List localList = localyme.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ynt)localIterator.next();
      if ((localObject instanceof ynv))
      {
        ynv localynv = (ynv)localObject;
        int i = ylw.a(localList, ((ynt)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (ylw)localList.remove(i);
          ((ylw)localObject).b = localynv.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((ynt)localObject).a().feedId))
        {
          localArrayList.add(new ylw(((ynt)localObject).a().feedId, 0, ((ynt)localObject).a().getOwner().getUnionId(), ((ynt)localObject).a().date));
        }
        else
        {
          localArrayList.add(new ylw(((ynt)localObject).a().feedId, 0, ((ynt)localObject).a().getOwner().getUnionId(), ((ynt)localObject).a().date));
          yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((ynt)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localyme.b.jdField_a_of_type_JavaUtilList = localArrayList;
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Yly.c();
    yuk.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymx
 * JD-Core Version:    0.7.0.1
 */