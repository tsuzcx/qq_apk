package com.tencent.mobileqq.vaswebviewplugin;

import aqux.b;

class ThemeJsPlugin$4
  implements aqux.b
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, boolean paramBoolean, String paramString3) {}
  
  public void callback(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.this$0.gotoDownload(2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
      return;
    }
    this.this$0.gotoDownload(-2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */