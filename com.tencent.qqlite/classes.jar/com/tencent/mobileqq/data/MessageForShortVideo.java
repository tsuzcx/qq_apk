package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dcs;
import localpb.richMsg.RichMsg.VideoFile;

public class MessageForShortVideo
  extends ChatMessage
  implements Parcelable, LoggerInterface
{
  public static final Parcelable.Creator CREATOR = new dcs();
  public String fileSource;
  public int fileType;
  public long lastModified;
  public String md5;
  public int thumbHeight;
  public String thumbMD5;
  public int thumbWidth;
  public String uuid;
  public int videoFileFormat;
  public String videoFileName;
  public int videoFileProgress;
  public int videoFileSize;
  public int videoFileStatus;
  public int videoFileTime;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    try
    {
      localVideoFile.mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    if (i != 0)
    {
      this.videoFileName = localVideoFile.bytes_file_name.get().toStringUtf8();
      this.uuid = localVideoFile.bytes_file_uuid.get().toStringUtf8();
      this.md5 = HexUtil.bytes2HexStr(localVideoFile.bytes_file_md5.get().toByteArray());
      this.videoFileFormat = localVideoFile.uint32_file_format.get();
      this.videoFileSize = localVideoFile.uint32_file_size.get();
      this.videoFileTime = localVideoFile.uint32_file_time.get();
      this.thumbWidth = localVideoFile.uint32_thumb_width.get();
      this.thumbHeight = localVideoFile.uint32_thumb_height.get();
      this.videoFileStatus = localVideoFile.uint32_file_status.get();
      this.videoFileProgress = localVideoFile.uint32_file_progress.get();
      this.fileType = localVideoFile.uint32_file_type.get();
      this.thumbMD5 = HexUtil.bytes2HexStr(localVideoFile.bytes_thumb_file_md5.get().toByteArray());
      this.fileSource = localVideoFile.bytes_source.get().toStringUtf8();
      this.lastModified = localVideoFile.file_lastmodified.get();
    }
  }
  
  public ShortVideoDownloadInfo getDownloadInfo()
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    localShortVideoDownloadInfo.jdField_a_of_type_Long = this.uniseq;
    localShortVideoDownloadInfo.jdField_b_of_type_Int = this.istroop;
    localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    localShortVideoDownloadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    localShortVideoDownloadInfo.jdField_d_of_type_JavaLangString = this.senderuin;
    localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = this.uuid;
    localShortVideoDownloadInfo.e = this.md5;
    localShortVideoDownloadInfo.jdField_c_of_type_Int = this.videoFileTime;
    localShortVideoDownloadInfo.jdField_d_of_type_Int = this.videoFileFormat;
    localShortVideoDownloadInfo.jdField_c_of_type_Int = this.videoFileTime;
    localShortVideoDownloadInfo.f = this.thumbMD5;
    return localShortVideoDownloadInfo;
  }
  
  public RichMsg.VideoFile getSerialPB()
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    PBBytesField localPBBytesField = localVideoFile.bytes_file_name;
    if (this.videoFileName != null)
    {
      str = this.videoFileName;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localPBBytesField = localVideoFile.bytes_file_md5;
      if (this.md5 == null) {
        break label251;
      }
      str = this.md5;
      label55:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_file_uuid;
      if (this.uuid == null) {
        break label257;
      }
      str = this.uuid;
      label83:
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localVideoFile.uint32_file_format.set(this.videoFileFormat);
      localVideoFile.uint32_file_size.set(this.videoFileSize);
      localVideoFile.uint32_file_time.set(this.videoFileTime);
      localVideoFile.uint32_thumb_width.set(this.thumbWidth);
      localVideoFile.uint32_thumb_height.set(this.thumbHeight);
      localVideoFile.uint32_file_status.set(this.videoFileStatus);
      localVideoFile.uint32_file_progress.set(this.videoFileProgress);
      localVideoFile.uint32_file_type.set(this.fileType);
      localPBBytesField = localVideoFile.bytes_thumb_file_md5;
      if (this.thumbMD5 == null) {
        break label263;
      }
      str = this.thumbMD5;
      label196:
      localPBBytesField.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      localPBBytesField = localVideoFile.bytes_source;
      if (this.fileSource == null) {
        break label269;
      }
    }
    label257:
    label263:
    label269:
    for (String str = this.fileSource;; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localVideoFile.file_lastmodified.set(this.lastModified);
      return localVideoFile;
      str = "";
      break;
      label251:
      str = "";
      break label55;
      str = "";
      break label83;
      str = "";
      break label196;
    }
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
    this.msgData = getSerialPB().toByteArray();
  }
  
  public String toLogString()
  {
    if (isSendFromLocal()) {
      return "[sendFromLocal, fileName:" + this.videoFileName + ", videoFileSize:" + this.videoFileSize + ", videoFileTime:" + this.videoFileTime + ", videoFileFormat:" + this.videoFileFormat + ", thumbWidth:" + this.thumbWidth + ", thumbHeight:" + this.thumbHeight + ", fileType:" + ShortVideoUtils.a(this.fileType) + ", videoFileStatus:" + ShortVideoUtils.b(this.videoFileStatus) + ", videoFileProgress:" + this.videoFileProgress + ", md5:" + this.md5 + ", thumbMD5:" + this.thumbMD5 + "]";
    }
    return "[uuid:" + this.uuid + ", fileName:" + this.videoFileName + ", videoFileSize:" + this.videoFileSize + ", videoFileTime:" + this.videoFileTime + ", videoFileFormat:" + this.videoFileFormat + ", thumbWidth:" + this.thumbWidth + ", thumbHeight:" + this.thumbHeight + ", fileType:" + ShortVideoUtils.a(this.fileType) + ", videoFileStatus:" + ShortVideoUtils.b(this.videoFileStatus) + ", videoFileProgress:" + this.videoFileProgress + ", md5:" + this.md5 + ", thumbMD5:" + this.thumbMD5 + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uuid);
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.videoFileName);
    paramParcel.writeInt(this.videoFileSize);
    paramParcel.writeInt(this.videoFileFormat);
    paramParcel.writeInt(this.videoFileTime);
    paramParcel.writeInt(this.thumbWidth);
    paramParcel.writeInt(this.thumbHeight);
    paramParcel.writeInt(this.videoFileStatus);
    paramParcel.writeInt(this.videoFileProgress);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeString(this.thumbMD5);
    paramParcel.writeString(this.fileSource);
    paramParcel.writeLong(this.lastModified);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForShortVideo
 * JD-Core Version:    0.7.0.1
 */