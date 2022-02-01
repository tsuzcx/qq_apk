import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class zmc
{
  public static String keyword;
  public MessageRecord messageRecord;
  
  public zmc(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageItem", 2, "MessageItem, messageRecord.senderuin = " + paramMessageRecord.senderuin);
    }
    this.messageRecord = paramMessageRecord;
  }
  
  public static String f(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuilder(paramCharSequence);
    int k = paramCharSequence.length();
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int m = paramCharSequence.codePointAt(i);
      int j;
      if ((m == 20) && (i < k - 1))
      {
        j = i;
        if (paramCharSequence.charAt(i + 1) < aoff.dOp)
        {
          paramCharSequence.replace(i, i + 2, "\001\001");
          j = i + 1;
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        j = i;
        if (aoff.ah.get(m, -1) >= 0) {
          if ((m > 65535) && (k >= i + 2))
          {
            paramCharSequence.replace(i, i + 2, "\001\001");
            j = i;
          }
          else
          {
            paramCharSequence.replace(i, i + 1, "\001");
            j = i;
          }
        }
      }
    }
    return paramCharSequence.toString();
  }
  
  public static void setKeyword(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageItem", 2, "setKeyword, keyword = " + paramString);
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      keyword = paramString.toLowerCase(Locale.US);
    }
  }
  
  public CharSequence a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    paramString = new aofk(c(paramString), 3, 16);
    a(paramString, paramInt);
    return paramString;
  }
  
  public void a(Spannable paramSpannable, int paramInt)
  {
    int i = 0;
    int j = 0;
    String str = f(paramSpannable.toString()).toString().toLowerCase(Locale.US);
    int m = keyword.length();
    String[] arrayOfString = (String[])paramSpannable.getSpans(0, paramSpannable.length(), String.class);
    if (arrayOfString != null)
    {
      int n = arrayOfString.length;
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= n) {
          break;
        }
        if ("...".equals(arrayOfString[k])) {
          j = "...".length();
        }
        k += 1;
      }
    }
    j = str.indexOf(keyword, i);
    if ((j >= 0) && (j < str.length()))
    {
      i = j + m;
      paramSpannable.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
      j = i;
    }
    for (;;)
    {
      if (j >= 0)
      {
        i = j;
        if (j < str.length()) {
          break;
        }
      }
      return;
    }
  }
  
  public String be(long paramLong)
  {
    return aqmu.a(1000L * paramLong, true, "yyyy-MM-dd");
  }
  
  public SpannableString c(String paramString)
  {
    int i = f(paramString).toLowerCase(Locale.US).indexOf(keyword);
    if (i > 20)
    {
      int j = i - 20;
      int k = paramString.codePointAt(j - 1);
      if (k != 20)
      {
        i = j;
        if (aoff.ah.get(k, -1) >= 0)
        {
          i = j;
          if (k <= 65535) {}
        }
      }
      else
      {
        i = j + 1;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      localStringBuilder.append("...");
      localStringBuilder.append(paramString.substring(i));
      paramString = new SpannableString(localStringBuilder.toString());
      paramString.setSpan("...", 0, "...".length(), 33);
      return paramString;
    }
    return new SpannableString(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq = ").append(this.messageRecord.uniseq);
    localStringBuilder.append(", msg = ").append(this.messageRecord.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmc
 * JD-Core Version:    0.7.0.1
 */