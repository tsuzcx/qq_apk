import android.os.Bundle;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class jrr
  implements BusinessObserver
{
  jrr(jrp paramjrp) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.abq) {
      return;
    }
    if ((!paramBoolean) || (paramBundle == null))
    {
      jrp.a(this.a);
      return;
    }
    do
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramBundle);
        if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          jrp.a(this.a);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        jrp.a(this.a);
        return;
      }
      paramBundle = jrp.b(this.a, localOIDBSSOPkg);
    } while ((paramBundle == null) || (paramBundle.size() <= 0));
    jrp.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jrr
 * JD-Core Version:    0.7.0.1
 */