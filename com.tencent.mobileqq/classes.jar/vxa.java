import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class vxa
  extends ConfessObserver
{
  public vxa(ConfessChatPie paramConfessChatPie) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (paramInt2 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel())
      {
        paramInt2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (paramString2 != null) {
          break label181;
        }
      }
    }
    label181:
    for (paramConfessInfo = "";; paramConfessInfo = paramString2)
    {
      QLog.i("Q.aio.ConfessChatPie", 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      this.a.aX();
      if ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
      {
        paramString1 = new StringBuilder();
        if (!paramBoolean) {
          break;
        }
      }
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1.append("屏蔽失败，请重试。");
      this.a.a(2, paramString1.toString(), 500);
      return;
    }
    paramString1.append("屏蔽失败，").append(paramString2);
    this.a.a(2, paramString1.toString(), 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxa
 * JD-Core Version:    0.7.0.1
 */