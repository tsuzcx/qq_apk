import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class aoji
  extends aojn
{
  private static boolean cLL;
  private static int dON;
  public static final boolean isMainProcess;
  ArrayList<akxb> Bl = new ArrayList();
  protected QQAppInterface app;
  protected long apq = 0L;
  protected long apr = 0L;
  protected String bMt = null;
  protected boolean cLM;
  public boolean cLN;
  protected String ckX;
  protected String ckY;
  protected String ckZ = null;
  int dOO = 0;
  int dOP = 0;
  public boolean mHasIpv6List;
  protected ArrayList<aonh> xp = new ArrayList();
  
  static
  {
    boolean bool = true;
    dON = 80;
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      isMainProcess = bool;
      return;
      bool = false;
    }
  }
  
  public aoji() {}
  
  public aoji(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.app = ((QQAppInterface)this.app);
    if ((paramaool != null) && (paramaool.b != null)) {}
    try
    {
      this.Bl.add(paramaool.b);
      this.jdField_a_of_type_Aona$d = aojp.b;
      return;
    }
    finally {}
  }
  
  public static int KI()
  {
    if (!cLL) {}
    try
    {
      Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "getPicDownloadPort:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 9) {
        dON = Integer.valueOf(localObject[9]).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "getPicDownloadPort e:" + localException.toString());
        }
      }
    }
    cLL = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "getPicDownloadPort return " + dON);
    }
    return dON;
  }
  
  public static byte[] ac(String paramString)
  {
    if (paramString.length() % 2 != 0) {}
    do
    {
      return null;
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        paramString = paramString.toCharArray();
        int i = 0;
        while (i < paramString.length)
        {
          StringBuilder localStringBuilder = new StringBuilder(2);
          localStringBuilder.append(paramString[i]).append(paramString[(i + 1)]);
          arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
          i += 2;
        }
        return arrayOfByte;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG", 2, "bytesFromHexString Exception=" + paramString.getMessage());
    return null;
  }
  
  public void a(akxb paramakxb)
  {
    try
    {
      if (this.Bl != null) {
        this.Bl.remove(paramakxb);
      }
      return;
    }
    finally {}
  }
  
  protected void a(aomh paramaomh, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll)) && (((aoll)this.jdField_a_of_type_Aomg).bZ != null))
    {
      localObject = ((aoll)this.jdField_a_of_type_Aomg).bZ;
      this.jdField_a_of_type_Aomy.mUrl = ((String)localObject);
    }
    try
    {
      localObject = new URL((String)localObject);
      String str = ((URL)localObject).getHost();
      int i = ((URL)localObject).getPort();
      this.jdField_a_of_type_Aomy.mServerIp = str;
      this.jdField_a_of_type_Aomy.clZ = String.valueOf(i);
      this.jdField_a_of_type_Aomy.cme = (paramaomh.dPy + "");
      this.jdField_a_of_type_Aomy.mMD5 = this.h.mMd5;
      this.jdField_a_of_type_Aomy.bRd = paramString2;
      this.jdField_a_of_type_Aomy.cma = String.valueOf(paramaomh.mErrCode);
      this.jdField_a_of_type_Aomy.clO = paramaomh.clO;
      if (paramaomh.mErrCode == -9527) {}
      for (paramaomh = (String)paramaomh.nR.get("netresp_param_reason");; paramaomh = null)
      {
        this.jdField_a_of_type_Aomy.mReason = paramaomh;
        cZ(paramString1, paramBoolean);
        return;
      }
      return;
    }
    catch (Throwable paramaomh)
    {
      QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", paramaomh);
    }
  }
  
  public void b(akxb paramakxb)
  {
    try
    {
      this.Bl.add(paramakxb);
      return;
    }
    finally {}
  }
  
  public void dUR()
  {
    dN(9366, "transfileController destroy");
    onError();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
    }
    super.dUR();
  }
  
  protected byte[] h(String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = str;
    if (paramString1 != null)
    {
      localObject = str;
      if (paramString1.length() == 32) {
        localObject = ac(paramString1);
      }
    }
    paramString1 = (String)localObject;
    if (localObject == null)
    {
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() != 32) {
          break label86;
        }
        paramString1 = ac(str);
      }
    }
    label86:
    do
    {
      do
      {
        do
        {
          return paramString1;
          if (str.length() != 38) {
            break;
          }
          paramString2 = str.substring(1, 37).replace("-", "");
          paramString1 = (String)localObject;
        } while (paramString2.length() != 32);
        return ac(paramString2);
        paramString1 = (String)localObject;
      } while (str.length() != 34);
      paramString2 = str.substring(1, 33);
      paramString1 = (String)localObject;
    } while (paramString2.length() != 32);
    return ac(paramString2);
  }
  
  protected ArrayList<aonh> i(ArrayList<aonh> paramArrayList1, ArrayList<aonh> paramArrayList2)
  {
    this.mHasIpv6List = false;
    this.cLN = false;
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      this.mHasIpv6List = true;
    }
    paramArrayList1 = aolo.i(paramArrayList1, paramArrayList2);
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList2 = (aonh)paramArrayList1.get(0);
      if ((paramArrayList2 != null) && (paramArrayList2.isIpv6)) {
        this.cLN = true;
      }
    }
    return paramArrayList1;
  }
  
  public void start()
  {
    try
    {
      if (this.b != null)
      {
        this.b.status = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoji
 * JD-Core Version:    0.7.0.1
 */