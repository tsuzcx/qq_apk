package com.tencent.mobileqq.nearby.now;

import acfp;
import ajpj;
import ajvk;
import ajvn;
import ajvq;
import ajvr;
import ajvt;
import ajvu;
import ajvv;
import ajvw;
import ajvy;
import ajwe;
import ajwe.a;
import ajwh;
import ajwi;
import ajwq;
import ajww;
import ajxr;
import ajxs;
import ajxt;
import ajxu;
import ajxv;
import ajyb;
import ajzh.a;
import ajzo;
import akbc;
import akio;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import aoiz;
import aqbn;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.a;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.a;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jll;
import jqi;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayController
  implements ViewPager.OnPageChangeListener, StuffContainerView.a
{
  private boolean Yp;
  public ajvk a;
  ajwe.a jdField_a_of_type_Ajwe$a = new ajvr(this);
  public ajwe a;
  public ajyb a;
  private akbc jdField_a_of_type_Akbc;
  public QQStoryVideoPlayerErrorView a;
  public VideoPlayerPagerAdapter a;
  public QQAppInterface app;
  public StuffContainerView b;
  private boolean cbk = true;
  private boolean cqA;
  private boolean cqB = true;
  public boolean cqC;
  public boolean cqD;
  private boolean cqv;
  private boolean cqw = true;
  private boolean cqx;
  private boolean cqy;
  public boolean cqz = false;
  public int dli;
  private int dlj = -1;
  public int dlk;
  private Runnable hf = new StoryPlayController.9(this);
  public HashMap<Integer, ajzo> lV = new HashMap();
  public Bundle mBundle;
  public Context mContext;
  public int mCurrentIndex;
  private String mFeedId = "";
  Handler mHandler = new ajvq(this);
  
  public StoryPlayController(Context paramContext, StuffContainerView paramStuffContainerView, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, QQAppInterface paramQQAppInterface, ajvk paramajvk)
  {
    this.app = paramQQAppInterface;
    this.b = paramStuffContainerView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.mContext = paramContext;
    this.jdField_a_of_type_Ajyb = new ajyb(paramContext, paramajvk, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = paramQQStoryVideoPlayerErrorView;
    this.mBundle = paramBundle;
    paramContext = getValue("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.cqC = true;
    }
    this.cqD = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.cqv = ajxu.getBoolean("short_video_player_guide_shown", false);
    this.jdField_a_of_type_Ajvk = paramajvk;
  }
  
  private void Rw(int paramInt)
  {
    if (!this.cqv)
    {
      this.mHandler.removeMessages(1001);
      this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
    }
  }
  
  private void Rx(int paramInt)
  {
    if (paramInt != this.mCurrentIndex) {}
    VideoPlayerPagerAdapter.a locala;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.Yp);
        locala = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
      } while ((locala == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() <= 1) || (this.cqv));
      if ((locala != null) && (locala.ld != null)) {
        this.jdField_a_of_type_Ajyb.pause();
      }
    } while (this.jdField_a_of_type_Akbc != null);
    this.jdField_a_of_type_Akbc = new akbc(this.b.mActivity);
    this.jdField_a_of_type_Akbc.sI(acfp.m(2131714970));
    HashMap localHashMap = this.lV;
    this.jdField_a_of_type_Akbc.setOnDismissListener(new ajvy(this, locala, localHashMap));
    this.jdField_a_of_type_Akbc.show();
    this.cqv = true;
    ajxu.putBoolean("short_video_player_guide_shown", true);
    ThreadManager.getUIHandler().postDelayed(this.hf, 3000L);
  }
  
  private void a(int paramInt, VideoPlayerPagerAdapter.a parama, VideoData paramVideoData)
  {
    
    if ((jqi.getNetworkType(getContext()) != 1) && (this.dli != 4) && (this.dli != 6) && (!paramVideoData.cqF))
    {
      QQToast.a(getContext(), acfp.m(2131714960), 1).show();
      this.cqA = true;
    }
    if (this.jdField_a_of_type_Ajvk != null) {
      this.jdField_a_of_type_Ajvk.ahH();
    }
    if ((parama != null) && (parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b(paramVideoData);
      this.jdField_a_of_type_Ajyb.a((ajzh.a)this.lV.get(Integer.valueOf(parama.position)));
      this.jdField_a_of_type_Ajyb.a(parama.ld, paramVideoData, new ajvv(this));
    }
    this.b.a.iP(paramInt, 0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "playShortVideovideoDataIndex is: " + paramInt + " percent is: " + 0);
    }
  }
  
  private void b(int paramInt, VideoPlayerPagerAdapter.a parama, VideoData paramVideoData)
  {
    this.b.a.Mr(true);
    parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new ajvw(this, parama, paramVideoData));
    if (paramVideoData.yf.get(0) != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.getView(paramInt) instanceof ShortVideoCommentsView))
      {
        ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.getView(paramInt);
        ajxv.a(parama, ((ajwh)paramVideoData.yf.get(0)).dlm, ((ajwh)paramVideoData.yf.get(0)).imageWidth, paramVideoData, localShortVideoCommentsView);
      }
      parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.c(paramVideoData);
      dzF();
    }
  }
  
  @TargetApi(14)
  public void Rv(int paramInt)
  {
    VideoPlayerPagerAdapter.a locala = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
    if (locala == null) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoPlayController", 2, "startPlayVideo: videoViewHolder == null videoDataIndex=" + paramInt + "  mAdapter.realIndex" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.dlI);
      }
    }
    VideoData localVideoData;
    do
    {
      do
      {
        return;
        localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(paramInt);
      } while (localVideoData == null);
      ajxt.j(localVideoData.id, 2, "0", "0");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "startPlayVideo:videoItem=" + localVideoData + ",videoItem.anchorUin=" + localVideoData.ads + ",videoItem.anchorNickName=" + localVideoData.bSG);
      }
      if (locala.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.ads;
        locala.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
    } while (paramInt != this.mCurrentIndex);
    if (locala.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      locala.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.dzV();
    }
    this.dli = localVideoData.feedType;
    if (localVideoData.feedType == 4)
    {
      b(paramInt, locala, localVideoData);
      new ajww(this.app).a(localVideoData.id, null);
      ((akio)this.app.getManager(263)).Nu(localVideoData.id);
      return;
    }
    if (localVideoData.feedType == 6)
    {
      new ajww(this.app).a(localVideoData.id, null);
      ((akio)this.app.getManager(263)).Nu(localVideoData.id);
      return;
    }
    a(paramInt, locala, localVideoData);
    if ((jqi.getNetworkType(getContext()) != 1) && (this.dli != 4) && (this.dli != 6) && (!localVideoData.cqF))
    {
      QQToast.a(getContext(), acfp.m(2131714967), 1).show();
      this.cqB = false;
    }
    Rw(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.a parama) {}
  
  public void a(ImageView paramImageView, String paramString, ajzo paramajzo)
  {
    ajxr.a().a(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), jll.getScreenWidth(this.mContext) / 2, jll.getScreenHeight(this.mContext) / 2, new ajvt(this, paramImageView, paramajzo), false);
  }
  
  public void a(VideoPlayerPagerAdapter.a parama, VideoData paramVideoData, boolean paramBoolean, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    a(parama, paramVideoData, paramBoolean, paramShortVideoCommentsView, true);
  }
  
  public void a(VideoPlayerPagerAdapter.a parama, VideoData paramVideoData, boolean paramBoolean1, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData() called with: holder = [" + parama + "], videoData = [" + paramVideoData + "], willToPlay = [" + paramBoolean1 + "], commentsView = [" + paramShortVideoCommentsView + "]");
    }
    parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b(paramVideoData);
    parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.Mu(true);
    if ((paramVideoData.coverUrl == null) || (TextUtils.isEmpty(paramVideoData.coverUrl))) {
      parama.ld.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    for (;;)
    {
      paramShortVideoCommentsView = new ajzo(parama, this, paramShortVideoCommentsView, ajxv.a(parama, paramVideoData.videoWidth, paramVideoData.videoHeight));
      this.lV.put(Integer.valueOf(parama.position), paramShortVideoCommentsView);
      if (paramVideoData.type == 4)
      {
        parama.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
        if (parama.eX != null) {
          parama.eX.findViewById(2131379818).setVisibility(4);
        }
      }
      a(paramBoolean1, parama.ld, paramVideoData, paramShortVideoCommentsView, paramBoolean2);
      return;
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.coverUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(aqbn.t);
      parama.ld.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, ajzo paramajzo, boolean paramBoolean2)
  {
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131369717);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131366039);
    localImageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView1.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "prepare() called with: willToPlay = [" + paramBoolean1 + "], rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "], videoInfoListener = [" + paramajzo + "], loadCover = [" + paramBoolean2 + "]");
    }
    if ((paramBoolean2) && (paramVideoData.coverUrl != null))
    {
      if (paramVideoData.cqF) {
        break label197;
      }
      a(localImageView1, paramVideoData.coverUrl, paramajzo);
    }
    for (;;)
    {
      ajxr.a().a(localImageView2, paramVideoData.doodleUrl, new ColorDrawable(0), new ColorDrawable(0), new ajvu(this, paramajzo));
      return;
      label197:
      paramRelativeLayout = aoiz.getFile(paramVideoData.coverUrl);
      if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoPlayController", 2, "load cover,localFile exists,filepath = " + paramRelativeLayout.getAbsolutePath());
          }
          localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
          paramajzo.E(paramVideoData.videoWidth, paramVideoData.videoHeight, true);
        }
        catch (OutOfMemoryError paramRelativeLayout)
        {
          QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
          a(localImageView1, paramVideoData.coverUrl, paramajzo);
        }
      } else {
        a(localImageView1, paramVideoData.coverUrl, paramajzo);
      }
    }
  }
  
  public boolean arD()
  {
    return this.cqD;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void doOnDestroy()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_Ajyb.b != null)
    {
      l1 = this.jdField_a_of_type_Ajyb.getFileSize();
      l2 = this.jdField_a_of_type_Ajyb.gu();
      if (l1 == 0L) {
        break label100;
      }
    }
    label100:
    for (double d = l2 / l1;; d = 0.0D)
    {
      ajxt.a(this.jdField_a_of_type_Ajyb.b.id, 2, String.valueOf(d), String.valueOf(l1), String.valueOf(l2), String.valueOf(ajxt.gt()), this.jdField_a_of_type_Ajyb.isPlaying());
      this.jdField_a_of_type_Ajyb.suspend();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.destroy();
      this.Yp = true;
      return;
    }
  }
  
  public void doOnPause()
  {
    this.jdField_a_of_type_Ajyb.pause();
  }
  
  public void doOnResume()
  {
    this.jdField_a_of_type_Ajyb.resume();
    if ((jqi.getNetworkType(getContext()) != 1) && (this.dli != 4) && (this.dli != 6) && (this.jdField_a_of_type_Ajyb.b != null) && (!this.jdField_a_of_type_Ajyb.b.cqF)) {
      QQToast.a(getContext(), acfp.m(2131714971), 1).show();
    }
    this.cbk = false;
  }
  
  public void dzE()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG == null)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() <= 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).cqF) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() > 1))
      {
        ajxs.bSL = "3";
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).feedType == 4) {
        ajxs.bSL = "2";
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).feedType == 4);
    ajxs.bSL = "1";
  }
  
  public void dzF()
  {
    if (this.jdField_a_of_type_Ajvk != null) {
      this.jdField_a_of_type_Ajvk.cWn();
    }
  }
  
  public void dzG() {}
  
  public void dzH() {}
  
  public void dzI() {}
  
  public void dzJ() {}
  
  public void dzK() {}
  
  public void dzL()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.da == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG == null)) {
      QLog.e("VideoPlayController", 1, "updateVideoLabelState mAdapter.mVideoViewHolderList == null || mAdapter.mVideoDataList == null !!!!");
    }
  }
  
  public void dzM()
  {
    ajzo localajzo = (ajzo)this.lV.get(Integer.valueOf(this.mCurrentIndex));
    if (localajzo != null) {
      localajzo.dzM();
    }
  }
  
  public void g(Bundle paramBundle)
  {
    int i = 2;
    if (paramBundle.getBoolean("play_list", true))
    {
      if (!"2".equals(paramBundle.getString("play_mode", "1"))) {
        break label632;
      }
      this.cqx = false;
      this.jdField_a_of_type_Ajwe = new ajwq();
      if ("1".equals(paramBundle.getString("isLocal"))) {
        this.jdField_a_of_type_Ajwe.Ms(true);
      }
    }
    for (;;)
    {
      Object localObject = paramBundle.getString("raw_url");
      QLog.i("VideoPlayController", 1, "rawUrl = " + (String)localObject);
      this.mFeedId = getValue("feeds_id");
      if (TextUtils.isEmpty(this.mFeedId))
      {
        this.mFeedId = getValue("feed_id");
        QLog.i("VideoPlayController", 1, " feeds_id is null,feed_id ==" + this.mFeedId);
      }
      if (this.mFeedId == null) {
        this.mFeedId = "";
      }
      this.b.a.Mr(false);
      localObject = paramBundle.getString("processbar");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        j = Integer.parseInt((String)localObject);
        if (j == 1)
        {
          this.b.a.Mr(false);
          label232:
          this.cqy = paramBundle.getBoolean("should_show_comment_view", false);
          this.jdField_a_of_type_Ajwe.dd(paramBundle);
          this.jdField_a_of_type_Ajwe.app = this.app;
          this.jdField_a_of_type_Ajwe.a(this.jdField_a_of_type_Ajwe$a);
          ajxt.dzP();
          this.jdField_a_of_type_Ajwe.dui();
          paramBundle = new VideoData();
          localObject = getValue("preLoadParams");
          bool = getValue("feed_type").equals("4");
          QLog.i("VideoPlayController", 1, "preLoadJson~ in init = " + (String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localObject = URLDecoder.decode((String)localObject);
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          int j;
          boolean bool;
          this.cqz = true;
          localObject = new JSONObject((String)localObject);
          paramBundle.id = ((JSONObject)localObject).optString("id");
          paramBundle.headerUrl = ((JSONObject)localObject).optString("headerUrl");
          paramBundle.videoUrl = ((JSONObject)localObject).optString("videoUrl");
          paramBundle.videoHeight = ((JSONObject)localObject).optInt("videoHeight");
          paramBundle.videoWidth = ((JSONObject)localObject).optInt("videoWidth");
          paramBundle.coverUrl = ((JSONObject)localObject).optString("coverUrl");
          paramBundle.doodleUrl = ((JSONObject)localObject).optString("doodleUrl");
          paramBundle.AC = ((JSONObject)localObject).optLong("video_timelong");
          if (((JSONObject)localObject).optLong("is_local") == 1L) {
            i = 4;
          }
          paramBundle.type = i;
          paramBundle.cqF = true;
          paramBundle.feedType = 3;
          if (bool)
          {
            paramBundle.feedType = 4;
            paramBundle.yf = new ArrayList();
            localObject = new ajwh();
            ((ajwh)localObject).dlm = paramBundle.videoHeight;
            ((ajwh)localObject).imageWidth = paramBundle.videoWidth;
            ((ajwh)localObject).imageUrl = paramBundle.coverUrl;
            paramBundle.yf.add(localObject);
          }
          if (paramBundle.type == 4) {
            this.jdField_a_of_type_Ajwe.Ms(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_Ajwe.getDataList().add(paramBundle);
            this.jdField_a_of_type_Ajwe.gL(this.mFeedId, paramBundle.id);
            this.jdField_a_of_type_Ajwe$a.iQ(1, 0);
            this.b.setCurrentItem(0, false);
            return;
            label632:
            this.cqx = true;
            this.jdField_a_of_type_Ajwe = new ajwi();
            break;
            if (j != 2) {
              break label232;
            }
            this.b.a.Mr(true);
            break label232;
            localException = localException;
            QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
            break label232;
            this.jdField_a_of_type_Ajwe.dzO();
          }
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.i("VideoPlayController", 1, "no preload params~ in init");
        }
      }
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getValue(String paramString)
  {
    Object localObject = "";
    if (this.mBundle != null) {
      localObject = this.mBundle.getString(paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return localObject;
      if (this.mBundle == null) {
        return "";
      }
      localObject = this.mBundle.getString("raw_url");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return "";
      }
      localObject = Uri.parse((String)localObject);
      try
      {
        localObject = ((Uri)localObject).getQueryParameter(paramString);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w("VideoPlayController", 1, localException + "getValue no value in url key=" + paramString);
          paramString = "";
        }
      }
      localObject = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return "";
  }
  
  public void hk(View paramView) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.b.onClose();
      return true;
    }
    return false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() == 1) {}
    while (paramInt == this.dlj) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.dlj = paramInt;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "onPageScrollStateChanged SCROLL_STATE_IDLE currentIndex is: " + this.mCurrentIndex);
      }
      if (this.mCurrentIndex >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size()) {
        break;
      }
      if (((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(this.mCurrentIndex)).isReady)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "videoItem.isReady state = [" + paramInt + "]");
        }
        this.jdField_a_of_type_Ajyb.resume();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "startPlayVideo state = [" + paramInt + "]");
        }
        ajxt.RB(1);
        Rv(this.mCurrentIndex);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        this.jdField_a_of_type_Ajyb.pause();
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    paramInt = paramInt - 50 + this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.dlI;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onPageSelected index is: " + paramInt + " mCurrentIndex=" + this.mCurrentIndex);
    }
    if (paramInt < 0) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() == 0) {
      return;
    }
    if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() - 2)
    {
      this.jdField_a_of_type_Ajwe.gL(this.mFeedId, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() - 1)).id);
      this.mFeedId = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.size() - 1)).id;
      this.jdField_a_of_type_Ajwe.dui();
    }
    if (paramInt < 2)
    {
      this.jdField_a_of_type_Ajwe.gL(this.mFeedId, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(0)).id);
      this.mFeedId = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(0)).id;
      this.jdField_a_of_type_Ajwe.dzO();
    }
    if (paramInt < this.mCurrentIndex) {
      new ajxs().h("video").i("playpage_left_slide").b().dy(this.app);
    }
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jG.get(this.mCurrentIndex);
    localVideoData.isReady = false;
    if (paramInt > this.mCurrentIndex)
    {
      new ajxs().h("video").i("playpage_right_slide").b().dy(this.app);
      ThreadManagerV2.excute(new StoryPlayController.7(this, localVideoData, (ajpj)this.app.getManager(106)), 16, null, false);
    }
    this.mCurrentIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController
 * JD-Core Version:    0.7.0.1
 */