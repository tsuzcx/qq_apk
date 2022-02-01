import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog.1.1.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ajtz
  extends aquy
{
  ajtz(ajty paramajty, int paramInt) {}
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz.errCode == 0) {
      localObject = paramaquz.getParams().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        paramaquz = new File((String)localObject);
        String str = aqhq.readFileToString(paramaquz);
        if (QLog.isColorLevel()) {
          QLog.d(ajtx.access$100(), 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new snf(new JSONObject(str), "");
          ((snf)localObject).X(ajtx.a(this.a.b), ajtx.a(this.a.b));
          this.a.a.jX(this.Un, ajtx.a(this.a.b));
          if (ajtx.a(this.a.b) != null) {
            ajtx.a(this.a.b).post(new NearbyGiftPanelDialog.1.1.1(this, (snf)localObject));
          }
          paramaquz.deleteOnExit();
        }
        return;
      }
      catch (IOException paramaquz)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(ajtx.access$100(), 2, QLog.getStackTraceString(paramaquz));
        return;
      }
      catch (JSONException paramaquz)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(ajtx.access$100(), 2, QLog.getStackTraceString(paramaquz));
        return;
      }
    }
    QLog.d(ajtx.access$100(), 2, "onError() time =  " + (System.currentTimeMillis() - this.a.AG) + ", errorCode = " + paramaquz.errCode);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtz
 * JD-Core Version:    0.7.0.1
 */