import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public abstract class iwu
{
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    QLog.w("NewTipsManager", 1, "hideAllTips, seq[" + paramLong + "]");
    ((ikz)paramVideoAppInterface.a(11)).anE();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ikz)paramVideoAppInterface.a(11)).kU(paramInt);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ikz)paramVideoAppInterface.a(11)).ii(paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).h(paramInt, paramLong);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).a(paramInt, paramLong, paramBoolean);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).f(paramInt, paramString);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).a(paramInt1, paramString, paramDrawable, paramInt2, paramOnClickListener);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).a(paramInt, paramString, null, -1, paramOnClickListener);
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, boolean paramBoolean) {}
  
  public static boolean b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return ((ikz)paramVideoAppInterface.a(11)).cl(paramInt);
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    if (paramVideoAppInterface == null) {
      return false;
    }
    return a(paramVideoAppInterface, paramInt1, paramVideoAppInterface.getApp().getString(paramInt2));
  }
  
  public static void l(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ikz)paramVideoAppInterface.a(11)).anH();
  }
  
  public static void m(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    ((ikz)paramVideoAppInterface.a(11)).anI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwu
 * JD-Core Version:    0.7.0.1
 */