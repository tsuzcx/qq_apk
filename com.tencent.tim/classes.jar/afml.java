import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;

public class afml
{
  public static EmoticonMainPanel a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, EditText paramEditText, afmf paramafmf)
  {
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity.getBaseContext(), 2131559281, null);
    paramEditText.setCallBack(paramafmf);
    paramEditText.bYZ = true;
    paramEditText.bZc = true;
    paramEditText.bYX = false;
    paramEditText.bYY = true;
    paramEditText.bZb = true;
    paramEditText.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new afmm());
    paramEditText.a.setOverScrollMode(2);
    return paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afml
 * JD-Core Version:    0.7.0.1
 */