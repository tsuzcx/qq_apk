import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

public class vws
{
  public static void a(long paramLong, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramLong != 10022L) && (paramLong != 10023L)) {
      QQToast.a(paramContext, paramInt1, paramString, paramInt2).a();
    }
  }
  
  public static void a(long paramLong, Context paramContext, String paramString, int paramInt)
  {
    a(paramLong, paramContext, 0, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vws
 * JD-Core Version:    0.7.0.1
 */