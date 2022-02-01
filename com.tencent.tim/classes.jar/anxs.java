import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;

public class anxs
{
  public ArrayList<String> Bc;
  public ArrayList<String> Bd;
  public ArrayList<String> Be;
  public String aLa;
  public String aQf;
  public boolean cKA;
  public boolean cKB;
  public boolean cKC;
  public boolean cKz = true;
  public String errorMsg;
  public int errorType = -99999;
  public Object obj;
  public int serverErrorType = -99999;
  
  public static anxs a(anxs paramanxs)
  {
    if (paramanxs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clone() return, backData == null.");
      }
      return null;
    }
    anxs localanxs = new anxs();
    localanxs.errorMsg = paramanxs.errorMsg;
    localanxs.errorType = paramanxs.errorType;
    localanxs.aLa = paramanxs.aLa;
    localanxs.aQf = paramanxs.aQf;
    ArrayList localArrayList = new ArrayList();
    if (paramanxs.Bc != null) {
      localArrayList.addAll(paramanxs.Bc);
    }
    localanxs.Bc = localArrayList;
    localArrayList = new ArrayList();
    if (paramanxs.Bd != null) {
      localArrayList.addAll(paramanxs.Bd);
    }
    localanxs.Bd = localArrayList;
    localArrayList = new ArrayList();
    if (paramanxs.Be != null) {
      localArrayList.addAll(paramanxs.Be);
    }
    localanxs.Be = localArrayList;
    localanxs.obj = paramanxs.obj;
    localanxs.serverErrorType = paramanxs.serverErrorType;
    localanxs.cKz = paramanxs.cKz;
    localanxs.cKA = paramanxs.cKA;
    localanxs.cKB = paramanxs.cKB;
    localanxs.cKC = paramanxs.cKC;
    return localanxs;
  }
  
  public void RF(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.addNewUin subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      return;
      if (this.Bc == null) {
        this.Bc = new ArrayList();
      }
      if (!this.Bc.contains(paramString)) {
        this.Bc.add(paramString);
      }
      if (this.Bd == null) {
        this.Bd = new ArrayList();
      }
    } while (this.Bd.contains(paramString));
    this.Bd.add(paramString);
  }
  
  public void a(oidb_0x7a2.RspBody paramRspBody, ArrayList<String> paramArrayList)
  {
    if (paramRspBody == null) {}
    do
    {
      return;
      if (this.Bc == null) {
        this.Bc = new ArrayList();
      }
      for (;;)
      {
        if ((paramRspBody.uint64_bind_uin.has()) && (paramRspBody.uint64_bind_uin.get() > 10000L))
        {
          this.aQf = Long.toString(paramRspBody.uint64_bind_uin.get());
          this.Bc.add(this.aQf);
        }
        if (!paramRspBody.uint64_multi_bind_uin.has()) {
          break;
        }
        paramRspBody = paramRspBody.uint64_multi_bind_uin.get();
        if (paramRspBody == null) {
          break;
        }
        paramRspBody = paramRspBody.iterator();
        while (paramRspBody.hasNext())
        {
          Object localObject = (Long)paramRspBody.next();
          if (((Long)localObject).longValue() > 10000L)
          {
            localObject = Long.toString(((Long)localObject).longValue());
            if (!this.Bc.contains(localObject)) {
              this.Bc.add(localObject);
            }
            if (this.aQf == null) {
              this.aQf = ((String)localObject);
            }
          }
        }
        this.Bc.clear();
      }
      this.Be = new ArrayList();
      this.Bd = new ArrayList();
      this.Bd.addAll(this.Bc);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramRspBody = paramArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          paramArrayList = (String)paramRspBody.next();
          if (!this.Bc.contains(paramArrayList)) {
            this.Be.add(paramArrayList);
          }
          this.Bd.remove(paramArrayList);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=" + String.valueOf(this.Bd) + " overdue SubUins=" + String.valueOf(this.Be));
  }
  
  public boolean azk()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Bd != null)
    {
      bool1 = bool2;
      if (this.Bd.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean azl()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Be != null)
    {
      bool1 = bool2;
      if (this.Be.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean azm()
  {
    boolean bool2 = false;
    if ((this.aQf != null) && (this.aQf.length() > 4))
    {
      if (this.Bc == null) {
        this.Bc = new ArrayList();
      }
      if (!this.Bc.contains(this.aQf)) {
        this.Bc.add(0, this.aQf);
      }
    }
    boolean bool1 = bool2;
    if (this.Bc != null)
    {
      bool1 = bool2;
      if (this.Bc.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList<String> dM()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.Bd != null) {
      localArrayList.addAll(this.Bd);
    }
    return localArrayList;
  }
  
  public ArrayList<String> dN()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.Be != null) {
      localArrayList.addAll(this.Be);
    }
    return localArrayList;
  }
  
  public ArrayList<String> dO()
  {
    if ((this.aQf != null) && (this.aQf.length() > 4))
    {
      if (this.Bc == null) {
        this.Bc = new ArrayList();
      }
      if (!this.Bc.contains(this.aQf)) {
        this.Bc.add(0, this.aQf);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (this.Bc != null) {
        localArrayList.addAll(this.Bc);
      }
      return localArrayList;
      this.Bc = null;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
      }
    }
  }
  
  public void dTL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
    }
    if (this.Bd != null) {
      this.Bd.clear();
    }
    if (this.Be != null) {
      this.Be.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxs
 * JD-Core Version:    0.7.0.1
 */