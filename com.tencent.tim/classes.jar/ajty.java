import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajty
  extends apsy
{
  ajty(ajtx paramajtx, apsz paramapsz, long paramLong, apqk paramapqk, int paramInt) {}
  
  public void fp(String paramString, int paramInt)
  {
    int i = this.jdField_a_of_type_Apsz.jN(ajtx.a(this.b));
    if (QLog.isColorLevel()) {
      QLog.d(ajtx.access$100(), 2, "onGetExtraData() time =  " + (System.currentTimeMillis() - this.AG) + ", configURL = " + paramString + ", version:" + paramInt + ", oldVersion:" + i);
    }
    if ((paramInt <= i) && (snf.a(ajtx.a(this.b), ajtx.a(this.b)) != null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = new File(acbn.bmj);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = acbn.bmj + "troopGiftConfig.tmp";
    paramString = new aquz(paramString, new File((String)localObject));
    paramString.retryCount = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    this.jdField_a_of_type_Apqk.a().a(paramString, new ajtz(this, paramInt), localBundle);
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ajtx.access$100(), 2, "onError() time =  " + (System.currentTimeMillis() - this.AG) + ", errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajty
 * JD-Core Version:    0.7.0.1
 */