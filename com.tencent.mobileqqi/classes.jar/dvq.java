import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.List;

public class dvq
  extends TroopObserver
{
  public dvq(TroopManageActivity paramTroopManageActivity) {}
  
  protected void a(String paramString, int paramInt)
  {
    ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "up_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    TroopManageActivity localTroopManageActivity;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localTroopManageActivity = this.a;
      if (localObject != null) {
        break label175;
      }
    }
    label175:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))
    {
      localTroopManageActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin)))
      {
        TroopManageActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + paramInt);
        this.a.o = paramInt;
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new dvr(this));
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, String.valueOf(paramLong)));
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          if (paramBoolean)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, this.a.getString(2131562396), 1000);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, this.a.getString(2131562400), 1000);
          TroopManageActivity.c(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramTroopInfo, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_b_of_type_JavaLangString)) && (paramInt > 0))
    {
      paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
      if (paramString != null)
      {
        ((TextView)paramString.findViewById(2131231506)).setText(TroopManageActivity.a(this.a) + "/" + paramInt);
        this.a.n = paramInt;
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, int paramInt)
  {
    TroopManageActivity localTroopManageActivity;
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
      {
        localObject = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localTroopManageActivity = this.a;
        if (localObject != null) {
          break label127;
        }
      }
    }
    label127:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))
    {
      localTroopManageActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin)))
      {
        if (this.a.o != paramInt) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax = paramInt;
        ((FriendsManagerImp)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      }
      return;
    }
    TroopManageActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvq
 * JD-Core Version:    0.7.0.1
 */