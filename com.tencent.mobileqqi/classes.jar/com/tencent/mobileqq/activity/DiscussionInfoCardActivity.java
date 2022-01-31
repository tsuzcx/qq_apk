package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
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
import cnk;
import cnl;
import cnm;
import cnn;
import cno;
import cnp;
import cnq;
import cnr;
import cns;
import cnt;
import cnu;
import cnv;
import cnw;
import cnx;
import cny;
import coa;
import cob;
import cod;
import coe;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
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
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
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
import cooperation.qzone.QZoneShareManager;
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
  private static final int B = -1;
  private static final int C = -1;
  private static final int D = 0;
  private static final int E = 1;
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
  public static final String i = "3";
  private static final String j;
  private static final int y = 16;
  private static final int z = 17;
  private int F = -1;
  private int G = -1;
  private final int H = 8;
  private float jdField_a_of_type_Float;
  protected final int a;
  private long jdField_a_of_type_Long;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new cnv(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  private coe jdField_a_of_type_Coe;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cnr(this);
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new cnl(this);
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new cob(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new coa(this);
  public DiscussionInfo a;
  private DiscussionMemberManager jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
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
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new cnw(this);
  public Handler b;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Handler jdField_c_of_type_AndroidOsHandler = new cnm(this);
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem e;
  private FormSimpleItem f;
  private FormSimpleItem g;
  protected final int h;
  private FormSimpleItem h;
  protected final int i = 1;
  protected final int j;
  protected int k;
  private String k;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int = 0;
  private String jdField_n_of_type_JavaLangString;
  private int jdField_o_of_type_Int;
  private String jdField_o_of_type_JavaLangString;
  private int jdField_p_of_type_Int;
  private String jdField_p_of_type_JavaLangString;
  private int jdField_q_of_type_Int;
  private String jdField_q_of_type_JavaLangString;
  private int r;
  private final int s = 0;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final int w = 8;
  private final int x = 9;
  
  static
  {
    jdField_j_of_type_JavaLangString = DiscussionInfoCardActivity.class.getSimpleName();
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
    jdField_e_of_type_Int = 0;
  }
  
  public DiscussionInfoCardActivity()
  {
    this.m = 0;
    this.o = 0;
    this.p = 0;
    this.q = 4;
    this.jdField_a_of_type_Int = 10;
    this.jdField_h_of_type_Int = 0;
    this.jdField_j_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler = new cnx(this);
    this.jdField_b_of_type_AndroidOsHandler = new cny(this);
  }
  
  private Bitmap a()
  {
    Bitmap localBitmap2 = FaceDrawable.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 101, this.jdField_l_of_type_JavaLangString).a();
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
      paramString1 = paramQQAppInterface.getString(2131559051, new Object[] { paramString2, paramString1 });
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setText(paramString1);
      }
      for (;;)
      {
        QQToast.a(paramQQAppInterface, 2, paramQQAppInterface.getResources().getString(2131559052), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131427376));
        return;
        ((android.content.ClipboardManager)paramQQAppInterface.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramString1));
      }
    }
    QQToast.a(paramQQAppInterface, 2, paramQQAppInterface.getResources().getString(2131559053), 0).b(paramQQAppInterface.getResources().getDimensionPixelSize(2131427376));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, QQProgressDialog paramQQProgressDialog)
  {
    jdField_e_of_type_Int += 1;
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramQQProgressDialog != null)) {}
    try
    {
      paramQQProgressDialog.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "2", "", "", "");
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getSkey(paramQQAppInterface.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        new Thread(new cns(paramLong, paramQQAppInterface, paramString2, str, paramActivity, paramString3, paramString1, paramInt, paramQQProgressDialog)).start();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_j_of_type_JavaLangString, 2, localException.toString());
        }
      }
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      QQToast.a(paramActivity, -1, paramActivity.getString(2131559050), 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, "3", "", "", "");
    paramString3 = String.format(paramContext.getString(2131562279), new Object[] { paramString3 });
    paramString2 = QRUtils.a(paramContext, "temp_discuss_link_share_" + paramString2 + ".png", TroopShareUtility.a(paramString1, paramContext.getResources()));
    if (TextUtils.isEmpty(paramString2)) {
      QQToast.a(paramContext, 1, 2131560519, 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
    }
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString2)) {
        localArrayList.add(paramString2);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", paramString3);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", paramString1);
      localBundle.putStringArrayList("image_url", localArrayList);
      QZoneShareManager.a(paramQQAppInterface, paramContext, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_j_of_type_JavaLangString, 2, "shareToQzone.title:" + paramString3 + " filePath:" + paramString2 + " shareLink:" + paramString1 + " desc:" + "");
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
    this.m = i2;
    this.jdField_n_of_type_Int = i2;
    this.o = i3;
    this.p = i3;
    this.q = i1;
    paramMyGridView.setPadding(this.m, this.o, this.jdField_n_of_type_Int, this.p);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      if (((this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) || ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130840184);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setBackgroundResource(2130840178);
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
      new Thread(new cnu(this, paramString)).start();
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
      DiscussionMemberManager.CacheData localCacheData = this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.jdField_l_of_type_JavaLangString);
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
  
  private void j()
  {
    QQToast.a(this, getString(2131562451), 0).b(d());
  }
  
  private void k()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_k_of_type_JavaLangString == null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
    }
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_l_of_type_JavaLangString);
    l();
    j(2130837729);
  }
  
  private void l()
  {
    Object localObject1 = (XListView)View.inflate(this, 2130903258, null);
    ((XListView)localObject1).setDivider(null);
    ((XListView)localObject1).setVerticalScrollBarEnabled(false);
    ((XListView)localObject1).setPadding(0, 0, 0, 0);
    Object localObject2 = View.inflate(this, 2130903118, null);
    ((XListView)localObject1).setAdapter(new XSimpleListAdapter((View)localObject2));
    setContentView((View)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject2).findViewById(2131231290));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject2).findViewById(2131231282));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231281));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231286));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231285));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231284));
    this.f = ((FormSimpleItem)((View)localObject2).findViewById(2131231288));
    this.g = ((FormSimpleItem)((View)localObject2).findViewById(2131231289));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131231292));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)((View)localObject2).findViewById(2131231291));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231283));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)((View)localObject2).findViewById(2131231287));
    i();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cnk(this));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    setTitle(2131561803);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_k_of_type_JavaLangString);
    localObject1 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_l_of_type_JavaLangString);
    if (localObject1 == null)
    {
      a(1, getString(2131562067));
      finish();
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 4, "DiscussionInfo.DiscussionFlag:" + ((DiscussionInfo)localObject1).DiscussionFlag);
    }
    v();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((DiscussionInfo)localObject1).hasCollect);
    if (((DiscussionInfo)localObject1).hasCollect)
    {
      localObject2 = getString(2131562883);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new cnt(this, (DiscussionInfo)localObject1));
      this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager = ((DiscussionMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(27));
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue());
      if ((localObject1 == null) || (((DiscussionInfo)localObject1).ownerUin == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!((DiscussionInfo)localObject1).ownerUin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        break label733;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    }
    for (;;)
    {
      c();
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("编辑讨论组名称");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131561646));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("删除讨论组成员");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131560622));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131560468));
      this.f.setContentDescription(getString(2131562216));
      this.g.setContentDescription(getString(2131562886));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131562883));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131562525));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562705));
      b(this.jdField_l_of_type_JavaLangString);
      return;
      localObject2 = getString(2131562883);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription((CharSequence)localObject2);
      break;
      label733:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  private void m()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Handler localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1009);
      }
      localHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(TroopAssistantActivity.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void n() {}
  
  private void o()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040F4", "0X80040F4", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this, EditActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", 2131562432);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("limit", 48);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("current", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("canPostNull", false);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("multiLine", false);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 0);
  }
  
  private void p()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "2", "", "", "");
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    startActivityForResult(localIntent, 1000);
  }
  
  private void q()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 1);
  }
  
  private void r()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "dis_mng_mber", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("troop_code", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("param_from", 1);
    startActivityForResult(localIntent, 9);
    overridePendingTransition(2130968591, 2130968592);
  }
  
  private void s()
  {
    Object localObject2 = this.jdField_k_of_type_JavaLangString;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = getString(2131562504);
    }
    localObject2 = DialogUtil.a(this, 230);
    ((QQCustomDialog)localObject2).setTitle(getString(2131562705));
    ((QQCustomDialog)localObject2).setMessage(String.format(getString(2131561975), new Object[] { localObject1 }));
    ((QQCustomDialog)localObject2).setPositiveButton(2131562703, new cnn(this));
    ((QQCustomDialog)localObject2).setNegativeButton(2131561751, new cno(this));
    ((QQCustomDialog)localObject2).show();
  }
  
  private void t()
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_k_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_l_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_a_of_type_Boolean);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void u()
  {
    if ((this.r >= 8) && (this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqManagersDiscussionMemberManager.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_l_of_type_JavaLangString);
    }
  }
  
  private void v()
  {
    Object localObject = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null)
    {
      localObject = ((FriendsManagerImp)localObject).a(this.jdField_l_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localObject == null) {
        break label115;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 4, "DiscussionMemberInfo.flag:" + ((DiscussionMemberInfo)localObject).flag);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if ((((DiscussionMemberInfo)localObject).flag & 0x1) != 0) {
          break label110;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
      }
    }
    label110:
    label115:
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {
      for (;;)
      {
        FormSwitchItem localFormSwitchItem;
        return;
        boolean bool = false;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) {
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(d());
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2130903940);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131562875));
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
      FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
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
          if (!localDiscussionMemberInfo.memberUin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
            break label117;
          }
          ((DiscussionMemberInfo)localObject1).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localDiscussionMemberInfo);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject2).memberUin = localDiscussionMemberInfo.memberUin;
          ((DiscussionMemberInfo)localObject2).memberName = ContactUtils.a(localDiscussionMemberInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          ((DiscussionMemberInfo)localObject2).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject2).memberName, 1);
          localArrayList.add(localObject2);
        }
      }
      Collections.sort(localArrayList, new cod(this));
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
        if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(0)) {
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
      }
    }
  }
  
  protected void b()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_l_of_type_JavaLangString, "discuss", "discuss_QR", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidContentIntent = new Intent(a(), QRDisplayActivity.class);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("title", getString(2131560514));
    this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_l_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("nick", this.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("type", 5);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussion_shorturl", this.jdField_n_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_l_of_type_JavaLangString, true);
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localObject).getBitmap();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", (Parcelable)localObject);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 10);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null) {
      return;
    }
    switch (this.jdField_k_of_type_Int)
    {
    default: 
      return;
    case 0: 
      e();
      return;
    case 1: 
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "discuss_set", "Clk_grptab", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), "", "", "");
      ChatSettingForTroop.a(this, TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 5), 2);
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode), 5);
    localBundle.putInt("D2GType", 1);
    ChatSettingForTroop.a(this, localBundle, 2);
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
          } while (this.jdField_a_of_type_Coe == null);
          this.jdField_a_of_type_Coe.notifyDataSetChanged();
          return;
          t();
          finish();
          return;
          setResult(-1);
          this.jdField_a_of_type_Boolean = true;
          return;
          a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
          return;
          localObject = "";
          if (paramIntent != null) {
            localObject = paramIntent.getStringExtra("result");
          }
        } while ((localObject == null) || (((String)localObject).equals("")) || (((String)localObject).equals(this.jdField_k_of_type_JavaLangString)));
        if (NetworkUtil.e(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue(), (String)localObject);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
          a(getString(2131561664));
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(1, getString(2131562488));
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        }
        Object localObject = new Intent(this, ChatActivity.class);
        paramIntent = paramIntent.getStringExtra("roomId");
        ((Intent)localObject).putExtra("uin", paramIntent);
        ((Intent)localObject).putExtra("uintype", 3000);
        ((Intent)localObject).putExtra("uinname", ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, getApplicationContext(), paramIntent));
        ((Intent)localObject).putExtra("isBack2Root", true);
        ((Intent)localObject).setFlags(67108864);
        startActivity((Intent)localObject);
        finish();
        return;
      } while ((paramInt2 != 0) || (3 != paramInt1));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
        finish();
      }
    } while (this.jdField_a_of_type_Coe == null);
    this.jdField_a_of_type_Coe.notifyDataSetChanged();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(DiscussionInfoCardActivity.class, this.jdField_c_of_type_AndroidOsHandler);
    k();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_l_of_type_Int == 1) {
      GroupCatalogTool.a(this).a();
    }
    try
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      u();
      b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      b(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(DiscussionInfoCardActivity.class);
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
    m();
    super.doOnPause();
  }
  
  protected void e()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131561953));
    localQQCustomDialog.setMessage(getString(2131561670));
    localQQCustomDialog.setPositiveButton(2131562544, new cnp(this));
    localQQCustomDialog.setNegativeButton(2131561751, new cnq(this));
    localQQCustomDialog.show();
  }
  
  public void f()
  {
    try
    {
      int i1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin).intValue();
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
      if (localBizTroopHandler == null) {
        return;
      }
      try
      {
        long l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localBizTroopHandler.a(0L, 1, l1, 2, a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, 30), "", 10010, i1, 1, 0L, 0L, 0, "", null, 3, false);
        g();
        return;
      }
      catch (NumberFormatException localNumberFormatException1) {}
      return;
    }
    catch (NumberFormatException localNumberFormatException2) {}
  }
  
  public void finish()
  {
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.i("DiscussionInfoCardActivity", 2, "finish");
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131561894);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void i()
  {
    int i1 = 2131561953;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null)
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupUin == 0L))
    {
      this.jdField_k_of_type_Int = 0;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131561953));
    }
    for (;;)
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(i1));
      return;
      FriendManager localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localFriendManager == null)
      {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
      }
      if (localFriendManager.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.groupCode)) != null)
      {
        this.jdField_k_of_type_Int = 1;
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131562023));
        i1 = 2131562023;
      }
      else
      {
        this.jdField_k_of_type_Int = 2;
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131562261));
        i1 = 2131562261;
      }
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.F = -1;
    this.G = -1;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    switch (paramView.getId())
    {
    case 2131231282: 
    case 2131231284: 
    case 2131231290: 
    case 2131231291: 
    default: 
      return;
    case 2131231281: 
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput = DialogUtil.a(this, 2131562432, null, this.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      return;
    case 2131231286: 
      n();
      return;
    case 2131231285: 
      b();
      return;
    case 2131231288: 
      p();
      return;
    case 2131231289: 
      q();
      return;
    case 2131231292: 
      s();
      return;
    case 2131231287: 
      d();
      return;
    }
    r();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (3000 == this.jdField_l_of_type_Int)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView);
      if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity
 * JD-Core Version:    0.7.0.1
 */