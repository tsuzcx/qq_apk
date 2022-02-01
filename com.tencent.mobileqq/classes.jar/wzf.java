import android.view.ViewGroup;
import android.widget.TextView;

public class wzf
  extends wzd
{
  protected TextView c = (TextView)a(2131380438);
  
  public wzf(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(wvn paramwvn)
  {
    if (paramwvn.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramwvn.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzf
 * JD-Core Version:    0.7.0.1
 */