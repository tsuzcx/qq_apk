import android.view.View;

public class wwm
{
  private int a;
  private int b;
  
  public wwm(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static wwm a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new wwm(0, -1);
    case 0: 
      return new wwm(0, 0);
    case 1: 
      return new wwm(0, -1);
    }
    return new wwm(0, -2);
  }
  
  public static wwm b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new wwm(1, -1);
    case 3: 
      return new wwm(1, 0);
    case 1: 
      return new wwm(1, -1);
    }
    return new wwm(1, -2);
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
 * Qualified Name:     wwm
 * JD-Core Version:    0.7.0.1
 */