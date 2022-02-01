package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import rvo;
import rwk;
import rwo;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(rvo paramrvo, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.val$list == null) || (this.val$list.size() == 0)) {
      this.a.this$0.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.a.this$0) != -1L)
      {
        Iterator localIterator = this.val$list.iterator();
        while (localIterator.hasNext())
        {
          rwo localrwo = (rwo)localIterator.next();
          if (localrwo.Cz == QRLoginMgrActivity.a(this.a.this$0)) {
            localrwo.aCQ = QRLoginMgrActivity.a(this.a.this$0);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.a.this$0) == null);
    QRLoginMgrActivity.a(this.a.this$0).setDataSource(this.val$list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */