import android.view.View;
import android.view.ViewGroup;

public class vuc
  extends vua
{
  public final View b;
  
  public vuc(View paramView)
  {
    super((ViewGroup)paramView.getParent());
    this.b = paramView;
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vuc
 * JD-Core Version:    0.7.0.1
 */