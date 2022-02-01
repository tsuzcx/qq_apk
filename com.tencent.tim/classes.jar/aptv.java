import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo;

public class aptv
{
  private long asc;
  private String crl;
  private String crm;
  private String crn;
  private int dVU;
  private int dVV;
  private int dVW;
  private String desc;
  private String name;
  private int status;
  
  public static aptv a(Oidb_0xce5.RobotInfo paramRobotInfo)
  {
    if (paramRobotInfo != null)
    {
      aptv localaptv = new aptv();
      localaptv.asc = paramRobotInfo.robot_uin.get();
      localaptv.name = paramRobotInfo.name.get();
      localaptv.status = paramRobotInfo.status.get();
      localaptv.desc = paramRobotInfo.desc.get();
      localaptv.dVU = paramRobotInfo.enabled_groups.get();
      localaptv.crl = paramRobotInfo.welcome_msg.get();
      localaptv.crm = paramRobotInfo.call_name.get();
      localaptv.dVV = paramRobotInfo.show_invite.get();
      localaptv.dVW = paramRobotInfo.offline.get();
      localaptv.crn = paramRobotInfo.verify.get();
      return localaptv;
    }
    return null;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getUin()
  {
    return this.asc;
  }
  
  public boolean isAdded()
  {
    return this.status == 1;
  }
  
  public boolean isOffline()
  {
    return this.dVW == 1;
  }
  
  protected void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public String toString()
  {
    return "robot_uin:" + this.asc + " name:" + this.name + " status:" + this.status + " desc:" + this.desc + " enabled_groups:" + this.dVU + " welcome_msg:" + this.crl + " call_name:" + this.crm + " show_invite:" + this.dVV + " offline:" + this.dVW + " verify:" + this.crn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptv
 * JD-Core Version:    0.7.0.1
 */