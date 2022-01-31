import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskInterface;

public class ysa
  implements Runnable
{
  public ysa(SpriteBridge paramSpriteBridge, SpriteTaskParam paramSpriteTaskParam) {}
  
  public void run()
  {
    if (SpriteBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge) != null)
    {
      if (SpriteBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge).a()) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.j = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.a = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge;
      SpriteBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysa
 * JD-Core Version:    0.7.0.1
 */