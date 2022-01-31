package com.tencent.component.network.module.common.a;

import com.tencent.component.network.downloader.impl.ipc.Const;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public final class h
{
  private d a;
  private int[] b = new int[4];
  private int c;
  private int d;
  private ArrayList[] e;
  private long f = 0L;
  private String g = "";
  private byte[] h = new byte[64];
  private StringBuilder i = new StringBuilder();
  
  public h(d paramd, String paramString)
    throws j, UnknownHostException, Exception
  {
    this.a = paramd;
    this.g = paramString;
    this.e = new ArrayList[4];
    d();
    paramd = Integer.toBinaryString(this.d);
    if (paramd.length() < 4) {
      throw new Exception("exception cause [FBS - " + paramd + "]");
    }
    paramd = paramd.substring(paramd.length() - 4);
    if (paramd.equals("0011")) {
      throw new UnknownHostException("Unable to resolve host \"" + this.g + "\": No address associated with hostname");
    }
    if (!paramd.equals("0000")) {
      throw new Exception("exception cause [RCODE - " + paramd + "][HOST - " + this.g + "]");
    }
    e();
  }
  
  private void d()
    throws j
  {
    this.c = this.a.e();
    this.d = this.a.e();
    int j = 0;
    for (;;)
    {
      if (j >= this.b.length) {
        return;
      }
      this.b[j] = this.a.e();
      j += 1;
    }
  }
  
  private void e()
    throws j
  {
    int j = 0;
    if (j >= 2) {
      return;
    }
    label231:
    label245:
    label250:
    for (;;)
    {
      int m;
      try
      {
        m = this.b[j];
        if (m <= 0) {
          break label231;
        }
        this.e[j] = new ArrayList(m);
      }
      catch (j localj)
      {
        a locala;
        long l;
        throw localj;
      }
      locala = new a();
      int k;
      if (j == 0)
      {
        locala.a = f();
        locala.c = this.a.e();
        this.a.e();
        this.e[j].add(locala);
      }
      else
      {
        f();
        locala.a = this.g;
        locala.c = this.a.e();
        this.a.e();
        locala.d = this.a.f();
        this.a.a(this.a.e());
        locala.b = this.a.g();
        if (locala.c == 1)
        {
          l = locala.d;
          if ((this.f == 0L) && (l > 0L)) {
            this.f = (l * 1000L + System.currentTimeMillis());
          }
          this.e[j].add(locala);
          break label245;
          k = 0;
        }
      }
      for (;;)
      {
        if (k < m) {
          break label250;
        }
        j += 1;
        break;
        k += 1;
      }
    }
  }
  
  private String f()
    throws j
  {
    int k = 0;
    int j;
    if (this.i.length() > 0)
    {
      this.i.delete(0, this.i.length());
      j = 0;
    }
    for (;;)
    {
      if (j != 0)
      {
        if (k != 0) {
          this.a.c();
        }
        if (this.i.length() > 0) {
          this.i.deleteCharAt(this.i.length() - 1);
        }
        return this.i.toString();
      }
      int m = this.a.d();
      switch (m & 0xC0)
      {
      default: 
        throw new j("bad label type");
      case 0: 
        if (m == 0)
        {
          j = 1;
        }
        else
        {
          this.a.a(this.h, m);
          this.i.append(c.a(this.h, m));
          this.i.append(".");
        }
        break;
      case 192: 
        int n = ((m & 0xFFFFFF3F) << 8) + this.a.d();
        if (n >= this.a.a() - 2) {
          throw new j("bad compression");
        }
        m = k;
        if (k == 0)
        {
          this.a.b();
          m = 1;
        }
        this.a.b(n);
        k = m;
        continue;
        j = 0;
      }
    }
  }
  
  public final InetAddress[] a()
  {
    if ((this.e[1] != null) && (this.e[1].size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j >= this.e[1].size()) {
          return (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
        }
        Object localObject = (a)this.e[1].get(j);
        try
        {
          localObject = InetAddress.getByAddress(((a)localObject).a, ((a)localObject).b);
          if ((localObject != null) && (((InetAddress)localObject).getHostName() != null) && (!((InetAddress)localObject).getHostName().equals(((InetAddress)localObject).getHostAddress()))) {
            localArrayList.add(localObject);
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            Const.d("ResponsePacket", "getByAddress>>>", localUnknownHostException);
          }
        }
        j += 1;
      }
    }
    return null;
  }
  
  public final long b()
  {
    return this.f;
  }
  
  public final int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.h
 * JD-Core Version:    0.7.0.1
 */