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

public class uqv
  implements IEventReceiver, uoz, upn, uqi
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private tbw jdField_a_of_type_Tbw;
  private tcl jdField_a_of_type_Tcl;
  private uov jdField_a_of_type_Uov;
  private upk jdField_a_of_type_Upk;
  private upp jdField_a_of_type_Upp;
  private upr jdField_a_of_type_Upr;
  private uqa jdField_a_of_type_Uqa;
  private uqz jdField_a_of_type_Uqz;
  protected ura a;
  private urc jdField_a_of_type_Urc;
  private urd jdField_a_of_type_Urd;
  private ure jdField_a_of_type_Ure;
  private urf jdField_a_of_type_Urf;
  private urg jdField_a_of_type_Urg;
  private urh jdField_a_of_type_Urh;
  private uri jdField_a_of_type_Uri;
  private urj jdField_a_of_type_Urj;
  private urk jdField_a_of_type_Urk;
  private url jdField_a_of_type_Url;
  private urm jdField_a_of_type_Urm;
  private uvx jdField_a_of_type_Uvx;
  private uwd jdField_a_of_type_Uwd;
  private final int jdField_b_of_type_Int;
  private uov jdField_b_of_type_Uov;
  private upr jdField_b_of_type_Upr;
  private int c = -1;
  
  public uqv(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ura = new ura(this.jdField_a_of_type_JavaLangString, new uqw(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    tae localtae;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localtae = new tae(2, paramCommentEntry.feedId, paramInt);
      localtae.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localtae;; paramCommentEntry = new tae(2, this.jdField_a_of_type_Upp.a.feedId, paramInt, this.jdField_a_of_type_Upp.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Upp.a;
      stb.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upp.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Upp.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Upp.a));
    this.jdField_a_of_type_Tbw.d(paramCommentEntry);
    tao.a().a();
    bcql.a(BaseApplication.getContext(), 2, ajya.a(2131714417), 0).a();
    a(this.jdField_a_of_type_Upp);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Upp, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = vei.b(this.jdField_a_of_type_Upp.a);
    if ((this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Upp.a.getOwner().getUnionId();; str = "")
    {
      vei.a("home_page", paramString, vei.a(this.jdField_a_of_type_Upp.a), 0, new String[] { String.valueOf(i), vei.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Upp.a.feedId, str });
      return;
    }
  }
  
  private void a(upp paramupp)
  {
    if (paramupp == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramupp.a()) {
          break label39;
        }
        if (!paramupp.b()) {
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
    String str = tsr.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((tdl)tcz.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Upp.a.mHadLike = 1;
      this.jdField_a_of_type_Upp.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Upp.a);
      this.jdField_a_of_type_Tcl.a(localLikeEntry);
    }
    for (;;)
    {
      ved.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Upp.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Upp.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Upp.b(true)), Integer.valueOf(this.jdField_a_of_type_Upp.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Upp.b(false)), Integer.valueOf(this.jdField_a_of_type_Upp.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Upp.a.mHadLike = 0;
      this.jdField_a_of_type_Upp.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Upp.a);
      this.jdField_a_of_type_Tcl.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(upp paramupp)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = vei.a(paramupp.a);
      if (!paramupp.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      vei.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramupp.a.feedId });
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
  
  private static void b(@NonNull uqv paramuqv, @NonNull String paramString1, String paramString2)
  {
    if (paramuqv.jdField_a_of_type_Upp == null) {
      ved.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      ved.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramuqv.jdField_a_of_type_Upp.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramuqv.jdField_a_of_type_Upp.a().remove(localStoryVideoItem);
      ved.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramuqv.jdField_a_of_type_Upp.a().size()));
      if (paramuqv.jdField_a_of_type_Upp.a().size() == 0) {
        paramuqv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramuqv.k();
        return;
        paramuqv.a();
      }
    }
    ved.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramuqv.jdField_a_of_type_Upp.a().size()) });
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
        } while (this.jdField_a_of_type_Upr != null);
        this.jdField_a_of_type_Upr = new upr(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Upr != null);
      this.jdField_b_of_type_Upr = new upr(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Upr != null);
    this.jdField_a_of_type_Upr = new upr(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Uov != null);
        this.jdField_a_of_type_Uov = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Uov != null);
      this.jdField_b_of_type_Uov = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Uov != null);
    this.jdField_a_of_type_Uov = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Upp.a())
    {
      d(-1);
      this.jdField_a_of_type_Upr.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Upr.a(true);
    d(2);
    this.jdField_a_of_type_Upr.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Upp.a()) {
      if (this.jdField_a_of_type_Upp.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Uov.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Upp.a(false))
      {
        e(1);
        this.jdField_b_of_type_Uov.c();
      }
    } while (!this.jdField_a_of_type_Upp.a(true));
    e(2);
    this.jdField_a_of_type_Uov.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ved.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    ved.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    tdc localtdc = (tdc)tcz.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localtdc.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((tdc)tcz.a(27)).a(this.jdField_a_of_type_Upp.a.feedId, this.jdField_a_of_type_Upp.a());
    this.jdField_a_of_type_Upp.b(localList, true);
    ved.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Upp.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Uov != null) {
      this.jdField_a_of_type_Uov.b(this.jdField_a_of_type_Upp.a(true));
    }
    if (this.jdField_b_of_type_Uov != null) {
      this.jdField_b_of_type_Uov.b(this.jdField_a_of_type_Upp.a(false));
    }
    if (this.jdField_a_of_type_Uqa != null)
    {
      if (!this.jdField_a_of_type_Upp.c()) {
        ved.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Upp.a().getVideoInfo();
    this.jdField_a_of_type_Uqa.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void L_()
  {
    ved.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Uov.c();
    }
    for (;;)
    {
      vei.a("home_page", "load_detail", 0, 0, new String[] { "", vei.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Uov.c();
    }
  }
  
  public void M_()
  {
    ved.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bbfj.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131714416), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Upp.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Upp.a.getOwner().isSubscribe()))
    {
      bcql.a(BaseApplication.getContext(), 1, sxm.a(2131699691), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Upp.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      taf.a(this.jdField_a_of_type_Upp.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void N_()
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
    ved.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Upp, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      vei.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", vei.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Upp.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ved.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    sxm.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Upp.a(bool)) && (this.jdField_a_of_type_Upp.a(bool) == null))
    {
      CommentEntry localCommentEntry = uqe.a(this.jdField_a_of_type_Upp.a(bool) - this.jdField_a_of_type_Upp.a(bool).size());
      this.jdField_a_of_type_Upp.c(localCommentEntry, bool);
      this.jdField_a_of_type_Upp.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Upp.a(paramCommentEntry, bool);
    ved.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Upp.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Upp.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Upp.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Upp.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bcql.a(BaseApplication.getContext(), 1, ajya.a(2131714420), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      N_();
      this.jdField_a_of_type_Upp.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Upp.a));
      if (!this.jdField_a_of_type_Upp.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Tbw.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Upp.a.getCommentLikeType();
      this.jdField_a_of_type_Tbw.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqe == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqe.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(upp paramupp, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ved.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramupp);
    if ((this.jdField_a_of_type_Upp == null) && (paramErrorMessage.isSuccess())) {
      b(paramupp);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Upp = paramupp;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Upp, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramupp = this.jdField_a_of_type_Upp.toString();; paramupp = "null")
    {
      ved.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramupp);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Upp = paramupp;
        l();
        if ((this.jdField_a_of_type_Upp.d()) && (!this.jdField_a_of_type_Upp.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Upp, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramupp, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Upp == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Upk.a();
      return;
    }
    this.jdField_a_of_type_Upk.b();
  }
  
  public void b()
  {
    ved.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Uqa == null)
    {
      if (!this.jdField_a_of_type_Upp.c())
      {
        ved.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Uqa = new uqa(2, this.jdField_a_of_type_Upp.a().getVideoInfo());
      this.jdField_a_of_type_Uqa.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Uqa.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Upp.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bbfj.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131714419), 0).a();
      ved.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    sze.a(localCommentEntry, new uqy(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    szs.a(this.jdField_a_of_type_Upp.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new uqx(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqe == null) {
      return;
    }
    if ((this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.a != null)) {
      if (!this.jdField_a_of_type_Upp.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      vei.a("home_page", "press_reply", 0, 0, new String[] { str, vei.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqe.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Upp, a()));
  }
  
  public void c()
  {
    wdb localwdb = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localwdb != null) {
      localwdb.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      ved.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    ved.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    wdb localwdb = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localwdb != null)
    {
      if (this.jdField_a_of_type_Upp.a(a())) {
        localwdb.a(false);
      }
    }
    else {
      return;
    }
    localwdb.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Ure = new ure(this);
    stb.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Ure);
    this.jdField_a_of_type_Uri = new uri(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Uri);
    this.jdField_a_of_type_Uqz = new uqz(this);
    stb.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Uqz);
    this.jdField_a_of_type_Urc = new urc(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urc);
    this.jdField_a_of_type_Urk = new urk(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urk);
    this.jdField_a_of_type_Url = new url(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Url);
    this.jdField_a_of_type_Urm = new urm(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urm);
    this.jdField_a_of_type_Urf = new urf(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urf);
    this.jdField_a_of_type_Urd = new urd(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urd);
    this.jdField_a_of_type_Urh = new urh(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urh);
    this.jdField_a_of_type_Urj = new urj(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urj);
    this.jdField_a_of_type_Urg = new urg(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Urg);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ura);
    this.jdField_a_of_type_Upk = new upk(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
    this.jdField_a_of_type_Tcl = ((tcl)tcz.a(15));
    this.jdField_a_of_type_Tbw = ((tbw)tcz.a(17));
    this.jdField_a_of_type_Uwd = ((uwd)tcz.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqe.a();
  }
  
  public void f_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void g()
  {
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Ure);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uri);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uqz);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urc);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urk);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Url);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urm);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urf);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urd);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urh);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urj);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Urg);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ura);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Upr = null;
    this.jdField_b_of_type_Upr = null;
    if (this.jdField_a_of_type_Upk != null) {
      this.jdField_a_of_type_Upk.c();
    }
    if (this.jdField_a_of_type_Uqa != null) {
      this.jdField_a_of_type_Uqa.d();
    }
    if (this.jdField_a_of_type_Uov != null) {
      this.jdField_a_of_type_Uov.d();
    }
    if (this.jdField_b_of_type_Uov != null) {
      this.jdField_b_of_type_Uov.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      tjn.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqv
 * JD-Core Version:    0.7.0.1
 */