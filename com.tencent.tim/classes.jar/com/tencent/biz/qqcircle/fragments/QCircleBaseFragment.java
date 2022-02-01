package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import aqmb;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oug;
import ous;
import ouy;
import ovd;
import ozq;
import ozv;
import rze;
import spp;

public abstract class QCircleBaseFragment
  extends BasePartFragment
{
  private void biI()
  {
    File localFile = new File(oug.arz);
    if ((localFile.exists()) || (aqmb.Cg() == null))
    {
      QLog.i("QCircleBaseFragment", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    rze.a(localFile, (String)spp.a().getValue("KEY_QCIRCLE_BASE_VIEW_DOWNLOAD_URL", "https://downv6.qq.com/video_story/qcircle/base/qcircle_download_pics.zip"), oug.arw);
  }
  
  private void biJ()
  {
    ozq localozq = ozq.a();
    ozv localozv = new ozv(this);
    localozq.a(new String[] { "https://downv6.qq.com/video_story/qcircle/animation/rockey1.zip", "https://downv6.qq.com/video_story/qcircle/animation/rockey2.zip", "https://downv6.qq.com/video_story/qcircle/animation/rockey3.zip", "https://downv6.qq.com/video_story/qcircle/animation/icon_start_recommend.zip", "https://downv6.qq.com/video_story/qcircle/animation/icon_end_recommend.zip", "https://downv6.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip", "https://downv6.qq.com/video_story/qcircle/animation/rockey_single_click.zip" }, localozv);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->doOnCreateView");
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    biI();
    biJ();
  }
  
  public abstract String getLogTag();
  
  public int getStatusBarColor()
  {
    return ovd.rY();
  }
  
  public void onAttach(Activity paramActivity)
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->onAttach");
    super.onAttach(paramActivity);
  }
  
  public void onBackPressed()
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->onBackPressed");
  }
  
  public void onDestroy()
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->onDestroy");
    super.onDestroy();
    ouy.a().release();
    ous.clearMemoryCache();
  }
  
  public void onDetach()
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->onDetach");
    super.onDetach();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(getLogTag(), 1, getLogTag() + "->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
 * JD-Core Version:    0.7.0.1
 */