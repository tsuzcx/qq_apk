package com.tencent.biz.pubaccount.readinjoy.view;

import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import java.util.Calendar;
import ndi;

public class ReadInJoyBaseAdapter$25
  implements Runnable
{
  public ReadInJoyBaseAdapter$25(ndi paramndi, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((ndi.a(this.this$0) == 0) && (awit.m(ndi.getApp()) > 0) && (this.c.getLastVisiblePosition() >= awit.m(ndi.getApp())) && (awit.l(ndi.getApp()) > 0))
    {
      ndi.a(this.this$0, this.c.getLastVisiblePosition());
      i = awit.l(ndi.getApp());
      j = awit.n(ndi.getApp());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = awit.a(ndi.getApp());
      if (l1 <= l2) {
        break label161;
      }
      awit.u(ndi.getApp(), 1);
      awit.a(ndi.getApp(), l1);
      ((KandianMergeManager)ndi.getApp().getManager(162)).aIP();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    awit.u(ndi.getApp(), j + 1);
    ((KandianMergeManager)ndi.getApp().getManager(162)).aIP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.25
 * JD-Core Version:    0.7.0.1
 */