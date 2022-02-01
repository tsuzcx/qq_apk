import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class jje
  extends ReportDialog
{
  public jje(Context paramContext, boolean paramBoolean) {}
  
  void awU()
  {
    findViewById(2131374262).setOnClickListener(new jjg(this));
  }
  
  void init()
  {
    super.getWindow().setGravity(17);
    super.setContentView(2131559985);
  }
  
  public void k(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      awU();
    }
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131374263);
    localFrameLayout.setOnClickListener(new jjf(this));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jje
 * JD-Core Version:    0.7.0.1
 */