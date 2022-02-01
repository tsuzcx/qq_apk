package com.tencent.biz.qqstory.storyHome.atvideo.view;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.b;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pml;
import psx;
import qrk;
import qrn;
import qrs;
import qrs.b;
import qru;
import qrz;
import qrz.b;
import qtf;
import qvi;
import qvi.a;
import qyk;
import ram;
import rar;
import rpq;
import rsn.a;

public class StoryAtVideoFragment
  extends QQStoryBaseFragment
  implements QQStoryAutoPlayView.a, StoryHomeHorizontalListView.b, qrn, qrs.b, rsn.a
{
  public QQStoryAutoPlayView a;
  public StoryHomeHorizontalListView a;
  public qrk a;
  public qrs a;
  public qru a;
  public qvi a;
  public String ayk;
  public qrz b;
  public ViewGroup cq;
  public RelativeLayout fP;
  public String mFeedId;
  public TextView mTimeText;
  public TextView xO;
  
  public static void c(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_at_video_feed_id", paramString1);
    localIntent.putExtra("extra_at_video_scroll_to_feed_id", paramString2);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, StoryAtVideoFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772367, 2130772002);
  }
  
  public void O(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new b(this), "StoryDetailPresenter");
    paramMap.put(new a(this), "");
  }
  
  public boolean R(boolean paramBoolean)
  {
    ram.d("Q.qqstory.atvideo.StoryAtVideoFragment", "load more video");
    bpV();
    return true;
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    qrk.a(getActivity(), paramVideoListFeedItem, paramStoryVideoItem);
    getActivity().finish();
  }
  
  public void a(qru paramqru, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (isFinishing())
    {
      ram.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    boolean bool;
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        d(paramqru);
      }
      refreshData(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label149;
      }
    }
    label149:
    for (paramqru = this.jdField_a_of_type_Qru.toString();; paramqru = "null")
    {
      ram.a("Q.qqstory.atvideo.StoryAtVideoFragment", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramqru);
      return;
      if (!paramErrorMessage.isSuccess()) {
        break;
      }
      if (this.b != null)
      {
        if (!this.jdField_a_of_type_Qru.Kn())
        {
          ram.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Qru.b().getVideoInfo();
        this.b.m(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      d(paramqru);
      break;
    }
  }
  
  public void aM(int paramInt, String paramString) {}
  
  public void aXi() {}
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void bmr() {}
  
  public void bpV()
  {
    ram.i("Q.qqstory.atvideo.StoryAtVideoFragment", "request load next page video.");
    if (this.b == null)
    {
      if (!this.jdField_a_of_type_Qru.Kn())
      {
        ram.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.b = new qrz(2, this.jdField_a_of_type_Qru.b().getVideoInfo());
      this.b.rV("StoryDetailPresenter");
    }
    this.b.aPh();
  }
  
  public void bpW() {}
  
  public void bpX() {}
  
  public void c(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void d(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void d(qru paramqru)
  {
    int j = -7829368;
    int i = 0;
    if ((paramqru == null) || (!paramqru.Kn())) {
      ram.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
    }
    label270:
    label734:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Qru = paramqru;
      ram.d("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramqru.toString());
      if ((this.jdField_a_of_type_Qru.d == null) || (this.jdField_a_of_type_Qru.bS().isEmpty()))
      {
        this.fP.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.cq.setVisibility(0);
        return;
      }
      if (this.jdField_a_of_type_Qru.bS().size() == 1)
      {
        localObject1 = (StoryVideoItem)this.jdField_a_of_type_Qru.bS().get(0);
        if ((((StoryVideoItem)localObject1).isUploading()) || (((StoryVideoItem)localObject1).isUploadFail()))
        {
          this.fP.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
          this.cq.setVisibility(0);
          return;
        }
        this.fP.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.cq.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_Qru.b(), (StoryVideoItem)localObject1, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setStoryCoverClickListener(this);
        qyk.a((StoryVideoItem)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView, "QQStory_feed");
        paramqru = this.mTimeText;
        if (((StoryVideoItem)localObject1).mHadRead == 1)
        {
          i = -7829368;
          paramqru.setTextColor(i);
          paramqru = this.xO;
          if (((StoryVideoItem)localObject1).mHadRead != 1) {
            break label353;
          }
          i = j;
          paramqru.setTextColor(i);
          if (((StoryVideoItem)localObject1).mTimeZoneOffsetMillis == 2147483647L) {
            break label360;
          }
        }
        label353:
        label360:
        for (paramqru = rpq.f(((StoryVideoItem)localObject1).mCreateTime, ((StoryVideoItem)localObject1).mTimeZoneOffsetMillis);; paramqru = rpq.aM(((StoryVideoItem)localObject1).mCreateTime))
        {
          this.mTimeText.setText(paramqru);
          if (!(this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) {
            break label372;
          }
          this.xO.setVisibility(0);
          this.xO.setText(((StoryVideoItem)localObject1).mOwnerName);
          return;
          i = -16777216;
          break;
          i = -16777216;
          break label270;
        }
        label372:
        this.xO.setVisibility(8);
        return;
      }
      this.fP.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(0);
      this.cq.setVisibility(8);
      if (this.jdField_a_of_type_Qrk == null)
      {
        this.jdField_a_of_type_Qrk = new qrk(getActivity(), getActivity(), 0, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_Qrk);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131298963));
      }
      paramqru = this.jdField_a_of_type_Qru.bS();
      Object localObject1 = new ArrayList();
      if (!paramqru.isEmpty())
      {
        localObject2 = paramqru.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
          if ((!localStoryVideoItem.isUploading()) && (!localStoryVideoItem.isUploadFail())) {
            ((List)localObject1).add(localStoryVideoItem);
          }
        }
      }
      this.jdField_a_of_type_Qrk.a((List)localObject1, this.jdField_a_of_type_Qru.b());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(((List)localObject1).size());
      Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      boolean bool;
      if (!this.jdField_a_of_type_Qru.b().mIsVideoEnd)
      {
        bool = true;
        ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(bool);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnLoadMoreListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnScrollChangeListener(this);
        if ((paramqru.size() != ((List)localObject1).size()) || (TextUtils.isEmpty(this.ayk))) {}
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Qru.bS().size()) {
            break label734;
          }
          if (((StoryVideoItem)this.jdField_a_of_type_Qru.bS().get(i)).mVid.equals(this.ayk))
          {
            ram.d("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.resetCurrentX(qtf.r(getActivity(), i));
            return;
            bool = false;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public void dh(int paramInt1, int paramInt2)
  {
    this.ayk = null;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    this.mFeedId = paramLayoutInflater.getString("extra_at_video_feed_id");
    this.ayk = paramLayoutInflater.getString("extra_at_video_scroll_to_feed_id");
    setTitle(acfp.m(2131714821));
    setLeftButton(acfp.m(2131714820), null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)$(2131363030));
    this.fP = ((RelativeLayout)$(2131375142));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)$(2131375139));
    this.mTimeText = ((TextView)$(2131375141));
    this.xO = ((TextView)$(2131375140));
    this.cq = ((ViewGroup)$(2131375116));
    this.jdField_a_of_type_Qvi = ((qvi)psx.a(12));
    this.jdField_a_of_type_Qrs = new qrs(this.mFeedId, this, false);
    refreshData(true);
    rar.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public int getContentLayoutId()
  {
    return 2131561799;
  }
  
  public boolean onBackEvent()
  {
    qrk.a(getActivity(), null, null);
    rar.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Qrs != null) {
      this.jdField_a_of_type_Qrs.terminate();
    }
    if (this.b != null) {
      this.b.terminate();
    }
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
  
  public void wu(int paramInt) {}
  
  public static class a
    extends pml<StoryAtVideoFragment, qvi.a>
  {
    public a(StoryAtVideoFragment paramStoryAtVideoFragment)
    {
      super();
    }
    
    public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull qvi.a parama)
    {
      if ((parama.bnP == 2) || (!parama.mFeedId.equals(paramStoryAtVideoFragment.mFeedId)) || (paramStoryAtVideoFragment.jdField_a_of_type_Qru == null))
      {
        ram.d(this.TAG, "ignore this video cookie change event. %s.", parama.toString());
        return;
      }
      if (!paramStoryAtVideoFragment.jdField_a_of_type_Qru.Kn())
      {
        ram.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { parama.toString() });
        return;
      }
      parama = paramStoryAtVideoFragment.jdField_a_of_type_Qvi.a(paramStoryAtVideoFragment.mFeedId, paramStoryAtVideoFragment.jdField_a_of_type_Qru.b().mVideoPullType);
      if (parama == null)
      {
        ram.e(this.TAG, "can't find video info for feedId:%s, pullType:%d.", new Object[] { paramStoryAtVideoFragment.mFeedId, Integer.valueOf(paramStoryAtVideoFragment.jdField_a_of_type_Qru.b().mVideoPullType) });
        return;
      }
      ram.b(this.TAG, "receive video cookie change event. %s.", parama.toString());
      paramStoryAtVideoFragment.jdField_a_of_type_Qru.b().updateVideoInfo(parama);
      paramStoryAtVideoFragment.jdField_a_of_type_Qru.I(parama.mVideoItemList, true);
      if (paramStoryAtVideoFragment.b != null) {
        paramStoryAtVideoFragment.b.m(parama.mVideoPullType, parama.mVideoNextCookie, parama.mVideoSeq);
      }
      paramStoryAtVideoFragment.d(paramStoryAtVideoFragment.jdField_a_of_type_Qru);
    }
    
    public Class acceptEventClass()
    {
      return qvi.a.class;
    }
    
    public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull qvi.a parama) {}
  }
  
  public static class b
    extends pml<StoryAtVideoFragment, qrz.b>
  {
    b(StoryAtVideoFragment paramStoryAtVideoFragment)
    {
      super();
    }
    
    public void a(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull qrz.b paramb)
    {
      if ((!paramb.mFeedId.equals(paramStoryAtVideoFragment.mFeedId)) || (paramb.b.isFail()) || (paramStoryAtVideoFragment.jdField_a_of_type_Qru == null))
      {
        ram.d(this.TAG, "ignore this comment list event. %s.", paramb.toString());
        return;
      }
      if (!paramStoryAtVideoFragment.jdField_a_of_type_Qru.Kn())
      {
        ram.e(this.TAG, "this feed does not support video list.ignore this comment list event. %s.", new Object[] { paramb.toString() });
        return;
      }
      ram.b(this.TAG, "receive comment list event. %s.", paramb.toString());
      paramStoryAtVideoFragment.jdField_a_of_type_Qru.I(paramb.oj, paramb.isFirstPage);
      paramStoryAtVideoFragment.jdField_a_of_type_Qru.b().updateVideoInfo(paramb.a);
      if (paramStoryAtVideoFragment.jdField_a_of_type_Qru.bS().size() < 1)
      {
        paramStoryAtVideoFragment.cq.setVisibility(0);
        paramStoryAtVideoFragment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        paramStoryAtVideoFragment.fP.setVisibility(8);
        return;
      }
      paramStoryAtVideoFragment.d(paramStoryAtVideoFragment.jdField_a_of_type_Qru);
    }
    
    public Class acceptEventClass()
    {
      return qrz.b.class;
    }
    
    public void b(@NonNull StoryAtVideoFragment paramStoryAtVideoFragment, @NonNull qrz.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */