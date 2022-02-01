package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class i$4
  extends WebChromeClient.FileChooserParams
{
  i$4(i parami, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.a.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.a.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.a.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.a.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.a.isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.i.4
 * JD-Core Version:    0.7.0.1
 */