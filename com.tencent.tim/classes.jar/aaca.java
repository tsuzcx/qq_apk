import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.3;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;

public class aaca
{
  public static aabz a;
  public static Object ca = new Object();
  public static int cgc = 0;
  public static ArrayList<aaca.a> rW = new ArrayList();
  public static ArrayList<aabz.a> rX = new ArrayList();
  public static ArrayList<aabz.a> rY = new ArrayList(128);
  
  public static void K(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = aagd.getQQAppInterface();
    } while (localQQAppInterface == null);
    paramString2 = new aabz.a(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.ea("groupUin", paramString1);
    paramString2.cR("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static aabz.a a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    aabz.a locala = null;
    ??? = locala;
    if (ht(paramInt))
    {
      ??? = locala;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = locala;
      }
    }
    for (;;)
    {
      return ???;
      label32:
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord btype:" + paramInt + " bid:" + paramString + " dbstate:" + cgc);
      }
      if (cgc == 2)
      {
        locala = a(rY, paramInt, paramString);
        if (locala != null) {
          a(paramMessageRecord, locala, paramInt, paramString, true);
        }
        ??? = locala;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + locala);
        return locala;
      }
      if (paramInt != 2) {}
      synchronized (rW)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          rW.add(new aaca.a(paramInt, paramString, paramMessageRecord));
        }
        ??? = locala;
        if (cgc != 0) {
          continue;
        }
        ctF();
        return null;
      }
    }
  }
  
  public static aabz.a a(aabz.a parama1, aabz.a parama2)
  {
    if ((parama1 == null) || (parama2 == null)) {}
    while ((parama1.EP != parama2.EP) || (parama1.mBusinessId == null) || (!parama1.mBusinessId.equals(parama2.mBusinessId))) {
      return parama2;
    }
    int i;
    if (parama1.EP == 1)
    {
      i = parama2.S("state", 0);
      int j = parama1.S("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      parama2.cR("state", i);
      return parama2;
      parama2.bb = parama1.bb;
      return parama2;
    }
  }
  
  public static aabz.a a(ArrayList<aabz.a> paramArrayList, int paramInt, String paramString)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label75;
      }
      aabz.a locala = (aabz.a)paramArrayList.get(i);
      if ((locala != null) && (locala.EP == paramInt) && (locala.mBusinessId != null))
      {
        localObject = locala;
        if (locala.mBusinessId.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static void a(int paramInt, TroopTips0x857.GoldMsgTipsElem paramGoldMsgTipsElem, oidb_0x858.GoldMsgTipsElem paramGoldMsgTipsElem1)
  {
    if ((paramInt == 3000) && (paramGoldMsgTipsElem1 != null)) {
      if (!paramGoldMsgTipsElem1.type.has()) {
        break label310;
      }
    }
    label300:
    label310:
    for (paramInt = paramGoldMsgTipsElem1.type.get();; paramInt = 0)
    {
      if (paramGoldMsgTipsElem1.billno.has()) {}
      for (paramGoldMsgTipsElem = paramGoldMsgTipsElem1.billno.get();; paramGoldMsgTipsElem = null)
      {
        int i = paramInt;
        Object localObject = paramGoldMsgTipsElem;
        if (paramGoldMsgTipsElem1.action.has())
        {
          i = paramGoldMsgTipsElem1.action.get();
          if (QLog.isColorLevel()) {
            QLog.i("NotifyMsgManager", 2, "onReceiveAAPaySysNotify type:" + paramInt + " billno:" + paramGoldMsgTipsElem + " action:" + i);
          }
          if (paramInt != 3)
          {
            label123:
            do
            {
              return;
            } while (((paramInt != 1) && (paramInt != 0)) || (paramGoldMsgTipsElem == null));
            if (!paramGoldMsgTipsElem.type.has()) {
              break label300;
            }
          }
        }
        for (paramInt = paramGoldMsgTipsElem.type.get();; paramInt = 0)
        {
          if (paramGoldMsgTipsElem.billno.has()) {}
          for (paramGoldMsgTipsElem1 = paramGoldMsgTipsElem.billno.get();; paramGoldMsgTipsElem1 = null)
          {
            i = paramInt;
            localObject = paramGoldMsgTipsElem1;
            if (paramGoldMsgTipsElem.action.has())
            {
              i = paramGoldMsgTipsElem.action.get();
              paramGoldMsgTipsElem = paramGoldMsgTipsElem1;
              break;
              paramGoldMsgTipsElem1 = aagd.getQQAppInterface();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new aabz.a(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((aabz.a)localObject).cR("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (aabz.a)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(aacb.class, 1, true, (Bundle)localObject);
              return;
            }
            int j = 0;
            paramGoldMsgTipsElem = (TroopTips0x857.GoldMsgTipsElem)localObject;
            paramInt = i;
            i = j;
            break;
          }
        }
      }
    }
  }
  
  protected static void a(long paramLong, aabz.a parama)
  {
    if ((parama == null) || (!ht(parama.EP)) || (TextUtils.isEmpty(parama.mBusinessId))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(rY, parama.EP, parama.mBusinessId);
        if (localObject != null) {
          break;
        }
        if (cgc == 2)
        {
          rY.add(parama);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(parama);
          y((ArrayList)localObject, true);
          return;
        }
        localObject = a(rX, parama.EP, parama.mBusinessId);
        if (localObject == null) {
          rX.add(parama);
        }
        while (cgc == 0)
        {
          ctF();
          return;
          a(parama, (aabz.a)localObject);
        }
      }
    } while (parama.EP == 2);
    a(parama, (aabz.a)localObject);
    parama = new ArrayList();
    parama.add(localObject);
    y(parama, false);
  }
  
  public static void a(aaca.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((parama != null) && (parama.o != null))
    {
      localQQAppInterface = aagd.getQQAppInterface();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", parama.EP);
      localBundle.putString("bid", parama.mBusinessId);
      localQQAppInterface.notifyObservers(aacb.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + parama.EP + " bid:" + parama.mBusinessId);
  }
  
  protected static boolean a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < rW.size())
      {
        aaca.a locala = (aaca.a)rW.get(i);
        if ((locala != null) && (locala.EP == paramInt) && (locala.mBusinessId != null) && (locala.mBusinessId.equals(paramString)) && (locala.o == paramMessageRecord)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord, aabz.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    aabz.a locala;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        locala = parama;
        if (parama == null) {
          locala = a(rY, paramInt, paramString);
        }
        if (locala == null) {
          break label239;
        }
        i = locala.S("state", -1);
        parama = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(parama)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(parama).intValue();
        if ((i == -1) || (i == paramInt)) {
          break label239;
        }
        paramMessageRecord.saveExtInfoToExtStr("qqpay_state", String.valueOf(i));
        bool = true;
        if ((bool) && (paramBoolean)) {
          ThreadManager.post(new NotifyMsgManager.3(paramMessageRecord), 5, null, false);
        }
        return bool;
      }
      catch (Exception parama)
      {
        if (QLog.isColorLevel()) {
          parama.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        locala = parama;
        if (parama == null) {
          locala = a(rY, paramInt, paramString);
        }
        if ((locala != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          parama = (MessageForQQWalletMsg)paramMessageRecord;
          if ((parama.mQQWalletRedPacketMsg != null) && (parama.mQQWalletRedPacketMsg.isOpened))
          {
            parama.mQQWalletRedPacketMsg.isOpened = true;
            parama.msgData = parama.getBytes();
            paramString = aagd.getQQAppInterface();
            if (paramString != null) {
              paramString.b().c(parama.frienduin, parama.istroop, parama.uniseq, parama.msgData);
            }
          }
        }
      }
      label239:
      boolean bool = false;
    }
  }
  
  protected static ArrayList<aabz.a> b(ArrayList<aabz.a> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      aabz.a locala = (aabz.a)paramArrayList.get(i);
      if ((locala != null) && (locala.EP == paramInt)) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void beA()
  {
    if (cgc == 0) {
      ctF();
    }
  }
  
  protected static void ctF()
  {
    cgc = 1;
    ThreadManager.post(new NotifyMsgManager.1(), 10, null, false);
  }
  
  protected static boolean ht(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  public static void hx(List<aaca.a> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aaca.a locala = (aaca.a)paramList.next();
        if ((locala != null) && (a(locala.o, null, locala.EP, locala.mBusinessId, false))) {
          localArrayList.add(locala);
        }
      }
    } while (localArrayList.size() <= 0);
    ThreadManager.post(new NotifyMsgManager.2(localArrayList), 5, null, false);
  }
  
  public static ArrayList<aabz.a> n(int paramInt)
  {
    if (!ht(paramInt)) {}
    label69:
    do
    {
      return null;
      if (cgc == 2)
      {
        ArrayList localArrayList = b(rY, paramInt);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("queryRecordsInMemory size:");
          if (localArrayList == null) {
            break label69;
          }
        }
        for (paramInt = localArrayList.size();; paramInt = 0)
        {
          QLog.i("NotifyMsgManager", 2, paramInt);
          return localArrayList;
        }
      }
    } while (cgc != 0);
    ctF();
    return null;
  }
  
  public static void onActiveAccount()
  {
    cgc = 0;
    rY.clear();
    rW.clear();
    rX.clear();
    if (a != null) {}
    try
    {
      a.close();
      a = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void y(ArrayList<aabz.a> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static class a
  {
    public int EP;
    public String mBusinessId;
    public MessageRecord o;
    
    public a(int paramInt, String paramString, MessageRecord paramMessageRecord)
    {
      this.EP = paramInt;
      this.mBusinessId = paramString;
      this.o = paramMessageRecord;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaca
 * JD-Core Version:    0.7.0.1
 */