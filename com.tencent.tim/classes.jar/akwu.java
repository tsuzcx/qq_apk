import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.AioQzonePicOperator.1;
import com.tencent.qphone.base.util.QLog;

public class akwu
  extends akws
{
  public akwu() {}
  
  public akwu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!aqhq.fileExistsAndNotEmpty(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = this.logTag;
        localStringBuilder = new StringBuilder().append("AioQzonePicOperator checkParams:");
        if (paramPhotoSendParams == null) {
          break label92;
        }
      }
      label92:
      for (paramPhotoSendParams = paramPhotoSendParams.toString();; paramPhotoSendParams = "")
      {
        QLog.e(str, 2, paramPhotoSendParams);
        return false;
      }
    }
    return true;
  }
  
  public akxy a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("uin");
      String str = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool = paramIntent.getBooleanExtra("video_sync_to_story", false);
      paramIntent = (PhotoSendParams)paramIntent.getParcelableExtra("PhotoConst.photo_send_qzone_pic_file_params");
      if (!a(paramIntent)) {
        return null;
      }
      akxy.a locala = new akxy.a();
      locala.NP((String)localObject);
      locala.Sp(i);
      locala.NT(str);
      locala.So(k);
      locala.Sr(j);
      locala.St(n);
      locala.setEntrance(m);
      locala.Nv(bool);
      locala.setMd5(paramIntent.rawMd5);
      locala.setFileSize(paramIntent.fileSize);
      localObject = locala.a();
      ((akxy)localObject).isQzonePic = true;
      ((akxy)localObject).jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      akxe.M(this.logTag, this.bUB, "createPicUploadInfo", "");
      return localObject;
    }
    akxe.M(this.logTag, this.bUB, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(akxy paramakxy)
  {
    long l = System.currentTimeMillis();
    if ((paramakxy != null) && (a(paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = anbi.a(this.mApp, paramakxy.peerUin, paramakxy.bUG, paramakxy.uinType);
      localMessageForPic.busiType = paramakxy.busiType;
      localMessageForPic.path = paramakxy.localPath;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramakxy.protocolType == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramakxy.a != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramakxy.a.msgseq;
          localMessageForPic.shmsgseq = paramakxy.a.shmsgseq;
          localMessageForPic.msgUid = paramakxy.a.msgUid;
        }
        localMessageForPic.localUUID = paramakxy.localUUID;
        akxe.M(this.logTag, this.bUB, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!anof.ayA()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramakxy.thumbPath;
        localMessageForPic.thumbWidth = paramakxy.thumbWidth;
        localMessageForPic.thumbHeight = paramakxy.thumbHeight;
        localMessageForPic.width = paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramakxy.extLong;
        localMessageForPic.extStr = paramakxy.extStr;
        localMessageForPic.msgVia = paramakxy.entrance;
        localMessageForPic.sync2Story = paramakxy.sync2Story;
        localMessageForPic.isQzonePic = paramakxy.isQzonePic;
        str2 = anbb.cda;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(anbb.cdb, paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(anbb.cdc, String.valueOf(paramakxy.jdField_b_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramakxy.uniseq = localMessageForPic.uniseq;
        akxe.M(this.logTag, this.bUB, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        o(localMessageForPic);
        localMessageForPic.DSKey = paramakxy.aeH;
        akxe.M(this.logTag, this.bUB, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramakxy.aeH);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramakxy.thumbPath;
        break label228;
      }
    }
    return null;
  }
  
  public void a(akxq paramakxq)
  {
    akxe.M(this.logTag, this.bUB, "sendPic.start", "");
    if (b(paramakxq.b))
    {
      b(paramakxq);
      return;
    }
    a(3, paramakxq.b.jdField_b_of_type_Akxn$a);
  }
  
  protected void b(akxq paramakxq)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramakxq.b, paramakxq), 8, null, false);
  }
  
  protected void o(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    aoop.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    akxe.M(this.logTag, this.bUB, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwu
 * JD-Core Version:    0.7.0.1
 */