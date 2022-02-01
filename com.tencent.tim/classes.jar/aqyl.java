import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class aqyl
{
  public static aqzl a(arcd paramarcd)
  {
    int j = 0;
    int i = j;
    if (paramarcd.c != null)
    {
      i = j;
      if (paramarcd.c.getIntent() != null) {
        i = paramarcd.c.getIntent().getIntExtra("titleBarStyle", 0);
      }
    }
    avoc.i("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new avdx(paramarcd);
    }
    if (i == 2) {
      return new aqzt(paramarcd);
    }
    if (i == 3) {
      return new avoj(paramarcd);
    }
    if (i == 4) {
      return new phk(paramarcd);
    }
    return new aqzl(paramarcd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyl
 * JD-Core Version:    0.7.0.1
 */