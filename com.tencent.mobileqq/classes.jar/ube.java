import android.view.View;
import android.view.ViewGroup;

public class ube
  extends ubc
{
  public final View b;
  
  public ube(View paramView)
  {
    super((ViewGroup)paramView.getParent());
    this.b = paramView;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ube
 * JD-Core Version:    0.7.0.1
 */