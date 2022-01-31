import android.view.ViewGroup;
import android.widget.TextView;

public class tix
  extends tiv
{
  protected TextView c = (TextView)a(2131378649);
  
  public tix(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(tff paramtff)
  {
    if (paramtff.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramtff.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tix
 * JD-Core Version:    0.7.0.1
 */