package com.facebook.stetho;

import android.content.Context;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;

final class Stetho$1
  extends Stetho.Initializer
{
  Stetho$1(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  protected Iterable<DumperPlugin> getDumperPlugins()
  {
    return new Stetho.DefaultDumperPluginsBuilder(this.val$context).finish();
  }
  
  protected Iterable<ChromeDevtoolsDomain> getInspectorModules()
  {
    return new Stetho.DefaultInspectorModulesBuilder(this.val$context).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.Stetho.1
 * JD-Core Version:    0.7.0.1
 */