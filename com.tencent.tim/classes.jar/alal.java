import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class alal
  implements aolm.b
{
  public static aolm.a c;
  private alaj a;
  private QQAppInterface app;
  private aolm c;
  public boolean cvI = true;
  private ConcurrentHashMap<String, alal.b> gx = new ConcurrentHashMap();
  private List<alai> mListenerList = new Vector();
  private Map<String, aoll> mr = Collections.synchronizedMap(new HashMap());
  
  static
  {
    jdField_c_of_type_Aolm$a = new alam();
  }
  
  public alal(QQAppInterface paramQQAppInterface, alaj paramalaj)
  {
    this.a = paramalaj;
    this.app = paramQQAppInterface;
  }
  
  private boolean a(PrecoverResource paramPrecoverResource)
  {
    return (this.a != null) && (this.a.a(paramPrecoverResource));
  }
  
  private boolean b(PrecoverResource paramPrecoverResource)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource == null)
      {
        localObject = "null";
        QLog.d("PrecoverResDownloader", 2, new Object[] { "isNeedDownload, resource=", localObject });
      }
    }
    else
    {
      if (paramPrecoverResource != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, "isNeedDownload, resource == null");
      }
    }
    for (;;)
    {
      return false;
      localObject = paramPrecoverResource;
      break;
      label57:
      if (TextUtils.isEmpty(paramPrecoverResource.businessId))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, businessId is empty");
          return false;
        }
      }
      else if (TextUtils.isEmpty(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is empty");
          return false;
        }
      }
      else if (this.mr.containsKey(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is in set");
          return false;
        }
      }
      else {
        try
        {
          boolean bool = alan.aK(paramPrecoverResource.businessId, paramPrecoverResource.md5);
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload. file exist=" + bool + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
          if (!bool) {}
          for (bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Throwable localThrowable)
        {
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload.exception happen.e=" + localThrowable.getMessage() + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
        }
      }
    }
    localThrowable.printStackTrace();
    return false;
  }
  
  public alal.b a(String paramString)
  {
    return (alal.b)this.gx.get(paramString);
  }
  
  public void a(alai paramalai)
  {
    if (paramalai == null) {}
    while (this.mListenerList.contains(paramalai)) {
      return;
    }
    this.mListenerList.add(paramalai);
  }
  
  public void a(alal.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "sendReqToNetEngine, task=" + parama + ", mNetEngine=" + this.jdField_c_of_type_Aolm);
    }
    if ((parama == null) || (parama.d == null)) {
      return;
    }
    if (this.jdField_c_of_type_Aolm == null) {
      this.jdField_c_of_type_Aolm = this.app.getNetEngine(0);
    }
    this.jdField_c_of_type_Aolm.a(parama.d);
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject)
  {
    return a(paramPrecoverResource, paramObject, false, false);
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource != null) {
        break label79;
      }
      localObject1 = "null";
      if (paramObject != null) {
        break label85;
      }
    }
    label79:
    label85:
    for (Object localObject2 = "null";; localObject2 = paramObject)
    {
      QLog.d("PrecoverResDownloader", 2, new Object[] { "resource=", localObject1, ", userData=", localObject2, ", checkControl=", Boolean.valueOf(paramBoolean1) });
      if (paramPrecoverResource != null) {
        break label91;
      }
      QLog.d("PrecoverResDownloader", 1, "download, resource is null");
      return false;
      localObject1 = paramPrecoverResource;
      break;
    }
    label91:
    if (!paramPrecoverResource.isValid())
    {
      QLog.d("PrecoverResDownloader", 1, "download, resource.isValid() return false");
      return false;
    }
    if (!b(paramPrecoverResource))
    {
      QLog.d("PrecoverResDownloader", 1, "download, isNeedDownload() return false");
      return false;
    }
    if ((paramBoolean1) && (!a(paramPrecoverResource)))
    {
      QLog.d("PrecoverResDownloader", 1, "download, canDownload() return false");
      return false;
    }
    if (this.jdField_c_of_type_Aolm == null) {
      this.jdField_c_of_type_Aolm = this.app.getNetEngine(0);
    }
    this.gx.put(paramPrecoverResource.md5, new alal.b());
    Object localObject1 = new aoll();
    ((aoll)localObject1).f = this;
    ((aoll)localObject1).bZ = paramPrecoverResource.url;
    ((aoll)localObject1).mHttpMethod = 0;
    if ((paramBoolean2) && (!TextUtils.isEmpty(paramPrecoverResource.thirdPartDownloadPath))) {}
    for (((aoll)localObject1).atY = paramPrecoverResource.thirdPartDownloadPath;; ((aoll)localObject1).atY = alan.G(paramPrecoverResource.businessId, paramPrecoverResource.md5))
    {
      ((aoll)localObject1).dPo = 2;
      ((aoll)localObject1).bw(new Object[] { paramPrecoverResource, paramObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      ((aoll)localObject1).a = jdField_c_of_type_Aolm$a;
      this.mr.put(paramPrecoverResource.md5, localObject1);
      if (this.cvI) {
        break;
      }
      this.jdField_c_of_type_Aolm.a((aomg)localObject1);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverResDownloader", 2, "innerDownload, mUsePreDownScheduler==true");
    }
    int i;
    switch (this.a.Hq())
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramObject = new alal.a(this.app, paramPrecoverResource, (aoll)localObject1);
      paramBoolean1 = ((aopo)this.app.getManager(193)).a(10064, "prd", paramPrecoverResource.md5, 0, paramPrecoverResource.url, ((aoll)localObject1).atY, i, 0, true, paramObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PrecoverResDownloader", 2, "innerDownload, PreDownloadController.ret=" + paramBoolean1);
      break;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public void b(alai paramalai)
  {
    if (paramalai == null) {
      return;
    }
    this.mListenerList.remove(paramalai);
  }
  
  public void cancelDownload(String paramString)
  {
    aoll localaoll = (aoll)this.mr.get(paramString);
    if (localaoll != null)
    {
      this.jdField_c_of_type_Aolm.b(localaoll);
      this.mr.remove(paramString);
    }
  }
  
  public boolean isDownloading(String paramString)
  {
    return this.mr.containsKey(paramString);
  }
  
  public void onResp(aomh paramaomh)
  {
    int i;
    aoll localaoll;
    Object localObject1;
    int j;
    Object localObject4;
    String str1;
    label56:
    Object localObject3;
    Object localObject2;
    boolean bool;
    int k;
    if (paramaomh.mResult == 0)
    {
      i = 1;
      localaoll = (aoll)paramaomh.b;
      localObject1 = localaoll.U();
      j = paramaomh.mErrCode;
      localObject4 = new File(localaoll.atY);
      if (paramaomh.clO != null) {
        break label535;
      }
      str1 = "0";
      if ((localObject1 == null) || (!(localObject1 instanceof Object[])) || (((Object[])localObject1).length < 4)) {
        break label569;
      }
      localObject3 = (Object[])localObject1;
      localObject1 = (PrecoverResource)localObject3[0];
      localObject2 = localObject3[1];
      bool = ((Boolean)localObject3[3]).booleanValue();
      if (i == 0) {
        break label544;
      }
      localObject3 = alab.getFileMD5String(((File)localObject4).getAbsolutePath());
      if (((PrecoverResource)localObject1).md5.equalsIgnoreCase((String)localObject3)) {
        break label842;
      }
      k = -6103066;
      ((File)localObject4).delete();
      i = 0;
      QLog.i("PrecoverResDownloader", 1, "onResp.md5 verify fail.md5=" + ((PrecoverResource)localObject1).md5 + ",calMD5=" + (String)localObject3);
    }
    for (;;)
    {
      j = k;
      int m = i;
      if (i != 0)
      {
        j = k;
        m = i;
        if (!bool)
        {
          j = k;
          m = i;
          if (this.a != null)
          {
            this.a.a((PrecoverResource)localObject1);
            m = i;
            j = k;
          }
        }
      }
      label249:
      if (this.mr.containsKey(((PrecoverResource)localObject1).md5)) {
        this.mr.remove(((PrecoverResource)localObject1).md5);
      }
      if (this.gx.containsKey(((PrecoverResource)localObject1).md5)) {
        this.gx.remove(((PrecoverResource)localObject1).md5);
      }
      i = j;
      j = m;
      label314:
      label342:
      long l1;
      if (QLog.isColorLevel())
      {
        String str2 = localaoll.bZ;
        k = paramaomh.mResult;
        if (localObject1 == null)
        {
          localObject3 = "null";
          QLog.d("PrecoverResDownloader", 2, new Object[] { "onResp.url=", str2, ", result=", Integer.valueOf(k), ", errCode=", Integer.valueOf(i), ", resource=", localObject3 });
        }
      }
      else
      {
        if ((j == 0) || (!((File)localObject4).exists())) {
          break label624;
        }
        l1 = ((File)localObject4).length();
        label423:
        if (this.cvI)
        {
          localObject3 = (aopo)this.app.getManager(193);
          localObject4 = localaoll.bZ;
          if (j == 0) {
            break label630;
          }
        }
      }
      label535:
      label544:
      label569:
      label624:
      label630:
      for (long l2 = l1;; l2 = -1L)
      {
        ((aopo)localObject3).be((String)localObject4, l2);
        k = 0;
        while (k < this.mListenerList.size())
        {
          localObject3 = (alai)this.mListenerList.get(k);
          if (localObject3 != null) {
            ((alai)localObject3).a(i, str1, (PrecoverResource)localObject1, localObject2);
          }
          k += 1;
        }
        i = 0;
        break;
        str1 = paramaomh.clO;
        break label56;
        if ((localObject4 != null) && (((File)localObject4).exists())) {
          ((File)localObject4).delete();
        }
        m = i;
        break label249;
        if ((localObject4 != null) && (((File)localObject4).exists())) {
          ((File)localObject4).delete();
        }
        QLog.i("PrecoverResDownloader", 1, "onResp objects == null || objects not instanceof Object[] || ((Object[]) objects).length < 3");
        localObject1 = null;
        k = i;
        i = j;
        localObject2 = null;
        bool = false;
        j = k;
        break label314;
        localObject3 = localObject1;
        break label342;
        l1 = 0L;
        break label423;
      }
      if (j == 0)
      {
        localObject3 = new StringBuilder().append("onResp.url=").append(localaoll.bZ).append(", result=").append(paramaomh.mResult).append(", errCode=").append(i).append(",md5 = ");
        if (localObject1 == null)
        {
          localObject2 = "null";
          QLog.i("PrecoverResDownloader", 1, (String)localObject2 + ", errDesc=" + str1);
        }
      }
      else if (!bool)
      {
        if (this.a != null) {
          break label813;
        }
        localObject2 = null;
        label745:
        if ((localObject2 == null) || (localObject1 == null)) {
          break label832;
        }
        if ((paramaomh.nR == null) || (!paramaomh.nR.containsKey("netresp_param_reason"))) {
          break label825;
        }
      }
      label813:
      label825:
      for (paramaomh = (String)paramaomh.nR.get("netresp_param_reason");; paramaomh = "0")
      {
        ((alak)localObject2).a((PrecoverResource)localObject1, i, str1, paramaomh, l1);
        return;
        localObject2 = ((PrecoverResource)localObject1).md5;
        break;
        localObject2 = this.a.a();
        break label745;
      }
      label832:
      QLog.i("PrecoverResDownloader", 1, "onResp，reporter or resource is null");
      return;
      label842:
      k = j;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    Object localObject1 = null;
    if (paramaomg == null)
    {
      QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, req is null");
      return;
    }
    paramaomg = paramaomg.U();
    if ((paramaomg != null) && ((paramaomg instanceof Object[])) && (((Object[])paramaomg).length >= 2))
    {
      localObject1 = (Object[])paramaomg;
      paramaomg = (PrecoverResource)localObject1[0];
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      if (paramaomg == null)
      {
        QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, resource is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, new Object[] { "onUpdateProgeress, resource=", paramaomg, ", userData=", localObject1, ", currOffSet=", Long.valueOf(paramLong1), ", totalLen=", Long.valueOf(paramLong2) });
      }
      alal.b localb = (alal.b)this.gx.get(paramaomg.md5);
      Object localObject2 = localb;
      if (localb == null) {
        localObject2 = new alal.b();
      }
      ((alal.b)localObject2).total = paramLong2;
      ((alal.b)localObject2).afW = paramLong1;
      this.gx.put(paramaomg.md5, localObject2);
      int i = 0;
      while (i < this.mListenerList.size())
      {
        localObject2 = (alai)this.mListenerList.get(i);
        if (localObject2 != null) {
          ((alai)localObject2).a(paramaomg, localObject1, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      paramaomg = null;
    }
  }
  
  public static class a
    extends aopm
  {
    PrecoverResource a;
    aoll d;
    
    public a(QQAppInterface paramQQAppInterface, PrecoverResource paramPrecoverResource, aoll paramaoll)
    {
      super(paramPrecoverResource.md5);
      this.a = paramPrecoverResource;
      this.d = paramaoll;
    }
    
    protected void realCancel()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, "DownloadTask realCancel");
      }
      alaj localalaj = (alaj)this.app.getManager(179);
      if ((localalaj != null) && (localalaj.a() != null)) {
        localalaj.a().cancelDownload(this.a.md5);
      }
    }
    
    protected void realStart()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, "DownloadTask realStart");
      }
      alaj localalaj = (alaj)this.app.getManager(179);
      if ((localalaj != null) && (localalaj.a() != null)) {
        localalaj.a().a(this);
      }
    }
    
    public String toString()
    {
      return "[DownloadTask] req=" + this.d + ", res=" + this.a;
    }
  }
  
  public static class b
  {
    public long afW = -1L;
    public long total = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alal
 * JD-Core Version:    0.7.0.1
 */