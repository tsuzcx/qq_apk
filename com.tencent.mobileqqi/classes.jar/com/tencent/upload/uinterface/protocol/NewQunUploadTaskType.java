package com.tencent.upload.uinterface.protocol;

import com.tencent.upload.uinterface.IUploadTaskType;

public class NewQunUploadTaskType
  implements IUploadTaskType
{
  public int getProtocolFileType()
  {
    return 0;
  }
  
  public int getProtocolUploadType()
  {
    return 22;
  }
  
  public int getServerCategory()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.uinterface.protocol.NewQunUploadTaskType
 * JD-Core Version:    0.7.0.1
 */