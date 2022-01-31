import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class boa
  extends TroopObserver
{
  public boa(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerFailed, reqtype:" + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 9)) {
      this.a.a(1, this.a.getString(2131363675));
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eResignGroupReq result:" + paramByte + " troopUin:" + paramString);
      }
      if (paramByte == 0) {
        this.a.a(5, 2131363674, 1000);
      }
    }
    while (paramInt != 9)
    {
      return;
      this.a.a(1, this.a.getString(2131363675));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onTroopManagerSuccess, reqtype:_eDeleteGroupReq result:" + paramByte + " troopUin:" + paramString);
    }
    if (paramByte == 0)
    {
      this.a.a(5, 2131363674, 1000);
      return;
    }
    this.a.a(1, this.a.getString(2131363675));
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      this.a.a(2, this.a.getString(2131362854));
      this.a.a(1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    this.a.a(1, this.a.getString(2131362855));
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      TroopMemberCardActivity.a(this.a);
      ((TroopGagMgr)this.a.app.getManager(42)).a(this.a.c, this.a.e);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        l = ((Long)paramObject[0]).longValue();
        i = ((Integer)paramObject[1]).intValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (l != Long.parseLong(this.a.c))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + l + "!=" + this.a.c);
          }
        }
        else if (paramObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: cardInfo==null");
        }
      }
    }
    catch (Exception paramObject)
    {
      long l;
      int i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard:" + paramObject.toString());
        return;
        l = paramObject.memberUin;
        if (l != Long.parseLong(this.a.e))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + l + "!=" + this.a.e);
          }
        }
        else {
          this.a.a(i, paramObject);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong)
  {
    if (paramString.equalsIgnoreCase("OidbSvc.0x8bb_2"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onOperateSpecialFocus, CMD_ADD_SPECIAL_FOCUS, isSuccess:" + paramBoolean + " cmd:" + paramString + " errorCode:" + paramInt);
      }
      if (paramBoolean)
      {
        this.a.a(2, this.a.getString(2131363725));
        this.a.a(0);
        paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[3];
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = this.a.a(this.a.c, this.a.e);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {
          break label368;
        }
        this.a.a(paramString, this.a.getString(2131363724), true);
        paramString.setContentDescription(this.a.getString(2131363620) + this.a.getString(2131363724));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onOperateSpecialFocus, isMemberSpecialFocus:" + this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned);
      }
      return;
      this.a.a(1, this.a.getString(2131363726));
      break;
      if (!paramString.equalsIgnoreCase("OidbSvc.0x8bb_3")) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onOperateSpecialFocus, CMD_DELETE_SPECIAL_FOCUS, isSuccess:" + paramBoolean + " cmd:" + paramString + " errorCode:" + paramInt);
      }
      if (paramBoolean)
      {
        this.a.a(2, this.a.getString(2131363728));
        this.a.a(0);
        break;
      }
      this.a.a(1, this.a.getString(2131363729));
      break;
      label368:
      paramString.setContentDescription(this.a.getString(2131363620) + this.a.getString(2131363727));
      this.a.a(paramString, this.a.getString(2131363727), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     boa
 * JD-Core Version:    0.7.0.1
 */