import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class ajwu
{
  public ajwu.a a;
  public ajwu.b a;
  public int atL;
  public int cmd;
  public AppInterface mApp;
  
  public ajwu(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  private boolean b(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.mApp.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.mApp.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.mApp.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("3.4.4");
      paramReqBody.original_id.set(this.mApp.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public ajwu a(int paramInt)
  {
    this.cmd = paramInt;
    return this;
  }
  
  public ajwu a(ajwu.a parama)
  {
    this.jdField_a_of_type_Ajwu$a = parama;
    return this;
  }
  
  public ajwu a(ajwu.b paramb)
  {
    this.jdField_a_of_type_Ajwu$b = paramb;
    return this;
  }
  
  public ajwu a(byte[] paramArrayOfByte)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (b(localReqBody))
    {
      localReqBody.cmd.set(this.cmd);
      localReqBody.subcmd.set(this.atL);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      jnm.a(this.mApp, new ajwv(this), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
    return this;
  }
  
  public ajwu b(int paramInt)
  {
    this.atL = paramInt;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
  }
  
  public static abstract interface b
  {
    public abstract void m(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwu
 * JD-Core Version:    0.7.0.1
 */