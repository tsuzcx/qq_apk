package com.tencent.biz.qqstory.shareGroup.infocard;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import pso;
import psx;

class QQStoryShareGroupProfileActivity$1
  implements Runnable
{
  QQStoryShareGroupProfileActivity$1(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void run()
  {
    pso localpso = (pso)psx.a(18);
    ArrayList localArrayList = localpso.a(this.this$0);
    int i = localArrayList.size();
    if (i >= 4)
    {
      localpso.dP(((Integer)localArrayList.get(0)).intValue() + 1, ((Integer)localArrayList.get(i - 1)).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "QQStoryShareGroupProfileActivity activity stack full, size = " + i + ", start clear!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.1
 * JD-Core Version:    0.7.0.1
 */