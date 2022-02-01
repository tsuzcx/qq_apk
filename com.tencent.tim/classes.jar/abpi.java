import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.1;
import com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class abpi
{
  private abpl jdField_a_of_type_Abpl;
  private abpq jdField_a_of_type_Abpq;
  public aquy l = new abpk(this);
  private int mStatus;
  
  public abpi(abpl paramabpl, abpq paramabpq)
  {
    this.jdField_a_of_type_Abpl = paramabpl;
    this.jdField_a_of_type_Abpq = paramabpq;
  }
  
  private void CK(String paramString)
  {
    Object localObject = abmt.getAppInterface();
    if ((localObject == null) || (this.jdField_a_of_type_Abpl == null)) {
      return;
    }
    abmt.Hy(this.jdField_a_of_type_Abpl.gameId);
    aqvc localaqvc = null;
    localObject = (aqva)((AppInterface)localObject).getManager(47);
    if (localObject != null) {
      localaqvc = ((aqva)localObject).a(3);
    }
    if (localaqvc == null)
    {
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "updateGameRes no downloaderInterface");
      return;
    }
    localObject = aqgz.getSDCardMemory();
    if ((localObject != null) && (localObject.length == 2) && (localObject[1] <= 50L))
    {
      ApolloItemBuilder.a(acfp.m(2131704125), 1, BaseApplicationImpl.getContext());
      QLog.w("cmgame_process.CmGameRscDownloader", 2, "updateGameRes:available space on SD card is less than 50M. ====> Stop download game rsc.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(abxi.biF).append(this.jdField_a_of_type_Abpl.itemId);
    int k;
    if (this.jdField_a_of_type_Abpl.isPatch)
    {
      localObject = ".patch";
      paramString = new aquz(paramString, new File((String)localObject));
      paramString.cWy = true;
      paramString.cWs = false;
      paramString.cWw = true;
      paramString.cWB = false;
      paramString.cWz = true;
      paramString.cWA = true;
      paramString.cWl = true;
      paramString.cxX = "apollo_res";
      localObject = new Bundle();
      localaqvc.a(paramString, this.l, (Bundle)localObject);
      k = this.jdField_a_of_type_Abpl.enter;
      if ((k != 2) && (k != 1)) {
        break label372;
      }
    }
    label372:
    for (int i = 1;; i = 0)
    {
      int j;
      if ((k != 4) && (k != 5))
      {
        j = k;
        if (k != 3) {}
      }
      else
      {
        j = 1;
      }
      this.mStatus = 1;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_start", i, j, new String[] { String.valueOf(this.jdField_a_of_type_Abpl.gameId), String.valueOf(this.jdField_a_of_type_Abpl.cqD), this.jdField_a_of_type_Abpl.packName, String.valueOf(this.jdField_a_of_type_Abpl.cqE) });
      return;
      localObject = ".zip";
      break;
    }
  }
  
  private void HL(int paramInt)
  {
    Object localObject = abmt.a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameRscDownloader", 1, "[handleLoadSuppack], launcher is null, mGameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((abos)localObject).a();
    } while (localObject == null);
    ((abpm)localObject).anq();
  }
  
  private void cDZ()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "[doOnGameResFileDone]");
    }
    if (this.jdField_a_of_type_Abpl == null) {}
    do
    {
      String str1;
      do
      {
        return;
        QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], download rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Abpl.startT));
        boolean bool = this.jdField_a_of_type_Abpl.isPatch;
        String str2 = this.jdField_a_of_type_Abpl.md5;
        str1 = abxi.biF + this.jdField_a_of_type_Abpl.itemId + ".zip";
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4);
        try
        {
          localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Abpl.itemId, false).commit();
          if (!bool) {
            break;
          }
          bool = abhh.an(String.valueOf(this.jdField_a_of_type_Abpl.itemId), str2);
          QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], patch rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Abpl.startT));
          if (bool) {
            break;
          }
          QLog.e("cmgame_process.CmGameRscDownloader", 1, "fail to patch, download complete pack.");
          this.jdField_a_of_type_Abpl.isPatch = false;
          CK(this.jdField_a_of_type_Abpl.bhl);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("cmgame_process.CmGameRscDownloader", 1, "uncompressZip fail zip file: " + str1, localException);
          localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Abpl.itemId, true).commit();
        }
      } while (this.jdField_a_of_type_Abpq == null);
      this.jdField_a_of_type_Abpq.bK(-1006, this.jdField_a_of_type_Abpl.packName);
      return;
      if (this.jdField_a_of_type_Abpq != null) {
        aqhq.W(str1, this.jdField_a_of_type_Abpq.t(this.jdField_a_of_type_Abpl.gameId, this.jdField_a_of_type_Abpl.packName), false);
      }
      ApolloUtil.cGt();
      QLog.i("cmgame_process.CmGameRscDownloader", 1, "[game_launch_cost], unzip rsc:" + (System.currentTimeMillis() - this.jdField_a_of_type_Abpl.startT));
      abmt.x(new Object[] { "[downloadRes], done packName:", this.jdField_a_of_type_Abpl.packName, ", cost:", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Abpl.startT) });
      HL(this.jdField_a_of_type_Abpl.gameId);
      if (this.jdField_a_of_type_Abpq != null) {
        this.jdField_a_of_type_Abpq.bJ(this.jdField_a_of_type_Abpl.gameId, this.jdField_a_of_type_Abpl.packName);
      }
      this.mStatus = 0;
    } while (this.jdField_a_of_type_Abpl.isPatch);
    int k = this.jdField_a_of_type_Abpl.enter;
    if (k != 2) {
      if (k != 1) {
        break label629;
      }
    }
    for (;;)
    {
      int j;
      VipUtils.a(null, "cmshow", "Apollo", "game_renew_succeed", i, j, new String[] { String.valueOf(this.jdField_a_of_type_Abpl.gameId), String.valueOf(this.jdField_a_of_type_Abpl.cqD), this.jdField_a_of_type_Abpl.packName, String.valueOf(this.jdField_a_of_type_Abpl.cqE) });
      return;
      i = 1;
      label629:
      if ((k != 2) && (k != 5))
      {
        j = k;
        if (k != 3) {}
      }
      else
      {
        j = 1;
      }
    }
  }
  
  public boolean YT()
  {
    if (this.jdField_a_of_type_Abpl == null) {}
    boolean bool;
    do
    {
      return false;
      bool = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getBoolean("apollo_sp_game_rsc_verify_" + this.jdField_a_of_type_Abpl.itemId, false);
      if (bool) {}
      QLog.i("cmgame_process.CmGameRscDownloader", 1, "isVerifyFail:" + bool + ",isUpdate:" + this.jdField_a_of_type_Abpl.isUpdate + ",isPatch:" + this.jdField_a_of_type_Abpl.isPatch + "packType:" + this.jdField_a_of_type_Abpl.cqE + ",delay:" + this.jdField_a_of_type_Abpl.delayMs);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameRscDownloader", 2, new Object[] { "patchUrl:", this.jdField_a_of_type_Abpl.patchUrl });
      }
    } while ((!bool) && (!this.jdField_a_of_type_Abpl.isUpdate));
    ThreadManager.getSubThreadHandler().postDelayed(new CmGameRscDownloader.1(this), this.jdField_a_of_type_Abpl.delayMs);
    return true;
  }
  
  public void cDY()
  {
    if (this.jdField_a_of_type_Abpq != null) {
      this.jdField_a_of_type_Abpq.bI(this.jdField_a_of_type_Abpl.gameId, this.jdField_a_of_type_Abpl.packName);
    }
    if ((this.jdField_a_of_type_Abpl.isPatch) && (this.jdField_a_of_type_Abpl.cM != null) && (this.jdField_a_of_type_Abpl.cM.length > 0))
    {
      ThreadManager.excute(new CmGameRscDownloader.2(this), 192, null, true);
      return;
    }
    boolean bool = aqiw.isWifiConnected(BaseApplicationImpl.getApplication().getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.i("cmgame_process.CmGameRscDownloader", 2, "is wifi:" + bool + ",pkg size:" + this.jdField_a_of_type_Abpl.Ol + ",tip size:" + this.jdField_a_of_type_Abpl.Ok);
    }
    if ((bool) || (this.jdField_a_of_type_Abpl.Ol < this.jdField_a_of_type_Abpl.Ok))
    {
      if (this.jdField_a_of_type_Abpl.isPatch) {}
      for (localObject = this.jdField_a_of_type_Abpl.patchUrl;; localObject = this.jdField_a_of_type_Abpl.bhl)
      {
        CK((String)localObject);
        return;
      }
    }
    Object localObject = new abpj(this);
    if (this.jdField_a_of_type_Abpq != null) {
      this.jdField_a_of_type_Abpq.a((CmGameStartChecker.b)localObject, this.jdField_a_of_type_Abpl.Ol);
    }
    if ("message".equals(this.jdField_a_of_type_Abpl.from)) {}
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", i, 3, new String[] { String.valueOf(this.jdField_a_of_type_Abpl.gameId) });
      return;
    }
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpi
 * JD-Core Version:    0.7.0.1
 */