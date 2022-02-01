package com.tencent.qqmail.activity.compose.richeditor;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

final class DetailReporter$1
  implements Runnable
{
  DetailReporter$1(ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    Object localObject = this.val$mailVar;
    if ((localObject == null) || (((ComposeMailUI)localObject).getContent() == null)) {
      return;
    }
    int i;
    label36:
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(((ComposeMailUI)localObject).getContent().getOrigin()))
    {
      i = 1;
      localStringBuilder = new StringBuilder().append("It's new mail = ");
      if (i != 0) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      Log.i("DetailReporter", bool);
      if (i != 0) {
        break;
      }
      localObject = ((ComposeMailUI)localObject).getContent().getBody();
      Log.i("DetailReporter", "mail content is " + (String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      i = StringUtils.countMatches((CharSequence)localObject, "</h3>");
      int j = StringUtils.countMatches((CharSequence)localObject, "</b>");
      int k = StringUtils.countMatches((CharSequence)localObject, "</strike>");
      int m = StringUtils.countMatches((CharSequence)localObject, "</ul>");
      int n = StringUtils.countMatches((CharSequence)localObject, "text-align: center");
      int i1 = StringUtils.countMatches((CharSequence)localObject, "</blockquote>");
      Log.i("DetailReporter", String.format("headerCount [%s],boldCount [%s],strikeCount [%s],unorderListCount [%s],centerCount [%s],blockQuoteCount [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
      KvHelper.eventRichEditorMailContainsTitle(new double[] { i });
      KvHelper.eventRichEditorMailContainsBold(new double[] { j });
      KvHelper.eventRichEditorMailContainsMidline(new double[] { k });
      KvHelper.eventRichEditorMailContainsList(new double[] { m });
      KvHelper.eventRichEditorMailContainsCenter(new double[] { n });
      KvHelper.eventRichEditorMailContainsQuote(new double[] { i1 });
      return;
      i = 0;
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.DetailReporter.1
 * JD-Core Version:    0.7.0.1
 */