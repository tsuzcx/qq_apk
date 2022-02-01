package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import awta;
import ayiw;
import ayix;
import ayiy;
import ayiz;
import aytv;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.a;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.cropvideo.CropVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import ram;
import rar;
import sqn;

public class LocalVideoSelectActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ScrollFrameSelectBar.a
{
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView;
  private ScrollFrameSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar;
  private boolean aGB;
  private boolean aHu;
  private boolean aHv;
  private int bqH = -1;
  private int bqI = -1;
  private Button ct;
  private boolean dzw;
  private boolean dzx;
  private ImageView fV;
  private LinearLayout fa;
  private int mFrom;
  private LocalMediaInfo mLocalMediaInfo;
  private String mLocalVideoPath;
  private int mVideoHeight;
  private int mVideoWidth;
  private TextView yx;
  
  private void cancel()
  {
    finish();
  }
  
  private void k(LocalMediaInfo paramLocalMediaInfo)
  {
    Bosses.get().postJob(new ayiz(this, "Q.qqstory.publish.edit.LocalVideoSelectActivity", paramLocalMediaInfo));
  }
  
  public void doOnBackPressed()
  {
    cancel();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.dzw = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.pausePlay();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", 2, "model=" + str);
    }
    if ((this.dzw) && (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.mLocalVideoPath);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.i(this.mLocalMediaInfo.rotation, this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sJ(false);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("mGoThrough", this.aHu);
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
    for (String str = String.format(acfp.m(2131707893), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = String.format(acfp.m(2131707896), new Object[] { Integer.valueOf(paramInt1) }))
    {
      this.yx.setText(str);
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.aHu) && (this.mLocalMediaInfo != null)) {
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
        if (paramIntent != null) {
          paramIntent.putExtra("edit_video_type", getIntent().getIntExtra("edit_video_type", 10002));
        }
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
    String str3;
    int i;
    int k;
    int m;
    int n;
    int i1;
    int j;
    String str1;
    String str2;
    boolean bool;
    if (paramView == this.ct)
    {
      ram.w("Q.qqstory.publish.edit.LocalVideoSelectActivity", "publish the local video path=%s,start=%s,end=%s", new Object[] { this.mLocalVideoPath, Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.getStartTime()), Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK()) });
      str3 = getIntent().getStringExtra("video_refer");
      if ("tribe".equals(str3))
      {
        i = awta.eCL;
        k = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.getStartTime();
        m = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.sK();
        if (m - k > i) {
          rar.a("video_edit", "edit_split", 0, 0, new String[] { String.valueOf(Math.ceil((m - k) / 1000.0F)) });
        }
        n = getIntent().getIntExtra("entrance_type", 99);
        i1 = getIntent().getIntExtra("edit_video_type", 10002);
        j = 0;
        str1 = null;
        str2 = null;
        bool = false;
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("shareGroupType", 0);
          str1 = localIntent.getStringExtra("shareGroupId");
          str2 = localIntent.getStringExtra("shareGroupName");
          bool = localIntent.getBooleanExtra("ignorePersonalPublish", false);
        }
        if (i1 != 10009) {
          break label323;
        }
        CropVideoActivity.a(this, k, m, this.mLocalVideoPath);
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.tI();
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.tJ();
        if ((i != this.bqH) || (j != this.bqI)) {
          rar.a("video_edit", "num_cut", 0, 0, new String[0]);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.stopPlayback();
      }
    }
    for (;;)
    {
      label308:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 20000;
      break;
      label323:
      if ("tribe".equals(str3)) {
        i = 11;
      }
      for (;;)
      {
        aytv.a(this, this.mLocalVideoPath, this.mLocalMediaInfo, k, m, n, i1, j, str1, str2, bool, this.mFrom, i);
        break;
        if ("READINJOY_VIDEO".equals(str3))
        {
          i = 12;
        }
        else
        {
          if (i1 == 10023)
          {
            wt(2131696226);
            new FrameVideoHelper(this.mLocalVideoPath, this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mDuration).a(k, new ayiy(this, k, m, n, i1, 14));
            sqn.a("mystatus_localupload", "cut_page_confirm", 0, 0, new String[0]);
            this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.stopPlayback();
            break label308;
          }
          i = 1;
        }
      }
      if (paramView == this.fa) {
        cancel();
      }
    }
  }
  
  @TargetApi(11)
  public void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(1024);
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.onCreate(paramBundle);
    ShortVideoUtils.B(this.app);
    this.mFrom = getIntent().getIntExtra("edit_video_way", 0);
    int i;
    if (paramBundle == null)
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      this.aHu = aytv.a(this, getIntent(), this.mFrom);
      if (!this.aHu) {
        break label125;
      }
      ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, go through, start edit video activity directly");
    }
    label99:
    label125:
    do
    {
      return;
      i = 0;
      break;
      this.aHu = paramBundle.getBoolean("mGoThrough");
      if (this.aHu)
      {
        ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity re-create, do nothing");
        return;
      }
      ram.i("Q.qqstory.publish.edit.LocalVideoSelectActivity", "activity on-create, init ui");
      setContentViewC(2131561880);
      ram.w("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
      this.fV = ((ImageView)findViewById(2131375185));
      this.mLocalMediaInfo = ((LocalMediaInfo)getIntent().getParcelableExtra("media_info"));
      this.mLocalVideoPath = this.mLocalMediaInfo.path;
      this.fa = ((LinearLayout)findViewById(2131375184));
      this.ct = ((Button)findViewById(2131375187));
      this.yx = ((TextView)findViewById(2131375186));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar = ((ScrollFrameSelectBar)findViewById(2131375159));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)findViewById(2131370837));
      this.ct.setOnClickListener(this);
      this.fa.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setOnRangeValueChangeListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.mLocalVideoPath);
      this.aGB = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.i(this.mLocalMediaInfo.rotation, this.mLocalMediaInfo.mediaWidth, this.mLocalMediaInfo.mediaHeight);
      this.mVideoWidth = Math.min(this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mediaWidth);
      this.mVideoHeight = Math.max(this.mLocalMediaInfo.mediaHeight, this.mLocalMediaInfo.mediaWidth);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.IF()) {
        this.fV.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      k(this.mLocalMediaInfo);
      this.aHv = getIntent().getBooleanExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", false);
      if (getIntent().getIntExtra("edit_video_type", 10002) == 10023) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.setMaxVideoDuration(60000);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.post(new LocalVideoSelectActivity.1(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(new ayiw(this));
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnErrorListener(new ayix(this));
      rar.a("video_edit", "exp_cut", 0, 0, new String[0]);
    } while (getIntent().getIntExtra("edit_video_type", 10002) != 10023);
    sqn.a("mystatus_localupload", "cut_page_exp", 0, 0, new String[0]);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.aHu) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar.detach();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity
 * JD-Core Version:    0.7.0.1
 */