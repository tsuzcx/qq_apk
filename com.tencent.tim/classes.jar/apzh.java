import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apzh
  implements AdapterView.OnItemClickListener
{
  apzh(apzg paramapzg) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    Object localObject = paramView.getTag();
    if ((localObject == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.this$0.mShareActionSheet.dismiss();
    switch (((ShareActionSheetBuilder.b)localObject).b.action)
    {
    }
    for (;;)
    {
      this.this$0.atU = ((int)paramLong);
      if (paramLong != 7L) {
        break label255;
      }
      localObject = new Intent(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Face2FaceAddFriendActivity.class);
      ((Intent)localObject).putExtra("activity_from_type", 1);
      ((Intent)localObject).putExtra("activity_troop_uin", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      break;
      paramLong = 0L;
      continue;
      paramLong = 1L;
      continue;
      paramLong = 3L;
      continue;
      paramLong = 2L;
      continue;
      paramLong = 4L;
      continue;
      paramLong = 5L;
      continue;
      paramLong = 7L;
    }
    label255:
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        this.this$0.Su(false);
        QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), 0).show(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.this$0.atU = -1;
        this.this$0.atV = -1;
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        }
        break;
        if (WXShareHelper.a().isWXsupportApi()) {
          break label711;
        }
        i = 2131721936;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
      }
      if ((this.this$0.atU == 5) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        this.this$0.ecJ();
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        }
      }
      for (;;)
      {
        break;
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (!TroopInfo.isQidianPrivateTroop((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
        {
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            this.this$0.cSZ = true;
          }
          if ((TroopInfo.hasPayPrivilege(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
          for (i = 1;; i = 0)
          {
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) {
              j = 1;
            }
            if ((i | j) == 0) {
              break label654;
            }
            this.this$0.Su(true);
            this.this$0.ecH();
            break;
          }
          label654:
          apzg.a(this.this$0);
        }
        else
        {
          this.this$0.Su(true);
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            this.this$0.cSZ = false;
          }
          this.this$0.atV = 0;
          apzg.b(this.this$0);
        }
      }
      label711:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzh
 * JD-Core Version:    0.7.0.1
 */