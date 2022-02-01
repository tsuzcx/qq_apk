import android.text.TextUtils;
import com.google.zxing.client.android.wifi.ParsedResultType;

public abstract class lh
{
  private final ParsedResultType a;
  
  protected lh(ParsedResultType paramParsedResultType)
  {
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public abstract String X();
  
  public final String toString()
  {
    return X();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lh
 * JD-Core Version:    0.7.0.1
 */