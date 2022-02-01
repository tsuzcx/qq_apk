import Wallet.GetSkinListRsp;
import Wallet.SetSelectedSkinRsp;
import Wallet.SkinInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

class aabo
  implements BusinessObserver
{
  aabo(aabn paramaabn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    QLog.d("HbSkinLogic", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    aabn.a(this.b, false);
    if (paramBundle != null) {
      switch (paramInt)
      {
      }
    }
    label241:
    do
    {
      return;
      List localList = aabn.a(this.b).getList();
      localList.clear();
      aabn.a(this.b, localList);
      GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
      QLog.d("HbSkinLogic", 2, "GetSkinListRsp = " + localGetSkinListRsp);
      if (localGetSkinListRsp != null)
      {
        aabn localaabn = this.b;
        if (localGetSkinListRsp.is_hide_list) {}
        for (paramInt = 8;; paramInt = 0)
        {
          localaabn.FP(paramInt);
          if (!localGetSkinListRsp.is_hide_list) {
            break label241;
          }
          if (aabn.a(this.b) != -1) {
            break;
          }
          aabl.cfZ = aabn.a(this.b, -1);
          return;
        }
        aabn.b(this.b, true);
        aabl.cfZ = aabn.a(this.b, aabn.a(this.b));
        return;
        aabl.buW = paramBundle.getBoolean("isCache");
        aabn.a(this.b, localGetSkinListRsp.selected_id);
        QLog.d("HbSkinLogic", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + aabn.b(this.b));
        aabl.cfZ = localGetSkinListRsp.selected_id;
        QLog.d("HbSkinLogic", 2, "select restor: " + aabl.cfZ);
        aabn.a(this.b).clear();
        paramInt = i;
        while (paramInt < localGetSkinListRsp.skin_list.size())
        {
          paramBundle = new aabl((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
          paramBundle.sort = (paramInt + 1);
          aabn.a(this.b).add(paramBundle);
          paramInt += 1;
        }
        if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
          localList.add(aabl.a.c(localGetSkinListRsp.more_skin_url));
        }
      }
      aabl.hu(localList);
      aabn.a(this.b).notifyDataSetChanged();
      aabn.b(this.b, aabn.a(this.b));
      return;
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("HbSkinLogic", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabo
 * JD-Core Version:    0.7.0.1
 */