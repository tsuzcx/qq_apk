import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class qsn
  implements IEventReceiver, qrn, qrs.b, qsb.a
{
  private psa jdField_a_of_type_Psa;
  private psm jdField_a_of_type_Psm;
  private qrs jdField_a_of_type_Qrs;
  private qru jdField_a_of_type_Qru;
  private qrv jdField_a_of_type_Qrv;
  private qsn.a jdField_a_of_type_Qsn$a;
  private qsn.c jdField_a_of_type_Qsn$c;
  private qsn.d jdField_a_of_type_Qsn$d;
  private qsn.e jdField_a_of_type_Qsn$e;
  private qsn.f jdField_a_of_type_Qsn$f;
  private qsn.g jdField_a_of_type_Qsn$g;
  private qsn.h jdField_a_of_type_Qsn$h;
  private qsn.i jdField_a_of_type_Qsn$i;
  private qsn.j jdField_a_of_type_Qsn$j;
  private qsn.k jdField_a_of_type_Qsn$k;
  private qsn.l jdField_a_of_type_Qsn$l;
  private qsn.m jdField_a_of_type_Qsn$m;
  private qvf jdField_a_of_type_Qvf;
  private qvi jdField_a_of_type_Qvi;
  private final StoryDetailFragment jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private qrv jdField_b_of_type_Qrv;
  private qrz jdField_b_of_type_Qrz;
  protected qsn.b b;
  private int bms = -1;
  private final int bnW;
  private qrl c;
  private qrl d;
  private final String mFeedId;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  private final int mSource;
  
  public qsn(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.mFeedId = paramString;
    this.mSource = paramInt1;
    this.bnW = paramInt2;
    this.jdField_b_of_type_Qsn$b = new qsn.b(this.mFeedId, new qso(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    pqs localpqs;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localpqs = new pqs(2, paramCommentEntry.feedId, paramInt);
      localpqs.commentId = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localpqs;; paramCommentEntry = new pqs(2, this.jdField_a_of_type_Qru.d.feedId, paramInt, this.jdField_a_of_type_Qru.d))
    {
      paramCommentEntry.c = this.jdField_a_of_type_Qru.d;
      pmi.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(qru paramqru)
  {
    if (paramqru == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramqru.Kl()) {
          break label39;
        }
        if (!paramqru.Km()) {
          break;
        }
      } while (this.bms != -1);
      this.bms = 1;
      return;
      this.bms = 1;
      return;
    } while (this.bms == -1);
    this.bms = -1;
  }
  
  private static void a(@NonNull qsn paramqsn, @NonNull String paramString1, String paramString2)
  {
    if (paramqsn.jdField_a_of_type_Qru == null) {
      ram.d(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      ram.b(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramqsn.jdField_a_of_type_Qru.bS().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramqsn.jdField_a_of_type_Qru.bS().remove(localStoryVideoItem);
      ram.b(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramqsn.jdField_a_of_type_Qru.bS().size()));
      if (paramqsn.jdField_a_of_type_Qru.bS().size() == 0) {
        paramqsn.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.bqg();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramqsn.bql();
        return;
        paramqsn.azy();
      }
    }
    ram.w(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramqsn.jdField_a_of_type_Qru.bS().size()) });
  }
  
  private void ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = QQStoryContext.a().getCurrentUid();
    String str = qem.getQQAppInterface().getCurrentUin();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.mFeedId;
    localObject = ((ptf)psx.a(2)).b((String)localObject);
    long l;
    if (localObject != null)
    {
      if (((QQUserUIItem)localObject).isVip)
      {
        l = 2L;
        localLikeEntry.role = l;
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label260;
      }
      this.jdField_a_of_type_Qru.d.mHadLike = 1;
      this.jdField_a_of_type_Qru.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qru.d);
      this.jdField_a_of_type_Psm.a(localLikeEntry);
    }
    for (;;)
    {
      ram.d("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Qru.d.mHadLike), Integer.valueOf(this.jdField_a_of_type_Qru.d.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Qru.s(true)), Integer.valueOf(this.jdField_a_of_type_Qru.i(true).size()), Integer.valueOf(this.jdField_a_of_type_Qru.s(false)), Integer.valueOf(this.jdField_a_of_type_Qru.i(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Qru.d.mHadLike = 0;
      this.jdField_a_of_type_Qru.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qru.d);
      this.jdField_a_of_type_Psm.b(localLikeEntry);
    }
  }
  
  private void b(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qru.d(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Qru.d = ((CommentLikeFeedItem)this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qru.d));
    this.jdField_a_of_type_Psa.e(paramCommentEntry);
    pqy.a().bmw();
    QQToast.a(BaseApplication.getContext(), 2, acfp.m(2131714827), 0).show();
    a(this.jdField_a_of_type_Qru);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Qru, isOpen());
    a(2, paramCommentEntry);
  }
  
  private void bqi()
  {
    if (!this.jdField_a_of_type_Qru.Kl())
    {
      wy(-1);
      this.jdField_a_of_type_Qrv.tj(true);
      return;
    }
    wy(1);
    this.jdField_b_of_type_Qrv.tj(true);
    wy(2);
    this.jdField_a_of_type_Qrv.tj(true);
  }
  
  private void bqj()
  {
    if (!this.jdField_a_of_type_Qru.Kl()) {
      if (this.jdField_a_of_type_Qru.Y(true))
      {
        wz(-1);
        this.c.aPh();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Qru.Y(false))
      {
        wz(1);
        this.d.aPh();
      }
    } while (!this.jdField_a_of_type_Qru.Y(true));
    wz(2);
    this.c.aPh();
  }
  
  private void bql()
  {
    if (TextUtils.isEmpty(this.mFeedId))
    {
      ram.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    ram.d("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    psz localpsz = (psz)psx.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mFeedId);
    localpsz.ea(localArrayList);
  }
  
  private void bqm()
  {
    List localList = ((psz)psx.a(27)).c(this.jdField_a_of_type_Qru.d.feedId, this.jdField_a_of_type_Qru.bS());
    this.jdField_a_of_type_Qru.J(localList, true);
    ram.d("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Qru.bT());
  }
  
  private void bqn()
  {
    if (this.c != null) {
      this.c.rT(this.jdField_a_of_type_Qru.j(true));
    }
    if (this.d != null) {
      this.d.rT(this.jdField_a_of_type_Qru.j(false));
    }
    if (this.jdField_b_of_type_Qrz != null)
    {
      if (!this.jdField_a_of_type_Qru.Kn()) {
        ram.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Qru.b().getVideoInfo();
    this.jdField_b_of_type_Qrz.m(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  private void e(qru paramqru)
  {
    String str1 = "";
    int i;
    switch (this.mSource)
    {
    default: 
      i = rar.a(paramqru.d);
      if (!paramqru.d.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      rar.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramqru.d.feedId });
      return;
      str1 = "1";
      break;
      str1 = "2";
      break;
      str1 = "3";
      break;
      str1 = "4";
      break;
    }
  }
  
  private boolean isOpen()
  {
    return (this.bms == -1) || (this.bms == 2);
  }
  
  private void report(String paramString)
  {
    int i = rar.b(this.jdField_a_of_type_Qru.d);
    if ((this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Qru.d.getOwner().getUnionId();; str = "")
    {
      rar.a("home_page", paramString, rar.a(this.jdField_a_of_type_Qru.d), 0, new String[] { String.valueOf(i), rar.bX(this.mSource), this.jdField_a_of_type_Qru.d.feedId, str });
      return;
    }
  }
  
  private void wy(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Qrv != null);
        this.jdField_a_of_type_Qrv = new qrv(this.mFeedId, true);
        return;
      } while (this.jdField_b_of_type_Qrv != null);
      this.jdField_b_of_type_Qrv = new qrv(this.mFeedId, true, 0);
      return;
    } while (this.jdField_a_of_type_Qrv != null);
    this.jdField_a_of_type_Qrv = new qrv(this.mFeedId, true, 1);
  }
  
  private void wz(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.c != null);
        this.c = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(true)), "StoryDetailPresenter");
        return;
      } while (this.d != null);
      this.d = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(false), 0), "StoryDetailPresenter");
      return;
    } while (this.c != null);
    this.c = new qrl(new qvc(this.mFeedId, 2, this.jdField_a_of_type_Qru.j(true), 1), "StoryDetailPresenter");
  }
  
  public void a(qru paramqru, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.mIsDestroy.get())
    {
      ram.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramqru);
    if ((this.jdField_a_of_type_Qru == null) && (paramErrorMessage.isSuccess())) {
      e(paramqru);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Qru = paramqru;
        this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Qru, isOpen());
      }
      refreshData(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramqru = this.jdField_a_of_type_Qru.toString();; paramqru = "null")
    {
      ram.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramqru);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Qru = paramqru;
        bqm();
        if ((this.jdField_a_of_type_Qru.Ko()) && (!this.jdField_a_of_type_Qru.b().mIsVideoEnd)) {
          bql();
        }
        bqn();
        this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Qru, isOpen());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.aq(bool, this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramqru, isOpen()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.bqg();
        } else if (this.jdField_a_of_type_Qru == null) {
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.bqg();
        }
      }
    }
  }
  
  public void aM(int paramInt, String paramString)
  {
    ram.b("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    ppf.f(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
    if (paramInt == 1) {}
    for (paramString = "clk_reply_nick";; paramString = "clk_like_name")
    {
      report(paramString);
      return;
    }
  }
  
  public void azy()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.azy();
  }
  
  public void bmr()
  {
    ram.d("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!aqiw.isNetSupport(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131714826), 0).show();
      return;
    }
    if (((this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Qru.d.getOwner()).isPublic()) && (!this.jdField_a_of_type_Qru.d.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, ppf.getString(2131701932), 0).show();
      return;
    }
    if (this.jdField_a_of_type_Qru.d.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = isOpen();
      pqt.a(this.jdField_a_of_type_Qru.d, bool1, -1, 0);
      ar(bool1, bool2);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.azy();
      a(3, null);
      report("clk_like");
      return;
    }
  }
  
  public void boq()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.bqh();
  }
  
  public void bor()
  {
    rsn localrsn = this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localrsn != null) {
      localrsn.uh(false);
    }
  }
  
  public void bos()
  {
    rsn localrsn = this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localrsn != null)
    {
      if (this.jdField_a_of_type_Qru.Y(isOpen())) {
        localrsn.uh(false);
      }
    }
    else {
      return;
    }
    localrsn.uh(true);
  }
  
  public void bpV()
  {
    ram.i("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_b_of_type_Qrz == null)
    {
      if (!this.jdField_a_of_type_Qru.Kn())
      {
        ram.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_b_of_type_Qrz = new qrz(2, this.jdField_a_of_type_Qru.b().getVideoInfo());
      this.jdField_b_of_type_Qrz.rV("StoryDetailPresenter");
    }
    this.jdField_b_of_type_Qrz.aPh();
  }
  
  public void bpW()
  {
    ram.i("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    wz(this.bms);
    if (isOpen()) {
      this.c.aPh();
    }
    for (;;)
    {
      rar.a("home_page", "load_detail", 0, 0, new String[] { "", rar.bX(this.mSource), "", this.mFeedId });
      return;
      this.d.aPh();
    }
  }
  
  public void bpX()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Qsb.bpX();
  }
  
  public void bqk()
  {
    if (!TextUtils.isEmpty(this.mFeedId)) {
      pxk.ei(Collections.singletonList(this.mFeedId));
    }
  }
  
  public void c(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Qsb == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Qsb.c(paramCommentEntry, paramInt, sO());
  }
  
  public void create()
  {
    this.jdField_a_of_type_Qsn$e = new qsn.e(this);
    pmi.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Qsn$e);
    this.jdField_a_of_type_Qsn$i = new qsn.i(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$i);
    this.jdField_a_of_type_Qsn$a = new qsn.a(this);
    pmi.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Qsn$a);
    this.jdField_a_of_type_Qsn$c = new qsn.c(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$c);
    this.jdField_a_of_type_Qsn$k = new qsn.k(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$k);
    this.jdField_a_of_type_Qsn$l = new qsn.l(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$l);
    this.jdField_a_of_type_Qsn$m = new qsn.m(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$m);
    this.jdField_a_of_type_Qsn$f = new qsn.f(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$f);
    this.jdField_a_of_type_Qsn$d = new qsn.d(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$d);
    this.jdField_a_of_type_Qsn$h = new qsn.h(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$h);
    this.jdField_a_of_type_Qsn$j = new qsn.j(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$j);
    this.jdField_a_of_type_Qsn$g = new qsn.g(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qsn$g);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_b_of_type_Qsn$b);
    this.jdField_a_of_type_Qrs = new qrs(this.mFeedId, this, true);
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
    this.jdField_a_of_type_Psm = ((psm)psx.a(15));
    this.jdField_a_of_type_Psa = ((psa)psx.a(17));
    this.jdField_a_of_type_Qvi = ((qvi)psx.a(12));
  }
  
  public void d(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Qsb == null) {
      return;
    }
    if ((this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.d != null)) {
      if (!this.jdField_a_of_type_Qru.d.getOwner().isMe()) {
        break label96;
      }
    }
    label96:
    for (String str = "2";; str = "1")
    {
      rar.a("home_page", "press_reply", 0, 0, new String[] { str, rar.bX(this.mSource) });
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Qsb.b(paramCommentEntry, paramInt, sO());
      return;
    }
  }
  
  public void destroy()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$e);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$i);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$c);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$k);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$l);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$m);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$f);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$d);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$h);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$j);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qsn$g);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_b_of_type_Qsn$b);
    this.mIsDestroy.set(true);
    this.jdField_a_of_type_Qrv = null;
    this.jdField_b_of_type_Qrv = null;
    if (this.jdField_a_of_type_Qrs != null) {
      this.jdField_a_of_type_Qrs.terminate();
    }
    if (this.jdField_b_of_type_Qrz != null) {
      this.jdField_b_of_type_Qrz.terminate();
    }
    if (this.c != null) {
      this.c.terminate();
    }
    if (this.d != null) {
      this.d.terminate();
    }
  }
  
  public void f(CommentEntry paramCommentEntry)
  {
    boolean bool = isOpen();
    if ((!this.jdField_a_of_type_Qru.Y(bool)) && (this.jdField_a_of_type_Qru.a(bool) == null))
    {
      CommentEntry localCommentEntry = qsb.b(this.jdField_a_of_type_Qru.r(bool) - this.jdField_a_of_type_Qru.h(bool).size());
      this.jdField_a_of_type_Qru.e(localCommentEntry, bool);
      this.jdField_a_of_type_Qru.c(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Qru.c(paramCommentEntry, bool);
    ram.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Qru.d.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Qru.d.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Qru.d.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Qru.d.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131714830), 0).show();
        paramCommentEntry.status = 2;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.azy();
      boq();
      this.jdField_a_of_type_Qru.d = ((CommentLikeFeedItem)this.jdField_a_of_type_Qvf.a(this.jdField_a_of_type_Qru.d));
      if (!this.jdField_a_of_type_Qru.Kl()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Psa.b(paramCommentEntry);
    }
    for (;;)
    {
      if (i == 0) {
        g(paramCommentEntry);
      }
      return;
      i = 0;
      break;
      label256:
      paramCommentEntry.type = 3;
      paramCommentEntry.pbType = 0;
      break label233;
      label269:
      paramCommentEntry.pbType = this.jdField_a_of_type_Qru.d.getCommentLikeType();
      this.jdField_a_of_type_Psa.c(paramCommentEntry);
    }
  }
  
  public void g(CommentEntry paramCommentEntry)
  {
    pqj.a(this.jdField_a_of_type_Qru.d, paramCommentEntry, false, this.mSource, new qsp(this));
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void refreshData(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qrs.bpY();
      return;
    }
    this.jdField_a_of_type_Qrs.bpZ();
  }
  
  public int sO()
  {
    return this.bms;
  }
  
  public void setTabType(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      ram.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    ram.b("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.bms = paramInt;
  }
  
  public void tn(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.azy();
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.aq(paramBoolean, this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Qru, isOpen()));
  }
  
  public void wk(int paramInt)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.wx(paramInt);
  }
  
  public void wl(int paramInt)
  {
    boolean bool = isOpen();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Qru.h(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      b(localCommentEntry, bool);
      return;
    }
    if (!aqiw.isNetSupport(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131714829), 0).show();
      ram.w("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    pqf.a(localCommentEntry, new qsq(this, localCommentEntry, bool));
  }
  
  public void wu(int paramInt)
  {
    ram.b("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.bms = paramInt;
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c(this.jdField_a_of_type_Qru, isOpen());
    if (isOpen()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      rar.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", rar.bX(this.mSource), this.jdField_a_of_type_Qru.d.feedId });
      return;
    }
  }
  
  static class a
    extends pml<qsn, qrl.b>
  {
    a(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull qrl.b paramb)
    {
      if ((!paramb.mFeedId.equals(qsn.a(paramqsn))) || (paramb.b.isFail()) || (qsn.a(paramqsn) == null)) {
        ram.d(this.TAG, "ignore this comment list event. %s.", paramb.toString());
      }
      boolean bool2;
      boolean bool1;
      do
      {
        return;
        ram.b(this.TAG, "receive comment list event. %s.", paramb.toString());
        bool2 = qsn.a(paramqsn);
        bool1 = true;
        if (paramb.mType == 0) {
          bool1 = false;
        }
        qsn.a(paramqsn).ti(bool1);
        qsn.a(paramqsn).ac(bool1, paramb.mTotalCount);
        qsn.a(paramqsn).ap(bool1, paramb.isEnd);
        qsn.a(paramqsn).d(paramb.nh, paramb.isFirstPage, bool1);
      } while (bool2 != bool1);
      paramqsn.tn(paramb.b.isSuccess());
    }
    
    public Class acceptEventClass()
    {
      return qrl.b.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull qrl.b paramb) {}
  }
  
  public static class b
    extends pmd
  {
    private qsn.b.a a;
    public String mFeedId;
    
    public b(String paramString, @NonNull qsn.b.a parama)
    {
      this.mFeedId = paramString;
      this.a = parama;
    }
    
    public void b(StoryPushMsg paramStoryPushMsg)
    {
      if (!TextUtils.equals(this.mFeedId, paramStoryPushMsg.mFeedId))
      {
        ram.b("DetailFeedPushObserver", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.mFeedId, this.mFeedId);
        return;
      }
      if ((paramStoryPushMsg.type == 15) || (paramStoryPushMsg.type == 19))
      {
        ram.b("DetailFeedPushObserver", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
        this.a.wm(1);
        return;
      }
      if ((paramStoryPushMsg.type == 14) || (paramStoryPushMsg.type == 16) || (paramStoryPushMsg.type == 18))
      {
        ram.b("DetailFeedPushObserver", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
        this.a.wm(2);
        return;
      }
      this.a.wm(0);
    }
    
    public static abstract interface a
    {
      public abstract void wm(int paramInt);
    }
  }
  
  public static class c
    extends pml<qsn, pqs>
  {
    public c(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull pqs parampqs)
    {
      if ((parampqs.bjU == 2) || (!parampqs.feedId.equals(qsn.a(paramqsn))) || (qsn.a(paramqsn) == null))
      {
        ram.d(this.TAG, "ignore this feed info change event. %s.", parampqs.toString());
        return;
      }
      ram.b(this.TAG, "receive feed info change event. %s.", parampqs.toString());
      switch (parampqs.what)
      {
      default: 
        return;
      case 1: 
        if (parampqs.c != null)
        {
          qsn.a(paramqsn).d.mCommentCount = parampqs.c.mCommentCount;
          qsn.a(paramqsn).d.mFriendCommentCount = parampqs.c.mFriendCommentCount;
          qsn.a(paramqsn).d.mFanCommentCount = parampqs.c.mFanCommentCount;
        }
        localObject = (psa)psx.a(17);
        localList = ((psa)localObject).a(parampqs.feedId, true);
        qsn.a(paramqsn).d(localList, true, true);
        if (qsn.a(paramqsn).Kl())
        {
          parampqs = ((psa)localObject).a(parampqs.feedId, false);
          qsn.a(paramqsn).d(parampqs, true, false);
        }
        paramqsn.azy();
        return;
      case 2: 
        if (parampqs.c != null)
        {
          qsn.a(paramqsn).d.mCommentCount = parampqs.c.mCommentCount;
          qsn.a(paramqsn).d.mFriendCommentCount = parampqs.c.mFriendCommentCount;
          qsn.a(paramqsn).d.mFanCommentCount = parampqs.c.mFanCommentCount;
        }
        qsn.a(paramqsn).wv(parampqs.commentId);
        paramqsn.azy();
        return;
      }
      if (parampqs.c != null)
      {
        qsn.a(paramqsn).d.mHadLike = parampqs.c.mHadLike;
        qsn.a(paramqsn).d.mLikeCount = parampqs.c.mLikeCount;
        qsn.a(paramqsn).d.mFriendLikeCount = parampqs.c.mFriendLikeCount;
        qsn.a(paramqsn).d.mFanLikeCount = parampqs.c.mFanLikeCount;
      }
      Object localObject = (psm)psx.a(15);
      List localList = ((psm)localObject).c(parampqs.feedId, true);
      qsn.a(paramqsn).e(localList, true, true);
      if (qsn.a(paramqsn).Kl())
      {
        parampqs = ((psm)localObject).c(parampqs.feedId, false);
        qsn.a(paramqsn).e(parampqs, true, false);
      }
      paramqsn.azy();
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull pqs parampqs) {}
  }
  
  public static class d
    extends pml<qsn, qvi.a>
  {
    public d(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull qvi.a parama)
    {
      if ((parama.bnP == 2) || (!parama.mFeedId.equals(qsn.a(paramqsn))) || (qsn.a(paramqsn) == null))
      {
        ram.d(this.TAG, "ignore this video cookie change event. %s.", parama.toString());
        return;
      }
      if (!qsn.a(paramqsn).Kn())
      {
        ram.e(this.TAG, "this feed does not support video list. ignore this video cookie change event. %s.", new Object[] { parama.toString() });
        return;
      }
      parama = qsn.a(paramqsn).a(qsn.a(paramqsn), qsn.a(paramqsn).b().mVideoPullType);
      if (parama == null)
      {
        ram.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { qsn.a(paramqsn), Integer.valueOf(qsn.a(paramqsn).b().mVideoPullType) });
        return;
      }
      ram.b(this.TAG, "receive video cookie change event. %s.", parama.toString());
      qsn.a(paramqsn).b().updateVideoInfo(parama);
      qsn.a(paramqsn).I(parama.mVideoItemList, true);
      if (qsn.a(paramqsn) != null) {
        qsn.a(paramqsn).m(parama.mVideoPullType, parama.mVideoNextCookie, parama.mVideoSeq);
      }
      qsn.a(paramqsn).azy();
    }
    
    public Class acceptEventClass()
    {
      return qvi.a.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull qvi.a parama) {}
  }
  
  static class e
    extends pml<qsn, qrz.b>
  {
    e(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull qrz.b paramb)
    {
      if ((!paramb.mFeedId.equals(qsn.a(paramqsn))) || (paramb.b.isFail()) || (qsn.a(paramqsn) == null))
      {
        ram.d(this.TAG, "ignore this comment list event. %s.", paramb.toString());
        return;
      }
      if (!qsn.a(paramqsn).Kn())
      {
        ram.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramb.toString() });
        return;
      }
      ram.b(this.TAG, "receive comment list event. %s.", paramb.toString());
      qsn.a(paramqsn).I(paramb.oj, paramb.isFirstPage);
      qsn.a(paramqsn).b().updateVideoInfo(paramb.a);
      if (qsn.a(paramqsn).bS().size() < 1)
      {
        qsn.a(paramqsn).bqg();
        return;
      }
      paramqsn.azy();
    }
    
    public Class acceptEventClass()
    {
      return qrz.b.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull qrz.b paramb) {}
  }
  
  public static final class f
    extends QQUIEventReceiver<qsn, pxk.a>
  {
    public f(@NonNull qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull pxk.a parama)
    {
      if (qsn.a(paramqsn) == null) {
        ram.d(this.TAG, "ignore this feature event. %s.", parama.toString());
      }
      ptp localptp;
      do
      {
        return;
        while (!parama.hasNext())
        {
          do
          {
            ram.b(this.TAG, "receive feature event. %s.", parama.toString());
          } while (parama.mO == null);
          parama = parama.mO.iterator();
        }
        localptp = (ptp)parama.next();
      } while (!localptp.feedId.equals(qsn.a(paramqsn)));
      ram.b(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(qsn.a(paramqsn).d.mViewTotalTime), Integer.valueOf(localptp.bkm));
      qsn.a(paramqsn).d.mViewTotalTime = localptp.bkm;
      paramqsn.azy();
    }
    
    public Class acceptEventClass()
    {
      return pxk.a.class;
    }
  }
  
  public static final class g
    extends QQUIEventReceiver<qsn, psz.a>
  {
    public g(@NonNull qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull psz.a parama)
    {
      if (qsn.a(paramqsn) == null) {
        ram.d("Q.qqstory.detail.StoryDetailPresenter", "ignore this tag info event. %s.", parama.toString());
      }
      do
      {
        do
        {
          return;
        } while (!parama.b.isSuccess());
        ram.b("Q.qqstory.detail.StoryDetailPresenter", "receive tag info event. %s.", parama.toString());
        parama = (pyv.a)parama.fJ.get(qsn.a(paramqsn));
      } while (parama == null);
      parama = ((psz)psx.a(27)).d(qsn.a(paramqsn).bS(), parama.nq);
      qsn.a(paramqsn).J(parama, true);
      paramqsn.azy();
    }
    
    public Class acceptEventClass()
    {
      return psz.a.class;
    }
  }
  
  public static class h
    extends QQUIEventReceiver<qsn, pxs.b>
  {
    public h(@NonNull qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull pxs.b paramb)
    {
      if (qsn.a(paramqsn) == null)
      {
        ram.d(this.TAG, "ignore this user info event. %s.", paramb.toString());
        return;
      }
      ram.b(this.TAG, "receive user info event. %s.", paramb.toString());
      qsn.a(paramqsn).azy();
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  static class i
    extends pml<qsn, qrv.a>
  {
    i(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull qrv.a parama)
    {
      if ((!parama.aFd) || (!parama.mFeedId.equals(qsn.a(paramqsn))) || (parama.b.isFail()) || (qsn.a(paramqsn) == null))
      {
        ram.d(this.TAG, "ignore this like list event. %s.", parama.toString());
        return;
      }
      ram.b(this.TAG, "receive like list event. %s.", parama.toString());
      boolean bool2 = qsn.a(paramqsn);
      if (parama.mType == 0) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        qsn.a(paramqsn).ad(bool1, parama.mLikeCount);
        qsn.a(paramqsn).e(parama.mLikeEntryList, true, bool1);
        if (bool2 != bool1) {
          break;
        }
        paramqsn.azy();
        return;
      }
    }
    
    public Class acceptEventClass()
    {
      return qrv.a.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull qrv.a parama) {}
  }
  
  public static class j
    extends QQUIEventReceiver<qsn, ptc.a>
  {
    public j(@NonNull qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull ptc.a parama)
    {
      if (qsn.a(paramqsn) == null)
      {
        ram.d(this.TAG, "ignore this troop nick name change event. %s.", parama.toString());
        return;
      }
      ram.b(this.TAG, "receive troop nick name change event. %s.", parama.toString());
      qsn.a(paramqsn).azy();
    }
    
    public Class acceptEventClass()
    {
      return ptc.a.class;
    }
  }
  
  public static class k
    extends pml<qsn, pnx.d>
  {
    public k(qsn paramqsn)
    {
      super();
    }
    
    private void b(@NonNull qsn paramqsn, @NonNull pnx.d paramd)
    {
      if ((qsn.a(paramqsn) == null) || (!qsn.a(paramqsn).d.date.equals(paramd.a.date)))
      {
        ram.d(this.TAG, "ignore this upload status event. %s.", paramd.toString());
        return;
      }
      ram.b(this.TAG, "receive upload status change event. %s.", paramd.toString());
      int i = 0;
      for (;;)
      {
        StoryVideoItem localStoryVideoItem;
        if (i < qsn.a(paramqsn).bS().size())
        {
          localStoryVideoItem = (StoryVideoItem)qsn.a(paramqsn).bS().get(i);
          if (!localStoryVideoItem.equals(paramd.b)) {
            break label159;
          }
          if (paramd.c != null) {
            break label135;
          }
          localStoryVideoItem.copy(paramd.b);
        }
        for (;;)
        {
          paramqsn.azy();
          ram.w(this.TAG, "can't find the video whose state has been changed.");
          return;
          label135:
          qsn.a(paramqsn).o(localStoryVideoItem);
          qsn.a(paramqsn).a(paramd.c, i);
        }
        label159:
        i += 1;
      }
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull pnx.d paramd)
    {
      if (paramd.Iz()) {
        ram.d(this.TAG, "ignore this upload status event, because it's a troop video.");
      }
      do
      {
        return;
        if (paramd.IB())
        {
          ram.b(this.TAG, "receive share group video upload status change event. %s.", paramd.toString());
          return;
        }
      } while (!paramd.IA());
      ram.b(this.TAG, "receive personal video upload status change event. %s.", paramd.toString());
      b(paramqsn, paramd);
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
    
    public void c(@NonNull qsn paramqsn, @NonNull pnx.d paramd) {}
  }
  
  public static class l
    extends pml<qsn, psg>
  {
    public l(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull psg parampsg)
    {
      qsn.b(paramqsn, parampsg.vid, this.TAG);
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull psg parampsg) {}
  }
  
  public static class m
    extends pml<qsn, pxy.c>
  {
    public m(qsn paramqsn)
    {
      super();
    }
    
    public void a(@NonNull qsn paramqsn, @NonNull pxy.c paramc)
    {
      qsn.b(paramqsn, paramc.vid, this.TAG);
    }
    
    public Class acceptEventClass()
    {
      return pxy.c.class;
    }
    
    public void b(@NonNull qsn paramqsn, @NonNull pxy.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsn
 * JD-Core Version:    0.7.0.1
 */