package com.tencent.mobileqq.bigbrother;

import adxf;
import anot;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class WeakOuterRefRunnable
  implements Runnable
{
  private int action = 1;
  private boolean bRB;
  private int callbackId;
  private WeakReference<Object> gC;
  private String id;
  private Runnable runnable;
  
  public WeakOuterRefRunnable(Runnable paramRunnable, boolean paramBoolean)
  {
    this.runnable = paramRunnable;
    if (paramBoolean) {
      cUU();
    }
  }
  
  private boolean afL()
  {
    Object localObject;
    if ((this.gC != null) && (this.runnable != null))
    {
      localObject = this.gC.get();
      if (localObject == null) {
        return false;
      }
    }
    try
    {
      Field localField = this.runnable.getClass().getDeclaredField("this$0");
      localField.setAccessible(true);
      localField.set(this.runnable, localObject);
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
    }
    return false;
  }
  
  private void cUU()
  {
    if (this.runnable == null) {
      return;
    }
    Object localObject = this.runnable.getClass();
    try
    {
      localObject = ((Class)localObject).getDeclaredField("this$0");
      ((Field)localObject).setAccessible(true);
      this.gC = new WeakReference(((Field)localObject).get(this.runnable));
      ((Field)localObject).set(this.runnable, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localNoSuchFieldException, new Object[0]);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalArgumentException, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      QLog.e("WeakOuterRefRunnable", 1, localIllegalAccessException, new Object[0]);
    }
  }
  
  public void LC(int paramInt)
  {
    this.action = paramInt;
  }
  
  public void LD(int paramInt)
  {
    this.callbackId = paramInt;
  }
  
  public void run()
  {
    int i;
    String str1;
    label53:
    String str2;
    if ((this.runnable != null) && (afL()))
    {
      this.runnable.run();
      adxf.a().hE(this.callbackId, this.action);
      i = 1;
      if (this.bRB)
      {
        if (i == 0) {
          break label111;
        }
        str1 = "1";
        if (i == 0) {
          break label117;
        }
        str2 = "";
        label60:
        if (this.id != null) {
          break label123;
        }
      }
    }
    label111:
    label117:
    label123:
    for (String str3 = "";; str3 = this.id)
    {
      anot.a(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, str1, str2, str3, "");
      return;
      adxf.a().hE(this.callbackId, -3);
      i = 0;
      break;
      str1 = "";
      break label53;
      str2 = "1";
      break label60;
    }
  }
  
  public void setId(String paramString)
  {
    this.bRB = true;
    this.id = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable
 * JD-Core Version:    0.7.0.1
 */