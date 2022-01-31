package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awz;
import axa;
import axb;
import axc;
import axd;
import axg;
import axh;
import axi;
import axj;
import axk;
import axm;
import axn;
import axo;
import axp;
import axq;
import axr;
import axs;
import axt;
import axu;
import axw;
import ayc;
import ayd;
import aye;
import ayf;
import ayg;
import ayh;
import ayi;
import ayj;
import ayk;
import ayl;
import aym;
import ayn;
import ayo;
import ayp;
import ayq;
import ayr;
import ays;
import ayt;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NearbyPeopleProfileActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener
{
  public static final int a = 0;
  public static final String a = "NearbyPeopleProfileActivity";
  public static final int b = 1;
  private static final long jdField_b_of_type_Long = 20000L;
  public static final String b = "param_mode";
  public static final int c = 1;
  public static final String c = "param_tiny_id";
  public static final int d = 2;
  public static final String d = "AllInOne";
  public static final int e = 3;
  public static final String e = "param_dating_id";
  public static final int f = 4;
  public static final String f = "param_no_miss";
  public static final int g = 6;
  public static final String g = "param_xuan_yan";
  public static final int h = 7;
  public static final String h = "param_nickname";
  public static final int i = 1;
  public static final String i = "param_gender";
  public static final int j = 2;
  public static final String j = "param_age";
  public static final int k = 3;
  public static final String k = "param_career";
  public static final int l = -1;
  public static final String l = "param_constellation";
  public static final int m = 640;
  public static final String m = "param_marital_status";
  public static final String n = "param_photo_count";
  private static final int jdField_o_of_type_Int = 12;
  public static final String o = "140";
  private static final int jdField_p_of_type_Int = 100;
  public static final String p = "250";
  private static final int jdField_q_of_type_Int = 101;
  private static final int jdField_r_of_type_Int = 1000;
  private static final String jdField_t_of_type_JavaLangString = "plus";
  private static final int v = 1000;
  private static final int w = 1001;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Uri jdField_a_of_type_AndroidNetUri;
  public Handler a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ays jdField_a_of_type_Ays;
  private ayt jdField_a_of_type_Ayt;
  private ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new axw(this);
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new ayq(this);
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new axu(this);
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new ayo(this);
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ayc(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private Dialog jdField_b_of_type_AndroidAppDialog = null;
  private ViewPager jdField_b_of_type_AndroidSupportV4ViewViewPager;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ays jdField_b_of_type_Ays;
  private ayt jdField_b_of_type_Ayt;
  private ConditionSearchManager.IConfigListener jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new ayj(this);
  private IphonePickerView.PickerViewAdapter jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new ayp(this);
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  private boolean jdField_b_of_type_Boolean = false;
  private Dialog jdField_c_of_type_AndroidAppDialog = null;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private EditText jdField_e_of_type_AndroidWidgetEditText;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  private EditText jdField_f_of_type_AndroidWidgetEditText;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private EditText jdField_g_of_type_AndroidWidgetEditText;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private EditText jdField_h_of_type_AndroidWidgetEditText;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private EditText jdField_i_of_type_AndroidWidgetEditText;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private EditText jdField_j_of_type_AndroidWidgetEditText;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_j_of_type_AndroidWidgetLinearLayout;
  private ImageView jdField_k_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_k_of_type_AndroidWidgetLinearLayout;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_l_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private ImageView jdField_m_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_m_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public int n;
  private ImageView jdField_n_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_n_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_o_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  private String jdField_q_of_type_JavaLangString;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  private String jdField_r_of_type_JavaLangString;
  private int jdField_s_of_type_Int;
  private TextView jdField_s_of_type_AndroidWidgetTextView;
  private String jdField_s_of_type_JavaLangString;
  private int jdField_t_of_type_Int;
  private int u = 0;
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new axa(this);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn())
    {
      TextView localTextView;
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130839217, 0, 0, 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount));
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount).append("人已赞过");
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted != 0) {
          break label143;
        }
      }
      label143:
      for (String str = "";; str = "你已点赞")
      {
        localTextView.setContentDescription(str);
        return;
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130839218, 0, 0, 0);
        this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(null);
        break;
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void B()
  {
    View localView1;
    View localView2;
    if ((this.jdField_e_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_e_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
    {
      localView1 = this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131296422);
      localView2 = this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131296424);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localView1.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localView2.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    localView1.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    localView2.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void C()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(this.jdField_n_of_type_Int + (int)(21.0F * this.jdField_c_of_type_Float), 0, 0, 0);
    localLayoutParams.addRule(2, 2131298299);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void E()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131364436), new ayh(this), new ayi(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void G()
  {
    if (!LBSHandler.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))
    {
      F();
      return;
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, 3007, 0, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, AddContactsActivity.class.getName(), b_()));
      return;
    }
    startActivityForResult(AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, null, 3007, 0, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, null, FriendProfileCardActivity.class.getName(), b_()), 1000);
  }
  
  private void H()
  {
    ThreadPriorityManager.a(true);
    if (this.jdField_d_of_type_Boolean) {}
    for (int i1 = 0; f(); i1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      setResult(0, localIntent);
      finish();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
  }
  
  private TroopInfo a()
  {
    new ArrayList();
    Object localObject = ((TroopManager)this.app.getManager(44)).b();
    if (localObject == null)
    {
      new ArrayList();
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject).next();
      int i1 = TroopListAdapter2.a(this.app.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        localArrayList1.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        localArrayList2.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      } else {
        localArrayList3.add(new TroopListAdapter2.TroopListItemWithMask(i1, localEntity));
      }
    }
    localObject = new TroopListAdapter2.TroopCompator();
    Collections.sort(localArrayList1, (Comparator)localObject);
    Collections.sort(localArrayList2, (Comparator)localObject);
    Collections.sort(localArrayList3, (Comparator)localObject);
    if (localArrayList1.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList1.get(0)).a;
    }
    if (localArrayList2.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList2.get(0)).a;
    }
    if (localArrayList3.size() != 0) {
      return (TroopInfo)((TroopListAdapter2.TroopListItemWithMask)localArrayList3.get(0)).a;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 0, paramInt, 2131364473, 2131364474, new axg(this), new axh(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  private void a(ViewPager paramViewPager)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 3) {}
    for (RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(6.0F * this.jdField_c_of_type_Float) + this.jdField_n_of_type_Int);; localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(9.0F * this.jdField_c_of_type_Float) + this.jdField_n_of_type_Int * 2))
    {
      paramViewPager.setLayoutParams(localLayoutParams);
      if (paramViewPager == this.jdField_b_of_type_AndroidSupportV4ViewViewPager)
      {
        paramViewPager = new RelativeLayout.LayoutParams(-2, -2);
        paramViewPager.addRule(7, this.jdField_b_of_type_AndroidSupportV4ViewViewPager.getId());
        paramViewPager.addRule(8, this.jdField_b_of_type_AndroidSupportV4ViewViewPager.getId());
        paramViewPager.setMargins(0, 0, (int)(this.jdField_c_of_type_Float * 10.0F), (int)(this.jdField_c_of_type_Float * 10.0F));
        this.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramViewPager);
      }
      return;
    }
  }
  
  private void a(EditText paramEditText, int paramInt)
  {
    String str = paramEditText.getText().toString();
    if (str.getBytes().length > paramInt)
    {
      while (str.getBytes().length > paramInt) {
        str = str.substring(0, str.length() - 1);
      }
      paramEditText.setText(str);
      paramEditText.setSelection(str.length());
    }
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if ((paramTextView == this.jdField_l_of_type_AndroidWidgetTextView) && (this.jdField_i_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    Object localObject2;
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.a(paramArrayOfByte);
      if (localRichStatus != null) {
        localObject1 = localRichStatus.a(null, -8947849, getResources().getColor(2131427354));
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new SpannableString("");
      }
      if ((localRichStatus == null) || (TextUtils.isEmpty(localRichStatus.c))) {
        break label288;
      }
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
        break label273;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.b, 200);
      localObject1 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject1, false, false);
      int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject1).setBounds(0, 0, i1, i1);
      localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
      ((OffsetableImageSpan)localObject1).a(-0.1F);
      ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      if ((paramTextView == this.jdField_l_of_type_AndroidWidgetTextView) && (this.jdField_i_of_type_AndroidWidgetLinearLayout != null) && (paramArrayOfByte.length > 0))
      {
        this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return;
      label273:
      localObject1 = BitmapManager.a(getResources(), 2130839082);
      break;
      label288:
      paramTextView.setText((CharSequence)localObject2);
    }
  }
  
  private void a(ays paramays)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 2)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramays);
      this.jdField_b_of_type_Ayt.a();
      return;
    }
    paramays = DialogUtil.a(this, "没有头像，怎么交朋友？请保留至少一张照片作为交友头像。", 0, 0, null, null);
    paramays.setPositiveButton(2131362795, new ayg(this, paramays));
    paramays.show();
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    localIntent.putExtra("cSpecialFlag", getIntent().getExtras().getInt("cSpecialFlag"));
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i != 0) {
      localIntent.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i);
    }
    if (paramInt == 1001) {
      localIntent.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
    }
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i1 = 1;
    switch (paramArrayList.size())
    {
    }
    for (;;)
    {
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130837924);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130837927);
      ((View)paramArrayList.get(1)).setBackgroundResource(2130837926);
      return;
      ((View)paramArrayList.get(0)).setBackgroundResource(2130837927);
      ((View)paramArrayList.get(paramArrayList.size() - 1)).setBackgroundResource(2130837926);
      while (i1 < paramArrayList.size() - 1)
      {
        ((View)paramArrayList.get(i1)).setBackgroundResource(2130837927);
        i1 += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      v();
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
      if ((getIntent() != null) && (getIntent().getBooleanExtra("param_no_miss", false))) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      overridePendingTransition(2130968587, 2130968588);
      finish();
      return;
      if (!this.app.getPreferences().getBoolean("nearby_people_skip_guide", false)) {
        this.app.getPreferences().edit().putBoolean("nearby_people_skip_guide", true).commit();
      }
    }
  }
  
  private void b(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  private void c(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.app.a());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("NearbyPeopleProfileActivity", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      startActivity(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_e_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.jdField_g_of_type_AndroidWidgetEditText.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!this.jdField_h_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!this.jdField_i_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.jdField_j_of_type_AndroidWidgetEditText.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298252));
    this.jdField_b_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131298254));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298257));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131298259));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131298253));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298263));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298262));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298264));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298265));
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298267));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298266));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298268));
    this.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298270));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298269));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298271));
    this.jdField_k_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298273));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298272));
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298274));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298275));
    this.jdField_l_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298277));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298276));
    this.p = ((TextView)findViewById(2131298278));
    this.jdField_m_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298280));
    this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298279));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298281));
    this.jdField_n_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298283));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298282));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298284));
    this.jdField_o_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298286));
    this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298285));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298287));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298289));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298288));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296569));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297557));
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298290));
    this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298291));
    int i1 = getResources().getColor(2131427446);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131296422).setBackgroundColor(i1);
    this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131296424).setBackgroundColor(i1);
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setNeedHorizontalGesture(true);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131298251));
    this.jdField_a_of_type_Ayt = new ayt(this, 1, this.jdField_b_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_b_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Ayt);
    this.jdField_b_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131298260);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 6) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(1, true);
    }
  }
  
  private boolean f()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e != 2);
  }
  
  private void g()
  {
    if (this.jdField_s_of_type_Int == 1) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaUtilArrayList.size() - 1 + "/" + 12);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 6) {
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup != null) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetRadioGroup == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
  }
  
  private void i()
  {
    ActionSheet localActionSheet = ActionSheet.a(this, 2131624119);
    localActionSheet.c("拍照");
    localActionSheet.c("从相册选择");
    localActionSheet.d(2131362794);
    localActionSheet.a(new axb(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("编辑资料");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("交友信息仅陌生人可见");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    findViewById(2131296896).setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_h_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(new axc(this));
    setRightButton(2131363433, new axd(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ays localays = (ays)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localays != this.jdField_a_of_type_Ays) && (localays.jdField_a_of_type_Int == -1)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localays);
      }
      i1 += 1;
    }
    this.t = this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  private void l()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 2131364475, 2131364476, 2131362794, 2131364477, new axi(this), new axj(this));
    if ((this.jdField_c_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_c_of_type_AndroidAppDialog.show();
    }
  }
  
  private void m()
  {
    if (getIntent() == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      if (getIntent().getIntExtra("param_mode", 0) == 1)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(new ArrayList());
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
        a(false);
        return;
      }
    } while ((getIntent().getIntExtra("param_mode", 0) != 2) || (this.jdField_s_of_type_Int != 1));
    u();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder("正在上传照片(");
      ((StringBuilder)localObject).append(this.t - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.t).append(")...");
      a(((StringBuilder)localObject).toString());
      localObject = new axk(this);
      this.app.a((Runnable)localObject);
      return;
    }
    o();
  }
  
  private void o()
  {
    a("正在保存资料...");
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ays localays = (ays)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localays != this.jdField_a_of_type_Ays) {
        localArrayList.add(Integer.valueOf(localays.jdField_a_of_type_Int));
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_b_of_type_JavaUtilArrayList.size()) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(localArrayList);
      return;
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label186;
        }
        if (((ays)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int != ((ays)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int)
        {
          i1 = 1;
          break;
        }
        i1 += 1;
      }
      label186:
      i1 = 0;
    }
  }
  
  private void p()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    Object localObject2;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localObject2 = (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      localBundle.putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag())) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
      {
        localBundle.putString("key_new_nickname", (String)localObject1);
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      if ((this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
      {
        localBundle.putByte("key_marital_status", ((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
      }
      if ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender))
      {
        localBundle.putByte("sex", ((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.jdField_e_of_type_AndroidWidgetEditText.getTag();
      if (((Integer)localObject1[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
      {
        localBundle.putInt("birthday", ((Integer)localObject1[0]).intValue());
        localBundle.putInt("age", ((Integer)localObject1[1]).intValue());
        localBundle.putByte("key_constellation", (byte)((Integer)localObject1[2]).intValue());
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
      if (((Integer)this.jdField_g_of_type_AndroidWidgetEditText.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
      {
        localBundle.putInt("profession", ((Integer)this.jdField_g_of_type_AndroidWidgetEditText.getTag()).intValue());
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
      }
      localObject1 = this.jdField_h_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
      {
        localBundle.putString("company", (String)localObject1);
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
      }
      localObject1 = this.jdField_i_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
      {
        localBundle.putString("college", (String)localObject1);
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
      }
      if (!Arrays.equals((String[])this.jdField_j_of_type_AndroidWidgetEditText.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
      {
        localBundle.putStringArray("hometown", (String[])this.jdField_j_of_type_AndroidWidgetEditText.getTag());
        ReportController.b(this.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) {
        break label971;
      }
      i1 = 0;
      localBundle.putShort("key_qzone_switch", (short)i1);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) {
        break label976;
      }
      localObject1 = "1";
      label831:
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004821", "0X8004821", 0, 0, (String)localObject1, "", "", "");
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) {
        break label983;
      }
      i1 = 0;
      label869:
      localBundle.putShort("key_hobby_switch", (short)i1);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) {
        break label988;
      }
    }
    label971:
    label976:
    label983:
    label988:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004822", "0X8004822", 0, 0, (String)localObject1, "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "NearbyPeopleProfileActivity.updateProfile(), modified_data = " + localBundle.toString());
      }
      return;
      i1 = 1;
      break;
      localObject1 = "0";
      break label831;
      i1 = 1;
      break label869;
    }
  }
  
  private void q()
  {
    Object localObject;
    if (2 == this.jdField_s_of_type_Int)
    {
      setTitle(this.jdField_q_of_type_JavaLangString);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser())
      {
        localObject = this.jdField_h_of_type_AndroidWidgetTextView.getCompoundDrawables();
        localDrawable = getResources().getDrawable(2130838177);
        localDrawable.setBounds((int)(6.0F * this.jdField_c_of_type_Float), 0, (int)(this.jdField_c_of_type_Float * 15.0F), (int)(this.jdField_c_of_type_Float * 15.0F));
        this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawables(localObject[0], localObject[1], localDrawable, localObject[2]);
        this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(12);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      findViewById(2131296896).setVisibility(8);
    }
    while (3 != this.jdField_s_of_type_Int)
    {
      Drawable localDrawable;
      if (this.jdField_s_of_type_Int == 2)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        setRightButton(2131363436, new axm(this));
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_q_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser())
    {
      localObject = getResources().getDrawable(2130838177);
      ((Drawable)localObject).setBounds(0, 0, (int)(this.jdField_c_of_type_Float * 15.0F), (int)(this.jdField_c_of_type_Float * 15.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(12);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      findViewById(2131296896).setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void r()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FriendProfileCardActivity.e);
      localStringBuilder.append("sid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.app.getSid(), "UTF-8"));
      localStringBuilder.append("&hostuin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  private void s()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FriendProfileCardActivity.d);
      localStringBuilder.append("&sid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.app.getSid(), "UTF-8"));
      localStringBuilder.append("&res_uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      startActivity(new Intent(this, QQBrowserActivity.class).putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  private void t()
  {
    this.jdField_s_of_type_Int = 1;
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(300L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(300L);
    localAlphaAnimation1.setAnimationListener(new axo(this));
    localAlphaAnimation2.setAnimationListener(new axp(this));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    }
    ((BounceScrollView)this.jdField_a_of_type_AndroidViewView).setNeedHorizontalGesture(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation2);
  }
  
  private void u()
  {
    this.jdField_s_of_type_Int = 2;
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(300L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(300L);
    localAlphaAnimation1.setAnimationListener(new axq(this));
    localAlphaAnimation2.setAnimationListener(new axr(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.startAnimation(localAlphaAnimation2);
  }
  
  private void v()
  {
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
    localNearPeopleFilters.i = -1;
    NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a(), localNearPeopleFilters);
    this.u = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  private void x()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(arrayOfString);
      if (this.jdField_j_of_type_AndroidWidgetEditText != null)
      {
        if (!"不限".equals(str)) {
          this.jdField_j_of_type_AndroidWidgetEditText.setText(str);
        }
        this.jdField_j_of_type_AndroidWidgetEditText.setTag(arrayOfString);
      }
      if (this.jdField_r_of_type_AndroidWidgetTextView != null)
      {
        if (!"不限".equals(str)) {
          break label130;
        }
        this.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    return;
    label130:
    this.jdField_r_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void y()
  {
    j();
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_Ays)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ays);
    }
    this.jdField_b_of_type_Ayt.a();
    a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_a_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    this.jdField_c_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
    this.jdField_d_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.jdField_d_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.jdField_e_of_type_AndroidWidgetEditText.setText("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
    this.jdField_f_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
    this.jdField_e_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age), Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) });
    this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
    if (StringUtil.b(NearbyProfileUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job))) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_g_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.jdField_g_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.jdField_h_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.jdField_h_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_i_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      this.jdField_i_of_type_AndroidWidgetEditText.clearFocus();
      x();
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void z()
  {
    this.jdField_q_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
    if (this.jdField_s_of_type_Int == 2)
    {
      this.jdField_r_of_type_JavaLangString = "";
      q();
      if (this.jdField_e_of_type_Boolean) {
        break label582;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
      label55:
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_Ays)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Ays);
      }
      this.jdField_a_of_type_Ayt.a();
      A();
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age));
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label596;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130838083), null, null, null);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130838734);
      label149:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0) {
        break label664;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      label168:
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      a(this.jdField_l_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      if (!StringUtil.b(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) {
        break label702;
      }
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(8);
      label235:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= NearbyProfileUtil.d.length)) {
        break label787;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job != NearbyProfileUtil.d.length - 1) {
        break label740;
      }
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
      label284:
      this.jdField_o_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
      label318:
      if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        break label808;
      }
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      label349:
      if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        break label841;
      }
      this.jdField_m_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
      label380:
      x();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed())) {
        break label874;
      }
      this.jdField_o_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(8);
      label422:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowQzoneFeed()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hasQzonePhotoUrl())) {
        break label981;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_s_of_type_Int != 3) {
        break label1270;
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      B();
      return;
      if (this.jdField_s_of_type_Int != 3) {
        break;
      }
      Object localObject2 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance == null)
      {
        localObject1 = "";
        label520:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" ");
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff != null) {
          break label571;
        }
      }
      label571:
      for (Object localObject1 = "";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)
      {
        this.jdField_r_of_type_JavaLangString = ((String)localObject1);
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
        break label520;
      }
      label582:
      findViewById(2131298258).setVisibility(4);
      break label55;
      label596:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130838078), null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130838733);
        break label149;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130838734);
      break label149;
      label664:
      this.jdField_g_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundResource(2130838736);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      break label168;
      label702:
      this.jdField_m_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(0);
      break label235;
      label740:
      this.jdField_n_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.e[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_n_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
      break label284;
      label787:
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(8);
      break label318;
      label808:
      this.p.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(0);
      break label349;
      label841:
      this.jdField_q_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      this.jdField_m_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      break label380;
      label874:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneFeed;
      localObject1 = localObject2;
      if (StringUtil.b((String)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.qzoneName;
      }
      localObject2 = localObject1;
      if (StringUtil.b((String)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname + getString(2131363892);
      }
      this.jdField_s_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_s_of_type_AndroidWidgetTextView.setOnClickListener(new axs(this));
      this.jdField_o_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
      break label422;
      label981:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getQZonePhotoList();
      String str1 = MD5.toMD5("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
      int i1 = 0;
      if (i1 < 3)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298381 + i1);
        if ((localObject2 != null) && (((List)localObject2).size() > i1))
        {
          localObject1 = (String)((List)localObject2).get(i1);
          label1068:
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (localImageView == null)) {
            break label1099;
          }
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject1 = null;
          break label1068;
          label1099:
          if (localImageView != null)
          {
            String str2 = AppConstants.bp + str1 + "_" + MD5.toMD5((String)localObject1);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131427373));
            }
            try
            {
              localObject1 = URLDrawable.getDrawable(new URL("profile_img_icon", (String)localObject1, str2), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
              localImageView.setVisibility(0);
              localImageView.setImageDrawable((Drawable)localObject1);
            }
            catch (MalformedURLException localMalformedURLException)
            {
              localImageView.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
              QLog.e("Q.nearby_people_card.", 2, localMalformedURLException.toString());
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new axt(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label1270:
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = paramArrayOfByte;
    runOnUiThread(new ayk(this));
  }
  
  protected boolean a()
  {
    int i1 = 0;
    if (getIntent() != null) {
      i1 = getIntent().getIntExtra("param_mode", 0);
    }
    if (i1 == 1)
    {
      a(2131364471);
      return true;
    }
    if ((i1 == 2) && (this.jdField_s_of_type_Int == 1))
    {
      k();
      if (this.u == 0)
      {
        a(2131364471);
        return true;
      }
      if ((this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) || (c()) || (this.jdField_b_of_type_Boolean))
      {
        a(2131364472);
        return true;
      }
      m();
      return true;
    }
    return super.a();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d()
  {
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.app.getManager(49);
    int i1 = localConditionSearchManager.a();
    if (i1 != 0)
    {
      i1 = localConditionSearchManager.a(i1);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPeopleProfileActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131363516, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(getString(2131364393));
        localConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(getString(2131364393));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    String[] arrayOfString2 = (String[])this.jdField_j_of_type_AndroidWidgetEditText.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.b(arrayOfString1));
    startActivityForResult(localIntent, 4);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (paramInt2 != -1);
                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
              } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
              a(this.jdField_a_of_type_AndroidWidgetEditText, paramIntent);
              this.jdField_a_of_type_AndroidWidgetEditText.setTag(paramIntent);
              return;
            } while ((paramInt2 != -1) || (this.jdField_e_of_type_AndroidWidgetEditText == null));
            paramInt1 = paramIntent.getShortExtra("param_year", (short)-1);
            paramInt2 = paramIntent.getByteExtra("param_month", (byte)-1);
            int i1 = paramIntent.getByteExtra("param_day", (byte)-1);
            int i2 = paramIntent.getIntExtra("param_age", 0);
            this.jdField_e_of_type_AndroidWidgetEditText.setText(i2 + "岁");
            localObject1 = paramIntent.getStringExtra("param_constellation");
            int i3 = paramIntent.getIntExtra("param_constellation_id", 0);
            this.jdField_f_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
            this.jdField_e_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | paramInt2 << 8 | i1), Integer.valueOf(i2), Integer.valueOf(i3) });
            return;
          } while ((paramInt2 != -1) || (this.jdField_g_of_type_AndroidWidgetEditText == null));
          localObject1 = paramIntent.getStringExtra("param_name");
          paramInt1 = paramIntent.getIntExtra("param_id", -1);
          localObject2 = paramIntent.getStringExtra("param_tag");
          paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_g_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
            this.jdField_g_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
            return;
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        } while (paramInt2 != -1);
        localObject2 = paramIntent.getStringArrayExtra("param_location");
        paramIntent = null;
        try
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject2);
          paramIntent = (Intent)localObject1;
        }
        catch (Exception localException)
        {
          break label402;
        }
        if (paramIntent != null)
        {
          localObject1 = paramIntent;
          if (!paramIntent.equals("不限")) {}
        }
        else
        {
          localObject1 = "";
        }
      } while (this.jdField_j_of_type_AndroidWidgetEditText == null);
      this.jdField_j_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      this.jdField_j_of_type_AndroidWidgetEditText.setTag(localObject2);
      return;
    case 5: 
      localObject1 = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
      paramIntent = new Intent(this, PhotoCropActivity.class);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      paramIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localObject1);
      localObject1 = AppConstants.as + this.app.a() + "/" + "nearby_people_photo/";
      paramIntent.putExtra("PhotoConst.TARGET_PATH", (String)localObject1 + System.currentTimeMillis() + ".jpg");
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      startActivity(paramIntent);
      return;
    case 1000: 
      label402:
      setResult(-1);
      finish();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903505);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_n_of_type_Int = ((getResources().getDisplayMetrics().widthPixels - (int)(12.0F * this.jdField_c_of_type_Float)) / 3);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(49));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "passed allinone is null!!");
      }
      finish();
      return true;
    }
    findViewById(2131296896).setVisibility(0);
    findViewById(2131296896).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296898));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296899));
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Ays = new ays(null);
    this.jdField_a_of_type_Ays.jdField_a_of_type_JavaLangString = "plus";
    this.jdField_a_of_type_Ays.b = "plus";
    this.jdField_a_of_type_Ays.c = "plus";
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Ays);
    this.jdField_s_of_type_Int = getIntent().getIntExtra("param_mode", 0);
    if (this.jdField_s_of_type_Int != 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    if (this.jdField_s_of_type_Int == 1)
    {
      j();
      findViewById(2131298252).setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131298251));
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      ((BounceScrollView)this.jdField_a_of_type_AndroidViewView).setNeedHorizontalGesture(true);
      if (NetworkUtil.e(BaseApplication.getContext())) {
        break label518;
      }
      QQToast.a(BaseApplicationImpl.a, 2131362916, 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      this.u = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      return true;
      this.jdField_a_of_type_Long = getIntent().getLongExtra("param_tiny_id", 0L);
      this.jdField_s_of_type_JavaLangString = getIntent().getStringExtra("param_dating_id");
      e();
      this.app.a(new awz(this));
      break;
      label518:
      a("正在加载...");
      if (this.jdField_s_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_Long > 0L) {
          NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, this.jdField_a_of_type_Long, null);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null) || (TextUtils.isEmpty(this.jdField_s_of_type_JavaLangString))) {
            break label621;
          }
          break;
          if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
            NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, 0L, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
      }
      else
      {
        label621:
        NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, 0L, this.app.a());
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = (NearbyPeoplePhotoUploadProcessor)this.app.a().a(null, 0L);
    if (localNearbyPeoplePhotoUploadProcessor != null) {
      localNearbyPeoplePhotoUploadProcessor.r();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_s_of_type_Int != 1);
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    int i1 = 0;
    while (i1 < paramIntent.size())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 13)
      {
        ays localays = new ays(null);
        localays.jdField_a_of_type_JavaLangString = ((String)paramIntent.get(i1));
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, localays);
      }
      i1 += 1;
    }
    this.jdField_b_of_type_Ayt.a();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DataTag))) {
      ReportController.b(this.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
    }
    int i1;
    do
    {
      do
      {
        return;
        if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
        {
          paramView = new Intent(this, EditActivity.class);
          paramView.putExtra("param_entry", 1);
          paramView.putExtra("param_old_xuan_yan", (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag());
          startActivityForResult(paramView, 1);
          return;
        }
        if (paramView != this.jdField_c_of_type_AndroidWidgetEditText) {
          break;
        }
        paramView = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
        localObject1 = (DispatchActionMoveScrollView)paramView.findViewById(2131296499);
        ((DispatchActionMoveScrollView)localObject1).jdField_a_of_type_Boolean = true;
        ((DispatchActionMoveScrollView)localObject1).setBackgroundResource(17170445);
        localObject1 = (IphonePickerView)getLayoutInflater().inflate(2130903492, null);
        ((IphonePickerView)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      } while (this.jdField_c_of_type_AndroidWidgetEditText.getTag() == null);
      i2 = (byte)(((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() - 1);
      if (i2 >= 0)
      {
        i1 = i2;
        if (i2 <= 3) {}
      }
      else
      {
        i1 = 0;
      }
      ((IphonePickerView)localObject1).setSelection(0, i1);
      ((IphonePickerView)localObject1).setPickListener(new aym(this, (IphonePickerView)localObject1, paramView));
      paramView.b((View)localObject1, null);
      paramView.show();
      return;
      if (paramView != this.jdField_d_of_type_AndroidWidgetEditText) {
        break;
      }
      paramView = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      localObject1 = (DispatchActionMoveScrollView)paramView.findViewById(2131296499);
      ((DispatchActionMoveScrollView)localObject1).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject1).setBackgroundResource(17170445);
      localObject1 = (IphonePickerView)getLayoutInflater().inflate(2130903492, null);
      ((IphonePickerView)localObject1).a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    } while (this.jdField_d_of_type_AndroidWidgetEditText.getTag() == null);
    int i2 = ((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue();
    if (i2 >= 0)
    {
      i1 = i2;
      if (i2 <= 1) {}
    }
    else
    {
      i1 = 0;
    }
    ((IphonePickerView)localObject1).setSelection(0, i1);
    ((IphonePickerView)localObject1).setPickListener(new ayn(this, (IphonePickerView)localObject1, paramView));
    paramView.b((View)localObject1, null);
    paramView.show();
    return;
    if ((paramView == this.jdField_e_of_type_AndroidWidgetEditText) || (paramView == this.jdField_f_of_type_AndroidWidgetEditText))
    {
      paramView = new Intent(this, AgeSelectionActivity.class);
      localObject1 = (Object[])this.jdField_e_of_type_AndroidWidgetEditText.getTag();
      if ((localObject1 != null) && (localObject1.length > 0)) {}
      for (i1 = ((Integer)localObject1[0]).intValue();; i1 = 0)
      {
        paramView.putExtra("param_birthday", i1);
        startActivityForResult(paramView, 2);
        return;
      }
    }
    if (paramView == this.jdField_g_of_type_AndroidWidgetEditText)
    {
      paramView = new Intent(this, JobSelectionActivity.class);
      if ((this.jdField_g_of_type_AndroidWidgetEditText != null) && (this.jdField_g_of_type_AndroidWidgetEditText.getTag() != null) && ((this.jdField_g_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
        paramView.putExtra("param_id", (Integer)this.jdField_g_of_type_AndroidWidgetEditText.getTag());
      }
      startActivityForResult(paramView, 3);
      return;
    }
    if (paramView == this.jdField_j_of_type_AndroidWidgetEditText)
    {
      d();
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      a("正在导入");
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(12);
      return;
    }
    if (paramView == this.jdField_f_of_type_AndroidWidgetLinearLayout)
    {
      H();
      ReportController.b(this.app, "CliOper", "", "", "0X8004826", "0X8004826", 0, 0, "", "", "", "");
      return;
    }
    if (paramView == this.jdField_g_of_type_AndroidWidgetLinearLayout)
    {
      G();
      ReportController.b(this.app, "CliOper", "", "", "0X8004827", "0X8004827", 0, 0, "", "", "", "");
      return;
    }
    if (paramView == this.jdField_h_of_type_AndroidWidgetLinearLayout)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      paramView = (View)localObject1;
      if (StringUtil.b((String)localObject1))
      {
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
        }
      }
      if (!StringUtil.b(paramView)) {
        break label1371;
      }
      paramView = "0";
    }
    label1371:
    for (;;)
    {
      long l1;
      if (this.jdField_a_of_type_Long == 0L) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          l1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId;
          if ((!"0".equals(paramView)) || (l1 != 0L)) {
            switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
            {
            }
          }
        }
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
        return;
        l1 = 0L;
        break;
        l1 = this.jdField_a_of_type_Long;
        break;
        ReportPlugin.a(this, 402, "", paramView, this.app.a(), String.valueOf(l1));
      }
      if (paramView != this.jdField_e_of_type_AndroidWidgetTextView) {
        break;
      }
      if (2 == this.jdField_s_of_type_Int)
      {
        paramView = new Intent(this, VisitorsActivity.class);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.app.a()).longValue());
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          ((Bundle)localObject1).putLong("totalVoters", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount);
        }
        for (;;)
        {
          ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
          ((Bundle)localObject1).putBoolean("votersOnly", true);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount == 0)) {
            ((Bundle)localObject1).putBoolean("hasVoters", false);
          }
          paramView.putExtras((Bundle)localObject1);
          startActivity(paramView);
          return;
          ((Bundle)localObject1).putLong("totalVoters", 0L);
        }
      }
      if ((3 != this.jdField_s_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted != 0)) {
        break;
      }
      localObject1 = new HashMap();
      Object localObject2 = this.app.a();
      paramView = (CardHandler)this.app.a(2);
      if ((paramView != null) && (NetworkUtil.e(BaseApplication.getContext()))) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
          ((NearbyPeopleCard)localObject2).likeCount += 1;
          this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
          paramView.b(Long.valueOf(this.app.a()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), (byte[])localObject1);
          A();
          ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        }
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004825", "0X8004825", 1, 0, "", "", "", "");
        return;
        if (paramView != null)
        {
          ((HashMap)localObject1).put("param_FailCode", "-203");
          StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
          QQToast.a(this, 2131363887, 0).b(getTitleBarHeight());
        }
        else
        {
          ((HashMap)localObject1).put("param_FailCode", "-204");
          StatisticCollector.a(this.app.a()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
          QQToast.a(this, 2131363891, 0).b(getTitleBarHeight());
        }
      }
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131298296));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298303));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298302));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298299));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298300));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298301));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298304));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131296532));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298305));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298306));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298100));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298101));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298307));
    this.jdField_g_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298308));
    this.jdField_h_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298309));
    this.jdField_i_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298310));
    this.jdField_j_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131298311));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298293));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298292));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298295));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298294));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_j_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new axn(this));
    this.jdField_h_of_type_AndroidWidgetEditText.addTextChangedListener(new aye(this));
    this.jdField_i_of_type_AndroidWidgetEditText.addTextChangedListener(new ayl(this));
    a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    g();
    this.jdField_b_of_type_Ayt = new ayt(this, 0, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_b_of_type_Ayt);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_s_of_type_Int == 1) {
      if (paramAdapterView == this.jdField_b_of_type_Ayt.jdField_a_of_type_AndroidWidgetGridView)
      {
        paramView = (ays)this.jdField_b_of_type_Ayt.jdField_a_of_type_Ayr.getItem(paramInt);
        if (paramView != null) {
          break label73;
        }
      }
    }
    for (;;)
    {
      return;
      if (paramAdapterView == this.jdField_b_of_type_Ayt.jdField_b_of_type_AndroidWidgetGridView)
      {
        paramView = (ays)this.jdField_b_of_type_Ayt.jdField_b_of_type_Ayr.getItem(paramInt);
        break;
      }
      paramView = null;
      break;
      label73:
      if (paramView == this.jdField_a_of_type_Ays)
      {
        i();
        return;
      }
      ActionSheet localActionSheet = ActionSheet.a(this, 2131624119);
      if ((paramAdapterView != this.jdField_b_of_type_Ayt.jdField_a_of_type_AndroidWidgetGridView) || (paramInt != 0))
      {
        localActionSheet.c("设为头像");
        localActionSheet.a(new ayd(this, paramAdapterView, paramInt, paramView, localActionSheet));
      }
      for (;;)
      {
        localActionSheet.c("删除照片");
        localActionSheet.d(2131362794);
        localActionSheet.show();
        return;
        localActionSheet.a(new ayf(this, paramView, localActionSheet));
      }
      if (paramAdapterView == this.jdField_a_of_type_Ayt.jdField_a_of_type_AndroidWidgetGridView) {
        paramAdapterView = (ays)this.jdField_a_of_type_Ayt.jdField_a_of_type_Ayr.getItem(paramInt);
      }
      while (paramAdapterView != null)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800482A", "0X800482A", 0, 0, "", "", "", "");
        return;
        if (paramAdapterView == this.jdField_a_of_type_Ayt.jdField_b_of_type_AndroidWidgetGridView) {
          paramAdapterView = (ays)this.jdField_a_of_type_Ayt.jdField_b_of_type_Ayr.getItem(paramInt);
        } else {
          paramAdapterView = null;
        }
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Ayt.getCount() == 1) {
        this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(4);
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ayt.getCount() != 2);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131298260);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRadioGroup.check(2131298261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */