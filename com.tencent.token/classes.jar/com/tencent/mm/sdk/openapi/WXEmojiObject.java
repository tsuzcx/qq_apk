package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject()
  {
    this.emojiData = null;
    this.emojiPath = null;
  }
  
  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    if (((this.emojiData == null) || (this.emojiData.length == 0)) && ((this.emojiPath == null) || (this.emojiPath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
      return false;
    }
    if ((this.emojiData != null) && (this.emojiData.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
      return false;
    }
    if (this.emojiPath != null)
    {
      Object localObject = this.emojiPath;
      int i;
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        i = 0;
      }
      while (i > 10485760)
      {
        Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
        return false;
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {
          i = 0;
        } else {
          i = (int)((File)localObject).length();
        }
      }
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
  }
  
  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public int type()
  {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXEmojiObject
 * JD-Core Version:    0.7.0.1
 */