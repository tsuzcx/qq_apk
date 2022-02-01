import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.topentry.CardViewController.2;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zbx
{
  private SharedPreferences B;
  private long KT;
  private acfd jdField_a_of_type_Acfd;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private acff jdField_b_of_type_Acff;
  private zbx.a jdField_b_of_type_Zbx$a;
  private final Object bW = new Object();
  private achg d;
  private QQAppInterface mApp;
  private ArrayList<MayKnowRecommend> rx;
  
  public zbx(QQAppInterface paramQQAppInterface, zbx.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "CardViewController create");
    }
    this.mApp = paramQQAppInterface;
    this.d = ((achg)this.mApp.getManager(159));
    this.jdField_b_of_type_Acff = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.mApp.getBusinessHandler(1));
    this.jdField_b_of_type_Zbx$a = parama;
    this.jdField_a_of_type_Acfd = new zby(this);
    this.rx = new ArrayList();
    this.mApp.addObserver(this.jdField_a_of_type_Acfd);
  }
  
  private void EZ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "decreaseCurrentDelCount " + paramInt);
    }
    int i = yc();
    SharedPreferences.Editor localEditor = b();
    i -= paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    localEditor.putInt("CardViewControllerdelete_count", paramInt);
    if (paramInt == 0) {
      localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    }
    localEditor.apply();
  }
  
  private boolean Vi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "isTimeToUpdateMKRDataFromNetwork");
    }
    return this.d.iv(2);
  }
  
  private boolean a(MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend != null)
    {
      if (!this.jdField_b_of_type_Acff.isFriend(paramMayKnowRecommend.uin))
      {
        boolean bool = this.jdField_b_of_type_Acff.b(paramMayKnowRecommend.uin, false, true);
        if (bool) {}
        for (int i = 1;; i = 0)
        {
          paramMayKnowRecommend.friendStatus = i;
          if (bool) {
            break;
          }
          return true;
        }
        return false;
      }
      paramMayKnowRecommend.friendStatus = 2;
    }
    return false;
  }
  
  private SharedPreferences.Editor b()
  {
    return l().edit();
  }
  
  private ArrayList<MayKnowRecommend> bX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "calcDisplayingMKRList");
    }
    ArrayList localArrayList1 = bY();
    int k = yb();
    int j = localArrayList1.size();
    ArrayList localArrayList2 = new ArrayList(k);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = eD();
    int i = 0;
    if ((i >= j) || (localArrayList2.size() >= k))
    {
      label68:
      i = 0;
      localArrayList1.removeAll(localArrayList2);
      j = localArrayList1.size() - 1;
      if ((j < 0) || (localArrayList2.size() >= k))
      {
        if ((i == 0) || (yb() == 2)) {
          break label241;
        }
        cnX();
        return bX();
      }
    }
    else
    {
      localMayKnowRecommend = (MayKnowRecommend)localArrayList1.get(i);
      if (a(localMayKnowRecommend))
      {
        if ((localMayKnowRecommend.cardDisplayTimestamp + l2 <= l1) || (c(localMayKnowRecommend.uin, localArrayList2))) {
          break label183;
        }
        localArrayList2.add(localMayKnowRecommend);
      }
      for (;;)
      {
        i += 1;
        break;
        label183:
        if (localMayKnowRecommend.cardDisplayTimestamp != 0L) {
          break label68;
        }
        localArrayList2.add(localMayKnowRecommend);
      }
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localArrayList1.get(j);
    if (a(localMayKnowRecommend))
    {
      localArrayList2.add(localMayKnowRecommend);
      i = 1;
    }
    for (;;)
    {
      j -= 1;
      break;
      label241:
      return localArrayList2;
    }
  }
  
  private ArrayList<MayKnowRecommend> bY()
  {
    ArrayList localArrayList = this.d.cw();
    Collections.sort(localArrayList, new zbz(this));
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getOrderedMKRListFromLocal = " + localArrayList);
    }
    return localArrayList;
  }
  
  private void bk(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "reallyCheckLocalUpdate, fromNetwork = " + paramBoolean1 + ", isSuccess = " + paramBoolean2);
    }
    ThreadManagerV2.excute(new CardViewController.2(this), 16, null, true);
  }
  
  private boolean c(String paramString, List<MayKnowRecommend> paramList)
  {
    if ((paramString != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramList.next();
        if ((localMayKnowRecommend != null) && (paramString.equals(localMayKnowRecommend.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void cnX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "resetCurrentDelCount");
    }
    SharedPreferences.Editor localEditor = b();
    localEditor.putInt("CardViewControllerdelete_count", 0);
    localEditor.putLong("CardViewControllerdisplay_not_2", 0L);
    localEditor.apply();
  }
  
  private void cnY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "increaseCurrentDelCount");
    }
    int i = yc();
    SharedPreferences.Editor localEditor = b();
    i += 1;
    localEditor.putInt("CardViewControllerdelete_count", i);
    if (i == 1) {
      localEditor.putLong("CardViewControllerdisplay_not_2", NetConnInfoCenter.getServerTimeMillis());
    }
    localEditor.apply();
  }
  
  private void dg(ArrayList<MayKnowRecommend> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ??? = new ArrayList(2);
      long l1 = eD();
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)((Iterator)localObject2).next();
        if (localMayKnowRecommend != null) {
          ((List)???).add(localMayKnowRecommend.uin);
        }
      }
      this.d.a((List)???, l2, l1, true);
      ??? = paramArrayList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (MayKnowRecommend)((Iterator)???).next();
        if ((localObject2 != null) && (((MayKnowRecommend)localObject2).cardDisplayTimestamp + l1 < l2)) {
          ((MayKnowRecommend)localObject2).cardDisplayTimestamp = l2;
        }
      }
    }
    gZ(paramArrayList);
    synchronized (this.bW)
    {
      this.rx.clear();
      if (paramArrayList != null) {
        this.rx.addAll(paramArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "displayMayKnowList done");
      }
      return;
    }
  }
  
  private long eD()
  {
    long l = this.d.B(2);
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCardDisplayInterval = " + l);
    }
    return l;
  }
  
  private void gZ(List<MayKnowRecommend> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshCardData: ");
      if (paramList != null) {
        break label53;
      }
    }
    label53:
    for (String str = "NULL";; str = paramList.toString())
    {
      QLog.d("CardViewController", 2, str);
      this.jdField_b_of_type_Zbx$a.gY(paramList);
      return;
    }
  }
  
  private SharedPreferences l()
  {
    if (this.B == null) {
      this.B = BaseApplicationImpl.getApplication().getSharedPreferences("CardViewControllermay_know_sp" + this.mApp.getCurrentAccountUin(), 0);
    }
    return this.B;
  }
  
  private boolean x(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getMKRDataFromNetwork");
    }
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getMKRDataFromNetwork when network error, abort");
      }
      return false;
    }
    return this.d.e(2, paramBundle);
  }
  
  private int yb()
  {
    long l1 = l().getLong("CardViewControllerdisplay_not_2", 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 + eD() < l2) {
      cnX();
    }
    int j = 2 - yc();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "loadCardSize = " + i);
    }
    return i;
  }
  
  private int yc()
  {
    int i = 0;
    int j = l().getInt("CardViewControllerdelete_count", 0);
    if (j < 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "loadCurrentDelCount = " + i);
      }
      return i;
      i = j;
    }
  }
  
  public ArrayList<MayKnowRecommend> bW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "getCurrentDisplayingMKRList");
    }
    ArrayList localArrayList = new ArrayList();
    if (yb() == 0) {}
    for (;;)
    {
      return localArrayList;
      int i = 0;
      int j = 0;
      Object localObject2;
      if (this.rx != null)
      {
        localObject2 = this.bW;
        i = j;
      }
      try
      {
        if (this.rx != null)
        {
          i = j;
          if (!this.rx.isEmpty())
          {
            localArrayList.addAll(this.rx);
            i = 1;
          }
        }
        if (i != 0) {
          continue;
        }
        localObject2 = bX();
        dg((ArrayList)localObject2);
        localArrayList.addAll((Collection)localObject2);
        return localArrayList;
      }
      finally {}
    }
  }
  
  public void checkUpdate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate");
    }
    if (this.jdField_b_of_type_Zbx$a.Vg())
    {
      if (Vi())
      {
        int i;
        if (System.currentTimeMillis() - this.KT > 1800000L)
        {
          i = 1;
          if (i == 0) {
            break label124;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("from", "fetch");
          if (x(localBundle)) {
            break label108;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed or network error [1]\"");
          }
          bk(false, true);
        }
        label108:
        while (!QLog.isColorLevel())
        {
          return;
          i = 0;
          break;
        }
        QLog.d("CardViewController", 2, "do network checkUpdate. msg: \"send network request done\"");
        return;
        label124:
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Update too frequently, network update is not allowed\"");
        }
        bk(false, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "do local checkUpdate. msg: \"Time is not up, network update is not allowed [2]\"");
      }
      bk(false, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "try checkUpdate， closed");
    }
    dg(null);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
  }
  
  public void zt(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "deleteMayKnowRecommend, uin = " + paramString);
    }
    cnY();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.DK(paramString);
  }
  
  public static abstract interface a
  {
    public abstract boolean Vg();
    
    public abstract void gY(List<MayKnowRecommend> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbx
 * JD-Core Version:    0.7.0.1
 */