import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class advl
{
  public String RU;
  public boolean bRf;
  public boolean bRg;
  public boolean bRh;
  public boolean bRi;
  public boolean bRj;
  public boolean bRk;
  public boolean bRl;
  public boolean bRm;
  public boolean bRn;
  public boolean bRo;
  public int cKl;
  public int cKm;
  public int cKn;
  public int cKo;
  
  public advl()
  {
    anq();
  }
  
  public void anq()
  {
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.dynamic_avatar.name());
    this.RU = ((String)localObject);
    this.bRf = true;
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 11) {
          continue;
        }
        this.bRf = false;
        if (Integer.valueOf(localObject[0]).intValue() != 1) {
          continue;
        }
        this.bRg = true;
        if (!this.bRg) {
          continue;
        }
        if (Integer.valueOf(localObject[1]).intValue() != 1) {
          continue;
        }
        this.bRh = true;
      }
      catch (Exception localException)
      {
        this.bRf = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "parse config exception:" + localException.getMessage());
        continue;
        this.bRh = false;
        continue;
        this.bRi = false;
        continue;
        this.bRj = false;
        continue;
        this.bRk = false;
        continue;
        this.bRl = false;
        continue;
        this.bRm = false;
        continue;
        this.bRn = false;
        continue;
        this.bRo = false;
        continue;
        this.bRh = false;
        this.bRi = false;
        this.bRj = false;
        this.bRk = false;
        this.bRl = false;
        this.bRm = false;
        this.bRn = false;
        this.bRo = false;
        continue;
        if ((this.cKl > 0) && (this.cKm > 0)) {
          continue;
        }
        this.bRg = false;
        this.bRh = false;
        this.bRi = false;
        this.bRj = false;
        this.bRk = false;
        this.bRl = false;
        this.bRm = false;
        this.bRn = false;
        this.bRo = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "maxPlayingCount or maxPlayCountOneDay <= 0");
        if (this.cKn > 0) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "adjust samllSizeFPS:" + this.cKn);
        this.cKn = 18;
        if (this.cKo > 0) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "adjust bigSizeFPS:" + this.cKo);
        this.cKo = 18;
      }
      if (Integer.valueOf(localObject[2]).intValue() != 1) {
        continue;
      }
      this.bRi = true;
      if (Integer.valueOf(localObject[3]).intValue() != 1) {
        continue;
      }
      this.bRj = true;
      if (Integer.valueOf(localObject[4]).intValue() != 1) {
        continue;
      }
      this.bRk = true;
      if (Integer.valueOf(localObject[5]).intValue() != 1) {
        continue;
      }
      this.bRl = true;
      if (Integer.valueOf(localObject[6]).intValue() != 1) {
        continue;
      }
      this.bRm = true;
      if (Integer.valueOf(localObject[11]).intValue() != 1) {
        continue;
      }
      this.bRn = true;
      if (Integer.valueOf(localObject[12]).intValue() != 1) {
        continue;
      }
      this.bRo = true;
      this.cKl = Integer.valueOf(localObject[7]).intValue();
      this.cKm = Integer.valueOf(localObject[8]).intValue();
      this.cKn = Integer.valueOf(localObject[9]).intValue();
      this.cKo = Integer.valueOf(localObject[10]).intValue();
      if (!this.bRf) {
        continue;
      }
      this.bRg = true;
      this.bRh = true;
      this.bRi = true;
      this.bRj = true;
      this.bRk = true;
      this.bRl = true;
      this.bRm = true;
      this.cKl = 8;
      this.cKm = 200;
      this.cKn = 18;
      this.cKo = 18;
      this.bRn = true;
      this.bRo = true;
      return;
      this.bRg = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("dpcString:").append(this.RU).append(",isPlayInAll:").append(this.bRg).append(",isPlayInMsgTab:").append(this.bRh).append(",isPlayInContacts:").append(this.bRi).append(",isPlayInNearList:").append(this.bRj).append(",isPlayInFriendProfile:").append(this.bRk).append(",isPlayInNearProfile:").append(this.bRl).append(",isPlayInTroopProfile:").append(this.bRm).append(",maxPlayingCount:").append(this.cKl).append(",maxPlayCountOneDay:").append(this.cKm).append(",bigSizeFPS:").append(this.cKo).append(",smallSizeFPS:").append(this.cKn).append(",isConvsPlayAfterKill:").append(this.bRn).append(",isContactPlayAfterKill:").append(this.bRo).append(",isUseDefault:").append(this.bRf);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advl
 * JD-Core Version:    0.7.0.1
 */