import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;

class vfo
  implements aaav<QQHeadUrl.QQHeadUrlRsp>
{
  vfo(vfi paramvfi, String paramString, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp)
  {
    paramString = this.jdField_a_of_type_JavaLangString;
    Object localObject;
    QQHeadUrl.RspHeadInfo localRspHeadInfo;
    if ((paramBoolean) && (paramLong == 0L) && (paramQQHeadUrlRsp != null))
    {
      localObject = paramQQHeadUrlRsp.dstHeadInfos.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label294;
      }
      localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((List)localObject).get(0);
      if (localRspHeadInfo == null) {
        break label294;
      }
      localObject = localRspHeadInfo.url.get();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (this.jdField_a_of_type_Vfi.a == null)) {
        break label294;
      }
    }
    label294:
    for (;;)
    {
      try
      {
        paramQQHeadUrlRsp = ((FriendListHandler)this.jdField_a_of_type_Vfi.a.a(1)).a().a((String)localObject, (byte)localRspHeadInfo.faceFlag.get(), (byte)paramQQHeadUrlRsp.dstUsrType.get(), 0);
        paramString = paramQQHeadUrlRsp;
        paramQQHeadUrlRsp = MsfSdkUtils.insertMtype("QQHeadIcon", paramQQHeadUrlRsp);
        paramString = paramQQHeadUrlRsp;
        localObject = Uri.parse((String)localObject).getHost();
        paramString = paramQQHeadUrlRsp;
        paramQQHeadUrlRsp = paramQQHeadUrlRsp.replace(Uri.parse(paramQQHeadUrlRsp).getHost(), (CharSequence)localObject);
        paramString = paramQQHeadUrlRsp;
      }
      catch (Exception paramQQHeadUrlRsp)
      {
        try
        {
          bmud.a(String.valueOf(this.jdField_a_of_type_Vfi.a.getAccount()), this.jdField_a_of_type_Vfi.a(), this.jdField_a_of_type_AndroidOsBundle, null, -1);
          if (QLog.isColorLevel()) {
            QLog.d("QCircleSharePart", 1, "shareToQZone  success");
          }
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("QCircleSharePart", 1, "shareToQZone() jumpToQzoneShare error!", paramString);
        }
        paramQQHeadUrlRsp = paramQQHeadUrlRsp;
        QLog.e("QCircleSharePart", 1, "shareToQZone() process icon url error! Use default cover url instead!", paramQQHeadUrlRsp);
        continue;
      }
      paramQQHeadUrlRsp = new ArrayList(1);
      paramQQHeadUrlRsp.add(paramString);
      this.jdField_a_of_type_AndroidOsBundle.putStringArrayList("image_url", paramQQHeadUrlRsp);
      if (vfi.a(this.jdField_a_of_type_Vfi)) {}
      QLog.w("QCircleSharePart", 1, "shareToQZone() get user icon url error! Use default cover url instead!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */