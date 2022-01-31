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

public class uwt
  implements IEventReceiver, uvy<uwp>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<uxp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final ssy jdField_a_of_type_Ssy = new uww(this);
  private uvu jdField_a_of_type_Uvu;
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
  private uxi jdField_a_of_type_Uxi;
  private uxj jdField_a_of_type_Uxj;
  private uxk jdField_a_of_type_Uxk;
  private boolean jdField_a_of_type_Boolean = true;
  
  public uwt(int paramInt, @NonNull uxc paramuxc, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Uxc = paramuxc;
    vxs.a(this.jdField_a_of_type_Uxc);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      vxs.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<uxp> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxp)paramList.next();
      if ((localObject instanceof uwi))
      {
        localObject = (uwi)localObject;
        if (((GeneralFeedItem)((uwi)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((uwi)localObject).a());
        }
      }
    }
    return null;
  }
  
  private uwi a(List<uxp> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxp)paramList.next();
      if ((localObject instanceof uwi))
      {
        localObject = (uwi)localObject;
        if ((((GeneralFeedItem)((uwi)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((uwi)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          veg.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private uxr a(List<uxp> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (uxp)paramList.next();
      if ((localObject instanceof uxo))
      {
        localObject = (uxr)localObject;
        teg localteg = ((uxr)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localteg != null) && (TextUtils.equals(paramString1, localteg.getUnionId())) && (TextUtils.equals(paramString2, ((uxr)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          veg.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<uxp> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(uwp paramuwp, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((tdo)tdc.a(2)).a() == null) {
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
            veg.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramuwp.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = uwa.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new uxo(paramList);
                paramuwp.jdField_b_of_type_JavaUtilList.add(0, paramList);
                veg.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = sxh.a(localStoryVideoItem.mVid);
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
                  veg.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramuwp.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new uxo(uwa.a(str, localStoryVideoItem.mPublishDate));
                  paramuwp.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  veg.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramuwp.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((tcz)tdc.a(5)).a(localStoryVideoItem.mVid);
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramuwp.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = uwa.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new uwi(paramList);
        paramuwp.jdField_b_of_type_JavaUtilList.add(0, paramList);
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        veg.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        veg.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramuwp.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramuwp.jdField_b_of_type_JavaUtilList, uwi.jdField_a_of_type_Uxt);
      if (!QLog.isDebugVersion()) {
        break;
      }
      veg.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramuwp.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((tcz)tdc.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (sxv.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((tcz)tdc.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    veg.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = umy.a(((umy)tdc.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      veg.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      veg.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          veg.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    tah localtah = new tah(0, paramCommentEntry.feedId, 1);
    localtah.c = paramCommentEntry.commentId;
    localtah.a = paramCommentLikeFeedItem;
    ste.a().dispatch(localtah);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localtah, Integer.valueOf(localtah.a.mCommentCount), Integer.valueOf(localtah.a.mFanCommentCount), Integer.valueOf(localtah.a.mFriendCommentCount));
  }
  
  private void b(uwp paramuwp)
  {
    List localList;
    if ((paramuwp.jdField_b_of_type_Boolean) || ((paramuwp.c) && (paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((tcz)tdc.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramuwp, localList);
  }
  
  private static void b(@NonNull uwt paramuwt, @NonNull String paramString)
  {
    Object localObject2 = paramuwt.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (uxp)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof uxr)) {
          continue;
        }
        localObject1 = (uxr)localObject1;
        Iterator localIterator = ((uxr)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((uxr)localObject1).a(localStoryVideoItem);
        paramString = (uwg)tdc.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((uxr)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((uxr)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((uxr)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((uxr)localObject1).a().size() != 0) {
          break label346;
        }
        paramuwt.jdField_a_of_type_JavaUtilArrayList.remove(i);
        uwa.b(((VideoListFeedItem)((uxr)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramuwt.jdField_a_of_type_Uxc.b(((VideoListFeedItem)((uxr)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramuwt = (tdf)tdc.a(27);
          paramString = new ArrayList();
          paramString.add(((uxr)localObject1).a().feedId);
          paramuwt.a(paramString);
          veg.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((uxr)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          veg.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((uxr)localObject1), 2000L);
        }
        return;
        label346:
        paramuwt.jdField_a_of_type_Uxc.a((uxr)localObject1);
      }
    }
  }
  
  private static void b(uxr paramuxr)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramuxr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new tlt((List)localObject, true);
    syr.a().a((syv)localObject, new uwv(paramuxr));
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
  
  private void c(uwp paramuwp)
  {
    long l = 0L;
    if (!paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramuwp.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (uxp)((Iterator)???).next();
      if (((localObject2 instanceof uxr)) && (((uxr)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramuwp.c) {
        this.jdField_a_of_type_JavaUtilList = ((tcz)tdc.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramuwp.jdField_a_of_type_Boolean) {}
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
          if (uwa.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramuwp.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((uxp)paramuwp.jdField_b_of_type_JavaUtilList.get(paramuwp.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramuwp, (List)localObject2);
  }
  
  private void d(uwp paramuwp)
  {
    tdf localtdf = (tdf)tdc.a(27);
    paramuwp = paramuwp.jdField_b_of_type_JavaUtilList;
    if (paramuwp != null)
    {
      paramuwp = paramuwp.iterator();
      while (paramuwp.hasNext())
      {
        Object localObject = (uxp)paramuwp.next();
        if ((localObject instanceof uxr))
        {
          localObject = (uxr)localObject;
          ((uxr)localObject).d = localtdf.a(((uxr)localObject).a().feedId, ((uxr)localObject).a());
          veg.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((uxr)localObject).a().feedId, Integer.valueOf(((uxr)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(uwp paramuwp)
  {
    Object localObject = paramuwp.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramuwp = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uxp localuxp = (uxp)((Iterator)localObject).next();
      if (((localuxp instanceof uwi)) && (!((GeneralFeedItem)localuxp.a()).mIsVideoEnd)) {
        paramuwp.add(localuxp.a().feedId);
      }
    }
    ((tdf)tdc.a(27)).a(paramuwp);
  }
  
  public List<uxp> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public uxp a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      uxp localuxp = (uxp)localIterator.next();
      if (localuxp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localuxp;
      }
    }
    return null;
  }
  
  public void a()
  {
    veg.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Uvu = new uwq(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uxi = new uxi(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxi);
      this.jdField_a_of_type_Uwx = new uwx(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uwx);
      this.jdField_a_of_type_Uxd = new uxd(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxd);
      this.jdField_a_of_type_Uxa = new uxa(this);
      ste.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Uxa);
      this.jdField_a_of_type_Uwz = new uwz(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uwz);
      this.jdField_a_of_type_Uwy = new uwy(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uwy);
      this.jdField_a_of_type_Uxj = new uxj(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxj);
      this.jdField_a_of_type_Uxk = new uxk(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxk);
      this.jdField_a_of_type_Uxf = new uxf(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxf);
      this.jdField_a_of_type_Uxg = new uxg(this, this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxg);
      this.jdField_a_of_type_Uxh = new uxh(this, this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxh);
      this.jdField_a_of_type_Uxe = new uxe(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxe);
      this.jdField_a_of_type_Uxb = new uxb(this);
      ste.a().registerSubscriber(this.jdField_a_of_type_Uxb);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ssy);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Uvu = new vxn(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Uvu = new ust(this);
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
    } while (!(localObject instanceof uvk));
    Object localObject = (uvk)localObject;
    if (((uvk)localObject).a().mCommentIsEnd == 0)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new uvr(paramString, 1, ((CommentLikeFeedItem)((uvk)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((uwa)tdc.a(11)).a().a(localArrayList);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<uxp> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uxp localuxp = (uxp)paramList.next();
      if (localHashSet.contains(localuxp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localuxp });
      }
      else
      {
        localHashSet.add(localuxp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(uwp paramuwp)
  {
    c(paramuwp);
    d(paramuwp);
    veg.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramuwp.b() });
    e(paramuwp);
    a(new ArrayList(paramuwp.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramuwp));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      uwa localuwa = (uwa)tdc.a(11);
      uvw localuvw = localuwa.jdField_a_of_type_Uvw;
      ArrayList localArrayList = localuwa.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localuvw != null))
      {
        localObject = new uwp(new ErrorMessage());
        ((uwp)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localuwa.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((uwp)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((uwp)localObject).jdField_b_of_type_Boolean = true;
        ((uwp)localObject).e = true;
        this.jdField_a_of_type_Uvu.a(localuvw);
        veg.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((uwp)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((uwp)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((uwp)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((uwp)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (uwp)this.jdField_a_of_type_Uvu.b();
        this.jdField_a_of_type_Boolean = ((uwp)localObject).jdField_a_of_type_Boolean;
        b((uwp)localObject);
        d((uwp)localObject);
      }
    }
    Object localObject = (tev)tdc.a(9);
    ((tev)localObject).a(new uwu(this, (tev)localObject));
    ((tev)localObject).a(1000);
    veg.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(uxr paramuxr)
  {
    FeedVideoInfo localFeedVideoInfo = paramuxr.a().getVideoInfo();
    uqd localuqd = new uqd(0, localFeedVideoInfo);
    localuqd.b("HomeFeedPresenter");
    localuqd.c();
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramuxr.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxi);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uwx);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxd);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxa);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uwz);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uwy);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxj);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxk);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxf);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxg);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxh);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxe);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uxb);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ssy);
    ((uwa)tdc.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new upu(paramString, false).a(true);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      uwa localuwa = (uwa)tdc.a(11);
      localuwa.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localuwa.jdField_a_of_type_Uvw = new uvw(this.jdField_a_of_type_Uvu.a());
      localuwa.jdField_a_of_type_Boolean = a();
      veg.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    uwa localuwa = (uwa)tdc.a(11);
    localuwa.b = new uvw(this.jdField_a_of_type_Uvu.a());
    List localList = localuwa.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (uxp)localIterator.next();
      if ((localObject instanceof uxr))
      {
        uxr localuxr = (uxr)localObject;
        int i = uvs.a(localList, ((uxp)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (uvs)localList.remove(i);
          ((uvs)localObject).b = localuxr.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((uxp)localObject).a().feedId))
        {
          localArrayList.add(new uvs(((uxp)localObject).a().feedId, 0, ((uxp)localObject).a().getOwner().getUnionId(), ((uxp)localObject).a().date));
        }
        else
        {
          localArrayList.add(new uvs(((uxp)localObject).a().feedId, 0, ((uxp)localObject).a().getOwner().getUnionId(), ((uxp)localObject).a().date));
          veg.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((uxp)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localuwa.b.jdField_a_of_type_JavaUtilList = localArrayList;
    veg.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Uvu.c();
    veg.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwt
 * JD-Core Version:    0.7.0.1
 */