package com.tencent.upload.uinterface.data;

import com.tencent.upload.common.Const;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.UppUploadAction;
import com.tencent.upload.uinterface.protocol.UppUploadTaskType;

public class UppUploadTask
  extends AbstractUploadTask
{
  public static final String sfUppAppId = "diy";
  
  public IUploadTaskType getUploadTaskType()
  {
    return new UppUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new UppUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    Const.processPictureTypeUploadTask(paramIUploadServiceContext, this, 0, false);
  }
  
  public boolean onVerifyUploadFile()
  {
    return Const.verifyUploadFileFully(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UppUploadTask
 * JD-Core Version:    0.7.0.1
 */