import android.view.ViewGroup;
import android.widget.TextView;

public class uxp
  extends uxn
{
  protected TextView c = (TextView)a(2131379266);
  
  public uxp(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(utx paramutx)
  {
    if (paramutx.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramutx.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxp
 * JD-Core Version:    0.7.0.1
 */