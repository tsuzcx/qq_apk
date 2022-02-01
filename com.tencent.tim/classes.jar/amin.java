import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.Spannable;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class amin
{
  private static long aiJ;
  
  public static String K(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://ti.qq.com/signature/focustopic?_wv=3&&_wwv=129");
    localStringBuilder.append('&');
    localStringBuilder.append("topic_id=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&");
    localStringBuilder.append("topic_name=");
    try
    {
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      if (QLog.isColorLevel()) {
        QLog.i("TopicUtil", 2, String.format("constructTopicDetailUrl[%d,%s]", new Object[] { Integer.valueOf(paramInt), paramString }));
      }
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public static String L(List<Pair<Integer, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append("index = ").append(i).append(",");
      localStringBuilder.append("id = ").append(((Pair)paramList.get(i)).first).append(",");
      localStringBuilder.append("topic = ").append((String)((Pair)paramList.get(i)).second).append(",");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int a(Editable paramEditable, int paramInt)
  {
    if ((paramEditable.length() < 0) || (paramInt < 2) || (paramInt > paramEditable.length())) {}
    for (;;)
    {
      return -1;
      paramInt -= 1;
      while ((paramInt >= 0) && (a(paramEditable, paramInt) == null) && (paramEditable.charAt(paramInt) != ' '))
      {
        if (paramEditable.charAt(paramInt) == '#') {
          return paramInt;
        }
        paramInt -= 1;
      }
    }
  }
  
  public static amii a(Spannable paramSpannable, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramSpannable.length())) {
      return null;
    }
    amii[] arrayOfamii = (amii[])paramSpannable.getSpans(paramInt, paramInt, amii.class);
    int i = 0;
    while (i < arrayOfamii.length)
    {
      int j = paramSpannable.getSpanStart(arrayOfamii[i]);
      int k = paramSpannable.getSpanEnd(arrayOfamii[i]);
      if ((paramInt >= j) && (paramInt < k)) {
        return arrayOfamii[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static String a(Editable paramEditable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramEditable.length())
    {
      if (a(paramEditable, i) != null) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramEditable.subSequence(i, i + 1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicUtil", 2, String.format("getPlainText [edit=%s len=%d %s]", new Object[] { paramEditable, Integer.valueOf(paramEditable.length()), localStringBuilder.toString() }));
    }
    return localStringBuilder.toString();
  }
  
  public static List<Pair<Integer, String>> a(Editable paramEditable)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    int i = 0;
    if (i < paramEditable.length())
    {
      Object localObject2 = (amii[])paramEditable.getSpans(i, i, amii.class);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label122;
      }
      localObject2 = localObject2[0];
      if (localObject2 == localObject1) {
        break label122;
      }
      localObject1 = ((amii)localObject2).getData();
      if ((localObject1 instanceof Pair)) {
        localArrayList.add((Pair)localObject1);
      }
      localObject1 = localObject2;
    }
    label122:
    for (;;)
    {
      i += 1;
      break;
      if (QLog.isDevelopLevel()) {
        QLog.i("TopicUtil", 2, String.format("getTopics %s", new Object[] { L(localArrayList) }));
      }
      return localArrayList;
    }
  }
  
  public static void a(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) || (paramInt2 < 0) || (paramInt3 <= 0) || (paramInt3 < -paramInt1) || (paramInt2 + paramInt3 > paramEditable.length())) {}
    int j;
    do
    {
      return;
      paramInt1 = -paramInt1;
      int i = 0;
      j = paramInt2 + paramInt3 - paramInt1;
      paramInt1 = i;
      if (Character.isLowSurrogate(paramEditable.toString().charAt(j)))
      {
        paramInt1 = i;
        if (j > 0)
        {
          paramInt1 = i;
          if (j - 1 < paramEditable.length() - 1) {
            paramInt1 = 1;
          }
        }
      }
      paramEditable.delete(j, paramInt2 + paramInt3);
    } while (paramInt1 == 0);
    paramEditable.delete(j - 1, j);
  }
  
  public static void a(ETTextView paramETTextView, CharSequence paramCharSequence, int paramInt)
  {
    boolean bool;
    if ((paramETTextView.mFont != null) && (paramETTextView.mFont.getId() != 0) && (9999 != paramETTextView.mFont.getId()))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("TopicUtil", 2, String.format("topicSpanCompactETTextView isCustom=%b from=%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      if (paramCharSequence != null) {
        break label140;
      }
    }
    label140:
    for (paramETTextView = paramETTextView.getText();; paramETTextView = paramCharSequence)
    {
      if ((paramETTextView == null) || (!(paramETTextView instanceof Spannable))) {
        return;
      }
      paramETTextView = (Spannable)paramETTextView;
      paramETTextView = (amii[])paramETTextView.getSpans(0, paramETTextView.length(), amii.class);
      paramInt = 0;
      while (paramInt < paramETTextView.length)
      {
        paramETTextView[0].Pk(bool);
        paramInt += 1;
      }
      bool = false;
      break;
    }
  }
  
  public static ColorStateList b(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 0 } }, new int[] { paramInt2, paramInt1 });
  }
  
  public static List<Pair<Integer, Integer>> b(Editable paramEditable)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2 = null;
    amii[] arrayOfamii;
    int j;
    Object localObject1;
    if (i < paramEditable.length())
    {
      arrayOfamii = (amii[])paramEditable.getSpans(i, i, amii.class);
      if ((arrayOfamii == null) || (arrayOfamii.length <= 0)) {
        break label184;
      }
      if (arrayOfamii.length > 1)
      {
        int k = arrayOfamii.length;
        j = 0;
        localObject1 = null;
        label66:
        if (j < k)
        {
          amii localamii = arrayOfamii[j];
          if (localamii == localObject2) {
            break label194;
          }
          localObject1 = localamii;
        }
      }
    }
    label184:
    label194:
    for (;;)
    {
      j += 1;
      break label66;
      if (localObject1 == null) {
        localObject1 = arrayOfamii[(arrayOfamii.length - 1)];
      }
      for (;;)
      {
        label110:
        if (localObject1 != localObject2)
        {
          localObject2 = ((amii)localObject1).getData();
          if ((localObject2 instanceof Pair)) {
            localArrayList.add(new Pair(((Pair)localObject2).first, Integer.valueOf(i)));
          }
        }
        for (;;)
        {
          i += 1;
          localObject2 = localObject1;
          break;
          localObject1 = arrayOfamii[0];
          break label110;
          return localArrayList;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static boolean oE(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() < 3) {
      return false;
    }
    return true;
  }
  
  public static void u(Context paramContext, String paramString, int paramInt)
  {
    if (System.currentTimeMillis() - aiJ < 500L) {
      return;
    }
    aiJ = System.currentTimeMillis();
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amin
 * JD-Core Version:    0.7.0.1
 */