import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRight.GetCircleUnCareListRsp;

class vet
  implements aaav<QQCircleRight.GetCircleUnCareListRsp>
{
  vet(veo paramveo) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleRight.GetCircleUnCareListRsp paramGetCircleUnCareListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if ((paramGetCircleUnCareListRsp != null) && (paramGetCircleUnCareListRsp.userlist != null))
      {
        QLog.e("QCirclePrivacySettingContentPart", 1, "UnCareList + updateBlacklistNum= " + paramGetCircleUnCareListRsp.userlist.size());
        veo.a(this.a, paramGetCircleUnCareListRsp.userlist.size());
      }
      return;
    }
    QLog.e("QCirclePrivacySettingContentPart", 1, "UnCareList + retcode= " + paramLong + "errMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vet
 * JD-Core Version:    0.7.0.1
 */