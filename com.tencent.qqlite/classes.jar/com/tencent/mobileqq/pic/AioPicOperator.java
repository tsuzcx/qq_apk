package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class AioPicOperator
  extends BasePicOprerator
{
  public AioPicOperator() {}
  
  public AioPicOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    long l = System.currentTimeMillis();
    paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    URLDrawableHelper.a(paramMessageForPic, 65537, null).downloadImediatly();
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public MessageRecord a(PicFowardInfo paramPicFowardInfo)
  {
    boolean bool = true;
    if ((paramPicFowardInfo == null) || (!paramPicFowardInfo.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    PicUploadInfo localPicUploadInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
    localPicFowardDbRecordData.c = localPicUploadInfo.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicUploadInfo.c, localPicUploadInfo.d, localPicUploadInfo.jdField_b_of_type_Int);
    localMessageForPic.path = localPicUploadInfo.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    paramPicFowardInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (paramPicFowardInfo != null)
    {
      localMessageForPic.md5 = paramPicFowardInfo.jdField_f_of_type_JavaLangString;
      localPicFowardDbRecordData.jdField_a_of_type_Long = paramPicFowardInfo.jdField_a_of_type_Long;
      localPicFowardDbRecordData.jdField_a_of_type_JavaLangString = paramPicFowardInfo.c;
      localPicFowardDbRecordData.jdField_a_of_type_Int = paramPicFowardInfo.jdField_b_of_type_Int;
      localPicFowardDbRecordData.b = paramPicFowardInfo.jdField_g_of_type_JavaLangString;
    }
    localMessageForPic.picExtraFlag = TranDbRecord.PicDbRecord.jdField_g_of_type_Int;
    localMessageForPic.picExtraObject = localPicFowardDbRecordData;
    if (localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null) {}
    for (;;)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
      }
      localMessageForPic.localUUID = localPicUploadInfo.jdField_a_of_type_JavaLangString;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.serial();
      localPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramPicFowardInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramPicFowardInfo != null) {
        paramPicFowardInfo.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new BaseTransProcessor(paramPicFowardInfo));
      }
      a(localMessageForPic);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
    }
  }
  
  public MessageRecord a(PicUploadInfo paramPicUploadInfo)
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if ((paramPicUploadInfo != null) && (paramPicUploadInfo.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPicUploadInfo.c, paramPicUploadInfo.d, paramPicUploadInfo.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramPicUploadInfo.jdField_a_of_type_Int;
      localMessageForPic.path = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      if (paramPicUploadInfo.jdField_h_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      if (paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null) {}
      for (;;)
      {
        if (bool)
        {
          localMessageForPic.msgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
        }
        localMessageForPic.localUUID = paramPicUploadInfo.jdField_a_of_type_JavaLangString;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = a(localMessageForPic.path);
        localMessageForPic.thumbMsgUrl = paramPicUploadInfo.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramPicUploadInfo.jdField_f_of_type_Int;
        localMessageForPic.thumbHeight = paramPicUploadInfo.jdField_g_of_type_Int;
        if (GifDrawable.isGifFile(new File(paramPicUploadInfo.jdField_g_of_type_JavaLangString))) {
          localMessageForPic.imageType = 3;
        }
        localMessageForPic.extLong = paramPicUploadInfo.j;
        localMessageForPic.extStr = paramPicUploadInfo.i;
        localMessageForPic.serial();
        paramPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramPicUploadInfo.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramPicUploadInfo.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof ChatMessage))) {
      ((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    CompressInfo localCompressInfo = new CompressInfo();
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    paramIntent = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
    localCompressInfo.jdField_a_of_type_Int = j;
    localCompressInfo.c = paramIntent;
    localCompressInfo.jdField_g_of_type_Int = CompressOperator.a(i);
    return localCompressInfo;
  }
  
  public PicDownloadInfo a(Intent paramIntent)
  {
    return null;
  }
  
  public PicFowardInfo a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      String str5 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str6 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str7 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      String str1 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject2 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
      int j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
      long l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      int k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      String str4 = paramIntent.getStringExtra("forward_photo_md5");
      int m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      long l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      paramIntent = new PicFowardInfo();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a((String)localObject1);
      localBuilder.c(str1);
      localBuilder.c(TranDbRecord.PicDbRecord.jdField_g_of_type_Int);
      localBuilder.j((int)l3);
      localBuilder.k((int)l4);
      localBuilder.b((int)l5);
      localBuilder.l(k);
      localBuilder.m(n);
      localObject2 = AbsDownloader.a((String)localObject2);
      if (localObject2 != null) {
        localBuilder.b(((File)localObject2).getAbsolutePath());
      }
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = str5;
      localBuilder.e(i);
      localBuilder.e(str6);
      localBuilder.d(str7);
      localBuilder.f(str4);
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e = "chatimg";
      if (!FileUtils.b((String)localObject1))
      {
        localObject1 = new PicDownloadInfo.Builder();
        ((PicDownloadInfo.Builder)localObject1).a(1009);
        ((PicDownloadInfo.Builder)localObject1).a(str1);
        ((PicDownloadInfo.Builder)localObject1).b(str2);
        ((PicDownloadInfo.Builder)localObject1).b(j);
        ((PicDownloadInfo.Builder)localObject1).d(str3);
        ((PicDownloadInfo.Builder)localObject1).a(l1);
        ((PicDownloadInfo.Builder)localObject1).e(str4);
        ((PicDownloadInfo.Builder)localObject1).f(m);
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = ((PicDownloadInfo.Builder)localObject1).a();
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int = k;
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = l2;
      }
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
      return paramIntent;
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    label81:
    PicFowardInfo localPicFowardInfo;
    if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003))
    {
      i = 1;
      if (i != 0) {
        break label534;
      }
      i = 65537;
      Object localObject = URLDrawableHelper.a(paramMessageForPic, i).toString();
      localPicFowardInfo = new PicFowardInfo();
      localPicFowardInfo.b = paramMessageForPic.isSendFromLocal();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a(paramMessageForPic.path);
      localBuilder.c(paramString3);
      localBuilder.c(TranDbRecord.PicDbRecord.jdField_g_of_type_Int);
      localBuilder.j((int)paramMessageForPic.width);
      localBuilder.k((int)paramMessageForPic.height);
      localBuilder.b((int)paramMessageForPic.size);
      localBuilder.l(paramMessageForPic.fileSizeFlag);
      localBuilder.a(paramMessageForPic.thumbWidth);
      localBuilder.b(paramMessageForPic.thumbHeight);
      localBuilder.m(paramMessageForPic.imageType);
      localObject = AbsDownloader.a((String)localObject);
      if (localObject != null) {
        localBuilder.b(((File)localObject).getAbsolutePath());
      }
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
      localBuilder.e(paramInt);
      localBuilder.e(paramString1);
      localBuilder.d(paramString2);
      localBuilder.f(paramMessageForPic.md5);
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e = "chatimg";
      if ((paramMessageForPic.isMultiMsg) || (!FileUtils.b(paramMessageForPic.path)))
      {
        paramString1 = new PicDownloadInfo.Builder();
        paramString1.a(1009);
        paramString1.a(paramString3);
        paramString1.b(paramMessageForPic.frienduin);
        paramString1.b(paramMessageForPic.istroop);
        paramString1.d(paramMessageForPic.uuid);
        paramString1.a(paramMessageForPic.uniseq);
        paramString1.e(paramMessageForPic.md5);
        paramString1.f(paramMessageForPic.issend);
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramString1.a();
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e = "chatimg";
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int = paramMessageForPic.fileSizeFlag;
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
      }
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
      paramMessageForPic = this.b;
      paramString1 = this.jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder().append("retry:");
      if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo == null) {
        break label540;
      }
    }
    label534:
    label540:
    for (boolean bool = true;; bool = false)
    {
      Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
      return localPicFowardInfo;
      i = 0;
      break;
      i = 1;
      break label81;
    }
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str1 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      paramIntent = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(str1);
      localBuilder.a(paramIntent);
      localBuilder.e(i);
      localBuilder.e(str2);
      localBuilder.d(k);
      localBuilder.i(j);
      paramIntent = localBuilder.a();
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return paramIntent;
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public ArrayList a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForMixedMsg == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramMessageForMixedMsg.msgElemList == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
      }
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramSendResult.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramSendResult.c;
      localMessageForPic.groupFileID = paramSendResult.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramSendResult.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioPicOperator
 * JD-Core Version:    0.7.0.1
 */