import android.view.ViewGroup;
import android.widget.TextView;

public class wvk
  extends wvi
{
  protected TextView c = (TextView)a(2131380252);
  
  public wvk(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(wrs paramwrs)
  {
    if (paramwrs.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramwrs.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvk
 * JD-Core Version:    0.7.0.1
 */