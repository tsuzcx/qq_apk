package com.tencent.qqmail.popularize.view;

import android.content.Context;
import com.tencent.qqmail.activity.webviewexplorer.PopularizeWebViewExplorer;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.schema.SchemaUtil;

final class PopularizeUIHelper$3
  implements PopularizeUIHelper.PopularizeActionDelegate
{
  PopularizeUIHelper$3(Context paramContext) {}
  
  public boolean onAction(Popularize paramPopularize)
  {
    int i = paramPopularize.getAction();
    int j = PopularizeUIHelper.getAnimationTypeByPopularize(paramPopularize.getType());
    String str = paramPopularize.getOpenUrl();
    if (i == 1)
    {
      if ((str == null) || (!str.startsWith("qqmail://"))) {
        break label53;
      }
      SchemaUtil.handleSchemaAction(this.val$context, str, j, 2);
    }
    for (;;)
    {
      return false;
      label53:
      if ((str != null) && ((str.startsWith("http://")) || (str.startsWith("https://"))))
      {
        paramPopularize = PopularizeWebViewExplorer.createIntent(str, paramPopularize.getId(), j);
        this.val$context.startActivity(paramPopularize);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeUIHelper.3
 * JD-Core Version:    0.7.0.1
 */