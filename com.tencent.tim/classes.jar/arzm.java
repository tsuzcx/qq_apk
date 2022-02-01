import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.MyAppApi.11.1;
import com.tencent.open.downloadnew.MyAppApi.11.2;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import mqq.os.MqqHandler;

public class arzm
  implements arwy.a
{
  arzm(arzk paramarzk, arwy paramarwy, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle, long paramLong, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void G(String paramString, byte[] paramArrayOfByte)
  {
    arwt.d("TIME-STATISTIC", "onGetA1");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.11.1(this, paramArrayOfByte, paramString));
  }
  
  public void elT()
  {
    arwt.d("TIME-STATISTIC", "onGetA1Fail");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.11.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzm
 * JD-Core Version:    0.7.0.1
 */