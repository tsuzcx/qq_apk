import android.view.View;
import android.view.ViewGroup;

public class wst
  extends wsr
{
  public final View b;
  
  public wst(View paramView)
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
 * Qualified Name:     wst
 * JD-Core Version:    0.7.0.1
 */