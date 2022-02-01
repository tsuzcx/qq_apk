import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class apsa
  implements Manager
{
  private static final ArrayList<Long> Cm = new ArrayList();
  protected LruCache<String, Bundle> C = new LruCache(10);
  protected TroopManager b;
  protected String cqW = "";
  protected QQAppInterface mApp;
  protected SharedPreferences mSharedPref;
  protected HashMap<String, Long> ow = new HashMap();
  
  public apsa(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = ((TroopManager)paramQQAppInterface.getManager(52));
    this.mSharedPref = this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_troop_bind_pb", 0);
  }
  
  @Deprecated
  public static boolean B(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.msgtype == -3006);
  }
  
  public String BB()
  {
    try
    {
      String str = this.cqW;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean E(String arg1, long paramLong)
  {
    String str = ??? + "_btm_pbmsg_seq";
    for (;;)
    {
      synchronized (this.mSharedPref)
      {
        long l = this.mSharedPref.getLong(str, -1L);
        if ((l > 0L) && (l == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void H(String paramString, Bundle paramBundle)
  {
    this.C.put(paramString, paramBundle);
  }
  
  public void T(String paramString, List<ChatMessage> arg2)
  {
    Object localObject2;
    boolean bool;
    try
    {
      localObject2 = paramString + "_btm_pbmsg_seq";
      synchronized (this.mSharedPref)
      {
        l = this.mSharedPref.getLong((String)localObject2, -1L);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("checkMovePubMsg2Bottom:").append(paramString).append(", hasPubMsg=");
          if (l <= 0L) {
            break label230;
          }
          bool = true;
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, bool);
        }
        if ((l >= 0L) && (??? != null))
        {
          i = ???.size();
          if (i != 0) {
            break label236;
          }
        }
        return;
      }
      ??? = paramString + "_unread_pbmsg_cnt";
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBindPublicAccountMgr.bottom", 2, "checkMoveLastPubMsgToBottom:" + ???.toString());
      }
      TM(paramString);
    }
    for (;;)
    {
      synchronized (this.mSharedPref)
      {
        if (this.mSharedPref.getInt((String)???, 0) == 1) {
          TO(paramString);
        }
        return;
      }
      label230:
      bool = false;
      break;
      label236:
      j = ???.size();
      i = 0;
      label246:
      if (i >= j) {
        break label738;
      }
      if (((ChatMessage)???.get(i)).uniseq != l) {
        break label746;
      }
      label271:
      bool = this.ow.containsKey(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "lastPubMsgIdxInList: lastPubMsgIdx=" + i + ", listSize=" + j + ", inBottomBefore=" + bool);
      }
      ??? = null;
      if (i < 0)
      {
        localObject2 = this.mApp.b().b(paramString, 1, l);
        if ((localObject2 instanceof ChatMessage)) {
          ??? = (ChatMessage)localObject2;
        }
        if (!QLog.isColorLevel()) {
          break label743;
        }
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "queryMsgItemByseq:" + (localObject2 instanceof ChatMessage));
        break label743;
      }
      label408:
      while (??? == null)
      {
        TM(paramString);
        return;
        ??? = (ChatMessage)???.remove(i);
      }
      if (bool) {
        break label535;
      }
      ???.add(???);
      i = ???.size();
      if (i > 1)
      {
        l = ((ChatMessage)???.get(i - 2)).shmsgseq;
        this.ow.put(paramString, Long.valueOf(l));
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "put2InsertSeqMap:" + paramString + "," + l);
        }
      }
    }
    label535:
    long l = ((Long)this.ow.get(paramString)).longValue();
    int j = ???.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ChatMessage)???.get(i)).shmsgseq < l) {}
      }
      else
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr.bottom", 2, "inBottomBefore, lastSeq=" + l + ", insertIdx=" + i);
          }
          if (i < 0) {
            ???.add(???);
          }
          for (;;)
          {
            anot.a(this.mApp, "P_CliOper", "Grp_public", "", "oper", "bottom_one", 0, 0, paramString, "", "", "");
            break;
            if (((ChatMessage)???.get(i)).shmsgseq > l) {
              ???.add(i, ???);
            } else if (((ChatMessage)???.get(i)).shmsgseq == l) {
              ???.add(i + 1, ???);
            }
          }
          i = -1;
        }
        label738:
        i = -1;
        break label271;
        label743:
        break label408;
        label746:
        i += 1;
        break label246;
      }
      i += 1;
    }
  }
  
  public void TL(String paramString)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        paramString = paramString + "_" + this.mApp.getCurrentAccountUin() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void TM(String paramString)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        String str = paramString + "_btm_pbmsg_seq";
        localEditor.remove(str);
        localEditor.commit();
        this.ow.remove(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + str);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void TN(String paramString)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        int i = this.mSharedPref.getInt(paramString, 0) + 1;
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        localEditor.putInt(paramString, i);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString + ", " + i);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void TO(String paramString)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void TP(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr", 2, "setCurentAIOUin:" + paramString);
      }
      this.cqW = paramString;
      return;
    }
    finally {}
  }
  
  public void aK(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        paramString = paramString + "_" + this.mApp.getCurrentAccountUin() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        paramInt1 = paramInt1 << 4 | paramInt2;
        localEditor.putInt(paramString, paramInt1);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString + ", " + paramInt1);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString.toString());
          }
        }
      }
      return;
    }
  }
  
  public boolean be(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (B(paramMessageRecord)) {
        return (E(paramMessageRecord.frienduin, paramMessageRecord.uniseq)) && (!cQ(paramMessageRecord.uniseq));
      }
    }
    return false;
  }
  
  public void bi(String paramString, long paramLong)
  {
    synchronized (this.mSharedPref)
    {
      try
      {
        paramString = paramString + "_btm_pbmsg_seq";
        SharedPreferences.Editor localEditor = this.mSharedPref.edit();
        localEditor.putLong(paramString, paramLong);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString + ", " + paramLong);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public boolean cQ(long paramLong)
  {
    return Cm.contains(Long.valueOf(paramLong));
  }
  
  public int eT(String paramString)
  {
    paramString = paramString + "_" + this.mApp.getCurrentAccountUin() + "_temp_follow_state";
    return this.mSharedPref.getInt(paramString, -1);
  }
  
  public Bundle h(String paramString)
  {
    return (Bundle)this.C.get(paramString);
  }
  
  public void lR(long paramLong)
  {
    if (!Cm.contains(Long.valueOf(paramLong))) {
      Cm.add(Long.valueOf(paramLong));
    }
  }
  
  public void onDestroy()
  {
    Cm.clear();
  }
  
  /* Error */
  public boolean qP(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +62 -> 68
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 39	apsa:cqW	Ljava/lang/String;
    //   14: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +51 -> 68
    //   20: iconst_1
    //   21: istore_2
    //   22: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: ldc_w 295
    //   31: iconst_2
    //   32: new 69	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 356
    //   42: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 221
    //   51: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_2
    //   55: invokevirtual 139	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_2
    //   67: ireturn
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -48 -> 22
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	apsa
    //   0	78	1	paramString	String
    //   21	49	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	73	finally
    //   22	64	73	finally
  }
  
  public boolean qQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.b.b(paramString) != null) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsa
 * JD-Core Version:    0.7.0.1
 */