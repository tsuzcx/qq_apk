import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class txx
  extends Handler
{
  public txx(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.f();
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (paramMessage.what == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
          }
          this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getTroopOwnerName(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFetchedTroopOwnerUin());
          return;
        }
        if (paramMessage.what == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
            this.a.a(7, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, false);
          }
          this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFetchedTroopOwnerUin());
          if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick == null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
            TroopInfoActivity.c(this.a);
          }
          bool = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
          if ((this.a.g) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (!this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName)) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = "";
          }
          this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName, bool);
          this.a.k();
          if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {}
          for (paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; paramMessage = this.a.getResources().getString(2131433085))
          {
            this.a.a(6, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass != null) {
              break;
            }
            TroopInfoActivity.d(this.a);
            return;
          }
        }
        if (paramMessage.what == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
          }
          this.a.a(4, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
          return;
        }
        if (paramMessage.what == 6)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
          }
          paramMessage = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
          this.a.a(8, paramMessage, true, 2, true);
          return;
        }
        if (paramMessage.what == 9)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
          }
          paramMessage = new ArrayList();
          if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName)) {
            paramMessage.add(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName);
          }
          this.a.a(9, paramMessage, true, 1, true);
          TroopInfoActivity.e(this.a);
          return;
        }
        if (paramMessage.what == 10)
        {
          TroopInfoActivity.e(this.a);
          return;
        }
        if (paramMessage.what != 8) {
          break;
        }
        paramMessage = paramMessage.getData();
        Object localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
        bool = paramMessage.getBoolean("IS_DEFAULT_AVATAR");
        Object localObject1 = paramMessage.getStringArray("VERIFYING_PICTURE_LIST");
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = new String[0];
        }
        localObject1 = new HashSet(Arrays.asList(paramMessage));
        paramMessage = new ArrayList();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
            localAvatarInfo.c = str;
            localAvatarInfo.d = "AVATAR_URL_STR";
            localAvatarInfo.b = ((Set)localObject1).contains(str);
            paramMessage.add(localAvatarInfo);
          }
        }
        if (!paramMessage.isEmpty())
        {
          localObject1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[10];
          if ((localObject1 instanceof ViewGroup)) {
            ((ViewGroup)localObject1).removeView(this.a.b);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.d();
          ((TextView)((View)localObject1).findViewById(2131366468)).setVisibility(0);
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(paramMessage, bool)));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead = true;
      return;
    } while (paramMessage.what != 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txx
 * JD-Core Version:    0.7.0.1
 */