import android.app.Activity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class hgb
  implements ActionMode.Callback
{
  public hgb(ContainerView.SelectableTextView paramSelectableTextView, ContainerView paramContainerView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMenuItem.getItemId() == 2131234873)
    {
      paramActionMode = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getContext();
      bool1 = bool2;
      if (paramActionMode != null)
      {
        bool1 = bool2;
        if ((paramActionMode instanceof TextPreviewActivity))
        {
          paramMenuItem = (TextPreviewActivity)paramActionMode;
          CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getText().subSequence(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionStart(), this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionEnd());
          if (localCharSequence != null) {
            TextPreviewActivity.a(localCharSequence.toString(), (Activity)paramActionMode, paramMenuItem.b, paramMenuItem.g, paramMenuItem.jdField_a_of_type_Int, TextPreviewActivity.jdField_a_of_type_Long, false);
          }
          ReportController.b(paramMenuItem.b, "CliOper", "", "", "0X8004065", "0X8004065", 0, 0, "", "", "", "");
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode.getMenuInflater().inflate(2131755008, paramMenu);
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgb
 * JD-Core Version:    0.7.0.1
 */