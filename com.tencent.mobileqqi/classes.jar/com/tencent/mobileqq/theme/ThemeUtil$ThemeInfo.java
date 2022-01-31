package com.tencent.mobileqq.theme;

import java.io.Serializable;

public class ThemeUtil$ThemeInfo
  implements Serializable
{
  public String downloadUrl = "";
  public long downsize = 0L;
  public boolean isVoiceTheme = false;
  public long size = 0L;
  public String status = "1";
  public String themeId = "";
  public String version = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ThemeInfo.class.getName());
    localStringBuilder.append("{");
    localStringBuilder.append("themeId=");
    localStringBuilder.append(this.themeId);
    localStringBuilder.append(",status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(",downsize=");
    localStringBuilder.append(this.downsize);
    localStringBuilder.append(",size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(",version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(",isVoiceTheme=");
    localStringBuilder.append(this.isVoiceTheme);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
 * JD-Core Version:    0.7.0.1
 */