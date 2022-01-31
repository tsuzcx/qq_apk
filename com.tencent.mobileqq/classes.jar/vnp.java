import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.widget.QQToast;

class vnp
  implements Runnable
{
  vnp(vnl paramvnl, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((ArkAppCenter)this.jdField_a_of_type_Vnl.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().b(this.jdField_a_of_type_JavaLangString, this.b);
    QQToast.a(this.jdField_a_of_type_Vnl.a.a.jdField_a_of_type_AndroidContentContext, "应用创建成功...", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */