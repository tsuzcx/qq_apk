package com.tencent.tim.mvp.cloudfile;

import android.os.Message;
import atkw;
import auif;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class FileRecentListPresenter$5
  implements Runnable
{
  public FileRecentListPresenter$5(auif paramauif, int paramInt) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    List localList1 = auif.b(this.this$0).subList(auif.a(this.this$0), Math.max(auif.b(this.this$0).size(), 0));
    List localList2 = auif.a(this.this$0).subList(auif.b(this.this$0), Math.max(auif.a(this.this$0).size(), 0));
    ((List)localObject).addAll(localList1);
    ((List)localObject).addAll(localList2);
    if (((List)localObject).size() > 0)
    {
      Collections.sort((List)localObject, this.this$0.ao);
      int j = Math.min(20, ((List)localObject).size());
      int i = 0;
      if (i < j)
      {
        if (((atkw)((List)localObject).get(i)).relatedType == 7)
        {
          auif.c(this.this$0);
          if (auif.b(this.this$0) >= auif.a(this.this$0).size() - 1) {
            auif.a(this.this$0, false);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          auif.d(this.this$0);
        }
      }
      auif.c(this.this$0).addAll(((List)localObject).subList(0, j));
    }
    if (this.eqr == 1) {}
    for (localObject = this.this$0.q.obtainMessage(3, 0, 0, null);; localObject = this.this$0.q.obtainMessage(6, 0, 0, null))
    {
      this.this$0.q.sendMessage((Message)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mvp.cloudfile.FileRecentListPresenter.5
 * JD-Core Version:    0.7.0.1
 */