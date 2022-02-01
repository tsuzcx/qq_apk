import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akxf
{
  private static void NO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramQQAppInterface == null))
    {
      NO("picPreSendProcess bundle=null!");
      return;
    }
    paramBundle.setClassLoader(PhotoSendParams.class.getClassLoader());
    PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramBundle.getParcelable("PhotoConst.photo_send_qzone_pic_file_params");
    String str2 = paramBundle.getString("uin");
    String str3 = paramQQAppInterface.getCurrentUin();
    paramBundle.getString("troop_uin");
    int i = paramBundle.getInt("uintype", 1003);
    if ((localPhotoSendParams == null) || (TextUtils.isEmpty(localPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(localPhotoSendParams.thumbPath)) || (!aqhq.fileExistsAndNotEmpty(localPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(str2)))
    {
      NO("picPreSendProcess sendParams error, friendUin:" + str2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + str2 + ", uinType:" + i + ", sendParams:" + localPhotoSendParams.toString());
    }
    aoql.a locala = new aoql.a();
    switch (i)
    {
    default: 
      paramBundle = new aoql.a.i();
      paramBundle.selfUin = str3;
      paramBundle.peerUin = str2;
      paramBundle.cmC = str3;
      paramBundle.fileSize = localPhotoSendParams.fileSize;
      paramBundle.md5 = aqhs.hexStr2Bytes(localPhotoSendParams.rawMd5);
      paramBundle.fileName = (localPhotoSendParams.rawMd5 + ".jpg");
      paramBundle.width = localPhotoSendParams.rawWidth;
      paramBundle.height = localPhotoSendParams.rawHeight;
      paramBundle.picType = 1000;
      paramBundle.dRm = 3;
      paramBundle.cmB = localPhotoSendParams.rawDownloadUrl;
    }
    for (String str1 = "c2c_pic_up"; TextUtils.isEmpty(str1); str1 = "grp_pic_up")
    {
      NO("picPreSendProcess protoKey=null!");
      return;
      paramBundle = new aoql.a.i();
      paramBundle.selfUin = str3;
      paramBundle.peerUin = str2;
      paramBundle.cmC = str3;
      paramBundle.fileSize = localPhotoSendParams.fileSize;
      paramBundle.md5 = aqhs.hexStr2Bytes(localPhotoSendParams.rawMd5);
      paramBundle.fileName = (localPhotoSendParams.rawMd5 + ".jpg");
      paramBundle.width = localPhotoSendParams.rawWidth;
      paramBundle.height = localPhotoSendParams.rawHeight;
      paramBundle.picType = 1000;
      paramBundle.busiType = 1045;
      paramBundle.uinType = 1;
      paramBundle.dRm = 3;
      paramBundle.cmB = localPhotoSendParams.rawDownloadUrl;
    }
    locala.He.add(paramBundle);
    locala.cmy = str1;
    locala.a = paramQQAppInterface.getProtoReqManager();
    locala.b = new akxg(str3, str2, localPhotoSendParams);
    aoqm.c(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxf
 * JD-Core Version:    0.7.0.1
 */