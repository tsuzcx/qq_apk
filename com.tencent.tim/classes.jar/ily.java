import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ily
{
  public static int aoW;
  
  public static aofk a(String paramString, int paramInt)
  {
    return new aofk(jdMethod_do(paramString), 3, paramInt);
  }
  
  public static String a(aofr paramaofr)
  {
    int j = 0;
    if (paramaofr == null) {
      return null;
    }
    int i = paramaofr.length();
    Object localObject1 = new char[i];
    paramaofr.getChars(0, i, (char[])localObject1, 0);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject2 = (aofk.a[])paramaofr.getSpans(0, i, aofk.a.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((char[])localObject1);
      localObject1 = new ArrayList(localObject2.length);
      i = 0;
      Object localObject3;
      if (i < localObject2.length)
      {
        localObject3 = localObject2[i];
        if (localObject3 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ((ArrayList)localObject1).add(ilz.a((aofk.a)localObject3, paramaofr.getSpanStart(localObject3), paramaofr.getSpanEnd(localObject3)));
        }
      }
      Collections.sort((List)localObject1, ilz.comparator);
      localObject2 = ((ArrayList)localObject1).iterator();
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        paramaofr = (ilz)((Iterator)localObject2).next();
        localObject3 = paramaofr.a;
        int k = paramaofr.start;
        j = paramaofr.end;
        switch (((aofk.a)localObject3).emojiType)
        {
        default: 
          paramaofr = localStringBuilder2.substring(k, j);
        }
        for (;;)
        {
          if (i < k) {
            localStringBuilder1.append(localStringBuilder2.substring(i, k));
          }
          localStringBuilder1.append(paramaofr);
          i = j;
          break;
          paramaofr = '\024' + ((aofk.a)localObject3).getDescription();
          continue;
          paramaofr = aK(((aofk.a)localObject3).index & 0x7FFFFFFF);
        }
      }
      if (i < localStringBuilder2.length()) {
        localStringBuilder1.append(localStringBuilder2.substring(i));
      }
      ilz.bz((List)localObject1);
    }
    for (;;)
    {
      return localStringBuilder1.toString();
      localStringBuilder1.append((char[])localObject1);
    }
  }
  
  public static String aK(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (paramInt >= 0)
    {
      str1 = str2;
      if (paramInt < aoff.hj.length) {
        str1 = '\024' + aoff.hj[paramInt];
      }
    }
    return str1;
  }
  
  public static String jdMethod_do(String paramString)
  {
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (paramString.indexOf("/") == -1);
    int i = 0;
    for (Object localObject1 = paramString;; localObject1 = paramString)
    {
      paramString = (String)localObject1;
      int j = k;
      Object localObject2 = localObject1;
      try
      {
        String str;
        if (i < aoff.hj.length)
        {
          localObject2 = localObject1;
          str = '\024' + aoff.hj[i];
          localObject2 = localObject1;
          paramString = (String)localObject1;
          if (((String)localObject1).indexOf(str) != -1)
          {
            localObject2 = localObject1;
            paramString = ((String)localObject1).replace(str, aofy.fx(i));
          }
        }
        else
        {
          for (;;)
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (j >= aoff.hj.length) {
              break;
            }
            localObject2 = paramString;
            str = aoff.hj[j];
            localObject1 = paramString;
            localObject2 = paramString;
            if (paramString.indexOf(str) != -1)
            {
              localObject2 = paramString;
              localObject1 = paramString.replace(str, aofy.fx(j));
            }
            j += 1;
            paramString = (String)localObject1;
          }
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("ChatRoomUtil", 2, "convertMsg exception", paramString);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
  
  public static void report(String paramString)
  {
    int i = igv.a().a().amI;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("doReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(i) }));
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ily
 * JD-Core Version:    0.7.0.1
 */