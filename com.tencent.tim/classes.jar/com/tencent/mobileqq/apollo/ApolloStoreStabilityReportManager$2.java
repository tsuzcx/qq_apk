package com.tencent.mobileqq.apollo;

import abim;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;

public class ApolloStoreStabilityReportManager$2
  implements Runnable
{
  public ApolloStoreStabilityReportManager$2(abim paramabim) {}
  
  public void run()
  {
    abim.a(this.this$0, false);
    if (abim.a(this.this$0).size() > 0) {
      ThreadManagerV2.excute(abim.a(this.this$0), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.2
 * JD-Core Version:    0.7.0.1
 */