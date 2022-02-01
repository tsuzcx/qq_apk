package com.tencent.wework.api.model;

import android.os.Bundle;
import android.util.Log;

public class WWMediaLink
  extends WWMediaMessage.WWMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "WWAPI.WWMediaLink";
  public String thumbUrl;
  public String webpageUrl;
  
  public boolean checkArgs()
  {
    if (!super.checkArgs()) {
      return false;
    }
    if ((this.webpageUrl != null) && (this.webpageUrl.length() != 0) && (this.webpageUrl.length() <= 10240)) {
      return true;
    }
    Log.d("WWAPI.WWMediaLink", "checkArgs fail, webpageUrl is invalid");
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.thumbUrl = paramBundle.getString("_wwwebpageobject_thumbUrl");
    this.webpageUrl = paramBundle.getString("_wwwebpageobject_webpageUrl");
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
    paramBundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLink
 * JD-Core Version:    0.7.0.1
 */