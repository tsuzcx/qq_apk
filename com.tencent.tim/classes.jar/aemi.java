import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aemi
  extends aehv<aemh>
{
  public static void r(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_msg_btn_is_show", paramInt);
    paramContext.apply();
  }
  
  public static int v(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_msg_btn_is_show", 0);
  }
  
  @NonNull
  public aemh a(int paramInt)
  {
    return new aemh(0);
  }
  
  @Nullable
  public aemh a(aeic[] paramArrayOfaeic)
  {
    j = 0;
    i = j;
    if (paramArrayOfaeic != null)
    {
      i = j;
      if (paramArrayOfaeic.length > 0) {
        paramArrayOfaeic = paramArrayOfaeic[0].content;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfaeic);
      }
      i = new JSONObject(paramArrayOfaeic).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfaeic)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfaeic);
          i = j;
        }
      }
    }
    return new aemh(i);
  }
  
  public void a(aemh paramaemh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramaemh.cNN);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    r(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramaemh.cNN);
  }
  
  public Class clazz()
  {
    return aemh.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 439;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemi
 * JD-Core Version:    0.7.0.1
 */