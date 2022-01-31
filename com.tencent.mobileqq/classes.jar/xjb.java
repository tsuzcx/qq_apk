import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.HbSkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

public class xjb
  implements IRedPacket.OnGetSkinListener
{
  public xjb(CommonHbFragment paramCommonHbFragment) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    HbSkinInfo localHbSkinInfo = HbSkinInfo.a(CommonHbFragment.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localHbSkinInfo != null)
    {
      localList = CommonHbFragment.a(this.a).getList();
      if (QLog.isColorLevel()) {
        QLog.d("CommonHbFragment", 2, "redl iscache = " + HbSkinInfo.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      }
      if ((HbSkinInfo.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localHbSkinInfo))) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CommonHbFragment", 2, "no add in list...");
      }
    }
    label110:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = CommonHbFragment.e(this.a);
    }
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    if (QLog.isColorLevel()) {
      QLog.d("CommonHbFragment", 2, "redl add to list show!");
    }
    localList.add(localHbSkinInfo);
    HbSkinInfo.a(localList);
    CommonHbFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjb
 * JD-Core Version:    0.7.0.1
 */