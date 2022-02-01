import android.content.Context;
import android.widget.TextView;

public class ansd
  extends anqw
{
  public ansd()
  {
    this(null);
  }
  
  public ansd(String paramString)
  {
    super(paramString, "tips");
  }
  
  public int Kp()
  {
    return -1;
  }
  
  public int Kq()
  {
    return 28;
  }
  
  public TextView d(Context paramContext)
  {
    paramContext = super.d(paramContext);
    paramContext.setBackgroundResource(2130845675);
    paramContext.setPadding(20, 5, 20, 5);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  public String getLayoutStr()
  {
    return "tips";
  }
  
  protected int getTextId()
  {
    return 2131380973;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansd
 * JD-Core Version:    0.7.0.1
 */