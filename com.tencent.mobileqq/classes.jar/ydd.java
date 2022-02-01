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

public class ydd
  implements IEventReceiver, yci<ycz>
{
  private int jdField_a_of_type_Int;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<ydz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  protected AtomicBoolean a;
  private final vzx jdField_a_of_type_Vzx = new ydg(this);
  private yce jdField_a_of_type_Yce;
  private ydh jdField_a_of_type_Ydh;
  private ydi jdField_a_of_type_Ydi;
  private ydj jdField_a_of_type_Ydj;
  private ydk jdField_a_of_type_Ydk;
  private ydl jdField_a_of_type_Ydl;
  private ydm jdField_a_of_type_Ydm;
  private ydn jdField_a_of_type_Ydn;
  private ydo jdField_a_of_type_Ydo;
  private ydp jdField_a_of_type_Ydp;
  private ydq jdField_a_of_type_Ydq;
  private ydr jdField_a_of_type_Ydr;
  private yds jdField_a_of_type_Yds;
  private ydt jdField_a_of_type_Ydt;
  private ydu jdField_a_of_type_Ydu;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ydd(int paramInt, @NonNull ydm paramydm, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ydm = paramydm;
    zdl.a(this.jdField_a_of_type_Ydm);
    if ((this.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_Int != 12)) {
      zdl.a("feed type error for:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<ydz> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ydz)paramList.next();
      if ((localObject instanceof ycs))
      {
        localObject = (ycs)localObject;
        if (((GeneralFeedItem)((ycs)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((ycs)localObject).a());
        }
      }
    }
    return null;
  }
  
  private ycs a(List<ydz> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ydz)paramList.next();
      if ((localObject instanceof ycs))
      {
        localObject = (ycs)localObject;
        if ((((GeneralFeedItem)((ycs)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((ycs)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).date)))
        {
          ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private yeb a(List<ydz> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ydz)paramList.next();
      if ((localObject instanceof ydy))
      {
        localObject = (yeb)localObject;
        wkw localwkw = ((yeb)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.getOwner();
        if ((localwkw != null) && (TextUtils.equals(paramString1, localwkw.getUnionId())) && (TextUtils.equals(paramString2, ((yeb)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.date)))
        {
          ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void a(ArrayList<ydz> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void a(ycz paramycz, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((wke)wjs.a(2)).a() == null) {
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
            ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramycz.jdField_b_of_type_JavaUtilList, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = yck.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new ydy(paramList);
                paramycz.jdField_b_of_type_JavaUtilList.add(0, paramList);
                ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
          localObject = wdy.a(localStoryVideoItem.mVid);
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
                  ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str });
                }
                else
                {
                  paramList = a(paramycz.jdField_b_of_type_JavaUtilList, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label605;
                  }
                  paramList = new ydy(yck.a(str, localStoryVideoItem.mPublishDate));
                  paramycz.jdField_b_of_type_JavaUtilList.add(0, paramList);
                  ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
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
      paramList = a(localStoryVideoItem, paramycz.jdField_b_of_type_JavaUtilList);
      if (paramList != null)
      {
        ((wjp)wjs.a(5)).a(localStoryVideoItem.mVid);
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      a(localStoryVideoItem);
      localObject = a(paramycz.jdField_b_of_type_JavaUtilList, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = yck.a(QQStoryContext.a().b(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label532;
        }
        paramList = new ycs(paramList);
        paramycz.jdField_b_of_type_JavaUtilList.add(0, paramList);
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.a(localStoryVideoItem, true);
        break;
        ykq.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().b() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramycz.jdField_b_of_type_JavaUtilList);
      }
      Collections.sort(paramycz.jdField_b_of_type_JavaUtilList, ycs.jdField_a_of_type_Yed);
      if (!QLog.isDebugVersion()) {
        break;
      }
      ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramycz.jdField_b_of_type_JavaUtilList);
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
        paramStoryVideoItem.copy(((wjp)wjs.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (wem.a(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((wjp)wjs.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = xti.a(((xti)wjs.a(7)).a(paramString));
    if ((this.jdField_a_of_type_Int == 11) && (!bool))
    {
      ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.jdField_a_of_type_Int != 11) && (bool))
    {
      ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    wgy localwgy = new wgy(0, paramCommentEntry.feedId, 1);
    localwgy.c = paramCommentEntry.commentId;
    localwgy.a = paramCommentLikeFeedItem;
    wad.a().dispatch(localwgy);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localwgy, Integer.valueOf(localwgy.a.mCommentCount), Integer.valueOf(localwgy.a.mFanCommentCount), Integer.valueOf(localwgy.a.mFriendCommentCount));
  }
  
  private void b(ycz paramycz)
  {
    List localList;
    if ((paramycz.jdField_b_of_type_Boolean) || ((paramycz.c) && (paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())))
    {
      localList = ((wjp)wjs.a(5)).a(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramycz, localList);
  }
  
  private static void b(@NonNull ydd paramydd, @NonNull String paramString)
  {
    Object localObject2 = paramydd.a().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ydz)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof yeb)) {
          continue;
        }
        localObject1 = (yeb)localObject1;
        Iterator localIterator = ((yeb)localObject1).a().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((yeb)localObject1).a(localStoryVideoItem);
        paramString = (ycq)wjs.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((yeb)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)((yeb)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((yeb)localObject1).a());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((yeb)localObject1).a().size() != 0) {
          break label346;
        }
        paramydd.jdField_a_of_type_JavaUtilArrayList.remove(i);
        yck.b(((VideoListFeedItem)((yeb)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
        paramydd.jdField_a_of_type_Ydm.b(((VideoListFeedItem)((yeb)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramydd = (wjv)wjs.a(27);
          paramString = new ArrayList();
          paramString.add(((yeb)localObject1).a().feedId);
          paramydd.a(paramString);
          ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((yeb)localObject1).a().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((yeb)localObject1), 2000L);
        }
        return;
        label346:
        paramydd.jdField_a_of_type_Ydm.a((yeb)localObject1);
      }
    }
  }
  
  private static void b(yeb paramyeb)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramyeb.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
    localObject = new wsj((List)localObject, true);
    wfi.a().a((wfm)localObject, new ydf(paramyeb));
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
  
  private void c(ycz paramycz)
  {
    long l = 0L;
    if (!paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    ??? = paramycz.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (ydz)((Iterator)???).next();
      if (((localObject2 instanceof yeb)) && (((yeb)localObject2).a().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramycz.c) {
        this.jdField_a_of_type_JavaUtilList = ((wjp)wjs.a(5)).a(true);
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramycz.jdField_a_of_type_Boolean) {}
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
          if (yck.a().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramycz.jdField_b_of_type_JavaUtilList.size() > 0) {
        l = ((ydz)paramycz.jdField_b_of_type_JavaUtilList.get(paramycz.jdField_b_of_type_JavaUtilList.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramycz, (List)localObject2);
  }
  
  private void d(ycz paramycz)
  {
    wjv localwjv = (wjv)wjs.a(27);
    paramycz = paramycz.jdField_b_of_type_JavaUtilList;
    if (paramycz != null)
    {
      paramycz = paramycz.iterator();
      while (paramycz.hasNext())
      {
        Object localObject = (ydz)paramycz.next();
        if ((localObject instanceof yeb))
        {
          localObject = (yeb)localObject;
          ((yeb)localObject).d = localwjv.a(((yeb)localObject).a().feedId, ((yeb)localObject).a());
          ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((yeb)localObject).a().feedId, Integer.valueOf(((yeb)localObject).d.size()));
        }
      }
    }
  }
  
  private void e(ycz paramycz)
  {
    Object localObject = paramycz.jdField_b_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    paramycz = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ydz localydz = (ydz)((Iterator)localObject).next();
      if (((localydz instanceof ycs)) && (!((GeneralFeedItem)localydz.a()).mIsVideoEnd)) {
        paramycz.add(localydz.a().feedId);
      }
    }
    ((wjv)wjs.a(27)).a(paramycz);
  }
  
  public List<ydz> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ydz a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ydz localydz = (ydz)localIterator.next();
      if (localydz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId.equals(paramString)) {
        return localydz;
      }
    }
    return null;
  }
  
  public void a()
  {
    ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Yce = new yda(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yds = new yds(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Yds);
      this.jdField_a_of_type_Ydh = new ydh(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydh);
      this.jdField_a_of_type_Ydn = new ydn(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydn);
      this.jdField_a_of_type_Ydk = new ydk(this);
      wad.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Ydk);
      this.jdField_a_of_type_Ydj = new ydj(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydj);
      this.jdField_a_of_type_Ydi = new ydi(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydi);
      this.jdField_a_of_type_Ydt = new ydt(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydt);
      this.jdField_a_of_type_Ydu = new ydu(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydu);
      this.jdField_a_of_type_Ydp = new ydp(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydp);
      this.jdField_a_of_type_Ydq = new ydq(this, this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydq);
      this.jdField_a_of_type_Ydr = new ydr(this, this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydr);
      this.jdField_a_of_type_Ydo = new ydo(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydo);
      this.jdField_a_of_type_Ydl = new ydl(this);
      wad.a().registerSubscriber(this.jdField_a_of_type_Ydl);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Vzx);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Yce = new zdg(this);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Yce = new xzd(this);
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
    } while (!(localObject instanceof ybu));
    Object localObject = (ybu)localObject;
    if (((ybu)localObject).a().mCommentIsEnd == 0)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ycb(paramString, 1, ((CommentLikeFeedItem)((ybu)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie));
    ((yck)wjs.a(11)).a().a(localArrayList);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void a(List<ydz> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ydz localydz = (ydz)paramList.next();
      if (localHashSet.contains(localydz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))
      {
        paramList.remove();
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localydz });
      }
      else
      {
        localHashSet.add(localydz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId);
      }
    }
  }
  
  public void a(ycz paramycz)
  {
    c(paramycz);
    d(paramycz);
    ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramycz.b() });
    e(paramycz);
    a(new ArrayList(paramycz.jdField_b_of_type_JavaUtilList));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramycz));
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      yck localyck = (yck)wjs.a(11);
      ycg localycg = localyck.jdField_a_of_type_Ycg;
      ArrayList localArrayList = localyck.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_Int == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localycg != null))
      {
        localObject = new ycz(new ErrorMessage());
        ((ycz)localObject).jdField_b_of_type_JavaUtilList = localArrayList;
        paramBoolean = localyck.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Boolean = paramBoolean;
        ((ycz)localObject).jdField_a_of_type_Boolean = paramBoolean;
        ((ycz)localObject).jdField_b_of_type_Boolean = true;
        ((ycz)localObject).e = true;
        this.jdField_a_of_type_Yce.a(localycg);
        ykq.d("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((ycz)localObject).jdField_b_of_type_JavaUtilList.size()) });
      }
      for (;;)
      {
        a(new ArrayList(((ycz)localObject).jdField_b_of_type_JavaUtilList));
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(((ycz)localObject).jdField_b_of_type_JavaUtilList);
        long l2 = System.currentTimeMillis();
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((ycz)localObject).jdField_b_of_type_JavaUtilList.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (ycz)this.jdField_a_of_type_Yce.b();
        this.jdField_a_of_type_Boolean = ((ycz)localObject).jdField_a_of_type_Boolean;
        b((ycz)localObject);
        d((ycz)localObject);
      }
    }
    Object localObject = (wll)wjs.a(9);
    ((wll)localObject).a(new yde(this, (wll)localObject));
    ((wll)localObject).a(1000);
    ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(yeb paramyeb)
  {
    FeedVideoInfo localFeedVideoInfo = paramyeb.a().getVideoInfo();
    xwn localxwn = new xwn(0, localFeedVideoInfo);
    localxwn.b("HomeFeedPresenter");
    localxwn.c();
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramyeb.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yds);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydh);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydn);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydk);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydj);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydi);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydt);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydu);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydp);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydq);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydr);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydo);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Ydl);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Vzx);
    ((yck)wjs.a(11)).b = null;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new xwe(paramString, false).a(true);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      yck localyck = (yck)wjs.a(11);
      localyck.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      localyck.jdField_a_of_type_Ycg = new ycg(this.jdField_a_of_type_Yce.a());
      localyck.jdField_a_of_type_Boolean = a();
      ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void d()
  {
    yck localyck = (yck)wjs.a(11);
    localyck.b = new ycg(this.jdField_a_of_type_Yce.a());
    List localList = localyck.b.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ydz)localIterator.next();
      if ((localObject instanceof yeb))
      {
        yeb localyeb = (yeb)localObject;
        int i = ycc.a(localList, ((ydz)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (ycc)localList.remove(i);
          ((ycc)localObject).b = localyeb.a().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((ydz)localObject).a().feedId))
        {
          localArrayList.add(new ycc(((ydz)localObject).a().feedId, 0, ((ydz)localObject).a().getOwner().getUnionId(), ((ydz)localObject).a().date));
        }
        else
        {
          localArrayList.add(new ycc(((ydz)localObject).a().feedId, 0, ((ydz)localObject).a().getOwner().getUnionId(), ((ydz)localObject).a().date));
          ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((ydz)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localyck.b.jdField_a_of_type_JavaUtilList = localArrayList;
    ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void e()
  {
    this.jdField_a_of_type_Yce.c();
    ykq.b("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydd
 * JD-Core Version:    0.7.0.1
 */