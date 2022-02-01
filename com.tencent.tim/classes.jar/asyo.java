import android.util.Pair;

final class asyo
  implements asyn.a
{
  public Pair<String, String> j(String paramString)
  {
    paramString = paramString.split(":", 2);
    if ((paramString == null) || (paramString.length < 2)) {
      return null;
    }
    return new Pair(paramString[0].trim(), paramString[1].trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyo
 * JD-Core Version:    0.7.0.1
 */