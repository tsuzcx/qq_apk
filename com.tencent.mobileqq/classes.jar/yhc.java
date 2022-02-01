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

public class yhc
  implements IEventReceiver, yfg, yfu, ygp
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private wse jdField_a_of_type_Wse;
  private wst jdField_a_of_type_Wst;
  private yfc jdField_a_of_type_Yfc;
  private yfr jdField_a_of_type_Yfr;
  private yfw jdField_a_of_type_Yfw;
  private yfy jdField_a_of_type_Yfy;
  private ygh jdField_a_of_type_Ygh;
  private yhg jdField_a_of_type_Yhg;
  protected yhh a;
  private yhj jdField_a_of_type_Yhj;
  private yhk jdField_a_of_type_Yhk;
  private yhl jdField_a_of_type_Yhl;
  private yhm jdField_a_of_type_Yhm;
  private yhn jdField_a_of_type_Yhn;
  private yho jdField_a_of_type_Yho;
  private yhp jdField_a_of_type_Yhp;
  private yhq jdField_a_of_type_Yhq;
  private yhr jdField_a_of_type_Yhr;
  private yhs jdField_a_of_type_Yhs;
  private yht jdField_a_of_type_Yht;
  private yme jdField_a_of_type_Yme;
  private ymk jdField_a_of_type_Ymk;
  private final int jdField_b_of_type_Int;
  private yfc jdField_b_of_type_Yfc;
  private yfy jdField_b_of_type_Yfy;
  private int c = -1;
  
  public yhc(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Yhh = new yhh(this.jdField_a_of_type_JavaLangString, new yhd(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    wqm localwqm;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwqm = new wqm(2, paramCommentEntry.feedId, paramInt);
      localwqm.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwqm;; paramCommentEntry = new wqm(2, this.jdField_a_of_type_Yfw.a.feedId, paramInt, this.jdField_a_of_type_Yfw.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Yfw.a;
      wjj.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yfw.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Yfw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Yfw.a));
    this.jdField_a_of_type_Wse.d(paramCommentEntry);
    wqw.a().a();
    QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131713211), 0).a();
    a(this.jdField_a_of_type_Yfw);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Yfw, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = yup.b(this.jdField_a_of_type_Yfw.a);
    if ((this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Yfw.a.getOwner().getUnionId();; str = "")
    {
      yup.a("home_page", paramString, yup.a(this.jdField_a_of_type_Yfw.a), 0, new String[] { String.valueOf(i), yup.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Yfw.a.feedId, str });
      return;
    }
  }
  
  private void a(yfw paramyfw)
  {
    if (paramyfw == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramyfw.a()) {
          break label39;
        }
        if (!paramyfw.b()) {
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
    String str = xiz.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((wtt)wth.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Yfw.a.mHadLike = 1;
      this.jdField_a_of_type_Yfw.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Yfw.a);
      this.jdField_a_of_type_Wst.a(localLikeEntry);
    }
    for (;;)
    {
      yuk.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yfw.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Yfw.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Yfw.b(true)), Integer.valueOf(this.jdField_a_of_type_Yfw.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Yfw.b(false)), Integer.valueOf(this.jdField_a_of_type_Yfw.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Yfw.a.mHadLike = 0;
      this.jdField_a_of_type_Yfw.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Yfw.a);
      this.jdField_a_of_type_Wst.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(yfw paramyfw)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = yup.a(paramyfw.a);
      if (!paramyfw.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      yup.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramyfw.a.feedId });
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
  
  private static void b(@NonNull yhc paramyhc, @NonNull String paramString1, String paramString2)
  {
    if (paramyhc.jdField_a_of_type_Yfw == null) {
      yuk.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      yuk.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramyhc.jdField_a_of_type_Yfw.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramyhc.jdField_a_of_type_Yfw.a().remove(localStoryVideoItem);
      yuk.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramyhc.jdField_a_of_type_Yfw.a().size()));
      if (paramyhc.jdField_a_of_type_Yfw.a().size() == 0) {
        paramyhc.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramyhc.k();
        return;
        paramyhc.a();
      }
    }
    yuk.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramyhc.jdField_a_of_type_Yfw.a().size()) });
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
        } while (this.jdField_a_of_type_Yfy != null);
        this.jdField_a_of_type_Yfy = new yfy(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Yfy != null);
      this.jdField_b_of_type_Yfy = new yfy(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Yfy != null);
    this.jdField_a_of_type_Yfy = new yfy(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Yfc != null);
        this.jdField_a_of_type_Yfc = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Yfc != null);
      this.jdField_b_of_type_Yfc = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Yfc != null);
    this.jdField_a_of_type_Yfc = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Yfw.a())
    {
      d(-1);
      this.jdField_a_of_type_Yfy.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Yfy.a(true);
    d(2);
    this.jdField_a_of_type_Yfy.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Yfw.a()) {
      if (this.jdField_a_of_type_Yfw.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Yfc.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Yfw.a(false))
      {
        e(1);
        this.jdField_b_of_type_Yfc.c();
      }
    } while (!this.jdField_a_of_type_Yfw.a(true));
    e(2);
    this.jdField_a_of_type_Yfc.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yuk.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    yuk.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    wtk localwtk = (wtk)wth.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localwtk.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((wtk)wth.a(27)).a(this.jdField_a_of_type_Yfw.a.feedId, this.jdField_a_of_type_Yfw.a());
    this.jdField_a_of_type_Yfw.b(localList, true);
    yuk.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Yfw.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Yfc != null) {
      this.jdField_a_of_type_Yfc.b(this.jdField_a_of_type_Yfw.a(true));
    }
    if (this.jdField_b_of_type_Yfc != null) {
      this.jdField_b_of_type_Yfc.b(this.jdField_a_of_type_Yfw.a(false));
    }
    if (this.jdField_a_of_type_Ygh != null)
    {
      if (!this.jdField_a_of_type_Yfw.c()) {
        yuk.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Yfw.a().getVideoInfo();
    this.jdField_a_of_type_Ygh.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void N_()
  {
    yuk.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Yfc.c();
    }
    for (;;)
    {
      yup.a("home_page", "load_detail", 0, 0, new String[] { "", yup.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Yfc.c();
    }
  }
  
  public void O_()
  {
    yuk.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131713210), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Yfw.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Yfw.a.getOwner().isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, wnu.a(2131698605), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Yfw.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      wqn.a(this.jdField_a_of_type_Yfw.a, bool1, -1, 0);
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
    yuk.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Yfw, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      yup.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", yup.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Yfw.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    yuk.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    wnu.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Yfw.a(bool)) && (this.jdField_a_of_type_Yfw.a(bool) == null))
    {
      CommentEntry localCommentEntry = ygl.a(this.jdField_a_of_type_Yfw.a(bool) - this.jdField_a_of_type_Yfw.a(bool).size());
      this.jdField_a_of_type_Yfw.c(localCommentEntry, bool);
      this.jdField_a_of_type_Yfw.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Yfw.a(paramCommentEntry, bool);
    yuk.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Yfw.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Yfw.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Yfw.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Yfw.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131713214), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      P_();
      this.jdField_a_of_type_Yfw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Yfw.a));
      if (!this.jdField_a_of_type_Yfw.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Wse.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Yfw.a.getCommentLikeType();
      this.jdField_a_of_type_Wse.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ygl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ygl.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(yfw paramyfw, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      yuk.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramyfw);
    if ((this.jdField_a_of_type_Yfw == null) && (paramErrorMessage.isSuccess())) {
      b(paramyfw);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Yfw = paramyfw;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Yfw, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramyfw = this.jdField_a_of_type_Yfw.toString();; paramyfw = "null")
    {
      yuk.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramyfw);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Yfw = paramyfw;
        l();
        if ((this.jdField_a_of_type_Yfw.d()) && (!this.jdField_a_of_type_Yfw.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Yfw, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramyfw, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Yfw == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Yfr.a();
      return;
    }
    this.jdField_a_of_type_Yfr.b();
  }
  
  public void b()
  {
    yuk.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Ygh == null)
    {
      if (!this.jdField_a_of_type_Yfw.c())
      {
        yuk.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Ygh = new ygh(2, this.jdField_a_of_type_Yfw.a().getVideoInfo());
      this.jdField_a_of_type_Ygh.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Ygh.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Yfw.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131713213), 0).a();
      yuk.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    wpm.a(localCommentEntry, new yhf(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    wqa.a(this.jdField_a_of_type_Yfw.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new yhe(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ygl == null) {
      return;
    }
    if ((this.jdField_a_of_type_Yfw != null) && (this.jdField_a_of_type_Yfw.a != null)) {
      if (!this.jdField_a_of_type_Yfw.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      yup.a("home_page", "press_reply", 0, 0, new String[] { str, yup.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ygl.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Yfw, a()));
  }
  
  public void c()
  {
    zti localzti = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzti != null) {
      localzti.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      yuk.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    yuk.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    zti localzti = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localzti != null)
    {
      if (this.jdField_a_of_type_Yfw.a(a())) {
        localzti.a(false);
      }
    }
    else {
      return;
    }
    localzti.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Yhl = new yhl(this);
    wjj.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Yhl);
    this.jdField_a_of_type_Yhp = new yhp(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhp);
    this.jdField_a_of_type_Yhg = new yhg(this);
    wjj.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Yhg);
    this.jdField_a_of_type_Yhj = new yhj(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhj);
    this.jdField_a_of_type_Yhr = new yhr(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhr);
    this.jdField_a_of_type_Yhs = new yhs(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhs);
    this.jdField_a_of_type_Yht = new yht(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yht);
    this.jdField_a_of_type_Yhm = new yhm(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhm);
    this.jdField_a_of_type_Yhk = new yhk(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhk);
    this.jdField_a_of_type_Yho = new yho(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yho);
    this.jdField_a_of_type_Yhq = new yhq(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhq);
    this.jdField_a_of_type_Yhn = new yhn(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yhn);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Yhh);
    this.jdField_a_of_type_Yfr = new yfr(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
    this.jdField_a_of_type_Wst = ((wst)wth.a(15));
    this.jdField_a_of_type_Wse = ((wse)wth.a(17));
    this.jdField_a_of_type_Ymk = ((ymk)wth.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Ygl.a();
  }
  
  public void g()
  {
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhl);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhp);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhg);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhj);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhr);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhs);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yht);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhm);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhk);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yho);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhq);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yhn);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Yhh);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Yfy = null;
    this.jdField_b_of_type_Yfy = null;
    if (this.jdField_a_of_type_Yfr != null) {
      this.jdField_a_of_type_Yfr.c();
    }
    if (this.jdField_a_of_type_Ygh != null) {
      this.jdField_a_of_type_Ygh.d();
    }
    if (this.jdField_a_of_type_Yfc != null) {
      this.jdField_a_of_type_Yfc.d();
    }
    if (this.jdField_b_of_type_Yfc != null) {
      this.jdField_b_of_type_Yfc.d();
    }
  }
  
  public void g_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      wzv.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhc
 * JD-Core Version:    0.7.0.1
 */