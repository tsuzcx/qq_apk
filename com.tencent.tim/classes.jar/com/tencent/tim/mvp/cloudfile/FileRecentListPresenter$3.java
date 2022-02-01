package com.tencent.tim.mvp.cloudfile;

import auif;
import aull;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class FileRecentListPresenter$3
  implements Runnable
{
  public FileRecentListPresenter$3(auif paramauif, int paramInt) {}
  
  public void run()
  {
    auif.a(this.this$0);
    List localList = auif.a(this.this$0).hn();
    if (localList != null)
    {
      Collections.sort(localList, this.this$0.an);
      auif.a(this.this$0).clear();
      auif.a(this.this$0).addAll(auif.a(this.this$0, localList));
      QLog.i("FileRecentListPresenter", 1, "loadTeamWorkDatabaseData. load teamwork database file finish.");
      if (this.eqr == 1) {
        this.this$0.q.sendMessage(this.this$0.q.obtainMessage(1, 0, 0, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.FileRecentListPresenter.3
 * JD-Core Version:    0.7.0.1
 */