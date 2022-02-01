import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.3;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.4;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver.1;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver.1;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver.1;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqstory.model.item.StoryVideoItem;>;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class qvt
  implements IEventReceiver, qve.d<qvq>
{
  private qve jdField_a_of_type_Qve;
  private qvt.a jdField_a_of_type_Qvt$a;
  private qvt.b jdField_a_of_type_Qvt$b;
  private qvt.c jdField_a_of_type_Qvt$c;
  private qvt.d jdField_a_of_type_Qvt$d;
  private qvt.e jdField_a_of_type_Qvt$e;
  private qvt.f jdField_a_of_type_Qvt$f;
  private qvt.g jdField_a_of_type_Qvt$g;
  private qvt.h jdField_a_of_type_Qvt$h;
  private qvt.i jdField_a_of_type_Qvt$i;
  private qvt.j jdField_a_of_type_Qvt$j;
  private qvt.k jdField_a_of_type_Qvt$k;
  private qvt.l jdField_a_of_type_Qvt$l;
  private qvt.m jdField_a_of_type_Qvt$m;
  private qvt.n jdField_a_of_type_Qvt$n;
  private final Object bt = new Object();
  private final pmd f = new qvw(this);
  private int mFeedType;
  protected AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  private boolean mIsEnd = true;
  private ArrayList<qwa> nl = new ArrayList();
  private List<StoryVideoItem> os;
  
  public qvt(int paramInt, @NonNull qvt.f paramf, boolean paramBoolean)
  {
    this.mFeedType = paramInt;
    this.jdField_a_of_type_Qvt$f = paramf;
    rom.checkNotNull(this.jdField_a_of_type_Qvt$f);
    if ((this.mFeedType != 10) && (this.mFeedType != 11) && (this.mFeedType != 12)) {
      rom.fail("feed type error for:%d", new Object[] { Integer.valueOf(this.mFeedType) });
    }
  }
  
  private boolean KC()
  {
    return this.mFeedType != 11;
  }
  
  public static String a(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<qwa> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (qwa)paramList.next();
      if ((localObject instanceof qvj))
      {
        localObject = (qvj)localObject;
        if (((GeneralFeedItem)((qvj)localObject).c).isMyFeedItem()) {
          return b(paramStoryVideoItem, ((qvj)localObject).bS());
        }
      }
    }
    return null;
  }
  
  private qvj a(List<qwa> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (qwa)paramList.next();
      if ((localObject instanceof qvj))
      {
        localObject = (qvj)localObject;
        if ((((GeneralFeedItem)((qvj)localObject).c).isMyFeedItem()) && (TextUtils.equals(paramString, ((GeneralFeedItem)((qvj)localObject).c).date)))
        {
          ram.d("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private qwc a(List<qwa> paramList, String paramString1, String paramString2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (qwa)paramList.next();
      if ((localObject instanceof qvz))
      {
        localObject = (qwc)localObject;
        ptq localptq = ((qwc)localObject).c.getOwner();
        if ((localptq != null) && (TextUtils.equals(paramString1, localptq.getUnionId())) && (TextUtils.equals(paramString2, ((qwc)localObject).c.date)))
        {
          ram.d("Q.qqstory.home.data.HomeFeedPresenter", "find myself today home feed item %s", localObject);
          return localObject;
        }
      }
    }
    return null;
  }
  
  private static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry)
  {
    pqs localpqs = new pqs(0, paramCommentEntry.feedId, 1);
    localpqs.commentId = paramCommentEntry.commentId;
    localpqs.c = paramCommentLikeFeedItem;
    pmi.a().dispatch(localpqs);
    ram.a("Q.qqstory.home.data.HomeFeedPresenter", "notifyFeedInfoChange. event = %s, mCommentCount = %d, mFanCommentCount = %d, mFriendCommentCount = %d.", localpqs, Integer.valueOf(localpqs.c.mCommentCount), Integer.valueOf(localpqs.c.mFanCommentCount), Integer.valueOf(localpqs.c.mFriendCommentCount));
  }
  
  private void a(qvq paramqvq, List<StoryVideoItem> paramList)
  {
    if (paramList.size() == 0) {
      break label9;
    }
    label9:
    while (((ptf)psx.a(2)).a() == null) {
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
          if (!fr(localStoryVideoItem.shareGroupId))
          {
            ram.w("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.mFeedType), localStoryVideoItem.shareGroupId });
          }
          else
          {
            localObject = a(paramqvq.or, localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
            paramList = (List<StoryVideoItem>)localObject;
            if (localObject == null)
            {
              paramList = qvf.a(localStoryVideoItem.shareGroupId, localStoryVideoItem.mPublishDate);
              if (paramList != null)
              {
                paramList = new qvz(paramList);
                paramqvq.or.add(0, paramList);
                ram.w("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
              }
            }
            else
            {
              paramList.c(localStoryVideoItem, true);
            }
          }
        }
        else
        {
          localObject = pox.b(localStoryVideoItem.mVid);
          if (localObject != null)
          {
            paramList = localStoryVideoItem.mVideoSpreadGroupList;
            if ((paramList != null) && (paramList.mB != null))
            {
              Iterator localIterator2 = paramList.mB.iterator();
              label236:
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (!fr(str))
                {
                  ram.w("Q.qqstory.home.data.HomeFeedPresenter", "this feed not in this feed type:%d, %s", new Object[] { Integer.valueOf(this.mFeedType), str });
                }
                else
                {
                  paramList = a(paramqvq.or, str, localStoryVideoItem.mPublishDate);
                  if (paramList != null) {
                    break label610;
                  }
                  paramList = new qvz(qvf.a(str, localStoryVideoItem.mPublishDate));
                  paramqvq.or.add(0, paramList);
                  ram.w("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
                }
              }
            }
          }
        }
      }
    }
    label537:
    label610:
    for (;;)
    {
      paramList.c(localStoryVideoItem, true);
      break label236;
      if ((((PublishVideoEntry)localObject).getBooleanExtra("ignorePersonalPublish", false)) || (!KC())) {
        break label31;
      }
      paramList = a(localStoryVideoItem, paramqvq.or);
      if (paramList != null)
      {
        ((psu)psx.a(5)).qV(localStoryVideoItem.mVid);
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { localStoryVideoItem.mVid, paramList });
        break label31;
      }
      f(localStoryVideoItem);
      localObject = a(paramqvq.or, localStoryVideoItem.mPublishDate);
      paramList = (List<StoryVideoItem>)localObject;
      if (localObject == null)
      {
        paramList = qvf.a(QQStoryContext.a().getCurrentUid(), localStoryVideoItem.mPublishDate);
        if (paramList == null) {
          break label537;
        }
        paramList = new qvj(paramList);
        paramqvq.or.add(0, paramList);
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { paramList });
      }
      for (;;)
      {
        paramList.c(localStoryVideoItem, true);
        break;
        ram.e("Q.qqstory.home.data.HomeFeedPresenter", "we found the union id = %s and get null generalFeed", new Object[] { QQStoryContext.a().getCurrentUid() });
        paramList = (List<StoryVideoItem>)localObject;
      }
      if (QLog.isDebugVersion()) {
        ram.b("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", paramqvq.or);
      }
      Collections.sort(paramqvq.or, qvj.a);
      if (!QLog.isDebugVersion()) {
        break;
      }
      ram.b("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", paramqvq.or);
      return;
    }
  }
  
  private static void a(@NonNull qvt paramqvt, @NonNull String paramString)
  {
    Object localObject2 = paramqvt.bY().iterator();
    int i = -1;
    for (;;)
    {
      Object localObject1;
      StoryVideoItem localStoryVideoItem;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (qwa)((Iterator)localObject2).next();
        i += 1;
        if (!(localObject1 instanceof qwc)) {
          continue;
        }
        localObject1 = (qwc)localObject1;
        Iterator localIterator = ((qwc)localObject1).bS().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
        } while (!localStoryVideoItem.mVid.equals(paramString));
        ((qwc)localObject1).o(localStoryVideoItem);
        paramString = (qvi)psx.a(12);
        localObject2 = paramString.a(((VideoListFeedItem)((qwc)localObject1).c).feedId, ((VideoListFeedItem)((qwc)localObject1).c).mVideoPullType);
        if (localObject2 != null)
        {
          ((FeedVideoInfo)localObject2).mVideoItemList.clear();
          ((FeedVideoInfo)localObject2).mVideoItemList.addAll(((qwc)localObject1).bS());
          paramString.a(0, (FeedVideoInfo)localObject2, true);
        }
        if (((qwc)localObject1).bS().size() != 0) {
          break label346;
        }
        paramqvt.nl.remove(i);
        qvf.sd(((VideoListFeedItem)((qwc)localObject1).c).feedId);
        paramqvt.jdField_a_of_type_Qvt$f.sh(((VideoListFeedItem)((qwc)localObject1).c).feedId);
      }
      for (;;)
      {
        paramString.a((FeedVideoInfo)localObject2);
        if (localStoryVideoItem.mTagInfoBase != null)
        {
          paramqvt = (psz)psx.a(27);
          paramString = new ArrayList();
          paramString.add(((qwc)localObject1).c().feedId);
          paramqvt.ea(paramString);
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "delete video ,update tag list :%s", new Object[] { ((qwc)localObject1).c().feedId });
        }
        if ((localStoryVideoItem.isPollVideo()) || (localStoryVideoItem.isInteractVideo()))
        {
          ram.d("Q.qqstory.home.data.HomeFeedPresenter", "delete interact video, refresh comment.");
          ThreadManager.getUIHandler().postDelayed(new HomeFeedPresenter.4((qwc)localObject1), 2000L);
        }
        return;
        label346:
        paramqvt.jdField_a_of_type_Qvt$f.c((qwc)localObject1);
      }
    }
  }
  
  private static void a(qwc paramqwc)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(paramqwc.c.feedId);
    localObject = new pyi((List)localObject, true);
    ppv.a().a((ppw)localObject, new qvv(paramqwc));
  }
  
  private static boolean a(CommentLikeFeedItem paramCommentLikeFeedItem)
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
  
  public static String b(@NonNull StoryVideoItem paramStoryVideoItem, @NonNull List<StoryVideoItem> paramList)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      ram.w("Q.qqstory.home.data.HomeFeedPresenter", "matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (TextUtils.equals(localStoryVideoItem.mLocalSpecialItemId, paramStoryVideoItem.mLocalSpecialItemId))
        {
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "FIND !! matchStoryVideoItem, local item special id = %s", new Object[] { paramStoryVideoItem.mLocalSpecialItemId });
          return localStoryVideoItem.mVid;
        }
      }
    }
    return null;
  }
  
  private void c(qvq paramqvq)
  {
    List localList;
    if ((paramqvq.aCu) || ((paramqvq.isFirstPage) && (paramqvq.b.isSuccess())))
    {
      localList = ((psu)psx.a(5)).g(true);
      if (localList.size() != 0) {}
    }
    else
    {
      return;
    }
    a(paramqvq, localList);
  }
  
  private void cm(ArrayList<qwa> paramArrayList)
  {
    Bosses.get().postLightWeightJob(new HomeFeedPresenter.3(this, paramArrayList), 10);
  }
  
  private void d(qvq paramqvq)
  {
    long l = 0L;
    if (!paramqvq.b.isSuccess()) {
      return;
    }
    ??? = paramqvq.or.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (qwa)((Iterator)???).next();
      if (((localObject2 instanceof qwc)) && (((qwc)localObject2).bS().size() == 0)) {
        ((Iterator)???).remove();
      }
    }
    synchronized (this.bt)
    {
      if (paramqvq.isFirstPage) {
        this.os = ((psu)psx.a(5)).g(true);
      }
      if ((this.os == null) || (this.os.isEmpty())) {
        return;
      }
    }
    Object localObject2 = new ArrayList(0);
    if (paramqvq.isEnd) {}
    for (;;)
    {
      Iterator localIterator = this.os.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        try
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (qvf.c().parse(localStoryVideoItem.mPublishDate).getTime() >= l)
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
      if (paramqvq.or.size() > 0) {
        l = ((qwa)paramqvq.or.get(paramqvq.or.size() - 1)).a().dateTimeMillis;
      }
    }
    a(paramqvq, (List)localObject2);
  }
  
  private void e(qvq paramqvq)
  {
    psz localpsz = (psz)psx.a(27);
    paramqvq = paramqvq.or;
    if (paramqvq != null)
    {
      paramqvq = paramqvq.iterator();
      while (paramqvq.hasNext())
      {
        Object localObject = (qwa)paramqvq.next();
        if ((localObject instanceof qwc))
        {
          localObject = (qwc)localObject;
          ((qwc)localObject).oi = localpsz.c(((qwc)localObject).c().feedId, ((qwc)localObject).bS());
          ram.b("Q.qqstory.home.data.HomeFeedPresenter", "update tag list , feed id = %s , tag size = %d", ((qwc)localObject).c().feedId, Integer.valueOf(((qwc)localObject).oi.size()));
        }
      }
    }
  }
  
  private void f(qvq paramqvq)
  {
    Object localObject = paramqvq.or;
    if (localObject == null) {
      return;
    }
    paramqvq = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      qwa localqwa = (qwa)((Iterator)localObject).next();
      if (((localqwa instanceof qvj)) && (!((GeneralFeedItem)localqwa.a()).mIsVideoEnd)) {
        paramqvq.add(localqwa.a().feedId);
      }
    }
    ((psz)psx.a(27)).ea(paramqvq);
  }
  
  public static boolean f(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    if (!TextUtils.isEmpty(paramStoryVideoItem.mLocalSpecialItemId))
    {
      if (paramStoryVideoItem.mUploadStatus != 4) {
        break label92;
      }
      if (Math.abs(paramStoryVideoItem.mCreateTime - NetConnInfoCenter.getServerTimeMillis()) > 600000L)
      {
        paramStoryVideoItem.mUploadStatus = 6;
        paramStoryVideoItem.copy(((psu)psx.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s createTime=%d is marked as SUBMIT FAIL", new Object[] { paramStoryVideoItem.mVid, Long.valueOf(paramStoryVideoItem.mCreateTime) });
      }
    }
    label92:
    while ((paramStoryVideoItem.mUploadStatus != 1) || (ppg.e.fc(paramStoryVideoItem.mVid))) {
      return false;
    }
    paramStoryVideoItem.mUploadStatus = 3;
    paramStoryVideoItem.copy(((psu)psx.a(5)).a(paramStoryVideoItem.mVid, paramStoryVideoItem));
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "confirmUploadingStatus, the video item with fakeVid=%s is marked as UPLOAD FAIL", new Object[] { paramStoryVideoItem.mVid });
    return true;
  }
  
  private boolean fr(String paramString)
  {
    if ((this.mFeedType == 12) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    boolean bool = qqe.b(((qqe)psx.a(7)).a(paramString));
    if ((this.mFeedType == 11) && (!bool))
    {
      ram.d("Q.qqstory.home.data.HomeFeedPresenter", "ignore share group item in troop assistant list");
      return false;
    }
    if ((this.mFeedType != 11) && (bool))
    {
      ram.d("Q.qqstory.home.data.HomeFeedPresenter", "ignore troop assistant only share group item not in troop assistant list");
      return false;
    }
    return true;
  }
  
  public qwa a(String paramString)
  {
    Iterator localIterator = this.nl.iterator();
    while (localIterator.hasNext())
    {
      qwa localqwa = (qwa)localIterator.next();
      if (localqwa.c.feedId.equals(paramString)) {
        return localqwa;
      }
    }
    return null;
  }
  
  public void a(qvq paramqvq)
  {
    d(paramqvq);
    e(paramqvq);
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "on feed back:%s", new Object[] { paramqvq.mQ() });
    f(paramqvq);
    cm(new ArrayList(paramqvq.or));
    ThreadManager.getUIHandler().post(new HomeFeedPresenter.2(this, paramqvq));
  }
  
  public boolean a(qwc paramqwc)
  {
    FeedVideoInfo localFeedVideoInfo = paramqwc.c().getVideoInfo();
    qrz localqrz = new qrz(0, localFeedVideoInfo);
    localqrz.rV("HomeFeedPresenter");
    localqrz.aPh();
    ram.b("Q.qqstory.home.data.HomeFeedPresenter", "load next page for %s, info:%s", paramqwc.c.feedId, localFeedVideoInfo);
    return true;
  }
  
  public void aMG()
  {
    this.jdField_a_of_type_Qve.aPh();
    ram.d("Q.qqstory.home.data.HomeFeedPresenter", "load network next feed");
  }
  
  public List<qwa> bY()
  {
    return this.nl;
  }
  
  public void brg()
  {
    qvf localqvf = (qvf)psx.a(11);
    localqvf.d = new qve.b(this.jdField_a_of_type_Qve.a());
    List localList = localqvf.d.nk;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.nl.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (qwa)localIterator.next();
      if ((localObject instanceof qwc))
      {
        qwc localqwc = (qwc)localObject;
        int i = qvd.a(localList, ((qwa)localObject).a().feedId);
        if (i >= 0)
        {
          localObject = (qvd)localList.remove(i);
          ((qvd)localObject).bls = localqwc.c().mVideoPullType;
          localArrayList.add(localObject);
        }
        else if (VideoListFeedItem.isFakeFeedId(((qwa)localObject).a().feedId))
        {
          localArrayList.add(new qvd(((qwa)localObject).a().feedId, 0, ((qwa)localObject).a().getOwner().getUnionId(), ((qwa)localObject).a().date));
        }
        else
        {
          localArrayList.add(new qvd(((qwa)localObject).a().feedId, 0, ((qwa)localObject).a().getOwner().getUnionId(), ((qwa)localObject).a().date));
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "this feed don't include %s", new Object[] { ((qwa)localObject).a().feedId });
        }
      }
    }
    localArrayList.addAll(localList);
    localqvf.d.nk = localArrayList;
    ram.w("Q.qqstory.home.data.HomeFeedPresenter", "save data for play");
  }
  
  public void create()
  {
    ram.d("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter create");
    if (this.mFeedType == 10) {
      this.jdField_a_of_type_Qve = new qvr(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qvt$l = new qvt.l(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$l);
      this.jdField_a_of_type_Qvt$a = new qvt.a(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$a);
      this.jdField_a_of_type_Qvt$g = new qvt.g(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$g);
      this.jdField_a_of_type_Qvt$d = new qvt.d(this);
      pmi.a().registerSubscriber("HomeFeedPresenter", this.jdField_a_of_type_Qvt$d);
      this.jdField_a_of_type_Qvt$c = new qvt.c(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$c);
      this.jdField_a_of_type_Qvt$b = new qvt.b(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$b);
      this.jdField_a_of_type_Qvt$m = new qvt.m(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$m);
      this.jdField_a_of_type_Qvt$n = new qvt.n(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$n);
      this.jdField_a_of_type_Qvt$i = new qvt.i(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$i);
      this.jdField_a_of_type_Qvt$j = new qvt.j(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$j);
      this.jdField_a_of_type_Qvt$k = new qvt.k(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$k);
      this.jdField_a_of_type_Qvt$h = new qvt.h(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$h);
      this.jdField_a_of_type_Qvt$e = new qvt.e(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qvt$e);
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.f);
      return;
      if (this.mFeedType == 11) {
        this.jdField_a_of_type_Qve = new roi(this);
      } else if (this.mFeedType == 12) {
        this.jdField_a_of_type_Qve = new qtn(this);
      }
    }
  }
  
  public void destroy()
  {
    this.mIsDestroy.set(true);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$l);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$g);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$d);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$c);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$b);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$m);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$n);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$i);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$j);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$k);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$h);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qvt$e);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.f);
    ((qvf)psx.a(11)).d = null;
  }
  
  public void eG(List<qwa> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qwa localqwa = (qwa)paramList.next();
      if (localHashSet.contains(localqwa.c.feedId))
      {
        paramList.remove();
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "have repeat feed %s", new Object[] { localqwa });
      }
      else
      {
        localHashSet.add(localqwa.c.feedId);
      }
    }
  }
  
  public boolean isEnd()
  {
    return this.mIsEnd;
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void pause()
  {
    if (this.mFeedType == 10)
    {
      qvf localqvf = (qvf)psx.a(11);
      localqvf.nk = new ArrayList(this.nl);
      localqvf.c = new qve.b(this.jdField_a_of_type_Qve.a());
      localqvf.aFL = isEnd();
      ram.d("Q.qqstory.home.data.HomeFeedPresenter", "HomeFeedPresenter pause, set feedList cache");
    }
  }
  
  public void refreshData(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      qvf localqvf = (qvf)psx.a(11);
      qve.b localb = localqvf.c;
      ArrayList localArrayList = localqvf.nk;
      if ((this.mFeedType == 10) && (localArrayList != null) && (localArrayList.size() > 0) && (localb != null))
      {
        localObject = new qvq(new ErrorMessage());
        ((qvq)localObject).or = localArrayList;
        paramBoolean = localqvf.aFL;
        this.mIsEnd = paramBoolean;
        ((qvq)localObject).isEnd = paramBoolean;
        ((qvq)localObject).aCu = true;
        ((qvq)localObject).aFO = true;
        this.jdField_a_of_type_Qve.a(localb);
        ram.w("Q.qqstory.home.position", "#use memory cache data size:", new Object[] { Integer.valueOf(((qvq)localObject).or.size()) });
      }
      for (;;)
      {
        cm(new ArrayList(((qvq)localObject).or));
        this.nl.clear();
        this.nl.addAll(((qvq)localObject).or);
        long l2 = System.currentTimeMillis();
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "cache data size %d, take time:%d", new Object[] { Integer.valueOf(((qvq)localObject).or.size()), Long.valueOf(l2 - l1) });
        return;
        localObject = (qvq)this.jdField_a_of_type_Qve.b();
        this.mIsEnd = ((qvq)localObject).isEnd;
        c((qvq)localObject);
        e((qvq)localObject);
      }
    }
    Object localObject = (pub)psx.a(9);
    ((pub)localObject).a(new qvu(this, (pub)localObject));
    ((pub)localObject).vX(1000);
    ram.d("Q.qqstory.home.data.HomeFeedPresenter", "refresh network feed");
  }
  
  public void se(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = a(paramString);
    } while (!(localObject instanceof qux));
    Object localObject = (qux)localObject;
    if (((qux)localObject).a().mCommentIsEnd == 0)
    {
      ram.w("Q.qqstory.home.data.HomeFeedPresenter", "push refresh, comment is not end :%s", new Object[] { paramString });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new qvc(paramString, 1, ((CommentLikeFeedItem)((qux)localObject).c).mCommentLastCookie));
    ((qvf)psx.a(11)).a().eD(localArrayList);
    ram.b("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push comment, feedId:%s", paramString);
  }
  
  public void sf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new qrv(paramString, false).tj(true);
    ram.b("Q.qqstory.home.data.HomeFeedPresenter", "start sync feed for push like, feedId:%s", paramString);
  }
  
  public static class a
    extends pml<qvt, qrl.b>
  {
    public a(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull qrl.b paramb)
    {
      int i = 1;
      if (paramb.b.isSuccess())
      {
        localObject = paramqvt.a(paramb.mFeedId);
        if (localObject == null) {
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramb.mFeedId });
        }
      }
      else
      {
        return;
      }
      if (!(localObject instanceof qux))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramb.mFeedId });
        return;
      }
      Object localObject = (qux)localObject;
      ((qux)localObject).O(paramb.nh, paramb.isFirstPage);
      CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((qux)localObject).c;
      if (paramb.isEnd) {}
      for (;;)
      {
        localCommentLikeFeedItem.mCommentIsEnd = i;
        ((CommentLikeFeedItem)((qux)localObject).c).mCommentLastCookie = paramb.aym;
        ((CommentLikeFeedItem)((qux)localObject).c).mCommentCount = paramb.mTotalCount;
        ((qvf)psx.a(11)).a(((qux)localObject).c);
        qvt.a(paramqvt).sh(paramb.mFeedId);
        ram.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramb.mFeedId, Integer.valueOf(((qux)localObject).getCommentList().size()), Boolean.valueOf(paramb.isEnd), paramb.aym);
        return;
        i = 0;
      }
    }
    
    public Class acceptEventClass()
    {
      return qrl.b.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull qrl.b paramb) {}
  }
  
  public static class b
    extends pml<qvt, pqs>
  {
    public b(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pqs parampqs)
    {
      if (((qvt.a(paramqvt) == 12) && (parampqs.bjU == 3)) || ((qvt.a(paramqvt) == 10) && (parampqs.bjU == 0) && (parampqs.what != 1))) {
        return;
      }
      Object localObject = paramqvt.a(parampqs.feedId);
      if (localObject == null)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { parampqs.feedId });
        return;
      }
      if (!(localObject instanceof qux))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { parampqs.feedId });
        return;
      }
      localObject = (qux)localObject;
      if ((parampqs.what == 1) || (parampqs.what == 2))
      {
        if (parampqs.c != null) {
          ((CommentLikeFeedItem)((qux)localObject).c).mCommentCount = parampqs.c.mCommentCount;
        }
        ((qux)localObject).O(((psa)psx.a(17)).a(parampqs.feedId, false), true);
        ram.b("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", parampqs.feedId, Integer.valueOf(((qux)localObject).getCommentList().size()));
      }
      for (;;)
      {
        qvt.a(paramqvt).sh(parampqs.feedId);
        return;
        if (parampqs.what == 3)
        {
          if (parampqs.c != null)
          {
            ((CommentLikeFeedItem)((qux)localObject).c).mHadLike = parampqs.c.mHadLike;
            ((CommentLikeFeedItem)((qux)localObject).c).mLikeCount = parampqs.c.mLikeCount;
          }
          ((qux)localObject).P(((psm)psx.a(15)).c(parampqs.feedId, false), true);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull pqs parampqs) {}
  }
  
  public static class c
    extends pml<qvt, qvi.a>
  {
    public c(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull qvi.a parama)
    {
      if (parama.bnP == 0) {
        return;
      }
      Object localObject = paramqvt.a(parama.mFeedId);
      if (localObject == null)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { parama.mFeedId });
        return;
      }
      if (!(localObject instanceof qvj))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { parama.mFeedId });
        return;
      }
      localObject = (qvj)localObject;
      FeedVideoInfo localFeedVideoInfo = ((qvi)psx.a(12)).a(parama.mFeedId, ((GeneralFeedItem)((qvj)localObject).c).mVideoPullType);
      if (localFeedVideoInfo == null)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find video info for feedId:%s, pullType:%d", new Object[] { parama.mFeedId, Integer.valueOf(((GeneralFeedItem)((qvj)localObject).c).mVideoPullType) });
        return;
      }
      ((qvj)localObject).I(localFeedVideoInfo.mVideoItemList, true);
      ((GeneralFeedItem)((qvj)localObject).c).updateVideoInfo(localFeedVideoInfo);
      ram.b("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video and cookie update after count:%d", parama.mFeedId, Integer.valueOf(((qvj)localObject).bS().size()));
      qvt.a(paramqvt).c((qwc)localObject);
    }
    
    public Class acceptEventClass()
    {
      return qvi.a.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull qvi.a parama) {}
  }
  
  public static class d
    extends pml<qvt, qrz.b>
  {
    public d(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull qrz.b paramb)
    {
      Object localObject = paramqvt.a(paramb.mFeedId);
      if (localObject == null)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramb.mFeedId });
        return;
      }
      if (!(localObject instanceof qwc))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "that is not general type!! feedId:%s", new Object[] { paramb.mFeedId });
        return;
      }
      localObject = (qwc)localObject;
      if (paramb.b.isSuccess())
      {
        ((qwc)localObject).I(paramb.oj, false);
        ((VideoListFeedItem)((qwc)localObject).c).updateVideoInfo(paramb.a);
        ram.b("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s video update after count:%d", paramb.mFeedId, Integer.valueOf(((qwc)localObject).bS().size()));
      }
      qvt.a(paramqvt).c((qwc)localObject);
    }
    
    public Class acceptEventClass()
    {
      return qrz.b.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull qrz.b paramb) {}
  }
  
  public static class e
    extends QQUIEventReceiver<qvt, pqw>
  {
    public e(@NonNull qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pqw parampqw)
    {
      if ((TextUtils.isEmpty(parampqw.feedId)) || (parampqw.commentId == 0) || (parampqw.Ao == 0L) || (TextUtils.isEmpty(parampqw.content)))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { parampqw.feedId, Integer.valueOf(parampqw.commentId), Long.valueOf(parampqw.Ao), parampqw.content });
        return;
      }
      Object localObject1 = paramqvt.a(parampqw.feedId);
      if ((localObject1 == null) || (!(localObject1 instanceof qwc)))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { parampqw.feedId });
        return;
      }
      Object localObject2 = (qwc)localObject1;
      localObject1 = qsb.a(parampqw.feedId, parampqw.commentId, parampqw.Ao, parampqw.content, parampqw.auv, parampqw.auw, parampqw.aux, parampqw.auy);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject1);
      ((qwc)localObject2).O(localArrayList, false);
      localObject2 = (CommentLikeFeedItem)((qwc)localObject2).c;
      ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
      if (qvt.b((CommentLikeFeedItem)localObject2)) {
        ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
      }
      for (;;)
      {
        qvt.a(paramqvt).sh(parampqw.feedId);
        ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, parampqw), 5, null, false);
        qvt.b((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
        return;
        ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
      }
    }
    
    public Class acceptEventClass()
    {
      return pqw.class;
    }
  }
  
  public static abstract interface f
    extends qve.d<qvq>
  {
    public abstract void brh();
    
    public abstract void c(qwc paramqwc);
    
    public abstract void sg(String paramString);
    
    public abstract void sh(String paramString);
  }
  
  static class g
    extends pml<qvt, qrv.a>
  {
    g(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull qrv.a parama)
    {
      Object localObject = paramqvt.a(parama.mFeedId);
      if ((localObject == null) || (parama.aFd))
      {
        ram.w(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { parama.mFeedId, Boolean.valueOf(parama.aFd) });
        return;
      }
      if (!(localObject instanceof qux))
      {
        ram.e(this.TAG, "that is error type!");
        return;
      }
      localObject = (qux)localObject;
      ((CommentLikeFeedItem)((qux)localObject).c).mLikeCount = parama.mLikeCount;
      ((qux)localObject).P(parama.mLikeEntryList, true);
      qvt.a(paramqvt).sh(parama.mFeedId);
    }
    
    public Class acceptEventClass()
    {
      return qrv.a.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull qrv.a parama) {}
  }
  
  public static class h
    extends pml<qvt, psz.a>
  {
    public h(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull psz.a parama)
    {
      Object localObject = qvt.a(paramqvt);
      parama = parama.fJ;
      psz localpsz = (psz)psx.a(27);
      localObject = ((ArrayList)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        qwa localqwa = (qwa)((Iterator)localObject).next();
        if ((localqwa instanceof qwc))
        {
          pyv.a locala = (pyv.a)parama.get(localqwa.a().feedId);
          if (locala == null) {
            break label129;
          }
          ((qwc)localqwa).oi = localpsz.d(((qwc)localqwa).bS(), locala.nq);
          i = 1;
        }
      }
      label129:
      for (;;)
      {
        break;
        if (i != 0) {
          qvt.a(paramqvt).brh();
        }
        return;
      }
    }
    
    public Class acceptEventClass()
    {
      return psz.a.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull psz.a parama) {}
  }
  
  public static class i
    extends pml<qvt, qvy.a>
  {
    public i(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull qvy.a parama)
    {
      Object localObject = parama.a;
      parama = paramqvt.a(((qwa)localObject).c.feedId);
      if (parama == null)
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { ((qwa)localObject).c.feedId });
        return;
      }
      if ((!(localObject instanceof qwc)) || (!(parama instanceof qwc)))
      {
        ram.e("Q.qqstory.home.data.HomeFeedPresenter", "SingleFeedInfoEvent error!!");
        return;
      }
      localObject = (qwc)localObject;
      parama = (qwc)parama;
      parama.c = ((qwc)localObject).c;
      parama.O(((qwc)localObject).getCommentList(), false);
      parama.P(((qwc)localObject).bU(), false);
      parama.I(((qwc)localObject).bS(), false);
      qvt.a(paramqvt).sh(parama.c.feedId);
      ram.b("Q.qqstory.home.data.HomeFeedPresenter", "single feed update from server %s", parama);
    }
    
    public Class acceptEventClass()
    {
      return qvy.a.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull qvy.a parama) {}
  }
  
  public class j
    extends QQUIEventReceiver<qvt, pxz.a>
  {
    public j(@NonNull qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pxz.a parama)
    {
      if ((TextUtils.isEmpty(parama.feedId)) || (TextUtils.isEmpty(parama.vid)) || (parama.commentId == 0) || (parama.Ao == 0L))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { parama.feedId, parama.vid, Integer.valueOf(parama.commentId), Long.valueOf(parama.Ao) });
        return;
      }
      Object localObject1 = paramqvt.a(parama.feedId);
      if ((localObject1 == null) || (!(localObject1 instanceof qwc)))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { parama.feedId });
        return;
      }
      Object localObject2 = (qwc)localObject1;
      ram.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", parama.feedId, parama.vid, Integer.valueOf(parama.commentId), Integer.valueOf(parama.bll));
      localObject1 = ((qwc)localObject2).bS().iterator();
      Object localObject3;
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
          if (((StoryVideoItem)localObject3).mVid.equals(parama.vid))
          {
            localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
            if ((localObject1 != null) && (((StoryVideoItem.b)localObject1).bR.length > parama.bll)) {
              localObject1 = localObject1.bR[(parama.bll + 1)];
            }
          }
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = qsb.a(parama.feedId, parama.commentId, parama.Ao, 1, (String)localObject1);
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject1);
          ((qwc)localObject2).O((List)localObject3, false);
          localObject2 = (CommentLikeFeedItem)((qwc)localObject2).c;
          ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
          if (qvt.b((CommentLikeFeedItem)localObject2)) {
            ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
          }
          for (;;)
          {
            qvt.a(paramqvt).sh(parama.feedId);
            ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
            qvt.b((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
            return;
            if (localObject1 == null) {}
            for (int i = 0;; i = ((StoryVideoItem.b)localObject1).bR.length)
            {
              ram.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(parama.bll) });
              localObject1 = null;
              break;
            }
            ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
          }
        }
        ram.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
        return;
        localObject1 = null;
      }
    }
    
    public Class acceptEventClass()
    {
      return pxz.a.class;
    }
  }
  
  public class k
    extends QQUIEventReceiver<qvt, pya.a>
  {
    public k(@NonNull qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pya.a parama)
    {
      if ((TextUtils.isEmpty(parama.feedId)) || (TextUtils.isEmpty(parama.vid)) || (parama.commentId == 0) || (parama.Ao == 0L) || (parama.aCm < 1))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { parama.feedId, parama.vid, Integer.valueOf(parama.commentId), Long.valueOf(parama.Ao), Integer.valueOf(parama.aCm) });
        return;
      }
      Object localObject1 = paramqvt.a(parama.feedId);
      if ((localObject1 == null) || (!(localObject1 instanceof qwc)))
      {
        ram.w("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { parama.feedId });
        return;
      }
      Object localObject2 = (qwc)localObject1;
      ram.d("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { parama.feedId, parama.vid, Integer.valueOf(parama.commentId), Long.valueOf(parama.Ao), Integer.valueOf(parama.aCm) });
      localObject1 = qsb.a(parama.feedId, parama.commentId, parama.Ao, 2, String.valueOf(parama.aCm));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject1);
      ((qwc)localObject2).O(localArrayList, false);
      localObject2 = (CommentLikeFeedItem)((qwc)localObject2).c;
      ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
      if (qvt.b((CommentLikeFeedItem)localObject2)) {
        ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
      }
      for (;;)
      {
        qvt.a(paramqvt).sh(parama.feedId);
        ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
        qvt.b((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
        return;
        ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
      }
    }
    
    public Class acceptEventClass()
    {
      return pya.a.class;
    }
  }
  
  public static class l
    extends pml<qvt, pnx.d>
  {
    public l(qvt paramqvt)
    {
      super();
    }
    
    private void a(@NonNull qvt paramqvt, qwc paramqwc, boolean paramBoolean, StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
    {
      Object localObject1 = paramqwc.bS().iterator();
      int i = 0;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject2).equals(paramStoryVideoItem1))
        {
          ram.b("Q.qqstory.home.data.HomeFeedPresenter", "update new video %s", paramStoryVideoItem1);
          if (paramStoryVideoItem2 == null) {
            ((StoryVideoItem)localObject2).copy(paramStoryVideoItem1);
          }
        }
      }
      label67:
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramqwc.c(paramStoryVideoItem1, paramBoolean);
            ram.b("Q.qqstory.home.data.HomeFeedPresenter", "insert new video  %s", paramStoryVideoItem1);
            paramStoryVideoItem2 = (qvi)psx.a(12);
            localObject1 = ((VideoListFeedItem)paramqwc.c).getVideoInfo();
            ((FeedVideoInfo)localObject1).mVideoItemList.clear();
            ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramqwc.bS());
            if (!((FeedVideoInfo)localObject1).mIsVideoEnd)
            {
              ram.b("Q.qqstory.home.data.HomeFeedPresenter", "mark feed %s is video pull finish", paramqwc.c().feedId);
              ((FeedVideoInfo)localObject1).mIsVideoEnd = true;
              localObject2 = ((FeedVideoInfo)localObject1).mVideoItemList.iterator();
              while (((Iterator)localObject2).hasNext()) {
                if (!StoryVideoItem.isFakeVid(((StoryVideoItem)((Iterator)localObject2).next()).mVid)) {
                  ((FeedVideoInfo)localObject1).mIsVideoEnd = false;
                }
              }
            }
            paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
            if (QLog.isDebugVersion()) {
              ram.b("Q.qqstory.home.data.HomeFeedPresenter", "order before:%s", qvt.a(paramqvt));
            }
            int j = paramqvt.bY().size();
            i = 0;
            while (j > i)
            {
              paramStoryVideoItem2 = (qwa)qvt.a(paramqvt).get(i);
              if ((!(paramStoryVideoItem2 instanceof qvx)) || (!((HotRecommendFeedItem)((qvx)paramStoryVideoItem2).c()).mIsTopLocation)) {
                break;
              }
              i += 1;
            }
            paramqwc.a(i, paramStoryVideoItem2);
            ram.w("Q.qqstory.home.data.HomeFeedPresenter", "feed fake %s to suc:%s", new Object[] { ((StoryVideoItem)localObject2).mVid, paramStoryVideoItem2 });
            paramStoryVideoItem2 = (qvi)psx.a(12);
            localObject1 = ((VideoListFeedItem)paramqwc.c).getVideoInfo();
            ((FeedVideoInfo)localObject1).mVideoItemList.clear();
            ((FeedVideoInfo)localObject1).mVideoItemList.addAll(paramqwc.bS());
            paramStoryVideoItem2.a(0, ((FeedVideoInfo)localObject1).feedId, ((FeedVideoInfo)localObject1).mVideoSeq, ((FeedVideoInfo)localObject1).mVideoItemList, ((FeedVideoInfo)localObject1).mVideoNextCookie, ((FeedVideoInfo)localObject1).mIsVideoEnd, ((FeedVideoInfo)localObject1).mVideoPullType, true);
            break label67;
            i += 1;
            break;
          }
          qvt.a(paramqvt).remove(paramqwc);
          qvt.a(paramqvt).add(i, paramqwc);
          if (QLog.isDebugVersion()) {
            ram.b("Q.qqstory.home.data.HomeFeedPresenter", "order after:%s", qvt.a(paramqvt));
          }
          if ((paramStoryVideoItem1.mTagInfoBase != null) && ((paramqwc instanceof qvj)))
          {
            paramStoryVideoItem2 = paramqwc.oi;
            paramStoryVideoItem2.remove(paramStoryVideoItem1.mTagInfoBase);
            if (paramStoryVideoItem2.size() <= 0) {
              break label610;
            }
            paramStoryVideoItem2.add(0, paramStoryVideoItem1.mTagInfoBase);
          }
        }
        for (;;)
        {
          ram.w(this.TAG, "update tag list while publish , feedId :%s", new Object[] { paramqwc.c().feedId });
          qvt.a(paramqvt).sg(paramqwc.c.feedId);
          return;
          label610:
          paramStoryVideoItem2.add(paramStoryVideoItem1.mTagInfoBase);
        }
      }
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pnx.d paramd)
    {
      if (paramd.Iz())
      {
        ram.d(this.TAG, "group video upload");
        return;
      }
      Object localObject2;
      label33:
      Object localObject3;
      Object localObject1;
      if (paramd.my != null)
      {
        localObject2 = paramd.my.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (pnx.c)((Iterator)localObject2).next();
          if (!(((pnx.c)localObject3).b instanceof ShareGroupFeedItem))
          {
            rom.fail("fake item type error", new Object[0]);
          }
          else
          {
            localObject1 = (ShareGroupItem)((pnx.c)localObject3).b.getOwner();
            if (qvt.a(paramqvt, ((ShareGroupItem)localObject1).shareGroupId))
            {
              localObject1 = qvt.a(paramqvt, qvt.a(paramqvt), ((ShareGroupItem)localObject1).shareGroupId, ((pnx.c)localObject3).b.date);
              if (localObject1 != null) {
                break label531;
              }
              if ((((pnx.c)localObject3).b instanceof ShareGroupFeedItem))
              {
                localObject1 = new qvz((ShareGroupFeedItem)((pnx.c)localObject3).b);
                qvt.a(paramqvt).add(0, localObject1);
              }
              ram.w("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
            }
          }
        }
      }
      label531:
      for (;;)
      {
        if ((((pnx.c)localObject3).a != null) && ((localObject1 instanceof qvz))) {
          ((qwc)localObject1).c = ((pnx.c)localObject3).a;
        }
        localObject3 = ((pnx.c)localObject3).hq.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          pnx.b localb = (pnx.b)((Iterator)localObject3).next();
          a(paramqvt, (qwc)localObject1, paramd.zU, localb.b, localb.c);
        }
        break label33;
        if ((!paramd.aAU) || (!qvt.a(paramqvt))) {
          break;
        }
        if (paramd.a == null)
        {
          ram.w(this.TAG, "null pointer for feed item");
          return;
        }
        if (paramd.a.getOwner() == null)
        {
          ram.w(this.TAG, "null pointer for feed item user");
          return;
        }
        ram.b("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramd);
        ram.d("Q.qqstory.home.data.HomeFeedPresenter", "home task state write temp:" + paramd.b.hashCode());
        localObject2 = qvt.a(paramqvt, qvt.a(paramqvt), paramd.a.date);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new qvj(paramd.a);
          int j = qvt.a(paramqvt).size();
          int i = 0;
          while (j > i)
          {
            localObject2 = (qwa)qvt.a(paramqvt).get(i);
            if ((!(localObject2 instanceof qvx)) || (!((HotRecommendFeedItem)((qvx)localObject2).c()).mIsTopLocation)) {
              break;
            }
            i += 1;
          }
          qvt.a(paramqvt).add(i, localObject1);
          ram.w("Q.qqstory.home.data.HomeFeedPresenter", "create and add fake home feed %s", new Object[] { localObject1 });
        }
        if (paramd.c != null)
        {
          ((qvj)localObject1).c = paramd.a;
          ((qvj)localObject1).aFN = false;
        }
        a(paramqvt, (qwc)localObject1, paramd.zU, paramd.b, paramd.c);
        return;
      }
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull pnx.d paramd) {}
  }
  
  public static class m
    extends pml<qvt, psg>
  {
    public m(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull psg parampsg)
    {
      ram.b("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", parampsg);
      qvt.b(paramqvt, parampsg.vid);
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull psg parampsg) {}
  }
  
  public static class n
    extends pml<qvt, pxy.c>
  {
    public n(qvt paramqvt)
    {
      super();
    }
    
    public void a(@NonNull qvt paramqvt, @NonNull pxy.c paramc)
    {
      ram.b("Q.qqstory.home.data.HomeFeedPresenter", "upload status change event:%s", paramc);
      qvt.b(paramqvt, paramc.vid);
    }
    
    public Class acceptEventClass()
    {
      return pxy.c.class;
    }
    
    public void b(@NonNull qvt paramqvt, @NonNull pxy.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvt
 * JD-Core Version:    0.7.0.1
 */