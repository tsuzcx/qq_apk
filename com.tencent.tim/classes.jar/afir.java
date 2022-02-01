import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import org.json.JSONObject;

public class afir
  extends kdz
{
  public afir(MessengerService paramMessengerService) {}
  
  public void M(Object paramObject)
  {
    if (this.a.aC != null)
    {
      this.a.aC.putString("data", aqec.convert2JSON(paramObject).toString());
      this.a.cp(this.a.aC);
      this.a.aC = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afir
 * JD-Core Version:    0.7.0.1
 */