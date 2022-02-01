import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class akpy
  implements aolm.b
{
  static aolm.a b = new akpz();
  private static int doR = 3;
  private QQAppInterface app;
  private aolm c;
  Set<String> cf = Collections.synchronizedSet(new HashSet());
  private List<akpy.a> ys = new Vector();
  
  public akpy(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicResources", 2, "retry.url" + paramString1 + ",md5=" + paramString2 + ",userData=" + paramObject + ",retryCount=" + paramInt1);
    }
    if (this.c == null) {
      this.c = this.app.getNetEngine(0);
    }
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = paramString1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = paramString3;
    localaoll.dPo = 1;
    localaoll.bw(new Object[] { paramString2, paramObject, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    localaoll.a = b;
    this.c.a(localaoll);
  }
  
  private boolean bm(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicResources", 2, "isNeedDownload ,md = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.cf.contains(paramString1))) {}
    for (;;)
    {
      return false;
      try
      {
        String str = getResourceDir();
        paramString2 = new File(str + paramString1 + paramString2);
        if (!paramString2.exists())
        {
          this.cf.add(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "isNeedDownload. file not exist,md = " + paramString1 + ",file = " + paramString2.getAbsolutePath());
          }
          return true;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "isNeedDownload.exception happen.e=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public static String getResourceDir()
  {
    if (aqfo.isExistSDCard()) {
      return acbn.SDCARD_PATH + "OlympicRes/";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "OlympicRes/";
  }
  
  public static boolean isFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(getResourceDir() + paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static String mC(String paramString)
  {
    String str = getResourceDir() + paramString + "_dir" + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("OlympicResources", 2, "getUncompressedZipFileDir ,md = " + paramString + ",dir = " + str);
    }
    return str;
  }
  
  public void a(akpy.a parama)
  {
    if (parama == null) {}
    while (this.ys.contains(parama)) {
      return;
    }
    this.ys.add(parama);
  }
  
  public boolean a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicResources", 2, "downLoad.url" + paramString1 + ",md5=" + paramString2 + ",userData=" + paramObject);
    }
    if ((paramObject != null) && ((paramObject instanceof String)) && ("mp4".equals(paramObject))) {}
    String str2;
    for (String str1 = ".mp4";; str2 = "")
    {
      if (!bm(paramString2, str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "downLoad.not need to download.md5=" + paramString2 + ",url=" + paramString1);
        }
        if ((paramObject != null) && ((paramObject instanceof String[])))
        {
          paramString1 = (String[])paramObject;
          paramObject = paramString1[0];
          if ((paramObject != null) && ("shuayishua_anim".equals(paramObject)))
          {
            str1 = mC(paramString2);
            localObject = str1 + "pullfire";
            String str3 = str1 + "takefire";
            String str4 = str1 + "firestart";
            String str5 = str1 + "fire";
            if ((aqhq.fileExists((String)localObject)) && (aqhq.fileExists(str3)) && (aqhq.fileExists(str4)) && (aqhq.fileExists(str5))) {}
          }
        }
        try
        {
          localObject = new File(str1);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          aqhq.W(getResourceDir() + paramString2, str1, false);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "re un compressZip shuayishua_anim success.destDir=" + str1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OlympicResources", 2, "re un compressZip shuayishua_anim failed: " + localException.getMessage());
            }
          }
        }
        if ((paramObject != null) && ("ActConfig".equals(paramObject)))
        {
          paramString1 = paramString1[1];
          if ((paramString1 != null) && ("TorchAnim".equals(paramString1)))
          {
            paramString1 = mC(paramString2);
            if (aqhq.fileExists(paramString1 + "fire")) {}
          }
        }
        try
        {
          paramObject = new File(paramString1);
          if (paramObject.exists()) {
            paramObject.delete();
          }
          aqhq.W(getResourceDir() + paramString2, paramString1, false);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "re un compressZip TorchAnim success.destDir=" + paramString1);
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OlympicResources", 2, "re un compressZip TorchAnim failed: " + paramString1.getMessage());
            }
          }
        }
        return false;
      }
      if (paramBoolean2)
      {
        localObject = (OlympicManager)this.app.getManager(167);
        if (localObject != null)
        {
          if (!((OlympicManager)localObject).kT(paramString1))
          {
            akrf.log("OlympicResources", new Object[] { "download, checkLimit == false, url=", paramString1 });
            return true;
          }
          ((OlympicManager)localObject).s(paramString1, 1, false);
        }
      }
      if (this.c == null) {
        this.c = this.app.getNetEngine(0);
      }
      Object localObject = new aoll();
      ((aoll)localObject).f = this;
      ((aoll)localObject).bZ = paramString1;
      ((aoll)localObject).mHttpMethod = 0;
      ((aoll)localObject).atY = (getResourceDir() + paramString2 + localException);
      ((aoll)localObject).dPo = 1;
      ((aoll)localObject).bw(new Object[] { paramString2, paramObject, Integer.valueOf(0), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      ((aoll)localObject).a = b;
      this.c.a((aomg)localObject);
      return true;
    }
  }
  
  public void b(akpy.a parama)
  {
    if (parama == null) {
      return;
    }
    this.ys.remove(parama);
  }
  
  public void onResp(aomh paramaomh)
  {
    boolean bool1;
    aoll localaoll;
    Object localObject2;
    Object localObject1;
    int i;
    String str1;
    label57:
    Object localObject4;
    Object localObject5;
    int k;
    boolean bool2;
    int j;
    long l;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      localaoll = (aoll)paramaomh.b;
      localObject2 = new File(localaoll.atY);
      localObject1 = localaoll.U();
      i = paramaomh.mErrCode;
      if (paramaomh.clO != null) {
        break label636;
      }
      str1 = "0";
      if ((localObject1 == null) || (!(localObject1 instanceof Object[]))) {
        break label888;
      }
      localObject1 = (Object[])localObject1;
      localObject4 = (String)localObject1[0];
      localObject5 = localObject1[1];
      k = ((Integer)localObject1[2]).intValue();
      bool2 = ((Boolean)localObject1[3]).booleanValue();
      j = ((Integer)localObject1[4]).intValue();
      if (!bool1) {
        break label662;
      }
      if (this.cf.contains(localObject4)) {
        this.cf.remove(localObject4);
      }
      localObject1 = alab.getFileMD5String(((File)localObject2).getAbsolutePath());
      if (((String)localObject4).equals(localObject1)) {
        break label645;
      }
      ((File)localObject2).delete();
      bool1 = false;
      QLog.i("OlympicResources", 1, "onResp.md5 verify fail.md5=" + (String)localObject4 + ",calMD5=" + (String)localObject1);
      l = 0L;
      i = -6103066;
      localObject1 = null;
    }
    for (;;)
    {
      label241:
      HashMap localHashMap;
      label267:
      String str2;
      Object localObject3;
      if ((j == 1) || (j == 2))
      {
        if (j == 1)
        {
          localObject2 = "olympic_down_shua";
          if (i != 0) {
            break label807;
          }
          j = 1;
          localHashMap = new HashMap();
          localHashMap.put("param_FailCode", String.valueOf(i));
          localHashMap.put("url", akrf.mD(localaoll.bZ));
          localHashMap.put("err_desc", str1);
          str2 = "0";
          localObject3 = str2;
          if (paramaomh.nR != null)
          {
            localObject3 = str2;
            if (paramaomh.nR.containsKey("netresp_param_reason")) {
              localObject3 = (String)paramaomh.nR.get("netresp_param_reason");
            }
          }
          localHashMap.put("netresp_param_reason", localObject3);
          str2 = "0";
          if (j == 0) {
            break label812;
          }
          localHashMap.put("file_size", String.valueOf(l));
          localHashMap.put("cdn_ip", "0");
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), (String)localObject2, true, 0L, l, localHashMap, "", false);
          akrf.log("OlympicResources", new Object[] { "onResp report Download, reportKey=", localObject2, ", errcode=", Integer.valueOf(i), ", url=", localaoll.bZ });
        }
      }
      else
      {
        localObject3 = localObject1;
        localObject2 = localObject5;
        localObject1 = localObject4;
        label499:
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "onResp.url=" + localaoll.bZ + ", result=" + paramaomh.mResult + ", errCode=" + i + ",md5 = " + (String)localObject1);
        }
        j = 0;
        for (;;)
        {
          if (j < this.ys.size())
          {
            localObject4 = (akpy.a)this.ys.get(j);
            if (localObject4 != null) {
              ((akpy.a)localObject4).a(localaoll.bZ, (String)localObject1, localObject2, i, (String)localObject3);
            }
            j += 1;
            continue;
            bool1 = false;
            break;
            label636:
            str1 = paramaomh.clO;
            break label57;
            label645:
            localObject1 = ((File)localObject2).getAbsolutePath();
            l = ((File)localObject2).length();
            break label241;
            label662:
            if ((localObject2 != null) && (((File)localObject2).exists())) {
              ((File)localObject2).delete();
            }
            if ((k >= doR) || (!bool2)) {
              break label1015;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OlympicResources", 2, "onResp.retry.url=" + localaoll.bZ + ",md5=" + (String)localObject4 + ", result=" + paramaomh.mResult + ", errCode=" + i + ",retryCount=" + k);
            }
            a(localaoll.bZ, (String)localObject4, localObject5, k + 1, bool2, j, localaoll.atY);
          }
        }
      }
      label807:
      label812:
      label888:
      while (bool1)
      {
        for (;;)
        {
          return;
          localObject2 = "olympic_down_act";
          break;
          j = 0;
          break label267;
          try
          {
            localObject3 = InetAddress.getByName("hb.url.cn").getHostAddress();
            localHashMap.put("cdn_ip", localObject3);
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), (String)localObject2, false, 0L, 0L, localHashMap, "", false);
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject3 = str2;
              if (QLog.isColorLevel())
              {
                localThrowable.printStackTrace();
                localObject3 = str2;
              }
            }
          }
        }
        ((File)localObject2).delete();
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "olympic_down_null", bool1, 0L, 0L, null, "", false);
        localObject3 = null;
        localObject2 = null;
        localObject1 = null;
        break label499;
      }
      QLog.i("OlympicResources", 1, "onResp.url=" + localaoll.bZ + ", result=" + paramaomh.mResult + ", errCode=" + i + ",md5 = " + (String)localObject1 + ", errDesc=" + str1);
      return;
      label1015:
      localObject1 = null;
      l = 0L;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    Object localObject = null;
    if ((paramaomg == null) || (!(paramaomg instanceof aoll))) {
      return;
    }
    String str = ((aoll)paramaomg).bZ;
    paramaomg = paramaomg.U();
    if ((paramaomg != null) && ((paramaomg instanceof Object[])))
    {
      localObject = (Object[])paramaomg;
      paramaomg = (String)localObject[0];
      localObject = localObject[1];
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OlympicResources", 2, "onUpdateProgeress.url=" + str + ", md5=" + paramaomg + ", userData=" + localObject + ",curOffset=" + paramLong1 + ",totalLen=" + paramLong2);
      }
      int i = 0;
      while (i < this.ys.size())
      {
        akpy.a locala = (akpy.a)this.ys.get(i);
        if (locala != null) {
          locala.a(str, paramaomg, localObject, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      paramaomg = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, Object paramObject, int paramInt, String paramString3);
    
    public abstract void a(String paramString1, String paramString2, Object paramObject, long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpy
 * JD-Core Version:    0.7.0.1
 */