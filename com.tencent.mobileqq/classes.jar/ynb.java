import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class ynb
  implements Runnable
{
  public ynb(CmGameAvHandler paramCmGameAvHandler, Boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      if (CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).size() > 0)
      {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      localObject = ((QQAppInterface)localObject).c();
      CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler, (String[])CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).toArray(new String[CmGameAvHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameAvHandler).size()]), (String)localObject);
      return;
      AVManager.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new ync(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynb
 * JD-Core Version:    0.7.0.1
 */