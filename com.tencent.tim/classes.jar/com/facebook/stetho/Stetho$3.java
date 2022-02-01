package com.facebook.stetho;

import android.content.Context;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;

final class Stetho$3
  implements InspectorModulesProvider
{
  Stetho$3(Context paramContext) {}
  
  public Iterable<ChromeDevtoolsDomain> get()
  {
    return new Stetho.DefaultInspectorModulesBuilder(this.val$context).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.Stetho.3
 * JD-Core Version:    0.7.0.1
 */