package com.tencent.map.sdk.engine.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.sdk.a.ke;
import com.tencent.map.sdk.a.ma;
import com.tencent.map.sdk.a.me;
import com.tencent.map.sdk.a.mf;
import com.tencent.map.sdk.a.mg;
import com.tencent.map.sdk.a.mh;
import com.tencent.map.sdk.a.mi;
import com.tencent.map.sdk.a.mj;
import com.tencent.map.sdk.a.mk;
import com.tencent.map.sdk.a.ml;
import com.tencent.map.sdk.a.nl;
import com.tencent.map.sdk.a.or;
import com.tencent.map.sdk.a.os;
import com.tencent.map.sdk.a.pb;
import com.tencent.map.sdk.a.qd;
import com.tencent.map.sdk.a.qh;
import com.tencent.map.sdk.engine.jni.models.DataSource;
import com.tencent.map.sdk.engine.jni.models.IconImageInfo;
import com.tencent.map.sdk.engine.jni.models.MapTileID;
import com.tencent.map.sdk.engine.jni.models.TextBitmapInfo;
import java.util.Hashtable;

public class JNICallback
{
  private ke a;
  private mf b;
  private me c;
  private mk d;
  private mi e;
  private ml f;
  private mg g;
  private mj h;
  private mh i;
  private ma j;
  private Hashtable<Long, Paint> k = new Hashtable();
  private Hashtable<Long, PointF> l = new Hashtable();
  private Bitmap m = null;
  public TextBitmapInfo mTextBitmapInfo = null;
  
  public JNICallback(ke paramke, mf parammf, me paramme, mk parammk, mg parammg, mj parammj, ma paramma, ml paramml, mi parammi)
  {
    this.a = paramke;
    this.b = parammf;
    this.c = paramme;
    this.d = parammk;
    this.f = paramml;
    this.g = parammg;
    this.e = parammi;
    this.h = parammj;
    this.j = paramma;
    this.m = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    this.mTextBitmapInfo = new TextBitmapInfo();
  }
  
  private Paint a()
  {
    if (this.k == null) {
      return null;
    }
    return (Paint)this.k.get(Long.valueOf(Thread.currentThread().getId()));
  }
  
  private Paint a(int paramInt)
  {
    Paint localPaint = a();
    Object localObject = localPaint;
    if (localPaint == null)
    {
      localObject = new pb();
      ((Paint)localObject).setTypeface(Typeface.DEFAULT);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
      ((Paint)localObject).setLinearText(true);
      a((Paint)localObject);
    }
    ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
    ((Paint)localObject).setTextSize(paramInt);
    return localObject;
  }
  
  private IconImageInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramInt == 1)
      {
        ke localke = this.a;
        IconImageInfo localIconImageInfo = new IconImageInfo();
        localIconImageInfo.scale = localke.c;
        localIconImageInfo.anchorPointX1 = 0.5F;
        localIconImageInfo.anchorPointY1 = 0.5F;
        localIconImageInfo.bitmap = localke.a(paramArrayOfByte, Bitmap.Config.RGB_565);
        return localIconImageInfo;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    paramArrayOfByte = this.a.a(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  private void a(Paint paramPaint)
  {
    if (this.k != null) {
      this.k.put(Long.valueOf(Thread.currentThread().getId()), paramPaint);
    }
  }
  
  public Object callback(int paramInt, JNIEvent paramJNIEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return null;
                      paramInt = paramJNIEvent.id;
                      localObject1 = paramJNIEvent.name;
                      paramJNIEvent = paramJNIEvent.data;
                      if (this.m == null) {
                        this.m = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
                      }
                      if (this.m == null) {}
                      for (paramJNIEvent = null;; paramJNIEvent = this.m)
                      {
                        return paramJNIEvent;
                        this.mTextBitmapInfo.fill(paramJNIEvent);
                        paramJNIEvent = a(paramInt);
                        this.m.eraseColor(0);
                        localObject2 = new Canvas(this.m);
                        f1 = (paramJNIEvent.descent() + paramJNIEvent.ascent()) / 2.0F;
                        paramJNIEvent.setFakeBoldText(this.mTextBitmapInfo.bold);
                        ((Canvas)localObject2).drawText((String)localObject1, 400.0F, 200.0F - f1, paramJNIEvent);
                      }
                      localObject1 = paramJNIEvent.name;
                      paramInt = paramJNIEvent.id;
                      float f1 = a(paramInt).measureText((String)localObject1);
                      if (this.l == null) {}
                      for (paramJNIEvent = null;; paramJNIEvent = (PointF)this.l.get(Long.valueOf(Thread.currentThread().getId())))
                      {
                        localObject1 = paramJNIEvent;
                        if (paramJNIEvent == null)
                        {
                          paramJNIEvent = new PointF();
                          localObject1 = paramJNIEvent;
                          if (this.l != null)
                          {
                            this.l.put(Long.valueOf(Thread.currentThread().getId()), paramJNIEvent);
                            localObject1 = paramJNIEvent;
                          }
                        }
                        ((PointF)localObject1).x = (1.0F + f1);
                        ((PointF)localObject1).y = (paramInt + 2);
                        return localObject1;
                      }
                      os.a();
                    } while (nl.a(paramJNIEvent.name));
                    localObject1 = new qd();
                    ((qd)localObject1).a = paramJNIEvent.id;
                    if ((paramJNIEvent.extra instanceof MapTileID))
                    {
                      localObject2 = (MapTileID)paramJNIEvent.extra;
                      ((qd)localObject1).b = ((MapTileID)localObject2).getDataSource().getValue();
                      ((qd)localObject1).c = ((MapTileID)localObject2).getPriority().e;
                    }
                    ((qd)localObject1).d = paramJNIEvent.extra;
                    paramJNIEvent = paramJNIEvent.name;
                  } while (this.b == null);
                  or.a("Engine callback download:".concat(String.valueOf(paramJNIEvent)));
                  this.b.b(paramJNIEvent, (qd)localObject1);
                  return null;
                  return a(paramJNIEvent.id, paramJNIEvent.data);
                  localObject1 = paramJNIEvent.name;
                  paramJNIEvent = paramJNIEvent.data;
                } while (paramJNIEvent == null);
                new JNICallback.1(this, (String)localObject1, paramJNIEvent).execute(new Void[0]);
                return null;
              } while (this.f == null);
              this.f.a();
              return null;
            } while (this.j == null);
            this.j.c(paramJNIEvent.name);
            return null;
          } while (this.g == null);
          this.g.b();
          return null;
        } while (this.h == null);
        localObject1 = this.h;
        if (paramJNIEvent.id > 0) {}
        for (;;)
        {
          ((mj)localObject1).a(bool);
          return null;
          bool = false;
        }
        os.a();
      } while (nl.a(paramJNIEvent.name));
      localObject1 = new qd();
      ((qd)localObject1).a = paramJNIEvent.id;
      if ((paramJNIEvent.extra instanceof MapTileID))
      {
        localObject2 = (MapTileID)paramJNIEvent.extra;
        ((qd)localObject1).b = ((MapTileID)localObject2).getDataSource().getValue();
        ((qd)localObject1).c = ((MapTileID)localObject2).getPriority().e;
      }
      ((qd)localObject1).d = paramJNIEvent.extra;
      paramJNIEvent = paramJNIEvent.name;
    } while (this.c == null);
    or.a("Engine callback cancel download:".concat(String.valueOf(paramJNIEvent)));
    this.c.a(paramJNIEvent, (qd)localObject1);
    return null;
  }
  
  public int callbackGetGLContext()
  {
    if (this.i != null) {
      return this.i.getEGLContextHash();
    }
    return 0;
  }
  
  public void destory()
  {
    this.m = null;
    this.mTextBitmapInfo = null;
    if (this.k != null)
    {
      this.k.clear();
      this.k = null;
    }
    if (this.l != null)
    {
      this.l.clear();
      this.l = null;
    }
    this.a = null;
    this.b = null;
    this.c = null;
    this.f = null;
    this.g = null;
    this.e = null;
  }
  
  public void onMapCameraChangeStopped()
  {
    if (this.e != null) {
      this.e.j();
    }
  }
  
  public void onMapCameraChanged()
  {
    if (this.e != null) {
      this.e.i();
    }
  }
  
  public void onMapLoaded()
  {
    if (this.d != null) {
      this.d.e();
    }
  }
  
  public void setMapCallbackGetGLContext(mh parammh)
  {
    this.i = parammh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNICallback
 * JD-Core Version:    0.7.0.1
 */