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

public class xxi
  implements IEventReceiver, xvm, xwa, xwv
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wip jdField_a_of_type_Wip;
  private wje jdField_a_of_type_Wje;
  private xvi jdField_a_of_type_Xvi;
  private xvx jdField_a_of_type_Xvx;
  private xwc jdField_a_of_type_Xwc;
  private xwe jdField_a_of_type_Xwe;
  private xwn jdField_a_of_type_Xwn;
  private xxm jdField_a_of_type_Xxm;
  protected xxn a;
  private xxp jdField_a_of_type_Xxp;
  private xxq jdField_a_of_type_Xxq;
  private xxr jdField_a_of_type_Xxr;
  private xxs jdField_a_of_type_Xxs;
  private xxt jdField_a_of_type_Xxt;
  private xxu jdField_a_of_type_Xxu;
  private xxv jdField_a_of_type_Xxv;
  private xxw jdField_a_of_type_Xxw;
  private xxx jdField_a_of_type_Xxx;
  private xxy jdField_a_of_type_Xxy;
  private xxz jdField_a_of_type_Xxz;
  private yck jdField_a_of_type_Yck;
  private ycq jdField_a_of_type_Ycq;
  private final int jdField_b_of_type_Int;
  private xvi jdField_b_of_type_Xvi;
  private xwe jdField_b_of_type_Xwe;
  private int c = -1;
  
  public xxi(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Xxn = new xxn(this.jdField_a_of_type_JavaLangString, new xxj(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    wgy localwgy;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwgy = new wgy(2, paramCommentEntry.feedId, paramInt);
      localwgy.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwgy;; paramCommentEntry = new wgy(2, this.jdField_a_of_type_Xwc.a.feedId, paramInt, this.jdField_a_of_type_Xwc.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Xwc.a;
      wad.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xwc.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Xwc.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xwc.a));
    this.jdField_a_of_type_Wip.d(paramCommentEntry);
    whi.a().a();
    QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131713790), 0).a();
    a(this.jdField_a_of_type_Xwc);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xwc, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = ykv.b(this.jdField_a_of_type_Xwc.a);
    if ((this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Xwc.a.getOwner().getUnionId();; str = "")
    {
      ykv.a("home_page", paramString, ykv.a(this.jdField_a_of_type_Xwc.a), 0, new String[] { String.valueOf(i), ykv.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xwc.a.feedId, str });
      return;
    }
  }
  
  private void a(xwc paramxwc)
  {
    if (paramxwc == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramxwc.a()) {
          break label39;
        }
        if (!paramxwc.b()) {
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
    String str = wzk.a().getCurrentUin();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((wke)wjs.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Xwc.a.mHadLike = 1;
      this.jdField_a_of_type_Xwc.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xwc.a);
      this.jdField_a_of_type_Wje.a(localLikeEntry);
    }
    for (;;)
    {
      ykq.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Xwc.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Xwc.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Xwc.b(true)), Integer.valueOf(this.jdField_a_of_type_Xwc.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Xwc.b(false)), Integer.valueOf(this.jdField_a_of_type_Xwc.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Xwc.a.mHadLike = 0;
      this.jdField_a_of_type_Xwc.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xwc.a);
      this.jdField_a_of_type_Wje.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(xwc paramxwc)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = ykv.a(paramxwc.a);
      if (!paramxwc.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      ykv.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramxwc.a.feedId });
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
  
  private static void b(@NonNull xxi paramxxi, @NonNull String paramString1, String paramString2)
  {
    if (paramxxi.jdField_a_of_type_Xwc == null) {
      ykq.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      ykq.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramxxi.jdField_a_of_type_Xwc.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramxxi.jdField_a_of_type_Xwc.a().remove(localStoryVideoItem);
      ykq.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramxxi.jdField_a_of_type_Xwc.a().size()));
      if (paramxxi.jdField_a_of_type_Xwc.a().size() == 0) {
        paramxxi.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramxxi.k();
        return;
        paramxxi.a();
      }
    }
    ykq.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramxxi.jdField_a_of_type_Xwc.a().size()) });
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
        } while (this.jdField_a_of_type_Xwe != null);
        this.jdField_a_of_type_Xwe = new xwe(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Xwe != null);
      this.jdField_b_of_type_Xwe = new xwe(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Xwe != null);
    this.jdField_a_of_type_Xwe = new xwe(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Xvi != null);
        this.jdField_a_of_type_Xvi = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Xvi != null);
      this.jdField_b_of_type_Xvi = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Xvi != null);
    this.jdField_a_of_type_Xvi = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Xwc.a())
    {
      d(-1);
      this.jdField_a_of_type_Xwe.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Xwe.a(true);
    d(2);
    this.jdField_a_of_type_Xwe.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Xwc.a()) {
      if (this.jdField_a_of_type_Xwc.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Xvi.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Xwc.a(false))
      {
        e(1);
        this.jdField_b_of_type_Xvi.c();
      }
    } while (!this.jdField_a_of_type_Xwc.a(true));
    e(2);
    this.jdField_a_of_type_Xvi.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ykq.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    ykq.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    wjv localwjv = (wjv)wjs.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localwjv.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((wjv)wjs.a(27)).a(this.jdField_a_of_type_Xwc.a.feedId, this.jdField_a_of_type_Xwc.a());
    this.jdField_a_of_type_Xwc.b(localList, true);
    ykq.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Xwc.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Xvi != null) {
      this.jdField_a_of_type_Xvi.b(this.jdField_a_of_type_Xwc.a(true));
    }
    if (this.jdField_b_of_type_Xvi != null) {
      this.jdField_b_of_type_Xvi.b(this.jdField_a_of_type_Xwc.a(false));
    }
    if (this.jdField_a_of_type_Xwn != null)
    {
      if (!this.jdField_a_of_type_Xwc.c()) {
        ykq.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Xwc.a().getVideoInfo();
    this.jdField_a_of_type_Xwn.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void J_()
  {
    ykq.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Xvi.c();
    }
    for (;;)
    {
      ykv.a("home_page", "load_detail", 0, 0, new String[] { "", ykv.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Xvi.c();
    }
  }
  
  public void K_()
  {
    ykq.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131713789), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Xwc.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Xwc.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, weg.a(2131699191), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Xwc.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      wgz.a(this.jdField_a_of_type_Xwc.a, bool1, -1, 0);
      a(bool1, bool2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      a(3, null);
      a("clk_like");
      return;
    }
  }
  
  public void L_()
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
    ykq.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Xwc, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ykv.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", ykv.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xwc.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ykq.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    weg.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Xwc.a(bool)) && (this.jdField_a_of_type_Xwc.a(bool) == null))
    {
      CommentEntry localCommentEntry = xwr.a(this.jdField_a_of_type_Xwc.a(bool) - this.jdField_a_of_type_Xwc.a(bool).size());
      this.jdField_a_of_type_Xwc.c(localCommentEntry, bool);
      this.jdField_a_of_type_Xwc.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Xwc.a(paramCommentEntry, bool);
    ykq.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Xwc.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Xwc.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Xwc.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Xwc.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131713793), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      L_();
      this.jdField_a_of_type_Xwc.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xwc.a));
      if (!this.jdField_a_of_type_Xwc.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Wip.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Xwc.a.getCommentLikeType();
      this.jdField_a_of_type_Wip.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xwr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xwr.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(xwc paramxwc, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      ykq.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramxwc);
    if ((this.jdField_a_of_type_Xwc == null) && (paramErrorMessage.isSuccess())) {
      b(paramxwc);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xwc = paramxwc;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xwc, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramxwc = this.jdField_a_of_type_Xwc.toString();; paramxwc = "null")
    {
      ykq.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramxwc);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xwc = paramxwc;
        l();
        if ((this.jdField_a_of_type_Xwc.d()) && (!this.jdField_a_of_type_Xwc.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xwc, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramxwc, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Xwc == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xvx.a();
      return;
    }
    this.jdField_a_of_type_Xvx.b();
  }
  
  public void b()
  {
    ykq.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Xwn == null)
    {
      if (!this.jdField_a_of_type_Xwc.c())
      {
        ykq.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Xwn = new xwn(2, this.jdField_a_of_type_Xwc.a().getVideoInfo());
      this.jdField_a_of_type_Xwn.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Xwn.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Xwc.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131713792), 0).a();
      ykq.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    wfy.a(localCommentEntry, new xxl(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wgm.a(this.jdField_a_of_type_Xwc.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new xxk(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xwr == null) {
      return;
    }
    if ((this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.a != null)) {
      if (!this.jdField_a_of_type_Xwc.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      ykv.a("home_page", "press_reply", 0, 0, new String[] { str, ykv.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xwr.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Xwc, a()));
  }
  
  public void c()
  {
    zhm localzhm = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzhm != null) {
      localzhm.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      ykq.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    ykq.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    zhm localzhm = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzhm != null)
    {
      if (this.jdField_a_of_type_Xwc.a(a())) {
        localzhm.a(false);
      }
    }
    else {
      return;
    }
    localzhm.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Xxr = new xxr(this);
    wad.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Xxr);
    this.jdField_a_of_type_Xxv = new xxv(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxv);
    this.jdField_a_of_type_Xxm = new xxm(this);
    wad.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Xxm);
    this.jdField_a_of_type_Xxp = new xxp(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxp);
    this.jdField_a_of_type_Xxx = new xxx(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxx);
    this.jdField_a_of_type_Xxy = new xxy(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxy);
    this.jdField_a_of_type_Xxz = new xxz(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxz);
    this.jdField_a_of_type_Xxs = new xxs(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxs);
    this.jdField_a_of_type_Xxq = new xxq(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxq);
    this.jdField_a_of_type_Xxu = new xxu(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxu);
    this.jdField_a_of_type_Xxw = new xxw(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxw);
    this.jdField_a_of_type_Xxt = new xxt(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xxt);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Xxn);
    this.jdField_a_of_type_Xvx = new xvx(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
    this.jdField_a_of_type_Wje = ((wje)wjs.a(15));
    this.jdField_a_of_type_Wip = ((wip)wjs.a(17));
    this.jdField_a_of_type_Ycq = ((ycq)wjs.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Xwr.a();
  }
  
  public void g()
  {
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxr);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxv);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxm);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxp);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxx);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxy);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxz);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxs);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxq);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxu);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxw);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xxt);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Xxn);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Xwe = null;
    this.jdField_b_of_type_Xwe = null;
    if (this.jdField_a_of_type_Xvx != null) {
      this.jdField_a_of_type_Xvx.c();
    }
    if (this.jdField_a_of_type_Xwn != null) {
      this.jdField_a_of_type_Xwn.d();
    }
    if (this.jdField_a_of_type_Xvi != null) {
      this.jdField_a_of_type_Xvi.d();
    }
    if (this.jdField_b_of_type_Xvi != null) {
      this.jdField_b_of_type_Xvi.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      wqg.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxi
 * JD-Core Version:    0.7.0.1
 */