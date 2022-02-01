import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;

public class uiq
{
  public static blsy<stSimpleMetaFeed> a(int paramInt, ViewGroup paramViewGroup, udq paramudq)
  {
    return uip.a(paramViewGroup, paramudq, paramInt);
  }
  
  public static uir a(int paramInt)
  {
    uir localuir = new uir();
    localuir.jdField_a_of_type_Int = paramInt;
    localuir.jdField_a_of_type_Boolean = b(paramInt);
    localuir.b = c(paramInt);
    localuir.c = d(paramInt);
    localuir.d = e(paramInt);
    localuir.e = f(paramInt);
    localuir.f = g(paramInt);
    return localuir;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10);
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7);
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  private static boolean d(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean e(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  private static boolean f(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7);
  }
  
  private static boolean g(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 7) || (paramInt == 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uiq
 * JD-Core Version:    0.7.0.1
 */