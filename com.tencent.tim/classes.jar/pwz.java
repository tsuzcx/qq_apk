import android.view.ViewGroup;
import android.widget.TextView;

public class pwz
  extends pwx
{
  protected TextView xe = (TextView)getView(2131381283);
  
  public pwz(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void r(puh parampuh)
  {
    if (parampuh.unreadCount > 99)
    {
      this.xe.setText("99+");
      return;
    }
    this.xe.setText(String.valueOf(parampuh.unreadCount));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwz
 * JD-Core Version:    0.7.0.1
 */