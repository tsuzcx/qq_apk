package com.tencent.shadow.dynamic.host;

import android.content.Context;

public abstract interface LoaderFactory
{
  public abstract PluginLoaderImpl buildLoader(String paramString, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.LoaderFactory
 * JD-Core Version:    0.7.0.1
 */