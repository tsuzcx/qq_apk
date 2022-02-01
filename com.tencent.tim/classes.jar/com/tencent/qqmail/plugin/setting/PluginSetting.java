package com.tencent.qqmail.plugin.setting;

public class PluginSetting
{
  public String pluginFolder;
  public String url;
  public String zipFileExpectedMd5;
  public String zipFileName;
  
  public String toString()
  {
    return "PluginSetting{url='" + this.url + '\'' + ", pluginFolder='" + this.pluginFolder + '\'' + ", zipFileExpectedMd5='" + this.zipFileExpectedMd5 + '\'' + ", zipFileName='" + this.zipFileName + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.plugin.setting.PluginSetting
 * JD-Core Version:    0.7.0.1
 */