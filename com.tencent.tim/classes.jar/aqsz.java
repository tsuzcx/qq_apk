import QC.GetUsrKeyWordInfoRsp;
import QC.OneKeyWordItemClient;
import QC.UniLoginCheckRsp;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopKeyWord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.troopkeyword.ExpireSet;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aqsz
{
  private static int enable = -1;
  private QQAppInterface app;
  private long atK;
  private EntityManager em;
  private Object fz = new Object();
  private boolean hasLoaded;
  private ConcurrentHashMap<String, List<TroopKeyWord>> jf = new ConcurrentHashMap();
  
  public aqsz(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.app = paramQQAppInterface;
    this.em = paramEntityManager;
  }
  
  private void M(HashMap<String, List<TroopKeyWord>> paramHashMap)
  {
    synchronized (this.jf)
    {
      Iterator localIterator = this.jf.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!paramHashMap.containsKey(str)) {
          this.jf.remove(str);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "updateKeywords: " + paramHashMap);
    }
    this.jf.putAll(paramHashMap);
    this.hasLoaded = true;
    efq();
  }
  
  public static aqsz a(QQAppInterface paramQQAppInterface)
  {
    return ((aqrc)paramQQAppInterface.getManager(235)).a;
  }
  
  public static boolean bj(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramMessageRecord instanceof QQMessageFacade.Message))
    {
      bool1 = bool2;
      if (((QQMessageFacade.Message)paramMessageRecord).bizType == 16) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void efp()
  {
    if (this.hasLoaded) {
      return;
    }
    synchronized (this.jf)
    {
      if (this.hasLoaded) {
        return;
      }
    }
    Object localObject2 = this.em.query(TroopKeyWord.class);
    HashMap localHashMap = new HashMap();
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        TroopKeyWord localTroopKeyWord = (TroopKeyWord)localIterator.next();
        List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
        localObject2 = localList;
        if (localList == null)
        {
          localObject2 = new ArrayList();
          localHashMap.put(localTroopKeyWord.troopUin, localObject2);
        }
        ((List)localObject2).add(localTroopKeyWord);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "syncLoad: " + localHashMap);
    }
    this.jf.putAll(localHashMap);
    this.hasLoaded = true;
  }
  
  private void efq()
  {
    ThreadManagerV2.excute(new TroopKeywordManager.1(this), 32, null, true);
  }
  
  private long hS()
  {
    if (this.atK == 0L) {
      this.atK = aqvl.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", 0L);
    }
    return this.atK;
  }
  
  private static long hT()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_KeywordAIORefreshFrequency", 1) * 60L * 1000L;
  }
  
  public static boolean isEnable()
  {
    boolean bool2 = true;
    boolean bool1;
    if (enable == 0) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (enable == 1);
    if (aqvl.e((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_open", true)) {}
    for (int i = 1;; i = 0)
    {
      enable = i;
      if (QLog.isColorLevel()) {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "isEnable = " + enable);
      }
      bool1 = bool2;
      if (enable == 1) {
        break;
      }
      return false;
    }
  }
  
  private void md(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "setPullTimestamp = " + paramLong);
    }
    this.atK = paramLong;
    aqvl.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_last_pull_timestamp", paramLong);
  }
  
  public void VD(String paramString)
  {
    if (rF(paramString))
    {
      long l = System.currentTimeMillis();
      if (Math.abs(l - hS()) > hT())
      {
        QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordTimeoutCheck");
        md(l);
        efr();
      }
    }
  }
  
  public aqsy a(String paramString)
  {
    aqsy localaqsy = new aqsy();
    if ((TextUtils.isEmpty(paramString)) || (!isEnable()))
    {
      localaqsy.tips = "";
      localaqsy.showRedDot = false;
      localaqsy.reportType = 1;
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, new Object[] { "getTips error, troopUin=", paramString, " enable=", Boolean.valueOf(isEnable()) });
      return localaqsy;
    }
    efp();
    Object localObject1 = BaseApplicationImpl.getContext().getResources();
    List localList = (List)this.jf.get(paramString);
    boolean bool;
    int i;
    if ((localList == null) || (localList.isEmpty()))
    {
      localObject1 = ((Resources)localObject1).getString(2131694373);
      if ((!aqvl.e(this.app, "troop_keyword_guide_clicked", false)) && (this.jf.isEmpty()))
      {
        bool = true;
        if (!bool) {
          break label245;
        }
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, new Object[] { "getTips, troopUin=", paramString, " tips=", localObject1, " red=", Boolean.valueOf(bool) });
      }
      localaqsy.tips = ((String)localObject1);
      localaqsy.showRedDot = bool;
      localaqsy.reportType = i;
      return localaqsy;
      bool = false;
      break;
      label245:
      i = 1;
      continue;
      ExpireSet localExpireSet = new ExpireSet();
      Object localObject2 = localList.iterator();
      int j = 0;
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        TroopKeyWord localTroopKeyWord = (TroopKeyWord)((Iterator)localObject2).next();
        if (localTroopKeyWord.expiredFlag == 3)
        {
          localExpireSet.add(Long.valueOf(localTroopKeyWord.wordId));
          j += 1;
        }
        for (;;)
        {
          break;
          int k = i;
          if (localTroopKeyWord.expiredFlag == 2)
          {
            k = i + 1;
            localExpireSet.add(Long.valueOf(localTroopKeyWord.wordId));
          }
          i = k;
        }
      }
      localaqsy.ecw = j;
      localaqsy.ecx = i;
      localaqsy.cwQ = localExpireSet.toJson();
      localObject2 = aqvl.t(this.app, "troop_keyword_expire_list_" + paramString, null);
      if (!ExpireSet.fromJson((String)localObject2).containsAll(localExpireSet))
      {
        bool = true;
        label429:
        if (!bool) {
          break label511;
        }
        QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "expireList hasNewExpiredId, last:" + (String)localObject2 + " now:" + localaqsy.cwQ);
      }
      for (;;)
      {
        if (j <= 0) {
          break label547;
        }
        localObject1 = ((Resources)localObject1).getString(2131701845, new Object[] { Integer.valueOf(j) });
        i = 5;
        break;
        bool = false;
        break label429;
        label511:
        aqvl.h(this.app, "troop_keyword_expire_list_" + paramString, localaqsy.cwQ);
      }
      label547:
      if (i > 0)
      {
        localObject1 = ((Resources)localObject1).getString(2131701850);
        i = 4;
      }
      else
      {
        localObject1 = ((Resources)localObject1).getString(2131701846, new Object[] { Integer.valueOf(localList.size()) });
        bool = false;
        i = 3;
      }
    }
  }
  
  public void a(GetUsrKeyWordInfoRsp paramGetUsrKeyWordInfoRsp)
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeyworkRsp");
    if (paramGetUsrKeyWordInfoRsp == null)
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "rsp == null");
      return;
    }
    boolean bool;
    HashMap localHashMap;
    ArrayList[] arrayOfArrayList;
    int j;
    int i;
    if (1 == paramGetUsrKeyWordInfoRsp.iShowEntry)
    {
      bool = true;
      setEnable(bool);
      localHashMap = new HashMap();
      arrayOfArrayList = new ArrayList[2];
      arrayOfArrayList[0] = paramGetUsrKeyWordInfoRsp.vBaseWord;
      arrayOfArrayList[1] = paramGetUsrKeyWordInfoRsp.vVaWord;
      j = arrayOfArrayList.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label302;
      }
      paramGetUsrKeyWordInfoRsp = arrayOfArrayList[i];
      if (paramGetUsrKeyWordInfoRsp != null)
      {
        Iterator localIterator = paramGetUsrKeyWordInfoRsp.iterator();
        label97:
        if (localIterator.hasNext())
        {
          paramGetUsrKeyWordInfoRsp = (OneKeyWordItemClient)localIterator.next();
          TroopKeyWord localTroopKeyWord = new TroopKeyWord();
          localTroopKeyWord.wordId = paramGetUsrKeyWordInfoRsp.uWordId;
          localTroopKeyWord.keyword = paramGetUsrKeyWordInfoRsp.sKeyWordContent.toLowerCase();
          localTroopKeyWord.troopUin = String.valueOf(paramGetUsrKeyWordInfoRsp.uGroupNum);
          localTroopKeyWord.expiredFlag = ((int)paramGetUsrKeyWordInfoRsp.uWordExpiredFlag);
          if ((paramGetUsrKeyWordInfoRsp.uWordStatus == 2L) && ((paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 1L) || (paramGetUsrKeyWordInfoRsp.uWordExpiredFlag == 2L))) {}
          for (bool = true;; bool = false)
          {
            localTroopKeyWord.enable = bool;
            if (QLog.isColorLevel()) {
              QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, localTroopKeyWord.toString());
            }
            List localList = (List)localHashMap.get(localTroopKeyWord.troopUin);
            paramGetUsrKeyWordInfoRsp = localList;
            if (localList == null)
            {
              paramGetUsrKeyWordInfoRsp = new ArrayList();
              localHashMap.put(localTroopKeyWord.troopUin, paramGetUsrKeyWordInfoRsp);
            }
            paramGetUsrKeyWordInfoRsp.add(localTroopKeyWord);
            break label97;
            bool = false;
            break;
          }
        }
      }
      i += 1;
    }
    label302:
    M(localHashMap);
  }
  
  public boolean bZ(String paramString1, String paramString2)
  {
    if (!isEnable()) {}
    TroopKeyWord localTroopKeyWord;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            return false;
          } while (TextUtils.isEmpty(paramString1));
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "containsKeyword, troopUin is empty");
            return false;
          }
          efp();
          localObject = (List)this.jf.get(paramString2);
        } while ((localObject == null) || (((List)localObject).isEmpty()));
        paramString1 = paramString1.toLowerCase();
        localObject = ((List)localObject).iterator();
      }
      localTroopKeyWord = (TroopKeyWord)((Iterator)localObject).next();
    } while ((!localTroopKeyWord.enable) || (!paramString1.contains(localTroopKeyWord.keyword)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopKeywordManager.troop.special_msg.keyword", 2, "containsKeyword: " + localTroopKeyWord.keyword);
    }
    anot.b(null, "dc00898", "", paramString2, "qq_vip", "0X800A8FD", 0, 1, 0, "", "", localTroopKeyWord.keyword, "");
    return true;
  }
  
  public void efr()
  {
    QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "onKeywordChangePush");
    ((acle)this.app.getBusinessHandler(13)).a(new aqsz.a(this), true);
  }
  
  public void onDestroy() {}
  
  public boolean rF(String paramString)
  {
    if (!isEnable()) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "hasKeyword, troopUin is empty");
      return false;
    }
    paramString = (List)this.jf.get(paramString);
    if ((paramString != null) && (paramString.size() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopKeywordManager.troop.special_msg.keyword", 1, "setEnable = " + paramBoolean);
    }
    aqvl.f((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "troop_keyword_open", paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      enable = i;
      return;
    }
  }
  
  static class a
    implements acci
  {
    private WeakReference<aqsz> iw;
    
    public a(aqsz paramaqsz)
    {
      this.iw = new WeakReference(paramaqsz);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      aqsz localaqsz = (aqsz)this.iw.get();
      if (localaqsz == null) {}
      while (!(paramObject instanceof UniLoginCheckRsp)) {
        return;
      }
      localaqsz.a(((UniLoginCheckRsp)paramObject).stKeyWord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsz
 * JD-Core Version:    0.7.0.1
 */