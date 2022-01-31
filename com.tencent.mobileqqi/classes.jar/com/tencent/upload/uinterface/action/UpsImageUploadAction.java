package com.tencent.upload.uinterface.action;

import FileUpload.UploadUpsInfoReq;
import FileUpload.UploadUpsInfoRsp;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class UpsImageUploadAction
  extends UploadActionFlowWrapper
{
  private boolean mDeleteFileAfterUpload;
  
  public UpsImageUploadAction(UpsImageUploadTask paramUpsImageUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramUpsImageUploadTask);
    this.mDeleteFileAfterUpload = paramBoolean;
    UploadUpsInfoReq localUploadUpsInfoReq = createUploadUpsInfoReq(paramUpsImageUploadTask);
    printUploadUpsInfoReq(localUploadUpsInfoReq);
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = ProtocolUtil.pack(localUploadUpsInfoReq.getClass().getSimpleName(), localUploadUpsInfoReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramUpsImageUploadTask = localObject;
        if (localObject == null) {
          paramUpsImageUploadTask = new Exception("UpsImageUploadAction() pack UploadUpsInfoReq=null. " + localUploadUpsInfoReq);
        }
        throw paramUpsImageUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        UploadLog.w("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramUpsImageUploadTask);
    }
  }
  
  private static UploadUpsInfoReq createUploadUpsInfoReq(UpsImageUploadTask paramUpsImageUploadTask)
  {
    UploadUpsInfoReq localUploadUpsInfoReq = new UploadUpsInfoReq();
    localUploadUpsInfoReq.iKeppRaw = paramUpsImageUploadTask.keepRaw;
    localUploadUpsInfoReq.iType = paramUpsImageUploadTask.dataType;
    localUploadUpsInfoReq.sFileId = paramUpsImageUploadTask.fileId;
    localUploadUpsInfoReq.sBusinessId = paramUpsImageUploadTask.sBusinessId;
    localUploadUpsInfoReq.vBusiNessData = paramUpsImageUploadTask.vBusiNessData;
    localUploadUpsInfoReq.iAppid = paramUpsImageUploadTask.appid;
    if (paramUpsImageUploadTask.iBusiNessType != 0) {}
    for (int i = 1;; i = 0)
    {
      localUploadUpsInfoReq.bNotifyWns = ((byte)i);
      localUploadUpsInfoReq.iBatchId = paramUpsImageUploadTask.iBatchID;
      localUploadUpsInfoReq.iBatUploadNum = paramUpsImageUploadTask.iBatchUploadCount;
      localUploadUpsInfoReq.iCurUpload = paramUpsImageUploadTask.iCurrentUploadOrder;
      localUploadUpsInfoReq.sWnsCmd = paramUpsImageUploadTask.sCommand;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramUpsImageUploadTask.uploadFilePath, localOptions);
      localUploadUpsInfoReq.iPicHight = localOptions.outHeight;
      localUploadUpsInfoReq.iPicWidth = localOptions.outWidth;
      return localUploadUpsInfoReq;
    }
  }
  
  private static void printUploadUpsInfoReq(UploadUpsInfoReq paramUploadUpsInfoReq)
  {
    UploadLog.d("FlowWrapper", "UploadUpsInfoReq [sBusinessId=" + paramUploadUpsInfoReq.sBusinessId + ", iType=" + paramUploadUpsInfoReq.iType + ", sFileId=" + paramUploadUpsInfoReq.sFileId + "]");
  }
  
  private static void printUploadUpsInfoRsp(UploadUpsInfoRsp paramUploadUpsInfoRsp)
  {
    UploadLog.d("FlowWrapper", "UploadUpsInfoReq [iType=" + paramUploadUpsInfoRsp.iType + "]");
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mDeleteFileAfterUpload)) {
      FileUtils.deleteTempFile(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      UploadUpsInfoRsp localUploadUpsInfoRsp = (UploadUpsInfoRsp)ProtocolUtil.unpack(UploadUpsInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject2 = localUploadUpsInfoRsp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.w("FlowWrapper", localException);
      }
      printUploadUpsInfoRsp((UploadUpsInfoRsp)localObject2);
      if (this.mUploadTaskCallback == null) {
        break label188;
      }
      localObject1 = new UpsImageUploadResult();
      ((UpsImageUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((UpsImageUploadResult)localObject1).dataType = ((UploadUpsInfoRsp)localObject2).iType;
      ((UpsImageUploadResult)localObject1).vBusiNessData = ((UploadUpsInfoRsp)localObject2).vBusiNessData;
      ((UpsImageUploadResult)localObject1).url = ((UploadUpsInfoRsp)localObject2).sUrl;
      ((UpsImageUploadResult)localObject1).rawWidth = ((UploadUpsInfoRsp)localObject2).iWidth;
      ((UpsImageUploadResult)localObject1).rawHeight = ((UploadUpsInfoRsp)localObject2).iHight;
      ((UpsImageUploadResult)localObject1).photoType = ((UploadUpsInfoRsp)localObject2).iPhotoType;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label188:
      super.processFileUploadFinishRsp(paramArrayOfByte);
    }
    if (localObject2 == null)
    {
      bool = false;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = "processFileUploadFinishRsp() unpack UploadUpsInfoRsp=null. " + paramArrayOfByte;
        bool = true;
      }
      cancelActionForException(500, 0, true, bool, (String)localObject2, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.UpsImageUploadAction
 * JD-Core Version:    0.7.0.1
 */