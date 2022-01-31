package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import btt;
import btu;
import btv;
import btw;
import btx;
import bty;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread.TuneVoiceListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, QQVoiceChangerThread.TuneVoiceListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = -1;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private QQVoiceChangerThread jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt = new int[6];
  public ChangeVoiceView[] a;
  private TextView b;
  private volatile int h = -1;
  private int i = -1;
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView = new ChangeVoiceView[6];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[0] = ((ChangeVoiceView)findViewById(2131298129));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[1] = ((ChangeVoiceView)findViewById(2131298130));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[2] = ((ChangeVoiceView)findViewById(2131298131));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[3] = ((ChangeVoiceView)findViewById(2131298132));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[4] = ((ChangeVoiceView)findViewById(2131298133));
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[5] = ((ChangeVoiceView)findViewById(2131298134));
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[j].a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[j].setOnClickListener(this);
      j += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 0) {
        j = 1;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005474", "0X8005474", 0, 0, paramInt + "", j + "", "", "");
        paramInt = 0;
        if (this.i == this.h) {
          paramInt = 10;
        }
        int k = 0;
        j = paramInt;
        paramInt = k;
        while (paramInt < this.jdField_a_of_type_ArrayOfInt.length)
        {
          k = j;
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
          {
            k = j + 1;
            this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
          }
          paramInt += 1;
          j = k;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 3000) {
          j = 2;
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 1) {
          j = 3;
        } else {
          j = 4;
        }
      }
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      new HashMap().put("param_FailCode", String.valueOf(j));
      localStatisticCollector.a("", "VCPttSendEvent", false, 0L, 0L, null, "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = AudioPanel.a(paramInt1) / 1250;
    this.jdField_a_of_type_AndroidOsHandler.post(new btv(this, paramInt2, paramInt3, paramInt1));
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298136));
    this.b = ((TextView)findViewById(2131298137));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    a();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298143);
    localPressToChangeVoicePanel.g();
    localPressToChangeVoicePanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", 0, 0, "", "", "", "");
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.a = false;
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(1);
  }
  
  public void c()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      int j;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g())
      {
        localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, false);
        if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.h)) {
          break label242;
        }
        ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.h;
        j = 1;
      }
      while ((j != 0) && (localObject != null))
      {
        ThreadManager.a().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        return;
        ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, false);
        localObject = localExtensionInfo;
        j = k;
        if (localExtensionInfo != null)
        {
          localObject = localExtensionInfo;
          j = k;
          if (localExtensionInfo.pttChangeVoiceType != this.h)
          {
            localExtensionInfo.pttChangeVoiceType = this.h;
            j = 1;
            localObject = localExtensionInfo;
            continue;
            label242:
            j = 0;
          }
        }
      }
    }
  }
  
  public void d()
  {
    ThreadManager.b().post(new btt(this));
  }
  
  public void e()
  {
    if (this.h == -1) {
      this.h = 0;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(1);
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView.length)
    {
      if (j != this.h) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[j].a(0);
      }
      j += 1;
    }
  }
  
  public void f()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, 2, 2, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.h, this);
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null) && (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.a)) {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.a = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new btw(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new btx(this));
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new bty(this));
  }
  
  public void k()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298143);
      localPressToChangeVoicePanel.g();
      localPressToChangeVoicePanel.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131298136)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      k();
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", 0, 0, "", "", "", "");
    }
    do
    {
      do
      {
        return;
        if (j == 2131298137)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, 2, 2, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.h, this);
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.b = false;
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.b(this.h);
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = null;
          }
          int k = (int)this.jdField_a_of_type_Double;
          if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
            QLog.e("Barry", 4, "AudioPath == null");
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
          String str = this.jdField_a_of_type_JavaLangString;
          QQRecorder.RecorderParam localRecorderParam = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
          if (this.h > 0) {}
          for (j = 1;; j = 0)
          {
            paramView.a(str, 3, k, localRecorderParam, j, false);
            k();
            ThreadManager.b().post(new btu(this, k));
            return;
          }
        }
        g();
      } while (!(paramView instanceof ChangeVoiceView));
      paramView = (ChangeVoiceView)paramView;
      j = paramView.a();
      if (j != this.h)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(0);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[j].a(2);
        this.h = j;
        f();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", 0, 0, this.h + "", "", "", "");
        this.jdField_a_of_type_ArrayOfInt[this.h] = 1;
        return;
      }
      if (paramView.b() == 2)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(1);
        return;
      }
      if (paramView.b() == 1)
      {
        f();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioAudiopanelChangeVoiceView[this.h].a(2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", 0, 0, this.h + "", "", "", "");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.h + " newtype is " + j + " state is " + paramView.b());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */