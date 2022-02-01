import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class avnz
  extends avnl
{
  public avnz(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull avnk paramavnk)
  {
    paramavnk = paramavnk.f();
    if (paramavnk == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramavnk.getJSONObject("data").getInt("identity");
        paramavnk = this.a;
        if (i == 2)
        {
          bool = true;
          avob.a.X(paramavnk, bool);
          avoc.i("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception paramavnk)
      {
        avoc.e("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", paramavnk);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnz
 * JD-Core Version:    0.7.0.1
 */