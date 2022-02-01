import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;

public class aytl
{
  public static final int[] ek = { -1, -2148308, -1009097, -8136876, -13338378 };
  public static final int[] el = { 2130847648, 2130847651, 2130847649, 2130847654, 2130847653 };
  public static final int[] uo = { -16777216, -1, -2148308, -1009097, -8136876, -13338378 };
  public static final int[] up = { 2130847650, 2130847648, 2130847651, 2130847649, 2130847654, 2130847653 };
  public String cTR;
  public String contentDescription;
  public Drawable mDrawable;
  public int subType;
  public int type;
  
  public aytl(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.mDrawable = paramDrawable;
    this.type = paramInt1;
    this.subType = paramInt2;
    if (paramInt1 == 0) {
      this.contentDescription = ColorPicker.cB(paramInt2);
    }
  }
  
  public aytl(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.mDrawable = paramDrawable;
    this.type = paramInt;
    this.cTR = paramString;
    this.subType = Color.parseColor(paramString);
  }
  
  public static int R(boolean paramBoolean)
  {
    if (paramBoolean) {
      return uo[2];
    }
    return ek[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytl
 * JD-Core Version:    0.7.0.1
 */