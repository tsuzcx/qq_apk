import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.TroopNickNameManager.2;
import com.tencent.biz.qqstory.model.TroopNickNameManager.3;
import com.tencent.biz.qqstory.model.TroopNickNameManager.4;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ptc
  implements psj
{
  public static final String auW = qem.auW;
  acms jdField_a_of_type_Acms;
  acnd jdField_a_of_type_Acnd = new ptd(this);
  public TroopManager a;
  QQAppInterface app;
  public Map<String, Long> fK;
  Map<String, Set<String>> fL;
  Handler mHandler = new Handler(ThreadManager.getSubThreadLooper());
  
  public static String ae(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public String a(QQUserUIItem paramQQUserUIItem, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return auW;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    if ((!TextUtils.isEmpty(paramQQUserUIItem.qq)) && (!TextUtils.isEmpty(paramString)))
    {
      TroopMemberInfo localTroopMemberInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString, paramQQUserUIItem.qq);
      if (localTroopMemberInfo != null)
      {
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
          return localTroopMemberInfo.troopnick;
        }
      }
      else {
        ThreadManager.post(new TroopNickNameManager.2(this, paramString, paramQQUserUIItem, paramBoolean1, paramBoolean2), 8, null, true);
      }
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public void a(QQUserUIItem paramQQUserUIItem, String paramString, boolean paramBoolean)
  {
    String str = ae(paramString, paramQQUserUIItem.qq);
    if (!this.fK.containsKey(str)) {
      cp(paramString, paramQQUserUIItem.qq);
    }
    if (paramBoolean) {
      flush();
    }
  }
  
  public void cp(String paramString1, String paramString2)
  {
    Set localSet = (Set)this.fL.get(paramString1);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.fL.put(paramString1, localObject);
    }
    ((Set)localObject).add(paramString2);
  }
  
  public void flush()
  {
    if (Looper.myLooper() != ThreadManager.getSubThreadLooper())
    {
      ThreadManager.executeOnSubThread(new TroopNickNameManager.3(this));
      return;
    }
    long l = System.currentTimeMillis();
    Iterator localIterator = this.fL.entrySet().iterator();
    int i = 0;
    Object localObject1;
    String str1;
    TroopInfo localTroopInfo;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        str1 = (String)((Map.Entry)localObject1).getKey();
        Object localObject2 = (Set)((Map.Entry)localObject1).getValue();
        localIterator.remove();
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(str1);
        if (localTroopInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNickNameManager", 2, "troopInfo not found:" + str1);
          }
        }
        else
        {
          localObject1 = new ArrayList(20);
          localObject2 = ((Set)localObject2).iterator();
          label167:
          if (((Iterator)localObject2).hasNext())
          {
            String str2 = (String)((Iterator)localObject2).next();
            this.fK.put(ae(str1, str2), Long.valueOf(l));
            ((ArrayList)localObject1).add(str2);
            if (((ArrayList)localObject1).size() < 20) {
              break label316;
            }
            this.jdField_a_of_type_Acms.b(str1, localTroopInfo.troopcode, (ArrayList)localObject1);
            localObject1 = new ArrayList(20);
            i = 1;
          }
        }
      }
    }
    label314:
    label316:
    for (;;)
    {
      break label167;
      if (((ArrayList)localObject1).size() > 0)
      {
        this.jdField_a_of_type_Acms.b(str1, localTroopInfo.troopcode, (ArrayList)localObject1);
        i = 1;
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label314;
        }
        this.mHandler.postDelayed(new TroopNickNameManager.4(this), 30000L);
        return;
      }
      break;
    }
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
    this.app = null;
  }
  
  public void onInit()
  {
    this.fK = new ConcurrentHashMap();
    this.fL = new ConcurrentHashMap();
    QQStoryContext.a();
    this.app = QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
    this.jdField_a_of_type_Acms = ((acms)this.app.getBusinessHandler(20));
    this.app.addObserver(this.jdField_a_of_type_Acnd);
  }
  
  public static class a
    extends plt
  {
    public String troopUin;
    public List<String> uinList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptc
 * JD-Core Version:    0.7.0.1
 */