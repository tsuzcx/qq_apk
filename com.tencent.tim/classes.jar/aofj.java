import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aofj
{
  static class a
    extends aofj.g
  {
    a(@NonNull String paramString)
    {
      super(paramString);
    }
    
    float getWidth(@NonNull Paint paramPaint)
    {
      return paramPaint.measureText(getSource());
    }
  }
  
  public static class b
  {
    private List<aofj.g> GZ;
    private String mSource;
    
    private b()
    {
      this.mSource = "";
      this.GZ = new ArrayList();
    }
    
    public b(String paramString, int paramInt)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.mSource = str;
      this.GZ = new ArrayList();
      d(new StringBuilder(this.mSource), paramInt);
    }
    
    private b a(aofj.g paramg)
    {
      if (paramg != null) {
        this.GZ.add(paramg);
      }
      this.mSource = AD();
      return this;
    }
    
    private void d(StringBuilder paramStringBuilder, int paramInt)
    {
      int k = this.mSource.length();
      int m = this.mSource.length();
      int n = (int)(paramInt * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      paramInt = 0;
      while (paramInt < m)
      {
        if ((paramStringBuilder.charAt(paramInt) == '<') && (paramInt < k - 2))
        {
          int i = paramStringBuilder.charAt(paramInt + 1);
          if ((i == 36) && (paramInt < k - 3))
          {
            int j = paramStringBuilder.charAt(paramInt + 2);
            if (aofk.cLs) {
              paramStringBuilder.replace(paramInt + 1, paramInt + 3, "##");
            }
            for (;;)
            {
              if (j >= afky.De()) {
                break label213;
              }
              if (paramStringBuilder.charAt(paramInt + 3) != '>') {
                break label635;
              }
              j = afky.hm(j);
              i = j;
              if (j == 250) {
                i = 10;
              }
              if (i >= aoff.dOp) {
                break label635;
              }
              a(new aofj.e(paramStringBuilder.substring(paramInt, paramInt + 4), i, n));
              paramInt += 4;
              break;
              if (j == 10) {
                paramStringBuilder.setCharAt(paramInt + 2, 'ú');
              }
            }
            label213:
            if ((j >= 255) && (paramInt + 6 < k))
            {
              if (paramStringBuilder.charAt(paramInt + 6) == '>')
              {
                char[] arrayOfChar = new char[3];
                arrayOfChar[0] = paramStringBuilder.charAt(paramInt + 3);
                arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 4);
                arrayOfChar[2] = ((char)(paramStringBuilder.charAt(paramInt + 5) & 0xFF));
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
                a(new aofj.f(paramStringBuilder.substring(paramInt, paramInt + 7), j, n));
                i = 2;
                if (i < 5)
                {
                  if (paramStringBuilder.charAt(paramInt + i) == '\n') {
                    paramStringBuilder.setCharAt(paramInt + i, 'ú');
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    if (paramStringBuilder.charAt(paramInt + i) == '\r') {
                      paramStringBuilder.setCharAt(paramInt + i, 'þ');
                    }
                  }
                }
                paramInt += 7;
              }
            }
            else if (j == 250)
            {
              if (aofk.cLs) {
                paramStringBuilder.replace(paramInt + 1, paramInt + 3, "##");
              }
              a(new aofj.e(paramStringBuilder.substring(paramInt, paramInt + 4), 10, n));
              paramInt += 4;
            }
          }
          else if (((i == 37) || (i == 38)) && (paramInt < k - 6))
          {
            a(new aofj.d(paramStringBuilder.substring(paramInt, paramInt + 7)));
            paramInt += 7;
          }
        }
        else
        {
          if ((Character.isHighSurrogate(paramStringBuilder.charAt(paramInt))) && (paramInt <= k - 2) && (Character.isSurrogatePair(paramStringBuilder.charAt(paramInt), paramStringBuilder.charAt(paramInt + 1))) && (lN(paramStringBuilder.toString().codePointAt(paramInt))))
          {
            a(new aofj.a(paramStringBuilder.substring(paramInt, paramInt + 2)));
            paramInt += 2;
            continue;
          }
          a(new aofj.c(String.valueOf(paramStringBuilder.charAt(paramInt))));
        }
        label635:
        paramInt += 1;
      }
    }
    
    private static boolean lN(int paramInt)
    {
      return ((paramInt >= 9728) && (paramInt <= 10175)) || (paramInt == 12349) || (paramInt == 8265) || (paramInt == 8252) || ((paramInt >= 8192) && (paramInt <= 8207)) || ((paramInt >= 8232) && (paramInt <= 8239)) || (paramInt == 8287) || ((paramInt >= 8293) && (paramInt <= 8303)) || ((paramInt >= 8448) && (paramInt <= 8527)) || ((paramInt >= 8960) && (paramInt <= 9215)) || ((paramInt >= 11008) && (paramInt <= 11263)) || ((paramInt >= 10496) && (paramInt <= 10623)) || ((paramInt >= 12800) && (paramInt <= 13055)) || ((paramInt >= 55296) && (paramInt <= 57343)) || ((paramInt >= 57344) && (paramInt <= 63743)) || ((paramInt >= 65024) && (paramInt <= 65039)) || (paramInt >= 65536);
    }
    
    public String AC()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.GZ.iterator();
      while (localIterator.hasNext())
      {
        aofj.g localg = (aofj.g)localIterator.next();
        if ((localg.getType() == 0) || (localg.getType() == 1)) {
          localStringBuilder.append(localg.getSource());
        }
      }
      return localStringBuilder.toString();
    }
    
    public String AD()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.GZ.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((aofj.g)localIterator.next()).getSource());
      }
      return localStringBuilder.toString();
    }
    
    public float a(Paint paramPaint)
    {
      float f = 0.0F;
      int i = 0;
      while (i < length())
      {
        f += a(i).getWidth(paramPaint);
        i += 1;
      }
      return f;
    }
    
    public b a(int paramInt)
    {
      b localb = new b();
      Iterator localIterator = this.GZ.iterator();
      while (localIterator.hasNext())
      {
        aofj.g localg = (aofj.g)localIterator.next();
        if (localg.getType() == paramInt) {
          localb.a(localg);
        }
      }
      return localb;
    }
    
    @NonNull
    public aofj.g a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.GZ.size())) {
        return (aofj.g)this.GZ.get(paramInt);
      }
      throw new IndexOutOfBoundsException("NickString index error");
    }
    
    public b b(int paramInt)
    {
      b localb = new b();
      Iterator localIterator = this.GZ.iterator();
      while (localIterator.hasNext())
      {
        aofj.g localg = (aofj.g)localIterator.next();
        if (localg.getType() != paramInt) {
          localb.a(localg);
        }
      }
      return localb;
    }
    
    public int length()
    {
      return this.GZ.size();
    }
    
    public String toString()
    {
      return AC();
    }
  }
  
  static class c
    extends aofj.g
  {
    c(@NonNull String paramString)
    {
      super(paramString);
    }
    
    float getWidth(@NonNull Paint paramPaint)
    {
      return paramPaint.measureText(getSource());
    }
  }
  
  static class d
    extends aofj.g
  {
    d(String paramString)
    {
      super(paramString);
    }
    
    float getWidth(@NonNull Paint paramPaint)
    {
      return 0.0F;
    }
  }
  
  static class e
    extends aofj.g
  {
    private aofk.a b;
    
    e(@NonNull String paramString, int paramInt1, int paramInt2)
    {
      super(paramString);
      this.b = new aofk.a(paramInt1, paramInt2, 1);
    }
    
    float getWidth(@NonNull Paint paramPaint)
    {
      float f = this.b.getDrawable().getBounds().width();
      if (QLog.isColorLevel()) {
        QLog.d("NickWrapper", 2, "getWidth normal span width " + f);
      }
      return f;
    }
  }
  
  static class f
    extends aofj.g
  {
    private aofk.c a;
    
    f(@NonNull String paramString, int paramInt1, int paramInt2)
    {
      super(paramString);
      if (paramString.length() >= 6)
      {
        char[] arrayOfChar = new char[3];
        arrayOfChar[0] = paramString.charAt(3);
        arrayOfChar[1] = paramString.charAt(4);
        arrayOfChar[2] = ((char)(paramString.charAt(5) & 0xFF));
        int i = 0;
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
        if (paramInt1 == 511) {
          bool = true;
        }
        this.a = new aofk.c(arrayOfChar, paramInt2, true, bool);
      }
    }
    
    float getWidth(@NonNull Paint paramPaint)
    {
      if (this.a != null)
      {
        paramPaint = this.a.getDrawable();
        if (paramPaint != null)
        {
          float f = paramPaint.getBounds().width();
          if (QLog.isColorLevel()) {
            QLog.d("NickWrapper", 2, "getWidth small span width " + f);
          }
          return f;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NickWrapper", 2, "getWidth with error drawable");
      }
      return 0.0F;
    }
  }
  
  public static abstract class g
  {
    private String mSource;
    private int mType;
    
    public g(int paramInt, @NonNull String paramString)
    {
      this.mType = paramInt;
      this.mSource = paramString;
    }
    
    String getSource()
    {
      return this.mSource;
    }
    
    int getType()
    {
      return this.mType;
    }
    
    abstract float getWidth(@NonNull Paint paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */