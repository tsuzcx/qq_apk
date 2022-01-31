import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.widget.QQToast;

class vqp
  implements Runnable
{
  vqp(vqn paramvqn, int paramInt) {}
  
  public void run()
  {
    ArkDebugChatPie.a(this.jdField_a_of_type_Vqn.a.a);
    if (this.jdField_a_of_type_Int == 1) {}
    for (String str = "(监听超时)";; str = "")
    {
      ((ArkAppCenter)this.jdField_a_of_type_Vqn.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().f();
      QQToast.a(this.jdField_a_of_type_Vqn.a.a.jdField_a_of_type_AndroidContentContext, String.format("连接已经关闭%s...", new Object[] { str }), 0).a();
      ArkDispatchTask.getInstance().postToMainThreadDelayed(new vqq(this), 60L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqp
 * JD-Core Version:    0.7.0.1
 */