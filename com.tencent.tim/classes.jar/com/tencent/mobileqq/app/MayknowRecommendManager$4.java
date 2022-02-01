package com.tencent.mobileqq.app;

import achg;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

public class MayknowRecommendManager$4
  implements Runnable
{
  public MayknowRecommendManager$4(achg paramachg, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    achg.a(this.this$0, this.cwr);
    for (;;)
    {
      synchronized (achg.b(this.this$0))
      {
        ArrayList localArrayList = (ArrayList)achg.a(this.this$0).get(Integer.valueOf(this.cwr));
        if ((localArrayList == null) || (localArrayList.isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label124;
          }
          bool = this.this$0.iv(this.cws);
          if (bool) {
            ((FriendListHandler)achg.a(this.this$0).getBusinessHandler(1)).a(this.cws, this.cwr, null, true, this.K);
          }
          return;
        }
      }
      int i = 0;
      continue;
      label124:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.4
 * JD-Core Version:    0.7.0.1
 */