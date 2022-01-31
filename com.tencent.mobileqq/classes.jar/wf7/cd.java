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
    if (this.gT != null)
    {
      this.gU = this.gT.size();
      this.gW = true;
    }
    this.gV = paramInt;
  }
  
  private void a(String paramString, int paramInt, Exception paramException)
  {
    bz.av().A().z().a(new Thread(), paramException, "cmd:" + this.gV + " func:" + paramString + " pos:" + paramInt, null);
  }
  
  private String getValue(int paramInt)
  {
    if ((this.gU > 0) && (this.gU - 1 >= paramInt)) {
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
          return str.split(paramString2);
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = paramString1.split(paramString2);
          return paramString1;
        }
      }
    }
    catch (Exception paramString1)
    {
      a("readArray", paramInt, paramString1);
    }
    return null;
  }
  
  public boolean aJ()
  {
    return this.gW;
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    String str = getValue(paramInt);
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      bool = cb.G(Integer.valueOf(str).intValue());
      return bool;
    }
    catch (Exception localException)
    {
      a("readBool", paramInt, localException);
    }
    return paramBoolean;
  }
  
  public int e(int paramInt1, int paramInt2)
  {
    String str = getValue(paramInt1);
    int i = paramInt2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (Exception localException)
    {
      a("readInt", paramInt1, localException);
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cd
 * JD-Core Version:    0.7.0.1
 */