package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

public class dk
{
  private cy hF;
  private String mV = "";
  private boolean mW = false;
  
  public dk(Context paramContext, cy paramcy, boolean paramBoolean)
  {
    this.hF = paramcy;
    this.mV = this.hF.bL().aF();
  }
  
  private dj<Long, Integer, JceStruct> a(long paramLong, int paramInt, av paramav)
  {
    if (paramav == null) {
      return null;
    }
    if (paramav.dq == 0)
    {
      b(1, true);
      return null;
    }
    if (paramav.dq == 1) {
      b(1, false);
    }
    return null;
  }
  
  private boolean aY()
  {
    if (!cx.ax()) {
      return false;
    }
    return TextUtils.isEmpty(this.mV);
  }
  
  private aq c(int paramInt, boolean paramBoolean)
  {
    String str1 = this.hF.bL().aF();
    String str2 = this.hF.bL().aG();
    if (str1 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    String str3 = this.hF.bL().aO();
    if (str3 == null) {
      str3 = "";
    }
    if (paramBoolean) {}
    for (aq localaq = new aq();; localaq = new aq())
    {
      localaq.cZ = paramInt;
      localaq.da = str1;
      localaq.cS = str2;
      localaq.cT = str3;
      return localaq;
      if (aY()) {
        return null;
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (str1.equals(str2))) {
        break;
      }
    }
    return null;
  }
  
  private ao cz()
  {
    ao localao = new ao();
    String str = this.hF.bL().aG();
    if (str == null) {
      str = "";
    }
    localao.cS = str;
    str = this.hF.bL().aO();
    if (str == null) {
      str = "";
    }
    localao.cT = str;
    return localao;
  }
  
  public void av()
  {
    eh.f("VidCertifier", "[cu_vid]registerVidIfNeed()");
    if (!this.hF.bL().aD())
    {
      eh.g("VidCertifier", "[cu_vid]registerVidIfNeed(), not support vid, do nothing");
      return;
    }
    if (this.mW)
    {
      eh.f("VidCertifier", "[cu_vid]registerVidIfNeed(), registering, ignore");
      return;
    }
    if (!aY())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cu_vid]registerVidIfNeed(), not necessary, mVidFromPhone: ");
      localStringBuilder.append(this.mV);
      eh.f("VidCertifier", localStringBuilder.toString());
      return;
    }
    this.hF.bL().aE();
    this.mW = true;
    cx.bE().b(5006, cz(), new ax(), 0, new cj()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        StringBuilder localStringBuilder;
        if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0) && (paramAnonymousJceStruct != null))
        {
          paramAnonymousJceStruct = ((ax)paramAnonymousJceStruct).dr;
          if (!TextUtils.isEmpty(paramAnonymousJceStruct))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[cu_vid]registerVidIfNeed()-onFinish(), succ, vid: ");
            localStringBuilder.append(paramAnonymousJceStruct);
            eh.f("VidCertifier", localStringBuilder.toString());
            dk.a(dk.this, paramAnonymousJceStruct);
            dk.a(dk.this).bL().c(paramAnonymousJceStruct, true);
            dk.a(dk.this).bL().d(paramAnonymousJceStruct, true);
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[cu_vid]registerVidIfNeed()-onFinish(), seqNo: ");
            localStringBuilder.append(paramAnonymousInt1);
            localStringBuilder.append(", vid is empty: ");
            localStringBuilder.append(paramAnonymousJceStruct);
            eh.g("VidCertifier", localStringBuilder.toString());
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[cu_vid]registerVidIfNeed()-onFinish(), seqNo: ");
          localStringBuilder.append(paramAnonymousInt1);
          localStringBuilder.append(" retCode: ");
          localStringBuilder.append(paramAnonymousInt3);
          localStringBuilder.append(" dataRetCode: ");
          localStringBuilder.append(paramAnonymousInt4);
          localStringBuilder.append(" resp: ");
          localStringBuilder.append(paramAnonymousJceStruct);
          eh.g("VidCertifier", localStringBuilder.toString());
        }
        dk.a(dk.this, false);
      }
    }, 30000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (!this.hF.bL().aD()) {
      return;
    }
    aq localaq = c(paramInt, paramBoolean);
    if (localaq == null) {
      return;
    }
    cx.bE().b(5007, localaq, new ay(), 0, new cj()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
        {
          if (paramAnonymousJceStruct == null) {
            return;
          }
          paramAnonymousJceStruct = ((ay)paramAnonymousJceStruct).dr;
          if (!TextUtils.isEmpty(paramAnonymousJceStruct))
          {
            dk.a(dk.this, paramAnonymousJceStruct);
            dk.a(dk.this).bL().c(paramAnonymousJceStruct, false);
            dk.a(dk.this).bL().d(paramAnonymousJceStruct, false);
          }
        }
      }
    }, 30000L);
  }
  
  public void c(cy.d paramd)
  {
    cm local3 = new cm()
    {
      public dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousJceStruct == null)
        {
          eh.h("VidCertifier", "onRecvPush() null == push");
          return null;
        }
        if (paramAnonymousInt2 != 15020) {
          return null;
        }
        return dk.a(dk.this, paramAnonymousLong, paramAnonymousInt1, (av)paramAnonymousJceStruct);
      }
    };
    paramd.a(0L, 15020, new av(), 0, local3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dk
 * JD-Core Version:    0.7.0.1
 */