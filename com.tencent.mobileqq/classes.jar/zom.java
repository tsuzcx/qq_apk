import android.os.Bundle;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class zom
  implements BusinessObserver
{
  public zom(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditUniqueTitleActivity", 2, "setUniqueTitle, onReceive. type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    if (!paramBoolean)
    {
      EditUniqueTitleActivity.a(this.a, -1);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg.mergeFrom(paramBundle);
      paramInt = localOIDBSSOPkg.uint32_result.get();
      EditUniqueTitleActivity.a(this.a, paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      EditUniqueTitleActivity.a(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zom
 * JD-Core Version:    0.7.0.1
 */