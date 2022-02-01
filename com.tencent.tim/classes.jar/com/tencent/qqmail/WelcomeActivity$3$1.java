package com.tencent.qqmail;

import com.tencent.qqmail.activity.webviewexplorer.PopularizeWebViewExplorer;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper.PopularizeActionDelegate;
import com.tencent.qqmail.schema.SchemaUtil;

class WelcomeActivity$3$1
  implements PopularizeUIHelper.PopularizeActionDelegate
{
  WelcomeActivity$3$1(WelcomeActivity.3 param3) {}
  
  public boolean onAction(Popularize paramPopularize)
  {
    int i = paramPopularize.getAction();
    int j = PopularizeUIHelper.getAnimationTypeByPopularize(paramPopularize.getType());
    String str = paramPopularize.getOpenUrl();
    if (i == 1) {
      if ((str != null) && (str.startsWith("qqmail://"))) {
        if (SchemaUtil.handleSchemaAction(this.this$1.this$0, str, j, 2)) {
          this.this$1.this$0.finish();
        }
      }
    }
    for (;;)
    {
      return false;
      if ((str != null) && ((str.startsWith("http://")) || (str.startsWith("https://"))))
      {
        paramPopularize = PopularizeWebViewExplorer.createIntent(str, paramPopularize.getId(), j);
        this.this$1.this$0.startActivity(paramPopularize);
        this.this$1.this$0.finish();
        continue;
        if (paramPopularize.getAction() == 4) {
          WelcomeActivity.access$600(this.this$1.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.3.1
 * JD-Core Version:    0.7.0.1
 */