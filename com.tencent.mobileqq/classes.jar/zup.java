import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public class zup
  extends ProtoUtils.TroopProtocolObserver
{
  public zup(TroopHandler paramTroopHandler, String paramString1, String paramString2) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(6, true, new Object[] { Integer.valueOf(8), Integer.valueOf(0), this.jdField_a_of_type_JavaLangString });
      paramArrayOfByte = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b.getManager(51)).b(this.jdField_a_of_type_JavaLangString);
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.hasSetTroopHead())) {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b(Long.parseLong(this.b));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(6, false, new Object[] { Integer.valueOf(8), Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zup
 * JD-Core Version:    0.7.0.1
 */