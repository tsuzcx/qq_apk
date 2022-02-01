import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Locale;
import mqq.manager.AccountManager;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class yfq
  implements achs.a, toj
{
  private final yfq.a a = new yfq.a(null);
  private Activity activity;
  private QQAppInterface app;
  private achs jdField_b_of_type_Achs;
  private final yfq.a jdField_b_of_type_Yfq$a = new yfq.a(null);
  private boolean bmj;
  private boolean bmk;
  private boolean bml;
  private boolean bmm;
  private boolean bmn;
  private final yfq.a c = new yfq.a(null);
  private boolean cancel;
  private final yfq.a d = new yfq.a(null);
  private aclh jdField_e_of_type_Aclh = new yfr(this);
  private final yfq.a jdField_e_of_type_Yfq$a = new yfq.a(null);
  private final yfq.a f = new yfq.a(null);
  private boolean init;
  private Calendar m;
  private List<ChatMessage> records;
  private String uin;
  
  public yfq(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    this.app = paramQQAppInterface;
    this.activity = paramActivity;
    this.uin = paramString;
  }
  
  private void DS(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    RoamDate localRoamDate = this.jdField_b_of_type_Achs.a().a(this.uin, localCalendar.get(1), localCalendar.get(2) + 1);
    if (localRoamDate != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "update today's roam date");
      }
      localRoamDate.setLocState(localCalendar.get(5) - 1, paramInt);
    }
  }
  
  @Nullable
  private List<ChatMessage> E(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_Achs.b();
      if (localObject != null) {
        break label87;
      }
    }
    label87:
    for (long l1 = 0L;; l1 = ((Calendar)localObject).getTimeInMillis())
    {
      QLog.d("C2CMsgRoamProxy", 2, "getHistorySync, current date: " + l1 + ", type: " + paramInt);
      register();
      this.bml = true;
      this.records = null;
      if (!this.cancel) {
        break;
      }
      QLog.w("C2CMsgRoamProxy", 1, "get roam msg canceled");
      return null;
    }
    if (this.jdField_b_of_type_Achs.b() == null)
    {
      QLog.e("C2CMsgRoamProxy", 1, "current page date is null, show roam flag: " + this.jdField_b_of_type_Achs.aaT());
      return null;
    }
    Object localObject = this.jdField_b_of_type_Achs.a(paramInt);
    if ((localObject != null) && (((RoamMessagePreloadInfo)localObject).curday != null))
    {
      l1 = SystemClock.uptimeMillis();
      this.a.init();
      this.jdField_b_of_type_Achs.a(((RoamMessagePreloadInfo)localObject).curday, null, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySig wait");
      }
      this.a.by(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySync cost: " + (l2 - l1));
      }
    }
    for (;;)
    {
      this.m = this.jdField_b_of_type_Achs.b();
      return this.records;
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "preload info is null");
      }
    }
  }
  
  private boolean Tr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "isDevOpened");
    }
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = aqiw.isNetSupport(BaseApplication.getContext());
    chS();
    boolean bool2 = this.jdField_b_of_type_Achs.aaX();
    if ((!bool1) || (!bool2)) {
      return false;
    }
    if (!this.jdField_b_of_type_Achs.aaV())
    {
      Tu();
      if (this.jdField_b_of_type_Achs.aaV()) {
        zV(false);
      }
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "isDevOpened cost: " + (l2 - l1) + ", ret: " + this.bmn);
      }
      return this.bmn;
      this.bmn = false;
      continue;
      zV(false);
    }
  }
  
  private boolean Ts()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync");
    }
    boolean bool1;
    if (this.bmj) {
      bool1 = this.bmk;
    }
    long l1;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
        return bool1;
        register();
        l1 = SystemClock.uptimeMillis();
        bool3 = aqiw.isNetSupport(BaseApplication.getContext());
        chS();
        bool4 = this.jdField_b_of_type_Achs.aaX();
        bool1 = bool2;
      } while (!bool3);
      bool1 = bool2;
    } while (!bool4);
    zU(false);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync cost: " + (l2 - l1));
    }
    return this.bmk;
  }
  
  private boolean Tt()
  {
    return this.bmk;
  }
  
  private boolean Tu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync");
    }
    Object localObject = this.app;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "getAuthModeSync after destroy");
      return false;
    }
    localObject = (aczx)((QQAppInterface)localObject).getBusinessHandler(59);
    if (localObject != null)
    {
      long l1 = SystemClock.uptimeMillis();
      this.d.init();
      ((aczx)localObject).cPt();
      this.d.by(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync cost: " + (l2 - l1));
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "hasGetAuthMode false hanlder is null");
    }
    return false;
  }
  
  private boolean Tv()
  {
    Object localObject2 = this.jdField_b_of_type_Achs.d();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.m;
    }
    if (this.jdField_b_of_type_Achs.c() == null)
    {
      QLog.e("C2CMsgRoamProxy", 1, "can not get first page date, roam flag: " + this.jdField_b_of_type_Achs.aaT());
      return true;
    }
    long l = this.jdField_b_of_type_Achs.c().getTimeInMillis();
    while (((Calendar)localObject1).getTimeInMillis() >= l)
    {
      int i = ((Calendar)localObject1).get(5);
      localObject2 = this.jdField_b_of_type_Achs.a().a(this.uin, ((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("C2CMsgRoamProxy", 2, "roam date cache is null: " + ((Calendar)localObject1).getTimeInMillis());
        }
        ((Calendar)localObject1).set(5, 1);
        ((Calendar)localObject1).add(5, -1);
        b((Calendar)localObject1);
      }
      else
      {
        this.jdField_b_of_type_Achs.aG(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), i);
        int j = ((RoamDate)localObject2).getLocState(i - 1);
        int k = ((RoamDate)localObject2).getSerState(i - 1);
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "ser: " + k + ", local: " + j + ", day: " + i);
        }
        if ((k == 2) && ((j == 1) || (j == 2) || (j == 0)))
        {
          ((Calendar)localObject1).add(5, 1);
          this.jdField_b_of_type_Achs.aG(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.m = this.jdField_b_of_type_Achs.b();
          return false;
        }
        ((Calendar)localObject1).add(5, -1);
      }
    }
    return this.bmk;
  }
  
  private int a(String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "canGetRoamMsg app is null");
      return 0;
    }
    if (localQQAppInterface.a().oR(paramString))
    {
      if (localQQAppInterface.a(paramInt).K(paramString, paramInt) + paramArrayList.size() < 15)
      {
        QLog.d("C2CMsgRoamProxy", 1, "can't get roam msg");
        return 0;
      }
      localQQAppInterface.a().Qo(paramString);
      return 1;
    }
    return 2;
  }
  
  @Nullable
  private List<ChatMessage> a(List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord)
  {
    Object localObject = E(1);
    if (localObject == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator2.next();
          if (top.a(localMessageRecord, localChatMessage, true)) {
            localArrayList.add(localChatMessage);
          }
        }
      }
      ((List)localObject).removeAll(localArrayList);
      if ((((List)localObject).size() > 0) && (paramMessageRecord != null) && (ahwb.aB(paramMessageRecord)) && (((ChatMessage)((List)localObject).get(0)).time >= paramMessageRecord.time))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "roam msg is later than top revoke msg. revoke msg time: " + paramMessageRecord.time + ", top msg time: " + ((ChatMessage)((List)localObject).get(0)).time);
        }
        try
        {
          Thread.sleep(200L);
          localObject = new ArrayList((Collection)localObject);
          paramMessageRecord = a(paramList, paramLong, paramMessageRecord);
          paramList = (List<MessageRecord>)localObject;
          if (paramMessageRecord != null)
          {
            ((List)localObject).addAll(0, paramMessageRecord);
            return localObject;
          }
        }
        catch (InterruptedException localInterruptedException2)
        {
          for (;;)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
    }
    if ((((List)localObject).size() == 0) || ((paramLong != 0L) && (((ChatMessage)((List)localObject).get(0)).time >= paramLong)) || ((paramLong == 0L) && (paramMessageRecord != null) && (((ChatMessage)((List)localObject).get(0)).time >= paramMessageRecord.time)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("get duplicate msg, try again. break time: ").append(paramLong).append(", top msg time: ");
        if (((List)localObject).size() != 0) {
          break label428;
        }
        localObject = "";
      }
      for (;;)
      {
        QLog.d("C2CMsgRoamProxy", 2, localObject);
        try
        {
          Thread.sleep(200L);
          return a(paramList, paramLong, paramMessageRecord);
          label428:
          localObject = Long.valueOf(((ChatMessage)((List)localObject).get(0)).time);
        }
        catch (InterruptedException localInterruptedException1)
        {
          for (;;)
          {
            QLog.e("C2CMsgRoamProxy", 1, localInterruptedException1, new Object[0]);
          }
        }
      }
    }
    return localInterruptedException1;
  }
  
  private void a(String paramString, int paramInt1, ArrayList<MessageRecord> paramArrayList, int paramInt2, long paramLong, Calendar paramCalendar)
  {
    if (paramArrayList.size() > 0) {}
    for (long l1 = ((MessageRecord)paramArrayList.get(0)).time;; l1 = paramLong)
    {
      long l2 = paramCalendar.getTimeInMillis() / 1000L;
      QLog.d("C2CMsgRoamProxy", 1, "query local msg from " + l1 + " to " + l2);
      if ((paramLong >= 0L) && (paramLong > l2))
      {
        paramString = this.app.a(paramInt1).a(paramString, paramInt1, l1, paramInt2, String.format(Locale.getDefault(), "time>=%d", new Object[] { Long.valueOf(l2) }));
        if ((paramString.size() > 0) && (QLog.isColorLevel())) {
          QLog.d("C2CMsgRoamProxy", 2, "query local msg size: " + paramString.size() + ", first msg: " + ((MessageRecord)paramString.get(0)).toString());
        }
        paramArrayList.addAll(0, paramString);
      }
      return;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    paramObject = (List)paramObject;
    paramQQAppInterface = (achs)paramQQAppInterface.getManager(92);
    if ((paramObject == null) || (paramObject.size() == 0))
    {
      if (((paramQQAppInterface.aaS()) && (paramQQAppInterface.AC() == 3)) || ((paramQQAppInterface.isFirstPage()) && (paramQQAppInterface.AC() == 2)) || ((paramQQAppInterface.isFirstPage()) && ((paramQQAppInterface.AC() == 0) || (paramQQAppInterface.AC() == 1)))) {
        return true;
      }
      if (paramQQAppInterface.AC() != 4)
      {
        if (this.bml)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMsgRoamProxy", 2, "query success, continue");
          }
          paramQQAppInterface.cKD();
          return false;
        }
        return true;
      }
    }
    else
    {
      if (paramQQAppInterface.AC() == 4) {}
      this.bml = false;
    }
    paramQQAppInterface.cKE();
    this.records = paramObject;
    return true;
  }
  
  private Calendar b()
  {
    return this.jdField_b_of_type_Achs.b();
  }
  
  private void b(Calendar paramCalendar)
  {
    this.jdField_b_of_type_Achs.aG(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    this.m = this.jdField_b_of_type_Achs.b();
  }
  
  private void bd(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (achs)paramQQAppInterface.getManager(92);
    if (((paramQQAppInterface.aaS()) && (paramQQAppInterface.AC() == 3)) || ((paramQQAppInterface.isFirstPage()) && (paramQQAppInterface.AC() == 2)) || ((paramQQAppInterface.isFirstPage()) && ((paramQQAppInterface.AC() == 0) || (paramQQAppInterface.AC() == 1)))) {}
    while ((paramQQAppInterface.AC() == 4) || (!this.bml) || (paramQQAppInterface.AC() != 2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "query failed, continue");
    }
    paramQQAppInterface.cKD();
  }
  
  private void c(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramMessageRecord != null) && (paramInt == 2))
    {
      DS(3);
      return;
    }
    DS(0);
  }
  
  private void chS()
  {
    if (this.jdField_b_of_type_Achs.aaY()) {}
    long l1;
    long l2;
    do
    {
      return;
      QQAppInterface localQQAppInterface = this.app;
      if (localQQAppInterface == null)
      {
        QLog.d("C2CMsgRoamProxy", 1, "syncRoamType after destroy");
        return;
      }
      l1 = SystemClock.uptimeMillis();
      ((BaseActivity)this.activity).addObserver(this.jdField_e_of_type_Aclh);
      aqrb localaqrb = (aqrb)localQQAppInterface.getBusinessHandler(71);
      this.c.init();
      localaqrb.a(new String[] { localQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
      this.c.Tw();
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("C2CMsgRoamProxy", 2, "syncRoamType cost: " + (l2 - l1));
  }
  
  private void g(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.bmj = true;
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramInt1) });
      }
      this.jdField_b_of_type_Yfq$a.chT();
      return;
      if (paramInt2 == -1) {}
      for (;;)
      {
        this.bmk = false;
        break;
        QQToast.a(this.activity, this.activity.getString(2131694325), 0).show();
      }
      this.bmk = false;
      continue;
      this.bmk = true;
    }
  }
  
  private void h(int paramInt1, int paramInt2, Object paramObject) {}
  
  private void i(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "handleRoamMessageRsp, what: " + paramInt1);
    }
    Object localObject = this.app;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleRoamMessageRsp after destroy");
      this.a.chT();
      return;
    }
    localObject = (achs)((QQAppInterface)localObject).getManager(92);
    Calendar localCalendar;
    if (paramObject != null)
    {
      localCalendar = Calendar.getInstance();
      paramObject = (Long)paramObject;
      if (paramInt2 != 1) {
        break label179;
      }
    }
    label179:
    for (int i = 1;; i = 0)
    {
      localCalendar.setTimeInMillis(paramObject.longValue() * 1000L);
      if (i == 0) {
        ((achs)localObject).a(localCalendar, false);
      }
      switch (paramInt1)
      {
      case 3: 
      default: 
        return;
      case 0: 
        QLog.e("C2CMsgRoamProxy", 2, new Exception("handleRoamMessageRsp"), new Object[0]);
        ((achs)localObject).cKA();
        return;
      }
    }
    if (paramInt2 == -1) {}
    for (;;)
    {
      ((achs)localObject).cKA();
      return;
      paramObject = ((achs)localObject).b();
      if (paramObject != null) {
        QQToast.a(this.activity, this.activity.getString(2131694327, new Object[] { Integer.valueOf(paramObject.get(2) + 1), Integer.valueOf(paramObject.get(5)) }), 0).show();
      }
    }
    ((achs)localObject).cKA();
  }
  
  private void init(boolean paramBoolean)
  {
    Object localObject1 = this.app;
    if ((!this.init) || (paramBoolean)) {
      try
      {
        if ((!this.init) || (paramBoolean))
        {
          if (localObject1 == null)
          {
            QLog.d("C2CMsgRoamProxy", 1, "init after destroy");
            return;
          }
          this.jdField_b_of_type_Achs = ((achs)((QQAppInterface)localObject1).getManager(92));
          this.jdField_b_of_type_Achs.ad(this.uin, false);
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
          this.jdField_b_of_type_Achs.aG(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.m = this.jdField_b_of_type_Achs.b();
          this.init = true;
        }
        return;
      }
      finally {}
    }
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_b_of_type_Achs.getAuthMode();
    boolean bool = this.jdField_b_of_type_Achs.aaW();
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_Achs.R();
      localObject2 = new StringBuilder().append("mode: ").append(j).append(", isSetPasswd: ").append(bool).append(", refreshTimeLine: ").append(paramBoolean3).append(", devSetup: ").append(paramBoolean1).append(", allowSet: ").append(paramBoolean2).append(", da2 length: ");
      if (localObject1 == null)
      {
        i = 0;
        QLog.d("C2CMsgRoamProxy", 2, i);
      }
    }
    else
    {
      localObject1 = this.app;
      if (localObject1 != null) {
        break label153;
      }
      QLog.d("C2CMsgRoamProxy", 1, "checkDevAuthSync after destroy");
    }
    label153:
    do
    {
      return;
      i = localObject1.length;
      break;
      if (j != 1) {
        break label255;
      }
    } while (!paramBoolean1);
    if (this.jdField_b_of_type_Achs.R() != null)
    {
      this.bmn = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("C2CMsgRoamProxy", 2, "devlock is open but no da2 ticket， refresh da2...");
    }
    Object localObject2 = (AccountManager)((QQAppInterface)localObject1).getManager(0);
    if (localObject2 != null)
    {
      this.f.init();
      ((AccountManager)localObject2).refreshDA2(((QQAppInterface)localObject1).getCurrentAccountUin(), new yft(this));
      this.f.by(30000L);
      return;
    }
    this.bmn = false;
    return;
    label255:
    this.bmn = false;
  }
  
  private void register()
  {
    try
    {
      if (!this.bmm)
      {
        this.jdField_b_of_type_Achs.Ju(hashCode());
        this.jdField_b_of_type_Achs.b(this);
        this.bmm = true;
      }
      return;
    }
    finally {}
  }
  
  private void zU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync");
    }
    this.bmk = false;
    this.jdField_b_of_type_Achs.Fs(true);
    long l1 = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Yfq$a.init();
    this.jdField_b_of_type_Achs.Fq(paramBoolean);
    this.jdField_b_of_type_Yfq$a.by(30000L);
    DS(3);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync cost: " + (l2 - l1) + ", result: " + this.bmk);
    }
    this.jdField_b_of_type_Achs.cKB();
    this.jdField_b_of_type_Achs.Fs(this.bmk);
  }
  
  private void zV(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "checkDevStatusSync");
    }
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevStatusOnlySync after destroy");
      return;
    }
    if (this.jdField_b_of_type_Achs.R() != null)
    {
      q(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_e_of_type_Yfq$a.init();
    int[] arrayOfInt = new int[1];
    DevlockInfo[] arrayOfDevlockInfo = new DevlockInfo[1];
    afsf.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new yfs(this, l, arrayOfInt, arrayOfDevlockInfo));
    this.jdField_e_of_type_Yfq$a.by(30000L);
    if ((arrayOfInt[0] == 0) && (arrayOfDevlockInfo[0] != null))
    {
      boolean bool1;
      if (arrayOfDevlockInfo[0].DevSetup == 1)
      {
        bool1 = true;
        if (arrayOfDevlockInfo[0].AllowSet != 1) {
          break label169;
        }
      }
      for (;;)
      {
        q(bool1, bool2, paramBoolean);
        return;
        bool1 = false;
        break;
        label169:
        bool2 = false;
      }
    }
    this.bmn = false;
  }
  
  public void K(boolean paramBoolean, Object paramObject) {}
  
  public void a(achs.a parama)
  {
    try
    {
      this.cancel = true;
      this.jdField_b_of_type_Achs.c(this);
      this.jdField_b_of_type_Achs.iw(hashCode());
      this.bmm = false;
      return;
    }
    finally {}
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = a(paramString, paramInt1, paramArrayList);
    if (i == 0) {
      return true;
    }
    this.cancel = false;
    int j = paramArrayList.size();
    long l;
    if (paramMessageRecord == null)
    {
      l = NetConnInfoCenter.getServerTime();
      if ((paramMessageRecord != null) && ((this.jdField_b_of_type_Achs == null) || (!this.jdField_b_of_type_Achs.aaT()) || (this.jdField_b_of_type_Achs.b() != null))) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      init(bool);
      Ts();
      if (this.jdField_b_of_type_Achs.aaX()) {
        break label122;
      }
      QLog.i("C2CMsgRoamProxy", 1, "not open roam");
      return false;
      l = paramMessageRecord.time;
      break;
    }
    label122:
    c(paramMessageRecord, i);
    this.jdField_b_of_type_Achs.Fs(true);
    if (b() == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "current page date is null, init again");
      paramb = this.jdField_b_of_type_Achs.t;
      init(true);
      if (paramb == null) {
        break label203;
      }
      b(paramb);
    }
    for (;;)
    {
      bool = Tv();
      if (this.app != null) {
        break;
      }
      QLog.w("C2CMsgRoamProxy", 1, "getRoamMsg app is null");
      return true;
      label203:
      QLog.d("C2CMsgRoamProxy", 1, "last query date is null");
    }
    paramb = b();
    if (paramb == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "last synced date is null");
      return true;
    }
    if ((paramMessageRecord != null) && (i == 2)) {
      a(paramString, paramInt1, paramArrayList, paramInt2 - j, l, paramb);
    }
    if ((!bool) && (paramArrayList.size() < paramInt2))
    {
      if (!Tr())
      {
        QLog.d("C2CMsgRoamProxy", 1, "check auth failed");
        return false;
      }
      if (!Tt()) {
        break label424;
      }
      paramString = a(paramArrayList, paramLong, paramMessageRecord);
      if (paramString == null) {
        break label412;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("C2CMsgRoamProxy", 2, "get roam msg size: " + paramString.size());
        if (paramString.size() > 0) {
          QLog.d("C2CMsgRoamProxy", 2, "first roam msg: " + ((ChatMessage)paramString.get(0)).toString());
        }
      }
      paramArrayList.addAll(0, paramString);
    }
    for (;;)
    {
      return true;
      label412:
      QLog.d("C2CMsgRoamProxy", 1, "no more roam msg");
    }
    label424:
    QLog.d("C2CMsgRoamProxy", 1, "get timeline failed");
    return false;
  }
  
  public void j(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "handleQueryMessageFromDBRsp, what: " + paramInt1);
    }
    Object localObject = this.app;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleQueryMessageFromDBRsp after destroy");
      this.a.chT();
      return;
    }
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel())
      {
        paramObject = this.records;
        localObject = new StringBuilder().append("getHistorySig notify, result ");
        if (paramObject != null) {
          break label161;
        }
      }
      break;
    }
    label161:
    for (paramObject = "is null";; paramObject = " size: " + paramObject.size())
    {
      QLog.d("C2CMsgRoamProxy", 2, paramObject);
      this.a.chT();
      return;
      bd((QQAppInterface)localObject);
      break;
      if (a((QQAppInterface)localObject, paramObject)) {
        break;
      }
      return;
    }
  }
  
  public void k(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "onHandleMsg: " + paramInt1);
    }
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      i(paramInt1, paramInt2, paramObject);
      return;
    case 22: 
    case 23: 
      j(paramInt1, paramInt2, paramObject);
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
      g(paramInt1, paramInt2, paramObject);
      return;
    case 34: 
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "handle_get_roam_msg_auth_mode notify");
      }
      this.d.chT();
      return;
    }
    h(paramInt1, paramInt2, paramObject);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Achs != null)
    {
      this.jdField_b_of_type_Achs.cKO();
      this.jdField_b_of_type_Achs.iw(hashCode());
      this.jdField_b_of_type_Achs.c(this);
      ((BaseActivity)this.activity).removeObserver(this.jdField_e_of_type_Aclh);
    }
    this.app = null;
  }
  
  static class a
  {
    boolean notified;
    
    boolean Tw()
    {
      return by(0L);
    }
    
    /* Error */
    boolean by(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	yfq$a:notified	Z
      //   6: ifeq +7 -> 13
      //   9: aload_0
      //   10: monitorexit
      //   11: iconst_1
      //   12: ireturn
      //   13: aload_0
      //   14: lload_1
      //   15: invokevirtual 30	java/lang/Object:wait	(J)V
      //   18: aload_0
      //   19: monitorexit
      //   20: iconst_1
      //   21: ireturn
      //   22: astore_3
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_3
      //   26: athrow
      //   27: astore_3
      //   28: aload_3
      //   29: invokevirtual 33	java/lang/InterruptedException:printStackTrace	()V
      //   32: aload_0
      //   33: monitorexit
      //   34: iconst_0
      //   35: ireturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	a
      //   0	36	1	paramLong	long
      //   22	4	3	localObject	Object
      //   27	2	3	localInterruptedException	InterruptedException
      // Exception table:
      //   from	to	target	type
      //   2	11	22	finally
      //   13	18	22	finally
      //   18	20	22	finally
      //   23	25	22	finally
      //   28	34	22	finally
      //   13	18	27	java/lang/InterruptedException
    }
    
    void chT()
    {
      try
      {
        this.notified = true;
        notify();
        return;
      }
      finally {}
    }
    
    void init()
    {
      try
      {
        this.notified = false;
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfq
 * JD-Core Version:    0.7.0.1
 */