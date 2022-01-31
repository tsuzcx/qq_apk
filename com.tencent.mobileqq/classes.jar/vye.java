import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class vye
  extends SosoInterface.OnLocationListener
{
  public vye(PublicAccountChatPie paramPublicAccountChatPie, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label206;
      }
    }
    label206:
    for (double d1 = paramSosoLbsInfo.a.a;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.a != null) {
          d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2 + ", address=" + str);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, d1, d2, str);
      }
      return;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vye
 * JD-Core Version:    0.7.0.1
 */