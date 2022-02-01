package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import afei;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
import pmi;
import ppg.c;
import psu;
import psx;
import ptk;
import pyg;
import qwa;
import qwn;
import qwp;
import qyh;
import ram;
import rar;
import rpc;

public class QQStoryAutoPlayView
  extends FrameLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  private long Bt;
  private long Bu = -1L;
  private long Bv;
  private AutoPlayImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView;
  private a jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a;
  private InteractContainerLayout jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout;
  private PollContainerLayout jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout;
  private pyg jdField_a_of_type_Pyg;
  private qwn jdField_a_of_type_Qwn;
  private qyh jdField_a_of_type_Qyh;
  private boolean aFV;
  private VideoListFeedItem c;
  private StoryVideoItem e;
  private ImageView mMaskView;
  private int mPosition;
  private long mStartPlayTime = -1L;
  
  public QQStoryAutoPlayView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QQStoryAutoPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void brk()
  {
    if (StoryVideoItem.isFakeVid(this.e.mVid)) {}
    StoryVideoItem localStoryVideoItem;
    do
    {
      return;
      ram.d("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView---- reportWatchVideo ------coverUrl=" + this.e.getThumbUrl());
      localStoryVideoItem = this.jdField_a_of_type_Qwn.e(this.e.mVid);
    } while (localStoryVideoItem == null);
    Object localObject;
    if (!TextUtils.isEmpty(localStoryVideoItem.shareGroupId))
    {
      localObject = localStoryVideoItem.shareGroupId;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ptk((String)localObject, localStoryVideoItem);
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
      }
      localObject = "";
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        break label150;
      }
      localObject = localStoryVideoItem.mOwnerUid;
    }
    for (;;)
    {
      this.jdField_a_of_type_Pyg.a(localStoryVideoItem.mVid, (String)localObject, 79, false, localStoryVideoItem.mCreateTime);
      return;
      localObject = localStoryVideoItem.mOwnerUid;
      break;
      label150:
      ram.e("Q.qqstory.home.QQStoryAutoPlayView", "this story item info incomplete .vid=" + this.e.mVid);
    }
  }
  
  private void brq()
  {
    if ((this.jdField_a_of_type_Qwn == null) || (this.c.isFakeFeedItem())) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qwn.e(this.e.mVid);
    if (localStoryVideoItem == null)
    {
      ram.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=" + this.e.mVid);
      return;
    }
    int i;
    int j;
    long l1;
    long l2;
    if (localStoryVideoItem.mIsPicture == 1)
    {
      i = 1;
      j = rar.a(this.c);
      l1 = localStoryVideoItem.mVideoDuration;
      l2 = this.Bt;
      str3 = "";
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("vid", localStoryVideoItem.mVid);
        localJSONObject.put("feedid", this.c.feedId);
        localJSONObject.put("author_id", this.c.ownerId);
        if (!this.c.isReportedAutoPlay) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("type", str1);
        str1 = localJSONObject.toString();
      }
      catch (Exception localException)
      {
        String str1;
        String str2 = str3;
        continue;
      }
      rar.b("auto_play", "auto_play_720", this.jdField_a_of_type_Qwn.sS(), i, new String[] { String.valueOf(j), String.valueOf(l1), String.valueOf(l2), str1 });
      qwp.w("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory dev url= ", localStoryVideoItem.getThumbUrl() });
      return;
      i = 0;
      break;
      str1 = "1";
    }
  }
  
  private void brr()
  {
    if ((this.jdField_a_of_type_Qwn == null) || (this.c.isFakeFeedItem())) {
      return;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Qwn.e(this.e.mVid);
    if (localStoryVideoItem == null)
    {
      ram.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but getVideo is null, vid=" + this.e.mVid);
      return;
    }
    if ((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (localStoryVideoItem.mVideoDuration < 0L) || (localStoryVideoItem.mSourceType == -1)) {
      localStoryVideoItem = ((psu)psx.a(5)).c(this.e.mVid);
    }
    String str3;
    for (;;)
    {
      if (localStoryVideoItem == null)
      {
        ram.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView reportAutoPlayStory but queryVideoFromDb is null, vid=" + this.e.mVid);
        return;
      }
      int i;
      String str4;
      String str5;
      String str6;
      if (localStoryVideoItem.mIsPicture == 1)
      {
        i = 1;
        str4 = String.valueOf(rar.a(this.c));
        str5 = String.valueOf(localStoryVideoItem.mVideoDuration);
        str6 = String.valueOf(this.Bt);
        str3 = "";
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("vid", localStoryVideoItem.mVid);
          localJSONObject.put("feedid", this.c.feedId);
          localJSONObject.put("author_id", this.e.mOwnerUid);
          if (!this.c.isReportedAutoPlay) {
            continue;
          }
          str1 = "2";
          localJSONObject.put("type", str1);
          localJSONObject.put("info_error", localStoryVideoItem.mErrorCode);
          localJSONObject.put("video_origin", localStoryVideoItem.mSourceType);
          localJSONObject.put("mobile_type", Build.MODEL);
          localJSONObject.put("wifi_ssid", rpc.W(getContext()));
          localJSONObject.put("wifi_mac", rpc.V(getContext()));
          str1 = localJSONObject.toString();
        }
        catch (Exception localException)
        {
          String str1;
          String str2 = str3;
          continue;
        }
        rar.a("play_video", "auto_play", this.jdField_a_of_type_Qwn.sS(), i, new String[] { str4, str5, str6, str1 });
        rar.b("auto_play", "auto_play_720", this.jdField_a_of_type_Qwn.sS(), i, new String[] { str4, str5, str6, str1 });
        rar.b("auto_play", "auto_play_scenes", this.jdField_a_of_type_Qwn.sS(), this.jdField_a_of_type_Qwn.sT(), new String[] { String.valueOf(this.Bt), localStoryVideoItem.mVid });
        this.c.isReportedAutoPlay = true;
        qwp.w("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory ", Integer.valueOf(this.jdField_a_of_type_Qwn.sT()), ",url= ", localStoryVideoItem.getThumbUrl() });
        qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayStory:", Integer.valueOf(this.jdField_a_of_type_Qwn.sS()), "|", Integer.valueOf(i), "|", str4, "|", str5, "|", str6, "|", str1 });
        return;
        i = 0;
        break;
        str1 = "1";
      }
    }
  }
  
  private void init()
  {
    super.setOnClickListener(this);
    super.setOnLongClickListener(this);
    this.mMaskView = new ImageView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout = new PollContainerLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.ac(true);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout = new InteractContainerLayout(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView = new AutoPlayImageView(getContext());
    MessageProgressView localMessageProgressView = new MessageProgressView(getContext());
    this.jdField_a_of_type_Qyh = new qyh(localMessageProgressView);
    this.jdField_a_of_type_Qyh.init();
    this.jdField_a_of_type_Pyg = new pyg();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mMaskView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.mMaskView, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    super.addView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    super.addView(localMessageProgressView, new FrameLayout.LayoutParams(-1, -1));
    super.setOnClickListener(this);
    this.mMaskView.setVisibility(8);
    this.jdField_a_of_type_Qyh.setVisibility(4);
  }
  
  public AutoPlayImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView;
  }
  
  public QQStoryAutoPlayView a(qwn paramqwn)
  {
    this.jdField_a_of_type_Qwn = paramqwn;
    return this;
  }
  
  public qyh a()
  {
    return this.jdField_a_of_type_Qyh;
  }
  
  public void aTA()
  {
    this.mStartPlayTime = System.currentTimeMillis();
    this.Bt = 0L;
    this.Bu = this.mStartPlayTime;
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordStartTime---view=", Integer.valueOf(super.hashCode()), "--mStartPlayTime=", Long.valueOf(this.mStartPlayTime), ",mHaveBeenPlayedTime=", Long.valueOf(this.Bt) });
  }
  
  public StoryVideoItem b()
  {
    return this.e;
  }
  
  public void brl()
  {
    if (this.mStartPlayTime > 0L) {
      this.Bt = (System.currentTimeMillis() - this.mStartPlayTime + this.Bt);
    }
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordPauseTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.mStartPlayTime), ",mHaveBeenPlayedTime=", Long.valueOf(this.Bt) });
    this.mStartPlayTime = -1L;
  }
  
  public void brm()
  {
    if (this.mStartPlayTime == -1L) {
      this.mStartPlayTime = System.currentTimeMillis();
    }
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordResumeTime--view=", Integer.valueOf(super.hashCode()), "---mStartPlayTime=", Long.valueOf(this.mStartPlayTime), ",mHaveBeenPlayedTime=", Long.valueOf(this.Bt) });
  }
  
  public void brn()
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTime---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.mStartPlayTime), ",mHaveBeenPlayedTime=", Long.valueOf(this.Bt) });
    if ((this.mStartPlayTime == -1L) && (this.Bt > 0L)) {
      brr();
    }
    this.Bt = 0L;
  }
  
  public void bro()
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "reportAutoPlayWhenPageSwitch---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime=", Long.valueOf(this.mStartPlayTime), ",mHaveBeenPlayedTime=", Long.valueOf(this.Bt) });
    if (this.Bt > 0L)
    {
      brr();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.release();
    }
    this.mStartPlayTime = -1L;
    this.Bt = 0L;
    this.Bv = 0L;
    this.Bu = -1L;
  }
  
  public void brp()
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "recordReleaseTimeForDev---view=", Integer.valueOf(super.hashCode()), "----mStartPlayTime_dev=", Long.valueOf(this.Bu), ",mHaveBeenPlayedTime_dev=", Long.valueOf(this.Bv) });
    if ((this.mStartPlayTime == -1L) && (this.Bt > 0L))
    {
      this.Bv = 0L;
      this.Bu = -1L;
    }
    for (;;)
    {
      if (this.Bu > 0L) {
        this.Bv = (System.currentTimeMillis() - this.mStartPlayTime + this.Bt);
      }
      return;
      if (this.Bv > 0L)
      {
        brq();
        this.Bv = 0L;
        this.Bu = -1L;
      }
    }
  }
  
  public void d(File paramFile1, File paramFile2)
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view-", Integer.valueOf(hashCode()), "- startPlay ---", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.sR()), "---coverUrl=" + this.e.getThumbUrl() });
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.KF()) {
      brk();
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.getCoverUrl())) {}
    StoryVideoItem localStoryVideoItem;
    for (String str = this.e.getThumbUrl();; str = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.getCoverUrl())
    {
      localStoryVideoItem = this.jdField_a_of_type_Qwn.e(this.e.mVid);
      if (localStoryVideoItem != null) {
        break;
      }
      ram.e("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay but getVideo is null, vid=" + this.e.mVid);
      return;
    }
    ram.a("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView startPlay w= %s ,h= %s , coverUrl=%s", Integer.valueOf(localStoryVideoItem.mVideoWidth), Integer.valueOf(localStoryVideoItem.mVideoHeight), str);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.a(str, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight, this.e.uniqueKey(), paramFile1.getAbsolutePath());
    if ((paramFile2 != null) && (paramFile2.exists())) {}
    try
    {
      paramFile1 = URLDrawable.URLDrawableOptions.obtain();
      paramFile1.mUseAutoScaleParams = false;
      paramFile1.mLoadingDrawable = new afei(0, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight);
      paramFile1.mMemoryCacheKeySuffix = "qqstory_mask";
      paramFile1.mRequestHeight = getHeight();
      paramFile1.mRequestWidth = (localStoryVideoItem.mVideoWidth * getHeight() / localStoryVideoItem.mVideoHeight);
      paramFile1 = URLDrawable.getDrawable(paramFile2, paramFile1);
      if ((paramFile1.getStatus() == 2) || (paramFile1.getStatus() == 3))
      {
        qwp.w("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "drawable restartDownload" });
        paramFile1.restartDownload();
      }
      this.mMaskView.setVisibility(0);
      this.mMaskView.setImageDrawable(paramFile1);
    }
    catch (Exception paramFile1)
    {
      for (;;)
      {
        ram.e("Q.qqstory.home.QQStoryAutoPlayView", "get maskFile error:" + paramFile1);
      }
    }
    aTA();
  }
  
  public void eK(List<qwa> paramList)
  {
    if (this.jdField_a_of_type_Qwn != null)
    {
      ram.d("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView requestPlay");
      this.jdField_a_of_type_Qwn.a(this, paramList);
    }
  }
  
  public boolean isPause()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.isPause();
  }
  
  public void onClick(View paramView)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a != null)
    {
      str = paramView.getContext().getClass().getSimpleName();
      if (!StoryVideoItem.isFakeVid(this.e.mVid)) {
        break label96;
      }
      ram.b("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of fake vid = %s, current activity = %s", this.e.mVid, str);
      rar.b("play_video", "home_video_info_state", 0, 1, new String[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a.a(this, this.c, this.e, this.mPosition);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label96:
      StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).a(this.e.mVid);
      if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())))
      {
        ram.b("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has video info of vid = %s, current activity = %s", this.e.mVid, str);
        rar.b("play_video", "home_video_info_state", 0, 2, new String[] { str });
      }
      else
      {
        ram.w("Q.qqstory.home.QQStoryAutoPlayView", "video card click, has *no* video info of vid = %s, current activity = %s", new Object[] { this.e.mVid, str });
        rar.b("play_video", "home_video_info_state", 0, 3, new String[] { str });
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a.b(this, this.c, this.e, this.mPosition);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ppg.c.a(this, paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void pausePlay()
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(super.hashCode()), "-- pausePlay ---" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.sR() + "---coverUrl=" + this.e.getThumbUrl() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.pausePlay();
    brl();
  }
  
  public void release()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.release();
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--", Integer.valueOf(hashCode()), "-- release completed:", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.aFU), "---", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.sR()), "---coverUrl=", this.e.getThumbUrl() });
    brn();
  }
  
  public void resumePlay()
  {
    qwp.d("Q.qqstory.home.QQStoryAutoPlayView", new Object[] { "QQStoryAutoPlayView--view=", Integer.valueOf(super.hashCode()), "-- resumePlay ---" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.sR() + "---coverUrl=" + this.e.getThumbUrl() });
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.resumePlay();
    brm();
  }
  
  public int sR()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.sR();
  }
  
  public int sU()
  {
    return this.mPosition;
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    ram.d("Q.qqstory.home.QQStoryAutoPlayView", "setCoverUrl:" + this.e.getThumbUrl());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setCoverUrl(paramString, paramInt1, paramInt2);
  }
  
  public void setImageDrawable(Drawable paramDrawable, String paramString)
  {
    if ((!this.aFV) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.isPlaying()))
    {
      ram.w("Q.qqstory.home.QQStoryAutoPlayView", "setImageDrawable but data have no change. so ignore this called.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.release();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayImageView.setCoverDrawable(paramDrawable);
    this.mMaskView.setVisibility(8);
    this.mMaskView.setImageDrawable(null);
    if ("QQStory_feed_min".equals(paramString)) {
      brp();
    }
    brn();
  }
  
  public void setItemData(VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    String str;
    if (paramStoryVideoItem == null)
    {
      str = "";
      ram.b("Q.qqstory.home.QQStoryAutoPlayView", "QQStoryAutoPlayView setItemData mPosition=%s url=%s", Integer.valueOf(paramInt), str);
      if ((paramStoryVideoItem != null) && (paramStoryVideoItem.equals(this.e))) {
        break label87;
      }
    }
    label87:
    for (this.aFV = true;; this.aFV = false)
    {
      if (paramStoryVideoItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.u(paramStoryVideoItem);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.t(paramStoryVideoItem);
      }
      this.c = paramVideoListFeedItem;
      this.e = paramStoryVideoItem;
      this.mPosition = paramInt;
      return;
      str = paramStoryVideoItem.getThumbUrl();
      break;
    }
  }
  
  public void setStoryCoverClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt);
    
    public abstract void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView
 * JD-Core Version:    0.7.0.1
 */