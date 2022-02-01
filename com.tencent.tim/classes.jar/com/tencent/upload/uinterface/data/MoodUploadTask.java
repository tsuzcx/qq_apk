package com.tencent.upload.uinterface.data;

import FileUpload.ShuoshuoInfoReq;
import FileUpload.ShuoshuoInfoRsp;
import FileUpload.ShuoshuoPicInfo;
import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileBatchControlRsp;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.FileControlRsp;
import SLICE_UPLOAD.UploadModel;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.request.UploadRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.request.impl.BatchControlRequest;
import com.tencent.upload.request.impl.FileControlRequest;
import com.tencent.upload.task.TaskState;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.token.TokenProvider;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.ProtocolUtil;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MoodUploadTask
  extends AbstractUploadTask
{
  private static final String TAG = "MoodUploadTask";
  public byte[] businessData = null;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public List<PictureInfo> pictureInfoList = null;
  public String sAlbumID = "";
  
  public MoodUploadTask()
  {
    super(new byte[0]);
    this.mAppid = "commit_shuoshuo";
  }
  
  private static Map<String, String> clearInValidValue(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return paramMap;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          paramMap.put(localEntry.getKey(), "");
        }
      }
    }
  }
  
  private ShuoshuoInfoReq createReq()
  {
    ShuoshuoInfoReq localShuoshuoInfoReq = new ShuoshuoInfoReq();
    localShuoshuoInfoReq.iAlbumTypeID = this.iAlbumTypeID;
    localShuoshuoInfoReq.iBatchID = this.iBatchID;
    localShuoshuoInfoReq.sAlbumID = this.sAlbumID;
    localShuoshuoInfoReq.pic_list = new ArrayList();
    if (this.pictureInfoList != null)
    {
      Iterator localIterator = this.pictureInfoList.iterator();
      while (localIterator.hasNext())
      {
        PictureInfo localPictureInfo = (PictureInfo)localIterator.next();
        localShuoshuoInfoReq.pic_list.add(toShuoshuoPicInfo(localPictureInfo));
      }
    }
    localShuoshuoInfoReq.busiData = this.businessData;
    if (localShuoshuoInfoReq.busiData == null) {
      localShuoshuoInfoReq.busiData = new byte[0];
    }
    return localShuoshuoInfoReq;
  }
  
  private static final ShuoshuoPicInfo toShuoshuoPicInfo(PictureInfo paramPictureInfo)
  {
    ShuoshuoPicInfo localShuoshuoPicInfo = new ShuoshuoPicInfo();
    localShuoshuoPicInfo.albumid = paramPictureInfo.albumid;
    localShuoshuoPicInfo.pictureid = paramPictureInfo.pictureid;
    localShuoshuoPicInfo.sloc = paramPictureInfo.sloc;
    localShuoshuoPicInfo.pictype = paramPictureInfo.pictype;
    if (paramPictureInfo.pictype == 2) {
      localShuoshuoPicInfo.sourceType = 2;
    }
    localShuoshuoPicInfo.picheight = paramPictureInfo.picheight;
    localShuoshuoPicInfo.picwidth = paramPictureInfo.picwidth;
    localShuoshuoPicInfo.ishd = paramPictureInfo.ishd;
    localShuoshuoPicInfo.hdid = paramPictureInfo.hdid;
    localShuoshuoPicInfo.hdheight = paramPictureInfo.hdheight;
    localShuoshuoPicInfo.hdwidth = paramPictureInfo.hdwidth;
    localShuoshuoPicInfo.strWaterMarkID = paramPictureInfo.strWaterMarkID;
    localShuoshuoPicInfo.strWaterMarkMemo = paramPictureInfo.strWaterMarkMemo;
    localShuoshuoPicInfo.mapWaterMarkParams = clearInValidValue(paramPictureInfo.mapWaterMarkParams);
    localShuoshuoPicInfo.pic_url = paramPictureInfo.picUrl;
    localShuoshuoPicInfo.is_appext_pic = paramPictureInfo.isAppExtPic;
    localShuoshuoPicInfo.richval = paramPictureInfo.richval;
    return localShuoshuoPicInfo;
  }
  
  public byte[] buildExtra()
  {
    Object localObject1 = null;
    Object localObject2 = createReq();
    String str = localObject2.getClass().getSimpleName();
    try
    {
      localObject2 = ProtocolUtil.pack(str, localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        UploadLog.e("MoodUploadTask", localException.toString());
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = super.buildExtra();
      UploadLog.e("MoodUploadTask", "package ShuoshuoInfoReq error!!!");
    }
    return localObject2;
  }
  
  public UploadRequest getControlRequest()
  {
    Object localObject = TokenProvider.getAuthToken(this.vLoginData, this.vLoginKey);
    this.mCheckType = CheckType.TYPE_SHA1;
    this.mChecksum = "";
    buildEnv();
    this.mModel = UploadModel.MODEL_NORMAL;
    this.mStEnv = UploadGlobalConfig.getEnv();
    localObject = new FileControlRequest(this.iUin + "", this.mAppid, (AuthToken)localObject, this.mChecksum, this.mCheckType, this.mDataLength, this.mStEnv, this.mModel, this.mSessionId, this.mNeedIpRedirect, true, this.iSync, null);
    ((FileControlRequest)localObject).setExtraParam(buildExtra());
    HashMap localHashMap = new HashMap();
    localHashMap.put("1", (FileControlReq)((FileControlRequest)localObject).createJceRequest());
    return new BatchControlRequest(localHashMap);
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return TaskTypeConfig.ImageUploadTaskType;
  }
  
  public void onFileControlResponse(JceStruct paramJceStruct, UploadResponse paramUploadResponse)
  {
    processUploadMoodRsp(((FileControlRsp)((FileBatchControlRsp)paramJceStruct).control_rsp.get("1")).biz_rsp);
  }
  
  public boolean onRun()
  {
    UploadRequest localUploadRequest = getControlRequest();
    IUploadSession localIUploadSession = this.mSessionPool.poll();
    if (localIUploadSession == null)
    {
      UploadLog.e("MoodUploadTask", "MoodUploadTask onRun(), get session return null !");
      retryPollSession();
      return false;
    }
    this.mSavedSession = localIUploadSession;
    this.mSession = localIUploadSession;
    return this.mSession.send(localUploadRequest, this);
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
  
  protected void processUploadMoodRsp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "vRspData invalid");
      UploadLog.e("MoodUploadTask", "vRspData == null");
      return;
    }
    try
    {
      paramArrayOfByte = (ShuoshuoInfoRsp)ProtocolUtil.unpack(ShuoshuoInfoRsp.class.getSimpleName(), paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        onError(Const.UploadRetCode.DATA_UNPACK_FAILED_RETCODE.getCode(), "processMoodRsp() unpack ShuoshuoInfoRsp == null !");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        UploadLog.e("MoodUploadTask", paramArrayOfByte.toString());
        paramArrayOfByte = null;
      }
      UploadLog.d("MoodUploadTask", "onUploadSucceed flowid = " + this.flowId);
      onUploadSucceed(new MoodUploadResult(paramArrayOfByte.vBusiNessDataRsp));
      setTaskStatus(TaskState.SUCCEED);
      onTaskFinished(Const.UploadRetCode.SUCCEED.getCode(), Const.UploadRetCode.SUCCEED.getDesc());
    }
  }
  
  public static final class PictureInfo
  {
    public String albumid;
    public int hdheight;
    public String hdid;
    public int hdwidth;
    public int isAppExtPic;
    public boolean ishd;
    public Map<String, String> mapWaterMarkParams;
    public String picUrl;
    public int picheight;
    public String pictureid;
    public int pictype;
    public int picwidth;
    public String richval;
    public String sloc;
    public String strWaterMarkID;
    public String strWaterMarkMemo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MoodUploadTask
 * JD-Core Version:    0.7.0.1
 */