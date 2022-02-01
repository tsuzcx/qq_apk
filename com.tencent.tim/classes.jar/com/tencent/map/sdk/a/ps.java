package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.io.QStorageManager;

public final class ps
  implements md
{
  private Context a;
  private final QStorageManager b;
  private String c;
  
  public ps(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      this.b = QStorageManager.getInstance(this.a);
      this.c = paramString;
      return;
    }
    this.b = null;
  }
  
  public final String a()
  {
    if (this.b != null) {
      return this.b.getMapPath();
    }
    return null;
  }
  
  public final String b()
  {
    if (this.b != null) {
      return this.b.getSatPath();
    }
    return null;
  }
  
  public final String c()
  {
    if (this.b != null) {
      return this.b.getConfigPath(this.c);
    }
    return null;
  }
  
  public final String d()
  {
    if (this.b != null) {
      return this.b.getAssetsLoadPath(this.c);
    }
    return null;
  }
  
  public final String e()
  {
    if (this.b != null) {
      return this.b.getRouteBlockPath();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ps
 * JD-Core Version:    0.7.0.1
 */