import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class avzt
{
  public static int a(EditText paramEditText, ArrayList<ResultRecord> paramArrayList, List<avzs> paramList, int paramInt)
  {
    int i;
    if (paramArrayList == null)
    {
      i = paramInt;
      return i;
    }
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      label15:
      i = paramInt;
      if (!paramArrayList.hasNext()) {
        break;
      }
      Object localObject = (ResultRecord)paramArrayList.next();
      avzs localavzs = new avzs();
      if (!TextUtils.isEmpty(((ResultRecord)localObject).name)) {}
      for (localavzs.mName = ((ResultRecord)localObject).name;; localavzs.mName = ((ResultRecord)localObject).uin) {
        try
        {
          long l = Long.valueOf(((ResultRecord)localObject).uin).longValue();
          localavzs.mUin = l;
          if ((localavzs.mName == null) || (localavzs.mUin == 0L)) {
            break label15;
          }
          i = paramInt;
          if (paramList == null) {
            break;
          }
          paramList.add(localavzs);
          localObject = "@" + localavzs.mName + " ";
          i = paramInt;
          if (paramInt < ((String)localObject).length()) {
            i = ((String)localObject).length();
          }
          a((String)localObject, paramEditText.getSelectionStart(), paramEditText);
          paramInt = i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
  
  public static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, List<avzs> paramList, int paramInt3, int paramInt4, String paramString)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 1)) {
      return -1;
    }
    int j;
    int i;
    if (paramCharSequence.length() > paramInt1)
    {
      j = paramInt1 - 1;
      i = 1;
    }
    for (;;)
    {
      if ((j < 0) || (i > paramInt2)) {
        break label112;
      }
      if ((paramCharSequence.charAt(j) == '@') && (a(paramCharSequence.toString().substring(j, paramInt1), false, paramList, paramInt3, paramInt4, paramString)))
      {
        return j;
        paramInt1 = paramCharSequence.length();
        break;
      }
      j -= 1;
      i += 1;
    }
    label112:
    return -1;
  }
  
  public static SystemEmoticonPanel a(Context paramContext, EditText paramEditText)
  {
    try
    {
      paramContext = new SystemEmoticonPanel(paramContext, new avzu(paramEditText));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QZoneShareActivity", 1, paramContext.getStackTrace());
    }
    return null;
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      if ((paramEditText.getText() instanceof aofr))
      {
        aofr localaofr = (aofr)paramEditText.getText();
        if (localaofr != null) {
          return localaofr.AE();
        }
      }
      if ((paramEditText != null) && (paramEditText.getEditableText() != null)) {
        return paramEditText.getEditableText().toString();
      }
    }
    return null;
  }
  
  public static String a(EditText paramEditText, List<avzs> paramList)
  {
    if (paramEditText != null)
    {
      paramEditText = a(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return e(paramEditText, paramList).replaceAll(acfp.m(2131707442), acfp.m(2131707444)).replaceAll(acfp.m(2131707443), "/MM");
      }
    }
    return "";
  }
  
  public static void a(String paramString, int paramInt, EditText paramEditText)
  {
    if ((paramEditText == null) || (TextUtils.isEmpty(paramString)) || (paramInt < 0)) {
      return;
    }
    Editable localEditable = aofw.a.newEditable(paramEditText.getText());
    localEditable.insert(paramInt, paramString);
    try
    {
      paramEditText.setText(localEditable);
      paramEditText.setSelection(paramString.length() + paramInt);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        localEditable.append(" ");
        paramEditText.setText(localEditable);
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    return (paramInt1 != -1) && (paramInt2 != -1) && (paramString != null) && (paramString.length() > 0);
  }
  
  public static boolean a(String paramString1, boolean paramBoolean, List<avzs> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (((a(paramInt1, paramInt2, paramString2)) || (!paramBoolean)) && (paramList != null))
    {
      paramInt2 = paramList.size();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString2 = (avzs)paramList.get(paramInt1);
        if ((paramString2 != null) && (paramString2.mName != null) && (paramString1 != null) && ((paramString1.equalsIgnoreCase("@" + paramString2.mName)) || (paramString1.equalsIgnoreCase("@" + paramString2.mName + " "))))
        {
          if (paramBoolean) {
            paramList.remove(paramInt1);
          }
          return true;
        }
        paramInt1 += 1;
      }
    }
    return false;
  }
  
  public static String e(String paramString, List<avzs> paramList)
  {
    return f(paramString, paramList);
  }
  
  public static String f(String paramString, List<avzs> paramList)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramList == null);
      str = paramString;
    } while (paramList.size() == 0);
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      str = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      avzs localavzs = (avzs)localIterator.next();
      str = localavzs.mName;
      paramList = str;
      if (str == null) {
        paramList = localavzs.mUin + "";
      }
      paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D");
      paramList = "@{uin:" + localavzs.mUin + ",nick:" + paramList + "}";
      str = "@" + localavzs.mName;
      if ((!TextUtils.isEmpty(localavzs.mName)) && (paramString.contains(str))) {
        paramString = g(str, paramString, paramList);
      }
    }
  }
  
  public static String g(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = Pattern.compile(paramString1, 16).matcher(paramString2).replaceFirst(paramString3);
      return str;
    }
    catch (Exception localException) {}
    return replace(paramString2, paramString1, paramString3);
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2, 0);
    if (i == -1) {
      return paramString1;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.replace(i, paramString2.length() + i, paramString3);
    return paramString1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avzt
 * JD-Core Version:    0.7.0.1
 */