package com.tencent.biz.qqstory.takevideo;

import acfp;
import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import ayxa;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ram;
import rar;
import res;
import ret;
import rns;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.a
{
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private boolean aGB;
  private boolean aHt;
  private boolean aHu;
  private boolean aHv;
  public String azW;
  public int blx;
  private RelativeLayout bottom_blackLH;
  private int bqG;
  private int bqH = -1;
  private int bqI = -1;
  private Button ct;
  public int endIndex;
  public long endTime;
  private ImageView fV;
  private LinearLayout fa;
  private boolean mEnableLiuHai;
  private LocalMediaInfo mLocalMediaInfo;
  private String mLocalVideoPath;
  private int mVideoHeight;
  private int mVideoWidth;
  public int scrollX;
  public int startIndex;
  public long startTime;
  private LinearLayout top_blackLH;
  private TextView yx;
  
  private void btE()
  {
    this.mEnableLiuHai = false;
    this.top_blackLH = ((LinearLayout)findViewById(2131363559));
    this.bottom_blackLH = ((RelativeLayout)findViewById(2131363557));
    this.mEnableLiuHai = ayxa.a(this.top_blackLH, this.bottom_blackLH, 0);
  }
  
  private void cancel()
  {
    finish();
  }
  
  public void doOnBackPressed()
  {
    cancel();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    ayxa.initLiuHaiProperty(this);
    getWindow().addFlags(1024);
    if (ayxa.needCloseFullScreen()) {
      ayxa.closeFullScreen(this);
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    this.aHt = getIntent().getBooleanExtra("from_slideshow_to_share", false);
    this.bqG = getIntent().getIntExtra("video_index", 0);
    this.startIndex = getIntent().getIntExtra("start_index", 0);
    this.endIndex = getIntent().getIntExtra("end_index", 0);
    this.scrollX = getIntent().getIntExtra("scroll_x", 0);
    this.blx = getIntent().getIntExtra("entrance_type", 0);
    this.azW = getIntent().getStringExtra("op_entrance_type");
    this.startTime = getIntent().getLongExtra("start_time", 0L);
    this.endTime = getIntent().getLongExtra("end_time", 0L);
    int i;
    if (paramBundle == null)
    {
      i = 1;
      if (i == 0) {
        break label230;
      }
      paramBundle = getIntent();
      if (this.aHt) {
        break label225;
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      this.aHu = QQStoryFlowCallback.a(this, paramBundle, bool);
      if (!this.aHu) {
        break label256;
      }
      ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
      return false;
      i = 0;
      break;
    }
    label230:
    this.aHu = paramBundle.getBoolean("mGoThrough");
    if (this.aHu)
    {
      ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
      return false;
    }
    label256:
    ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
    setContentViewC(2131561880);
    ram.w("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
    btE();
    this.fV = ((ImageView)findViewById(2131375185));
    this.mLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
    this.mLocalVideoPath = this.mLocalMediaInfo.path;
    paramBundle = new MediaMetadataRetriever();
    try
    {
      paramBundle.setDataSource(this.mLocalVideoPath);
      this.mLocalMediaInfo.mediaHeight = Integer.parseInt(paramBundle.extractMetadata(19));
      this.mLocalMediaInfo.mediaWidth = Integer.parseInt(paramBundle.extractMetadata(18));
      this.mLocalMediaInfo.rotation = Integer.parseInt(paramBundle.extractMetadata(24));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramBundle.release();
      }
    }
    finally
    {
      paramBundle.release();
    }
    this.fa = ((LinearLayout)findViewById(2131375184));
    this.ct = ((Button)findViewById(2131375187));
    this.yx = ((TextView)findViewById(2131375186));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131375159));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setMinDuration(2000);
    if (this.mEnableLiuHai)
    {
      paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.getLayoutParams();
      paramBundle.bottomMargin = 0;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLayoutParams(paramBundle);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131370837));
    this.ct.setOnClickListener(this);
    this.fa.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.post(new LocalVideoSelectActivity.1(this));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.mLocalVideoPath);
    if (this.mEnableLiuHai)
    {
      paramBundle = (RelativeLayout)findViewById(2131363311);
      ((ViewGroup)paramBundle.getParent()).removeView(paramBundle);
      localObject1 = paramBundle.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aqnm.dip2px(14.0F);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = aqnm.dip2px(12.0F);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = aqnm.dip2px(12.0F);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
      this.bottom_blackLH.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
    }
    paramBundle = getIntent().getStringExtra("video_refer");
    if ((!"tribe".equals(paramBundle)) && (!"READINJOY_VIDEO".equals(paramBundle))) {
      this.aGB = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.i(this.mLocalMediaInfo.rotation, this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight);
    }
    for (;;)
    {
      this.fV.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.mVideoWidth = Math.min(this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mediaWidth);
      this.mVideoHeight = Math.max(this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mediaWidth);
      if (QQStoryFlowCallback.ev != null)
      {
        this.fV.setImageBitmap(QQStoryFlowCallback.ev);
        this.fV.setVisibility(0);
        ram.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate mCoverView.setImageBitmap()");
      }
      paramBundle = getIntent().getBundleExtra("bundle_extra");
      if (paramBundle != null) {
        this.aHv = paramBundle.getBoolean("enable_multi_fragment", false);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setLocalVideoView(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new res(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new ret(this));
      rar.a("video_edit", "exp_cut", 0, 0, new String[0]);
      return false;
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setCenterInside(true);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.aHu) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.detach();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.isPlaying()) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sJ(false);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("mGoThrough", this.aHu);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
  }
  
  public void ee(int paramInt1, int paramInt2)
  {
    eg(paramInt1, paramInt2);
    if ((this.bqH < 0) || (this.bqI < 0))
    {
      this.bqH = paramInt1;
      this.bqI = paramInt2;
    }
  }
  
  public void ef(int paramInt1, int paramInt2)
  {
    eg(paramInt1, paramInt2);
  }
  
  protected void eg(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)Math.floor((paramInt2 - paramInt1) / 1000.0F);
    paramInt2 = (int)Math.ceil(paramInt1 / 10.0F);
    if (this.aHv) {}
    for (String str = String.format(acfp.m(2131707897), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format(acfp.m(2131707898), new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.yx.setText(str);
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.aHu) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.a(this.mLocalMediaInfo);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    while (this.aHu)
    {
      ram.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult go through, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      setResult(paramInt2, paramIntent);
      finish();
      return;
      if (paramInt2 == -1)
      {
        ram.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        setResult(paramInt2, paramIntent);
        finish();
        return;
      }
      if ((paramInt2 == 0) && (this.aHu))
      {
        cancel();
        return;
      }
    }
    ram.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void onClick(View paramView)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    Object localObject;
    if (paramView == this.ct) {
      if (this.aHt)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.stopPlayback();
        i = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.getStartTime();
        j = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK();
        k = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.tK();
        m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.getStartIndex();
        n = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.getEndIndex();
        localObject = new Intent();
        ((Intent)localObject).putExtra("start_time", i);
        ((Intent)localObject).putExtra("end_time", j);
        ((Intent)localObject).putExtra("video_index", this.bqG);
        ((Intent)localObject).putExtra("start_index", m);
        ((Intent)localObject).putExtra("end_index", n);
        ((Intent)localObject).putExtra("scroll_x", k);
        setResult(-1, (Intent)localObject);
        rar.a("pic_choose", "done_cutVideo", this.blx, 0, new String[] { this.azW, i + "-" + j });
        finish();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.w("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.mLocalVideoPath, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.getStartTime()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK()) });
      String str2 = getIntent().getStringExtra("video_refer");
      m = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.getStartTime();
      n = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK();
      if (n - m > 10000) {
        rar.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((n - m) / 1000.0F)) });
      }
      localObject = getIntent().getBundleExtra("bundle_extra");
      if (localObject != null)
      {
        ram.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", "LocalVideoSelectActivity start edit video activity");
        rns.g("Q.qqstory.publish.edit.LocalVideoSelectActivity", (Bundle)localObject);
        QQStoryFlowCallback.a(this, this.mLocalVideoPath, this.mLocalMediaInfo, m, n, (Bundle)localObject);
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.tI();
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.tJ();
        if ((i != this.bqH) || (j != this.bqI)) {
          rar.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.stopPlayback();
      }
      else
      {
        int i1 = getIntent().getIntExtra("entrance_type", 99);
        j = 0;
        localObject = null;
        String str1 = null;
        long l = 0L;
        boolean bool = false;
        k = 0;
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("shareGroupType", 0);
          localObject = localIntent.getStringExtra("shareGroupId");
          str1 = localIntent.getStringExtra("shareGroupName");
          l = localIntent.getLongExtra("groupUin", -1L);
          bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
          k = localIntent.getIntExtra("add_video_source", 0);
        }
        if ("tribe".equals(str2)) {
          i = 10;
        }
        for (;;)
        {
          QQStoryFlowCallback.a(this, this.mLocalVideoPath, this.mLocalMediaInfo, m, n, i1, j, (String)localObject, str1, l, bool, k, i);
          break;
          if ("READINJOY_VIDEO".equals(str2)) {
            i = 12;
          } else {
            i = 1;
          }
        }
        if (paramView == this.fa) {
          cancel();
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */