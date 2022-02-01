import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.2;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.3;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class acsn
  implements acsj, acsk, Manager
{
  private acsg jdField_a_of_type_Acsg;
  private acsl jdField_a_of_type_Acsl;
  private acso jdField_a_of_type_Acso;
  public PeakAppInterface a;
  private volatile boolean bKa;
  private volatile boolean bKb;
  private volatile boolean bKc;
  private volatile boolean bKd;
  private xuh c;
  private ConcurrentHashMap<String, MessageRecord> eA;
  private ConcurrentHashMap<String, List<String>> ez;
  private volatile boolean isDestroy;
  private HashMap<String, String> jl;
  private HashMap<String, Integer> jm;
  private long totalFileSize;
  private List<acsf> xZ;
  
  public acsn()
  {
    cOr();
  }
  
  private void G(String paramString, List<MessageRecord> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramList = c(paramList);
      } while (paramList == null);
      dZ(paramString, ((Integer)paramList.first).intValue());
      paramString = b(paramString, (List)paramList.second);
    } while (paramString == null);
    H((String)paramString.first, (List)paramString.second);
  }
  
  private void Gc(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.ez != null)) {
      this.ez.remove(paramString);
    }
  }
  
  private void Gd(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.ez != null))
    {
      Object localObject = (List)this.ez.get(paramString);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = new ArrayList();
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Acsg.s();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          acsi localacsi = (acsi)localConcurrentHashMap.get(str1);
          if (localacsi != null)
          {
            localacsi.czS -= 1;
            if (localacsi.czS == 0)
            {
              String str2 = this.jdField_a_of_type_Acsg.a(localacsi);
              if (!TextUtils.isEmpty(str2))
              {
                this.totalFileSize += localacsi.fileSize;
                paramString.add(str2);
              }
              this.jdField_a_of_type_Acsg.Gb(str1);
            }
            else
            {
              this.jdField_a_of_type_Acsg.a(str1, localacsi);
            }
          }
        }
        this.jdField_a_of_type_Acsg.deleteFiles(paramString);
      }
    }
  }
  
  private void H(String paramString, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (this.ez == null)) {
      return;
    }
    if (this.ez.containsKey(paramString))
    {
      List localList = (List)this.ez.get(paramString);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramList.get(i);
        if (!localList.contains(str)) {
          localList.add(str);
        }
        i += 1;
      }
      this.ez.put(paramString, localList);
      return;
    }
    this.ez.put(paramString, paramList);
  }
  
  private boolean a(acsf paramacsf)
  {
    if ((paramacsf == null) || (this.c == null)) {}
    String str;
    do
    {
      return true;
      str = MessageRecord.getTableName(paramacsf.uin, paramacsf.messageType);
    } while (TextUtils.isEmpty(str));
    Gd(str);
    if (this.c != null) {
      this.c.cD(paramacsf.uin, paramacsf.messageType);
    }
    Gc(str);
    return true;
  }
  
  private boolean abZ()
  {
    return (this.jdField_a_of_type_Acsg != null) && (this.jdField_a_of_type_Acsg.abZ());
  }
  
  private boolean aca()
  {
    return (this.bKa) && (this.bKb) && (this.bKc);
  }
  
  private long ad(String paramString)
  {
    long l1 = 0L;
    long l3 = l1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.ez != null) {
        break label25;
      }
      l3 = l1;
    }
    label25:
    long l2;
    do
    {
      do
      {
        do
        {
          return l3;
          ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Acsg.s();
          Object localObject = (List)this.ez.get(paramString);
          l2 = l1;
          if (localObject != null)
          {
            l2 = l1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              for (;;)
              {
                l2 = l1;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                String str = (String)((Iterator)localObject).next();
                acsi localacsi = (acsi)localConcurrentHashMap.get(str);
                l2 = l1;
                if (localacsi != null)
                {
                  l2 = l1 + localacsi.fileSize;
                  localacsi.czS += 1;
                  this.jdField_a_of_type_Acsg.a(str, localacsi);
                }
                l1 = l2;
              }
            }
          }
          l3 = l2;
        } while (this.jm == null);
        l3 = l2;
      } while (!this.jm.containsKey(paramString));
      l3 = l2;
    } while (((Integer)this.jm.get(paramString)).intValue() <= 0);
    return l2 + ((Integer)this.jm.get(paramString)).intValue() * 200;
  }
  
  private Pair<String, List<String>> b(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return new Pair(paramString, localArrayList);
    }
    Iterator localIterator = paramList.iterator();
    label332:
    label350:
    label351:
    for (;;)
    {
      int i;
      if (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        i = paramList.msgtype;
        if (acsq.iH(i))
        {
          paramList = akvb.a(paramList);
          if ((paramList == null) || (!(paramList instanceof MessageForPic))) {
            break label332;
          }
          paramList = ((MessageForPic)paramList).getBiggestFilePath();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramList)) || (localArrayList.contains(paramList))) {
          break label351;
        }
        localArrayList.add(new File(paramList).getName());
        break;
        if (acsq.iI(i))
        {
          paramList = akvb.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
            if (!TextUtils.isEmpty(paramList)) {
              break label350;
            }
            paramList = ShortVideoUtils.d(localMessageForShortVideo);
          }
        }
        else if (acsq.iJ(i))
        {
          paramList = akvb.a(paramList);
          if (paramList != null) {
            paramList = ahbr.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, paramList);
          }
        }
        else if (acsq.iK(i))
        {
          paramList = akvb.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg)))
          {
            G(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
            paramList = "";
          }
        }
        else if (acsq.iL(i))
        {
          paramList = akvb.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForStructing)) && (ajlg.P((MessageForStructing)paramList))) {
            G(paramString, this.jdField_a_of_type_Acso.c(MessageRecord.class, "select * from mr_multimessage where msgseq=?", "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramList.uniseq) }));
          }
        }
        paramList = "";
        continue;
        return new Pair(paramString, localArrayList);
      }
    }
  }
  
  private Pair<Integer, List<MessageRecord>> c(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForText)) {
        i += 1;
      }
      for (;;)
      {
        break;
        localArrayList.add(localMessageRecord);
      }
    }
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  private void cOr()
  {
    this.jdField_a_of_type_Acso = new acso();
    AppInterface localAppInterface = this.jdField_a_of_type_Acso.getAppInterface();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
  }
  
  private void cOt()
  {
    this.jdField_a_of_type_Acso.c(0, this.jl);
    this.jdField_a_of_type_Acso.d(1, this.jl);
    this.bKa = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadNameList finish");
    }
    cOw();
  }
  
  private void cOu()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Acso.cG();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
      }
      this.bKb = true;
      cOw();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      G(str1, this.jdField_a_of_type_Acso.a(MessageRecord.class, str2, str1, null, null));
    }
    this.bKb = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord finish");
    }
    cOw();
  }
  
  private void cOv()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Acso.cH();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
      }
      this.bKc = true;
      cOw();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      G(str1, this.jdField_a_of_type_Acso.b(MessageRecord.class, str2, str1, null, null));
    }
    this.bKc = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord finish");
    }
    cOw();
  }
  
  private void cOw()
  {
    if ((aca()) && (abZ()))
    {
      if ((this.ez == null) || (this.eA == null) || (this.eA.size() <= 0)) {
        break label288;
      }
      Iterator localIterator = this.ez.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        acsf localacsf = new acsf();
        localObject = (MessageRecord)this.eA.get(localObject);
        if ((localObject != null) && (iG(((MessageRecord)localObject).istroop)))
        {
          localacsf.uin = ((MessageRecord)localObject).frienduin;
          localacsf.displayName = o((MessageRecord)localObject);
          localacsf.messageType = ((MessageRecord)localObject).istroop;
          localacsf.lastMsgTime = ((MessageRecord)localObject).time;
          localacsf.totalSize = ad(MessageRecord.getTableName(localacsf.uin, ((MessageRecord)localObject).istroop));
          if ((localacsf.totalSize > 0L) && (this.xZ != null))
          {
            localacsf.bqC = acsh.aV(localacsf.totalSize);
            this.xZ.add(localacsf);
          }
        }
      }
      if (this.eA != null) {
        this.eA.clear();
      }
      if (this.jl != null) {
        this.jl.clear();
      }
      if (this.jm != null) {
        this.jm.clear();
      }
      if (this.jdField_a_of_type_Acsl != null)
      {
        S(1);
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_Acsl.hQ(this.xZ);
      }
    }
    for (;;)
    {
      this.bKd = false;
      return;
      label288:
      if (this.jdField_a_of_type_Acsl != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
        }
        this.jdField_a_of_type_Acsl.hQ(this.xZ);
      }
    }
  }
  
  private void cOx()
  {
    this.bKd = false;
    this.isDestroy = true;
    this.bKb = false;
    this.bKc = false;
    this.bKa = false;
    this.totalFileSize = 0L;
    if (this.xZ != null)
    {
      this.xZ.clear();
      this.xZ = null;
    }
    if (this.ez != null)
    {
      this.ez.clear();
      this.ez = null;
    }
    if (this.eA != null)
    {
      this.eA.clear();
      this.eA = null;
    }
    if (this.jl != null)
    {
      this.jl.clear();
      this.jl = null;
    }
    if (this.jm != null)
    {
      this.jm.clear();
      this.jm = null;
    }
    if (this.jdField_a_of_type_Acso != null) {
      this.jdField_a_of_type_Acso.onDestroy();
    }
    if (this.jdField_a_of_type_Acsg != null) {
      this.jdField_a_of_type_Acsg.onDestroy();
    }
  }
  
  private void dZ(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jm != null))
    {
      if (this.jm.containsKey(paramString))
      {
        int i = ((Integer)this.jm.get(paramString)).intValue();
        this.jm.put(paramString, Integer.valueOf(i + paramInt));
      }
    }
    else {
      return;
    }
    this.jm.put(paramString, Integer.valueOf(paramInt));
  }
  
  private boolean iG(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1000) || (paramInt == 1004);
  }
  
  private void init()
  {
    this.isDestroy = false;
    this.ez = new ConcurrentHashMap();
    this.eA = new ConcurrentHashMap();
    this.xZ = new ArrayList();
    this.jl = new HashMap();
    this.jm = new HashMap();
    this.totalFileSize = 0L;
    this.jdField_a_of_type_Acso.a(this);
    this.jdField_a_of_type_Acsg = new acsg(this);
  }
  
  private String o(MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2;
    if ((paramMessageRecord == null) || (this.jl == null) || (this.jl.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramMessageRecord.frienduin;
      str1 = (String)this.jl.get(paramMessageRecord.frienduin + 0);
      continue;
      str1 = (String)this.jl.get(paramMessageRecord.frienduin + 1);
      continue;
      str1 = this.jdField_a_of_type_Acso.jB(paramMessageRecord.frienduin);
      continue;
      if (this.c != null)
      {
        str1 = this.c.getTroopMemberName(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
        continue;
        str1 = this.jdField_a_of_type_Acso.getDiscussMemberName(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
      }
    }
  }
  
  public void F(String paramString, List<? extends Entity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyMessageData messageRecordList is empty");
      }
    }
    while (!(paramList.get(0) instanceof MessageRecord)) {
      return;
    }
    G(paramString, paramList);
  }
  
  public List<acsf> S(int paramInt)
  {
    if (this.xZ != null) {
      Collections.sort(this.xZ, new acse(paramInt));
    }
    return this.xZ;
  }
  
  public void a(acsl paramacsl)
  {
    this.jdField_a_of_type_Acsl = paramacsl;
  }
  
  public void a(String paramString, Entity paramEntity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramEntity == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyLastMsg tableName or entity is null");
      }
    }
    while ((!(paramEntity instanceof MessageRecord)) || (this.eA == null)) {
      return;
    }
    this.eA.put(paramString, (MessageRecord)paramEntity);
  }
  
  public List<acsf> aR(List<acsf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.c == null)) {
      return this.xZ;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "deleteMessages");
    }
    ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      acsf localacsf = (acsf)paramList.next();
      if (this.xZ != null) {
        this.xZ.remove(localacsf);
      }
    }
    return this.xZ;
  }
  
  public void b(xuh paramxuh)
  {
    this.c = paramxuh;
  }
  
  public void cOq()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onScanFinish");
    }
    cOw();
  }
  
  public void cOs()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord");
    }
    if (this.bKd) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord isLoadingData");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_Acsl != null) {
          this.jdField_a_of_type_Acsl.onLoadStart();
        }
        cOx();
        init();
        try
        {
          this.bKd = true;
          this.jdField_a_of_type_Acsg.cOk();
          ThreadManager.getSubThreadHandler().post(new MessageCleanManager.1(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.2(this));
          ThreadManager.getFileThreadHandler().post(new MessageCleanManager.3(this));
          return;
        }
        catch (Exception localException)
        {
          if (this.jdField_a_of_type_Acsl != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MessageCleanManager", 2, "loadAllMessageRecord exception = " + localException.getMessage());
            }
            this.jdField_a_of_type_Acsl.hQ(this.xZ);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (this.jdField_a_of_type_Acsl == null);
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
    }
    this.jdField_a_of_type_Acsl.hQ(this.xZ);
  }
  
  public long eY()
  {
    return this.totalFileSize;
  }
  
  public void onDestroy()
  {
    cOx();
    this.jdField_a_of_type_Acsl = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsn
 * JD-Core Version:    0.7.0.1
 */