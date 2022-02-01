import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1;
import com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import mqq.os.MqqHandler;

public class aomj
  implements aolm
{
  private static volatile int dPJ = -1;
  HttpCommunicator b;
  boolean cMZ;
  private ConcurrentHashMap<String, String> iE = new ConcurrentHashMap();
  AtomicBoolean mWorking = new AtomicBoolean(true);
  
  public aomj() {}
  
  public aomj(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.b = paramHttpCommunicator;
    this.cMZ = paramBoolean;
  }
  
  private aqog a(aomg paramaomg)
  {
    if (paramaomg == null) {
      return null;
    }
    if ((paramaomg.dPE == 0) && ((paramaomg instanceof aoll)))
    {
      aoll localaoll = (aoll)paramaomg;
      aomj.a locala = (aomj.a)localaoll.fh;
      if ((locala == null) || (locala.cQ.get())) {
        return null;
      }
      aqog localaqog = new aqog(a(localaoll, paramaomg), localaoll.X, locala);
      if (localaoll.mHttpMethod == 0) {}
      for (Object localObject = "GET";; localObject = "POST")
      {
        localaqog.setRequestMethod((String)localObject);
        localObject = localaoll.u.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localaqog.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      localaqog.mIsHttps = localaoll.mIsHttps;
      localaqog.cux = localaoll.clP;
      localaqog.cML = localaoll.cML;
      localaqog.cMM = localaoll.cMM;
      localaqog.cMH = localaoll.cMH;
      localaqog.cVb = localaoll.cMI;
      localaqog.msgId = paramaomg.mMsgId;
      localaqog.busiType = paramaomg.dPG;
      localaqog.fileType = paramaomg.mFileType;
      localaqog.d = localaoll.b;
      localaqog.hX = localaoll.hq;
      localaqog.cMY = localaoll.cMY;
      localaqog.cMV = paramaomg.cMV;
      localaqog.cMK = localaoll.cMK;
      if (dPJ == -1) {
        dVQ();
      }
      switch (dPJ)
      {
      }
      for (;;)
      {
        if (paramaomg.dPo == 1)
        {
          localaqog.rL = 201;
          label355:
          if ((localaoll.f != null) || (localaoll.atY != null)) {
            localaqog.SP(true);
          }
          locala.jdField_f_of_type_Aqog = localaqog;
        }
        try
        {
          paramaomg = new URL(localaqog.getUrl());
          localObject = localaoll.a;
          ((aomh)localObject).nR.put("serverip", paramaomg.getHost());
          ((aomh)localObject).nR.put("param_url", localaqog.getUrl());
          return localaqog;
          if (localaoll.cMJ)
          {
            localaqog.eaI = dPJ;
            continue;
            localaqog.eaI = (dPJ / 4);
            continue;
            if (paramaomg.dPo == 2)
            {
              localaqog.rL = 202;
              break label355;
            }
            if (paramaomg.dPo != 0) {
              break label355;
            }
            localaqog.rL = 200;
          }
        }
        catch (Exception paramaomg)
        {
          for (;;)
          {
            paramaomg.printStackTrace();
          }
        }
      }
    }
    if (paramaomg.f != null)
    {
      paramaomg.a.a(1, 9302, "not support by HttpOldEngine", null);
      paramaomg.f.onResp(paramaomg.a);
    }
    return null;
  }
  
  private String a(aoll paramaoll, aomg paramaomg)
  {
    String str1 = paramaoll.bZ;
    if ((paramaoll.cMG) && (paramaoll.bZ != null) && (!paramaoll.bZ.startsWith("https")))
    {
      String str2 = aopd.getHostFromUrl(paramaoll.bZ);
      String str3 = aopd.a().aC(str2, 1002);
      str3 = aopd.bK(paramaoll.bZ, str3);
      if ((str3 != null) && (!str3.equals(paramaoll.bZ)))
      {
        if (!aqmr.isEmpty(str2)) {
          paramaomg.u.put("host", str2);
        }
        paramaoll.cMH = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + paramaoll.bZ + " ipUrl=" + str3);
        }
        return str3;
      }
    }
    return str1;
  }
  
  private static String a(aomg paramaomg, String paramString1, String paramString2)
  {
    if ((paramaomg != null) && (paramaomg.mTempPath != null) && (paramaomg.mTempPath.length() > 0)) {
      return paramaomg.mTempPath;
    }
    return paramString1 + "." + MD5.toMD5(aonc.z(paramString2, false)) + ".tmp";
  }
  
  private boolean a(aqog paramaqog, aoll paramaoll)
  {
    boolean bool = paramaqog.aFp();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + paramaoll.cMH);
    }
    return (bool) && (paramaoll.cMH);
  }
  
  public static void dVQ()
  {
    if (dPJ >= 0) {}
    for (;;)
    {
      return;
      Object localObject = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {}
      }
      try
      {
        dPJ = Integer.valueOf(localObject[4]).intValue();
        label56:
        if (dPJ == -1) {
          dPJ = 1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.richmedia.OldHttpEngine", 2, "[initCmwapConnectionTypeFromDpc]: " + dPJ);
        return;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public void a(aomg paramaomg)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramaomg != null) && (paramaomg.f != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramaomg instanceof aoll))
      {
        localObject3 = (aoll)paramaomg;
        localObject1 = localObject2;
        i = j;
        if (((aoll)localObject3).mHttpMethod == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramaomg.atY != null)
          {
            localObject1 = a(paramaomg, paramaomg.atY, ((aoll)localObject3).bZ);
            paramaomg.mKey = ((String)localObject1);
            if (this.iE.putIfAbsent(localObject1, localObject1) == null) {
              break label346;
            }
          }
        }
      }
    }
    label204:
    label346:
    for (int i = 1;; i = j)
    {
      if ((paramaomg.dPE == 0) && ((paramaomg instanceof aoll)))
      {
        localObject2 = (aoll)paramaomg;
        ((aoll)localObject2).a = new aomh((aomg)localObject2);
        localObject3 = new aomj.a();
        ((aoll)localObject2).fh = localObject3;
        ((aomj.a)localObject3).jdField_f_of_type_Aoll = ((aoll)localObject2);
        ((aomj.a)localObject3).c = ((aoll)localObject2).a;
        if (i == 0) {
          ((aomj.a)localObject3).init();
        }
        if ((paramaomg.a.mResult == 2) && (!((aomj.a)localObject3).cNb)) {
          break label204;
        }
        aomj.a.a((aomj.a)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramaomg + " _id:" + paramaomg.mMsgId + " isDownloading _key:" + (String)localObject1);
          }
          paramaomg.a.mResult = 3;
          aomj.a.a((aomj.a)localObject3);
          return;
        }
        c(paramaomg);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramaomg).append(" callback:");
      if (paramaomg == null) {}
      for (paramaomg = (aomg)localObject1;; paramaomg = paramaomg.f)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramaomg);
        return;
      }
    }
  }
  
  public void b(aomg paramaomg)
  {
    if (paramaomg == null) {}
    do
    {
      return;
      if (paramaomg.mKey != null) {
        this.iE.remove(paramaomg.mKey);
      }
    } while (!aomj.a.class.isInstance(paramaomg.fh));
    Object localObject = (aoll)paramaomg;
    int i = paramaomg.dPG;
    if (((aoll)localObject).mHttpMethod == 1) {}
    for (boolean bool = true;; bool = false)
    {
      aonc.a(i, bool, paramaomg.mFileType, paramaomg.mMsgId, "cancelReq", "");
      localObject = (aomj.a)paramaomg.fh;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((aomj.a)localObject).cQ);
        }
      }
      if (localObject == null) {
        break;
      }
      ((aomj.a)localObject).cQ.set(true);
      aqog localaqog = ((aomj.a)localObject).jdField_f_of_type_Aqog;
      if ((this.mWorking.get()) && (this.b != null)) {
        this.b.f(localaqog);
      }
      ((aomj.a)localObject).d(paramaomg);
      ((aomj.a)localObject).dVR();
      return;
    }
  }
  
  public void c(aomg paramaomg)
  {
    aomj.a locala;
    do
    {
      try
      {
        aqog localaqog1 = a(paramaomg);
        locala = (aomj.a)paramaomg.fh;
        if ((localaqog1 != null) && (locala != null))
        {
          aomh localaomh = paramaomg.a;
          localaomh.dPH += 1;
          locala.dPL = 0;
          if (this.mWorking.get())
          {
            c(localaqog1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          System.gc();
          try
          {
            aqog localaqog2 = a(paramaomg);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramaomg = paramaomg.a;
        paramaomg.mErrCode = 9366;
        paramaomg.clO = "oldengine close";
        paramaomg.mResult = 1;
        aomj.a.a(locala);
        return;
      }
    } while ((locala == null) || (locala.cQ.get()));
    paramaomg = paramaomg.a;
    paramaomg.mErrCode = 9369;
    paramaomg.clO = "Out of memory";
    paramaomg.mResult = 1;
    aomj.a.a(locala);
  }
  
  public void c(aqog paramaqog)
  {
    if ((paramaqog != null) && (this.mWorking.get()) && (this.b != null)) {
      this.b.a(paramaqog);
    }
  }
  
  public void destroy()
  {
    if (this.mWorking.get())
    {
      this.mWorking.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.cMZ) && (this.b != null)) {
        this.b.close();
      }
      this.b = null;
    }
  }
  
  public class a
    implements aqoi
  {
    public aomh c;
    boolean cNa = false;
    boolean cNb = false;
    public AtomicBoolean cQ = new AtomicBoolean(false);
    int dPK = 0;
    int dPL = 0;
    int dPM = 5;
    int dPN = 0;
    int dPO = 0;
    public aoll f;
    public aqog f;
    public RandomAccessFile j;
    public OutputStream mOut;
    String mTempPath = null;
    
    public a() {}
    
    private long a(aomh paramaomh, long paramLong)
    {
      if ((paramaomh.mErrCode == 9056) && (paramLong != 0L)) {
        return 0L;
      }
      if (paramLong != 0L) {
        return 3000L;
      }
      return 6000L;
    }
    
    private void a(long paramLong, aoll paramaoll)
    {
      int i;
      if ((QLog.isColorLevel()) && (paramaoll != null))
      {
        i = paramaoll.dPG;
        if (paramaoll.mHttpMethod != 1) {
          break label77;
        }
      }
      label77:
      for (boolean bool = true;; bool = false)
      {
        aonc.a(i, bool, paramaoll.mFileType, paramaoll.mMsgId, "scheduleRetry", "mIsCancelled:" + this.cQ);
        if (!this.cQ.get()) {
          break;
        }
        return;
      }
      this.c.apY = System.currentTimeMillis();
      if (aomi.a().getNetType() != 0)
      {
        if ((aomj.this.mWorking.get()) && (paramLong != 0L))
        {
          ThreadManager.getSubThreadHandler().postDelayed(new OldHttpEngine.OldHttpCommunicatorListner.1(this, paramaoll), paramLong);
          return;
        }
        if ((QLog.isColorLevel()) && (paramaoll != null))
        {
          i = paramaoll.dPG;
          if (paramaoll.mHttpMethod != 1) {
            break label227;
          }
        }
        label227:
        for (bool = true;; bool = false)
        {
          aonc.a(i, bool, paramaoll.mFileType, paramaoll.mMsgId, "scheduleRetry", "mIsCancelled:" + this.cQ);
          if (this.cQ.get()) {
            break;
          }
          aomj.this.c(this.jdField_f_of_type_Aoll);
          return;
        }
      }
      if (aomj.this.mWorking.get())
      {
        ThreadManager.getTimer().schedule(new OldHttpEngine.OldHttpCommunicatorListner.2(this, paramaoll), paramLong);
        return;
      }
      if ((QLog.isColorLevel()) && (paramaoll != null))
      {
        i = paramaoll.dPG;
        if (paramaoll.mHttpMethod != 1) {
          break label320;
        }
      }
      label320:
      for (bool = true;; bool = false)
      {
        aonc.a(i, bool, paramaoll.mFileType, paramaoll.mMsgId, "scheduleRetry", "mWorking is false");
        if (!this.cQ.get()) {
          break;
        }
        return;
      }
    }
    
    private boolean a(aomh paramaomh, aoll paramaoll)
    {
      if (paramaomh.apW > 0L)
      {
        if (!paramaoll.aAf()) {
          break label46;
        }
        if (paramaoll.jdField_a_of_type_Aolm$a == null) {
          break label44;
        }
        paramaoll.jdField_a_of_type_Aolm$a.a(paramaoll, paramaomh);
        this.mOut = paramaoll.jdField_f_of_type_JavaIoOutputStream;
      }
      label44:
      label46:
      while (!paramaoll.aAe())
      {
        return true;
        return false;
      }
      if (paramaoll.jdField_a_of_type_Aolm$a != null)
      {
        paramaoll.jdField_a_of_type_Aolm$a.a(paramaoll, paramaomh);
        return true;
      }
      if (this.mOut != null) {
        try
        {
          this.mOut.close();
          this.mOut = new FileOutputStream(this.mTempPath);
          paramaomh.apW = 0L;
          return true;
        }
        catch (IOException paramaoll)
        {
          a(paramaoll, paramaomh);
        }
      }
      return false;
    }
    
    private boolean a(aqog paramaqog)
    {
      return false;
    }
    
    private void d(aqog paramaqog1, aqog paramaqog2)
    {
      if (this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$b == null)
      {
        int i;
        if (QLog.isColorLevel())
        {
          i = this.jdField_f_of_type_Aoll.dPG;
          if (this.jdField_f_of_type_Aoll.mHttpMethod != 1) {
            break label186;
          }
        }
        label186:
        for (boolean bool = true;; bool = false)
        {
          aonc.a(i, bool, this.jdField_f_of_type_Aoll.mFileType, this.jdField_f_of_type_Aoll.mMsgId, "check", "writtenSize:" + this.c.apW + " totalBlockLen:" + this.c.apV);
          this.c.a(1, -9527, null, null);
          paramaqog1 = aojn.x("Q", -9533L);
          this.c.nR.put("netresp_param_reason", paramaqog1);
          this.c.clO = ("recvSize:" + this.c.apW + " totalBlockLen:" + this.c.apV);
          return;
        }
      }
      this.c.mResult = 1;
      this.c.mErrCode = 9058;
      this.c.clO = "error data len ! ";
      QLog.d("T.Q.richmedia." + aonc.fG(this.jdField_f_of_type_Aoll.dPG) + "." + aonc.fH(this.jdField_f_of_type_Aoll.mFileType), 1, "id:" + paramaqog1.msgId + "reqUrl:" + this.jdField_f_of_type_Aoll.bZ + ",reqHeader:" + paramaqog1.cuv + "responseHeader:" + paramaqog2.cuw);
    }
    
    private void dVS()
    {
      boolean bool = true;
      if (this.cQ.get()) {
        return;
      }
      aoll localaoll = this.jdField_f_of_type_Aoll;
      aomh localaomh = this.c;
      OutputStream localOutputStream;
      RandomAccessFile localRandomAccessFile;
      if (localaoll != null)
      {
        localOutputStream = this.mOut;
        localRandomAccessFile = this.j;
        if ((localaoll.atY == null) || (localOutputStream == null)) {}
      }
      try
      {
        localOutputStream.close();
        if (localRandomAccessFile == null) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          localRandomAccessFile.close();
          if (localaomh != null)
          {
            if ((localaoll.mKey != null) && (localaomh.mResult != 3)) {
              aomj.a(aomj.this).remove(localaoll.mKey);
            }
            if (localaoll.jdField_f_of_type_Aolm$b != null)
            {
              if (QLog.isColorLevel())
              {
                int i = localaoll.dPG;
                if (localaoll.mHttpMethod != 1) {
                  break label250;
                }
                aonc.a(i, bool, localaoll.mFileType, localaoll.mMsgId, "onOutEngine", "result:" + localaomh.mResult + " errCode:" + localaomh.mErrCode + " desc:" + localaomh.clO);
              }
              if ((localaomh.mErrCode == 9367) && (QLog.isColorLevel())) {
                break label255;
              }
              localaoll.jdField_f_of_type_Aolm$b.onResp(localaomh);
            }
          }
          dVR();
          return;
          localIOException2 = localIOException2;
          localIOException2.printStackTrace();
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            localIOException1.printStackTrace();
            continue;
            label250:
            bool = false;
            continue;
            label255:
            anow.report("Http_Download_Queen_Full", aomj.this.b.Cm());
          }
        }
      }
    }
    
    public void Hp(String paramString)
    {
      if ((this.c != null) && (this.jdField_f_of_type_Aqog != null))
      {
        this.c.apZ = (SystemClock.uptimeMillis() - this.jdField_f_of_type_Aqog.startTime);
        paramString = this.c;
        paramString.dPI += 1;
      }
    }
    
    void a(aoll paramaoll, boolean paramBoolean1, aomh paramaomh, aqog paramaqog1, aqog paramaqog2, boolean paramBoolean2, long paramLong)
    {
      int k;
      boolean bool;
      if (QLog.isColorLevel())
      {
        k = paramaoll.dPG;
        if (paramaoll.mHttpMethod != 1) {
          break label284;
        }
        bool = true;
      }
      for (;;)
      {
        int m = paramaoll.mFileType;
        String str = paramaoll.mMsgId;
        StringBuilder localStringBuilder = new StringBuilder().append("tryTime:");
        int i;
        label66:
        long l;
        if (this.c != null)
        {
          i = this.c.dPH;
          localStringBuilder = localStringBuilder.append(i).append(" consumeTime:");
          if (this.c == null) {
            break label296;
          }
          l = this.c.apX;
          label97:
          aonc.a(k, bool, m, str, "retry", l + " isLastGetData:" + paramBoolean1);
          bool = a(paramaomh, paramaoll);
          paramBoolean1 = bool;
          if (paramaoll.cMW)
          {
            paramBoolean1 = bool;
            if (paramaqog1.getResponseCode() >= 400)
            {
              paramBoolean1 = bool;
              if (paramaqog1.getResponseCode() < 500)
              {
                bool = false;
                paramBoolean1 = bool;
                if (this.mOut == null) {}
              }
            }
          }
        }
        try
        {
          this.mOut.close();
          try
          {
            label197:
            aqhq.deleteFile(this.mTempPath);
            paramBoolean1 = bool;
          }
          catch (Exception paramaqog1)
          {
            for (;;)
            {
              label284:
              label296:
              label302:
              paramBoolean1 = bool;
            }
          }
          if (this.dPO >= paramaoll.dPF) {
            paramaoll.u.put("Connection", "close");
          }
          if (!paramBoolean1)
          {
            if (QLog.isColorLevel())
            {
              i = paramaoll.dPG;
              if (paramaoll.mHttpMethod != 1) {
                break label302;
              }
            }
            for (paramBoolean1 = true;; paramBoolean1 = false)
            {
              aonc.a(i, paramBoolean1, paramaoll.mFileType, paramaoll.mMsgId, "retry", "breakDownAllowRetry is false ");
              dVS();
              return;
              bool = false;
              break;
              i = 0;
              break label66;
              l = 0L;
              break label97;
            }
          }
          if (paramaoll.jdField_a_of_type_Aoll$b != null) {
            paramaoll.jdField_a_of_type_Aoll$b.reset();
          }
          if (paramaoll.cMG)
          {
            if (paramaoll.cMH)
            {
              aopd.a().X(aopd.getHostFromUrl(paramaoll.bZ), aopd.getHostFromUrl(paramaqog2.getUrl()), 1002);
              paramaoll.cMH = false;
            }
            paramaoll.cMG = false;
          }
          if ((paramaoll.P != null) && (paramaoll.P.size() >= 1) && (paramBoolean2))
          {
            paramaqog1 = (aonh)paramaoll.P.remove(0);
            paramaoll.P.add(paramaqog1);
            paramaqog1 = (aonh)paramaoll.P.get(0);
            if (paramaoll.bZ != null)
            {
              paramaqog1 = paramaqog1.ox(paramaoll.bZ);
              paramaoll.bZ = aonc.bJ(paramaoll.bZ, paramaqog1);
            }
          }
          if ((paramaomh.mErrCode == 9050) && (paramaoll.b != null)) {
            paramaoll.b.VY(this.dPK);
          }
          a(a(paramaomh, paramLong), paramaoll);
          return;
        }
        catch (Exception paramaqog1)
        {
          break label197;
        }
      }
    }
    
    public void a(aomh paramaomh, long paramLong, boolean paramBoolean)
    {
      if ((paramaomh.mErrCode == 9056) && (paramLong < 2000L))
      {
        int i = this.dPM;
        this.dPM = (i - 1);
        if (i <= 0) {}
      }
      for (;;)
      {
        if ((paramaomh.mErrCode == 9056) || (paramaomh.mErrCode == 9051)) {
          this.dPO += 1;
        }
        return;
        if (paramBoolean) {
          this.dPK += 1;
        }
      }
    }
    
    public void a(aqog paramaqog1, aqog paramaqog2)
    {
      if (this.cQ.get()) {}
      label317:
      do
      {
        for (;;)
        {
          return;
          this.dPK = 0;
          if (this.jdField_f_of_type_Aoll != null) {
            try
            {
              if ((paramaqog2.getResponseCode() == 206) || (paramaqog2.getResponseCode() == 200))
              {
                arrayOfByte = paramaqog2.aB();
                aoll.b localb = this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$b;
                paramaqog1 = arrayOfByte;
                if (localb == null) {}
              }
            }
            catch (IOException paramaqog1)
            {
              try
              {
                byte[] arrayOfByte;
                paramaqog1 = this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$b.decode(arrayOfByte);
                if (paramaqog1 == null) {
                  continue;
                }
                int i = paramaqog1.length;
                if (i <= 0) {
                  continue;
                }
                paramaqog1 = a(paramaqog1, paramaqog2);
                this.dPL += paramaqog1.length;
                if (this.mOut == null) {
                  break label317;
                }
                this.mOut.write(paramaqog1);
                this.mOut.flush();
                this.c.apU = paramaqog2.hR();
                this.c.apV = paramaqog2.atu;
                paramaqog2 = this.c;
                paramaqog2.apW += paramaqog1.length;
                if (this.jdField_f_of_type_Aoll.jdField_f_of_type_Aolm$b == null) {
                  continue;
                }
                this.jdField_f_of_type_Aoll.jdField_f_of_type_Aolm$b.onUpdateProgeress(this.jdField_f_of_type_Aoll, this.c.apW + this.jdField_f_of_type_Aoll.apS, this.c.apU);
                return;
              }
              catch (Throwable paramaqog1)
              {
                paramaqog1 = Log.getStackTraceString(paramaqog1);
                throw new RuntimeException("FlowDecoderExp:" + paramaqog1.substring(0, Math.min(100, paramaqog1.length())));
              }
              paramaqog1 = paramaqog1;
              paramaqog1.printStackTrace();
              this.cNa = true;
              a(paramaqog1, this.c);
              throw new RuntimeException("io exceptionmsg:" + paramaqog1.getMessage());
            }
          }
        }
        if (this.j == null) {
          break;
        }
        if (this.j.length() == 0L) {
          this.j.setLength(paramaqog2.atu);
        }
        this.j.write(paramaqog1);
        this.c.apU = paramaqog2.hR();
        this.c.apV = paramaqog2.atu;
        paramaqog2 = this.c;
        paramaqog2.apW += paramaqog1.length;
      } while (this.jdField_f_of_type_Aoll.jdField_f_of_type_Aolm$b == null);
      this.jdField_f_of_type_Aoll.jdField_f_of_type_Aolm$b.onUpdateProgeress(this.jdField_f_of_type_Aoll, this.c.apW + this.jdField_f_of_type_Aoll.apS, this.c.apU);
      return;
      this.c.apU = paramaqog2.hR();
      this.c.apV = paramaqog2.atu;
      this.c.mRespData = paramaqog2.aB();
    }
    
    void a(IOException paramIOException, aomh paramaomh)
    {
      if (this.cQ.get()) {}
      do
      {
        return;
        paramaomh = paramIOException.getMessage();
        this.c.a(1, 9301, paramaomh + MsfSdkUtils.getStackTraceString(paramIOException), null);
        try
        {
          paramIOException = Environment.getExternalStorageState();
          if (paramaomh.contains("EACCES"))
          {
            this.c.mErrCode = 9039;
            return;
          }
        }
        catch (Exception paramIOException)
        {
          paramIOException.printStackTrace();
          return;
        }
        if ((paramaomh.contains("ENOSPC")) || (paramaomh.contains("space")))
        {
          long l = aqft.hE();
          if (this.jdField_f_of_type_Aoll != null)
          {
            paramIOException = this.jdField_f_of_type_Aoll.atY;
            paramaomh = new File(paramIOException).getParentFile();
            QLog.e("Q.richmedia.OldHttpEngine", 1, "no space error, outPath:" + paramIOException + ",fileCount:" + paramaomh.listFiles().length + ",url:" + this.jdField_f_of_type_Aoll.bZ + ",availableSpace:" + l);
          }
          this.c.mErrCode = 9040;
          return;
        }
        if (paramaomh.contains("Read-only"))
        {
          this.c.mErrCode = 9039;
          return;
        }
      } while ("mounted".equals(paramIOException));
      this.c.mErrCode = 9039;
    }
    
    public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
    {
      int i = 0;
      if (this.cQ.get()) {}
      while (paramInt != 5) {
        return true;
      }
      d(paramaqog2);
      if (this.jdField_f_of_type_Aoll.aAd()) {
        c(paramaqog2, paramaqog1);
      }
      for (;;)
      {
        if (paramaqog1.cost != 0L) {
          this.c.reqCost = paramaqog1.cost;
        }
        this.c.apv = paramaqog1.apv;
        if (paramaqog1.aqa != 0L) {
          this.c.aqa = paramaqog1.aqa;
        }
        dVS();
        return true;
        this.c.mResult = 0;
        this.c.mErrCode = 0;
        this.c.clO = "";
        if (((this.c.mRespData != null) && (this.c.mRespData.length != this.c.apV)) || ((this.c.mRespData == null) && (this.c.apV != 0L)))
        {
          this.c.a(1, -9527, null, null);
          paramaqog2 = aojn.x("Q", -9533L);
          this.c.nR.put("netresp_param_reason", paramaqog2);
          paramaqog2 = this.c;
          StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
          paramInt = i;
          if (this.c.mRespData != null) {
            paramInt = this.c.mRespData.length;
          }
          paramaqog2.clO = (paramInt + " totalBlockLen:" + this.c.apV);
        }
      }
    }
    
    public byte[] a(byte[] paramArrayOfByte, aqog paramaqog)
    {
      int i = 0;
      byte[] arrayOfByte = paramArrayOfByte;
      long l1;
      if (paramArrayOfByte.length > 0)
      {
        arrayOfByte = paramArrayOfByte;
        if (this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$a != null)
        {
          l1 = System.nanoTime();
          int k = 1;
          arrayOfByte = null;
          for (;;)
          {
            try
            {
              localCipher = Cipher.getInstance("AES/ECB/NoPadding");
              localCipher.init(2, new SecretKeySpec(this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$a.key, "AES"));
              if (paramArrayOfByte.length % 16 != 0) {
                continue;
              }
              paramaqog = localCipher.doFinal(paramArrayOfByte);
              paramArrayOfByte = paramaqog;
              i = k;
              paramaqog = arrayOfByte;
            }
            catch (NoSuchAlgorithmException paramaqog)
            {
              Cipher localCipher;
              int m;
              paramaqog = Log.getStackTraceString(paramaqog);
              continue;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("Q.richmedia.OldHttpEngine", 2, "padding erro,recLen =" + paramArrayOfByte.length + " writeLen=" + this.c.apW + " totalLen=" + paramaqog.hR());
              paramaqog = "padding erro,recLen =" + paramArrayOfByte.length + " writeLen=" + this.c.apW + " totalLen=" + paramaqog.hR();
              i = 0;
              continue;
            }
            catch (NoSuchPaddingException paramaqog)
            {
              paramaqog = Log.getStackTraceString(paramaqog);
              continue;
            }
            catch (InvalidKeyException paramaqog)
            {
              paramaqog = Log.getStackTraceString(paramaqog);
              continue;
            }
            catch (IllegalBlockSizeException paramaqog)
            {
              paramaqog = Log.getStackTraceString(paramaqog);
              continue;
            }
            catch (BadPaddingException paramaqog)
            {
              paramaqog = Log.getStackTraceString(paramaqog);
              continue;
              long l2 = System.nanoTime();
              paramaqog = this.c;
              paramaqog.aqa = (l2 - l1 + paramaqog.aqa);
              arrayOfByte = paramArrayOfByte;
            }
            if (i != 0) {
              continue;
            }
            throw new RuntimeException("DecryptError:" + paramaqog);
            if ((paramaqog.hR() <= 0L) || (paramArrayOfByte.length + this.c.apW != paramaqog.hR())) {
              continue;
            }
            m = paramArrayOfByte.length % 16;
            paramaqog = new byte[paramArrayOfByte.length - m];
            System.arraycopy(paramArrayOfByte, 0, paramaqog, 0, paramArrayOfByte.length - m);
            paramaqog = localCipher.doFinal(paramaqog);
            System.arraycopy(paramaqog, 0, paramArrayOfByte, 0, paramaqog.length);
            paramaqog = arrayOfByte;
            i = k;
          }
        }
      }
      return arrayOfByte;
    }
    
    public void b(aqog paramaqog1, aqog paramaqog2)
    {
      if (this.cQ.get()) {}
      aoll localaoll;
      aomh localaomh;
      do
      {
        return;
        localaoll = this.jdField_f_of_type_Aoll;
        localaomh = this.c;
      } while ((localaoll == null) || (localaomh == null));
      d(paramaqog2);
      long l1 = System.currentTimeMillis() - localaomh.apY;
      localaomh.apX += l1;
      if ((localaoll.P != null) && (localaoll.P.size() >= 1)) {
        ((aonh)localaoll.P.get(0)).bbs();
      }
      long l2 = aomi.a().getNetType();
      boolean bool1;
      label188:
      int i;
      if (l2 != 0L)
      {
        bool1 = true;
        a(localaomh, l1, bool1);
        if (this.cNa) {
          break label489;
        }
        localaomh.mErrCode = paramaqog2.errCode;
        localaomh.clO = paramaqog2.errString;
        localaomh.mResult = 1;
        if (bool1) {
          break label466;
        }
        localaomh.mErrCode = 9004;
        localaomh.clO = "no network";
        localaomh.mResult = 1;
        if ((l2 == this.dPN) || (l2 == 0L) || (this.dPN == 0L)) {
          break label494;
        }
        i = 1;
        label218:
        if ((!localaoll.cMU) || (i == 0) || (!aona.isNetworkError(paramaqog2.errCode))) {
          break label499;
        }
        i = 1;
        label242:
        if (i != 0)
        {
          localaomh.mErrCode = 9364;
          localaomh.clO = "netchg";
          if (QLog.isColorLevel())
          {
            int k = localaoll.dPG;
            if (localaoll.mHttpMethod != 1) {
              break label504;
            }
            bool2 = true;
            aonc.a(k, bool2, localaoll.mFileType, localaoll.mMsgId, "netChg", "originNet:" + this.dPN + " cur:" + l2);
          }
        }
        label287:
        if (this.dPL <= 0) {
          break label510;
        }
      }
      label466:
      label489:
      label494:
      label499:
      label504:
      label510:
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((this.cNa) || (i != 0) || ((!paramaqog2.aFq()) && (!aomj.a(aomj.this, paramaqog2, localaoll))) || (((localaomh.apX >= localaoll.mExcuteTimeLimit - 5000L) || (this.dPK > localaoll.mContinuErrorLimit)) && ((!bool2) || (localaomh.apX >= localaoll.mExcuteTimeLimit * 3L / 2L - 5000L)))) {
          break label516;
        }
        a(localaoll, bool2, localaomh, paramaqog2, paramaqog1, bool1, l2);
        return;
        bool1 = false;
        break;
        if (localaoll.jdField_a_of_type_Aolm$c == null) {
          break label188;
        }
        localaoll.jdField_a_of_type_Aolm$c.g(localaomh);
        break label188;
        dVS();
        return;
        i = 0;
        break label218;
        i = 0;
        break label242;
        bool2 = false;
        break label287;
      }
      label516:
      dVS();
    }
    
    public String bH(String paramString1, String paramString2)
    {
      this.mTempPath = aomj.b(this.jdField_f_of_type_Aoll, paramString1, paramString2);
      return this.mTempPath;
    }
    
    public void c(aqog paramaqog1, aqog paramaqog2)
    {
      int k = 0;
      int i;
      if ((!a(paramaqog2)) || (this.c.apW == this.c.apV) || ((this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$b != null) && (this.jdField_f_of_type_Aoll.jdField_a_of_type_Aoll$b.isFinish())))
      {
        this.c.mResult = 0;
        this.c.mErrCode = 0;
        this.c.clO = "";
        i = k;
        if (this.mTempPath != null)
        {
          i = k;
          if (this.mTempPath.equalsIgnoreCase(this.jdField_f_of_type_Aoll.atY)) {
            i = 1;
          }
        }
        if (this.jdField_f_of_type_Aoll.atY != null) {}
        try
        {
          if ((this.jdField_f_of_type_Aoll.cMT) && (i == 0) && (aqhq.fileExists(this.jdField_f_of_type_Aoll.atY))) {
            aqhq.deleteFile(this.jdField_f_of_type_Aoll.atY);
          }
        }
        catch (Exception paramaqog1)
        {
          try
          {
            if (this.mOut == null) {
              break label184;
            }
            this.mOut.close();
            if (!this.jdField_f_of_type_Aoll.cMS) {
              break label208;
            }
          }
          catch (IOException paramaqog1)
          {
            try
            {
              for (;;)
              {
                if (this.j != null) {
                  this.j.close();
                }
                if (this.jdField_f_of_type_Aoll.cMT) {
                  break;
                }
                return;
                paramaqog1 = paramaqog1;
                paramaqog1.printStackTrace();
              }
              paramaqog1 = paramaqog1;
              paramaqog1.printStackTrace();
            }
            catch (IOException paramaqog1)
            {
              do
              {
                for (;;)
                {
                  paramaqog1.printStackTrace();
                }
              } while ((i != 0) || (aqhq.rename(this.mTempPath, this.jdField_f_of_type_Aoll.atY)) || (this.mTempPath == null));
              if (!aqhq.copyFile(this.mTempPath, this.jdField_f_of_type_Aoll.atY)) {
                break label304;
              }
              new File(this.mTempPath).delete();
              return;
              this.c.a(1, 9301, "rename file failed", null);
              new File(this.mTempPath).delete();
              return;
            }
          }
        }
        if (this.jdField_f_of_type_Aoll.atY == null) {}
      }
      label184:
      label208:
      d(paramaqog1, paramaqog2);
      label304:
    }
    
    void d(aomg paramaomg)
    {
      try
      {
        if ((paramaomg.atY != null) && (this.mOut != null)) {
          this.mOut.close();
        }
        if (this.j == null) {}
      }
      catch (IOException paramaomg)
      {
        for (;;)
        {
          try
          {
            this.j.close();
            return;
          }
          catch (IOException paramaomg)
          {
            paramaomg.printStackTrace();
          }
          paramaomg = paramaomg;
          paramaomg.printStackTrace();
        }
      }
    }
    
    void d(aqog paramaqog)
    {
      aomh localaomh = this.c;
      if ((this.cQ.get()) || (localaomh == null)) {
        return;
      }
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = localaomh.nR;
      if (localHashMap2.containsKey("firstserverip")) {
        localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
      }
      if (localHashMap2.containsKey("serverip")) {
        localHashMap1.put("serverip", localHashMap2.get("serverip"));
      }
      if (localHashMap2.containsKey("param_url")) {
        localHashMap1.put("param_url", localHashMap2.get("param_url"));
      }
      if (paramaqog.oZ.containsKey(aqog.cuy)) {
        localHashMap1.put("netresp_param_reason", paramaqog.oZ.get(aqog.cuy));
      }
      localaomh.nR.clear();
      localaomh.nR.putAll(localHashMap1);
      localaomh.nR.putAll(paramaqog.oZ);
      localaomh.nR.put("param_rspHeader", paramaqog.cuw);
      localaomh.nR.put("param_reqHeader", paramaqog.cuv);
      localaomh.dPy = paramaqog.getResponseCode();
    }
    
    void dVR()
    {
      this.cQ.set(true);
      aoll localaoll = this.jdField_f_of_type_Aoll;
      if (localaoll != null) {
        localaoll.fh = null;
      }
      this.jdField_f_of_type_Aoll = null;
      this.c = null;
      this.mOut = null;
    }
    
    public void init()
    {
      this.dPN = aomi.a().getNetType();
      Object localObject = this.jdField_f_of_type_Aoll;
      aomh localaomh = this.c;
      if ((localObject == null) || (localaomh == null))
      {
        this.cNb = true;
        return;
      }
      label368:
      int i;
      if (((aoll)localObject).atY != null)
      {
        for (;;)
        {
          try
          {
            this.mTempPath = bH(((aoll)localObject).atY, ((aoll)localObject).bZ);
            localaomh.b.mTempPath = this.mTempPath;
            localFile = new File(this.mTempPath);
            if (!localFile.exists()) {
              break label368;
            }
            l = localFile.length();
            if ((l <= 0L) || (((aoll)localObject).jdField_a_of_type_Aolm$a == null)) {
              continue;
            }
            localaomh.apW = l;
            ((aoll)localObject).jdField_a_of_type_Aolm$a.a((aomg)localObject, localaomh);
            if (!((aoll)localObject).cMS) {
              continue;
            }
            this.j = new RandomAccessFile(localFile, "rw");
            this.j.seek(((aoll)localObject).apS);
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + l);
            }
          }
          catch (IOException localIOException)
          {
            File localFile;
            long l;
            localIOException.printStackTrace();
            this.cNb = true;
            a(localIOException, localException);
            continue;
            if (!((aoll)localObject).cMS) {
              continue;
            }
            this.j = new RandomAccessFile(localIOException, "rw");
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + l + " trunk");
            continue;
            this.mOut = new FileOutputStream(localIOException);
            continue;
          }
          try
          {
            localObject = new URL(((aoll)localObject).bZ).getHost();
            localaomh.nR.put("firstserverip", localObject);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
          this.mOut = new FileOutputStream(localFile, true);
        }
        if (QLog.isColorLevel())
        {
          i = ((aoll)localObject).dPG;
          if (((aoll)localObject).mHttpMethod != 1) {
            break label486;
          }
        }
      }
      label486:
      for (boolean bool = true;; bool = false)
      {
        aonc.a(i, bool, ((aoll)localObject).mFileType, ((aoll)localObject).mMsgId, "createtmp", this.mTempPath);
        aqhq.createFile(this.mTempPath);
        if (((aoll)localObject).cMS)
        {
          this.j = new RandomAccessFile(localIOException, "rw");
          break;
        }
        this.mOut = new FileOutputStream(localIOException);
        break;
        if (((aoll)localObject).jdField_f_of_type_JavaIoOutputStream == null) {
          break;
        }
        this.mOut = ((aoll)localObject).jdField_f_of_type_JavaIoOutputStream;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomj
 * JD-Core Version:    0.7.0.1
 */