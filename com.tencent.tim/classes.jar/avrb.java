import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneGiftFullScreenViewController.2;
import java.util.ArrayList;
import java.util.List;

public class avrb
  implements View.OnClickListener
{
  public static boolean cmL = true;
  protected ImageView Ba;
  protected View Ej;
  protected View Ek;
  private List<avrb.b> LM = new ArrayList();
  protected aixt a;
  public avra a;
  public aiyp b;
  protected MagicfaceContainerView c;
  protected boolean cmM;
  protected String epId;
  public Button gu;
  private Activity mActivity;
  protected WindowManager mWindowManager;
  protected Handler uiHandler;
  
  static
  {
    String str = aqgz.getCpuType();
    if (str != null)
    {
      str = str.toLowerCase();
      if ((str.contains("marvell")) || (str.contains("armv5")) || (str.contains("armv6"))) {
        cmL = false;
      }
    }
    else
    {
      return;
    }
  }
  
  public avrb(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.uiHandler = new Handler(Looper.getMainLooper());
    dvx();
  }
  
  private void Qu(int paramInt)
  {
    if (this.Ej == null) {}
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          if (!Settings.canDrawOverlays((Context)localObject)) {
            ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
          }
        }
        for (int i = 0; i != 0; i = 1) {
          for (;;)
          {
            localObject = new WindowManager.LayoutParams();
            ((WindowManager.LayoutParams)localObject).type = 2002;
            ((WindowManager.LayoutParams)localObject).flags = 131112;
            ((WindowManager.LayoutParams)localObject).gravity = 51;
            ((WindowManager.LayoutParams)localObject).x = 0;
            ((WindowManager.LayoutParams)localObject).y = paramInt;
            ((WindowManager.LayoutParams)localObject).width = -1;
            ((WindowManager.LayoutParams)localObject).height = -2;
            ((WindowManager.LayoutParams)localObject).format = 1;
            this.mWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
            if (this.Ej.getParent() != null) {}
            try
            {
              this.mWindowManager.removeView(this.Ej);
              try
              {
                this.mWindowManager.addView(this.Ej, (ViewGroup.LayoutParams)localObject);
                return;
              }
              catch (Exception localException1)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException1);
                return;
              }
              if (localException1.checkSelfPermission("android.settings.action.MANAGE_WRITE_SETTINGS") != 0)
              {
                localException1.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
                i = 0;
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("QzoneGiftFullScreenViewController", 1, "initTopbar: ", localException2);
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean apU()
  {
    if ((DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.magicface_support.name())) && (cmL) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneGiftFullScreenViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  private void dvw()
  {
    if ((this.jdField_a_of_type_Avra != null) && (this.mActivity != null))
    {
      this.c.setVisibility(8);
      this.c.setMagicfaceGestureListener(null);
      ((View)this.b).setVisibility(8);
      this.b.setSurfaceCreatelistener(null);
    }
    try
    {
      ((ViewGroup)this.mActivity.getWindow().getDecorView()).removeView(this.c);
      if (this.Ej != null)
      {
        this.Ej.setVisibility(8);
        if (this.mWindowManager != null) {
          this.mWindowManager.removeView(this.Ej);
        }
      }
      label109:
      if (this.jdField_a_of_type_Avra.isStart())
      {
        avra localavra = this.jdField_a_of_type_Avra;
        localavra.a(new avrc(this, localavra));
        return;
      }
      this.jdField_a_of_type_Avra.release();
      return;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  private void dvx()
  {
    if (!aqgz.aCF())
    {
      this.cmM = false;
      return;
    }
    if (Math.min(aqgz.hI(), aqgz.hJ()) >= 720L)
    {
      this.cmM = true;
      return;
    }
    this.cmM = false;
  }
  
  private void dvy()
  {
    if (this.c == null) {
      if (!this.cmM) {
        break label133;
      }
    }
    label133:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131562131, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131562133, null))
    {
      this.Ej = View.inflate(BaseApplicationImpl.getContext(), 2131562135, null);
      this.Ek = this.Ej.findViewById(2131371059);
      this.b = ((aiyp)localView.findViewById(2131371052));
      this.c = ((MagicfaceContainerView)localView.findViewById(2131371054));
      this.gu = ((Button)this.Ej.findViewById(2131371053));
      this.gu.setVisibility(8);
      this.Ba = ((ImageView)this.Ej.findViewById(2131371057));
      this.gu.setOnClickListener(this);
      return;
    }
  }
  
  public View a(String paramString1, String paramString2, avrb.a parama)
  {
    return a(paramString1, paramString2, false, parama);
  }
  
  public View a(String paramString1, String paramString2, boolean paramBoolean, avrb.a parama)
  {
    if (Build.VERSION.SDK_INT <= 17) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis();
      if ((this.b != null) && (((View)this.b).getVisibility() == 0))
      {
        localObject1 = new avrb.b();
        ((avrb.b)localObject1).cNg = paramString1;
        ((avrb.b)localObject1).dou = paramBoolean;
        ((avrb.b)localObject1).cNh = paramString2;
        ((avrb.b)localObject1).b = parama;
        this.LM.add(localObject1);
        return null;
      }
      if ((this.jdField_a_of_type_Avra != null) && (this.jdField_a_of_type_Avra.isStart())) {
        return null;
      }
      if (this.mActivity == null) {
        return null;
      }
      this.jdField_a_of_type_Aixt = avra.a(paramString1, paramString2);
      if (this.jdField_a_of_type_Aixt == null) {
        return null;
      }
      this.epId = paramString1;
      dvy();
      this.jdField_a_of_type_Avra = new avra(this);
      Object localObject1 = (ViewGroup)this.mActivity.getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.c);
      Object localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.Ek.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      this.c.updateViewLayout((View)this.b, (ViewGroup.LayoutParams)localObject2);
      if (!paramBoolean) {
        Qu(0);
      }
      ((ViewGroup)localObject1).addView(this.c);
      if (paramBoolean)
      {
        localObject1 = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).topMargin = aqnm.dip2px(75.0F);
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = aqnm.dip2px(75.0F);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = aqnm.dip2px(15.0F);
        ((FrameLayout.LayoutParams)localObject1).rightMargin = aqnm.dip2px(15.0F);
        this.b.setIsFullScreen(false);
        this.c.setTouchEffect(true);
        ((View)this.b).setClickable(false);
        ((View)this.b).setFocusable(false);
        this.c.setClickable(false);
        this.c.setFocusable(false);
      }
      this.uiHandler.post(new QzoneGiftFullScreenViewController.2(this));
      this.c.setVisibility(8);
      ((View)this.b).setVisibility(8);
      this.c.setVisibility(0);
      this.b.setIsFullScreen(this.jdField_a_of_type_Aixt.fullScreen);
      this.Ej.setVisibility(0);
      localObject1 = this.b;
      this.Ba.setVisibility(8);
      ((View)localObject1).setVisibility(0);
      ((SurfaceView)localObject1).setZOrderOnTop(true);
      ((SurfaceView)localObject1).getHolder().setFormat(-2);
      localObject2 = new aiyl();
      ((aiyl)localObject2).b((aiyc.b)localObject1);
      this.jdField_a_of_type_Avra.a((aiyl)localObject2);
      this.jdField_a_of_type_Avra.a(new avrd(this, l, parama));
      this.jdField_a_of_type_Avra.doAction(paramString1, paramString2);
    }
    catch (SecurityException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return this.c;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Avra != null) && (this.c.getVisibility() != 8))
    {
      dvw();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dvw();
    }
  }
  
  public static abstract interface a
  {
    public abstract void GB();
  }
  
  public class b
  {
    public avrb.a b;
    public String cNg;
    public String cNh;
    public boolean dou;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrb
 * JD-Core Version:    0.7.0.1
 */