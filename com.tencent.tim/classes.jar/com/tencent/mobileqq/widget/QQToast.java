package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aric;
import arid;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import rpq;

public class QQToast
{
  private static d jdField_a_of_type_ComTencentMobileqqWidgetQQToast$d = new d(Looper.getMainLooper(), null);
  private static BlockingQueue<c> mToastQueue = new LinkedBlockingQueue();
  private static Class sAppOpsClass;
  private static Method sCheckOpNoThrow;
  private static Field sOpPostNotification;
  private static int useCustomToast = -1;
  private b jdField_a_of_type_ComTencentMobileqqWidgetQQToast$b;
  private Drawable icon;
  private boolean isUserTouched;
  boolean mAutoTextSize = false;
  private Context mContext;
  private int mDuration = 0;
  private LayoutInflater mInflater;
  private long mLastShowedTime;
  private Resources mResources;
  private int mToastType = 0;
  private CharSequence message;
  
  public QQToast(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mResources = this.mContext.getResources();
    this.mInflater = LayoutInflater.from(this.mContext);
  }
  
  @TargetApi(19)
  public static int MK()
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        return 2;
      }
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PushOpenNotify", 2, new Object[] { "isNotificationEnabled,  isEnabled, ", Boolean.valueOf(bool) });
        break;
        AppOpsManager localAppOpsManager = (AppOpsManager)BaseApplicationImpl.sApplication.getSystemService("appops");
        ApplicationInfo localApplicationInfo = BaseApplicationImpl.sApplication.getApplicationInfo();
        String str = BaseApplicationImpl.sApplication.getApplicationContext().getPackageName();
        int j = localApplicationInfo.uid;
        if (sAppOpsClass == null) {
          sAppOpsClass = Class.forName(AppOpsManager.class.getName());
        }
        if (sCheckOpNoThrow == null) {
          sCheckOpNoThrow = sAppOpsClass.getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        }
        if (sOpPostNotification == null) {
          sOpPostNotification = sAppOpsClass.getDeclaredField("OP_POST_NOTIFICATION");
        }
        int k = ((Integer)sOpPostNotification.get(Integer.class)).intValue();
        j = ((Integer)sCheckOpNoThrow.invoke(localAppOpsManager, new Object[] { Integer.valueOf(k), Integer.valueOf(j), str })).intValue();
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      while (bool) {}
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, " isNotificationEnabled, get except, " + localThrowable.getMessage());
      }
      i = 2;
      return i;
    }
    return 0;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new QQToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramInt2);
    paramContext.setDuration(paramInt3);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.setToastIcon(getIconRes(paramInt1));
    paramContext.setType(paramInt1);
    paramContext.setToastMsg(paramCharSequence);
    paramContext.setDuration(paramInt2);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  private void a(@NotNull Toast paramToast, @NotNull LinearLayout paramLinearLayout, @NotNull b paramb)
  {
    if ((paramb.text == null) || (paramb.text.isEmpty()))
    {
      QLog.e("QQToast", 1, "addRightActionView params isNullOrEmpty");
      return;
    }
    Context localContext = paramLinearLayout.getContext();
    Object localObject = new View(localContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    localLayoutParams.weight = 1.0F;
    paramLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(localContext);
    ((TextView)localObject).setOnClickListener(new arid(this, paramb, paramToast));
    ((TextView)localObject).setText(paramb.text);
    if (paramb.textColor == 0) {
      paramb.textColor = localContext.getResources().getColor(2131165653);
    }
    ((TextView)localObject).setTextColor(paramb.textColor);
    if (paramb.ehQ == 0) {
      paramb.ehQ = 16;
    }
    ((TextView)localObject).setTextSize(1, paramb.ehQ);
    paramToast = new LinearLayout.LayoutParams(-2, -2);
    paramToast.rightMargin = rpq.dip2px(localContext, 22.0F);
    paramLinearLayout.addView((View)localObject, paramToast);
  }
  
  public static boolean bD(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return false;
      if ((useCustomToast == -1) || (paramBoolean))
      {
        int i = useCustomToast;
        useCustomToast = MK();
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "canUseCustomToast = " + useCustomToast);
        }
        if ((i == 0) && (useCustomToast == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQToast", 2, "Temp Report mark: now Notification from disable to Enabled ");
          }
          anot.a(null, "dc00898", "", "", "0X8009ACA", "0X8009ACA", 0, 0, "", "", "", "");
        }
      }
    } while (useCustomToast == 1);
    return true;
  }
  
  public static int getIconColor(int paramInt)
  {
    switch (paramInt)
    {
    }
    return -1;
  }
  
  public static int getIconRes(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 3: 
    case 6: 
    default: 
      return 2130839515;
    case 1: 
    case 4: 
      return 2130848673;
    }
    return 2130848674;
  }
  
  private static int getTextColorType(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  public static boolean isMX2()
  {
    return Build.BOARD.contains("mx2");
  }
  
  public static boolean useIOSLikeUI()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000"))) && (!DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.UICfg.name(), "1").equals("0"));
  }
  
  public Toast a(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    paramOnTouchListener = create(paramInt1, paramInt2, paramOnTouchListener);
    paramOnTouchListener.show();
    this.mLastShowedTime = System.currentTimeMillis();
    this.isUserTouched = false;
    return paramOnTouchListener;
  }
  
  public void a(a parama)
  {
    parama = new c(this, parama);
    mToastQueue.add(parama);
    jdField_a_of_type_ComTencentMobileqqWidgetQQToast$d.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQToast", 2, "current queue size is " + mToastQueue.size());
    }
  }
  
  public Toast create(int paramInt)
  {
    return create(paramInt, 2131561731, null);
  }
  
  public Toast create(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    ProtectedToast localProtectedToast = new ProtectedToast(this.mContext);
    View localView = this.mInflater.inflate(paramInt2, null);
    Object localObject = localView.findViewById(2131379944);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject).setElevation(6.0F);
    }
    AnimationUtils.loadAnimation(this.mContext, 2130772304);
    localObject = (LinearLayout)localView.findViewById(2131379950);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$b != null) {
      a(localProtectedToast, (LinearLayout)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast$b);
    }
    if (this.icon != null)
    {
      localObject = (ImageView)localView.findViewById(2131379948);
      ((ImageView)localObject).setImageDrawable(this.icon);
      ((ImageView)localObject).setColorFilter(getIconColor(this.mToastType), PorterDuff.Mode.MULTIPLY);
      if (this.message != null)
      {
        localObject = (TextView)localView.findViewById(2131379951);
        ((TextView)localObject).setTextColor(getTextColorType(this.mToastType));
        ((TextView)localObject).setText(this.message);
        String str = this.message.toString();
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        float f1 = localTextPaint.measureText(str);
        DisplayMetrics localDisplayMetrics = this.mResources.getDisplayMetrics();
        float f2 = localDisplayMetrics.densityDpi / 160 * 50;
        f2 = localDisplayMetrics.widthPixels - f2;
        if (f1 > f2) {
          ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
        }
        if (this.mAutoTextSize)
        {
          f1 = localTextPaint.measureText(str);
          if (f1 > f2) {
            ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
          }
        }
      }
      if (!useIOSLikeUI()) {
        break label395;
      }
      localProtectedToast.setGravity(55, 0, 0);
    }
    for (;;)
    {
      localProtectedToast.setView(localView);
      localProtectedToast.setDuration(this.mDuration);
      if (useIOSLikeUI()) {
        localView.setOnTouchListener(new aric(this, localProtectedToast, paramOnTouchListener));
      }
      return localProtectedToast;
      ((ImageView)localView.findViewById(2131379948)).setVisibility(8);
      break;
      label395:
      if (paramInt1 == 6316128) {
        localProtectedToast.setGravity(55, 0, getStatusBarHeight());
      } else {
        localProtectedToast.setGravity(55, 0, getTitleBarHeight());
      }
    }
  }
  
  public int getStatusBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.mResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public int getTitleBarHeight()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.mResources.getDisplayMetrics().density * 44.0F + 0.5D);
  }
  
  public boolean isShowing()
  {
    if (this.mDuration == 0) {}
    for (long l = 2000L; (System.currentTimeMillis() - this.mLastShowedTime > l) || (this.isUserTouched); l = 3500L) {
      return false;
    }
    return true;
  }
  
  public void setAutoTextSize()
  {
    this.mAutoTextSize = true;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setToastIcon(int paramInt)
  {
    setToastIcon(this.mResources.getDrawable(paramInt));
  }
  
  public void setToastIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  public void setToastMsg(int paramInt)
  {
    setToastMsg(this.mResources.getString(paramInt));
  }
  
  public void setToastMsg(CharSequence paramCharSequence)
  {
    this.message = paramCharSequence;
  }
  
  public void setType(int paramInt)
  {
    this.mToastType = paramInt;
  }
  
  public Toast show()
  {
    Toast localToast;
    if (isMX2())
    {
      localToast = create(getStatusBarHeight());
      localToast.show();
    }
    for (;;)
    {
      this.isUserTouched = false;
      this.mLastShowedTime = System.currentTimeMillis();
      return localToast;
      localToast = create(0);
      localToast.show();
    }
  }
  
  public Toast show(int paramInt)
  {
    Toast localToast = create(paramInt);
    localToast.show();
    this.mLastShowedTime = System.currentTimeMillis();
    this.isUserTouched = false;
    return localToast;
  }
  
  static class ProtectedToast
    extends Toast
  {
    private static Class TNClass;
    private static Method hideMethod;
    private static Field mNextViewField;
    private static Field mTNField;
    private static WindowManager.LayoutParams params;
    private static Method showMethod;
    boolean cIH = false;
    public Runnable cancelRunnable = new QQToast.ProtectedToast.1(this);
    
    public ProtectedToast(Context paramContext)
    {
      super();
    }
    
    private static Object a(Object paramObject, Field paramField)
    {
      if (paramField != null) {
        try
        {
          if (!paramField.isAccessible()) {
            paramField.setAccessible(true);
          }
          paramObject = paramField.get(paramObject);
          return paramObject;
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
        }
      }
      return null;
    }
    
    private static boolean a(Object paramObject1, String paramString, Object paramObject2)
    {
      paramString = getDeclaredField(paramObject1, paramString);
      if (paramString != null) {
        try
        {
          if (Modifier.isFinal(paramString.getModifiers()))
          {
            Field localField = Field.class.getDeclaredField("accessFlags");
            localField.setAccessible(true);
            localField.setInt(paramString, paramString.getModifiers() & 0xFFFFFFEF);
          }
          if (!paramString.isAccessible()) {
            paramString.setAccessible(true);
          }
          paramString.set(paramObject1, paramObject2);
          return true;
        }
        catch (Exception paramObject1)
        {
          paramObject1.printStackTrace();
        }
      }
      return false;
    }
    
    private static Object f(Object paramObject, String paramString)
    {
      return a(paramObject, getDeclaredField(paramObject, paramString));
    }
    
    private static Field getDeclaredField(Object paramObject, String paramString)
    {
      paramObject = paramObject.getClass();
      while (paramObject != Object.class)
      {
        if (paramObject != null) {}
        try
        {
          Field localField = paramObject.getDeclaredField(paramString);
          return localField;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          paramObject = paramObject.getSuperclass();
        }
        return null;
      }
      return null;
    }
    
    public void cancel()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, new Object[] { "", "cancel!" });
        }
        ThreadManager.getUIHandler().removeCallbacks(this.cancelRunnable);
        if (!QQToast.bD(false))
        {
          super.cancel();
          return;
        }
        Object localObject = mTNField.get(this);
        if (hideMethod == null)
        {
          hideMethod = TNClass.getDeclaredMethod("hide", new Class[0]);
          hideMethod.setAccessible(true);
        }
        hideMethod.invoke(localObject, new Object[0]);
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "", localThrowable);
        }
        if ((localThrowable instanceof NoSuchMethodException)) {
          super.cancel();
        }
      }
    }
    
    public void show()
    {
      try
      {
        if (getView() == null) {
          throw new RuntimeException("setView must have been called");
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "", localThrowable);
        }
        if (((localThrowable instanceof NoSuchMethodException)) || ((localThrowable instanceof NoSuchFieldException))) {
          super.show();
        }
        return;
      }
      if (mTNField == null)
      {
        mTNField = Toast.class.getDeclaredField("mTN");
        mTNField.setAccessible(true);
        if (Build.VERSION.SDK_INT == 25)
        {
          localObject1 = f(mTNField, "mShow");
          if ((localObject1 instanceof Runnable)) {
            this.cIH = a(mTNField, "mShow", new InternalRunnable((Runnable)localObject1));
          }
          if (!this.cIH)
          {
            localObject1 = f(mTNField, "mHandler");
            if ((localObject1 instanceof Handler)) {
              this.cIH = a(localObject1, "mCallback", new a((Handler)localObject1));
            }
          }
          if ((!this.cIH) && (QLog.isColorLevel())) {
            QLog.d("QQToast", 2, "tryToHook error.");
          }
        }
      }
      Object localObject1 = mTNField.get(this);
      Object localObject2;
      if (QQToast.useIOSLikeUI())
      {
        localObject2 = localObject1.getClass().getDeclaredField("mParams");
        ((Field)localObject2).setAccessible(true);
        params = (WindowManager.LayoutParams)((Field)localObject2).get(localObject1);
        params.flags = 40;
        params.windowAnimations = 2131756073;
      }
      for (;;)
      {
        try
        {
          if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
            params.getClass().getField("layoutInDisplayCutoutMode").setInt(params, 1);
          }
          localObject2 = (TextView)getView().findViewById(2131379951);
          if ((localObject2 != null) && (((TextView)localObject2).getText().length() < 6))
          {
            l = 900L;
            ThreadManager.getUIHandler().postDelayed(this.cancelRunnable, l);
            if (QLog.isColorLevel()) {
              QLog.d("QQToast", 2, "show");
            }
            if (!QQToast.bD(false))
            {
              super.show();
              return;
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("QQToast", 2, QLog.getStackTraceString(localException));
          continue;
          if (TNClass == null) {
            TNClass = Class.forName("android.widget.Toast$TN");
          }
          if (mNextViewField == null)
          {
            mNextViewField = TNClass.getDeclaredField("mNextView");
            mNextViewField.setAccessible(true);
          }
          mNextViewField.set(localObject1, getView());
          if (showMethod == null)
          {
            showMethod = TNClass.getDeclaredMethod("show", new Class[0]);
            showMethod.setAccessible(true);
          }
          showMethod.invoke(localObject1, new Object[0]);
          return;
        }
        long l = 1900L;
      }
    }
    
    class InternalRunnable
      implements Runnable
    {
      private final Runnable mRunnable;
      
      InternalRunnable(Runnable paramRunnable)
      {
        this.mRunnable = paramRunnable;
      }
      
      public void run()
      {
        try
        {
          this.mRunnable.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    
    class a
      implements Handler.Callback
    {
      private final Handler mHandler;
      
      public a(Handler paramHandler)
      {
        this.mHandler = paramHandler;
      }
      
      public boolean handleMessage(Message paramMessage)
      {
        try
        {
          this.mHandler.handleMessage(paramMessage);
          return true;
        }
        catch (Throwable paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean auu();
  }
  
  public static class b
  {
    public int ehQ;
    public View.OnClickListener onClickListener;
    public String text;
    public int textColor;
  }
  
  static class c
  {
    private QQToast a;
    private WeakReference<QQToast.a> dQ;
    
    c(QQToast paramQQToast, QQToast.a parama)
    {
      this.a = paramQQToast;
      this.dQ = new WeakReference(parama);
    }
    
    private boolean needToShow()
    {
      QQToast.a locala = (QQToast.a)this.dQ.get();
      return (locala != null) && (locala.auu());
    }
    
    @Nullable
    QQToast a()
    {
      if (needToShow()) {
        return this.a;
      }
      return null;
    }
  }
  
  static class d
    extends Handler
  {
    private long avQ = 0L;
    
    private d(Looper paramLooper)
    {
      super();
    }
    
    private void a(QQToast.c paramc)
    {
      long l2 = 0L;
      paramc = paramc.a();
      long l1;
      int i;
      if (paramc != null)
      {
        paramc.show();
        if (QQToast.a(paramc) == 0)
        {
          l1 = 2000L;
          this.avQ = (System.currentTimeMillis() + l1);
          i = 1;
        }
      }
      for (;;)
      {
        if (!QQToast.mToastQueue.isEmpty())
        {
          if (i != 0) {
            l2 = 100L + l1;
          }
          mi(l2);
        }
        return;
        l1 = 3500L;
        break;
        i = 0;
        l1 = 0L;
      }
    }
    
    private void mi(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "scheduleNextToast to " + paramLong);
      }
      removeMessages(1);
      sendEmptyMessageDelayed(1, paramLong);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      long l;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "MSG_SHOW_TOAST received");
        }
        l = System.currentTimeMillis();
        if (l <= this.avQ + 100L) {
          break;
        }
        paramMessage = (QQToast.c)QQToast.mToastQueue.poll();
        if (paramMessage != null)
        {
          a(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQToast", 2, "MSG_SHOW_TOAST but no message to show");
      return;
      mi(this.avQ - l + 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast
 * JD-Core Version:    0.7.0.1
 */