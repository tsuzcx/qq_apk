import android.content.Context;
import android.view.View;

public class vtg
{
  protected final View a;
  
  protected vtg(View paramView)
  {
    this.a = paramView;
  }
  
  protected Context a()
  {
    return this.a.getContext();
  }
  
  protected <T extends View> T a(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtg
 * JD-Core Version:    0.7.0.1
 */