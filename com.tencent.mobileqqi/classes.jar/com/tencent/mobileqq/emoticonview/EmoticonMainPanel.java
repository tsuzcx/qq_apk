package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.ClubContentUpdateHandler.ClubContentUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.qphone.base.util.QLog;
import fsu;
import fsw;
import fsy;
import fta;
import ftc;
import ftd;
import fte;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmoticonMainPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, EmoticonPackageChangedListener, HorizonEmoticonTabs.EmoticonTabChangeListener
{
  public static final int a = 1;
  protected static final String a = "EmoticonMainPanel";
  public static final int b = 2;
  private static int jdField_d_of_type_Int = 1;
  private static int e = 1;
  private static int f = 0;
  private static final int g = 0;
  private static final int h = 0;
  private static final int i = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ClubContentUpdateHandler.ClubContentUpdateListener jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener = new fsu(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new fsw(this);
  public EmoticonCallback a;
  private EmoticonPageIndicator jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator;
  private EmoticonPagerAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter;
  private EmoticonViewPager jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager;
  private HorizonEmoticonTabs jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs;
  private Runnable jdField_a_of_type_JavaLangRunnable = new fte(this);
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  EmoticonPackageDownloadListener jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new fsy(this);
  private HorizonEmoticonTabs jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private List jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private int j = 0;
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs == null) || ("".equals(paramString))) {}
    for (;;)
    {
      return 0;
      if (this.jdField_c_of_type_JavaUtilList != null)
      {
        int m;
        int k;
        if (paramBoolean)
        {
          m = this.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          while (k < m)
          {
            paramString = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(k);
            if ((paramString != null) && ((paramString instanceof MagicFaceViewBinder))) {
              return k;
            }
            k += 1;
          }
        }
        else
        {
          paramString = paramString.split("\\|");
          if ((paramString != null) && (paramString.length > 0) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.getChildCount() > 0))
          {
            k = paramString.length - 1;
            while (k >= 0)
            {
              Object localObject = paramString[k];
              m = 0;
              while (m < this.jdField_c_of_type_JavaUtilList.size())
              {
                EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(m);
                if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof BigEmoticonViewBinder)) && (localObject.equals(((BigEmoticonViewBinder)localEmoticonViewBinder).a.epId))) {
                  return m;
                }
                m += 1;
              }
              k -= 1;
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
    long l = System.currentTimeMillis();
    int k;
    if (!EmoticonUtils.d(this.j))
    {
      int m = 1;
      k = m;
      paramInt1 = paramInt2;
      if (paramInt2 >= 2)
      {
        paramInt1 = 1;
        k = m;
      }
      b(k, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - l));
      }
      return;
    }
    Object localObject1 = getContext().getSharedPreferences("mobileQQi", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("LAST_ADD_EMO_PACKAGE", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramInt1 = 0;
      this.jdField_c_of_type_Boolean = false;
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
      k = 1;
      label227:
      if (paramString == null) {
        break label370;
      }
      g();
      if (this.jdField_b_of_type_JavaUtilList == null) {
        break label582;
      }
      paramInt1 = 0;
      paramInt2 = this.jdField_b_of_type_JavaUtilList.size();
      label254:
      if (paramInt1 >= paramInt2) {
        break label618;
      }
      localObject1 = (EmoticonViewBinder)this.jdField_b_of_type_JavaUtilList.get(paramInt1);
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
        k = 1;
        break;
        if ((paramInt1 == 1) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in panel, refresh");
          }
          this.jdField_c_of_type_Boolean = false;
        }
        k = paramInt1;
        paramInt1 = paramInt2;
        break label227;
        label370:
        break;
        label372:
        paramInt1 += 1;
        break label254;
      }
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        k = -1;
        localObject1 = null;
        paramInt1 = 0;
        paramInt2 = this.jdField_b_of_type_JavaUtilList.size();
        if (paramInt1 >= paramInt2) {
          break label610;
        }
        localObject2 = (EmoticonViewBinder)this.jdField_b_of_type_JavaUtilList.get(paramInt1);
        if ((localObject2 != null) && ((localObject2 instanceof MagicFaceViewBinder)))
        {
          localObject1 = (MagicFaceViewBinder)localObject2;
          localObject2 = ((MagicFaceViewBinder)localObject1).a();
          if (localObject2 == null) {
            break label602;
          }
          paramInt2 = 0;
          k = ((List)localObject2).size();
          if (paramInt2 >= k) {
            break label595;
          }
          Object localObject3 = (EmoticonInfo)((List)localObject2).get(paramInt2);
          if ((localObject3 != null) && ((localObject3 instanceof PicEmoticonInfo)))
          {
            localObject3 = (PicEmoticonInfo)localObject3;
            if ((((PicEmoticonInfo)localObject3).a != null) && (paramString.equals(((PicEmoticonInfo)localObject3).a.epId)))
            {
              paramString = (String)localObject1;
              k = paramInt2;
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
          if (k == -1) {
            break label324;
          }
          paramString.a = (k / 8);
          paramInt2 = paramInt1;
          break label324;
          paramInt2 += 1;
          break label467;
          paramInt1 += 1;
          break label404;
          paramInt1 = 0;
          k = 1;
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
    EmoticonViewBinder localEmoticonViewBinder = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localEmoticonViewBinder = (EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof EmoticonPanelViewBinder))) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    jdField_d_of_type_Int = paramInt1;
    int k;
    Object localObject;
    if (paramInt1 == 1)
    {
      if (!this.jdField_c_of_type_Boolean) {
        g();
      }
      k = paramInt2;
      if (this.jdField_a_of_type_Boolean)
      {
        k = paramInt2;
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          k = paramInt2;
          if (this.jdField_b_of_type_JavaUtilList.size() > 0)
          {
            localObject = (EmoticonViewBinder)this.jdField_b_of_type_JavaUtilList.get(0);
            if (this.jdField_b_of_type_JavaUtilList.size() < 4) {
              break label273;
            }
            paramInt2 = 3;
            this.jdField_a_of_type_Boolean = false;
            k = paramInt2;
          }
        }
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
      if (k >= 0)
      {
        paramInt2 = k;
        if (k < this.jdField_a_of_type_JavaUtilList.size()) {}
      }
      else
      {
        paramInt2 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(paramInt2);
      new ArrayList(1).add(this.jdField_b_of_type_JavaUtilList.get(paramInt2));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
      a(paramInt2, true);
      e = paramInt2;
      if (paramInt2 == 0)
      {
        e();
        label212:
        if (paramInt2 != 1) {
          break label289;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to " + paramInt1 + ", duration:" + (System.currentTimeMillis() - l));
      }
      return;
      label273:
      paramInt2 = 0;
      break;
      if (paramInt2 != 0) {
        break label212;
      }
      f();
      break label212;
      label289:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if (paramInt1 == 2)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        k = paramInt2;
        if (!this.jdField_d_of_type_Boolean)
        {
          h();
          k = paramInt2;
          if (this.jdField_a_of_type_Boolean)
          {
            k = paramInt2;
            if (this.jdField_c_of_type_JavaUtilList != null)
            {
              k = paramInt2;
              if (this.jdField_c_of_type_JavaUtilList.size() > 0)
              {
                localObject = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(0);
                if (((EmoticonViewBinder)localObject).n != 8) {
                  break label570;
                }
                if (this.jdField_c_of_type_JavaUtilList.size() < 3) {
                  break label565;
                }
                k = 2;
              }
            }
            label400:
            this.jdField_a_of_type_Boolean = false;
          }
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_JavaUtilList = this.jdField_c_of_type_JavaUtilList;
        if (k >= 0)
        {
          paramInt2 = k;
          if (k < this.jdField_a_of_type_JavaUtilList.size() - 1) {}
        }
        else
        {
          paramInt2 = 0;
        }
        f = paramInt2;
        if (this.jdField_a_of_type_JavaUtilList.size() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setAdapter(null);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(8);
          label487:
          localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
          if (localObject == null) {
            continue;
          }
          if (((GameCenterManagerImp)localObject).a("100005.100001") == -1) {
            break label656;
          }
        }
        label656:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label661;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_hdshow", 0, 0, "", "", "", "");
          break;
          label565:
          k = 0;
          break label400;
          label570:
          if (((EmoticonViewBinder)localObject).n == 9)
          {
            if (this.jdField_c_of_type_JavaUtilList.size() >= 2)
            {
              k = 1;
              break label400;
            }
            k = 0;
            break label400;
          }
          k = 0;
          break label400;
          this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(this.jdField_a_of_type_JavaUtilList, false);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
          a(paramInt2, true);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
          break label487;
        }
        label661:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
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
      this.jdField_b_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.j, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.b();
      int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      int m = (int)(getResources().getDisplayMetrics().density * 60.0F);
      int n = this.jdField_b_of_type_JavaUtilList.size();
      k = 0;
      while (k < n)
      {
        localObject = (EmoticonViewBinder)this.jdField_b_of_type_JavaUtilList.get(k);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, m, true);
        k += 1;
      }
      QLog.d("EmoticonMainPanel", 2, "tabs.size: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.getChildCount());
      this.jdField_c_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "[Performance] initMainTabView duration:" + (System.currentTimeMillis() - l));
  }
  
  private void h()
  {
    if (this.jdField_d_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
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
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.b();
      int m = this.jdField_c_of_type_JavaUtilList.size();
      int k = 0;
      if (k < m)
      {
        if (k == 0)
        {
          localObject = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(k);
          if (((EmoticonViewBinder)localObject).n == 8)
          {
            int n = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131427511);
            this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, n, true);
          }
          for (;;)
          {
            k += 1;
            break;
            this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a((EmoticonViewBinder)localObject, true);
          }
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs;
        localEmoticonViewBinder = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(k);
        if (k != m - 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((HorizonEmoticonTabs)localObject).a(localEmoticonViewBinder, bool);
          break;
        }
      }
      this.jdField_d_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l));
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    Object localObject = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      ((EmoticonController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      ((EmoticonController)localObject).a(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    localObject = (ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(15);
    if (localObject != null) {
      ((ClubContentUpdateHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    }
    if ((getVisibility() == 0) && (this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_d_of_type_Boolean = false;
      a(null);
      this.jdField_b_of_type_Boolean = false;
    }
    while (!isShown()) {
      return;
    }
    if ((EmoticonUtils.d(this.j)) && (!TextUtils.isEmpty(getContext().getSharedPreferences("mobileQQi", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "download in market, initEmoticonView");
      }
      a(2, 0, null);
    }
    e();
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "OnTabChanged, oldIndex=" + paramInt1 + ", newIndex=" + paramInt2);
    }
    if (jdField_d_of_type_Int == 1)
    {
      StatisticAssist.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_tab2" + paramInt2);
      if (e != paramInt2) {}
    }
    label159:
    do
    {
      do
      {
        return;
        a(paramInt2, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
        e = paramInt2;
        if (paramInt2 == 0)
        {
          e();
          if (paramInt2 != 1) {
            break label159;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          StatisticAssist.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_tab");
          return;
          if (paramInt2 != 0) {
            break;
          }
          f();
          break;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      } while ((jdField_d_of_type_Int != 2) || (this.jdField_c_of_type_JavaUtilList == null) || (paramInt2 >= this.jdField_c_of_type_JavaUtilList.size()));
      localObject1 = (EmoticonViewBinder)this.jdField_c_of_type_JavaUtilList.get(paramInt2);
      if (101 == ((EmoticonViewBinder)localObject1).n) {
        break;
      }
    } while (f == paramInt2);
    f = paramInt2;
    a(paramInt2, true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof BigEmoticonViewBinder)) {
        break label361;
      }
      localObject2 = (BigEmoticonViewBinder)localObject1;
      if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.a(paramInt2)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_hdclick", 0, 0, ((BigEmoticonViewBinder)localObject2).a.epId, "", "", "");
      }
    }
    for (;;)
    {
      StatisticAssist.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ep_tab");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_tab", 0, 0, a((EmoticonViewBinder)localObject1), "", "", "");
      return;
      label361:
      if ((localObject1 instanceof MagicFaceViewBinder)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbFasong", "MbTabDianji", 0, 0, "", "", "", "");
      }
    }
    Object localObject1 = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = new Intent((Context)localObject1, EmosmActivity.class);
    ((Intent)localObject2).putExtra("extra_launch_source", 1);
    ((ChatActivity)localObject1).startActivity((Intent)localObject2);
    StatisticAssist.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Ep_manage");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.j = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = ((HorizonEmoticonTabs)findViewById(2131231640));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setEmoticonTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator = ((EmoticonPageIndicator)findViewById(2131231633));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager = ((EmoticonViewPager)findViewById(2131231632));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231639);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231641);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = ((HorizonEmoticonTabs)findViewById(2131231644));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setEmoticonTabChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131231643));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131231642));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231645));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageButton)findViewById(2131231634));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramContext = EmoticonController.a(paramQQAppInterface);
    if (paramContext != null)
    {
      paramContext.a(this);
      paramContext.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      paramContext.a(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    paramQQAppInterface = (ClubContentUpdateHandler)paramQQAppInterface.a(15);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    }
    a(paramString);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageDeleted");
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageMoved");
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    int m = jdField_d_of_type_Int;
    if (jdField_d_of_type_Int == 1) {}
    for (int k = e;; k = f)
    {
      a(m, k, paramString);
      return;
    }
  }
  
  public void b()
  {
    EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    ((ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(15)).b(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageAdded");
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    Object localObject = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      ((EmoticonController)localObject).b(this);
      ((EmoticonController)localObject).b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      ((EmoticonController)localObject).b(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    ((ClubContentUpdateHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(15)).b(this.jdField_a_of_type_ComTencentMobileqqAppClubContentUpdateHandler$ClubContentUpdateListener);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.c();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = null;
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.c();
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs = null;
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
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  public void d()
  {
    if (!isShown()) {}
    while (jdField_d_of_type_Int != 2) {
      return;
    }
    ThreadManager.b(new fta(this));
  }
  
  public void e()
  {
    if (!isShown()) {
      return;
    }
    postDelayed(new ftc(this), 200L);
  }
  
  public void f()
  {
    if (!isShown()) {
      return;
    }
    postDelayed(new ftd(this), 200L);
  }
  
  public void onClick(View paramView)
  {
    int i2 = 1;
    switch (paramView.getId())
    {
    }
    label140:
    label154:
    label284:
    label289:
    label295:
    label301:
    label309:
    label311:
    label314:
    for (;;)
    {
      return;
      b(1, e);
      return;
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramView = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (paramView != null)
      {
        int k;
        label109:
        int m;
        label126:
        int n;
        int i1;
        boolean bool;
        if (paramView.a("100005.100001") != -1)
        {
          k = 1;
          if (k == 0) {
            break label282;
          }
          if (paramView.a("100005.100003") == -1) {
            break label284;
          }
          m = 1;
          if (paramView.a("100005.100002") == -1) {
            break label289;
          }
          n = 1;
          if (paramView.a("100005.100006") == -1) {
            break label295;
          }
          i1 = 1;
          bool = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).jdField_a_of_type_Boolean;
          if (!bool) {
            break label311;
          }
          if (paramView.a("100005.100011") == -1) {
            break label301;
          }
          k = 1;
        }
        for (;;)
        {
          label189:
          if (((!bool) || (m != 0) || (n != 0) || (i1 != 0) || (k != 0)) && ((bool) || (m != 0) || (n != 0) || (i1 != 0))) {
            break label314;
          }
          if (paramView.a("100005") != -1) {}
          for (k = i2;; k = 0)
          {
            if (k == 0) {
              break label309;
            }
            BusinessInfoCheckUpdateItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "100005", false);
            ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b("100005");
            return;
            k = 0;
            break label109;
            break;
            m = 0;
            break label126;
            n = 0;
            break label140;
            i1 = 0;
            break label154;
            k = 0;
            break label189;
          }
          break;
          k = 0;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((k == 1) || (k == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPageSelected, position=" + paramInt);
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    label182:
    label195:
    label199:
    label473:
    label483:
    label488:
    label490:
    label498:
    for (;;)
    {
      return;
      int n;
      int k;
      int i1;
      Object localObject1;
      int m;
      int i2;
      if (jdField_d_of_type_Int == 1)
      {
        n = 0;
        k = 0;
        i1 = this.jdField_a_of_type_JavaUtilList.size();
        if (k >= i1) {
          break label490;
        }
        localObject1 = (EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(k);
        m = n;
        if (localObject1 != null)
        {
          m = n;
          if ((localObject1 instanceof EmoticonPanelViewBinder))
          {
            localObject1 = (EmoticonPanelViewBinder)localObject1;
            i2 = ((EmoticonPanelViewBinder)localObject1).b();
            n += i2;
            m = n;
            if (paramInt + 1 > n) {}
          }
        }
      }
      for (paramInt = i2 - (n - paramInt);; paramInt = -1)
      {
        if ((paramInt == -1) || (localObject1 == null)) {
          break label498;
        }
        if (e != k) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(k, false);
        }
        if (k == 0)
        {
          e();
          if (k != 1) {
            break label258;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          e = k;
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("EmoticonMainPanel", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l));
            return;
            k += 1;
            n = m;
            break;
            if (k != 0) {
              break label182;
            }
            f();
            break label182;
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label195;
            if (jdField_d_of_type_Int == 2)
            {
              n = 0;
              localObject1 = null;
              k = 0;
              i1 = this.jdField_a_of_type_JavaUtilList.size();
              if (k >= i1) {
                break label483;
              }
              Object localObject2 = (EmoticonViewBinder)this.jdField_a_of_type_JavaUtilList.get(k);
              m = n;
              if (localObject2 == null) {
                break label473;
              }
              m = n;
              if (!(localObject2 instanceof EmoticonPanelViewBinder)) {
                break label473;
              }
              localObject2 = (EmoticonPanelViewBinder)localObject2;
              i2 = ((EmoticonPanelViewBinder)localObject2).b();
              n += i2;
              m = n;
              if (paramInt + 1 > n) {
                break label473;
              }
              ((EmoticonPanelViewBinder)localObject2).a();
              localObject1 = localObject2;
            }
          }
        }
        for (paramInt = i2 - (n - paramInt);; paramInt = -1)
        {
          if ((paramInt == -1) || (localObject1 == null)) {
            break label488;
          }
          if (f != k)
          {
            this.jdField_b_of_type_ComTencentMobileqqEmoticonviewHorizonEmoticonTabs.setSelectedIndex(k, false);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_slidetab", 0, 0, a((EmoticonViewBinder)localObject1), "", "", "");
          }
          if (((localObject1 instanceof BigEmoticonViewBinder)) && (paramInt == 0)) {
            ((BigEmoticonViewBinder)localObject1).d();
          }
          f = k;
          break label199;
          break;
          k += 1;
          n = m;
          break label296;
          k = 0;
        }
        break;
        localObject1 = null;
        k = 0;
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setToastOffset(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      if (paramInt == 0) {
        a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */