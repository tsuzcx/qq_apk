import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.cmd0xe19.cmd0xe19.RspBody;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class mdj
  extends jnm.d
{
  public mdj(RIJRedPacketManager paramRIJRedPacketManager, RIJRedPacketManager.d paramd) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 error code = " + paramInt);
    if ((BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() == 2436410075L) || (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() == 3451242434L))
    {
      paramInt = 0;
      paramArrayOfByte = new cmd0xe19.RspBody();
      paramArrayOfByte.button_wording.set("获取更多现金红包");
      paramArrayOfByte.detail_wording.set("已存入看点红包，点击查看");
      paramArrayOfByte.money.set(545L);
      paramArrayOfByte = paramArrayOfByte.toByteArray();
    }
    if (paramInt == 0)
    {
      RIJRedPacketManager.a(this.this$0, paramArrayOfByte, this.a);
      return;
    }
    this.a.aOI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */