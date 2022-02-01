import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.2;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.3;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.4;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.5;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.6;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.7;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.8;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.9;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class nyn
{
  private static Set<String> av;
  private static nyn b = new nyn();
  private nyn.a a = new nyn.a();
  private String aoM = "";
  private String aoN = "";
  private String aoO;
  private boolean avD;
  private boolean avE;
  private boolean avF;
  private int bdc;
  private HashMap<String, nyi> eB = new HashMap();
  private final HashMap<String, Integer> eC = new HashMap();
  private List<nyi> kI = new ArrayList();
  private String mAccount;
  private List<nyi> mDataList = new ArrayList();
  private final Object mDataLock = new Object();
  private final achq mMsgObserver = new nyo(this);
  private CharSequence w = "";
  private long yp;
  private long yq;
  private long yr;
  private long ys;
  private long yt;
  
  static
  {
    av = new HashSet();
    av.add(new String("2171946401"));
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int i;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      i = a().c(paramString, 1, 0);
      if (i > 0)
      {
        paramQQAppInterface = new StringBuilder(150);
        paramQQAppInterface.append("updateServiceAccountBelongInfo(");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(", folder type:");
        paramQQAppInterface.append(1);
        paramQQAppInterface.append(", error param, default service folder!");
        QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
      }
      i = 1;
      label94:
      return i;
    }
    Object localObject3 = (acja)paramQQAppInterface.getManager(56);
    if (localObject3 != null) {
      if ((!aako.L(paramQQAppInterface)) || (Thread.currentThread() != ThreadManager.getRecentThreadLooper().getThread())) {}
    }
    label460:
    label1126:
    for (;;)
    {
      AccountDetail localAccountDetail;
      int k;
      try
      {
        Object localObject1 = ((acja)localObject3).a(paramString, true);
        if (localObject1 != null) {
          break label1126;
        }
        localAccountDetail = ((acja)localObject3).b(paramString);
        localObject3 = localObject1;
        localObject1 = localAccountDetail;
        if ((localObject3 == null) && (localObject1 == null)) {
          break label547;
        }
        if (localObject3 == null) {
          break label460;
        }
        l = ((PublicAccountInfo)localObject3).accountFlag2;
        j = (int)((0x7800 & l) >> 11);
        i = -1;
        switch (j)
        {
        default: 
          if (localObject3 == null) {
            break label490;
          }
          j = ((PublicAccountInfo)localObject3).accountFlag;
          k = ocp.getAccountType(j);
          if (!ocp.p(j, l)) {
            break label500;
          }
          j = 2;
          if ((i != 0) || (j != 2)) {
            break label519;
          }
          j = 1;
          k = a().c(paramString, j, 1);
          i = j;
          if (k <= 0) {
            break label94;
          }
          paramQQAppInterface = new StringBuilder(256);
          paramQQAppInterface.append("updateServiceAccountBelongInfo(");
          paramQQAppInterface.append(k);
          paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(", folder type:");
          paramQQAppInterface.append(j);
          if (localObject3 != null)
          {
            paramQQAppInterface.append(", info accountFlag:");
            paramQQAppInterface.append(((PublicAccountInfo)localObject3).accountFlag);
            paramQQAppInterface.append(", info accountFlag2:");
            paramQQAppInterface.append(((PublicAccountInfo)localObject3).accountFlag2);
          }
          if (localObject1 != null)
          {
            paramQQAppInterface.append(", detail accountFlag:");
            paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag);
            paramQQAppInterface.append(", detail accountFlag2:");
            paramQQAppInterface.append(((AccountDetail)localObject1).accountFlag2);
          }
          QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          return j;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = ((acja)localObject3).c(paramString);
        continue;
      }
      Object localObject2 = ((acja)localObject3).c(paramString);
      continue;
      long l = ((AccountDetail)localObject2).accountFlag2;
      continue;
      i = 2;
      continue;
      i = 1;
      continue;
      i = 0;
      continue;
      i = 3;
      continue;
      label490:
      int j = ((AccountDetail)localObject2).accountFlag;
      continue;
      label500:
      if (k == -5)
      {
        j = 3;
      }
      else
      {
        j = 1;
        continue;
        if ((i == 2) && (j == 1))
        {
          j = 1;
        }
        else if (i != -1)
        {
          j = i;
          continue;
          if (ep(paramString)) {
            return 0;
          }
          if (paramQQAppInterface != null)
          {
            localObject2 = ((acff)paramQQAppInterface.getManager(51)).b(paramString);
            if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
            {
              QLog.d("ServiceAccountFolderManager", 1, " getPublicAccountFolderType error, is UIN_TYPE_PUBLIC_ACCOUNT, but is friend relation  puin = " + paramString);
              localObject2 = new HashMap();
              ((HashMap)localObject2).put("self_uin", paramQQAppInterface.getCurrentAccountUin());
              ((HashMap)localObject2).put("inValid_uin", paramString);
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ServiceAccountFolderManager_InValid_puin", false, 1L, 0L, (HashMap)localObject2, null);
              return 0;
            }
          }
          localObject2 = paramQQAppInterface.b().a(paramString, 1008);
          if (localObject2 != null)
          {
            if (((MessageRecord)localObject2).istroop != 1008)
            {
              QLog.d("ServiceAccountFolderManager", 1, " getPublicAccountFolderType error, not UIN_TYPE_PUBLIC_ACCOUNT, msg info is " + ((MessageRecord)localObject2).toString() + " puin = " + paramString);
              localObject3 = new HashMap();
              if (paramQQAppInterface != null) {
                ((HashMap)localObject3).put("self_uin", paramQQAppInterface.getCurrentAccountUin());
              }
              ((HashMap)localObject3).put("inValid_uin", paramString);
              ((HashMap)localObject3).put("inValid_msg_troop", String.valueOf(((MessageRecord)localObject2).istroop));
              ((HashMap)localObject3).put("inValid_msg_content", ((MessageRecord)localObject2).toString());
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ServiceAccountFolderManager_InValid_Msg", false, 1L, 0L, (HashMap)localObject3, null);
              return 0;
            }
            if (jxp.c((MessageRecord)localObject2)) {
              return 0;
            }
            paramQQAppInterface = ((MessageRecord)localObject2).getExtInfoFromExtStr("inter_num");
            if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("1")))
            {
              i = a().c(paramString, 2, 2);
              if (i > 0)
              {
                paramQQAppInterface = new StringBuilder(128);
                paramQQAppInterface.append("updateServiceAccountBelongInfo(");
                paramQQAppInterface.append(i);
                paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
                paramQQAppInterface.append(paramString);
                paramQQAppInterface.append(", folder type:");
                paramQQAppInterface.append(2);
                paramQQAppInterface.append(", inter_num:1");
                QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
              }
              return 2;
            }
            if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramQQAppInterface.equals("2")))
            {
              i = a().c(paramString, 3, 2);
              if (i > 0)
              {
                paramQQAppInterface = new StringBuilder(128);
                paramQQAppInterface.append("updateServiceAccountBelongInfo(");
                paramQQAppInterface.append(i);
                paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
                paramQQAppInterface.append(paramString);
                paramQQAppInterface.append(", folder type:");
                paramQQAppInterface.append(3);
                paramQQAppInterface.append(", inter_num:2");
                QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
              }
              return 3;
            }
          }
          i = a().c(paramString, 1, 2);
          if (i > 0)
          {
            paramQQAppInterface = new StringBuilder(150);
            paramQQAppInterface.append("updateServiceAccountBelongInfo(");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(")->getPublicAccountFolderType->puin:");
            paramQQAppInterface.append(paramString);
            paramQQAppInterface.append(", folder type:");
            paramQQAppInterface.append(1);
            paramQQAppInterface.append(", no info to judge, default service folder!");
            QLog.d("ServiceAccountFolderManager", 1, paramQQAppInterface.toString());
          }
          return 1;
          localAccountDetail = null;
          localObject3 = localObject2;
          localObject2 = localAccountDetail;
          continue;
          localObject2 = null;
          localObject3 = null;
        }
      }
    }
  }
  
  public static nyn a()
  {
    if (b == null) {}
    try
    {
      b = new nyn();
      return b;
    }
    finally {}
  }
  
  public static Drawable aq()
  {
    Drawable localDrawable = BaseApplicationImpl.sApplication.getResources().getDrawable(rb());
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(obt.Yf)) {
      localObject = URLDrawable.getDrawable(obt.Yf, localDrawable, localDrawable);
    }
    return localObject;
  }
  
  public static String bG(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", String.valueOf(paramInt));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private int c(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountBelongInfo->empty puin!");
      }
      return 0;
    }
    synchronized (this.eC)
    {
      Integer localInteger = Integer.valueOf((paramInt1 << 2) + paramInt2);
      if (this.eC.containsKey(paramString))
      {
        if ((this.eC.get(paramString) == null) || (!localInteger.equals(this.eC.get(paramString))))
        {
          this.eC.put(paramString, localInteger);
          return 2;
        }
      }
      else
      {
        this.eC.put(paramString, localInteger);
        return 1;
      }
    }
    return 0;
  }
  
  public static String d(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(obt.Ye)) {
      return obt.lc();
    }
    return obt.Ye;
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.b().i(paramString, 1008, 15);
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + " no message list");
      }
      return "";
    }
    int i = paramQQAppInterface.size() - 1;
    for (;;)
    {
      Object localObject;
      if (i >= 0)
      {
        localObject = (MessageRecord)paramQQAppInterface.get(i);
        if (((MessageRecord)localObject).isread) {
          break label173;
        }
        localObject = ((MessageRecord)localObject).getExtInfoFromExtStr("public_account_msg_extra_info_type");
        if (!"1".equals(localObject)) {
          break label163;
        }
      }
      label163:
      while ("2".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getLastExtraInfo->puin:" + paramString + ", extraInfo:" + "");
        }
        return "";
      }
      label173:
      i -= 1;
    }
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, paramString, true) == 0;
  }
  
  public static boolean ep(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return av.contains(paramString);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (ep(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "isBelongServiceAccountFolder->puin:" + paramString + ", inOutFolderWhiteList!");
      }
      return false;
    }
    int i = a(paramQQAppInterface, paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "isBelongServiceAccountFolder->puin:" + paramString + ", type:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (ep(paramString)) {
      return false;
    }
    if (a(paramQQAppInterface, paramString, false) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (a(paramQQAppInterface, paramString, false) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    int i = a(paramQQAppInterface, paramString, false);
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantManager", 2, "isBelongEcShopFolder->puin:" + paramString + ", type:" + i);
    }
    if (i == 3) {
      bool = true;
    }
    return bool;
  }
  
  private void oT(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " begin update");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {}
    do
    {
      acja localacja;
      do
      {
        return;
        localacja = (acja)localQQAppInterface.getManager(56);
      } while ((localacja != null) && (localacja.c(paramString) == null) && (localacja.b(paramString) == null));
      if (ocp.d(localQQAppInterface, paramString) != -7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " is EQQ, return!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateMsgState->puin:" + paramString + " do update");
    }
    k(localQQAppInterface, paramString);
  }
  
  public static int rb()
  {
    return 2130841034;
  }
  
  public boolean Gr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderHasLittleRedDot->mFolderHasLittleRedDot:" + this.avF);
    }
    return this.avF;
  }
  
  public boolean Gs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "isLastDraftMsg->lastDraft:" + this.avE);
    }
    return this.avE;
  }
  
  public long a(nyi paramnyi)
  {
    if (paramnyi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->empty feed");
      }
      return 0L;
    }
    paramnyi = paramnyi.d;
    if ((paramnyi != null) && ((paramnyi instanceof MessageForStructing)))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramnyi;
      paramnyi = localMessageForStructing.structingMsg;
      if (paramnyi != null) {
        break label110;
      }
      paramnyi = anre.a(localMessageForStructing.msgData);
    }
    label110:
    for (;;)
    {
      if (paramnyi != null) {}
      for (long l = paramnyi.msgId;; l = 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getFeedMsgId->msgId:" + l);
        }
        return l;
      }
    }
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.w)) && (!this.avD))
    {
      ah(paramQQAppInterface);
      this.avD = true;
      return new aofk(this.w, 3, 16);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderMsgBrief->mFolderMsgBrief:" + this.w);
    }
    return this.w;
  }
  
  public CharSequence a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.b().b(localMessage);
    paramMessageRecord = new MsgSummary();
    aqiu.a(paramQQAppInterface.getApplication(), paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramQQAppInterface.getApplication());
  }
  
  public List<nyi> a(QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshDataList!");
    }
    if (paramQQAppInterface == null) {
      return this.mDataList;
    }
    if (!paramQQAppInterface.getAccount().equals(this.mAccount))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->new cuin:" + paramQQAppInterface.getAccount() + ", old cuin:" + this.mAccount);
      }
      ac(paramQQAppInterface);
    }
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    synchronized (this.mDataLock)
    {
      this.mDataList.clear();
      this.eB.clear();
      localObject1 = oan.a().b(paramQQAppInterface);
      localObject3 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (TroopBarData)((Iterator)localObject1).next();
        if (f(paramQQAppInterface, ((TroopBarData)localObject4).mUin))
        {
          localObject4 = oal.a(paramQQAppInterface, paramQQAppInterface.getApplication(), (TroopBarData)localObject4);
          if (localObject4 != null)
          {
            if ((((oal)localObject4).mItems != null) && (((oal)localObject4).mItems.size() > 0))
            {
              localObject5 = (oam)((oal)localObject4).mItems.get(0);
              if ((TextUtils.isEmpty(((oam)localObject5).title)) && (!TextUtils.isEmpty(((oam)localObject5).aoP))) {
                ((oam)localObject5).title = ((oam)localObject5).aoP;
              }
            }
            ((List)localObject3).add(localObject4);
          }
        }
      }
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      if (!QLog.isColorLevel()) {
        break label790;
      }
      localObject1 = new StringBuilder("refreshDataList->SubscriptionFeedList size:");
      ((StringBuilder)localObject1).append(((List)localObject3).size()).append(", content:{");
    }
    for (;;)
    {
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (oal)((Iterator)localObject4).next();
        if ((QLog.isColorLevel()) && (localObject1 != null)) {
          ((StringBuilder)localObject1).append("[").append(((oal)localObject3).mUin).append(", ").append(((oal)localObject3).mType).append("]");
        }
        if (!this.eB.containsKey(((oal)localObject3).mUin))
        {
          localObject5 = nyi.a(paramQQAppInterface, (oal)localObject3);
          if (((nyi)localObject5).mIsVisible)
          {
            this.mDataList.add(localObject5);
            this.eB.put(((oal)localObject3).mUin, localObject5);
          }
        }
      }
      else
      {
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          localObject4 = paramQQAppInterface.a().a().q(false);
          if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
            break label772;
          }
          localObject3 = ((List)localObject4).iterator();
          localObject1 = localRecentUser;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder("refreshDataList->RecentList size:");
            ((StringBuilder)localObject1).append(((List)localObject4).size()).append(", content:{");
          }
          while (((Iterator)localObject3).hasNext())
          {
            localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((QLog.isColorLevel()) && (localObject1 != null)) {
              ((StringBuilder)localObject1).append("[").append(localRecentUser.uin).append(", ").append(localRecentUser.getType()).append("]");
            }
            if ((localRecentUser.getType() == 1008) && (f(paramQQAppInterface, localRecentUser.uin)) && (!this.eB.containsKey(localRecentUser.uin)))
            {
              localObject4 = nyi.a(paramQQAppInterface, localRecentUser);
              if (((nyi)localObject4).mIsVisible)
              {
                this.mDataList.add(localObject4);
                this.eB.put(localRecentUser.uin, localObject4);
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty SubscriptionFeedList!");
          }
        }
        if ((QLog.isColorLevel()) && (localObject1 != null))
        {
          ((StringBuilder)localObject1).append("}");
          QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject1).toString());
        }
        for (;;)
        {
          aj(paramQQAppInterface);
          return this.mDataList;
          label772:
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "refreshDataList->empty RecentList!");
          }
        }
        label790:
        localObject1 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->friend uin:" + paramObject.frienduin + ", istroop:" + paramObject.istroop);
      }
      if ((paramObject.istroop == 1008) && (f(paramQQAppInterface, paramObject.frienduin))) {
        break label116;
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(102);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->msg not belong serviceAccountFolder");
      }
    }
    for (;;)
    {
      return;
      label116:
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "addMessageToServiceAccountFolder->go to update feed");
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.3(this, paramQQAppInterface, paramObject));
      }
      while (!paramObject.isSendFromLocal())
      {
        e(paramQQAppInterface, 0L);
        return;
        k(paramQQAppInterface, paramObject.frienduin);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "updateDraft->puin:" + paramString1);
    }
    k(paramQQAppInterface, paramString1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, nyi paramnyi, boolean paramBoolean)
  {
    String str = paramnyi.mUin;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolderFeed->puin:" + str + ", needRefresh:" + paramBoolean);
    }
    for (;;)
    {
      synchronized (this.mDataLock)
      {
        if (this.eB.containsKey(str))
        {
          nyi localnyi = (nyi)this.eB.get(str);
          if (localnyi != null)
          {
            this.mDataList.remove(localnyi);
            this.eB.remove(str);
          }
        }
        if (paramnyi.avC)
        {
          paramnyi = paramQQAppInterface.a().a().b(paramnyi.mUin, 1008);
          if (paramnyi != null) {
            aalb.a(paramQQAppInterface, paramnyi, -1);
          }
          if (paramBoolean)
          {
            aj(paramQQAppInterface);
            al(paramQQAppInterface);
          }
          return;
        }
      }
      oan.a().d(str, paramQQAppInterface);
      aalb.l(paramQQAppInterface, str, ocp.e(paramQQAppInterface, str));
      paramQQAppInterface.b().ca(str, 1008);
    }
  }
  
  public void ac(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.mAccount)) || (!this.mAccount.equals(paramQQAppInterface.getAccount())))
    {
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (localSharedPreferences != null)
      {
        this.yr = localSharedPreferences.getLong("service_account_folder_last_read_time", 0L);
        this.ys = localSharedPreferences.getLong("service_account_folder_last_enter_time", 0L);
        obt.adU = localSharedPreferences.getBoolean("service_folder_redclean_after_enter", false);
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "initManager->mFolderLastReadTime:" + this.yr + ", mFolderLastEnterTime:" + this.ys);
        }
      }
      this.mAccount = paramQQAppInterface.getAccount();
      this.avD = false;
      ad(paramQQAppInterface);
      paramQQAppInterface.addObserver(this.mMsgObserver, true);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "initManager->cuin:" + this.mAccount);
      }
    }
  }
  
  public void ad(QQAppInterface paramQQAppInterface)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.2(this, paramQQAppInterface));
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.mAccount + ", throw to sub thread!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshAndUpdate->cuin:" + this.mAccount);
    }
    a(paramQQAppInterface);
    al(paramQQAppInterface);
  }
  
  public void ae(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleFollowListChange");
    }
    ad(paramQQAppInterface);
  }
  
  public void af(QQAppInterface paramQQAppInterface)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "deleteServiceAccountFolder->time:" + l);
    }
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.4(this, paramQQAppInterface, l));
  }
  
  public void ag(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderUnreadNum");
      }
      localArrayList = new ArrayList();
      synchronized (this.mDataLock)
      {
        Iterator localIterator = this.mDataList.iterator();
        if (localIterator.hasNext())
        {
          nyi localnyi = (nyi)localIterator.next();
          localnyi.mUnreadNum = 0;
          localArrayList.add(localnyi.mUin);
        }
      }
      this.bdc = 0;
    } while (localArrayList.size() <= 0);
    ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.5(this, localArrayList, paramQQAppInterface));
  }
  
  public void ah(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      this.yp = paramQQAppInterface.getLong("service_account_folder_display_time", 0L);
      this.aoM = paramQQAppInterface.getString("service_account_folder_time", "");
      this.yq = paramQQAppInterface.getLong("service_account_folder_operation_time", 0L);
      this.w = paramQQAppInterface.getString("service_account_folder_brief", "");
      this.yt = paramQQAppInterface.getLong("service_account_folder_maxunreadtime", 0L);
      this.bdc = paramQQAppInterface.getInt("service_account_folder_unreadnum", 0);
      this.aoO = paramQQAppInterface.getString("service_account_folder_extend", "");
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLocalData->mFolderDisplayTime:" + this.yp + ", mFolderShowTime:" + this.aoM + ", mFolderOperationTime:" + this.yq + ", mFolderMsgBrief:" + this.w + ", mFolderReportKeyBytesOacMsgxtend:" + this.aoO);
      }
    }
  }
  
  public void ai(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.8(this, paramQQAppInterface));
  }
  
  public void aj(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      long l3;
      Object localObject1;
      long l4;
      Object localObject2;
      Object localObject3;
      boolean bool;
      Object localObject4;
      Object localObject5;
      long l2;
      synchronized (this.mDataLock)
      {
        aalb.hH(this.mDataList);
        Collections.sort(this.mDataList, this.a);
        int i = 0;
        l3 = 0L;
        String str1 = "";
        int k = 0;
        long l1 = 0L;
        localObject1 = "";
        l4 = 0L;
        localObject2 = "";
        String str2 = "";
        localObject3 = "";
        int j = 0;
        bool = false;
        localObject4 = "";
        Iterator localIterator = this.mDataList.iterator();
        if (localIterator.hasNext())
        {
          localObject5 = (nyi)localIterator.next();
          if (((nyi)localObject5).mUnreadFlag == 2)
          {
            bool = true;
            l2 = l3;
            if (((nyi)localObject5).mUnreadNum > 0)
            {
              l2 = l3;
              if (((nyi)localObject5).mDisplayTime >= l3) {
                l2 = ((nyi)localObject5).mDisplayTime;
              }
            }
            l3 = l4;
            if (((nyi)localObject5).yo > l4) {
              l3 = ((nyi)localObject5).yo;
            }
            if ((((nyi)localObject5).mUnreadNum <= 0) || (k != 0) || (TextUtils.isEmpty(((nyi)localObject5).aoL))) {
              break label822;
            }
            str1 = ((nyi)localObject5).aoL;
            k = 1;
            if ((j != 0) || (TextUtils.isEmpty(((nyi)localObject5).v))) {
              break label795;
            }
            l1 = ((nyi)localObject5).mDisplayTime;
            localObject4 = ((nyi)localObject5).mShowTime;
            localObject3 = ((nyi)localObject5).mTitleName;
            str2 = ((nyi)localObject5).mUin;
            localObject2 = ((nyi)localObject5).v;
            localObject1 = ((nyi)localObject5).mReportKeyBytesOacMsgxtend;
            j = 1;
            break label828;
          }
          if (((nyi)localObject5).mUnreadFlag != 1) {
            break label825;
          }
          i += ((nyi)localObject5).mUnreadNum;
          continue;
        }
        this.bdc = i;
        this.avF = bool;
        this.yt = l3;
        this.aoN = str1;
        this.yp = l1;
        this.aoM = ((String)localObject1);
        this.yq = l4;
        this.aoO = ((String)localObject4);
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label679;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.w = new aofk((CharSequence)localObject3, 3, 16).a((String)localObject2 + "：", true, new int[0]);
          if (this.mDataList.size() <= 0) {
            break label787;
          }
          if (((nyi)this.mDataList.get(0)).mStatus != 4) {
            break label863;
          }
          bool = true;
          this.avE = bool;
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "generateFolderDescription->mFolderDisplayTime:" + this.yp + ", mFolderShowTime:" + this.aoM + ", mFolderExtraInfo:" + this.aoN + ", mFolderMsgBrief:" + this.w + ", mFolderUnreadNum:" + this.bdc + ", maxUnreadDisplayTime:" + this.yt + ", mFolderLastReadTime:" + this.yr + ", mFolderLastEnterTime:" + this.ys + ", mFolderHasLittleRedDot:" + this.avF + ", lastDraft:" + this.avE);
          }
          ai(paramQQAppInterface);
          return;
        }
        if (!TextUtils.isEmpty(str2)) {
          this.w = new aofk((CharSequence)localObject3, 3, 16).a(str2 + "：", true, new int[0]);
        }
      }
      this.w = ((CharSequence)localObject3);
      label787:
      label795:
      if (this.w == null)
      {
        this.w = "";
        continue;
        label679:
        if (this.mDataList.size() > 0)
        {
          this.yp = ((nyi)this.mDataList.get(0)).mDisplayTime;
          this.aoM = ((nyi)this.mDataList.get(0)).mShowTime;
          this.w = ((nyi)this.mDataList.get(0)).v;
          this.aoO = ((nyi)this.mDataList.get(0)).mReportKeyBytesOacMsgxtend;
          if (this.w == null)
          {
            this.w = "";
            continue;
            this.avE = false;
            continue;
            localObject5 = localObject2;
            Object localObject6 = localObject1;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject5;
            localObject4 = localObject6;
            break label828;
            label822:
            continue;
            label825:
            continue;
            label828:
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject4 = localObject1;
            localObject3 = localObject2;
            localObject2 = localObject6;
            localObject1 = localObject5;
            l4 = l3;
            l3 = l2;
            continue;
            label863:
            bool = false;
          }
        }
      }
    }
  }
  
  public void ak(QQAppInterface paramQQAppInterface)
  {
    acxw localacxw = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localacxw.b(acbn.bly, 7230);
    synchronized (this.mDataLock)
    {
      if ((this.mDataList == null) || (this.mDataList.size() == 0))
      {
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->删除folder节点");
          }
          localacxw.f(localRecentUser);
        }
        return;
      }
      ??? = localRecentUser;
      if (localRecentUser == null)
      {
        localRecentUser = new RecentUser(acbn.bly, 7230);
        localRecentUser.displayName = d(paramQQAppInterface);
        ??? = localRecentUser;
        if (QLog.isColorLevel())
        {
          QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->新增folder节点");
          ??? = localRecentUser;
        }
      }
      long l1 = c(paramQQAppInterface);
      long l2 = d(paramQQAppInterface);
      ((RecentUser)???).lastmsgtime = Math.max(l1, l2);
      localacxw.e((RecentUser)???);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderInMsgTab->更新folder节点:tempFolderDisplayTime:" + l1 + ", tempFolderOperationTime:" + l2 + ", ru.lastmsgtime:" + ((RecentUser)???).lastmsgtime);
      }
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public void al(QQAppInterface paramQQAppInterface)
  {
    ak(paramQQAppInterface);
    MqqHandler localMqqHandler = paramQQAppInterface.getHandler(ServiceAccountFolderActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(100);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(FolderFollowTabFragment.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(100);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "refreshFolderAndActivityUI");
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    paramAccountDetail = paramAccountDetail.uin;
    if (TextUtils.isEmpty(paramAccountDetail))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->empty uin");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "handleAccountDetailChange->update feed");
    }
    k(paramQQAppInterface, paramAccountDetail);
  }
  
  public void b(QQAppInterface paramQQAppInterface, nyi paramnyi, boolean paramBoolean)
  {
    if (paramnyi == null) {}
    do
    {
      return;
      this.bdc -= paramnyi.mUnreadNum;
      if (this.bdc < 0) {
        this.bdc = 0;
      }
      paramnyi.mUnreadNum = 0;
      paramnyi = paramnyi.mUin;
      aalb.l(paramQQAppInterface, paramnyi, 1008);
      paramQQAppInterface.b().ca(paramnyi, 1008);
      paramQQAppInterface.a().h(paramnyi, 1008, true);
      k(paramQQAppInterface, paramnyi);
      if (paramBoolean) {
        ak(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderManager", 2, "clearServiceAccountFolderFeedUnreadNum->uin:" + paramnyi + ", needRefresh:" + paramBoolean);
  }
  
  public List<nyi> be()
  {
    synchronized (this.mDataLock)
    {
      if (this.mDataList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->empty DataList");
        }
        return null;
      }
      StringBuilder localStringBuilder;
      try
      {
        List localList = (List)((ArrayList)this.mDataList).clone();
        if (!QLog.isColorLevel()) {
          break label214;
        }
        int i = localList.size();
        localStringBuilder = new StringBuilder("getDataList->");
        localStringBuilder.append("size:").append(i).append(", content:[");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append(((nyi)localIterator.next()).mUin).append(",");
        }
        if (i <= 0) {
          break label194;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "getDataList->exception:" + localException.getStackTrace());
        }
        return null;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      label194:
      localStringBuilder.append("]");
      QLog.d("ServiceAccountFolderManager", 2, localStringBuilder.toString());
      label214:
      return localException;
    }
  }
  
  public List<nyi> bk()
  {
    synchronized (this.mDataLock)
    {
      List localList = this.kI;
      return localList;
    }
  }
  
  public int c(QQAppInterface paramQQAppInterface)
  {
    int i = 2;
    if (rc() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:1");
      }
      i = 1;
    }
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadType->type:0");
      }
    } while ((Gr()) && (c(paramQQAppInterface) > jdMethod_do()));
    return 0;
  }
  
  public long c(QQAppInterface paramQQAppInterface)
  {
    if ((this.yp == 0L) && (!this.avD))
    {
      ah(paramQQAppInterface);
      this.avD = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderDisplayTime->mFolderDisplayTime:" + this.yp);
    }
    return this.yp;
  }
  
  public long d(QQAppInterface paramQQAppInterface)
  {
    if ((this.yq == 0L) && (!this.avD))
    {
      ah(paramQQAppInterface);
      this.avD = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderOperationTime->mFolderOperationTime:" + this.yq);
    }
    return this.yq;
  }
  
  public void d(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.ys = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.6(this, paramQQAppInterface));
  }
  
  public long dn()
  {
    for (;;)
    {
      int i;
      synchronized (this.mDataLock)
      {
        if ((this.mDataList != null) && (this.mDataList.size() > 0))
        {
          i = 0;
          if (i < this.mDataList.size())
          {
            if (TextUtils.isEmpty(((nyi)this.mDataList.get(i)).v)) {
              break label158;
            }
            nyi localnyi = (nyi)this.mDataList.get(i);
            long l = a(localnyi);
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:" + l);
            }
            return l;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderManager", 2, "getFolderLastShowMsgId->msgId:0");
          }
          return 0L;
        }
      }
      Object localObject2 = null;
      continue;
      label158:
      i += 1;
    }
  }
  
  public long jdMethod_do()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderLastEnterTime->mFolderLastEnterTime:" + this.ys);
    }
    return this.ys;
  }
  
  public void dq(List<nyi> paramList)
  {
    synchronized (this.mDataLock)
    {
      this.kI.clear();
      if (paramList != null) {
        this.kI.addAll(paramList);
      }
      return;
    }
  }
  
  public String e(QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(this.aoM)) && (!this.avD))
    {
      ah(paramQQAppInterface);
      this.avD = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderShowTime->mFolderShowTime:" + this.aoM);
    }
    return this.aoM;
  }
  
  public void e(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.yr = paramLong;
    this.ys = paramLong;
    ThreadManager.executeOnFileThread(new ServiceAccountFolderManager.7(this, paramQQAppInterface));
  }
  
  public boolean eo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->empty uin, return false");
      }
      return false;
    }
    synchronized (this.mDataLock)
    {
      boolean bool = this.eB.containsKey(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "containsFeedWithUin->uin:" + paramString + ", return " + bool);
      }
      return bool;
    }
  }
  
  public void k(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ServiceAccountFolderManager.9(this, paramQQAppInterface, paramString));
      return;
    }
    for (;;)
    {
      nyi localnyi;
      int i;
      int j;
      synchronized (this.mDataLock)
      {
        if (this.eB.containsKey(paramString))
        {
          localnyi = (nyi)this.eB.get(paramString);
          localnyi.mUin = paramString;
          localObject2 = (acja)paramQQAppInterface.getManager(56);
          if (localObject2 != null)
          {
            PublicAccountInfo localPublicAccountInfo = ((acja)localObject2).c(paramString);
            if (localPublicAccountInfo != null)
            {
              localnyi.mTitleName = localPublicAccountInfo.name;
              localnyi.mIsVisible = localPublicAccountInfo.isVisible();
              localnyi.mAuthenIconId = 0;
            }
          }
          else
          {
            localnyi.mUnreadNum = paramQQAppInterface.a().C(paramString, 1008);
            i = paramQQAppInterface.a().G(paramString, 1008);
            if (localnyi.mUnreadNum <= 0) {
              break label771;
            }
            if ((localnyi.mUnreadNum != 1) || (i <= 0)) {
              break label746;
            }
            localnyi.mUnreadFlag = 2;
            localObject2 = paramQQAppInterface.b();
            if (localObject2 == null) {
              break label990;
            }
            localnyi.mDraft = null;
            localnyi.d = ((QQMessageFacade)localObject2).d(paramString, 1008);
            localObject2 = ((QQMessageFacade)localObject2).a(paramString, 1008);
            if ((localObject2 == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary()))) {
              break label837;
            }
            if ((localnyi.d != null) && (((DraftSummaryInfo)localObject2).getTime() <= localnyi.d.time)) {
              break label780;
            }
            localnyi.mStatus = 4;
            localnyi.mDisplayTime = ((DraftSummaryInfo)localObject2).getTime();
            localnyi.mShowTime = aale.a().t(localnyi.mUin, ((DraftSummaryInfo)localObject2).getTime());
            localnyi.v = ((DraftSummaryInfo)localObject2).getSummary();
            i = 0;
            localnyi.aoL = e(paramQQAppInterface, localnyi.mUin);
            localnyi.avC = true;
            if (!oan.a().e(paramQQAppInterface, paramString, 1008)) {
              break label944;
            }
            localnyi.avC = false;
            if ((paramQQAppInterface.a() == null) || (paramQQAppInterface.a().a() == null)) {
              break label987;
            }
            localObject2 = paramQQAppInterface.a().a().a(paramString, 1008);
            if (localObject2 == null) {
              break label987;
            }
            localnyi.yo = ((RecentUser)localObject2).lastmsgtime;
            if ((i == 0) || (localnyi.yo <= 0L)) {
              break label987;
            }
            localnyi.mDisplayTime = localnyi.yo;
            localnyi.mShowTime = aale.a().t(paramString, localnyi.mDisplayTime);
            localnyi.v = "";
            i = 0;
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->" + localnyi.toString());
            }
            if (ocp.d(paramQQAppInterface, paramString) != -7) {
              break label981;
            }
            j = 1;
            if ((QLog.isColorLevel()) && (j != 0)) {
              QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->puin:" + localnyi.mUin + " is Eqq!");
            }
            if ((!localnyi.mIsVisible) || (i != 0) || (j != 0) || (!g(paramQQAppInterface, paramString)))
            {
              this.eB.remove(paramString);
              this.mDataList.remove(localnyi);
              if (QLog.isColorLevel()) {
                QLog.d("ServiceAccountFolderManager", 2, "updateServiceAccountFolderFeed->remove feed puin:" + localnyi.mUin + ", title:" + localnyi.mTitleName);
              }
            }
            aj(paramQQAppInterface);
            al(paramQQAppInterface);
          }
        }
        else
        {
          localnyi = new nyi();
          this.mDataList.add(localnyi);
          this.eB.put(paramString, localnyi);
          continue;
        }
        Object localObject2 = ((acja)localObject2).b(paramString);
        if (localObject2 == null) {
          continue;
        }
        localnyi.mTitleName = ((AccountDetail)localObject2).name;
        if (1 == ((AccountDetail)localObject2).showFlag)
        {
          bool = true;
          localnyi.mIsVisible = bool;
          localnyi.mAuthenIconId = 0;
        }
      }
      boolean bool = false;
      continue;
      label746:
      localnyi.mUnreadFlag = 1;
      label771:
      label780:
      label944:
      if (i > 0)
      {
        localnyi.mUnreadNum -= 1;
        continue;
        localnyi.mUnreadFlag = 0;
        continue;
        localnyi.mStatus = 0;
        localnyi.mDisplayTime = localnyi.d.time;
        localnyi.mShowTime = aale.a().t(paramString, localnyi.mDisplayTime);
        localnyi.v = a(paramQQAppInterface, localnyi.d, false);
        i = 0;
        continue;
        label837:
        if ((localnyi.d != null) && (localnyi.d.time > 0L))
        {
          localnyi.mStatus = 0;
          localnyi.mDisplayTime = localnyi.d.time;
          localnyi.mShowTime = aale.a().t(paramString, localnyi.mDisplayTime);
          localnyi.v = a(paramQQAppInterface, localnyi.d, false);
          i = 0;
        }
        else
        {
          localnyi.mStatus = 0;
          localnyi.mDisplayTime = 0L;
          localnyi.mShowTime = null;
          localnyi.v = null;
          i = 1;
          continue;
          if ((localnyi.d != null) && ("1".equals(localnyi.d.getExtInfoFromExtStr("inter_num"))))
          {
            localnyi.avC = false;
            continue;
            label981:
            j = 0;
            continue;
            label987:
            continue;
            label990:
            i = 0;
          }
        }
      }
    }
  }
  
  public String kR()
  {
    synchronized (this.mDataLock)
    {
      if ((this.mDataList != null) && (this.mDataList.size() > 0))
      {
        Object localObject2 = (nyi)this.mDataList.get(0);
        if (localObject2 != null)
        {
          localObject2 = ((nyi)localObject2).d;
          if (localObject2 != null)
          {
            localObject2 = ((MessageRecord)localObject2).frienduin;
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderManager", 2, "getFolderLastMsgUin->msgUin:" + (String)localObject2);
            }
            return localObject2;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderLastMsgUin->msgUin:0");
      }
      return "0";
    }
  }
  
  public String kS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderReportKeyBytesOacMsgxtend->mReportKeyBytesOacMsgxtend:" + this.aoO);
    }
    return this.aoO;
  }
  
  public String kT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "getFolderExtraInfo->mFolderExtraInfo:" + this.aoN);
    }
    return this.aoN;
  }
  
  public int rc()
  {
    if (this.yt > this.yr)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->mFolderUnreadNum:" + this.bdc);
      }
      if ((obt.Gy()) && (this.ys >= this.yt)) {
        if (QLog.isColorLevel()) {
          QLog.d("ServiceAccountFolderManager", 2, "enter time:" + this.ys + "  Last msgtime=" + this.yt);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return 0;
      return this.bdc;
    }
    QLog.d("ServiceAccountFolderManager", 2, "getFolderUnreadNum->0");
    return 0;
  }
  
  public class a
    implements Comparator<nyi>
  {
    public a() {}
    
    public int a(nyi paramnyi1, nyi paramnyi2)
    {
      long l1 = paramnyi1.mDisplayTime;
      long l2 = paramnyi2.mDisplayTime;
      if (l2 > l1) {
        return 1;
      }
      if (l2 < l1) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyn
 * JD-Core Version:    0.7.0.1
 */