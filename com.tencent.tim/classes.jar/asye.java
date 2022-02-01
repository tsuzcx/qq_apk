import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQuery;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudQueryEntry;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespBody;
import com.tencent.ims.QSecCloudAVEngineMsg.QSecCloudRespEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine;
import com.tencent.qqprotect.qsec.ICloudAVEngine.a;
import com.tencent.qqprotect.qsec.ICloudAVEngine.b;
import com.tencent.qqprotect.qsec.ICloudAVEngine.c;
import com.tencent.qqprotect.qsec.ICloudAVEngine.d;
import com.tencent.qqprotect.qsec.IRuntimeInterface;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecFramework.a;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class asye
  implements ICloudAVEngine, IRuntimeInterface
{
  private static volatile asye jdField_a_of_type_Asye;
  private List<asye.c> Kc = new LinkedList();
  private asye.a jdField_a_of_type_Asye$a = new asye.a(MobileQQ.sMobileQQ.getDir("qqprotect", 0).toString() + File.separator + "QSecCache2.dat", 50);
  private asye.b jdField_a_of_type_Asye$b = new asye.b(ThreadManager.getFileThreadLooper());
  private QSecFramework.a jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$a = new asye.e(null);
  private boolean dgz;
  private int eoc = 1;
  private int eod;
  private int eoe;
  private int eof;
  private HashMap<Integer, asye.c> pZ = new HashMap();
  
  public asye()
  {
    QSecFramework.a(1L, this.jdField_a_of_type_ComTencentQqprotectQsecQSecFramework$a);
    aszo.a("QSec.AVEng", new asyf(this));
  }
  
  private int a(asye.c paramc)
  {
    int j = 16;
    paramc = paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b;
    if (paramc.mFileName != null) {
      j = 16 + paramc.mFileName.length();
    }
    int i = j;
    if (paramc.mFileMd5 != null) {
      i = j + paramc.mFileMd5.length();
    }
    j = i;
    if (paramc.cGc != null) {
      j = i + paramc.cGc.length();
    }
    i = j;
    if (paramc.cGd != null) {
      i = j + paramc.cGd.length();
    }
    j = i;
    if (paramc.cGe != null) {
      j = i + paramc.cGe.length();
    }
    i = j;
    if (paramc.br != null) {
      i = j + paramc.br.length;
    }
    return i;
  }
  
  private asye.c a(Object paramObject)
  {
    try
    {
      paramObject = (asye.c)paramObject;
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static asye a()
  {
    if (jdField_a_of_type_Asye == null) {}
    try
    {
      if (jdField_a_of_type_Asye == null) {
        jdField_a_of_type_Asye = new asye();
      }
      return jdField_a_of_type_Asye;
    }
    finally {}
  }
  
  private QSecCloudAVEngineMsg.QSecCloudQuery a(List<asye.c> paramList)
  {
    QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
    QSecCloudAVEngineMsg.QSecCloudQueryBody localQSecCloudQueryBody;
    try
    {
      localQQProtectQueryHead = asxv.a(0);
      if (localQQProtectQueryHead == null) {
        return null;
      }
      localQSecCloudQueryBody = new QSecCloudAVEngineMsg.QSecCloudQueryBody();
      localQSecCloudQueryBody.version.set(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        asye.c localc = (asye.c)paramList.next();
        ICloudAVEngine.b localb = localc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b;
        QSecCloudAVEngineMsg.QSecCloudQueryEntry localQSecCloudQueryEntry = new QSecCloudAVEngineMsg.QSecCloudQueryEntry();
        localQSecCloudQueryEntry.entryId.set(localc.drV);
        localQSecCloudQueryEntry.fileType.set(localb.mFileType);
        localQSecCloudQueryEntry.scenarioType.set(localb.eoh);
        localQSecCloudQueryEntry.fileSize.set(localb.aCy);
        if (localb.cGc != null) {
          localQSecCloudQueryEntry.packageName.set(localb.cGc);
        }
        if (localb.mFileName != null) {
          localQSecCloudQueryEntry.fileName.set(localb.mFileName);
        }
        if (localb.cGd != null) {
          localQSecCloudQueryEntry.appName.set(localb.cGd);
        }
        if (localb.mFileMd5 != null) {
          localQSecCloudQueryEntry.fileMd5.set(localb.mFileMd5);
        }
        if (localb.cGe != null) {
          localQSecCloudQueryEntry.certMd5.set(localb.cGe);
        }
        if (localb.br != null) {
          localQSecCloudQueryEntry.extraInfo.set(ByteStringMicro.copyFrom(localb.br));
        }
        localQSecCloudQueryBody.queryEntry.add(localQSecCloudQueryEntry);
      }
      paramList = new QSecCloudAVEngineMsg.QSecCloudQuery();
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    paramList.head.set(localQQProtectQueryHead);
    paramList.body.set(localQSecCloudQueryBody);
    return paramList;
  }
  
  private void a(int paramInt, ICloudAVEngine.d paramd)
  {
    asye.c localc = (asye.c)this.pZ.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, "reply for id: " + paramInt + " result: " + paramd.toString());
    }
    if (localc != null)
    {
      if ((paramd.mExpireTime != 0L) && (!TextUtils.isEmpty(localc.cFX))) {
        this.jdField_a_of_type_Asye$a.a(localc.cFX, paramd);
      }
      paramd.cpR = false;
      a(localc, 3, paramd);
    }
  }
  
  private void a(asye.c paramc)
  {
    if (paramc == null) {}
    String str;
    do
    {
      return;
      str = paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.getKey();
      paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.mFileMd5 = str;
    } while (!QLog.isColorLevel());
    QLog.d("QSec.AVEngine", 2, String.format("File: %s, md5: %s", new Object[] { paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.mFileName, str }));
  }
  
  private void a(asye.c paramc, int paramInt, ICloudAVEngine.d paramd)
  {
    if (paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$c != null) {
      paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$c.a(paramInt, paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b, paramd);
    }
  }
  
  private boolean a(QSecCloudAVEngineMsg.QSecCloudQuery paramQSecCloudQuery)
  {
    return aszo.c("QSec.AVEng", paramQSecCloudQuery.toByteArray());
  }
  
  private void b(asye.c paramc)
  {
    if (paramc != null)
    {
      paramc.cFX = paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.mFileMd5;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Lookup cache, key: " + paramc.cFX);
      }
      if (!TextUtils.isEmpty(paramc.cFX))
      {
        ICloudAVEngine.d locald = this.jdField_a_of_type_Asye$a.b(paramc.cFX);
        if (locald != null)
        {
          locald.cpR = true;
          a(paramc, 3, locald);
        }
      }
    }
    else
    {
      return;
    }
    c(paramc);
  }
  
  private void bD(Object paramObject)
  {
    int i;
    label398:
    do
    {
      int j;
      try
      {
        paramObject = (QSecCloudAVEngineMsg.QSecCloudRespBody)paramObject;
        j = -1;
        i = j;
        if (paramObject.status == null) {
          continue;
        }
        i = j;
        if (!paramObject.status.has()) {
          continue;
        }
        i = paramObject.status.get();
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if ((paramObject.version != null) && (paramObject.version.has())) {}
      for (i = paramObject.version.get(); (i == 1) && (paramObject.respEntry != null); i = 0)
      {
        paramObject = paramObject.respEntry.get();
        if (paramObject == null) {
          break;
        }
        Iterator localIterator = paramObject.iterator();
        int k;
        int m;
        int n;
        int i1;
        while (localIterator.hasNext())
        {
          paramObject = (QSecCloudAVEngineMsg.QSecCloudRespEntry)localIterator.next();
          if ((paramObject.entryId != null) && (paramObject.entryId.has()))
          {
            k = paramObject.entryId.get();
            if ((paramObject.attrType != null) && (paramObject.attrType.has()))
            {
              m = paramObject.attrType.get();
              if ((paramObject.category != null) && (paramObject.category.has()))
              {
                n = paramObject.category.get();
                if ((paramObject.subCategory != null) && (paramObject.subCategory.has()))
                {
                  i1 = paramObject.subCategory.get();
                  if ((paramObject.timeToLive == null) || (!paramObject.timeToLive.has())) {
                    break label398;
                  }
                }
              }
            }
          }
        }
        for (i = paramObject.timeToLive.get();; i = 0)
        {
          if ((paramObject.actionType != null) && (paramObject.actionType.has())) {}
          for (j = paramObject.actionType.get();; j = 0)
          {
            if (paramObject.extraInfo != null)
            {
              paramObject = paramObject.extraInfo.get();
              if (paramObject == null) {}
            }
            for (paramObject = paramObject.toByteArray();; paramObject = null)
            {
              ICloudAVEngine.d locald = new ICloudAVEngine.d();
              locald.eoi = m;
              locald.lN = n;
              locald.eoj = i1;
              locald.mAction = j;
              if (i != 0) {
                locald.mExpireTime = (new Date().getTime() + i * 1000);
              }
              locald.br = paramObject;
              a(k, locald);
              break;
              this.jdField_a_of_type_Asye$a.esp();
              return;
            }
          }
        }
      }
    } while (i == 0);
  }
  
  private void bE(Object paramObject)
  {
    if (paramObject == null) {}
    int i;
    label133:
    do
    {
      return;
      for (;;)
      {
        int m;
        asye.c localc;
        try
        {
          paramObject = (int[])paramObject;
          int k = paramObject.length;
          int j = 0;
          i = 0;
          if (j >= k) {
            break;
          }
          m = paramObject[j];
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Timeout entry id:" + m);
          }
          localc = (asye.c)this.pZ.get(Integer.valueOf(m));
          if (localc == null)
          {
            j += 1;
            continue;
          }
          if (localc.mRetryCount >= 1) {
            break label133;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          return;
        }
        localc.mRetryCount += 1;
        e(localc);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "No retry chance for entry id: " + m);
        }
        esm();
        this.pZ.remove(Integer.valueOf(m));
        a(localc, 2, null);
      }
    } while (i == 0);
    flushRequest();
  }
  
  private void c(asye.c paramc)
  {
    if (paramc != null)
    {
      int i = this.eoc;
      this.eoc = (i + 1);
      paramc.drV = i;
      paramc.mRetryCount = 0;
      e(paramc);
    }
  }
  
  private void d(asye.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSec.AVEngine", 2, String.format("Start flow: %s", new Object[] { paramc.toString() }));
    }
    if (TextUtils.isEmpty(paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.mFileMd5))
    {
      a(paramc);
      if (TextUtils.isEmpty(paramc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b.mFileMd5))
      {
        a(paramc, 4, null);
        return;
      }
    }
    if (paramc.dgC)
    {
      b(paramc);
      return;
    }
    c(paramc);
  }
  
  private void doReport(int paramInt)
  {
    asxt.report(2, paramInt);
  }
  
  private void e(asye.c paramc)
  {
    if (this.eod >= 100) {
      a(paramc, 1, null);
    }
    do
    {
      return;
      if (paramc.eog == 0) {
        paramc.eog = a(paramc);
      }
      this.eoe += paramc.eog;
      this.eod += 1;
      this.Kc.add(paramc);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Enqueue request, entryId: %d, pending count: %d, pending size: %d", new Object[] { Integer.valueOf(paramc.drV), Integer.valueOf(this.eod), Integer.valueOf(this.eoe) }));
      }
    } while ((paramc.dgD != true) && (this.eoe < 1000));
    esn();
  }
  
  private void esm()
  {
    this.eof += 1;
    if (this.eof >= 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Rpt to %d", new Object[] { Integer.valueOf(this.eof) }));
      }
      this.eof = 0;
      doReport(1);
    }
  }
  
  private void esn()
  {
    LinkedList localLinkedList = new LinkedList();
    int k = this.Kc.size();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i < k) {}
      try
      {
        localObject = (asye.c)this.Kc.get(i);
        int m = ((asye.c)localObject).eog;
        if (m + j > 1000)
        {
          localObject = a(localLinkedList);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QSec.AVEngine", 2, String.format("Pack size: %d, count: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localLinkedList.size()) }));
            }
            ns(localLinkedList);
            a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
          }
          this.eoe -= j;
          this.eod -= localLinkedList.size();
          localLinkedList.clear();
          i -= 1;
          j = 0;
        }
        else
        {
          localLinkedList.add(localObject);
          j += m;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        this.Kc.clear();
        this.eoe = 0;
        this.eod = 0;
        localException.printStackTrace();
        return;
      }
      this.Kc.clear();
      if (localLinkedList.size() == 0) {
        break;
      }
      if (this.dgz)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, String.format("Commit Left (%d:%d)", new Object[] { Integer.valueOf(this.eoe), Integer.valueOf(this.eod) }));
        }
        localObject = a(localLinkedList);
        if (localObject != null)
        {
          ns(localLinkedList);
          a((QSecCloudAVEngineMsg.QSecCloudQuery)localObject);
        }
        this.eoe = 0;
        this.eod = 0;
        return;
      }
      this.Kc.addAll(localLinkedList);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QSec.AVEngine", 2, String.format("Has %d(count: %d) left.", new Object[] { Integer.valueOf(this.eoe), Integer.valueOf(localLinkedList.size()) }));
      return;
      i += 1;
    }
  }
  
  private void ns(List<asye.c> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      asye.c localc = (asye.c)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Add to wait resp map: " + localc.toString());
      }
      this.pZ.put(Integer.valueOf(localc.drV), localc);
      arrayOfInt[i] = localc.drV;
      i += 1;
    }
    this.jdField_a_of_type_Asye$b.sendMessageDelayed(this.jdField_a_of_type_Asye$b.obtainMessage(3, arrayOfInt), 30000L);
  }
  
  public int cloudDetect(ICloudAVEngine.b paramb, boolean paramBoolean1, boolean paramBoolean2, ICloudAVEngine.c paramc)
  {
    if (paramb == null) {
      return 13;
    }
    asye.c localc = new asye.c(null);
    localc.dgC = paramBoolean1;
    localc.dgD = paramBoolean2;
    localc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b = paramb;
    localc.jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$c = paramc;
    if ((paramb.aCy == 0) && (!TextUtils.isEmpty(paramb.mFileName))) {
      paramb.aCy = ((int)new File(paramb.mFileName).length());
    }
    this.jdField_a_of_type_Asye$b.sendMessage(this.jdField_a_of_type_Asye$b.obtainMessage(1, localc));
    return 0;
  }
  
  public void flushRequest()
  {
    this.jdField_a_of_type_Asye$b.sendMessage(this.jdField_a_of_type_Asye$b.obtainMessage(2));
  }
  
  public String getInterfaceName()
  {
    return "AVEngine";
  }
  
  static final class a
    extends LruCache<String, ICloudAVEngine.d>
  {
    private static final byte[] hx = { 90, 39, 2, -61, -88, -75, -36, 105, -102, 55, 18, 69, -72, -11, -84, 50 };
    private static final byte[] hy = { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, 35, -85, -74, -68, 105 };
    private List<Pair<String, ICloudAVEngine.d>> Kd = new LinkedList();
    private boolean dgA = true;
    private boolean dgB;
    private File mBackupFile;
    private File mCacheFile;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.mCacheFile = new File(paramString);
      this.mBackupFile = new File(this.mCacheFile.getPath() + ".bak");
      eso();
    }
    
    private ICloudAVEngine.d a(String paramString)
    {
      paramString = new asyh(this, paramString);
      a(paramString);
      return paramString.a;
    }
    
    private void a(asye.a.b paramb)
    {
      if (this.mBackupFile.exists())
      {
        this.mCacheFile.delete();
        this.mBackupFile.renameTo(this.mCacheFile);
      }
      if ((this.mCacheFile.exists()) && (this.mCacheFile.isFile()))
      {
        int i = 0;
        if (this.mCacheFile.length() > 10485760L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Cache file too big: " + this.mCacheFile.length());
          }
          i = 1;
        }
        new asye.a.a(this.mCacheFile, paramb).read();
        if (i != 0)
        {
          asxt.report(2, 2);
          this.mCacheFile.delete();
        }
      }
    }
    
    private void a(String paramString, ICloudAVEngine.d paramd, XmlSerializer paramXmlSerializer)
    {
      if (paramd.mExpireTime > new Date().getTime()) {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Write entry: " + paramd.toString());
        }
      }
      while (!QLog.isColorLevel()) {
        try
        {
          paramXmlSerializer.startTag(null, "CacheEntry");
          paramXmlSerializer.attribute(null, "Key", paramString);
          paramXmlSerializer.attribute(null, "AttrType", Integer.toString(paramd.eoi));
          paramXmlSerializer.attribute(null, "Category", Integer.toString(paramd.lN));
          paramXmlSerializer.attribute(null, "SubCategory", Integer.toString(paramd.eoj));
          paramXmlSerializer.attribute(null, "Action", Integer.toString(paramd.mAction));
          paramXmlSerializer.attribute(null, "ExpireTime", Long.toString(paramd.mExpireTime));
          if (paramd.br != null) {
            paramXmlSerializer.attribute(null, "ExtraInfo", Base64.encodeToString(paramd.br, 0));
          }
          paramXmlSerializer.endTag(null, "CacheEntry");
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      QLog.d("QSec.AVEngine", 2, "Discard expired entry for write: " + paramd.toString());
    }
    
    private boolean aIL()
    {
      if (this.mCacheFile.exists()) {
        if (!this.mBackupFile.exists())
        {
          if (!this.mCacheFile.renameTo(this.mBackupFile)) {
            return false;
          }
        }
        else {
          this.mCacheFile.delete();
        }
      }
      new asye.a.a(this.mBackupFile, new asyi(this, this.mCacheFile)).read();
      return true;
    }
    
    private void eso()
    {
      a(new asyg(this));
    }
    
    public void a(String paramString, ICloudAVEngine.d paramd)
    {
      if ((paramString != null) && (paramd != null))
      {
        if (put(paramString, paramd) == null) {
          this.Kd.add(new Pair(paramString, paramd));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, String.format("Put to cache, key: %s, result: %s ", new Object[] { paramString, paramd.toString() }));
        }
        if (this.Kd.size() >= 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Trigger rebuild cache file");
          }
          aIL();
        }
      }
    }
    
    protected void a(boolean paramBoolean, String paramString, ICloudAVEngine.d paramd1, ICloudAVEngine.d paramd2)
    {
      super.entryRemoved(paramBoolean, paramString, paramd1, paramd2);
      if (!paramBoolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Memory cache overflow.");
      }
      this.dgB = true;
    }
    
    public ICloudAVEngine.d b(String paramString)
    {
      Object localObject;
      if (paramString == null) {
        localObject = null;
      }
      ICloudAVEngine.d locald;
      do
      {
        do
        {
          do
          {
            return localObject;
            locald = (ICloudAVEngine.d)super.get(paramString);
            if (locald == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QSec.AVEngine", 2, "Hit memory cache for key: " + paramString);
            }
            localObject = locald;
          } while (locald.mExpireTime >= new Date().getTime());
          if (QLog.isColorLevel()) {
            QLog.d("QSec.AVEngine", 2, "Memory cache expired for key: " + paramString);
          }
          remove(paramString);
          return null;
          if (!this.dgA) {
            break;
          }
          localObject = locald;
        } while (this.dgB != true);
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "Look from cache file for key: " + paramString);
        }
        locald = a(paramString);
        localObject = locald;
      } while (locald == null);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Hit file cache for key: " + paramString);
      }
      if (locald.mExpireTime < new Date().getTime())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QSec.AVEngine", 2, "File cache expired for key: " + paramString);
        }
        return null;
      }
      put(paramString, locald);
      return locald;
    }
    
    public void esp()
    {
      if (this.Kd.size() > 0) {
        aIL();
      }
    }
    
    static final class a
    {
      private asye.a.b a;
      private File mFile;
      
      public a(File paramFile, asye.a.b paramb)
      {
        this.mFile = paramFile;
        this.a = paramb;
      }
      
      private Pair<String, ICloudAVEngine.d> a(XmlPullParser paramXmlPullParser)
      {
        try
        {
          String str = paramXmlPullParser.getAttributeValue(null, "Key");
          if (TextUtils.isEmpty(str)) {
            return null;
          }
          ICloudAVEngine.d locald = new ICloudAVEngine.d();
          locald.eoi = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "AttrType"));
          locald.lN = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Category"));
          locald.eoj = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "SubCategory"));
          locald.mAction = Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "Action"));
          locald.mExpireTime = Long.parseLong(paramXmlPullParser.getAttributeValue(null, "ExpireTime"));
          paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "ExtraInfo");
          if (!TextUtils.isEmpty(paramXmlPullParser)) {
            locald.br = Base64.decode(paramXmlPullParser, 0);
          }
          paramXmlPullParser = new Pair(str, locald);
          return paramXmlPullParser;
        }
        catch (Exception paramXmlPullParser)
        {
          paramXmlPullParser.printStackTrace();
        }
        return null;
      }
      
      /* Error */
      public void read()
      {
        // Byte code:
        //   0: new 108	javax/crypto/spec/IvParameterSpec
        //   3: dup
        //   4: invokestatic 112	asye$a:access$200	()[B
        //   7: invokespecial 115	javax/crypto/spec/IvParameterSpec:<init>	([B)V
        //   10: astore 5
        //   12: new 117	javax/crypto/spec/SecretKeySpec
        //   15: dup
        //   16: invokestatic 120	asye$a:access$300	()[B
        //   19: ldc 122
        //   21: invokespecial 125	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
        //   24: astore 6
        //   26: ldc 127
        //   28: invokestatic 133	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
        //   31: astore 7
        //   33: aload 7
        //   35: iconst_2
        //   36: aload 6
        //   38: aload 5
        //   40: invokevirtual 137	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
        //   43: new 139	javax/crypto/CipherInputStream
        //   46: dup
        //   47: new 141	java/io/BufferedInputStream
        //   50: dup
        //   51: new 143	java/io/FileInputStream
        //   54: dup
        //   55: aload_0
        //   56: getfield 19	asye$a$a:mFile	Ljava/io/File;
        //   59: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   62: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   65: aload 7
        //   67: invokespecial 152	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
        //   70: astore 7
        //   72: invokestatic 158	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
        //   75: astore 8
        //   77: aload 8
        //   79: aload 7
        //   81: ldc 160
        //   83: invokeinterface 164 3 0
        //   88: aload 8
        //   90: invokeinterface 168 1 0
        //   95: istore_3
        //   96: iconst_0
        //   97: istore_1
        //   98: aconst_null
        //   99: astore 5
        //   101: iload_3
        //   102: iconst_1
        //   103: if_icmpeq +46 -> 149
        //   106: iload_3
        //   107: iconst_2
        //   108: if_icmpne +116 -> 224
        //   111: aload 8
        //   113: invokeinterface 172 1 0
        //   118: astore 6
        //   120: aload 6
        //   122: ldc 174
        //   124: invokevirtual 180	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   127: ifeq +72 -> 199
        //   130: aload 8
        //   132: aconst_null
        //   133: ldc 182
        //   135: invokeinterface 33 3 0
        //   140: invokestatic 50	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   143: istore_1
        //   144: iload_1
        //   145: iconst_1
        //   146: if_icmpeq +28 -> 174
        //   149: aload 7
        //   151: ifnull +8 -> 159
        //   154: aload 7
        //   156: invokevirtual 187	java/io/InputStream:close	()V
        //   159: aload_0
        //   160: getfield 21	asye$a$a:a	Lasye$a$b;
        //   163: ifnull +10 -> 173
        //   166: aload_0
        //   167: getfield 21	asye$a$a:a	Lasye$a$b;
        //   170: invokevirtual 192	asye$a$b:esq	()V
        //   173: return
        //   174: iconst_1
        //   175: istore_1
        //   176: iload_1
        //   177: istore_2
        //   178: aload 5
        //   180: astore 6
        //   182: aload 8
        //   184: invokeinterface 195 1 0
        //   189: istore_3
        //   190: aload 6
        //   192: astore 5
        //   194: iload_2
        //   195: istore_1
        //   196: goto -95 -> 101
        //   199: iload_1
        //   200: ifeq +240 -> 440
        //   203: aload 6
        //   205: ldc 197
        //   207: invokevirtual 180	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   210: ifeq +230 -> 440
        //   213: aload_0
        //   214: aload 8
        //   216: invokespecial 199	asye$a$a:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/tencent/util/Pair;
        //   219: astore 5
        //   221: goto -45 -> 176
        //   224: aload 5
        //   226: astore 6
        //   228: iload_1
        //   229: istore_2
        //   230: iload_3
        //   231: iconst_3
        //   232: if_icmpne -50 -> 182
        //   235: aload 5
        //   237: astore 6
        //   239: iload_1
        //   240: istore_2
        //   241: ldc 197
        //   243: aload 8
        //   245: invokeinterface 172 1 0
        //   250: invokevirtual 180	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   253: ifeq -71 -> 182
        //   256: aload 5
        //   258: astore 6
        //   260: iload_1
        //   261: istore_2
        //   262: aload 5
        //   264: ifnull -82 -> 182
        //   267: aload_0
        //   268: getfield 21	asye$a$a:a	Lasye$a$b;
        //   271: ifnull +33 -> 304
        //   274: aload_0
        //   275: getfield 21	asye$a$a:a	Lasye$a$b;
        //   278: aload 5
        //   280: getfield 203	com/tencent/util/Pair:first	Ljava/lang/Object;
        //   283: checkcast 176	java/lang/String
        //   286: aload 5
        //   288: getfield 206	com/tencent/util/Pair:second	Ljava/lang/Object;
        //   291: checkcast 41	com/tencent/qqprotect/qsec/ICloudAVEngine$d
        //   294: invokevirtual 209	asye$a$b:a	(Ljava/lang/String;Lcom/tencent/qqprotect/qsec/ICloudAVEngine$d;)Z
        //   297: istore 4
        //   299: iload 4
        //   301: ifeq -152 -> 149
        //   304: aconst_null
        //   305: astore 6
        //   307: iload_1
        //   308: istore_2
        //   309: goto -127 -> 182
        //   312: astore 5
        //   314: aload 5
        //   316: invokevirtual 210	java/io/IOException:printStackTrace	()V
        //   319: goto -160 -> 159
        //   322: astore 6
        //   324: aconst_null
        //   325: astore 5
        //   327: aload 6
        //   329: invokevirtual 101	java/lang/Exception:printStackTrace	()V
        //   332: aload 5
        //   334: ifnull +8 -> 342
        //   337: aload 5
        //   339: invokevirtual 187	java/io/InputStream:close	()V
        //   342: aload_0
        //   343: getfield 21	asye$a$a:a	Lasye$a$b;
        //   346: ifnull -173 -> 173
        //   349: aload_0
        //   350: getfield 21	asye$a$a:a	Lasye$a$b;
        //   353: invokevirtual 192	asye$a$b:esq	()V
        //   356: return
        //   357: astore 5
        //   359: aload 5
        //   361: invokevirtual 210	java/io/IOException:printStackTrace	()V
        //   364: goto -22 -> 342
        //   367: astore 5
        //   369: aconst_null
        //   370: astore 6
        //   372: aload 6
        //   374: ifnull +8 -> 382
        //   377: aload 6
        //   379: invokevirtual 187	java/io/InputStream:close	()V
        //   382: aload_0
        //   383: getfield 21	asye$a$a:a	Lasye$a$b;
        //   386: ifnull +10 -> 396
        //   389: aload_0
        //   390: getfield 21	asye$a$a:a	Lasye$a$b;
        //   393: invokevirtual 192	asye$a$b:esq	()V
        //   396: aload 5
        //   398: athrow
        //   399: astore 6
        //   401: aload 6
        //   403: invokevirtual 210	java/io/IOException:printStackTrace	()V
        //   406: goto -24 -> 382
        //   409: astore 5
        //   411: aload 7
        //   413: astore 6
        //   415: goto -43 -> 372
        //   418: astore 7
        //   420: aload 5
        //   422: astore 6
        //   424: aload 7
        //   426: astore 5
        //   428: goto -56 -> 372
        //   431: astore 6
        //   433: aload 7
        //   435: astore 5
        //   437: goto -110 -> 327
        //   440: goto -264 -> 176
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	443	0	this	a
        //   97	211	1	i	int
        //   177	132	2	j	int
        //   95	138	3	k	int
        //   297	3	4	bool	boolean
        //   10	277	5	localObject1	Object
        //   312	3	5	localIOException1	java.io.IOException
        //   325	13	5	localObject2	Object
        //   357	3	5	localIOException2	java.io.IOException
        //   367	30	5	localObject3	Object
        //   409	12	5	localObject4	Object
        //   426	10	5	localObject5	Object
        //   24	282	6	localObject6	Object
        //   322	6	6	localException1	Exception
        //   370	8	6	localObject7	Object
        //   399	3	6	localIOException3	java.io.IOException
        //   413	10	6	localObject8	Object
        //   431	1	6	localException2	Exception
        //   31	381	7	localObject9	Object
        //   418	16	7	localObject10	Object
        //   75	169	8	localXmlPullParser	XmlPullParser
        // Exception table:
        //   from	to	target	type
        //   154	159	312	java/io/IOException
        //   0	72	322	java/lang/Exception
        //   337	342	357	java/io/IOException
        //   0	72	367	finally
        //   377	382	399	java/io/IOException
        //   72	96	409	finally
        //   111	144	409	finally
        //   182	190	409	finally
        //   203	221	409	finally
        //   241	256	409	finally
        //   267	299	409	finally
        //   327	332	418	finally
        //   72	96	431	java/lang/Exception
        //   111	144	431	java/lang/Exception
        //   182	190	431	java/lang/Exception
        //   203	221	431	java/lang/Exception
        //   241	256	431	java/lang/Exception
        //   267	299	431	java/lang/Exception
      }
    }
    
    static abstract class b
    {
      public abstract boolean a(String paramString, ICloudAVEngine.d paramd);
      
      public void esq() {}
    }
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        asye.a(asye.this, asye.a(asye.this, paramMessage.obj));
        return;
      case 2: 
        asye.a(asye.this, true);
        asye.a(asye.this);
        asye.a(asye.this, false);
        return;
      case 3: 
        asye.a(asye.this, paramMessage.obj);
        return;
      }
      asye.b(asye.this, paramMessage.obj);
    }
  }
  
  static final class c
  {
    ICloudAVEngine.b jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$b;
    ICloudAVEngine.c jdField_a_of_type_ComTencentQqprotectQsecICloudAVEngine$c;
    String cFX = "";
    boolean dgC;
    boolean dgD;
    int drV;
    int eog;
    int mRetryCount;
    
    public String toString()
    {
      return "[EntryId:" + this.drV + ",UseCache:" + this.dgC + ",rightnow:" + this.dgD + ",Retry:" + this.mRetryCount + ",localKey:" + this.cFX + ",content:" + this.a.toString() + "]";
    }
  }
  
  static final class d
    implements ICloudAVEngine.c
  {
    private long axL;
    
    public d(long paramLong)
    {
      this.axL = paramLong;
    }
    
    public void a(int paramInt, ICloudAVEngine.b paramb, ICloudAVEngine.d paramd)
    {
      long l1 = 0L;
      if (this.axL != 0L)
      {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4)) {
          break label46;
        }
        QSecFramework.b(5L, this.axL, paramInt, 0L, null, null, null, null);
      }
      label46:
      while (paramInt != 3) {
        return;
      }
      int i = paramd.eoi;
      int j = paramd.lN;
      int k = paramd.eoj;
      int m = paramd.mAction;
      paramb = paramd.br;
      long l2 = this.axL;
      long l3 = paramInt;
      if (paramd.cpR) {
        l1 = 1L;
      }
      QSecFramework.b(5L, l2, l3, l1, null, null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), paramb }, null);
    }
  }
  
  final class e
    implements QSecFramework.a
  {
    private e() {}
    
    public int b(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
    {
      if (paramLong1 == 2L) {}
      try
      {
        asye.this.flushRequest();
        return 0;
      }
      catch (Exception paramObject1)
      {
        label62:
        paramObject1.printStackTrace();
        return -1;
      }
      if ((paramObject1 != null) && (paramObject2 != null) && (paramArrayOfObject1 != null))
      {
        if (paramArrayOfObject1.length >= 6) {
          break label241;
        }
        break label238;
        if (paramLong2 != 0L)
        {
          paramArrayOfObject2 = new asye.d(paramLong2);
          break label251;
          if (((Integer)paramObject1).intValue() == 0) {
            break label270;
          }
        }
      }
      label270:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (((Integer)paramObject2).intValue() == 1) {
          paramObject1 = new ICloudAVEngine.a((String)paramArrayOfObject1[2]);
        }
        for (;;)
        {
          return asye.this.cloudDetect(paramObject1, bool1, bool2, paramArrayOfObject2);
          paramObject1 = new ICloudAVEngine.b();
          paramObject1.mFileType = ((Integer)paramObject2).intValue();
          paramObject1.eoh = ((Integer)paramArrayOfObject1[0]).intValue();
          paramObject1.mFileName = ((String)paramArrayOfObject1[1]);
          paramObject1.cGc = ((String)paramArrayOfObject1[2]);
          paramObject1.cGd = ((String)paramArrayOfObject1[3]);
          paramObject1.cGe = ((String)paramArrayOfObject1[4]);
          paramObject1.br = ((byte[])paramArrayOfObject1[5]);
        }
        paramArrayOfObject2 = null;
        break label251;
        label238:
        return 13;
        label241:
        if (paramArrayOfObject1[0] != null) {
          break;
        }
        return 13;
        label251:
        if (paramLong3 != 0L)
        {
          bool1 = true;
          break label62;
        }
        boolean bool1 = false;
        break label62;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asye
 * JD-Core Version:    0.7.0.1
 */