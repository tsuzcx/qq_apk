package com.tencent.moai.proxycat;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.net.VpnService.Builder;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.tencent.moai.proxycat.protocol.IPHeader;
import com.tencent.moai.proxycat.protocol.TcpHeader;
import com.tencent.moai.proxycat.protocol.UdpHeader;
import com.tencent.moai.proxycat.tcp.TCPProxy;
import com.tencent.moai.proxycat.tcp.TCPSession;
import com.tencent.moai.proxycat.transport.ProxySelector;
import com.tencent.moai.proxycat.udp.UDPProxy;
import com.tencent.moai.proxycat.udp.UDPSession;
import com.tencent.moai.proxycat.util.ByteUtils;
import com.tencent.moai.proxycat.util.IPConfig;
import com.tencent.moai.proxycat.util.Logger;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;

public class ProxyVPNService
  extends VpnService
  implements Runnable
{
  private static final int ACTION_START = 1;
  private static final int ACTION_STOP = 0;
  private static final String ARG_ACTION = "";
  private static final String TAG = "ProxyVPNService";
  private static ProxyVPNService instance;
  private ParcelFileDescriptor fileDescriptor;
  private FileInputStream fileInputStream;
  private FileOutputStream fileOutputStream;
  private IPHeader iPHeader;
  private byte[] packet;
  private ProxySelector proxySelector;
  private volatile boolean running;
  private TcpHeader tcpHeader;
  private TCPProxy tcpProxy;
  private Thread thread;
  private UdpHeader udpHeader;
  private UDPProxy udpProxy;
  
  public static Intent createStartIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, ProxyVPNService.class);
    paramContext.putExtra("", 1);
    return paramContext;
  }
  
  public static Intent createStopIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, ProxyVPNService.class);
    paramContext.putExtra("", 0);
    return paramContext;
  }
  
  private ParcelFileDescriptor establish()
  {
    return new VpnService.Builder(this).addAddress(IPConfig.VPN_ADDRESS, 24).addRoute("0.0.0.0", 0).establish();
  }
  
  public static ProxyVPNService getInstance()
  {
    return instance;
  }
  
  private void onIPPacketReceived(int paramInt)
    throws IOException
  {
    onIPv4PacketReceived(paramInt);
  }
  
  private void onIPv4PacketReceived(int paramInt)
    throws IOException
  {
    if (this.iPHeader.totalLength() != paramInt) {
      return;
    }
    switch (this.iPHeader.protocol())
    {
    default: 
      return;
    case 6: 
      onTCPPacketReceived();
      return;
    }
    onUDPPacketReceived();
  }
  
  private void onTCPPacketReceived()
    throws IOException
  {
    if (this.tcpHeader.getSourceIp() != ByteUtils.toInteger(IPConfig.VPN_ADDRESS)) {}
    do
    {
      return;
      if (this.tcpHeader.getSourcePort() != this.tcpProxy.port()) {
        break;
      }
      localObject = (TCPSession)this.tcpProxy.getSession(this.tcpHeader.getDestinationPort());
    } while (localObject == null);
    ((TCPSession)localObject).active();
    if (this.tcpHeader.fin())
    {
      ((TCPSession)localObject).finish();
      this.tcpProxy.finishSession(this.tcpHeader.getDestinationPort());
    }
    Logger.d("ProxyVPNService", "TO LOCAL " + this.tcpHeader);
    this.tcpHeader.setSourceIp(((TCPSession)localObject).getOriginalRemoteAddress());
    this.tcpHeader.setSourcePort(((TCPSession)localObject).getOriginalRemotePort());
    this.tcpHeader.setDestinationIp(IPConfig.VPN_ADDRESS);
    this.tcpHeader.recomputeChecksum();
    this.tcpHeader.writeTo(this.fileOutputStream);
    return;
    Object localObject = ProxyCatManager.getInstance().getIpsToForward().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      str = str.substring(0, str.lastIndexOf("."));
      if (!this.tcpHeader.getDestinationIpAddress().getHostAddress().startsWith(str)) {
        break label440;
      }
      Log.i("ProxyVPNService", "need to proxy : " + this.tcpHeader.getDestinationIpAddress().getHostAddress());
      i = 1;
    }
    label440:
    for (;;)
    {
      break;
      if (i != 0) {}
      for (localObject = this.tcpProxy.pickSession(this.tcpHeader.getSourcePort(), InetAddress.getByName(ProxyCatManager.getInstance().getProxyIp()), ProxyCatManager.getInstance().getProxyPort());; localObject = this.tcpProxy.pickSession(this.tcpHeader.getSourcePort(), this.tcpHeader.getDestinationIpAddress(), this.tcpHeader.getDestinationPort()))
      {
        ((TCPSession)localObject).setOriginalRemoteAddress(this.tcpHeader.getDestinationIpAddress());
        ((TCPSession)localObject).setOriginalRemotePort(this.tcpHeader.getDestinationPort());
        ((TCPSession)localObject).active();
        Logger.d("ProxyVPNService", "TO REMOTE " + this.tcpHeader);
        this.tcpHeader.setSourceIp(IPConfig.FAKE_CLIENT_ADDRESS);
        this.tcpHeader.setDestinationIp(IPConfig.VPN_ADDRESS);
        this.tcpHeader.setDestinationPort(this.tcpProxy.port());
        this.tcpHeader.recomputeChecksum();
        this.tcpHeader.writeTo(this.fileOutputStream);
        return;
      }
    }
  }
  
  private void onUDPPacketReceived()
    throws IOException
  {
    if (this.udpHeader.getSourceIp() != ByteUtils.toInteger(IPConfig.VPN_ADDRESS)) {}
    UDPSession localUDPSession;
    do
    {
      return;
      if (this.udpHeader.getDestinationIp() != ByteUtils.toInteger(IPConfig.UDP_TO_VPN_ADDRESS)) {
        break;
      }
      localUDPSession = (UDPSession)this.udpProxy.finishSession(this.udpHeader.getDestinationPort());
    } while (localUDPSession == null);
    Logger.d("ProxyVPNService", "TO LOCAL " + this.udpHeader);
    this.udpHeader.setSourceIp(localUDPSession.getRemoteAddress());
    this.udpHeader.setSourcePort(localUDPSession.getRemotePort());
    this.udpHeader.setDestinationIp(IPConfig.VPN_ADDRESS);
    this.udpHeader.recomputeChecksum();
    this.udpHeader.writeTo(this.fileOutputStream);
    return;
    protect(this.udpProxy.pickSession(this.udpHeader.getSourcePort(), this.udpHeader.getDestinationIpAddress(), this.udpHeader.getDestinationPort()).socket());
    Logger.d("ProxyVPNService", "TO REMOTE " + this.udpHeader);
    this.udpHeader.setSourceIp(IPConfig.FAKE_CLIENT_ADDRESS);
    this.udpHeader.setDestinationIp(IPConfig.VPN_ADDRESS);
    this.udpHeader.setDestinationPort(this.udpProxy.port());
    this.udpHeader.recomputeChecksum();
    this.udpHeader.writeTo(this.fileOutputStream);
  }
  
  public void onCreate()
  {
    super.onCreate();
    instance = this;
    this.thread = new Thread(this, "ProxyVPNThread");
    this.packet = new byte[65535];
    this.iPHeader = new IPHeader(this.packet);
    this.tcpHeader = new TcpHeader(this.packet);
    this.udpHeader = new UdpHeader(this.packet);
  }
  
  public void onDestroy()
  {
    Logger.i("ProxyVPNService", "VPN service destroyed");
    instance = null;
    super.onDestroy();
  }
  
  public void onRevoke()
  {
    Logger.i("ProxyVPNService", "VPN service revoked");
    this.running = false;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = paramIntent.getIntExtra("", 0);
    if (paramInt1 == 1) {
      if (!this.running)
      {
        this.running = true;
        this.thread.start();
      }
    }
    for (;;)
    {
      return 2;
      if ((paramInt1 == 0) && (this.running)) {
        this.running = false;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 18
    //   2: ldc_w 386
    //   5: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: new 388	com/tencent/moai/proxycat/transport/ProxySelector
    //   12: dup
    //   13: invokespecial 389	com/tencent/moai/proxycat/transport/ProxySelector:<init>	()V
    //   16: putfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   24: ldc 136
    //   26: invokevirtual 395	com/tencent/moai/proxycat/transport/ProxySelector:create	(Ljava/lang/Class;)Lcom/tencent/moai/proxycat/transport/Proxy;
    //   29: checkcast 136	com/tencent/moai/proxycat/tcp/TCPProxy
    //   32: putfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   35: ldc 18
    //   37: ldc_w 397
    //   40: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   48: ldc_w 309
    //   51: invokevirtual 395	com/tencent/moai/proxycat/transport/ProxySelector:create	(Ljava/lang/Class;)Lcom/tencent/moai/proxycat/transport/Proxy;
    //   54: checkcast 309	com/tencent/moai/proxycat/udp/UDPProxy
    //   57: putfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   60: ldc 18
    //   62: ldc_w 399
    //   65: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   72: invokevirtual 400	com/tencent/moai/proxycat/transport/ProxySelector:start	()V
    //   75: aload_0
    //   76: aload_0
    //   77: invokespecial 401	com/tencent/moai/proxycat/ProxyVPNService:establish	()Landroid/os/ParcelFileDescriptor;
    //   80: putfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   83: ldc 18
    //   85: ldc_w 405
    //   88: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: new 407	java/io/FileOutputStream
    //   95: dup
    //   96: aload_0
    //   97: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   100: invokevirtual 413	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   103: invokespecial 416	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   106: putfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   109: aload_0
    //   110: new 418	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   118: invokevirtual 413	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   121: invokespecial 419	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   124: putfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   127: aload_0
    //   128: getfield 370	com/tencent/moai/proxycat/ProxyVPNService:running	Z
    //   131: ifeq +38 -> 169
    //   134: aload_0
    //   135: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   138: aload_0
    //   139: getfield 353	com/tencent/moai/proxycat/ProxyVPNService:packet	[B
    //   142: invokevirtual 425	java/io/FileInputStream:read	([B)I
    //   145: istore_1
    //   146: iload_1
    //   147: iconst_m1
    //   148: if_icmpeq +21 -> 169
    //   151: aload_0
    //   152: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   155: invokevirtual 428	com/tencent/moai/proxycat/tcp/TCPProxy:isRunning	()Z
    //   158: ifne +116 -> 274
    //   161: ldc 18
    //   163: ldc_w 430
    //   166: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: ldc 18
    //   171: ldc_w 432
    //   174: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   181: ifnull +10 -> 191
    //   184: aload_0
    //   185: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   188: invokevirtual 435	java/io/FileInputStream:close	()V
    //   191: aload_0
    //   192: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   195: ifnull +10 -> 205
    //   198: aload_0
    //   199: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   202: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   209: ifnull +10 -> 219
    //   212: aload_0
    //   213: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   216: invokevirtual 437	android/os/ParcelFileDescriptor:close	()V
    //   219: aload_0
    //   220: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   223: ifnull +10 -> 233
    //   226: aload_0
    //   227: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   230: invokevirtual 438	com/tencent/moai/proxycat/tcp/TCPProxy:close	()V
    //   233: aload_0
    //   234: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   237: ifnull +10 -> 247
    //   240: aload_0
    //   241: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   244: invokevirtual 439	com/tencent/moai/proxycat/udp/UDPProxy:close	()V
    //   247: aload_0
    //   248: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   251: ifnull +10 -> 261
    //   254: aload_0
    //   255: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   258: invokevirtual 440	com/tencent/moai/proxycat/transport/ProxySelector:close	()V
    //   261: aload_0
    //   262: invokevirtual 443	com/tencent/moai/proxycat/ProxyVPNService:stopSelf	()V
    //   265: ldc 18
    //   267: ldc_w 445
    //   270: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: return
    //   274: aload_0
    //   275: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   278: invokevirtual 446	com/tencent/moai/proxycat/udp/UDPProxy:isRunning	()Z
    //   281: ifne +121 -> 402
    //   284: ldc 18
    //   286: ldc_w 448
    //   289: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: goto -123 -> 169
    //   295: astore_2
    //   296: ldc 18
    //   298: aload_2
    //   299: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_0
    //   306: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   309: ifnull +10 -> 319
    //   312: aload_0
    //   313: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   316: invokevirtual 435	java/io/FileInputStream:close	()V
    //   319: aload_0
    //   320: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   323: ifnull +10 -> 333
    //   326: aload_0
    //   327: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   330: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   333: aload_0
    //   334: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   337: ifnull +10 -> 347
    //   340: aload_0
    //   341: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   344: invokevirtual 437	android/os/ParcelFileDescriptor:close	()V
    //   347: aload_0
    //   348: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   351: ifnull +10 -> 361
    //   354: aload_0
    //   355: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   358: invokevirtual 438	com/tencent/moai/proxycat/tcp/TCPProxy:close	()V
    //   361: aload_0
    //   362: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   365: ifnull +10 -> 375
    //   368: aload_0
    //   369: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   372: invokevirtual 439	com/tencent/moai/proxycat/udp/UDPProxy:close	()V
    //   375: aload_0
    //   376: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   379: ifnull +10 -> 389
    //   382: aload_0
    //   383: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   386: invokevirtual 440	com/tencent/moai/proxycat/transport/ProxySelector:close	()V
    //   389: aload_0
    //   390: invokevirtual 443	com/tencent/moai/proxycat/ProxyVPNService:stopSelf	()V
    //   393: ldc 18
    //   395: ldc_w 445
    //   398: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: return
    //   402: iload_1
    //   403: ifle +118 -> 521
    //   406: aload_0
    //   407: iload_1
    //   408: invokespecial 457	com/tencent/moai/proxycat/ProxyVPNService:onIPPacketReceived	(I)V
    //   411: goto -284 -> 127
    //   414: astore_2
    //   415: ldc 18
    //   417: aload_2
    //   418: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   421: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload_0
    //   425: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   428: ifnull +10 -> 438
    //   431: aload_0
    //   432: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   435: invokevirtual 435	java/io/FileInputStream:close	()V
    //   438: aload_0
    //   439: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   442: ifnull +10 -> 452
    //   445: aload_0
    //   446: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   449: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   452: aload_0
    //   453: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   456: ifnull +10 -> 466
    //   459: aload_0
    //   460: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   463: invokevirtual 437	android/os/ParcelFileDescriptor:close	()V
    //   466: aload_0
    //   467: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   470: ifnull +10 -> 480
    //   473: aload_0
    //   474: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   477: invokevirtual 438	com/tencent/moai/proxycat/tcp/TCPProxy:close	()V
    //   480: aload_0
    //   481: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   484: ifnull +10 -> 494
    //   487: aload_0
    //   488: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   491: invokevirtual 439	com/tencent/moai/proxycat/udp/UDPProxy:close	()V
    //   494: aload_0
    //   495: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   498: ifnull +10 -> 508
    //   501: aload_0
    //   502: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   505: invokevirtual 440	com/tencent/moai/proxycat/transport/ProxySelector:close	()V
    //   508: aload_0
    //   509: invokevirtual 443	com/tencent/moai/proxycat/ProxyVPNService:stopSelf	()V
    //   512: ldc 18
    //   514: ldc_w 445
    //   517: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: return
    //   521: ldc2_w 458
    //   524: invokestatic 463	java/lang/Thread:sleep	(J)V
    //   527: goto -400 -> 127
    //   530: astore_2
    //   531: aload_0
    //   532: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   535: ifnull +10 -> 545
    //   538: aload_0
    //   539: getfield 421	com/tencent/moai/proxycat/ProxyVPNService:fileInputStream	Ljava/io/FileInputStream;
    //   542: invokevirtual 435	java/io/FileInputStream:close	()V
    //   545: aload_0
    //   546: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   549: ifnull +10 -> 559
    //   552: aload_0
    //   553: getfield 205	com/tencent/moai/proxycat/ProxyVPNService:fileOutputStream	Ljava/io/FileOutputStream;
    //   556: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   559: aload_0
    //   560: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   563: ifnull +10 -> 573
    //   566: aload_0
    //   567: getfield 403	com/tencent/moai/proxycat/ProxyVPNService:fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   570: invokevirtual 437	android/os/ParcelFileDescriptor:close	()V
    //   573: aload_0
    //   574: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   577: ifnull +10 -> 587
    //   580: aload_0
    //   581: getfield 134	com/tencent/moai/proxycat/ProxyVPNService:tcpProxy	Lcom/tencent/moai/proxycat/tcp/TCPProxy;
    //   584: invokevirtual 438	com/tencent/moai/proxycat/tcp/TCPProxy:close	()V
    //   587: aload_0
    //   588: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   591: ifnull +10 -> 601
    //   594: aload_0
    //   595: getfield 306	com/tencent/moai/proxycat/ProxyVPNService:udpProxy	Lcom/tencent/moai/proxycat/udp/UDPProxy;
    //   598: invokevirtual 439	com/tencent/moai/proxycat/udp/UDPProxy:close	()V
    //   601: aload_0
    //   602: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   605: ifnull +10 -> 615
    //   608: aload_0
    //   609: getfield 391	com/tencent/moai/proxycat/ProxyVPNService:proxySelector	Lcom/tencent/moai/proxycat/transport/ProxySelector;
    //   612: invokevirtual 440	com/tencent/moai/proxycat/transport/ProxySelector:close	()V
    //   615: aload_0
    //   616: invokevirtual 443	com/tencent/moai/proxycat/ProxyVPNService:stopSelf	()V
    //   619: ldc 18
    //   621: ldc_w 445
    //   624: invokestatic 363	com/tencent/moai/proxycat/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload_2
    //   628: athrow
    //   629: astore_2
    //   630: ldc 18
    //   632: aload_2
    //   633: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   636: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: goto -448 -> 191
    //   642: astore_2
    //   643: ldc 18
    //   645: aload_2
    //   646: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   649: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: goto -447 -> 205
    //   655: astore_2
    //   656: ldc 18
    //   658: aload_2
    //   659: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   662: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: goto -446 -> 219
    //   668: astore_2
    //   669: ldc 18
    //   671: aload_2
    //   672: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   675: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -445 -> 233
    //   681: astore_2
    //   682: ldc 18
    //   684: aload_2
    //   685: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   688: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: goto -444 -> 247
    //   694: astore_2
    //   695: ldc 18
    //   697: aload_2
    //   698: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   701: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: goto -443 -> 261
    //   707: astore_2
    //   708: ldc 18
    //   710: aload_2
    //   711: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   714: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: goto -452 -> 265
    //   720: astore_2
    //   721: ldc 18
    //   723: aload_2
    //   724: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   727: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: goto -411 -> 319
    //   733: astore_2
    //   734: ldc 18
    //   736: aload_2
    //   737: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   740: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: goto -410 -> 333
    //   746: astore_2
    //   747: ldc 18
    //   749: aload_2
    //   750: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   753: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: goto -409 -> 347
    //   759: astore_2
    //   760: ldc 18
    //   762: aload_2
    //   763: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   766: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: goto -408 -> 361
    //   772: astore_2
    //   773: ldc 18
    //   775: aload_2
    //   776: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   779: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   782: goto -407 -> 375
    //   785: astore_2
    //   786: ldc 18
    //   788: aload_2
    //   789: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   792: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: goto -406 -> 389
    //   798: astore_2
    //   799: ldc 18
    //   801: aload_2
    //   802: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   805: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: goto -415 -> 393
    //   811: astore_2
    //   812: ldc 18
    //   814: aload_2
    //   815: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   818: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: goto -383 -> 438
    //   824: astore_2
    //   825: ldc 18
    //   827: aload_2
    //   828: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   831: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: goto -382 -> 452
    //   837: astore_2
    //   838: ldc 18
    //   840: aload_2
    //   841: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   844: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: goto -381 -> 466
    //   850: astore_2
    //   851: ldc 18
    //   853: aload_2
    //   854: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   857: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: goto -380 -> 480
    //   863: astore_2
    //   864: ldc 18
    //   866: aload_2
    //   867: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   870: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: goto -379 -> 494
    //   876: astore_2
    //   877: ldc 18
    //   879: aload_2
    //   880: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   883: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: goto -378 -> 508
    //   889: astore_2
    //   890: ldc 18
    //   892: aload_2
    //   893: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   896: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   899: goto -387 -> 512
    //   902: astore_3
    //   903: ldc 18
    //   905: aload_3
    //   906: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   909: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: goto -367 -> 545
    //   915: astore_3
    //   916: ldc 18
    //   918: aload_3
    //   919: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   922: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: goto -366 -> 559
    //   928: astore_3
    //   929: ldc 18
    //   931: aload_3
    //   932: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   935: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: goto -365 -> 573
    //   941: astore_3
    //   942: ldc 18
    //   944: aload_3
    //   945: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   948: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   951: goto -364 -> 587
    //   954: astore_3
    //   955: ldc 18
    //   957: aload_3
    //   958: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   961: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: goto -363 -> 601
    //   967: astore_3
    //   968: ldc 18
    //   970: aload_3
    //   971: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   974: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: goto -362 -> 615
    //   980: astore_3
    //   981: ldc 18
    //   983: aload_3
    //   984: invokestatic 452	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   987: invokestatic 455	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   990: goto -371 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	993	0	this	ProxyVPNService
    //   145	263	1	i	int
    //   295	4	2	localIOException1	IOException
    //   414	4	2	localInterruptedException	java.lang.InterruptedException
    //   530	98	2	localObject	Object
    //   629	4	2	localIOException2	IOException
    //   642	4	2	localIOException3	IOException
    //   655	4	2	localIOException4	IOException
    //   668	4	2	localIOException5	IOException
    //   681	4	2	localIOException6	IOException
    //   694	4	2	localIOException7	IOException
    //   707	4	2	localException1	java.lang.Exception
    //   720	4	2	localIOException8	IOException
    //   733	4	2	localIOException9	IOException
    //   746	4	2	localIOException10	IOException
    //   759	4	2	localIOException11	IOException
    //   772	4	2	localIOException12	IOException
    //   785	4	2	localIOException13	IOException
    //   798	4	2	localException2	java.lang.Exception
    //   811	4	2	localIOException14	IOException
    //   824	4	2	localIOException15	IOException
    //   837	4	2	localIOException16	IOException
    //   850	4	2	localIOException17	IOException
    //   863	4	2	localIOException18	IOException
    //   876	4	2	localIOException19	IOException
    //   889	4	2	localException3	java.lang.Exception
    //   902	4	3	localIOException20	IOException
    //   915	4	3	localIOException21	IOException
    //   928	4	3	localIOException22	IOException
    //   941	4	3	localIOException23	IOException
    //   954	4	3	localIOException24	IOException
    //   967	4	3	localIOException25	IOException
    //   980	4	3	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   8	127	295	java/io/IOException
    //   127	146	295	java/io/IOException
    //   151	169	295	java/io/IOException
    //   169	177	295	java/io/IOException
    //   274	292	295	java/io/IOException
    //   406	411	295	java/io/IOException
    //   521	527	295	java/io/IOException
    //   8	127	414	java/lang/InterruptedException
    //   127	146	414	java/lang/InterruptedException
    //   151	169	414	java/lang/InterruptedException
    //   169	177	414	java/lang/InterruptedException
    //   274	292	414	java/lang/InterruptedException
    //   406	411	414	java/lang/InterruptedException
    //   521	527	414	java/lang/InterruptedException
    //   8	127	530	finally
    //   127	146	530	finally
    //   151	169	530	finally
    //   169	177	530	finally
    //   274	292	530	finally
    //   296	305	530	finally
    //   406	411	530	finally
    //   415	424	530	finally
    //   521	527	530	finally
    //   177	191	629	java/io/IOException
    //   191	205	642	java/io/IOException
    //   205	219	655	java/io/IOException
    //   219	233	668	java/io/IOException
    //   233	247	681	java/io/IOException
    //   247	261	694	java/io/IOException
    //   261	265	707	java/lang/Exception
    //   305	319	720	java/io/IOException
    //   319	333	733	java/io/IOException
    //   333	347	746	java/io/IOException
    //   347	361	759	java/io/IOException
    //   361	375	772	java/io/IOException
    //   375	389	785	java/io/IOException
    //   389	393	798	java/lang/Exception
    //   424	438	811	java/io/IOException
    //   438	452	824	java/io/IOException
    //   452	466	837	java/io/IOException
    //   466	480	850	java/io/IOException
    //   480	494	863	java/io/IOException
    //   494	508	876	java/io/IOException
    //   508	512	889	java/lang/Exception
    //   531	545	902	java/io/IOException
    //   545	559	915	java/io/IOException
    //   559	573	928	java/io/IOException
    //   573	587	941	java/io/IOException
    //   587	601	954	java/io/IOException
    //   601	615	967	java/io/IOException
    //   615	619	980	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.ProxyVPNService
 * JD-Core Version:    0.7.0.1
 */