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

public class wli
  implements IEventReceiver, wkn<wle>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<wme> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final uhn jdField_a_of_type_Uhn = new wll(this);
  private wkj jdField_a_of_type_Wkj;
  private wlm jdField_a_of_type_Wlm;
  private wln jdField_a_of_type_Wln;
  private wlo jdField_a_of_type_Wlo;
  private wlp jdField_a_of_type_Wlp;
  private wlq jdField_a_of_type_Wlq;
  private wlr jdField_a_of_type_Wlr;
  private wls jdField_a_of_type_Wls;
  private wlt jdField_a_of_type_Wlt;
  private wlu jdField_a_of_type_Wlu;
  private wlv jdField_a_of_type_Wlv;
  private wlw jdField_a_of_type_Wlw;
  private wlx jdField_a_of_type_Wlx;
  private wly jdField_a_of_type_Wly;
  private wlz jdField_a_of_type_Wlz;
  private boolean jdField_a_of_type_Boolean = true;
  
  public wli(int paramInt, @NonNull wlr paramwlr, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wlr = paramwlr;
    xmh.a(this.jdField_a_of_type_Wlr);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      xmh.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<wme> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wme)paramList.next();
      if ((localObject instanceof wkx))
      {
        localObject = (wkx)localObject;
        if (((GeneralFeedItem)((wkx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((wkx)localObject).a());
        }
      }
    }
    return null;
  }
  
  private wkx a(List<wme> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wme)paramList.next();
      if ((localObject instanceof wkx))
      {
        localObject = (wkx)localObject;
        if ((((GeneralFeedItem)((wkx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((wkx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private wmg a(List<wme> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (wme)paramList.next();
      if ((localObject instanceof wmd))
      {
        localObject = (wmg)localObject;
        usv localusv = ((wmg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localusv != null) && (TextUtils.equals(paramString1, localusv.getUnionId())) && (TextUtils.equals(paramString2, ((wmg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<wme> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(wle paramwle, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((usd)urr.a(2)).a() == null) {
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
            wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramwle.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = wkp.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new wmd(paramList);
                paramwle.jdField_b_of_type_JavaUtilList.add(0, paramList);
                wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = ulw.a(localStoryVideoItem.mVid);
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
                  wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramwle.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new wmd(wkp.a(str, localStoryVideoItem.mPublishDate));
                  paramwle.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramwle.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((uro)urr.a(5)).a(localStoryVideoItem.mVid);
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramwle.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = wkp.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new wkx(paramList);
        paramwle.jdField_b_of_type_JavaUtilList.add(0, paramList);
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        wsv.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramwle.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramwle.jdField_b_of_type_JavaUtilList, wkx.jdField_a_of_type_Wmi);
      if (!QLog.isDebugVersion()) {
        break;
      }
      wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramwle.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((uro)urr.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (umk.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((uro)urr.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = wbn.a(((wbn)urr.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    uow localuow = new uow(0, paramCommentEntry.feedId, 1);
    localuow.c = paramCommentEntry.commentId;
    localuow.a = paramCommentLikeFeedItem;
    uht.a().dispatch(localuow);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localuow, Integer.valueOf(localuow.a.mCommentCount), Integer.valueOf(localuow.a.mFanCommentCount), Integer.valueOf(localuow.a.mFriendCommentCount));
  }
  
  private void b(wle paramwle)
  {
    List localList;
    if ((paramwle.jdField_b_of_type_Boolean) || ((paramwle.c) && (paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((uro)urr.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramwle, localList);
  }
  
  private static void b(@NonNull wli paramwli, @NonNull String paramString)
  {
    Object localObject2 = paramwli.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (wme)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof wmg)) {
          continue;
        }
        localObject1 = (wmg)localObject1;
        Iterator localIterator = ((wmg)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((wmg)localObject1).a(localStoryVideoItem);
        paramString = (wkv)urr.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((wmg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((wmg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((wmg)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((wmg)localObject1).a().size() != 0) {
          break label346;
        }
        paramwli.jdField_a_of_type_JavaUtilArrayList.remove(i);
        wkp.b(((VideoListFeedItem)((wmg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramwli.jdField_a_of_type_Wlr.b(((VideoListFeedItem)((wmg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramwli = (uru)urr.a(27);
          paramString = new ArrayList();
          paramString.add(((wmg)localObject1).a().feedId);
          paramwli.a(paramString);
          wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((wmg)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((wmg)localObject1), 2000L);
        }
        return;
        label346:
        paramwli.jdField_a_of_type_Wlr.a((wmg)localObject1);
      }
    }
  }
  
  private static void b(wmg paramwmg)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramwmg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new vai((List)localObject, true);
    ung.a().a((unk)localObject, new wlk(paramwmg));
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
  
  private void c(wle paramwle)
  {
    long l = 0L;
    if (!paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramwle.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (wme)((Iterator)???).next();
      if (((localObject2 instanceof wmg)) && (((wmg)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramwle.c) {
        this.jdField_a_of_type_JavaUtilList = ((uro)urr.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramwle.jdField_a_of_type_Boolean) {}
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
          if (wkp.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramwle.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((wme)paramwle.jdField_b_of_type_JavaUtilList.get(paramwle.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramwle, (List)localObject2);
  }
  
  private void d(wle paramwle)
  {
    uru localuru = (uru)urr.a(27);
    paramwle = paramwle.jdField_b_of_type_JavaUtilList;
    if (paramwle != null)
    {
      paramwle = paramwle.iterator();
      while (paramwle.hasNext())
      {
        Object localObject = (wme)paramwle.next();
        if ((localObject instanceof wmg))
        {
          localObject = (wmg)localObject;
          ((wmg)localObject).d = localuru.a(((wmg)localObject).a().feedId, ((wmg)localObject).a());
          wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((wmg)localObject).a().feedId, Integer.valueOf(((wmg)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(wle paramwle)
  {
    Object localObject = paramwle.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramwle = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      wme localwme = (wme)((Iterator)localObject).next();
      if (((localwme instanceof wkx)) && (!((GeneralFeedItem)localwme.a()).mIsVideoEnd)) {
        paramwle.add(localwme.a().feedId);
      }
    }
    ((uru)urr.a(27)).a(paramwle);
  }
  
  public List<wme> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public wme a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      wme localwme = (wme)localIterator.next();
      if (localwme.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localwme;
      }
    }
    return null;
  }
  
  public void a()
  {
    wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Wkj = new wlf(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Wlx = new wlx(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlx);
      this.jdField_a_of_type_Wlm = new wlm(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlm);
      this.jdField_a_of_type_Wls = new wls(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wls);
      this.jdField_a_of_type_Wlp = new wlp(this);
      uht.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Wlp);
      this.jdField_a_of_type_Wlo = new wlo(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlo);
      this.jdField_a_of_type_Wln = new wln(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wln);
      this.jdField_a_of_type_Wly = new wly(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wly);
      this.jdField_a_of_type_Wlz = new wlz(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlz);
      this.jdField_a_of_type_Wlu = new wlu(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlu);
      this.jdField_a_of_type_Wlv = new wlv(this, this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlv);
      this.jdField_a_of_type_Wlw = new wlw(this, this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlw);
      this.jdField_a_of_type_Wlt = new wlt(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlt);
      this.jdField_a_of_type_Wlq = new wlq(this);
      uht.a().registerSubscriber(this.jdField_a_of_type_Wlq);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Uhn);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Wkj = new xmc(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Wkj = new whi(this);
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
    } while (!(localObject instanceof wjz));
    Object localObject = (wjz)localObject;
    if (((wjz)localObject).a().mCommentIsEnd == 0)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new wkg(paramString, 1, ((CommentLikeFeedItem)((wjz)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((wkp)urr.a(11)).a().a(localArrayList);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<wme> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wme localwme = (wme)paramList.next();
      if (localHashSet.contains(localwme.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localwme });
      }
      else
      {
        localHashSet.add(localwme.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(wle paramwle)
  {
    c(paramwle);
    d(paramwle);
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramwle.b() });
    e(paramwle);
    a(new ArrayList(paramwle.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramwle));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      wkp localwkp = (wkp)urr.a(11);
      wkl localwkl = localwkp.jdField_a_of_type_Wkl;
      ArrayList localArrayList = localwkp.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localwkl != null))
      {
        localObject = new wle(new ErrorMessage());
        ((wle)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localwkp.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((wle)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((wle)localObject).jdField_b_of_type_Boolean = true;
        ((wle)localObject).e = true;
        this.jdField_a_of_type_Wkj.a(localwkl);
        wsv.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((wle)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((wle)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((wle)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((wle)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (wle)this.jdField_a_of_type_Wkj.b();
        this.jdField_a_of_type_Boolean = ((wle)localObject).jdField_a_of_type_Boolean;
        b((wle)localObject);
        d((wle)localObject);
      }
    }
    Object localObject = (utk)urr.a(9);
    ((utk)localObject).a(new wlj(this, (utk)localObject));
    ((utk)localObject).a(1000);
    wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(wmg paramwmg)
  {
    FeedVideoInfo localFeedVideoInfo = paramwmg.a().getVideoInfo();
    wes localwes = new wes(0, localFeedVideoInfo);
    localwes.b("HomeFeedPresenter");
    localwes.c();
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramwmg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlx);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlm);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wls);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlp);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlo);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wln);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wly);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlz);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlu);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlv);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlw);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlt);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wlq);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Uhn);
    ((wkp)urr.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new wej(paramString, false).a(true);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      wkp localwkp = (wkp)urr.a(11);
      localwkp.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localwkp.jdField_a_of_type_Wkl = new wkl(this.jdField_a_of_type_Wkj.a());
      localwkp.jdField_a_of_type_Boolean = a();
      wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    wkp localwkp = (wkp)urr.a(11);
    localwkp.b = new wkl(this.jdField_a_of_type_Wkj.a());
    List localList = localwkp.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (wme)localIterator.next();
      if ((localObject instanceof wmg))
      {
        wmg localwmg = (wmg)localObject;
        int i = wkh.a(localList, ((wme)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (wkh)localList.remove(i);
          ((wkh)localObject).b = localwmg.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((wme)localObject).a().feedId))
        {
          localArrayList.add(new wkh(((wme)localObject).a().feedId, 0, ((wme)localObject).a().getOwner().getUnionId(), ((wme)localObject).a().date));
        }
        else
        {
          localArrayList.add(new wkh(((wme)localObject).a().feedId, 0, ((wme)localObject).a().getOwner().getUnionId(), ((wme)localObject).a().date));
          wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((wme)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localwkp.b.jdField_a_of_type_JavaUtilList = localArrayList;
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wkj.c();
    wsv.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wli
 * JD-Core Version:    0.7.0.1
 */