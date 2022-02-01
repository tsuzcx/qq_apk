package com.tencent.token;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.tcc.TccCryptor;

public final class aqg
{
  public apy a;
  aqi b;
  public apf c;
  aqc d;
  public apu e;
  private final String f = "SharkNetwork";
  private final int g = 0;
  private final int h = 1;
  private Context i;
  private aqi j;
  private Object k = new Object();
  private String l = "";
  private ab m;
  
  public aqg(Context paramContext, apy paramapy)
  {
    this.i = paramContext;
    this.a = paramapy;
    this.b = new aqi();
    this.j = new aqi();
    this.c = new apf(paramContext, paramapy);
    this.d = new aqc(this);
    this.e = new apu(paramContext, this);
    int n = Process.myPid();
    paramContext = new StringBuilder();
    paramContext.append("b");
    paramContext.append(n);
    this.l = paramContext.toString();
    new StringBuilder("SharkNetwork() mExt: ").append(this.l);
  }
  
  private static int a()
  {
    if (!aoz.f)
    {
      aoz.f = false;
      aoz.a();
    }
    if (3 == aoz.g) {
      return 1;
    }
    switch (aoz.i)
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
  
  private static int a(int paramInt)
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
  
  private ab a(boolean paramBoolean, aqd paramaqd)
  {
    if (this.m == null) {
      this.m = new ab();
    }
    if (paramaqd != null) {
      localObject = paramaqd.a;
    } else {
      localObject = this.m.e;
    }
    ab localab = this.m;
    if (paramBoolean) {
      localObject = "";
    }
    localab.e = ((String)localObject);
    this.m.f = aos.a("build");
    this.m.a = a();
    Object localObject = this.m;
    ((ab)localObject).b = 0;
    ((ab)localObject).c = this.e.d();
    this.m.d = this.l;
    if (paramaqd != null)
    {
      localObject = new StringBuilder("checkSharkfin() rsaKeyCode: ");
      ((StringBuilder)localObject).append(paramaqd.hashCode());
      ((StringBuilder)localObject).append(" rsaKey: ");
      ((StringBuilder)localObject).append(paramaqd);
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
      localObject = new StringBuilder("checkSharkfin() rsaKeyCode: ");
      ((StringBuilder)localObject).append(paramaqd.hashCode());
      ((StringBuilder)localObject).append(" rsaKey: ");
      ((StringBuilder)localObject).append(paramaqd);
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
      new StringBuilder("[ocean]info: guid|").append(this.m.c);
      localObject = new StringBuilder("[ocean]info: SdKy: sessionId|");
      ((StringBuilder)localObject).append(this.m.e);
      ((StringBuilder)localObject).append("|encodeKey|");
      ((StringBuilder)localObject).append(paramaqd.b);
      localObject = new StringBuilder("[ocean]info: guid|");
      ((StringBuilder)localObject).append(this.m.c);
      ((StringBuilder)localObject).append("|sessionId|");
      ((StringBuilder)localObject).append(this.m.e);
      ((StringBuilder)localObject).append("|encodeKey|");
      ((StringBuilder)localObject).append(paramaqd.b);
    }
    return this.m;
  }
  
  private aj a(boolean paramBoolean1, boolean paramBoolean2, aqd paramaqd, ArrayList paramArrayList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private ArrayList a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return null;
    }
    int i3 = paramArrayList.size();
    Object localObject1 = new StringBuilder("handleServerSashimiList()  retList.size(): ");
    ((StringBuilder)localObject1).append(paramArrayList.size());
    ((StringBuilder)localObject1).append(" noCheckIpList: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    localObject1 = new StringBuilder("handleServerSashimiList()  retList.size(): ");
    ((StringBuilder)localObject1).append(paramArrayList.size());
    ((StringBuilder)localObject1).append(" noCheckIpList: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    int n = 0;
    while (n < i3)
    {
      localObject1 = (al)paramArrayList.get(n);
      Object localObject2;
      int i1;
      int i2;
      Object localObject3;
      int i4;
      int i5;
      ArrayList localArrayList;
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder("handleServerSashimiList() rs.seqNo: ");
        ((StringBuilder)localObject2).append(((al)localObject1).b);
        ((StringBuilder)localObject2).append(" rs.cmd: ");
        ((StringBuilder)localObject2).append(((al)localObject1).a);
        ((StringBuilder)localObject2).append(" rs.retCode: ");
        ((StringBuilder)localObject2).append(((al)localObject1).d);
        ((StringBuilder)localObject2).append(" rs.dataRetCode: ");
        ((StringBuilder)localObject2).append(((al)localObject1).e);
        localObject2 = new StringBuilder("handleServerSashimiList() rs.seqNo: ");
        ((StringBuilder)localObject2).append(((al)localObject1).b);
        ((StringBuilder)localObject2).append(" rs.cmd: ");
        ((StringBuilder)localObject2).append(((al)localObject1).a);
        ((StringBuilder)localObject2).append(" rs.retCode: ");
        ((StringBuilder)localObject2).append(((al)localObject1).d);
        ((StringBuilder)localObject2).append(" rs.dataRetCode: ");
        ((StringBuilder)localObject2).append(((al)localObject1).e);
        if (((al)localObject1).f != null)
        {
          new StringBuilder("handleServerSashimiList()  rs.data.length: ").append(((al)localObject1).f.length);
          new StringBuilder("handleServerSashimiList()  rs.data.length: ").append(((al)localObject1).f.length);
        }
        if (!paramBoolean)
        {
          i1 = ((al)localObject1).a;
          i2 = 1;
          if (10150 == i1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i1 == 0)
          {
            i1 = 0;
          }
          else if (((al)localObject1).f == null)
          {
            i1 = i2;
          }
          else
          {
            localObject2 = new StringBuilder("checkIpList() respSashimi.seqNo: ");
            ((StringBuilder)localObject2).append(((al)localObject1).b);
            ((StringBuilder)localObject2).append(" respSashimi.refSeqNo: ");
            ((StringBuilder)localObject2).append(((al)localObject1).c);
            ((StringBuilder)localObject2).append(" respSashimi.cmd: ");
            ((StringBuilder)localObject2).append(((al)localObject1).a);
            ((StringBuilder)localObject2).append(" respSashimi.retCode: ");
            ((StringBuilder)localObject2).append(((al)localObject1).d);
            ((StringBuilder)localObject2).append(" respSashimi.dataRetCode: ");
            ((StringBuilder)localObject2).append(((al)localObject1).e);
            ((StringBuilder)localObject2).append(" respSashimi.data.length: ");
            ((StringBuilder)localObject2).append(((al)localObject1).f.length);
            localObject2 = new StringBuilder("checkIpList() respSashimi.seqNo: ");
            ((StringBuilder)localObject2).append(((al)localObject1).b);
            ((StringBuilder)localObject2).append(" respSashimi.refSeqNo: ");
            ((StringBuilder)localObject2).append(((al)localObject1).c);
            ((StringBuilder)localObject2).append(" respSashimi.cmd: ");
            ((StringBuilder)localObject2).append(((al)localObject1).a);
            ((StringBuilder)localObject2).append(" respSashimi.retCode: ");
            ((StringBuilder)localObject2).append(((al)localObject1).d);
            ((StringBuilder)localObject2).append(" respSashimi.dataRetCode: ");
            ((StringBuilder)localObject2).append(((al)localObject1).e);
            ((StringBuilder)localObject2).append(" respSashimi.data.length: ");
            ((StringBuilder)localObject2).append(((al)localObject1).f.length);
            if (((al)localObject1).d != 0)
            {
              i1 = i2;
            }
            else if (((al)localObject1).e != 0)
            {
              new StringBuilder("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ").append(((al)localObject1).e);
              new StringBuilder("checkIpList() ESharkCode.ERR_NONE != respSashimi.dataRetCode, respSashimi.dataRetCode: ").append(((al)localObject1).e);
              i1 = i2;
            }
            else if (((al)localObject1).f == null)
            {
              i1 = i2;
            }
            else
            {
              localObject2 = new y();
              localObject2 = apt.a(this.d.b().b.getBytes(), ((al)localObject1).f, (JceStruct)localObject2);
              if (localObject2 == null)
              {
                i1 = i2;
              }
              else
              {
                localObject3 = (y)localObject2;
                localObject2 = this.c.a;
                i1 = ((y)localObject3).a;
                i4 = ((al)localObject1).b;
                i5 = ((y)localObject3).b;
                localObject1 = ((y)localObject3).c;
                localArrayList = ((y)localObject3).d;
                localObject3 = ((y)localObject3).e;
                ??? = new StringBuilder("handleNewIpList() hash: ");
                ((StringBuilder)???).append(i1);
                ((StringBuilder)???).append(" hashSeqNo: ");
                ((StringBuilder)???).append(i4);
                ((StringBuilder)???).append(" validperiod: ");
                ((StringBuilder)???).append(i5);
                ??? = new StringBuilder("handleNewIpList() hash: ");
                ((StringBuilder)???).append(i1);
                ((StringBuilder)???).append(" hashSeqNo: ");
                ((StringBuilder)???).append(i4);
                ((StringBuilder)???).append(" validperiod: ");
                ((StringBuilder)???).append(i5);
                aph.a("cmvips", (ArrayList)localObject1);
                aph.a("unvips", localArrayList);
                aph.a("ctvips", (ArrayList)localObject3);
              }
            }
          }
        }
      }
      synchronized (((aph)localObject2).f)
      {
        ((aph)localObject2).a(i1, i4);
        ((aph)localObject2).a((ArrayList)localObject1, localArrayList, (ArrayList)localObject3);
        ((aph)localObject2).e = (System.currentTimeMillis() + i5 * 1000);
        ((aph)localObject2).b.a(((aph)localObject2).e, (ArrayList)localObject1, localArrayList, (ArrayList)localObject3);
        ((aph)localObject2).a();
        i1 = i2;
        if (i1 == 0) {}
      }
    }
    n = -1;
    if (n < 0) {
      return paramArrayList;
    }
    paramArrayList.remove(n);
    return paramArrayList;
  }
  
  private static void a(ArrayList paramArrayList, aqd paramaqd1, aqd paramaqd2)
  {
    if ((paramArrayList != null) && (paramaqd1 != null) && (paramaqd2 != null) && (!TextUtils.isEmpty(paramaqd2.a)))
    {
      if (TextUtils.isEmpty(paramaqd2.b)) {
        return;
      }
      int n = paramArrayList.size();
      if (n <= 0) {
        return;
      }
      Object localObject = new StringBuilder("[ocean]info: RKey:  oldRsaKey: ");
      ((StringBuilder)localObject).append(paramaqd1);
      ((StringBuilder)localObject).append(" newRsaKey: ");
      ((StringBuilder)localObject).append(paramaqd2);
      n -= 1;
      while (n >= 0)
      {
        ai localai = (ai)paramArrayList.get(n);
        if ((localai != null) && (localai.d != null) && (localai.d.length > 0))
        {
          new StringBuilder("[ocean]info: RKey: ECmd: ").append(localai.a);
          byte[] arrayOfByte = apt.a(paramaqd1.b.getBytes(), localai.d);
          if (arrayOfByte == null)
          {
            paramArrayList.remove(n);
          }
          else
          {
            localObject = paramaqd2.b.getBytes();
            arrayOfByte = apt.a(arrayOfByte);
            if (arrayOfByte == null) {
              localObject = null;
            } else {
              localObject = TccCryptor.encrypt(arrayOfByte, (byte[])localObject);
            }
            if (localObject == null) {
              paramArrayList.remove(n);
            } else {
              localai.d = ((byte[])localObject);
            }
          }
        }
        n -= 1;
      }
      return;
    }
  }
  
  private static void a(boolean paramBoolean, aqd paramaqd, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
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
        ai localai = (ai)paramArrayList1.get(n);
        if (localai != null)
        {
          StringBuilder localStringBuilder = new StringBuilder("[ocean]info: Used: sessionId|");
          if (paramaqd != null) {
            localObject = paramaqd.a;
          } else {
            localObject = "";
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("|encodeKey|");
          if (paramaqd != null) {
            localObject = paramaqd.b;
          } else {
            localObject = "";
          }
          localStringBuilder.append((String)localObject);
          Object localObject = new StringBuilder("[ocean]send: ECmd|");
          ((StringBuilder)localObject).append(localai.a);
          ((StringBuilder)localObject).append("|seqNo|");
          ((StringBuilder)localObject).append(localai.b);
          ((StringBuilder)localObject).append("|refSeqNo|");
          ((StringBuilder)localObject).append(localai.c);
          ((StringBuilder)localObject).append("|ret|");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("|ident|");
          ((StringBuilder)localObject).append(localai.e);
          localObject = new StringBuilder("[ocean]send: ECmd|");
          ((StringBuilder)localObject).append(localai.a);
          ((StringBuilder)localObject).append("|seqNo|");
          ((StringBuilder)localObject).append(localai.b);
          ((StringBuilder)localObject).append("|refSeqNo|");
          ((StringBuilder)localObject).append(localai.c);
          ((StringBuilder)localObject).append("|ret|");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("|ident|");
          ((StringBuilder)localObject).append(localai.e);
        }
        n += 1;
      }
    }
    if ((!paramBoolean) && (paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      i2 = paramArrayList2.size();
      n = i1;
      while (n < i2)
      {
        paramaqd = (al)paramArrayList2.get(n);
        if (paramaqd != null)
        {
          if ((paramInt == 0) && (paramaqd.d == 0) && (paramaqd.e == 0))
          {
            paramArrayList1 = new StringBuilder("[ocean]recv: ECmd|");
            paramArrayList1.append(paramaqd.a);
            paramArrayList1.append("|seqNo|");
            paramArrayList1.append(paramaqd.b);
            paramArrayList1.append("|refSeqNo|");
            paramArrayList1.append(paramaqd.c);
            paramArrayList1.append("|ret|");
            paramArrayList1.append(paramInt);
            paramArrayList1.append("|retCode|");
            paramArrayList1.append(paramaqd.d);
            paramArrayList1.append("|dataRetCode|");
            paramArrayList1.append(paramaqd.e);
          }
          else
          {
            paramArrayList1 = new StringBuilder("[ocean]recv: ECmd|");
            paramArrayList1.append(paramaqd.a);
            paramArrayList1.append("|seqNo|");
            paramArrayList1.append(paramaqd.b);
            paramArrayList1.append("|refSeqNo|");
            paramArrayList1.append(paramaqd.c);
            paramArrayList1.append("|ret|");
            paramArrayList1.append(paramInt);
            paramArrayList1.append("|retCode|");
            paramArrayList1.append(paramaqd.d);
            paramArrayList1.append("|dataRetCode|");
            paramArrayList1.append(paramaqd.e);
          }
          paramArrayList1 = new StringBuilder("[ocean]recv: ECmd|");
          paramArrayList1.append(paramaqd.a);
          paramArrayList1.append("|seqNo|");
          paramArrayList1.append(paramaqd.b);
          paramArrayList1.append("|refSeqNo|");
          paramArrayList1.append(paramaqd.c);
          paramArrayList1.append("|ret|");
          paramArrayList1.append(paramInt);
          paramArrayList1.append("|retCode|");
          paramArrayList1.append(paramaqd.d);
          paramArrayList1.append("|dataRetCode|");
          paramArrayList1.append(paramaqd.e);
        }
        n += 1;
      }
      return;
    }
    if ((!paramBoolean) && (paramArrayList1 != null))
    {
      i1 = paramArrayList1.size();
      n = i2;
      while (n < i1)
      {
        paramaqd = (ai)paramArrayList1.get(n);
        if (paramaqd != null)
        {
          paramArrayList2 = new StringBuilder("[ocean]recv: ECmd|");
          paramArrayList2.append(paramaqd.a + 10000);
          paramArrayList2.append("|ret|");
          paramArrayList2.append(paramInt);
          paramArrayList2 = new StringBuilder("[ocean]recv: ECmd|");
          paramArrayList2.append(paramaqd.a + 10000);
          paramArrayList2.append("|ret|");
          paramArrayList2.append(paramInt);
        }
        n += 1;
      }
    }
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, aqd paramaqd, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    Object localObject = new StringBuilder("doSend() isReqRSA: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" isReqRegistGuid: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" isReqUpdateRegist: ");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append(" rsaKey: ");
    ((StringBuilder)localObject).append(paramaqd);
    localObject = new StringBuilder("doSend() isReqRSA: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" isReqRegistGuid: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" isReqUpdateRegist: ");
    ((StringBuilder)localObject).append(paramBoolean3);
    ((StringBuilder)localObject).append(" rsaKey: ");
    ((StringBuilder)localObject).append(paramaqd);
    localObject = paramaqd;
    if (!paramBoolean1)
    {
      localObject = this.d;
      if ((!TextUtils.isEmpty(((aqc)localObject).c())) && (!TextUtils.isEmpty(((aqc)localObject).a()))) {
        n = 0;
      } else {
        n = 1;
      }
      if (n != 0)
      {
        long l1 = System.currentTimeMillis();
        if (!apb.a(l1, ((aqc)localObject).a, 10))
        {
          n = -700;
          break label248;
        }
        ((aqc)localObject).a = l1;
        l1 = ((aqc)localObject).a;
        if (!((aqc)localObject).a(null))
        {
          n = -100;
          break label248;
        }
      }
      n = 0;
      label248:
      if (n != 0) {
        return n;
      }
      aqd localaqd = this.d.b();
      localObject = paramaqd;
      if (paramaqd != null) {
        if ((!TextUtils.isEmpty(paramaqd.a)) && (!TextUtils.isEmpty(paramaqd.b)))
        {
          if ((paramaqd != null) && (!TextUtils.isEmpty(paramaqd.a)) && (!TextUtils.isEmpty(paramaqd.b)) && (!TextUtils.isEmpty(localaqd.a)) && (!TextUtils.isEmpty(localaqd.b)) && ((!paramaqd.a.equals(localaqd.a)) || (!paramaqd.b.equals(localaqd.b)))) {
            n = 1;
          } else {
            n = 0;
          }
          localObject = paramaqd;
          if (n == 0) {}
        }
        else
        {
          a(paramArrayList, paramaqd, localaqd);
          localObject = localaqd;
        }
      }
    }
    if ((!paramBoolean1) && (!paramBoolean2) && (TextUtils.isEmpty(this.e.b()))) {
      return -200;
    }
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
      this.e.c();
    }
    if (paramArrayList == null) {
      return 0;
    }
    new StringBuilder("doSend() reqSashimiList.size(): ").append(paramArrayList.size());
    new StringBuilder("doSend() reqSashimiList.size(): ").append(paramArrayList.size());
    if (paramArrayList.size() <= 0) {
      return -10;
    }
    paramaqd = apz.a(a(paramBoolean1, true, (aqd)localObject, paramArrayList));
    new StringBuilder("doSend() sendData.length: ").append(paramaqd.length);
    new StringBuilder("doSend() sendData.length: ").append(paramaqd.length);
    paramArrayList = new AtomicReference();
    int n = this.c.a(paramaqd, paramArrayList);
    if (-160000 == n) {
      return a(n);
    }
    if (n != 0) {
      return a(n);
    }
    paramaqd = (byte[])paramArrayList.get();
    if (paramaqd == null) {
      return -5;
    }
    new StringBuilder("doSend() retData.length: ").append(paramaqd.length);
    new StringBuilder("doSend() retData.length: ").append(paramaqd.length);
    try
    {
      paramaqd = apz.a(paramaqd);
      if (paramaqd == null) {
        return -5;
      }
      paramaqd = (am)paramaqd;
      paramArrayList = paramaqd.c;
      if (paramArrayList == null) {
        return -5;
      }
      localObject = new StringBuilder("doSend() retShark.seqNo: ");
      ((StringBuilder)localObject).append(paramaqd.a);
      ((StringBuilder)localObject).append(" respSashimiList.size(): ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      localObject = new StringBuilder("doSend() retShark.seqNo: ");
      ((StringBuilder)localObject).append(paramaqd.a);
      ((StringBuilder)localObject).append(" respSashimiList.size(): ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      paramAtomicReference.set(paramArrayList);
      return 0;
    }
    catch (Exception paramaqd)
    {
      new StringBuilder("doSend() e: ").append(paramaqd.toString());
      new StringBuilder("doSend() e: ").append(paramaqd.toString());
    }
    return -5;
  }
  
  private static al b(ArrayList paramArrayList)
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
      al localal = (al)paramArrayList.get(n);
      if ((localal != null) && (10151 == localal.a)) {
        return localal;
      }
      n += 1;
    }
    return null;
  }
  
  public final int a(aqd paramaqd, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    if (!arp.d()) {
      return -2;
    }
    return a(false, false, false, paramaqd, paramArrayList, paramAtomicReference);
  }
  
  protected final int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, aqd paramaqd, ArrayList paramArrayList, AtomicReference paramAtomicReference)
  {
    Object localObject3 = this.k;
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3) && (paramaqd != null)) {}
    for (;;)
    {
      int i1;
      try
      {
        Object localObject2 = paramaqd.b;
        n = this.c.a.c;
        i1 = this.c.a.d;
        Object localObject1 = new StringBuilder("getCSIPListResultToSend() hash: ");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" hashSeqNo: ");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = new StringBuilder("getCSIPListResultToSend() hash: ");
        ((StringBuilder)localObject1).append(n);
        ((StringBuilder)localObject1).append(" hashSeqNo: ");
        ((StringBuilder)localObject1).append(i1);
        if (n == 0)
        {
          localObject1 = null;
        }
        else
        {
          this.c.a.a(0, 0);
          localObject4 = new w();
          ((w)localObject4).a = n;
          localObject1 = new ai();
          ((ai)localObject1).b = 0;
          ((ai)localObject1).c = i1;
          ((ai)localObject1).a = 151;
          ((ai)localObject1).d = apt.a(((String)localObject2).getBytes(), (JceStruct)localObject4);
        }
        if (localObject1 == null) {
          break label948;
        }
        paramArrayList.add(localObject1);
        bool1 = true;
        Object localObject4 = new AtomicReference();
        a(true, paramaqd, paramArrayList, null, 0);
        int i2 = b(paramBoolean1, paramBoolean2, paramBoolean3, paramaqd, paramArrayList, (AtomicReference)localObject4);
        if (i2 != 0)
        {
          a(false, null, paramArrayList, (ArrayList)((AtomicReference)localObject4).get(), i2);
          return i2;
        }
        localObject2 = a((ArrayList)((AtomicReference)localObject4).get(), bool1);
        if (localObject2 == null)
        {
          n = 0;
        }
        else if (((ArrayList)localObject2).size() > 1)
        {
          n = 0;
        }
        else
        {
          localObject1 = (al)((ArrayList)localObject2).get(0);
          if (localObject1 == null)
          {
            n = 0;
          }
          else
          {
            if (2 != ((al)localObject1).d) {
              break label954;
            }
            n = 1;
            break label957;
            StringBuilder localStringBuilder = new StringBuilder("checkRsa() ERC_EXPIRE retCode: ");
            localStringBuilder.append(((al)localObject1).d);
            localStringBuilder.append(" dataRetCode: ");
            localStringBuilder.append(((al)localObject1).e);
            localStringBuilder = new StringBuilder("checkRsa() ERC_EXPIRE retCode: ");
            localStringBuilder.append(((al)localObject1).d);
            localStringBuilder.append(" dataRetCode: ");
            localStringBuilder.append(((al)localObject1).e);
            n = 1;
          }
        }
        i1 = i2;
        localObject1 = localObject2;
        if (!paramBoolean1)
        {
          i1 = i2;
          localObject1 = localObject2;
          if (n != 0)
          {
            localObject1 = new AtomicReference();
            boolean bool2 = this.d.a((AtomicReference)localObject1);
            i1 = i2;
            localObject1 = localObject2;
            if (!paramBoolean1)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (bool2)
              {
                i1 = b(false, paramBoolean2, paramBoolean3, paramaqd, paramArrayList, (AtomicReference)localObject4);
                localObject1 = a((ArrayList)((AtomicReference)localObject4).get(), bool1);
              }
            }
          }
        }
        a(false, null, paramArrayList, (ArrayList)((AtomicReference)localObject4).get(), i1);
        paramAtomicReference.set(localObject1);
        if ((bool1) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          paramaqd = b((ArrayList)localObject1);
          if (paramaqd != null)
          {
            paramArrayList = new StringBuilder("checkCSIPListResult() rs.seqNo: ");
            paramArrayList.append(paramaqd.b);
            paramArrayList.append(" rs.cmd: ");
            paramArrayList.append(paramaqd.a);
            paramArrayList.append(" rs.retCode: ");
            paramArrayList.append(paramaqd.d);
            paramArrayList.append(" rs.dataRetCode: ");
            paramArrayList.append(paramaqd.e);
            paramArrayList = new StringBuilder("checkCSIPListResult() rs.seqNo: ");
            paramArrayList.append(paramaqd.b);
            paramArrayList.append(" rs.cmd: ");
            paramArrayList.append(paramaqd.a);
            paramArrayList.append(" rs.retCode: ");
            paramArrayList.append(paramaqd.d);
            paramArrayList.append(" rs.dataRetCode: ");
            paramArrayList.append(paramaqd.e);
            if ((1 != paramaqd.d) && (paramaqd.e == 0))
            {
              paramArrayList = paramaqd.f;
              if (paramArrayList != null)
              {
                new StringBuilder("checkCSIPListResult() rs.data.length: ").append(paramaqd.f.length);
                new StringBuilder("checkCSIPListResult() rs.data.length: ").append(paramaqd.f.length);
                paramaqd = new z();
              }
            }
          }
        }
      }
      finally {}
      try
      {
        paramaqd = apt.a(this.d.b().b.getBytes(), paramArrayList, paramaqd);
        if (paramaqd != null)
        {
          paramaqd = (z)paramaqd;
          new StringBuilder("checkCSIPListResult() ipList反馈成功, ret.hash: ").append(paramaqd.a);
          new StringBuilder("checkCSIPListResult() ipList反馈成功, ret.hash: ").append(paramaqd.a);
        }
      }
      catch (Exception paramaqd)
      {
        continue;
      }
      return i1;
      label948:
      boolean bool1 = false;
      continue;
      label954:
      int n = 0;
      label957:
      if (n == 0) {
        n = 0;
      }
    }
  }
  
  public final aj a(ArrayList paramArrayList)
  {
    int n;
    if (!this.e.a())
    {
      n = 1;
    }
    else
    {
      n = a(null, new ArrayList(), new AtomicReference());
      if ((-10 != n) && (n != 0)) {
        n = 0;
      } else {
        n = 1;
      }
    }
    if (n == 0) {
      return null;
    }
    return a(true, false, null, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqg
 * JD-Core Version:    0.7.0.1
 */