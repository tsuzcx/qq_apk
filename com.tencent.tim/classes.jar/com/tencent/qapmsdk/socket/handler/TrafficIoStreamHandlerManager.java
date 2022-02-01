package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.report.TrafficMonitorReport;
import com.tencent.qapmsdk.impl.util.StringUtil;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig;
import com.tencent.qapmsdk.socket.hpack.Decode;
import com.tencent.qapmsdk.socket.hpack.Header;
import com.tencent.qapmsdk.socket.hpack.Http2Reader.Handler;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.model.SocketTracer;
import com.tencent.qapmsdk.socket.model.Utf8Checker;
import com.tencent.qapmsdk.socket.util.ArrayUtils;
import com.tencent.qapmsdk.socket.util.ThreadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import okio.BufferedSource;
import okio.ByteString;

public class TrafficIoStreamHandlerManager
{
  private static final Set<ITrafficInputStreamHandlerFactory> INPUT_STREAM_HANDLER_FACTORIES = Collections.newSetFromMap(new ConcurrentHashMap());
  private static final Set<ITrafficOutputStreamHandlerFactory> OUTPUT_STREAM_HANDLER_FACTORIES = Collections.newSetFromMap(new ConcurrentHashMap());
  
  static
  {
    INPUT_STREAM_HANDLER_FACTORIES.add(new DefaultTrafficInputStreamHandlerFactory(null));
    OUTPUT_STREAM_HANDLER_FACTORIES.add(new DefaultTrafficOutputStreamHandlerFactory(null));
  }
  
  public static void addInputStreamHandlerFactory(ITrafficInputStreamHandlerFactory paramITrafficInputStreamHandlerFactory)
  {
    if (paramITrafficInputStreamHandlerFactory == null) {
      return;
    }
    INPUT_STREAM_HANDLER_FACTORIES.add(paramITrafficInputStreamHandlerFactory);
  }
  
  public static void addOutputStreamHandlerFactory(ITrafficOutputStreamHandlerFactory paramITrafficOutputStreamHandlerFactory)
  {
    if (paramITrafficOutputStreamHandlerFactory == null) {
      return;
    }
    OUTPUT_STREAM_HANDLER_FACTORIES.add(paramITrafficOutputStreamHandlerFactory);
  }
  
  public static void clearInputStreamHandlerFactories()
  {
    INPUT_STREAM_HANDLER_FACTORIES.clear();
  }
  
  public static void clearOutputStreamHandlerFactories()
  {
    OUTPUT_STREAM_HANDLER_FACTORIES.clear();
  }
  
  public static Set<ITrafficInputStreamHandlerFactory> getInputStreamHandlerFactories()
  {
    return INPUT_STREAM_HANDLER_FACTORIES;
  }
  
  public static Set<ITrafficOutputStreamHandlerFactory> getOutputStreamHandlerFactories()
  {
    return OUTPUT_STREAM_HANDLER_FACTORIES;
  }
  
  private static String makeTag(SocketInfo paramSocketInfo)
  {
    Object localObject = PathResolver.getPathResolver();
    if (paramSocketInfo.version != null) {
      if (paramSocketInfo.ssl)
      {
        str = "https";
        paramSocketInfo.protocol = str;
        StringBuilder localStringBuilder = new StringBuilder().append(paramSocketInfo.host).append("/").append(paramSocketInfo.ip).append(":").append(paramSocketInfo.port).append(", ");
        if (localObject == null) {
          break label237;
        }
        localObject = ((IPathResolver)localObject).resolve(paramSocketInfo.path);
        label85:
        localObject = localStringBuilder.append((String)localObject).append(", ").append(paramSocketInfo.version).append(", ").append(paramSocketInfo.method).append(", ").append(str).append(", ").append(paramSocketInfo.networkType);
        if (!paramSocketInfo.gzip) {
          break label245;
        }
        str = ", gzip";
        label146:
        localObject = ((StringBuilder)localObject).append(str);
        if (!paramSocketInfo.chunked) {
          break label251;
        }
      }
    }
    label237:
    label245:
    label251:
    for (String str = ", chunked";; str = "")
    {
      return str + ", " + paramSocketInfo.fd + ", impl[@" + paramSocketInfo.implHashCode + "], tid[" + paramSocketInfo.threadId + "]";
      str = "http";
      break;
      if (paramSocketInfo.ssl)
      {
        str = "ssl";
        break;
      }
      str = "tcp";
      break;
      localObject = paramSocketInfo.path;
      break label85;
      str = "";
      break label146;
    }
  }
  
  public static void removeInputStreamHandlerFactory(ITrafficInputStreamHandlerFactory paramITrafficInputStreamHandlerFactory)
  {
    if (paramITrafficInputStreamHandlerFactory == null) {
      return;
    }
    INPUT_STREAM_HANDLER_FACTORIES.remove(paramITrafficInputStreamHandlerFactory);
  }
  
  public static void removeOutputStreamHandlerFactory(ITrafficOutputStreamHandlerFactory paramITrafficOutputStreamHandlerFactory)
  {
    if (paramITrafficOutputStreamHandlerFactory == null) {
      return;
    }
    OUTPUT_STREAM_HANDLER_FACTORIES.remove(paramITrafficOutputStreamHandlerFactory);
  }
  
  static class Body
    extends TrafficIoStreamHandlerManager.Data
  {
    private static final String TAG = "QAPM_Socket_Body";
    ByteArrayOutputStream chunkBaos = new ByteArrayOutputStream();
    long chunkRemain;
    long remain;
    int size = 0;
    Utf8Checker utf8Checker = new Utf8Checker();
    
    Body(boolean paramBoolean, SocketInfo paramSocketInfo)
    {
      super(paramSocketInfo);
    }
    
    void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.socketInfo.chunked) {
        this.chunkBaos.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      label173:
      do
      {
        paramArrayOfByte = this.chunkBaos.toByteArray();
        for (;;)
        {
          Object localObject;
          if (this.offset < paramArrayOfByte.length)
          {
            if (this.chunkRemain == 0L)
            {
              localObject = readLine(paramArrayOfByte);
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                long l = 0L;
                localObject = localObject.split(";")[0];
                paramInt2 = 0;
                if (paramInt2 < ((String)localObject).length())
                {
                  paramInt1 = localObject.getBytes()[paramInt2];
                  if ((paramInt1 >= 48) && (paramInt1 <= 57)) {
                    paramInt1 -= 48;
                  }
                  for (;;)
                  {
                    l = l << 4 | paramInt1;
                    paramInt2 += 1;
                    break;
                    if ((paramInt1 >= 97) && (paramInt1 <= 102))
                    {
                      paramInt1 = paramInt1 - 97 + 10;
                    }
                    else
                    {
                      if ((paramInt1 < 65) || (paramInt1 > 70)) {
                        break label173;
                      }
                      paramInt1 = paramInt1 - 65 + 10;
                    }
                  }
                }
                if (l == 0L) {
                  this.isCompleted = true;
                }
                this.chunkRemain = l;
              }
            }
            if (!this.isCompleted) {}
          }
          else
          {
            return;
          }
          if (this.chunkRemain != 0L)
          {
            localObject = readBytes(paramArrayOfByte, (int)this.chunkRemain);
            this.size += localObject.length;
            this.chunkRemain -= localObject.length;
          }
        }
        this.size += paramInt2;
        this.remain -= paramInt2;
      } while (this.remain != 0L);
      this.isCompleted = true;
    }
    
    byte[] toByteArray()
    {
      return this.baos.toByteArray();
    }
  }
  
  static class Data
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    boolean isCompleted;
    boolean isOutput;
    int offset;
    SocketInfo socketInfo;
    
    Data(boolean paramBoolean, SocketInfo paramSocketInfo)
    {
      this.isOutput = paramBoolean;
      this.socketInfo = paramSocketInfo;
    }
    
    byte[] readBytes(byte[] paramArrayOfByte, int paramInt)
    {
      paramInt = Math.min(paramArrayOfByte.length - this.offset, paramInt);
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, this.offset, arrayOfByte, 0, paramInt);
      this.offset = (paramInt + this.offset);
      return arrayOfByte;
    }
    
    String readLine(byte[] paramArrayOfByte)
    {
      int i = this.offset;
      while (i < paramArrayOfByte.length)
      {
        if (paramArrayOfByte[i] == 10)
        {
          int m = this.offset;
          int k = i - m;
          int n = i - 1;
          int j = k;
          if (n >= 0)
          {
            j = k;
            if (paramArrayOfByte[n] == 13) {
              j = k - 1;
            }
          }
          byte[] arrayOfByte = new byte[j];
          System.arraycopy(paramArrayOfByte, m, arrayOfByte, 0, j);
          this.offset = (i + 1);
          return new String(arrayOfByte);
        }
        i += 1;
      }
      return null;
    }
  }
  
  static class DefaultTrafficInputStreamHandler
    implements ITrafficInputStreamHandler
  {
    private static final long DELAY_TIME = 500L;
    private static final String TAG = "QAPM_Socket_TrafficInputStream";
    private List<Byte> byteList = new ArrayList();
    private boolean canHandlerHttp1;
    private boolean canHandlerHttp2;
    private DumpInputStreamTask dumpInputStreamTask = new DumpInputStreamTask();
    private boolean finish;
    private TrafficIoStreamHandlerManager.Package inputSteamPackage;
    private String inputTag;
    private String path;
    
    public void onClose()
    {
      if (this.byteList.size() > 0)
      {
        ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(this.byteList.size()), 500L);
        if ((TrafficMonitor.config().isVerbose()) && (!this.canHandlerHttp1) && (this.inputSteamPackage != null))
        {
          TrafficIoStreamHandlerManager.Body localBody = this.inputSteamPackage.body;
          if (localBody.baos.size() > 0) {
            localBody.baos.reset();
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "input stream close ", this.inputTag });
        }
        this.byteList.clear();
      }
    }
    
    public void onInput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable SocketInfo paramSocketInfo)
    {
      boolean bool;
      label141:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (paramSocketInfo != null)
      {
        if ((this.finish) || (TextUtils.isEmpty(this.inputTag)) || ((paramSocketInfo.path != null) && (!paramSocketInfo.path.equals(this.path))))
        {
          this.finish = false;
          this.path = paramSocketInfo.path;
          paramSocketInfo.resetForInput();
          this.inputTag = TrafficIoStreamHandlerManager.makeTag(paramSocketInfo);
          this.inputSteamPackage = new TrafficIoStreamHandlerManager.Package(false, paramSocketInfo);
          if ((paramSocketInfo.version != null) && (paramSocketInfo.version.startsWith("HTTP/1")))
          {
            bool = true;
            this.canHandlerHttp1 = bool;
            if ((paramSocketInfo.version == null) || (!paramSocketInfo.version.startsWith("HTTP/2"))) {
              break label583;
            }
            bool = true;
            this.canHandlerHttp2 = bool;
          }
        }
        else
        {
          paramSocketInfo.receivedBytes += paramInt2;
        }
      }
      else
      {
        if ((TrafficMonitor.config().isVerbose()) && (paramInt3 > 0) && (this.canHandlerHttp1) && (this.inputSteamPackage != null))
        {
          localObject1 = this.inputSteamPackage.header;
          localObject2 = this.inputSteamPackage.body;
          if (((TrafficIoStreamHandlerManager.Header)localObject1).isCompleted) {
            break label589;
          }
          ((TrafficIoStreamHandlerManager.Header)localObject1).parse(paramArrayOfByte, paramInt1, paramInt3);
          if (((TrafficIoStreamHandlerManager.Header)localObject1).isCompleted)
          {
            if (paramSocketInfo != null)
            {
              this.inputTag = TrafficIoStreamHandlerManager.makeTag(paramSocketInfo);
              ((TrafficIoStreamHandlerManager.Body)localObject2).remain = paramSocketInfo.contentLength;
            }
            localObject3 = ((TrafficIoStreamHandlerManager.Header)localObject1).baos.toByteArray();
            ((TrafficIoStreamHandlerManager.Body)localObject2).parse((byte[])localObject3, ((TrafficIoStreamHandlerManager.Header)localObject1).offset, localObject3.length - ((TrafficIoStreamHandlerManager.Header)localObject1).offset);
          }
          if ((((TrafficIoStreamHandlerManager.Header)localObject1).isCompleted) && (((TrafficIoStreamHandlerManager.Body)localObject2).isCompleted) && (this.canHandlerHttp1))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http1 read finished <<< ", this.inputTag });
            this.finish = true;
          }
        }
        if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp2) && (this.inputSteamPackage != null))
        {
          localObject1 = new Decode(new ByteArrayInputStream(paramArrayOfByte));
          localObject2 = this.inputSteamPackage.header;
          localObject3 = this.inputSteamPackage.body;
        }
      }
      label583:
      label589:
      byte[] arrayOfByte;
      label710:
      do
      {
        try
        {
          ((Decode)localObject1).readFrame(new TrafficIoStreamHandlerManager.Http2Handle(this.inputSteamPackage));
          if ((((TrafficIoStreamHandlerManager.Header)localObject2).isCompleted) && (((TrafficIoStreamHandlerManager.Body)localObject3).isCompleted) && (this.canHandlerHttp2))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http2 read finished <<< ", this.inputTag });
            this.finish = true;
          }
          if (paramInt3 == 1)
          {
            this.byteList.add(Byte.valueOf(paramArrayOfByte[0]));
            if ((this.finish) && (paramSocketInfo != null))
            {
              if (!paramSocketInfo.hasSaved)
              {
                TrafficMonitorReport.getInstance().addSocketToQueue(paramSocketInfo);
                paramSocketInfo.hasSaved = true;
              }
              SocketTracer.addSocketInfoToMap(paramSocketInfo.protocol + "://" + paramSocketInfo.host + paramSocketInfo.path, paramSocketInfo);
            }
            return;
            bool = false;
            break;
            bool = false;
            break label141;
            ((TrafficIoStreamHandlerManager.Body)localObject2).parse(paramArrayOfByte, paramInt1, paramInt3);
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficInputStream", "http2 read failed <<< ", this.inputTag });
            }
          } while (paramInt3 <= 1);
          ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(paramInt3), 500L);
          if (!TrafficMonitor.config().canLog()) {
            continue;
          }
        }
        if (!this.canHandlerHttp1)
        {
          if ((this.inputSteamPackage == null) || (this.inputSteamPackage.size() <= 0) || (this.canHandlerHttp2)) {
            break label1001;
          }
          paramArrayOfByte = this.inputSteamPackage.toByteArray();
          this.inputSteamPackage.reset();
          arrayOfByte = paramArrayOfByte;
          if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
            arrayOfByte = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.inputTag, "]\n", new String(arrayOfByte) });
        }
      } while (this.byteList.size() <= 0);
      ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(this.byteList.size()), 500L);
      if ((TrafficMonitor.config().canLog()) && (!this.canHandlerHttp1))
      {
        if ((this.inputSteamPackage == null) || (this.inputSteamPackage.size() <= 0) || (this.canHandlerHttp2)) {
          break label1023;
        }
        paramArrayOfByte = this.inputSteamPackage.toByteArray();
        this.inputSteamPackage.reset();
      }
      for (;;)
      {
        arrayOfByte = paramArrayOfByte;
        if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
          arrayOfByte = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.inputTag, "]\n", new String(arrayOfByte) });
        this.byteList.clear();
        break;
        label1001:
        arrayOfByte = new byte[paramInt3];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt3);
        paramArrayOfByte = arrayOfByte;
        break label710;
        label1023:
        paramArrayOfByte = ArrayUtils.toPrimitive((Byte[])this.byteList.toArray(new Byte[0]));
      }
    }
    
    class DumpInputStreamTask
      implements Runnable
    {
      AtomicLong atomicLong = new AtomicLong();
      
      DumpInputStreamTask() {}
      
      DumpInputStreamTask acquire(int paramInt)
      {
        this.atomicLong.getAndAdd(paramInt);
        return this;
      }
      
      public void run()
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "[", TrafficIoStreamHandlerManager.DefaultTrafficInputStreamHandler.this.inputTag, "] <=== read ", String.valueOf(this.atomicLong.getAndSet(0L)), " bytes" });
      }
    }
  }
  
  static class DefaultTrafficInputStreamHandlerFactory
    implements ITrafficInputStreamHandlerFactory
  {
    public ITrafficInputStreamHandler create()
    {
      return new TrafficIoStreamHandlerManager.DefaultTrafficInputStreamHandler();
    }
  }
  
  static class DefaultTrafficOutputStreamHandler
    implements ITrafficOutputStreamHandler
  {
    private static final long DELAY_TIME = 500L;
    private static final String TAG = "QAPM_Socket_TrafficOutputStream";
    private boolean canHandlerHttp1;
    private boolean canHandlerHttp2;
    private DumpOutputStreamTask dumpOutputStreamTask = new DumpOutputStreamTask();
    private boolean finish;
    private TrafficIoStreamHandlerManager.Package outputStreamPackage;
    private String outputTag;
    private String path;
    
    public void onOutput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo)
    {
      boolean bool;
      if ((this.finish) || (TextUtils.isEmpty(this.outputTag)) || ((paramSocketInfo.path != null) && (!paramSocketInfo.path.equals(this.path))))
      {
        this.finish = false;
        this.path = paramSocketInfo.path;
        paramSocketInfo.resetForOutput();
        this.outputTag = TrafficIoStreamHandlerManager.makeTag(paramSocketInfo);
        this.outputStreamPackage = new TrafficIoStreamHandlerManager.Package(true, paramSocketInfo);
        if ((paramSocketInfo.version == null) || (!paramSocketInfo.version.startsWith("HTTP/1"))) {
          break label623;
        }
        bool = true;
      }
      for (;;)
      {
        this.canHandlerHttp1 = bool;
        label136:
        TrafficIoStreamHandlerManager.Header localHeader;
        TrafficIoStreamHandlerManager.Body localBody;
        if ((paramSocketInfo.version != null) && (paramSocketInfo.version.startsWith("HTTP/2")))
        {
          bool = true;
          this.canHandlerHttp2 = bool;
          paramSocketInfo.sendBytes += paramInt2;
          if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp1))
          {
            localHeader = this.outputStreamPackage.header;
            localBody = this.outputStreamPackage.body;
            if (localHeader.isCompleted) {
              break label635;
            }
            localHeader.parse(paramArrayOfByte, paramInt1, paramInt2);
            if (localHeader.isCompleted)
            {
              this.outputTag = TrafficIoStreamHandlerManager.makeTag(paramSocketInfo);
              localBody.remain = paramSocketInfo.contentLength;
              paramSocketInfo = localHeader.baos.toByteArray();
              localBody.parse(paramSocketInfo, localHeader.offset, paramSocketInfo.length - localHeader.offset);
            }
            if ((localHeader.isCompleted) && (localBody.isCompleted) && (this.canHandlerHttp1))
            {
              Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http1 write finish >>>> ", this.outputTag });
              this.finish = true;
            }
          }
          if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp2))
          {
            paramSocketInfo = new Decode(new ByteArrayInputStream(paramArrayOfByte));
            localHeader = this.outputStreamPackage.header;
            localBody = this.outputStreamPackage.body;
          }
        }
        try
        {
          paramSocketInfo.readFrame(new TrafficIoStreamHandlerManager.Http2Handle(this.outputStreamPackage));
          if ((localHeader.isCompleted) && (localBody.isCompleted) && (this.canHandlerHttp2))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write finish >>>> ", this.outputTag });
            this.finish = true;
          }
          ThreadUtils.replaceSingle(this.dumpOutputStreamTask.acquire(paramInt2), 500L);
          if ((TrafficMonitor.config().canLog()) && (!this.canHandlerHttp1))
          {
            if ((this.outputStreamPackage != null) && (this.outputStreamPackage.size() > 0) && (!this.canHandlerHttp2))
            {
              paramArrayOfByte = this.outputStreamPackage.toByteArray();
              this.outputStreamPackage.reset();
              paramSocketInfo = paramArrayOfByte;
              if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
                paramSocketInfo = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
              }
              Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "write >>> [", this.outputTag + "]\n", new String(paramSocketInfo) });
            }
          }
          else
          {
            return;
            label623:
            bool = false;
            continue;
            bool = false;
            break label136;
            label635:
            localBody.parse(paramArrayOfByte, paramInt1, paramInt2);
          }
        }
        catch (Exception paramSocketInfo)
        {
          for (;;)
          {
            Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write failed >>> ", this.outputTag });
            continue;
            paramSocketInfo = new byte[paramInt2];
            System.arraycopy(paramArrayOfByte, paramInt1, paramSocketInfo, 0, paramInt2);
            paramArrayOfByte = paramSocketInfo;
          }
        }
      }
    }
    
    class DumpOutputStreamTask
      implements Runnable
    {
      AtomicLong atomicLong = new AtomicLong();
      
      DumpOutputStreamTask() {}
      
      DumpOutputStreamTask acquire(int paramInt)
      {
        this.atomicLong.getAndAdd(paramInt);
        return this;
      }
      
      public void run()
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "[", TrafficIoStreamHandlerManager.DefaultTrafficOutputStreamHandler.this.outputTag, "] ===> write ", String.valueOf(this.atomicLong.getAndSet(0L)), " bytes" });
      }
    }
  }
  
  static class DefaultTrafficOutputStreamHandlerFactory
    implements ITrafficOutputStreamHandlerFactory
  {
    public ITrafficOutputStreamHandler create()
    {
      return new TrafficIoStreamHandlerManager.DefaultTrafficOutputStreamHandler();
    }
  }
  
  static class Header
    extends TrafficIoStreamHandlerManager.Data
  {
    Header(boolean paramBoolean, SocketInfo paramSocketInfo)
    {
      super(paramSocketInfo);
    }
    
    void parse(List<Header> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Header localHeader = (Header)paramList.next();
        if (localHeader.name.utf8().startsWith("content-encoding")) {
          if ("gzip".equalsIgnoreCase(localHeader.value.utf8())) {
            this.socketInfo.gzip = true;
          }
        }
        for (;;)
        {
          if (!this.isOutput) {
            break label350;
          }
          this.socketInfo.requestHeaders.put(localHeader.name.utf8(), localHeader.value.utf8());
          break;
          if (localHeader.name.utf8().startsWith("transfer-encoding"))
          {
            if ("chunked".equalsIgnoreCase(localHeader.value.utf8())) {
              this.socketInfo.chunked = true;
            }
          }
          else if (localHeader.name.utf8().startsWith("content-length")) {
            try
            {
              this.socketInfo.contentLength = Long.parseLong(localHeader.value.utf8());
            }
            catch (Exception localException) {}
          } else if (localHeader.name.utf8().startsWith("content-type")) {
            this.socketInfo.contentType = StringUtil.contentType(localHeader.value.utf8());
          } else if (localHeader.name.utf8().equals(":status")) {
            this.socketInfo.statusCode = Integer.decode(localHeader.value.utf8()).intValue();
          } else if (localHeader.name.utf8().equals(":method")) {
            this.socketInfo.method = localHeader.value.utf8();
          } else if (localHeader.name.utf8().equals(":scheme")) {
            this.socketInfo.protocol = localHeader.value.utf8();
          } else if (localHeader.name.utf8().equals(":path")) {
            this.socketInfo.path = localHeader.value.utf8();
          }
        }
        label350:
        this.socketInfo.responseHeaders.put(localHeader.name.utf8(), localHeader.value.utf8());
      }
    }
    
    void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.baos.write(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = this.baos.toByteArray();
      for (;;)
      {
        Object localObject1 = readLine(paramArrayOfByte);
        if (localObject1 != null)
        {
          if (((String)localObject1).length() == 0) {
            this.isCompleted = true;
          }
        }
        else {
          return;
        }
        if (((String)localObject1).startsWith("Content-Encoding:")) {
          if ("gzip".equalsIgnoreCase(((String)localObject1).substring("Content-Encoding:".length(), ((String)localObject1).length()).trim())) {
            this.socketInfo.gzip = true;
          }
        }
        for (;;)
        {
          localObject1 = ((String)localObject1).split(":");
          if (localObject1.length != 2) {
            break;
          }
          if (!this.isOutput) {
            break label344;
          }
          this.socketInfo.requestHeaders.put(localObject1[0].trim(), localObject1[1].trim());
          break;
          if (((String)localObject1).startsWith("Transfer-Encoding:"))
          {
            if ("chunked".equalsIgnoreCase(((String)localObject1).substring("Transfer-Encoding:".length(), ((String)localObject1).length()).trim())) {
              this.socketInfo.chunked = true;
            }
          }
          else if (((String)localObject1).startsWith("Content-Length:"))
          {
            String str = ((String)localObject1).substring("Content-Length:".length(), ((String)localObject1).length()).trim();
            try
            {
              this.socketInfo.contentLength = Long.parseLong(str);
            }
            catch (Exception localException) {}
          }
          else
          {
            Object localObject2;
            if (((String)localObject1).startsWith("Content-Type:"))
            {
              localObject2 = ((String)localObject1).substring("Content-Type:".length(), ((String)localObject1).length()).trim();
              this.socketInfo.contentType = StringUtil.contentType((String)localObject2);
            }
            else if ((this.socketInfo.version != null) && (((String)localObject1).startsWith(this.socketInfo.version)))
            {
              localObject2 = ((String)localObject1).split(" ");
              if (localObject2.length > 2) {
                this.socketInfo.statusCode = Integer.decode(localObject2[1]).intValue();
              }
            }
          }
        }
        label344:
        this.socketInfo.responseHeaders.put(localObject1[0].trim(), localObject1[1].trim());
      }
    }
    
    byte[] toByteArray()
    {
      byte[] arrayOfByte1 = this.baos.toByteArray();
      byte[] arrayOfByte2 = new byte[this.offset];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
      return arrayOfByte2;
    }
  }
  
  static class Http2Handle
    implements Http2Reader.Handler
  {
    private TrafficIoStreamHandlerManager.Package http2Package;
    
    public Http2Handle(TrafficIoStreamHandlerManager.Package paramPackage)
    {
      this.http2Package = paramPackage;
    }
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (paramBoolean) {
        this.http2Package.header.isCompleted = true;
      }
      this.http2Package.body.isCompleted = paramBoolean;
    }
    
    public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
    {
      boolean bool2 = true;
      if (paramBoolean1) {
        this.http2Package.body.isCompleted = true;
      }
      TrafficIoStreamHandlerManager.Header localHeader = this.http2Package.header;
      boolean bool1 = bool2;
      if (!paramBoolean1) {
        if (!paramBoolean2) {
          break label63;
        }
      }
      label63:
      for (bool1 = bool2;; bool1 = false)
      {
        localHeader.isCompleted = bool1;
        this.http2Package.header.parse(paramList);
        return;
      }
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  }
  
  static class Package
  {
    TrafficIoStreamHandlerManager.Body body;
    TrafficIoStreamHandlerManager.Header header;
    
    Package(boolean paramBoolean, SocketInfo paramSocketInfo)
    {
      this.header = new TrafficIoStreamHandlerManager.Header(paramBoolean, paramSocketInfo);
      this.body = new TrafficIoStreamHandlerManager.Body(paramBoolean, paramSocketInfo);
    }
    
    void reset()
    {
      this.header.baos.reset();
      this.body.baos.reset();
    }
    
    int size()
    {
      return this.header.baos.size() + this.body.size;
    }
    
    byte[] toByteArray()
    {
      byte[] arrayOfByte1 = this.header.toByteArray();
      byte[] arrayOfByte2 = this.body.toByteArray();
      byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
      return arrayOfByte3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIoStreamHandlerManager
 * JD-Core Version:    0.7.0.1
 */