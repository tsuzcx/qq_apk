package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean
  implements Serializable
{
  private boolean a;
  private String b;
  private int c;
  private String d;
  private String e;
  private ArrayList f;
  private boolean g = true;
  
  private static <T> T a(T paramT)
  {
    return paramT;
  }
  
  boolean a()
  {
    return ((Boolean)a(Boolean.valueOf(this.a))).booleanValue();
  }
  
  String b()
  {
    return (String)a(this.b);
  }
  
  int c()
  {
    return ((Integer)a(Integer.valueOf(this.c))).intValue();
  }
  
  String d()
  {
    return (String)a(this.d);
  }
  
  public String getClientAppName()
  {
    return (String)a(this.e);
  }
  
  public ArrayList getTypeList()
  {
    return (ArrayList)a(this.f);
  }
  
  public boolean isNeedConfirm()
  {
    return ((Boolean)a(Boolean.valueOf(this.g))).booleanValue();
  }
  
  public void setClientAppId(String paramString)
  {
    this.d = paramString;
  }
  
  public void setClientAppName(String paramString)
  {
    this.e = paramString;
  }
  
  public void setClientPackageName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setClientVersionCode(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setHmsOrApkUpgrade(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setNeedConfirm(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setTypeList(ArrayList paramArrayList)
  {
    this.f = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.UpdateBean
 * JD-Core Version:    0.7.0.1
 */