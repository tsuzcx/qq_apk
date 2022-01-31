import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class ynu
  extends ahhg
{
  public ynu(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    localLayoutParams.y -= getContext().getResources().getDimensionPixelOffset(2131298994);
    paramBundle.setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ynu
 * JD-Core Version:    0.7.0.1
 */