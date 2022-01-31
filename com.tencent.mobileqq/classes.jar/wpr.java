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

public class wpr
  implements IEventReceiver, wow<wpn>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<wqn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final ulw jdField_a_of_type_Ulw = new wpu(this);
  private wos jdField_a_of_type_Wos;
  private wpv jdField_a_of_type_Wpv;
  private wpw jdField_a_of_type_Wpw;
  private wpx jdField_a_of_type_Wpx;
  private wpy jdField_a_of_type_Wpy;
  private wpz jdField_a_of_type_Wpz;
  private wqa jdField_a_of_type_Wqa;
  private wqb jdField_a_of_type_Wqb;
  private wqc jdField_a_of_type_Wqc;
  private wqd jdField_a_of_type_Wqd;
  private wqe jdField_a_of_type_Wqe;
  private wqf jdField_a_of_type_Wqf;
  private wqg jdField_a_of_type_Wqg;
  private wqh jdField_a_of_type_Wqh;
  private wqi jdField_a_of_type_Wqi;
  private boolean jdField_a_of_type_Boolean = true;
  
  public wpr(int paramInt, @NonNull wqa paramwqa, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wqa = paramwqa;
    xqq.a(this.jdField_a_of_type_Wqa);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      xqq.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<wqn> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wqn)paramList.next();
      if ((localObject instanceof wpg))
      {
        localObject = (wpg)localObject;
        if (((GeneralFeedItem)((wpg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((wpg)localObject).a());
        }
      }
    }
    return null;
  }
  
  private wpg a(List<wqn> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wqn)paramList.next();
      if ((localObject instanceof wpg))
      {
        localObject = (wpg)localObject;
        if ((((GeneralFeedItem)((wpg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((wpg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private wqp a(List<wqn> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wqn)paramList.next();
      if ((localObject instanceof wqm))
      {
        localObject = (wqp)localObject;
        uxe localuxe = ((wqp)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localuxe != null) && (TextUtils.equals(paramString1, localuxe.getUnionId())) && (TextUtils.equals(paramString2, ((wqp)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<wqn> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(wpn paramwpn, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((uwm)uwa.a(2)).a() == null) {
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
            wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramwpn.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = woy.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new wqm(paramList);
                paramwpn.jdField_b_of_type_JavaUtilList.add(0, paramList);
                wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = uqf.a(localStoryVideoItem.mVid);
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
                  wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramwpn.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new wqm(woy.a(str, localStoryVideoItem.mPublishDate));
                  paramwpn.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramwpn.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((uvx)uwa.a(5)).a(localStoryVideoItem.mVid);
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramwpn.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = woy.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new wpg(paramList);
        paramwpn.jdField_b_of_type_JavaUtilList.add(0, paramList);
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        wxe.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramwpn.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramwpn.jdField_b_of_type_JavaUtilList, wpg.jdField_a_of_type_Wqr);
      if (!QLog.isDebugVersion()) {
        break;
      }
      wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramwpn.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((uvx)uwa.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (uqt.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((uvx)uwa.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = wfw.a(((wfw)uwa.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    utf localutf = new utf(0, paramCommentEntry.feedId, 1);
    localutf.c = paramCommentEntry.commentId;
    localutf.a = paramCommentLikeFeedItem;
    umc.a().dispatch(localutf);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localutf, Integer.valueOf(localutf.a.mCommentCount), Integer.valueOf(localutf.a.mFanCommentCount), Integer.valueOf(localutf.a.mFriendCommentCount));
  }
  
  private void b(wpn paramwpn)
  {
    List localList;
    if ((paramwpn.jdField_b_of_type_Boolean) || ((paramwpn.c) && (paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((uvx)uwa.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramwpn, localList);
  }
  
  private static void b(@NonNull wpr paramwpr, @NonNull String paramString)
  {
    Object localObject2 = paramwpr.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (wqn)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof wqp)) {
          continue;
        }
        localObject1 = (wqp)localObject1;
        Iterator localIterator = ((wqp)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((wqp)localObject1).a(localStoryVideoItem);
        paramString = (wpe)uwa.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((wqp)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((wqp)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((wqp)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((wqp)localObject1).a().size() != 0) {
          break label346;
        }
        paramwpr.jdField_a_of_type_JavaUtilArrayList.remove(i);
        woy.b(((VideoListFeedItem)((wqp)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramwpr.jdField_a_of_type_Wqa.b(((VideoListFeedItem)((wqp)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramwpr = (uwd)uwa.a(27);
          paramString = new ArrayList();
          paramString.add(((wqp)localObject1).a().feedId);
          paramwpr.a(paramString);
          wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((wqp)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((wqp)localObject1), 2000L);
        }
        return;
        label346:
        paramwpr.jdField_a_of_type_Wqa.a((wqp)localObject1);
      }
    }
  }
  
  private static void b(wqp paramwqp)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramwqp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new ver((List)localObject, true);
    urp.a().a((urt)localObject, new wpt(paramwqp));
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
  
  private void c(wpn paramwpn)
  {
    long l = 0L;
    if (!paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramwpn.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (wqn)((Iterator)???).next();
      if (((localObject2 instanceof wqp)) && (((wqp)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramwpn.c) {
        this.jdField_a_of_type_JavaUtilList = ((uvx)uwa.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramwpn.jdField_a_of_type_Boolean) {}
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
          if (woy.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramwpn.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((wqn)paramwpn.jdField_b_of_type_JavaUtilList.get(paramwpn.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramwpn, (List)localObject2);
  }
  
  private void d(wpn paramwpn)
  {
    uwd localuwd = (uwd)uwa.a(27);
    paramwpn = paramwpn.jdField_b_of_type_JavaUtilList;
    if (paramwpn != null)
    {
      paramwpn = paramwpn.iterator();
      while (paramwpn.hasNext())
      {
        Object localObject = (wqn)paramwpn.next();
        if ((localObject instanceof wqp))
        {
          localObject = (wqp)localObject;
          ((wqp)localObject).d = localuwd.a(((wqp)localObject).a().feedId, ((wqp)localObject).a());
          wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((wqp)localObject).a().feedId, Integer.valueOf(((wqp)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(wpn paramwpn)
  {
    Object localObject = paramwpn.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramwpn = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wqn localwqn = (wqn)((Iterator)localObject).next();
      if (((localwqn instanceof wpg)) && (!((GeneralFeedItem)localwqn.a()).mIsVideoEnd)) {
        paramwpn.add(localwqn.a().feedId);
      }
    }
    ((uwd)uwa.a(27)).a(paramwpn);
  }
  
  public List<wqn> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public wqn a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wqn localwqn = (wqn)localIterator.next();
      if (localwqn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localwqn;
      }
    }
    return null;
  }
  
  public void a()
  {
    wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Wos = new wpo(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Wqg = new wqg(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqg);
      this.jdField_a_of_type_Wpv = new wpv(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wpv);
      this.jdField_a_of_type_Wqb = new wqb(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqb);
      this.jdField_a_of_type_Wpy = new wpy(this);
      umc.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Wpy);
      this.jdField_a_of_type_Wpx = new wpx(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wpx);
      this.jdField_a_of_type_Wpw = new wpw(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wpw);
      this.jdField_a_of_type_Wqh = new wqh(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqh);
      this.jdField_a_of_type_Wqi = new wqi(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqi);
      this.jdField_a_of_type_Wqd = new wqd(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqd);
      this.jdField_a_of_type_Wqe = new wqe(this, this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqe);
      this.jdField_a_of_type_Wqf = new wqf(this, this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqf);
      this.jdField_a_of_type_Wqc = new wqc(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wqc);
      this.jdField_a_of_type_Wpz = new wpz(this);
      umc.a().registerSubscriber(this.jdField_a_of_type_Wpz);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ulw);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Wos = new xql(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Wos = new wlr(this);
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
    } while (!(localObject instanceof woi));
    Object localObject = (woi)localObject;
    if (((woi)localObject).a().mCommentIsEnd == 0)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new wop(paramString, 1, ((CommentLikeFeedItem)((woi)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((woy)uwa.a(11)).a().a(localArrayList);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<wqn> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wqn localwqn = (wqn)paramList.next();
      if (localHashSet.contains(localwqn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localwqn });
      }
      else
      {
        localHashSet.add(localwqn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(wpn paramwpn)
  {
    c(paramwpn);
    d(paramwpn);
    wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramwpn.b() });
    e(paramwpn);
    a(new ArrayList(paramwpn.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramwpn));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      woy localwoy = (woy)uwa.a(11);
      wou localwou = localwoy.jdField_a_of_type_Wou;
      ArrayList localArrayList = localwoy.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localwou != null))
      {
        localObject = new wpn(new ErrorMessage());
        ((wpn)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localwoy.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((wpn)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((wpn)localObject).jdField_b_of_type_Boolean = true;
        ((wpn)localObject).e = true;
        this.jdField_a_of_type_Wos.a(localwou);
        wxe.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((wpn)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((wpn)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((wpn)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((wpn)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (wpn)this.jdField_a_of_type_Wos.b();
        this.jdField_a_of_type_Boolean = ((wpn)localObject).jdField_a_of_type_Boolean;
        b((wpn)localObject);
        d((wpn)localObject);
      }
    }
    Object localObject = (uxt)uwa.a(9);
    ((uxt)localObject).a(new wps(this, (uxt)localObject));
    ((uxt)localObject).a(1000);
    wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(wqp paramwqp)
  {
    FeedVideoInfo localFeedVideoInfo = paramwqp.a().getVideoInfo();
    wjb localwjb = new wjb(0, localFeedVideoInfo);
    localwjb.b("HomeFeedPresenter");
    localwjb.c();
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramwqp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqg);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wpv);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqb);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wpy);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wpx);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wpw);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqh);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqi);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqd);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqe);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqf);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wqc);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wpz);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ulw);
    ((woy)uwa.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new wis(paramString, false).a(true);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      woy localwoy = (woy)uwa.a(11);
      localwoy.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localwoy.jdField_a_of_type_Wou = new wou(this.jdField_a_of_type_Wos.a());
      localwoy.jdField_a_of_type_Boolean = a();
      wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    woy localwoy = (woy)uwa.a(11);
    localwoy.b = new wou(this.jdField_a_of_type_Wos.a());
    List localList = localwoy.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (wqn)localIterator.next();
      if ((localObject instanceof wqp))
      {
        wqp localwqp = (wqp)localObject;
        int i = woq.a(localList, ((wqn)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (woq)localList.remove(i);
          ((woq)localObject).b = localwqp.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((wqn)localObject).a().feedId))
        {
          localArrayList.add(new woq(((wqn)localObject).a().feedId, 0, ((wqn)localObject).a().getOwner().getUnionId(), ((wqn)localObject).a().date));
        }
        else
        {
          localArrayList.add(new woq(((wqn)localObject).a().feedId, 0, ((wqn)localObject).a().getOwner().getUnionId(), ((wqn)localObject).a().date));
          wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((wqn)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localwoy.b.jdField_a_of_type_JavaUtilList = localArrayList;
    wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wos.c();
    wxe.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpr
 * JD-Core Version:    0.7.0.1
 */