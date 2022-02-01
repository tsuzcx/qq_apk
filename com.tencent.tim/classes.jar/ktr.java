import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.11;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.30;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.31;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.5;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.6;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.7;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.9;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ktr
  implements ksw
{
  private static Map<String, ktr> dQ = new HashMap();
  public CommonCommentData a;
  private ktr.b jdField_a_of_type_Ktr$b;
  private kut jdField_a_of_type_Kut;
  private kuu jdField_a_of_type_Kuu;
  private kuy jdField_a_of_type_Kuy = new kuy();
  private String acg = "";
  private String ach = "";
  private String aci = "";
  private String acj = "";
  private String ack = "";
  protected String acl = "";
  private boolean ahL = true;
  private boolean ahM = true;
  private boolean ahN = true;
  private boolean ahO = true;
  private boolean ahP;
  private boolean ahQ = true;
  private ArticleInfo b;
  private Map<String, BaseCommentData> dR = new HashMap();
  private aure<Pair<String, BaseCommentData>> f = new aure();
  private List<String> gA = new ArrayList();
  private List<String> gB = new ArrayList();
  private List<String> gC = new ArrayList();
  private List<String> gz = new ArrayList();
  private int mContentSrc;
  private List<ktr.d> mListeners = new ArrayList();
  private String rowKey = "";
  private long sJ;
  private long sK;
  private long sL;
  private long sM;
  
  private ktr(String paramString)
  {
    paramString = kxm.a();
    if (paramString != null)
    {
      this.jdField_a_of_type_Kut = ((lcd)paramString.getManager(163)).b().a();
      this.jdField_a_of_type_Kut.a(this);
    }
    this.jdField_a_of_type_Kuu = new kuu();
    this.jdField_a_of_type_Kuu.a(this);
    c(this.jdField_a_of_type_Kuy);
  }
  
  private int a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    do
    {
      return 0;
      if (paramBaseCommentData.isActivity()) {
        return 4;
      }
      if (paramBaseCommentData.isBanner()) {
        return 5;
      }
      if (paramBaseCommentData.isDynamicComment()) {
        return 7;
      }
    } while (!paramBaseCommentData.isAd);
    return 9;
  }
  
  private List<ktm> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new ktm(0, paramBaseCommentData, this.b));
      localArrayList.add(new ktm(3, paramBaseCommentData, this.b));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramBaseCommentData = paramList.iterator();
      if (paramBaseCommentData.hasNext())
      {
        paramList = (SubCommentData)paramBaseCommentData.next();
        if (paramList.isActivity()) {}
        for (int i = 4;; i = 0)
        {
          localArrayList.add(new ktm(i, paramList, this.b));
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static ktr a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    return (ktr)dQ.get(paramArticleInfo.innerUniqueID);
  }
  
  public static ktr a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      localObject = null;
    }
    ktr localktr;
    do
    {
      return localObject;
      localktr = (ktr)dQ.get(paramArticleInfo.innerUniqueID);
      localObject = localktr;
    } while (localktr != null);
    Object localObject = new ktr(paramArticleInfo.innerUniqueID);
    ((ktr)localObject).b(paramArticleInfo);
    ((ktr)localObject).mContentSrc = paramInt;
    if (paramInt == 1) {}
    for (((ktr)localObject).acl = (paramArticleInfo.mArticleID + "");; ((ktr)localObject).acl = paramArticleInfo.innerUniqueID)
    {
      dQ.put(paramArticleInfo.innerUniqueID, localObject);
      ((ktr)localObject).rowKey = paramArticleInfo.innerUniqueID;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramArticleInfo, ", src : ", Integer.valueOf(paramInt) });
      return localObject;
    }
  }
  
  public static ktr a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ktr)dQ.get(paramString);
  }
  
  private void a(CommentData paramCommentData, int paramInt)
  {
    if (paramCommentData == null) {}
    do
    {
      return;
      if ((this.gz != null) && (this.gz.contains(paramCommentData.commentId)))
      {
        this.sL += paramInt;
        QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mHotCommentCnt " + this.sL);
      }
      if ((this.gA != null) && (this.gA.contains(paramCommentData.commentId)))
      {
        this.sK += paramInt;
        QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mNewCommentCnt " + this.sK);
      }
    } while ((this.gC == null) || (!this.gC.contains(paramCommentData.commentId)));
    this.sM += paramInt;
    QLog.d("ReadInJoyCommentDataManager", 2, "updateCommentCount | mFamilyCommentCnt " + this.sM);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      paramArticleInfo = (ktr)dQ.get(paramArticleInfo.innerUniqueID);
      if (paramArticleInfo != null) {
        paramArticleInfo.aHo();
      }
      QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager feedsType " + paramInt);
      return;
    }
    c(paramArticleInfo);
  }
  
  private void a(List<ktr.d> paramList, boolean paramBoolean, ktr.a parama)
  {
    int i = 0;
    if (i < paramList.size())
    {
      ktr.d locald = (ktr.d)paramList.get(i);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.30(this, parama, locald));
      }
      for (;;)
      {
        i += 1;
        break;
        parama.d(locald);
      }
    }
  }
  
  private void a(ktr.a parama)
  {
    a(parama, true);
  }
  
  private void a(ktr.a parama, boolean paramBoolean)
  {
    if ((!this.mListeners.isEmpty()) && (parama != null)) {
      a(this.mListeners, paramBoolean, parama);
    }
    ArrayList localArrayList = new ArrayList();
    if (krz.a().ar() != null) {
      localArrayList.addAll(krz.a().ar());
    }
    if ((localArrayList != null) && (parama != null)) {
      a(localArrayList, paramBoolean, parama);
    }
  }
  
  private void aHm()
  {
    if (this.gz != null) {
      this.gz.clear();
    }
    this.sL = 0L;
    this.ahO = false;
    this.acj = "";
  }
  
  private void aHn()
  {
    if (this.gA != null) {
      this.gA.clear();
    }
    this.aci = "";
    this.ahN = false;
    this.sK = 0L;
  }
  
  private void aHo()
  {
    if (this.gC != null) {
      this.gC.clear();
    }
    this.ack = "";
    this.sM = 0L;
    this.ahP = false;
  }
  
  private List<ktm> c(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new ktm(paramInt, a(localBaseCommentData), localBaseCommentData, this.b));
    }
    return localArrayList;
  }
  
  public static void c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return;
      paramArticleInfo = (ktr)dQ.remove(paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo == null);
    paramArticleInfo.destroy();
    QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
  }
  
  private List<ktm> d(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!TextUtils.isEmpty(str)) && (this.dR.get(str) != null)) {
        localArrayList.add(new ktm(paramInt, a((BaseCommentData)this.dR.get(str)), (BaseCommentData)this.dR.get(str), this.b));
      }
    }
    return localArrayList;
  }
  
  private void j(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Kut == null) || (TextUtils.isEmpty(this.acl)))
    {
      a(new ktv(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.ach });
    this.jdField_a_of_type_Kut.a(this.b.innerUniqueID, paramString1, paramString2, this.ach, 10, this.mContentSrc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
  }
  
  private void j(List<CommentData> paramList1, List<CommentData> paramList2)
  {
    if (this.dR == null) {}
    for (;;)
    {
      return;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList1.next();
          if (localCommentData != null)
          {
            this.dR.put(localCommentData.commentId, localCommentData);
            if (this.gz != null) {
              this.gz.add(localCommentData.commentId);
            }
          }
        }
      }
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (CommentData)paramList1.next();
          if (paramList2 != null)
          {
            this.dR.put(paramList2.commentId, paramList2);
            if (this.gA != null) {
              this.gA.add(paramList2.commentId);
            }
          }
        }
      }
    }
  }
  
  private void k(List<CommentData> paramList, List<String> paramList1)
  {
    if (this.dR == null) {}
    for (;;)
    {
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          CommentData localCommentData = (CommentData)paramList.next();
          if (localCommentData != null)
          {
            this.dR.put(localCommentData.commentId, localCommentData);
            if (paramList1 != null) {
              paramList1.add(localCommentData.commentId);
            }
          }
        }
      }
    }
  }
  
  private boolean p(List<CommentData> paramList)
  {
    if ((paramList == null) || (this.jdField_a_of_type_Ktr$b == null) || (!this.jdField_a_of_type_Ktr$b.ahW) || (this.jdField_a_of_type_Ktr$b.acr == null)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CommentData localCommentData = (CommentData)paramList.next();
      if ((localCommentData != null) && (this.jdField_a_of_type_Ktr$b.acr.equals(localCommentData.commentId)))
      {
        localCommentData.isAnchor = true;
        return true;
      }
    }
    return false;
  }
  
  private void pO(int paramInt)
  {
    if ((this.jdField_a_of_type_Kut == null) || (TextUtils.isEmpty(this.acl)))
    {
      a(new kus(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch NewCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.aci });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.aci)
    {
      this.aci = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ktr$b != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ktr$b.ahV) {
            localObject1 = this.jdField_a_of_type_Ktr$b.acr;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.9(this, (String)localObject1));
      return;
    }
  }
  
  private void pP(int paramInt)
  {
    if ((this.jdField_a_of_type_Kut == null) || (TextUtils.isEmpty(this.acl)))
    {
      a(new ktt(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch HotCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.acj });
    if (paramInt == 1) {}
    for (Object localObject1 = "";; localObject1 = this.acj)
    {
      this.acj = ((String)localObject1);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt == 1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ktr$b != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Ktr$b.ahV) {
            localObject1 = this.jdField_a_of_type_Ktr$b.acr;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.11(this, (String)localObject1));
      return;
    }
  }
  
  private void pQ(int paramInt)
  {
    if ((this.jdField_a_of_type_Kut == null) || (TextUtils.isEmpty(this.acl)))
    {
      a(new ktu(this, paramInt));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.ack });
    if (paramInt == 1) {}
    for (String str = "";; str = this.ack)
    {
      this.ack = str;
      this.jdField_a_of_type_Kut.a(this.b.innerUniqueID, this.ack, 10, this.mContentSrc, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      return;
    }
  }
  
  public List<ktm> A(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.dR.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new ktm(0, paramString, this.b));
    localArrayList.add(new ktm(3, paramString, this.b));
    localArrayList.addAll(d(0, this.gB));
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "get all sub comment list , parentID : ", paramString, ", sub list size : ", Integer.valueOf(this.gB.size()) });
    return localArrayList;
  }
  
  public long D(String paramString)
  {
    paramString = (BaseCommentData)this.dR.get(paramString);
    if ((paramString != null) && ((paramString instanceof CommentData))) {
      return ((CommentData)paramString).subCommentNum;
    }
    return 0L;
  }
  
  public void R(boolean paramBoolean, int paramInt)
  {
    this.ahQ = paramBoolean;
    QLog.d("ReadInJoyCommentDataManager", 2, "setTitleShowData | showFamilyTitle : " + this.ahQ);
  }
  
  public BaseCommentData a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = new CommentData();
      ((BaseCommentData)localObject1).level = paramInt;
      ((BaseCommentData)localObject1).anonymous = 0;
      ((BaseCommentData)localObject1).authorSelection = 0;
      ((BaseCommentData)localObject1).awesome = 0;
      ((BaseCommentData)localObject1).uin = kxm.getAccount();
      ((BaseCommentData)localObject1).homepage = kxm.ez(((BaseCommentData)localObject1).uin);
      ((BaseCommentData)localObject1).myself = 1;
      ((BaseCommentData)localObject1).like = 0;
      ((BaseCommentData)localObject1).disLike = 0;
      ((BaseCommentData)localObject1).likeCnt = 0;
      ((BaseCommentData)localObject1).rank = 0;
      ((BaseCommentData)localObject1).rowKey = this.b.innerUniqueID;
      ((BaseCommentData)localObject1).contentSrc = this.mContentSrc;
      ((BaseCommentData)localObject1).authorComment = "";
      ((BaseCommentData)localObject1).commentTime = NetConnInfoCenter.getServerTime();
      localObject3 = ReadInJoyUserInfoModule.a(Long.parseLong(((BaseCommentData)localObject1).uin), null);
      if (localObject3 == null) {
        break label344;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).nick;
      label133:
      ((BaseCommentData)localObject1).nickName = ((String)localObject2);
      if (localObject3 == null) {
        break label352;
      }
      localObject2 = ((ReadInJoyUserInfo)localObject3).faceUrl;
      label151:
      ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    }
    label387:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        ((BaseCommentData)localObject1).commentContent = new String(aqgo.decode(paramString.getString("comment"), 0));
        if (paramInt == 2)
        {
          localObject2 = (SubCommentData)localObject1;
          localObject3 = paramString.getString("commentId");
          localObject3 = (BaseCommentData)this.dR.get(localObject3);
          if (!(localObject3 instanceof SubCommentData)) {
            continue;
          }
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localObject3).parentCommentId;
          if (paramString.optBoolean("isSecondReply", false))
          {
            localObject3 = paramString.optString("replyUin");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              ((SubCommentData)localObject2).repliedUserUin = ((String)localObject3);
              paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject3).longValue(), null);
              if (paramString == null) {
                break label387;
              }
              paramString = paramString.nick;
              ((SubCommentData)localObject2).repliedUserNickname = paramString;
              ((SubCommentData)localObject2).repliedUserHomePage = kxm.ez((String)localObject3);
              ((SubCommentData)localObject2).hasTarget = 1;
            }
          }
        }
        return localObject1;
        if (paramInt == 2)
        {
          localObject1 = new SubCommentData();
          break;
        }
        return null;
        label344:
        localObject2 = ReadInJoyUserInfoModule.getDefaultNickName();
        break label133;
        label352:
        localObject2 = "";
        break label151;
        if ((localObject3 instanceof CommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = ((BaseCommentData)localObject3).commentId;
          continue;
          paramString = ReadInJoyUserInfoModule.getDefaultNickName();
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  public BaseCommentData a(String paramString)
  {
    return (BaseCommentData)this.dR.get(paramString);
  }
  
  public CommonCommentData a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  }
  
  public ktr.b a()
  {
    return this.jdField_a_of_type_Ktr$b;
  }
  
  public kuy a()
  {
    return this.jdField_a_of_type_Kuy;
  }
  
  public void a(int paramInt, String paramString, kut.a parama, kut.b paramb)
  {
    boolean bool2 = true;
    boolean bool3 = TextUtils.isEmpty(this.ach);
    kut.a locala = parama;
    if (parama == null) {
      locala = new kut.a();
    }
    if (paramb == null) {
      new kut.b();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.ahM = locala.hasNextPage;
      this.ach = locala.acv;
      if (locala.gI == null) {
        break label343;
      }
      parama = locala.gI.iterator();
      while (parama.hasNext())
      {
        paramb = (SubCommentData)parama.next();
        if (paramb != null)
        {
          if (TextUtils.isEmpty(paramb.parentCommentId)) {
            paramb.parentCommentId = paramString;
          }
          this.dR.put(paramb.commentId, paramb);
          this.gB.add(paramb.commentId);
        }
      }
      parama = a(bool3, (BaseCommentData)this.dR.get(paramString), locala.gI);
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (locala.gI == null) {
          break label332;
        }
        paramInt = locala.gI.size();
        label212:
        if ((locala == null) || (!locala.hasNextPage)) {
          break label337;
        }
      }
      for (;;)
      {
        QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
        a(new kuj(this, bool3, bool1, parama));
        return;
        parama = null;
        bool1 = false;
        break;
        label332:
        paramInt = 0;
        break label212;
        label337:
        bool2 = false;
      }
      label343:
      parama = null;
      bool1 = true;
    }
  }
  
  public void a(int paramInt, kut.a parama1, kut.a parama2, kut.b paramb)
  {
    boolean bool1;
    boolean bool2;
    Object localObject;
    long l;
    label105:
    int i;
    if (paramInt == 0)
    {
      bool1 = true;
      bool2 = TextUtils.isEmpty(this.acg);
      localObject = parama1;
      if (parama1 == null) {
        localObject = new kut.a();
      }
      parama1 = parama2;
      if (parama2 == null) {
        parama1 = new kut.a();
      }
      parama2 = paramb;
      if (paramb == null) {
        parama2 = new kut.b();
      }
      if (bool1)
      {
        this.ahN = parama1.hasNextPage;
        this.ahO = ((kut.a)localObject).hasNextPage;
        if (((kut.a)localObject).gH == null) {
          break label477;
        }
        l = ((kut.a)localObject).gH.size();
        this.sL = l;
        this.aci = parama1.acv;
        this.acj = ((kut.a)localObject).acv;
        j(((kut.a)localObject).gH, parama1.gH);
      }
      if (!bool2) {
        break label504;
      }
      if (parama2.sN > 0L) {
        this.sK = parama2.sN;
      }
      this.sJ = parama2.sO;
      if ((this.jdField_a_of_type_Ktr$b != null) && (this.jdField_a_of_type_Ktr$b.ahW))
      {
        if (!p(((kut.a)localObject).gH)) {
          a(new ktx(this));
        }
        this.jdField_a_of_type_Ktr$b.ahW = false;
      }
      paramInt = 3;
      List localList = o(3);
      if (localList != null)
      {
        paramb = localList;
        if (!localList.isEmpty()) {}
      }
      else
      {
        paramInt = 2;
        paramb = o(2);
      }
      if (paramInt != 3) {
        break label483;
      }
      bool2 = this.ahO;
      label268:
      if (!((kut.a)localObject).AB()) {
        break label492;
      }
      i = ((kut.a)localObject).gH.size();
      label288:
      localObject = new StringBuilder().append(", new size : ");
      if (!parama1.AB()) {
        break label498;
      }
    }
    label477:
    label483:
    label492:
    label498:
    for (int j = parama1.gH.size();; j = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i), j, ", totalCnt : ", this.sK + " , hideCnt : " + this.sJ });
      a(new kty(this, bool1, paramb, bool2, paramInt));
      if (this.jdField_a_of_type_Ktr$b != null) {
        this.jdField_a_of_type_Ktr$b.mM(false);
      }
      this.jdField_a_of_type_Kuy.pR(parama2.aLW);
      this.jdField_a_of_type_Kuy.mz(parama2.jumpSchema);
      return;
      bool1 = false;
      break;
      l = 0L;
      break label105;
      bool2 = this.ahN;
      break label268;
      i = 0;
      break label288;
    }
    label504:
    if (parama1 != null) {}
    for (parama1 = c(2, new ArrayList(parama1.gH));; parama1 = new ArrayList())
    {
      bool2 = this.ahL;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(parama1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ktz(this, bool1, parama1));
      return;
    }
  }
  
  public void a(int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.aci);
    paramCommentData = parama;
    if (parama == null) {
      paramCommentData = new kut.a();
    }
    parama = paramb;
    if (paramb == null) {
      parama = new kut.b();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.ahN = paramCommentData.hasNextPage;
      this.aci = paramCommentData.acv;
      j(null, paramCommentData.gH);
      bool1 = true;
      if (!bool2) {
        break label228;
      }
      if (parama.sN > 0L) {
        this.sK = parama.sN;
      }
      parama = au();
      paramb = new StringBuilder().append(", new size : ");
      if (paramCommentData.gH == null) {
        break label223;
      }
    }
    label223:
    for (paramInt = paramCommentData.gH.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramInt, ", totalCnt : ", Long.valueOf(this.sK) });
      a(new kua(this, bool1, parama));
      if (this.jdField_a_of_type_Ktr$b != null) {
        this.jdField_a_of_type_Ktr$b.mM(false);
      }
      return;
      bool1 = false;
      break;
    }
    label228:
    if (paramCommentData.gH != null) {}
    for (parama = c(2, new ArrayList(paramCommentData.gH));; parama = new ArrayList())
    {
      bool2 = this.ahN;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(parama.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new kub(this, bool1, parama, bool2));
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCreateCommentResult | create comment resp, seq ", Long.valueOf(paramLong), " succ : ", Boolean.valueOf(paramBoolean), " data : ", paramString });
    if (this.gA == null) {
      this.gA = new ArrayList();
    }
    if (this.gz == null) {
      this.gz = new ArrayList();
    }
    Pair localPair = (Pair)this.f.get(paramLong);
    if (localPair == null) {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
    }
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = (BaseCommentData)localPair.second;
      this.f.remove(paramLong);
      if (paramBoolean)
      {
        ksz.a(this.b, (String)localPair.first);
        a(localBaseCommentData, paramString, paramInt2);
        return;
      }
      if ((localBaseCommentData instanceof CommentData))
      {
        a(new kul(this, paramInt2));
        return;
      }
    } while (!(localBaseCommentData instanceof SubCommentData));
    a(new kum(this));
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.b != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.31(this, paramBoolean, paramString2, paramString1));
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    paramBaseCommentData.commentId = paramString;
    this.dR.put(paramBaseCommentData.commentId, paramBaseCommentData);
    label117:
    boolean bool;
    label131:
    int i;
    if ((paramBaseCommentData instanceof CommentData)) {
      if (paramInt == 6)
      {
        if (this.gC == null) {
          this.gC = new ArrayList();
        }
        if (this.gC.size() == 0)
        {
          this.gC.add(paramBaseCommentData.commentId);
          if (this.gA.size() != 0) {
            break label321;
          }
          this.gA.add(paramBaseCommentData.commentId);
          this.gz.add(paramBaseCommentData.commentId);
          if ((paramInt != 3) && (paramInt != 6)) {
            break label419;
          }
          bool = true;
          a((CommentData)paramBaseCommentData, 1);
          if (paramInt != 6) {
            break label425;
          }
          i = 4;
          label149:
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | createComment feedsType " + i);
          a(new kup(this, new ktm(i, 0, paramBaseCommentData, this.b), bool, paramInt));
        }
      }
    }
    label321:
    do
    {
      do
      {
        return;
        paramString = (BaseCommentData)this.dR.get(this.gC.get(0));
        if ((paramString != null) && (paramString.isBanner())) {
          if (this.gC.size() < 2) {
            this.gC.add(paramBaseCommentData.commentId);
          }
        }
        for (;;)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
          break;
          this.gC.add(1, paramBaseCommentData.commentId);
          continue;
          this.gC.add(0, paramBaseCommentData.commentId);
        }
        paramInt = 2;
        break;
        paramString = (BaseCommentData)this.dR.get(this.gA.get(0));
        if ((paramString != null) && (paramString.isBanner()))
        {
          if (this.gA.size() < 2)
          {
            this.gA.add(paramBaseCommentData.commentId);
            break label117;
          }
          this.gA.add(1, paramBaseCommentData.commentId);
          break label117;
        }
        this.gA.add(0, paramBaseCommentData.commentId);
        break label117;
        bool = false;
        break label131;
        i = 2;
        break label149;
      } while (!(paramBaseCommentData instanceof SubCommentData));
      this.gB.add(0, paramBaseCommentData.commentId);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.gB.size()) });
      paramString = (BaseCommentData)this.dR.get(((SubCommentData)paramBaseCommentData).parentCommentId);
      paramString = (CommentData)this.dR.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    } while (paramString == null);
    label419:
    label425:
    paramString.subCommentNum += 1;
    if (paramString.subCommentList == null) {
      paramString.subCommentList = new ArrayList();
    }
    if (paramString.subCommentList.size() < 2) {
      paramString.subCommentList.add((SubCommentData)paramBaseCommentData);
    }
    a(paramString, 1);
    a(new kuq(this, paramBaseCommentData));
  }
  
  public void a(ktm paramktm, int paramInt)
  {
    if ((this.jdField_a_of_type_Kuu == null) || (paramktm == null) || (paramktm.a == null)) {
      return;
    }
    BaseCommentData localBaseCommentData = paramktm.a;
    if ((localBaseCommentData instanceof CommentData))
    {
      int i = ((CommentData)localBaseCommentData).subCommentNum;
      a((CommentData)localBaseCommentData, -(i + 1));
      if (this.dR != null) {
        this.dR.remove(localBaseCommentData.commentId);
      }
      if (this.gz != null) {
        this.gz.remove(localBaseCommentData.commentId);
      }
      if (this.gA != null) {
        this.gA.remove(localBaseCommentData.commentId);
      }
      if (this.gC != null) {
        this.gC.remove(localBaseCommentData.commentId);
      }
    }
    if ((localBaseCommentData instanceof SubCommentData))
    {
      CommentData localCommentData = (CommentData)this.dR.get(((SubCommentData)localBaseCommentData).parentCommentId);
      if (localCommentData != null)
      {
        if (localCommentData.subCommentNum > 0) {
          localCommentData.subCommentNum -= 1;
        }
        List localList = localCommentData.subCommentList;
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
            if (localSubCommentData.commentId.equalsIgnoreCase(localBaseCommentData.commentId)) {
              localList.remove(localSubCommentData);
            }
          }
        }
      }
      a(localCommentData, -1);
      this.gB.remove(localBaseCommentData.commentId);
    }
    a(new ktw(this, localBaseCommentData.getCommentLevel(), paramktm, paramInt), false);
    this.jdField_a_of_type_Kuu.b(localBaseCommentData, this.acl, this.mContentSrc);
  }
  
  public void a(ktr.b paramb)
  {
    if ("setCommentAnchor | commentid : " + paramb != null) {}
    for (String str = paramb.acr;; str = "")
    {
      QLog.d("ReadInJoyCommentDataManager", 1, str);
      this.jdField_a_of_type_Ktr$b = paramb;
      return;
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
      if (paramBoolean)
      {
        Bundle localBundle = BaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
        if ((paramBaseCommentData instanceof CommentData)) {}
        for (int i = ((CommentData)paramBaseCommentData).subCommentNum + 1; localBundle != null; i = 1)
        {
          lcc.a().a(true, this.acl, paramBaseCommentData.commentId, "onCommentDelete", localBundle.getInt("seq"), i);
          return;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentID : ", paramString, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new kuk(this, paramBoolean, paramString, paramInt1, paramInt2));
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        lcc.a().a(paramBoolean, this.acl, paramString, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public boolean a(ktr.d paramd)
  {
    try
    {
      boolean bool = this.mListeners.remove(paramd);
      return bool;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void aA(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SubCommentData localSubCommentData;
    do
    {
      return;
      localSubCommentData = (SubCommentData)a(2, paramString);
    } while (localSubCommentData == null);
    long l = this.jdField_a_of_type_Kuu.a(paramString, this.acl, this.mContentSrc, 2, localSubCommentData.parentCommentId, this.rowKey, paramInt);
    if (l != -1L) {
      this.f.append(l, new Pair(paramString, localSubCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create reply comment, seq : " + l + ", data : " + localSubCommentData);
  }
  
  public void aB(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = a(1, paramString);
    } while (localBaseCommentData == null);
    long l = this.jdField_a_of_type_Kuu.a(paramString, this.acl, this.mContentSrc, 1, "", this.rowKey, paramInt);
    if (l != -1L) {
      this.f.append(l, new Pair(paramString, localBaseCommentData));
    }
    QLog.d("ReadInJoyCommentDataManager", 1, "create main comment, seq : " + l + ", data : " + localBaseCommentData);
  }
  
  public void aHp()
  {
    if (this.gB != null)
    {
      Iterator localIterator = this.gB.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.dR.remove(str);
      }
      this.gB.clear();
    }
    this.ach = "";
    this.ahM = true;
  }
  
  public int aK(String paramString)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.dR.get(paramString);
    if (localBaseCommentData == null) {
      return 0;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      if (this.gz.contains(paramString)) {
        return 1;
      }
      if (this.gA.contains(paramString)) {
        return 2;
      }
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      return aK(((SubCommentData)localBaseCommentData).parentCommentId);
    }
    return 0;
  }
  
  public List<ktm> as()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.gz.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < this.gz.size())
      {
        CommentData localCommentData = (CommentData)this.dR.get(this.gz.get(i));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ksj.Av())))) {
          localArrayList2.add(localCommentData);
        }
        i += 1;
      }
      if ((localArrayList2.size() > 0) && (this.ahQ)) {
        localArrayList1.add(new ktm(1, null, this.b));
      }
      localArrayList1.addAll(c(1, new ArrayList(localArrayList2)));
    }
    if ("getTotalHotCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public List<ktm> au()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.gA.size() > 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      if (i < this.gA.size())
      {
        CommentData localCommentData = (CommentData)this.dR.get(this.gA.get(i));
        if (localCommentData == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ksj.Av()))) {
            localArrayList2.add(localCommentData);
          }
        }
      }
      if ((localArrayList2.size() > 0) && (this.ahQ)) {
        localArrayList1.add(new ktm(2, null, this.b));
      }
      localArrayList1.addAll(c(2, new ArrayList(localArrayList2)));
    }
    if ("getTotalNewCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public List<ktm> av()
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((this.gC != null) && (this.gC.size() > 0))
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.gC.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (CommentData)this.dR.get(localObject);
        if (localObject != null) {
          localArrayList2.add(localObject);
        }
      }
      if ((localArrayList2.size() > 0) && (this.ahQ))
      {
        QLog.d("ReadInJoyCommentDataManager", 1, "getTotalFamilyCommentList | showTitle dont showSwitch");
        localArrayList1.add(new ktm(2, null, this.b));
      }
      localArrayList1.addAll(c(4, new ArrayList(localArrayList2)));
    }
    if ("getTotalFamilyCommentList " + localArrayList1 != null) {}
    for (int i = localArrayList1.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i) });
      return localArrayList1;
    }
  }
  
  public void ay(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.dR.get(paramString);
    if (paramString != null) {
      paramString.disLike = paramInt;
    }
    this.jdField_a_of_type_Kuu.a(paramString, 1, paramInt, this.acl, this.mContentSrc);
  }
  
  public void az(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.dR.get(paramString);
    int j;
    if (paramString != null)
    {
      paramString.like = paramInt;
      j = paramString.likeCnt;
      if (!paramString.isLiked()) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = -1)
    {
      paramString.likeCnt = (i + j);
      if (paramString.likeCnt < 0) {
        paramString.likeCnt = 0;
      }
      this.jdField_a_of_type_Kuu.a(paramString, 0, paramInt, this.acl, this.mContentSrc);
      return;
    }
  }
  
  public void b(int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.acj);
    paramCommentData = parama;
    if (parama == null) {
      paramCommentData = new kut.a();
    }
    if (paramb == null) {
      new kut.b();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.ahO = paramCommentData.hasNextPage;
      this.acj = paramCommentData.acv;
      j(paramCommentData.gH, null);
      bool1 = true;
    }
    while (bool2) {
      if ((bool1) && ((paramCommentData.gH == null) || (paramCommentData.gH.isEmpty())))
      {
        if (TextUtils.isEmpty(this.aci))
        {
          QLog.d("ReadInJoyCommentDataManager", 1, "switchCommentFeedsType | hot is empty or first change to new : ");
          pO(1);
          return;
          bool1 = false;
        }
        else
        {
          a(new kud(this, o(3)));
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Ktr$b != null) && (this.jdField_a_of_type_Ktr$b.ahW))
        {
          if (!p(paramCommentData.gH)) {
            a(new kue(this));
          }
          this.jdField_a_of_type_Ktr$b.ahW = false;
        }
        parama = as();
        if (paramCommentData.gH != null)
        {
          paramInt = paramCommentData.gH.size();
          label226:
          paramb = new StringBuilder().append(", hot size : ");
          if (paramCommentData.gH == null) {
            break label364;
          }
        }
        label364:
        for (int i = paramCommentData.gH.size();; i = 0)
        {
          QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), i, ", totalCnt : ", Long.valueOf(this.sL) });
          a(new kuf(this, bool1, parama));
          if (this.jdField_a_of_type_Ktr$b == null) {
            break;
          }
          this.jdField_a_of_type_Ktr$b.mM(false);
          return;
          paramInt = 0;
          break label226;
        }
      }
    }
    if (paramCommentData.gH != null) {}
    for (parama = c(1, new ArrayList(paramCommentData.gH));; parama = new ArrayList())
    {
      bool2 = this.ahO;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(parama.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new kug(this, bool1, parama, bool2));
      return;
    }
  }
  
  public void b(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.b = paramArticleInfo;
    this.jdField_a_of_type_Kuy.b(paramArticleInfo);
  }
  
  public void bw(String paramString1, String paramString2)
  {
    aHp();
    j(1, paramString1, paramString2);
  }
  
  public void c(int paramInt, kut.a parama, kut.b paramb, CommentData paramCommentData)
  {
    paramCommentData = parama;
    if (parama == null) {
      paramCommentData = new kut.a();
    }
    parama = paramb;
    if (paramb == null) {
      parama = new kut.b();
    }
    boolean bool2 = TextUtils.isEmpty(this.ack);
    boolean bool1;
    label92:
    long l;
    if (paramInt == 0)
    {
      bool1 = true;
      if (!bool1) {
        break label223;
      }
      this.ack = paramCommentData.acv;
      this.ahP = paramCommentData.hasNextPage;
      k(paramCommentData.gH, this.gC);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
      if (!bool2) {
        break label247;
      }
      if (parama == null) {
        break label236;
      }
      l = parama.sN;
      label107:
      this.sM = l;
      parama = new StringBuilder();
      if (!paramCommentData.AB()) {
        break label242;
      }
    }
    label223:
    label236:
    label242:
    for (paramInt = paramCommentData.gH.size();; paramInt = 0)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramInt + ", mFamilyCommentCnt : ", Long.valueOf(this.sM) });
      a(new kuh(this, bool1, av()));
      return;
      bool1 = false;
      break;
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
      break label92;
      l = 0L;
      break label107;
    }
    label247:
    if (paramCommentData != null) {}
    for (parama = c(4, new ArrayList(paramCommentData.gH));; parama = new ArrayList())
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(parama.size()), ", hasNext : ", Boolean.valueOf(this.ahP) });
      a(new kui(this, bool1, parama));
      return;
    }
  }
  
  /* Error */
  public void c(ktr.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	ktr:mListeners	Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface 292 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 111	ktr:mListeners	Ljava/util/List;
    //   24: aload_1
    //   25: invokeinterface 197 2 0
    //   30: pop
    //   31: goto -14 -> 17
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	ktr
    //   0	39	1	paramd	ktr.d
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	34	finally
    //   20	31	34	finally
  }
  
  public long cm()
  {
    return this.sK;
  }
  
  public void cz(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Kut == null) || (TextUtils.isEmpty(this.acl)))
    {
      a(new kur(this, paramInt2));
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "loadFirstCommentList | feedsType : " + paramInt1 + " contentSrc : " + this.mContentSrc + "; fetchType : " + paramInt2, ", cookie : ", this.acg });
    if (paramInt2 == 1) {}
    for (String str = "";; str = this.acg)
    {
      this.acg = str;
      if ((paramInt2 != 1) || (this.jdField_a_of_type_Ktr$b == null) || (!this.jdField_a_of_type_Ktr$b.ahV)) {
        break;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.5(this, this.jdField_a_of_type_Ktr$b.acr));
      return;
    }
    if (paramInt1 == 6)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.6(this));
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.7(this, null));
  }
  
  public void destroy()
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "CommentDataManager destroy");
    if (this.dR != null) {
      this.dR.clear();
    }
    aHm();
    aHn();
    aHo();
    this.acl = "";
    this.ahL = false;
    this.acg = "";
    if (this.f != null) {
      this.f.clear();
    }
    if (this.mListeners != null) {
      this.mListeners.clear();
    }
    if (this.jdField_a_of_type_Kut != null) {
      this.jdField_a_of_type_Kut.aEL();
    }
    if (this.jdField_a_of_type_Kuu != null) {
      this.jdField_a_of_type_Kuu.destroy();
    }
  }
  
  public String eo(String paramString)
  {
    paramString = (BaseCommentData)this.dR.get(paramString);
    if ((paramString instanceof SubCommentData)) {
      return ((SubCommentData)paramString).parentCommentId;
    }
    if ((paramString instanceof CommentData)) {
      return paramString.commentId;
    }
    return "";
  }
  
  public int getContentSrc()
  {
    return this.mContentSrc;
  }
  
  public void mx(String paramString)
  {
    j(2, paramString, null);
  }
  
  public void my(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(1, paramString) == null) {
      return;
    }
    this.jdField_a_of_type_Kuu.a(paramString, this.acl, this.mContentSrc, 1, "", true, this.rowKey, 2);
  }
  
  public int nJ()
  {
    if (this.gA != null) {
      return this.gA.size();
    }
    return 0;
  }
  
  public int nK()
  {
    if (this.gz != null) {
      return this.gz.size();
    }
    return 0;
  }
  
  public List<ktm> o(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "getCurrentFeedsTypeItemList | feedsType " + paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return new ArrayList();
    case 3: 
      return as();
    case 2: 
      return au();
    }
    return av();
  }
  
  public void onCommentStateError(int paramInt)
  {
    a(new kuo(this, paramInt));
  }
  
  public void pN(int paramInt)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, "loadMoreComment | with feedsType : " + paramInt);
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 3: 
    case 5: 
      pP(2);
      return;
    case 2: 
      pO(2);
      return;
    }
    pQ(2);
  }
  
  public void q(ktm paramktm)
  {
    if (paramktm == null) {}
    do
    {
      do
      {
        return;
        paramktm = paramktm.a;
      } while (paramktm == null);
      if (this.dR != null) {
        this.dR.remove(paramktm);
      }
      paramktm = paramktm.commentId;
      if ((this.gz != null) && (this.gz.contains(paramktm)))
      {
        this.gz.remove(paramktm);
        a(new kts(this));
      }
      if ((this.gA != null) && (this.gA.contains(paramktm)))
      {
        this.gA.remove(paramktm);
        a(new kuc(this));
      }
    } while ((this.gC == null) || (!this.gC.contains(paramktm)));
    this.gC.remove(paramktm);
    a(new kun(this));
  }
  
  public long r(int paramInt)
  {
    long l = this.sK;
    if (paramInt == 6) {
      l = this.sM;
    }
    QLog.d("ReadInJoyCommentDataManager", 2, "getFirstCommentTotalCount | feedsType " + paramInt + "; totalCount " + l);
    return l;
  }
  
  public List<ktm> z(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.dR.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new ktm(0, paramString, this.b));
    localArrayList.add(new ktm(3, paramString, this.b));
    return localArrayList;
  }
  
  public abstract class a
  {
    private a() {}
    
    public abstract void d(ktr.d paramd);
  }
  
  public static class b
  {
    public String acr;
    public String acs;
    public boolean ahV;
    public boolean ahW;
    
    public b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.acr = paramString1;
      this.acs = paramString2;
      this.ahV = paramBoolean1;
      this.ahW = paramBoolean2;
    }
    
    public void mM(boolean paramBoolean)
    {
      this.ahV = paramBoolean;
    }
  }
  
  public static abstract interface c
  {
    public abstract void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3);
    
    public abstract void onCommentStateError(int paramInt);
  }
  
  public static abstract interface d
    extends ktr.c
  {
    public abstract void onCommentCreate(boolean paramBoolean, ktm paramktm, List<ktm> paramList, int paramInt);
    
    public abstract void onCommentCreate(boolean paramBoolean1, ktm paramktm, boolean paramBoolean2, List<ktm> paramList, int paramInt);
    
    public abstract void onCommentDelete(int paramInt1, boolean paramBoolean, ktm paramktm, int paramInt2);
    
    public abstract void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2);
    
    public abstract void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2);
    
    public abstract void onCommentReply(boolean paramBoolean, ktm paramktm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktr
 * JD-Core Version:    0.7.0.1
 */