package com.tencent.qqpimsecure.wificore.api.connect;

import java.util.HashMap;
import java.util.Map;

public class a
{
  public b dt;
  public int du;
  
  public String toString()
  {
    Object localObject;
    if (this.dt == b.dG)
    {
      localObject = c.k(this.du);
      return this.dt.toString() + ",原因:" + localObject;
    }
    if (this.dt == b.dH)
    {
      localObject = d.l(this.du);
      return this.dt.toString() + ",原因:" + localObject;
    }
    if (this.dt == b.dI)
    {
      localObject = a.j(this.du);
      return this.dt.toString() + ",原因:" + localObject;
    }
    return this.dt.toString();
  }
  
  public static enum a
  {
    static String[] dC = { "系统连接其他WiFi事件导致的取消", "手动在手管点击连接其他WiFi导致的取消", "手动断开/忘记WiFi导致的取消", "检测发现当前WiFi发生改变导致的取消", "连接过程中关闭WiFi开关导致的取消", "刷新WiFi列表时发现WiFi消失导致的取消", "未知的取消（连接过程中收到了未知原因的事件）" };
    int dD;
    
    static
    {
      dA = new a("CANCEL_BY_REFRESH_AP_GONE", 5, 6);
      dB = new a("CANCEL_BY_UNKNOWN", 6, 10);
      dE = new a[] { dv, dw, dx, dy, dz, dA, dB };
    }
    
    private a(int paramInt)
    {
      this.dD = paramInt;
    }
    
    public static a j(int paramInt)
    {
      try
      {
        a[] arrayOfa = values();
        int j = arrayOfa.length;
        int i = 0;
        while (i < j)
        {
          a locala = arrayOfa[i];
          int k = locala.f();
          if (k == paramInt) {
            return locala;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    
    public int f()
    {
      return this.dD;
    }
    
    public String toString()
    {
      return "[" + dC[ordinal()] + "," + this.dD + "]";
    }
  }
  
  public static enum b
  {
    static String[] dC = { "连接成功", "断开中止", "连接失败", "取消连接" };
    int dD;
    
    private b(int paramInt)
    {
      this.dD = paramInt;
    }
    
    public String toString()
    {
      return "[" + dC[ordinal()] + "]";
    }
  }
  
  public static enum c
  {
    static String[] dC = { "停用WiFi_未知", "停用WiFi_DNS出错", "停用WiFi_DHCP出错", "停用WiFi_密码错误", "停用WiFi_连接被拒绝" };
    int dD;
    
    private c(int paramInt)
    {
      this.dD = paramInt;
    }
    
    public static c k(int paramInt)
    {
      try
      {
        c[] arrayOfc = values();
        int j = arrayOfc.length;
        int i = 0;
        while (i < j)
        {
          c localc = arrayOfc[i];
          int k = localc.f();
          if (k == paramInt) {
            return localc;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    
    public int f()
    {
      return this.dD;
    }
    
    public String toString()
    {
      return "[" + dC[ordinal()] + "," + this.dD + "]";
    }
  }
  
  public static enum d
  {
    static String[] dC = { "路由异常", "路由异常", "密码错误", "获取IP失败", "弱信号", "Portal鉴权失败", "其他" };
    static Map<String, d> dX;
    static Map<Integer, d> dY;
    int dD;
    
    static
    {
      dX = new HashMap();
      dX.put("IDLE", dQ);
      dX.put("CONNECTING", dR);
      dX.put("AUTHENTICATING", dS);
      dX.put("OBTAINING_IPADDR", dT);
      dX.put("VERIFYING_POOR_LINK", dU);
      dX.put("CAPTIVE_PORTAL_CHECK", dV);
      dY = new HashMap();
      dY.put(Integer.valueOf(0), dQ);
      dY.put(Integer.valueOf(2), dR);
      dY.put(Integer.valueOf(3), dS);
      dY.put(Integer.valueOf(4), dT);
      dY.put(Integer.valueOf(12), dU);
      dY.put(Integer.valueOf(11), dV);
    }
    
    private d(int paramInt)
    {
      this.dD = paramInt;
    }
    
    public static d l(int paramInt)
    {
      try
      {
        d[] arrayOfd = values();
        int j = arrayOfd.length;
        int i = 0;
        while (i < j)
        {
          d locald = arrayOfd[i];
          int k = locald.f();
          if (k == paramInt) {
            return locald;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    
    public int f()
    {
      return this.dD;
    }
    
    public String toString()
    {
      return "[" + dC[ordinal()] + "," + this.dD + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.a
 * JD-Core Version:    0.7.0.1
 */