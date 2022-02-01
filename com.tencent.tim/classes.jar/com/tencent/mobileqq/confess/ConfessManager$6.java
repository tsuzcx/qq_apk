package com.tencent.mobileqq.confess;

import aegs;
import aegs.a;
import anaz;
import android.text.TextUtils;
import aqgv;

public class ConfessManager$6
  implements Runnable
{
  public ConfessManager$6(aegs paramaegs, String paramString) {}
  
  public void run()
  {
    aegs.a locala = this.this$0.a;
    if (locala == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(locala.strRecNick)) {
        locala.strRecNick = aqgv.s(this.this$0.mApp, locala.strRecUin);
      }
      if (locala.flag == 0) {
        locala.flag = this.this$0.b(this.bxd, locala.strRecUin, locala.strConfessorUin, locala.nTopicId);
      }
    } while (locala.flag != 1);
    long l = anaz.gQ();
    this.this$0.a(this.bxd, locala, l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.6
 * JD-Core Version:    0.7.0.1
 */