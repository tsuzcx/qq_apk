import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class hkm
  implements View.OnClickListener
{
  public hkm(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hkm
 * JD-Core Version:    0.7.0.1
 */