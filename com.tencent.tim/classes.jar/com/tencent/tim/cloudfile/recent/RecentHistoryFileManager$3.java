package com.tencent.tim.cloudfile.recent;

import atmk;
import atmk.a;
import java.util.LinkedHashMap;
import java.util.List;

public class RecentHistoryFileManager$3
  implements Runnable
{
  public RecentHistoryFileManager$3(atmk paramatmk) {}
  
  public void run()
  {
    if (atmk.a(this.this$0).size() >= 8) {}
    while (atmk.a(this.this$0).size() == 0) {
      return;
    }
    atmk.a locala = (atmk.a)atmk.a(this.this$0).get(0);
    if (locala == null)
    {
      atmk.a(this.this$0).remove(0);
      atmk.a(this.this$0);
      return;
    }
    atmk.a(this.this$0).remove(locala);
    atmk.a(this.this$0, locala);
    atmk.b(this.this$0, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.recent.RecentHistoryFileManager.3
 * JD-Core Version:    0.7.0.1
 */