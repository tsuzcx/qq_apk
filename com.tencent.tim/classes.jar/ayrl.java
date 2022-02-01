import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.1;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.2;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.3;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.4;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.5;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.6;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager.7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ayrl
  implements Manager
{
  private List<RecentUser> ND = new ArrayList();
  private acso jdField_a_of_type_Acso;
  private ayrc jdField_a_of_type_Ayrc;
  private CopyOnWriteArrayList<ayrk> aC = new CopyOnWriteArrayList();
  private volatile boolean bKa;
  public volatile String cTF;
  private volatile String cUs;
  private volatile boolean dAt;
  public volatile boolean dAu;
  private int dCU = 0;
  private HashMap<String, String> jl;
  private Handler mHandler;
  
  private ayrl()
  {
    cOr();
  }
  
  public static ayrl a()
  {
    return ayrl.a.b();
  }
  
  private String a(RecentUser paramRecentUser)
  {
    String str1 = "";
    String str2;
    if ((paramRecentUser == null) || (this.jl == null) || (this.jl.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramRecentUser.getType())
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramRecentUser.displayName;
      str1 = (String)this.jl.get(paramRecentUser.uin + 0);
      continue;
      str1 = (String)this.jl.get(paramRecentUser.uin + 1);
      continue;
      str1 = this.jdField_a_of_type_Acso.jB(paramRecentUser.uin);
      continue;
      axyl.jS(paramRecentUser.troopUin, paramRecentUser.uin);
      continue;
      str1 = this.jdField_a_of_type_Acso.getDiscussMemberName(paramRecentUser.troopUin, paramRecentUser.uin);
    }
  }
  
  private void a(ayrk paramayrk, int paramInt1, int paramInt2)
  {
    int i = paramayrk.operateStatus;
    if (i == 1) {
      if ((paramInt1 == 1003) || (paramInt1 == 1007))
      {
        paramayrk.operateStatus = 3;
        paramayrk.progress = 100;
      }
    }
    while ((i != 0) || ((paramInt1 != 1003) && (paramInt1 != 1007)))
    {
      return;
      if ((paramInt1 == 1004) || (paramInt1 == 1005) || (paramInt1 == 1006))
      {
        paramayrk.operateStatus = 2;
        return;
      }
      paramayrk.progress = paramInt2;
      return;
    }
    paramayrk.operateStatus = 3;
    paramayrk.progress = 100;
  }
  
  private void cOr()
  {
    this.jdField_a_of_type_Acso = new acso();
    this.jdField_a_of_type_Acso.getAppInterface();
    this.mHandler = new Handler(Looper.getMainLooper());
    axyr.registerModule();
  }
  
  private void cOt()
  {
    this.jdField_a_of_type_Acso.c(0, this.jl);
    this.jdField_a_of_type_Acso.d(1, this.jl);
    this.bKa = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadNameList finish");
    }
    cOw();
  }
  
  private void cOw()
  {
    if ((this.dAt) && (this.bKa))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "conformAllData");
      }
      if ((this.ND == null) || (this.ND.size() <= 0)) {
        break label404;
      }
      localObject = new ArrayList();
      localIterator = this.ND.iterator();
      while (localIterator.hasNext())
      {
        localRecentUser = (RecentUser)localIterator.next();
        localayrk = new ayrk();
        localayrk.uin = localRecentUser.uin;
        localayrk.troopUin = localRecentUser.troopUin;
        if (localRecentUser.getType() == 1000)
        {
          localayrk.displayName = localRecentUser.displayName;
          ((List)localObject).add(localRecentUser);
        }
        for (;;)
        {
          if (localRecentUser.getType() == 1)
          {
            localPair = axyl.i(localRecentUser.uin);
            if (localPair != null)
            {
              if (((Boolean)localPair.first).booleanValue())
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                break;
                localayrk.displayName = a(localRecentUser);
                continue;
              }
              localayrk.isNewTroop = ((Boolean)localPair.second).booleanValue();
            }
          }
        }
        localayrk.messageType = localRecentUser.getType();
        if ((localRecentUser.getType() == 0) && (!TextUtils.isEmpty(localayrk.uin)) && ((TextUtils.isEmpty(localayrk.displayName)) || (localayrk.uin.equals(localayrk.displayName)))) {
          localayrk.displayName = axyl.dy(localayrk.uin);
        }
        this.aC.add(localayrk);
      }
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((RecentUser)((Iterator)localObject).next());
        }
      }
      if (this.ND != null) {
        this.ND.clear();
      }
      if (this.jl != null) {
        this.jl.clear();
      }
      if (this.jdField_a_of_type_Ayrc != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
        }
        this.dCU = 2;
        onLoadFinish();
      }
    }
    label404:
    while (this.jdField_a_of_type_Ayrc == null)
    {
      Object localObject;
      Iterator localIterator;
      RecentUser localRecentUser;
      ayrk localayrk;
      Pair localPair;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish recentUserList is empty");
    }
    this.dCU = 2;
    onLoadFinish();
  }
  
  private void cOx()
  {
    this.ND.clear();
    this.dCU = 0;
    this.dAt = false;
    this.bKa = false;
    if (this.jl != null)
    {
      this.jl.clear();
      this.jl = null;
    }
    if (this.aC != null) {
      this.aC.clear();
    }
  }
  
  private void eTm()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadPanelData");
    }
    if (this.jdField_a_of_type_Ayrc != null) {
      this.jdField_a_of_type_Ayrc.onLoadStart();
    }
    cOx();
    init();
    this.dCU = 1;
    try
    {
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.1(this));
      ThreadManager.getSubThreadHandler().post(new SendPanelManager.2(this));
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      while (this.jdField_a_of_type_Ayrc == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData exception = " + localException.getMessage());
      }
      this.dCU = 3;
      onLoadFinish();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Ayrc == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData OutOfMemoryError");
      }
      this.dCU = 3;
      onLoadFinish();
    }
  }
  
  private void eTn()
  {
    this.dAu = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).getBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true);
  }
  
  private void eTo()
  {
    oU(this.jdField_a_of_type_Acso.a(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
    eTp();
    this.dAt = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadRecentUserList finish");
    }
    cOw();
  }
  
  private void eTp()
  {
    if ((this.ND != null) && (this.ND.size() > 0))
    {
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      Object localObject3 = this.ND.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
        if (localRecentUser.showUpTime > 0L) {
          ((List)localObject2).add(localRecentUser);
        } else {
          ((List)localObject1).add(localRecentUser);
        }
      }
      this.ND.clear();
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new ayre());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          this.ND.add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new ayre());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.ND.add(localObject2);
        }
      }
    }
  }
  
  private boolean iG(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  private void init()
  {
    this.jl = new HashMap();
  }
  
  private void oU(List<RecentUser> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (iG(localRecentUser.getType())) {
          this.ND.add(localRecentUser);
        }
      }
    }
  }
  
  private void onLoadFinish()
  {
    if (this.jdField_a_of_type_Ayrc != null) {
      this.mHandler.post(new SendPanelManager.4(this));
    }
  }
  
  public String IB()
  {
    return this.cUs;
  }
  
  public void ZM(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).edit().putBoolean("send_panel_animation_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramBoolean).apply();
  }
  
  public void a(ayrc paramayrc)
  {
    this.jdField_a_of_type_Ayrc = paramayrc;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateOperateStatus uin is null");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Ayrc != null) && (this.aC != null) && (this.aC.size() > 0))
      {
        int j = this.aC.size();
        int i = 0;
        while (i < j)
        {
          ayrk localayrk = (ayrk)this.aC.get(i);
          if ((!TextUtils.isEmpty(localayrk.uin)) && (localayrk.uin.equals(paramString)) && (localayrk.messageType == paramInt1) && (localayrk.isSend))
          {
            a(localayrk, paramInt2, paramInt3);
            if (localayrk.uniseq <= 0L) {
              localayrk.uniseq = paramLong;
            }
            if (QLog.isColorLevel()) {
              QLog.i("SendPanelManager", 2, "updateOperateStatus operateStatus = " + localayrk.operateStatus + " ,progress = " + localayrk.progress + " ,position = " + i + ", uinseq:" + localayrk.uniseq);
            }
            this.mHandler.post(new SendPanelManager.6(this, i, localayrk));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void adE(String paramString)
  {
    this.cTF = paramString;
  }
  
  public void adF(String paramString)
  {
    this.cUs = paramString;
  }
  
  public void ap(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fileMd5 is null");
      }
    }
    for (;;)
    {
      return;
      if ((this.aC != null) && (this.aC.size() > 0))
      {
        paramString1 = this.aC.iterator();
        while (paramString1.hasNext()) {
          ((ayrk)paramString1.next()).fileMd5 = paramString2;
        }
      }
    }
  }
  
  public void b(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fail uin = " + paramString1 + " ,filePath = " + paramString2);
      }
      if (this.jdField_a_of_type_Ayrc != null) {
        this.jdField_a_of_type_Ayrc.eTk();
      }
      return;
    }
    Object localObject3 = null;
    Object localObject1 = null;
    int i = -1;
    int k = i;
    Object localObject2 = localObject3;
    int j;
    if (this.aC != null)
    {
      k = i;
      localObject2 = localObject3;
      if (this.aC.size() > 0)
      {
        int m = this.aC.size();
        j = 0;
        label127:
        k = i;
        localObject2 = localObject1;
        if (j < m)
        {
          localObject2 = (ayrk)this.aC.get(j);
          ((ayrk)localObject2).filePath = paramString2;
          ((ayrk)localObject2).thumbPath = paramString3;
          ((ayrk)localObject2).isVideo = paramBoolean;
          if ((TextUtils.isEmpty(((ayrk)localObject2).uin)) || (!((ayrk)localObject2).uin.equals(paramString1)) || (paramInt != ((ayrk)localObject2).messageType)) {
            break label389;
          }
          localObject1 = localObject2;
          i = j;
        }
      }
    }
    label389:
    for (;;)
    {
      j += 1;
      break label127;
      if (localObject2 != null)
      {
        ((ayrk)localObject2).operateStatus = 1;
        if (this.jdField_a_of_type_Ayrc != null) {
          this.mHandler.post(new SendPanelManager.7(this, k, (ayrk)localObject2));
        }
        if (paramBoolean) {
          axyl.a(((ayrk)localObject2).filePath, paramString3, (ayrk)localObject2, this.cTF, this.cUs);
        }
        for (;;)
        {
          ((ayrk)localObject2).isSend = true;
          alwx.a((ayrk)localObject2);
          axim.a().hg(((ayrk)localObject2).fileMd5, ((ayrk)localObject2).messageType);
          axiy.i("SendPanelManager", "【updateFilePath】messageType:" + ((ayrk)localObject2).messageType);
          ap(paramString1, paramInt, ((ayrk)localObject2).fileMd5);
          return;
          axyl.a(paramString2, (ayrk)localObject2, this.cTF, this.cUs);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SendPanelManager", 2, "updateFilePath can not find sendItemInfo");
      return;
    }
  }
  
  public List<ayrk> ib()
  {
    if ((this.aC != null) && (this.aC.size() > 0)) {
      return this.aC;
    }
    eTm();
    return null;
  }
  
  public void jX(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateTroopMemberName uin = " + paramString1 + " ,name = " + paramString2);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_Ayrc == null) || (this.aC == null) || (this.aC.size() <= 0)) {
          break;
        }
        int j = this.aC.size();
        int i = 0;
        while (i < j)
        {
          ayrk localayrk = (ayrk)this.aC.get(i);
          if ((!TextUtils.isEmpty(localayrk.uin)) && (localayrk.uin.equals(paramString1)) && (localayrk.messageType == 1000))
          {
            localayrk.displayName = paramString2;
            if (QLog.isColorLevel()) {
              QLog.e("SendPanelManager", 2, "updateTroopMemberName");
            }
            this.mHandler.post(new SendPanelManager.5(this, i, localayrk));
            return;
          }
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("SendPanelManager", 2, "updateTroopMemberName exception uin = " + paramString1 + " ,name = " + paramString2);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "onDestroy()");
    }
    cOx();
    if (this.jdField_a_of_type_Ayrc != null)
    {
      this.jdField_a_of_type_Ayrc.destroy();
      this.jdField_a_of_type_Ayrc = null;
    }
  }
  
  static class a
  {
    private static final ayrl a = new ayrl(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrl
 * JD-Core Version:    0.7.0.1
 */