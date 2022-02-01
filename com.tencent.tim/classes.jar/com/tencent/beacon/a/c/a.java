package com.tencent.beacon.a.c;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.util.b;

final class a
  implements Runnable
{
  a(com.tencent.beacon.a.d.a parama, String paramString, long paramLong) {}
  
  public void run()
  {
    a.a locala = this.a.edit();
    if (b.a(locala)) {
      locala.putLong(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.c.a
 * JD-Core Version:    0.7.0.1
 */