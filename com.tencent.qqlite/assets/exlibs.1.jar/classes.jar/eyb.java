import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class eyb
  implements View.OnClickListener
{
  public eyb(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eyb
 * JD-Core Version:    0.7.0.1
 */