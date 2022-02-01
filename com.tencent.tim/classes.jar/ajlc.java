import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.multimsg.MultiMsgManager.1;
import com.tencent.mobileqq.multimsg.MultiMsgManager.2;
import com.tencent.mobileqq.multimsg.MultiMsgManager.5;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import tencent.im.msg.im_msg_body.RichText;

public class ajlc
  implements Comparator<ChatMessage>
{
  private static long WI;
  private static ajlc a;
  public static final String bQH = acbn.SDCARD_PATH + "fight/pic_expire.png";
  private static byte[] lock = new byte[0];
  private int crv = 100;
  private int djA = 10;
  private int djB = 10;
  private int djC;
  private int djD;
  private int djE;
  public int djF;
  private int djx;
  private int djy = 100;
  private int djz = 20;
  private SessionInfo i;
  private aure<Integer> j;
  private HashMap<Long, List<MultiMsgNick>> lB = new HashMap();
  public HashMap<ChatMessage, Boolean> lC = new HashMap();
  public HashMap<String, String> lD = new HashMap();
  private boolean mEnable = true;
  public ArrayList<ChatMessage> xL = new ArrayList();
  
  private void Re(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "updateFinishMask mask: " + paramInt);
    }
    this.djx ^= paramInt;
  }
  
  public static ajlc a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new ajlc();
      }
      return a;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, int paramInt2, @Nullable Bundle paramBundle)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)paramArrayList.get(0);
    aool localaool = new aool();
    localaool.mSelfUin = paramQQAppInterface.getAccount();
    localaool.mPeerUin = paramString;
    localaool.mUinType = paramInt1;
    localaool.mFileType = 2;
    localaool.mUniseq = ((MessageRecord)paramArrayList.get(0)).uniseq;
    localaool.cNy = true;
    String str;
    boolean bool;
    if (paramBundle != null)
    {
      str = paramBundle.getString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH");
      localaool.dQ = str;
      localaool.mBusiType = 1002;
      if ((paramBundle != null) && (!paramBundle.getBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED"))) {
        break label220;
      }
      bool = true;
      label117:
      localaool.cNF = bool;
      if (paramBundle == null) {
        break label226;
      }
    }
    label220:
    label226:
    for (int k = eK(paramBundle.getInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE"));; k = 0)
    {
      localaool.dQL = k;
      localaool.F = ((MessageRecord)paramArrayList.get(0));
      localMessageForPtt.mInputContent = "";
      localaool.jdField_b_of_type_Akyf = new ajlc.c(paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramInt2, this, null);
      localaool.cMb = false;
      paramQQAppInterface.a().a(localaool);
      return;
      str = localMessageForPtt.fullLocalPath;
      break;
      bool = false;
      break label117;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, achq paramachq, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg_TAG", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg_TAG", 4, paramArrayList.toString());
    }
    paramachq = paramQQAppInterface.a().b().a(paramArrayList, paramHashMap, paramBoolean);
    if (paramachq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "pack multi msg failed.............................");
      }
      if (paramInt2 == 2) {
        ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(8031, false, Integer.valueOf(4));
      }
    }
    do
    {
      return;
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().e(paramString, paramInt1, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramInt1), false, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "pack multi msg done.............................");
      }
      if (paramInt2 == 0) {
        paramHashMap = new ajlc.b(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
      }
      for (;;)
      {
        if (c(paramQQAppInterface, paramachq, paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt1, paramMessageRecord.uniseq, 1035, paramHashMap))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg_TAG", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
          return;
          if (paramInt2 == 2)
          {
            paramHashMap = new ajlc.a(paramQQAppInterface, paramMessageRecord, paramString, paramInt1, paramArrayList, paramHashMap);
          }
          else if (paramInt2 == 5)
          {
            paramHashMap = new alte.a(paramQQAppInterface, paramMessageRecord, paramString, paramInt1);
          }
          else
          {
            QLog.e("MultiMsg_TAG", 1, "not support forwardMode:" + paramInt2);
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "sendMultiMsg failed.......................");
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<akxm> paramArrayList1, int paramInt2)
  {
    akxq localakxq = akxj.a(8, 7);
    localakxq.eF(paramArrayList1);
    localakxq.b(new ajld(this, paramInt2, paramMessageRecord, paramArrayList, paramQQAppInterface, paramString, paramInt1, paramHashMap));
    akxj.a(localakxq, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<anfw> paramArrayList1, angi paramangi, int paramInt2)
  {
    angi localangi = paramangi;
    if (paramangi == null) {
      localangi = anfr.a(5, 5);
    }
    localangi.eF(paramArrayList1);
    localangi.b(new ajle(this, paramArrayList, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramHashMap, paramInt2));
    anfr.a(localangi, paramQQAppInterface);
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().e(paramString, paramInt, paramMessageRecord.uniseq);
    paramQQAppInterface.b().b(paramString, paramInt, paramMessageRecord.uniseq, 32768, -1);
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  /* Error */
  private void aL(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +39 -> 44
    //   8: ldc 115
    //   10: iconst_2
    //   11: new 55	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 412
    //   21: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: lload_1
    //   25: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: ldc_w 417
    //   31: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 419	ajlc:j	Laure;
    //   48: ifnull +40 -> 88
    //   51: aload_0
    //   52: getfield 419	ajlc:j	Laure;
    //   55: lload_1
    //   56: iconst_0
    //   57: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 424	aure:get	(JLjava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 299	java/lang/Integer
    //   66: invokevirtual 428	java/lang/Integer:intValue	()I
    //   69: iload_3
    //   70: ixor
    //   71: istore_3
    //   72: iload_3
    //   73: ifeq +18 -> 91
    //   76: aload_0
    //   77: getfield 419	ajlc:j	Laure;
    //   80: lload_1
    //   81: iload_3
    //   82: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 432	aure:put	(JLjava/lang/Object;)V
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: aload_0
    //   92: getfield 419	ajlc:j	Laure;
    //   95: lload_1
    //   96: invokevirtual 436	aure:remove	(J)V
    //   99: goto -11 -> 88
    //   102: astore 4
    //   104: aload_0
    //   105: monitorexit
    //   106: aload 4
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ajlc
    //   0	109	1	paramLong	long
    //   0	109	3	paramInt	int
    //   102	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	102	finally
    //   44	72	102	finally
    //   76	88	102	finally
    //   91	99	102	finally
  }
  
  private boolean c(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, akyf paramakyf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[sendMultiMsg]data.length = " + paramArrayOfByte.length);
    }
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.mFileType = 131078;
    localaool.dPD = 0;
    localaool.fT = paramArrayOfByte;
    localaool.mSelfUin = paramString1;
    localaool.mPeerUin = paramString2;
    localaool.cmn = paramString3;
    localaool.mUinType = paramInt1;
    localaool.mUniseq = paramLong;
    localaool.mBusiType = paramInt2;
    localaool.jdField_b_of_type_Akyf = paramakyf;
    paramQQAppInterface.a().a(localaool);
    return true;
  }
  
  private boolean cm(long paramLong)
  {
    for (;;)
    {
      try
      {
        boolean bool2;
        if (this.j == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished map null and res: false");
          }
          bool2 = false;
          return bool2;
        }
        boolean bool1;
        if (((Integer)this.j.get(paramLong, Integer.valueOf(0))).intValue() == 0)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MultiMsg_TAG", 2, "isReceiptMessageFinished res: " + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  private void dye()
  {
    try
    {
      if (this.j == null) {
        this.j = new aure();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int eK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static long gp()
  {
    File localFile = new File(bQH);
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  public static String x(QQAppInterface paramQQAppInterface)
  {
    if (!new File(bQH).exists())
    {
      aqhq.l(paramQQAppInterface.getApp(), 2130842325, bQH);
      paramQQAppInterface = aqhq.px(bQH);
      paramQQAppInterface = aoiz.getFilePath("chatthumb:" + paramQQAppInterface);
      aqhq.copyFile(bQH, paramQQAppInterface);
    }
    return bQH;
  }
  
  public int Gq()
  {
    if (this.djF != 7) {
      return this.djy;
    }
    return 50;
  }
  
  public int Gr()
  {
    return this.djE;
  }
  
  public boolean O(ChatMessage paramChatMessage)
  {
    Object localObject;
    ChatMessage localChatMessage;
    if ((paramChatMessage instanceof MessageForLongMsg))
    {
      localObject = this.lC.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.lC.get(localChatMessage) != null)) {
          return ((Boolean)this.lC.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if (paramChatMessage != null)
    {
      localObject = this.lC.keySet();
      if (((Set)localObject).contains(paramChatMessage)) {
        return ((Boolean)this.lC.get(paramChatMessage)).booleanValue();
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          boolean bool = ((Boolean)this.lC.get(localChatMessage)).booleanValue();
          this.lC.remove(localChatMessage);
          this.lC.put(paramChatMessage, Boolean.valueOf(bool));
          return bool;
        }
      }
    }
    return false;
  }
  
  public void Rd(int paramInt)
  {
    this.djE = paramInt;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramChatMessage1.istroop == 1) || (paramChatMessage1.istroop == 3000)) {
      if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
        if (paramChatMessage1.getId() <= paramChatMessage2.getId()) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return 1;
          if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
            return -1;
          }
          return 0;
        } while (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq);
        return -1;
        if (paramChatMessage1.time != paramChatMessage2.time) {
          break;
        }
      } while (paramChatMessage1.getId() > paramChatMessage2.getId());
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    } while (paramChatMessage1.time > paramChatMessage2.time);
    return -1;
  }
  
  public SessionInfo a()
  {
    return this.i;
  }
  
  public MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, " favorMultiMsg start: ");
    }
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = anbi.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, 0L, paramAbsStructMsg);
    paramQQAppInterface.isReMultiMsg = true;
    return (MessageForStructing)paramQQAppInterface;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    Object localObject;
    do
    {
      while (!paramQQAppInterface.hasNext())
      {
        do
        {
          return null;
          if (this.lB.size() > 0)
          {
            localObject = (List)this.lB.get(Long.valueOf(paramLong));
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                MultiMsgNick localMultiMsgNick = (MultiMsgNick)((Iterator)localObject).next();
                if ((localMultiMsgNick != null) && (paramString.equals(localMultiMsgNick.uin)) && (paramLong == localMultiMsgNick.uniseq)) {
                  return localMultiMsgNick.nick;
                }
              }
            }
          }
          this.lB.clear();
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager().query(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
        this.lB.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
      localObject = (MultiMsgNick)paramQQAppInterface.next();
    } while ((localObject == null) || (!paramString.equals(((MultiMsgNick)localObject).uin)) || (paramLong != ((MultiMsgNick)localObject).uniseq));
    return ((MultiMsgNick)localObject).nick;
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return b(paramQQAppInterface, paramLong, null, 0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList)
  {
    a(paramQQAppInterface, paramSessionInfo, paramArrayList, 0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList);
    ((ambj)paramQQAppInterface.getManager(326)).z(paramSessionInfo.aTl, paramArrayList);
    paramQQAppInterface.execute(new MultiMsgManager.1(this, localArrayList, paramQQAppInterface, paramSessionInfo, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.execute(new MultiMsgManager.5(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2)
  {
    a(paramQQAppInterface, paramString1, paramInt1, paramString2, paramAbsStructMsg, paramLong, paramBoolean, paramInt2, -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 4, " sendMultiMsg start uniseq =  " + paramLong);
    }
    Object localObject1;
    int k;
    Object localObject2;
    if (paramLong == 0L)
    {
      localObject1 = this.xL.iterator();
      k = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
          break label792;
        }
        k = 0;
      }
    }
    label525:
    label783:
    label792:
    for (;;)
    {
      break;
      if (k != 0) {
        anot.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.xL);
      localObject2 = new HashMap();
      ((HashMap)localObject2).putAll(this.lD);
      if (paramInt2 == 1)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.cZ = paramInt1;
        paramAbsStructMsg.aTl = paramString1;
        paramAbsStructMsg.troopUin = paramString2;
        a(paramQQAppInterface, paramAbsStructMsg, localArrayList, paramInt3);
        return;
      }
      if (paramInt2 == 2)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        k = amzo.seq;
        amzo.seq = k + 1;
        localObject1 = anbi.a(paramQQAppInterface, (String)localObject1, paramString1, (String)localObject1, 1040, k, paramAbsStructMsg);
        ((MessageRecord)localObject1).msg = ujt.a(localArrayList, (Map)localObject2);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          paramAbsStructMsg.forwardID = paramInt3;
          localObject3 = aqmf.a(paramQQAppInterface, paramString1, paramInt1, paramAbsStructMsg);
        }
        if (localObject3 == null) {
          break;
        }
        ((MessageRecord)localObject3).isReMultiMsg = true;
        wte.a().i(((MessageRecord)localObject3).uniseq, 0L, paramInt3);
        if (paramBoolean) {
          paramQQAppInterface.b().t(paramString1, paramInt1, paramLong);
        }
        Object localObject4;
        if ((paramInt2 == 0) || (paramInt2 == 2))
        {
          localObject1 = new ajlf();
          localObject4 = new SessionInfo();
          ((SessionInfo)localObject4).aTl = paramString1;
          ((SessionInfo)localObject4).cZ = paramInt1;
          if (paramInt2 == 2)
          {
            ((SessionInfo)localObject4).cZ = 1040;
            ((SessionInfo)localObject4).bPv = paramInt1;
          }
          ((SessionInfo)localObject4).troopUin = paramString2;
          ((ajlf)localObject1).action = 0;
          ((ajlf)localObject1).sessionInfo = ((SessionInfo)localObject4);
          ((ajlf)localObject1).Dr = localArrayList;
          ((ajlf)localObject1).mb = ((Map)localObject2);
          ((ajlf)localObject1).djJ = paramInt2;
          ((ajlf)localObject1).c = paramAbsStructMsg;
          ((ajlf)localObject1).j = ((MessageForStructing)localObject3);
          paramQQAppInterface.a().e((ajlf)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg_TAG", 2, String.format("step.sendRequest:msglistSize = %d", new Object[] { Integer.valueOf(localArrayList.size()) }));
          return;
          localArrayList = new ArrayList();
          localObject1 = paramQQAppInterface.a().b().k(paramLong).iterator();
          k = 1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof ChatMessage)) {
              localArrayList.add((ChatMessage)localObject2);
            }
            if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
              break label783;
            }
            k = 0;
          }
        }
        for (;;)
        {
          break label525;
          if (k != 0) {
            anot.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
          }
          localObject3 = new HashMap();
          localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject4).next();
            if (!((HashMap)localObject3).containsKey(localMessageRecord.senderuin))
            {
              localObject2 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (((String)localObject1).trim().length() != 0) {}
              }
              else
              {
                localObject2 = ajlg.me(localMessageRecord.senderuin);
              }
              ((HashMap)localObject3).put(localMessageRecord.senderuin, localObject2);
            }
          }
          localObject1 = null;
          localObject2 = localObject3;
          break;
          a(paramQQAppInterface, paramString1, paramInt1, localArrayList, (HashMap)localObject2, (MessageRecord)localObject3, paramInt2);
          return;
        }
        localObject1 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2)
  {
    a(paramQQAppInterface, paramString, paramInt1, paramArrayList, paramHashMap, paramMessageRecord, paramInt2, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, int paramInt2, @Nullable Bundle paramBundle)
  {
    if (paramMessageRecord == null) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.execute(new MultiMsgManager.2(this, paramArrayList, paramInt2, paramHashMap, paramMessageRecord, paramQQAppInterface, paramString, paramInt1, paramBundle));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int k = 0;; k = 1)
    {
      localHashMap.put("result", k + "");
      if (paramList == null) {
        break;
      }
      k = paramList.size();
      int m = a().e(paramList);
      localHashMap.put("msgCount", k + "");
      localHashMap.put("picCount", m + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.lC.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.lC.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.lC.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (this.djD != 0) {}
    String str1;
    do
    {
      do
      {
        return;
      } while ((this.djC != 0) && (akxo.b(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1));
      str1 = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mResid;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "preDownloadRes failed by empty resid!");
    return;
    String str2 = paramMessageForStructing.frienduin;
    int k = paramMessageForStructing.istroop;
    long l = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "preDownloadRes begin! touin:" + str2 + ",touinType:" + k + ",uniseq:" + l + ",fileKey:" + str1);
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.getCurrentAccountUin(), str2, str2, k, l, 1035, null);
  }
  
  /* Error */
  public void a(HashMap<String, String> paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_1
    //   5: invokevirtual 593	java/util/HashMap:size	()I
    //   8: ifle +177 -> 185
    //   11: new 100	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 101	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 912	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 521 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 526 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 530 1 0
    //   45: checkcast 914	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 917 1 0
    //   57: checkcast 604	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 920 1 0
    //   69: checkcast 604	java/lang/String
    //   72: astore 7
    //   74: new 599	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 624	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 602	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 608	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 611	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 801	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 617	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   119: invokevirtual 623	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 924	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 929	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   134: aload 5
    //   136: invokevirtual 690	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 526 1 0
    //   148: ifeq +38 -> 186
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 530 1 0
    //   160: checkcast 599	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 933	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: astore 5
    //   171: aload 5
    //   173: invokevirtual 936	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokevirtual 939	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   180: aload 4
    //   182: invokevirtual 942	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   185: return
    //   186: aload_1
    //   187: invokevirtual 945	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   190: aload_1
    //   191: invokevirtual 939	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   194: goto -14 -> 180
    //   197: astore 4
    //   199: aload_1
    //   200: invokevirtual 939	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: aload 4
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ajlc
    //   0	206	1	paramHashMap	HashMap<String, String>
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   169	3	5	localException	Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	169	java/lang/Exception
    //   141	166	169	java/lang/Exception
    //   186	190	169	java/lang/Exception
    //   130	141	197	finally
    //   141	166	197	finally
    //   171	176	197	finally
    //   186	190	197	finally
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, akxb paramakxb)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {}
      return false;
    }
    aool localaool = new aool();
    localaool.cNy = false;
    localaool.mFileType = 131078;
    localaool.cmp = paramString1;
    localaool.mSelfUin = paramString2;
    localaool.mPeerUin = paramString3;
    localaool.cmn = paramString4;
    localaool.mUinType = paramInt1;
    localaool.mUniseq = paramLong;
    localaool.mBusiType = paramInt2;
    localaool.jdField_b_of_type_Akxb = paramakxb;
    paramQQAppInterface.a().a(localaool);
    return true;
  }
  
  public boolean aqX()
  {
    return this.mEnable;
  }
  
  public List<ChatMessage> b(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.a().b().k(paramLong);
    if (paramString != null) {
      top.a(paramString, paramInt, (List)localObject, paramQQAppInterface);
    }
    paramQQAppInterface = new ArrayList();
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (MessageRecord)paramString.next();
      if ((localObject instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localObject;
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.structingMsg = anre.a(((MessageRecord)localObject).msgData);
        }
      }
      if ((localObject instanceof MessageForQQStoryComment)) {
        ((MessageForQQStoryComment)localObject).displayType = 1;
      }
      paramQQAppInterface.add((ChatMessage)localObject);
      if ((QLog.isColorLevel()) && ((localObject instanceof MessageForPic)))
      {
        localObject = (MessageForPic)localObject;
        QLog.d("MultiMsg_TAG", 2, "[chatPie.getMultiMsgList] = " + ((MessageForPic)localObject).toLogString() + " mr = " + ((MessageForPic)localObject).toString());
      }
    }
    return paramQQAppInterface;
  }
  
  public void b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return;
      Object localObject = this.lC.keySet();
      if (((Set)localObject).contains(paramChatMessage))
      {
        this.lC.put(paramChatMessage, Boolean.valueOf(paramBoolean));
        return;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq) {
          this.lC.put(localChatMessage, Boolean.valueOf(paramBoolean));
        }
      }
      for (int k = 1; k == 0; k = 0)
      {
        this.lC.put(paramChatMessage, Boolean.valueOf(paramBoolean));
        return;
      }
    }
  }
  
  public boolean c(ChatMessage paramChatMessage, int paramInt)
  {
    int m = getCheckedItemCount();
    int k;
    int n;
    if (this.djF == 7)
    {
      k = 1;
      n = m + k;
      if (n <= paramInt) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("isWillBeyondTotalLimit: hasCount = %d,willCheckCount = %d,willTotalCount = %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(n) }));
      }
      return bool;
      k = ajlg.f(paramChatMessage);
      break;
    }
  }
  
  public void ds(QQAppInterface paramQQAppInterface)
  {
    String str2;
    Object localObject;
    int k;
    if (paramQQAppInterface != null)
    {
      String str1 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_enable");
      paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      str2 = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      localObject = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxVideoNum");
      k = aqmj.ae(paramQQAppInterface.getCurrentUin(), "multimsg_config");
      if (k > 0) {
        this.djy = k;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "initLimitCount enable = " + str1 + " maxMsgNum = " + k + " maxPicNum " + str2);
      }
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      this.djz = Integer.parseInt(str2);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      try
      {
        this.djA = Integer.parseInt((String)localObject);
        paramQQAppInterface = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.MultiMsgConfig.name(), "100|10|0|0");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "initLimitCount delayConfi = " + paramQQAppInterface);
        }
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          localObject = new Integer[4];
          Arrays.fill((Object[])localObject, Integer.valueOf(0));
          if (DeviceProfileManager.a(paramQQAppInterface, (Object[])localObject, new DeviceProfileManager.e()) >= localObject.length)
          {
            if (localObject[0].intValue() >= 0)
            {
              this.crv = localObject[0].intValue();
              if (localObject[1].intValue() <= 0) {
                break label349;
              }
              k = localObject[1].intValue();
              this.djB = k;
            }
            if (localObject[2].intValue() < 0) {
              break label357;
            }
            k = localObject[2].intValue();
            this.djC = k;
            if (localObject[3].intValue() < 0) {
              break label365;
            }
            k = localObject[3].intValue();
            this.djD = k;
          }
        }
        this.mEnable = true;
        return;
        paramQQAppInterface = paramQQAppInterface;
        this.djz = 20;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          this.djA = 10;
          continue;
          label349:
          k = this.djB;
          continue;
          label357:
          k = this.djC;
          continue;
          label365:
          k = this.djD;
        }
      }
    }
  }
  
  public void dyd()
  {
    this.lC.clear();
  }
  
  public int e(Collection<ChatMessage> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int k = 0;
    Object localObject1;
    if (paramCollection.hasNext())
    {
      localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic)) {
        k += 1;
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            k += 1;
          }
        }
      }
      else
      {
        int m = k;
        if (((ChatMessage)localObject1).msgtype == -1036)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            m = k;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          m = k;
          for (;;)
          {
            k = m;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              m += 1;
            }
          }
          return k;
        }
        k = m;
      }
    }
  }
  
  public List<ChatMessage> fH()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.lC.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public boolean g(QQAppInterface paramQQAppInterface, long paramLong)
  {
    anot.b(paramQQAppInterface, "CliOper", "", "", "0X8006628", "0X8006628", 0, 1, 0, "", "", "", "");
    return a(paramQQAppInterface, paramLong).size() > 0;
  }
  
  public int getCheckedItemCount()
  {
    Iterator localIterator = this.lC.keySet().iterator();
    int k = 0;
    ChatMessage localChatMessage;
    int m;
    if (localIterator.hasNext())
    {
      localChatMessage = (ChatMessage)localIterator.next();
      if (!((Boolean)this.lC.get(localChatMessage)).booleanValue()) {
        break label112;
      }
      if (this.djF == 7)
      {
        m = 1;
        label64:
        k = m + k;
      }
    }
    label112:
    for (;;)
    {
      break;
      m = ajlg.f(localChatMessage);
      break label64;
      ajlg.o("checkMap.size = %d,count= %d", new Object[] { Integer.valueOf(this.lC.size()), Integer.valueOf(k) });
      return k;
    }
  }
  
  public boolean h(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramLong);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      Iterator localIterator1 = paramQQAppInterface.iterator();
      if (localIterator1.hasNext())
      {
        paramQQAppInterface = (ChatMessage)localIterator1.next();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 4, " isContainedNotExistPic ChatMessage = " + paramQQAppInterface.getClass().getName());
        }
        if ((paramQQAppInterface instanceof MessageForPic)) {
          paramQQAppInterface = (MessageForPic)paramQQAppInterface;
        }
        label99:
        Iterator localIterator2;
        Object localObject;
        for (;;)
        {
          if ((paramQQAppInterface != null) && (!aoop.a(null, paramQQAppInterface, 65537)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 4, " isContainedNotExistPic is = true ");
            }
            return true;
            if ((paramQQAppInterface instanceof MessageForMixedMsg))
            {
              localIterator2 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              localObject = null;
              label155:
              paramQQAppInterface = (QQAppInterface)localObject;
              if (!localIterator2.hasNext()) {
                continue;
              }
              paramQQAppInterface = (MessageRecord)localIterator2.next();
              if (!(paramQQAppInterface instanceof MessageForPic)) {
                break label406;
              }
            }
          }
        }
        label272:
        label403:
        label404:
        label406:
        for (paramQQAppInterface = (MessageForPic)paramQQAppInterface;; paramQQAppInterface = (QQAppInterface)localObject)
        {
          localObject = paramQQAppInterface;
          break label155;
          if (paramQQAppInterface.msgtype == -1036)
          {
            localIterator2 = ((MessageForLongMsg)paramQQAppInterface).longMsgFragmentList.iterator();
            localObject = null;
            Iterator localIterator3;
            do
            {
              do
              {
                paramQQAppInterface = (QQAppInterface)localObject;
                if (!localIterator2.hasNext()) {
                  break;
                }
                paramQQAppInterface = (MessageRecord)localIterator2.next();
              } while (!(paramQQAppInterface instanceof MessageForMixedMsg));
              localIterator3 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              paramQQAppInterface = (QQAppInterface)localObject;
              localObject = paramQQAppInterface;
            } while (!localIterator3.hasNext());
            localObject = (MessageRecord)localIterator3.next();
            if (!(localObject instanceof MessageForPic)) {
              break label403;
            }
            paramQQAppInterface = (MessageForPic)localObject;
          }
          for (;;)
          {
            break label272;
            if (!(paramQQAppInterface instanceof MessageForStructing)) {
              break label404;
            }
            paramQQAppInterface = ((MessageForStructing)paramQQAppInterface).structingMsg;
            if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructMsgForImageShare)))
            {
              localObject = ((StructMsgForImageShare)paramQQAppInterface).getFirstImageElement();
              if ((localObject != null) && (((ansu)localObject).j == null))
              {
                if (((ansu)localObject).d == null) {
                  ((ansu)localObject).d = ((StructMsgForImageShare)paramQQAppInterface);
                }
                ((ansu)localObject).j = ((ansu)localObject).a();
                paramQQAppInterface = ((ansu)localObject).j;
                break label99;
              }
            }
            paramQQAppInterface = null;
            break label99;
            break;
          }
          break;
        }
      }
    }
    return false;
  }
  
  public void lw(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (((ChatMessage)paramList.get(0)).isLongMsg()) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChatMessage)paramList.next();
        if (this.lC.containsKey(localObject)) {
          this.lC.remove(localObject);
        }
      }
    }
    Object localObject = this.lC.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)((Map.Entry)((Iterator)localObject).next()).getKey();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
        if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public void lx(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, a);
    }
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.i = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.i = null;
    return;
  }
  
  static class a
    implements akyf
  {
    MessageRecord D;
    int djI;
    HashMap<String, String> lF;
    String mToUin;
    WeakReference<QQAppInterface> n;
    ArrayList<MessageRecord> xP;
    
    public a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.D = paramMessageRecord;
      this.mToUin = paramString;
      this.djI = paramInt;
      this.xP = paramArrayList;
      this.lF = paramHashMap;
    }
    
    private Bitmap J(Bitmap paramBitmap)
    {
      Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      return localBitmap;
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      return null;
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      if (parama.result == 0) {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "send real struct msg for weixin done, cost : " + (System.currentTimeMillis() - ajlc.WI));
        }
      }
      for (;;)
      {
        String str2;
        Object localObject2;
        long l;
        try
        {
          String str1;
          String str3;
          if (this.djI == 0)
          {
            str1 = String.format(((QQAppInterface)this.n.get()).getApplication().getString(2131696072), new Object[] { aqgv.t((QQAppInterface)this.n.get(), ((QQAppInterface)this.n.get()).getCurrentUin()), aqgv.t((QQAppInterface)this.n.get(), this.mToUin) });
            str3 = this.D.msg;
            str2 = "https://mma.qq.com/jumpqq/forward2.html?rId=" + parama.uuid + "&fName=" + parama.md5;
            if (this.djI == 1)
            {
              i = 4;
              localObject2 = ((QQAppInterface)this.n.get()).getFaceBitmap(i, this.mToUin, (byte)1, false, 0);
              if (localObject2 != null) {
                continue;
              }
            }
          }
          else
          {
            str1 = String.format(((QQAppInterface)this.n.get()).getApplication().getString(2131696073), new Object[] { aqgv.d((QQAppInterface)this.n.get(), this.mToUin, this.djI) });
            continue;
          }
          if (this.djI != 3000) {
            break label584;
          }
          i = 101;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "send to weixin icon != null  ");
          }
          Object localObject1 = localObject2;
          if (this.djI == 3000) {
            localObject1 = J((Bitmap)localObject2);
          }
          localObject2 = String.valueOf(System.currentTimeMillis());
          WXShareHelper.a().d((String)localObject2, str1, (Bitmap)localObject1, str3, str2);
          l = parama.uuid.hashCode();
          parama = this.xP.iterator();
          if (parama.hasNext())
          {
            ((MessageRecord)parama.next()).msgseq = l;
            continue;
          }
          ((QQAppInterface)this.n.get()).a().b().a(this.xP, null);
        }
        catch (Exception parama)
        {
          parama.printStackTrace();
          return;
        }
        ajlc.a().a(this.lF, l, (QQAppInterface)this.n.get());
        ((MessageHandler)((QQAppInterface)this.n.get()).getBusinessHandler(0)).notifyUI(8031, false, Integer.valueOf(0));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MultiMsg_TAG", 2, "shareToWXFriend.transaction: " + (String)localObject2 + ", shareLink:" + str2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
        }
        ((MessageHandler)((QQAppInterface)this.n.get()).getBusinessHandler(0)).notifyUI(8031, false, Integer.valueOf(5));
        return;
        label584:
        int i = 1;
      }
    }
  }
  
  static class b
    implements akyf
  {
    MessageRecord D;
    int djI;
    String mToUin;
    WeakReference<QQAppInterface> n;
    
    public b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.D = paramMessageRecord;
      this.mToUin = paramString;
      this.djI = paramInt;
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      return null;
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      if (parama.result == 0)
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)this.D;
        localMessageForStructing.structingMsg.mResid = parama.uuid;
        localMessageForStructing.structingMsg.mFileName = String.valueOf(localMessageForStructing.uniseq);
        ((QQAppInterface)this.n.get()).b().c(this.mToUin, this.djI, localMessageForStructing.uniseq, localMessageForStructing.structingMsg.getBytes());
        ((QQAppInterface)this.n.get()).b().b(this.D, null);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "send real struct msg done, cost : " + (System.currentTimeMillis() - ajlc.WI));
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "upload multi msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr);
      }
      this.D.extraflag = 32768;
      ((QQAppInterface)this.n.get()).a().e(this.mToUin, this.djI, this.D.uniseq);
      parama = ((QQAppInterface)this.n.get()).b().a(this.mToUin, this.djI);
      if ((parama != null) && (parama.uniseq == this.D.uniseq)) {
        parama.extraflag = 32768;
      }
      parama = this.mToUin;
      int i = this.djI;
      long l = this.D.uniseq;
      ((MessageHandler)((QQAppInterface)this.n.get()).getBusinessHandler(0)).notifyUI(MessageHandler.gz(this.djI), false, new Object[] { parama, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
  }
  
  static class c
    implements akyf
  {
    private MessageRecord E;
    private ajlc b;
    private int djF;
    private int djI;
    private QQAppInterface mApp;
    private String mToUin;
    private ArrayList<MessageRecord> xb;
    
    private c(MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ajlc paramajlc)
    {
      this.E = paramMessageRecord;
      this.mApp = paramQQAppInterface;
      this.mToUin = paramString;
      this.djI = paramInt1;
      this.b = paramajlc;
      this.djF = paramInt2;
      this.xb = paramArrayList;
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      if (paramRichText != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack attachRichText2Msg with " + paramRichText.toString());
        }
        if (((this.xb.get(0) instanceof MessageForRichText)) && (((MessageForRichText)this.xb.get(0)).richText == null)) {
          if (QLog.isColorLevel()) {
            break label185;
          }
        }
        for (;;)
        {
          ((MessageForRichText)this.xb.get(0)).richText = paramRichText;
          if (!(this.xb.get(0) instanceof MessageForPtt)) {
            break label272;
          }
          if (((MessageForPtt)this.xb.get(0)).fileSize >= 0L) {
            break label211;
          }
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg with fileSize < 0");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
          paramRichText = Thread.currentThread().getStackTrace();
          int j = paramRichText.length;
          int i = 0;
          while (i < j)
          {
            QLog.d("MultiMsg_TAG", 2, new Object[] { paramRichText[i] });
            i += 1;
          }
          label185:
          QLog.d("MultiMsg_TAG", 2, "PttUploadCallback.attachRichText2Msg return but mr.richtext is null");
        }
        ((MessageForPtt)this.xb.get(0)).fileSize = 1L;
        for (;;)
        {
          label211:
          this.mApp.a().b().a(this.xb, null);
          ajlc.a(this.b, this.mApp, this.mToUin, this.djI, new HashMap(), this.E, null, this.xb, true, this.djF);
          return null;
          label272:
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback attachRichText2Msg but not message for ptt");
        }
      }
      QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack attachRichText2Msg with null");
      return null;
    }
    
    public void a(akyf.a parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack updateMsg with " + parama.toString());
      }
    }
    
    public void b(akyf.a parama)
    {
      if (parama.result != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "mPttUpCallBack onSend fail with " + parama.toString());
        }
        if ((this.xb.get(0) instanceof MessageForPtt))
        {
          if (((MessageForPtt)this.xb.get(0)).fileSize < 0L)
          {
            QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend with fileSize < 0");
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "start print stack trace ---------");
              parama = Thread.currentThread().getStackTrace();
              int j = parama.length;
              int i = 0;
              while (i < j)
              {
                QLog.d("MultiMsg_TAG", 2, new Object[] { parama[i] });
                i += 1;
              }
            }
          }
        }
        else {
          QLog.d("MultiMsg_TAG", 1, "PttUploadCallback onSend but no message for ptt");
        }
        this.mApp.a().b().a(this.xb, null);
        ajlc.a(this.b, this.E, this.mApp, this.mToUin, this.djI);
        return;
      }
      QLog.d("MultiMsg_TAG", 1, "mPttUpCallBack onSend result ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlc
 * JD-Core Version:    0.7.0.1
 */