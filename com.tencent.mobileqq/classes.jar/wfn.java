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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wfn
  implements IEventReceiver, wdr, wef, wfa
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private uqo jdField_a_of_type_Uqo;
  private urd jdField_a_of_type_Urd;
  private wdn jdField_a_of_type_Wdn;
  private wec jdField_a_of_type_Wec;
  private weh jdField_a_of_type_Weh;
  private wej jdField_a_of_type_Wej;
  private wes jdField_a_of_type_Wes;
  private wfr jdField_a_of_type_Wfr;
  protected wfs a;
  private wfu jdField_a_of_type_Wfu;
  private wfv jdField_a_of_type_Wfv;
  private wfw jdField_a_of_type_Wfw;
  private wfx jdField_a_of_type_Wfx;
  private wfy jdField_a_of_type_Wfy;
  private wfz jdField_a_of_type_Wfz;
  private wga jdField_a_of_type_Wga;
  private wgb jdField_a_of_type_Wgb;
  private wgc jdField_a_of_type_Wgc;
  private wgd jdField_a_of_type_Wgd;
  private wge jdField_a_of_type_Wge;
  private wkp jdField_a_of_type_Wkp;
  private wkv jdField_a_of_type_Wkv;
  private final int jdField_b_of_type_Int;
  private wdn jdField_b_of_type_Wdn;
  private wej jdField_b_of_type_Wej;
  private int c = -1;
  
  public wfn(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Wfs = new wfs(this.jdField_a_of_type_JavaLangString, new wfo(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    uow localuow;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localuow = new uow(2, paramCommentEntry.feedId, paramInt);
      localuow.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localuow;; paramCommentEntry = new uow(2, this.jdField_a_of_type_Weh.a.feedId, paramInt, this.jdField_a_of_type_Weh.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Weh.a;
      uht.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Weh.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Weh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Weh.a));
    this.jdField_a_of_type_Uqo.d(paramCommentEntry);
    upg.a().a();
    QQToast.a(BaseApplication.getContext(), 2, alpo.a(2131714789), 0).a();
    a(this.jdField_a_of_type_Weh);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Weh, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = wta.b(this.jdField_a_of_type_Weh.a);
    if ((this.jdField_a_of_type_Weh.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Weh.a.getOwner().getUnionId();; str = "")
    {
      wta.a("home_page", paramString, wta.a(this.jdField_a_of_type_Weh.a), 0, new String[] { String.valueOf(i), wta.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Weh.a.feedId, str });
      return;
    }
  }
  
  private void a(weh paramweh)
  {
    if (paramweh == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramweh.a()) {
          break label39;
        }
        if (!paramweh.b()) {
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
    String str = vhj.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((usd)urr.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Weh.a.mHadLike = 1;
      this.jdField_a_of_type_Weh.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Weh.a);
      this.jdField_a_of_type_Urd.a(localLikeEntry);
    }
    for (;;)
    {
      wsv.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Weh.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Weh.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Weh.b(true)), Integer.valueOf(this.jdField_a_of_type_Weh.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Weh.b(false)), Integer.valueOf(this.jdField_a_of_type_Weh.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Weh.a.mHadLike = 0;
      this.jdField_a_of_type_Weh.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Weh.a);
      this.jdField_a_of_type_Urd.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(weh paramweh)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = wta.a(paramweh.a);
      if (!paramweh.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      wta.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramweh.a.feedId });
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
  
  private static void b(@NonNull wfn paramwfn, @NonNull String paramString1, String paramString2)
  {
    if (paramwfn.jdField_a_of_type_Weh == null) {
      wsv.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      wsv.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramwfn.jdField_a_of_type_Weh.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramwfn.jdField_a_of_type_Weh.a().remove(localStoryVideoItem);
      wsv.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramwfn.jdField_a_of_type_Weh.a().size()));
      if (paramwfn.jdField_a_of_type_Weh.a().size() == 0) {
        paramwfn.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramwfn.k();
        return;
        paramwfn.a();
      }
    }
    wsv.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramwfn.jdField_a_of_type_Weh.a().size()) });
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
        } while (this.jdField_a_of_type_Wej != null);
        this.jdField_a_of_type_Wej = new wej(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Wej != null);
      this.jdField_b_of_type_Wej = new wej(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Wej != null);
    this.jdField_a_of_type_Wej = new wej(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Wdn != null);
        this.jdField_a_of_type_Wdn = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Wdn != null);
      this.jdField_b_of_type_Wdn = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Wdn != null);
    this.jdField_a_of_type_Wdn = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Weh.a())
    {
      d(-1);
      this.jdField_a_of_type_Wej.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Wej.a(true);
    d(2);
    this.jdField_a_of_type_Wej.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Weh.a()) {
      if (this.jdField_a_of_type_Weh.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Wdn.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Weh.a(false))
      {
        e(1);
        this.jdField_b_of_type_Wdn.c();
      }
    } while (!this.jdField_a_of_type_Weh.a(true));
    e(2);
    this.jdField_a_of_type_Wdn.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wsv.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    wsv.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    uru localuru = (uru)urr.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localuru.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((uru)urr.a(27)).a(this.jdField_a_of_type_Weh.a.feedId, this.jdField_a_of_type_Weh.a());
    this.jdField_a_of_type_Weh.b(localList, true);
    wsv.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Weh.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Wdn != null) {
      this.jdField_a_of_type_Wdn.b(this.jdField_a_of_type_Weh.a(true));
    }
    if (this.jdField_b_of_type_Wdn != null) {
      this.jdField_b_of_type_Wdn.b(this.jdField_a_of_type_Weh.a(false));
    }
    if (this.jdField_a_of_type_Wes != null)
    {
      if (!this.jdField_a_of_type_Weh.c()) {
        wsv.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Weh.a().getVideoInfo();
    this.jdField_a_of_type_Wes.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void T_()
  {
    wsv.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Wdn.c();
    }
    for (;;)
    {
      wta.a("home_page", "load_detail", 0, 0, new String[] { "", wta.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Wdn.c();
    }
  }
  
  public void U_()
  {
    wsv.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bdee.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131714788), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Weh.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Weh.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Weh.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, ume.a(2131700060), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Weh.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      uox.a(this.jdField_a_of_type_Weh.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void V_()
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
    wsv.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Weh, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      wta.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", wta.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Weh.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    wsv.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    ume.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Weh.a(bool)) && (this.jdField_a_of_type_Weh.a(bool) == null))
    {
      CommentEntry localCommentEntry = wew.a(this.jdField_a_of_type_Weh.a(bool) - this.jdField_a_of_type_Weh.a(bool).size());
      this.jdField_a_of_type_Weh.c(localCommentEntry, bool);
      this.jdField_a_of_type_Weh.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Weh.a(paramCommentEntry, bool);
    wsv.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Weh.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Weh.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Weh.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Weh.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131714792), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      V_();
      this.jdField_a_of_type_Weh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Weh.a));
      if (!this.jdField_a_of_type_Weh.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Uqo.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Weh.a.getCommentLikeType();
      this.jdField_a_of_type_Uqo.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wew == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wew.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(weh paramweh, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      wsv.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramweh);
    if ((this.jdField_a_of_type_Weh == null) && (paramErrorMessage.isSuccess())) {
      b(paramweh);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Weh = paramweh;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Weh, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramweh = this.jdField_a_of_type_Weh.toString();; paramweh = "null")
    {
      wsv.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramweh);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Weh = paramweh;
        l();
        if ((this.jdField_a_of_type_Weh.d()) && (!this.jdField_a_of_type_Weh.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Weh, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramweh, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Weh == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wec.a();
      return;
    }
    this.jdField_a_of_type_Wec.b();
  }
  
  public void b()
  {
    wsv.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Wes == null)
    {
      if (!this.jdField_a_of_type_Weh.c())
      {
        wsv.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Wes = new wes(2, this.jdField_a_of_type_Weh.a().getVideoInfo());
      this.jdField_a_of_type_Wes.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Wes.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Weh.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bdee.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131714791), 0).a();
      wsv.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    unw.a(localCommentEntry, new wfq(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    uok.a(this.jdField_a_of_type_Weh.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new wfp(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wew == null) {
      return;
    }
    if ((this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.a != null)) {
      if (!this.jdField_a_of_type_Weh.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      wta.a("home_page", "press_reply", 0, 0, new String[] { str, wta.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wew.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Weh, a()));
  }
  
  public void c()
  {
    xrt localxrt = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localxrt != null) {
      localxrt.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      wsv.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    wsv.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    xrt localxrt = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localxrt != null)
    {
      if (this.jdField_a_of_type_Weh.a(a())) {
        localxrt.a(false);
      }
    }
    else {
      return;
    }
    localxrt.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wfw = new wfw(this);
    uht.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Wfw);
    this.jdField_a_of_type_Wga = new wga(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wga);
    this.jdField_a_of_type_Wfr = new wfr(this);
    uht.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Wfr);
    this.jdField_a_of_type_Wfu = new wfu(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wfu);
    this.jdField_a_of_type_Wgc = new wgc(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wgc);
    this.jdField_a_of_type_Wgd = new wgd(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wgd);
    this.jdField_a_of_type_Wge = new wge(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wge);
    this.jdField_a_of_type_Wfx = new wfx(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wfx);
    this.jdField_a_of_type_Wfv = new wfv(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wfv);
    this.jdField_a_of_type_Wfz = new wfz(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wfz);
    this.jdField_a_of_type_Wgb = new wgb(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wgb);
    this.jdField_a_of_type_Wfy = new wfy(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wfy);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Wfs);
    this.jdField_a_of_type_Wec = new wec(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
    this.jdField_a_of_type_Urd = ((urd)urr.a(15));
    this.jdField_a_of_type_Uqo = ((uqo)urr.a(17));
    this.jdField_a_of_type_Wkv = ((wkv)urr.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wew.a();
  }
  
  public void g()
  {
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfw);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wga);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfr);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfu);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wgc);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wgd);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wge);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfx);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfv);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfz);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wgb);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wfy);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wfs);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Wej = null;
    this.jdField_b_of_type_Wej = null;
    if (this.jdField_a_of_type_Wec != null) {
      this.jdField_a_of_type_Wec.c();
    }
    if (this.jdField_a_of_type_Wes != null) {
      this.jdField_a_of_type_Wes.d();
    }
    if (this.jdField_a_of_type_Wdn != null) {
      this.jdField_a_of_type_Wdn.d();
    }
    if (this.jdField_b_of_type_Wdn != null) {
      this.jdField_b_of_type_Wdn.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      uyf.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void h_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfn
 * JD-Core Version:    0.7.0.1
 */