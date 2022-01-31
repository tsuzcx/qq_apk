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
import java.util.LinkedHashMap;
import java.util.List;

public class afc
  extends Handler
{
  public afc(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
                            this.a.a(7, this.a.app.c(), true);
                            return;
                          }
                          this.a.a(7, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString, true);
                          return;
                        }
                      } while (paramMessage.what == 12);
                      if (paramMessage.what == 5)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
                        }
                        this.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h, true);
                        this.a.v();
                        this.a.a(true);
                        this.a.f();
                        return;
                      }
                      if (paramMessage.what == 2)
                      {
                        switch (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_Int)
                        {
                        default: 
                          localObject1 = "";
                          paramMessage = "";
                        }
                        for (;;)
                        {
                          localObject3 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
                          if (localObject3 == null) {
                            break;
                          }
                          ((FormSimpleItem)((View)localObject3).findViewById(2131298549)).setRightText((CharSequence)localObject1);
                          ((TextView)((View)localObject3).findViewById(2131298550)).setText(paramMessage);
                          return;
                          localObject1 = this.a.getString(2131363862);
                          paramMessage = this.a.getString(2131362540);
                          continue;
                          localObject1 = this.a.getString(2131363863);
                          paramMessage = this.a.getString(2131362542);
                          continue;
                          localObject1 = this.a.getString(2131362535);
                          paramMessage = this.a.getString(2131362541);
                        }
                      }
                    } while (paramMessage.what == 3);
                    if (paramMessage.what != 8) {
                      break;
                    }
                    paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
                  } while (paramMessage == null);
                  if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k != 0)
                  {
                    ReportController.b(this.a.app, "CliOper", "", "", "Grp", "files_hotpoint", 0, 0, "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "");
                    if (QLog.isDevelopLevel()) {
                      QLog.d("files_hotpoint", 4, "troopUin :" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
                    }
                    if (ChatSettingForTroop.a(this.a) != null) {}
                  }
                  try
                  {
                    long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c).longValue();
                    ChatSettingForTroop.a(this.a, TroopFileManager.a(this.a.app, l));
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
              localObject2 = this.a;
              i = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l;
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l != 0) {}
              for (bool = true;; bool = false)
              {
                ((ChatSettingForTroop)localObject2).a(paramMessage, i, bool);
                this.a.a(paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l);
                return;
              }
              if (paramMessage.what != 15) {
                break;
              }
              localObject2 = (View)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get((Long)paramMessage.obj);
            } while (localObject2 == null);
            Object localObject3 = this.a;
            if (paramMessage.arg1 > 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((ChatSettingForTroop)localObject3).a((View)localObject2, 0, bool);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (paramMessage.arg1 <= 0)) {
                break;
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_data_appEntry_new", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "" + ((View)localObject2).getTag());
              return;
            }
            if (paramMessage.what != 10) {
              break;
            }
            paramMessage = paramMessage.getData();
            Object localObject2 = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
            int i = paramMessage.getInt("newSeq");
            int j = paramMessage.getInt("CMD_TYPE");
            paramMessage = new ArrayList();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
                localAvatarInfo.b = ((String)localObject3);
                localAvatarInfo.c = "AVATAR_URL_STR";
                paramMessage.add(localAvatarInfo);
              }
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramMessage, i, j);
            }
          } while (ChatSettingForTroop.a(this.a));
          ChatSettingForTroop.a(this.a, true);
          this.a.u();
          return;
          if (paramMessage.what != 11) {
            break;
          }
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
      } while (this.a.jdField_a_of_type_AndroidWidgetTextView == null);
      if ((this.a.jdField_b_of_type_AndroidViewView != null) && (this.a.jdField_b_of_type_AndroidViewView.getVisibility() == 8)) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      return;
      if (paramMessage.what == 14)
      {
        this.a.u();
        return;
      }
    } while (paramMessage.what != 13);
    paramMessage = (ArrayList)paramMessage.obj;
    ChatSettingForTroop.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e(), paramMessage);
    this.a.a("Grp", "Clk_invite_new", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afc
 * JD-Core Version:    0.7.0.1
 */