import android.content.res.Resources;

public final class jiv
{
  public static jiw a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559946: 
    case 2131559947: 
    case 2131559949: 
    default: 
      return null;
    case 2131559945: 
      localObject1 = new int[][] { { 2131697526, 2130843046 }, { 2131697534, 2130842870 }, { 2131697532, 2130842868 }, { 2131697531, 2130843050 }, { 2131697527, 2130843132 }, { 2131697530, 2130843049 } };
    }
    int[] arrayOfInt1;
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[] { 2131697526, 2130843046 };
      localObject2 = new int[] { 2131697534, 2130842870 };
      arrayOfInt1 = new int[] { 2131697528, 2130843047 };
      localObject1 = new int[][] { { 2131697537, 2130843059 }, localObject1, localObject2, { 2131697530, 2130843049 }, arrayOfInt1 };
      continue;
      localObject1 = new int[] { 2131697537, 2130843059 };
      localObject2 = new int[] { 2131697526, 2130843046 };
      arrayOfInt1 = new int[] { 2131697527, 2130843132 };
      int[] arrayOfInt2 = { 2131697528, 2130843047 };
      localObject1 = new int[][] { localObject1, localObject2, { 2131697534, 2130842870 }, { 2131697532, 2130842868 }, arrayOfInt1, { 2131697530, 2130843049 }, arrayOfInt2 };
      continue;
      localObject1 = new int[][] { { 2131697526, 2130843046 }, { 2131697534, 2130842870 }, { 2131697532, 2130842868 } };
    }
    Object localObject2 = new jiw();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((jiw)localObject2).a(new jiu(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((jiw)localObject2).awS = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jiv
 * JD-Core Version:    0.7.0.1
 */