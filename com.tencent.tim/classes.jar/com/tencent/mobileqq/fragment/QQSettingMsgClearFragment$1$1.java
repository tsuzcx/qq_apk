package com.tencent.mobileqq.fragment;

import aajd;
import ahop;
import android.os.Handler;
import anql;
import aqmj;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class QQSettingMsgClearFragment$1$1
  implements Runnable
{
  public QQSettingMsgClearFragment$1$1(ahop paramahop) {}
  
  public void run()
  {
    QQSettingMsgHistoryActivity.b(this.a.a.getActivity(), QQSettingMsgClearFragment.a(this.a.a));
    anql.a().Qm(true);
    this.a.a.handler.sendEmptyMessageDelayed(0, 1000L);
    aqmj.UV(QQSettingMsgClearFragment.a(this.a.a).getCurrentUin());
    aajd.a().gG(0L);
    QQSettingMsgHistoryActivity.bUu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */