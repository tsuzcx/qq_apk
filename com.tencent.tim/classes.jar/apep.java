import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

public class apep
{
  public ArrayList<apeg> BQ;
  public ArrayList<apeg> BR;
  public ArrayList<apeg> BS;
  public ArrayList<apeg> BT;
  public String coo;
  public String cop;
  public String coq;
  public String cor;
  public String name;
  public String remark;
  public String uin;
  
  public apep(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.uin = paramString1;
    this.name = paramString2;
    this.remark = paramString3;
    this.coo = ChnToSpell.aJ(paramString2, 1).toLowerCase();
    this.cop = ChnToSpell.aJ(paramString2, 2).toLowerCase();
    this.coq = ChnToSpell.aJ(paramString3, 1).toLowerCase();
    this.cor = ChnToSpell.aJ(paramString3, 2).toLowerCase();
    int j;
    int i;
    int k;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.trim();
      j = paramString1.length();
      this.BQ = new ArrayList(j);
      this.BR = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k >= 19968) && (k <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.BQ.add(new apeg(paramContext, paramString2, ChnToSpell.aJ(paramString2, 1).toLowerCase()));
          this.BR.add(new apeg(paramContext, paramString2, ChnToSpell.aJ(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString3.trim();
      j = paramString1.length();
      this.BS = new ArrayList(j);
      this.BT = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k >= 19968) && (k <= 40869))
        {
          paramString2 = paramString1.substring(i, i + 1);
          this.BS.add(new apeg(paramContext, paramString2, ChnToSpell.aJ(paramString2, 1).toLowerCase()));
          this.BT.add(new apeg(paramContext, paramString2, ChnToSpell.aJ(paramString2, 2).toLowerCase()));
        }
        i += 1;
      }
    }
  }
  
  protected static final int a(int paramInt, String paramString, apep paramapep)
  {
    int i = -1;
    if (paramInt == 5) {
      i = paramapep.coq.indexOf(paramString);
    }
    do
    {
      return i;
      if (paramInt == 6) {
        return paramapep.cor.indexOf(paramString);
      }
      if (paramInt == 2) {
        return paramapep.coo.indexOf(paramString);
      }
    } while (paramInt != 3);
    return paramapep.cop.indexOf(paramString);
  }
  
  protected static int a(int paramInt, ArrayList<apeg> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    for (;;)
    {
      apeg localapeg;
      if (i < k)
      {
        localapeg = (apeg)paramArrayList.get(i);
        if (localapeg.dSm + j <= paramInt) {}
      }
      else
      {
        return j;
      }
      j += localapeg.dSm;
      i += 1;
    }
  }
  
  protected static final int a(String paramString, apep paramapep)
  {
    int j = 0;
    int i;
    if ((paramapep.coq != null) && (paramapep.coq.indexOf(paramString) > -1)) {
      i = 5;
    }
    do
    {
      do
      {
        return i;
        if ((paramapep.cor != null) && (paramapep.cor.indexOf(paramString) > -1)) {
          return 6;
        }
        if ((paramapep.coo != null) && (paramapep.coo.indexOf(paramString) > -1)) {
          return 2;
        }
        i = j;
      } while (paramapep.cop == null);
      i = j;
    } while (paramapep.cop.indexOf(paramString) <= -1);
    return 3;
  }
  
  protected static final String a(int paramInt1, int paramInt2, String paramString, apep paramapep)
  {
    String str = null;
    if (paramInt1 == 5) {
      paramapep = paramapep.BS;
    }
    for (;;)
    {
      if (paramapep != null)
      {
        paramInt1 = paramString.length();
        str = a(a(paramInt2, paramapep), b(paramInt1 + paramInt2, paramapep), paramapep);
      }
      return str;
      if (paramInt1 == 6) {
        paramapep = paramapep.BT;
      } else if (paramInt1 == 2) {
        paramapep = paramapep.BQ;
      } else if (paramInt1 == 3) {
        paramapep = paramapep.BR;
      } else {
        paramapep = null;
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, ArrayList<apeg> paramArrayList)
  {
    int m = paramArrayList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = 0;
    int k = 0;
    for (;;)
    {
      apeg localapeg;
      if (i < m)
      {
        localapeg = (apeg)paramArrayList.get(i);
        if (j == paramInt1) {
          k = 1;
        }
        if (j != paramInt2) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
      if (k != 0) {
        localStringBuilder.append(localapeg.cnz);
      }
      j += localapeg.dSm;
      i += 1;
    }
  }
  
  public static final String a(String paramString, apep paramapep)
  {
    int i = a(paramString, paramapep);
    int j = a(i, paramString, paramapep);
    String str = null;
    if (((j == 0) && (i == 5) && (paramString.equalsIgnoreCase(paramapep.coq))) || ((i == 6) && (paramString.equalsIgnoreCase(paramapep.cor)))) {
      str = paramapep.remark;
    }
    do
    {
      return str;
      if (((j == 0) && (i == 2) && (paramString.equalsIgnoreCase(paramapep.coo))) || ((i == 3) && (paramString.equalsIgnoreCase(paramapep.cop)))) {
        return paramapep.name;
      }
    } while (j <= -1);
    return a(i, j, paramString, paramapep);
  }
  
  protected static int b(int paramInt, ArrayList<apeg> paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = ((apeg)paramArrayList.get(i)).dSm + j;
      if (j >= paramInt) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.uin != null) {
      localStringBuilder.append("uin = " + this.uin);
    }
    if (this.name != null) {
      localStringBuilder.append(", name = " + this.name);
    }
    if (this.remark != null) {
      localStringBuilder.append(", remark = " + this.remark);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apep
 * JD-Core Version:    0.7.0.1
 */