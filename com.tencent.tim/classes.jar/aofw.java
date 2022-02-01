import android.text.Editable.Factory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Comparator;

public class aofw
  extends aofr
{
  public static Editable.Factory a = new aofx();
  
  public aofw(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public aofw(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public String AE()
  {
    int i = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    aofk.a[] arrayOfa = (aofk.a[])getSpans(0, m, aofk.a.class);
    Arrays.sort(arrayOfa, new aofw.a());
    int n = arrayOfa.length;
    int j = 0;
    Object localObject;
    int i1;
    int k;
    if (i < n)
    {
      localObject = arrayOfa[i];
      i1 = getSpanStart(localObject);
      k = getSpanEnd(localObject);
      if ((localObject != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (j < m) {
        localStringBuilder.append(arrayOfChar, j, m - j);
      }
      return localStringBuilder.toString();
    }
    if (i1 > j) {
      localStringBuilder.append(arrayOfChar, j, i1 - j);
    }
    switch (((aofk.a)localObject).emojiType)
    {
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      j = afku.hi(((aofk.a)localObject).index);
      if (j != -1)
      {
        localStringBuilder.append(String.valueOf(Character.toChars(j)));
      }
      else
      {
        QLog.e("QzoneTextBuilder", 1, "不支持的表情");
        continue;
        localStringBuilder.append(((aofk.a)localObject).getDescription());
        continue;
        localObject = afky.ea(0x7FFFFFFF & ((aofk.a)localObject).index);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject);
        } else {
          QLog.e("QzoneTextBuilder", 1, "不支持的表情");
        }
      }
    }
  }
  
  class a
    implements Comparator
  {
    a() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      int i = aofw.this.getSpanStart(paramObject1);
      int j = aofw.this.getSpanStart(paramObject2);
      if (i == j) {
        return 0;
      }
      if (i > j) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofw
 * JD-Core Version:    0.7.0.1
 */