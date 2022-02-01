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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class xin
  implements IEventReceiver, xgr, xhf, xia
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private vtu jdField_a_of_type_Vtu;
  private vuj jdField_a_of_type_Vuj;
  private xgn jdField_a_of_type_Xgn;
  private xhc jdField_a_of_type_Xhc;
  private xhh jdField_a_of_type_Xhh;
  private xhj jdField_a_of_type_Xhj;
  private xhs jdField_a_of_type_Xhs;
  private xir jdField_a_of_type_Xir;
  protected xis a;
  private xiu jdField_a_of_type_Xiu;
  private xiv jdField_a_of_type_Xiv;
  private xiw jdField_a_of_type_Xiw;
  private xix jdField_a_of_type_Xix;
  private xiy jdField_a_of_type_Xiy;
  private xiz jdField_a_of_type_Xiz;
  private xja jdField_a_of_type_Xja;
  private xjb jdField_a_of_type_Xjb;
  private xjc jdField_a_of_type_Xjc;
  private xjd jdField_a_of_type_Xjd;
  private xje jdField_a_of_type_Xje;
  private xnp jdField_a_of_type_Xnp;
  private xnv jdField_a_of_type_Xnv;
  private final int jdField_b_of_type_Int;
  private xgn jdField_b_of_type_Xgn;
  private xhj jdField_b_of_type_Xhj;
  private int c = -1;
  
  public xin(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Xis = new xis(this.jdField_a_of_type_JavaLangString, new xio(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    vsd localvsd;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localvsd = new vsd(2, paramCommentEntry.feedId, paramInt);
      localvsd.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localvsd;; paramCommentEntry = new vsd(2, this.jdField_a_of_type_Xhh.a.feedId, paramInt, this.jdField_a_of_type_Xhh.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Xhh.a;
      vli.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xhh.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Xhh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Xhh.a));
    this.jdField_a_of_type_Vtu.d(paramCommentEntry);
    vsn.a().a();
    QQToast.a(BaseApplication.getContext(), 2, amtj.a(2131713443), 0).a();
    a(this.jdField_a_of_type_Xhh);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xhh, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = xwa.b(this.jdField_a_of_type_Xhh.a);
    if ((this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Xhh.a.getOwner().getUnionId();; str = "")
    {
      xwa.a("home_page", paramString, xwa.a(this.jdField_a_of_type_Xhh.a), 0, new String[] { String.valueOf(i), xwa.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xhh.a.feedId, str });
      return;
    }
  }
  
  private void a(xhh paramxhh)
  {
    if (paramxhh == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramxhh.a()) {
          break label39;
        }
        if (!paramxhh.b()) {
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
    String str = wkp.a().getCurrentUin();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((vvj)vux.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Xhh.a.mHadLike = 1;
      this.jdField_a_of_type_Xhh.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Xhh.a);
      this.jdField_a_of_type_Vuj.a(localLikeEntry);
    }
    for (;;)
    {
      xvv.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xhh.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Xhh.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Xhh.b(true)), Integer.valueOf(this.jdField_a_of_type_Xhh.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Xhh.b(false)), Integer.valueOf(this.jdField_a_of_type_Xhh.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Xhh.a.mHadLike = 0;
      this.jdField_a_of_type_Xhh.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Xhh.a);
      this.jdField_a_of_type_Vuj.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(xhh paramxhh)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = xwa.a(paramxhh.a);
      if (!paramxhh.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      xwa.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramxhh.a.feedId });
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
  
  private static void b(@NonNull xin paramxin, @NonNull String paramString1, String paramString2)
  {
    if (paramxin.jdField_a_of_type_Xhh == null) {
      xvv.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      xvv.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramxin.jdField_a_of_type_Xhh.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramxin.jdField_a_of_type_Xhh.a().remove(localStoryVideoItem);
      xvv.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramxin.jdField_a_of_type_Xhh.a().size()));
      if (paramxin.jdField_a_of_type_Xhh.a().size() == 0) {
        paramxin.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramxin.k();
        return;
        paramxin.a();
      }
    }
    xvv.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramxin.jdField_a_of_type_Xhh.a().size()) });
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
        } while (this.jdField_a_of_type_Xhj != null);
        this.jdField_a_of_type_Xhj = new xhj(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Xhj != null);
      this.jdField_b_of_type_Xhj = new xhj(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Xhj != null);
    this.jdField_a_of_type_Xhj = new xhj(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Xgn != null);
        this.jdField_a_of_type_Xgn = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Xgn != null);
      this.jdField_b_of_type_Xgn = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Xgn != null);
    this.jdField_a_of_type_Xgn = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Xhh.a())
    {
      d(-1);
      this.jdField_a_of_type_Xhj.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Xhj.a(true);
    d(2);
    this.jdField_a_of_type_Xhj.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Xhh.a()) {
      if (this.jdField_a_of_type_Xhh.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Xgn.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Xhh.a(false))
      {
        e(1);
        this.jdField_b_of_type_Xgn.c();
      }
    } while (!this.jdField_a_of_type_Xhh.a(true));
    e(2);
    this.jdField_a_of_type_Xgn.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      xvv.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    xvv.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    vva localvva = (vva)vux.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localvva.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((vva)vux.a(27)).a(this.jdField_a_of_type_Xhh.a.feedId, this.jdField_a_of_type_Xhh.a());
    this.jdField_a_of_type_Xhh.b(localList, true);
    xvv.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Xhh.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Xgn != null) {
      this.jdField_a_of_type_Xgn.b(this.jdField_a_of_type_Xhh.a(true));
    }
    if (this.jdField_b_of_type_Xgn != null) {
      this.jdField_b_of_type_Xgn.b(this.jdField_a_of_type_Xhh.a(false));
    }
    if (this.jdField_a_of_type_Xhs != null)
    {
      if (!this.jdField_a_of_type_Xhh.c()) {
        xvv.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Xhh.a().getVideoInfo();
    this.jdField_a_of_type_Xhs.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void H_()
  {
    xvv.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Xgn.c();
    }
    for (;;)
    {
      xwa.a("home_page", "load_detail", 0, 0, new String[] { "", xwa.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Xgn.c();
    }
  }
  
  public void I_()
  {
    xvv.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131713442), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Xhh.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Xhh.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, vpl.a(2131698840), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Xhh.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      vse.a(this.jdField_a_of_type_Xhh.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void J_()
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
    xvv.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Xhh, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      xwa.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", xwa.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xhh.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    xvv.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    vpl.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Xhh.a(bool)) && (this.jdField_a_of_type_Xhh.a(bool) == null))
    {
      CommentEntry localCommentEntry = xhw.a(this.jdField_a_of_type_Xhh.a(bool) - this.jdField_a_of_type_Xhh.a(bool).size());
      this.jdField_a_of_type_Xhh.c(localCommentEntry, bool);
      this.jdField_a_of_type_Xhh.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Xhh.a(paramCommentEntry, bool);
    xvv.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Xhh.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Xhh.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Xhh.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Xhh.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131713446), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      J_();
      this.jdField_a_of_type_Xhh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Xhh.a));
      if (!this.jdField_a_of_type_Xhh.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Vtu.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Xhh.a.getCommentLikeType();
      this.jdField_a_of_type_Vtu.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xhw == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xhw.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(xhh paramxhh, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      xvv.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramxhh);
    if ((this.jdField_a_of_type_Xhh == null) && (paramErrorMessage.isSuccess())) {
      b(paramxhh);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xhh = paramxhh;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xhh, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramxhh = this.jdField_a_of_type_Xhh.toString();; paramxhh = "null")
    {
      xvv.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramxhh);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xhh = paramxhh;
        l();
        if ((this.jdField_a_of_type_Xhh.d()) && (!this.jdField_a_of_type_Xhh.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xhh, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramxhh, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Xhh == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xhc.a();
      return;
    }
    this.jdField_a_of_type_Xhc.b();
  }
  
  public void b()
  {
    xvv.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Xhs == null)
    {
      if (!this.jdField_a_of_type_Xhh.c())
      {
        xvv.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Xhs = new xhs(2, this.jdField_a_of_type_Xhh.a().getVideoInfo());
      this.jdField_a_of_type_Xhs.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Xhs.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Xhh.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, amtj.a(2131713445), 0).a();
      xvv.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    vrd.a(localCommentEntry, new xiq(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    vrr.a(this.jdField_a_of_type_Xhh.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new xip(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xhw == null) {
      return;
    }
    if ((this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.a != null)) {
      if (!this.jdField_a_of_type_Xhh.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      xwa.a("home_page", "press_reply", 0, 0, new String[] { str, xwa.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xhw.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xhh, a()));
  }
  
  public void c()
  {
    yst localyst = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localyst != null) {
      localyst.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      xvv.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    xvv.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    yst localyst = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localyst != null)
    {
      if (this.jdField_a_of_type_Xhh.a(a())) {
        localyst.a(false);
      }
    }
    else {
      return;
    }
    localyst.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Xiw = new xiw(this);
    vli.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Xiw);
    this.jdField_a_of_type_Xja = new xja(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xja);
    this.jdField_a_of_type_Xir = new xir(this);
    vli.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Xir);
    this.jdField_a_of_type_Xiu = new xiu(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xiu);
    this.jdField_a_of_type_Xjc = new xjc(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xjc);
    this.jdField_a_of_type_Xjd = new xjd(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xjd);
    this.jdField_a_of_type_Xje = new xje(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xje);
    this.jdField_a_of_type_Xix = new xix(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xix);
    this.jdField_a_of_type_Xiv = new xiv(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xiv);
    this.jdField_a_of_type_Xiz = new xiz(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xiz);
    this.jdField_a_of_type_Xjb = new xjb(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xjb);
    this.jdField_a_of_type_Xiy = new xiy(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xiy);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Xis);
    this.jdField_a_of_type_Xhc = new xhc(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
    this.jdField_a_of_type_Vuj = ((vuj)vux.a(15));
    this.jdField_a_of_type_Vtu = ((vtu)vux.a(17));
    this.jdField_a_of_type_Xnv = ((xnv)vux.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xhw.a();
  }
  
  public void g()
  {
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xiw);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xja);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xir);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xiu);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xjc);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xjd);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xje);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xix);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xiv);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xiz);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xjb);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xiy);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Xis);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Xhj = null;
    this.jdField_b_of_type_Xhj = null;
    if (this.jdField_a_of_type_Xhc != null) {
      this.jdField_a_of_type_Xhc.c();
    }
    if (this.jdField_a_of_type_Xhs != null) {
      this.jdField_a_of_type_Xhs.d();
    }
    if (this.jdField_a_of_type_Xgn != null) {
      this.jdField_a_of_type_Xgn.d();
    }
    if (this.jdField_b_of_type_Xgn != null) {
      this.jdField_b_of_type_Xgn.d();
    }
  }
  
  public void g_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      wbl.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xin
 * JD-Core Version:    0.7.0.1
 */