import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class aqlz
  implements Manager
{
  QQAppInterface app = null;
  long atb = 0L;
  boolean cUA = false;
  boolean cUy = false;
  boolean cUz = false;
  int dZS = 0;
  ConcurrentHashMap<String, Integer> iZ = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Integer> ja = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Boolean> jb = new ConcurrentHashMap();
  Lock lock;
  
  public aqlz(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.lock = new ReentrantLock();
  }
  
  public static void R(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = (aqlz)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.e("message.ring.care", Integer.valueOf(paramInt));
    }
  }
  
  public static String aK(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      paramString = "message.group.policy." + paramString;
    }
    do
    {
      return paramString;
      if (paramInt == 2) {
        return "message.group.ring";
      }
      if (paramInt == 3) {
        return "message.group.vibrate";
      }
      if (paramInt == 4) {
        return "message.ring.switch";
      }
      if (paramInt == 5) {
        return "message.vibrate.switch";
      }
      if (paramInt == 6) {
        return "sync.c2c_message";
      }
      if (paramInt == 7) {
        return "message.ring.care";
      }
    } while (paramInt != 8);
    return "message.push_detail";
  }
  
  public static void af(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = (aqlz)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 1;; i = 0)
    {
      paramQQAppInterface.e("message.push_detail", Integer.valueOf(i));
      return;
    }
  }
  
  public static int ai(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aqlz)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.as("message.ring.care", 0);
    }
    return 0;
  }
  
  public static boolean ca(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aqlz)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {}
    for (int i = paramQQAppInterface.as("message.push_detail", 1);; i = 1) {
      return i == 1;
    }
  }
  
  private void eek()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "uploadNewValue...");
    }
    Object localObject;
    if ((this.app == null) || (!this.app.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("uploadNewValue return directly, app.isRunning=");
        if (this.app != null) {
          break label75;
        }
        localObject = "null";
        QLog.d("RoamSetting", 2, localObject);
      }
    }
    label75:
    label205:
    do
    {
      do
      {
        return;
        localObject = Boolean.valueOf(this.app.isRunning());
        break;
        if (this.cUz)
        {
          if ((this.atb <= 0L) || (this.atb + 45000L >= System.currentTimeMillis())) {
            break label205;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "uploadNewValue state_allLoading=" + this.cUz + " more than 45s, forced to stop");
          }
          this.atb = 0L;
          this.cUz = false;
        }
        eel();
        localObject = (FriendListHandler)this.app.getBusinessHandler(1);
      } while (localObject == null);
      ((FriendListHandler)localObject).a(a().getRevision(), this.ja);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "uploadNewValue but return, state_allLoading=" + this.cUz + ", time_allLoading less than 60s, waitting...");
  }
  
  private void eel()
  {
    this.lock.lock();
    try
    {
      this.ja.putAll(this.iZ);
      this.iZ.clear();
      this.cUA = false;
      this.lock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "copyNewValue2Uploading, change state_newValue=false, mapUploading:" + this.ja.toString());
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void eem()
  {
    this.lock.lock();
    try
    {
      this.ja.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public static int fk(String paramString)
  {
    if (paramString.contains("message.group.policy.")) {
      return 1;
    }
    if (paramString.contains("message.group.ring")) {
      return 2;
    }
    if (paramString.contains("message.group.vibrate")) {
      return 3;
    }
    if (paramString.contains("message.ring.switch")) {
      return 4;
    }
    if (paramString.contains("message.vibrate.switch")) {
      return 5;
    }
    if (paramString.contains("sync.c2c_message")) {
      return 6;
    }
    if (paramString.contains("message.ring.care")) {
      return 7;
    }
    if (paramString.contains("message.push_detail")) {
      return 8;
    }
    return -1;
  }
  
  acld a()
  {
    return (acld)this.app.getManager(40);
  }
  
  public Map<String, Integer> a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new HashMap();
    }
    Map localMap = aqgx.a().a(paramList, paramInt, this.app);
    this.lock.lock();
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          str = (String)paramList.next();
          StringBuilder localStringBuilder = new StringBuilder(40);
          localStringBuilder.append("message.group.policy.");
          localStringBuilder.append(str);
          str = localStringBuilder.toString();
          if (this.iZ.containsKey(str))
          {
            localMap.put(str, Integer.valueOf(((Integer)this.iZ.get(str)).intValue()));
            continue;
          }
        }
      }
      catch (OutOfMemoryError paramList)
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.e("RoamSetting", 2, "getTroopMsgFilterList OutOfMemoryError");
        }
        return localMap;
        if (!this.ja.containsKey(str)) {
          continue;
        }
        localMap.put(str, Integer.valueOf(((Integer)this.ja.get(str)).intValue()));
        continue;
      }
      finally
      {
        this.lock.unlock();
      }
      this.lock.unlock();
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadRoamSettingsByPage,localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    if (paramFriendListHandler == null) {
      paramFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    }
    for (;;)
    {
      paramFriendListHandler.a(paramInt1, paramLong, paramInt2, paramBoolean);
      this.atb = System.currentTimeMillis();
      return;
    }
  }
  
  public void a(boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if ((this.app == null) || (!this.app.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("loadAllRoamSetting return directly, app.isRunning=");
        if (this.app != null) {
          break label64;
        }
        paramFriendListHandler = "null";
        QLog.d("RoamSetting", 2, paramFriendListHandler);
      }
    }
    label64:
    do
    {
      return;
      paramFriendListHandler = Boolean.valueOf(this.app.isRunning());
      break;
      if (!this.cUz) {
        break label121;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "loadAllRoamSettings but return, state_allUpdating=" + this.cUz);
    return;
    label121:
    this.cUz = true;
    int i = a().getRevision();
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadAllRoamSettings, localRevision=" + i + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    a(i, 0L, -1, paramBoolean, paramFriendListHandler);
  }
  
  public boolean aEU()
  {
    return this.dZS < 3;
  }
  
  public int ar(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return ((Integer)a(localArrayList, paramInt).get(paramString)).intValue();
  }
  
  public int as(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    this.lock.lock();
    try
    {
      if (this.iZ.containsKey(paramString))
      {
        paramInt = ((Integer)this.iZ.get(paramString)).intValue();
        return paramInt;
      }
      if (this.ja.containsKey(paramString))
      {
        paramInt = ((Integer)this.ja.get(paramString)).intValue();
        return paramInt;
      }
      return a().U(paramString, paramInt);
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void bH(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onUploadRomingSettingsFinish isSuccess=" + paramBoolean1 + " reload=" + paramBoolean2);
    }
    eem();
    if ((paramBoolean1) && (paramBoolean2)) {
      a(true, null);
    }
  }
  
  public void cA(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onGetAllSettingsFinish isSucc=" + paramBoolean1 + " next=" + paramBoolean2);
    }
    this.cUz = false;
    this.atb = 0L;
    if ((paramBoolean2) && (this.cUA)) {
      eek();
    }
  }
  
  public void e(String paramString, Integer paramInteger)
  {
    this.cUA = true;
    this.dZS = 0;
    this.lock.lock();
    try
    {
      this.iZ.put(paramString, paramInteger);
      this.lock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "state_newValue=" + this.cUA + " setRoamSettingNewValue, path=" + paramString + " value=" + paramInteger + " uploadingCount=" + this.dZS);
      }
      eek();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlz
 * JD-Core Version:    0.7.0.1
 */