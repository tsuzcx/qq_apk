import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;

public class vxt
  extends blir
{
  public vxt(Context paramContext)
  {
    super(paramContext);
  }
  
  public static vxt a(Context paramContext)
  {
    paramContext = new vxt(paramContext);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131755013);
    }
    return paramContext;
  }
  
  protected int a()
  {
    return super.a();
  }
  
  protected int a(int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 8)) {
      return super.a(paramInt);
    }
    return this.a.getColor(2131166775);
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.a.getDrawable(2130848953);
    }
    return this.a.getDrawable(2130848950);
  }
  
  protected int b()
  {
    return super.b();
  }
  
  protected int c()
  {
    return 2131562629;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxt
 * JD-Core Version:    0.7.0.1
 */