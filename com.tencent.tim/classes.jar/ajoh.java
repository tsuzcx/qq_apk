import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class ajoh
{
  public long HR;
  public long HS;
  public long HU;
  public long HV;
  public String aSQ = "";
  public long ada;
  public long adb;
  public long adc;
  public String bRP;
  public boolean bdS;
  public boolean cpt;
  public boolean cpu;
  public boolean cpw;
  public int djW;
  public int djX = 999;
  public int iconResId;
  public String icon_static_url = "";
  public String name;
  public long type;
  public float xw;
  
  public void a(ajoi paramajoi)
  {
    this.type = paramajoi.type;
    this.ada = paramajoi.ada;
    this.xw = paramajoi.xw;
    this.adb = paramajoi.adb;
    this.HR = paramajoi.HR;
    this.HS = paramajoi.HS;
    this.HU = paramajoi.HU;
    this.HV = paramajoi.HV;
    this.cpw = paramajoi.cpw;
    this.adc = paramajoi.adc;
    this.icon_static_url = paramajoi.icon_static_url;
    this.bRP = paramajoi.aSN;
    this.aSQ = paramajoi.aSQ;
    this.bdS = paramajoi.bdS;
  }
  
  public boolean arh()
  {
    boolean bool = true;
    if ((this.type == 12L) || (this.type == 1L) || (this.type == 2L) || (this.type == 3L)) {
      bool = false;
    }
    do
    {
      return bool;
      if ((!ajnu.cp(this.type)) && (this.type != 7L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkForDisplayInfo", 2, "isInTwinkling icon_status:" + this.HU + " currentMillis:" + NetConnInfoCenter.getServerTimeMillis() + " icon_status_end_time:" + this.HV);
      }
    } while ((this.HU == 2L) && (NetConnInfoCenter.getServerTimeMillis() < this.HV * 1000L));
    while (!ajnu.cn(this.HR * 1000L)) {
      return false;
    }
    return true;
  }
  
  public boolean ari()
  {
    return (this.type == 5L) || (this.type == 6L) || (this.type == 8L) || (this.type == 4L);
  }
  
  public boolean arj()
  {
    return this.HU == 1L;
  }
  
  public boolean ark()
  {
    if ((this.cpu) && (TextUtils.isEmpty(this.icon_static_url))) {}
    while ((this.iconResId == 0) && (TextUtils.isEmpty(this.icon_static_url))) {
      return false;
    }
    return true;
  }
  
  public float bg()
  {
    if (arj()) {}
    while (arh()) {
      return 0.4F;
    }
    return 1.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkForDisplayInfo{");
    localStringBuilder.append("type=").append(this.type);
    localStringBuilder.append(", level=").append(this.ada);
    localStringBuilder.append(", count=").append(this.xw);
    localStringBuilder.append(", continue_days=").append(this.adb);
    localStringBuilder.append(", last_action_time=").append(this.HR);
    localStringBuilder.append(", last_change_time=").append(this.HS);
    localStringBuilder.append(", icon_status=").append(this.HU);
    localStringBuilder.append(", icon_status_end_time=").append(this.HV);
    localStringBuilder.append(", hasRemindInContact=").append(this.cpw);
    localStringBuilder.append(", remindAnimStartTime=").append(this.adc);
    localStringBuilder.append(", sortKeyForNormal=").append(this.djW);
    localStringBuilder.append(", isInAIOTitleLeft2=").append(this.cpt);
    localStringBuilder.append(", sortKeyForAIOTitle=").append(this.djX);
    localStringBuilder.append(", name='").append(this.name).append("'");
    localStringBuilder.append(", disableLocalResource=").append(this.cpu);
    localStringBuilder.append(", iconResId=").append(this.iconResId);
    localStringBuilder.append(", iconApngUrl='").append(this.bRP).append("'");
    localStringBuilder.append(", icon_static_url='").append(this.icon_static_url).append("'");
    localStringBuilder.append(", icon_name='").append(this.aSQ).append("'");
    localStringBuilder.append(", user_close_flag=").append(this.bdS);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoh
 * JD-Core Version:    0.7.0.1
 */