import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.1;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class agke
  implements INetInfoHandler
{
  private static agke jdField_a_of_type_Agke;
  private static boolean cdK;
  private agkd jdField_a_of_type_Agkd = new agkd();
  private int cXm = 1;
  private boolean cdJ;
  private boolean cdL;
  private boolean cdM = true;
  private boolean cdN = true;
  private boolean cdO = true;
  private boolean cdP = true;
  private String mSelfUin = "";
  
  public static void Jb(boolean paramBoolean)
  {
    cdK = paramBoolean;
  }
  
  private int L(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface = (agiq)paramQQAppInterface.getManager(317);
    if (paramQQAppInterface == null) {
      return 0;
    }
    return paramQQAppInterface.Eg();
  }
  
  private agke.b a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if ((paramString.contains("[")) && (paramString.contains("]")))
      {
        i = paramString.indexOf("[");
        int j = paramString.indexOf("]");
        if (j > i) {
          return new agke.b(paramString.substring(i, j + 1), paramInt);
        }
        QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo err. ipPortStr:" + paramString);
        return null;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] innerDnsIpPortStr2IPInfo exp. ipPortStr:" + paramString);
      return null;
    }
    int i = paramString.lastIndexOf(":");
    if (i >= 0) {
      return new agke.b(paramString.substring(0, i), paramInt);
    }
    agke.b localb = new agke.b(paramString, paramInt);
    return localb;
  }
  
  public static agke a()
  {
    try
    {
      if (jdField_a_of_type_Agke == null)
      {
        jdField_a_of_type_Agke = new agke();
        jdField_a_of_type_Agke.init();
      }
      agke localagke = jdField_a_of_type_Agke;
      return localagke;
    }
    finally {}
  }
  
  private List<agke.b> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool2 = false;
      String str2 = "";
      ArrayList localArrayList = aopd.a().a(paramString, 1019, true, 28);
      String str1 = str2;
      boolean bool1 = bool2;
      Object localObject1 = localObject2;
      if (localArrayList != null)
      {
        str1 = str2;
        bool1 = bool2;
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject1 = new ArrayList();
          if (paramBoolean != true) {
            break label179;
          }
        }
      }
      label179:
      for (int i = localArrayList.size();; i = 1)
      {
        a((List)localObject1, localArrayList, paramInt1, i);
        str1 = localObject1.toString();
        bool1 = true;
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns[" + paramString + "] result:" + bool1 + " IPv6List[" + str1 + "]");
        b(paramQQAppInterface, bool1, paramString, paramInt2);
        return localObject1;
      }
    }
    QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. domain=null");
    return null;
  }
  
  private void a(List<agke.b> paramList, List<String> paramList1, int paramInt1, int paramInt2)
  {
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramList == null) || (paramInt2 == 0)) {}
    int i;
    label33:
    Object localObject;
    do
    {
      return;
      paramList1 = paramList1.iterator();
      i = 0;
      if (!paramList1.hasNext()) {
        break;
      }
      localObject = (String)paramList1.next();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label100;
      }
      localObject = a((String)localObject, paramInt1);
      if (localObject == null) {
        break label100;
      }
    } while (i >= paramInt2);
    paramList.add(localObject);
    i += 1;
    label100:
    for (;;)
    {
      break label33;
      break;
    }
  }
  
  public static void a(List<agke.b> paramList, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    int i = paramList.size() - 1;
    label19:
    agke.b localb;
    if (i >= 0)
    {
      localb = (agke.b)paramList.get(i);
      if ((localb != null) && (!TextUtils.isEmpty(localb.mIp)))
      {
        if (!paramBoolean1) {
          break label108;
        }
        if (!paramBoolean2) {
          break label93;
        }
        if (!TextUtils.isEmpty(localb.vb())) {
          paramList1.add(0, localb.vb());
        }
      }
    }
    for (;;)
    {
      i -= 1;
      break label19;
      break;
      label93:
      paramList1.add(0, localb.mIp);
      continue;
      label108:
      if (paramBoolean2)
      {
        if (!TextUtils.isEmpty(localb.vb())) {
          paramList1.add(0, localb.vb() + ":" + localb.mPort);
        }
      }
      else {
        paramList1.add(0, localb.mIp + ":" + localb.mPort);
      }
    }
  }
  
  private boolean als()
  {
    return MsfServiceSdk.get().getConnectedIPFamily() == 2;
  }
  
  public static boolean alt()
  {
    return false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 2;
    int k = 0;
    int j;
    label63:
    label95:
    HashMap localHashMap;
    if (als())
    {
      j = 2;
      switch (paramInt)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        paramInt = 0;
        switch (ahbr.getIPStackType())
        {
        default: 
          i = 0;
        case 3: 
          localHashMap = new HashMap();
          localHashMap.put("param_domain", String.valueOf(paramString));
          if (!paramBoolean) {}
          break;
        }
        break;
      }
    }
    for (;;)
    {
      localHashMap.put("param_result", String.valueOf(k));
      localHashMap.put("param_stackType", String.valueOf(i));
      localHashMap.put("param_loginType", String.valueOf(j));
      localHashMap.put("param_bizType", String.valueOf(paramInt));
      paramString = this.mSelfUin;
      if (paramQQAppInterface != null) {
        paramString = paramQQAppInterface.getCurrentAccountUin();
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(paramString, "actFAIPDerect", true, 0L, 0L, localHashMap, null);
      QLog.d("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] >> reportInnerDnsResult:" + localHashMap.toString());
      return;
      j = 1;
      break;
      paramInt = 1;
      break label63;
      paramInt = 2;
      break label63;
      paramInt = 3;
      break label63;
      paramInt = 4;
      break label63;
      i = 1;
      break label95;
      i = 3;
      break label95;
      k = 1;
    }
  }
  
  private QQAppInterface d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void dhk() {}
  
  private void init()
  {
    ThreadManager.getSubThreadHandler().post(new FileIPv6StrateyController.1(this));
  }
  
  public int En()
  {
    return this.cXm;
  }
  
  public void Jc(boolean paramBoolean)
  {
    this.cdL = paramBoolean;
  }
  
  public void Jd(boolean paramBoolean)
  {
    this.cdM = paramBoolean;
  }
  
  public void Je(boolean paramBoolean)
  {
    this.cdN = paramBoolean;
  }
  
  public void Jf(boolean paramBoolean)
  {
    this.cdO = paramBoolean;
  }
  
  public void Jg(boolean paramBoolean)
  {
    this.cdP = paramBoolean;
  }
  
  public void NV(int paramInt)
  {
    this.cXm = paramInt;
  }
  
  public agke.c a(QQAppInterface paramQQAppInterface, agke.a parama, int paramInt)
  {
    if (parama == null) {
      return null;
    }
    if (paramQQAppInterface == null) {
      paramQQAppInterface = d();
    }
    for (;;)
    {
      if (!l(paramQQAppInterface, paramInt)) {
        return null;
      }
      if (paramQQAppInterface != null) {
        this.mSelfUin = paramQQAppInterface.getCurrentUin();
      }
      for (;;)
      {
        QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPlistForV6Domain on enable IPV6. busType:" + paramInt + " ipv6Domain:" + parama.mDomain + " port:" + parama.mPort + " stacktype:" + ahbr.getIPStackType() + " isV6Login:" + als() + " stratey:" + L(paramQQAppInterface));
        if (1 != ahbr.getIPStackType()) {
          break;
        }
        return null;
        QLog.w("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. app=null");
      }
      Object localObject;
      if (3 == ahbr.getIPStackType())
      {
        paramQQAppInterface = a(paramQQAppInterface, parama.mDomain, parama.mPort, paramInt, true);
        localObject = new agke.c();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          ((agke.c)localObject).cXn = 2;
          ((agke.c)localObject).Bb = paramQQAppInterface;
          return localObject;
        }
        dhk();
        ((agke.c)localObject).cXn = 1;
        ((agke.c)localObject).Bb.add(new agke.b(parama.mDomain, parama.mPort));
        return localObject;
      }
      if (2 == ahbr.getIPStackType())
      {
        if (L(paramQQAppInterface) == 0) {
          return null;
        }
        agke.c localc;
        if (L(paramQQAppInterface) == 1)
        {
          localObject = a(paramQQAppInterface, parama.mDomain, parama.mPort, paramInt, false);
          localc = new agke.c();
          if ((localObject == null) || (((List)localObject).size() == 0))
          {
            dhk();
            localc.cXn = 1;
            localc.Bb.add(new agke.b(parama.mDomain, parama.mPort));
            return localc;
          }
          if (this.jdField_a_of_type_Agkd.a(parama))
          {
            localc.cXn = 2;
            localc.Bb = ((List)localObject);
            return localc;
          }
          this.jdField_a_of_type_Agkd.a(paramQQAppInterface, parama, (agke.b)((List)localObject).get(0));
          return null;
        }
        if (L(paramQQAppInterface) == 2)
        {
          if (als())
          {
            localObject = a(paramQQAppInterface, parama.mDomain, parama.mPort, paramInt, false);
            localc = new agke.c();
            if ((localObject == null) || (((List)localObject).size() == 0))
            {
              dhk();
              localc.cXn = 1;
              localc.Bb.add(new agke.b(parama.mDomain, parama.mPort));
              return localc;
            }
            if (this.jdField_a_of_type_Agkd.a(parama))
            {
              localc.cXn = 2;
              localc.Bb = ((List)localObject);
              return localc;
            }
            this.jdField_a_of_type_Agkd.a(paramQQAppInterface, parama, (agke.b)((List)localObject).get(0));
            return null;
          }
          return null;
        }
      }
      return null;
    }
  }
  
  public boolean alu()
  {
    return this.cdL;
  }
  
  public boolean alv()
  {
    return this.cdM;
  }
  
  public boolean alw()
  {
    return this.cdN;
  }
  
  public boolean alx()
  {
    return this.cdO;
  }
  
  public boolean aly()
  {
    return this.cdP;
  }
  
  public List<ExcitingTransferHostInfo> c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localObject = d();
    }
    if (!l((QQAppInterface)localObject, paramInt)) {}
    label289:
    for (;;)
    {
      return null;
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPV6listForExcitingUpload on enable IPV6. busType:" + paramInt + " stacktype:" + ahbr.getIPStackType() + " isV6Login:" + als() + " stratey:" + L((QQAppInterface)localObject));
      if (1 == ahbr.getIPStackType()) {
        paramInt = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label289;
        }
        localObject = agpf.a().t(true);
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          break;
        }
        if (paramInt != 0)
        {
          return localObject;
          if (3 == ahbr.getIPStackType())
          {
            paramInt = 1;
            i = 1;
            continue;
          }
          if (2 == ahbr.getIPStackType())
          {
            if (L((QQAppInterface)localObject) == 0)
            {
              paramInt = 0;
              continue;
            }
            if (L((QQAppInterface)localObject) == 1)
            {
              paramInt = 0;
              i = 1;
              continue;
            }
            if (L((QQAppInterface)localObject) == 2)
            {
              if (als())
              {
                paramInt = 0;
                i = 1;
                continue;
              }
              paramInt = 0;
              continue;
            }
            paramInt = 0;
          }
        }
        else
        {
          paramQQAppInterface = new ArrayList();
          localObject = ((List)localObject).iterator();
          for (;;)
          {
            ExcitingTransferHostInfo localExcitingTransferHostInfo;
            if (((Iterator)localObject).hasNext())
            {
              localExcitingTransferHostInfo = (ExcitingTransferHostInfo)((Iterator)localObject).next();
              if (paramQQAppInterface.size() < 1) {}
            }
            else
            {
              return paramQQAppInterface;
            }
            paramQQAppInterface.add(localExcitingTransferHostInfo);
          }
        }
        paramInt = 0;
      }
    }
  }
  
  public boolean l(QQAppInterface paramQQAppInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = d();
      localQQAppInterface = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        return false;
      }
    }
    paramQQAppInterface = (agiq)localQQAppInterface.getManager(317);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (paramInt == 1) {
      return paramQQAppInterface.alk();
    }
    if (paramInt == 3) {
      return paramQQAppInterface.all();
    }
    if (paramInt == 5) {
      return false;
    }
    if (paramInt == 7) {
      return paramQQAppInterface.aln();
    }
    return false;
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public void onNetWifi2None()
  {
    this.jdField_a_of_type_Agkd.onNetChanged();
  }
  
  public static class a
  {
    public String mDomain;
    public int mPort;
    
    public a(String paramString, int paramInt)
    {
      this.mDomain = paramString;
      this.mPort = paramInt;
    }
    
    public String toString()
    {
      return "" + this.mDomain + ":" + this.mPort;
    }
  }
  
  public static class b
  {
    public String mIp;
    public int mPort;
    
    public b(String paramString, int paramInt)
    {
      this.mIp = paramString;
      this.mPort = paramInt;
    }
    
    public String toString()
    {
      return "" + this.mIp + ":" + this.mPort;
    }
    
    public String vb()
    {
      if ((this.mIp != null) && (this.mIp.startsWith("[")) && (this.mIp.endsWith("]"))) {
        return this.mIp.substring(1, this.mIp.length() - 1);
      }
      return this.mIp;
    }
  }
  
  public static class c
  {
    public List<agke.b> Bb = new ArrayList();
    public int cXn = 0;
    
    public boolean alz()
    {
      return (this.Bb == null) || (this.Bb.size() == 0);
    }
    
    public String toString()
    {
      if (alz()) {
        localObject = "TPType:" + this.cXn + "IPList:";
      }
      String str;
      Iterator localIterator;
      do
      {
        return localObject;
        str = "TPType:" + this.cXn + "IPList:";
        localIterator = this.Bb.iterator();
        localObject = str;
      } while (!localIterator.hasNext());
      Object localObject = (agke.b)localIterator.next();
      if (localObject != null) {
        if (!TextUtils.isEmpty(((agke.b)localObject).mIp))
        {
          localObject = ((agke.b)localObject).mIp + ":" + ((agke.b)localObject).mPort + " ";
          label145:
          str = str + (String)localObject;
        }
      }
      for (;;)
      {
        break;
        localObject = ":" + ((agke.b)localObject).mPort + " ";
        break label145;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agke
 * JD-Core Version:    0.7.0.1
 */