package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.qk;
import java.io.File;

public class WXAppExtendObject
  implements WXMediaMessage.a
{
  public String extInfo;
  public byte[] fileData;
  public String filePath;
  
  public WXAppExtendObject() {}
  
  public WXAppExtendObject(String paramString1, String paramString2)
  {
    this.extInfo = paramString1;
    this.filePath = paramString2;
  }
  
  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.extInfo;
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        localObject = this.fileData;
        if ((localObject == null) || (localObject.length == 0)) {
          break label193;
        }
      }
    }
    localObject = this.extInfo;
    if ((localObject != null) && (((String)localObject).length() > 2048)) {
      localObject = "checkArgs fail, extInfo is invalid";
    }
    for (;;)
    {
      qk.a("MicroMsg.SDK.WXAppExtendObject", (String)localObject);
      return false;
      localObject = this.filePath;
      if ((localObject != null) && (((String)localObject).length() > 10240))
      {
        localObject = "checkArgs fail, filePath is invalid";
      }
      else
      {
        localObject = this.filePath;
        if (localObject != null)
        {
          if ((localObject != null) && (((String)localObject).length() != 0))
          {
            localObject = new File((String)localObject);
            if (((File)localObject).exists())
            {
              i = (int)((File)localObject).length();
              break label157;
            }
          }
          int i = 0;
          label157:
          if (i > 10485760)
          {
            localObject = "checkArgs fail, fileSize is too large";
            continue;
          }
        }
        localObject = this.fileData;
        if ((localObject != null) && (localObject.length > 10485760))
        {
          localObject = "checkArgs fail, fileData is too large";
        }
        else
        {
          return true;
          label193:
          localObject = "checkArgs fail, all arguments is null";
        }
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxappextendobject_extInfo", this.extInfo);
    paramBundle.putByteArray("_wxappextendobject_fileData", this.fileData);
    paramBundle.putString("_wxappextendobject_filePath", this.filePath);
  }
  
  public int type()
  {
    return 7;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.extInfo = paramBundle.getString("_wxappextendobject_extInfo");
    this.fileData = paramBundle.getByteArray("_wxappextendobject_fileData");
    this.filePath = paramBundle.getString("_wxappextendobject_filePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXAppExtendObject
 * JD-Core Version:    0.7.0.1
 */