import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cjo
  extends Handler
{
  public cjo(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                Object localObject1;
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramMessage.what == 1)
                      {
                        this.a.c();
                        return;
                      }
                      if (paramMessage.what == 6)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
                        }
                        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString))
                        {
                          this.a.a(9, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(), true);
                          return;
                        }
                        this.a.a(9, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString, true);
                        return;
                      }
                    } while (paramMessage.what == 12);
                    if (paramMessage.what == 5)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
                      }
                      this.a.a(5, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
                      this.a.w();
                      this.a.a(true);
                      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a);
                      this.a.f();
                      return;
                    }
                    if (paramMessage.what == 2)
                    {
                      switch (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_Int)
                      {
                      default: 
                        paramMessage = "";
                      }
                      for (;;)
                      {
                        localObject1 = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[10];
                        if (localObject1 == null) {
                          break;
                        }
                        ((FormSimpleItem)localObject1).setRightText(paramMessage);
                        return;
                        paramMessage = this.a.getString(2131562718);
                        this.a.getString(2131560660);
                        continue;
                        paramMessage = this.a.getString(2131560653);
                        this.a.getString(2131560662);
                        continue;
                        paramMessage = this.a.getString(2131561714);
                        this.a.getString(2131560663);
                        continue;
                        paramMessage = this.a.getString(2131560652);
                        this.a.getString(2131560661);
                      }
                    }
                  } while (paramMessage.what == 3);
                  if (paramMessage.what == 4)
                  {
                    paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
                    localObject1 = this.a;
                    i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int;
                    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i != 0) {}
                    for (bool = true;; bool = false)
                    {
                      ((ChatSettingForTroop)localObject1).a(paramMessage, i, bool);
                      return;
                    }
                  }
                  if (paramMessage.what != 8) {
                    break;
                  }
                  paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[2];
                } while (paramMessage == null);
                if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k != 0)
                {
                  ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "files_hotpoint", 0, 0, "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "");
                  if (QLog.isDevelopLevel()) {
                    QLog.d("files_hotpoint", 4, "troopUin :" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
                  }
                  if (ChatSettingForTroop.a(this.a) != null) {}
                }
                try
                {
                  long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c).longValue();
                  ChatSettingForTroop.a(this.a, TroopFileManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l));
                  if (ChatSettingForTroop.a(this.a) != null) {
                    ChatSettingForTroop.a(this.a).a(3, 0, 1);
                  }
                  localObject1 = this.a;
                  i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j;
                  if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k != 0)
                  {
                    bool = true;
                    ((ChatSettingForTroop)localObject1).a(paramMessage, i, bool);
                    return;
                  }
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  for (;;)
                  {
                    if (QLog.isDevelopLevel())
                    {
                      QLog.e("Q.chatopttroop", 4, "NumberFormatException");
                      continue;
                      bool = false;
                    }
                  }
                }
              } while (paramMessage.what == 7);
              if (paramMessage.what != 9) {
                break;
              }
              paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[0];
            } while (paramMessage == null);
            Object localObject2 = this.a;
            int i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l;
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((ChatSettingForTroop)localObject2).a(paramMessage, i, bool);
              this.a.a(paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l);
              return;
            }
            if (paramMessage.what != 10) {
              break;
            }
            paramMessage = paramMessage.getData();
            localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
            i = paramMessage.getInt("newSeq");
            int j = paramMessage.getInt("CMD_TYPE");
            paramMessage = new ArrayList();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                String str = (String)((Iterator)localObject2).next();
                AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
                localAvatarInfo.b = str;
                localAvatarInfo.c = "AVATAR_URL_STR";
                paramMessage.add(localAvatarInfo);
              }
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramMessage, i, j);
            }
          } while (ChatSettingForTroop.a(this.a));
          ChatSettingForTroop.a(this.a, true);
          this.a.v();
          return;
          if (paramMessage.what != 11) {
            break;
          }
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
        if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          if ((this.a.jdField_b_of_type_AndroidViewView != null) && (this.a.jdField_b_of_type_AndroidViewView.getVisibility() == 8)) {
            this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        }
      } while (this.a.jdField_b_of_type_AndroidViewView == null);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      if (paramMessage.what == 14)
      {
        this.a.v();
        return;
      }
    } while (paramMessage.what != 13);
    paramMessage = (ArrayList)paramMessage.obj;
    ChatSettingForTroop.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e(), paramMessage);
    this.a.a("Grp", "Clk_invite_new", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cjo
 * JD-Core Version:    0.7.0.1
 */