import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QQProtectUpdate.UpdateQueryBody;
import com.tencent.ims.QQProtectUpdate.UpdateQueryRequest;
import com.tencent.ims.QQProtectUpdate.UpdateQueryResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aszu
  implements Handler.Callback, aolm.a, aolm.b, Manager
{
  private aszt jdField_a_of_type_Aszt;
  private aszv.b jdField_a_of_type_Aszv$b;
  private SharedPreferences ah;
  private Handler bG;
  private String cGl = "";
  private String cGm = "";
  private ConcurrentHashMap<String, aomg> cK = new ConcurrentHashMap();
  private boolean dgN;
  private int eos = 0;
  final Object lock = new Object();
  private QQAppInterface mApp;
  
  public aszu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.bG = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.dgN = false;
    this.ah = this.mApp.getApp().getSharedPreferences("qp_sfu_config", 0);
    this.jdField_a_of_type_Aszt = new aszt(this.mApp);
  }
  
  private String Ae()
  {
    return Ev() + "qp_sfu_config.dat";
  }
  
  private String Ev()
  {
    String str = this.mApp.getApp().getDir("qqprotect", 0).toString() + File.separator + "SFU/";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private void ZY(int paramInt)
  {
    this.eos = paramInt;
  }
  
  private void ZZ(int paramInt)
  {
    QLog.d("QQProtect.QPUpdate", 1, String.format("[SFU] update event: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
    case 1: 
    case 2: 
    case 5: 
    case 6: 
      do
      {
        return;
        try
        {
          if (this.eos == 1)
          {
            ZZ(17);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
        ZZ(14);
        return;
        onStart();
        return;
        if ((aIT()) && (this.jdField_a_of_type_Aszv$b != null))
        {
          if (!i(this.jdField_a_of_type_Aszv$b))
          {
            ZZ(15);
            return;
          }
          ZZ(6);
          return;
        }
        ZZ(16);
        return;
      } while ((this.jdField_a_of_type_Aszv$b != null) && (h(this.jdField_a_of_type_Aszv$b)));
      onError(3);
      return;
    case 7: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (c(this.jdField_a_of_type_Aszv$b)))
      {
        ZZ(8);
        return;
      }
      l("0X80078AF", 0, "", "");
      onError(4);
      return;
    case 8: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (g(this.jdField_a_of_type_Aszv$b)))
      {
        ZZ(9);
        return;
      }
      l("0X80078B0", 0, "", "");
      onError(5);
      return;
    case 9: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (e(this.jdField_a_of_type_Aszv$b)))
      {
        ZZ(10);
        return;
      }
      l("0X80078B1", 0, "", "");
      onError(6);
      return;
    case 10: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (f(this.jdField_a_of_type_Aszv$b)))
      {
        ZZ(11);
        return;
      }
      ZY(7);
      ZZ(13);
      return;
    case 11: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (d(this.jdField_a_of_type_Aszv$b)))
      {
        ZZ(12);
        return;
      }
      ZY(8);
      ZZ(13);
      return;
    case 12: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (b(this.jdField_a_of_type_Aszv$b)))
      {
        onError(0);
        return;
      }
      onError(9);
      return;
    case 13: 
      if ((this.jdField_a_of_type_Aszv$b != null) && (a(this.jdField_a_of_type_Aszv$b)))
      {
        onError(0);
        return;
      }
      l("0X80078B3", 0, "", "");
      onError(10);
      return;
    case 14: 
      if (this.jdField_a_of_type_Aszv$b != null) {
        b(this.jdField_a_of_type_Aszv$b);
      }
      ZZ(15);
      return;
    case 15: 
      a(this.jdField_a_of_type_Aszv$b);
      this.jdField_a_of_type_Aszv$b = null;
      if (aIR())
      {
        ZZ(16);
        return;
      }
      ZZ(5);
      return;
    case 16: 
      esO();
      ZZ(17);
      return;
    }
    onEnd();
  }
  
  private String a(aszv.b paramb)
  {
    paramb = Ev() + paramb.sectionId + File.separator;
    File localFile = new File(paramb);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramb;
  }
  
  private void a(aomg paramaomg, int paramInt1, int paramInt2) {}
  
  private void a(aomh paramaomh)
  {
    boolean bool = true;
    if (paramaomh == null) {}
    aszu.a locala;
    do
    {
      do
      {
        return;
        if (paramaomh.mResult != 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download error=%d", new Object[] { Integer.valueOf(paramaomh.mResult) }));
      return;
      locala = (aszu.a)paramaomh.b.U();
    } while (locala == null);
    if (paramaomh.mResult == 0) {}
    while (!bool)
    {
      try
      {
        if (locala.cuw >= 3) {
          break label145;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(locala.cuw), Boolean.valueOf(bool), locala.fileUrl }));
        }
        a(locala);
        return;
      }
      catch (Throwable paramaomh)
      {
        paramaomh.printStackTrace();
        return;
      }
      bool = false;
      continue;
      label145:
      File localFile = new File(paramaomh.b.atY);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    this.cK.remove(locala.cGn.toLowerCase());
    a(bool, paramaomh.b);
  }
  
  private void a(aszv.b paramb)
  {
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update complete: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      paramb.esP();
      if (aIS())
      {
        this.cGl += String.format("#%d#", new Object[] { Long.valueOf(paramb.businessId) });
        this.cGm += String.format("#%d#", new Object[] { Long.valueOf(paramb.sectionId) });
      }
      l("0X80078B4", 0, "", "");
    }
  }
  
  private void a(boolean paramBoolean, aomg paramaomg)
  {
    if ((!paramBoolean) || (paramaomg == null))
    {
      onError(3);
      return;
    }
    File localFile = new File(paramaomg.atY);
    aszu.a locala = (aszu.a)paramaomg.U();
    if ((!localFile.exists()) || (locala == null))
    {
      onError(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download complete: %s, %s", new Object[] { paramaomg.atY, locala.fileUrl }));
    }
    switch (locala.fileType)
    {
    default: 
      return;
    case 1: 
      localFile = new File(Ae());
      new File(paramaomg.atY).renameTo(localFile);
      l("0X80078AC", locala.fileVersion, "", "");
      if (this.jdField_a_of_type_Aszt.sR(localFile.toString()))
      {
        this.ah.edit().putInt("last_update_config_version", locala.fileVersion).commit();
        if (this.jdField_a_of_type_Aszt.hd().isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, "[SFU] config ok but without any sections");
          }
          ZZ(16);
          return;
        }
        ZZ(5);
        return;
      }
      l("0X80078AC", locala.fileVersion, locala.fileName, locala.fileUrl);
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] invalid config (sig not accepted)");
      }
      onError(1);
      return;
    }
    l("0X80078AE", locala.fileVersion, "", "");
    ZZ(7);
  }
  
  private boolean a(aszu.a parama)
  {
    if (parama == null) {}
    do
    {
      return false;
      if ((parama.fileType == 2) && (parama.eot != 1) && (!NetworkUtils.isWifiConnected(this.mApp.getApplication())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] donot download file because not using wifi");
        }
        asxt.report(3, 1);
        return false;
      }
    } while ((parama.cuw < 3) && (this.cK.contains(parama.cGn.toLowerCase())));
    aolm localaolm = this.mApp.getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.a = this;
    localaoll.bZ = parama.fileUrl;
    localaoll.mHttpMethod = 0;
    localaoll.atY = (parama.filePath + parama.fileName);
    parama.cuw += 1;
    parama.startTime = new Date().getTime();
    localaoll.bw(parama);
    this.cK.put(parama.cGn.toLowerCase(), localaoll);
    localaolm.a(localaoll);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] begin http download %s", new Object[] { parama.fileUrl }));
    }
    return true;
  }
  
  private boolean a(aszv.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      if (paramb.Kj.isEmpty())
      {
        if (!QLog.isColorLevel()) {
          break label355;
        }
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to rollback");
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      String str = b(paramb);
      long l2 = 0L;
      int i = 0;
      while (i < paramb.Kj.size())
      {
        Object localObject = (aszv.a)paramb.Kj.get(i);
        File localFile1 = new File(((aszv.a)localObject).cGr);
        File localFile2 = new File(((aszv.a)localObject).cGs);
        long l1 = l2;
        if (localFile2.exists())
        {
          if (!localFile2.delete()) {
            localFile2.deleteOnExit();
          }
          l1 = l2 + 1L;
        }
        l2 = l1;
        if (((aszv.a)localObject).updateFlag == 2)
        {
          l2 = l1;
          if (localFile1.exists())
          {
            if (!localFile1.delete()) {
              localFile1.deleteOnExit();
            }
            l2 = l1 + 1L;
          }
        }
        localObject = new File(str, ((aszv.a)localObject).cGp);
        l1 = l2;
        if (((File)localObject).exists())
        {
          l1 = l2;
          if (((File)localObject).canRead())
          {
            l1 = l2;
            if (localFile1.exists())
            {
              l1 = l2;
              if (localFile1.canWrite())
              {
                g((File)localObject, localFile1);
                l1 = l2 + 1L;
              }
            }
          }
        }
        i += 1;
        l2 = l1;
      }
      if (l2 == paramb.Kj.size())
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label355:
        bool = false;
      }
    }
  }
  
  private boolean aIR()
  {
    Object localObject = this.jdField_a_of_type_Aszt.hd();
    int i = 0;
    if (i < ((List)localObject).size()) {
      if (((aszv.b)((List)localObject).get(i)).isDone()) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        if (!bool) {
          break label81;
        }
      }
      label81:
      for (localObject = "yes";; localObject = "no")
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] all complete: %s", new Object[] { localObject }));
        return bool;
        i += 1;
        break;
      }
    }
  }
  
  private boolean aIS()
  {
    return this.eos == 0;
  }
  
  private boolean aIT()
  {
    this.jdField_a_of_type_Aszv$b = null;
    List localList = this.jdField_a_of_type_Aszt.hd();
    int i = 0;
    label150:
    boolean bool;
    if (i < localList.size())
    {
      aszv.b localb = (aszv.b)localList.get(i);
      if (localb.isDone()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localb.dgQ) && (localb.dgP) && (localb.dgR)) {
          break label150;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QQProtect.QPUpdate", 2, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localb.sectionId), Boolean.valueOf(localb.dgQ), Boolean.valueOf(localb.dgP), Boolean.valueOf(localb.dgR) }));
        }
        localb.esP();
      }
      this.jdField_a_of_type_Aszv$b = localb;
      ZY(0);
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Aszv$b.sectionId) }));
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private String b(aszv.b paramb)
  {
    paramb = a(paramb) + "bak" + File.separator;
    File localFile = new File(paramb);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramb;
  }
  
  private void b(aszv.b paramb)
  {
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      aqhq.delete(a(paramb), false);
    }
  }
  
  private boolean b(aszv.b paramb)
  {
    return true;
  }
  
  private String c(aszv.b paramb)
  {
    return a(paramb) + paramb.packageName;
  }
  
  private boolean c(aszv.b paramb)
  {
    String str;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      str = aszr.getFileMd5BigFile(c(paramb));
      if (str == null) {
        return false;
      }
    }
    for (boolean bool = str.equalsIgnoreCase(paramb.cGt);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  private boolean d(aszv.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      if (paramb.Kk.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] no diff: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      int i = 0;
      for (;;)
      {
        if (i < paramb.Kk.size())
        {
          aszv.a locala = (aszv.a)paramb.Kk.get(i);
          if (TextUtils.isEmpty(locala.cGs)) {}
          for (String str = locala.cGr;; str = locala.cGs)
          {
            str = aszr.getFileMd5BigFile(str);
            if ((str != null) && (str.equalsIgnoreCase(locala.cGo))) {
              break label246;
            }
            if (!QLog.isColorLevel()) {
              break label253;
            }
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, locala.cGo, Long.valueOf(paramb.sectionId) }));
            bool = false;
            break;
          }
          label246:
          i += 1;
          continue;
          label253:
          bool = false;
          break;
        }
      }
      bool = true;
    }
  }
  
  private boolean e(aszv.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      if (paramb.axQ == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to backup");
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      if (paramb.axQ > 0L)
      {
        String str1 = b(paramb);
        long l1 = 0L;
        int i = 0;
        while (i < paramb.Kk.size())
        {
          aszv.a locala = (aszv.a)paramb.Kk.get(i);
          long l2 = l1;
          if (1 == locala.updateFlag)
          {
            String str2 = str1 + locala.cGp;
            g(new File(locala.cGr), new File(str2));
            l2 = l1 + 1L;
          }
          i += 1;
          l1 = l2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramb.Kk.size()) }));
        }
        if (paramb.axQ == l1) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private void esN()
  {
    synchronized (this.lock)
    {
      if (!this.dgN)
      {
        this.ah.edit().putLong("last_query_time", new Date().getTime()).commit();
        ZZ(2);
        this.dgN = true;
      }
      do
      {
        return;
        long l = this.ah.getLong("last_query_time", 0L);
        if (new Date().getTime() - l > 3600000L)
        {
          this.dgN = false;
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, "[SFU] last udpate timeout");
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQProtect.QPUpdate", 2, "[SFU] already being updating");
    }
  }
  
  private void esO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, "[SFU] all sections update complete");
    }
    try
    {
      if (!TextUtils.isEmpty(this.cGl))
      {
        QSecFramework.a().esB();
        this.ah.edit().putString("last_update_bids", this.cGl).putString("last_update_sections", this.cGm).commit();
        l("0X80078B6", 0, this.cGl, this.cGm);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] notify update complete: %s", new Object[] { this.cGl }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean f(aszv.b paramb)
  {
    boolean bool1;
    if ((paramb != null) && (!paramb.Kk.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      String str = a(paramb);
      int i = 0;
      if (i < paramb.Kk.size())
      {
        aszv.a locala = (aszv.a)paramb.Kk.get(i);
        File localFile1 = new File(str, locala.cGo);
        Object localObject = new File(locala.cGr);
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, src not existed or cannot read: %s", new Object[] { localFile1.toString() }));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          boolean bool2 = g(localFile1, (File)localObject);
          bool1 = bool2;
          if (!bool2)
          {
            localObject = locala.cGr + ".1";
            File localFile2 = new File((String)localObject);
            locala.updateFlag = 3;
            locala.cGs = ((String)localObject);
            bool2 = g(localFile1, localFile2);
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, renamed to: %s", new Object[] { locala.cGs }));
            }
            bool1 = bool2;
            if (bool2)
            {
              this.ah.edit().putString(locala.cGr, locala.cGs).commit();
              bool1 = bool2;
            }
          }
          if (!bool1) {
            break label376;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] success copied: %s", new Object[] { locala.cGr }));
          }
          paramb.Kj.add(locala);
          paramb.axR += 1L;
        }
        label376:
        l("0X80078B2", (int)locala.reportId, locala.fileName, locala.cGo);
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] failed copied: %s", new Object[] { locala.cGr }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramb.axR), Integer.valueOf(paramb.Kk.size()) }));
      }
      if (paramb.axR == paramb.Kk.size()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update result: %b", new Object[] { Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private boolean g(aszv.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip package: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      String str = a(paramb);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (jqp.k(c(paramb), str) == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  /* Error */
  private boolean g(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_2
    //   10: invokevirtual 133	java/io/File:exists	()Z
    //   13: ifeq +41 -> 54
    //   16: aload_2
    //   17: invokevirtual 286	java/io/File:delete	()Z
    //   20: istore 5
    //   22: iload 5
    //   24: ifne +90 -> 114
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 667	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 668	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 667	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 668	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iload 4
    //   53: ireturn
    //   54: new 120	java/io/File
    //   57: dup
    //   58: aload_2
    //   59: invokevirtual 671	java/io/File:getParent	()Ljava/lang/String;
    //   62: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 8
    //   67: aload 8
    //   69: invokevirtual 133	java/io/File:exists	()Z
    //   72: ifne +42 -> 114
    //   75: aload 8
    //   77: invokevirtual 136	java/io/File:mkdirs	()Z
    //   80: istore 5
    //   82: iload 5
    //   84: ifne +30 -> 114
    //   87: iconst_0
    //   88: ifeq +11 -> 99
    //   91: new 667	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 668	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: iconst_0
    //   100: ifeq -49 -> 51
    //   103: new 667	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 668	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: iconst_0
    //   113: ireturn
    //   114: new 673	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 676	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   122: astore_2
    //   123: new 678	java/io/BufferedInputStream
    //   126: dup
    //   127: new 680	java/io/FileInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 681	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: invokespecial 684	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   138: astore_1
    //   139: invokestatic 690	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   142: sipush 4096
    //   145: invokevirtual 694	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   148: astore 6
    //   150: aload_1
    //   151: aload 6
    //   153: invokevirtual 698	java/io/BufferedInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: iconst_m1
    //   159: if_icmpeq +58 -> 217
    //   162: aload_2
    //   163: aload 6
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 702	java/io/FileOutputStream:write	([BII)V
    //   170: aload_2
    //   171: invokevirtual 705	java/io/FileOutputStream:flush	()V
    //   174: goto -24 -> 150
    //   177: astore 7
    //   179: aload_1
    //   180: astore 6
    //   182: aload_2
    //   183: astore_1
    //   184: aload 6
    //   186: astore_2
    //   187: aload 7
    //   189: astore 6
    //   191: aload 6
    //   193: invokevirtual 706	java/io/IOException:printStackTrace	()V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 709	java/io/FileOutputStream:close	()V
    //   204: aload_2
    //   205: ifnull -154 -> 51
    //   208: aload_2
    //   209: invokevirtual 710	java/io/BufferedInputStream:close	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore_1
    //   215: iconst_0
    //   216: ireturn
    //   217: invokestatic 690	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   220: aload 6
    //   222: invokevirtual 714	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   225: iconst_1
    //   226: istore 4
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 709	java/io/FileOutputStream:close	()V
    //   236: aload_1
    //   237: ifnull -186 -> 51
    //   240: aload_1
    //   241: invokevirtual 710	java/io/BufferedInputStream:close	()V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_1
    //   247: iconst_1
    //   248: ireturn
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 709	java/io/FileOutputStream:close	()V
    //   260: aload 6
    //   262: ifnull +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 710	java/io/BufferedInputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: goto -234 -> 39
    //   276: astore_1
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_1
    //   280: goto -181 -> 99
    //   283: astore_2
    //   284: goto -48 -> 236
    //   287: astore_1
    //   288: goto -84 -> 204
    //   291: astore_2
    //   292: goto -32 -> 260
    //   295: astore_2
    //   296: goto -26 -> 270
    //   299: astore_1
    //   300: goto -48 -> 252
    //   303: astore 7
    //   305: aload_1
    //   306: astore 6
    //   308: aload 7
    //   310: astore_1
    //   311: goto -59 -> 252
    //   314: astore 6
    //   316: aload_1
    //   317: astore 7
    //   319: aload 6
    //   321: astore_1
    //   322: aload_2
    //   323: astore 6
    //   325: aload 7
    //   327: astore_2
    //   328: goto -76 -> 252
    //   331: astore 6
    //   333: aconst_null
    //   334: astore_1
    //   335: aload 7
    //   337: astore_2
    //   338: goto -147 -> 191
    //   341: astore 6
    //   343: aload_2
    //   344: astore_1
    //   345: aload 7
    //   347: astore_2
    //   348: goto -157 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	aszu
    //   0	351	1	paramFile1	File
    //   0	351	2	paramFile2	File
    //   156	11	3	i	int
    //   7	220	4	bool1	boolean
    //   20	63	5	bool2	boolean
    //   1	306	6	localObject1	Object
    //   314	6	6	localObject2	Object
    //   323	1	6	localFile1	File
    //   331	1	6	localIOException1	java.io.IOException
    //   341	1	6	localIOException2	java.io.IOException
    //   4	1	7	localObject3	Object
    //   177	11	7	localIOException3	java.io.IOException
    //   303	6	7	localObject4	Object
    //   317	29	7	localFile2	File
    //   65	11	8	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   139	150	177	java/io/IOException
    //   150	157	177	java/io/IOException
    //   162	174	177	java/io/IOException
    //   217	225	177	java/io/IOException
    //   208	212	214	java/io/IOException
    //   240	244	246	java/io/IOException
    //   9	22	249	finally
    //   54	82	249	finally
    //   114	123	249	finally
    //   31	39	272	java/io/IOException
    //   43	51	276	java/io/IOException
    //   91	99	279	java/io/IOException
    //   232	236	283	java/io/IOException
    //   200	204	287	java/io/IOException
    //   256	260	291	java/io/IOException
    //   265	270	295	java/io/IOException
    //   123	139	299	finally
    //   139	150	303	finally
    //   150	157	303	finally
    //   162	174	303	finally
    //   217	225	303	finally
    //   191	196	314	finally
    //   9	22	331	java/io/IOException
    //   54	82	331	java/io/IOException
    //   114	123	331	java/io/IOException
    //   123	139	341	java/io/IOException
  }
  
  private boolean h(aszv.b paramb)
  {
    boolean bool = false;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      bool = a(new aszu.a(2, 0, a(paramb), paramb.packageName, paramb.cGu, paramb.cGt, 0, true, 0, new Date().getTime(), paramb.eot));
    }
    return bool;
  }
  
  private boolean i(aszv.b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramb.sectionId) }));
      }
      List localList = paramb.Ki;
      int i = 0;
      if (i < localList.size())
      {
        aszv.a locala = (aszv.a)localList.get(i);
        if (!new File(locala.cGr).exists())
        {
          locala.updateFlag = 2;
          paramb.Kk.add(locala);
        }
        String str;
        do
        {
          i += 1;
          break;
          str = aszr.getFileMd5BigFile(locala.cGr);
        } while ((str != null) && (str.equalsIgnoreCase(locala.cGo)));
        locala.updateFlag = 1;
        if (str != null) {}
        for (;;)
        {
          locala.cGp = str;
          paramb.Kk.add(locala);
          paramb.axQ += 1L;
          break;
          str = "";
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramb.Kk.size()), Integer.valueOf(paramb.Ki.size()) }));
      }
      bool1 = bool2;
      if (!paramb.Kk.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void kM(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = asxv.a(1);
      if (localObject == null) {
        return;
      }
      QQProtectUpdate.UpdateQueryBody localUpdateQueryBody = new QQProtectUpdate.UpdateQueryBody();
      localUpdateQueryBody.uint32_file_id.set(paramInt1);
      localUpdateQueryBody.uint32_file_local_version.set(paramInt2);
      QQProtectUpdate.UpdateQueryRequest localUpdateQueryRequest = new QQProtectUpdate.UpdateQueryRequest();
      localUpdateQueryRequest.head_update_query.set((MessageMicro)localObject);
      localUpdateQueryRequest.body_update_query.set(localUpdateQueryBody);
      localObject = new ToServiceMsg("mobileqq.service", this.mApp.getCurrentAccountUin(), "MobileQQprotect.QPUpdate");
      ((ToServiceMsg)localObject).putWupBuffer(localUpdateQueryRequest.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      this.mApp.sendToService((ToServiceMsg)localObject);
      l("0X80078AA", paramInt1, "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] sent update query: fileid=%d, localversion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void l(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_Aszv$b != null)
    {
      paramInt = (int)this.jdField_a_of_type_Aszv$b.businessId;
      if (this.jdField_a_of_type_Aszv$b == null) {
        break label188;
      }
    }
    label188:
    for (paramString2 = String.format("%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Aszv$b.sectionId) });; paramString2 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt), Integer.valueOf(this.eos), paramString2, paramString3, "", "" }));
      }
      asxz localasxz = new asxz();
      localasxz.a(paramString1).a(paramString1).a(paramString3).a(paramString2).a(this.eos);
      asxw.ao(localasxz.toString(), 105, paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private void onEnd()
  {
    synchronized (this.lock)
    {
      this.dgN = false;
      l("0X80078B5", 0, "", "");
      this.jdField_a_of_type_Aszv$b = null;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] update ended");
      }
      return;
    }
  }
  
  private void onStart()
  {
    kM(1, this.ah.getInt("last_update_config_version", 0));
    this.ah.edit().remove("last_update_bids").commit();
  }
  
  private int v(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "No matched update from server.");
      }
    }
    String str;
    do
    {
      return -1;
      if (this.ah.getInt("last_update_config_version", 0) < paramInt) {
        return 0;
      }
      str = Ae();
      if (!new File(str).exists()) {
        return 0;
      }
      str = aszr.getFileMd5BigFile(str);
      if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
        return 0;
      }
    } while ((str == null) || (!str.equalsIgnoreCase(paramString)));
    return 1;
  }
  
  public void a(aomg paramaomg, aomh paramaomh)
  {
    if ((paramaomg == null) || (paramaomh == null)) {}
    while (!(paramaomg instanceof aoll)) {
      return;
    }
    paramaomg = (aoll)paramaomg;
    paramaomg.apS += paramaomh.apW;
    paramaomh.apW = 0L;
    paramaomh = "bytes=" + paramaomg.apS + "-";
    paramaomg.u.put("Range", paramaomh);
  }
  
  public void aaa(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] received update push from server: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    esN();
  }
  
  public void esM()
  {
    long l1 = this.ah.getLong("last_query_time", -28800000L);
    long l2 = new Date().getTime() - l1;
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 1, String.format("[SFU] startSFU last time: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    if (l2 >= 28800000L) {
      esN();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a((aomh)paramMessage.obj);
      continue;
      a((aomg)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void lI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    for (;;)
    {
      int i;
      int j;
      int n;
      try
      {
        QQProtectUpdate.UpdateQueryResponse localUpdateQueryResponse = new QQProtectUpdate.UpdateQueryResponse();
        bool1 = bool2;
        int i1;
        if (localUpdateQueryResponse != null)
        {
          localUpdateQueryResponse.mergeFrom((byte[])paramObject);
          if ((localUpdateQueryResponse.int32_status == null) || (!localUpdateQueryResponse.int32_status.has())) {
            break label643;
          }
          i = localUpdateQueryResponse.int32_status.get();
          l("0X80078B8", i, "", "");
          if (i != 0) {
            break label596;
          }
          if ((localUpdateQueryResponse.uint32_sec_cmd == null) || (!localUpdateQueryResponse.uint32_sec_cmd.has())) {
            break label637;
          }
          j = localUpdateQueryResponse.uint32_sec_cmd.get();
          int m = 0;
          int k = m;
          if (localUpdateQueryResponse.uint32_file_id != null)
          {
            k = m;
            if (localUpdateQueryResponse.uint32_file_id.has()) {
              k = localUpdateQueryResponse.uint32_file_id.get();
            }
          }
          n = 0;
          m = n;
          if (localUpdateQueryResponse.uint32_file_version != null)
          {
            m = n;
            if (localUpdateQueryResponse.uint32_file_version.has()) {
              m = localUpdateQueryResponse.uint32_file_version.get();
            }
          }
          paramFromServiceMsg = "";
          paramToServiceMsg = paramFromServiceMsg;
          if (localUpdateQueryResponse.string_file_hash != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (localUpdateQueryResponse.string_file_hash.has()) {
              paramToServiceMsg = localUpdateQueryResponse.string_file_hash.get();
            }
          }
          paramObject = "";
          paramFromServiceMsg = paramObject;
          if (localUpdateQueryResponse.string_file_url != null)
          {
            paramFromServiceMsg = paramObject;
            if (localUpdateQueryResponse.string_file_url.has()) {
              paramFromServiceMsg = localUpdateQueryResponse.string_file_url.get();
            }
          }
          i1 = 0;
          n = i1;
          if (localUpdateQueryResponse.uint32_zip_flag == null) {
            break label649;
          }
          n = i1;
          if (!localUpdateQueryResponse.uint32_zip_flag.has()) {
            break label649;
          }
          n = localUpdateQueryResponse.uint32_zip_flag.get();
          break label649;
          i1 = v(m, paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(n) }));
          }
          if ((i1 == 0) && (k == 1))
          {
            l("0X80078AB", k, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(k) }));
            }
            bool1 = a(new aszu.a(1, k, Ev(), "qp_sfu_config.dat", paramFromServiceMsg, paramToServiceMsg, m, bool1, 0, new Date().getTime(), 1));
          }
        }
        else
        {
          if (bool1) {
            break label661;
          }
          ZZ(17);
          return;
        }
        if (i1 == 1)
        {
          paramToServiceMsg = new File(Ae());
          bool1 = bool2;
          if (!this.jdField_a_of_type_Aszt.sR(paramToServiceMsg.toString())) {
            continue;
          }
          if (this.jdField_a_of_type_Aszt.hd().isEmpty()) {
            ZZ(16);
          } else {
            ZZ(5);
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        ZZ(17);
        return;
      }
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] NO Need UPDATE");
        bool1 = bool2;
        continue;
        label596:
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(i) }));
          bool1 = bool2;
          continue;
          label637:
          j = 0;
          continue;
          label643:
          i = -1;
          continue;
          label649:
          if (n == 1)
          {
            bool1 = true;
          }
          else
          {
            label661:
            bool1 = false;
            continue;
            bool1 = true;
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.bG != null) {
      this.bG.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onError(int paramInt)
  {
    QLog.e("QQProtect.QPUpdate", 1, String.format("[SFU] update error: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    }
    for (;;)
    {
      ZZ(1);
      return;
      File localFile = new File(Ae());
      if (localFile.exists())
      {
        localFile.delete();
        continue;
        ZY(paramInt);
      }
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (this.bG != null) {
      this.bG.obtainMessage(1052688, paramaomh).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.bG.obtainMessage(1052689, (int)paramLong1, (int)paramLong2, paramaomg).sendToTarget();
  }
  
  static class a
  {
    public String cGn;
    public int cuw;
    public boolean dgO;
    public int eot;
    public int fileId;
    public String fileName;
    public String filePath;
    public int fileType;
    public String fileUrl;
    public int fileVersion;
    public long startTime;
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong, int paramInt5)
    {
      this.fileType = paramInt1;
      this.fileId = paramInt2;
      this.filePath = paramString1;
      this.fileName = paramString2;
      this.fileUrl = paramString3;
      this.cGn = paramString4;
      this.fileVersion = paramInt3;
      this.dgO = paramBoolean;
      this.cuw = paramInt4;
      this.startTime = paramLong;
      this.eot = paramInt5;
    }
    
    public String toString()
    {
      return "filePath=" + this.filePath + ",fileName=" + this.fileName + ",fileId=" + this.fileId + ",fileUrl=" + this.fileUrl + ",fileHash=" + this.cGn + ",fileVersion=" + this.fileVersion + ",zipFlag=" + this.dgO + ",startTime=" + this.startTime + ",tryTimes=" + this.cuw + ",downloadFlag=" + this.eot;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszu
 * JD-Core Version:    0.7.0.1
 */