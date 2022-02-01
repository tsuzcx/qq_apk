package com.tencent.mobileqq.gamecenter.fragment;

import abmt;
import ahtz;
import ahuh;
import ahup;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import java.util.ArrayList;
import java.util.List;
import tbb;

class QQGamePubAccountFragment$10
  implements Runnable
{
  QQGamePubAccountFragment$10(QQGamePubAccountFragment paramQQGamePubAccountFragment, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    synchronized (QQGamePubAccountFragment.ex)
    {
      QQGamePubAccountFragment.a(this.this$0).add(0, this.p);
      ahuh localahuh = ahup.a(this.p, this.this$0.getActivity());
      this.this$0.mHeaderRecords.add(0, localahuh);
      if (this.this$0.c != null) {
        this.this$0.c.notifyDataSetChanged();
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.refreshIndicator();
        int i = this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i + 1);
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setCurrentIndex(i + 1);
      }
      this.this$0.dpH();
      QQGamePubAccountFragment.a(this.this$0).setVisibility(0);
      QQGamePubAccountFragment.a(this.this$0).sendEmptyMessageDelayed(0, 3000L);
      QQGamePubAccountFragment.a(this.this$0).setTag(ahtz.t(this.p));
      tbb.a(abmt.getAppInterface(), "769", "205030", "", "76901", "1", "160", new String[] { ahtz.t(this.p), "", "8" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.10
 * JD-Core Version:    0.7.0.1
 */