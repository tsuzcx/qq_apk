public class xrc
{
  public static String a(String paramString, int paramInt)
  {
    if (paramString.getBytes().length <= paramInt) {
      return paramString;
    }
    int k = paramString.length();
    int j = 0;
    for (int i = 0;; i = j) {
      if (j < k)
      {
        j += Character.charCount(paramString.codePointAt(j));
        if (paramString.substring(0, j).getBytes().length <= paramInt) {}
      }
      else
      {
        return paramString.substring(0, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrc
 * JD-Core Version:    0.7.0.1
 */