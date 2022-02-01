package com.tencent.mobileqq.activity.recent;

import aagv;
import aagx;
import aagy;
import android.content.Context;
import ausj;

public class AppletsFolderManager$2
  implements Runnable
{
  public AppletsFolderManager$2(aagv paramaagv, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    aagv.a(this.this$0, ausj.b(this.val$context));
    String str = this.val$context.getString(2131690425);
    aagv.a(this.this$0).setMainTitle(str);
    aagv.a(this.this$0).addButton(2131690426, 3);
    aagv.a(this.this$0).addCancelButton(2131721058);
    aagv.a(this.this$0).a(new aagx(this));
    aagv.a(this.this$0).a(new aagy(this));
    if (!aagv.a(this.this$0).isShowing())
    {
      aagv.a(this.this$0, false);
      aagv.a(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager.2
 * JD-Core Version:    0.7.0.1
 */