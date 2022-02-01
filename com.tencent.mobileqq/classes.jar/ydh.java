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

public class ydh
  implements IEventReceiver, ybl, ybz, ycu
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private woj jdField_a_of_type_Woj;
  private woy jdField_a_of_type_Woy;
  private ybh jdField_a_of_type_Ybh;
  private ybw jdField_a_of_type_Ybw;
  private ycb jdField_a_of_type_Ycb;
  private ycd jdField_a_of_type_Ycd;
  private ycm jdField_a_of_type_Ycm;
  private ydl jdField_a_of_type_Ydl;
  protected ydm a;
  private ydo jdField_a_of_type_Ydo;
  private ydp jdField_a_of_type_Ydp;
  private ydq jdField_a_of_type_Ydq;
  private ydr jdField_a_of_type_Ydr;
  private yds jdField_a_of_type_Yds;
  private ydt jdField_a_of_type_Ydt;
  private ydu jdField_a_of_type_Ydu;
  private ydv jdField_a_of_type_Ydv;
  private ydw jdField_a_of_type_Ydw;
  private ydx jdField_a_of_type_Ydx;
  private ydy jdField_a_of_type_Ydy;
  private yij jdField_a_of_type_Yij;
  private yip jdField_a_of_type_Yip;
  private final int jdField_b_of_type_Int;
  private ybh jdField_b_of_type_Ybh;
  private ycd jdField_b_of_type_Ycd;
  private int c = -1;
  
  public ydh(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Ydm = new ydm(this.jdField_a_of_type_JavaLangString, new ydi(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    wmr localwmr;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwmr = new wmr(2, paramCommentEntry.feedId, paramInt);
      localwmr.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwmr;; paramCommentEntry = new wmr(2, this.jdField_a_of_type_Ycb.a.feedId, paramInt, this.jdField_a_of_type_Ycb.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Ycb.a;
      wfo.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ycb.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ycb.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Ycb.a));
    this.jdField_a_of_type_Woj.d(paramCommentEntry);
    wnb.a().a();
    QQToast.a(BaseApplication.getContext(), 2, anni.a(2131713102), 0).a();
    a(this.jdField_a_of_type_Ycb);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ycb, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = yqu.b(this.jdField_a_of_type_Ycb.a);
    if ((this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Ycb.a.getOwner().getUnionId();; str = "")
    {
      yqu.a("home_page", paramString, yqu.a(this.jdField_a_of_type_Ycb.a), 0, new String[] { String.valueOf(i), yqu.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ycb.a.feedId, str });
      return;
    }
  }
  
  private void a(ycb paramycb)
  {
    if (paramycb == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramycb.a()) {
          break label39;
        }
        if (!paramycb.b()) {
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
    String str = xfe.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((wpy)wpm.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Ycb.a.mHadLike = 1;
      this.jdField_a_of_type_Ycb.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Ycb.a);
      this.jdField_a_of_type_Woy.a(localLikeEntry);
    }
    for (;;)
    {
      yqp.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ycb.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Ycb.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Ycb.b(true)), Integer.valueOf(this.jdField_a_of_type_Ycb.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Ycb.b(false)), Integer.valueOf(this.jdField_a_of_type_Ycb.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Ycb.a.mHadLike = 0;
      this.jdField_a_of_type_Ycb.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Ycb.a);
      this.jdField_a_of_type_Woy.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(ycb paramycb)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = yqu.a(paramycb.a);
      if (!paramycb.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      yqu.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramycb.a.feedId });
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
  
  private static void b(@NonNull ydh paramydh, @NonNull String paramString1, String paramString2)
  {
    if (paramydh.jdField_a_of_type_Ycb == null) {
      yqp.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      yqp.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramydh.jdField_a_of_type_Ycb.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramydh.jdField_a_of_type_Ycb.a().remove(localStoryVideoItem);
      yqp.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramydh.jdField_a_of_type_Ycb.a().size()));
      if (paramydh.jdField_a_of_type_Ycb.a().size() == 0) {
        paramydh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramydh.k();
        return;
        paramydh.a();
      }
    }
    yqp.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramydh.jdField_a_of_type_Ycb.a().size()) });
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
        } while (this.jdField_a_of_type_Ycd != null);
        this.jdField_a_of_type_Ycd = new ycd(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Ycd != null);
      this.jdField_b_of_type_Ycd = new ycd(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Ycd != null);
    this.jdField_a_of_type_Ycd = new ycd(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Ybh != null);
        this.jdField_a_of_type_Ybh = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Ybh != null);
      this.jdField_b_of_type_Ybh = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Ybh != null);
    this.jdField_a_of_type_Ybh = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Ycb.a())
    {
      d(-1);
      this.jdField_a_of_type_Ycd.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Ycd.a(true);
    d(2);
    this.jdField_a_of_type_Ycd.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Ycb.a()) {
      if (this.jdField_a_of_type_Ycb.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Ybh.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ycb.a(false))
      {
        e(1);
        this.jdField_b_of_type_Ybh.c();
      }
    } while (!this.jdField_a_of_type_Ycb.a(true));
    e(2);
    this.jdField_a_of_type_Ybh.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yqp.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    yqp.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    wpp localwpp = (wpp)wpm.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localwpp.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((wpp)wpm.a(27)).a(this.jdField_a_of_type_Ycb.a.feedId, this.jdField_a_of_type_Ycb.a());
    this.jdField_a_of_type_Ycb.b(localList, true);
    yqp.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Ycb.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Ybh != null) {
      this.jdField_a_of_type_Ybh.b(this.jdField_a_of_type_Ycb.a(true));
    }
    if (this.jdField_b_of_type_Ybh != null) {
      this.jdField_b_of_type_Ybh.b(this.jdField_a_of_type_Ycb.a(false));
    }
    if (this.jdField_a_of_type_Ycm != null)
    {
      if (!this.jdField_a_of_type_Ycb.c()) {
        yqp.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Ycb.a().getVideoInfo();
    this.jdField_a_of_type_Ycm.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void N_()
  {
    yqp.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Ybh.c();
    }
    for (;;)
    {
      yqu.a("home_page", "load_detail", 0, 0, new String[] { "", yqu.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Ybh.c();
    }
  }
  
  public void O_()
  {
    yqp.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bgnt.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anni.a(2131713101), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Ycb.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Ycb.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, wjz.a(2131698498), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Ycb.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      wms.a(this.jdField_a_of_type_Ycb.a, bool1, -1, 0);
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
    yqp.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Ycb, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      yqu.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", yqu.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ycb.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    yqp.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    wjz.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Ycb.a(bool)) && (this.jdField_a_of_type_Ycb.a(bool) == null))
    {
      CommentEntry localCommentEntry = ycq.a(this.jdField_a_of_type_Ycb.a(bool) - this.jdField_a_of_type_Ycb.a(bool).size());
      this.jdField_a_of_type_Ycb.c(localCommentEntry, bool);
      this.jdField_a_of_type_Ycb.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Ycb.a(paramCommentEntry, bool);
    yqp.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Ycb.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Ycb.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Ycb.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Ycb.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anni.a(2131713105), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      P_();
      this.jdField_a_of_type_Ycb.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Ycb.a));
      if (!this.jdField_a_of_type_Ycb.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Woj.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Ycb.a.getCommentLikeType();
      this.jdField_a_of_type_Woj.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ycq == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ycq.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(ycb paramycb, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      yqp.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramycb);
    if ((this.jdField_a_of_type_Ycb == null) && (paramErrorMessage.isSuccess())) {
      b(paramycb);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ycb = paramycb;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ycb, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramycb = this.jdField_a_of_type_Ycb.toString();; paramycb = "null")
    {
      yqp.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramycb);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ycb = paramycb;
        l();
        if ((this.jdField_a_of_type_Ycb.d()) && (!this.jdField_a_of_type_Ycb.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ycb, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramycb, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Ycb == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ybw.a();
      return;
    }
    this.jdField_a_of_type_Ybw.b();
  }
  
  public void b()
  {
    yqp.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Ycm == null)
    {
      if (!this.jdField_a_of_type_Ycb.c())
      {
        yqp.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Ycm = new ycm(2, this.jdField_a_of_type_Ycb.a().getVideoInfo());
      this.jdField_a_of_type_Ycm.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Ycm.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ycb.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bgnt.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anni.a(2131713104), 0).a();
      yqp.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    wlr.a(localCommentEntry, new ydk(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wmf.a(this.jdField_a_of_type_Ycb.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new ydj(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ycq == null) {
      return;
    }
    if ((this.jdField_a_of_type_Ycb != null) && (this.jdField_a_of_type_Ycb.a != null)) {
      if (!this.jdField_a_of_type_Ycb.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      yqu.a("home_page", "press_reply", 0, 0, new String[] { str, yqu.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ycq.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ycb, a()));
  }
  
  public void c()
  {
    zpn localzpn = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzpn != null) {
      localzpn.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      yqp.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    yqp.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    zpn localzpn = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzpn != null)
    {
      if (this.jdField_a_of_type_Ycb.a(a())) {
        localzpn.a(false);
      }
    }
    else {
      return;
    }
    localzpn.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Ydq = new ydq(this);
    wfo.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Ydq);
    this.jdField_a_of_type_Ydu = new ydu(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydu);
    this.jdField_a_of_type_Ydl = new ydl(this);
    wfo.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Ydl);
    this.jdField_a_of_type_Ydo = new ydo(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydo);
    this.jdField_a_of_type_Ydw = new ydw(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydw);
    this.jdField_a_of_type_Ydx = new ydx(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydx);
    this.jdField_a_of_type_Ydy = new ydy(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydy);
    this.jdField_a_of_type_Ydr = new ydr(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydr);
    this.jdField_a_of_type_Ydp = new ydp(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydp);
    this.jdField_a_of_type_Ydt = new ydt(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydt);
    this.jdField_a_of_type_Ydv = new ydv(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Ydv);
    this.jdField_a_of_type_Yds = new yds(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yds);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Ydm);
    this.jdField_a_of_type_Ybw = new ybw(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
    this.jdField_a_of_type_Woy = ((woy)wpm.a(15));
    this.jdField_a_of_type_Woj = ((woj)wpm.a(17));
    this.jdField_a_of_type_Yip = ((yip)wpm.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ycq.a();
  }
  
  public void g()
  {
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydq);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydu);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydl);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydo);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydw);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydx);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydy);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydr);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydp);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydt);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ydv);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yds);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ydm);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Ycd = null;
    this.jdField_b_of_type_Ycd = null;
    if (this.jdField_a_of_type_Ybw != null) {
      this.jdField_a_of_type_Ybw.c();
    }
    if (this.jdField_a_of_type_Ycm != null) {
      this.jdField_a_of_type_Ycm.d();
    }
    if (this.jdField_a_of_type_Ybh != null) {
      this.jdField_a_of_type_Ybh.d();
    }
    if (this.jdField_b_of_type_Ybh != null) {
      this.jdField_b_of_type_Ybh.d();
    }
  }
  
  public void g_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      wwa.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydh
 * JD-Core Version:    0.7.0.1
 */