import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;

public class akme
  implements ActionMode.Callback
{
  public akme(OCRResultActivity paramOCRResultActivity, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131372592)
    {
      paramActionMode = OCRResultActivity.a(this.a, this.val$editText);
      if (TextUtils.isEmpty(paramActionMode)) {
        QQToast.a(this.a, 1, acfp.m(2131709345), 0).show();
      }
    }
    else
    {
      return false;
    }
    OCRTextSearchActivity.e(this.a, paramActionMode);
    this.a.overridePendingTransition(2130772004, 0);
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
 * Qualified Name:     akme
 * JD-Core Version:    0.7.0.1
 */