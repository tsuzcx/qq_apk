import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ablc
  extends abkx
{
  int actionId;
  boolean bDB;
  long expireTime;
  long toUin;
  String wording;
  
  public ablc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0);
    this.priority = paramQQAppInterface.getInt("hire_priority", 1);
    this.actionId = paramQQAppInterface.getInt("hire_action", 0);
    this.wording = paramQQAppInterface.getString("hire_word", "");
    this.toUin = paramQQAppInterface.getLong("hire_for", 0L);
    this.expireTime = paramQQAppInterface.getLong("hire_end", 0L);
  }
  
  public int b(abrs paramabrs, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if ((NetConnInfoCenter.getServerTime() > this.expireTime) || (this.bDB) || (!this.bDA)) {
      return super.b(paramabrs, paramInt, paramAppInterface, paramContext);
    }
    if (this.actionId > 0)
    {
      if (ApolloUtil.aH(5, this.actionId))
      {
        paramContext = new ApolloActionData();
        paramContext.actionId = this.actionId;
        paramContext.actionType = 0;
        abrj.a(paramabrs, 6, paramContext);
        this.bDB = true;
        paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
        return 0;
      }
      QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus resource is not ready, actionId:" + this.actionId);
      super.b(paramabrs, paramInt, paramAppInterface, paramContext);
      abto.b(paramAppInterface, ApolloUtil.dr(this.actionId) + "/d.zip", ApolloUtil.ds(this.actionId));
      return 0;
    }
    QLog.w("AplloDrawerStatus", 2, "HireDrawerStatus action is not correct, actionId:" + this.actionId);
    super.b(paramabrs, paramInt, paramAppInterface, paramContext);
    paramAppInterface.getApp().getSharedPreferences("apollo_sp" + paramAppInterface.getCurrentAccountUin(), 0).edit().putLong("hire_end", NetConnInfoCenter.getServerTime()).commit();
    return 0;
  }
  
  public void b(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!this.bDA) {}
    boolean bool;
    do
    {
      return;
      bool = paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("hire_bubble_click", false);
    } while ((NetConnInfoCenter.getServerTime() > this.expireTime) || (bool));
    this.bDz = true;
    abrj.a(paramabrs, this.wording, 7, 0);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F001", 0, 0, new String[] { String.valueOf(this.actionId) });
  }
  
  public void bZ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences("apollo_sp" + paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean("hire_bubble_click", true).commit();
  }
  
  public void c(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramabrs = new Intent();
    paramabrs.putExtra("extra_key_url_append", "&tab=interactive&suin=" + paramQQAppInterface.getCurrentAccountUin());
    ApolloUtil.a(paramContext, paramabrs, "drawer", abxi.bjv, null);
    bZ(paramQQAppInterface);
    VipUtils.a(null, "cmshow", "Apollo", "0X80065F002", 0, 0, new String[] { String.valueOf(this.actionId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablc
 * JD-Core Version:    0.7.0.1
 */