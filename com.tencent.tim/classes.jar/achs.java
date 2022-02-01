import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageRoamManager.1;
import com.tencent.mobileqq.app.MessageRoamManager.10;
import com.tencent.mobileqq.app.MessageRoamManager.12;
import com.tencent.mobileqq.app.MessageRoamManager.2;
import com.tencent.mobileqq.app.MessageRoamManager.3;
import com.tencent.mobileqq.app.MessageRoamManager.4;
import com.tencent.mobileqq.app.MessageRoamManager.5;
import com.tencent.mobileqq.app.MessageRoamManager.6;
import com.tencent.mobileqq.app.MessageRoamManager.8;
import com.tencent.mobileqq.app.MessageRoamManager.9;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class achs
  implements Manager
{
  SharedPreferences N;
  long Qx = 0L;
  acoj a;
  public aczx a;
  public aquy a;
  public QQAppInterface app;
  boolean bIB;
  public volatile boolean bIC;
  public volatile boolean bID;
  public byte[] cP;
  int cwW = 2001;
  int cwX = -1;
  int cwY = -1;
  private Runnable fL;
  public HashMap<Calendar, RoamMessagePreloadInfo> iV = new HashMap();
  public String mFriendUin;
  Calendar q;
  Calendar r;
  public MessageRecord s;
  Calendar s;
  public Calendar t;
  ArrayList<achs.a> tp = new ArrayList(2);
  Calendar u;
  Calendar v;
  Calendar w;
  private Calendar x;
  public List<Long> xI;
  
  public achs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aquy = new acht(this);
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Aczx = ((aczx)paramQQAppInterface.getBusinessHandler(59));
    this.jdField_a_of_type_Acoj = ((acoj)paramQQAppInterface.a().getCache(2));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).getString("vip_message_roam_passwordmd5" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = Base64.decode(paramQQAppInterface, 0);; paramQQAppInterface = null)
    {
      this.cP = paramQQAppInterface;
      return;
    }
  }
  
  private List<MessageRecord> a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "rawQuery db = null!");
      }
      return null;
    }
    paramString1 = aqir.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "sqlStr db = null!");
      }
      return null;
    }
    return ((akvm)this.app.a().createMessageRecordEntityManager()).a(paramString1.toString(), null, this.app);
  }
  
  private boolean a(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    paramCalendar = this.jdField_a_of_type_Acoj.a(this.mFriendUin, i, j + 1);
    return (paramCalendar == null) || (paramCalendar.getSerState(k - 1) == 0) || (paramCalendar.getSerState(k - 1) == 1);
  }
  
  private boolean aaU()
  {
    if (this.mFriendUin == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine error : mFriendUin == null");
      }
      return false;
    }
    Object localObject2 = eb();
    if (this.xI == null) {
      this.xI = new ArrayList();
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        break label90;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine fasle");
      return false;
      this.xI.clear();
    }
    label90:
    Object localObject1 = Calendar.getInstance();
    localObject2 = ((List)localObject2).iterator();
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      ((Calendar)localObject1).setTimeInMillis(((MessageRecord)((Iterator)localObject2).next()).time * 1000L);
      ((Calendar)localObject1).set(11, 0);
      ((Calendar)localObject1).set(12, 0);
      ((Calendar)localObject1).set(13, 0);
      ((Calendar)localObject1).set(14, 0);
      l = ((Calendar)localObject1).getTimeInMillis();
      if (!this.xI.contains(Long.valueOf(l))) {
        this.xI.add(Long.valueOf(l));
      }
    }
    if (this.w == null)
    {
      this.w = Calendar.getInstance();
      this.w.setTimeInMillis(((Long)this.xI.get(this.xI.size() - 1)).longValue());
    }
    for (localObject1 = this.w.get(1) + "-" + (this.w.get(2) + 1) + "-" + this.w.get(5);; localObject1 = "")
    {
      if (this.v == null)
      {
        this.v = Calendar.getInstance();
        this.v.setTimeInMillis(((Long)this.xI.get(0)).longValue());
      }
      for (localObject2 = this.v.get(1) + "-" + (this.v.get(2) + 1) + "-" + this.v.get(5);; localObject2 = "")
      {
        if (this.u == null)
        {
          this.u = Calendar.getInstance();
          this.u.setTimeInMillis(this.w.getTimeInMillis());
        }
        if ((this.v != null) && (this.w != null))
        {
          l = (this.w.getTimeInMillis() - this.v.getTimeInMillis()) / 86400000L;
          VipUtils.a(this.app, "chat_history", "ChatHistory", "local_timeline", 0, 0, new String[] { l + "", "0", localObject2, localObject1 });
        }
        return true;
      }
    }
  }
  
  private long b(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("date is null!");
    }
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    return paramCalendar.getTimeInMillis();
  }
  
  private boolean b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = a((Calendar)paramCalendar.clone());
    return (paramLong >= ((Long)paramCalendar.first).longValue()) && (paramLong <= ((Long)paramCalendar.second).longValue());
  }
  
  private boolean b(Calendar paramCalendar)
  {
    Pair localPair = this.app.a().h(this.mFriendUin);
    if (localPair == null) {
      return false;
    }
    long l = ((Long)localPair.first).longValue();
    localPair = a((Calendar)paramCalendar.clone());
    if ((l > ((Long)localPair.first).longValue()) && (l <= ((Long)localPair.second).longValue()))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_Acoj.a(this.mFriendUin, i, j + 1);
      if (paramCalendar != null)
      {
        paramCalendar.setLocState(k - 1, 0);
        this.jdField_a_of_type_Acoj.a(paramCalendar);
      }
      return true;
    }
    return false;
  }
  
  private void cKC()
  {
    if (this.fL != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.fL);
    }
  }
  
  private void cKM()
  {
    ThreadManager.getSubThreadHandler().post(new MessageRoamManager.9(this));
  }
  
  private void hE(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    g(localCalendar);
    f(localCalendar);
  }
  
  private void hF(long paramLong)
  {
    Calendar localCalendar;
    if (this.bIB) {
      if (a(paramLong - 5L, this.r))
      {
        localCalendar = this.jdField_a_of_type_Acoj.b(this.mFriendUin, this.r, null);
        if (localCalendar != null)
        {
          this.r = localCalendar;
          if (this.mFriendUin == null) {}
        }
      }
    }
    label119:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("first_page_date" + this.mFriendUin, this.r.getTimeInMillis()).commit();
              break label119;
              break label119;
              break label119;
              do
              {
                return;
              } while (!a(paramLong - 5L, this.jdField_s_of_type_JavaUtilCalendar));
              localCalendar = this.jdField_a_of_type_Acoj.a(this.mFriendUin, this.jdField_s_of_type_JavaUtilCalendar, null);
            } while (localCalendar == null);
            this.jdField_s_of_type_JavaUtilCalendar = localCalendar;
          } while (this.mFriendUin == null);
          this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("last_page_date" + this.mFriendUin, this.jdField_s_of_type_JavaUtilCalendar.getTimeInMillis()).commit();
          return;
          if (!a(paramLong - 5L, this.v)) {
            break;
          }
          i = this.xI.indexOf(Long.valueOf(b(this.v)));
        } while ((i == -1) || (i >= this.xI.size() - 1));
        this.v.setTimeInMillis(((Long)this.xI.get(i + 1)).longValue());
        return;
      } while (!a(paramLong - 5L, this.w));
      i = this.xI.indexOf(Long.valueOf(b(this.w)));
    } while (i <= 0);
    this.w.setTimeInMillis(((Long)this.xI.get(i - 1)).longValue());
  }
  
  public int AC()
  {
    return this.cwY;
  }
  
  public void Ep(String paramString)
  {
    Eq(paramString);
    switch (this.cwX)
    {
    }
    for (;;)
    {
      this.cwX = -1;
      return;
      z(24, null);
      continue;
      z(25, null);
    }
  }
  
  public void Eq(String paramString)
  {
    int j = paramString.length();
    if (this.cP == null) {
      this.cP = new byte[j / 2];
    }
    int i = 0;
    while (i < j)
    {
      this.cP[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage passwordMD5" + Arrays.toString(this.cP));
    }
    ThreadManager.getFileThreadHandler().post(new MessageRoamManager.6(this));
  }
  
  public void Fq(boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    if ((paramBoolean) || (b(localCalendar)) || (a(localCalendar)))
    {
      paramBoolean = true;
      if (!paramBoolean) {
        break label100;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (aqiw.isNetSupport(BaseApplication.getContext()))
        {
          z(26, null);
          this.jdField_a_of_type_Aczx.d(this.mFriendUin, 0, 1, i, j + 1, k);
          return;
          paramBoolean = false;
          break;
          label100:
          paramBoolean = aba();
          continue;
        }
        l(16, 1, null);
        return;
      }
    }
    z(18, null);
    this.cwW = 2003;
  }
  
  public void Fr(boolean paramBoolean)
  {
    Iterator localIterator = this.tp.iterator();
    while (localIterator.hasNext()) {
      ((achs.a)localIterator.next()).K(paramBoolean, null);
    }
  }
  
  public void Fs(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "show roam: " + paramBoolean);
    }
    this.bIB = paramBoolean;
  }
  
  @TargetApi(9)
  public void Ft(boolean paramBoolean)
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.N.edit().putBoolean("first_use_devlock_for_roam_message_" + this.app.getCurrentAccountUin(), paramBoolean).apply();
      return;
    }
    this.N.edit().putBoolean("first_use_devlock_for_roam_message_" + this.app.getCurrentAccountUin(), paramBoolean).commit();
  }
  
  public void Fu(boolean paramBoolean)
  {
    Object localObject = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    long l1 = ((SharedPreferences)localObject).getLong("blue_banner_last_update_timestamp", 0L);
    long l2 = ((SharedPreferences)localObject).getInt("blue_banner_cheak_update_internal", 24);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if ((paramBoolean) || (l3 - l1 > l2 * 3600000L) || (l3 < l1))
    {
      localObject = ((aqva)this.app.getManager(47)).a(1);
      if ((localObject != null) && (((aqvc)localObject).a("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json") == null))
      {
        aquz localaquz = new aquz("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json", new File(this.app.getApp().getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json"));
        localaquz.cWy = false;
        ((aqvc)localObject).a(localaquz, this.jdField_a_of_type_Aquy, null);
      }
    }
  }
  
  public void Jt(int paramInt)
  {
    this.cwW = paramInt;
  }
  
  public void Ju(int paramInt)
  {
    this.app.addObserver(this.jdField_a_of_type_Aczx.a(paramInt));
  }
  
  public void Jv(int paramInt)
  {
    this.cwX = paramInt;
  }
  
  public byte[] R()
  {
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getDA2(this.app.getCurrentAccountUin());; localObject = null)
    {
      if ((localObject != null) && (localObject.length > 0)) {
        return localObject;
      }
      VasWebviewUtil.reportVasStatus("messageRoam", "da2", "0", 0, 0, 0, 0, "", "");
      return null;
    }
  }
  
  public void U(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      this.jdField_s_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      this.cwY = 6;
      long l = paramMessageRecord.time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(l * 1000L);
      z(26, null);
      if (this.bIB) {
        break label120;
      }
      i = this.xI.indexOf(Long.valueOf(b(paramMessageRecord)));
      if (i >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryBySearchResult local state error index < 0");
    return;
    g(paramMessageRecord);
    cKC();
    this.fL = new MessageRoamManager.5(this, i);
    ThreadManager.getSubThreadHandler().post(this.fL);
    return;
    label120:
    Calendar localCalendar = Calendar.getInstance();
    if ((paramMessageRecord.get(1) == localCalendar.get(1)) && (paramMessageRecord.get(2) == localCalendar.get(2)) && (paramMessageRecord.get(5) == localCalendar.get(5)) && (b(paramMessageRecord))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Fq(false);
        return;
      }
      a(paramMessageRecord, null, true);
      return;
    }
  }
  
  public void V(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (this.mFriendUin == null) {
      this.jdField_a_of_type_Acoj.FL(str);
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(1000L * l);
    Object localObject2 = a((Calendar)((Calendar)localObject1).clone());
    List localList;
    if (this.mFriendUin != null)
    {
      localObject1 = this.mFriendUin;
      localList = a((String)localObject1, ((Long)((Pair)localObject2).first).longValue(), ((Long)((Pair)localObject2).second).longValue());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
        if (this.mFriendUin != null) {
          break label399;
        }
        localObject1 = str;
        label133:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(", dayList.size() = ");
        if (localList != null) {
          break label408;
        }
        localObject1 = "null";
        label158:
        QLog.d("Q.roammsg.MessageRoamManager", 2, localObject1);
      }
      localObject1 = new ArrayList();
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: delList.size() = " + ((List)localObject1).size());
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label429;
      }
      if ((localList != null) && (localList.size() == 1))
      {
        localObject1 = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin == null) {
          break label423;
        }
        paramMessageRecord = this.mFriendUin;
        label287:
        ((acoj)localObject1).n(paramMessageRecord, l - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin != null) {
          str = this.mFriendUin;
        }
        paramMessageRecord.o(str, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.mFriendUin != null) {
          hF(l);
        }
      }
    }
    label399:
    label408:
    label423:
    label429:
    do
    {
      if (this.mFriendUin == null) {
        this.jdField_a_of_type_Acoj.clearCache();
      }
      return;
      localObject1 = str;
      break;
      localObject1 = this.mFriendUin;
      break label133;
      localObject1 = Integer.valueOf(localList.size());
      break label158;
      paramMessageRecord = str;
      break label287;
      if (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label605;
      }
    } while ((localList == null) || (localList.size() != ((List)localObject1).size()));
    localObject1 = this.jdField_a_of_type_Acoj;
    if (this.mFriendUin != null) {}
    for (paramMessageRecord = this.mFriendUin;; paramMessageRecord = str)
    {
      ((acoj)localObject1).n(paramMessageRecord, l - 5L, 1);
      paramMessageRecord = this.jdField_a_of_type_Acoj;
      if (this.mFriendUin != null) {
        str = this.mFriendUin;
      }
      paramMessageRecord.o(str, l - 5L, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
      }
      if (this.mFriendUin == null) {
        break;
      }
      hF(l);
      break;
    }
    label605:
    int j = 0;
    int i = ((List)localObject1).size();
    paramMessageRecord = ((List)localObject1).iterator();
    label623:
    if (paramMessageRecord.hasNext())
    {
      if (((MessageRecord)paramMessageRecord.next()).time > ((Long)((Pair)localObject2).second).longValue()) {
        break label1122;
      }
      j += 1;
      i -= 1;
    }
    label704:
    label735:
    label1122:
    for (;;)
    {
      break label623;
      if ((localList != null) && (localList.size() == j))
      {
        localObject2 = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin == null) {
          break label1076;
        }
        paramMessageRecord = this.mFriendUin;
        ((acoj)localObject2).n(paramMessageRecord, l - 5L, 1);
        localObject2 = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin == null) {
          break label1082;
        }
        paramMessageRecord = this.mFriendUin;
        ((acoj)localObject2).o(paramMessageRecord, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.mFriendUin != null) {
          hF(l);
        }
      }
      l = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * l);
      localObject1 = a(paramMessageRecord);
      if (this.mFriendUin != null)
      {
        paramMessageRecord = this.mFriendUin;
        localObject1 = a(paramMessageRecord, ((Long)((Pair)localObject1).first).longValue(), ((Long)((Pair)localObject1).second).longValue());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
          if (this.mFriendUin != null) {
            break label1094;
          }
          paramMessageRecord = str;
          localObject2 = ((StringBuilder)localObject2).append(paramMessageRecord).append(", tomorrowList.size() = ");
          if (localObject1 != null) {
            break label1102;
          }
          paramMessageRecord = "null";
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramMessageRecord);
        }
        if ((localObject1 == null) || (((List)localObject1).size() != i)) {
          break;
        }
        localObject1 = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin == null) {
          break label1116;
        }
      }
      for (paramMessageRecord = this.mFriendUin;; paramMessageRecord = str)
      {
        ((acoj)localObject1).n(paramMessageRecord, l - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_Acoj;
        if (this.mFriendUin != null) {
          str = this.mFriendUin;
        }
        paramMessageRecord.o(str, l - 5L, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeClearRoamDateIndex: " + l);
        }
        if (this.mFriendUin == null) {
          break;
        }
        hF(l);
        break;
        paramMessageRecord = str;
        break label704;
        paramMessageRecord = str;
        break label735;
        paramMessageRecord = str;
        break label851;
        paramMessageRecord = this.mFriendUin;
        break label911;
        paramMessageRecord = Integer.valueOf(((List)localObject1).size());
        break label934;
      }
    }
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.app == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(top.ox());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = aqir.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(top.ox());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label239;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label239:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  public int a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    paramString = a(MessageRecord.getTableName(paramString, 0), null, "( msgtype " + top.ox() + " and isValid=1 and " + str + " ) " + "ORDER BY time asc , longMsgIndex asc", paramLong1, paramLong2);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public acoj a()
  {
    return this.jdField_a_of_type_Acoj;
  }
  
  public Bundle a(Calendar paramCalendar)
  {
    List localList = this.jdField_a_of_type_Acoj.ej();
    int m;
    int n;
    int i1;
    int i;
    if (!localList.isEmpty())
    {
      m = paramCalendar.get(1);
      n = paramCalendar.get(2) + 1;
      i1 = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_Acoj.g(this.mFriendUin, m, n);
      i = 0;
      if (i >= localList.size()) {
        break label383;
      }
      if (!((String)((Map.Entry)localList.get(i)).getKey()).equals(paramCalendar)) {}
    }
    label374:
    label383:
    for (;;)
    {
      if (i < localList.size())
      {
        paramCalendar = (RoamDate)((Map.Entry)localList.get(i)).getValue();
        String str = (String)((Map.Entry)localList.get(i)).getKey();
        str = this.jdField_a_of_type_Acoj.l(str)[1];
        int i2 = Integer.valueOf(str.split("-")[0]).intValue();
        int i3 = Integer.valueOf(str.split("-")[1]).intValue();
        int k = 1;
        int j = k;
        if (m == i2)
        {
          j = k;
          if (n == i3) {
            j = i1 + 1;
          }
        }
        for (;;)
        {
          if (j > RoamDate.getDays(i2, i3)) {
            break label374;
          }
          if (paramCalendar.getLocState(j - 1) == 3)
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "local");
            paramCalendar.putInt("DATE_YEAR", i2);
            paramCalendar.putInt("DATE_MONTH", i3);
            paramCalendar.putInt("DATE_DAY", j);
            return paramCalendar;
            i += 1;
            break;
          }
          if ((paramCalendar.getSerState(j - 1) == 2) && (aqiw.isNetSupport(BaseApplication.getContext())))
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "server");
            paramCalendar.putInt("DATE_YEAR", i2);
            paramCalendar.putInt("DATE_MONTH", i3);
            paramCalendar.putInt("DATE_DAY", j);
            return paramCalendar;
          }
          j += 1;
        }
        i += 1;
      }
      else
      {
        return null;
      }
    }
  }
  
  public Pair<Long, Long> a(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    long l = paramCalendar.getTimeInMillis() / 1000L;
    paramCalendar.set(11, 23);
    paramCalendar.set(12, 59);
    paramCalendar.set(13, 59);
    paramCalendar.set(14, 0);
    return new Pair(Long.valueOf(l), Long.valueOf(paramCalendar.getTimeInMillis() / 1000L));
  }
  
  public RoamMessagePreloadInfo a(int paramInt)
  {
    return this.jdField_a_of_type_Acoj.a(this.mFriendUin, this.q, paramInt);
  }
  
  public BitSet a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    if (this.xI.size() > 0)
    {
      paramCalendar1 = (Calendar)paramCalendar1.clone();
      int i = 0;
      while ((paramCalendar1.before(paramCalendar2)) || (paramCalendar1.equals(paramCalendar2)))
      {
        paramCalendar1.set(11, 0);
        paramCalendar1.set(12, 0);
        paramCalendar1.set(13, 0);
        paramCalendar1.set(14, 0);
        if (this.xI.contains(Long.valueOf(paramCalendar1.getTimeInMillis()))) {
          localBitSet.set(i, true);
        }
        paramCalendar1.add(5, 1);
        i += 1;
      }
    }
    return localBitSet;
  }
  
  public List<MessageRecord> a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    return a(MessageRecord.getTableName(paramString, 0), null, str + " " + "ORDER BY time asc , longMsgIndex asc", paramLong1, paramLong2);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = (akwh)this.app.getManager(201);
    if (localObject == null) {
      paramString3 = a(paramString1, paramString2, paramString3);
    }
    int i;
    int j;
    do
    {
      return paramString3;
      this.Qx = ((akwh)localObject).aq(paramString1);
      if (this.Qx <= paramLong2) {
        break label169;
      }
      paramString2 = "slowTable";
      paramString1 = ((akwh)localObject).h(paramString1, paramString3);
      if (paramString1 != null) {
        break;
      }
      i = 0;
      k = 0;
      j = i;
      i = k;
      paramString3 = paramString1;
    } while (!QLog.isColorLevel());
    paramString3 = new StringBuilder().append("queryMsgDbBoth: msgLists = ");
    if (paramString1 == null) {}
    for (int k = 0;; k = paramString1.size())
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, k + ",fromWhichTable:" + paramString2 + ",stCount:" + j + " ,qtCount:" + i);
      return paramString1;
      i = paramString1.size();
      break;
      label169:
      if (this.Qx < paramLong1)
      {
        localObject = "quickTable";
        paramString1 = a(paramString1, paramString2, paramString3);
        if (paramString1 == null) {}
        for (i = 0;; i = paramString1.size())
        {
          j = 0;
          paramString2 = (String)localObject;
          break;
        }
      }
      localObject = ((akwh)localObject).h(paramString1, paramString3);
      label236:
      String str;
      if (localObject == null)
      {
        i = 0;
        str = "slowTable";
        if (i <= 0) {
          break label323;
        }
        paramString1 = a(paramString1, null, paramString3);
        if (paramString1 != null) {
          break label312;
        }
      }
      label312:
      for (j = 0;; j = paramString1.size())
      {
        paramString2 = str;
        if (j > 0)
        {
          ((List)localObject).addAll(paramString1);
          paramString2 = "bothTable";
        }
        k = i;
        i = j;
        j = k;
        paramString1 = (String)localObject;
        break;
        i = ((List)localObject).size();
        break label236;
      }
      label323:
      paramString1 = a(paramString1, paramString2, paramString3);
      if (paramString1 == null) {}
      for (j = 0;; j = paramString1.size())
      {
        k = i;
        i = j;
        paramString2 = "quickTable";
        j = k;
        break;
      }
    }
  }
  
  public void a(int paramInt, Calendar paramCalendar, boolean paramBoolean)
  {
    a(paramInt, paramCalendar, paramBoolean, true);
  }
  
  public void a(int paramInt, Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cwY = paramInt;
    int i;
    if ((paramCalendar != null) && (QLog.isColorLevel()))
    {
      i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistory start... someday=" + i + "-" + (j + 1) + "-" + k);
    }
    if (!this.bIB)
    {
      if (this.u == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory error :mLocCurPageDate == null");
        }
        return;
      }
      if (paramCalendar != null) {
        i = this.xI.indexOf(Long.valueOf(b(paramCalendar)));
      }
    }
    for (;;)
    {
      if ((i < 0) || (i > this.xI.size() - 1))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getForwardRoamHistoryByDate error :index < 0");
        }
        if ((paramInt == 1) || (paramInt == 0)) {
          break;
        }
        z(33, paramCalendar);
        return;
        if (paramInt == 1)
        {
          long l = b(this.u);
          i = this.xI.size() - 1;
          label221:
          if ((i < 0) || (((Long)this.xI.get(i)).longValue() <= l))
          {
            if (i != -1) {
              break label273;
            }
            i += 1;
          }
          label273:
          for (;;)
          {
            break;
            i -= 1;
            break label221;
          }
        }
        if (paramInt == 3)
        {
          i = this.xI.indexOf(Long.valueOf(b(this.u)));
          if (i >= this.xI.size() - 1) {
            break;
          }
          i += 1;
          continue;
        }
        if (paramInt != 2) {
          break label706;
        }
        i = this.xI.indexOf(Long.valueOf(b(this.u)));
        if (i <= 0) {
          break label703;
        }
        i -= 1;
        continue;
      }
      if (paramInt == 0) {
        g(this.w);
      }
      while (paramBoolean1)
      {
        ThreadManager.getSubThreadHandler().post(new MessageRoamManager.3(this, i));
        return;
        hE(((Long)this.xI.get(i)).longValue());
      }
      z(0, null);
      return;
      Object localObject;
      RoamMessagePreloadInfo localRoamMessagePreloadInfo;
      if (paramInt == 1)
      {
        localObject = this.q;
        localRoamMessagePreloadInfo = null;
      }
      for (;;)
      {
        if (localObject != null) {
          a((Calendar)localObject, null, paramBoolean1, paramBoolean2);
        }
        for (;;)
        {
          label463:
          if (QLog.isColorLevel())
          {
            QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory end");
            return;
            if (paramInt == 0)
            {
              localObject = this.jdField_s_of_type_JavaUtilCalendar;
              localRoamMessagePreloadInfo = null;
              break;
            }
            if (paramCalendar != null)
            {
              localRoamMessagePreloadInfo = this.jdField_a_of_type_Acoj.a(this.mFriendUin, paramCalendar, 0);
              localObject = null;
              break;
            }
            if ((paramInt == 3) && (this.q != null))
            {
              localRoamMessagePreloadInfo = this.jdField_a_of_type_Acoj.a(this.mFriendUin, this.q, 2);
              localObject = null;
              break;
            }
            if ((paramInt != 2) || (this.q == null)) {
              break label694;
            }
            localRoamMessagePreloadInfo = this.jdField_a_of_type_Acoj.a(this.mFriendUin, this.q, 1);
            localObject = null;
            break;
            if ((localRoamMessagePreloadInfo != null) && (localRoamMessagePreloadInfo.curday != null))
            {
              a(localRoamMessagePreloadInfo.curday, localRoamMessagePreloadInfo, paramBoolean1, paramBoolean2);
            }
            else if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("getRoamHistory: null roamFrom: ").append(paramInt).append("info==null:");
              if (localRoamMessagePreloadInfo != null) {
                break label689;
              }
            }
          }
        }
        label689:
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramBoolean1);
          if (paramCalendar == null) {
            break label463;
          }
          z(33, paramCalendar);
          break label463;
          break;
        }
        label694:
        localRoamMessagePreloadInfo = null;
        localObject = null;
      }
      label703:
      continue;
      label706:
      i = 0;
    }
  }
  
  public void a(Calendar paramCalendar, RoamMessagePreloadInfo paramRoamMessagePreloadInfo, boolean paramBoolean)
  {
    a(paramCalendar, paramRoamMessagePreloadInfo, paramBoolean, true);
  }
  
  public void a(Calendar paramCalendar, RoamMessagePreloadInfo paramRoamMessagePreloadInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCalendar == null) {}
    int m;
    int n;
    boolean bool;
    for (;;)
    {
      return;
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2) + 1;
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: Date = " + i + "-" + j + "-" + k);
      }
      RoamDate localRoamDate = this.jdField_a_of_type_Acoj.a(this.mFriendUin, i, j);
      if (localRoamDate == null)
      {
        if (!paramCalendar.equals(this.x))
        {
          this.x = paramCalendar;
          Fq(false);
          return;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery endless loop protection");
        return;
      }
      aG(i, j - 1, k);
      m = localRoamDate.getLocState(k - 1);
      n = localRoamDate.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: serverStatus: " + n + ", localStaus: " + m);
      }
      switch (m)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
        bool = aqiw.isNetSupport(BaseApplication.getContext());
        if ((n != 2) || (!bool)) {
          break label486;
        }
        z(26, null);
        paramCalendar = Calendar.getInstance();
        paramCalendar.setTime(new Date(i - 1900, j - 1, k));
        QLog.d("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery getRoamHistoryForSomeDay year = " + i + " month = " + j + " day = " + k + " call stack = " + Log.getStackTraceString(new Throwable()));
        this.jdField_a_of_type_Aczx.a(this.mFriendUin, paramCalendar, paramBoolean1, 8, false, paramBoolean2);
        if (paramRoamMessagePreloadInfo != null)
        {
          this.iV.clear();
          this.iV.put(this.q, paramRoamMessagePreloadInfo);
          return;
        }
        break;
      case 3: 
        if (paramBoolean1) {
          ThreadManager.getSubThreadHandler().post(new MessageRoamManager.4(this, paramCalendar));
        }
        while ((aqiw.isNetSupport(BaseApplication.getContext())) && (paramRoamMessagePreloadInfo != null))
        {
          this.iV.clear();
          this.iV.put(this.q, paramRoamMessagePreloadInfo);
          a(this.q, paramBoolean2);
          return;
          z(0, null);
        }
      }
    }
    label486:
    if (QLog.isColorLevel()) {
      QLog.w("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery serStatus: " + n + ", locStatus: " + m + ", network status: " + bool);
    }
    l(1, -1, null);
  }
  
  public void a(Calendar paramCalendar, boolean paramBoolean)
  {
    if (this.iV.containsKey(paramCalendar))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "startPreloadCalendar: Calendar key = " + i + "-" + (j + 1) + "-" + k);
      }
      RoamMessagePreloadInfo localRoamMessagePreloadInfo = (RoamMessagePreloadInfo)this.iV.get(paramCalendar);
      this.iV.remove(paramCalendar);
      if (localRoamMessagePreloadInfo.preloadType != 0)
      {
        b(localRoamMessagePreloadInfo.nextday, paramBoolean);
        b(localRoamMessagePreloadInfo.previousday, paramBoolean);
      }
    }
  }
  
  public boolean a(long paramLong, Calendar paramCalendar)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: day == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void aG(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.q == null) {
      this.q = Calendar.getInstance();
    }
    this.q.set(1, paramInt1);
    this.q.set(2, paramInt2);
    this.q.set(5, paramInt3);
    this.q.set(11, 0);
    this.q.set(12, 0);
    this.q.set(13, 0);
    this.q.set(14, 0);
    f(this.q);
  }
  
  public void aH(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    List localList = this.app.b().k(this.mFriendUin, 0);
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      localObject = a((Calendar)localCalendar.clone());
      localObject = a(this.mFriendUin, ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (b(((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time, (Calendar)localCalendar.clone())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeLatestMsgInToday: friendUin = " + this.mFriendUin + ", year/month/day = " + paramInt1 + "/" + paramInt2 + "/" + paramInt3);
      }
      this.jdField_a_of_type_Acoj.n(this.mFriendUin, localCalendar.getTimeInMillis() / 1000L, 2);
    }
  }
  
  public boolean aaQ()
  {
    return this.cwW == 2003;
  }
  
  public boolean aaR()
  {
    return this.q != null;
  }
  
  public boolean aaS()
  {
    Object localObject2;
    if (this.bIB)
    {
      localObject2 = this.jdField_s_of_type_JavaUtilCalendar;
      if (!this.bIB) {
        break label110;
      }
      localObject1 = this.q;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isLastPage: lastPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.w;
      break;
      localObject1 = this.u;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) <= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) <= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) <= ((Calendar)localObject1).get(5));
  }
  
  public boolean aaT()
  {
    return this.bIB;
  }
  
  public boolean aaV()
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.N.getInt("auth_mode_" + this.app.getCurrentAccountUin(), -1) != -1;
  }
  
  public boolean aaW()
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return 1 == this.N.getInt("message_roam_is_set_password" + this.app.getCurrentAccountUin(), -1);
  }
  
  public boolean aaX()
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.N.getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 1) != 1;
  }
  
  public boolean aaY()
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.N.contains("message_roam_flag" + this.app.getCurrentAccountUin());
  }
  
  public boolean aaZ()
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.N.getBoolean("first_use_devlock_for_roam_message_" + this.app.getCurrentAccountUin(), false);
  }
  
  public boolean aba()
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(this.mFriendUin)) {}
    boolean bool2;
    do
    {
      return bool1;
      if (this.N == null) {
        this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      }
      bool2 = this.N.getBoolean("delServerRoamMSg_" + this.mFriendUin, false);
      bool1 = bool2;
    } while (!bool2);
    cKK();
    return bool2;
  }
  
  public boolean abb()
  {
    if (!this.bIC)
    {
      cKM();
      this.bIC = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "canSearchInCloud: " + this.bID + ", mShowRoamFlag: " + this.bIB);
    }
    return (this.bID) && (this.bIB);
  }
  
  public void ad(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Acoj.clearCache();
    this.q = null;
    this.r = null;
    this.jdField_s_of_type_JavaUtilCalendar = null;
    StringBuilder localStringBuilder;
    if (this.xI == null)
    {
      this.xI = new ArrayList();
      this.u = null;
      this.v = null;
      this.w = null;
      if ((paramBoolean) && (this.app.b() != null)) {
        this.app.b().bEz();
      }
      this.mFriendUin = paramString;
      this.jdField_a_of_type_Acoj.FL(paramString);
      paramString = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      long l1 = paramString.getLong("first_page_date" + this.mFriendUin, 0L);
      long l2 = paramString.getLong("last_page_date" + this.mFriendUin, 0L);
      if (l1 != 0L)
      {
        this.r = Calendar.getInstance();
        this.r.setTimeInMillis(l1);
      }
      if (l2 != 0L)
      {
        this.jdField_s_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_s_of_type_JavaUtilCalendar.setTimeInMillis(l2);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("init: first - ");
        if (this.r == null) {
          break label343;
        }
        paramString = Integer.valueOf(this.r.get(5));
        label254:
        localStringBuilder = localStringBuilder.append(paramString).append(" second - ");
        if (this.jdField_s_of_type_JavaUtilCalendar == null) {
          break label350;
        }
      }
    }
    label343:
    label350:
    for (paramString = Integer.valueOf(this.jdField_s_of_type_JavaUtilCalendar.get(5));; paramString = "null")
    {
      QLog.d("MessageRoamManagerDebug", 4, paramString);
      this.t = null;
      this.iV.clear();
      ThreadManager.getSubThreadHandler().post(new MessageRoamManager.1(this));
      return;
      this.xI.clear();
      break;
      paramString = "null";
      break label254;
    }
  }
  
  public BitSet b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    List localList = this.jdField_a_of_type_Acoj.ej();
    Calendar localCalendar;
    if (!localList.isEmpty())
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendar1.getTimeInMillis());
      int i = 0;
      if ((localCalendar.before(paramCalendar2)) || (localCalendar.equals(paramCalendar2)))
      {
        int n = localCalendar.get(1);
        int i1 = localCalendar.get(2) + 1;
        localCalendar.get(5);
        paramCalendar1 = this.jdField_a_of_type_Acoj.g(this.mFriendUin, n, i1);
        int j = 0;
        int m = 0;
        while (j < localList.size())
        {
          int k = i;
          if (((String)((Map.Entry)localList.get(j)).getKey()).equals(paramCalendar1))
          {
            RoamDate localRoamDate = (RoamDate)((Map.Entry)localList.get(j)).getValue();
            k = localCalendar.get(5);
            if (k <= RoamDate.getDays(n, i1))
            {
              if (this.jdField_a_of_type_Acoj.a(localRoamDate, k - 1))
              {
                localBitSet.set(i, true);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
              for (;;)
              {
                i += 1;
                k += 1;
                break;
                localBitSet.set(i, false);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
            }
            m = 1;
            k = i;
          }
          j += 1;
          i = k;
        }
        if (m != 0) {
          break label478;
        }
        j = i + RoamDate.getDays(n, i1);
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramCalendar1 + " no roamDate add =" + RoamDate.getDays(n, i1) + ",index=" + j);
          i = j;
        }
      }
    }
    label478:
    for (;;)
    {
      localCalendar.add(2, 1);
      localCalendar.set(5, 1);
      break;
      return localBitSet;
    }
  }
  
  public Calendar b()
  {
    if (this.bIB) {
      return this.q;
    }
    return this.u;
  }
  
  public void b(achs.a parama)
  {
    Iterator localIterator = this.tp.iterator();
    while (localIterator.hasNext()) {
      ((achs.a)localIterator.next()).a(parama);
    }
    this.tp.add(parama);
  }
  
  public void b(Calendar paramCalendar, boolean paramBoolean)
  {
    if (paramCalendar == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    do
    {
      return;
      i = paramCalendar.get(1);
      j = paramCalendar.get(2) + 1;
      k = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_Acoj.a(this.mFriendUin, i, j);
      m = paramCalendar.getLocState(k - 1);
      n = paramCalendar.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: Date = " + i + "-" + j + "-" + k + " locState: " + m + " serverState " + n);
      }
    } while ((m == 3) || (n != 2));
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: preload >>>>> Date = " + i + "-" + j + "-" + k);
    }
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTime(new Date(i - 1900, j - 1, k));
    QLog.d("Q.roammsg.MessageRoamManager", 1, "preloadRoamMessage getRoamHistoryForSomeDay");
    this.jdField_a_of_type_Aczx.a(this.mFriendUin, paramCalendar, false, 0, true, paramBoolean);
  }
  
  public boolean bH(long paramLong)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (this.q == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == this.q.get(1)) && (localCalendar.get(2) == this.q.get(2)) && (localCalendar.get(5) == this.q.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public BitSet c(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    List localList = this.jdField_a_of_type_Acoj.ej();
    Calendar localCalendar;
    if (!localList.isEmpty())
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendar1.getTimeInMillis());
      int i = 0;
      if ((localCalendar.before(paramCalendar2)) || (localCalendar.equals(paramCalendar2)))
      {
        int n = localCalendar.get(1);
        int i1 = localCalendar.get(2) + 1;
        localCalendar.get(5);
        paramCalendar1 = this.jdField_a_of_type_Acoj.g(this.mFriendUin, n, i1);
        int j = 0;
        int m = 0;
        while (j < localList.size())
        {
          int k = i;
          if (((String)((Map.Entry)localList.get(j)).getKey()).equals(paramCalendar1))
          {
            RoamDate localRoamDate = (RoamDate)((Map.Entry)localList.get(j)).getValue();
            k = localCalendar.get(5);
            if (k <= RoamDate.getDays(n, i1))
            {
              if ((i == 0) && (!this.jdField_a_of_type_Acoj.a(localRoamDate, k - 1)))
              {
                cKy();
                z(18, null);
                if (QLog.isColorLevel()) {
                  QLog.d("MessageRoamManagerDebug", 2, "getRoamDateMap exception situation handle.");
                }
                return localBitSet;
              }
              if (this.jdField_a_of_type_Acoj.a(localRoamDate, k - 1))
              {
                localBitSet.set(i, true);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
              for (;;)
              {
                i += 1;
                k += 1;
                break;
                localBitSet.set(i, false);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
            }
            m = 1;
            k = i;
          }
          j += 1;
          i = k;
        }
        if (m != 0) {
          break label528;
        }
        j = i + RoamDate.getDays(n, i1);
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramCalendar1 + " no roamDate add =" + RoamDate.getDays(n, i1) + ",index=" + j);
          i = j;
        }
      }
    }
    label528:
    for (;;)
    {
      localCalendar.add(2, 1);
      localCalendar.set(5, 1);
      break;
      return localBitSet;
    }
  }
  
  public Calendar c()
  {
    if (this.bIB) {
      return this.r;
    }
    return this.v;
  }
  
  public void c(achs.a parama)
  {
    this.tp.remove(parama);
  }
  
  public void cKA()
  {
    if (this.bIB) {}
    for (Object localObject1 = this.q; localObject1 == null; localObject1 = this.u)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getMessageByDay error:curPageDate == null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      int i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2);
      int k = ((Calendar)localObject1).get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: friendUin = " + this.mFriendUin + ", mShowRoamFlag = " + this.bIB + ", curPageDate = " + i + "-" + (j + 1) + "-" + k);
    }
    localObject1 = a((Calendar)((Calendar)localObject1).clone());
    long l = ((Long)((Pair)localObject1).second).longValue();
    Object localObject2;
    if (this.t != null)
    {
      localObject2 = a((Calendar)this.t.clone());
      if (((Long)((Pair)localObject2).second).longValue() > l) {
        l = ((Long)((Pair)localObject2).second).longValue();
      }
    }
    for (;;)
    {
      String str2 = " time BETWEEN " + ((Pair)localObject1).first + " AND " + l;
      localObject2 = MessageRecord.getTableName(this.mFriendUin, 0);
      String str1 = MessageRecord.getOldTableName(this.mFriendUin, 0);
      str2 = "( msgtype " + top.ox() + " and isValid=1 and" + str2 + " ) " + "ORDER BY time asc , longMsgIndex asc";
      ThreadManager.getSubThreadHandler().post(new MessageRoamManager.2(this, (String)localObject2, str1, str2, (Pair)localObject1, l));
      return;
    }
  }
  
  public void cKB()
  {
    if (getAuthMode() == 0)
    {
      localObject = this.app.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      l = ((SharedPreferences)localObject).getLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), 0L);
      if ((System.currentTimeMillis() - l > 7200000L) || (l == 0L))
      {
        QLog.d("Q.roammsg.MessageRoamManager", 1, "checkPasswdBeforeRequest open password lastRequestTime = " + l);
        l(3, 2, null);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      long l;
      return;
    }
    QLog.d("Q.roammsg.MessageRoamManager", 2, "not passwd mode");
  }
  
  public void cKD()
  {
    switch (this.cwY)
    {
    default: 
      cKE();
    case 4: 
      return;
    case 0: 
    case 1: 
    case 2: 
      a(2, null, false);
      return;
    }
    a(3, null, false);
  }
  
  public void cKE()
  {
    this.cwY = -1;
    this.jdField_s_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public void cKF()
  {
    this.app.a().El(this.mFriendUin);
  }
  
  public void cKG()
  {
    this.jdField_a_of_type_Acoj.cKG();
  }
  
  public void cKH()
  {
    this.jdField_a_of_type_Acoj.cKH();
    SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
    localEditor.remove("first_page_date" + this.mFriendUin);
    localEditor.remove("last_page_date" + this.mFriendUin);
    localEditor.commit();
  }
  
  public void cKI()
  {
    ThreadManager.getSubThreadHandler().post(new MessageRoamManager.8(this));
  }
  
  public void cKJ()
  {
    if (TextUtils.isEmpty(this.mFriendUin)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "mFriendUin is null");
      }
    }
    for (;;)
    {
      return;
      Object localObject = eb();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine  no message");
        }
        cKG();
        return;
      }
      Calendar localCalendar = Calendar.getInstance();
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      int j = 0;
      label87:
      int m;
      for (int k = 0; localIterator.hasNext(); k = m)
      {
        localCalendar.setTimeInMillis(((MessageRecord)localIterator.next()).time * 1000L);
        m = localCalendar.get(1);
        int n = localCalendar.get(2) + 1;
        int i1 = localCalendar.get(5);
        if ((k == m) && (n == j) && (i1 == i)) {
          break label87;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine add local msg: " + m + "-" + n + "-" + i1);
        }
        RoamDate localRoamDate = this.jdField_a_of_type_Acoj.a(this.mFriendUin, m, n);
        localObject = localRoamDate;
        if (localRoamDate == null) {
          localObject = new RoamDate(String.valueOf(this.mFriendUin), this.jdField_a_of_type_Acoj.C(m, n));
        }
        if (2 != ((RoamDate)localObject).getSerState(i1 - 1))
        {
          ((RoamDate)localObject).setLocState(i1 - 1, 3);
          this.jdField_a_of_type_Acoj.a((RoamDate)localObject);
        }
        i = i1;
        j = n;
      }
    }
  }
  
  @TargetApi(9)
  public void cKK()
  {
    if (TextUtils.isEmpty(this.mFriendUin)) {
      return;
    }
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.N.edit().putBoolean("delServerRoamMSg_" + this.mFriendUin, false).apply();
      return;
    }
    this.N.edit().putBoolean("delServerRoamMSg_" + this.mFriendUin, false).commit();
  }
  
  public void cKL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg start....");
    }
    Object localObject1 = new File(achr.boF);
    int i;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    int k;
    int j;
    if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
    {
      localObject1 = aqhq.readFileContent((File)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          JSONArray localJSONArray = new JSONObject((String)localObject1).getJSONObject("data").getJSONArray("searchStrategy");
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject4 = (JSONObject)localJSONArray.get(0);
            localObject1 = ((JSONObject)localObject4).getString("version");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (AppSetting.bs((String)localObject1) < 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.roammsg.MessageRoamManager", 2, "curr ver: 3.4.4, config qqVer:" + (String)localObject1);
              }
            }
            else
            {
              localObject1 = ((JSONObject)localObject4).getString("canSearchInCloud");
              if (!"1".equals(localObject1))
              {
                if (!QLog.isColorLevel()) {
                  break label945;
                }
                QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[canSearchInCloud]: " + (String)localObject1);
              }
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parse cloudSearchcfg failed " + localException.getMessage());
          }
          this.bID = false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg done .... canCloudSearch: " + this.bID);
        }
        label359:
        do
        {
          return;
          localObject2 = ((JSONObject)localObject4).getString("whiteList");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).length() <= 2)) {
            break;
          }
          localObject2 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
          localObject3 = ((String)localObject2).split(",");
          k = localObject3.length;
          j = 0;
          if (j >= k) {
            break;
          }
          if (!localObject3[j].equals(this.app.getCurrentAccountUin())) {
            break label952;
          }
          this.bID = true;
        } while (!QLog.isColorLevel());
        QLog.d("Q.roammsg.MessageRoamManager", 2, "match Field[whitlist]:" + (String)localObject2);
        return;
        localObject3 = ((JSONObject)localObject4).getString("userType");
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label939;
        }
        localObject2 = localObject3;
        if (((String)localObject3).length() <= 2) {
          break label939;
        }
        localObject3 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
        localObject2 = ((String)localObject3).split(",");
        ArrayList localArrayList = new ArrayList();
        k = localObject2.length;
        j = 0;
        label495:
        if (j < k)
        {
          str = localObject2[j];
          if (str.equalsIgnoreCase("svip"))
          {
            localArrayList.add("2");
            break label959;
          }
          if (str.equalsIgnoreCase("vip"))
          {
            localArrayList.add("1");
            break label959;
          }
          if (!str.equalsIgnoreCase("normal")) {
            break label959;
          }
          localArrayList.add("0");
          break label959;
        }
        String str = VipUtils.d(this.app, this.app.getCurrentAccountUin());
        if (localArrayList.contains("0")) {
          break label966;
        }
        localObject2 = localObject3;
        if (!localArrayList.contains(str)) {
          break label939;
        }
        break label966;
      }
    }
    for (;;)
    {
      label629:
      if (!bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[userType]: " + (String)localObject2 + ", matchUserType: " + bool2);
        }
      }
      else
      {
        localObject2 = ((JSONObject)localObject4).getString("lastNumber");
        boolean bool1;
        boolean bool3;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).length() > 2))
        {
          localObject2 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
          localObject3 = new ArrayList(10);
          localObject4 = ((String)localObject2).split(",");
          k = localObject4.length;
          j = 0;
          while (j < k)
          {
            ((List)localObject3).add(localObject4[j]);
            j += 1;
          }
          localObject4 = this.app.getCurrentAccountUin();
          if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((List)localObject3).contains(((String)localObject4).substring(((String)localObject4).length() - 1, ((String)localObject4).length()))))
          {
            bool1 = true;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg Field[lastNumber]: " + (String)localObject2 + ", matchLastNumber: " + bool1);
              bool3 = bool1;
            }
          }
        }
        for (;;)
        {
          if ((bool2) && (bool3))
          {
            this.bID = true;
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg json text is empty");
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parseCloudSearchCfg file not exist");
            break;
            bool1 = false;
            break label821;
            bool3 = false;
            continue;
            bool2 = false;
            break label629;
          }
        }
      }
      label821:
      i += 1;
      label939:
      label945:
      break;
      label952:
      j += 1;
      break label359;
      label959:
      j += 1;
      break label495;
      label966:
      boolean bool2 = true;
      localObject2 = localObject3;
    }
  }
  
  public void cKN()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MessageRoamManager.10(this), 100L);
  }
  
  public void cKO()
  {
    this.Qx = 0L;
  }
  
  public void cKw()
  {
    QLog.d("Q.roammsg.MessageRoamManager", 1, "clearShowRoamBefore");
    this.q = null;
    this.r = null;
    this.jdField_s_of_type_JavaUtilCalendar = null;
  }
  
  public void cKx()
  {
    SharedPreferences.Editor localEditor = this.app.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    localEditor.remove("vip_message_roam_passwordmd5" + this.app.getCurrentAccountUin()).commit();
    this.cP = null;
    localEditor.putLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), 0L);
    localEditor.commit();
  }
  
  public void cKy()
  {
    Object localObject = this.jdField_a_of_type_Acoj.n();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        int i = ((Calendar)((Pair)localObject).first).get(1);
        int j = ((Calendar)((Pair)localObject).first).get(2);
        int k = ((Calendar)((Pair)localObject).first).get(5);
        int m = ((Calendar)((Pair)localObject).second).get(1);
        int n = ((Calendar)((Pair)localObject).second).get(2);
        int i1 = ((Calendar)((Pair)localObject).second).get(5);
        QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: first = " + i + "-" + (j + 1) + "-" + k + ", second = " + m + "-" + (n + 1) + "-" + i1);
      }
      this.r = ((Calendar)((Pair)localObject).first);
      this.jdField_s_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).second);
      if (QLog.isColorLevel()) {
        QLog.d("MessageRoamManagerDebug", 4, "setPageDateRange: first - " + this.r.get(5) + " second - " + this.jdField_s_of_type_JavaUtilCalendar.get(5));
      }
      localObject = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("first_page_date" + this.mFriendUin, this.r.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).putLong("last_page_date" + this.mFriendUin, this.jdField_s_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: null");
    }
    this.r = null;
    this.jdField_s_of_type_JavaUtilCalendar = null;
  }
  
  public void cKz()
  {
    this.cwY = 4;
    cKA();
  }
  
  public Calendar d()
  {
    if (this.bIB) {
      return this.jdField_s_of_type_JavaUtilCalendar;
    }
    return this.w;
  }
  
  void d(aquz paramaquz)
  {
    if ((paramaquz.errCode == 0) && (this.app != null))
    {
      this.app.getPreferences().edit().putLong("cloudSearchCfgLastModify", paramaquz.lastModifiedTime).commit();
      if (200 == paramaquz.httpCode) {
        ThreadManager.getFileThreadHandler().post(new MessageRoamManager.12(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(achr.boF);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status=" + paramaquz.getStatus() + ",errCode=" + paramaquz.errCode + ",httpCode=" + paramaquz.httpCode + ",local lastModify=" + l + ",server lastModify=" + paramaquz.lastModifiedTime);
    }
  }
  
  void e(aquz paramaquz)
  {
    boolean bool = true;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if ((paramaquz.getStatus() == 3) && (paramaquz.errCode == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download success!");
      }
      localObject = new File(this.app.getApp().getFilesDir(), paramaquz.key);
      if (((File)localObject).exists())
      {
        paramaquz = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        localEditor = paramaquz.edit();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray(aqhq.readFileContent((File)localObject));
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label477;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
          break label483;
        }
        localEditor.putInt("blue_banner_cheak_update_internal", localJSONObject.getInt("updateinternal"));
        localEditor.putInt("blue_banner_show_internal", localJSONObject.getInt("showinternal"));
        localEditor.putInt("blue_banner_show_time", localJSONObject.getInt("showtime"));
        localEditor.putString("blue_banner_go_url", localJSONObject.getString("url"));
        localEditor.putString("blue_banner_notvip_text", localJSONObject.getString("notvip"));
        localEditor.putString("blue_banner_vip_text", localJSONObject.getString("vip"));
        localEditor.putString("blue_banner_svip_text", localJSONObject.getString("svip"));
        localEditor.commit();
        if (bool)
        {
          paramaquz.edit().putLong("blue_banner_last_update_timestamp", NetConnInfoCenter.getServerTimeMillis()).commit();
          return;
        }
        if (!QLog.isColorLevel()) {
          break label482;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "save sp error , isSaveSuccess" + bool);
        return;
      }
      catch (JSONException paramaquz)
      {
        if (!QLog.isColorLevel()) {
          break label482;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "JSONException,blue banner parse json error : " + paramaquz.toString());
        return;
      }
      catch (Exception paramaquz)
      {
        if (!QLog.isColorLevel()) {
          break label482;
        }
      }
      QLog.e("Q.roammsg.MessageRoamManager", 2, "Exception,blue banner parse json error : " + paramaquz.toString());
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download file save failed!");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download failed, task.status = " + paramaquz.getStatus() + " , task.errCode = " + paramaquz.errCode);
          return;
          label477:
          bool = false;
          continue;
        }
      }
      label482:
      return;
      label483:
      i += 1;
    }
  }
  
  public long eT()
  {
    return this.Qx;
  }
  
  public List<MessageRecord> eb()
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB: friendUin = " + this.mFriendUin);
    }
    Object localObject1;
    if (this.mFriendUin == null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB error : mFriendUin == null");
        localObject1 = localObject2;
      }
    }
    List localList;
    for (;;)
    {
      return localObject1;
      localObject1 = MessageRecord.getTableName(this.mFriendUin, 0);
      localObject2 = "( msgtype " + top.ox() + " and isValid=1 ) " + "ORDER BY time asc , longMsgIndex asc";
      localList = a((String)localObject1, null, (String)localObject2);
      try
      {
        akwh localakwh = (akwh)this.app.getManager(201);
        if (localakwh != null)
        {
          localObject2 = localakwh.h((String)localObject1, (String)localObject2);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject1 = localObject2;
            if (localList == null) {
              continue;
            }
            localList.addAll(0, (Collection)localObject2);
            return localList;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.roammsg.MessageRoamManager", 1, "getAllMessageFormDB error");
      }
    }
    return localList;
  }
  
  public void f(Calendar paramCalendar)
  {
    if (this.t == null) {
      this.t = Calendar.getInstance();
    }
    this.t.setTimeInMillis(paramCalendar.getTimeInMillis());
  }
  
  public void g(Calendar paramCalendar)
  {
    if (this.u == null) {
      this.u = Calendar.getInstance();
    }
    this.u.set(1, paramCalendar.get(1));
    this.u.set(2, paramCalendar.get(2));
    this.u.set(5, paramCalendar.get(5));
    this.u.set(11, 0);
    this.u.set(12, 0);
    this.u.set(13, 0);
    this.u.set(14, 0);
    f(this.u);
  }
  
  public int getAuthMode()
  {
    int i = 0;
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    int j = this.N.getInt("auth_mode_" + this.app.getCurrentAccountUin(), -1);
    if ((j == 0) || (1 == j)) {
      i = j;
    }
    return i;
  }
  
  public byte[] getTicket()
  {
    int i = getAuthMode();
    if (i == 0) {
      return this.cP;
    }
    if (1 == i) {
      return R();
    }
    return null;
  }
  
  public void h(Calendar paramCalendar)
  {
    a(paramCalendar, true);
  }
  
  public void h(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    akwh localakwh = (akwh)this.app.getManager(201);
    paramString = MessageRecord.getTableName(paramString, 0);
    this.Qx = localakwh.aq(paramString);
    int j = paramList.size();
    int i = 0;
    if ((i >= j) || (((MessageRecord)paramList.get(i)).time > this.Qx))
    {
      if (i <= 0) {
        break label220;
      }
      localakwh.P(paramString, paramList.subList(0, i));
      this.app.b().g(paramList.subList(i, j), this.app.getCurrentAccountUin(), paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "addRoamMessage: msgLists.size:" + paramList.size() + ",index:" + i + ",slowTableMaxTime:" + this.Qx + ",cost:" + (System.currentTimeMillis() - l) + ", notify:" + paramBoolean);
      }
      return;
      i += 1;
      break;
      label220:
      this.app.b().f(paramList, this.app.getCurrentAccountUin(), paramBoolean);
    }
  }
  
  public void i(Calendar paramCalendar)
  {
    if ((paramCalendar != null) && (QLog.isColorLevel()))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistory start... someday=" + i + "-" + (j + 1) + "-" + k);
    }
    j(paramCalendar);
    if (QLog.isColorLevel()) {
      QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory end");
    }
  }
  
  public void init(String paramString)
  {
    ad(paramString, true);
  }
  
  public boolean isFirstPage()
  {
    Object localObject2;
    if (this.bIB)
    {
      localObject2 = this.r;
      if (!this.bIB) {
        break label110;
      }
      localObject1 = this.q;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isFirstPage: firstPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.v;
      break;
      localObject1 = this.u;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) >= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) >= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) >= ((Calendar)localObject1).get(5));
  }
  
  public boolean iw(int paramInt)
  {
    this.app.removeObserver(this.jdField_a_of_type_Aczx.b(paramInt));
    cKC();
    return (this.jdField_a_of_type_Aczx.cn == null) || (this.jdField_a_of_type_Aczx.cn.size() == 0);
  }
  
  public void j(Calendar paramCalendar)
  {
    if (paramCalendar == null) {}
    for (;;)
    {
      return;
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2) + 1;
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQueryNew: Date = " + i + "-" + j + "-" + k);
      }
      paramCalendar = this.jdField_a_of_type_Acoj.a(this.mFriendUin, i, j);
      if (paramCalendar == null)
      {
        QLog.e("Q.roammsg.MessageRoamManager", 1, "roamDate is null");
        return;
      }
      int m = paramCalendar.getLocState(k - 1);
      int n = paramCalendar.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: serverStatus: " + n + ", localStaus: " + m);
      }
      boolean bool;
      switch (m)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
        bool = aqiw.isNetSupport(BaseApplication.getContext());
        if ((n == 2) && (bool))
        {
          paramCalendar = Calendar.getInstance();
          paramCalendar.setTime(new Date(i - 1900, j - 1, k));
          QLog.d("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery getRoamHistoryForSomeDay year = " + i + " month = " + j + " day = " + k + " call stack = " + Log.getStackTraceString(new Throwable()));
          this.jdField_a_of_type_Aczx.a(this.mFriendUin, paramCalendar, false, 8, false);
          return;
        }
        break;
      case 3: 
        paramCalendar = this.tp.iterator();
        while (paramCalendar.hasNext()) {
          ((achs.a)paramCalendar.next()).K(true, null);
        }
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery serStatus: " + n + ", locStatus: " + m + ", network status: " + bool);
      }
      paramCalendar = this.tp.iterator();
      while (paramCalendar.hasNext()) {
        ((achs.a)paramCalendar.next()).K(false, null);
      }
    }
  }
  
  public void l(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 0;
    while (i < this.tp.size())
    {
      ((achs.a)this.tp.get(i)).k(paramInt1, paramInt2, paramObject);
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    this.N = null;
    this.cwX = -1;
    this.mFriendUin = null;
  }
  
  @TargetApi(9)
  public void setAuthMode(int paramInt)
  {
    if (this.N == null) {
      this.N = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.N.edit().putInt("auth_mode_" + this.app.getCurrentAccountUin(), paramInt).apply();
      return;
    }
    this.N.edit().putInt("auth_mode_" + this.app.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void z(int paramInt, Object paramObject)
  {
    l(paramInt, 0, paramObject);
  }
  
  public static abstract interface a
  {
    public abstract void K(boolean paramBoolean, Object paramObject);
    
    public abstract void a(a parama);
    
    public abstract void k(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achs
 * JD-Core Version:    0.7.0.1
 */