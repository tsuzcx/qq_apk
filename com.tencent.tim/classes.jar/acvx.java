import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.hce.HcePluginInstallActivity;
import java.util.HashMap;

public class acvx
  extends acuk
{
  public acvx(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean acG()
  {
    Intent localIntent = new Intent(this.context, HcePluginInstallActivity.class);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean ace()
  {
    try
    {
      if ((this.attrs.containsKey("from_type")) && (!aqmr.isEmpty((String)this.attrs.get("from_type"))) && ("2".equals(this.attrs.get("from_type"))))
      {
        boolean bool = acG();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletToBuscardAction", 1, "doAction error: " + localException.getMessage());
      Ge("QwalletToBuscardAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvx
 * JD-Core Version:    0.7.0.1
 */