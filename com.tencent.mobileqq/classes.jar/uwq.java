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

public class uwq
  implements IEventReceiver, uvv<uwm>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<uxm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final ssv jdField_a_of_type_Ssv = new uwt(this);
  private uvr jdField_a_of_type_Uvr;
  private uwu jdField_a_of_type_Uwu;
  private uwv jdField_a_of_type_Uwv;
  private uww jdField_a_of_type_Uww;
  private uwx jdField_a_of_type_Uwx;
  private uwy jdField_a_of_type_Uwy;
  private uwz jdField_a_of_type_Uwz;
  private uxa jdField_a_of_type_Uxa;
  private uxb jdField_a_of_type_Uxb;
  private uxc jdField_a_of_type_Uxc;
  private uxd jdField_a_of_type_Uxd;
  private uxe jdField_a_of_type_Uxe;
  private uxf jdField_a_of_type_Uxf;
  private uxg jdField_a_of_type_Uxg;
  private uxh jdField_a_of_type_Uxh;
  private boolean jdField_a_of_type_Boolean = true;
  
  public uwq(int paramInt, @NonNull uwz paramuwz, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Uwz = paramuwz;
    vxp.a(this.jdField_a_of_type_Uwz);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      vxp.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<uxm> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxm)paramList.next();
      if ((localObject instanceof uwf))
      {
        localObject = (uwf)localObject;
        if (((GeneralFeedItem)((uwf)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((uwf)localObject).a());
        }
      }
    }
    return null;
  }
  
  private uwf a(List<uxm> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxm)paramList.next();
      if ((localObject instanceof uwf))
      {
        localObject = (uwf)localObject;
        if ((((GeneralFeedItem)((uwf)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((uwf)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          ved.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private uxo a(List<uxm> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxm)paramList.next();
      if ((localObject instanceof uxl))
      {
        localObject = (uxo)localObject;
        ted localted = ((uxo)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localted != null) && (TextUtils.equals(paramString1, localted.getUnionId())) && (TextUtils.equals(paramString2, ((uxo)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          ved.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<uxm> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(uwm paramuwm, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((tdl)tcz.a(2)).a() == null) {
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
            ved.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramuwm.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = uvx.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new uxl(paramList);
                paramuwm.jdField_b_of_type_JavaUtilList.add(0, paramList);
                ved.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = sxe.a(localStoryVideoItem.mVid);
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
                  ved.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramuwm.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new uxl(uvx.a(str, localStoryVideoItem.mPublishDate));
                  paramuwm.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  ved.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramuwm.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((tcw)tcz.a(5)).a(localStoryVideoItem.mVid);
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramuwm.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = uvx.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new uwf(paramList);
        paramuwm.jdField_b_of_type_JavaUtilList.add(0, paramList);
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        ved.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        ved.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramuwm.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramuwm.jdField_b_of_type_JavaUtilList, uwf.jdField_a_of_type_Uxq);
      if (!QLog.isDebugVersion()) {
        break;
      }
      ved.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramuwm.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((tcw)tcz.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (sxs.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((tcw)tcz.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = umv.a(((umv)tcz.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      ved.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      ved.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          ved.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    tae localtae = new tae(0, paramCommentEntry.feedId, 1);
    localtae.c = paramCommentEntry.commentId;
    localtae.a = paramCommentLikeFeedItem;
    stb.a().dispatch(localtae);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localtae, Integer.valueOf(localtae.a.mCommentCount), Integer.valueOf(localtae.a.mFanCommentCount), Integer.valueOf(localtae.a.mFriendCommentCount));
  }
  
  private void b(uwm paramuwm)
  {
    List localList;
    if ((paramuwm.jdField_b_of_type_Boolean) || ((paramuwm.c) && (paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((tcw)tcz.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramuwm, localList);
  }
  
  private static void b(@NonNull uwq paramuwq, @NonNull String paramString)
  {
    Object localObject2 = paramuwq.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (uxm)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof uxo)) {
          continue;
        }
        localObject1 = (uxo)localObject1;
        Iterator localIterator = ((uxo)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((uxo)localObject1).a(localStoryVideoItem);
        paramString = (uwd)tcz.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((uxo)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((uxo)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((uxo)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((uxo)localObject1).a().size() != 0) {
          break label346;
        }
        paramuwq.jdField_a_of_type_JavaUtilArrayList.remove(i);
        uvx.b(((VideoListFeedItem)((uxo)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramuwq.jdField_a_of_type_Uwz.b(((VideoListFeedItem)((uxo)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramuwq = (tdc)tcz.a(27);
          paramString = new ArrayList();
          paramString.add(((uxo)localObject1).a().feedId);
          paramuwq.a(paramString);
          ved.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((uxo)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          ved.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((uxo)localObject1), 2000L);
        }
        return;
        label346:
        paramuwq.jdField_a_of_type_Uwz.a((uxo)localObject1);
      }
    }
  }
  
  private static void b(uxo paramuxo)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramuxo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new tlq((List)localObject, true);
    syo.a().a((sys)localObject, new uws(paramuxo));
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
  
  private void c(uwm paramuwm)
  {
    long l = 0L;
    if (!paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramuwm.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (uxm)((Iterator)???).next();
      if (((localObject2 instanceof uxo)) && (((uxo)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramuwm.c) {
        this.jdField_a_of_type_JavaUtilList = ((tcw)tcz.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramuwm.jdField_a_of_type_Boolean) {}
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
          if (uvx.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramuwm.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((uxm)paramuwm.jdField_b_of_type_JavaUtilList.get(paramuwm.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramuwm, (List)localObject2);
  }
  
  private void d(uwm paramuwm)
  {
    tdc localtdc = (tdc)tcz.a(27);
    paramuwm = paramuwm.jdField_b_of_type_JavaUtilList;
    if (paramuwm != null)
    {
      paramuwm = paramuwm.iterator();
      while (paramuwm.hasNext())
      {
        Object localObject = (uxm)paramuwm.next();
        if ((localObject instanceof uxo))
        {
          localObject = (uxo)localObject;
          ((uxo)localObject).d = localtdc.a(((uxo)localObject).a().feedId, ((uxo)localObject).a());
          ved.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((uxo)localObject).a().feedId, Integer.valueOf(((uxo)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(uwm paramuwm)
  {
    Object localObject = paramuwm.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramuwm = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uxm localuxm = (uxm)((Iterator)localObject).next();
      if (((localuxm instanceof uwf)) && (!((GeneralFeedItem)localuxm.a()).mIsVideoEnd)) {
        paramuwm.add(localuxm.a().feedId);
      }
    }
    ((tdc)tcz.a(27)).a(paramuwm);
  }
  
  public List<uxm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public uxm a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      uxm localuxm = (uxm)localIterator.next();
      if (localuxm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localuxm;
      }
    }
    return null;
  }
  
  public void a()
  {
    ved.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Uvr = new uwn(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uxf = new uxf(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxf);
      this.jdField_a_of_type_Uwu = new uwu(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uwu);
      this.jdField_a_of_type_Uxa = new uxa(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxa);
      this.jdField_a_of_type_Uwx = new uwx(this);
      stb.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Uwx);
      this.jdField_a_of_type_Uww = new uww(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uww);
      this.jdField_a_of_type_Uwv = new uwv(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uwv);
      this.jdField_a_of_type_Uxg = new uxg(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxg);
      this.jdField_a_of_type_Uxh = new uxh(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxh);
      this.jdField_a_of_type_Uxc = new uxc(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxc);
      this.jdField_a_of_type_Uxd = new uxd(this, this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxd);
      this.jdField_a_of_type_Uxe = new uxe(this, this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxe);
      this.jdField_a_of_type_Uxb = new uxb(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uxb);
      this.jdField_a_of_type_Uwy = new uwy(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Uwy);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ssv);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Uvr = new vxk(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Uvr = new usq(this);
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
    } while (!(localObject instanceof uvh));
    Object localObject = (uvh)localObject;
    if (((uvh)localObject).a().mCommentIsEnd == 0)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new uvo(paramString, 1, ((CommentLikeFeedItem)((uvh)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((uvx)tcz.a(11)).a().a(localArrayList);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<uxm> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uxm localuxm = (uxm)paramList.next();
      if (localHashSet.contains(localuxm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localuxm });
      }
      else
      {
        localHashSet.add(localuxm.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(uwm paramuwm)
  {
    c(paramuwm);
    d(paramuwm);
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramuwm.b() });
    e(paramuwm);
    a(new ArrayList(paramuwm.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramuwm));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      uvx localuvx = (uvx)tcz.a(11);
      uvt localuvt = localuvx.jdField_a_of_type_Uvt;
      ArrayList localArrayList = localuvx.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localuvt != null))
      {
        localObject = new uwm(new ErrorMessage());
        ((uwm)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localuvx.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((uwm)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((uwm)localObject).jdField_b_of_type_Boolean = true;
        ((uwm)localObject).e = true;
        this.jdField_a_of_type_Uvr.a(localuvt);
        ved.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((uwm)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((uwm)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((uwm)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        ved.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((uwm)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (uwm)this.jdField_a_of_type_Uvr.b();
        this.jdField_a_of_type_Boolean = ((uwm)localObject).jdField_a_of_type_Boolean;
        b((uwm)localObject);
        d((uwm)localObject);
      }
    }
    Object localObject = (tes)tcz.a(9);
    ((tes)localObject).a(new uwr(this, (tes)localObject));
    ((tes)localObject).a(1000);
    ved.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(uxo paramuxo)
  {
    FeedVideoInfo localFeedVideoInfo = paramuxo.a().getVideoInfo();
    uqa localuqa = new uqa(0, localFeedVideoInfo);
    localuqa.b("HomeFeedPresenter");
    localuqa.c();
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramuxo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxf);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwu);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxa);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwx);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uww);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwv);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxg);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxh);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxc);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxd);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxe);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uxb);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uwy);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ssv);
    ((uvx)tcz.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new upr(paramString, false).a(true);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      uvx localuvx = (uvx)tcz.a(11);
      localuvx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localuvx.jdField_a_of_type_Uvt = new uvt(this.jdField_a_of_type_Uvr.a());
      localuvx.jdField_a_of_type_Boolean = a();
      ved.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    uvx localuvx = (uvx)tcz.a(11);
    localuvx.b = new uvt(this.jdField_a_of_type_Uvr.a());
    List localList = localuvx.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (uxm)localIterator.next();
      if ((localObject instanceof uxo))
      {
        uxo localuxo = (uxo)localObject;
        int i = uvp.a(localList, ((uxm)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (uvp)localList.remove(i);
          ((uvp)localObject).b = localuxo.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((uxm)localObject).a().feedId))
        {
          localArrayList.add(new uvp(((uxm)localObject).a().feedId, 0, ((uxm)localObject).a().getOwner().getUnionId(), ((uxm)localObject).a().date));
        }
        else
        {
          localArrayList.add(new uvp(((uxm)localObject).a().feedId, 0, ((uxm)localObject).a().getOwner().getUnionId(), ((uxm)localObject).a().date));
          ved.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((uxm)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localuvx.b.jdField_a_of_type_JavaUtilList = localArrayList;
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Uvr.c();
    ved.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwq
 * JD-Core Version:    0.7.0.1
 */