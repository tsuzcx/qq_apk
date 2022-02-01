import android.graphics.Bitmap;

public class ayqh
{
  private static boolean[] k = new boolean[5];
  public String aAY;
  public String aAZ;
  public boolean aGy;
  public boolean aIF;
  public int bsR;
  public int bsS;
  public Bitmap cK;
  public boolean dAr;
  public Bitmap doodleBitmap;
  public boolean result;
  
  public ayqh(String paramString)
  {
    this.aAY = paramString;
  }
  
  public static boolean eV(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      return true;
    }
    return k[paramInt];
  }
  
  public static void i(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 5) {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 5))
      {
        k[i] = false;
        i += 1;
      }
      else
      {
        boolean[] arrayOfBoolean = k;
        int m = arrayOfBoolean[i];
        if (paramArrayOfInt[i] > 0) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = (j | m);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqh
 * JD-Core Version:    0.7.0.1
 */