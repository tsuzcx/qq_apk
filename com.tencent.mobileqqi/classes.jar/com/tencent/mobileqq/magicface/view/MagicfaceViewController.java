package com.tencent.mobileqq.magicface.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import gas;
import gat;
import gau;
import gav;
import gaz;
import gbc;
import gbd;

public class MagicfaceViewController
  implements View.OnClickListener
{
  public static boolean a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private ActionGlobalData jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
  private MagicfaceActionManager jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
  private MagicfaceContainerView jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  private MagicfaceView jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private String jdField_a_of_type_JavaLangString;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MagicfaceContainerView jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView;
  private MagicfaceView jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private Button e;
  private Button f;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    String str = DeviceInfoUtil.f();
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceViewController", 2, "cpuType=" + str);
    }
    if (str != null)
    {
      if ((str.toLowerCase().contains("marvell")) || (str.toLowerCase().contains("armv5")) || (str.toLowerCase().contains("armv6"))) {
        jdField_a_of_type_Boolean = false;
      }
    }
    else {
      return;
    }
    jdField_a_of_type_Boolean = true;
  }
  
  public MagicfaceViewController(ChatActivity paramChatActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = paramChatActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT >= 26) {
      localLayoutParams.type = 2038;
    }
    for (;;)
    {
      localLayoutParams.flags = 131112;
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = paramInt;
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSystemService("window"));
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        label98:
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
        return;
        localLayoutParams.type = 2002;
      }
      catch (Exception localException)
      {
        break label98;
      }
    }
  }
  
  public static boolean a()
  {
    return (DeviceProfileManager.a().b(DeviceProfileManager.DpcNames.magicface_support.name())) && (jdField_a_of_type_Boolean);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.s();
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getLayoutInflater().inflate(2130903668, null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView = ((MagicfaceView)localView.findViewById(2131233330));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131233329));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233331));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233332));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131233336));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131233333));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131233335));
      this.e = ((Button)localView.findViewById(2131233334));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.e.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getLayoutInflater().inflate(2130903667, null);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getLayoutInflater().inflate(2130903669, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131233337);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView = ((MagicfaceView)localView.findViewById(2131233327));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131233326));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233340));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233328));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131233341));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131233338));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233339));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b())
    {
      this.e.setBackgroundResource(2130839172);
      return;
    }
    this.e.setBackgroundResource(2130839171);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c())
    {
      this.f.setBackgroundResource(2130839148);
      return;
    }
    this.f.setBackgroundResource(2130839169);
  }
  
  private void f()
  {
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    if ((localPicEmoticonInfo != null) && (localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() >= 0)) {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() != 0) {
          break label84;
        }
      }
    }
    label84:
    for (localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "value=1";; localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = ("value=" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a(localPicEmoticonInfo);
      a();
      a(localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setmSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setmSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getWindow().getDecorView();
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label156:
      break label156;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      ((MagicfaceActionManager)localObject).a(new gau(this, (MagicfaceActionManager)localObject));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.e();
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (!a()) {}
    do
    {
      return;
      Emoticon localEmoticon = new Emoticon();
      localEmoticon.eId = paramEmoticon.eId;
      localEmoticon.epId = paramEmoticon.epId;
      localEmoticon.magicValue = paramEmoticon.magicValue;
      localEmoticon.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new gat(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.getVisibility() == 0)) {}
    while (((this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView != null) && (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.getVisibility() == 0)) || ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a()))) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramEmoticon.epId;
    c();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager = new MagicfaceActionManager(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView;
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((MagicfaceView)localObject2).setVisibility(0);
      ((MagicfaceView)localObject2).setZOrderOnTop(true);
      ((MagicfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a((MagicfacePlayManager)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new gav(this, paramInt, (TextView)localObject1));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new gaz(this, paramInt));
      if (!((MagicfaceView)localObject2).jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(paramEmoticon, paramInt, paramString);
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(paramEmoticon, paramInt);
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView.setmIsFullScreen(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView;
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gbc(this), 200L);
    ((MagicfaceView)localObject2).setmSurfaceCreatelistener(new gbd(this, paramEmoticon, paramInt, paramString));
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticonInfo);
  }
  
  public void b()
  {
    a();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      a();
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
    case 2131233337: 
    case 2131233339: 
    case 2131233340: 
    default: 
    case 2131233333: 
    case 2131233341: 
    case 2131233336: 
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        a();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        a();
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new gas(this), 300L);
      return;
    case 2131233335: 
      f();
      return;
    case 2131233334: 
      bool3 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (!bool3)
      {
        bool1 = true;
        label251:
        paramView.a(bool1);
        d();
        paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
        if (bool3) {
          break label327;
        }
      }
      label327:
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.c(bool1);
        if (bool3) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        return;
        bool1 = false;
        break label251;
      }
    }
    bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
    paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
    if (!bool2)
    {
      bool1 = true;
      label351:
      paramView.b(bool1);
      e();
      paramView = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (bool2) {
        break label426;
      }
    }
    label426:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      paramView.c(bool1);
      if (bool2) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.b, "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break label351;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController
 * JD-Core Version:    0.7.0.1
 */