package tmsdk.common.d.a.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class o
{
  private final String a = "SharkNetwork";
  private final int b = 0;
  private final int c = 1;
  private Context d;
  private g e;
  private q f;
  private q g;
  private tmsdk.common.d.a.a.b h;
  private k i;
  private c j;
  private Object k = new Object();
  private String l = "";
  private a.b.a m;
  
  public o(Context paramContext, g paramg, boolean paramBoolean)
  {
    new StringBuilder().append("SharkNetwork() isTest: ").append(paramBoolean).toString();
    new StringBuilder().append("SharkNetwork() isTest: ").append(paramBoolean).toString();
    this.d = paramContext;
    this.e = paramg;
    this.f = new q();
    this.g = new q();
    this.h = new tmsdk.common.d.a.a.b(paramContext, paramBoolean, paramg);
    this.i = new k(paramContext, this);
    this.j = new c(paramContext, this);
    int n = Process.myPid();
    paramBoolean = this.e.a();
    paramg = new StringBuilder();
    if (paramBoolean) {}
    for (paramContext = "b";; paramContext = "f")
    {
      paramg.append(paramContext);
      paramg.append(n);
      this.l = paramg.toString();
      new StringBuilder().append("SharkNetwork() mExt: ").append(this.l).toString();
      return;
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case -10000: 
      return paramInt - 3;
    case -20000: 
      return paramInt - 3;
    case -30000: 
      return paramInt - 3;
    case -40000: 
      return paramInt - 3;
    case -50000: 
      return paramInt - 4;
    case -60000: 
      return paramInt - 3;
    case -70000: 
      return paramInt - 3;
    case -80000: 
      return paramInt - 3;
    case -90000: 
      return paramInt - 3;
    case -100000: 
      return paramInt - 3;
    case -110000: 
      return paramInt - 3;
    case -120000: 
      return paramInt - 3;
    case -130000: 
      return paramInt - 4;
    case -140000: 
      return paramInt - 3;
    case -150000: 
      return paramInt - 3;
    case -160000: 
      return paramInt - 6;
    }
    return paramInt - 5;
  }
  
  private a.b.a a(boolean paramBoolean, l paraml)
  {
    if (this.m == null) {
      this.m = new a.b.a();
    }
    if (paraml != null) {}
    for (String str = paraml.a;; str = this.m.e)
    {
      a.b.a locala = this.m;
      if (paramBoolean) {
        str = "";
      }
      locala.e = str;
      this.m.f = tmsdk.common.a.b("build");
      this.m.a = g();
      this.m.b = h();
      this.m.c = this.j.e();
      this.m.d = this.l;
      if (paraml != null)
      {
        new StringBuilder().append("checkSharkfin() rsaKeyCode: ").append(paraml.hashCode()).append(" rsaKey: ").append(paraml).append(" mSharkfin.buildno: ").append(this.m.f).append(" mSharkfin.apn: ").append(this.m.a).append(" mSharkfin.authType: ").append(this.m.b).append(" mSharkfin.guid: ").append(this.m.c).append(" mSharkfin.ext1: ").append(this.m.d).toString();
        new StringBuilder().append("checkSharkfin() rsaKeyCode: ").append(paraml.hashCode()).append(" rsaKey: ").append(paraml).append(" mSharkfin.buildno: ").append(this.m.f).append(" mSharkfin.apn: ").append(this.m.a).append(" mSharkfin.authType: ").append(this.m.b).append(" mSharkfin.guid: ").append(this.m.c).append(" mSharkfin.ext1: ").append(this.m.d).toString();
        new StringBuilder().append("[ocean]info: guid|").append(this.m.c).toString();
        new StringBuilder().append("[ocean]info: SdKy: sessionId|").append(this.m.e).append("|encodeKey|").append(paraml.b).toString();
        new StringBuilder().append("[ocean]info: guid|").append(this.m.c).append("|sessionId|").append(this.m.e).append("|encodeKey|").append(paraml.b).toString();
      }
      return this.m;
    }
  }
  
  private a.e.c a(String paramString)
  {
    int n = this.h.a().a();
    int i1 = this.h.a().b();
    new StringBuilder().append("getCSIPListResultToSend() hash: ").append(n).append(" hashSeqNo: ").append(i1).toString();
    new StringBuilder().append("getCSIPListResultToSend() hash: ").append(n).append(" hashSeqNo: ").append(i1).toString();
    if (n == 0) {
      return null;
    }
    this.h.a().a(0, 0);
    new StringBuilder().append("getCSIPListResultToSend() encodeKey: ").append(paramString).toString();
    new StringBuilder().append("getCSIPListResultToSend() encodeKey: ").append(paramString).toString();
    a.a.a locala = new a.a.a();
    locala.a = n;
    a.e.c localc = new a.e.c();
    localc.b = 0;
    localc.c = i1;
    localc.a = 151;
    localc.d = b.a(this.d, paramString.getBytes(), locala);
    return localc;
  }
  
  private a.e.d a(boolean paramBoolean1, boolean paramBoolean2, l paraml, ArrayList paramArrayList)
  {
    a.e.d locald = h.a();
    locald.a = this.g.b();
    if (paramBoolean2) {}
    for (int n = 1;; n = 0)
    {
      locald.c = n;
      locald.d = a(paramBoolean1, paraml);
      locald.e = paramArrayList;
      this.g.c();
      return locald;
    }
  }
  
  private a.e.f a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i1 = paramArrayList.size();
    if (i1 <= 0) {
      return null;
    }
    int n = 0;
    if (n < i1)
    {
      a.e.f localf = (a.e.f)paramArrayList.get(n);
      if (localf == null) {}
      while (paramInt != localf.a)
      {
        n += 1;
        break;
      }
      return localf;
    }
    return null;
  }
  
  private ArrayList a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i1 = paramArrayList.size();
    new StringBuilder().append("handleServerSashimiList()  retList.size(): ").append(paramArrayList.size()).append(" noCheckIpList: ").append(paramBoolean).toString();
    new StringBuilder().append("handleServerSashimiList()  retList.size(): ").append(paramArrayList.size()).append(" noCheckIpList: ").append(paramBoolean).toString();
    int n = 0;
    if (n < i1)
    {
      localObject = (a.e.f)paramArrayList.get(n);
      if (localObject == null) {}
      do
      {
        n += 1;
        break;
        new StringBuilder().append("handleServerSashimiList() rs.seqNo: ").append(((a.e.f)localObject).b).append(" rs.cmd: ").append(((a.e.f)localObject).a).append(" rs.retCode: ").append(((a.e.f)localObject).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject).e).toString();
        new StringBuilder().append("handleServerSashimiList() rs.seqNo: ").append(((a.e.f)localObject).b).append(" rs.cmd: ").append(((a.e.f)localObject).a).append(" rs.retCode: ").append(((a.e.f)localObject).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject).e).toString();
        if (((a.e.f)localObject).f != null)
        {
          new StringBuilder().append("handleServerSashimiList()  rs.data.length: ").append(((a.e.f)localObject).f.length).toString();
          new StringBuilder().append("handleServerSashimiList()  rs.data.length: ").append(((a.e.f)localObject).f.length).toString();
        }
      } while ((paramBoolean) || (!a((a.e.f)localObject)));
    }
    for (;;)
    {
      localObject = paramArrayList;
      if (n < 0) {
        break;
      }
      paramArrayList.remove(n);
      return paramArrayList;
      n = -1;
    }
  }
  
  private void a(ArrayList paramArrayList, l paraml1, l paraml2)
  {
    if ((paramArrayList == null) || (paraml1 == null) || (paraml2 == null) || (TextUtils.isEmpty(paraml2.a)) || (TextUtils.isEmpty(paraml2.b))) {}
    int n;
    do
    {
      return;
      n = paramArrayList.size();
    } while (n <= 0);
    new StringBuilder().append("[ocean]info: RKey:  oldRsaKey: ").append(paraml1).append(" newRsaKey: ").append(paraml2).toString();
    n -= 1;
    label81:
    a.e.c localc;
    if (n >= 0)
    {
      localc = (a.e.c)paramArrayList.get(n);
      if ((localc != null) && (localc.d != null) && (localc.d.length > 0)) {
        break label128;
      }
    }
    for (;;)
    {
      n -= 1;
      break label81;
      break;
      label128:
      new StringBuilder().append("[ocean]info: RKey: ECmd: ").append(localc.a).toString();
      byte[] arrayOfByte = b.b(this.d, paraml1.b.getBytes(), localc.d);
      if (arrayOfByte == null)
      {
        paramArrayList.remove(n);
      }
      else
      {
        arrayOfByte = b.a(this.d, paraml2.b.getBytes(), arrayOfByte);
        if (arrayOfByte == null) {
          paramArrayList.remove(n);
        } else {
          localc.d = arrayOfByte;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    int i1 = 0;
    int i2;
    int n;
    if ((paramBoolean) && (paramArrayList1 != null))
    {
      i2 = paramArrayList1.size();
      n = 0;
      while (n < i2)
      {
        a.e.c localc = (a.e.c)paramArrayList1.get(n);
        if (localc == null)
        {
          n += 1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder().append("[ocean]info: Used: sessionId|");
          if (paraml != null)
          {
            str = paraml.a;
            label77:
            localStringBuilder = localStringBuilder.append(str).append("|encodeKey|");
            if (paraml == null) {
              break label278;
            }
          }
          label278:
          for (String str = paraml.b;; str = "")
          {
            localStringBuilder.append(str).toString();
            new StringBuilder().append("[ocean]send: ECmd|").append(localc.a).append("|seqNo|").append(localc.b).append("|refSeqNo|").append(localc.c).append("|ret|").append(paramInt).append("|ident|").append(localc.e).toString();
            new StringBuilder().append("[ocean]send: ECmd|").append(localc.a).append("|seqNo|").append(localc.b).append("|refSeqNo|").append(localc.c).append("|ret|").append(paramInt).append("|ident|").append(localc.e).toString();
            break;
            str = "";
            break label77;
          }
        }
      }
    }
    if ((!paramBoolean) && (paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      i2 = paramArrayList2.size();
      n = i1;
    }
    while (n < i2)
    {
      paraml = (a.e.f)paramArrayList2.get(n);
      if (paraml == null)
      {
        n += 1;
      }
      else
      {
        if ((paramInt != 0) || (paraml.d != 0) || (paraml.e != 0)) {
          new StringBuilder().append("[ocean]recv: ECmd|").append(paraml.a).append("|seqNo|").append(paraml.b).append("|refSeqNo|").append(paraml.c).append("|ret|").append(paramInt).append("|retCode|").append(paraml.d).append("|dataRetCode|").append(paraml.e).toString();
        }
        for (;;)
        {
          new StringBuilder().append("[ocean]recv: ECmd|").append(paraml.a).append("|seqNo|").append(paraml.b).append("|refSeqNo|").append(paraml.c).append("|ret|").append(paramInt).append("|retCode|").append(paraml.d).append("|dataRetCode|").append(paraml.e).toString();
          break;
          new StringBuilder().append("[ocean]recv: ECmd|").append(paraml.a).append("|seqNo|").append(paraml.b).append("|refSeqNo|").append(paraml.c).append("|ret|").append(paramInt).append("|retCode|").append(paraml.d).append("|dataRetCode|").append(paraml.e).toString();
        }
        if ((!paramBoolean) && (paramArrayList1 != null))
        {
          i1 = paramArrayList1.size();
          n = 0;
          if (n < i1)
          {
            paraml = (a.e.c)paramArrayList1.get(n);
            if (paraml == null) {}
            for (;;)
            {
              n += 1;
              break;
              new StringBuilder().append("[ocean]recv: ECmd|").append(paraml.a + 10000).append("|ret|").append(paramInt).toString();
              new StringBuilder().append("[ocean]recv: ECmd|").append(paraml.a + 10000).append("|ret|").append(paramInt).toString();
            }
          }
        }
      }
    }
  }
  
  private boolean a(a.e.f paramf)
  {
    if (10150 == paramf.a) {}
    for (int n = 1; n == 0; n = 0) {
      return false;
    }
    if (paramf.f == null) {
      return true;
    }
    new StringBuilder().append("checkIpList() respSashimi.seqNo: ").append(paramf.b).append(" respSashimi.refSeqNo: ").append(paramf.c).append(" respSashimi.cmd: ").append(paramf.a).append(" respSashimi.retCode: ").append(paramf.d).append(" respSashimi.dataRetCode: ").append(paramf.e).append(" respSashimi.data.length: ").append(paramf.f.length).toString();
    new StringBuilder().append("checkIpList() respSashimi.seqNo: ").append(paramf.b).append(" respSashimi.refSeqNo: ").append(paramf.c).append(" respSashimi.cmd: ").append(paramf.a).append(" respSashimi.retCode: ").append(paramf.d).append(" respSashimi.dataRetCode: ").append(paramf.e).append(" respSashimi.data.length: ").append(paramf.f.length).toString();
    if (paramf.d != 0) {
      return true;
    }
    if (paramf.e != 0)
    {
      new StringBuilder().append("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ").append(paramf.e).toString();
      new StringBuilder().append("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ").append(paramf.e).toString();
      return true;
    }
    if (paramf.f == null) {
      return true;
    }
    Object localObject = new a.a.c();
    localObject = b.a(this.d, this.i.a().b.getBytes(), paramf.f, (JceStruct)localObject);
    if (localObject == null) {
      return true;
    }
    localObject = (a.a.c)localObject;
    this.h.a().a(((a.a.c)localObject).a, paramf.b, ((a.a.c)localObject).b, ((a.a.c)localObject).c, ((a.a.c)localObject).d, ((a.a.c)localObject).e);
    return true;
  }
  
  private boolean a(l paraml1, l paraml2)
  {
    return (paraml1 != null) && (paraml2 != null) && (!TextUtils.isEmpty(paraml1.a)) && (!TextUtils.isEmpty(paraml1.b)) && (!TextUtils.isEmpty(paraml2.a)) && (!TextUtils.isEmpty(paraml2.b)) && ((!paraml1.a.equals(paraml2.a)) || (!paraml1.b.equals(paraml2.b)));
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, l paraml, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    new StringBuilder().append("doSend() isReqRSA: ").append(paramBoolean1).append(" isReqRegistGuid: ").append(paramBoolean2).append(" isReqUpdateRegist: ").append(paramBoolean3).append(" rsaKey: ").append(paraml).toString();
    new StringBuilder().append("doSend() isReqRSA: ").append(paramBoolean1).append(" isReqRegistGuid: ").append(paramBoolean2).append(" isReqUpdateRegist: ").append(paramBoolean3).append(" rsaKey: ").append(paraml).toString();
    Object localObject = paraml;
    if (!paramBoolean1)
    {
      n = this.i.b();
      if (n != 0) {
        return n;
      }
      l locall = this.i.a();
      localObject = paraml;
      if (paraml != null) {
        if ((!TextUtils.isEmpty(paraml.a)) && (!TextUtils.isEmpty(paraml.b)))
        {
          localObject = paraml;
          if (!a(paraml, locall)) {}
        }
        else
        {
          a(paramArrayList, paraml, locall);
          localObject = locall;
        }
      }
    }
    if ((!paramBoolean1) && (!paramBoolean2) && (TextUtils.isEmpty(this.j.c()))) {
      return -200;
    }
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
      this.j.d();
    }
    if (paramArrayList == null) {
      return 0;
    }
    new StringBuilder().append("doSend() reqSashimiList.size(): ").append(paramArrayList.size()).toString();
    new StringBuilder().append("doSend() reqSashimiList.size(): ").append(paramArrayList.size()).toString();
    if (paramArrayList.size() <= 0) {
      return -10;
    }
    paraml = h.a(a(paramBoolean1, true, (l)localObject, paramArrayList));
    new StringBuilder().append("doSend() sendData.length: ").append(paraml.length).toString();
    new StringBuilder().append("doSend() sendData.length: ").append(paraml.length).toString();
    paramArrayList = new AtomicReference();
    int n = this.h.a(paraml, paramArrayList);
    if (-160000 == n)
    {
      n = a(n);
      new StringBuilder().append("doSend() ESharkCode.ERR_NEED_WIFIAPPROVEMENT == ret, doneRet: ").append(n).toString();
      new StringBuilder().append("doSend() ESharkCode.ERR_NEED_WIFIAPPROVEMENT == ret, doneRet: ").append(n).toString();
      return n;
    }
    if (n != 0)
    {
      n = a(n);
      new StringBuilder().append("doSend() ESharkCode.ERR_NONE != ret, doneRet: ").append(n).toString();
      new StringBuilder().append("doSend() ESharkCode.ERR_NONE != ret, doneRet: ").append(n).toString();
      return n;
    }
    paraml = (byte[])paramArrayList.get();
    if (paraml == null) {
      return -5;
    }
    new StringBuilder().append("doSend() retData.length: ").append(paraml.length).toString();
    new StringBuilder().append("doSend() retData.length: ").append(paraml.length).toString();
    try
    {
      paraml = h.a(paraml);
      if (paraml == null) {
        return -5;
      }
    }
    catch (Exception paraml)
    {
      new StringBuilder().append("doSend() e: ").append(paraml.toString()).toString();
      new StringBuilder().append("doSend() e: ").append(paraml.toString()).toString();
      return -5;
    }
    paraml = (a.e.g)paraml;
    paramArrayList = paraml.c;
    if (paramArrayList == null) {
      return -5;
    }
    new StringBuilder().append("doSend() retShark.seqNo: ").append(paraml.a).append(" respSashimiList.size(): ").append(paramArrayList.size()).toString();
    new StringBuilder().append("doSend() retShark.seqNo: ").append(paraml.a).append(" respSashimiList.size(): ").append(paramArrayList.size()).toString();
    paramAtomicReference.set(paramArrayList);
    return 0;
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (paramArrayList.size() > 1) {
      return false;
    }
    paramArrayList = (a.e.f)paramArrayList.get(0);
    if (paramArrayList == null) {
      return false;
    }
    if (2 == paramArrayList.d) {}
    for (int n = 1; n == 0; n = 0) {
      return false;
    }
    new StringBuilder().append("checkRsa() ERC_EXPIRE retCode: ").append(paramArrayList.d).append(" dataRetCode: ").append(paramArrayList.e).toString();
    new StringBuilder().append("checkRsa() ERC_EXPIRE retCode: ").append(paramArrayList.d).append(" dataRetCode: ").append(paramArrayList.e).toString();
    return true;
  }
  
  private void c(ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      break label4;
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if (paramArrayList.size() > 0)
      {
        Object localObject = a(paramArrayList, 10151);
        if (localObject == null) {
          break;
        }
        new StringBuilder().append("checkCSIPListResult() rs.seqNo: ").append(((a.e.f)localObject).b).append(" rs.cmd: ").append(((a.e.f)localObject).a).append(" rs.retCode: ").append(((a.e.f)localObject).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject).e).toString();
        new StringBuilder().append("checkCSIPListResult() rs.seqNo: ").append(((a.e.f)localObject).b).append(" rs.cmd: ").append(((a.e.f)localObject).a).append(" rs.retCode: ").append(((a.e.f)localObject).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject).e).toString();
        if ((1 == ((a.e.f)localObject).d) || (((a.e.f)localObject).e != 0)) {
          break;
        }
        paramArrayList = ((a.e.f)localObject).f;
        if (paramArrayList == null) {
          break;
        }
        new StringBuilder().append("checkCSIPListResult() rs.data.length: ").append(((a.e.f)localObject).f.length).toString();
        new StringBuilder().append("checkCSIPListResult() rs.data.length: ").append(((a.e.f)localObject).f.length).toString();
        localObject = new a.a.d();
        try
        {
          paramArrayList = b.a(this.d, b().b.getBytes(), paramArrayList, (JceStruct)localObject);
          if (paramArrayList != null)
          {
            paramArrayList = (a.a.d)paramArrayList;
            new StringBuilder().append("checkCSIPListResult() ipList反馈成功, ret.hash: ").append(paramArrayList.a).toString();
            new StringBuilder().append("checkCSIPListResult() ipList反馈成功, ret.hash: ").append(paramArrayList.a).toString();
            return;
          }
        }
        catch (Exception paramArrayList) {}
      }
    }
  }
  
  private boolean e()
  {
    long l1 = this.e.k();
    long l2 = System.currentTimeMillis();
    boolean bool = tmsdk.common.c.a.e.b(l2, l1, 360);
    this.e.b(l2);
    return bool;
  }
  
  private boolean f()
  {
    if (!this.j.a()) {}
    int n;
    do
    {
      return true;
      n = a(null, new ArrayList(), new AtomicReference());
    } while ((-10 == n) || (n == 0));
    new StringBuilder().append("checkDoRegist() 首次注册失败，ret: ").append(n).toString();
    new StringBuilder().append("checkDoRegist() 首次注册失败，ret: ").append(n).toString();
    return false;
  }
  
  private int g()
  {
    int n = 3;
    if (!tmsdk.common.c.a.c.f)
    {
      tmsdk.common.c.a.c.f = false;
      tmsdk.common.c.a.c.a(this.d);
    }
    if (3 == tmsdk.common.c.a.c.g)
    {
      n = 1;
      return n;
    }
    switch (tmsdk.common.c.a.c.i)
    {
    case 1: 
    default: 
      return 0;
    case 0: 
      return 2;
    case 2: 
      return 4;
    case 3: 
      return 5;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    case 7: 
      return 9;
    }
    return 10;
  }
  
  private int h()
  {
    switch ()
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public int a(l paraml, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    if (!tmsdk.common.e.f.e()) {
      return -2;
    }
    return a(false, false, false, paraml, paramArrayList, paramAtomicReference);
  }
  
  protected int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, l paraml, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    Object localObject2 = this.k;
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3) && (paraml != null)) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = a(paraml.b);
        if (localObject1 == null) {
          break label367;
        }
        paramArrayList.add(localObject1);
        bool1 = true;
        new StringBuilder().append("send() isReqIpListResult: ").append(bool1).toString();
        new StringBuilder().append("send() isReqIpListResult: ").append(bool1).toString();
        AtomicReference localAtomicReference1 = new AtomicReference();
        a(true, paraml, paramArrayList, null, 0);
        int n = b(paramBoolean1, paramBoolean2, paramBoolean3, paraml, paramArrayList, localAtomicReference1);
        if (n != 0)
        {
          a(false, null, paramArrayList, (ArrayList)localAtomicReference1.get(), n);
          paraml = this.e;
          return n;
        }
        localObject1 = a((ArrayList)localAtomicReference1.get(), bool1);
        boolean bool2 = b((ArrayList)localObject1);
        new StringBuilder().append("send() 密钥是否过期：").append(bool2).toString();
        new StringBuilder().append("send() 密钥是否过期：").append(bool2).toString();
        if ((!paramBoolean1) && (bool2))
        {
          AtomicReference localAtomicReference2 = new AtomicReference();
          bool2 = this.i.a(localAtomicReference2);
          if ((!paramBoolean1) && (bool2))
          {
            n = b(false, paramBoolean2, paramBoolean3, paraml, paramArrayList, localAtomicReference1);
            paraml = a((ArrayList)localAtomicReference1.get(), bool1);
            a(false, null, paramArrayList, (ArrayList)localAtomicReference1.get(), n);
            paramAtomicReference.set(paraml);
            paramArrayList = this.e;
            if (bool1) {
              c(paraml);
            }
            return n;
          }
        }
      }
      finally {}
      paraml = (l)localObject1;
      continue;
      label367:
      boolean bool1 = false;
    }
  }
  
  public a.e.d a(ArrayList paramArrayList)
  {
    if (!f()) {
      return null;
    }
    return a(true, false, null, paramArrayList);
  }
  
  public ArrayList a(a.e.g paramg)
  {
    if (paramg == null) {
      return null;
    }
    return paramg.c;
  }
  
  protected g a()
  {
    return this.e;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h.a().a(paramBoolean);
  }
  
  protected l b()
  {
    return this.i.a();
  }
  
  public f c()
  {
    return this.f;
  }
  
  public void d()
  {
    if (!this.j.a()) {}
    while (!e()) {
      return;
    }
    c.b.a.a.a().b(new p(this), "checkDoRegist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.o
 * JD-Core Version:    0.7.0.1
 */