import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class aduq
  implements aolm.b, Manager
{
  static aolm.a b = new adur();
  adup a;
  AppInterface app;
  private aolm c;
  Set<String> cf = Collections.synchronizedSet(new HashSet());
  private List<aduq.b> ys = new Vector();
  
  public aduq(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    this.c = paramAppInterface.getNetEngine(0);
    this.a = new adup();
  }
  
  private void a(aduq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + parama);
    }
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = parama.url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = this.a.a(this.app, parama.type).b(parama);
    localaoll.dPo = 1;
    localaoll.bw(parama);
    localaoll.a = b;
    this.c.a(localaoll);
  }
  
  private String c(aduq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + parama);
    }
    String str = this.a.a(this.app, parama.type).a(parama);
    if (!aqhq.fileExists(str)) {}
    try
    {
      aqhq.W(this.a.a(this.app, parama.type).b(parama), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      aqhq.cn(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + parama + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private boolean d(aduq.a parama)
  {
    return this.a.a(this.app, parama.type).a(parama);
  }
  
  public void a(aduq.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.ys)
    {
      if (!this.ys.contains(paramb)) {
        this.ys.add(paramb);
      }
      return;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, aduq.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    aduq.a locala = new aduq.a();
    locala.type = paramInt;
    locala.url = paramString1;
    locala.retryCount = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    locala.bvD = str;
    locala.bQV = paramBoolean;
    locala.userData = paramObject;
    locala.b = paramb;
    if (TextUtils.isEmpty(paramString2)) {
      locala.md5 = Utils.Crc64String(paramString1);
    }
    for (locala.bQW = false;; locala.bQW = true)
    {
      return c(locala);
      locala.md5 = paramString2;
    }
  }
  
  public void b(aduq.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.ys)
    {
      this.ys.remove(paramb);
      return;
    }
  }
  
  public boolean c(aduq.a parama)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + parama);
    }
    Object localObject2 = this.a.a(this.app, parama.type);
    if ((!TextUtils.isEmpty(parama.md5)) && (this.cf.contains(parama.md5)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + parama);
      }
      return false;
    }
    Object localObject1;
    if (!d(parama))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + parama);
      }
      if (parama.bQV)
      {
        localObject1 = ((adup.b)localObject2).a(parama);
        if ((aqhq.fileExists((String)localObject1)) && (!((adup.b)localObject2).a(parama, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + parama);
          }
          aqhq.cn((String)localObject1);
        }
        localObject1 = c(parama);
        if (new File((String)localObject1).exists()) {
          break label637;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = this.ys;
        int j = 0;
        try
        {
          for (;;)
          {
            if (j < this.ys.size())
            {
              aduq.b localb = (aduq.b)this.ys.get(j);
              if (localb != null) {
                localb.a(parama.url, parama.md5, i, (String)localObject1, parama.userData);
              }
              j += 1;
              continue;
              localObject1 = ((adup.b)localObject2).b(parama);
              break;
            }
          }
          if (parama.b != null) {
            parama.b.a(parama.url, parama.md5, i, (String)localObject1, parama.userData);
          }
          return true;
        }
        finally {}
      }
      this.cf.add(parama.md5);
      for (;;)
      {
        try
        {
          localObject1 = (alaj)this.app.getManager(179);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((alal)localObject1).isDownloading(parama.md5);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + parama.md5);
            }
            if (bool) {
              ((alal)localObject1).cancelDownload(parama.md5);
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ResDownloadManager", 2, "download send request ,url = " + parama.url);
        }
        if (parama.type == 4) {
          irm.jw(parama.md5);
        }
        localObject1 = new aoll();
        ((aoll)localObject1).f = this;
        ((aoll)localObject1).bZ = parama.url;
        ((aoll)localObject1).mHttpMethod = 0;
        ((aoll)localObject1).atY = ((adup.b)localObject2).b(parama);
        ((aoll)localObject1).dPo = 1;
        ((aoll)localObject1).bw(parama);
        ((aoll)localObject1).a = b;
        this.c.a((aomg)localObject1);
        return true;
        localObject1 = ((alaj)localObject1).a();
      }
      label637:
      i = 0;
    }
  }
  
  public void onDestroy() {}
  
  public void onResp(aomh paramaomh)
  {
    boolean bool1;
    aoll localaoll;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label57:
    Object localObject3;
    boolean bool2;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      localaoll = (aoll)paramaomh.b;
      localObject1 = new File(localaoll.atY);
      localObject2 = localaoll.U();
      i = paramaomh.mErrCode;
      if (paramaomh.clO != null) {
        break label444;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof aduq.a))) {
        break label601;
      }
      localObject2 = (aduq.a)localObject2;
      localObject3 = this.a.a(this.app, ((aduq.a)localObject2).type);
      localObject4 = ((aduq.a)localObject2).md5;
      if (!bool1) {
        break label453;
      }
      if (!((aduq.a)localObject2).bQW) {
        break label1185;
      }
      if (((adup.b)localObject3).b((aduq.a)localObject2)) {
        break label1180;
      }
      j = -6103066;
      ((File)localObject1).delete();
      bool1 = false;
      i = j;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + bool1 + "|" + localObject2);
        bool2 = bool1;
        i = j;
      }
      label197:
      localObject3 = ((adup.b)localObject3).a((aduq.a)localObject2);
      if ((!bool2) || (!((aduq.a)localObject2).bQV)) {
        break label1171;
      }
      aqhq.cn((String)localObject3);
      c((aduq.a)localObject2);
      localObject3 = new File((String)localObject3);
      bool2 = ((File)localObject3).exists();
      if (!bool2) {
        i = 2;
      }
      j = i;
      localObject1 = localObject3;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + bool2 + "|" + localObject2);
        bool1 = bool2;
        localObject1 = localObject3;
        j = i;
      }
      label321:
      if (this.cf.contains(localObject4)) {
        this.cf.remove(localObject4);
      }
      i = j;
      j = 0;
      label351:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp url:" + localaoll.bZ + " result:" + paramaomh.mResult + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label653;
      }
      label437:
      return;
      bool1 = false;
      break;
      label444:
      str = paramaomh.clO;
      break label57;
      label453:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramaomh.mResult + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((aduq.a)localObject2).retryCount > 0)
      {
        ((aduq.a)localObject2).retryCount -= 1;
        a((aduq.a)localObject2);
        j = 1;
        break label351;
      }
      if (this.cf.contains(localObject4)) {
        this.cf.remove(localObject4);
      }
      j = 0;
      break label351;
      label601:
      ((File)localObject1).delete();
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp userdata|" + localObject2);
      }
      localObject3 = localObject1;
      localObject2 = null;
      localObject1 = null;
    }
    label653:
    Object localObject4 = this.ys;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.ys.size())
        {
          aduq.b localb = (aduq.b)this.ys.get(j);
          if ((localb == null) || (localObject1 == null)) {
            break label1192;
          }
          localb.a(localaoll.bZ, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aduq.a)localObject1).userData);
          break label1192;
        }
        if ((localObject1 != null) && (((aduq.a)localObject1).b != null)) {
          ((aduq.a)localObject1).b.a(localaoll.bZ, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((aduq.a)localObject1).userData);
        }
        if ((bool1) || (localObject1 == null)) {
          break label437;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramaomh.dPy);
        if ((paramaomh.nR != null) && (paramaomh.nR.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramaomh.nR.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", alan.mD(((aduq.a)localObject1).url));
          ((HashMap)localObject3).put("md5", ((aduq.a)localObject1).md5);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((aduq.a)localObject1).type + "");
          ((HashMap)localObject3).put("endFix", ((aduq.a)localObject1).bvD);
          ((HashMap)localObject3).put("retryCount", ((aduq.a)localObject1).retryCount + "");
          ((HashMap)localObject3).put("needUnzip", ((aduq.a)localObject1).bQV + "");
          ((HashMap)localObject3).put("needVerify", ((aduq.a)localObject1).bQW + "");
          ((HashMap)localObject3).put("httpCode", paramaomh.dPy + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
          return;
        }
      }
      finally {}
      localObject2 = "0";
      continue;
      label1171:
      bool1 = bool2;
      j = i;
      break label321;
      label1180:
      j = i;
      break;
      label1185:
      bool2 = bool1;
      break label197;
      label1192:
      j += 1;
    }
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((??? == null) || (!(??? instanceof aoll))) {}
    String str1;
    do
    {
      return;
      str1 = ((aoll)???).bZ;
      ??? = ???.U();
    } while ((??? == null) || (!(??? instanceof aduq.a)));
    aduq.a locala = (aduq.a)???;
    String str2 = locala.md5;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + locala);
    }
    if (locala.bQV) {}
    for (int i = 90;; i = 100)
    {
      if (paramLong2 > 0L) {
        i = (int)(i * paramLong1 / paramLong2);
      }
      for (;;)
      {
        synchronized (this.ys)
        {
          if (j < this.ys.size())
          {
            aduq.b localb = (aduq.b)this.ys.get(j);
            if (localb == null) {
              break label234;
            }
            localb.f(str1, str2, i);
            break label234;
          }
          if (locala.b == null) {
            break;
          }
          locala.b.f(str1, str2, i);
          return;
        }
        i = 0;
        continue;
        label234:
        j += 1;
      }
    }
  }
  
  public static class a
  {
    public aduq.b b;
    public boolean bQV;
    public boolean bQW = true;
    public String bvD;
    public String md5;
    public int retryCount;
    public int type = 0;
    public String url;
    public Object userData;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("|_DownloadParam_start");
      localStringBuilder.append("|").append(" type:").append(this.type);
      localStringBuilder.append("|").append(" md5:").append(this.md5);
      localStringBuilder.append("|").append(" endFix:").append(this.bvD);
      localStringBuilder.append("|").append(" retryCount:").append(this.retryCount);
      localStringBuilder.append("|").append(" needUnzip:").append(this.bQV);
      localStringBuilder.append("|").append(" needVerify:").append(this.bQW);
      localStringBuilder.append("|").append(" url:").append(this.url);
      if (this.userData != null) {
        localStringBuilder.append("|").append(" userData:").append(this.userData);
      }
      localStringBuilder.append("|end");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject);
    
    public abstract void f(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduq
 * JD-Core Version:    0.7.0.1
 */