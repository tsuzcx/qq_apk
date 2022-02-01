import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abky
  extends abkx
{
  public abky(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.priority = 99;
    if (paramQQAppInterface != null)
    {
      int i = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0).getInt("hire_priority", 99);
      if (i > this.priority) {
        this.priority = (i + 1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardDrawerStatus", 2, "[CardDrawerStatus] onCreate ");
    }
  }
  
  public static void DL(boolean paramBoolean)
  {
    Object localObject = abhh.o();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("CardDrawerStatus.VOICE_CONTROL", paramBoolean).commit();
        return;
      }
      QLog.e("CardDrawerStatus", 1, "[setVoicePermission] editor is null ");
      return;
    }
    QLog.e("CardDrawerStatus", 1, "[setVoicePermission] sp is null ");
  }
  
  public static boolean Yv()
  {
    SharedPreferences localSharedPreferences = abhh.o();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("CardDrawerStatus.VOICE_CONTROL", true);
    }
    QLog.e("CardDrawerStatus", 1, "[getVoicePermission] sp is null ");
    return true;
  }
  
  private void bY(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getUIHandler().post(new CardDrawerStatus.1(this, paramQQAppInterface));
  }
  
  public int b(abrs paramabrs, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramabrs == null) || (paramAppInterface == null) || (paramContext == null))
    {
      QLog.e("CardDrawerStatus", 1, "[onExecAction] null pointer");
      return 0;
    }
    if (!this.bDA) {
      return super.b(paramabrs, paramInt, paramAppInterface, paramContext);
    }
    paramContext = ((abhh)paramAppInterface.getManager(153)).a((QQAppInterface)paramAppInterface, paramAppInterface.getCurrentAccountUin(), new int[] { 2, 4 });
    if (paramContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardDrawerStatus", 2, new Object[] { "CardDrawerStatus onExecAction actionId:", Integer.valueOf(paramContext.actionId), ",actionType:", Integer.valueOf(paramContext.actionType) });
      }
      bY((QQAppInterface)paramAppInterface);
      abrj.a(paramabrs, 12, paramContext);
    }
    for (;;)
    {
      return 0;
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = -1;
      paramAppInterface.actionType = 0;
      abrj.a(paramabrs, 5, paramAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abky
 * JD-Core Version:    0.7.0.1
 */