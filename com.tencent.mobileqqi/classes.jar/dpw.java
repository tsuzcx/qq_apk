import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dpw
  extends Handler
{
  public dpw(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    int i = 0;
    if (paramMessage.what == 1) {
      this.a.j();
    }
    label344:
    do
    {
      do
      {
        int j;
        do
        {
          return;
          if (paramMessage.what == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
            }
            this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g());
            return;
          }
          if (paramMessage.what == 4)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
            }
            if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.b & 0x800) != 0L) {
              this.a.a(7, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.t, false);
            }
            this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.g());
            if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q == null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))) {
              TroopInfoActivity.a(this.a);
            }
            if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.b & 0x800) == 0L))
            {
              this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
              this.a.r();
              this.a.q();
              if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
                break label344;
              }
            }
            for (paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;; paramMessage = this.a.getResources().getString(2131562503))
            {
              this.a.a(6, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i == null) {
                TroopInfoActivity.b(this.a);
              }
              this.a.t();
              return;
              bool = false;
              break;
            }
          }
          if (paramMessage.what == 5)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
            }
            this.a.a(4, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
            return;
          }
          Object localObject2;
          if (paramMessage.what == 6)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
            }
            paramMessage = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
            this.a.a(8, paramMessage, true);
            localObject1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
            localObject2 = (LinearLayout)((View)localObject1).findViewById(2131231118);
            if (localObject2 != null)
            {
              if (TextUtils.isEmpty(paramMessage)) {
                i = 8;
              }
              ((LinearLayout)localObject2).setVisibility(i);
            }
            ((View)localObject1).setVisibility(8);
            return;
          }
          if (paramMessage.what != 8) {
            break;
          }
          paramMessage = paramMessage.getData();
          Object localObject1 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
          i = paramMessage.getInt("newSeq");
          j = paramMessage.getInt("CMD_TYPE");
          paramMessage = new ArrayList();
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
              localAvatarInfo.b = ((String)localObject2);
              localAvatarInfo.c = "AVATAR_URL_STR";
              paramMessage.add(localAvatarInfo);
            }
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter == null);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramMessage, i, j);
        return;
      } while ((paramMessage.what != 11) || (!(paramMessage.obj instanceof String)));
      paramMessage = (String)paramMessage.obj;
    } while (this.a.jdField_a_of_type_AndroidWidgetTextView == null);
    if ((this.a.b != null) && (this.a.b.getVisibility() == 8)) {
      this.a.b.setVisibility(0);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpw
 * JD-Core Version:    0.7.0.1
 */