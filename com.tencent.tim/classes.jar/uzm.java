import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class uzm
  extends acnd
{
  public uzm(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void e(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetGolbalTroopLevel isSuccess = " + paramBoolean + ", uin = " + paramLong + ", level = " + paramInt);
    }
    if (this.this$0.jdField_a_of_type_Alcn == null) {}
    do
    {
      do
      {
        return;
      } while ((TroopInfo.isQidianPrivateTroop(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.troopUin)) || (!paramBoolean) || (paramLong != Long.parseLong(this.this$0.jdField_a_of_type_Alcn.e.uin)));
      this.this$0.jdField_a_of_type_Alcn.drO = paramInt;
    } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null) || (this.this$0.jdField_a_of_type_Alcn == null) || (this.this$0.jdField_a_of_type_Alcn.e == null));
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.this$0.jdField_a_of_type_Alcn, true, new String[] { "map_key_troop_mem_charm_level" });
  }
  
  protected void v(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onTroopRankTitleUpdate, troopUin: %s, memberUin: %s, titleId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((this.this$0.jdField_a_of_type_Alcn == null) || (!this.this$0.jdField_a_of_type_Alcn.cwc) || (this.this$0.jdField_a_of_type_Alcn.c == null) || (this.this$0.jdField_a_of_type_Alcn.e == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
      } while ((!paramString1.equals(this.this$0.jdField_a_of_type_Alcn.troopUin)) || (!paramString2.equals(this.this$0.jdField_a_of_type_Alcn.e.uin)));
      this.this$0.jdField_a_of_type_Alcn.c.titleId = paramInt;
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.j(this.this$0.jdField_a_of_type_Alcn);
  }
  
  protected void v(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (this.this$0.isFinishing())
      {
        QLog.d("FriendProfileCardActivity", 1, "onGetTroopMemberCard return because is finished!");
        return;
      }
      if ((this.this$0.mActionSheet != null) && (this.this$0.mActionSheet.isShowing())) {
        this.this$0.mActionSheet.dismiss();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.this$0.jdField_a_of_type_Alcn.troopUin))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.this$0.jdField_a_of_type_Alcn.troopUin);
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      if (QLog.isColorLevel())
      {
        QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        if (paramObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
          }
        }
        else
        {
          l = paramObject.memberUin;
          if (l != Long.parseLong(this.this$0.jdField_a_of_type_Alcn.d.uin))
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.this$0.jdField_a_of_type_Alcn.d.uin);
            }
          }
          else if ((this.this$0.jdField_a_of_type_Alcn == null) || (this.this$0.jdField_a_of_type_Alcn.d == null) || (this.this$0.jdField_a_of_type_Alcn.e == null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: cardInfo == null || cardInfo.card == null || cardInfo.allinone == null");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "updateParams: uint32_result:" + paramObject.result + " memberRole:" + paramObject.memberRole);
            }
            this.this$0.jdField_a_of_type_Alcn.c = paramObject;
            this.this$0.jdField_a_of_type_Alcn.cwd = true;
            if ((paramObject.result == 260) && (paramObject.memberRole == 0))
            {
              QQToast.a(this.this$0, 1, acfp.m(2131706608), 0).show();
              this.this$0.jdField_a_of_type_Alcn.c = paramObject;
              if (!TroopInfo.isQidianPrivateTroop(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.troopUin))
              {
                this.this$0.jdField_a_of_type_Alcn.cwc = false;
                this.this$0.a(this.this$0.jdField_a_of_type_Alcn.d, false);
                return;
              }
              this.this$0.jdField_a_of_type_Alcn.cwd = false;
              this.this$0.er.setVisibility(8);
              return;
            }
            this.this$0.ZM();
            if (paramObject.titleId == 0)
            {
              Object localObject = (TroopManager)this.this$0.app.getManager(52);
              if (localObject != null)
              {
                localObject = ((TroopManager)localObject).b(this.this$0.jdField_a_of_type_Alcn.troopUin, this.this$0.jdField_a_of_type_Alcn.d.uin);
                if (localObject != null)
                {
                  paramObject.titleId = ((TroopMemberInfo)localObject).level;
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, "onGetTroopMemberCard: server realLevel==0, useLocal=" + paramObject.titleId);
                  }
                }
              }
            }
            this.this$0.a(this.this$0.jdField_a_of_type_Alcn, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzm
 * JD-Core Version:    0.7.0.1
 */