import android.view.ViewGroup;
import android.widget.TextView;

public class tja
  extends tiy
{
  protected TextView c = (TextView)a(2131378644);
  
  public tja(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(tfi paramtfi)
  {
    if (paramtfi.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramtfi.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tja
 * JD-Core Version:    0.7.0.1
 */