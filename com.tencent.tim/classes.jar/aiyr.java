import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.1;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.2;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.3;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.5;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.8;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiyr
  implements View.OnClickListener
{
  public static boolean cmL;
  public ImageView Ba;
  protected View Ej;
  protected View Ek;
  public TextView UA;
  public TextView Ux;
  public TextView Uy;
  protected TextView Uz;
  protected aixt a;
  public aiyh a;
  protected aiyp a;
  protected aiyr.a a;
  public aiyp b;
  protected MagicfaceContainerView b;
  public BaseChatPie c;
  protected MagicfaceContainerView c;
  protected boolean cmM;
  protected String epId;
  public Emoticon f;
  Runnable gZ = null;
  protected Button gs;
  protected Button gt;
  public Button gu;
  protected Button gv;
  protected Button gw;
  protected Button gx;
  protected WindowManager mWindowManager;
  protected Handler uiHandler;
  
  static
  {
    String str1 = aqgz.getCpuType();
    if (str1 != null)
    {
      String str2 = str1.toLowerCase();
      if ((!str2.contains("marvell")) && (!str2.contains("armv5")) && (!str2.contains("armv6"))) {
        break label76;
      }
    }
    label76:
    for (cmL = false;; cmL = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "cpuType=" + str1);
      }
      return;
    }
  }
  
  public aiyr(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.uiHandler = new Handler(Looper.getMainLooper());
    dvx();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.cmM);
    }
  }
  
  public static boolean apU()
  {
    if ((DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.magicface_support.name())) && (cmL) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  public void Qu(int paramInt)
  {
    if (this.Ej == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT < 26) {
      localLayoutParams.type = 2002;
    }
    for (;;)
    {
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = paramInt;
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.format = 1;
      this.mWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
      if (this.Ej.getParent() != null) {}
      try
      {
        this.mWindowManager.removeView(this.Ej);
        try
        {
          this.mWindowManager.addView(this.Ej, localLayoutParams);
          return;
        }
        catch (Exception localException1)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException1);
          return;
        }
        localException1.type = 2038;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
        }
      }
    }
  }
  
  public void a(Emoticon paramEmoticon, aiyr.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_Aiyr$a = parama;
    if (!apU())
    {
      if (this.jdField_a_of_type_Aiyr$a != null)
      {
        this.jdField_a_of_type_Aiyr$a.buY();
        this.jdField_a_of_type_Aiyr$a = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      parama = new Emoticon();
      parama.eId = paramEmoticon.eId;
      parama.epId = paramEmoticon.epId;
      parama.magicValue = paramEmoticon.magicValue;
      parama.jobType = paramEmoticon.jobType;
      this.f = parama;
    } while (this.uiHandler == null);
    if (this.gZ == null) {
      this.gZ = new MagicfaceViewController.3(this);
    }
    this.uiHandler.postDelayed(this.gZ, 400L);
  }
  
  public void b(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    apqk localapqk = (apqk)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(223);
    if ((localapqk != null) && (localapqk.playState != 1)) {
      localapqk.ebp();
    }
    b(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void b(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Aiyp != null) && (((View)this.jdField_a_of_type_Aiyp).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_Aiyr$a != null)
      {
        this.jdField_a_of_type_Aiyr$a.buY();
        this.jdField_a_of_type_Aiyr$a = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_Aiyp == null) || (((View)this.jdField_b_of_type_Aiyp).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_Aiyr$a == null);
        this.jdField_a_of_type_Aiyr$a.buY();
        this.jdField_a_of_type_Aiyr$a = null;
        return;
        if ((this.jdField_a_of_type_Aiyh == null) || (!this.jdField_a_of_type_Aiyh.isStart())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_Aiyr$a == null);
      this.jdField_a_of_type_Aiyr$a.buY();
      this.jdField_a_of_type_Aiyr$a = null;
      return;
      if (paramInt1 != 1) {
        break;
      }
      this.jdField_a_of_type_Aixt = aiyh.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_Aixt != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_Aiyr$a == null);
    this.jdField_a_of_type_Aiyr$a.buY();
    this.jdField_a_of_type_Aiyr$a = null;
    return;
    this.epId = paramEmoticon.epId;
    dvy();
    this.jdField_a_of_type_Aiyh = new aiyh(this);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Aiyp).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_Aiyp;
      localObject1 = this.Ux;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Aiyh);
      localObject3 = (ViewGroup)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(0);
      ((SurfaceView)localObject2).setZOrderOnTop(true);
      ((SurfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new aiyl();
      ((aiyl)localObject3).b((aiyc.b)localObject2);
      this.jdField_a_of_type_Aiyh.a((aiyl)localObject3);
      this.jdField_a_of_type_Aiyh.a(new aiyt(this, paramInt1, (TextView)localObject1));
      this.jdField_a_of_type_Aiyh.a(new aiyu(this, l, paramInt1));
      if (!((aiyp)localObject2).apT()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_Aiyh.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.Ek.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      Qu(0);
      ((ViewGroup)localObject1).addView(this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_Aiyp, (ViewGroup.LayoutParams)localObject2);
      this.uiHandler.post(new MagicfaceViewController.5(this));
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_Aiyp).setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_Aiyp.setIsFullScreen(this.jdField_a_of_type_Aixt.fullScreen);
      this.Ej.setVisibility(0);
      localObject2 = this.jdField_b_of_type_Aiyp;
      localObject1 = this.Uz;
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_Aiyh);
      this.Ba.setVisibility(8);
      this.UA.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.uiHandler.postDelayed(new MagicfaceViewController.8(this), 200L);
    ((aiyp)localObject2).setSurfaceCreatelistener(new aiyv(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void d(Emoticon paramEmoticon)
  {
    this.gv.setTag(paramEmoticon);
  }
  
  public void dvA()
  {
    if (this.jdField_a_of_type_Aiyh.apS())
    {
      this.gx.setBackgroundResource(2130848001);
      return;
    }
    this.gx.setBackgroundResource(2130848049);
  }
  
  public void dvB()
  {
    this.uiHandler.post(new MagicfaceViewController.2(this));
  }
  
  public void dvC()
  {
    if (this.gv.getTag() == null) {}
    Emoticon localEmoticon;
    do
    {
      return;
      localEmoticon = (Emoticon)this.gv.getTag();
    } while (localEmoticon.jobType != 2);
    if ((this.jdField_a_of_type_Aiyh != null) && (this.jdField_a_of_type_Aiyh.Gd() >= 0)) {
      if (this.jdField_a_of_type_Aiyh.Gd() != 0) {
        break label83;
      }
    }
    label83:
    for (localEmoticon.magicValue = "value=1";; localEmoticon.magicValue = ("value=" + this.jdField_a_of_type_Aiyh.Gd()))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a(localEmoticon);
      dvw();
      a(localEmoticon, null);
      return;
    }
  }
  
  public void dvw()
  {
    if (this.jdField_a_of_type_Aiyh != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_Aiyp).setVisibility(8);
      this.jdField_a_of_type_Aiyp.setSurfaceCreatelistener(null);
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_Aiyp).setVisibility(8);
      this.jdField_b_of_type_Aiyp.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.r();
      ((ViewGroup)localObject).removeView(this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.Ej != null)
      {
        this.Ej.setVisibility(8);
        if (this.mWindowManager != null) {
          this.mWindowManager.removeView(this.Ej);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label160:
      break label160;
    }
    if (this.jdField_a_of_type_Aiyh.isStart())
    {
      localObject = this.jdField_a_of_type_Aiyh;
      ((aiyh)localObject).a(new aiys(this, (aiyh)localObject));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aiyr$a != null)
      {
        this.jdField_a_of_type_Aiyr$a.buY();
        this.jdField_a_of_type_Aiyr$a = null;
      }
      return;
      this.jdField_a_of_type_Aiyh.release();
    }
  }
  
  public void dvx()
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
  
  public void dvy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.hideSoftInput();
    if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.cmM)
      {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131562132, null);
        this.jdField_a_of_type_Aiyp = ((aiyp)localView.findViewById(2131371049));
        this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131371050));
        this.Ux = ((TextView)localView.findViewById(2131371063));
        this.Uy = ((TextView)localView.findViewById(2131371051));
        this.gt = ((Button)localView.findViewById(2131371060));
        this.gs = ((Button)localView.findViewById(2131371048));
        this.gv = ((Button)localView.findViewById(2131371061));
        this.gw = ((Button)localView.findViewById(2131371062));
        this.gs.setOnClickListener(this);
        this.gt.setOnClickListener(this);
        this.gv.setOnClickListener(this);
        this.gw.setOnClickListener(this);
      }
    }
    else if (this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (!this.cmM) {
        break label415;
      }
    }
    label415:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131562131, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131562133, null))
    {
      this.Ej = View.inflate(BaseApplicationImpl.getContext(), 2131562135, null);
      this.Ek = this.Ej.findViewById(2131371059);
      this.jdField_b_of_type_Aiyp = ((aiyp)localView.findViewById(2131371052));
      this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131371054));
      this.Uz = ((TextView)this.Ej.findViewById(2131371058));
      this.UA = ((TextView)localView.findViewById(2131371056));
      this.gu = ((Button)this.Ej.findViewById(2131371053));
      this.gx = ((Button)this.Ej.findViewById(2131371055));
      this.Ba = ((ImageView)this.Ej.findViewById(2131371057));
      this.gu.setOnClickListener(this);
      this.gx.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
      }
      return;
      localView = View.inflate(BaseApplicationImpl.getContext(), 2131562134, null);
      break;
    }
  }
  
  public void dvz()
  {
    if (this.jdField_a_of_type_Aiyh.apR())
    {
      this.gw.setBackgroundResource(2130848052);
      return;
    }
    this.gw.setBackgroundResource(2130848051);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Aiyh != null) && ((this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_c_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      dvw();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131371048: 
    case 2131371053: 
    case 2131371060: 
    case 2131371061: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.epId, "", "", "");
        dvw();
        continue;
        anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.epId, "", "", "");
        dvw();
        continue;
        anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.epId, "", "", "");
        if (this.jdField_a_of_type_Aiyh != null)
        {
          this.jdField_a_of_type_Aiyh.close();
          this.uiHandler.postDelayed(new MagicfaceViewController.1(this), 300L);
          continue;
          dvC();
        }
      }
    case 2131371062: 
      bool3 = this.jdField_a_of_type_Aiyh.apR();
      localaiyh = this.jdField_a_of_type_Aiyh;
      if (!bool3)
      {
        bool1 = true;
        label275:
        localaiyh.LE(bool1);
        dvz();
        localaiyh = this.jdField_a_of_type_Aiyh;
        if (bool3) {
          break label356;
        }
      }
      label356:
      for (bool1 = bool2;; bool1 = false)
      {
        localaiyh.LG(bool1);
        if (bool3) {
          break;
        }
        anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        break;
        bool1 = false;
        break label275;
      }
    }
    bool2 = this.jdField_a_of_type_Aiyh.apS();
    aiyh localaiyh = this.jdField_a_of_type_Aiyh;
    if (!bool2)
    {
      bool1 = true;
      label381:
      localaiyh.LF(bool1);
      dvA();
      localaiyh = this.jdField_a_of_type_Aiyh;
      if (bool2) {
        break label461;
      }
    }
    label461:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localaiyh.LG(bool1);
      if (bool2) {
        break;
      }
      anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getApp(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      break;
      bool1 = false;
      break label381;
    }
  }
  
  public void onPause()
  {
    dvw();
    if ((this.uiHandler != null) && (this.gZ != null)) {
      this.uiHandler.removeCallbacks(this.gZ);
    }
  }
  
  public static abstract interface a
  {
    public abstract void buY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyr
 * JD-Core Version:    0.7.0.1
 */