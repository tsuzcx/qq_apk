import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afla
{
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = ((acle)paramQQAppInterface.getBusinessHandler(13)).AX();
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonContentProvider", 2, "call, vipType = " + i);
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt(paramString, i);
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     afla
 * JD-Core Version:    0.7.0.1
 */