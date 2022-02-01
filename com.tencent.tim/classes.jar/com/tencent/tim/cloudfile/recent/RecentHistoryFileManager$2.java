package com.tencent.tim.cloudfile.recent;

import atmk;
import com.tencent.qphone.base.util.QLog;

public class RecentHistoryFileManager$2
  implements Runnable
{
  public RecentHistoryFileManager$2(atmk paramatmk, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RecentHistoryFileManager", 1, "delete loadDB task. taskID[" + this.cHp + "]");
    }
    atmk.a(this.this$0, this.cHp);
    atmk.b(this.this$0, this.cHp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.2
 * JD-Core Version:    0.7.0.1
 */