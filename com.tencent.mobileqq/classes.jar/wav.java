import android.view.ViewGroup;
import android.widget.TextView;

public class wav
  extends wat
{
  protected TextView c = (TextView)a(2131380162);
  
  public wav(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(vxd paramvxd)
  {
    if (paramvxd.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramvxd.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wav
 * JD-Core Version:    0.7.0.1
 */