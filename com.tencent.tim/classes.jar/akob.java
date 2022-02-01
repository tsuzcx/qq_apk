import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class akob
{
  public List<String> words;
  
  public akob(List<String> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((paramString != null) && (!((List)localObject).contains(paramString))) {
      ((List)localObject).add(paramString);
    }
    Collections.sort((List)localObject, new akoc(this));
    this.words = ((List)localObject);
  }
  
  public static String mB(String paramString)
  {
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramString).replaceAll("");
  }
  
  public SpannableString a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Object localObject = new SpannableString(paramString);
    if ((this.words == null) || (this.words.size() <= 0)) {
      return localObject;
    }
    Object[] arrayOfObject = this.words.toArray();
    int k = 0;
    int i = 0;
    int j = 0;
    String str1 = paramString;
    paramString = (String)localObject;
    String str2;
    int m;
    for (;;)
    {
      localObject = paramString;
      if (k >= arrayOfObject.length) {
        break;
      }
      str2 = (String)arrayOfObject[k];
      if (str2.length() <= 1)
      {
        localObject = paramString;
        if (i != 0) {
          break;
        }
      }
      m = 0;
      m = g(str1, str2, m);
      if (m != -1) {
        break label137;
      }
      k += 1;
    }
    label137:
    if ((m > 10) && (j == 0) && (!paramBoolean))
    {
      str1 = "…" + str1.substring(m - 6);
      paramString = new SpannableString(str1);
      m = 7;
      j = 1;
    }
    for (;;)
    {
      if (str2.length() > 1) {
        j = 1;
      }
      int n;
      for (i = 1;; i = n)
      {
        paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), m, str2.length() + m, 34);
        n = i;
        m += 1;
        i = j;
        j = n;
        break;
        n = j;
        j = i;
      }
    }
  }
  
  public SpannableString e(String paramString)
  {
    return a(paramString, false);
  }
  
  public int g(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return -1;
    }
    return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akob
 * JD-Core Version:    0.7.0.1
 */