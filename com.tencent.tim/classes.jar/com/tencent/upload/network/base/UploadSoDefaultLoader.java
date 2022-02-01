package com.tencent.upload.network.base;

import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.utils.UploadLog;

public class UploadSoDefaultLoader
  implements IUploadSoLoader
{
  public String getSoVersion()
  {
    return "v1.3";
  }
  
  public boolean loadLibrary(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      UploadLog.d("UploadSoDefaultLoader", "loadLibrary :" + paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      UploadLog.e("UploadSoDefaultLoader", "error :" + paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.base.UploadSoDefaultLoader
 * JD-Core Version:    0.7.0.1
 */