import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskInterface;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge;

public class yzd
  implements Runnable
{
  public yzd(SpriteDrawerInfoBridge paramSpriteDrawerInfoBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge) != null)
    {
      if (SpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge).a()) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.j = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.a = this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge;
      SpriteDrawerInfoBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoBridge).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yzd
 * JD-Core Version:    0.7.0.1
 */