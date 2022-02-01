package com.tencent.android.tpush.a;

import android.content.pm.ProviderInfo;
import java.util.ArrayList;

public class b
{
  private String a;
  private ProviderInfo b;
  private ArrayList<ProviderInfo> c;
  
  public ArrayList<ProviderInfo> a()
  {
    return this.c;
  }
  
  public void a(ProviderInfo paramProviderInfo)
  {
    this.b = paramProviderInfo;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(ProviderInfo paramProviderInfo)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.c.add(paramProviderInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.a.b
 * JD-Core Version:    0.7.0.1
 */