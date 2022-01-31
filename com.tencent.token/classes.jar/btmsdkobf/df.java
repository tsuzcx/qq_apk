package btmsdkobf;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

public class df
  implements co
{
  private boolean gW = false;
  private cy hF;
  private cl he;
  private boolean hi = false;
  private df.a jv;
  private cb me;
  private di mf;
  private dp mg;
  
  public df(boolean paramBoolean1, Context paramContext, cl paramcl, boolean paramBoolean2, df.a parama, di.d paramd, cy.d paramd1, cy paramcy, String paramString)
  {
    this.gW = paramBoolean1;
    this.jv = parama;
    this.he = paramcl;
    this.hF = paramcy;
    this.hi = paramBoolean2;
    if (this.gW)
    {
      this.mg = new cg(paramContext, paramBoolean2, paramcl, paramString);
      this.me = new cb(paramContext, paramcl, this.mg, this.hi);
      this.mf = new di(paramcl, this.mg, parama, paramd, this, paramd1, this.hF);
    }
    while (!cx.ay()) {
      return;
    }
    this.mg = new cg(paramContext, paramBoolean2, paramcl, paramString);
    this.me = new cb(paramContext, paramcl, this.mg, this.hi);
  }
  
  public static void a(cy.f paramf, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramf != null) && (paramf.jT != null))
    {
      int j = paramf.jT.size();
      int i = 0;
      while (i < j)
      {
        as localas = (as)paramf.jT.get(i);
        if (localas == null)
        {
          i += 1;
        }
        else
        {
          cv localcv = cv.by();
          int k = localas.bM;
          int m = localas.dc;
          if (paramInt3 > 0) {}
          for (String str = String.format("%d/%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(j) });; str = null)
          {
            localcv.a("SharkWharf", k, m, localas, paramInt1, paramInt2, str);
            break;
          }
        }
      }
    }
  }
  
  public void a(cy.f paramf, int paramInt)
  {
    boolean bool = true;
    if (paramf == null)
    {
      localObject = new StringBuilder().append("onSendTcpFailed() sharkSend is null? ");
      if (paramf == null) {}
      for (;;)
      {
        eh.h("SharkWharf", bool);
        return;
        bool = false;
      }
    }
    if (paramf.jH == 1024)
    {
      eh.h("SharkWharf", "onSendTcpFailed(), user set only use tcp, so really fail");
      this.jv.b(true, paramInt, paramf);
      return;
    }
    if (paramf.bQ())
    {
      eh.e("SharkWharf", "onSendTcpFailed(), isTcpVip, so really fail");
      this.jv.b(true, paramInt, paramf);
      return;
    }
    eh.f("SharkWharf", "onSendTcpFailed(), tcp通道发送失败，转http通道");
    paramf.jN = false;
    Object localObject = cd.a(paramf, false, this.hF.getGuid(), this.he);
    if (localObject == null)
    {
      eh.g("SharkWharf", "[tcp_control][http_control][shark_v4]onSendTcpFailed(), ConverterUtil.createSendBytes() return null!");
      return;
    }
    a(paramf, 15, 0, localObject.length);
    this.me.a(paramf, (byte[])localObject, new hv(this, paramf));
  }
  
  public di bJ()
  {
    if (!this.gW) {
      throw new RuntimeException("getTmsTcpManager(), not in sending process!");
    }
    return this.mf;
  }
  
  public dp cq()
  {
    return this.mg;
  }
  
  public void d(cy.f paramf)
  {
    boolean bool3 = false;
    try
    {
      if ((!this.gW) && (!cx.ay())) {
        throw new RuntimeException("sendData(), not in sending or semiSending process!");
      }
    }
    finally {}
    if (paramf == null) {
      eh.h("SharkWharf", "sendData(), sharkSend is null");
    }
    Object localObject;
    int i;
    for (;;)
    {
      return;
      if ((paramf.jT != null) && (paramf.jT.size() > 0))
      {
        localObject = paramf.jT.iterator();
        i = 0;
        while (((Iterator)localObject).hasNext())
        {
          as localas = (as)((Iterator)localObject).next();
          eh.f("SharkWharf_CMDID", "[" + i + "]发包：cmd id:[" + localas.bM + "]seqNo:[" + localas.dc + "]refSeqNo:[" + localas.dd + "]retCode:[" + localas.df + "]dataRetCode:[" + localas.dg + "]");
          i += 1;
        }
      }
      if (!paramf.bQ()) {
        break;
      }
      if (!paramf.jO) {
        break label575;
      }
      eh.g("SharkWharf", "[tcp_control][http_control]sendData(), cloudcmd not allow tcp and this is tcp vip, failed!");
      this.jv.b(true, -30000007, paramf);
    }
    label255:
    boolean bool1;
    label272:
    label313:
    int j;
    if ((this.mf != null) && (!this.mf.cu()))
    {
      i = 1;
      if ((i == 0) || (paramf.jH == 1024)) {
        break label590;
      }
      bool1 = true;
      if ((!cx.ay()) && (paramf.jH != 2048) && (paramf.jH != 512) && (!paramf.jO))
      {
        if (!bool1) {
          break label596;
        }
        break label580;
        j = i;
        if (i != 0)
        {
          localObject = new StringBuilder().append("[tcp_control][http_control]sendData(), use http channel, for:  only http enable? false isSemiSendProcess? ").append(cx.ay()).append(" user select CHANNEL_LARGE_DATA ? ");
          if (paramf.jH != 2048) {
            break label601;
          }
        }
      }
    }
    label575:
    label580:
    label590:
    label596:
    label601:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = ((StringBuilder)localObject).append(bool2).append(" user select ONLY_HTTP ? ");
      bool2 = bool3;
      if (paramf.jH == 512) {
        bool2 = true;
      }
      eh.g("SharkWharf", bool2 + " cloud cmd not allow tcp? " + paramf.jO + " prefer http? " + bool1);
      for (j = i;; j = 0)
      {
        if (j != 0)
        {
          eh.f("SharkWharf", "[tcp_control][http_control]sendData(), use http channel");
          paramf.jN = false;
          localObject = cd.a(paramf, false, this.hF.getGuid(), this.he);
          if (localObject == null)
          {
            eh.g("SharkWharf", "[tcp_control][http_control][shark_v4]sendData(), ConverterUtil.createSendBytes() return null!");
            break;
          }
          a(paramf, 15, 0, localObject.length);
          this.me.a(paramf, (byte[])localObject, new hu(this, paramf));
          break;
        }
        eh.f("SharkWharf", "[tcp_control][http_control]sendData(), use tcp channel");
        paramf.jN = true;
        if (paramf.jM)
        {
          this.mf.f(paramf);
          break;
        }
        if (paramf.bR())
        {
          this.mf.f(paramf);
          break;
        }
        this.mf.e(paramf);
        break;
      }
      i = 1;
      break label313;
      i = 0;
      break label255;
      bool1 = false;
      break label272;
      i = 0;
      break label313;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.df
 * JD-Core Version:    0.7.0.1
 */