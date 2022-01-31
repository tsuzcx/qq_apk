import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class uec
  implements IEventReceiver, ucg, ucu, udp
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private spd jdField_a_of_type_Spd;
  private sps jdField_a_of_type_Sps;
  private ucc jdField_a_of_type_Ucc;
  private ucr jdField_a_of_type_Ucr;
  private ucw jdField_a_of_type_Ucw;
  private ucy jdField_a_of_type_Ucy;
  private udh jdField_a_of_type_Udh;
  private ueg jdField_a_of_type_Ueg;
  protected ueh a;
  private uej jdField_a_of_type_Uej;
  private uek jdField_a_of_type_Uek;
  private uel jdField_a_of_type_Uel;
  private uem jdField_a_of_type_Uem;
  private uen jdField_a_of_type_Uen;
  private ueo jdField_a_of_type_Ueo;
  private uep jdField_a_of_type_Uep;
  private ueq jdField_a_of_type_Ueq;
  private uer jdField_a_of_type_Uer;
  private ues jdField_a_of_type_Ues;
  private uet jdField_a_of_type_Uet;
  private uje jdField_a_of_type_Uje;
  private ujk jdField_a_of_type_Ujk;
  private final int jdField_b_of_type_Int;
  private ucc jdField_b_of_type_Ucc;
  private ucy jdField_b_of_type_Ucy;
  private int c = -1;
  
  public uec(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ueh = new ueh(this.jdField_a_of_type_JavaLangString, new ued(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    snl localsnl;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localsnl = new snl(2, paramCommentEntry.feedId, paramInt);
      localsnl.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localsnl;; paramCommentEntry = new snl(2, this.jdField_a_of_type_Ucw.a.feedId, paramInt, this.jdField_a_of_type_Ucw.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Ucw.a;
      sgi.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ucw.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ucw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Ucw.a));
    this.jdField_a_of_type_Spd.d(paramCommentEntry);
    snv.a().a();
    bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131648617), 0).a();
    a(this.jdField_a_of_type_Ucw);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ucw, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = urp.b(this.jdField_a_of_type_Ucw.a);
    if ((this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Ucw.a.getOwner().getUnionId();; str = "")
    {
      urp.a("home_page", paramString, urp.a(this.jdField_a_of_type_Ucw.a), 0, new String[] { String.valueOf(i), urp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ucw.a.feedId, str });
      return;
    }
  }
  
  private void a(ucw paramucw)
  {
    if (paramucw == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramucw.a()) {
          break label39;
        }
        if (!paramucw.b()) {
          break;
        }
      } while (this.c != -1);
      this.c = 1;
      return;
      this.c = 1;
      return;
    } while (this.c == -1);
    this.c = -1;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = QQStoryContext.a().b();
    String str = tfy.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((sqs)sqg.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Ucw.a.mHadLike = 1;
      this.jdField_a_of_type_Ucw.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Ucw.a);
      this.jdField_a_of_type_Sps.a(localLikeEntry);
    }
    for (;;)
    {
      urk.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ucw.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Ucw.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Ucw.b(true)), Integer.valueOf(this.jdField_a_of_type_Ucw.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Ucw.b(false)), Integer.valueOf(this.jdField_a_of_type_Ucw.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Ucw.a.mHadLike = 0;
      this.jdField_a_of_type_Ucw.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Ucw.a);
      this.jdField_a_of_type_Sps.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(ucw paramucw)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = urp.a(paramucw.a);
      if (!paramucw.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      urp.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramucw.a.feedId });
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
  
  private static void b(@NonNull uec paramuec, @NonNull String paramString1, String paramString2)
  {
    if (paramuec.jdField_a_of_type_Ucw == null) {
      urk.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      urk.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramuec.jdField_a_of_type_Ucw.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramuec.jdField_a_of_type_Ucw.a().remove(localStoryVideoItem);
      urk.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramuec.jdField_a_of_type_Ucw.a().size()));
      if (paramuec.jdField_a_of_type_Ucw.a().size() == 0) {
        paramuec.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramuec.k();
        return;
        paramuec.a();
      }
    }
    urk.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramuec.jdField_a_of_type_Ucw.a().size()) });
  }
  
  private void d(int paramInt)
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
        } while (this.jdField_a_of_type_Ucy != null);
        this.jdField_a_of_type_Ucy = new ucy(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Ucy != null);
      this.jdField_b_of_type_Ucy = new ucy(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Ucy != null);
    this.jdField_a_of_type_Ucy = new ucy(this.jdField_a_of_type_JavaLangString, true, 1);
  }
  
  private void e(int paramInt)
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
        } while (this.jdField_a_of_type_Ucc != null);
        this.jdField_a_of_type_Ucc = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Ucc != null);
      this.jdField_b_of_type_Ucc = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Ucc != null);
    this.jdField_a_of_type_Ucc = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Ucw.a())
    {
      d(-1);
      this.jdField_a_of_type_Ucy.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Ucy.a(true);
    d(2);
    this.jdField_a_of_type_Ucy.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Ucw.a()) {
      if (this.jdField_a_of_type_Ucw.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Ucc.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ucw.a(false))
      {
        e(1);
        this.jdField_b_of_type_Ucc.c();
      }
    } while (!this.jdField_a_of_type_Ucw.a(true));
    e(2);
    this.jdField_a_of_type_Ucc.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      urk.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    urk.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    sqj localsqj = (sqj)sqg.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localsqj.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((sqj)sqg.a(27)).a(this.jdField_a_of_type_Ucw.a.feedId, this.jdField_a_of_type_Ucw.a());
    this.jdField_a_of_type_Ucw.b(localList, true);
    urk.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Ucw.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Ucc != null) {
      this.jdField_a_of_type_Ucc.b(this.jdField_a_of_type_Ucw.a(true));
    }
    if (this.jdField_b_of_type_Ucc != null) {
      this.jdField_b_of_type_Ucc.b(this.jdField_a_of_type_Ucw.a(false));
    }
    if (this.jdField_a_of_type_Udh != null)
    {
      if (!this.jdField_a_of_type_Ucw.c()) {
        urk.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Ucw.a().getVideoInfo();
    this.jdField_a_of_type_Udh.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void N_()
  {
    urk.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Ucc.c();
    }
    for (;;)
    {
      urp.a("home_page", "load_detail", 0, 0, new String[] { "", urp.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Ucc.c();
    }
  }
  
  public void O_()
  {
    urk.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131648616), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Ucw.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Ucw.a.getOwner().isSubscribe()))
    {
      bbmy.a(BaseApplication.getContext(), 1, skt.a(2131633892), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Ucw.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      snm.a(this.jdField_a_of_type_Ucw.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void P_()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.e();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
  }
  
  public void a(int paramInt)
  {
    urk.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Ucw, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      urp.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", urp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ucw.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    urk.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    skt.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
    if (paramInt == 1) {}
    for (paramString = "clk_reply_nick";; paramString = "clk_like_name")
    {
      a(paramString);
      return;
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    boolean bool = a();
    if ((!this.jdField_a_of_type_Ucw.a(bool)) && (this.jdField_a_of_type_Ucw.a(bool) == null))
    {
      CommentEntry localCommentEntry = udl.a(this.jdField_a_of_type_Ucw.a(bool) - this.jdField_a_of_type_Ucw.a(bool).size());
      this.jdField_a_of_type_Ucw.c(localCommentEntry, bool);
      this.jdField_a_of_type_Ucw.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Ucw.a(paramCommentEntry, bool);
    urk.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Ucw.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Ucw.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Ucw.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Ucw.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131648620), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      P_();
      this.jdField_a_of_type_Ucw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Ucw.a));
      if (!this.jdField_a_of_type_Ucw.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Spd.a(paramCommentEntry);
    }
    for (;;)
    {
      if (i == 0) {
        b(paramCommentEntry);
      }
      return;
      i = 0;
      break;
      label256:
      paramCommentEntry.type = 3;
      paramCommentEntry.pbType = 0;
      break label233;
      label269:
      paramCommentEntry.pbType = this.jdField_a_of_type_Ucw.a.getCommentLikeType();
      this.jdField_a_of_type_Spd.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Udl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Udl.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(ucw paramucw, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      urk.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramucw);
    if ((this.jdField_a_of_type_Ucw == null) && (paramErrorMessage.isSuccess())) {
      b(paramucw);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ucw = paramucw;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ucw, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramucw = this.jdField_a_of_type_Ucw.toString();; paramucw = "null")
    {
      urk.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramucw);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ucw = paramucw;
        l();
        if ((this.jdField_a_of_type_Ucw.d()) && (!this.jdField_a_of_type_Ucw.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ucw, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramucw, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Ucw == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ucr.a();
      return;
    }
    this.jdField_a_of_type_Ucr.b();
  }
  
  public void b()
  {
    urk.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Udh == null)
    {
      if (!this.jdField_a_of_type_Ucw.c())
      {
        urk.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Udh = new udh(2, this.jdField_a_of_type_Ucw.a().getVideoInfo());
      this.jdField_a_of_type_Udh.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Udh.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ucw.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131648619), 0).a();
      urk.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    sml.a(localCommentEntry, new uef(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    smz.a(this.jdField_a_of_type_Ucw.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new uee(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Udl == null) {
      return;
    }
    if ((this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.a != null)) {
      if (!this.jdField_a_of_type_Ucw.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      urp.a("home_page", "press_reply", 0, 0, new String[] { str, urp.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Udl.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ucw, a()));
  }
  
  public void c()
  {
    vqi localvqi = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localvqi != null) {
      localvqi.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      urk.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    urk.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    vqi localvqi = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localvqi != null)
    {
      if (this.jdField_a_of_type_Ucw.a(a())) {
        localvqi.a(false);
      }
    }
    else {
      return;
    }
    localvqi.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Uel = new uel(this);
    sgi.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Uel);
    this.jdField_a_of_type_Uep = new uep(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uep);
    this.jdField_a_of_type_Ueg = new ueg(this);
    sgi.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Ueg);
    this.jdField_a_of_type_Uej = new uej(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uej);
    this.jdField_a_of_type_Uer = new uer(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uer);
    this.jdField_a_of_type_Ues = new ues(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ues);
    this.jdField_a_of_type_Uet = new uet(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uet);
    this.jdField_a_of_type_Uem = new uem(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uem);
    this.jdField_a_of_type_Uek = new uek(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uek);
    this.jdField_a_of_type_Ueo = new ueo(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ueo);
    this.jdField_a_of_type_Ueq = new ueq(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Ueq);
    this.jdField_a_of_type_Uen = new uen(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uen);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ueh);
    this.jdField_a_of_type_Ucr = new ucr(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
    this.jdField_a_of_type_Sps = ((sps)sqg.a(15));
    this.jdField_a_of_type_Spd = ((spd)sqg.a(17));
    this.jdField_a_of_type_Ujk = ((ujk)sqg.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Udl.a();
  }
  
  public void f_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void g()
  {
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uel);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uep);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ueg);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uej);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uer);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ues);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uet);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uem);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uek);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ueo);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Ueq);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uen);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ueh);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Ucy = null;
    this.jdField_b_of_type_Ucy = null;
    if (this.jdField_a_of_type_Ucr != null) {
      this.jdField_a_of_type_Ucr.c();
    }
    if (this.jdField_a_of_type_Udh != null) {
      this.jdField_a_of_type_Udh.d();
    }
    if (this.jdField_a_of_type_Ucc != null) {
      this.jdField_a_of_type_Ucc.d();
    }
    if (this.jdField_b_of_type_Ucc != null) {
      this.jdField_b_of_type_Ucc.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      swu.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uec
 * JD-Core Version:    0.7.0.1
 */