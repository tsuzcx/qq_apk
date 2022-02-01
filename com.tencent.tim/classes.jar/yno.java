import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import java.util.Iterator;
import java.util.List;

public class yno
  implements ReadInJoySearchTipsContainer.a
{
  public yno(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void of(String paramString)
  {
    SearchProtocol.WordItem localWordItem;
    if (paramString != null)
    {
      Iterator localIterator = this.this$0.sP.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWordItem = (SearchProtocol.WordItem)localIterator.next();
      } while (!paramString.equals(localWordItem.word));
    }
    for (;;)
    {
      if ((localWordItem != null) && (localWordItem.type == 2))
      {
        paramString = new Intent(this.this$0, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", localWordItem.jumpUrl);
        paramString.putExtra("articalChannelId", 14);
        this.this$0.startActivity(paramString);
        if (localWordItem != null)
        {
          paramString = "";
          if (this.this$0.mSource != ClassificationSearchActivity.cad) {
            break label333;
          }
          paramString = "kan";
        }
      }
      for (;;)
      {
        if (localWordItem.type != 2) {
          break label352;
        }
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, localWordItem.jumpUrl, paramString, "");
        return;
        if (this.this$0.mSource == ClassificationSearchActivity.cad)
        {
          this.this$0.aN.setText(paramString);
          if (!TextUtils.isEmpty(paramString.trim()))
          {
            this.this$0.aN.setSelection(this.this$0.aN.getText().length());
            ClassificationSearchActivity.a(this.this$0, paramString);
          }
        }
        for (;;)
        {
          if ((this.this$0.mSource == ClassificationSearchActivity.cag) || (TextUtils.isEmpty(paramString.trim()))) {
            break label331;
          }
          this.this$0.oR(paramString);
          break;
          if (this.this$0.mSource == ClassificationSearchActivity.cag)
          {
            this.this$0.aN.setText(paramString);
            this.this$0.aN.setSelection(paramString.length());
            ClassificationSearchActivity.a(this.this$0, paramString);
          }
          else
          {
            this.this$0.a.bc(paramString, false);
          }
        }
        label331:
        break;
        label333:
        if (this.this$0.mSource == ClassificationSearchActivity.cag) {
          paramString = "quan";
        }
      }
      label352:
      kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, "0", paramString, "");
      return;
      localWordItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */