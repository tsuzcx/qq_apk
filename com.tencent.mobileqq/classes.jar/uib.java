import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;

public class uib
{
  public static bkrv<stSimpleMetaFeed> a(int paramInt, ViewGroup paramViewGroup, udo paramudo)
  {
    return uia.a(paramViewGroup, paramudo, paramInt);
  }
  
  public static uic a(int paramInt)
  {
    uic localuic = new uic();
    localuic.jdField_a_of_type_Int = paramInt;
    localuic.jdField_a_of_type_Boolean = b(paramInt);
    localuic.b = c(paramInt);
    localuic.c = d(paramInt);
    localuic.d = e(paramInt);
    localuic.e = f(paramInt);
    localuic.f = g(paramInt);
    return localuic;
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
 * Qualified Name:     uib
 * JD-Core Version:    0.7.0.1
 */