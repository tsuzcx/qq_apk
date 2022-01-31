import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xxi
  extends TroopObserver
{
  public xxi(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.a(this.a, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8)
    {
      if (paramInt2 != 0) {
        break label188;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member success");
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      if (!this.a.g)
      {
        paramInt1 = this.a.b();
        this.a.a(paramInt1 + 1);
        ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
      }
      if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false)))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.i.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(((ResultRecord)localIterator.next()).a);
        }
        this.a.a(true, Long.parseLong(paramString), localArrayList);
      }
    }
    return;
    label188:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramInt2);
    }
    SelectMemberActivity.a(this.a, paramInt2);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((paramBoolean) && (str.equals(this.a.c)))
    {
      this.a.jdField_a_of_type_Long = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + str + " get inviteNoAuthLimitNum = " + paramLong2);
      }
      if ((this.a.k >= this.a.jdField_a_of_type_Long) && (this.a.jdField_a_of_type_Long > 0L))
      {
        this.a.d.setVisibility(0);
        ReportController.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, TroopMemberUtil.a(this.a.app, this.a.app.getCurrentAccountUin(), str) + "", "", "");
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong, List paramList)
  {
    paramLong = String.valueOf(paramLong);
    if ((paramBoolean) && (paramLong.equals(this.a.c)))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.a.jdField_a_of_type_JavaUtilList.add(String.valueOf(localLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + paramLong + " get invitedUinList = " + paramList.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxi
 * JD-Core Version:    0.7.0.1
 */