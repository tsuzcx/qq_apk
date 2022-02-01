import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import java.lang.reflect.Field;

public class zmm
{
  public static void a(@NonNull LayoutInflater paramLayoutInflater, @NonNull LayoutInflater.Factory paramFactory)
  {
    try
    {
      paramLayoutInflater.setFactory(paramFactory);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zmo.c("LayoutModifier", "LayoutInflater.setFactory IllegalStateException " + localIllegalStateException);
      try
      {
        Field localField1 = LayoutInflater.class.getDeclaredField("mFactory");
        localField1.setAccessible(true);
        Field localField2 = LayoutInflater.class.getDeclaredField("mFactory2");
        localField2.setAccessible(true);
        localField1.set(paramLayoutInflater, paramFactory);
        localField2.set(paramLayoutInflater, paramFactory);
        if ((paramLayoutInflater.getFactory() == paramFactory) && (paramLayoutInflater.getFactory2() == paramFactory))
        {
          zmo.b("LayoutModifier", "hookLayoutInflaterFactory success");
          return;
        }
      }
      catch (Exception paramLayoutInflater)
      {
        zmo.d("LayoutModifier", "hook setFactory " + paramLayoutInflater);
        return;
      }
      zmo.b("LayoutModifier", "hookLayoutInflaterFactory failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmm
 * JD-Core Version:    0.7.0.1
 */