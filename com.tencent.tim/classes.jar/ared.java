import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class ared
{
  Method A = null;
  Method B = null;
  Method C = null;
  Method D = null;
  Method E = null;
  Method F = null;
  Class jdField_G_of_type_JavaLangClass;
  Method jdField_G_of_type_JavaLangReflectMethod = null;
  Class jdField_H_of_type_JavaLangClass;
  Method jdField_H_of_type_JavaLangReflectMethod = null;
  Method I = null;
  Method J;
  Method K = null;
  Method L = null;
  Method M;
  Method N;
  Method O;
  Method P;
  Method Q = null;
  Method R = null;
  Method S;
  Method T;
  Method U;
  Method V;
  Method W;
  Context Y;
  WerewolvesHostInterface b;
  boolean cZk = false;
  Object fH;
  Object fI;
  ClassLoader mClassLoader;
  Method y = null;
  Method z;
  
  public ared(aree paramaree, ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
    this.b = new WerewolvesHostInterface(paramaree);
    init(paramaree.a.a);
  }
  
  public HashMap<String, Integer> A()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.O.invoke(this.fI, new Object[0]);
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIOColors called failed", localException);
      }
    }
    return null;
  }
  
  public void C(String paramString, Bitmap paramBitmap)
  {
    try
    {
      this.jdField_H_of_type_JavaLangReflectMethod.invoke(this.fI, new Object[] { paramString, paramBitmap });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onFaceDownloaded called failed");
      QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void E(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.y.invoke(this.fI, new Object[] { Integer.valueOf(1), paramString, paramArrayOfByte });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onReceive called failed");
      QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void K(int paramInt, Object paramObject)
  {
    try
    {
      this.z.invoke(this.fI, new Object[] { Integer.valueOf(paramInt), paramObject });
      return;
    }
    catch (Exception paramObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WereWolfPluginInterface", 2, "notify failed", paramObject);
    }
  }
  
  public int MC()
  {
    try
    {
      int i = ((Integer)this.U.invoke(this.fI, new Object[0])).intValue();
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurRoomNumber Failed:", localException);
    }
    return 10;
  }
  
  public int MD()
  {
    try
    {
      int i = ((Integer)this.V.invoke(this.fI, new Object[0])).intValue();
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurZoneId Failed:", localException);
    }
    return 0;
  }
  
  public void Tz(boolean paramBoolean)
  {
    try
    {
      this.S.invoke(this.fI, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onSpeakBtnPressed called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
  
  public void a(ViewGroup paramViewGroup, sse paramsse)
  {
    try
    {
      this.A.invoke(this.fI, new Object[] { paramViewGroup, paramsse });
      return;
    }
    catch (Exception paramViewGroup)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "attachGameUI called failed");
      QLog.e("WereWolfPluginInterface", 2, paramViewGroup, new Object[0]);
    }
  }
  
  public boolean aGn()
  {
    try
    {
      boolean bool = ((Boolean)this.F.invoke(this.fI, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isDead = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isDead called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public boolean aGo()
  {
    try
    {
      boolean bool = ((Boolean)this.jdField_G_of_type_JavaLangReflectMethod.invoke(this.fI, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "canSpeak = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "canSpeak called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public HashMap<String, Drawable> ad()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.P.invoke(this.fI, new Object[] { this.Y });
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIODrawables called failed", localException);
      }
    }
    return null;
  }
  
  public void dr(String paramString, boolean paramBoolean)
  {
    try
    {
      this.N.invoke(this.fI, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserSpeakingStateChanged called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
      paramString.printStackTrace();
    }
  }
  
  public ArrayList<String> ed()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.M.invoke(this.fI, new Object[0]);
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getQuickWords called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return null;
  }
  
  public void ehA()
  {
    try
    {
      this.C.invoke(this.fI, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "dettachUI called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      return;
    }
    finally
    {
      this.Y = null;
    }
  }
  
  public void ehB()
  {
    try
    {
      this.Q.invoke(this.fI, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserLeftAIO called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      localException.printStackTrace();
    }
  }
  
  public void ehC()
  {
    try
    {
      this.R.invoke(this.fI, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onUserEnterAIO called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
  
  public void init(Context paramContext)
  {
    this.Y = paramContext;
    this.jdField_G_of_type_JavaLangClass = ardp.loadClass(this.mClassLoader, "com.tencent.mobileqq.werewolves.PluginRuntime");
    this.jdField_H_of_type_JavaLangClass = ardp.loadClass(this.mClassLoader, "com.tencent.mobileqq.werewolves.PluginInterface");
    try
    {
      if (this.fH == null) {
        this.fH = ardp.getMethod(this.jdField_G_of_type_JavaLangClass, "getRuntime", null).invoke(null, null);
      }
      ardp.getMethod(this.jdField_G_of_type_JavaLangClass, "initFromHost", new Class[] { Object.class, Context.class }).invoke(this.fH, new Object[] { this.b, paramContext });
      this.fI = ardp.getMethod(this.jdField_G_of_type_JavaLangClass, "getPlulginInterface", null).invoke(this.fH, null);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("WereWolfPluginInterface", 2, "init failed");
          QLog.e("WereWolfPluginInterface", 2, paramContext, new Object[0]);
        }
      }
    }
    if ((!this.cZk) && (this.jdField_H_of_type_JavaLangClass != null))
    {
      this.y = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onReceive", new Class[] { Integer.TYPE, String.class, [B.class });
      this.A = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "attachGameUI", new Class[] { ViewGroup.class, Context.class });
      this.B = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onDestroy", new Class[0]);
      this.D = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "isReady", new Class[0]);
      this.E = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "isPlaying", new Class[0]);
      this.F = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "isDead", new Class[0]);
      this.jdField_G_of_type_JavaLangReflectMethod = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "canSpeak", new Class[0]);
      this.jdField_H_of_type_JavaLangReflectMethod = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onFaceDownloaded", new Class[] { String.class, Bitmap.class });
      this.M = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getQuickWords", new Class[0]);
      this.K = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "stopGame", new Class[0]);
      this.I = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "startGame", new Class[] { Integer.TYPE });
      this.J = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "startGameWithType", new Class[] { Integer.TYPE });
      this.L = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getRoomNick", new Class[] { String.class });
      this.N = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onUserSpeakingStateChanged", new Class[] { String.class, Boolean.TYPE });
      this.O = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getAIOColors", new Class[0]);
      this.P = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getAIODrawables", new Class[] { Context.class });
      this.C = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "dettachGameUI", new Class[0]);
      this.Q = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onUserLeftAIO", new Class[0]);
      this.R = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onUserEnterAIO", new Class[0]);
      this.S = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onSpeakBtnPressed", new Class[] { Boolean.TYPE });
      this.T = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "startGameForGold", new Class[0]);
      this.V = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getCurZoneId", new Class[0]);
      this.U = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "getCurRoomNumber", new Class[0]);
      this.z = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "notify", new Class[] { Integer.TYPE, Object.class });
      this.W = ardp.getMethod(this.jdField_H_of_type_JavaLangClass, "onPhoneStateChange", new Class[] { Integer.TYPE });
      this.cZk = true;
    }
  }
  
  public boolean isPlaying()
  {
    try
    {
      boolean bool = ((Boolean)this.E.invoke(this.fI, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isPlaying = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isPlaying called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public boolean isReady()
  {
    try
    {
      boolean bool = ((Boolean)this.D.invoke(this.fI, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isReady = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isReady called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    try
    {
      this.B.invoke(this.fI, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onDestroy called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      return;
    }
    finally
    {
      this.Y = null;
    }
  }
  
  public String qn(String paramString)
  {
    try
    {
      paramString = (String)this.L.invoke(this.fI, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getRoomIndex called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void zQ(int paramInt)
  {
    try
    {
      if (this.W != null) {
        this.W.invoke(this.fI, new Object[] { Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onPhoneStateChange called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ared
 * JD-Core Version:    0.7.0.1
 */