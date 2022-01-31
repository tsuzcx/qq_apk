package com.tencent.mm.sdk.platformtools;

import android.widget.Toast;

final class Log$1
  implements Runnable
{
  Log$1(String paramString) {}
  
  public final void run()
  {
    Toast.makeText(MMApplicationContext.getContext(), this.Z, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Log.1
 * JD-Core Version:    0.7.0.1
 */