import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.b;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class xkr
{
  public static long IY = 1500L;
  public static long IZ;
  private static xkr jdField_a_of_type_Xkr;
  public static final String aVf = aqul.getSDKPrivatePath("Tencent/MobileQQ/poke/");
  public static final String aVg = aVf + "/dazhao_motion/dazhao_move.png";
  private ArrayList[] jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
  xkr.b[] jdField_a_of_type_ArrayOfXkr$b = null;
  private ArrayList[] b = new ArrayList[6];
  HashMap<String, xkr.a> gM = new HashMap();
  public Handler mUIHandler;
  public HandlerThread v;
  public MqqHandler w;
  
  private xkr()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaUtilArrayList.length)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i] = null;
      i += 1;
    }
    i = 0;
    while (i < this.b.length)
    {
      this.b[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfXkr$b = new xkr.b[6];
    xkr.b[] arrayOfb = this.jdField_a_of_type_ArrayOfXkr$b;
    int k = arrayOfb.length;
    i = j;
    while (i < k)
    {
      xkr.b localb = arrayOfb[i];
      localb = new xkr.b();
      localb.count = 1;
      localb.Ja = -1L;
      i += 1;
    }
    this.v = new HandlerThread("PokeAIOAnimThread");
    this.v.start();
    this.w = new MqqHandler(this.v.getLooper());
  }
  
  public static xkr a()
  {
    if (jdField_a_of_type_Xkr == null) {}
    try
    {
      if (jdField_a_of_type_Xkr == null) {
        jdField_a_of_type_Xkr = new xkr();
      }
      return jdField_a_of_type_Xkr;
    }
    finally {}
  }
  
  private void i(String paramString, Context paramContext)
  {
    File localFile1 = new File(paramString);
    if ((localFile1.exists()) && (localFile1.isDirectory()))
    {
      String[] arrayOfString = localFile1.list();
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str1 = arrayOfString[i];
        if (QLog.isColorLevel()) {
          QLog.d("LzmaUtils", 2, "deal current file:" + str1);
        }
        if (new File(paramString + "/" + str1).isDirectory()) {
          i(paramString + "/" + str1, paramContext);
        }
        for (;;)
        {
          i += 1;
          break;
          if (str1.endsWith("7z"))
          {
            String str2 = str1.split("\\.")[0];
            if (QLog.isColorLevel()) {
              QLog.d("LzmaUtils", 2, "dirName:" + str2);
            }
            File localFile2 = new File(localFile1, str2);
            if (localFile2.exists()) {
              aqhq.delete(str2, false);
            }
            localFile2.mkdir();
            LzmaUtils.m(paramContext, paramString + "/" + str1, localFile2.getAbsolutePath());
            aqhq.delete(paramString + "/" + str1, true);
          }
        }
      }
    }
  }
  
  public void U(int paramInt, long paramLong)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = paramInt;
      this.mUIHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS" + IZ + "curFriendUin" + paramString + "type" + paramInt1 + "status" + paramInt3);
    }
    long l1;
    if (IZ == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      localObject2 = paramQQAppInterface.getAccount();
      l1 = ((SharedPreferences)localObject1).getLong((String)localObject2 + "_" + "aio_poke_strength_rule_interval", 0L) * 1000L;
      IZ = l1;
      if (l1 == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS is not ready");
        }
        return 0;
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((!this.gM.containsKey(paramString)) || (this.gM.get(paramString) == null))
    {
      localObject1 = new xkr.a();
      ((xkr.a)localObject1).a = new xkr.c[6];
      this.gM.put(paramString, localObject1);
    }
    Object localObject2 = (xkr.a)this.gM.get(paramString);
    if (localObject2 == null)
    {
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "pokeStrengthNullPoint", false, 0L, 0L, paramQQAppInterface, "");
      return 0;
    }
    Object localObject1 = ((xkr.a)localObject2).a;
    paramInt2 = ((xkr.a)localObject2).bTE;
    if (paramInt1 - 1 == -1) {
      paramInt1 = 0;
    }
    while ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      l1 = SystemClock.uptimeMillis();
      if (localObject1[paramInt1] == null)
      {
        localObject1[paramInt1] = new xkr.c();
        localObject1[paramInt1].status = 0;
        localObject1[paramInt1].count = 0;
        localObject1[paramInt1].Ja = -1L;
      }
      if (paramInt3 != -1)
      {
        localObject1[paramInt1].status = paramInt3;
        localObject1[paramInt1].Ja = l1;
        ((xkr.a)localObject2).bTE = paramInt1;
        return localObject1[paramInt1].status;
        paramInt1 -= 1;
      }
      else
      {
        if ((paramInt2 == -1) || (localObject1[paramInt1].Ja == -1L))
        {
          if (paramInt2 != -1) {
            anot.a(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].count, "", "", "");
          }
          localObject1[paramInt1].Ja = l1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength first click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].status);
          }
          ((xkr.a)localObject2).bTE = paramInt1;
          localObject1[paramInt1].status = 0;
          localObject1[paramInt1].count = 1;
          return localObject1[paramInt1].status;
        }
        long l2 = localObject1[paramInt1].Ja;
        localObject1[paramInt1].Ja = l1;
        if (paramInt2 != paramInt1)
        {
          anot.a(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].count, "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].status + "to 0");
          }
          ((xkr.a)localObject2).bTE = paramInt1;
          localObject1[paramInt1].status = 0;
          localObject1[paramInt1].count = 1;
          return localObject1[paramInt1].status;
        }
        if (l1 - l2 < IZ)
        {
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.status += 1;
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.count += 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click ,type:" + paramInt1 + ".with status " + localObject1[paramInt1].status);
          }
        }
        for (;;)
        {
          if (localObject1[paramInt1].status > 3) {
            localObject1[paramInt1].status = 3;
          }
          return localObject1[paramInt1].status;
          anot.a(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].count, "", "", "");
          localObject1[paramInt1].status = 0;
          localObject1[paramInt1].count = 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].status + ",out of time");
          }
        }
      }
    }
    if (paramInt2 != -1)
    {
      anot.a(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].count, "", "", "");
      ((xkr.a)localObject2).bTE = -1;
    }
    return 0;
  }
  
  public void a(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout)
  {
    this.mUIHandler = new auru(Looper.getMainLooper(), paramFitSystemWindowsRelativeLayout);
  }
  
  public MqqHandler b()
  {
    if ((this.w == null) || (this.v == null))
    {
      this.v = new HandlerThread("PokeAIOAnimThread");
      this.v.start();
      this.w = new MqqHandler(this.v.getLooper());
    }
    return this.w;
  }
  
  public void ft(View paramView)
  {
    paramView = wja.a(paramView);
    Object localObject;
    if (xbu.a.class.isInstance(paramView))
    {
      localObject = (xbu.a)paramView;
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, new Object[] { "==>to be remove obj:", Integer.valueOf(((xbu.a)localObject).pos) });
      }
      if ((((xbu.a)localObject).mMessage instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)((xbu.a)localObject).mMessage;
        if (xks.gw(paramView.interactType)) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.interactType != 6) {
            break;
          }
        } while (!((xbu.a)localObject).a.isInit());
        localObject = ((xbu.a)localObject).a.a();
        paramView.mUnlimitedState.bWv = ((UnlimitedBladeWorks.c)localObject).bWv;
        paramView.mUnlimitedState.bWw = ((UnlimitedBladeWorks.c)localObject).bWw;
        paramView.mUnlimitedState.currentTime = ((UnlimitedBladeWorks.c)localObject).currentTime;
        paramView.mFrameState.aPN = ((UnlimitedBladeWorks.c)localObject).aPN;
        paramView.mFrameState.hi = ((UnlimitedBladeWorks.c)localObject).hi;
        return;
        localObject = ((xbu.a)localObject).h.getBackground();
      } while (!(localObject instanceof CustomFrameAnimationDrawable));
      localObject = (CustomFrameAnimationDrawable)localObject;
      ((CustomFrameAnimationDrawable)localObject).pause();
      ((CustomFrameAnimationDrawable)localObject).a(null);
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "drawble pause");
      }
    } while (paramView.mFrameState.mCurFrameIndex != ((CustomFrameAnimationDrawable)localObject).getLastIndex());
    paramView.mFrameState.hi = false;
    paramView.mFrameState.aPN = true;
  }
  
  public void i(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.mUIHandler != null)
    {
      Message localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = Boolean.valueOf(paramBoolean);
      this.mUIHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage;
    if (this.mUIHandler != null)
    {
      localMessage = this.mUIHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      this.mUIHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void releaseThread()
  {
    if (this.w != null) {
      this.w.removeCallbacksAndMessages(null);
    }
    if (this.v != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label49;
      }
      this.v.quitSafely();
    }
    for (;;)
    {
      this.v = null;
      this.w = null;
      return;
      label49:
      this.v.quit();
    }
  }
  
  public void send(int paramInt)
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.sendEmptyMessage(paramInt);
    }
  }
  
  class a
  {
    xkr.c[] a;
    int bTE = -1;
    
    a() {}
  }
  
  class b
  {
    public long Ja = -1L;
    public int count;
    
    b() {}
  }
  
  class c
  {
    public long Ja = -1L;
    public int count;
    public int status;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */