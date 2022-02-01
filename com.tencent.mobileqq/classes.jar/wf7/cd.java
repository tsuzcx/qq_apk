package wf7;

import android.text.TextUtils;
import java.util.ArrayList;

public class cd
{
  public ArrayList<String> gT = null;
  protected int gU = 0;
  private int gV = -1;
  protected boolean gW = false;
  
  public cd(int paramInt, ArrayList<String> paramArrayList)
  {
    this.gT = paramArrayList;
    paramArrayList = this.gT;
    if (paramArrayList != null)
    {
      this.gU = paramArrayList.size();
      this.gW = true;
    }
    this.gV = paramInt;
  }
  
  private void a(String paramString, int paramInt, Exception paramException)
  {
    ar localar = bz.av().A().z();
    Thread localThread = new Thread();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd:");
    localStringBuilder.append(this.gV);
    localStringBuilder.append(" func:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" pos:");
    localStringBuilder.append(paramInt);
    localar.a(localThread, paramException, localStringBuilder.toString(), null);
  }
  
  private String getValue(int paramInt)
  {
    int i = this.gU;
    if ((i > 0) && (i - 1 >= paramInt)) {
      return (String)this.gT.get(paramInt);
    }
    return null;
  }
  
  public String[] a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        String str = getValue(paramInt);
        if (!TextUtils.isEmpty(str)) {
          paramString1 = str.split(paramString2);
        } else if (!TextUtils.isEmpty(paramString1)) {
          paramString1 = paramString1.split(paramString2);
        }
      }
    }
    catch (Exception paramString1)
    {
      a("readArray", paramInt, paramString1);
    }
    return null;
    return paramString1;
  }
  
  public boolean aJ()
  {
    return this.gW;
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    String str = getValue(paramInt);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        boolean bool = cb.G(Integer.valueOf(str).intValue());
        return bool;
      }
      catch (Exception localException)
      {
        a("readBool", paramInt, localException);
      }
    }
    return paramBoolean;
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    String str = getValue(paramInt1);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        int i = Integer.valueOf(str).intValue();
        return i;
      }
      catch (Exception localException)
      {
        a("readInt", paramInt1, localException);
      }
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cd
 * JD-Core Version:    0.7.0.1
 */