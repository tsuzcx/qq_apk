import Wallet.GetSkinListRsp;
import Wallet.SetSelectedSkinRsp;
import Wallet.SkinInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.HbSkinInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

public class wzz
  implements BusinessObserver
{
  public wzz(CommonHbFragment paramCommonHbFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CommonHbFragment", 2, "mObserver type = " + paramInt + " isSuccess = " + paramBoolean + " bundle = " + paramBundle);
    }
    if (paramBundle == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 14: 
        List localList = CommonHbFragment.a(this.a).getList();
        localList.clear();
        localList.add(HbSkinInfo.a(CommonHbFragment.e(this.a)));
        GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
        if (QLog.isColorLevel()) {
          QLog.d("CommonHbFragment", 2, "GetSkinListRsp = " + localGetSkinListRsp);
        }
        if (localGetSkinListRsp != null)
        {
          CommonHbFragment localCommonHbFragment = this.a;
          if (localGetSkinListRsp.is_hide_list) {}
          for (paramInt = 8;; paramInt = 0)
          {
            CommonHbFragment.a(localCommonHbFragment, paramInt);
            if (!localGetSkinListRsp.is_hide_list) {
              break;
            }
            HbSkinInfo.c = CommonHbFragment.a(this.a, -1);
            CommonHbFragment.a(this.a, null);
            return;
          }
          HbSkinInfo.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
          CommonHbFragment.a(this.a, localGetSkinListRsp.selected_id);
          if (QLog.isColorLevel()) {
            QLog.d("CommonHbFragment", 2, "rsp size = " + localGetSkinListRsp.skin_list.size() + " serverSkinID = " + CommonHbFragment.a(this.a));
          }
          if (!CommonHbFragment.c(this.a)) {
            HbSkinInfo.c = localGetSkinListRsp.selected_id;
          }
          CommonHbFragment.a(this.a).clear();
          paramInt = i;
          while (paramInt < localGetSkinListRsp.skin_list.size())
          {
            paramBundle = new HbSkinInfo((SkinInfo)localGetSkinListRsp.skin_list.get(paramInt));
            paramBundle.jdField_a_of_type_Int = paramInt;
            CommonHbFragment.a(this.a).add(paramBundle);
            paramInt += 1;
          }
          if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
            localList.add(HbSkinInfo.b(localGetSkinListRsp.more_skin_url));
          }
          if (!TextUtils.isEmpty(localGetSkinListRsp.operate_desc))
          {
            CommonHbFragment.a(this.a, CommonHbFragment.a(this.a), localGetSkinListRsp.operate_desc, localGetSkinListRsp.operate_url);
            CommonHbFragment.a(this.a, CommonHbFragment.b(this.a), localGetSkinListRsp.operate_desc, localGetSkinListRsp.operate_url);
          }
        }
        HbSkinInfo.a(localList);
        CommonHbFragment.a(this.a).notifyDataSetChanged();
        CommonHbFragment.a(this.a, CommonHbFragment.a(this.a));
        return;
      }
      paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
    } while (!QLog.isColorLevel());
    QLog.d("CommonHbFragment", 2, "SetSelectedSkinRsp = " + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzz
 * JD-Core Version:    0.7.0.1
 */