import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class arrk
  implements OpenCardContainer.b
{
  public arrk(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void mq(long paramLong)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual vid=", Long.valueOf(paramLong) });
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.this$0.ic);
      this.this$0.jdField_b_of_type_CooperationQqfavUtilHandlerPlus.post(this.this$0.ic);
      return;
    }
    OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0), paramLong, this.this$0.jdField_b_of_type_Artd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrk
 * JD-Core Version:    0.7.0.1
 */