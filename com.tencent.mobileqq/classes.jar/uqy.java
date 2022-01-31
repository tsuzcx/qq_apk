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

public class uqy
  implements IEventReceiver, upc, upq, uql
{
  private final int jdField_a_of_type_Int;
  private final StoryDetailFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment;
  private final String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private tbz jdField_a_of_type_Tbz;
  private tco jdField_a_of_type_Tco;
  private uoy jdField_a_of_type_Uoy;
  private upn jdField_a_of_type_Upn;
  private ups jdField_a_of_type_Ups;
  private upu jdField_a_of_type_Upu;
  private uqd jdField_a_of_type_Uqd;
  private urc jdField_a_of_type_Urc;
  protected urd a;
  private urf jdField_a_of_type_Urf;
  private urg jdField_a_of_type_Urg;
  private urh jdField_a_of_type_Urh;
  private uri jdField_a_of_type_Uri;
  private urj jdField_a_of_type_Urj;
  private urk jdField_a_of_type_Urk;
  private url jdField_a_of_type_Url;
  private urm jdField_a_of_type_Urm;
  private urn jdField_a_of_type_Urn;
  private uro jdField_a_of_type_Uro;
  private urp jdField_a_of_type_Urp;
  private uwa jdField_a_of_type_Uwa;
  private uwg jdField_a_of_type_Uwg;
  private final int jdField_b_of_type_Int;
  private uoy jdField_b_of_type_Uoy;
  private upu jdField_b_of_type_Upu;
  private int c = -1;
  
  public uqy(StoryDetailFragment paramStoryDetailFragment, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment = paramStoryDetailFragment;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Urd = new urd(this.jdField_a_of_type_JavaLangString, new uqz(this));
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    tah localtah;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localtah = new tah(2, paramCommentEntry.feedId, paramInt);
      localtah.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localtah;; paramCommentEntry = new tah(2, this.jdField_a_of_type_Ups.a.feedId, paramInt, this.jdField_a_of_type_Ups.a))
    {
      paramCommentEntry.a = this.jdField_a_of_type_Ups.a;
      ste.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ups.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ups.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Ups.a));
    this.jdField_a_of_type_Tbz.d(paramCommentEntry);
    tar.a().a();
    bcpw.a(BaseApplication.getContext(), 2, ajyc.a(2131714406), 0).a();
    a(this.jdField_a_of_type_Ups);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ups, a());
    a(2, paramCommentEntry);
  }
  
  private void a(String paramString)
  {
    int i = vel.b(this.jdField_a_of_type_Ups.a);
    if ((this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) {}
    for (String str = this.jdField_a_of_type_Ups.a.getOwner().getUnionId();; str = "")
    {
      vel.a("home_page", paramString, vel.a(this.jdField_a_of_type_Ups.a), 0, new String[] { String.valueOf(i), vel.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ups.a.feedId, str });
      return;
    }
  }
  
  private void a(ups paramups)
  {
    if (paramups == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramups.a()) {
          break label39;
        }
        if (!paramups.b()) {
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
    String str = tsu.a().c();
    LikeEntry localLikeEntry = new LikeEntry();
    localLikeEntry.likeTime = System.currentTimeMillis();
    localLikeEntry.uin = str;
    localLikeEntry.unionId = ((String)localObject);
    localLikeEntry.feedId = this.jdField_a_of_type_JavaLangString;
    localObject = ((tdo)tdc.a(2)).b((String)localObject);
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
      this.jdField_a_of_type_Ups.a.mHadLike = 1;
      this.jdField_a_of_type_Ups.a(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Ups.a);
      this.jdField_a_of_type_Tco.a(localLikeEntry);
    }
    for (;;)
    {
      veg.b("Q.qqstory.detail.StoryDetailPresenter", "update like data. mHadLike=%d, mLikeCount=%d, mFanLikeCount=%d, mLikeEntryList=%d, mFriendLikeCount=%d, mFriendLikeList=%d.", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ups.a.mHadLike), Integer.valueOf(this.jdField_a_of_type_Ups.a.mLikeCount), Integer.valueOf(this.jdField_a_of_type_Ups.b(true)), Integer.valueOf(this.jdField_a_of_type_Ups.b(true).size()), Integer.valueOf(this.jdField_a_of_type_Ups.b(false)), Integer.valueOf(this.jdField_a_of_type_Ups.b(false).size()) });
      return;
      l = 0L;
      break;
      label260:
      this.jdField_a_of_type_Ups.a.mHadLike = 0;
      this.jdField_a_of_type_Ups.b(localLikeEntry, paramBoolean2);
      this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Ups.a);
      this.jdField_a_of_type_Tco.b(localLikeEntry);
    }
  }
  
  private boolean a()
  {
    return (this.c == -1) || (this.c == 2);
  }
  
  private void b(ups paramups)
  {
    String str1 = "";
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = vel.a(paramups.a);
      if (!paramups.a.getOwner().isMe()) {
        break;
      }
    }
    for (String str2 = "1";; str2 = "2")
    {
      vel.a("home_page", "exp_detail", i, 0, new String[] { str2, str1, "", paramups.a.feedId });
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
  
  private static void b(@NonNull uqy paramuqy, @NonNull String paramString1, String paramString2)
  {
    if (paramuqy.jdField_a_of_type_Ups == null) {
      veg.b(paramString2, "ignore this video delete event. %s.", paramString1);
    }
    for (;;)
    {
      return;
      veg.a(paramString2, "receive video delete event. %s.", paramString1);
      Iterator localIterator = paramuqy.jdField_a_of_type_Ups.a().iterator();
      StoryVideoItem localStoryVideoItem;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStoryVideoItem = (StoryVideoItem)localIterator.next();
      } while (!localStoryVideoItem.mVid.equals(paramString1));
      paramuqy.jdField_a_of_type_Ups.a().remove(localStoryVideoItem);
      veg.a(paramString2, "video list's size is %d after delete video.", Integer.valueOf(paramuqy.jdField_a_of_type_Ups.a().size()));
      if (paramuqy.jdField_a_of_type_Ups.a().size() == 0) {
        paramuqy.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
      }
      while (localStoryVideoItem.mTagInfoBase != null)
      {
        paramuqy.k();
        return;
        paramuqy.a();
      }
    }
    veg.d(paramString2, "can't find the video that should be deleted. video list's size is %d.", new Object[] { Integer.valueOf(paramuqy.jdField_a_of_type_Ups.a().size()) });
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
        } while (this.jdField_a_of_type_Upu != null);
        this.jdField_a_of_type_Upu = new upu(this.jdField_a_of_type_JavaLangString, true);
        return;
      } while (this.jdField_b_of_type_Upu != null);
      this.jdField_b_of_type_Upu = new upu(this.jdField_a_of_type_JavaLangString, true, 0);
      return;
    } while (this.jdField_a_of_type_Upu != null);
    this.jdField_a_of_type_Upu = new upu(this.jdField_a_of_type_JavaLangString, true, 1);
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
        } while (this.jdField_a_of_type_Uoy != null);
        this.jdField_a_of_type_Uoy = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(true)), "StoryDetailPresenter");
        return;
      } while (this.jdField_b_of_type_Uoy != null);
      this.jdField_b_of_type_Uoy = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(false), 0), "StoryDetailPresenter");
      return;
    } while (this.jdField_a_of_type_Uoy != null);
    this.jdField_a_of_type_Uoy = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(true), 1), "StoryDetailPresenter");
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_Ups.a())
    {
      d(-1);
      this.jdField_a_of_type_Upu.a(true);
      return;
    }
    d(1);
    this.jdField_b_of_type_Upu.a(true);
    d(2);
    this.jdField_a_of_type_Upu.a(true);
  }
  
  private void j()
  {
    if (!this.jdField_a_of_type_Ups.a()) {
      if (this.jdField_a_of_type_Ups.a(true))
      {
        e(-1);
        this.jdField_a_of_type_Uoy.c();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ups.a(false))
      {
        e(1);
        this.jdField_b_of_type_Uoy.c();
      }
    } while (!this.jdField_a_of_type_Ups.a(true));
    e(2);
    this.jdField_a_of_type_Uoy.c();
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      veg.e("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list error because feedId is null.");
      return;
    }
    veg.b("Q.qqstory.detail.StoryDetailPresenter", "refresh tag list.");
    tdf localtdf = (tdf)tdc.a(27);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localtdf.a(localArrayList);
  }
  
  private void l()
  {
    List localList = ((tdf)tdc.a(27)).a(this.jdField_a_of_type_Ups.a.feedId, this.jdField_a_of_type_Ups.a());
    this.jdField_a_of_type_Ups.b(localList, true);
    veg.b("Q.qqstory.detail.StoryDetailPresenter", "after merging tag list from db. mFeedItem.getTagList()=%s", this.jdField_a_of_type_Ups.b());
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Uoy != null) {
      this.jdField_a_of_type_Uoy.b(this.jdField_a_of_type_Ups.a(true));
    }
    if (this.jdField_b_of_type_Uoy != null) {
      this.jdField_b_of_type_Uoy.b(this.jdField_a_of_type_Ups.a(false));
    }
    if (this.jdField_a_of_type_Uqd != null)
    {
      if (!this.jdField_a_of_type_Ups.c()) {
        veg.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
      }
    }
    else {
      return;
    }
    FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Ups.a().getVideoInfo();
    this.jdField_a_of_type_Uqd.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
  }
  
  public void L_()
  {
    veg.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page comment.");
    e(this.c);
    if (a()) {
      this.jdField_a_of_type_Uoy.c();
    }
    for (;;)
    {
      vel.a("home_page", "load_detail", 0, 0, new String[] { "", vel.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_b_of_type_Uoy.c();
    }
  }
  
  public void M_()
  {
    veg.b("Q.qqstory.detail.StoryDetailPresenter", "on like button click.");
    if (!bbev.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131714405), 0).a();
      return;
    }
    if (((this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) && (!((ShareGroupItem)this.jdField_a_of_type_Ups.a.getOwner()).isPublic()) && (!this.jdField_a_of_type_Ups.a.getOwner().isSubscribe()))
    {
      bcpw.a(BaseApplication.getContext(), 1, sxp.a(2131699680), 0).a();
      return;
    }
    if (this.jdField_a_of_type_Ups.a.mHadLike == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = a();
      tai.a(this.jdField_a_of_type_Ups.a, bool1, -1, 0);
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
    veg.a("Q.qqstory.detail.StoryDetailPresenter", "on tab click. tabType = %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b(this.jdField_a_of_type_Ups, a());
    if (a()) {}
    for (paramInt = 2;; paramInt = 1)
    {
      vel.a("content_flow", "clk_detail_reply", 0, paramInt, new String[] { "", vel.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ups.a.feedId });
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    veg.a("Q.qqstory.detail.StoryDetailPresenter", "on nick click. unionId = %s.", paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity() == null) {
      return;
    }
    sxp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity(), 12, paramString);
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
    if ((!this.jdField_a_of_type_Ups.a(bool)) && (this.jdField_a_of_type_Ups.a(bool) == null))
    {
      CommentEntry localCommentEntry = uqh.a(this.jdField_a_of_type_Ups.a(bool) - this.jdField_a_of_type_Ups.a(bool).size());
      this.jdField_a_of_type_Ups.c(localCommentEntry, bool);
      this.jdField_a_of_type_Ups.a(localCommentEntry, bool);
    }
    this.jdField_a_of_type_Ups.a(paramCommentEntry, bool);
    veg.b("Q.qqstory.detail.StoryDetailPresenter", "after add comment. mCommentCount = %d, mFanCommentCount = %d, mFanCommentCount = %d.", Integer.valueOf(this.jdField_a_of_type_Ups.a.mCommentCount), Integer.valueOf(this.jdField_a_of_type_Ups.a.mFanCommentCount), Integer.valueOf(this.jdField_a_of_type_Ups.a.mFriendCommentCount));
    int i;
    if (this.jdField_a_of_type_Ups.a.mDenyComment == 1)
    {
      i = 1;
      if (i != 0)
      {
        bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131714409), 0).a();
        paramCommentEntry.status = 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
      N_();
      this.jdField_a_of_type_Ups.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Ups.a));
      if (!this.jdField_a_of_type_Ups.a()) {
        break label269;
      }
      if (!bool) {
        break label256;
      }
      paramCommentEntry.type = 4;
      paramCommentEntry.pbType = 1;
      label233:
      this.jdField_a_of_type_Tbz.a(paramCommentEntry);
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
      paramCommentEntry.pbType = this.jdField_a_of_type_Ups.a.getCommentLikeType();
      this.jdField_a_of_type_Tbz.b(paramCommentEntry);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqh == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqh.a(paramCommentEntry, paramInt, a());
  }
  
  public void a(ups paramups, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      veg.e("Q.qqstory.detail.StoryDetailPresenter", "feed data back after activity destroy.");
      return;
    }
    a(paramups);
    if ((this.jdField_a_of_type_Ups == null) && (paramErrorMessage.isSuccess())) {
      b(paramups);
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ups = paramups;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ups, a());
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label267;
      }
    }
    label267:
    for (paramups = this.jdField_a_of_type_Ups.toString();; paramups = "null")
    {
      veg.a("Q.qqstory.detail.StoryDetailPresenter", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramups);
      return;
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ups = paramups;
        l();
        if ((this.jdField_a_of_type_Ups.d()) && (!this.jdField_a_of_type_Ups.a().mIsVideoEnd)) {
          k();
        }
        m();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ups, a());
      }
      for (;;)
      {
        if ((paramErrorMessage.isSuccess()) || (paramErrorMessage.errorCode == 2222)) {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramups, a()));
        break;
        if (paramErrorMessage.errorCode == 2222) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        } else if (this.jdField_a_of_type_Ups == null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.b();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Upn.a();
      return;
    }
    this.jdField_a_of_type_Upn.b();
  }
  
  public void b()
  {
    veg.c("Q.qqstory.detail.StoryDetailPresenter", "request load next page video.");
    if (this.jdField_a_of_type_Uqd == null)
    {
      if (!this.jdField_a_of_type_Ups.c())
      {
        veg.e("Q.qqstory.detail.StoryDetailPresenter", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Uqd = new uqd(2, this.jdField_a_of_type_Ups.a().getVideoInfo());
      this.jdField_a_of_type_Uqd.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Uqd.c();
  }
  
  public void b(int paramInt)
  {
    boolean bool = a();
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ups.a(bool).get(paramInt);
    if (localCommentEntry.status != 0)
    {
      a(localCommentEntry, bool);
      return;
    }
    if (!bbev.d(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.getActivity()))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131714408), 0).a();
      veg.d("Q.qqstory.detail.StoryDetailPresenter", "delete comment failed. invalidate network.");
      return;
    }
    localCommentEntry.status = 1;
    szh.a(localCommentEntry, new urb(this, localCommentEntry, bool));
  }
  
  public void b(CommentEntry paramCommentEntry)
  {
    szv.a(this.jdField_a_of_type_Ups.a, paramCommentEntry, false, this.jdField_a_of_type_Int, new ura(this));
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqh == null) {
      return;
    }
    if ((this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.a != null)) {
      if (!this.jdField_a_of_type_Ups.a.getOwner().isMe()) {
        break label95;
      }
    }
    label95:
    for (String str = "2";; str = "1")
    {
      vel.a("home_page", "press_reply", 0, 0, new String[] { str, vel.a(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqh.b(paramCommentEntry, paramInt, a());
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.c();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramBoolean, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(this.jdField_a_of_type_Ups, a()));
  }
  
  public void c()
  {
    wde localwde = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localwde != null) {
      localwde.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1) && (paramInt != -1))
    {
      veg.e("Q.qqstory.detail.StoryDetailPresenter", "set tab type failed. invalidate type : %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    veg.a("Q.qqstory.detail.StoryDetailPresenter", "set tab type to %d.", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public void d()
  {
    wde localwde = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailListView.a("StoryDetailFragment");
    if (localwde != null)
    {
      if (this.jdField_a_of_type_Ups.a(a())) {
        localwde.a(false);
      }
    }
    else {
      return;
    }
    localwde.a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Urh = new urh(this);
    ste.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Urh);
    this.jdField_a_of_type_Url = new url(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Url);
    this.jdField_a_of_type_Urc = new urc(this);
    ste.a().registerSubscriber("StoryDetailPresenter", this.jdField_a_of_type_Urc);
    this.jdField_a_of_type_Urf = new urf(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urf);
    this.jdField_a_of_type_Urn = new urn(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urn);
    this.jdField_a_of_type_Uro = new uro(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Uro);
    this.jdField_a_of_type_Urp = new urp(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urp);
    this.jdField_a_of_type_Uri = new uri(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Uri);
    this.jdField_a_of_type_Urg = new urg(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urg);
    this.jdField_a_of_type_Urk = new urk(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urk);
    this.jdField_a_of_type_Urm = new urm(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urm);
    this.jdField_a_of_type_Urj = new urj(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Urj);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_Urd);
    this.jdField_a_of_type_Upn = new upn(this.jdField_a_of_type_JavaLangString, this, true);
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    this.jdField_a_of_type_Tco = ((tco)tdc.a(15));
    this.jdField_a_of_type_Tbz = ((tbz)tdc.a(17));
    this.jdField_a_of_type_Uwg = ((uwg)tdc.a(12));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.jdField_a_of_type_Uqh.a();
  }
  
  public void f_(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewStoryDetailFragment.a(paramInt);
  }
  
  public void g()
  {
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urh);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Url);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urc);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urf);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urn);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uro);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urp);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uri);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urg);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urk);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urm);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Urj);
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_Urd);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Upu = null;
    this.jdField_b_of_type_Upu = null;
    if (this.jdField_a_of_type_Upn != null) {
      this.jdField_a_of_type_Upn.c();
    }
    if (this.jdField_a_of_type_Uqd != null) {
      this.jdField_a_of_type_Uqd.d();
    }
    if (this.jdField_a_of_type_Uoy != null) {
      this.jdField_a_of_type_Uoy.d();
    }
    if (this.jdField_b_of_type_Uoy != null) {
      this.jdField_b_of_type_Uoy.d();
    }
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      tjq.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqy
 * JD-Core Version:    0.7.0.1
 */