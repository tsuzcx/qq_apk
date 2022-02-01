import android.view.View;
import android.view.ViewGroup;

public class xri
  extends xrg
{
  public final View b;
  
  public xri(View paramView)
  {
    super((ViewGroup)paramView.getParent());
    this.b = paramView;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */