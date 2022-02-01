import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;

public class apot
{
  private static apot a = new apot();
  String cql;
  
  public static apot a()
  {
    return a;
  }
  
  public void A(BaseChatPie paramBaseChatPie) {}
  
  public void Tt(String paramString) {}
  
  public void a(String paramString, apot.a parama) {}
  
  public void bb(String paramString1, String paramString2, String paramString3) {}
  
  public void eaZ() {}
  
  public boolean isPlaying()
  {
    return !TextUtils.isEmpty(this.cql);
  }
  
  public boolean qF(String paramString)
  {
    return true;
  }
  
  public boolean qG(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.cql))) {
      return false;
    }
    return paramString.equals(this.cql);
  }
  
  public void stop() {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apot
 * JD-Core Version:    0.7.0.1
 */