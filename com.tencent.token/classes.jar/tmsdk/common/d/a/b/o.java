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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharkNetwork() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharkNetwork() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.toString();
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
    if (paramBoolean) {
      paramContext = "b";
    } else {
      paramContext = "f";
    }
    paramg.append(paramContext);
    paramg.append(n);
    this.l = paramg.toString();
    paramContext = new StringBuilder();
    paramContext.append("SharkNetwork() mExt: ");
    paramContext.append(this.l);
    paramContext.toString();
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
    Object localObject;
    if (paraml != null) {
      localObject = paraml.a;
    } else {
      localObject = this.m.e;
    }
    a.b.a locala = this.m;
    if (paramBoolean) {
      localObject = "";
    }
    locala.e = ((String)localObject);
    this.m.f = tmsdk.common.a.b("build");
    this.m.a = g();
    this.m.b = h();
    this.m.c = this.j.e();
    this.m.d = this.l;
    if (paraml != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkSharkfin() rsaKeyCode: ");
      ((StringBuilder)localObject).append(paraml.hashCode());
      ((StringBuilder)localObject).append(" rsaKey: ");
      ((StringBuilder)localObject).append(paraml);
      ((StringBuilder)localObject).append(" mSharkfin.buildno: ");
      ((StringBuilder)localObject).append(this.m.f);
      ((StringBuilder)localObject).append(" mSharkfin.apn: ");
      ((StringBuilder)localObject).append(this.m.a);
      ((StringBuilder)localObject).append(" mSharkfin.authType: ");
      ((StringBuilder)localObject).append(this.m.b);
      ((StringBuilder)localObject).append(" mSharkfin.guid: ");
      ((StringBuilder)localObject).append(this.m.c);
      ((StringBuilder)localObject).append(" mSharkfin.ext1: ");
      ((StringBuilder)localObject).append(this.m.d);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkSharkfin() rsaKeyCode: ");
      ((StringBuilder)localObject).append(paraml.hashCode());
      ((StringBuilder)localObject).append(" rsaKey: ");
      ((StringBuilder)localObject).append(paraml);
      ((StringBuilder)localObject).append(" mSharkfin.buildno: ");
      ((StringBuilder)localObject).append(this.m.f);
      ((StringBuilder)localObject).append(" mSharkfin.apn: ");
      ((StringBuilder)localObject).append(this.m.a);
      ((StringBuilder)localObject).append(" mSharkfin.authType: ");
      ((StringBuilder)localObject).append(this.m.b);
      ((StringBuilder)localObject).append(" mSharkfin.guid: ");
      ((StringBuilder)localObject).append(this.m.c);
      ((StringBuilder)localObject).append(" mSharkfin.ext1: ");
      ((StringBuilder)localObject).append(this.m.d);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ocean]info: guid|");
      ((StringBuilder)localObject).append(this.m.c);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ocean]info: SdKy: sessionId|");
      ((StringBuilder)localObject).append(this.m.e);
      ((StringBuilder)localObject).append("|encodeKey|");
      ((StringBuilder)localObject).append(paraml.b);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ocean]info: guid|");
      ((StringBuilder)localObject).append(this.m.c);
      ((StringBuilder)localObject).append("|sessionId|");
      ((StringBuilder)localObject).append(this.m.e);
      ((StringBuilder)localObject).append("|encodeKey|");
      ((StringBuilder)localObject).append(paraml.b);
      ((StringBuilder)localObject).toString();
    }
    return this.m;
  }
  
  private a.e.c a(String paramString)
  {
    int n = this.h.a().a();
    int i1 = this.h.a().b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCSIPListResultToSend() hash: ");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" hashSeqNo: ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCSIPListResultToSend() hash: ");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" hashSeqNo: ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).toString();
    if (n == 0) {
      return null;
    }
    this.h.a().a(0, 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCSIPListResultToSend() encodeKey: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCSIPListResultToSend() encodeKey: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).toString();
    localObject = new a.a.a();
    ((a.a.a)localObject).a = n;
    a.e.c localc = new a.e.c();
    localc.b = 0;
    localc.c = i1;
    localc.a = 151;
    localc.d = b.a(this.d, paramString.getBytes(), (JceStruct)localObject);
    return localc;
  }
  
  private a.e.d a(boolean paramBoolean1, boolean paramBoolean2, l paraml, ArrayList paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    while (n < i1)
    {
      a.e.f localf = (a.e.f)paramArrayList.get(n);
      if ((localf != null) && (paramInt == localf.a)) {
        return localf;
      }
      n += 1;
    }
    return null;
  }
  
  private ArrayList a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i2 = -1;
    int i3 = paramArrayList.size();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleServerSashimiList()  retList.size(): ");
    ((StringBuilder)localObject).append(paramArrayList.size());
    ((StringBuilder)localObject).append(" noCheckIpList: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleServerSashimiList()  retList.size(): ");
    ((StringBuilder)localObject).append(paramArrayList.size());
    ((StringBuilder)localObject).append(" noCheckIpList: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).toString();
    int n = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (n >= i3) {
        break;
      }
      localObject = (a.e.f)paramArrayList.get(n);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleServerSashimiList() rs.seqNo: ");
        localStringBuilder.append(((a.e.f)localObject).b);
        localStringBuilder.append(" rs.cmd: ");
        localStringBuilder.append(((a.e.f)localObject).a);
        localStringBuilder.append(" rs.retCode: ");
        localStringBuilder.append(((a.e.f)localObject).d);
        localStringBuilder.append(" rs.dataRetCode: ");
        localStringBuilder.append(((a.e.f)localObject).e);
        localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleServerSashimiList() rs.seqNo: ");
        localStringBuilder.append(((a.e.f)localObject).b);
        localStringBuilder.append(" rs.cmd: ");
        localStringBuilder.append(((a.e.f)localObject).a);
        localStringBuilder.append(" rs.retCode: ");
        localStringBuilder.append(((a.e.f)localObject).d);
        localStringBuilder.append(" rs.dataRetCode: ");
        localStringBuilder.append(((a.e.f)localObject).e);
        localStringBuilder.toString();
        if (((a.e.f)localObject).f != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleServerSashimiList()  rs.data.length: ");
          localStringBuilder.append(((a.e.f)localObject).f.length);
          localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleServerSashimiList()  rs.data.length: ");
          localStringBuilder.append(((a.e.f)localObject).f.length);
          localStringBuilder.toString();
        }
        if ((!paramBoolean) && (a((a.e.f)localObject)))
        {
          i1 = n;
          break;
        }
      }
      n += 1;
    }
    if (i1 < 0) {
      return paramArrayList;
    }
    paramArrayList.remove(i1);
    return paramArrayList;
  }
  
  private void a(ArrayList paramArrayList, l paraml1, l paraml2)
  {
    if ((paramArrayList != null) && (paraml1 != null) && (paraml2 != null) && (!TextUtils.isEmpty(paraml2.a)))
    {
      if (TextUtils.isEmpty(paraml2.b)) {
        return;
      }
      int n = paramArrayList.size();
      if (n <= 0) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[ocean]info: RKey:  oldRsaKey: ");
      ((StringBuilder)localObject1).append(paraml1);
      ((StringBuilder)localObject1).append(" newRsaKey: ");
      ((StringBuilder)localObject1).append(paraml2);
      ((StringBuilder)localObject1).toString();
      n -= 1;
      while (n >= 0)
      {
        localObject1 = (a.e.c)paramArrayList.get(n);
        if ((localObject1 != null) && (((a.e.c)localObject1).d != null) && (((a.e.c)localObject1).d.length > 0))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[ocean]info: RKey: ECmd: ");
          ((StringBuilder)localObject2).append(((a.e.c)localObject1).a);
          ((StringBuilder)localObject2).toString();
          localObject2 = b.b(this.d, paraml1.b.getBytes(), ((a.e.c)localObject1).d);
          if (localObject2 == null)
          {
            paramArrayList.remove(n);
          }
          else
          {
            localObject2 = b.a(this.d, paraml2.b.getBytes(), (byte[])localObject2);
            if (localObject2 == null) {
              paramArrayList.remove(n);
            } else {
              ((a.e.c)localObject1).d = ((byte[])localObject2);
            }
          }
        }
        n -= 1;
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    int n;
    if ((paramBoolean) && (paramArrayList1 != null))
    {
      int i3 = paramArrayList1.size();
      n = 0;
      while (n < i3)
      {
        a.e.c localc = (a.e.c)paramArrayList1.get(n);
        if (localc != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[ocean]info: Used: sessionId|");
          if (paraml != null) {
            localObject = paraml.a;
          } else {
            localObject = "";
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("|encodeKey|");
          if (paraml != null) {
            localObject = paraml.b;
          } else {
            localObject = "";
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.toString();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[ocean]send: ECmd|");
          ((StringBuilder)localObject).append(localc.a);
          ((StringBuilder)localObject).append("|seqNo|");
          ((StringBuilder)localObject).append(localc.b);
          ((StringBuilder)localObject).append("|refSeqNo|");
          ((StringBuilder)localObject).append(localc.c);
          ((StringBuilder)localObject).append("|ret|");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("|ident|");
          ((StringBuilder)localObject).append(localc.e);
          ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[ocean]send: ECmd|");
          ((StringBuilder)localObject).append(localc.a);
          ((StringBuilder)localObject).append("|seqNo|");
          ((StringBuilder)localObject).append(localc.b);
          ((StringBuilder)localObject).append("|refSeqNo|");
          ((StringBuilder)localObject).append(localc.c);
          ((StringBuilder)localObject).append("|ret|");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("|ident|");
          ((StringBuilder)localObject).append(localc.e);
          ((StringBuilder)localObject).toString();
        }
        n += 1;
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
      if (paraml != null)
      {
        if ((paramInt == 0) && (paraml.d == 0) && (paraml.e == 0))
        {
          paramArrayList1 = new StringBuilder();
          paramArrayList1.append("[ocean]recv: ECmd|");
          paramArrayList1.append(paraml.a);
          paramArrayList1.append("|seqNo|");
          paramArrayList1.append(paraml.b);
          paramArrayList1.append("|refSeqNo|");
          paramArrayList1.append(paraml.c);
          paramArrayList1.append("|ret|");
          paramArrayList1.append(paramInt);
          paramArrayList1.append("|retCode|");
          paramArrayList1.append(paraml.d);
          paramArrayList1.append("|dataRetCode|");
          paramArrayList1.append(paraml.e);
          paramArrayList1.toString();
        }
        else
        {
          paramArrayList1 = new StringBuilder();
          paramArrayList1.append("[ocean]recv: ECmd|");
          paramArrayList1.append(paraml.a);
          paramArrayList1.append("|seqNo|");
          paramArrayList1.append(paraml.b);
          paramArrayList1.append("|refSeqNo|");
          paramArrayList1.append(paraml.c);
          paramArrayList1.append("|ret|");
          paramArrayList1.append(paramInt);
          paramArrayList1.append("|retCode|");
          paramArrayList1.append(paraml.d);
          paramArrayList1.append("|dataRetCode|");
          paramArrayList1.append(paraml.e);
          paramArrayList1.toString();
        }
        paramArrayList1 = new StringBuilder();
        paramArrayList1.append("[ocean]recv: ECmd|");
        paramArrayList1.append(paraml.a);
        paramArrayList1.append("|seqNo|");
        paramArrayList1.append(paraml.b);
        paramArrayList1.append("|refSeqNo|");
        paramArrayList1.append(paraml.c);
        paramArrayList1.append("|ret|");
        paramArrayList1.append(paramInt);
        paramArrayList1.append("|retCode|");
        paramArrayList1.append(paraml.d);
        paramArrayList1.append("|dataRetCode|");
        paramArrayList1.append(paraml.e);
        paramArrayList1.toString();
      }
      n += 1;
      continue;
      if ((!paramBoolean) && (paramArrayList1 != null))
      {
        i1 = paramArrayList1.size();
        n = i2;
        while (n < i1)
        {
          paraml = (a.e.c)paramArrayList1.get(n);
          if (paraml != null)
          {
            paramArrayList2 = new StringBuilder();
            paramArrayList2.append("[ocean]recv: ECmd|");
            paramArrayList2.append(paraml.a + 10000);
            paramArrayList2.append("|ret|");
            paramArrayList2.append(paramInt);
            paramArrayList2.toString();
            paramArrayList2 = new StringBuilder();
            paramArrayList2.append("[ocean]recv: ECmd|");
            paramArrayList2.append(paraml.a + 10000);
            paramArrayList2.append("|ret|");
            paramArrayList2.append(paramInt);
            paramArrayList2.toString();
          }
          n += 1;
        }
      }
    }
  }
  
  private boolean a(a.e.f paramf)
  {
    int n;
    if (10150 == paramf.a) {
      n = 1;
    } else {
      n = 0;
    }
    if (n == 0) {
      return false;
    }
    if (paramf.f == null) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIpList() respSashimi.seqNo: ");
    ((StringBuilder)localObject).append(paramf.b);
    ((StringBuilder)localObject).append(" respSashimi.refSeqNo: ");
    ((StringBuilder)localObject).append(paramf.c);
    ((StringBuilder)localObject).append(" respSashimi.cmd: ");
    ((StringBuilder)localObject).append(paramf.a);
    ((StringBuilder)localObject).append(" respSashimi.retCode: ");
    ((StringBuilder)localObject).append(paramf.d);
    ((StringBuilder)localObject).append(" respSashimi.dataRetCode: ");
    ((StringBuilder)localObject).append(paramf.e);
    ((StringBuilder)localObject).append(" respSashimi.data.length: ");
    ((StringBuilder)localObject).append(paramf.f.length);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIpList() respSashimi.seqNo: ");
    ((StringBuilder)localObject).append(paramf.b);
    ((StringBuilder)localObject).append(" respSashimi.refSeqNo: ");
    ((StringBuilder)localObject).append(paramf.c);
    ((StringBuilder)localObject).append(" respSashimi.cmd: ");
    ((StringBuilder)localObject).append(paramf.a);
    ((StringBuilder)localObject).append(" respSashimi.retCode: ");
    ((StringBuilder)localObject).append(paramf.d);
    ((StringBuilder)localObject).append(" respSashimi.dataRetCode: ");
    ((StringBuilder)localObject).append(paramf.e);
    ((StringBuilder)localObject).append(" respSashimi.data.length: ");
    ((StringBuilder)localObject).append(paramf.f.length);
    ((StringBuilder)localObject).toString();
    if (paramf.d != 0) {
      return true;
    }
    if (paramf.e != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ");
      ((StringBuilder)localObject).append(paramf.e);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ");
      ((StringBuilder)localObject).append(paramf.e);
      ((StringBuilder)localObject).toString();
      return true;
    }
    if (paramf.f == null) {
      return true;
    }
    localObject = new a.a.c();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doSend() isReqRSA: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" isReqRegistGuid: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" isReqUpdateRegist: ");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append(" rsaKey: ");
    ((StringBuilder)localObject).append(paraml);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doSend() isReqRSA: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" isReqRegistGuid: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" isReqUpdateRegist: ");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append(" rsaKey: ");
    ((StringBuilder)localObject).append(paraml);
    ((StringBuilder)localObject).toString();
    localObject = paraml;
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
    paraml = new StringBuilder();
    paraml.append("doSend() reqSashimiList.size(): ");
    paraml.append(paramArrayList.size());
    paraml.toString();
    paraml = new StringBuilder();
    paraml.append("doSend() reqSashimiList.size(): ");
    paraml.append(paramArrayList.size());
    paraml.toString();
    if (paramArrayList.size() <= 0) {
      return -10;
    }
    paraml = h.a(a(paramBoolean1, true, (l)localObject, paramArrayList));
    paramArrayList = new StringBuilder();
    paramArrayList.append("doSend() sendData.length: ");
    paramArrayList.append(paraml.length);
    paramArrayList.toString();
    paramArrayList = new StringBuilder();
    paramArrayList.append("doSend() sendData.length: ");
    paramArrayList.append(paraml.length);
    paramArrayList.toString();
    paramArrayList = new AtomicReference();
    int n = this.h.a(paraml, paramArrayList);
    if (-160000 == n)
    {
      n = a(n);
      paraml = new StringBuilder();
      paraml.append("doSend() ESharkCode.ERR_NEED_WIFIAPPROVEMENT == ret, doneRet: ");
      paraml.append(n);
      paraml.toString();
      paraml = new StringBuilder();
      paraml.append("doSend() ESharkCode.ERR_NEED_WIFIAPPROVEMENT == ret, doneRet: ");
      paraml.append(n);
      paraml.toString();
      return n;
    }
    if (n != 0)
    {
      n = a(n);
      paraml = new StringBuilder();
      paraml.append("doSend() ESharkCode.ERR_NONE != ret, doneRet: ");
      paraml.append(n);
      paraml.toString();
      paraml = new StringBuilder();
      paraml.append("doSend() ESharkCode.ERR_NONE != ret, doneRet: ");
      paraml.append(n);
      paraml.toString();
      return n;
    }
    paraml = (byte[])paramArrayList.get();
    if (paraml == null) {
      return -5;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("doSend() retData.length: ");
    paramArrayList.append(paraml.length);
    paramArrayList.toString();
    paramArrayList = new StringBuilder();
    paramArrayList.append("doSend() retData.length: ");
    paramArrayList.append(paraml.length);
    paramArrayList.toString();
    try
    {
      paraml = h.a(paraml);
      if (paraml == null) {
        return -5;
      }
      paraml = (a.e.g)paraml;
      paramArrayList = paraml.c;
      if (paramArrayList == null) {
        return -5;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doSend() retShark.seqNo: ");
      ((StringBuilder)localObject).append(paraml.a);
      ((StringBuilder)localObject).append(" respSashimiList.size(): ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doSend() retShark.seqNo: ");
      ((StringBuilder)localObject).append(paraml.a);
      ((StringBuilder)localObject).append(" respSashimiList.size(): ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).toString();
      paramAtomicReference.set(paramArrayList);
      return 0;
    }
    catch (Exception paraml)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("doSend() e: ");
      paramArrayList.append(paraml.toString());
      paramArrayList.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("doSend() e: ");
      paramArrayList.append(paraml.toString());
      paramArrayList.toString();
    }
    return -5;
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
    int n;
    if (2 == paramArrayList.d) {
      n = 1;
    } else {
      n = 0;
    }
    if (n == 0) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkRsa() ERC_EXPIRE retCode: ");
    localStringBuilder.append(paramArrayList.d);
    localStringBuilder.append(" dataRetCode: ");
    localStringBuilder.append(paramArrayList.e);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkRsa() ERC_EXPIRE retCode: ");
    localStringBuilder.append(paramArrayList.d);
    localStringBuilder.append(" dataRetCode: ");
    localStringBuilder.append(paramArrayList.e);
    localStringBuilder.toString();
    return true;
  }
  
  private void c(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if (paramArrayList.size() <= 0) {
      return;
    }
    paramArrayList = a(paramArrayList, 10151);
    if (paramArrayList == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkCSIPListResult() rs.seqNo: ");
    ((StringBuilder)localObject).append(paramArrayList.b);
    ((StringBuilder)localObject).append(" rs.cmd: ");
    ((StringBuilder)localObject).append(paramArrayList.a);
    ((StringBuilder)localObject).append(" rs.retCode: ");
    ((StringBuilder)localObject).append(paramArrayList.d);
    ((StringBuilder)localObject).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject).append(paramArrayList.e);
    ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkCSIPListResult() rs.seqNo: ");
    ((StringBuilder)localObject).append(paramArrayList.b);
    ((StringBuilder)localObject).append(" rs.cmd: ");
    ((StringBuilder)localObject).append(paramArrayList.a);
    ((StringBuilder)localObject).append(" rs.retCode: ");
    ((StringBuilder)localObject).append(paramArrayList.d);
    ((StringBuilder)localObject).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject).append(paramArrayList.e);
    ((StringBuilder)localObject).toString();
    if (1 == paramArrayList.d) {
      return;
    }
    if (paramArrayList.e != 0) {
      return;
    }
    localObject = paramArrayList.f;
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkCSIPListResult() rs.data.length: ");
    localStringBuilder.append(paramArrayList.f.length);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkCSIPListResult() rs.data.length: ");
    localStringBuilder.append(paramArrayList.f.length);
    localStringBuilder.toString();
    paramArrayList = new a.a.d();
    try
    {
      paramArrayList = b.a(this.d, b().b.getBytes(), (byte[])localObject, paramArrayList);
      if (paramArrayList == null) {
        return;
      }
      paramArrayList = (a.a.d)paramArrayList;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkCSIPListResult() ipList反馈成功, ret.hash: ");
      ((StringBuilder)localObject).append(paramArrayList.a);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkCSIPListResult() ipList反馈成功, ret.hash: ");
      ((StringBuilder)localObject).append(paramArrayList.a);
      ((StringBuilder)localObject).toString();
      return;
    }
    catch (Exception paramArrayList) {}
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
    if (!this.j.a()) {
      return true;
    }
    int n = a(null, new ArrayList(), new AtomicReference());
    if (-10 != n)
    {
      if (n == 0) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDoRegist() 首次注册失败，ret: ");
      localStringBuilder.append(n);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDoRegist() 首次注册失败，ret: ");
      localStringBuilder.append(n);
      localStringBuilder.toString();
      return false;
    }
    return true;
  }
  
  private int g()
  {
    if (!tmsdk.common.c.a.c.f)
    {
      tmsdk.common.c.a.c.f = false;
      tmsdk.common.c.a.c.a(this.d);
    }
    if (3 == tmsdk.common.c.a.c.g) {
      return 1;
    }
    switch (tmsdk.common.c.a.c.i)
    {
    default: 
      return 0;
    case 8: 
      return 10;
    case 7: 
      return 9;
    case 6: 
      return 8;
    case 5: 
      return 7;
    case 4: 
      return 6;
    case 3: 
      return 5;
    case 2: 
      return 4;
    case 1: 
      return 3;
    }
    return 2;
  }
  
  private int h()
  {
    switch ()
    {
    default: 
      return 0;
    case 2: 
      return 2;
    case 1: 
      return 1;
    }
    return 0;
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
        if (localObject1 != null)
        {
          paramArrayList.add(localObject1);
          bool1 = true;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("send() isReqIpListResult: ");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("send() isReqIpListResult: ");
          ((StringBuilder)localObject1).append(bool1);
          ((StringBuilder)localObject1).toString();
          AtomicReference localAtomicReference = new AtomicReference();
          a(true, paraml, paramArrayList, null, 0);
          int n = b(paramBoolean1, paramBoolean2, paramBoolean3, paraml, paramArrayList, localAtomicReference);
          if (n != 0)
          {
            a(false, null, paramArrayList, (ArrayList)localAtomicReference.get(), n);
            paraml = this.e;
            return n;
          }
          localObject1 = a((ArrayList)localAtomicReference.get(), bool1);
          boolean bool2 = b((ArrayList)localObject1);
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("send() 密钥是否过期：");
          ((StringBuilder)localObject3).append(bool2);
          ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("send() 密钥是否过期：");
          ((StringBuilder)localObject3).append(bool2);
          ((StringBuilder)localObject3).toString();
          if ((paramBoolean1) || (!bool2)) {
            break label415;
          }
          localObject3 = new AtomicReference();
          bool2 = this.i.a((AtomicReference)localObject3);
          if ((paramBoolean1) || (!bool2)) {
            break label415;
          }
          n = b(false, paramBoolean2, paramBoolean3, paraml, paramArrayList, localAtomicReference);
          paraml = a((ArrayList)localAtomicReference.get(), bool1);
          a(false, null, paramArrayList, (ArrayList)localAtomicReference.get(), n);
          paramAtomicReference.set(paraml);
          paramArrayList = this.e;
          if (bool1) {
            c(paraml);
          }
          return n;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label415:
      paraml = (l)localObject1;
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
    if (!this.j.a()) {
      return;
    }
    if (!e()) {
      return;
    }
    com.tencent.token.f.a().b(new p(this), "checkDoRegist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.o
 * JD-Core Version:    0.7.0.1
 */