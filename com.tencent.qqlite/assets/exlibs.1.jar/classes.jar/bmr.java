import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bmr
  extends Handler
{
  public bmr(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (paramMessage.what == 1) {
      this.a.h();
    }
    label342:
    do
    {
      do
      {
        int i;
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
              this.a.o();
              this.a.n();
              if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
                break label342;
              }
            }
            for (paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;; paramMessage = this.a.getResources().getString(2131362830))
            {
              this.a.a(6, paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i == null) {
                TroopInfoActivity.b(this.a);
              }
              this.a.q();
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
          if (paramMessage.what != 8) {
            break;
          }
          paramMessage = paramMessage.getData();
          Object localObject = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
          i = paramMessage.getInt("newSeq");
          j = paramMessage.getInt("CMD_TYPE");
          paramMessage = new ArrayList();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
              localAvatarInfo.b = str;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmr
 * JD-Core Version:    0.7.0.1
 */