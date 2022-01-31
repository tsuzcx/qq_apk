import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class hhf
  implements View.OnClickListener
{
  public hhf(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput) {}
  
  public void onClick(View paramView)
  {
    if (QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        paramView = QQCustomDialogWtihEmoticonInput.a(this.a).getText();
        int i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(QQCustomDialogWtihEmoticonInput.a(this.a).getText(), i);
        if (i != j)
        {
          paramView.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhf
 * JD-Core Version:    0.7.0.1
 */