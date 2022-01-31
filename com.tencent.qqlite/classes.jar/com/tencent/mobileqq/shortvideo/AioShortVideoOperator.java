package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoOperator
  extends BaseShortVideoOprerator
{
  public AioShortVideoOperator() {}
  
  public AioShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.b);
    localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.videoFileFormat = 2;
    localMessageForShortVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramShortVideoUploadInfo.jdField_f_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramShortVideoUploadInfo.b == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_f_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.i == null) {
        paramShortVideoUploadInfo.i = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoUploadInfo.i;
      localMessageForShortVideo.lastModified = 0L;
      if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
        break label381;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.c;
      }
      localMessageForShortVideo.msg = "[视频]";
      localMessageForShortVideo.serial();
      paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramShortVideoUploadInfo.b == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramShortVideoUploadInfo.b != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      label381:
      i = 0;
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoDownloadInfo a(Object paramObject)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str6 = "0";
    String str5 = "0";
    int m = 0;
    long l = 0L;
    int k = 0;
    String str4 = "";
    String str3 = "";
    String str2 = "";
    int j = 0;
    int i = 0;
    String str1 = "";
    Object localObject = "";
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      str6 = ((Intent)localObject).getStringExtra("uin");
      str5 = ((Intent)localObject).getStringExtra("troop_uin");
      m = ((Intent)localObject).getIntExtra("uintype", 1003);
      l = ((Intent)localObject).getLongExtra("file_send_size", 0L);
      ((Intent)localObject).getIntExtra("file_send_business_type", -1);
      k = ((Intent)localObject).getIntExtra("file_send_duration", -1);
      str4 = ((Intent)localObject).getStringExtra("file_send_path");
      str3 = ((Intent)localObject).getStringExtra("thumbfile_send_path");
      str2 = ((Intent)localObject).getStringExtra("file_shortvideo_md5");
      j = ((Intent)localObject).getIntExtra("thumbfile_send_width", 0);
      i = ((Intent)localObject).getIntExtra("thumbfile_send_height", 0);
      str1 = ((Intent)localObject).getStringExtra("thumbfile_md5");
      localObject = ((Intent)localObject).getStringExtra("file_source");
    }
    for (;;)
    {
      ShortVideoUploadInfo localShortVideoUploadInfo = new ShortVideoUploadInfo();
      localShortVideoUploadInfo.jdField_c_of_type_JavaLangString = str6;
      localShortVideoUploadInfo.jdField_g_of_type_JavaLangString = str4;
      localShortVideoUploadInfo.h = str3;
      localShortVideoUploadInfo.b = m;
      localShortVideoUploadInfo.jdField_d_of_type_JavaLangString = str5;
      localShortVideoUploadInfo.jdField_e_of_type_Int = ((int)l);
      localShortVideoUploadInfo.jdField_f_of_type_Int = k;
      localShortVideoUploadInfo.jdField_e_of_type_JavaLangString = str2;
      localShortVideoUploadInfo.jdField_c_of_type_Int = j;
      localShortVideoUploadInfo.jdField_d_of_type_Int = i;
      localShortVideoUploadInfo.jdField_g_of_type_Int = paramShortVideoReq.jdField_d_of_type_Int;
      localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject = paramObject;
      localShortVideoUploadInfo.jdField_f_of_type_JavaLangString = str1;
      localShortVideoUploadInfo.i = ((String)localObject);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localShortVideoUploadInfo;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        str5 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str4 = ((MessageForShortVideo)localObject).videoFileName;
        str3 = ShortVideoUtils.a(((MessageForShortVideo)localObject).md5, "jpg");
        str2 = ((MessageForShortVideo)localObject).md5;
        j = ((MessageForShortVideo)localObject).thumbWidth;
        i = ((MessageForShortVideo)localObject).thumbHeight;
        str1 = ((MessageForShortVideo)localObject).thumbMD5;
        localObject = ((MessageForShortVideo)localObject).fileSource;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
    if (paramSendResult != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.AioShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */