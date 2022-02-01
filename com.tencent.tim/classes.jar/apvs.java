import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class apvs
{
  public static final int[] fA = { 2131380430, 2131380431, 2131380429 };
  public static final int[] fy = { 2131699758, 2131699759, 2131699757 };
  public static final int[] fz = { 2130839770, 2130839770, 2130839769 };
  protected auvd a;
  
  public final View a(Context paramContext, int paramInt, auvd.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.a == null) {
      this.a = a(paramContext);
    }
    return this.a.a(paramContext, localView, parama, -1);
  }
  
  public auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    paramContext = fA;
    int[] arrayOfInt1 = fy;
    int[] arrayOfInt2 = fz;
    return new apvt(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.a != null) {
      this.a.a(paramContext, paramView, 0, paramObject, parama, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvs
 * JD-Core Version:    0.7.0.1
 */