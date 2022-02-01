import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class aikk
  extends acnd
{
  aikk(aikg paramaikg) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (this.a.ddG == 0) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret success.");
      }
      paramLong = paramTroopInfo.troopPrivilegeFlag;
      if ((0x80 & paramLong) != 0L)
      {
        paramInt1 = 1;
        if ((paramLong & 0x200) == 0L) {
          break label110;
        }
        paramInt2 = 1;
        label61:
        paramString = aikg.a(this.a);
        if ((paramInt1 == 0) || (paramInt2 == 0) || (paramString == null)) {
          break label116;
        }
        yxe.bm(paramString, paramTroopInfo.troopuin);
      }
    }
    for (;;)
    {
      this.a.ddG = 0;
      return;
      paramInt1 = 0;
      break;
      label110:
      paramInt2 = 0;
      break label61;
      label116:
      if (paramTroopInfo.cGroupOption == 1)
      {
        this.a.ddF = paramTroopInfo.cGroupOption;
        aikg.a(this.a, paramTroopInfo);
      }
      else
      {
        aikg.b(this.a, paramTroopInfo);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TroopApiPlugin", 2, "AddTroop onOIDB0X88D_1_Ret failed.");
        }
        this.a.callJs(this.a.bOu, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
        aikg.a(this.a, 2131718828);
      }
    }
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if (this.a.ddF == -1) {
      return;
    }
    if (1 == paramInt1) {
      aikg.a(this.a, 2131695144);
    }
    this.a.ddF = -1;
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.ddF == -1) {
      return;
    }
    if (1 == paramInt1) {
      switch (paramInt2)
      {
      case -1: 
      default: 
        aikg.a(this.a, 2131695144);
      }
    }
    for (;;)
    {
      this.a.ddF = -1;
      return;
      if ((this.a.ddF == 2) || (this.a.ddF == 5))
      {
        this.a.callJs(this.a.bOu, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
      else
      {
        aikg.a(this.a, 2131695145, 2);
        this.a.callJs(this.a.bOu, new String[] { "{\"result\":0,\"message\":\"ok\"}" });
        continue;
        aikg.a(this.a, 2131721390);
        continue;
        this.a.callJs(this.a.bOu, new String[] { "{\"result\":1,\"message\":\"ok\"}" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikk
 * JD-Core Version:    0.7.0.1
 */