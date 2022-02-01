import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.a;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yso
  extends acfd
{
  public yso(NewFriendMoreSysMsgSuspiciousFragment.a parama) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt);
    }
    if (paramBoolean)
    {
      QQToast.a(NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0), acfp.m(2131709030), 0).show();
      NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0, paramLong);
      this.this$0.refreshData();
      return;
    }
    QQToast.a(NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0), acfp.m(2131709051), 0).show();
  }
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousDel " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if (paramBoolean) {
      this.this$0.refreshData();
    }
  }
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousGetList " + paramBoolean + " " + paramInt + " " + paramObject);
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Integer))
      {
        paramInt = ((Integer)paramObject).intValue();
        NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null) {
        NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0, NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0) + paramArrayList.size());
      }
      this.this$0.refreshData();
    }
  }
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousSendReadReport " + paramBoolean + " " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yso
 * JD-Core Version:    0.7.0.1
 */