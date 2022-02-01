import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class wvh
  implements ActionMode.Callback
{
  int bRJ = 1;
  int bRK = 2;
  
  wvh(wvd paramwvd) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == this.bRJ)
    {
      anot.a(wvd.a(this.this$0), "dc00898", "", "", "0X800A513", "0X800A513", wvd.a(this.this$0), 0, "", "", "", "");
      wvd.a(this.this$0).a.getText().insert(wvd.a(this.this$0).a.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool = true;
    }
    while (paramMenuItem.getItemId() != this.bRK) {
      return bool;
    }
    if (this.this$0.isFullScreenMode())
    {
      anot.a(wvd.a(this.this$0), "dc00898", "", "", "0X800A514", "0X800A514", wvd.a(this.this$0), 0, "", "", "", "");
      this.this$0.K(false);
    }
    for (;;)
    {
      paramActionMode.finish();
      return true;
      anot.a(wvd.a(this.this$0), "dc00898", "", "", "0X8009F28", "0X8009F28", wvd.a(this.this$0), 0, "", "", "", "");
      wvd.b(this.this$0);
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (anlm.ayn()) {
      return true;
    }
    int i = this.bRK;
    if (this.this$0.isFullScreenMode()) {}
    for (paramActionMode = acfp.m(2131706666);; paramActionMode = acfp.m(2131706663))
    {
      paramMenu.add(0, i, 196608, paramActionMode);
      return true;
    }
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvh
 * JD-Core Version:    0.7.0.1
 */