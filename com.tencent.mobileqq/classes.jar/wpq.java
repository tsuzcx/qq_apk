import android.view.ViewGroup;
import android.widget.TextView;

public class wpq
  extends wpo
{
  protected TextView c = (TextView)a(2131380497);
  
  public wpq(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a(wly paramwly)
  {
    if (paramwly.b > 99)
    {
      this.c.setText("99+");
      return;
    }
    this.c.setText(String.valueOf(paramwly.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpq
 * JD-Core Version:    0.7.0.1
 */