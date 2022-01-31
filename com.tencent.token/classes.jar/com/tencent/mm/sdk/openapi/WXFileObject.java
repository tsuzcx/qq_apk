package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
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
    if (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
      return false;
    }
    if (this.filePath != null)
    {
      Object localObject = this.filePath;
      int i;
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        i = 0;
      }
      while (i > 10485760)
      {
        Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
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