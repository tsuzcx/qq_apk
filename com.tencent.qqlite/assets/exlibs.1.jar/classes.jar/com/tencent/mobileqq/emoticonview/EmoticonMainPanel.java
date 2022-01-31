package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.ClubContentUpdateHandler.ClubContentUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import dep;
import der;
import det;
import dev;
import dex;
import dey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EmoticonMainPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, EmoticonPackageChangedListener, HorizonEmoticonTabs.EmoticonTabChangeListener
{
  public static final int a = 1;
  public static final long a = 86400000L;
  protected static final String a = "EmoticonMainPanel";
  public static final int b = 2;
  public static long b = 0L;
  public static final String b = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
  public static final int c = 3;
  public static final String c = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
  public static final int d = 10;
  public static final String d = "report_AIOEmoticonPanel_ReopenInAIO";
  public static final int e = 1;
  public static final String e = "emoticon_panel_";
  public static final int f = 2;
  public static final String f = "panelMode";
  public static int g = 0;
  public static final String g = "duration";
  private static boolean g = false;
  public static int h = 0;
  public static final String h = "sp_key_emoticon_panel_last_report_time";
  public static int i = 0;
  public static final String i = "sp_key_emoticon_panel_report_count";
  public Context a;
  public ViewPager a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ClubContentUpdateHandler.ClubContentUpdateListener jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener = new dep(this);
  public QQAppInterface a;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new der(this);
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  public EmoticonPageIndicator a;
  public EmoticonPagerAdapter a;
  public HorizonEmoticonTabs a;
  public List a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  EmoticonPackageDownloadListener jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new det(this);
  private HorizonEmoticonTabs jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs;
  public List b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  public List c;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  public int j;
  private int k = 0;
  private int l;
  
  static
  {
    jdField_g_of_type_Int = 1;
    h = 1;
    i = 0;
    jdField_g_of_type_Boolean = true;
  }
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return 0;
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        int n;
        int m;
        if (paramBoolean)
        {
          n = this.jdField_c_of_type_JavaUtilList.size();
          m = 0;
          while (m < n)
          {
            paramString = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(m);
            if ((paramString != null) && ((paramString instanceof MagicFaceViewBinder))) {
              return m;
            }
            m += 1;
          }
        }
        else
        {
          paramString = paramString.split("\\|");
          if ((paramString != null) && (paramString.length > 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.getChildCount() > 0))
          {
            m = paramString.length - 1;
            while (m >= 0)
            {
              Object localObject = paramString[m];
              n = 0;
              while (n < this.jdField_c_of_type_JavaUtilList.size())
              {
                EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(n);
                if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof BigEmoticonViewBinder)) && (localObject.equals(((BigEmoticonViewBinder)localEmoticonViewBinder).a.epId))) {
                  return n;
                }
                n += 1;
              }
              m -= 1;
            }
          }
        }
      }
    }
  }
  
  private String a(EmoticonViewBinder paramEmoticonViewBinder)
  {
    if (paramEmoticonViewBinder == null) {}
    do
    {
      do
      {
        return "";
        if (!(paramEmoticonViewBinder instanceof BigEmoticonViewBinder)) {
          break;
        }
        paramEmoticonViewBinder = (BigEmoticonViewBinder)paramEmoticonViewBinder;
      } while (paramEmoticonViewBinder.a == null);
      return paramEmoticonViewBinder.a.epId;
      if ((paramEmoticonViewBinder instanceof MagicFaceViewBinder)) {
        return "8";
      }
    } while (!(paramEmoticonViewBinder instanceof RecommendEmoticonViewBinder));
    return "7";
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    long l1 = System.currentTimeMillis();
    int m;
    if (!EmoticonUtils.d(this.k))
    {
      int n = 1;
      m = n;
      paramInt1 = paramInt2;
      if (paramInt2 >= 2)
      {
        paramInt1 = 1;
        m = n;
      }
      a(m, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - l1));
      }
      return;
    }
    Object localObject1 = getContext().getSharedPreferences("QQLite", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("LAST_ADD_EMO_PACKAGE", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramInt1 = 0;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      g();
      ((SharedPreferences)localObject1).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
      boolean bool = ((SharedPreferences)localObject1).getBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", false);
      ((SharedPreferences)localObject1).edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").commit();
      if (paramString == null) {
        paramInt1 = a((String)localObject2, bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in market, selectIndex:" + paramInt1);
      }
      m = 2;
      label227:
      if (paramString == null) {
        break label370;
      }
      g();
      if (this.jdField_c_of_type_JavaUtilList == null) {
        break label582;
      }
      paramInt1 = 0;
      paramInt2 = this.jdField_c_of_type_JavaUtilList.size();
      label254:
      if (paramInt1 >= paramInt2) {
        break label618;
      }
      localObject1 = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(paramInt1);
      if ((localObject1 == null) || (!(localObject1 instanceof BigEmoticonViewBinder))) {
        break label372;
      }
      localObject1 = (BigEmoticonViewBinder)localObject1;
      if ((((BigEmoticonViewBinder)localObject1).a == null) || (!paramString.equals(((BigEmoticonViewBinder)localObject1).a.epId))) {
        break label372;
      }
    }
    label324:
    label467:
    label602:
    label610:
    label618:
    for (paramInt2 = paramInt1;; paramInt2 = -1)
    {
      if (paramInt2 != -1)
      {
        paramInt1 = paramInt2;
        m = 2;
        break;
        if ((paramInt1 == 2) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in panel, refresh");
          }
          this.jdField_b_of_type_Boolean = false;
        }
        m = paramInt1;
        paramInt1 = paramInt2;
        break label227;
        label370:
        break;
        label372:
        paramInt1 += 1;
        break label254;
      }
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        m = -1;
        localObject1 = null;
        paramInt1 = 0;
        paramInt2 = this.jdField_c_of_type_JavaUtilList.size();
        if (paramInt1 >= paramInt2) {
          break label610;
        }
        localObject2 = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(paramInt1);
        if ((localObject2 != null) && ((localObject2 instanceof MagicFaceViewBinder)))
        {
          localObject1 = (MagicFaceViewBinder)localObject2;
          localObject2 = ((MagicFaceViewBinder)localObject1).a();
          if (localObject2 == null) {
            break label602;
          }
          paramInt2 = 0;
          m = ((List)localObject2).size();
          if (paramInt2 >= m) {
            break label595;
          }
          Object localObject3 = (EmoticonInfo)((List)localObject2).get(paramInt2);
          if ((localObject3 != null) && ((localObject3 instanceof PicEmoticonInfo)))
          {
            localObject3 = (PicEmoticonInfo)localObject3;
            if ((((PicEmoticonInfo)localObject3).a != null) && (paramString.equals(((PicEmoticonInfo)localObject3).a.epId)))
            {
              paramString = (String)localObject1;
              m = paramInt2;
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt1 != -1)
        {
          paramInt2 = paramInt1;
          if (paramString == null) {
            break label324;
          }
          paramInt2 = paramInt1;
          if (m == -1) {
            break label324;
          }
          paramString.a = (m / 8);
          paramInt2 = paramInt1;
          break label324;
          paramInt2 += 1;
          break label467;
          paramInt1 += 1;
          break label404;
          paramInt1 = 0;
          m = 2;
          break;
        }
        paramInt2 = 0;
        break label324;
        paramInt2 = -1;
        paramInt1 = -1;
        break label529;
        paramString = (String)localObject1;
        paramInt1 = -1;
        continue;
        paramInt1 = -1;
        paramString = (String)localObject1;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localObject = (EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if ((localObject != null) && ((localObject instanceof EmoticonPanelViewBinder)))
    {
      localObject = (EmoticonPanelViewBinder)localObject;
      ((EmoticonPanelViewBinder)localObject).b();
      boolean bool1 = localObject instanceof ClassicEmoticonPanelViewBinder;
      boolean bool2 = localObject instanceof RecentAndFavPanelViewBinder;
      int m = ((EmoticonPanelViewBinder)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setRecent(bool2);
      if (m == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(8);
      }
      for (;;)
      {
        m = ((EmoticonPanelViewBinder)localObject).a;
        n = m;
        if (paramInt < 1) {
          break label184;
        }
        n = m;
        if (!paramBoolean) {
          break label184;
        }
        n = 0;
        while (n <= paramInt - 1)
        {
          m += ((EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(n)).b();
          n += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.a(m, bool1);
      }
      int n = m;
      label184:
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(n, false);
      if ((localObject instanceof MagicFaceViewBinder)) {
        ((EmoticonPanelViewBinder)localObject).a = 0;
      }
    }
  }
  
  private void f()
  {
    if (this.e) {}
    long l1;
    label143:
    label196:
    label211:
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
          if (localEmoticonViewBinder != null) {
            localEmoticonViewBinder.a();
          }
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList = null;
      }
      this.jdField_b_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.k, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.c();
      int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      int i2 = i1 / 3;
      int m;
      int n;
      if (EmoticonUtils.d(this.k))
      {
        m = 3;
        n = 0;
        if (n >= m) {
          break label211;
        }
        localObject = (EmoticonViewBinder)this.jdField_b_of_type_JavaUtilList.get(n);
        if (n != 2) {
          break label196;
        }
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, i1 - i2 * 2, false);
      }
      for (;;)
      {
        n += 1;
        break label143;
        m = 2;
        break;
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, i2, true);
      }
      this.e = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "[Performance] initMainTabView duration:" + (System.currentTimeMillis() - l1));
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Boolean) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject;
      EmoticonViewBinder localEmoticonViewBinder;
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_c_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
          if (localEmoticonViewBinder != null) {
            localEmoticonViewBinder.a();
          }
        }
        this.jdField_c_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_JavaUtilList = null;
      }
      this.jdField_c_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.c();
      int n = this.jdField_c_of_type_JavaUtilList.size();
      int m = 0;
      if (m < n)
      {
        if (m == 0)
        {
          localObject = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(m);
          if (((EmoticonViewBinder)localObject).n == 8)
          {
            int i1 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493011);
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, i1, true);
          }
          for (;;)
          {
            m += 1;
            break;
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, true);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs;
        localEmoticonViewBinder = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(m);
        if (m != n - 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((HorizonEmoticonTabs)localObject).a(localEmoticonViewBinder, bool);
          break;
        }
      }
      this.jdField_b_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l1));
  }
  
  public int a()
  {
    return this.j;
  }
  
  public void a()
  {
    StartupTracker.a(null, "AIO_EmoticonPanel_OnResume");
    Object localObject = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
    if (localObject != null)
    {
      ((EmojiManager)localObject).a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      ((EmojiManager)localObject).a.a(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    localObject = (ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(14);
    if (localObject != null) {
      ((ClubContentUpdateHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    }
    if ((getVisibility() == 0) && (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_b_of_type_Boolean = false;
      a(null);
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (isShown())
      {
        if ((EmoticonUtils.d(this.k)) && (!TextUtils.isEmpty(getContext().getSharedPreferences("QQLite", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "download in market, initEmoticonView");
          }
          a(2, 0, null);
        }
        e();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    jdField_g_of_type_Int = paramInt1;
    Object localObject;
    if (paramInt1 == 1)
    {
      StartupTracker.a(null, "AIO_EmoticonPanel_EnterFirst");
      if (!this.e) {
        f();
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
      if (paramInt2 >= 0)
      {
        m = paramInt2;
        if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size()) {}
      }
      else
      {
        m = 0;
      }
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(m);
      localObject = new ArrayList(1);
      ((List)localObject).add(this.jdField_b_of_type_JavaUtilList.get(m));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a((List)localObject);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
      a(m, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
      h = m;
      if (m == 0) {
        e();
      }
      StartupTracker.a("AIO_EmoticonPanel_EnterFirst", null);
    }
    while (paramInt1 != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to " + paramInt1 + ", duration:" + (System.currentTimeMillis() - l1));
      }
      return;
    }
    StartupTracker.a(null, "AIO_EmoticonPanel_EnterSecond");
    int m = paramInt2;
    if (!this.jdField_b_of_type_Boolean)
    {
      g();
      m = paramInt2;
      if (this.jdField_a_of_type_Boolean)
      {
        m = paramInt2;
        if (this.jdField_c_of_type_JavaUtilList != null)
        {
          m = paramInt2;
          if (this.jdField_c_of_type_JavaUtilList.size() > 0)
          {
            localObject = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(0);
            if (((EmoticonViewBinder)localObject).n != 8) {
              break label497;
            }
            if (this.jdField_c_of_type_JavaUtilList.size() < 3) {
              break label492;
            }
            m = 2;
          }
        }
        label320:
        this.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
    if (m >= 0)
    {
      paramInt2 = m;
      if (m < this.jdField_a_of_type_JavaUtilList.size() - 1) {}
    }
    else
    {
      paramInt2 = 0;
    }
    i = paramInt2;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(8);
      label407:
      localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localObject != null)
      {
        if (((GameCenterManagerImp)localObject).a("100005.100001") == -1) {
          break label591;
        }
        paramInt2 = 1;
        label440:
        if (paramInt2 == 0) {
          break label596;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_hdshow", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_EnterSecond", null);
      break;
      label492:
      m = 0;
      break label320;
      label497:
      if (((EmoticonViewBinder)localObject).n == 9)
      {
        if (this.jdField_c_of_type_JavaUtilList.size() >= 2)
        {
          m = 1;
          break label320;
        }
        m = 0;
        break label320;
      }
      m = 0;
      break label320;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(this.jdField_a_of_type_JavaUtilList, false);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
      a(paramInt2, true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
      break label407;
      label591:
      paramInt2 = 0;
      break label440;
      label596:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.k = paramInt1;
    this.j = paramInt2;
    this.l = super.getResources().getConfiguration().orientation;
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = ((HorizonEmoticonTabs)super.findViewById(2131297073));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setEmoticonTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator = ((EmoticonPageIndicator)super.findViewById(2131297067));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)super.findViewById(2131297066));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297064);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297072);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131297074);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = ((HorizonEmoticonTabs)super.findViewById(2131297077));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setEmoticonTabChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297076));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297075));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297078));
    paramContext = (EmojiManager)paramQQAppInterface.getManager(39);
    if (paramContext != null)
    {
      paramContext.a.a(this);
      paramContext.a.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      paramContext.a.a(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    paramQQAppInterface = (ClubContentUpdateHandler)paramQQAppInterface.a(14);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    }
    a(paramString);
    this.f = true;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageDeleted");
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageMoved");
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    int n = jdField_g_of_type_Int;
    if (jdField_g_of_type_Int == 1) {}
    for (int m = h;; m = i)
    {
      a(n, m, paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    while (!paramBoolean) {
      return;
    }
  }
  
  public void b()
  {
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    ((ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(14)).b(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "OnTabChanged, oldIndex=" + paramInt1 + ", newIndex=" + paramInt2);
    }
    StartupTracker.a(null, "AIO_EmoticonPanel_TabClick");
    label71:
    label77:
    Object localObject;
    if (jdField_g_of_type_Int == 1)
    {
      if (EmoticonUtils.d(this.k)) {
        if (paramInt2 <= 2) {
          break label77;
        }
      }
      do
      {
        break label71;
        do
        {
          return;
        } while (paramInt2 > 1);
        if (paramInt2 >= this.jdField_b_of_type_JavaUtilList.size() - 1) {
          break;
        }
      } while (h == paramInt2);
      localObject = new ArrayList(1);
      ((List)localObject).add(this.jdField_b_of_type_JavaUtilList.get(paramInt2));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a((List)localObject);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
      a(paramInt2, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
      h = paramInt2;
      if (paramInt2 == 0) {
        e();
      }
      label170:
      localObject = null;
      switch (paramInt2)
      {
      default: 
        label200:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_TabClick", null);
      return;
      if (paramInt2 != this.jdField_b_of_type_JavaUtilList.size() - 1) {
        break label170;
      }
      a(2, i);
      break label170;
      localObject = "0X800479C";
      break label200;
      localObject = "0X800479D";
      break label200;
      localObject = "0X800479E";
      break label200;
      if (jdField_g_of_type_Int == 2)
      {
        if ((this.jdField_c_of_type_JavaUtilList == null) || (paramInt2 >= this.jdField_c_of_type_JavaUtilList.size())) {
          break;
        }
        localObject = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(paramInt2);
        if (101 != ((EmoticonViewBinder)localObject).n)
        {
          if (i == paramInt2)
          {
            if (!(localObject instanceof RecommendEmoticonViewBinder)) {
              break;
            }
            localObject = (Bundle)((RecommendEmoticonViewBinder)localObject).b(0).getTag();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", ((Bundle)localObject).getString("key"), 0, 0, ((Bundle)localObject).getString("id"), "", "", "");
            return;
          }
          i = paramInt2;
          a(paramInt2, true);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
          if (localObject == null) {
            continue;
          }
          if ((localObject instanceof BigEmoticonViewBinder))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A1", "0X80047A1", 0, 0, a((EmoticonViewBinder)localObject), paramInt2 - 1 + "", "", "");
            localObject = (BigEmoticonViewBinder)localObject;
            if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a(paramInt2)) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_hdclick", 0, 0, ((BigEmoticonViewBinder)localObject).a.epId, "", "", "");
            continue;
          }
          if ((localObject instanceof MagicFaceViewBinder))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A0", "0X80047A0", 0, 0, "", "", "", "");
            continue;
          }
          if (!(localObject instanceof RecommendEmoticonViewBinder)) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A4", "0X80047A4", 0, 0, "", "", "", "");
          continue;
        }
        localObject = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
        Intent localIntent = new Intent(((ChatActivity)localObject).getActivity(), EmosmActivity.class);
        localIntent.putExtra("extra_launch_source", 1);
        ((ChatActivity)localObject).startActivity(localIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A2", "0X80047A2", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageAdded");
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    Object localObject = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39);
    if (localObject != null)
    {
      ((EmojiManager)localObject).a.b(this);
      ((EmojiManager)localObject).a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      ((EmojiManager)localObject).a.b(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    ((ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(14)).b(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.d();
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.d();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = null;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a();
    }
    EmoticonViewBinder localEmoticonViewBinder;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
        if (localEmoticonViewBinder != null) {
          localEmoticonViewBinder.a();
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
        if (localEmoticonViewBinder != null) {
          localEmoticonViewBinder.a();
        }
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
        if (localEmoticonViewBinder != null) {
          localEmoticonViewBinder.a();
        }
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
    this.e = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  public void d()
  {
    if (!isShown()) {}
    while (jdField_g_of_type_Int != 2) {
      return;
    }
    ThreadManager.b(new dev(this));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int m = 1;
    super.dispatchDraw(paramCanvas);
    if (jdField_b_of_type_Long == -1L) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis() - jdField_b_of_type_Long;
    } while (l1 <= 0L);
    HashMap localHashMap = new HashMap(2);
    if (jdField_g_of_type_Int == 1) {}
    for (paramCanvas = "1"; jdField_g_of_type_Boolean; paramCanvas = "2")
    {
      localHashMap.put("panelMode", paramCanvas);
      localHashMap.put("duration", String.valueOf(l1));
      ThreadManager.b(new dey(this, m, l1, localHashMap));
      StartupTracker.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + m + ",panelMode=" + paramCanvas);
      }
      jdField_b_of_type_Long = -1L;
      this.f = false;
      jdField_g_of_type_Boolean = false;
      return;
    }
    if (this.f) {}
    for (m = 2;; m = 3) {
      break;
    }
  }
  
  public void e()
  {
    if (!isShown())
    {
      this.d = true;
      return;
    }
    postDelayed(new dex(this), 200L);
    this.d = false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297076: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800479F", "0X800479F", 0, 0, "", "", "", "");
      a(1, h);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramView = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    int m;
    int n;
    label134:
    int i1;
    label148:
    boolean bool;
    if (paramView != null)
    {
      if (paramView.a("100005.100001") == -1) {
        break label317;
      }
      m = 1;
      if (m != 0)
      {
        if (paramView.a("100005.100003") == -1) {
          break label322;
        }
        n = 1;
        if (paramView.a("100005.100002") == -1) {
          break label327;
        }
        i1 = 1;
        bool = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38)).jdField_a_of_type_Boolean;
        if (!bool) {
          break label343;
        }
        if (paramView.a("100005.100011") == -1) {
          break label333;
        }
        m = 1;
      }
    }
    for (;;)
    {
      label183:
      if (((bool) && (n == 0) && (i1 == 0) && (m == 0)) || ((!bool) && (n == 0) && (i1 == 0))) {
        if (paramView.a("100005") == -1) {
          break label338;
        }
      }
      label317:
      label322:
      label327:
      label333:
      label338:
      for (m = 1;; m = 0)
      {
        if (m != 0)
        {
          BusinessInfoCheckUpdateItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "100005", false);
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).b("100005");
        }
        EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
        return;
        m = 0;
        break;
        n = 0;
        break label134;
        i1 = 0;
        break label148;
        m = 0;
        break label183;
      }
      label343:
      m = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_PageScroll");
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPageSelected, position=" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    label138:
    label360:
    label379:
    for (;;)
    {
      return;
      if (jdField_g_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.onPageSelected(paramInt);
      }
      while (jdField_g_of_type_Int != 2)
      {
        StartupTracker.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
        return;
      }
      int i1 = 0;
      Object localObject1 = null;
      int m = 0;
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      if (m < i2)
      {
        Object localObject2 = (EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(m);
        n = i1;
        if (localObject2 != null)
        {
          n = i1;
          if ((localObject2 instanceof EmoticonPanelViewBinder))
          {
            localObject2 = (EmoticonPanelViewBinder)localObject2;
            int i3 = ((EmoticonPanelViewBinder)localObject2).b();
            i1 += i3;
            n = i1;
            if (paramInt + 1 <= i1)
            {
              n = ((EmoticonPanelViewBinder)localObject2).a();
              localObject1 = localObject2;
              i1 = i3 - (i1 - paramInt);
              paramInt = n;
            }
          }
        }
      }
      for (int n = i1;; n = -1)
      {
        if ((n == -1) || (localObject1 == null)) {
          break label379;
        }
        if (i != m)
        {
          if (paramInt == 0) {
            break label360;
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.a(paramInt, false);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(m, false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_slidetab", 0, 0, a(localObject1), "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.onPageSelected(n);
          if (((localObject1 instanceof BigEmoticonViewBinder)) && (n == 0)) {
            ((BigEmoticonViewBinder)localObject1).d();
          }
          i = m;
          break;
          m += 1;
          i1 = n;
          break label138;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(8);
        }
        paramInt = 0;
        m = 0;
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setToastOffset(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      if (paramInt == 0)
      {
        paramInt = super.getResources().getConfiguration().orientation;
        if (this.l != paramInt) {
          this.e = false;
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label109;
        }
        this.jdField_b_of_type_Boolean = false;
        a(null);
        this.jdField_c_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.l = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      label109:
      if ((!TextUtils.isEmpty(getContext().getSharedPreferences("QQLite", 0).getString("LAST_ADD_EMO_PACKAGE", ""))) || (this.l != paramInt)) {
        a(null);
      } else if ((jdField_g_of_type_Int == 1) && (h == 0) && (this.d)) {
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */