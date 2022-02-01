package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import fnf;
import localpb.richMsg.RichMsg.ForwardExtra;
import localpb.richMsg.RichMsg.PicRec;

public class MessageForPic
  extends ChatMessage
  implements Parcelable, LoggerInterface, PicUiInterface
{
  public static final Parcelable.Creator CREATOR = new fnf();
  public static int defaultSuMsgId = -1;
  public long DSKey = 0L;
  public String SpeedInfo;
  public String actMsgContentValue;
  public String action;
  public String bigMsgUrl;
  public int busiType;
  public int fileSizeFlag;
  public long groupFileID;
  public long height;
  public boolean isMixed;
  public boolean isRead;
  public int isReport = 0;
  public boolean isShareAppActionMsg;
  public String localUUID;
  public String md5;
  public String path;
  public int picExtraFlag;
  public Object picExtraObject;
  public int preDownNetworkType = -1;
  public int preDownState = -1;
  public int previewed;
  public String rawMsgUrl;
  public ReportInfo reportInfo;
  public String serverStoreSource;
  public long shareAppID;
  public long size;
  public int subMsgId = defaultSuMsgId;
  public int subVersion = 5;
  public int thumbHeight;
  public String thumbMsgUrl;
  public int thumbWidth;
  public int type;
  public String uuid;
  public long width;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    Object localObject = new RichMsg.PicRec();
    try
    {
      ((RichMsg.PicRec)localObject).mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        PicFowardDbRecordData localPicFowardDbRecordData;
        localException2.printStackTrace();
        int i = 0;
      }
      if (this.msg != null) {
        break label416;
      }
    }
    if (i != 0)
    {
      this.path = ((RichMsg.PicRec)localObject).localPath.get();
      this.size = ((RichMsg.PicRec)localObject).size.get();
      this.type = ((RichMsg.PicRec)localObject).type.get();
      this.isRead = ((RichMsg.PicRec)localObject).isRead.get();
      this.uuid = ((RichMsg.PicRec)localObject).uuid.get();
      this.groupFileID = ((RichMsg.PicRec)localObject).groupFileID.get();
      this.md5 = ((RichMsg.PicRec)localObject).md5.get();
      this.serverStoreSource = ((RichMsg.PicRec)localObject).serverStorageSource.get();
      this.thumbMsgUrl = ((RichMsg.PicRec)localObject).thumbMsgUrl.get();
      this.thumbWidth = ((RichMsg.PicRec)localObject).uint32_thumb_width.get();
      this.thumbHeight = ((RichMsg.PicRec)localObject).uint32_thumb_height.get();
      this.bigMsgUrl = ((RichMsg.PicRec)localObject).bigMsgUrl.get();
      this.rawMsgUrl = ((RichMsg.PicRec)localObject).rawMsgUrl.get();
      this.isReport = ((RichMsg.PicRec)localObject).isReport.get();
      this.subVersion = ((RichMsg.PicRec)localObject).version.get();
      this.picExtraFlag = ((RichMsg.PicRec)localObject).uiOperatorFlag.get();
      this.fileSizeFlag = ((RichMsg.PicRec)localObject).fileSizeFlag.get();
      this.localUUID = ((RichMsg.PicRec)localObject).localUUID.get();
      this.preDownState = ((RichMsg.PicRec)localObject).preDownState.get();
      this.preDownNetworkType = ((RichMsg.PicRec)localObject).preDownNetwork.get();
      this.previewed = ((RichMsg.PicRec)localObject).previewed.get();
      if (((RichMsg.PicRec)localObject).fowardInfo.has())
      {
        localObject = (RichMsg.ForwardExtra)((RichMsg.PicRec)localObject).fowardInfo.get();
        if (localObject != null)
        {
          localPicFowardDbRecordData = new PicFowardDbRecordData();
          localPicFowardDbRecordData.jdField_a_of_type_Long = ((RichMsg.ForwardExtra)localObject).foward_orgId.get();
          localPicFowardDbRecordData.jdField_a_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject).foward_orgUin.get();
          localPicFowardDbRecordData.jdField_a_of_type_Int = ((RichMsg.ForwardExtra)localObject).foward_orgUinType.get();
          localPicFowardDbRecordData.jdField_b_of_type_Int = ((RichMsg.ForwardExtra)localObject).foward_orgFileSizeType.get();
          localPicFowardDbRecordData.jdField_b_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject).foward_orgUrl.get();
          localPicFowardDbRecordData.jdField_c_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject).foward_thumbPath.get();
          this.picExtraObject = localPicFowardDbRecordData;
        }
      }
    }
    for (;;)
    {
      this.mIsParsed = true;
      return;
      try
      {
        if (this.versionCode > 0) {
          this.msg = new String(this.msgData, "UTF-8");
        }
        label416:
        this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
        if ((this.isShareAppActionMsg) || (this.msgtype == -3001) || (this.msgtype == -30002) || (this.msgtype == -30003) || (this.msgtype == -1032))
        {
          bool = true;
          this.isMixed = bool;
          localObject = new TranDbRecord.PicDbRecord();
          if (!this.isMixed) {
            break label658;
          }
          MsgBody localMsgBody = ActionMsgUtil.a(this.msg);
          this.action = localMsgBody.action;
          this.shareAppID = localMsgBody.shareAppID;
          ((TranDbRecord.PicDbRecord)localObject).a(localMsgBody.msg);
          this.actMsgContentValue = localMsgBody.actMsgContentValue;
          this.path = ((TranDbRecord.PicDbRecord)localObject).jdField_b_of_type_JavaLangString;
          this.size = ((TranDbRecord.PicDbRecord)localObject).jdField_b_of_type_Long;
          this.type = ((TranDbRecord.PicDbRecord)localObject).jdField_b_of_type_Int;
          this.isRead = ((TranDbRecord.PicDbRecord)localObject).jdField_a_of_type_Boolean;
          this.uuid = ((TranDbRecord.PicDbRecord)localObject).jdField_c_of_type_JavaLangString;
          this.md5 = ((TranDbRecord.PicDbRecord)localObject).jdField_d_of_type_JavaLangString;
          this.serverStoreSource = ((TranDbRecord.PicDbRecord)localObject).jdField_e_of_type_JavaLangString;
          this.thumbMsgUrl = ((TranDbRecord.PicDbRecord)localObject).jdField_f_of_type_JavaLangString;
          this.bigMsgUrl = ((TranDbRecord.PicDbRecord)localObject).g;
          this.rawMsgUrl = ((TranDbRecord.PicDbRecord)localObject).h;
          this.picExtraFlag = ((TranDbRecord.PicDbRecord)localObject).jdField_d_of_type_Int;
          this.picExtraObject = ((TranDbRecord.PicDbRecord)localObject).jdField_a_of_type_JavaLangObject;
          this.subVersion = 0;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label658:
          localException1.a(this.msg);
        }
      }
    }
  }
  
  public PicDownloadInfo getPicDownloadInfo()
  {
    PicDownloadInfo localPicDownloadInfo = new PicDownloadInfo();
    localPicDownloadInfo.jdField_a_of_type_Int = this.busiType;
    localPicDownloadInfo.jdField_a_of_type_Long = this.uniseq;
    localPicDownloadInfo.jdField_b_of_type_Int = this.istroop;
    localPicDownloadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    localPicDownloadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    localPicDownloadInfo.g = this.uuid;
    localPicDownloadInfo.jdField_f_of_type_JavaLangString = this.md5;
    localPicDownloadInfo.jdField_b_of_type_Long = this.groupFileID;
    localPicDownloadInfo.h = this.thumbMsgUrl;
    localPicDownloadInfo.jdField_i_of_type_JavaLangString = this.bigMsgUrl;
    localPicDownloadInfo.j = this.rawMsgUrl;
    localPicDownloadInfo.jdField_i_of_type_Int = this.subMsgId;
    localPicDownloadInfo.jdField_b_of_type_Boolean = this.isMixed;
    if (localPicDownloadInfo.jdField_b_of_type_Boolean)
    {
      localPicDownloadInfo.k = this.action;
      localPicDownloadInfo.l = this.actMsgContentValue;
      localPicDownloadInfo.jdField_e_of_type_Long = this.shareAppID;
    }
    localPicDownloadInfo.jdField_f_of_type_Int = this.fileSizeFlag;
    localPicDownloadInfo.jdField_c_of_type_Int = this.extraflag;
    localPicDownloadInfo.jdField_a_of_type_JavaLangObject = this.picExtraObject;
    localPicDownloadInfo.jdField_e_of_type_Int = this.subVersion;
    localPicDownloadInfo.jdField_a_of_type_JavaLangString = this.localUUID;
    localPicDownloadInfo.d = this.size;
    if (this.reportInfo == null) {
      this.reportInfo = new ReportInfo();
    }
    localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo = this.reportInfo;
    return localPicDownloadInfo;
  }
  
  public PicUploadInfo getPicUploadInfo()
  {
    PicUploadInfo localPicUploadInfo = new PicUploadInfo();
    localPicUploadInfo.jdField_a_of_type_Int = this.busiType;
    localPicUploadInfo.jdField_a_of_type_Long = this.uniseq;
    localPicUploadInfo.jdField_b_of_type_Int = this.istroop;
    localPicUploadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    localPicUploadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    localPicUploadInfo.jdField_d_of_type_JavaLangString = this.senderuin;
    localPicUploadInfo.jdField_f_of_type_JavaLangString = this.md5;
    localPicUploadInfo.g = this.path;
    localPicUploadInfo.h = this.thumbMsgUrl;
    localPicUploadInfo.jdField_c_of_type_Int = this.picExtraFlag;
    localPicUploadInfo.jdField_a_of_type_JavaLangObject = this.picExtraObject;
    localPicUploadInfo.jdField_a_of_type_JavaLangString = this.localUUID;
    localPicUploadInfo.jdField_e_of_type_Int = this.subVersion;
    return localPicUploadInfo;
  }
  
  public ReportInfo getReportInfo()
  {
    if (this.reportInfo == null) {
      this.reportInfo = new ReportInfo();
    }
    return this.reportInfo;
  }
  
  public RichMsg.PicRec getSerialPB()
  {
    RichMsg.PicRec localPicRec = new RichMsg.PicRec();
    localPicRec.setHasFlag(true);
    Object localObject1 = localPicRec.localPath;
    label85:
    label118:
    Object localObject2;
    if (this.path != null)
    {
      str = this.path;
      ((PBStringField)localObject1).set(str);
      localPicRec.size.set(this.size);
      localPicRec.type.set(this.type);
      localPicRec.isRead.set(this.isRead);
      localObject1 = localPicRec.uuid;
      if (this.uuid == null) {
        break label497;
      }
      str = this.uuid;
      ((PBStringField)localObject1).set(str);
      localPicRec.groupFileID.set(this.groupFileID);
      localObject1 = localPicRec.md5;
      if (this.md5 == null) {
        break label504;
      }
      str = this.md5;
      ((PBStringField)localObject1).set(str);
      localObject1 = localPicRec.serverStorageSource;
      if (this.serverStoreSource == null) {
        break label511;
      }
      str = this.serverStoreSource;
      label140:
      ((PBStringField)localObject1).set(str);
      localObject1 = localPicRec.thumbMsgUrl;
      if (this.thumbMsgUrl == null) {
        break label518;
      }
      str = this.thumbMsgUrl;
      label162:
      ((PBStringField)localObject1).set(str);
      localPicRec.uint32_thumb_width.set(this.thumbWidth);
      localPicRec.uint32_thumb_height.set(this.thumbHeight);
      localObject1 = localPicRec.bigMsgUrl;
      if (this.bigMsgUrl == null) {
        break label525;
      }
      str = this.bigMsgUrl;
      label206:
      ((PBStringField)localObject1).set(str);
      localObject1 = localPicRec.rawMsgUrl;
      if (this.rawMsgUrl == null) {
        break label532;
      }
      str = this.rawMsgUrl;
      label228:
      ((PBStringField)localObject1).set(str);
      localPicRec.uiOperatorFlag.set(this.picExtraFlag);
      localPicRec.version.set(this.subVersion);
      localPicRec.isReport.set(this.isReport);
      localPicRec.fileSizeFlag.set(this.fileSizeFlag);
      localObject1 = localPicRec.localUUID;
      if (this.localUUID == null) {
        break label539;
      }
      str = this.localUUID;
      label294:
      ((PBStringField)localObject1).set(str);
      localPicRec.preDownState.set(this.preDownState);
      localPicRec.preDownNetwork.set(this.preDownNetworkType);
      localPicRec.previewed.set(this.previewed);
      if ((this.picExtraObject != null) && ((this.picExtraObject instanceof PicFowardDbRecordData)))
      {
        localObject1 = (PicFowardDbRecordData)this.picExtraObject;
        localObject2 = (RichMsg.ForwardExtra)localPicRec.fowardInfo.get();
        ((RichMsg.ForwardExtra)localObject2).foward_orgId.set(((PicFowardDbRecordData)localObject1).jdField_a_of_type_Long);
        PBStringField localPBStringField = ((RichMsg.ForwardExtra)localObject2).foward_orgUin;
        if (((PicFowardDbRecordData)localObject1).jdField_a_of_type_JavaLangString == null) {
          break label546;
        }
        str = ((PicFowardDbRecordData)localObject1).jdField_a_of_type_JavaLangString;
        label400:
        localPBStringField.set(str);
        ((RichMsg.ForwardExtra)localObject2).foward_orgUinType.set(((PicFowardDbRecordData)localObject1).jdField_a_of_type_Int);
        ((RichMsg.ForwardExtra)localObject2).foward_orgFileSizeType.set(((PicFowardDbRecordData)localObject1).jdField_b_of_type_Int);
        localPBStringField = ((RichMsg.ForwardExtra)localObject2).foward_orgUrl;
        if (((PicFowardDbRecordData)localObject1).jdField_b_of_type_JavaLangString == null) {
          break label553;
        }
        str = ((PicFowardDbRecordData)localObject1).jdField_b_of_type_JavaLangString;
        label449:
        localPBStringField.set(str);
        localObject2 = ((RichMsg.ForwardExtra)localObject2).foward_thumbPath;
        if (((PicFowardDbRecordData)localObject1).jdField_c_of_type_JavaLangString == null) {
          break label560;
        }
      }
    }
    label518:
    label525:
    label532:
    label539:
    label546:
    label553:
    label560:
    for (String str = ((PicFowardDbRecordData)localObject1).jdField_c_of_type_JavaLangString;; str = "")
    {
      ((PBStringField)localObject2).set(str);
      localPicRec.fowardInfo.setHasFlag(true);
      return localPicRec;
      str = "";
      break;
      label497:
      str = "";
      break label85;
      label504:
      str = "";
      break label118;
      label511:
      str = "";
      break label140;
      str = "";
      break label162;
      str = "";
      break label206;
      str = "";
      break label228;
      str = "";
      break label294;
      str = "";
      break label400;
      str = "";
      break label449;
    }
  }
  
  public boolean hasBigFile()
  {
    return hasFile("chatimg");
  }
  
  public boolean hasFile(String paramString)
  {
    if (isSendFromLocal())
    {
      localObject = getPicUploadInfo();
      ((PicUploadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
      return ((PicUploadInfo)localObject).b();
    }
    Object localObject = getPicDownloadInfo();
    ((PicDownloadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
    return ((PicDownloadInfo)localObject).b();
  }
  
  public boolean hasRawFile()
  {
    return hasFile("chatraw");
  }
  
  public boolean hasThumbFile()
  {
    return hasFile("chatthumb");
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
    if ((this.isShareAppActionMsg) || (this.msgtype == -3001) || (this.msgtype == -30002) || (this.msgtype == -30003) || (this.msgtype == -1032)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isMixed = bool;
      if (!this.isMixed) {
        break;
      }
      this.msgData = this.msg.getBytes();
      return;
    }
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    this.msgData = getSerialPB().toByteArray();
  }
  
  public String toLogString()
  {
    if (isSendFromLocal()) {
      return " loacalpath:" + this.path;
    }
    return " uuid:" + this.uuid + ",md5:" + this.md5;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.type);
    if (this.isRead)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.uuid);
      paramParcel.writeLong(this.groupFileID);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.serverStoreSource);
      paramParcel.writeString(this.thumbMsgUrl);
      paramParcel.writeInt(this.thumbWidth);
      paramParcel.writeInt(this.thumbHeight);
      paramParcel.writeString(this.bigMsgUrl);
      paramParcel.writeString(this.rawMsgUrl);
      paramParcel.writeInt(this.fileSizeFlag);
      paramParcel.writeInt(this.picExtraFlag);
      if (!this.isMixed) {
        break label333;
      }
      i = 1;
      label138:
      paramParcel.writeInt(i);
      if (!this.isShareAppActionMsg) {
        break label338;
      }
    }
    label333:
    label338:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.action);
      paramParcel.writeLong(this.shareAppID);
      paramParcel.writeString(this.actMsgContentValue);
      paramParcel.writeString(this.localUUID);
      paramParcel.writeInt(this.subMsgId);
      paramParcel.writeInt(this.isReport);
      paramParcel.writeInt(this.subVersion);
      paramParcel.writeInt(this.busiType);
      paramParcel.writeString(this.frienduin);
      paramParcel.writeString(this.selfuin);
      paramParcel.writeString(this.senderuin);
      paramParcel.writeInt(this.istroop);
      paramParcel.writeInt(this.versionCode);
      paramParcel.writeLong(this.uniseq);
      paramParcel.writeInt(this.issend);
      paramParcel.writeLong(this.time);
      paramParcel.writeInt(this.msgtype);
      paramParcel.writeInt(this.preDownState);
      paramParcel.writeInt(this.preDownNetworkType);
      paramParcel.writeInt(this.previewed);
      paramParcel.writeParcelable(this.reportInfo, paramInt);
      return;
      i = 0;
      break;
      i = 0;
      break label138;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPic
 * JD-Core Version:    0.7.0.1
 */