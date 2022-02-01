package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.pw;

public class WXTextObject
  implements WXMediaMessage.a
{
  public String text;
  
  public WXTextObject()
  {
    this(null);
  }
  
  public WXTextObject(String paramString)
  {
    this.text = paramString;
  }
  
  public boolean checkArgs()
  {
    String str = this.text;
    if ((str != null) && (str.length() != 0) && (this.text.length() <= 10240)) {
      return true;
    }
    pw.a("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxtextobject_text", this.text);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.text = paramBundle.getString("_wxtextobject_text");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXTextObject
 * JD-Core Version:    0.7.0.1
 */