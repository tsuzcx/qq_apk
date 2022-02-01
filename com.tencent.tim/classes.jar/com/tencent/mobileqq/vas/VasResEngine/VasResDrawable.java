package com.tencent.mobileqq.vas.VasResEngine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aqro;
import aqrp;
import aqrr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class VasResDrawable
  extends VipPngPlayAnimationDrawable
  implements Handler.Callback
{
  private aqrp jdField_a_of_type_Aqrp;
  private a jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a;
  private b jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b;
  private c jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c;
  private URLDrawable.URLDrawableListener c = new aqrr(this);
  AppRuntime mApp;
  private Context mContext;
  private int mId;
  private Path mPath;
  private float mRadius;
  private RectF mRectF;
  private Handler mUIHandler;
  private Drawable t;
  
  public VasResDrawable(AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramAppRuntime.getApplication().getApplicationContext().getResources());
    a(paramAppRuntime, paramInt, new a());
    this.mPath = new Path();
    this.mRectF = new RectF();
  }
  
  private void a(AppRuntime paramAppRuntime, int paramInt, a parama)
  {
    this.mId = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a = parama;
    this.mContext = paramAppRuntime.getApplication().getApplicationContext();
    this.mApp = paramAppRuntime;
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aqrp = new aqrp(paramInt, this.mApp, this.mUIHandler);
  }
  
  private Drawable b(String paramString1, String paramString2)
  {
    Drawable localDrawable = null;
    if (TextUtils.isEmpty(paramString2))
    {
      if (a().ecm > 0) {
        return this.mContext.getResources().getDrawable(a().ecm);
      }
    }
    else {
      try
      {
        if (!TextUtils.isEmpty(a().cwB)) {}
        for (paramString1 = new URL(a().cwB, paramString2, paramString1); (paramString1 == null) || (this.mApp == null); paramString1 = new URL("http", paramString2, paramString1)) {
          return this.mContext.getResources().getDrawable(2130847025);
        }
      }
      catch (MalformedURLException paramString2)
      {
        for (;;)
        {
          paramString1 = localDrawable;
          if (QLog.isColorLevel())
          {
            QLog.d("VasResDrawable", 2, paramString2.getMessage());
            paramString1 = localDrawable;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasResDrawable", 2, "getBGDrawable url = " + paramString1.toString());
        }
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mRequestWidth = a().realWidth;
        paramString2.mRequestHeight = a().realHeight;
        if (a().ecl > 0)
        {
          localDrawable = this.mContext.getResources().getDrawable(a().ecl);
          paramString2.mLoadingDrawable = localDrawable;
          paramString2.mFailedDrawable = localDrawable;
        }
        paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
        if ((a().headers != null) && (a().headers.length > 0)) {
          paramString1.setHeaders(a().headers);
        }
        if (paramString1.getStatus() == 2) {
          paramString1.restartDownload();
        }
        paramString1.setURLDrawableListener(this.c);
        return paramString1;
      }
    }
    return null;
  }
  
  public aqro a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c;
  }
  
  public aqrp a()
  {
    return this.jdField_a_of_type_Aqrp;
  }
  
  public a a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a;
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b = paramb;
  }
  
  public void a(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c = paramc;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.load();
    }
    invalidateSelf();
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers != null) && (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers.length != 0))
    {
      Header[] arrayOfHeader = new Header[this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers.length + 1];
      System.arraycopy(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers, 0, arrayOfHeader, 0, this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers.length);
      arrayOfHeader[this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers.length] = new BasicHeader(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers = arrayOfHeader;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.headers = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.mPath.reset();
    this.mRectF.set(getBounds());
    this.mPath.addRoundRect(this.mRectF, this.mRadius, this.mRadius, Path.Direction.CW);
    paramCanvas.clipPath(this.mPath);
    if (this.t != null)
    {
      this.t.setBounds(getBounds());
      this.t.draw(paramCanvas);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.isDynamic()) {
      super.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.hq())) {
        this.t = b(String.valueOf(this.mId), this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.hq());
      }
      paramMessage = paramMessage.getData();
      if (paramMessage.getInt("type") == 1)
      {
        String[] arrayOfString = paramMessage.getStringArray("pngs");
        int i = paramMessage.getInt("interval");
        int j = paramMessage.getInt("repeatTimes");
        c(arrayOfString, i);
        setCurrentType(a().ecn);
        this.mRepeatCount = j;
      }
      invalidateSelf();
      if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b.refresh();
      }
      return true;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.O(paramMessage.arg1, (Bundle)paramMessage.obj);
      if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b.dNG();
      }
      return true;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.load();
      if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b.reload();
      }
    }
  }
  
  public void recycle()
  {
    super.recycle();
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.destroy();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    super.setColorFilter(paramColorFilter);
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }
  
  public void update(int paramInt)
  {
    if (a().ecm > 0) {
      this.t = this.mApp.getApplication().getResources().getDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$a.ecm);
    }
    super.recycle();
    this.jdField_a_of_type_Aqrp.update(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$c.load();
    }
  }
  
  public class a
  {
    public String cwB = "";
    public int ecl;
    public int ecm;
    public int ecn;
    public Header[] headers;
    public int realHeight;
    public int realWidth;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dNG();
    
    public abstract void refresh();
    
    public abstract void reload();
  }
  
  public static abstract interface c
    extends aqro
  {
    public abstract String hq();
    
    public abstract boolean isDynamic();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
 * JD-Core Version:    0.7.0.1
 */