import android.view.View;
import android.view.ViewGroup;

public class qjy
  extends qjw
{
  public final View oh;
  
  public qjy(View paramView)
  {
    super((ViewGroup)paramView.getParent());
    this.oh = paramView;
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return this.oh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjy
 * JD-Core Version:    0.7.0.1
 */