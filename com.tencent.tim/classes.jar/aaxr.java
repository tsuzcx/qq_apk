import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aaxr
  extends acnd
{
  public aaxr(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, Long paramLong, List<Long> paramList)
  {
    paramLong = String.valueOf(paramLong);
    if ((paramBoolean) && (paramLong.equals(this.this$0.aRJ)))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.this$0.vA.add(String.valueOf(localLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + paramLong + " get invitedUinList = " + paramList.toString());
      }
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((paramBoolean) && (str.equals(this.this$0.aRJ)))
    {
      this.this$0.MQ = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + str + " get inviteNoAuthLimitNum = " + paramLong2);
      }
      if ((this.this$0.cmu >= this.this$0.MQ) && (this.this$0.MQ > 0L))
      {
        this.this$0.Aj.setVisibility(0);
        anot.a(this.this$0.app, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, jlk.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), str) + "", "", "");
      }
    }
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.a(this.this$0, paramInt2);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add troop member success");
        }
        this.this$0.mHandler.sendEmptyMessage(0);
        if (!this.this$0.bap)
        {
          paramInt1 = this.this$0.zs();
          this.this$0.GO(paramInt1 + 1);
          anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
        }
        ArrayList localArrayList = this.this$0.cg();
        this.this$0.mIntent.putExtra("roomId", Long.parseLong(paramString));
        this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.aQ);
        this.this$0.mIntent.putParcelableArrayListExtra("result_set_for_out_Member ", localArrayList);
        this.this$0.setResult(-1);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramInt2);
    }
    SelectMemberActivity.a(this.this$0, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxr
 * JD-Core Version:    0.7.0.1
 */