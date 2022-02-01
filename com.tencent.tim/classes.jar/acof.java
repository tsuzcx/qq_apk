import Wallet.AcsMsg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.4;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgBody;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class acof
  extends Observable
  implements Manager
{
  private long QV;
  private long QW;
  private long QX;
  private long QY;
  private QQAppInterface app;
  private volatile Set<Long> bQ;
  private volatile Set<Long> bR;
  private volatile Set<Long> bS;
  private volatile Set<Long> bT;
  Set<Integer> bU = new HashSet();
  private Handler cA;
  private int cyr = 1;
  private int cys = 2;
  private int cyt = 3;
  public int cyu = this.cyr;
  private int cyv = -2147483648;
  private Runnable fQ = new ActivateFriendsManager.1(this);
  private wii mReminderDataManager;
  private SharedPreferences pref;
  
  public acof(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.pref = paramQQAppInterface.getApp().getSharedPreferences("pref_act_frd" + paramQQAppInterface.getCurrentAccountUin(), 0);
    this.QV = this.pref.getLong("key_check_stamp", 0L);
    this.QX = this.pref.getLong("key_memorial_check_stamp", 0L);
    this.QW = this.pref.getLong("key_check_interval", 120000L);
    this.QY = this.pref.getLong("key_memorial_check_interval", 120000L);
    this.cA = new Handler(ThreadManager.getSubThreadLooper());
    this.mReminderDataManager = new wii(paramQQAppInterface);
    wih.e(paramQQAppInterface);
  }
  
  public static String a(Context paramContext, SubMsgType0x76.MsgBody paramMsgBody)
  {
    String str2 = paramMsgBody.bytes_notify_wording.get().toStringUtf8();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramMsgBody.uint32_msg_type.get() != 1) {
        break label63;
      }
      str1 = String.format(paramContext.getString(2131690033), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
    }
    label63:
    do
    {
      return str1;
      if (paramMsgBody.uint32_msg_type.get() == 2) {
        return paramContext.getString(2131690031);
      }
      str1 = str2;
    } while (paramMsgBody.uint32_msg_type.get() != 3);
    return paramContext.getString(2131690035);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xeb.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("activiate_friends|onReceiveReadedActivateFriendsPush|");
    }
    int j = 0;
    Object localObject1 = paramQQAppInterface.b().k(acbn.bla, 9002);
    HashSet localHashSet = new HashSet(((List)localObject1).size());
    if (QLog.isColorLevel()) {
      localStringBuilder.append(null).append("get unread msgs|");
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (!((MessageRecord)localObject2).isread)
      {
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("key_msg_ext_msg_seq");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localHashSet.add(localObject2);
          if (QLog.isColorLevel()) {
            localStringBuilder.append((String)localObject2).append("|");
          }
        }
      }
    }
    int i;
    if (paramMsgBody.rpt_msg_info.has())
    {
      paramMsgBody = paramMsgBody.rpt_msg_info.get().iterator();
      for (;;)
      {
        if (paramMsgBody.hasNext())
        {
          localObject1 = Integer.toString(((submsgtype0xeb.MsgInfo)paramMsgBody.next()).uint32_msg_seq.get());
          if (localHashSet.contains(localObject1))
          {
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("we have ").append((String)localObject1).append(" in unread msgs|");
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramQQAppInterface.b().ca(acbn.bla, 9002);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ActivateFriends.Manager", 2, localStringBuilder.toString());
      return;
      i = j;
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("rpt_msg_info is null|");
        i = j;
        continue;
        i = 0;
      }
    }
  }
  
  public static String az(Context paramContext)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131690040;
    int[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 2131690045;
    int[] tmp18_12 = tmp12_6;
    tmp18_12[2] = 2131690044;
    int[] tmp24_18 = tmp18_12;
    tmp24_18[3] = 2131690038;
    int[] tmp30_24 = tmp24_18;
    tmp30_24[4] = 2131690037;
    int[] tmp36_30 = tmp30_24;
    tmp36_30[5] = 2131690042;
    int[] tmp42_36 = tmp36_30;
    tmp42_36[6] = 2131690041;
    int[] tmp49_42 = tmp42_36;
    tmp49_42[7] = 2131690036;
    int[] tmp56_49 = tmp49_42;
    tmp56_49[8] = 2131690039;
    int[] tmp63_56 = tmp56_49;
    tmp63_56[9] = 2131690043;
    tmp63_56;
    return paramContext.getString(arrayOfInt[new java.util.Random().nextInt(arrayOfInt.length)]);
  }
  
  private Set<Long> b(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = this.bQ;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label195;
      }
      localObject2 = new HashSet(6);
      localObject1 = this.pref.getString("key_uin_sended_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinSendedSet, str = " + (String)localObject1 + ", msgType = " + paramInt);
      }
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        i += 1;
      }
      if (paramInt == 2) {
        localObject1 = this.bR;
      }
    }
    if (paramInt == 1)
    {
      this.bQ = ((Set)localObject2);
      label195:
      return localObject2;
    }
    this.bR = ((Set)localObject2);
    return localObject2;
  }
  
  private Set<Long> c(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.bS != null) {
        return this.bS;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.pref.getString("key_uin_wished_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + (String)localObject + ", type = " + paramInt);
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CharSequence localCharSequence = localObject[paramInt];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        paramInt += 1;
      }
      this.bS = localHashSet;
    }
    return this.bS;
  }
  
  private Set<Long> d(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.bT != null) {
        return this.bT;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.pref.getString("key_uin_expired_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + (String)localObject + ", type = " + paramInt);
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CharSequence localCharSequence = localObject[paramInt];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        paramInt += 1;
      }
      this.bT = localHashSet;
    }
    return this.bT;
  }
  
  public static int t(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      int i = localMsgBody.uint32_msg_type.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", paramArrayOfByte);
      }
    }
    return 1;
  }
  
  public void Ke(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "onReceivePushMessage  msgType = " + paramInt);
    }
    this.pref.edit().putString("key_uin_sended_" + paramInt, "").commit();
    this.pref.edit().putString("key_uin_wished_" + paramInt, "").commit();
    this.pref.edit().putString("key_uin_expired_" + paramInt, "").commit();
    if (paramInt == 1) {
      this.bQ = new HashSet();
    }
    for (;;)
    {
      if ((paramInt == 2) || (paramInt == 3))
      {
        if (paramInt == 2) {
          i = 1;
        }
        LpReportInfo_pf00064.allReport(220, 1, i);
        anot.a(this.app, "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
        this.pref.edit().putLong("key_last_birth_msg_stamp", anaz.gQ()).commit();
        ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.4(this));
      }
      return;
      if (paramInt == 2) {
        this.bR = new HashSet();
      }
    }
  }
  
  public void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    a(paramInt, paramArrayOfLong1, paramArrayOfLong2, paramString, -1);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString, int paramInt2)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessages | uin = ");
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
        break label121;
      }
      localStringBuilder.append("null");
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0)) {
        break label167;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(" | giftId = ").append(paramInt2);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.3(this, paramInt1, paramArrayOfLong1, paramString, paramInt2, paramArrayOfLong2));
      return;
      label121:
      int k = paramArrayOfLong1.length;
      int i = 0;
      while (i < k)
      {
        localStringBuilder.append(jt(String.valueOf(paramArrayOfLong1[i]))).append(",");
        i += 1;
      }
      break;
      label167:
      k = paramArrayOfLong2.length;
      i = j;
      while (i < k)
      {
        localStringBuilder.append(paramArrayOfLong2[i]).append(",");
        i += 1;
      }
    }
  }
  
  public boolean aX(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)this.app.getBusinessHandler(2)).cHI();
    }
    return this.pref.getBoolean(this.app.getApp().getString(2131697044) + this.app.getCurrentAccountUin(), true);
  }
  
  public boolean aY(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)this.app.getBusinessHandler(2)).cHI();
    }
    return this.pref.getBoolean(this.app.getApp().getString(2131697044) + this.app.getCurrentAccountUin(), false);
  }
  
  public void b(long[] paramArrayOfLong, int paramInt)
  {
    HashSet localHashSet = new HashSet(6);
    localHashSet.addAll(b(paramInt));
    int j = localHashSet.size();
    int k = paramArrayOfLong.length;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Long)localIterator.next()).append("-");
    }
    this.pref.edit().putString("key_uin_sended_" + paramInt, localStringBuilder.toString()).commit();
    if (paramInt == 1) {
      this.bQ = localHashSet;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "onSendTimingMsgSuc, send count = " + paramArrayOfLong.length + ", orginal count = " + j + ", new count = " + localHashSet.size());
      }
      return;
      this.bR = localHashSet;
    }
  }
  
  public void bM(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)this.app.getBusinessHandler(2)).EB(paramBoolean1);
      return;
    }
    this.pref.edit().putBoolean(this.app.getApp().getString(2131697044) + this.app.getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void cNe()
  {
    this.cA.removeCallbacks(this.fQ);
    this.cA.postDelayed(this.fQ, 60000L);
  }
  
  public void cNf() {}
  
  public void cNg()
  {
    this.cA.removeCallbacks(this.fQ);
    this.cyu = this.cys;
    acoe.a(this.app, false, true, false, true);
  }
  
  public void cNh()
  {
    synchronized (this.bU)
    {
      this.bU.clear();
      return;
    }
  }
  
  public void cNi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "checkTodayReminder: current qq version is google play version!!!");
    }
  }
  
  public void fh(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "doNotifaction: current qq version is google play version!!!");
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ActivateFriends.Manager", 1, "doNotifaction throw an exception: " + paramString1);
    }
  }
  
  public boolean h(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = localMsgBody.bool_strong_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "shouldMsgTips | " + bool);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "IsMessageTipsInBackground catch error.", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public boolean i(byte[] arg1)
  {
    int i = t(???);
    for (;;)
    {
      synchronized (this.bU)
      {
        if (!this.bU.contains(Integer.valueOf(i)))
        {
          bool = true;
          this.bU.add(Integer.valueOf(i));
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean iD(int paramInt)
  {
    if (this.cyv == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      this.cyv = paramInt;
      return bool;
    }
  }
  
  void ia(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 120000L) {
      l = 120000L;
    }
    this.QV = System.currentTimeMillis();
    this.QW = l;
    this.pref.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", l).commit();
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "saveBirthdayCheckInStamp=" + this.QW);
    }
  }
  
  void ib(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 120000L) {
      l = 120000L;
    }
    this.QX = System.currentTimeMillis();
    this.QY = l;
    this.pref.edit().putLong("key_memorial_check_stamp", System.currentTimeMillis()).putLong("key_memorial_check_interval", l).commit();
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "saveMemorialCheckInStamp=" + this.QY);
    }
  }
  
  String jt(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 3);
    return paramString.substring(paramString.length() - 3, paramString.length());
  }
  
  public void l(String paramString1, String paramString2, long paramLong)
  {
    if (paramLong > NetConnInfoCenter.getServerTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "has not arrive noticetime, set AlarmMangaer first!");
      }
      wif localwif = (wif)this.app.getManager(321);
      if (localwif != null)
      {
        AcsMsg localAcsMsg = new AcsMsg();
        localAcsMsg.msg_id = paramString2;
        localAcsMsg.notice_time = paramLong;
        localAcsMsg.title = paramString1;
        localwif.d(localAcsMsg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "has arrive noticetime, doNotifaction!");
    }
    fh(paramString1, paramString2);
  }
  
  public boolean l(long paramLong, int paramInt)
  {
    return b(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean m(long paramLong, int paramInt)
  {
    if ((c(paramInt) == null) || (c(paramInt).size() == 0)) {
      return false;
    }
    return c(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean n(long paramLong, int paramInt)
  {
    if ((d(paramInt) == null) || (d(paramInt).size() == 0)) {
      return false;
    }
    return d(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public void onDestroy()
  {
    this.cA.removeCallbacks(this.fQ);
    wih.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acof
 * JD-Core Version:    0.7.0.1
 */