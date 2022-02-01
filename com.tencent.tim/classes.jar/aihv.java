import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class aihv
  implements Manager
{
  aoif b = new aihw(this);
  String bNM = "mqqapi://miniapp/open?_atype=0&_mappid=1109894538&_mvid=&_path=pages%2Findex%2Findex&_vt=3&_sig=71cba9e2ab0f0e779a62ecf6705e0f5cf65a4f764d755e8fc07b537e655c70ad";
  IVPluginDataReporter d;
  HashMap<Integer, aihd> ll = new HashMap();
  Map<String, NewTogetherRoomMessageData> lv = new HashMap();
  QQAppInterface mApp;
  
  public aihv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    a(2, (aicu)this.mApp.getManager(236));
    a(1, (aifl)this.mApp.getManager(306));
    this.d = new IVPluginDataReporter();
  }
  
  private NewTogetherRoomMessageData a(WatchTogetherSession paramWatchTogetherSession)
  {
    if (paramWatchTogetherSession == null) {
      return null;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.ddo = paramWatchTogetherSession.roomType;
    localNewTogetherRoomMessageData.QD = paramWatchTogetherSession.uin;
    localNewTogetherRoomMessageData.aif = paramWatchTogetherSession.aif;
    localNewTogetherRoomMessageData.wV = paramWatchTogetherSession.jumpurl;
    localNewTogetherRoomMessageData.abz = paramWatchTogetherSession.roomId;
    localNewTogetherRoomMessageData.roomName = paramWatchTogetherSession.roomName;
    Object localObject = Uri.parse(paramWatchTogetherSession.jumpurl);
    paramWatchTogetherSession = ((Uri)localObject).getQueryParameter("roomid");
    String str1 = ((Uri)localObject).getQueryParameter("room_show_number");
    String str2 = ((Uri)localObject).getQueryParameter("fromid");
    localObject = ((Uri)localObject).getQueryParameter("room_group_code");
    if (!TextUtils.isEmpty(paramWatchTogetherSession)) {
      localNewTogetherRoomMessageData.abz = Integer.parseInt(paramWatchTogetherSession);
    }
    if (!TextUtils.isEmpty(str1)) {
      localNewTogetherRoomMessageData.ddp = Integer.parseInt(str1);
    }
    localNewTogetherRoomMessageData.bNI = ((String)localObject);
    localNewTogetherRoomMessageData.bNJ = str2;
    return localNewTogetherRoomMessageData;
  }
  
  private long am(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.lv.get(paramString);
    if (paramString != null) {
      return paramString.abz;
    }
    return 0L;
  }
  
  private String d(Bundle paramBundle, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  troopUin is null");
      return "";
    }
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  from extrainfo ownerUin=" + (String)localObject);
    }
    for (;;)
    {
      QLog.i("WatchTogetherManager", 1, "getTroopOwnerUin  extraInfo = " + paramBundle + ";troopUin=" + paramString + ";ownerUin=" + (String)localObject);
      return localObject;
      if (this.mApp != null)
      {
        localObject = ((TroopManager)this.mApp.getManager(52)).b(paramString);
        if (localObject != null)
        {
          localObject = ((TroopInfo)localObject).troopowneruin;
          continue;
        }
      }
      localObject = "";
    }
  }
  
  private int dn(String paramString)
  {
    paramString = (NewTogetherRoomMessageData)this.lv.get(paramString);
    if (paramString != null) {
      return paramString.ddo;
    }
    return 0;
  }
  
  private void f(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if ((paramNewTogetherRoomMessageData.ddq == paramNewTogetherRoomMessageData.ddo) || (paramNewTogetherRoomMessageData.ddq == 0))
    {
      b(paramNewTogetherRoomMessageData.QD, paramNewTogetherRoomMessageData);
      g(paramNewTogetherRoomMessageData);
    }
    Bundle localBundle;
    aihd localaihd;
    do
    {
      return;
      b(paramNewTogetherRoomMessageData.QD, paramNewTogetherRoomMessageData);
      localBundle = new Bundle();
      localBundle.putString("close_reason", "switch_room");
      localBundle.putInt("old_room_type", paramNewTogetherRoomMessageData.ddq);
      localBundle.putInt("new_room_type", paramNewTogetherRoomMessageData.ddo);
      localaihd = (aihd)this.ll.get(Integer.valueOf(paramNewTogetherRoomMessageData.ddq));
    } while (localaihd == null);
    localaihd.b(paramNewTogetherRoomMessageData, localBundle, new aihy(this));
  }
  
  private void g(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.ll.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (aihd)this.ll.get(localObject);
      if (localObject != null)
      {
        localObject = ((aihd)localObject).b();
        if (localObject != null) {
          ((aihg)localObject).b(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void h(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    Iterator localIterator = this.ll.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (aihd)this.ll.get(localObject);
      if (localObject != null)
      {
        localObject = ((aihd)localObject).b();
        if (localObject != null) {
          ((aihg)localObject).c(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  private void i(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    b(paramNewTogetherRoomMessageData.QD, paramNewTogetherRoomMessageData);
    Iterator localIterator = this.ll.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      aihd localaihd = (aihd)this.ll.get(localObject);
      if (localaihd != null)
      {
        if (((Integer)localObject).intValue() == paramNewTogetherRoomMessageData.ddo)
        {
          QLog.i("WatchTogetherManager", 1, "preload roomtype =  " + paramNewTogetherRoomMessageData.ddo);
          paramNewTogetherRoomMessageData.bNJ = "101";
          localaihd.d(paramNewTogetherRoomMessageData);
        }
        localObject = localaihd.b();
        if (localObject != null) {
          ((aihg)localObject).a(paramNewTogetherRoomMessageData);
        }
      }
    }
  }
  
  public void PQ(int paramInt)
  {
    this.ll.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, aihd paramaihd)
  {
    this.ll.put(Integer.valueOf(paramInt), paramaihd);
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, int paramInt)
  {
    QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushActionType = " + paramInt);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.bNH = paramWatchTogetherSession.ckN;
    localNewTogetherRoomMessageData.QD = paramWatchTogetherSession.uin;
    localNewTogetherRoomMessageData.ddo = paramWatchTogetherSession.roomType;
    localNewTogetherRoomMessageData.abz = paramWatchTogetherSession.roomId;
    localNewTogetherRoomMessageData.ddq = dn(paramWatchTogetherSession.uin);
    localNewTogetherRoomMessageData.wV = paramWatchTogetherSession.jumpurl;
    localNewTogetherRoomMessageData.roomName = paramWatchTogetherSession.roomName;
    localNewTogetherRoomMessageData.aif = paramWatchTogetherSession.aif;
    localNewTogetherRoomMessageData.abA = am(paramWatchTogetherSession.uin);
    QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  pushContent = " + localNewTogetherRoomMessageData.toString());
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 1: 
      i(localNewTogetherRoomMessageData);
      return;
    case 5: 
      f(localNewTogetherRoomMessageData);
      return;
    }
    h(localNewTogetherRoomMessageData);
  }
  
  public void a(WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null)
    {
      arxa.a().showToast("watchTogetherSession == null!");
      return;
    }
    paramWatchTogetherSession = a(paramWatchTogetherSession);
    paramWatchTogetherSession.bNH = d(paramBundle, paramWatchTogetherSession.QD);
    e(paramWatchTogetherSession);
  }
  
  public void a(String paramString, int paramInt, WatchTogetherSession paramWatchTogetherSession)
  {
    aihd localaihd = (aihd)this.ll.get(Integer.valueOf(paramInt));
    if (localaihd == null)
    {
      QLog.i("WatchTogetherManager", 1, "preloadBizRoom  fail!  roomtype is not registered");
      return;
    }
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = a(paramWatchTogetherSession);
    paramWatchTogetherSession = localNewTogetherRoomMessageData;
    if (localNewTogetherRoomMessageData == null)
    {
      paramWatchTogetherSession = new NewTogetherRoomMessageData();
      paramWatchTogetherSession.bNJ = paramString;
    }
    paramWatchTogetherSession.bNH = d(null, paramWatchTogetherSession.QD);
    QLog.i("WatchTogetherManager", 1, "preloadRoom  roomtype = " + paramInt);
    localaihd.d(paramWatchTogetherSession);
  }
  
  public void a(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    boolean bool1 = this.mApp.getCurrentAccountUin().equals(paramNewTogetherRoomMessageData.bNH);
    boolean bool2 = apuh.g(this.mApp, paramNewTogetherRoomMessageData.QD, this.mApp.getCurrentAccountUin());
    a(paramString, paramNewTogetherRoomMessageData.QD, paramNewTogetherRoomMessageData.bNH, Boolean.valueOf(bool1).booleanValue(), Boolean.valueOf(bool2).booleanValue());
  }
  
  public void a(String paramString, WatchTogetherSession paramWatchTogetherSession, Bundle paramBundle)
  {
    if (paramWatchTogetherSession == null) {
      return;
    }
    boolean bool1;
    boolean bool2;
    if (paramBundle != null)
    {
      bool1 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER");
      bool2 = paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN");
      paramBundle = d(paramBundle, paramWatchTogetherSession.uin);
      a(paramString, paramWatchTogetherSession.uin, paramBundle, bool1, bool2);
      paramString = this.d.opDepartment("intervideo").opName("open_together_miniapp").opType(String.valueOf(paramWatchTogetherSession.roomType)).d1(paramWatchTogetherSession.uin).d2(paramBundle).d3(paramString);
      if (!bool1) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      paramString.opIn(i).report();
      return;
      bool1 = apuh.f(this.mApp, paramWatchTogetherSession.uin, this.mApp.getCurrentAccountUin());
      bool2 = apuh.g(this.mApp, paramWatchTogetherSession.uin, this.mApp.getCurrentAccountUin());
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(paramString3)) {
      if (paramBoolean1)
      {
        paramString3 = this.mApp.getCurrentUin();
        localStringBuilder = new StringBuilder(this.bNM);
        localStringBuilder.append("&group_uin=" + paramString2);
        localStringBuilder.append("&user_uin=" + this.mApp.getCurrentAccountUin());
        localStringBuilder.append("&source_id=" + paramString1);
        localStringBuilder.append("&owner_uin=" + paramString3);
        localStringBuilder.append("&isowner=");
        if (!paramBoolean1) {
          break label279;
        }
        paramString1 = "1";
        label164:
        localStringBuilder.append(paramString1);
        localStringBuilder.append("&isadmain=");
        if (!paramBoolean2) {
          break label286;
        }
        paramString1 = "1";
        label189:
        localStringBuilder.append(paramString1);
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty("3.4.4")) {
          break label452;
        }
        paramString1 = "3.4.4".split("\\.");
        if (paramString1.length <= 0) {
          break label452;
        }
        int j = 0;
        i = j;
        if (k < paramString1.length)
        {
          if (k == 0)
          {
            i = Integer.parseInt(paramString1[k]);
            i = j + i * 100000;
            k += 1;
            j = i;
            continue;
            paramString3 = "0";
            break;
            label279:
            paramString1 = "0";
            break label164;
            label286:
            paramString1 = "0";
            break label189;
          }
          if (k == 1)
          {
            i = j + Integer.parseInt(paramString1[k]) * 100;
            continue;
          }
          i = j;
          if (k != 2) {
            continue;
          }
          i = j + Integer.parseInt(paramString1[k]);
          continue;
        }
        localStringBuilder.append("&versioncode=" + i);
      }
      catch (Exception paramString1)
      {
        localStringBuilder.append("&versioncode=0");
        continue;
      }
      QLog.i("WatchTogetherManager", 1, "openMiniAPP  scheme = " + localStringBuilder.toString());
      paramString1 = new Intent();
      paramString1.setData(Uri.parse(localStringBuilder.toString()));
      paramString1.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString1);
      return;
      break;
      label452:
      int i = 0;
    }
  }
  
  public void b(String paramString, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    this.lv.put(paramString, paramNewTogetherRoomMessageData);
  }
  
  public void dsy()
  {
    this.mApp.addObserver(this.b);
  }
  
  public void e(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    if (paramNewTogetherRoomMessageData == null) {
      arxa.a().showToast("roomInfo is null!");
    }
    label277:
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramNewTogetherRoomMessageData.bNH)) || (TextUtils.isEmpty(paramNewTogetherRoomMessageData.QD)))
      {
        arxa.a().showToast("group info is null!");
        return;
      }
      if ((paramNewTogetherRoomMessageData.ddo != 2) && (paramNewTogetherRoomMessageData.ddo != 1))
      {
        arxa.a().showToast("invalid roomtype!");
        return;
      }
      boolean bool = this.mApp.getCurrentAccountUin().equals(paramNewTogetherRoomMessageData.bNH);
      Object localObject = this.d.opDepartment("intervideo").opName("open_together_room_entry").opType(String.valueOf(paramNewTogetherRoomMessageData.ddo)).d1(paramNewTogetherRoomMessageData.QD).d2(paramNewTogetherRoomMessageData.bNH).d3(paramNewTogetherRoomMessageData.bNJ).d4(String.valueOf(paramNewTogetherRoomMessageData.abz));
      int i;
      if (Boolean.valueOf(bool).booleanValue())
      {
        i = 1;
        ((IVPluginDataReporter)localObject).opIn(i).report();
        QLog.i("WatchTogetherManager", 1, "openWatchTogetherRoom  roominfo = " + paramNewTogetherRoomMessageData.toString());
        if (paramNewTogetherRoomMessageData.ddo != 2) {
          break label246;
        }
        localObject = (aihd)this.ll.get(Integer.valueOf(2));
      }
      for (;;)
      {
        if (localObject == null) {
          break label277;
        }
        ((aihd)localObject).a(paramNewTogetherRoomMessageData, null, new aihx(this));
        return;
        i = 0;
        break;
        label246:
        if (paramNewTogetherRoomMessageData.ddo == 1) {
          localObject = (aihd)this.ll.get(Integer.valueOf(1));
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.ll.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihv
 * JD-Core Version:    0.7.0.1
 */