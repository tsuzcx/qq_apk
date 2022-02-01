package com.tencent.token;

import android.os.Bundle;

public final class pb
  implements pa.b
{
  public String a;
  public String b;
  public String c;
  public boolean d;
  public int e = 0;
  public int f = 0;
  
  public final int a()
  {
    return 36;
  }
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putString("_wxminiprogram_webpageurl", this.a);
    paramBundle.putString("_wxminiprogram_username", this.b);
    paramBundle.putString("_wxminiprogram_path", this.c);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.d);
    paramBundle.putInt("_wxminiprogram_type", this.e);
    paramBundle.putInt("_wxminiprogram_disableforward", this.f);
  }
  
  public final void b(Bundle paramBundle)
  {
    this.a = paramBundle.getString("_wxminiprogram_webpageurl");
    this.b = paramBundle.getString("_wxminiprogram_username");
    this.c = paramBundle.getString("_wxminiprogram_path");
    this.d = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.e = paramBundle.getInt("_wxminiprogram_type");
    this.f = paramBundle.getInt("_wxminiprogram_disableforward");
  }
  
  public final boolean b()
  {
    if (pn.a(this.a)) {
      return false;
    }
    if (pn.a(this.b)) {
      return false;
    }
    int i = this.e;
    if (i >= 0) {
      return i <= 2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pb
 * JD-Core Version:    0.7.0.1
 */