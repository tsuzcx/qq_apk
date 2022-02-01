import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public class aytj
  implements aytk
{
  public static final String[] ju = { "#000000", "#FFFFFF", "#DF382C", "#F09A37", "#83D754", "#3478F6", "#7ED5F8", "#F7E368", "#E8519C" };
  public static final int[] un = { 2130847650, 2130847648, 2130847651, 2130847649, 2130847654, 2130847653, 2130847657, 2130847652, 2130847655 };
  
  public static int R(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Color.parseColor(ju[2]);
    }
    return Color.parseColor(ju[1]);
  }
  
  public void b(@NonNull ArrayList<aytl> paramArrayList, @NonNull Context paramContext)
  {
    int i = 0;
    while (i < ju.length)
    {
      paramArrayList.add(new aytl(paramContext.getResources().getDrawable(un[i]), 0, ju[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytj
 * JD-Core Version:    0.7.0.1
 */