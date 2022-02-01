package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kyo;
import wja;

class ReadInJoyListViewGroup$49
  implements Runnable
{
  ReadInJoyListViewGroup$49(ReadInJoyListViewGroup paramReadInJoyListViewGroup, View paramView1, int paramInt1, int paramInt2, View paramView2) {}
  
  public void run()
  {
    if ((kyo.Bh()) && (kyo.Bg())) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        j = this.mr.getHeight();
        if ((j != this.aYv) && (QLog.isColorLevel())) {
          QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + j + ",heightDef =" + this.aYv);
        }
        if (!kyo.Bg()) {
          break;
        }
        if (j <= this.aYw * 3)
        {
          i = j;
          if (j >= this.aYw) {}
        }
        else
        {
          wja.a("ReadInJoyListViewGroup", "", new IllegalStateException("hideWithAnimation" + j));
          i = this.aYw;
        }
        this.ms.setPadding(0, i, 0, 0);
        this.this$0.a.setPadding(0, i, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",heightDef =" + this.aYv);
        }
      } while (i > this.aYw);
      ReadInJoyListViewGroup.a(this.this$0).aYl();
      return;
    } while (j <= this.aYv);
    this.ms.setPadding(0, j, 0, 0);
    this.this$0.a.setPadding(0, j, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + j);
    }
    ReadInJoyListViewGroup.a(this.this$0).aYl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.49
 * JD-Core Version:    0.7.0.1
 */