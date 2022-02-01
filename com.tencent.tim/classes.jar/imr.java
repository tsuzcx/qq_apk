import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.av.doodle.DoodleSurfaceView;

public class imr
{
  public static int a(int[] paramArrayOfInt, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramArrayOfInt[0];
    }
    if (paramFloat >= 1.0F) {
      return paramArrayOfInt[(paramArrayOfInt.length - 1)];
    }
    paramFloat = (paramArrayOfInt.length - 1) * paramFloat;
    int j = (int)paramFloat;
    paramFloat -= j;
    int i = paramArrayOfInt[j];
    j = paramArrayOfInt[(j + 1)];
    return Color.argb(c(Color.alpha(i), Color.alpha(j), paramFloat), c(Color.red(i), Color.red(j), paramFloat), c(Color.green(i), Color.green(j), paramFloat), c(Color.blue(i), Color.blue(j), paramFloat));
  }
  
  public static DoodleSurfaceView a(ViewGroup paramViewGroup)
  {
    Object localObject2 = (DoodleSurfaceView)paramViewGroup.findViewById(2131373974);
    Object localObject1 = localObject2;
    View localView;
    if (localObject2 == null)
    {
      localObject1 = new DoodleSurfaceView(paramViewGroup.getContext());
      localObject2 = new ViewGroup.LayoutParams(-1, -1);
      localView = paramViewGroup.findViewById(2131374269);
      if (localView == null) {
        break label67;
      }
    }
    label67:
    for (int i = paramViewGroup.indexOfChild(localView);; i = -1)
    {
      paramViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
      return localObject1;
    }
  }
  
  public static imo a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      localObject = new ims();
    }
    for (;;)
    {
      ((imo)localObject).apU = paramInt;
      return localObject;
      localObject = new ims();
      continue;
      localObject = new imv(2130968658);
    }
  }
  
  public static int c(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public static void c(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373974);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public static void iF(String paramString)
  {
    anot.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean ub()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imr
 * JD-Core Version:    0.7.0.1
 */