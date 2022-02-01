import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeqw
  extends aeqp<aeqv>
{
  @NonNull
  public aeqv a()
  {
    return new aeqv();
  }
  
  @NonNull
  public aeqv a(aeic[] paramArrayOfaeic)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramArrayOfaeic.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfaeic[i].content;
        if (QLog.isColorLevel()) {
          QLog.i("PushOpenNotify", 2, "config :" + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          acsv.e(localQQAppInterface, str, false);
          PreferenceManager.getDefaultSharedPreferences(localQQAppInterface.getApp()).edit().putString(localQQAppInterface.getCurrentUin() + "_" + "push_open_notify_xml", str).commit();
        }
      }
      else
      {
        return new aeqv();
      }
      i += 1;
    }
  }
  
  @NonNull
  public aeqv b()
  {
    return new aeqv();
  }
  
  public Class<aeqv> clazz()
  {
    return aeqv.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 95;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqw
 * JD-Core Version:    0.7.0.1
 */