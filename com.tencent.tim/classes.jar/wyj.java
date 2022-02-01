import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;

class wyj
  implements ViewTreeObserver.OnPreDrawListener
{
  wyj(wyi paramwyi, TextView paramTextView, String paramString) {}
  
  private String ToDBC(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public boolean onPreDraw()
  {
    int j = 0;
    int k = this.IG.getMeasuredWidth() * 2;
    this.IG.setText(this.aUz);
    TextPaint localTextPaint = this.IG.getPaint();
    String str2 = ToDBC(this.a.mContext.getString(2131699433) + ">");
    String str3 = ToDBC(this.aUz);
    String str1 = "  " + str2;
    Object localObject = str3 + str1;
    if (localTextPaint.measureText((String)localObject + "      ") < k) {}
    label329:
    for (;;)
    {
      k = ((String)localObject).length();
      int i = j;
      if (k > str2.length()) {
        i = k - str2.length();
      }
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-14782465), i, k, 33);
      this.IG.setText((CharSequence)localObject);
      return true;
      String str4 = "..." + str1;
      int m = str3.length();
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label329;
        }
        str1 = str3.substring(0, m - i) + str4;
        localObject = str1;
        if (localTextPaint.measureText(str1 + "      ") < k) {
          break;
        }
        i += 1;
        localObject = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyj
 * JD-Core Version:    0.7.0.1
 */