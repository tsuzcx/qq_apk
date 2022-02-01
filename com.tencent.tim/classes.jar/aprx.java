import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class aprx
  extends acnd
{
  public aprx(TroopBatchAddFriendMgr paramTroopBatchAddFriendMgr) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = (Long)this.this$0.iR.get(paramString);
    if ((localObject == null) || (((Long)localObject).longValue() == 0L)) {
      break label31;
    }
    label31:
    while (!apwn.ml(paramInt2)) {
      return;
    }
    if (paramBoolean)
    {
      paramInt1 = 1;
      label47:
      if (paramList != null) {
        break label224;
      }
    }
    label224:
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onUpdateTroopGetMemberList suc_troopUin_type_ts=%d_%s_%d_%d_%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(i) }));
      if (((Long)localObject).longValue() != paramLong) {
        break;
      }
      paramList = (Long)this.this$0.iR.remove(paramString);
      if (!paramBoolean) {
        break label235;
      }
      paramList = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
      localObject = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.this$0.app.getCurrentAccountUin(), paramString });
      paramList.edit().putLong((String)localObject, paramLong).apply();
      TroopBatchAddFriendMgr.a(this.this$0, paramString, true, paramLong, 2);
      return;
      paramInt1 = 0;
      break label47;
    }
    label235:
    this.this$0.s(paramString, paramLong, paramInt2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onBAFSecurityCheckResult suc_result_troopUin_type_ts=%b_%d_%s_%d_%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong) }));
    }
    if (!apwn.ml(paramInt2)) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      TroopBatchAddFriendMgr.a(this.this$0, paramString1, true, paramLong, 1);
      return;
    }
    this.this$0.s(paramString1, paramLong, paramInt2);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, int paramInt)
  {
    if (!apwn.ml(paramInt)) {}
    Long localLong;
    do
    {
      return;
      localLong = (Long)this.this$0.iR.remove(paramString);
      TroopBatchAddFriendMgr.a(this.this$0, paramString, false, paramLong, 0);
    } while (!QLog.isColorLevel());
    if (localLong == null) {}
    for (long l = 0L;; l = localLong.longValue())
    {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchAddFrdsDataPrepareErr troopUin_ts_type_reqTs=%s_%d_%d_%d", new Object[] { paramString, Long.valueOf(l), Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2)
  {
    Object localObject = (Long)this.this$0.iR.get(paramString);
    if ((localObject == null) || (((Long)localObject).longValue() == 0L)) {}
    do
    {
      do
      {
        return;
      } while (!apwn.ml(paramInt));
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchGetMemberRemark suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(((Long)localObject).longValue()), Boolean.valueOf(paramBoolean2) }));
      }
    } while (paramLong != ((Long)localObject).longValue());
    localObject = (Long)this.this$0.iR.remove(paramString);
    if (paramBoolean1)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
      String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remarks", this.this$0.app.getCurrentAccountUin(), paramString });
      ((SharedPreferences)localObject).edit().putLong(str, paramLong).apply();
    }
    TroopBatchAddFriendMgr.a(this.this$0, paramString, true, paramLong, 5);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList)
  {
    paramString2 = (Long)this.this$0.iR.get(paramString1);
    if ((paramString2 == null) || (paramString2.longValue() == 0L)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!apwn.ml(paramInt));
        if (QLog.isColorLevel()) {
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onTroopBatchReqMemberCmnFrds suc_troopUin_type_ts_curTs_bInc=%b_%s_%d_%d_%d_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong), Long.valueOf(paramString2.longValue()), Boolean.valueOf(paramBoolean3) }));
        }
      } while (paramLong != paramString2.longValue());
      if ((paramBoolean2) || (!paramBoolean1)) {
        paramString2 = (Long)this.this$0.iR.remove(paramString1);
      }
      if (!paramBoolean1)
      {
        this.this$0.s(paramString1, paramLong, paramInt);
        return;
      }
    } while ((!paramBoolean1) || (!paramBoolean2));
    paramString2 = PreferenceManager.getDefaultSharedPreferences(this.this$0.app.getApp());
    paramHashMap = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_cmnfrds", this.this$0.app.getCurrentAccountUin(), paramString1 });
    paramString2.edit().putLong(paramHashMap, paramLong).apply();
    TroopBatchAddFriendMgr.a(this.this$0, paramString1, true, paramLong, 3);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if (!Long.toString(101509131L).equalsIgnoreCase(paramString2)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onChangeTroopAIORedPoint clear active suc_troopUin_appid_from0x8c2 %b_%s_%s_%b", new Object[] { Boolean.valueOf(paramBoolean1), paramString1, paramString2, Boolean.valueOf(paramBoolean2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprx
 * JD-Core Version:    0.7.0.1
 */