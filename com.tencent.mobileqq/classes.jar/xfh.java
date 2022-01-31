import android.view.View;

public class xfh
{
  private int a;
  private int b;
  
  public xfh(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static xfh a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new xfh(0, -1);
    case 0: 
      return new xfh(0, 0);
    case 1: 
      return new xfh(0, -1);
    }
    return new xfh(0, -2);
  }
  
  public static xfh b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new xfh(1, -1);
    case 3: 
      return new xfh(1, 0);
    case 1: 
      return new xfh(1, -1);
    }
    return new xfh(1, -2);
  }
  
  public void a(View paramView)
  {
    if (this.a == 0) {
      switch (this.b)
      {
      default: 
        paramView.setPivotX(this.b);
      }
    }
    while (this.a != 1)
    {
      return;
      paramView.setPivotX(paramView.getWidth() * 0.5F);
      return;
      paramView.setPivotX(paramView.getWidth());
      return;
    }
    switch (this.b)
    {
    default: 
      paramView.setPivotY(this.b);
      return;
    case -1: 
      paramView.setPivotY(paramView.getHeight() * 0.5F);
      return;
    }
    paramView.setPivotY(paramView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfh
 * JD-Core Version:    0.7.0.1
 */