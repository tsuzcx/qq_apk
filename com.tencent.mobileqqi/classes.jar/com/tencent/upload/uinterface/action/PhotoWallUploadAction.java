package com.tencent.upload.uinterface.action;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.PhotoWallUploadResult;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoWallUploadAction
  extends UploadActionFlowWrapper
{
  private boolean mDeleteFileAfterUpload;
  
  public PhotoWallUploadAction(PhotoWallUploadTask paramPhotoWallUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramPhotoWallUploadTask);
    this.mDeleteFileAfterUpload = paramBoolean;
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = createDescInfor(paramPhotoWallUploadTask);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramPhotoWallUploadTask = localObject;
        if (localObject == null) {
          paramPhotoWallUploadTask = new Exception("create photowallUpload DescInfor err,but exeception is null");
        }
        throw paramPhotoWallUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = localException;
        UploadLog.e("FlowWrapper", "create photowallUpload DescInfor err", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramPhotoWallUploadTask);
    }
  }
  
  private byte[] createDescInfor(PhotoWallUploadTask paramPhotoWallUploadTask)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("op", paramPhotoWallUploadTask.op);
    localJSONObject.put("source", paramPhotoWallUploadTask.source);
    if (!TextUtils.isEmpty(paramPhotoWallUploadTask.clientIp)) {
      localJSONObject.put("ip", paramPhotoWallUploadTask.clientIp);
    }
    if (!TextUtils.isEmpty(paramPhotoWallUploadTask.title)) {
      localJSONObject.put("title", paramPhotoWallUploadTask.title);
    }
    return localJSONObject.toString().getBytes();
  }
  
  private PhotoWallUploadResult decodeUploadResult(String paramString)
    throws JSONException
  {
    PhotoWallUploadResult localPhotoWallUploadResult = new PhotoWallUploadResult();
    localPhotoWallUploadResult.flowId = this.mAbstractUploadTask.flowId;
    paramString = new JSONObject(paramString);
    localPhotoWallUploadResult.burl = paramString.getString("burl");
    localPhotoWallUploadResult.ctime = paramString.getInt("ctime");
    localPhotoWallUploadResult.filekey = paramString.getString("filekey");
    localPhotoWallUploadResult.publish_code = paramString.getInt("publish_code");
    localPhotoWallUploadResult.surl = paramString.getString("surl");
    localPhotoWallUploadResult.murl = paramString.getString("murl");
    localPhotoWallUploadResult.url = paramString.getString("url");
    return localPhotoWallUploadResult;
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mDeleteFileAfterUpload)) {
      FileUtils.deleteTempFile(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      cancelActionForException(500, 0, true, false, "photowall upload task response is null", null);
      return;
    }
    Object localObject3 = new String(paramArrayOfByte);
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      localObject3 = decodeUploadResult((String)localObject3);
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        localObject1 = Log.getStackTraceString(localException);
        UploadLog.e("FlowWrapper", "decode photowallUpload result err", localException);
      }
      if (this.mUploadTaskCallback == null) {
        break label138;
      }
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject2);
      super.processFileUploadFinishRsp(paramArrayOfByte);
    }
    if (localObject2 == null)
    {
      bool = false;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = "processFileUploadFinishRsp() unpack UploadPicInfoRsp=null. " + paramArrayOfByte;
        bool = true;
      }
      cancelActionForException(500, 0, true, bool, (String)localObject2, null);
      return;
    }
    label138:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.uinterface.action.PhotoWallUploadAction
 * JD-Core Version:    0.7.0.1
 */