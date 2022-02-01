import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.b;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xc90.RspBody;

class lgr
  extends jnm.a
{
  lgr(lgp paramlgp, ReadInJoyDiandianHeaderController.b paramb) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0xc90.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if (this.a != null) {
        this.a.a(true, paramInt, paramBundle);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(lgp.TAG, 2, "requestNewCommunityMsg onResult(), exception = " + QLog.getStackTraceString(paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgr
 * JD-Core Version:    0.7.0.1
 */