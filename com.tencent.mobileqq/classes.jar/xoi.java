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

public class xoi
  implements IEventReceiver, xnn<xoe>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<xpe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final vlc jdField_a_of_type_Vlc = new xol(this);
  private xnj jdField_a_of_type_Xnj;
  private xom jdField_a_of_type_Xom;
  private xon jdField_a_of_type_Xon;
  private xoo jdField_a_of_type_Xoo;
  private xop jdField_a_of_type_Xop;
  private xoq jdField_a_of_type_Xoq;
  private xor jdField_a_of_type_Xor;
  private xos jdField_a_of_type_Xos;
  private xot jdField_a_of_type_Xot;
  private xou jdField_a_of_type_Xou;
  private xov jdField_a_of_type_Xov;
  private xow jdField_a_of_type_Xow;
  private xox jdField_a_of_type_Xox;
  private xoy jdField_a_of_type_Xoy;
  private xoz jdField_a_of_type_Xoz;
  private boolean jdField_a_of_type_Boolean = true;
  
  public xoi(int paramInt, @NonNull xor paramxor, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xor = paramxor;
    yos.a(this.jdField_a_of_type_Xor);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      yos.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<xpe> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (xpe)paramList.next();
      if ((localObject instanceof xnx))
      {
        localObject = (xnx)localObject;
        if (((GeneralFeedItem)((xnx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((xnx)localObject).a());
        }
      }
    }
    return null;
  }
  
  private xnx a(List<xpe> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (xpe)paramList.next();
      if ((localObject instanceof xnx))
      {
        localObject = (xnx)localObject;
        if ((((GeneralFeedItem)((xnx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((xnx)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private xpg a(List<xpe> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (xpe)paramList.next();
      if ((localObject instanceof xpd))
      {
        localObject = (xpg)localObject;
        vwb localvwb = ((xpg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localvwb != null) && (TextUtils.equals(paramString1, localvwb.getUnionId())) && (TextUtils.equals(paramString2, ((xpg)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<xpe> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(xoe paramxoe, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((vvj)vux.a(2)).a() == null) {
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
            xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramxoe.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = xnp.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new xpd(paramList);
                paramxoe.jdField_b_of_type_JavaUtilList.add(0, paramList);
                xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = vpd.a(localStoryVideoItem.mVid);
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
                  xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramxoe.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new xpd(xnp.a(str, localStoryVideoItem.mPublishDate));
                  paramxoe.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramxoe.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((vuu)vux.a(5)).a(localStoryVideoItem.mVid);
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramxoe.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = xnp.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new xnx(paramList);
        paramxoe.jdField_b_of_type_JavaUtilList.add(0, paramList);
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        xvv.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramxoe.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramxoe.jdField_b_of_type_JavaUtilList, xnx.jdField_a_of_type_Xpi);
      if (!QLog.isDebugVersion()) {
        break;
      }
      xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramxoe.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((vuu)vux.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (vpr.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((vuu)vux.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = xen.a(((xen)vux.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    vsd localvsd = new vsd(0, paramCommentEntry.feedId, 1);
    localvsd.c = paramCommentEntry.commentId;
    localvsd.a = paramCommentLikeFeedItem;
    vli.a().dispatch(localvsd);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localvsd, Integer.valueOf(localvsd.a.mCommentCount), Integer.valueOf(localvsd.a.mFanCommentCount), Integer.valueOf(localvsd.a.mFriendCommentCount));
  }
  
  private void b(xoe paramxoe)
  {
    List localList;
    if ((paramxoe.jdField_b_of_type_Boolean) || ((paramxoe.c) && (paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((vuu)vux.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramxoe, localList);
  }
  
  private static void b(@NonNull xoi paramxoi, @NonNull String paramString)
  {
    Object localObject2 = paramxoi.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (xpe)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof xpg)) {
          continue;
        }
        localObject1 = (xpg)localObject1;
        Iterator localIterator = ((xpg)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((xpg)localObject1).a(localStoryVideoItem);
        paramString = (xnv)vux.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((xpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((xpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((xpg)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((xpg)localObject1).a().size() != 0) {
          break label346;
        }
        paramxoi.jdField_a_of_type_JavaUtilArrayList.remove(i);
        xnp.b(((VideoListFeedItem)((xpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramxoi.jdField_a_of_type_Xor.b(((VideoListFeedItem)((xpg)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramxoi = (vva)vux.a(27);
          paramString = new ArrayList();
          paramString.add(((xpg)localObject1).a().feedId);
          paramxoi.a(paramString);
          xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((xpg)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((xpg)localObject1), 2000L);
        }
        return;
        label346:
        paramxoi.jdField_a_of_type_Xor.a((xpg)localObject1);
      }
    }
  }
  
  private static void b(xpg paramxpg)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramxpg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new wdo((List)localObject, true);
    vqn.a().a((vqr)localObject, new xok(paramxpg));
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
  
  private void c(xoe paramxoe)
  {
    long l = 0L;
    if (!paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramxoe.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (xpe)((Iterator)???).next();
      if (((localObject2 instanceof xpg)) && (((xpg)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramxoe.c) {
        this.jdField_a_of_type_JavaUtilList = ((vuu)vux.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramxoe.jdField_a_of_type_Boolean) {}
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
          if (xnp.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramxoe.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((xpe)paramxoe.jdField_b_of_type_JavaUtilList.get(paramxoe.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramxoe, (List)localObject2);
  }
  
  private void d(xoe paramxoe)
  {
    vva localvva = (vva)vux.a(27);
    paramxoe = paramxoe.jdField_b_of_type_JavaUtilList;
    if (paramxoe != null)
    {
      paramxoe = paramxoe.iterator();
      while (paramxoe.hasNext())
      {
        Object localObject = (xpe)paramxoe.next();
        if ((localObject instanceof xpg))
        {
          localObject = (xpg)localObject;
          ((xpg)localObject).d = localvva.a(((xpg)localObject).a().feedId, ((xpg)localObject).a());
          xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((xpg)localObject).a().feedId, Integer.valueOf(((xpg)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(xoe paramxoe)
  {
    Object localObject = paramxoe.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramxoe = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      xpe localxpe = (xpe)((Iterator)localObject).next();
      if (((localxpe instanceof xnx)) && (!((GeneralFeedItem)localxpe.a()).mIsVideoEnd)) {
        paramxoe.add(localxpe.a().feedId);
      }
    }
    ((vva)vux.a(27)).a(paramxoe);
  }
  
  public List<xpe> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public xpe a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      xpe localxpe = (xpe)localIterator.next();
      if (localxpe.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localxpe;
      }
    }
    return null;
  }
  
  public void a()
  {
    xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Xnj = new xof(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xox = new xox(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xox);
      this.jdField_a_of_type_Xom = new xom(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xom);
      this.jdField_a_of_type_Xos = new xos(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xos);
      this.jdField_a_of_type_Xop = new xop(this);
      vli.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Xop);
      this.jdField_a_of_type_Xoo = new xoo(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xoo);
      this.jdField_a_of_type_Xon = new xon(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xon);
      this.jdField_a_of_type_Xoy = new xoy(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xoy);
      this.jdField_a_of_type_Xoz = new xoz(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xoz);
      this.jdField_a_of_type_Xou = new xou(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xou);
      this.jdField_a_of_type_Xov = new xov(this, this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xov);
      this.jdField_a_of_type_Xow = new xow(this, this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xow);
      this.jdField_a_of_type_Xot = new xot(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xot);
      this.jdField_a_of_type_Xoq = new xoq(this);
      vli.a().registerSubscriber(this.jdField_a_of_type_Xoq);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Vlc);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Xnj = new yon(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Xnj = new xki(this);
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
    } while (!(localObject instanceof xmz));
    Object localObject = (xmz)localObject;
    if (((xmz)localObject).a().mCommentIsEnd == 0)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new xng(paramString, 1, ((CommentLikeFeedItem)((xmz)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((xnp)vux.a(11)).a().a(localArrayList);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<xpe> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xpe localxpe = (xpe)paramList.next();
      if (localHashSet.contains(localxpe.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localxpe });
      }
      else
      {
        localHashSet.add(localxpe.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(xoe paramxoe)
  {
    c(paramxoe);
    d(paramxoe);
    xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramxoe.b() });
    e(paramxoe);
    a(new ArrayList(paramxoe.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramxoe));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      xnp localxnp = (xnp)vux.a(11);
      xnl localxnl = localxnp.jdField_a_of_type_Xnl;
      ArrayList localArrayList = localxnp.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localxnl != null))
      {
        localObject = new xoe(new ErrorMessage());
        ((xoe)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localxnp.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((xoe)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((xoe)localObject).jdField_b_of_type_Boolean = true;
        ((xoe)localObject).e = true;
        this.jdField_a_of_type_Xnj.a(localxnl);
        xvv.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((xoe)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((xoe)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((xoe)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((xoe)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (xoe)this.jdField_a_of_type_Xnj.b();
        this.jdField_a_of_type_Boolean = ((xoe)localObject).jdField_a_of_type_Boolean;
        b((xoe)localObject);
        d((xoe)localObject);
      }
    }
    Object localObject = (vwq)vux.a(9);
    ((vwq)localObject).a(new xoj(this, (vwq)localObject));
    ((vwq)localObject).a(1000);
    xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(xpg paramxpg)
  {
    FeedVideoInfo localFeedVideoInfo = paramxpg.a().getVideoInfo();
    xhs localxhs = new xhs(0, localFeedVideoInfo);
    localxhs.b("HomeFeedPresenter");
    localxhs.c();
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramxpg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xox);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xom);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xos);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xop);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xoo);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xon);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xoy);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xoz);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xou);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xov);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xow);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xot);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xoq);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Vlc);
    ((xnp)vux.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new xhj(paramString, false).a(true);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      xnp localxnp = (xnp)vux.a(11);
      localxnp.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localxnp.jdField_a_of_type_Xnl = new xnl(this.jdField_a_of_type_Xnj.a());
      localxnp.jdField_a_of_type_Boolean = a();
      xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    xnp localxnp = (xnp)vux.a(11);
    localxnp.b = new xnl(this.jdField_a_of_type_Xnj.a());
    List localList = localxnp.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (xpe)localIterator.next();
      if ((localObject instanceof xpg))
      {
        xpg localxpg = (xpg)localObject;
        int i = xnh.a(localList, ((xpe)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (xnh)localList.remove(i);
          ((xnh)localObject).b = localxpg.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((xpe)localObject).a().feedId))
        {
          localArrayList.add(new xnh(((xpe)localObject).a().feedId, 0, ((xpe)localObject).a().getOwner().getUnionId(), ((xpe)localObject).a().date));
        }
        else
        {
          localArrayList.add(new xnh(((xpe)localObject).a().feedId, 0, ((xpe)localObject).a().getOwner().getUnionId(), ((xpe)localObject).a().date));
          xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((xpe)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localxnp.b.jdField_a_of_type_JavaUtilList = localArrayList;
    xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Xnj.c();
    xvv.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoi
 * JD-Core Version:    0.7.0.1
 */