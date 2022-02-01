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
  private a jv;
  private cb me;
  private di mf;
  private dp mg;
  
  public df(boolean paramBoolean1, Context paramContext, cl paramcl, boolean paramBoolean2, a parama, di.d paramd, cy.d paramd1, cy paramcy, String paramString)
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
      return;
    }
    if (cx.ay())
    {
      this.mg = new cg(paramContext, paramBoolean2, paramcl, paramString);
      this.me = new cb(paramContext, paramcl, this.mg, this.hi);
    }
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
        if (localas != null)
        {
          cv localcv = cv.by();
          int k = localas.bM;
          int m = localas.dc;
          String str;
          if (paramInt3 > 0) {
            str = String.format("%d/%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(j) });
          } else {
            str = null;
          }
          localcv.a("SharkWharf", k, m, localas, paramInt1, paramInt2, str);
        }
        i += 1;
      }
    }
  }
  
  public void a(final cy.f paramf, int paramInt)
  {
    boolean bool = true;
    if (paramf == null)
    {
      localObject = new StringBuilder("onSendTcpFailed() sharkSend is null? ");
      if (paramf != null) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      eh.h("SharkWharf", ((StringBuilder)localObject).toString());
      return;
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
    this.me.a(paramf, (byte[])localObject, new ca.a()
    {
      public final void a(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
      {
        int i = paramAnonymousInt;
        if (paramAnonymousInt != 0) {
          i = paramAnonymousInt - 42000000;
        }
        eh.e("SharkWharf", "onSendTcpFailed(), retry with http, http errCode: ".concat(String.valueOf(i)));
        df.a(paramf, 16, i, 0);
        df.a(df.this).a(false, i, paramAnonymousArrayOfByte, paramf);
      }
    });
  }
  
  public di bJ()
  {
    if (this.gW) {
      return this.mf;
    }
    throw new RuntimeException("getTmsTcpManager(), not in sending process!");
  }
  
  public dp cq()
  {
    return this.mg;
  }
  
  public void d(final cy.f paramf)
  {
    for (;;)
    {
      try
      {
        if ((!this.gW) && (!cx.ay())) {
          throw new RuntimeException("sendData(), not in sending or semiSending process!");
        }
        if (paramf == null)
        {
          eh.h("SharkWharf", "sendData(), sharkSend is null");
          return;
        }
        Object localObject;
        if ((paramf.jT != null) && (paramf.jT.size() > 0))
        {
          localObject = paramf.jT.iterator();
          i = 0;
          if (((Iterator)localObject).hasNext())
          {
            as localas = (as)((Iterator)localObject).next();
            StringBuilder localStringBuilder = new StringBuilder("[");
            localStringBuilder.append(i);
            localStringBuilder.append("]发包：cmd id:[");
            localStringBuilder.append(localas.bM);
            localStringBuilder.append("]seqNo:[");
            localStringBuilder.append(localas.dc);
            localStringBuilder.append("]refSeqNo:[");
            localStringBuilder.append(localas.dd);
            localStringBuilder.append("]retCode:[");
            localStringBuilder.append(localas.df);
            localStringBuilder.append("]dataRetCode:[");
            localStringBuilder.append(localas.dg);
            localStringBuilder.append("]");
            eh.f("SharkWharf_CMDID", localStringBuilder.toString());
            i += 1;
            continue;
          }
        }
        int j;
        if (paramf.bQ())
        {
          if (paramf.jO)
          {
            eh.g("SharkWharf", "[tcp_control][http_control]sendData(), cloudcmd not allow tcp and this is tcp vip, failed!");
            this.jv.b(true, -30000007, paramf);
            return;
          }
          j = 0;
        }
        else
        {
          if ((this.mf == null) || (this.mf.cu())) {
            break label646;
          }
          i = 1;
          if ((i == 0) || (paramf.jH == 1024)) {
            break label651;
          }
          bool1 = true;
          if ((cx.ay()) || (paramf.jH == 2048) || (paramf.jH == 512) || (paramf.jO)) {
            break label662;
          }
          if (!bool1) {
            break label657;
          }
          break label662;
          j = i;
          if (i != 0)
          {
            localObject = new StringBuilder("[tcp_control][http_control]sendData(), use http channel, for:  only http enable? false isSemiSendProcess? ");
            ((StringBuilder)localObject).append(cx.ay());
            ((StringBuilder)localObject).append(" user select CHANNEL_LARGE_DATA ? ");
            if (paramf.jH != 2048) {
              break label667;
            }
            bool2 = true;
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append(" user select ONLY_HTTP ? ");
            if (paramf.jH != 512) {
              break label673;
            }
            bool2 = true;
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append(" cloud cmd not allow tcp? ");
            ((StringBuilder)localObject).append(paramf.jO);
            ((StringBuilder)localObject).append(" prefer http? ");
            ((StringBuilder)localObject).append(bool1);
            eh.g("SharkWharf", ((StringBuilder)localObject).toString());
            j = i;
          }
        }
        if (j != 0)
        {
          eh.f("SharkWharf", "[tcp_control][http_control]sendData(), use http channel");
          paramf.jN = false;
          localObject = cd.a(paramf, false, this.hF.getGuid(), this.he);
          if (localObject == null)
          {
            eh.g("SharkWharf", "[tcp_control][http_control][shark_v4]sendData(), ConverterUtil.createSendBytes() return null!");
            return;
          }
          a(paramf, 15, 0, localObject.length);
          this.me.a(paramf, (byte[])localObject, new ca.a()
          {
            public final void a(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
            {
              int i = paramAnonymousInt;
              if (paramAnonymousInt != 0) {
                i = paramAnonymousInt - 42000000;
              }
              df.a(paramf, 16, i, 0);
              eh.e("SharkWharf", "[tcp_control][http_control]sendData(), http callback, errCode: ".concat(String.valueOf(i)));
              df.a(df.this).a(false, i, paramAnonymousArrayOfByte, paramf);
            }
          });
          return;
        }
        eh.f("SharkWharf", "[tcp_control][http_control]sendData(), use tcp channel");
        paramf.jN = true;
        if (paramf.jM)
        {
          this.mf.f(paramf);
          return;
        }
        if (paramf.bR())
        {
          this.mf.f(paramf);
          return;
        }
        this.mf.e(paramf);
        return;
      }
      finally {}
      label646:
      int i = 0;
      continue;
      label651:
      boolean bool1 = false;
      continue;
      label657:
      i = 0;
      continue;
      label662:
      i = 1;
      continue;
      label667:
      boolean bool2 = false;
      continue;
      label673:
      bool2 = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, cy.f paramf);
    
    public abstract void b(boolean paramBoolean, int paramInt, cy.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.df
 * JD-Core Version:    0.7.0.1
 */