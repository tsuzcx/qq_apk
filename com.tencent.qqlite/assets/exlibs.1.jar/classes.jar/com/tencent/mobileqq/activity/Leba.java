package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ase;
import asf;
import asg;
import ash;
import asi;
import asj;
import ask;
import asl;
import asn;
import aso;
import asp;
import asq;
import asr;
import ast;
import asu;
import asv;
import asw;
import asx;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.QZoneManager.FeedType;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Leba
  extends Frame
  implements View.OnClickListener, ViewStub.OnInflateListener, CommonLoadingView.OnFirstDrawListener
{
  public static final int a = 11340001;
  private static final long jdField_a_of_type_Long = 500L;
  static String jdField_a_of_type_JavaLangString = "http://m.qzone.com/infocenter";
  public static boolean a = false;
  public static final int b = 11340002;
  private static final String jdField_b_of_type_JavaLangString = "Q.lebatab.leba";
  private static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 11340005;
  public static final int d = 1134006;
  public static int e;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SearchProtocol.SearchObserver a;
  public LebaListViewAdapter a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aso(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new asn(this);
  public DownloadIconsListener a;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new ast(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new asl(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new ask(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new asj(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public AdapterView.OnItemClickListener a;
  public XListView a;
  private List jdField_a_of_type_JavaUtilList;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private TextView d;
  private boolean e;
  private final int jdField_f_of_type_Int = 1;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g = true;
  
  static
  {
    jdField_e_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public Leba()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new asr(this);
    this.jdField_a_of_type_AndroidOsHandler = new asu(this);
    this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new asv(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new asf(this);
  }
  
  private void a(ImageView paramImageView, int paramInt, Drawable paramDrawable)
  {
    if (paramInt == 1)
    {
      paramImageView.setImageDrawable(LebaIconDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDrawable));
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int i = a().getDimensionPixelSize(2131493077);
    switch (paramInt)
    {
    case 4: 
    default: 
      paramInt = i;
    }
    for (;;)
    {
      paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
      if ((paramTextView == null) || ((paramTextView.leftMargin == paramInt) && (paramTextView.bottomMargin == paramInt))) {
        break;
      }
      paramTextView.setMargins(paramInt, 0, 0, paramInt);
      return;
      paramInt = a().getDimensionPixelSize(2131493077);
      continue;
      paramInt = a().getDimensionPixelSize(2131493079);
      continue;
      paramInt = a().getDimensionPixelSize(2131493078);
      continue;
      paramInt = a().getDimensionPixelSize(2131493079);
    }
  }
  
  private void a(LebaViewItem paramLebaViewItem, int paramInt, ViewGroup paramViewGroup)
  {
    if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null) || (paramInt == 0) || (paramViewGroup == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "invalid arguments in markNewFeatureUsed");
      }
    }
    do
    {
      do
      {
        return;
      } while (paramLebaViewItem.a.isNew != 0);
      paramLebaViewItem.a.isNew = 1;
      ThreadManager.b(new asi(this, paramLebaViewItem));
      paramLebaViewItem = paramViewGroup.findViewById(paramInt);
    } while (paramLebaViewItem == null);
    paramLebaViewItem.setVisibility(8);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
      if (localObject != null) {
        ((RedTouchManager)localObject).b(34);
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "click_trends_tab", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
    ResourcePluginInfo localResourcePluginInfo;
    if (localObject != null)
    {
      int i = 0;
      if (i < ((List)localObject).size())
      {
        localResourcePluginInfo = (ResourcePluginInfo)((List)localObject).get(i);
        if (localResourcePluginInfo == null) {}
        while ((TextUtils.isEmpty(localResourcePluginInfo.strPkgName)) || (!localResourcePluginInfo.strPkgName.equals("m.tx.apphelper.android")))
        {
          i += 1;
          break;
        }
      }
    }
    for (long l = localResourcePluginInfo.uiResId;; l = 0L)
    {
      localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localObject != null) && ((((GameCenterManagerImp)localObject).a(601L)) || ((l > 0L) && (((GameCenterManagerImp)localObject).a(l))))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.d();
      ((SplashActivity)a()).a.j();
      return;
    }
  }
  
  private void p()
  {
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131296891));
    TextView localTextView = (TextView)a(2131296892);
    localTextView.setText(2131362955);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131296902));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363203);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    localTextView.setFocusable(true);
    localTextView.setContentDescription("动态");
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("进入动态设置界面");
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131297256));
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter = new LebaListViewAdapter(a(), this.jdField_a_of_type_JavaUtilList, 2130903172, 2130903173, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new asw(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2130903501, this.jdField_a_of_type_ComTencentWidgetXListView, false);
          View localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131298227);
          View localView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131298232);
          localView1.setOnClickListener(this);
          localView2.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298228));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298230));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298231));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298233));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298235));
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131298237));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298238));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298236));
          this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new asx(this));
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
          localView1.setContentDescription("好友动态");
          localView2.setContentDescription("附近");
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void s()
  {
    if ((a() != null) && (a().app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)a().app.getManager(9);
      if (localQZoneManager != null)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.leba", 2, "getQzoneUnread by tab resume.");
          }
          localQZoneManager.a(2);
        }
        localQZoneManager.a(false);
      }
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void t()
  {
    Object localObject;
    int j;
    int i;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      localObject = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
      if (localObject != null)
      {
        j = ((QZoneManagerImp)localObject).a(QZoneManager.FeedType.mySpacefeed);
        if (j > 0) {
          break label410;
        }
        if (localObject == null) {
          break label341;
        }
        i = ((QZoneManagerImp)localObject).a(QZoneManager.FeedType.friendSpace);
        label60:
        if ((i <= 0) || (((QZoneManagerImp)localObject).a().length() <= 3)) {
          break label346;
        }
        localObject = ((QZoneManagerImp)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("Leba", 2, "updateQZoneFlag.latestfriend=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label405;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
        if (localObject == null) {
          break label405;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Leba", 2, "updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        i = 1;
        label176:
        CustomWidgetUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, i, j, 0);
        a(this.jdField_b_of_type_AndroidWidgetTextView, i);
      }
    }
    else
    {
      n();
      j = 2130838743;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n())
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
        if ((l1 < 0L) || (l1 > 28800000L)) {
          break label457;
        }
        i = 2130838744;
        this.jdField_e_of_type_Boolean = true;
        jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1134006, 200L);
      return;
      j = 0;
      break;
      label341:
      i = 0;
      break label60;
      label346:
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "updateQZoneFlag.noflag count=" + i + ";lastFriendFeedLen=" + ((QZoneManagerImp)localObject).a().length());
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      label405:
      i = 0;
      break label176;
      label410:
      if (QLog.isColorLevel()) {
        QLog.d("Leba", 2, "freshEntryItemUI num=" + j);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      i = 3;
      break label176;
      label457:
      this.jdField_e_of_type_Boolean = false;
      jdField_a_of_type_Boolean = false;
      i = j;
    }
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(2130903223, null);
  }
  
  protected String a()
  {
    return a(2131362949);
  }
  
  protected void a()
  {
    super.a();
    p();
    ((ViewStub)a(2131297255)).setOnInflateListener(this);
    ((CommonLoadingView)a(2131296837)).setOnFirstDrawListener(this);
  }
  
  public void a(View paramView, int paramInt, LebaViewItem paramLebaViewItem)
  {
    if (this.g)
    {
      this.g = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new asg(this), 500L);
      if ((paramInt != -1) || (paramLebaViewItem == null)) {
        break label68;
      }
    }
    for (;;)
    {
      label68:
      Object localObject3;
      String str;
      boolean bool4;
      boolean bool3;
      Object localObject1;
      Object localObject2;
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      Object localObject4;
      if ((paramLebaViewItem == null) || (paramLebaViewItem.a == null))
      {
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.lebatab.leba", 2, "clickAction is dismiss,click too frequently.");
          return;
          if (paramInt < 0) {
            break label1701;
          }
          paramLebaViewItem = (LebaViewItem)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.getItem(paramInt);
        }
      }
      else
      {
        localObject3 = paramLebaViewItem.a.strGotoUrl;
        str = paramLebaViewItem.a.strResName;
        paramInt = paramLebaViewItem.a.sResSubType;
        bool4 = false;
        bool3 = false;
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.leba", 2, "clickAction.name=" + str + ",url=" + (String)localObject3);
        }
        localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
        localAppInfo = ((RedTouchManager)localObject2).a(paramLebaViewItem.a.uiResId + "");
        if ((paramLebaViewItem.a != null) && (paramLebaViewItem.a.uiResId > 0L))
        {
          localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
          localObject4 = String.valueOf(paramLebaViewItem.a.uiResId);
          if ((localAppInfo != null) && (localObject1 != null) && (((WebProcessManager)localObject1).a((String)localObject4))) {
            ThreadManager.a().post(new ash(this, (String)localObject4, localAppInfo));
          }
          if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
            if (localAppInfo.type.get() != 0) {
              break label1695;
            }
          }
        }
      }
      label389:
      label1670:
      label1682:
      label1695:
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject1 = "status=" + localAppInfo.type.get() + "&number=" + localAppInfo.num.get() + "&path=" + localAppInfo.path.get();
        if (localAppInfo != null) {
          ((RedTouchManager)localObject2).a(localAppInfo);
        }
        localObject2 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        boolean bool2;
        if (localObject2 != null) {
          if (((GameCenterManagerImp)localObject2).a(paramLebaViewItem.a.uiResId + "") != -1)
          {
            bool2 = true;
            label457:
            if (bool2)
            {
              BusinessInfoCheckUpdateItem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaViewItem.a.uiResId + "", false);
              this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            }
          }
        }
        for (;;)
        {
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_tab", "Clk_plug_in", 0, 0, "" + paramLebaViewItem.a.uiResId, "", "", "");
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          localObject2 = localObject1;
          label570:
          if ((localObject3 != null) && (!"".equals(localObject3)))
          {
            if (paramLebaViewItem.a.cDataType == 0) {
              a(paramLebaViewItem, 2131296762, (ViewGroup)paramView);
            }
            if (paramInt != 0) {
              break label1211;
            }
            if (((String)localObject3).indexOf("plg_auth=1") <= -1) {
              break label1682;
            }
          }
          for (localObject1 = (String)localObject3 + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();; localObject1 = localObject3)
          {
            paramView = (View)localObject1;
            if (((String)localObject1).indexOf("plg_uin=1") > -1) {
              paramView = (String)localObject1 + "&mqquin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            }
            localObject1 = paramView;
            if (paramView.indexOf("plg_vkey=1") > -1) {
              localObject1 = paramView + "&mqqvkey=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
            }
            paramView = new Intent(a(), QQBrowserActivity.class);
            if (((String)localObject1).indexOf("plg_nld=1") > -1) {
              paramView.putExtra("reportNld", true);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              paramView.putExtra("redTouch", (String)localObject2);
            }
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            paramView.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
            paramView.putExtra("plugin_start_time", System.currentTimeMillis());
            paramView.putExtra("is_from_leba", true);
            paramView.putExtra("has_red_dot", bool2);
            a(paramView.putExtra("url", (String)localObject1).putExtra("title", str));
            label1211:
            do
            {
              if ((paramLebaViewItem.a.strPkgName.equalsIgnoreCase("com.tx.gamecenter.android")) || (paramLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131363570)))) {
                StatisticCollector.a(a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, "0", null, null, null, null);
              }
              this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11340005);
              if (paramLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                break;
              }
              this.jdField_c_of_type_Boolean = true;
              return;
              localObject1 = "status=" + -1 + "&number=0" + "&path=" + paramLebaViewItem.a.uiResId;
              bool1 = false;
              break label389;
              bool2 = false;
              break label457;
              if ((paramLebaViewItem.a != null) && (paramLebaViewItem.a.strPkgName.equals("qzone_feedlist")))
              {
                localObject4 = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                localObject2 = localObject1;
                bool2 = bool3;
                bool1 = bool4;
                if (localObject4 == null) {
                  break label570;
                }
                if (((QZoneManagerImp)localObject4).a(QZoneManager.FeedType.friendSpace) <= 0)
                {
                  localObject2 = localObject1;
                  bool2 = bool3;
                  bool1 = bool4;
                  if (((QZoneManagerImp)localObject4).a(QZoneManager.FeedType.mySpacefeed) <= 0) {
                    break label570;
                  }
                }
                bool1 = true;
                localObject2 = localObject1;
                bool2 = bool3;
                break label570;
              }
              localObject2 = localObject1;
              bool2 = bool3;
              bool1 = bool4;
              if (paramLebaViewItem.a == null) {
                break label570;
              }
              if (paramLebaViewItem.a.isNew == 0) {}
              for (bool1 = true;; bool1 = false)
              {
                localObject2 = localObject1;
                bool2 = bool3;
                break label570;
                break;
                break;
              }
            } while (paramInt != 2);
            localObject3 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), (String)localObject3);
            if (localObject3 != null)
            {
              if ((paramLebaViewItem.a.strPkgName.equals("com.tx.gamecenter.android")) || (paramLebaViewItem.a.strResName.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131363570)))) {
                ((JumpAction)localObject3).c("platformId=qq_m");
              }
              ((JumpAction)localObject3).a("from_leba", "fromleba");
              ((JumpAction)localObject3).a("config_res_plugin_item_name", str);
              ((JumpAction)localObject3).a(bool1);
              ((JumpAction)localObject3).b(paramLebaViewItem.a.strPkgName);
              ((JumpAction)localObject3).d((String)localObject2);
              ((JumpAction)localObject3).b(bool2);
              paramView = ((JumpAction)localObject3).a("cmp");
              localObject1 = ((JumpAction)localObject3).a("pkg");
              localObject2 = new StringBuffer();
              if ((TextUtils.isEmpty(paramView)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!paramView.equalsIgnoreCase("com.tencent.biz.coupon.CouponActivity")) || (!((String)localObject1).equalsIgnoreCase("com.tencent.qqlite"))) {
                break label1636;
              }
              paramInt = 1;
              if (paramInt != 0)
              {
                if ((localAppInfo == null) || (localAppInfo.type.get() <= 0) || (!bool1)) {
                  break label1670;
                }
                ((StringBuffer)localObject2).append("isRedLight=1");
                if (localAppInfo.type.has()) {
                  ((StringBuffer)localObject2).append("&redType=" + localAppInfo.type.get());
                }
                if (localAppInfo.buffer.has()) {
                  localObject1 = null;
                }
              }
            }
            for (;;)
            {
              try
              {
                paramView = URLEncoder.encode(localAppInfo.buffer.get(), "UTF-8");
                ((StringBuffer)localObject2).append("&couponBuffer=" + paramView);
                paramView = ((JumpAction)localObject3).a("url");
                if ((!TextUtils.isEmpty(paramView)) && (QRUtils.d(paramView))) {
                  ((JumpAction)localObject3).a("url", HtmlOffline.a(paramView, ((StringBuffer)localObject2).toString()));
                }
                ((JumpAction)localObject3).b();
                if (!paramLebaViewItem.a.strPkgName.equals("qzone_feedlist")) {
                  break;
                }
                paramView = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
                if (paramView == null) {
                  break;
                }
                paramView.a(QZoneManager.FeedType.friendSpace);
                paramView.a(true);
                break;
                label1636:
                paramInt = 0;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                paramView = (View)localObject1;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("JumpAction", 2, localUnsupportedEncodingException.getMessage());
                paramView = (View)localObject1;
                continue;
              }
              ((StringBuffer)localObject2).append("isRedLight=0");
            }
          }
          bool2 = false;
        }
      }
      label1701:
      paramLebaViewItem = null;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (!this.jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(11340002, 200L);
    }
    for (;;)
    {
      WebProcessManager.b(true);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new asp(this), 100L);
      if (jdField_a_of_type_Boolean != this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = jdField_a_of_type_Boolean;
        int i = 2130838743;
        if (jdField_a_of_type_Boolean) {
          i = 2130838744;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i);
      }
      return;
      if (LebaShowListManager.c > 0)
      {
        ArrayList localArrayList = new ArrayList();
        LebaUtil.a(localArrayList, LebaShowListManager.a().b());
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
            t();
          }
        }
        LebaShowListManager.c = 0;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ase(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new asq(this, paramBoolean), 150L);
  }
  
  protected void d()
  {
    super.d();
    WebProcessManager.b(false);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
      }
    }
    super.e();
  }
  
  public void f()
  {
    q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.m();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void j()
  {
    if ((LebaShowListManager.a() == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    if (LebaShowListManager.a().a())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected void k()
  {
    super.k();
    LebaShowListManager.a().a();
    t();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. begin.");
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject = LebaShowListManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      t();
    }
    localObject = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    if ((localObject != null) && (((WebProcessManager)localObject).c())) {
      ((WebProcessManager)localObject).e();
    }
  }
  
  void n()
  {
    LebaViewItem localLebaViewItem = (LebaViewItem)LebaShowListManager.a().a.get("nearby_friends");
    if ((localLebaViewItem != null) && (localLebaViewItem.a != null) && (localLebaViewItem.a.isNew == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        CustomWidgetUtil.a(this.jdField_c_of_type_AndroidWidgetTextView, 2, 0, 0);
        a(this.jdField_c_of_type_AndroidWidgetTextView, 2);
        return;
      }
      CustomWidgetUtil.a(this.jdField_c_of_type_AndroidWidgetTextView, 0, 0, 0);
      a(this.jdField_c_of_type_AndroidWidgetTextView, 0);
      return;
    }
  }
  
  public void o()
  {
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    int j;
    if (localObject != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("886.100170");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.type.get() != -1))
      {
        j = 0;
        int i = j;
        if (j == -1)
        {
          localAppInfo = ((RedTouchManager)localObject).a("886.100171");
          i = j;
          if (localAppInfo != null)
          {
            i = j;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              i = j;
              if (localAppInfo.type.get() != -1) {
                i = 1;
              }
            }
          }
        }
        j = i;
        if (i == -1)
        {
          localObject = ((RedTouchManager)localObject).a("886.100172");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)
            {
              j = i;
              if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != -1) {
                j = 2;
              }
            }
          }
        }
        if (j != -1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "dynamic", "exp_red", 0, 0, j + "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsActivity", 2, "ReportTroopAndActivityStatics, redDotFrom=" + j);
      }
      return;
      j = -1;
      break;
      j = -1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298227: 
    case 2131298232: 
    case 2131298238: 
      do
      {
        do
        {
          return;
          a(new Intent(a(), QQBrowserActivity.class).putExtra("url", jdField_a_of_type_JavaLangString));
          return;
          int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("nearby_people_skip_guide", false);
          if ((i != -1) || (bool)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), (int)a().getResources().getDimension(2131492887));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在检查资料");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          paramView = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        } while (paramView == null);
        paramView.g();
        return;
        NearbyActivity.a(a(), 0, 0);
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getHint()))
        {
          SearchActivity.a(a());
          return;
        }
        SearchActivity.a(a(), this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString());
      } while (TextUtils.isEmpty((String)this.jdField_a_of_type_AndroidWidgetEditText.getTag()));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB2", "0X8004AB2", 0, 0, (String)this.jdField_a_of_type_AndroidWidgetEditText.getTag(), null, null, null);
      return;
    }
    a(new Intent(a(), NearbyActivity.class));
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    f();
    if (!this.jdField_f_of_type_Boolean) {
      a(true);
    }
    this.jdField_f_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba
 * JD-Core Version:    0.7.0.1
 */