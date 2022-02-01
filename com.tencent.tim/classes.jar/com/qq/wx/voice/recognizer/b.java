package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.util.ManagerDataStore;
import com.qq.wx.voice.util.ManagerDeviceInfo;
import com.qq.wx.voice.util.ManagerInfoRecord;
import com.qq.wx.voice.vad.EVad;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

final class b
{
  private boolean a = false;
  private ByteArrayOutputStream b = new ByteArrayOutputStream();
  private EVad c = new EVad();
  private boolean d = false;
  private int e = 3;
  private int f = 3;
  private boolean g = true;
  private LinkedList h = new LinkedList();
  private int i = InfoRecorder.h / InfoRecorder.b;
  private int j = 0;
  private boolean k = true;
  private boolean l = true;
  private InnerAudioList m = new InnerAudioList();
  private c n = new c();
  private Thread o = null;
  private InnerSender p = new InnerSender();
  private Thread q = null;
  
  protected static void a(int paramInt)
  {
    InfoRecorder.c = paramInt;
  }
  
  protected static void a(VoiceRecognizerListener paramVoiceRecognizerListener)
  {
    InfoRecognizer.b.b = paramVoiceRecognizerListener;
  }
  
  protected static void a(String paramString)
  {
    if (paramString != null) {
      InfoHttp.d = paramString;
    }
  }
  
  protected static void a(boolean paramBoolean)
  {
    InfoRecognizer.j = paramBoolean;
  }
  
  protected static void b(int paramInt)
  {
    InfoRecorder.d = paramInt;
  }
  
  protected static void b(String paramString)
  {
    InfoRecognizer.o = paramString;
  }
  
  protected static void b(boolean paramBoolean)
  {
    InfoRecognizer.k = paramBoolean;
  }
  
  protected static void c(int paramInt)
  {
    InfoHttp.e = paramInt;
  }
  
  protected static void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InfoHttp.f = 1;
      return;
    }
    InfoHttp.f = 0;
  }
  
  protected static void d(int paramInt)
  {
    InfoHttp.b = paramInt;
  }
  
  protected static void d(boolean paramBoolean)
  {
    InfoRecognizer.f = paramBoolean;
    if (paramBoolean)
    {
      InfoRecorder.f = 500;
      InfoRecorder.g = 350;
      InfoRecorder.h = 20000;
      return;
    }
    InfoRecorder.f = 300;
    InfoRecorder.g = 225;
    InfoRecorder.h = 10000;
  }
  
  protected static void e(int paramInt)
  {
    InfoHttp.c = paramInt;
  }
  
  protected static void e(boolean paramBoolean)
  {
    InfoRecognizer.g = paramBoolean;
  }
  
  protected static void f()
  {
    InfoRecognizer.p = false;
  }
  
  protected static void f(boolean paramBoolean)
  {
    InfoRecognizer.a(paramBoolean);
  }
  
  protected static void g(boolean paramBoolean)
  {
    InfoRecognizer.p = paramBoolean;
  }
  
  protected static void h(boolean paramBoolean)
  {
    InfoRecognizer.h = paramBoolean;
  }
  
  protected static void i(boolean paramBoolean)
  {
    InfoRecognizer.i = paramBoolean;
  }
  
  protected final int a()
  {
    if (InfoRecognizer.b.b == null) {}
    do
    {
      return -1;
      if (!this.a)
      {
        InfoRecognizer.b.b(-101);
        return -1;
      }
      if ((this.o != null) && (this.o.isAlive()))
      {
        InfoRecognizer.b.b(-102);
        return -1;
      }
      InfoRecognizer.b.a();
    } while (this.n.a(this.m) < 0);
    if ((this.q != null) && (this.q.isAlive()))
    {
      this.p.a();
      this.p.b();
    }
    try
    {
      this.q.join();
      this.q = null;
      this.p.a(this.m);
      this.m.a();
      this.q = new Thread(this.p);
      this.q.start();
      this.o = new Thread(this.n);
      this.o.start();
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected final int a(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    InfoRecognizer.b.a = this;
    if (this.a) {
      return 0;
    }
    try
    {
      System.loadLibrary("WXVoice");
      InfoRecognizer.a = paramString;
      InfoRecognizer.c.init(paramContext);
      InfoRecognizer.d.init(paramContext);
      InfoRecognizer.e.init(paramContext);
      paramContext = this.n;
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
      {
        InfoRecognizer.b.b(-304);
        return -1;
      }
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      InfoRecognizer.b.b(-103);
      return -1;
    }
    catch (Exception paramContext)
    {
      InfoRecognizer.b.b(-103);
      return -1;
    }
    this.a = true;
    return 0;
  }
  
  protected final int a(Context paramContext, String paramString1, String paramString2)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    InfoRecognizer.b.a = this;
    if (this.a) {
      return 0;
    }
    try
    {
      System.load(paramString2);
      InfoRecognizer.a = paramString1;
      InfoRecognizer.c.init(paramContext);
      InfoRecognizer.d.init(paramContext);
      InfoRecognizer.e.init(paramContext);
      paramContext = this.n;
      if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
      {
        InfoRecognizer.b.b(-304);
        return -1;
      }
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      InfoRecognizer.b.b(-103);
      return -1;
    }
    catch (Exception paramContext)
    {
      InfoRecognizer.b.b(-103);
      return -1;
    }
    this.a = true;
    return 0;
  }
  
  protected final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.l) {
      return 0;
    }
    if (paramArrayOfByte != null) {
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    byte[] arrayOfByte;
    int i1;
    label307:
    Object localObject;
    label771:
    for (;;)
    {
      int i2;
      try
      {
        this.b.flush();
        arrayOfByte = this.b.toByteArray();
        paramInt2 = 0;
        paramInt1 = 0;
        if (!InfoRecognizer.j) {
          break label861;
        }
        i2 = InfoRecorder.b;
        if (arrayOfByte.length - paramInt1 <= i2)
        {
          paramInt2 = paramInt1;
          if (!paramBoolean) {
            break label861;
          }
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.b.a(paramArrayOfByte);
          this.l = true;
          if (this.d) {
            break label776;
          }
          paramArrayOfByte = new a(null, InnerAudioState.cancel);
          if (this.m.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.b.b(-305);
          return -1;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
      paramArrayOfByte = new byte[InfoRecorder.b];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, i2);
      paramInt1 += i2;
      if (this.j == 0)
      {
        i1 = 0;
        paramInt2 = 0;
      }
      for (;;)
      {
        if (paramInt2 >= paramArrayOfByte.length) {}
        while (paramArrayOfByte[paramInt2] != 0)
        {
          if (i1 > paramArrayOfByte.length / 2) {
            break label771;
          }
          this.j += i2;
          if (InfoRecorder.d <= 0) {
            break label307;
          }
          LogTool.d("timeOffset = " + this.j + " timeOut = " + (InfoRecorder.a << 1) * InfoRecorder.d / 1000);
          if ((!this.g) || (this.j <= (InfoRecorder.a << 1) * InfoRecorder.d / 1000L)) {
            break label307;
          }
          InfoRecognizer.b.b(-307);
          break;
        }
        i1 += 1;
        paramInt2 += 1;
      }
      paramInt2 = Common.calculateVolumn(paramArrayOfByte, i2);
      InfoRecognizer.b.a(paramInt2);
      this.e = this.c.AddData(paramArrayOfByte, i2);
      if ((!this.d) && (this.e == 2) && (this.f == 3))
      {
        this.d = true;
        this.g = false;
        LogTool.d("speaking start: preAudio size = " + this.h.size());
        if (this.h.isEmpty()) {
          break label620;
        }
        localObject = new a((byte[])this.h.removeFirst(), InnerAudioState.begin);
        ((a)localObject).c = this.j;
        if (this.m.a((a)localObject)) {
          break label620;
        }
        InfoRecognizer.b.b(-305);
        continue;
        label459:
        localObject = new a((byte[])this.h.removeFirst(), InnerAudioState.middle);
        ((a)localObject).c = this.j;
        if (this.m.a((a)localObject)) {
          break label620;
        }
        InfoRecognizer.b.b(-305);
      }
      for (;;)
      {
        if (this.d)
        {
          if ((this.e == 3) && (this.f == 2))
          {
            if (!InfoRecognizer.f)
            {
              localObject = VoiceRecordState.Complete;
              InfoRecognizer.b.a((VoiceRecordState)localObject);
            }
            this.d = false;
            LogTool.d("speaking stop");
            this.h.clear();
            if (!InfoRecognizer.f)
            {
              paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
              paramArrayOfByte.c = this.j;
              if (!this.m.a(paramArrayOfByte))
              {
                InfoRecognizer.b.b(-305);
                break;
                label620:
                if (!this.h.isEmpty()) {
                  break label459;
                }
                continue;
              }
              this.l = true;
              return 0;
            }
            localObject = new a(paramArrayOfByte, InnerAudioState.end);
            ((a)localObject).c = this.j;
            if (this.m.a((a)localObject)) {
              break label732;
            }
            InfoRecognizer.b.b(-305);
            break;
          }
          localObject = new a(paramArrayOfByte, InnerAudioState.middle);
          ((a)localObject).c = this.j;
          if (!this.m.a((a)localObject))
          {
            InfoRecognizer.b.b(-305);
            break;
          }
        }
      }
      label732:
      this.f = this.e;
      this.h.add(paramArrayOfByte);
      if (this.h.size() > this.i) {
        this.h.removeFirst();
      }
    }
    return 0;
    label776:
    paramInt2 = paramInt1;
    if (this.d)
    {
      this.d = false;
      LogTool.d("speaking stop");
      paramArrayOfByte = new byte[arrayOfByte.length - paramInt1];
      System.arraycopy(arrayOfByte, paramInt1, paramArrayOfByte, 0, arrayOfByte.length - paramInt1);
      paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
      paramArrayOfByte.c = this.j;
      if (!this.m.a(paramArrayOfByte))
      {
        InfoRecognizer.b.b(-305);
        return -1;
      }
      return 0;
    }
    label861:
    paramInt1 = paramInt2;
    if (!InfoRecognizer.j)
    {
      i1 = InfoRecorder.b;
      if (arrayOfByte.length - paramInt2 <= i1)
      {
        label884:
        paramInt1 = paramInt2;
        if (paramBoolean)
        {
          paramArrayOfByte = VoiceRecordState.Complete;
          InfoRecognizer.b.a(paramArrayOfByte);
          this.l = true;
          paramArrayOfByte = new byte[arrayOfByte.length - paramInt2];
          System.arraycopy(arrayOfByte, paramInt2, paramArrayOfByte, 0, arrayOfByte.length - paramInt2);
          paramArrayOfByte = new a(paramArrayOfByte, InnerAudioState.stop);
          paramInt1 = paramInt2;
          if (!this.m.a(paramArrayOfByte))
          {
            InfoRecognizer.b.b(-305);
            return -1;
          }
        }
      }
      else
      {
        localObject = new byte[InfoRecorder.b];
        System.arraycopy(arrayOfByte, paramInt2, localObject, 0, i1);
        paramInt1 = paramInt2 + i1;
        this.j += i1;
        paramInt2 = Common.calculateVolumn((byte[])localObject, i1);
        InfoRecognizer.b.a(paramInt2);
        if (this.k) {}
        for (paramArrayOfByte = InnerAudioState.begin;; paramArrayOfByte = InnerAudioState.middle)
        {
          paramArrayOfByte = new a((byte[])localObject, paramArrayOfByte);
          this.k = false;
          paramInt2 = paramInt1;
          if (this.m.a(paramArrayOfByte)) {
            break;
          }
          InfoRecognizer.b.b(-305);
          paramInt2 = paramInt1;
          break label884;
        }
      }
    }
    this.b.reset();
    this.b.write(arrayOfByte, paramInt1, arrayOfByte.length - paramInt1);
    return 0;
  }
  
  protected final void a(byte[] paramArrayOfByte)
  {
    this.p.a(paramArrayOfByte);
  }
  
  protected final int b(Context paramContext, String paramString)
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    InfoRecognizer.b.a = this;
    if (this.a) {
      return 0;
    }
    InfoRecognizer.a = paramString;
    InfoRecognizer.c.init(paramContext);
    InfoRecognizer.d.init(paramContext);
    InfoRecognizer.e.init(paramContext);
    paramContext = this.n;
    if (this.c.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
    {
      InfoRecognizer.b.b(-304);
      return -1;
    }
    this.a = true;
    return 0;
  }
  
  protected final void b()
  {
    if (this.o != null) {
      if (this.n != null)
      {
        this.n.a();
        this.n.d();
      }
    }
    try
    {
      this.o.join();
      this.o = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected final void c()
  {
    VoiceRecordState localVoiceRecordState;
    if ((this.o != null) || (this.q != null))
    {
      localVoiceRecordState = VoiceRecordState.Canceling;
      InfoRecognizer.b.a(localVoiceRecordState);
      if (this.n != null)
      {
        this.n.b();
        this.n.d();
      }
      if (this.o == null) {}
    }
    try
    {
      this.o.join();
      this.o = null;
      if (this.p != null)
      {
        this.p.a();
        this.p.b();
      }
      if (this.q == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.q.join();
        this.q = null;
        localVoiceRecordState = VoiceRecordState.Canceled;
        InfoRecognizer.b.a(localVoiceRecordState);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  protected final void d()
  {
    if (this.a)
    {
      c();
      this.n.c();
      this.c.Release();
      this.a = false;
    }
  }
  
  protected final int e()
  {
    if (InfoRecognizer.b.b == null) {
      return -1;
    }
    if (!this.a)
    {
      InfoRecognizer.b.b(-101);
      return -1;
    }
    InfoRecognizer.b.a();
    VoiceRecordState localVoiceRecordState = VoiceRecordState.Start;
    InfoRecognizer.b.a(localVoiceRecordState);
    if ((this.q != null) && (this.q.isAlive()))
    {
      this.p.a();
      this.p.b();
    }
    try
    {
      this.q.join();
      this.q = null;
      this.m = new InnerAudioList();
      this.m.a();
      this.b.reset();
      this.p.a(this.m);
      this.c.Reset();
      this.d = false;
      this.e = 3;
      this.f = 3;
      this.g = true;
      this.h.clear();
      this.i = (InfoRecorder.h / InfoRecorder.b);
      this.j = 0;
      this.k = true;
      this.l = false;
      LogTool.d("preAudioMax = " + this.i);
      this.q = new Thread(this.p);
      this.q.start();
      localVoiceRecordState = VoiceRecordState.Recording;
      InfoRecognizer.b.a(localVoiceRecordState);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.b
 * JD-Core Version:    0.7.0.1
 */