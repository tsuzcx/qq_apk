import android.os.Build.VERSION;

public class ufg
{
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    case 3: 
    case 1: 
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT >= 21);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */