import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class akms
  implements ActionMode.Callback
{
  public akms(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131372592)
    {
      paramActionMode = aklz.a(this.val$editText);
      if (TextUtils.isEmpty(paramActionMode)) {
        QQToast.a(OCRResultFragmentNew.a(this.a), 1, acfp.m(2131709345), 0).show();
      }
    }
    else
    {
      return false;
    }
    OCRTextSearchActivity.e(OCRResultFragmentNew.a(this.a), paramActionMode);
    OCRResultFragmentNew.a(this.a).overridePendingTransition(2130772004, 0);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131623940, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akms
 * JD-Core Version:    0.7.0.1
 */