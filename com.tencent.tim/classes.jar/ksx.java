import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ksx
{
  public static int aLx = 0;
  private int aLJ;
  private ArticleInfo b;
  private kte c;
  protected Map<String, ktm> dK = new HashMap();
  protected Map<String, ktm> dL = new HashMap();
  protected Map<String, ktm> dM = new HashMap();
  protected Map<String, ktm> dN = new HashMap();
  Map<Integer, ktm> dO = new HashMap();
  private Map<String, String> dP = new HashMap();
  private List<String> gr = new ArrayList();
  private List<String> gs = new ArrayList();
  private List<String> gt = new ArrayList();
  private List<Pair<Long, ktm>> gu = new ArrayList();
  private QQAppInterface mApp;
  
  public ksx(kte paramkte, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.c = paramkte;
    this.b = paramArticleInfo;
    aLx = paramInt;
    if ((this.c != null) && (this.c.a() != null)) {
      this.mApp = ((QQAppInterface)this.c.a().getAppRuntime());
    }
  }
  
  private void Y(long paramLong, int paramInt)
  {
    if ((this.dP == null) || (this.c == null)) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.gu == null) {
              this.gu = new ArrayList();
            }
          } while (this.c.getItem(paramInt) == null);
          localObject1 = (ktm)this.c.getItem(paramInt);
        } while (localObject1 == null);
        localObject2 = ((ktm)localObject1).a;
      } while (localObject2 == null);
      localObject2 = ((BaseCommentData)localObject2).commentId;
    } while ((((ktm)localObject1).type != 0) || (this.dP.containsKey(localObject2)));
    Object localObject1 = new Pair(Long.valueOf(paramLong), localObject1);
    this.gu.add(localObject1);
    this.dP.put(localObject2, "");
  }
  
  private int nG()
  {
    int j = 0;
    int i = j;
    if (this.c != null)
    {
      i = j;
      if (this.c.a() != null) {
        i = this.c.nI();
      }
    }
    return i;
  }
  
  private void pF(int paramInt)
  {
    pG(paramInt);
    aGX();
    aGY();
    aGU();
    aHa();
    aGZ();
  }
  
  private void pK(int paramInt)
  {
    if (paramInt > this.aLJ) {
      this.aLJ = paramInt;
    }
  }
  
  public void W(long paramLong, int paramInt)
  {
    eo(paramLong);
    pF(paramInt);
  }
  
  public void X(long paramLong, int paramInt)
  {
    eo(paramLong);
    pF(paramInt);
  }
  
  public void Z(long paramLong, int paramInt)
  {
    if (this.c == null) {}
    BaseCommentData localBaseCommentData;
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.gu == null) {
            this.gu = new ArrayList();
          }
          localObject = (ktm)this.c.getItem(paramInt);
        } while (localObject == null);
        localBaseCommentData = ((ktm)localObject).a;
      } while (localBaseCommentData == null);
      str = localBaseCommentData.commentId;
    } while ((((ktm)localObject).type != 0) || (!(localBaseCommentData instanceof SubCommentData)) || (this.dP.containsKey(str)));
    Object localObject = new Pair(Long.valueOf(paramLong), localObject);
    this.gu.add(localObject);
    this.dP.put(str, "");
  }
  
  public void a(int paramInt1, int paramInt2, ktm paramktm)
  {
    if (paramktm == null) {}
    while (paramktm.a == null) {
      return;
    }
    String str = "0X8009669";
    if (paramInt1 == 2) {
      str = "0X8009018";
    }
    bv(new krx(paramktm).a().c(paramInt2).build(), str);
  }
  
  public void a(int paramInt, BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null)
    {
      bv("", "0X8009BD7");
      return;
    }
    String str2 = new krx(this.b, paramBaseCommentData).a().build();
    Object localObject = "0X800900E";
    String str1 = "0X800900F";
    if (paramInt == 2)
    {
      localObject = "0X8009015";
      str1 = "0X8009016";
    }
    if (paramBaseCommentData.isLiked()) {}
    for (;;)
    {
      bv(str2.toString(), (String)localObject);
      return;
      localObject = str1;
    }
  }
  
  public void a(int paramInt, ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    while (paramktm.a == null) {
      return;
    }
    String str = "0X8009010";
    if (paramInt == 2) {
      str = "0X8009014";
    }
    bv(new krx(paramktm).a().d(1).build(), str);
  }
  
  public void aGT()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("entry", aLx);
      localJSONObject.put("area", 2);
      localJSONObject.put("comment_platform", 3);
      bv(localJSONObject.toString(), "0X800966A");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void aGU()
  {
    Iterator localIterator = this.dO.values().iterator();
    while (localIterator.hasNext())
    {
      ktm localktm = (ktm)localIterator.next();
      if (localktm.a != null) {
        kxm.a(localktm.a.medalInfo);
      }
    }
    this.dO.clear();
  }
  
  public void aGV()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("entry", aLx);
      localJSONObject.put("area", 2);
      localJSONObject.put("comment_platform", 3);
      bv(localJSONObject.toString(), "0X800966A");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void aGW()
  {
    if ((this.gu == null) || (this.gu.size() == 0) || (this.c == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.gu.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        long l = ((Long)((Pair)localObject).first).longValue();
        localObject = (SubCommentData)((ktm)((Pair)localObject).second).a;
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("entry", aLx);
          localJSONObject.put("comment_platform", 3);
          localJSONObject.put("comment_id", ((ktb)this.c).iH());
          localJSONObject.put("sub_comment_id", ((SubCommentData)localObject).commentId);
          localJSONObject.put("time", l);
          localJSONObject.put("thumb_up_num", ((SubCommentData)localObject).likeCnt);
          localJSONObject.put("shown_page", 2);
          localJSONObject.put("come_in_action", 2);
          localJSONObject.put("proxy_bytes", ((SubCommentData)localObject).passthrough);
          bv(localJSONObject.toString(), "0X8009992");
          kxm.a(((SubCommentData)localObject).medalInfo);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void aGX()
  {
    if ((this.dK == null) || (this.dK.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dK.values().iterator();
      while (localIterator.hasNext())
      {
        ktm localktm = (ktm)localIterator.next();
        if (localktm != null) {
          e(localktm);
        }
      }
    }
  }
  
  public void aGY()
  {
    if ((this.dL == null) || (this.dL.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dL.values().iterator();
      while (localIterator.hasNext())
      {
        ktm localktm = (ktm)localIterator.next();
        if (localktm != null) {
          e(localktm);
        }
      }
    }
  }
  
  public void aGZ()
  {
    if ((this.dN == null) || (this.dN.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dN.values().iterator();
      while (localIterator.hasNext())
      {
        ktm localktm = (ktm)localIterator.next();
        if (localktm != null) {
          e(localktm);
        }
      }
    }
  }
  
  public void aHa()
  {
    if ((this.dM == null) || (this.dM.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.dM.values().iterator();
      while (localIterator.hasNext())
      {
        ktm localktm = (ktm)localIterator.next();
        if (localktm != null) {
          bv(new krx(localktm).a().b().j().build(), "0X800A2D2");
        }
      }
    }
  }
  
  public void b(int paramInt, ktm paramktm)
  {
    if (paramktm == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramktm.a;
    } while (localObject == null);
    if (paramInt == 1) {
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009557";
      }
    }
    for (;;)
    {
      bv(new krx(paramktm).a().build(), (String)localObject);
      return;
      localObject = "0X8009558";
      continue;
      if (((BaseCommentData)localObject).isDisliked()) {
        localObject = "0X8009559";
      } else {
        localObject = "0X800955A";
      }
    }
  }
  
  public void b(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramktm.a;
    } while (localBaseCommentData == null);
    String str = "0X8009668";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X8009013";
    }
    bv(new krx(paramktm).a().build(), str);
  }
  
  public void b(ktm paramktm, SubCommentData paramSubCommentData)
  {
    if ((paramktm != null) && (paramktm.a != null)) {
      bv(new krx(paramktm).a().b(((CommentData)paramktm.a).subCommentNum).build(), "0X800901F");
    }
  }
  
  public void bv(String paramString1, String paramString2)
  {
    if ((this.b == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentReportManager.1(this, paramString2, paramString1));
  }
  
  public void c(ktm paramktm)
  {
    if (paramktm == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return;
      localBaseCommentData = paramktm.a;
    } while (localBaseCommentData == null);
    String str = "0X800900D";
    if ((localBaseCommentData instanceof SubCommentData)) {
      str = "0X800955B";
    }
    bv(new krx(paramktm).a().build(), str);
  }
  
  public void cx(int paramInt1, int paramInt2)
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      QLog.d("ReadInJoyCommentReportManager", 2, "recordLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
      int i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      if (this.gt != null)
      {
        this.gt.clear();
        while ((i <= paramInt2) && (i < this.c.getCount()))
        {
          ktm localktm = (ktm)this.c.getItem(i);
          if ((localktm != null) && (localktm.a != null) && (!TextUtils.isEmpty(localktm.a.commentId))) {
            this.gt.add(localktm.a.commentId);
          }
          i += 1;
        }
      }
    }
  }
  
  public void cy(int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentReportManager", 2, "recordSubLeaveCommentIDList current screen firstpos " + paramInt1 + ", lastpos " + paramInt2);
    if (this.gt != null) {
      this.gt.clear();
    }
    for (;;)
    {
      if ((paramInt1 > paramInt2) || (paramInt1 >= this.c.getCount())) {
        return;
      }
      ktm localktm = (ktm)this.c.getItem(paramInt1);
      if ((localktm != null) && (localktm.type == 0) && (localktm.a != null) && (!TextUtils.isEmpty(localktm.a.commentId))) {
        this.gt.add(localktm.a.commentId);
      }
      paramInt1 += 1;
    }
  }
  
  public void d(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    String str = "0X8009011";
    if ((paramktm.a instanceof SubCommentData)) {
      str = "0X800901A";
    }
    bv(new krx(paramktm).a().build(), str);
  }
  
  public void e(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    bv(new krx(paramktm).h().c().g().a().build(), "0X8009993");
  }
  
  public void en(long paramLong)
  {
    ep(paramLong);
    aGW();
    aGX();
  }
  
  public void eo(long paramLong)
  {
    if ((this.b == null) || (paramLong == 0L)) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "reportReadCommentTime ");
    if ((this.gt == null) || (this.gt.size() == 0)) {
      cx(0, this.aLJ);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", aLx);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_comment_num", this.aLJ);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", awit.f(this.gt));
      localJSONObject.put("shown_page", 1);
      localJSONObject.put("stream_type", nG());
      bv(localJSONObject.toString(), "0X8009991");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void ep(long paramLong)
  {
    if ((this.b == null) || (this.c == null) || (!(this.c instanceof ktb))) {
      return;
    }
    QLog.d("ReadInJoyCommentReportManager", 2, "ReadCommentTime " + paramLong);
    if ((this.gt != null) && (this.gt.isEmpty()) && (this.c.a() != null)) {
      cy(0, this.c.a().getLastVisiblePosition());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", aLx);
      localJSONObject.put("comment_platform", 3);
      localJSONObject.put("website", 0);
      localJSONObject.put("read_time", paramLong);
      localJSONObject.put("leave_comment_id_list", awit.f(this.gt));
      localJSONObject.put("shown_page", 2);
      localJSONObject.put("comment_id", ((ktb)this.c).iH());
      bv(localJSONObject.toString(), "0X8009991");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void f(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    bv(new krx(paramktm).h().c().g().a().build(), "0X8009994");
  }
  
  public void g(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    bv(new krx(paramktm).a().b().build(), "0X800A001");
  }
  
  public void h(ktm paramktm)
  {
    if (paramktm == null) {
      return;
    }
    bv(new krx(paramktm).a().b().j().build(), "0X8009E82");
  }
  
  public void i(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null) || (this.dK == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramktm.a.isActivity());
      localBaseCommentData = paramktm.a;
    } while (this.dK.containsKey(localBaseCommentData.commentId));
    this.dK.put(localBaseCommentData.commentId, paramktm);
  }
  
  public void j(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null) || (this.dK == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramktm.a.isBanner());
      localBaseCommentData = paramktm.a;
    } while (this.dL.containsKey(localBaseCommentData.commentId));
    this.dL.put(localBaseCommentData.commentId, paramktm);
  }
  
  public void k(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null) || (this.dN == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (!paramktm.a.isDynamicComment());
      localBaseCommentData = paramktm.a;
    } while (this.dN.containsKey(localBaseCommentData.commentId));
    this.dN.put(localBaseCommentData.commentId, paramktm);
  }
  
  public void l(ktm paramktm)
  {
    if ((paramktm == null) || (paramktm.a == null) || (this.dM == null)) {}
    BaseCommentData localBaseCommentData;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramktm.a.flowGuidePtsData));
      localBaseCommentData = paramktm.a;
    } while (this.dM.containsKey(localBaseCommentData.commentId));
    this.dM.put(localBaseCommentData.commentId, paramktm);
  }
  
  public void pG(int paramInt)
  {
    if ((this.gu == null) || (this.gu.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.gu.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        long l = ((Long)localPair.first).longValue();
        CommentData localCommentData = (CommentData)((ktm)localPair.second).a;
        ArrayList localArrayList = new ArrayList();
        Object localObject;
        if ((localCommentData.subCommentList != null) && (localCommentData.subCommentList.size() > 0))
        {
          localObject = localCommentData.subCommentList.iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((SubCommentData)((Iterator)localObject).next()).commentId);
          }
        }
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("entry", aLx);
          ((JSONObject)localObject).put("comment_platform", 3);
          ((JSONObject)localObject).put("comment_id", localCommentData.commentId);
          ((JSONObject)localObject).put("time", l);
          ((JSONObject)localObject).put("thumb_up_num", localCommentData.likeCnt);
          ((JSONObject)localObject).put("sub_comment_num", localCommentData.subCommentNum);
          ((JSONObject)localObject).put("shown_page", 1);
          ((JSONObject)localObject).put("comment_type", ((ktm)localPair.second).area);
          ((JSONObject)localObject).put("show_sub_comment_id", awit.f(localArrayList));
          ((JSONObject)localObject).put("come_in_action", paramInt);
          ((JSONObject)localObject).put("proxy_bytes", localCommentData.passthrough);
          ((JSONObject)localObject).put("stream_type", nG());
          bv(((JSONObject)localObject).toString(), "0X8009992");
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void pH(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    bv(new krx(this.b, null).e(paramInt).build(), "0X8009D01");
  }
  
  public void pI(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    i((ktm)this.c.getItem(paramInt));
    j((ktm)this.c.getItem(paramInt));
    pK(paramInt);
    l((ktm)this.c.getItem(paramInt));
    Y(System.currentTimeMillis(), paramInt);
    k((ktm)this.c.getItem(paramInt));
    this.dO.put(Integer.valueOf(paramInt), (ktm)this.c.getItem(paramInt));
  }
  
  public void pJ(int paramInt)
  {
    if (this.c != null) {
      i((ktm)this.c.getItem(paramInt));
    }
    Z(System.currentTimeMillis(), paramInt);
  }
  
  public void resetData()
  {
    this.aLJ = 0;
    if (this.gr != null)
    {
      this.gr.clear();
      if (this.gt == null) {
        break label148;
      }
      this.gt.clear();
      label37:
      if (this.dP == null) {
        break label162;
      }
      this.dP.clear();
      label53:
      if (this.gu == null) {
        break label176;
      }
      this.gu.clear();
      label69:
      if (this.dK == null) {
        break label190;
      }
      this.dK.clear();
      label85:
      if (this.dL == null) {
        break label204;
      }
      this.dL.clear();
      label101:
      if (this.dO == null) {
        break label218;
      }
      this.dO.clear();
    }
    for (;;)
    {
      if (this.dM == null) {
        break label232;
      }
      this.dM.clear();
      return;
      this.gr = new ArrayList();
      break;
      label148:
      this.gt = new ArrayList();
      break label37;
      label162:
      this.dP = new HashMap();
      break label53;
      label176:
      this.gu = new ArrayList();
      break label69;
      label190:
      this.dK = new HashMap();
      break label85;
      label204:
      this.dL = new HashMap();
      break label101;
      label218:
      this.dO = new HashMap();
    }
    label232:
    this.dM = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksx
 * JD-Core Version:    0.7.0.1
 */