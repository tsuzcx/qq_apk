package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.pw;
import java.io.File;

public class WXEmojiObject
  implements WXMediaMessage.a
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
    Object localObject = this.emojiData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.emojiPath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.emojiData;
      if ((localObject != null) && (localObject.length > 10485760)) {
        localObject = "checkArgs fail, emojiData is too large";
      }
    }
    for (;;)
    {
      pw.a("MicroMsg.SDK.WXEmojiObject", (String)localObject);
      return false;
      localObject = this.emojiPath;
      if (localObject != null)
      {
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          localObject = new File((String)localObject);
          if (((File)localObject).exists())
          {
            i = (int)((File)localObject).length();
            break label113;
          }
        }
        int i = 0;
        label113:
        if (i > 10485760)
        {
          localObject = "checkArgs fail, emojiSize is too large";
          continue;
        }
      }
      return true;
      localObject = "checkArgs fail, both arguments is null";
    }
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