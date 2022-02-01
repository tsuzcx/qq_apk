import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.GetChars;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class aofe
  implements GetChars, Spannable, CharSequence, Cloneable
{
  private ArrayList<Object> at = new ArrayList();
  private int dOo;
  public String mSource;
  private String mText;
  private ArrayList<aofe.a> qQ = new ArrayList();
  
  public aofe(CharSequence paramCharSequence, int paramInt)
  {
    this.dOo = paramInt;
    if (paramCharSequence == null)
    {
      this.mText = "";
      this.mSource = "";
    }
    for (;;)
    {
      return;
      this.mSource = paramCharSequence.toString();
      this.mText = this.mSource;
      paramInt = (int)(paramInt * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      Object localObject = new StringBuilder(paramCharSequence);
      a(0, ((StringBuilder)localObject).length(), paramInt, (StringBuilder)localObject);
      this.mText = ((StringBuilder)localObject).toString();
      if (!aofk.cLs) {
        this.mSource = this.mText;
      }
      if ((paramCharSequence instanceof Spanned))
      {
        localObject = (Spanned)paramCharSequence;
        int k = paramCharSequence.length();
        paramCharSequence = ((Spanned)localObject).getSpans(0, paramCharSequence.length(), Object.class);
        paramInt = 0;
        while (paramInt < paramCharSequence.length)
        {
          int j = ((Spanned)localObject).getSpanStart(paramCharSequence[paramInt]);
          int m = ((Spanned)localObject).getSpanEnd(paramCharSequence[paramInt]);
          int n = ((Spanned)localObject).getSpanFlags(paramCharSequence[paramInt]);
          int i = j;
          if (j < 0) {
            i = 0;
          }
          j = m;
          if (m > k) {
            j = k;
          }
          setSpan(paramCharSequence[paramInt], i - 0, j - 0, n);
          paramInt += 1;
        }
      }
    }
  }
  
  private static String S(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    int k = paramStringBuilder.length();
    while (paramInt1 < paramInt2)
    {
      if ((paramStringBuilder.charAt(paramInt1) == '<') && (paramInt1 < k - 2))
      {
        int i2 = paramStringBuilder.charAt(paramInt1 + 1);
        int j;
        int i;
        if ((i2 == 36) && (paramInt1 < k - 3))
        {
          j = paramStringBuilder.charAt(paramInt1 + 2);
          if (aofk.cLs) {
            paramStringBuilder.replace(paramInt1 + 1, paramInt1 + 3, "##");
          }
          for (;;)
          {
            if ((j == 255) || (j == 511) || (j == 250)) {
              break label203;
            }
            if (paramStringBuilder.charAt(paramInt1 + 3) != '>') {
              break label651;
            }
            j = afky.hm(j);
            i = j;
            if (j == 250) {
              i = 10;
            }
            if (!afky.jr(i)) {
              break label651;
            }
            b(new aofk.a(i, paramInt3, 1), paramInt1, paramInt1 + 4, 33);
            paramInt1 += 4;
            break;
            if (j == 10) {
              paramStringBuilder.setCharAt(paramInt1 + 2, 'ú');
            }
          }
          label203:
          if ((j >= 255) && (paramInt1 + 6 < k))
          {
            if (paramStringBuilder.charAt(paramInt1 + 6) == '>')
            {
              char[] arrayOfChar = new char[3];
              arrayOfChar[0] = paramStringBuilder.charAt(paramInt1 + 3);
              arrayOfChar[1] = paramStringBuilder.charAt(paramInt1 + 4);
              arrayOfChar[2] = ((char)(paramStringBuilder.charAt(paramInt1 + 5) & 0xFF));
              i = 0;
              if (i < 3)
              {
                if (arrayOfChar[i] == 'ú') {
                  arrayOfChar[i] = '\n';
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (arrayOfChar[i] == 'þ') {
                    arrayOfChar[i] = '\r';
                  }
                }
              }
              boolean bool;
              if (j == 511)
              {
                bool = true;
                b(new aofk.c(arrayOfChar, paramInt3, true, bool), paramInt1, paramInt1 + 7, 33);
                i = 2;
                label375:
                if (i >= 5) {
                  break label451;
                }
                if (paramStringBuilder.charAt(paramInt1 + i) != '\n') {
                  break label422;
                }
                paramStringBuilder.setCharAt(paramInt1 + i, 'ú');
              }
              for (;;)
              {
                i += 1;
                break label375;
                bool = false;
                break;
                if (paramStringBuilder.charAt(paramInt1 + i) == '\r') {
                  paramStringBuilder.setCharAt(paramInt1 + i, 'þ');
                }
              }
              paramInt1 += 7;
            }
          }
          else if (j == 250)
          {
            if (aofk.cLs) {
              paramStringBuilder.replace(paramInt1 + 1, paramInt1 + 3, "##");
            }
            b(new aofk.a(10, paramInt3, 1), paramInt1, paramInt1 + 4, 33);
            paramInt1 += 4;
          }
        }
        else
        {
          label422:
          label451:
          if (((i2 == 37) || (i2 == 38)) && (paramInt1 < k - 6))
          {
            j = paramStringBuilder.charAt(paramInt1 + 2);
            int m = paramStringBuilder.charAt(paramInt1 + 3);
            int n = paramStringBuilder.charAt(paramInt1 + 4);
            int i1 = paramStringBuilder.charAt(paramInt1 + 5);
            i = 3;
            if (i2 == 38) {
              i = 2;
            }
            b(new aqqa(i, (i1 & 0xFF) + ((j << 24) + 0 + (m << 16 & 0xFF0000) + (n << 8 & 0xFF00))), paramInt1, paramInt1 + 7, 33);
            paramInt1 += 7;
            continue;
          }
        }
      }
      label651:
      paramInt1 += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  private void aH(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " has end before start");
    }
    int i = length();
    if ((paramInt1 > i) || (paramInt2 > i)) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " ends beyond length " + i);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    this.at.add(paramObject);
    paramObject = new aofe.a(paramInt1, paramInt2, paramInt3);
    this.qQ.add(paramObject);
  }
  
  public char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.mText.charAt(paramInt);
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    this.mText.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i = this.at.indexOf(paramObject);
    if (this.qQ.size() < i) {}
    while (i < 0) {
      return -1;
    }
    return ((aofe.a)this.qQ.get(i)).end;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.at.indexOf(paramObject);
    if (this.qQ.size() < i) {}
    while (i < 0) {
      return 0;
    }
    return ((aofe.a)this.qQ.get(i)).flag;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.at.indexOf(paramObject);
    if (this.qQ.size() < i) {}
    while (i < 0) {
      return -1;
    }
    return ((aofe.a)this.qQ.get(i)).start;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.at.size())
    {
      Object localObject = this.at.get(i);
      if (paramClass.isInstance(localObject))
      {
        aofe.a locala = (aofe.a)this.qQ.get(i);
        if ((locala.start >= paramInt1) && (locala.end <= paramInt2)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, localArrayList.size());
    paramInt1 = j;
    while (paramInt1 < localArrayList.size())
    {
      paramClass[paramInt1] = localArrayList.get(paramInt1);
      paramInt1 += 1;
    }
    return paramClass;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public SpannableString k()
  {
    SpannableString localSpannableString = new SpannableString(this.mText);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public int length()
  {
    return this.mText.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int k = 0;
    while (k < this.at.size())
    {
      paramClass = this.at.get(k);
      aofe.a locala = (aofe.a)this.qQ.get(k);
      int i = paramInt2;
      if (((Class)localObject).isInstance(paramClass))
      {
        int j = paramInt2;
        if (locala.start > paramInt1)
        {
          j = paramInt2;
          if (locala.start < paramInt2) {
            j = locala.start;
          }
        }
        i = j;
        if (locala.end > paramInt1)
        {
          i = j;
          if (locala.end < j) {
            i = locala.end;
          }
        }
      }
      k += 1;
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public void removeSpan(Object paramObject)
  {
    int i = this.at.indexOf(paramObject);
    if (i >= 0)
    {
      this.at.remove(i);
      aofe.a locala = (aofe.a)this.qQ.remove(i);
      b(paramObject, locala.start, locala.end);
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    aH("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c = charAt(paramInt1 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c + ")");
        }
      }
    }
    int i = this.at.indexOf(paramObject);
    aofe.a locala;
    if ((i > 0) && (this.qQ.size() > i))
    {
      locala = (aofe.a)this.qQ.get(i);
      int j = locala.start;
      int k = locala.end;
      locala.start = paramInt1;
      locala.end = paramInt2;
      locala.flag = paramInt3;
      a(paramObject, j, k, paramInt1, paramInt2);
    }
    if (i < 0)
    {
      this.at.add(paramObject);
      locala = new aofe.a(paramInt1, paramInt2, paramInt3);
      this.qQ.add(locala);
      a(paramObject, paramInt1, paramInt2);
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (i == 0) && (paramInt1 == length())) {
      return this;
    }
    return this.mText.substring(i, paramInt1);
  }
  
  public static class a
  {
    public int end;
    public int flag;
    public int start;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.flag = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofe
 * JD-Core Version:    0.7.0.1
 */