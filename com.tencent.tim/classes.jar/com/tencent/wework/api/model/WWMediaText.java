package com.tencent.wework.api.model;

import android.os.Bundle;
import android.util.Log;

public class WWMediaText
  extends WWMediaMessage.WWMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "WWAPI.WWMediaText";
  public String text;
  
  public WWMediaText() {}
  
  public WWMediaText(String paramString)
  {
    this.text = paramString;
  }
  
  public boolean checkArgs()
  {
    if (!super.checkArgs()) {
      return false;
    }
    if ((this.text != null) && (this.text.length() != 0) && (this.text.length() <= 10240)) {
      return true;
    }
    Log.d("WWAPI.WWMediaText", "checkArgs fail, text is invalid");
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.text = paramBundle.getString("_wwtextobject_text");
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwtextobject_text", this.text);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaText
 * JD-Core Version:    0.7.0.1
 */