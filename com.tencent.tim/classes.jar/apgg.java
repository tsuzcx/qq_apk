import android.text.TextUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class apgg
  extends acnd
{
  public apgg(TroopMoreDetailFragment paramTroopMoreDetailFragment) {}
  
  protected void T(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.eco();
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((this.a.mIsDestroyed) || (!TextUtils.equals(this.a.mTroopUin, String.valueOf(paramLong1))) || (paramInt1 != 2)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((paramList == null) || (paramList.isEmpty()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.mY(paramList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("TroopMoreDetailFragment", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgg
 * JD-Core Version:    0.7.0.1
 */