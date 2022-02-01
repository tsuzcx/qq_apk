package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import java.util.Set;

@API
public abstract interface PluginApplication
{
  @API
  public abstract void onPluginLoaded(String paramString, Set<String> paramSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.PluginApplication
 * JD-Core Version:    0.7.0.1
 */