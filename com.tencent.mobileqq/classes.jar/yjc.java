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

public class yjc
  implements IEventReceiver, yih<yiy>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<yjy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final wfi jdField_a_of_type_Wfi = new yjf(this);
  private yid jdField_a_of_type_Yid;
  private yjg jdField_a_of_type_Yjg;
  private yjh jdField_a_of_type_Yjh;
  private yji jdField_a_of_type_Yji;
  private yjj jdField_a_of_type_Yjj;
  private yjk jdField_a_of_type_Yjk;
  private yjl jdField_a_of_type_Yjl;
  private yjm jdField_a_of_type_Yjm;
  private yjn jdField_a_of_type_Yjn;
  private yjo jdField_a_of_type_Yjo;
  private yjp jdField_a_of_type_Yjp;
  private yjq jdField_a_of_type_Yjq;
  private yjr jdField_a_of_type_Yjr;
  private yjs jdField_a_of_type_Yjs;
  private yjt jdField_a_of_type_Yjt;
  private boolean jdField_a_of_type_Boolean = true;
  
  public yjc(int paramInt, @NonNull yjl paramyjl, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Yjl = paramyjl;
    zkb.a(this.jdField_a_of_type_Yjl);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      zkb.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<yjy> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (yjy)paramList.next();
      if ((localObject instanceof yir))
      {
        localObject = (yir)localObject;
        if (((GeneralFeedItem)((yir)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((yir)localObject).a());
        }
      }
    }
    return null;
  }
  
  private yir a(List<yjy> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (yjy)paramList.next();
      if ((localObject instanceof yir))
      {
        localObject = (yir)localObject;
        if ((((GeneralFeedItem)((yir)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((yir)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private yka a(List<yjy> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (yjy)paramList.next();
      if ((localObject instanceof yjx))
      {
        localObject = (yka)localObject;
        wqq localwqq = ((yka)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localwqq != null) && (TextUtils.equals(paramString1, localwqq.getUnionId())) && (TextUtils.equals(paramString2, ((yka)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<yjy> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(yiy paramyiy, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((wpy)wpm.a(2)).a() == null) {
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
            yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramyiy.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = yij.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new yjx(paramList);
                paramyiy.jdField_b_of_type_JavaUtilList.add(0, paramList);
                yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = wjr.a(localStoryVideoItem.mVid);
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
                  yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramyiy.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new yjx(yij.a(str, localStoryVideoItem.mPublishDate));
                  paramyiy.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramyiy.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((wpj)wpm.a(5)).a(localStoryVideoItem.mVid);
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramyiy.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = yij.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new yir(paramList);
        paramyiy.jdField_b_of_type_JavaUtilList.add(0, paramList);
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        yqp.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramyiy.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramyiy.jdField_b_of_type_JavaUtilList, yir.jdField_a_of_type_Ykc);
      if (!QLog.isDebugVersion()) {
        break;
      }
      yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramyiy.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((wpj)wpm.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (wkf.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((wpj)wpm.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = xzh.a(((xzh)wpm.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    wmr localwmr = new wmr(0, paramCommentEntry.feedId, 1);
    localwmr.c = paramCommentEntry.commentId;
    localwmr.a = paramCommentLikeFeedItem;
    wfo.a().dispatch(localwmr);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localwmr, Integer.valueOf(localwmr.a.mCommentCount), Integer.valueOf(localwmr.a.mFanCommentCount), Integer.valueOf(localwmr.a.mFriendCommentCount));
  }
  
  private void b(yiy paramyiy)
  {
    List localList;
    if ((paramyiy.jdField_b_of_type_Boolean) || ((paramyiy.c) && (paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((wpj)wpm.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramyiy, localList);
  }
  
  private static void b(@NonNull yjc paramyjc, @NonNull String paramString)
  {
    Object localObject2 = paramyjc.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (yjy)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof yka)) {
          continue;
        }
        localObject1 = (yka)localObject1;
        Iterator localIterator = ((yka)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((yka)localObject1).a(localStoryVideoItem);
        paramString = (yip)wpm.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((yka)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((yka)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((yka)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((yka)localObject1).a().size() != 0) {
          break label346;
        }
        paramyjc.jdField_a_of_type_JavaUtilArrayList.remove(i);
        yij.b(((VideoListFeedItem)((yka)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramyjc.jdField_a_of_type_Yjl.b(((VideoListFeedItem)((yka)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramyjc = (wpp)wpm.a(27);
          paramString = new ArrayList();
          paramString.add(((yka)localObject1).a().feedId);
          paramyjc.a(paramString);
          yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((yka)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((yka)localObject1), 2000L);
        }
        return;
        label346:
        paramyjc.jdField_a_of_type_Yjl.a((yka)localObject1);
      }
    }
  }
  
  private static void b(yka paramyka)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramyka.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new wyd((List)localObject, true);
    wlb.a().a((wlf)localObject, new yje(paramyka));
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
  
  private void c(yiy paramyiy)
  {
    long l = 0L;
    if (!paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramyiy.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (yjy)((Iterator)???).next();
      if (((localObject2 instanceof yka)) && (((yka)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramyiy.c) {
        this.jdField_a_of_type_JavaUtilList = ((wpj)wpm.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramyiy.jdField_a_of_type_Boolean) {}
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
          if (yij.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramyiy.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((yjy)paramyiy.jdField_b_of_type_JavaUtilList.get(paramyiy.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramyiy, (List)localObject2);
  }
  
  private void d(yiy paramyiy)
  {
    wpp localwpp = (wpp)wpm.a(27);
    paramyiy = paramyiy.jdField_b_of_type_JavaUtilList;
    if (paramyiy != null)
    {
      paramyiy = paramyiy.iterator();
      while (paramyiy.hasNext())
      {
        Object localObject = (yjy)paramyiy.next();
        if ((localObject instanceof yka))
        {
          localObject = (yka)localObject;
          ((yka)localObject).d = localwpp.a(((yka)localObject).a().feedId, ((yka)localObject).a());
          yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((yka)localObject).a().feedId, Integer.valueOf(((yka)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(yiy paramyiy)
  {
    Object localObject = paramyiy.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramyiy = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      yjy localyjy = (yjy)((Iterator)localObject).next();
      if (((localyjy instanceof yir)) && (!((GeneralFeedItem)localyjy.a()).mIsVideoEnd)) {
        paramyiy.add(localyjy.a().feedId);
      }
    }
    ((wpp)wpm.a(27)).a(paramyiy);
  }
  
  public List<yjy> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public yjy a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      yjy localyjy = (yjy)localIterator.next();
      if (localyjy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localyjy;
      }
    }
    return null;
  }
  
  public void a()
  {
    yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Yid = new yiz(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yjr = new yjr(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjr);
      this.jdField_a_of_type_Yjg = new yjg(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjg);
      this.jdField_a_of_type_Yjm = new yjm(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjm);
      this.jdField_a_of_type_Yjj = new yjj(this);
      wfo.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Yjj);
      this.jdField_a_of_type_Yji = new yji(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yji);
      this.jdField_a_of_type_Yjh = new yjh(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjh);
      this.jdField_a_of_type_Yjs = new yjs(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjs);
      this.jdField_a_of_type_Yjt = new yjt(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjt);
      this.jdField_a_of_type_Yjo = new yjo(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjo);
      this.jdField_a_of_type_Yjp = new yjp(this, this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjp);
      this.jdField_a_of_type_Yjq = new yjq(this, this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjq);
      this.jdField_a_of_type_Yjn = new yjn(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjn);
      this.jdField_a_of_type_Yjk = new yjk(this);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Yjk);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Wfi);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Yid = new zjw(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Yid = new yfc(this);
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
    } while (!(localObject instanceof yht));
    Object localObject = (yht)localObject;
    if (((yht)localObject).a().mCommentIsEnd == 0)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new yia(paramString, 1, ((CommentLikeFeedItem)((yht)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((yij)wpm.a(11)).a().a(localArrayList);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<yjy> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      yjy localyjy = (yjy)paramList.next();
      if (localHashSet.contains(localyjy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localyjy });
      }
      else
      {
        localHashSet.add(localyjy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(yiy paramyiy)
  {
    c(paramyiy);
    d(paramyiy);
    yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramyiy.b() });
    e(paramyiy);
    a(new ArrayList(paramyiy.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramyiy));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      yij localyij = (yij)wpm.a(11);
      yif localyif = localyij.jdField_a_of_type_Yif;
      ArrayList localArrayList = localyij.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localyif != null))
      {
        localObject = new yiy(new ErrorMessage());
        ((yiy)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localyij.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((yiy)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((yiy)localObject).jdField_b_of_type_Boolean = true;
        ((yiy)localObject).e = true;
        this.jdField_a_of_type_Yid.a(localyif);
        yqp.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((yiy)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((yiy)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((yiy)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((yiy)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (yiy)this.jdField_a_of_type_Yid.b();
        this.jdField_a_of_type_Boolean = ((yiy)localObject).jdField_a_of_type_Boolean;
        b((yiy)localObject);
        d((yiy)localObject);
      }
    }
    Object localObject = (wrf)wpm.a(9);
    ((wrf)localObject).a(new yjd(this, (wrf)localObject));
    ((wrf)localObject).a(1000);
    yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(yka paramyka)
  {
    FeedVideoInfo localFeedVideoInfo = paramyka.a().getVideoInfo();
    ycm localycm = new ycm(0, localFeedVideoInfo);
    localycm.b("HomeFeedPresenter");
    localycm.c();
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramyka.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjr);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjg);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjm);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjj);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yji);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjh);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjs);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjt);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjo);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjp);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjq);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjn);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yjk);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wfi);
    ((yij)wpm.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new ycd(paramString, false).a(true);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      yij localyij = (yij)wpm.a(11);
      localyij.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localyij.jdField_a_of_type_Yif = new yif(this.jdField_a_of_type_Yid.a());
      localyij.jdField_a_of_type_Boolean = a();
      yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    yij localyij = (yij)wpm.a(11);
    localyij.b = new yif(this.jdField_a_of_type_Yid.a());
    List localList = localyij.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (yjy)localIterator.next();
      if ((localObject instanceof yka))
      {
        yka localyka = (yka)localObject;
        int i = yib.a(localList, ((yjy)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (yib)localList.remove(i);
          ((yib)localObject).b = localyka.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((yjy)localObject).a().feedId))
        {
          localArrayList.add(new yib(((yjy)localObject).a().feedId, 0, ((yjy)localObject).a().getOwner().getUnionId(), ((yjy)localObject).a().date));
        }
        else
        {
          localArrayList.add(new yib(((yjy)localObject).a().feedId, 0, ((yjy)localObject).a().getOwner().getUnionId(), ((yjy)localObject).a().date));
          yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((yjy)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localyij.b.jdField_a_of_type_JavaUtilList = localArrayList;
    yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Yid.c();
    yqp.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjc
 * JD-Core Version:    0.7.0.1
 */