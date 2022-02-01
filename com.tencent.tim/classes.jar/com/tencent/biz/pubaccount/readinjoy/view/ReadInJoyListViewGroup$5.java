package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyListViewGroup$5
  implements Runnable
{
  ReadInJoyListViewGroup$5(ReadInJoyListViewGroup paramReadInJoyListViewGroup, View paramView1, int paramInt, View paramView2) {}
  
  public void run()
  {
    ReadInJoyListViewGroup.a(this.this$0).aYl();
    int i = this.mr.getHeight();
    if ((i != this.aYx) && (QLog.isColorLevel())) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",h = " + this.aYx);
    }
    if (i > this.aYx)
    {
      this.ms.setPadding(0, i, 0, 0);
      this.this$0.a.setPadding(0, i, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.5
 * JD-Core Version:    0.7.0.1
 */