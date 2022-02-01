package com.tencent.mobileqq.colornote.smallscreen;

import acfp;
import aeba;
import aebd;
import aebm;
import aebn;
import aebo;
import aebq;
import aebr;
import aebs;
import aecj;
import aecv;
import aeds;
import aedz;
import aeea;
import aeeb;
import aeec;
import aeed;
import aeee;
import aeef;
import aeeh;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anot;
import aqcl;
import aqcx;
import aqmj;
import aqnm;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;
import wja;
import ykc;
import ykg;

public class ColorNoteSmallScreenService
  extends AppService
  implements aecv, aeeh, ColorNoteSmallScreenFullToast.a, ColorNoteSmallScreenRelativeLayout.a, SkinnableServiceProcesser.a
{
  public static boolean mShouldShow = true;
  boolean Vn = false;
  boolean Vo = true;
  public boolean Vp = true;
  aeed jdField_a_of_type_Aeed;
  public ColorNoteSmallScreenFullToast a;
  SkinnableServiceProcesser jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser;
  private ykg jdField_a_of_type_Ykg = new ykg(new aeec(this));
  private aecj jdField_b_of_type_Aecj;
  Application.ActivityLifecycleCallbacks jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new aeea(this);
  public ColorNoteSmallScreenRelativeLayout b;
  Runnable bA = null;
  public boolean bTc = true;
  public boolean bTd = false;
  boolean bTe = false;
  public int cMi;
  View focusView;
  public Runnable gi = null;
  LinearLayout iC;
  public QQAppInterface mApp;
  int mOffset;
  private BroadcastReceiver mReceiver = new aedz(this);
  MqqHandler mUIHandler;
  List<ColorNote> yJ = new ArrayList();
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    int j;
    int i;
    label85:
    Object localObject;
    if (paramBoolean)
    {
      j = paramPoint.x;
      i = paramPoint.y;
      if (this.jdField_b_of_type_Aecj == null) {
        this.jdField_b_of_type_Aecj = new aecj(this, this);
      }
      paramPoint = new WindowManager.LayoutParams();
      paramPoint.height = -1;
      paramPoint.width = -1;
      paramPoint.flags = 16777984;
      paramPoint.format = -3;
      paramPoint.windowAnimations = 0;
      if (Build.VERSION.SDK_INT < 26) {
        break label188;
      }
      paramPoint.type = 2038;
      localObject = this.jdField_b_of_type_Aecj;
      if (j > 0) {
        break label198;
      }
    }
    label188:
    label198:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((aecj)localObject).o(paramBoolean, i, this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.bR() + i);
      localObject = this.jdField_b_of_type_Aecj.y();
      ayxa.a(paramPoint);
      this.jdField_a_of_type_Aeed.getWindowManager().addView((View)localObject, paramPoint);
      this.bTc = false;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "showList");
      }
      cWl();
      this.jdField_a_of_type_Ykg.ciP();
      return;
      j = paramPoint.y;
      i = paramPoint.x;
      break;
      paramPoint.type = 2002;
      break label85;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Point paramPoint, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    aeee.hH(paramPoint.x + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.Cg() / 2, paramPoint.y + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.bR() / 2);
    paramQQAppInterface = aqmj.c(this, paramQQAppInterface.getCurrentUin()).edit();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramQQAppInterface.putBoolean("colornote_windows_land", bool);
      paramQQAppInterface.putInt("colornote_windows_x", paramPoint.x);
      paramQQAppInterface.putInt("colornote_windows_y", paramPoint.y);
      paramQQAppInterface.apply();
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("key_float_window_position");
      paramQQAppInterface.putExtra("key_float_window_position_x", paramPoint.x);
      paramQQAppInterface.putExtra("key_float_window_position_y", paramPoint.y);
      sendBroadcast(paramQQAppInterface);
      return;
    }
  }
  
  public static void be(boolean paramBoolean, int paramInt)
  {
    mShouldShow = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "from: " + paramInt + ", should show: " + paramBoolean);
    }
  }
  
  private void cWj()
  {
    if (!this.bTe)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.bTe = true;
    }
  }
  
  private void cWk()
  {
    if (this.bTe)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_b_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.bTe = false;
    }
  }
  
  private void cWm()
  {
    Object localObject = new ArrayList(eq());
    if (((List)localObject).size() != 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        r((ColorNote)((Iterator)localObject).next());
      }
    }
    localObject = this.mApp.a().a();
    if (localObject != null)
    {
      ((aebo)localObject).cVI();
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.jH(((aebo)localObject).ep());
    }
  }
  
  private void dp(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      this.jdField_a_of_type_Ykg.ciO();
      anot.a(null, "dc00898", "", "", "0X800AE85", "0X800AE85", 0, 0, "", "", "", "");
    }
  }
  
  private void e(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      paramIntent = paramIntent.getSerializableExtra("key_upcoming_color_note");
      if (QLog.isDevelopLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "handleOtherCommand() is called. colorNote = " + paramIntent);
      }
      if ((paramIntent instanceof ColorNote))
      {
        paramIntent = (ColorNote)paramIntent;
        if (paramIntent.getServiceType() == 17235968)
        {
          this.jdField_a_of_type_Ykg.ciO();
          s(paramIntent);
          paramIntent = this.mApp.a().a();
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.jH(paramIntent.ep());
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cWh();
        }
      }
    }
  }
  
  private void jI(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("ColorNoteSmallScreenService", 1, "note size 0");
    }
    do
    {
      return;
      ykc localykc = (ykc)this.app.getManager(365);
      if (localykc != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localykc.f((ColorNote)localIterator.next());
        }
      }
      QLog.e("ColorNoteSmallScreenService", 1, "manager not init");
    } while (!aebs.ao(paramList));
    this.jdField_a_of_type_Ykg.ciO();
  }
  
  private void reset()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.iC.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
    this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cVY();
    this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.updateLayout();
    this.jdField_a_of_type_Aeed.update();
  }
  
  private void s(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (paramColorNote.getServiceType() != 17235968)) {}
    do
    {
      return;
      this.yJ.add(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "add note: " + paramColorNote.toString());
      }
    } while (!AppSetting.enableTalkBack);
    paramColorNote = acfp.m(2131721572) + aebs.a(paramColorNote);
    aqcl.speak(this.focusView, paramColorNote);
  }
  
  static void setLayoutParams(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 16909064;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    paramLayoutParams.type = 2002;
  }
  
  public int Cl()
  {
    return this.jdField_a_of_type_Ykg.getState();
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    a(this.mApp, paramPoint, paramInt);
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Aeed;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.b();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.iC.getLayoutParams();
    float f = getResources().getDimensionPixelSize(2131299434);
    if (paramInt1 <= 0)
    {
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(paramInt5 + f));
      paramColorNoteSmallScreenRelativeLayout.update();
      if (paramBoolean)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.agt()) {
          paramInt1 = getResources().getDimensionPixelSize(2131296853) / 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.hF(paramInt3 - this.mOffset, paramInt2);
      }
    }
    do
    {
      return;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(f * 2.0F));
      paramColorNoteSmallScreenRelativeLayout.update();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.hF(this.mOffset + paramInt1, paramInt2);
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("ColorNoteSmallScreenService", 1, "longpress width = " + localLayoutParams.width + " left = " + paramInt1 + ", right = " + paramInt3 + "offset = " + paramInt5 + ", getMeasuredWidth = " + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getMeasuredWidth());
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    a(paramPoint, paramBoolean);
    this.jdField_a_of_type_Ykg.ciP();
    anot.a(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    if (aebs.ao(this.yJ)) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", i, 0, "", "", "", "");
      return true;
    }
  }
  
  public boolean agv()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "smallscreen longclick");
    }
    anot.a(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.vG();
    return true;
  }
  
  public MqqHandler b()
  {
    if (this.mUIHandler == null) {
      this.mUIHandler = ThreadManager.getUIHandler();
    }
    return this.mUIHandler;
  }
  
  public void b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Aeed;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.b();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.width = (paramInt3 - paramInt1);
    localLayoutParams.height = (paramInt4 - paramInt2);
    localLayoutParams.windowAnimations = 0;
    paramColorNoteSmallScreenRelativeLayout.update();
  }
  
  public void c(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void cVJ()
  {
    try
    {
      if (this.jdField_b_of_type_Aecj != null) {
        this.jdField_a_of_type_Aeed.getWindowManager().removeViewImmediate(this.jdField_b_of_type_Aecj.y());
      }
      this.bTc = true;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "onHideList");
      }
      this.jdField_a_of_type_Ykg.ciQ();
      cWl();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, localRuntimeException, new Object[0]);
        }
      }
    }
  }
  
  public void cVS()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onBackevent");
    }
    cVT();
  }
  
  public void cVT()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onFullClick");
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.iC.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    if (this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.agr()) {
      localLayoutParams.rightMargin = aqcx.dip2px(getBaseContext(), 8.0F);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cVW();
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cVY();
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.updateLayout();
      this.jdField_a_of_type_Aeed.update();
      return;
      localLayoutParams.leftMargin = aqcx.dip2px(getBaseContext(), 8.0F);
    }
  }
  
  public void cVU()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    aebo localaebo = this.mApp.a().a();
    anot.a(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, localaebo.Cf() + "", "", "", "");
    Object localObject = localaebo.r(false);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ColorNote localColorNote = (ColorNote)((Iterator)localObject).next();
      localArrayList1.add(localColorNote.getServiceType() + "");
      localArrayList2.add(localColorNote.getSubType());
      if (localColorNote.getServiceType() != 16973824) {
        break label280;
      }
      i = 1;
    }
    label280:
    for (;;)
    {
      break;
      localObject = new Intent("key_delete_item_call");
      ((Intent)localObject).putStringArrayListExtra("key_color_note_servicetype_list", localArrayList1);
      ((Intent)localObject).putStringArrayListExtra("key_color_note_suptype_list", localArrayList2);
      aeba.a(this.mApp, null);
      aeee.ef(this);
      QQToast.a(BaseApplication.getContext(), 0, "彩签已取消", 1).show();
      if (i != 0) {
        QQPlayerService.eG(this);
      }
      ((Intent)localObject).putExtra("extra_can_add_colornote", localaebo.canAddColorNote());
      sendBroadcast((Intent)localObject);
      return;
    }
  }
  
  public void cWl()
  {
    if (!this.Vn) {
      if (this.mApp == null) {
        break label522;
      }
    }
    label522:
    for (boolean bool1 = aeds.checkPermission(this.mApp.getApp());; bool1 = false)
    {
      boolean bool2;
      int i;
      if (this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getVisibility() == 0)
      {
        bool2 = true;
        if ((!bool1) || (!mShouldShow) || (!this.Vp) || (!this.bTc)) {
          break label487;
        }
        i = 1;
        label63:
        if (QLog.isColorLevel())
        {
          QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + bool2 + ", isOpEnable = " + bool1 + ", mShouldShow = " + mShouldShow + ", mIsAppOnForeground = " + this.Vp + ", mIsNotInColorNoteList = " + this.bTc + ", Toast Isvisiable = " + this.jdField_a_of_type_Aeed.vH());
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
          localObject2 = new Rect();
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
          QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + localObject1 + "], mScreenWidth[" + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getScreenWidth() + "], mScreenHeight[" + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getScreenHeight() + "], mWindowWidth[" + ((Rect)localObject2).width() + "], mWindowHeight[" + ((Rect)localObject2).height() + "]");
        }
        if (i == 0) {
          break label504;
        }
        if (!this.jdField_a_of_type_Aeed.vH()) {
          this.jdField_a_of_type_Aeed.vG();
        }
        Object localObject2 = this.mApp.a().a();
        Object localObject1 = ((aebo)localObject2).ep();
        ((aebo)localObject2).r(false);
        this.cMi = ((List)localObject1).size();
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.jH((List)localObject1);
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.cMi + ", sumcount = " + ((aebo)localObject2).Cf());
        }
        if (this.cMi <= 0) {
          break label492;
        }
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cVX();
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        localObject2 = String.format(getResources().getString(2131691717), new Object[] { Integer.valueOf(this.cMi) });
        localObject1 = aebs.F((List)localObject1);
        this.focusView.setContentDescription((String)localObject2 + (String)localObject1);
      }
      label487:
      label492:
      label504:
      while (!bool2) {
        for (;;)
        {
          return;
          bool2 = false;
          break;
          i = 0;
          break label63;
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
      reset();
      return;
    }
  }
  
  public int d(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Aeed.b().x;
  }
  
  public int e(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Aeed.b().y;
  }
  
  public List<ColorNote> eq()
  {
    return this.yJ;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      this.mApp = ((QQAppInterface)this.app);
      ((QQAppInterface)this.app).addObserver(new aebn());
    }
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.Vo = aeds.checkPermission(BaseApplicationImpl.getContext());
      localObject3 = new IntentFilter();
      ((IntentFilter)localObject3).addAction("action_update_cn_smallscreen_state");
      ((IntentFilter)localObject3).addAction("mqq.intent.action.QQ_BACKGROUND");
      ((IntentFilter)localObject3).addAction("mqq.intent.action.QQ_FOREGROUND");
      registerReceiver(this.mReceiver, (IntentFilter)localObject3);
      cWj();
      if ((!this.Vo) || (localLayoutInflater == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate mIsOpEnable " + this.Vo);
        }
        aeee.ef(this);
        return;
        aeee.ef(this);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localException);
        }
        Object localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localOutOfMemoryError);
        }
        localObject2 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2131559022, null));
      this.focusView = this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131367361);
      this.focusView.bringToFront();
      this.focusView.setOnTouchListener(new aeeb(this));
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.agr();
      this.iC = ((LinearLayout)this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131378506));
      this.jdField_a_of_type_Aeed = new aeed(this, this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
      Object localObject3 = "";
      Object localObject2 = localObject3;
      try
      {
        List localList = this.mApp.a().a().ep();
        localObject2 = localObject3;
        this.cMi = localList.size();
        localObject2 = localObject3;
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.jH(localList);
        localObject2 = localObject3;
        localObject3 = aebs.F(localList);
        localObject2 = localObject3;
        jI(localList);
        localObject2 = localObject3;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          int j;
          int k;
          int m;
          int n;
          int i;
          boolean bool;
          aeee.ef(this);
          continue;
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839496);
          continue;
          if (j <= 0) {
            this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839497);
          } else {
            this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839499);
          }
        }
        aebd.Hd(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setUpcomingController(this);
      setLayoutParams(this.jdField_a_of_type_Aeed.b());
      localObject3 = aqmj.c(this, this.mApp.getCurrentUin());
      j = ((SharedPreferences)localObject3).getInt("colornote_windows_x", -1);
      k = ((SharedPreferences)localObject3).getInt("colornote_windows_y", -1);
      m = aqnm.getScreenWidth();
      n = aqnm.getScreenHeight();
      this.mOffset = wja.dp2px(8.0F, getResources());
      if (((j != -1) || (k != -1)) && (j <= m))
      {
        i = k;
        if (k <= n) {}
      }
      else
      {
        i = aqnm.getScreenWidth();
        j = getResources().getDimensionPixelSize(2131296853);
        j = this.mOffset + (i - j);
        i = aqnm.getScreenHeight() / 2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + j + ", " + i + "]");
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenWidth = " + m);
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + n);
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
      aeee.hH(this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.Cg() / 2 + j, i + this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.bR() / 2);
      bool = ColorNoteSmallScreenRelativeLayout.agu();
      if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bool)) {
        if (j <= 0)
        {
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839494);
          localObject3 = String.format(getResources().getString(2131691717), new Object[] { Integer.valueOf(this.cMi) });
          this.focusView.setContentDescription((String)localObject3 + (String)localObject2);
          aqcl.Q(this.focusView, true);
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
          if (this.gi == null) {
            this.gi = new OnSelectMemberActivityIsResumeChangedRunnable();
          }
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
          this.Vn = false;
          this.Vp = aeee.isAppOnForeground(this);
          cWl();
          if (this.bA == null) {
            this.bA = new OnOpChangedRunnable();
          }
          b().postDelayed(this.bA, 1000L);
          this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.cVZ();
          ((aebm)this.mApp.getBusinessHandler(168)).cVH();
          localObject2 = aebr.a();
          if ((localObject2 == null) || (!((aebq)localObject2).agp())) {
            break label1016;
          }
          aebd.Hd(true);
          return;
        }
      }
    }
    label1016:
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.Vn = true;
    try
    {
      unregisterReceiver(this.mReceiver);
      cWk();
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser.destory();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null) {
        this.jdField_a_of_type_Aeed.arg();
      }
      if (this.bA != null) {
        b().removeCallbacks(this.bA);
      }
      this.mApp = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "unregisterReceiver", localRuntimeException);
        }
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onPostThemeChanged");
    }
    Point localPoint = this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
    boolean bool = ColorNoteSmallScreenRelativeLayout.agu();
    if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bool)) {
      if (localPoint.x <= 0) {
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839494);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Aecj != null) {
        this.jdField_b_of_type_Aecj.onPostThemeChanged();
      }
      return;
      this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839496);
      continue;
      if (localPoint.x <= 0) {
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839497);
      } else {
        this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839499);
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("KEY_CMD_SHOW_LIST", 0) == 1) && (this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null))
    {
      dp(paramIntent);
      a(this.jdField_b_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b(), paramIntent.getBooleanExtra("KEY_SHOW_LIST_LAND", true));
    }
    e(paramIntent, paramInt1, paramInt2);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void r(ColorNote paramColorNote)
  {
    if (this.yJ != null)
    {
      this.yJ.remove(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "remove note: " + paramColorNote.toString());
      }
    }
  }
  
  class OnOpChangedRunnable
    implements Runnable
  {
    OnOpChangedRunnable() {}
    
    public void run()
    {
      if (!ColorNoteSmallScreenService.this.Vn) {}
    }
  }
  
  class OnSelectMemberActivityIsResumeChangedRunnable
    implements Runnable
  {
    OnSelectMemberActivityIsResumeChangedRunnable() {}
    
    public void run()
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "OnSelectMemberActivityIsResumeChangedRunnable");
      }
      ColorNoteSmallScreenService.this.cWl();
      if (!ColorNoteSmallScreenService.this.Vp)
      {
        ColorNoteSmallScreenService.this.cVJ();
        ColorNoteSmallScreenService.this.a.arg();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService
 * JD-Core Version:    0.7.0.1
 */