package com.tencent.wework.api.model;

import android.os.Bundle;
import android.util.Log;

public class WWMediaFile
  extends WWMediaMessage.WWMediaObject
{
  private static final String TAG = "WWAPI.WWMediaFile";
  private int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String fileName;
  public String filePath;
  
  public boolean checkArgs()
  {
    if (!super.checkArgs()) {
      return false;
    }
    if (((this.fileData != null) && (this.fileData.length != 0)) || ((this.filePath != null) && (this.filePath.length() != 0)))
    {
      if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
      {
        Log.d("WWAPI.WWMediaFile", "checkArgs fail, fileData is too large");
        return false;
      }
      if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
      {
        Log.d("WWAPI.WWMediaFile", "checkArgs fail, fileSize is too large");
        return false;
      }
      return true;
    }
    Log.d("WWAPI.WWMediaFile", "checkArgs fail, both arguments is null");
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.fileData = paramBundle.getByteArray("_wwfileobject_fileData");
    this.filePath = paramBundle.getString("_wwfileobject_filePath");
    this.fileName = paramBundle.getString("_wwfileobject_fileName");
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 6;
  }
  
  public void setContentLengthLimit(int paramInt)
  {
    this.contentLengthLimit = paramInt;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wwfileobject_fileData", this.fileData);
    paramBundle.putString("_wwfileobject_filePath", this.filePath);
    paramBundle.putString("_wwfileobject_fileName", this.fileName);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaFile
 * JD-Core Version:    0.7.0.1
 */