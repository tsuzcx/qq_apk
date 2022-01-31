import android.view.ViewGroup;
import android.widget.TextView;

public class vby
  extends vbw
{
  protected TextView c = (TextView)a(2131379324);
  
  public vby(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(uyg paramuyg)
  {
    if (paramuyg.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramuyg.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vby
 * JD-Core Version:    0.7.0.1
 */