import android.view.View;
import android.view.ViewGroup;

public class toi
  extends tog
{
  public final View b;
  
  public toi(View paramView)
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
 * Qualified Name:     toi
 * JD-Core Version:    0.7.0.1
 */