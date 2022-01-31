package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.filemanager.activity.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cro;
import crp;
import crq;
import crr;
import crt;
import cru;
import crw;
import cry;
import crz;
import csb;
import csc;
import cso;
import csp;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leba
  extends Frame
  implements View.OnClickListener
{
  public static final int a = 11340001;
  private static final long jdField_a_of_type_Long = 500L;
  private static final String jdField_a_of_type_JavaLangString = "Q.lebatab.leba";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 11340002;
  public static final int c = 11340003;
  public static final int d = 11340004;
  public static final int e = 11340005;
  public static int f = 0;
  private static final int g = 60;
  private static final int h = 1;
  private static final int i = 2;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public LebaListViewAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new crt(this);
  public DownloadIconsListener a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new cry(this);
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new crq(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new crr(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new crp(this);
  public AdapterView.OnItemClickListener a;
  public XListView a;
  private List jdField_a_of_type_JavaUtilList;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private TextView d;
  private boolean e = true;
  
  public Leba()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new crw(this);
    this.jdField_a_of_type_AndroidOsHandler = new crz(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new csc(this);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int j = a().getDimensionPixelSize(2131427615);
    switch (paramInt)
    {
    default: 
      paramInt = j;
    }
    for (;;)
    {
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if ((paramTextView == null) || ((paramTextView.leftMargin == paramInt) && (paramTextView.bottomMargin == paramInt))) {
        break;
      }
      paramTextView.setMargins(paramInt, 0, 0, paramInt);
      return;
      paramInt = a().getDimensionPixelSize(2131427615);
      continue;
      paramInt = a().getDimensionPixelSize(2131427617);
      continue;
      paramInt = a().getDimensionPixelSize(2131427616);
    }
  }
  
  private void a(LebaViewItem paramLebaViewItem, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (paramInt == 0) || (paramViewGroup == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "invalid arguments in markNewFeatureUsed");
      }
    }
    do
    {
      do
      {
        return;
      } while (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew != 0);
      paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew = 1;
      ThreadManager.b(new cso(this, paramLebaViewItem));
      paramLebaViewItem = paramViewGroup.findViewById(paramInt);
    } while (paramLebaViewItem == null);
    paramLebaViewItem.setVisibility(8);
  }
  
  private String b()
  {
    String str = "http://www.imqq.com/mobile/privacy/privacy.html?language={language}";
    int j = LocaleUtil.a(a().getApplicationContext());
    if (j == 2) {
      str = "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "ch_simple");
    }
    do
    {
      return str;
      if (j == 3) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "ch_chT");
      }
      if (j == 1) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "English");
      }
      if (j == 4) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "Japanese");
      }
      if (j == 5) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "Korean");
      }
      if (j == 6) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "Deutsch");
      }
      if (j == 7) {
        return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "Fran");
      }
    } while (j != 8);
    return "http://www.imqq.com/mobile/privacy/privacy.html?language={language}".replace("{language}", "Espa");
  }
  
  private void m() {}
  
  private void n()
  {
    IphoneTitleBarActivity.b((ViewGroup)a(2131231448));
    TextView localTextView = (TextView)a(2131231376);
    localTextView.setText(2131562047);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131231380));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562341);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    localTextView.setFocusable(true);
    localTextView.setContentDescription("动态");
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("进入动态设置界面");
  }
  
  private void o()
  {
    ArrayList localArrayList;
    int j;
    LebaViewItem localLebaViewItem;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localArrayList = new ArrayList();
      j = 0;
      if (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((localLebaViewItem == null) || (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString)) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
          break label426;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType != 1)
        {
          File localFile = LebaShowListManager.a(a(), localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
          URL localURL = new URL(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
          if (LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.containsKey(localFile.getAbsolutePath()))
          {
            localObject1 = (Bitmap)LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.get(localFile.getAbsolutePath());
            if (localObject1 == null)
            {
              localObject2 = a().getDrawable(2130838960);
              localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
              if ((localFile.exists()) && (localObject1 != null)) {
                continue;
              }
              if ((localFile.exists()) && (localObject1 == null)) {
                localFile.delete();
              }
              localObject1 = new HashMap();
              ((Map)localObject1).put("KEY", localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
              ((Map)localObject1).put("URL", localURL);
              ((Map)localObject1).put("FILE", localFile);
              localArrayList.add(localObject1);
              continue;
            }
          }
          else
          {
            if (!localFile.exists()) {
              continue;
            }
            localObject1 = LebaShowListManager.a().a(localFile);
            if (localObject1 == null) {
              continue;
            }
            LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap.put(localFile.getAbsolutePath(), localObject1);
            continue;
          }
          Object localObject2 = new BitmapDrawable((Bitmap)localObject1);
          continue;
        }
        else
        {
          int k = a().getIdentifier(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL, "drawable", a().getPackageName());
          if (k == 0) {
            continue;
          }
          localLebaViewItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(k);
          continue;
          if (localArrayList.size() > 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(localArrayList);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11340003, 50L);
          return;
        }
        Object localObject1 = null;
        continue;
      }
      catch (Exception localException)
      {
        label426:
        continue;
      }
      j += 1;
      break;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131231886));
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter = new LebaListViewAdapter(a(), this.jdField_a_of_type_JavaUtilList, 2130903200, 2130903201, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new csb(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130903584, this.jdField_a_of_type_ComTencentWidgetXListView, false);
          View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131232979);
          View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131232984);
          View localView3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131232988);
          localView1.setOnClickListener(this);
          localView2.setOnClickListener(this);
          localView3.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232980));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232982));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232983));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232985));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232987));
          this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232991));
          localView1.setContentDescription("好友动态");
          localView2.setContentDescription("附近的人");
          localView3.setContentDescription("兴趣部落");
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void r()
  {
    if ((a() != null) && (a().b != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)a().b.getManager(9);
      if (localQZoneManager != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localQZoneManager.a(2);
        }
        localQZoneManager.a(false);
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void s()
  {
    int n = 1;
    int m = 0;
    Object localObject;
    int k;
    int j;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localObject != null)
      {
        k = ((QZoneManagerImp)localObject).a(QZoneManager.FeedType.mySpacefeed);
        if (k > 0) {
          break label542;
        }
        if (localObject == null) {
          break label473;
        }
        j = ((QZoneManagerImp)localObject).a(QZoneManager.FeedType.friendSpace);
        label65:
        if ((j <= 0) || (((QZoneManagerImp)localObject).a().length() <= 3)) {
          break label478;
        }
        localObject = ((QZoneManagerImp)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("Leba", 2, "updateQZoneFlag.latestfriend=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label537;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if (localObject == null) {
          break label537;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        j = 1;
        label165:
        CustomWidgetUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, j, k, 0);
        a(this.jdField_b_of_type_AndroidWidgetTextView, j);
      }
    }
    else
    {
      localObject = (LebaViewItem)LebaShowListManager.a().b.get("qzone_feedlist");
      if ((localObject == null) || (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew != 0)) {
        break label589;
      }
      CustomWidgetUtil.a(this.jdField_c_of_type_AndroidWidgetTextView, 2, 0, 0);
      a(this.jdField_c_of_type_AndroidWidgetTextView, 2);
      label236:
      k = 2130838965;
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m())
      {
        long l3 = a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("nearby_enter_time", -100L);
        long l2 = -1L;
        long l4 = System.currentTimeMillis();
        long l1 = l2;
        if (l3 >= 0L)
        {
          l1 = l2;
          if (l4 >= l3) {
            l1 = l4 - l3;
          }
        }
        j = k;
        if (l1 >= 0L)
        {
          j = k;
          if (l1 <= 28800000L) {
            j = 2130838966;
          }
        }
      }
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(j);
      }
    }
    for (;;)
    {
      try
      {
        localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).a(String.valueOf(826));
        if ((localObject == null) || (!((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.has()) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
          break label640;
        }
        j = n;
        k = m;
        switch (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get())
        {
        case 0: 
          CustomWidgetUtil.a(this.d, j, k, 0);
          a(this.d, j);
          return;
        }
      }
      catch (Exception localException)
      {
        label473:
        label478:
        localException.printStackTrace();
        label537:
        label542:
        label589:
        return;
      }
      k = 0;
      break;
      j = 0;
      break label65;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateQZoneFlag.noflag count=" + j + ";lastFriendFeedLen=" + ((QZoneManagerImp)localObject).a().length());
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      j = 0;
      break label165;
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "freshEntryItemUI num=" + k);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      j = 3;
      break label165;
      CustomWidgetUtil.a(this.jdField_c_of_type_AndroidWidgetTextView, 0, 0, 0);
      a(this.jdField_c_of_type_AndroidWidgetTextView, 0);
      break label236;
      j = 2;
      k = m;
      continue;
      k = ((BusinessInfoCheckUpdate.AppInfo)localObject).num.get();
      j = 3;
      continue;
      label640:
      j = 0;
      k = m;
      continue;
      j = n;
      k = m;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(2130903268, null);
  }
  
  protected String a()
  {
    return a(2131562048);
  }
  
  protected void a()
  {
    super.a();
    n();
    ViewStub localViewStub = (ViewStub)a(2131231885);
    localViewStub.setOnInflateListener(new cro(this));
    CommonLoadingView localCommonLoadingView = (CommonLoadingView)a(2131231370);
    localCommonLoadingView.setOnFirstDrawListener(new cru(this, localCommonLoadingView, localViewStub));
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView, int paramInt, LebaViewItem paramLebaViewItem)
  {
    Object localObject1;
    if ((paramInt == -1) && (paramLebaViewItem != null)) {
      localObject1 = paramLebaViewItem;
    }
    for (;;)
    {
      if ((localObject1 == null) || (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null))
      {
        return;
        if (paramInt >= 0) {
          localObject1 = (LebaViewItem)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(paramInt);
        }
      }
      else
      {
        Object localObject2 = ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strGotoUrl;
        String str = ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName;
        paramInt = ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sResSubType;
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str + ",url=" + (String)localObject2);
        }
        label266:
        boolean bool;
        if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId > 0L))
        {
          Object localObject3 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject3).a(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "");
          if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
          {
            paramLebaViewItem = "status=" + localAppInfo.type.get() + "&number=" + localAppInfo.num.get() + "&path=" + localAppInfo.path.get();
            if (localAppInfo != null) {
              ((RedTouchManager)localObject3).a(localAppInfo);
            }
            localObject3 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
            if (localObject3 == null) {
              break label1797;
            }
            if (((GameCenterManagerImp)localObject3).a(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "") == -1) {
              break label667;
            }
            bool = true;
            label336:
            if (bool)
            {
              BusinessInfoCheckUpdateItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "", false);
              this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            }
          }
        }
        for (;;)
        {
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, "", "", "");
          for (;;)
          {
            if ((localObject2 == null) || ("".equals(localObject2)))
            {
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("personal_album"))
              {
                long l1 = 0L;
                try
                {
                  long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
                  l1 = l2;
                }
                catch (Exception paramView)
                {
                  for (;;)
                  {
                    paramView.printStackTrace();
                  }
                }
                localObject1 = QZoneHelper.UserInfo.a();
                ((QZoneHelper.UserInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(l1);
                ((QZoneHelper.UserInfo)localObject1).c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
                paramLebaViewItem = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
                paramView = paramLebaViewItem;
                if (TextUtils.isEmpty(paramLebaViewItem)) {
                  paramView = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                ((QZoneHelper.UserInfo)localObject1).b = paramView;
                QZoneHelper.a(a(), (QZoneHelper.UserInfo)localObject1, Long.valueOf(l1), 0, -1);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
                com.tencent.mobileqq.activity.recent.DrawerFrame.d = 0;
                return;
                paramLebaViewItem = "status=" + -1 + "&number=0" + "&path=" + ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
                break label266;
                label667:
                bool = false;
                break label336;
                if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("qzone_feedlist")))
                {
                  if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
                  {
                    if ((this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
                    {
                      bool = true;
                      paramLebaViewItem = null;
                      continue;
                    }
                    bool = false;
                    paramLebaViewItem = null;
                    continue;
                  }
                  bool = false;
                  paramLebaViewItem = null;
                  continue;
                }
                if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) {
                  break label1789;
                }
                if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.isNew == 0) {}
                for (bool = true;; bool = false)
                {
                  paramLebaViewItem = null;
                  break;
                }
              }
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("my_profile"))
              {
                paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
                paramView.e = 1;
                paramView.f = 8;
                ProfileActivity.a(a(), paramView, 1009);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_profile", 0, 0, "", "", "", "");
                return;
              }
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("what_is_up"))
              {
                paramView = new Intent(a(), EditActivity.class);
                paramView.putExtra("k_source", 0);
                a(paramView);
                return;
              }
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("file_manager"))
              {
                a(new Intent(a(), FileAssistantActivity.class));
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
                com.tencent.mobileqq.activity.recent.DrawerFrame.d = 0;
                return;
              }
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("my_favorite"))
              {
                QfavHelper.b(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1);
                QfavReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
                com.tencent.mobileqq.activity.recent.DrawerFrame.d = 0;
                return;
              }
              if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("nearby_friends"))
              {
                a(new Intent(a(), NearPeopleActivity.class));
                return;
              }
              if (!((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("privacy_item")) {
                break;
              }
              paramView = new Intent(a(), QQBrowserActivity.class);
              try
              {
                paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                paramView.putExtra("url", b());
                a(paramView);
                return;
              }
              catch (Exception paramView)
              {
                paramView.printStackTrace();
                return;
              }
            }
            if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.cDataType == 0) {
              a((LebaViewItem)localObject1, 2131231295, (ViewGroup)paramView);
            }
            if (paramInt == 0)
            {
              if (((String)localObject2).indexOf("plg_auth=1") <= -1) {
                break label1786;
              }
              localObject2 = (String)localObject2 + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
            }
            label1729:
            label1779:
            label1786:
            for (;;)
            {
              paramView = (View)localObject2;
              if (((String)localObject2).indexOf("plg_uin=1") > -1) {
                paramView = (String)localObject2 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              }
              localObject2 = paramView;
              if (paramView.indexOf("plg_vkey=1") > -1) {
                localObject2 = paramView + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g();
              }
              paramView = new Intent(a(), QQBrowserActivity.class);
              if (((String)localObject2).indexOf("plg_nld=1") > -1) {
                paramView.putExtra("reportNld", true);
              }
              if (!TextUtils.isEmpty(paramLebaViewItem)) {
                paramView.putExtra("redTouch", paramLebaViewItem);
              }
              paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              paramView.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
              a(paramView.putExtra("url", (String)localObject2).putExtra("title", str));
              do
              {
                do
                {
                  if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131562158)))) {
                    StatisticCollector.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
                  this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11340005);
                  if (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("qzone_feedlist")) {
                    break;
                  }
                  this.jdField_b_of_type_Boolean = true;
                  return;
                } while (paramInt != 2);
                paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject2);
                if (paramView != null)
                {
                  if ((((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("com.tx.gamecenter.android")) || (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131562158)))) {
                    paramView.c("platformId=qq_m");
                  }
                  paramView.a(bool);
                  paramView.b(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
                  paramView.d(paramLebaViewItem);
                  paramView.b();
                }
              } while (!((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("qzone_feedlist"));
              paramView = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
              if (paramView != null)
              {
                paramView.a(QZoneManager.FeedType.friendSpace);
                paramView.a(true);
              }
              QzonePluginProxyActivity.jdField_b_of_type_Boolean = true;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (QzonePluginProxyActivity.jdField_a_of_type_Boolean)
              {
                paramView = "1";
                if (!QzonePluginProxyActivity.jdField_b_of_type_Boolean) {
                  break label1779;
                }
              }
              for (paramLebaViewItem = "1";; paramLebaViewItem = "0")
              {
                ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Qzone", "Qzone_prestrain", 0, 0, paramView, paramLebaViewItem, "0", "");
                break;
                paramView = "0";
                break label1729;
              }
            }
            label1789:
            bool = false;
            paramLebaViewItem = null;
          }
          label1797:
          bool = false;
        }
      }
      localObject1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null) {
      f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null) && ((LebaShowListManager.c & 0x1) == 0)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11340002, 500L);
    }
    if (LebaShowListManager.c > 0)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = LebaShowListManager.a().b();
      LebaShowListManager.a().a(localArrayList, localList);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
          s();
        }
      }
      LebaShowListManager.a();
      LebaShowListManager.c = 0;
    }
    QzonePluginProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    r();
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(Menu paramMenu)
  {
    paramMenu.clear();
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity))) {}
    for (boolean bool = ((SplashActivity)localObject).c();; bool = false)
    {
      localObject = paramMenu.add(0, 1, 0, a().getString(2131562815));
      if (bool)
      {
        j = 2130837917;
        ((MenuItem)localObject).setIcon(j);
        MenuItemCompat.setShowAsAction((MenuItem)localObject, 2);
        paramMenu = paramMenu.add(0, 2, 0, a(2131562894));
        if (!bool) {
          break label125;
        }
      }
      label125:
      for (int j = 2130840262;; j = 2130840261)
      {
        paramMenu.setIcon(j);
        MenuItemCompat.setShowAsAction(paramMenu, 2);
        return true;
        j = 2130837916;
        break;
      }
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return true;
      paramMenuItem = new Intent(a(), QQSettingSettingActivity.class);
      a().startActivity(paramMenuItem);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
      continue;
      paramMenuItem = new Intent(a(), ScannerActivity.class);
      paramMenuItem.putExtra("from", "Conversation");
      paramMenuItem.setFlags(67108864);
      a().startActivity(paramMenuItem);
      ReportController.b(a().b, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
    }
  }
  
  public int[] a()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(j);
      if (localView == null) {}
      LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder;
      do
      {
        do
        {
          do
          {
            j += 1;
            break;
          } while ((localView.getTag() == null) || (!(localView.getTag() instanceof LebaListViewAdapter.CornerListItemHolder)));
          localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)localView.getTag();
        } while (localCornerListItemHolder.a == null);
        if (QLog.isDevelopLevel()) {
          QLog.d("GuideGame", 4, "fight....uiResId:" + localCornerListItemHolder.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
        }
      } while (769L != localCornerListItemHolder.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
      return new int[] { localView.getTop(), localView.getHeight() };
    }
    return null;
  }
  
  protected void b()
  {
    super.b();
    LebaShowListManager.a().a();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      }
    }
    super.e();
  }
  
  public void f()
  {
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.o();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    List localList = LebaShowListManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localList);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      s();
    }
  }
  
  void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new csp(this), 1000L);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.c();
    }
  }
  
  public void l()
  {
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(j);
      if (localView == null) {}
      LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder;
      do
      {
        do
        {
          j += 1;
          break;
        } while ((localView.getTag() == null) || (!(localView.getTag() instanceof LebaListViewAdapter.CornerListItemHolder)));
        localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)localView.getTag();
      } while ((localCornerListItemHolder.a == null) || (769L != localCornerListItemHolder.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId));
      j = this.jdField_a_of_type_JavaUtilList.indexOf(localCornerListItemHolder.a);
      if (j >= 0)
      {
        StatisticCollector.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "guide", "Clk_in_reader", 0, 1, "0", "", "", "", "");
        a(localView, j, null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232979: 
      a(null, -1, (LebaViewItem)LebaShowListManager.a().b.get("qzone_feedlist"));
      return;
    case 2131232984: 
      a(null, -1, (LebaViewItem)LebaShowListManager.a().b.get("nearby_friends"));
      return;
    case 2131232988: 
      a(null, -1, (LebaViewItem)LebaShowListManager.a().b.get("com.tx.xingqubuluo.android"));
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_tt_right", 0, 0, "", "", "", "");
    LebaShowListManager.a().jdField_a_of_type_Boolean = true;
    a(new Intent(a(), LebaListMgrActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */