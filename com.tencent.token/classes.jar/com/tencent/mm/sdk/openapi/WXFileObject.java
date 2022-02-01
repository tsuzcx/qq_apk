package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.pq;
import java.io.File;

public class WXFileObject
  implements WXMediaMessage.a
{
  public byte[] fileData;
  public String filePath;
  
  public WXFileObject()
  {
    this.fileData = null;
    this.filePath = null;
  }
  
  public WXFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  public WXFileObject(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.fileData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.fileData;
      if ((localObject != null) && (localObject.length > 10485760)) {
        localObject = "checkArgs fail, fileData is too large";
      }
    }
    for (;;)
    {
      pq.a("MicroMsg.SDK.WXFileObject", (String)localObject);
      return false;
      localObject = this.filePath;
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
          localObject = "checkArgs fail, fileSize is too large";
          continue;
        }
      }
      return true;
      localObject = "checkArgs fail, both arguments is null";
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
  }
  
  public void setFileData(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public int type()
  {
    return 6;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXFileObject
 * JD-Core Version:    0.7.0.1
 */