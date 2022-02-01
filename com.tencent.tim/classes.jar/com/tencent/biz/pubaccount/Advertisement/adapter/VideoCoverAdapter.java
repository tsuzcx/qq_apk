package com.tencent.biz.pubaccount.Advertisement.adapter;

import allf;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import aroc;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.b;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxc;
import jxd;
import jxo;
import skj;

public class VideoCoverAdapter
  extends PagerAdapter
{
  private a jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$a;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private VideoCoverView.b jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$b;
  private VideoCoverView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
  private jxc jdField_a_of_type_Jxc;
  private boolean acB;
  private skj c;
  private ArrayList<jxd> jv;
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int vv;
  
  public VideoCoverAdapter(Context paramContext, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, jxc paramjxc, VideoCoverView.b paramb)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$b = paramb;
    if ((paramjxc != null) && (paramjxc.jw != null)) {}
    for (this.jv = paramjxc.jw;; this.jv = new ArrayList())
    {
      this.jdField_a_of_type_Jxc = paramjxc;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$a = new a(null);
      AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$a);
      this.c = skj.a();
      this.c.bzj();
      return;
    }
  }
  
  private void aAN()
  {
    BaseVideoView localBaseVideoView = a();
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying()) && (!yE())) {
      pauseVideo();
    }
  }
  
  private boolean yE()
  {
    boolean bool = jxo.dp(((jxd)this.jv.get(this.vv)).b.UC);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "isVideoCached vid:0 cache:" + bool);
    }
    return bool;
  }
  
  public BaseVideoView a()
  {
    VideoCoverView localVideoCoverView = ((jxd)this.jv.get(this.vv)).b;
    if (localVideoCoverView != null) {
      return localVideoCoverView.b();
    }
    return null;
  }
  
  public void aAM()
  {
    VideoCoverView localVideoCoverView = ((jxd)this.jv.get(this.vv)).b;
    if (localVideoCoverView != null) {
      localVideoCoverView.showDialog();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.jv.size())
    {
      paramObject = ((jxd)this.jv.get(paramInt)).b;
      if (paramObject != null)
      {
        paramViewGroup.removeView(paramObject);
        paramObject.onDestory();
        ((jxd)this.jv.get(paramInt)).b = null;
      }
    }
  }
  
  public int getCount()
  {
    return this.jv.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    VideoCoverView localVideoCoverView = new VideoCoverView(this.mContext, (jxd)this.jv.get(paramInt), getCount(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$b, this.jv, this.jdField_a_of_type_Jxc, this.c);
    ((jxd)this.jv.get(paramInt)).b = localVideoCoverView;
    paramViewGroup.addView(localVideoCoverView);
    return localVideoCoverView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.jv.iterator();
    while (localIterator.hasNext())
    {
      jxd localjxd = (jxd)localIterator.next();
      if (localjxd.b != null)
      {
        localjxd.b.onDestory();
        localjxd.b = null;
      }
    }
    this.jv.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$a);
    if (this.c != null)
    {
      this.c.bzk();
      this.c = null;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int i;
    Object localObject1;
    Object localObject2;
    if ((paramInt != this.vv) && (paramInt < this.jv.size()))
    {
      i = (int)(((jxd)this.jv.get(this.vv)).b.bY() / 1000L);
      localObject1 = ((jxd)this.jv.get(this.vv)).UC;
      if (i > 0)
      {
        localObject2 = (Integer)PublicAccountAdvertisementActivity.cV.get(localObject1);
        if (localObject2 != null) {
          break label203;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverAdapter", 2, "sum time is null,current time" + i);
        }
        PublicAccountAdvertisementActivity.cV.put(localObject1, Integer.valueOf(i));
      }
      ((jxd)this.jv.get(this.vv)).b.akG();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = ((jxd)this.jv.get(paramInt)).b;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.bringToFront();
      if (!allf.isSDKReady()) {
        break label278;
      }
      if (aroc.getNetType(null) != 1) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.bJ(this.mContext);
    }
    label278:
    for (;;)
    {
      this.vv = paramInt;
      return;
      label203:
      PublicAccountAdvertisementActivity.cV.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + i));
      break;
      label224:
      if ((aroc.getNetType(null) != 0) || (VideoCoverFragment.acG))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.bJ(this.mContext);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
        ((VideoCoverView)localObject1).aEt = 6;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.updateView();
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.initSDK(this.mContext);
      }
    }
  }
  
  public void onPause()
  {
    VideoCoverView localVideoCoverView = ((jxd)this.jv.get(this.vv)).b;
    if (localVideoCoverView != null) {
      localVideoCoverView.pauseVideo();
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jv.size() > 0) {
        this.mHandler.postDelayed(new VideoCoverAdapter.1(this), 500L);
      }
    }
    VideoCoverView localVideoCoverView;
    do
    {
      return;
      localVideoCoverView = ((jxd)this.jv.get(this.vv)).b;
    } while (localVideoCoverView == null);
    localVideoCoverView.resumeVideo();
  }
  
  public void pauseVideo()
  {
    try
    {
      VideoCoverView localVideoCoverView = ((jxd)this.jv.get(this.vv)).b;
      if (localVideoCoverView != null) {
        localVideoCoverView.pauseVideo();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  class a
    implements INetInfoHandler
  {
    private a() {}
    
    public void onNetMobile2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from mobile to none");
      }
      VideoCoverAdapter.a(VideoCoverAdapter.this);
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from mobile to wifi");
      }
      VideoCoverAdapter.a(VideoCoverAdapter.this, false);
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from none to mobile");
      }
      if (!VideoCoverAdapter.a(VideoCoverAdapter.this))
      {
        paramString = VideoCoverAdapter.this.a();
        if ((paramString != null) && (paramString.isPlaying()))
        {
          VideoCoverAdapter.this.pauseVideo();
          VideoCoverAdapter.this.aAM();
        }
        VideoCoverAdapter.a(VideoCoverAdapter.this, true);
      }
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from none to wifi");
      }
      VideoCoverAdapter.a(VideoCoverAdapter.this, false);
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from wifi to mobile");
      }
      if (!VideoCoverAdapter.a(VideoCoverAdapter.this))
      {
        paramString = VideoCoverAdapter.this.a();
        if ((paramString != null) && (paramString.isPlaying()))
        {
          VideoCoverAdapter.this.pauseVideo();
          VideoCoverAdapter.this.aAM();
        }
        VideoCoverAdapter.a(VideoCoverAdapter.this, true);
      }
    }
    
    public void onNetWifi2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverAdapter", 2, "net from wifi to none");
      }
      VideoCoverAdapter.a(VideoCoverAdapter.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter
 * JD-Core Version:    0.7.0.1
 */