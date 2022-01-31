import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class eak
  extends AsyncTask
{
  final RichProtoProc.RichProtoCallback jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = new eal(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public eak(BasePicOprerator paramBasePicOprerator, ArrayList paramArrayList, long paramLong) {}
  
  private String a(im_msg_body.CustomFace paramCustomFace)
  {
    if ((!QLog.isColorLevel()) || (paramCustomFace == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CustomFace]uint32_server_ip:" + paramCustomFace.uint32_server_ip.get());
    localStringBuilder.append(",uint32_server_port:" + paramCustomFace.uint32_server_port.get());
    localStringBuilder.append(",uint32_file_id:" + paramCustomFace.uint32_file_id.get());
    localStringBuilder.append(",bytes_md5:" + HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
    localStringBuilder.append(",str_file_path:" + paramCustomFace.str_file_path.get());
    localStringBuilder.append(",uint32_origin:" + paramCustomFace.uint32_origin.get());
    localStringBuilder.append(",uint32_width:" + paramCustomFace.uint32_width.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",image_type:" + paramCustomFace.image_type.get());
    return localStringBuilder.toString();
  }
  
  private String a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    if ((!QLog.isColorLevel()) || (paramNotOnlineImage == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NotOnlineImage]file_path:" + paramNotOnlineImage.file_path.get().toString());
    localStringBuilder.append(",file_len:" + paramNotOnlineImage.file_len.get());
    localStringBuilder.append(",download_path:" + paramNotOnlineImage.download_path.get().toString());
    localStringBuilder.append(",res_id:" + paramNotOnlineImage.res_id.get());
    localStringBuilder.append(",pic_md5:" + HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
    localStringBuilder.append(",pic_height:" + paramNotOnlineImage.pic_height.get());
    localStringBuilder.append(",pic_width:" + paramNotOnlineImage.pic_width.get());
    localStringBuilder.append(",original:" + paramNotOnlineImage.original.get());
    localStringBuilder.append(",img_type:" + paramNotOnlineImage.img_type.get());
    localStringBuilder.append(",uint32_file_id:" + paramNotOnlineImage.uint32_file_id.get());
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] finish, cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(5, 0, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected Void a(Void... arg1)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.b.size());
    RichProto.RichProtoReq localRichProtoReq1 = new RichProto.RichProtoReq();
    int i = 0;
    for (;;)
    {
      if (i < this.b.size())
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.b.get(i);
        Object localObject = new PicResult();
        ((PicResult)localObject).jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq;
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (!BasePicOprerator.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, localPicFowardInfo)) {
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            ((PicResult)localObject).jdField_d_of_type_Int = -1;
            ((PicResult)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
            ((PicResult)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = "[uploadForwardMultiMsgPics] error, checkFowardPicInfo failed: checkFowardPicInfo failed";
            if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 1) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Int == 3000))
            {
              ((PicResult)localObject).jdField_a_of_type_JavaLangObject = a(null, null, i);
              Logger.b(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] failed, errDec ＝ " + ((PicResult)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
              if (QLog.isColorLevel()) {
                QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] error, checkFowardPicInfo failed:checkFowardPicInfo[" + i + "] failed:" + localPicFowardInfo.toString());
              }
              break label1040;
            }
            ((PicResult)localObject).jdField_a_of_type_JavaLangObject = a(null, null, i);
          }
        }
        localObject = new RichProto.RichProtoReq.PicUpReq();
        ((RichProto.RichProtoReq.PicUpReq)localObject).c = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
        ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
        ((RichProto.RichProtoReq.PicUpReq)localObject).e = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
        boolean bool;
        if (((RichProto.RichProtoReq.PicUpReq)localObject).jdField_d_of_type_Int == 1006)
        {
          bool = true;
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Boolean = bool;
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString);
          if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.m != 1) {
            break label652;
          }
          bool = true;
          label418:
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Boolean = bool;
          if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k == 0) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 0) || (0L == localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c)) {
            break label657;
          }
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Int = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Int = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l;
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Long = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
          label544:
          if ((((RichProto.RichProtoReq.PicUpReq)localObject).jdField_d_of_type_Int != 1) && (((RichProto.RichProtoReq.PicUpReq)localObject).jdField_d_of_type_Int != 3000)) {
            break label889;
          }
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
        }
        for (localRichProtoReq2.jdField_a_of_type_JavaLangString = "grp_pic_up";; localRichProtoReq2.jdField_a_of_type_JavaLangString = "c2c_pic_up")
        {
          ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_JavaLangString = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
          localRichProtoReq2.jdField_a_of_type_JavaUtilList.add(localObject);
          break label1040;
          bool = false;
          break;
          label652:
          bool = false;
          break label418;
          label657:
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
          if (FileUtils.b(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString)) {
            ??? = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString;
          }
          for (;;)
          {
            if (!FileUtils.b(???)) {
              break label836;
            }
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(???, localOptions);
            ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Int = localOptions.outWidth;
            ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Int = localOptions.outHeight;
            ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Long = FileUtil.a(???);
            break;
            if (((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Boolean) {}
            for (??? = URLDrawableHelper.a(localPicFowardInfo, 131075, null);; ??? = URLDrawableHelper.a(localPicFowardInfo, 1, null))
            {
              if (??? == null) {
                break label831;
              }
              ??? = AbsDownloader.d(???.toString());
              break;
            }
            label831:
            ??? = null;
          }
          label836:
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + ???);
          break label544;
          label889:
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
        }
      }
      if (!localRichProtoReq2.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localRichProtoReq2.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
        localRichProtoReq2.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localRichProtoReq2.toString());
        RichProtoProc.a(localRichProtoReq2);
        return null;
      }
      a();
      return null;
      label1040:
      i += 1;
    }
  }
  
  im_msg_body.CustomFace a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      PicFowardInfo localPicFowardInfo;
      try
      {
        localPicFowardInfo = (PicFowardInfo)this.b.get(paramInt);
        if (paramGroupPicUpResp != null)
        {
          localCustomFace.uint32_file_id.set((int)paramGroupPicUpResp.jdField_a_of_type_Long);
          if ((paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList != null) && (paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramGroupPicUpResp = (ServerAddr)paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(GroupPicUploadProcessor.a(paramGroupPicUpResp.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(paramGroupPicUpResp.jdField_b_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
          }
          if (paramPicUpReq == null) {
            break label443;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(paramPicUpReq.jdField_a_of_type_JavaLangString);
          paramGroupPicUpResp = localCustomFace.uint32_origin;
          if (paramPicUpReq.jdField_a_of_type_Boolean)
          {
            i = 1;
            paramGroupPicUpResp.set(i);
            localCustomFace.uint32_width.set(paramPicUpReq.jdField_a_of_type_Int);
            localCustomFace.uint32_height.set(paramPicUpReq.jdField_b_of_type_Int);
            localCustomFace.uint32_size.set((int)paramPicUpReq.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int);
            localCustomFace.uint32_thumb_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
            localCustomFace.image_type.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.n);
            Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
            return localCustomFace;
          }
        }
        else
        {
          localCustomFace.uint32_file_id.set(0);
          continue;
        }
        int i = 0;
      }
      catch (Exception paramPicUpReq)
      {
        Logger.b(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramPicUpReq.toString());
        return null;
      }
      continue;
      label443:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k);
      localCustomFace.uint32_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.b.get(paramInt);
        if (paramPicUpReq != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramPicUpReq.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)paramPicUpReq.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(paramPicUpReq.jdField_b_of_type_Int);
          localNotOnlineImage.pic_width.set(paramPicUpReq.jdField_a_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramPicUpReq.jdField_a_of_type_Boolean) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramC2CPicUpResp != null)
          {
            if (paramC2CPicUpResp.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.b));
            }
            if (paramC2CPicUpResp.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.n);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int);
            localNotOnlineImage.uint32_thumb_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_Int);
            Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k);
          localNotOnlineImage.pic_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramPicUpReq)
      {
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramPicUpReq.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eak
 * JD-Core Version:    0.7.0.1
 */