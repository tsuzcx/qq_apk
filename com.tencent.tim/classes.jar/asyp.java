import android.util.Pair;

final class asyp
  implements asyn.a
{
  public Pair<String, String> j(String paramString)
  {
    int i = paramString.indexOf(':');
    if ((i <= 0) || (i >= paramString.length())) {
      return null;
    }
    return new Pair(paramString.substring(0, i).trim(), paramString.substring(i + 1).trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyp
 * JD-Core Version:    0.7.0.1
 */