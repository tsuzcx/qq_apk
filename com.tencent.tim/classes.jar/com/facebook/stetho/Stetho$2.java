package com.facebook.stetho;

import android.content.Context;
import com.facebook.stetho.dumpapp.DumperPlugin;

final class Stetho$2
  implements DumperPluginsProvider
{
  Stetho$2(Context paramContext) {}
  
  public Iterable<DumperPlugin> get()
  {
    return new Stetho.DefaultDumperPluginsBuilder(this.val$context).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.Stetho.2
 * JD-Core Version:    0.7.0.1
 */