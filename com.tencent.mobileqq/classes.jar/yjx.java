import android.app.Activity;
import com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class yjx
  implements Runnable
{
  public yjx(ApolloGameNormalStartHandler paramApolloGameNormalStartHandler, int paramInt1, int paramInt2, int paramInt3, QQAppInterface paramQQAppInterface, String paramString1, int paramInt4, String paramString2, Activity paramActivity) {}
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "normalStart", 0L, 7, this.jdField_b_of_type_Int, this.c, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaLangString, this.d);
    localStartCheckParam.extendJson = this.jdField_b_of_type_JavaLangString;
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidAppActivity, localStartCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjx
 * JD-Core Version:    0.7.0.1
 */