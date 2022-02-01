import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessManager.1;
import com.tencent.mobileqq.confess.ConfessManager.2;
import com.tencent.mobileqq.confess.ConfessManager.3;
import com.tencent.mobileqq.confess.ConfessManager.4;
import com.tencent.mobileqq.confess.ConfessManager.5;
import com.tencent.mobileqq.confess.ConfessManager.6;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONObject;

public class aegs
  implements Manager
{
  final aego jdField_a_of_type_Aego;
  aegp jdField_a_of_type_Aegp;
  public aegs.a a;
  public aegs.b a;
  public final aehb a;
  aegs.a jdField_b_of_type_Aegs$a = null;
  aegs.b jdField_b_of_type_Aegs$b = null;
  final Object dn = new Object();
  final Object jdField_do = new Object();
  public QQAppInterface mApp;
  final ArrayList<aegs.a> vi;
  final ArrayList<aegs.b> vj;
  
  public aegs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aegs$a = null;
    this.jdField_a_of_type_Aegs$b = null;
    this.mApp = paramQQAppInterface;
    this.vi = new ArrayList();
    this.jdField_a_of_type_Aehb = new aehb(paramQQAppInterface.getAccount());
    this.jdField_a_of_type_Aego = new aego();
    this.jdField_a_of_type_Aegp = new aegp(this.mApp.getAccount());
    ThreadManager.post(new ConfessManager.1(this), 5, null, true);
    this.vj = new ArrayList();
  }
  
  private aegs.a a(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      synchronized (this.vi)
      {
        Object localObject = this.vi.iterator();
        if (((Iterator)localObject).hasNext())
        {
          locala = (aegs.a)((Iterator)localObject).next();
          if ((locala == null) || (locala.nTopicId != paramInt) || (!TextUtils.equals(locala.strRecUin, paramString1)) || (!TextUtils.equals(locala.strConfessorUin, paramString2))) {
            continue;
          }
          localObject = locala;
          if (locala == null)
          {
            localObject = new aegs.a();
            ((aegs.a)localObject).strRecUin = paramString1;
            ((aegs.a)localObject).strConfessorUin = paramString2;
            ((aegs.a)localObject).nTopicId = paramInt;
            ((aegs.a)localObject).flag = 0;
            this.vi.add(localObject);
          }
          return localObject;
        }
      }
      aegs.a locala = null;
    }
  }
  
  private aegs.b a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    for (;;)
    {
      synchronized (this.vj)
      {
        Object localObject = this.vj.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localb = (aegs.b)((Iterator)localObject).next();
          if ((localb == null) || (localb.nTopicId != paramInt) || (!TextUtils.equals(localb.strGroupUin, paramString1)) || (!TextUtils.equals(localb.strRecUin, paramString2)) || (!TextUtils.equals(localb.bxe, paramString3)) || (!TextUtils.equals(localb.strConfessorUin, paramString4))) {
            continue;
          }
          localObject = localb;
          if (localb == null)
          {
            localObject = new aegs.b();
            ((aegs.b)localObject).strGroupUin = paramString1;
            ((aegs.b)localObject).strRecUin = paramString2;
            ((aegs.b)localObject).bxe = paramString3;
            ((aegs.b)localObject).strConfessorUin = paramString4;
            ((aegs.b)localObject).nTopicId = paramInt;
            ((aegs.b)localObject).flag = 0;
            this.vj.add(localObject);
          }
          return localObject;
        }
      }
      aegs.b localb = null;
    }
  }
  
  public void Hn(String paramString)
  {
    Integer localInteger = null;
    aegs.a locala = this.jdField_a_of_type_Aegs$a;
    this.jdField_a_of_type_Aegs$a = null;
    if (locala != null)
    {
      this.jdField_b_of_type_Aegs$a = locala;
      if (locala.flag == 1) {
        ThreadManager.postImmediately(new ConfessManager.3(this, paramString, locala), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (locala != null) {
        break label89;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveFrdRecConfessChat frdUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label89:
      localInteger = Integer.valueOf(locala.flag);
    }
  }
  
  public void Ho(String paramString)
  {
    Integer localInteger = null;
    aegs.b localb = this.jdField_a_of_type_Aegs$b;
    this.jdField_a_of_type_Aegs$b = null;
    if (localb != null)
    {
      this.jdField_b_of_type_Aegs$b = localb;
      if (localb.flag == 1) {
        ThreadManager.postImmediately(new ConfessManager.5(this, paramString, localb), null, false);
      }
    }
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (localb != null) {
        break label89;
      }
    }
    for (;;)
    {
      QLog.i("ConfessManager", 4, String.format(localLocale, "leaveGroupRecConfessChat groupUin: %s, flag: %s", new Object[] { paramString, localInteger }));
      return;
      label89:
      localInteger = Integer.valueOf(localb.flag);
    }
  }
  
  public void M(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt).flag = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markFrdChatExtra recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1 = this.mApp.b().b(paramString1, 1, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) || (!TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkGroupNeedAddConfessElem groupUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, paramString4, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public aego a()
  {
    return this.jdField_a_of_type_Aego;
  }
  
  public aegp a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, "getConfigSync");
    }
    this.jdField_a_of_type_Aegp.initConfig();
    return this.jdField_a_of_type_Aegp;
  }
  
  public aegs.a a()
  {
    return this.jdField_a_of_type_Aegs$a;
  }
  
  public aegs.b a()
  {
    return this.jdField_a_of_type_Aegs$b;
  }
  
  public aehb a()
  {
    if (!this.jdField_a_of_type_Aehb.isInit) {
      this.jdField_a_of_type_Aehb.init();
    }
    return this.jdField_a_of_type_Aehb;
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    if (!this.jdField_a_of_type_Aehb.isInit) {
      this.jdField_a_of_type_Aehb.init();
    }
    if ((this.jdField_a_of_type_Aehb.Wd < paramRedTouchItem.lastRecvTime) || (this.jdField_a_of_type_Aehb.cMU != paramRedTouchItem.count)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_a_of_type_Aehb.b(paramRedTouchItem);
        aegu.d(this.mApp, false, false);
        ((aegq)this.mApp.getBusinessHandler(125)).b(this.jdField_a_of_type_Aehb);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "onFrdRecNewConfess bNeedUpdate: %s, info: %s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_Aehb }));
      return;
    }
  }
  
  public void a(String paramString, aegs.a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.dn)
      {
        if (parama.flag == 1)
        {
          paramString = this.mApp.b().b(paramString, 0, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == parama.nTopicId) && (TextUtils.equals(parama.strConfessorUin, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(parama.strRecUin, localMessageForConfessNews.strRecUin)))
                {
                  this.mApp.b().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.mApp.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeFrdConfessNews frdUin: %s confessorUin: %s topicId: %s", new Object[] { parama.strRecUin, parama.strConfessorUin, Integer.valueOf(parama.nTopicId) }));
  }
  
  public void a(String paramString, aegs.a parama, long paramLong1, long paramLong2)
  {
    if ((parama == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.dn)
      {
        if (parama.flag == 0) {
          parama.flag = b(paramString, parama.strRecUin, parama.strConfessorUin, parama.nTopicId);
        }
        int i = parama.flag;
        if (i == 1) {}
        try
        {
          String str = parama.toJsonStr();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = anbi.d(-2065);
            localMessageRecord.init(this.mApp.getCurrentAccountUin(), paramString, paramString, str, paramLong1, -2065, 0, paramLong2);
            localMessageRecord.isread = true;
            if (!achp.a(this.mApp, localMessageRecord, false)) {
              this.mApp.b().b(localMessageRecord, localMessageRecord.selfuin);
            }
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addFrdConfessNews frdUin: %s recUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, parama.strRecUin, parama.strConfessorUin, Integer.valueOf(parama.nTopicId) }));
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addFrdConfessNews error: " + localException.getMessage());
          }
        }
      }
    }
  }
  
  public void a(String paramString, aegs.b paramb)
  {
    if ((paramb == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      synchronized (this.jdField_do)
      {
        if (paramb.flag == 1)
        {
          paramString = this.mApp.b().b(paramString, 1, new int[] { -2065 });
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.next();
              if ((localMessageRecord instanceof MessageForConfessNews))
              {
                MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)localMessageRecord;
                localMessageForConfessNews.parse();
                if ((localMessageForConfessNews.nTopicId == paramb.nTopicId) && (TextUtils.equals(paramb.strGroupUin, localMessageForConfessNews.strGroupUin)) && (TextUtils.equals(paramb.strConfessorUin, localMessageForConfessNews.strConfessorUin)) && (TextUtils.equals(paramb.bxe, localMessageForConfessNews.senderuin)) && (TextUtils.equals(paramb.strRecUin, localMessageForConfessNews.strRecUin)))
                {
                  this.mApp.b().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
                  this.mApp.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
                }
              }
            }
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "removeGroupConfessNews groupUin: %s, strRecUin: %s, sendUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramb.strGroupUin, paramb.strRecUin, paramb.bxe, paramb.strConfessorUin, Integer.valueOf(paramb.nTopicId) }));
  }
  
  public void a(String paramString, aegs.b paramb, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramb == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      synchronized (this.jdField_do)
      {
        if (paramb.flag == 0) {
          paramb.flag = a(paramString, paramb.strRecUin, paramb.bxe, paramb.strConfessorUin, paramb.nTopicId);
        }
        int i = paramb.flag;
        if (i == 1) {}
        try
        {
          String str = paramb.toJsonStr();
          if (!TextUtils.isEmpty(str))
          {
            MessageRecord localMessageRecord = anbi.d(-2065);
            localMessageRecord.init(this.mApp.getCurrentAccountUin(), paramString, paramb.bxe, str, paramLong1, -2065, 1, paramLong2);
            localMessageRecord.isread = true;
            localMessageRecord.shmsgseq = paramLong3;
            if (QLog.isDevelopLevel()) {
              QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 1 %s", new Object[] { Long.valueOf(paramLong3) }));
            }
            if (!achp.a(this.mApp, localMessageRecord, false))
            {
              this.mApp.b().b(localMessageRecord, localMessageRecord.selfuin);
              if (QLog.isDevelopLevel()) {
                QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews in 2", new Object[0]));
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("ConfessManager", 1, "addGroupConfessNews error: " + localException.getMessage());
          }
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "addGroupConfessNews groupUin: %s recUin: %s, sendUin: %s, confessorUin: %s topicId: %s", new Object[] { paramString, paramb.strRecUin, paramb.bxe, paramb.strConfessorUin, Integer.valueOf(paramb.nTopicId) }));
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    Object localObject1 = this.vj.iterator();
    Object localObject2;
    boolean bool;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aegs.b)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((aegs.b)localObject2).nTopicId == paramInt) && (TextUtils.equals(((aegs.b)localObject2).strGroupUin, paramString1)) && (TextUtils.equals(((aegs.b)localObject2).strRecUin, paramString2)) && (TextUtils.equals(((aegs.b)localObject2).bxe, paramString3)) && (TextUtils.equals(((aegs.b)localObject2).strConfessorUin, paramString4))) {
          if (((aegs.b)localObject2).bTL)
          {
            ((aegs.b)localObject2).bTL = false;
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq find: " + bool + " shmsgseq: " + paramLong);
      }
      if (bool)
      {
        localObject1 = this.mApp.b().b(paramString1, 1, new int[] { -2065 });
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForConfessNews))
            {
              localObject2 = (MessageForConfessNews)localObject2;
              ((MessageForConfessNews)localObject2).parse();
              if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
              {
                this.mApp.b().a(((MessageForConfessNews)localObject2).frienduin, ((MessageForConfessNews)localObject2).istroop, ((MessageForConfessNews)localObject2).uniseq, paramLong, ((MessageForConfessNews)localObject2).time);
                if (QLog.isDevelopLevel()) {
                  QLog.i("ConfessManager", 4, "checkUpdateGroupMessageForConfessNewsShmsgseq updated");
                }
              }
            }
          }
        }
      }
      return;
      localObject1 = this.mApp.b().i(paramString1, 1, 6);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (MessageRecord)((List)localObject1).get(i);
          if ((localObject2 instanceof MessageForConfessNews))
          {
            localObject2 = (MessageForConfessNews)localObject2;
            ((MessageForConfessNews)localObject2).parse();
            if ((((MessageForConfessNews)localObject2).nTopicId == paramInt) && (TextUtils.equals(paramString1, ((MessageForConfessNews)localObject2).strGroupUin)) && (TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).senderuin)) && (TextUtils.equals(paramString4, ((MessageForConfessNews)localObject2).strConfessorUin)) && (TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)))
            {
              int j = i + 1;
              if (j < ((List)localObject1).size())
              {
                localObject2 = (MessageRecord)((List)localObject1).get(j);
                this.mApp.b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
              }
            }
          }
          i += 1;
        }
      }
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public boolean a(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str3 = paramIntent.getStringExtra("key_confess_desc");
    String str4 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    if ((!TextUtils.equals(paramString, str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)) || (i == 0)) {
      return false;
    }
    paramIntent = a(str1, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      paramIntent.strRecNick = str5;
    }
    paramIntent.strConfessorNick = str4;
    paramIntent.nConfessorSex = j;
    paramIntent.strConfessorDesc = str3;
    paramIntent.nBGType = k;
    paramIntent.confessTime = l;
    this.jdField_a_of_type_Aegs$a = paramIntent;
    if (paramIntent.flag != 2) {
      ThreadManager.postImmediately(new ConfessManager.2(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRecConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.flag) }));
    }
    return true;
  }
  
  public int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = this.mApp.b().b(paramString1, 0, new int[] { -2065 });
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof MessageForConfessNews));
        localObject2 = (MessageForConfessNews)localObject2;
        ((MessageForConfessNews)localObject2).parse();
      } while ((((MessageForConfessNews)localObject2).nTopicId != paramInt) || (!TextUtils.equals(paramString3, ((MessageForConfessNews)localObject2).strConfessorUin)) || (!TextUtils.equals(paramString2, ((MessageForConfessNews)localObject2).strRecUin)));
    }
    for (int i = 2;; i = 1)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "checkNeedAddConfessElem frdUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { paramString1, paramString3, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
    }
  }
  
  public aegp b()
  {
    return this.jdField_a_of_type_Aegp;
  }
  
  public boolean b(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null) || (this.mApp == null)) {
      return false;
    }
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str1 = paramIntent.getStringExtra("key_confess_desc");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    String str3 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confess_bg_type", 0);
    String str4 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str5 = paramIntent.getStringExtra("key_confess_rec_nick_name");
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    int m = paramIntent.getIntExtra("key_confess_rec_nick_type", 0);
    paramIntent = this.mApp.getCurrentUin();
    if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)) || (i == 0)) {
      return false;
    }
    aegs.b localb = a(paramString, str4, paramIntent, str2, i);
    if (!TextUtils.isEmpty(str5)) {
      localb.strRecNick = str5;
    }
    localb.strConfessorNick = str3;
    localb.nConfessorSex = j;
    localb.strConfessorDesc = str1;
    localb.nBGType = k;
    localb.confessTime = l;
    localb.nRecNickType = m;
    this.jdField_a_of_type_Aegs$b = localb;
    if (localb.flag != 2) {
      ThreadManager.postImmediately(new ConfessManager.4(this, paramString, localb), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat recUin: %s, sendUin: %s, confessorUin: %s, topicId: %s, flag: %s", new Object[] { str4, paramIntent, str2, Integer.valueOf(i), Integer.valueOf(localb.flag) }));
    }
    return true;
  }
  
  public boolean c(String paramString, Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntent == null)) {
      return false;
    }
    String str1 = paramIntent.getStringExtra("key_confess_rec_uin");
    String str2 = paramIntent.getStringExtra("key_confessor_uin");
    int i = paramIntent.getIntExtra("key_confess_topicid", 0);
    String str3 = paramIntent.getStringExtra("key_confessor_nick");
    int j = paramIntent.getIntExtra("key_confessor_sex", 0);
    int k = paramIntent.getIntExtra("key_confessor_friend_sex", 0);
    String str4 = paramIntent.getStringExtra("key_confess_desc");
    int m = paramIntent.getIntExtra("key_confess_bg_type", 0);
    long l = paramIntent.getLongExtra("key_confess_time", 0L);
    int n = paramIntent.getIntExtra("key_confessor_num", 0);
    if ((!TextUtils.equals(paramString, str1)) || (TextUtils.isEmpty(str4)) || (i == 0)) {
      return false;
    }
    paramIntent = a(str1, str2, i);
    paramIntent.nConfessorSex = j;
    paramIntent.nGetConfessSex = k;
    paramIntent.strConfessorDesc = str4;
    paramIntent.strConfessorNick = str3;
    paramIntent.nBGType = m;
    paramIntent.confessTime = l;
    paramIntent.nConfessNum = n;
    paramIntent.nBizType = 1;
    this.jdField_a_of_type_Aegs$a = paramIntent;
    if (paramIntent.flag != 2) {
      ThreadManager.postImmediately(new ConfessManager.6(this, paramString), null, false);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterFrdRankConfessChat recUin: %s, confessorUin: %s, topicId: %s, flag: %s, friendSex: %s, extra.strConfessorNick : %s", new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramIntent.flag), Integer.valueOf(k), paramIntent.strConfessorNick }));
    }
    return true;
  }
  
  public void d(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramInt).flag = 2;
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "markGroupChatExtra groupUin: %s recUin: %s, confessorUin: %s, topicId: %s", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt) }));
    }
  }
  
  public boolean lA(String paramString)
  {
    aegs.b localb = this.jdField_a_of_type_Aegs$b;
    if ((TextUtils.isEmpty(paramString)) || (localb == null) || (!TextUtils.equals(localb.strGroupUin, paramString))) {
      return false;
    }
    if (localb.flag == 0) {
      localb.flag = a(paramString, localb.strRecUin, localb.bxe, localb.strConfessorUin, localb.nTopicId);
    }
    return localb.flag == 1;
  }
  
  public boolean lz(String paramString)
  {
    boolean bool = true;
    aegs.a locala = this.jdField_a_of_type_Aegs$a;
    if ((TextUtils.isEmpty(paramString)) || (locala == null) || (!TextUtils.equals(locala.strRecUin, paramString))) {
      bool = false;
    }
    do
    {
      return bool;
      if (locala.flag == 0) {
        locala.flag = b(paramString, locala.strRecUin, locala.strConfessorUin, locala.nTopicId);
      }
    } while (locala.flag == 1);
    return false;
  }
  
  public void onDestroy() {}
  
  public static class a
  {
    public long confessTime;
    public int flag;
    public int nBGType;
    public int nBizType;
    public int nConfessNum;
    public int nConfessorSex;
    public int nGetConfessSex;
    public int nTopicId;
    public String strConfessorDesc;
    public String strConfessorNick;
    public String strConfessorUin;
    public String strRecNick;
    public String strRecUin;
    
    public static a a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      a locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.nTopicId = paramString.optInt("nTopicId");
        locala.nBGType = paramString.optInt("nBGType");
        locala.nConfessorSex = paramString.optInt("nConfessorSex");
        locala.strRecNick = paramString.optString("strRecNick");
        locala.strRecUin = paramString.optString("strRecUin");
        locala.strConfessorUin = paramString.optString("strConfessorUin");
        locala.strConfessorDesc = paramString.optString("strConfessorDesc");
        locala.strConfessorNick = paramString.optString("strConfessorNick");
        locala.flag = paramString.optInt("flag");
        locala.confessTime = paramString.optInt("confessTime");
        locala.nConfessNum = paramString.optInt("nConfessNum");
        locala.nGetConfessSex = paramString.optInt("nGetConfessSex");
        locala.nBizType = paramString.optInt("nBizType");
        return locala;
      }
      catch (Exception paramString) {}
      return null;
    }
    
    public String toJsonStr()
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("nTopicId", this.nTopicId);
        ((JSONObject)localObject).put("nBGType", this.nBGType);
        ((JSONObject)localObject).put("nConfessorSex", this.nConfessorSex);
        ((JSONObject)localObject).put("strRecNick", this.strRecNick);
        ((JSONObject)localObject).put("strRecUin", this.strRecUin);
        ((JSONObject)localObject).put("strConfessorUin", this.strConfessorUin);
        ((JSONObject)localObject).put("strConfessorDesc", this.strConfessorDesc);
        ((JSONObject)localObject).put("strConfessorNick", this.strConfessorNick);
        ((JSONObject)localObject).put("flag", this.flag);
        ((JSONObject)localObject).put("confessTime", this.confessTime);
        ((JSONObject)localObject).put("nConfessNum", this.nConfessNum);
        ((JSONObject)localObject).put("nGetConfessSex", this.nGetConfessSex);
        ((JSONObject)localObject).put("nBizType", this.nBizType);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return "";
    }
  }
  
  public static class b
  {
    public boolean bTL;
    public String bxe;
    public long confessTime;
    public int flag;
    public int nBGType;
    public int nConfessorSex;
    public int nRecNickType;
    public int nTopicId;
    public String strConfessorDesc;
    public String strConfessorNick;
    public String strConfessorUin;
    public String strGroupUin;
    public String strRecNick;
    public String strRecUin;
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      b localb = new b();
      try
      {
        paramString = new JSONObject(paramString);
        localb.strGroupUin = paramString.optString("strGroupUin");
        localb.bxe = paramString.optString("strSendUin");
        localb.nTopicId = paramString.optInt("nTopicId");
        localb.nBGType = paramString.optInt("nBGType");
        localb.nConfessorSex = paramString.optInt("nConfessorSex");
        localb.strRecNick = paramString.optString("strRecNick");
        localb.nRecNickType = paramString.optInt("nRecNickType");
        localb.strRecUin = paramString.optString("strRecUin");
        localb.strConfessorUin = paramString.optString("strConfessorUin");
        localb.strConfessorDesc = paramString.optString("strConfessorDesc");
        localb.strConfessorNick = paramString.optString("strConfessorNick");
        localb.flag = paramString.optInt("flag");
        localb.confessTime = paramString.optInt("confessTime");
        localb.bTL = paramString.optBoolean("isRandomShmsgseq");
        return localb;
      }
      catch (Exception paramString) {}
      return null;
    }
    
    public String toJsonStr()
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("strGroupUin", this.strGroupUin);
        ((JSONObject)localObject).put("strSendUin", this.bxe);
        ((JSONObject)localObject).put("nTopicId", this.nTopicId);
        ((JSONObject)localObject).put("nBGType", this.nBGType);
        ((JSONObject)localObject).put("nConfessorSex", this.nConfessorSex);
        ((JSONObject)localObject).put("strRecNick", this.strRecNick);
        ((JSONObject)localObject).put("nRecNickType", this.nRecNickType);
        ((JSONObject)localObject).put("strRecUin", this.strRecUin);
        ((JSONObject)localObject).put("strConfessorUin", this.strConfessorUin);
        ((JSONObject)localObject).put("strConfessorDesc", this.strConfessorDesc);
        ((JSONObject)localObject).put("strConfessorNick", this.strConfessorNick);
        ((JSONObject)localObject).put("flag", this.flag);
        ((JSONObject)localObject).put("confessTime", this.confessTime);
        ((JSONObject)localObject).put("isRandomShmsgseq", this.bTL);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegs
 * JD-Core Version:    0.7.0.1
 */