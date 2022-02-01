import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

class aqqg
  extends VasQuickUpdateManager.CallBacker
{
  aqqg(aqqf paramaqqf) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((16L != paramLong) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    label94:
    boolean bool;
    label118:
    int i;
    if ((QLog.isColorLevel()) || (paramInt1 != 0))
    {
      localObject1 = new StringBuilder().append("callBacker, from:").append(paramString3).append(",httpCode=").append(paramInt2).append(",errorCode:").append(paramInt1).append(", scid:").append(paramString1).append(", cfgScid:").append(paramString2);
      if (paramInt1 != 0)
      {
        paramVasQuickUpdateManager = ", Error ";
        QLog.d("IndividualRedPacketResDownloader", 2, paramVasQuickUpdateManager);
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label328;
      }
      bool = true;
      if (!bool) {
        break label334;
      }
      i = 2;
    }
    label328:
    label334:
    label340:
    do
    {
      for (;;)
      {
        try
        {
          if (!"iRedPacket_v3.json".equals(paramString1)) {
            break label340;
          }
          this.b.cB(true, false);
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2 + ", downloadOK=" + bool);
          }
          if ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("silent_download.redbag"))) {
            break;
          }
          this.b.px();
          return;
        }
        catch (Exception paramVasQuickUpdateManager)
        {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, paramVasQuickUpdateManager);
          return;
        }
        paramVasQuickUpdateManager = ", ok ";
        break label94;
        bool = false;
        break label118;
        i = -1;
        continue;
        if ("iRedPacket_v3.char300.json".equals(paramString1))
        {
          if (bool)
          {
            paramVasQuickUpdateManager = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
            paramVasQuickUpdateManager = VasQuickUpdateManager.getFileFromLocal(this.b.app, 16L, "iRedPacket_v3.char300.json", paramVasQuickUpdateManager, false, this.b.callBacker);
            this.b.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.b.app;
          ??? = acgn.bou;
          if (!bool) {
            break label1062;
          }
          paramVasQuickUpdateManager = "1";
          anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else if ("iRedPacket_v3.font.zip".equals(paramString1))
        {
          this.b.a.state = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(acgn.b(null, null, 21, 0, 0));
            this.b.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.b.app;
          ??? = acgn.bou;
          if (!bool) {
            break label1070;
          }
          paramVasQuickUpdateManager = "1";
          anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else
        {
          if (!"iRedPacket_v3.specialChar.zip".equals(paramString1)) {
            break label647;
          }
          this.b.c.state = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(acgn.b(null, null, 25, 0, 0));
            this.b.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
        }
      }
    } while (!paramString1.startsWith("luckyMoney.item."));
    label453:
    Object localObject1 = acgn.getIDFromSCID(paramString1);
    label560:
    if (bool)
    {
      paramVasQuickUpdateManager = this.b.a((String)localObject1);
      if ((paramVasQuickUpdateManager != null) && (this.b.d != null))
      {
        ??? = acgn.b((String)localObject1, null, paramVasQuickUpdateManager.a.resType, paramVasQuickUpdateManager.a.version, 0);
        ??? = (String)??? + "_dir2";
        VasQuickUpdateEngine.safeDeleteFile(new File((String)???));
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker delete animateDir: " + (String)???);
        }
      }
    }
    for (;;)
    {
      label647:
      synchronized (this.b.oi)
      {
        if (!this.b.oi.containsKey(localObject1)) {
          break label998;
        }
        localObject3 = (List)this.b.oi.get(localObject1);
        i = 0;
        if (i < ((List)localObject3).size())
        {
          String str = (String)((List)localObject3).get(i);
          if (TextUtils.isEmpty(str)) {
            break label1078;
          }
          this.b.d.dz(str, paramVasQuickUpdateManager.a.resType);
          this.b.d.dz(str + "_tp", paramVasQuickUpdateManager.b.resType);
          this.b.d.dz(str + "_send", paramVasQuickUpdateManager.c.resType);
        }
      }
      this.b.oi.remove(paramVasQuickUpdateManager.id);
      label998:
      ??? = this.b.app;
      Object localObject3 = acgn.bou;
      if (bool) {}
      for (paramVasQuickUpdateManager = "1";; paramVasQuickUpdateManager = "0")
      {
        anot.a((QQAppInterface)???, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, (String)localObject3, paramVasQuickUpdateManager, "1", (String)localObject1);
        break;
      }
      label1062:
      paramVasQuickUpdateManager = "0";
      break label453;
      label1070:
      paramVasQuickUpdateManager = "0";
      break label560;
      label1078:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqg
 * JD-Core Version:    0.7.0.1
 */