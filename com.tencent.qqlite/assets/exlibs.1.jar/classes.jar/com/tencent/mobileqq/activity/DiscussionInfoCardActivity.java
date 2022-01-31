package com.tencent.mobileqq.activity;

import air;
import ais;
import ait;
import aiu;
import aiw;
import aix;
import aiz;
import aja;
import ajb;
import ajc;
import ajd;
import aje;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.managers.DiscussionMemberManager;
import com.tencent.mobileqq.managers.DiscussionMemberManager.CacheData;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

public class DiscussionInfoCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int A = 0;
  private static final int B = 18;
  private static final int C = -1;
  private static final int D = -1;
  private static final int E = 0;
  private static final int F = 1;
  static final String jdField_a_of_type_JavaLangString = "memberUin";
  public static final int b = 1000;
  static final String jdField_b_of_type_JavaLangString = "memberName";
  public static int c = 0;
  static final String jdField_c_of_type_JavaLangString = "faceId";
  public static int d = 0;
  static final String jdField_d_of_type_JavaLangString = "pinyin";
  public static int e = 0;
  public static final String e = "D2GType";
  public static final int f = 1;
  public static final String f = "0";
  public static final int g = 2;
  public static final String g = "1";
  public static final String h = "2";
  private static final String i;
  private static final int y = 16;
  private static final int z = 17;
  private int G = -1;
  private int H = -1;
  private final int I = 8;
  private float jdField_a_of_type_Float;
  protected final int a;
  private long jdField_a_of_type_Long;
  private aje jdField_a_of_type_Aje;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajc(this);
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aiz(this);
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new aix(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new aiw(this);
  public DiscussionInfo a;
  private DiscussionMemberManager jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager;
  protected FormSimpleItem a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem e;
  private FormSimpleItem f;
  protected final int h = 0;
  protected final int i;
  protected final int j;
  private String j;
  protected int k;
  private String k;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int;
  private String jdField_n_of_type_JavaLangString;
  private int jdField_o_of_type_Int;
  private String jdField_o_of_type_JavaLangString;
  private int jdField_p_of_type_Int;
  private String jdField_p_of_type_JavaLangString;
  private int q = 4;
  private int r;
  private final int s = 0;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final int w = 8;
  private final int x = 9;
  
  static
  {
    jdField_i_of_type_JavaLangString = DiscussionInfoCardActivity.class.getSimpleName();
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
  }
  
  public DiscussionInfoCardActivity()
  {
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.jdField_a_of_type_Int = 10;
    this.jdField_i_of_type_Int = 1;
    this.jdField_j_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler = new aiu(this);
  }
  
  private Bitmap a()
  {
    Bitmap localBitmap2 = FaceDrawable.a(this.app, 101, this.k).a();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = ImageUtil.d();
    }
    return TroopShareUtility.a(localBitmap1);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str1;
    if ((paramString == null) || (paramInt <= 0)) {
      str1 = "";
    }
    for (;;)
    {
      return str1;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("utf-8");
        str1 = paramString;
        if (paramInt >= arrayOfByte.length) {
          continue;
        }
        str1 = new String(arrayOfByte, paramInt - 1, 3, "utf-8");
        String str2 = new String(arrayOfByte, paramInt - 2, 3, "utf-8");
        int i1;
        if ((str1.length() == 1) && (paramString.contains(str1))) {
          i1 = paramInt - 1;
        }
        for (;;)
        {
          return new String(arrayOfByte, 0, i1, "utf-8");
          i1 = paramInt;
          if (str2.length() == 1)
          {
            boolean bool = paramString.contains(str2);
            i1 = paramInt;
            if (bool) {
              i1 = paramInt - 2;
            }
          }
        }
        return paramString;
      }
      catch (Exception localException) {}
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "copy_link", 0, 0, "", "", "", "");
    paramQQAppInterface = BaseApplicationImpl.getContext();
    jdField_d_of_type_Int += 1;
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramLong > 0L))
    {
      paramString1 = "点击链接加入讨论组\"" + paramString2 + "\":\n" + paramString1;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, "已复制讨论组链接", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492887));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    QQToast.a(paramQQAppInterface, 2, "复制讨论组链接失败", 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131492887));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    jdField_e_of_type_Int += 1;
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramQQProgressDialog != null)) {}
    try
    {
      paramQQProgressDialog.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      if (!TextUtils.isEmpty(((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount())))
      {
        new Thread(new ais(paramLong, paramString3, paramString1, paramQQAppInterface, paramString2, paramActivity, paramInt, paramQQProgressDialog)).start();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_i_of_type_JavaLangString, 2, localException.toString());
        }
      }
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, "拉取讨论组连接失败，请重试！", 0).b(paramActivity.getResources().getDimensionPixelSize(2131492887));
    }
  }
  
  private void a(MyGridView paramMyGridView)
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i3 = (int)(20.0F * f1);
    int i1 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    int i5 = (int)(50.0F * f1);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1) + (i4 - i5) / 2;
    i3 = (int)(f1 * 20.0F);
    this.jdField_m_of_type_Int = i2;
    this.n = i2;
    this.o = i3;
    this.p = i3;
    this.q = i1;
    paramMyGridView.setPadding(this.jdField_m_of_type_Int, this.o, this.n, this.p);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      if (((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) || ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130837758);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130837758);
  }
  
  private void a(HashMap paramHashMap)
  {
    int i1 = 1;
    String str2;
    String str1;
    if ((paramHashMap != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      str2 = (String)paramHashMap.get("memberName");
      str1 = "";
      if (str2 != null) {
        str1 = ChnToSpell.a(str2, 1);
      }
      paramHashMap.put("pinyin", str1);
      if (TextUtils.isEmpty(str1)) {
        this.jdField_a_of_type_JavaUtilList.add(paramHashMap);
      }
    }
    else
    {
      return;
    }
    do
    {
      i1 += 1;
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      str2 = (String)((HashMap)this.jdField_a_of_type_JavaUtilList.get(i1)).get("pinyin");
    } while ((!TextUtils.isEmpty(str2)) && (str2.compareTo(str1) <= 0));
    this.jdField_a_of_type_JavaUtilList.add(i1, paramHashMap);
    return;
    this.jdField_a_of_type_JavaUtilList.add(paramHashMap);
  }
  
  private void b(String paramString)
  {
    try
    {
      new Thread(new ait(this, paramString)).start();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void c()
  {
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager != null)
    {
      DiscussionMemberManager.CacheData localCacheData = this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.k);
      bool1 = bool2;
      if (localCacheData != null)
      {
        bool1 = bool2;
        if (localCacheData.jdField_a_of_type_JavaUtilList != null)
        {
          bool1 = bool2;
          if (localCacheData.jdField_a_of_type_JavaUtilList.size() > 8)
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(localCacheData.jdField_a_of_type_JavaUtilList);
            this.jdField_a_of_type_JavaUtilArrayList.addAll(localCacheData.jdField_a_of_type_JavaUtilArrayList);
            this.r = this.jdField_a_of_type_JavaUtilList.size();
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void g()
  {
    QQToast.a(this, getString(2131362912), 0).b(getTitleBarHeight());
  }
  
  private void h()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_j_of_type_JavaLangString == null) {
      this.jdField_j_of_type_JavaLangString = this.k;
    }
    this.k = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.l = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.k);
    i();
    d(2130837633);
  }
  
  private void i()
  {
    Object localObject = (XListView)View.inflate(this, 2130903217, null);
    ((XListView)localObject).setDivider(null);
    ((XListView)localObject).setVerticalScrollBarEnabled(false);
    ((XListView)localObject).setPadding(0, 0, 0, 0);
    View localView = View.inflate(this, 2130903097, null);
    ((XListView)localObject).setAdapter(new XSimpleListAdapter(localView));
    setContentView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131296751));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131296749));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296750));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131296757));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131296756));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131296754));
    this.jdField_a_of_type_AndroidViewView = ((ImageView)localView.findViewById(2131296755));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131296759));
    this.f = ((FormSimpleItem)localView.findViewById(2131296760));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131296762));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView.findViewById(2131296761));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localView.findViewById(2131296752));
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new air(this));
    setTitle(2131363670);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
    localObject = ((FriendManager)this.app.getManager(8)).a(this.k);
    if (localObject == null)
    {
      a(1, getString(2131363115));
      finish();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(this.k));
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_i_of_type_JavaLangString, 2, "initDiscussionView getDiscussInfo error disUin=" + this.k, localException);
        return;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 4, "DiscussionInfo.DiscussionFlag:" + ((DiscussionInfo)localObject).DiscussionFlag);
    }
    s();
    this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager = ((DiscussionMemberManager)this.app.getManager(27));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.k).longValue());
    if ((localObject != null) && (((DiscussionInfo)localObject).ownerUin != null) && (this.app != null) && (this.app.a() != null) && (((DiscussionInfo)localObject).ownerUin.equals(this.app.a())))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    }
    for (;;)
    {
      c();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("编辑讨论组名称");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363683));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("删除讨论组成员");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131362507));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131362383));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131363078));
      this.f.setContentDescription(getString(2131363661));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131363721));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131363667));
      b(this.k);
      return;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      localException.findViewById(2131296753).setVisibility(8);
    }
  }
  
  private void j()
  {
    if (this.app != null)
    {
      Handler localHandler = this.app.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.app.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void k() {}
  
  private void l()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131363218);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current", this.jdField_j_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void m()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.k);
    localIntent.putExtra("uintype", this.l);
    startActivityForResult(localIntent, 1000);
  }
  
  private void n()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", this.k);
    localIntent.putExtra("uintype", this.l);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 1);
  }
  
  private void o()
  {
    ReportController.b(this.app, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.k);
    localIntent.putExtra("troop_code", this.k);
    localIntent.putExtra("param_from", 1);
    localIntent.putExtra("param_is_pop_up_style", true);
    startActivityForResult(localIntent, 9);
  }
  
  private void p()
  {
    Object localObject2 = this.jdField_j_of_type_JavaLangString;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = getString(2131363221);
    }
    localObject2 = DialogUtil.a(this, 230);
    ((QQCustomDialog)localObject2).setTitle(getString(2131363667));
    ((QQCustomDialog)localObject2).setMessage(String.format(getString(2131363668), new Object[] { localObject1 }));
    ((QQCustomDialog)localObject2).setPositiveButton(2131363722, new aja(this));
    ((QQCustomDialog)localObject2).setNegativeButton(2131363111, new ajb(this));
    ((QQCustomDialog)localObject2).show();
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.k);
    localIntent.putExtra("uinname", this.jdField_j_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.l);
    localIntent.putExtra("isNeedUpdate", this.jdField_a_of_type_Boolean);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void r()
  {
    if ((this.r >= 8) && (this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, this.k);
    }
  }
  
  private void s()
  {
    Object localObject = (FriendsManagerImp)this.app.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendsManagerImp)localObject).a(this.k, this.app.a());
      if (localObject == null) {
        break label115;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_i_of_type_JavaLangString, 4, "DiscussionMemberInfo.flag:" + ((DiscussionMemberInfo)localObject).flag);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((((DiscussionMemberInfo)localObject).flag & 0x1) != 0) {
          break label110;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
      }
    }
    label110:
    label115:
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {
      for (;;)
      {
        FormSwitchItem localFormSwitchItem;
        return;
        boolean bool = false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130903615);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131363378));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ChnToSpell.a(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        HashMap localHashMap = (HashMap)localIterator.next();
        if ((localHashMap != null) && (TextUtils.isEmpty((String)localHashMap.get("pinyin"))))
        {
          String str2 = (String)localHashMap.get("memberName");
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = (String)localHashMap.get("memberUin");
          }
          if (!TextUtils.isEmpty(str1)) {
            localHashMap.put("pinyin", ChnToSpell.a(str1, 1));
          }
        }
      }
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        a((HashMap)paramArrayList.get(i1));
        i1 += 1;
      }
      this.r = this.jdField_a_of_type_JavaUtilList.size();
    }
  }
  
  public void a(List paramList)
  {
    ChnToSpell.a(this);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
      Object localObject1 = new DiscussionMemberInfo();
      int i1 = 0;
      DiscussionMemberInfo localDiscussionMemberInfo;
      label117:
      Object localObject2;
      if (i1 < paramList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)paramList.get(i1);
        if (localDiscussionMemberInfo != null)
        {
          if (!localDiscussionMemberInfo.memberUin.equals(this.app.a())) {
            break label117;
          }
          ((DiscussionMemberInfo)localObject1).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a(this.app, localDiscussionMemberInfo);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.app);
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject2).memberName, 1);
          localArrayList.add(localObject2);
        }
      }
      Collections.sort(localArrayList, new ajd(this));
      localArrayList.add(0, localObject1);
      paramList = new ArrayList();
      localObject1 = new ArrayList();
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(i1);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("memberUin", localDiscussionMemberInfo.memberUin);
        ((HashMap)localObject2).put("memberName", localDiscussionMemberInfo.memberName);
        if (i1 > 0) {
          ((HashMap)localObject2).put("pinyin", localDiscussionMemberInfo.discussionUin);
        }
        Friends localFriends = localFriendManager.c(localDiscussionMemberInfo.memberUin);
        if (localFriends != null) {
          ((HashMap)localObject2).put("faceId", Short.valueOf(localFriends.faceid));
        }
        paramList.add(localObject2);
        ((ArrayList)localObject1).add(localDiscussionMemberInfo.memberUin);
        i1 += 1;
      }
      if (paramList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
        paramList.clear();
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
      }
    }
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", this.k, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(getActivity(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", getString(2131362426));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.k);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_j_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussion_shorturl", this.jdField_m_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.k, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    try
    {
      int i1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).intValue();
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(19);
      if (localBizTroopHandler == null) {
        return;
      }
      try
      {
        long l1 = Long.parseLong(this.app.a());
        localBizTroopHandler.a(0L, 1, l1, 2, a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, 30), "", 10010, i1, 1, 0L, 0L, 0, "", null, 3, false);
        e();
        return;
      }
      catch (NumberFormatException localNumberFormatException1) {}
      return;
    }
    catch (NumberFormatException localNumberFormatException2) {}
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Aje == null);
          this.jdField_a_of_type_Aje.notifyDataSetChanged();
          return;
          q();
          finish();
          return;
          setResult(-1);
          this.jdField_a_of_type_Boolean = true;
          return;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_j_of_type_JavaLangString)));
        if (NetworkUtil.e(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.k).longValue(), (String)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          a(getString(2131363672));
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(1, getString(2131363449));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = new Intent(this, ChatActivity.class);
        paramIntent = paramIntent.getStringExtra("roomId");
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        ((Intent)localObject).setFlags(67108864);
        startActivity((Intent)localObject);
        finish();
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Aje == null);
    this.jdField_a_of_type_Aje.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.a(DiscussionInfoCardActivity.class, this.jdField_a_of_type_AndroidOsHandler);
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.l == 1) {
      GroupCatalogTool.a(this).a();
    }
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      r();
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.a(DiscussionInfoCardActivity.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnPause()
  {
    j();
    super.doOnPause();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363802);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public int getPathNodeID()
  {
    return 22;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.G = -1;
    this.H = -1;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    case 2131296750: 
    case 2131296751: 
    case 2131296753: 
    case 2131296754: 
    case 2131296755: 
    case 2131296758: 
    case 2131296761: 
    default: 
      return;
    case 2131296749: 
      l();
      return;
    case 2131296757: 
      k();
      return;
    case 2131296756: 
      b();
      return;
    case 2131296759: 
      m();
      return;
    case 2131296760: 
      n();
      return;
    case 2131296762: 
      p();
      return;
    }
    o();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (3000 == this.l)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */