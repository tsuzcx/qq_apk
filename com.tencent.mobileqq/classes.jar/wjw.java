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

public class wjw
  implements IEventReceiver, wia, wio, wjj
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private uux jdField_a_of_type_Uux;
  private uvm jdField_a_of_type_Uvm;
  private whw jdField_a_of_type_Whw;
  private wil jdField_a_of_type_Wil;
  private wiq jdField_a_of_type_Wiq;
  private wis jdField_a_of_type_Wis;
  private wjb jdField_a_of_type_Wjb;
  private wka jdField_a_of_type_Wka;
  protected wkb a;
  private wkd jdField_a_of_type_Wkd;
  private wke jdField_a_of_type_Wke;
  private wkf jdField_a_of_type_Wkf;
  private wkg jdField_a_of_type_Wkg;
  private wkh jdField_a_of_type_Wkh;
  private wki jdField_a_of_type_Wki;
  private wkj jdField_a_of_type_Wkj;
  private wkk jdField_a_of_type_Wkk;
  private wkl jdField_a_of_type_Wkl;
  private wkm jdField_a_of_type_Wkm;
  private wkn jdField_a_of_type_Wkn;
  private woy jdField_a_of_type_Woy;
  private wpe jdField_a_of_type_Wpe;
  private final int jdField_b_of_type_Int;
  private whw jdField_b_of_type_Whw;
  private wis jdField_b_of_type_Wis;
  private int c = -1;
  
  public wjw(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Wkb = new wkb(this.jdField_a_of_type_JavaLangString, new wjx(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    utf localutf;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localutf = new utf(2, paramCommentEntry.feedId, paramInt);
      localutf.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localutf;; paramCommentEntry = new utf(2, this.jdField_a_of_type_Wiq.a.feedId, paramInt, this.jdField_a_of_type_Wiq.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Wiq.a;
      umc.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wiq.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Wiq.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Wiq.a));
    this.jdField_a_of_type_Uux.d(paramCommentEntry);
    utp.a().a();
    QQToast.a(BaseApplication.getContext(), 2, alud.a(2131714801), 0).a();
    a(this.jdField_a_of_type_Wiq);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Wiq, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = wxj.b(this.jdField_a_of_type_Wiq.a);
    if ((this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Wiq.a.getOwner().getUnionId();; str = "")
    {
      wxj.a("home_page", paramString, wxj.a(this.jdField_a_of_type_Wiq.a), 0, new String[] { String.valueOf(i), wxj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wiq.a.feedId, str });
      return;
    }
  }
  
  private void a(wiq paramwiq)
  {
    if (paramwiq == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramwiq.a()) {
          break label39;
        }
        if (!paramwiq.b()) {
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
    String str = vls.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((uwm)uwa.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Wiq.a.mHadLike = 1;
      this.jdField_a_of_type_Wiq.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Wiq.a);
      this.jdField_a_of_type_Uvm.a(localLikeEntry);
    }
    for (;;)
    {
      wxe.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Wiq.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Wiq.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Wiq.b(true)), Integer.valueOf(this.jdField_a_of_type_Wiq.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Wiq.b(false)), Integer.valueOf(this.jdField_a_of_type_Wiq.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Wiq.a.mHadLike = 0;
      this.jdField_a_of_type_Wiq.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Wiq.a);
      this.jdField_a_of_type_Uvm.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(wiq paramwiq)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = wxj.a(paramwiq.a);
      if (!paramwiq.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      wxj.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramwiq.a.feedId });
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
  
  private static void b(@NonNull wjw paramwjw, @NonNull String paramString1, String paramString2)
  {
    if (paramwjw.jdField_a_of_type_Wiq == null) {
      wxe.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      wxe.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramwjw.jdField_a_of_type_Wiq.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramwjw.jdField_a_of_type_Wiq.a().remove(localStoryVideoItem);
      wxe.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramwjw.jdField_a_of_type_Wiq.a().size()));
      if (paramwjw.jdField_a_of_type_Wiq.a().size() == 0) {
        paramwjw.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramwjw.k();
        return;
        paramwjw.a();
      }
    }
    wxe.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramwjw.jdField_a_of_type_Wiq.a().size()) });
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
        } while (this.jdField_a_of_type_Wis != null);
        this.jdField_a_of_type_Wis = new wis(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Wis != null);
      this.jdField_b_of_type_Wis = new wis(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Wis != null);
    this.jdField_a_of_type_Wis = new wis(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Whw != null);
        this.jdField_a_of_type_Whw = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Whw != null);
      this.jdField_b_of_type_Whw = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Whw != null);
    this.jdField_a_of_type_Whw = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Wiq.a())
    {
      d(-1);
      this.jdField_a_of_type_Wis.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Wis.a(true);
    d(2);
    this.jdField_a_of_type_Wis.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Wiq.a()) {
      if (this.jdField_a_of_type_Wiq.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Whw.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Wiq.a(false))
      {
        e(1);
        this.jdField_b_of_type_Whw.c();
      }
    } while (!this.jdField_a_of_type_Wiq.a(true));
    e(2);
    this.jdField_a_of_type_Whw.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wxe.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    wxe.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    uwd localuwd = (uwd)uwa.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localuwd.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((uwd)uwa.a(27)).a(this.jdField_a_of_type_Wiq.a.feedId, this.jdField_a_of_type_Wiq.a());
    this.jdField_a_of_type_Wiq.b(localList, true);
    wxe.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Wiq.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Whw != null) {
      this.jdField_a_of_type_Whw.b(this.jdField_a_of_type_Wiq.a(true));
    }
    if (this.jdField_b_of_type_Whw != null) {
      this.jdField_b_of_type_Whw.b(this.jdField_a_of_type_Wiq.a(false));
    }
    if (this.jdField_a_of_type_Wjb != null)
    {
      if (!this.jdField_a_of_type_Wiq.c()) {
        wxe.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Wiq.a().getVideoInfo();
    this.jdField_a_of_type_Wjb.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void Q_()
  {
    wxe.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Whw.c();
    }
    for (;;)
    {
      wxj.a("home_page", "load_detail", 0, 0, new String[] { "", wxj.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Whw.c();
    }
  }
  
  public void R_()
  {
    wxe.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131714800), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Wiq.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Wiq.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, uqn.a(2131700072), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Wiq.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      utg.a(this.jdField_a_of_type_Wiq.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void S_()
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
    wxe.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Wiq, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      wxj.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", wxj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wiq.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    wxe.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    uqn.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Wiq.a(bool)) && (this.jdField_a_of_type_Wiq.a(bool) == null))
    {
      CommentEntry localCommentEntry = wjf.a(this.jdField_a_of_type_Wiq.a(bool) - this.jdField_a_of_type_Wiq.a(bool).size());
      this.jdField_a_of_type_Wiq.c(localCommentEntry, bool);
      this.jdField_a_of_type_Wiq.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Wiq.a(paramCommentEntry, bool);
    wxe.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Wiq.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Wiq.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Wiq.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Wiq.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, alud.a(2131714804), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      S_();
      this.jdField_a_of_type_Wiq.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Wiq.a));
      if (!this.jdField_a_of_type_Wiq.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Uux.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Wiq.a.getCommentLikeType();
      this.jdField_a_of_type_Uux.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wjf == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wjf.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(wiq paramwiq, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      wxe.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramwiq);
    if ((this.jdField_a_of_type_Wiq == null) && (paramErrorMessage.isSuccess())) {
      b(paramwiq);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Wiq = paramwiq;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Wiq, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramwiq = this.jdField_a_of_type_Wiq.toString();; paramwiq = "null")
    {
      wxe.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramwiq);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Wiq = paramwiq;
        l();
        if ((this.jdField_a_of_type_Wiq.d()) && (!this.jdField_a_of_type_Wiq.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Wiq, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramwiq, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Wiq == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wil.a();
      return;
    }
    this.jdField_a_of_type_Wil.b();
  }
  
  public void b()
  {
    wxe.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Wjb == null)
    {
      if (!this.jdField_a_of_type_Wiq.c())
      {
        wxe.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Wjb = new wjb(2, this.jdField_a_of_type_Wiq.a().getVideoInfo());
      this.jdField_a_of_type_Wjb.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Wjb.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Wiq.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, alud.a(2131714803), 0).a();
      wxe.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    usf.a(localCommentEntry, new wjz(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    ust.a(this.jdField_a_of_type_Wiq.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new wjy(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wjf == null) {
      return;
    }
    if ((this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.a != null)) {
      if (!this.jdField_a_of_type_Wiq.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      wxj.a("home_page", "press_reply", 0, 0, new String[] { str, wxj.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wjf.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Wiq, a()));
  }
  
  public void c()
  {
    xwc localxwc = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localxwc != null) {
      localxwc.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      wxe.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    wxe.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    xwc localxwc = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localxwc != null)
    {
      if (this.jdField_a_of_type_Wiq.a(a())) {
        localxwc.a(false);
      }
    }
    else {
      return;
    }
    localxwc.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Wkf = new wkf(this);
    umc.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Wkf);
    this.jdField_a_of_type_Wkj = new wkj(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkj);
    this.jdField_a_of_type_Wka = new wka(this);
    umc.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Wka);
    this.jdField_a_of_type_Wkd = new wkd(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkd);
    this.jdField_a_of_type_Wkl = new wkl(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkl);
    this.jdField_a_of_type_Wkm = new wkm(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkm);
    this.jdField_a_of_type_Wkn = new wkn(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkn);
    this.jdField_a_of_type_Wkg = new wkg(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkg);
    this.jdField_a_of_type_Wke = new wke(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wke);
    this.jdField_a_of_type_Wki = new wki(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wki);
    this.jdField_a_of_type_Wkk = new wkk(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkk);
    this.jdField_a_of_type_Wkh = new wkh(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wkh);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Wkb);
    this.jdField_a_of_type_Wil = new wil(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
    this.jdField_a_of_type_Uvm = ((uvm)uwa.a(15));
    this.jdField_a_of_type_Uux = ((uux)uwa.a(17));
    this.jdField_a_of_type_Wpe = ((wpe)uwa.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Wjf.a();
  }
  
  public void g()
  {
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkf);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkj);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wka);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkd);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkl);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkm);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkn);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkg);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wke);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wki);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkk);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wkh);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wkb);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Wis = null;
    this.jdField_b_of_type_Wis = null;
    if (this.jdField_a_of_type_Wil != null) {
      this.jdField_a_of_type_Wil.c();
    }
    if (this.jdField_a_of_type_Wjb != null) {
      this.jdField_a_of_type_Wjb.d();
    }
    if (this.jdField_a_of_type_Whw != null) {
      this.jdField_a_of_type_Whw.d();
    }
    if (this.jdField_b_of_type_Whw != null) {
      this.jdField_b_of_type_Whw.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      vco.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
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
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */