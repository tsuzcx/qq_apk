import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class sks
  extends acnd
{
  public sks(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 9);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", paramString);
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.d.j(3, localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("TroopMngTest", 2, String.format("onGetTroopInfoResult [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
  }
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    paramList = new Bundle();
    paramList.putInt("type", 5);
    paramList.putBoolean("isSuccess", paramBoolean);
    paramList.putSerializable("data", new Object[] { paramString, null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(paramInt2) });
    paramList.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, paramList);
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 84);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("appid", paramInt1);
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putInt("seq", paramInt2);
    localBundle.putInt("retCode", paramInt3);
    localBundle.putString("uin", paramString3);
    if ((paramAllInOne != null) && ((!TextUtils.isEmpty(paramAllInOne.nickname)) || (!TextUtils.isEmpty(paramAllInOne.remark))))
    {
      paramBoolean = true;
      localBundle.putBoolean("isFriend", paramBoolean);
      if (paramAllInOne != null) {
        break label164;
      }
      paramString1 = "";
      label123:
      localBundle.putString("nickName", paramString1);
      if (paramAllInOne != null) {
        break label173;
      }
    }
    label164:
    label173:
    for (paramString1 = "";; paramString1 = paramAllInOne.remark)
    {
      localBundle.putString("remark", paramString1);
      this.d.j(60, localBundle);
      return;
      paramBoolean = false;
      break;
      paramString1 = paramAllInOne.nickname;
      break label123;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5)
  {
    paramString3 = new Bundle();
    paramString3.putInt("type", 71);
    paramString3.putBoolean("isSuccess", paramBoolean);
    paramString3.putInt("appid", paramInt1);
    paramString3.putString("openGroupId", paramString1);
    paramString3.putString("token", paramString2);
    paramString3.putInt("freq", paramInt2);
    paramString3.putInt("expireTime", paramInt3);
    paramString3.putStringArrayList("apilist", paramArrayList);
    paramString3.putInt("seq", paramInt4);
    paramString3.putInt("retCode", paramInt5);
    this.d.j(28, paramString3);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 12);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramTroopInfo });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.d.j(3, localBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 26);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramTroopInfo, Integer.valueOf(paramInt2), paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    paramTroopInfo = new awjk((QQAppInterface)TroopMemberApiService.b(this.d));
    paramString = PluginCommunicationHandler.getInstance();
    if (paramString != null) {
      paramString.register(paramTroopInfo);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", ((Integer)paramArrayOfObject[0]).intValue());
    paramTroopInfo.putString("processName", (String)paramArrayOfObject[1]);
    this.d.j(59, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (!"TroopMemberApiService111".equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = wja.a(new Intent(BaseApplication.getContext(), SplashActivity.class), new int[] { 2 });
      paramString.putExtra("uin", paramTroopInfo.troopuin);
      paramString.putExtra("uintype", 1);
      paramString.putExtra("uinname", paramTroopInfo.getTroopName());
      this.d.startActivity(paramString);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", this.d.bxD);
    paramTroopInfo.putString("callback", this.d.aEv);
    this.d.j(112, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 60);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), paramString2 });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    localBundle.putString("processName", paramString2);
    this.d.j(3, localBundle);
  }
  
  protected void bC(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 52);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
  
  protected void eE(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 6);
    localBundle.putBoolean("isSuccess", false);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
  
  protected void h(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 27);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
  
  protected void i(Boolean paramBoolean)
  {
    ArrayList localArrayList;
    if ((paramBoolean.booleanValue()) && (this.d.aLT))
    {
      paramBoolean = (aprp)TroopMemberApiService.a(this.d).getManager(109);
      localArrayList = new ArrayList();
      if (paramBoolean != null)
      {
        localObject = paramBoolean.b(false, 0);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label149;
        }
        localObject = ((List)localObject).iterator();
        TroopAIOAppInfo localTroopAIOAppInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
          localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
        } while (localTroopAIOAppInfo.appid != this.d.bxA);
        QQToast.a(BaseApplication.getContext(), 2, 2131721288, 0).show(this.d.getResources().getDimensionPixelSize(2131299627));
      }
    }
    return;
    label149:
    localArrayList.add(Integer.valueOf(this.d.bxA));
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(this.d.bxA));
    paramBoolean.o(localArrayList, (ArrayList)localObject);
  }
  
  protected void i(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 53);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
  
  protected void j(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.d.bxB);
    localBundle.putInt("type", 73);
    localBundle.putBoolean("isSuccess", paramBoolean.booleanValue());
    this.d.j(44, localBundle);
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 6);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(3));
    this.d.j(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sks
 * JD-Core Version:    0.7.0.1
 */