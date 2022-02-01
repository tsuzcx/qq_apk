import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.12;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.13;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.25;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.33;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.34;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.35;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.nearby.profilecard.NestScrollLayout;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.a;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.NestViewPager;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.GridView;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowAnchorState;

public class akcx
  extends akcw
  implements akho, View.OnClickListener, aqdf.a, TabBarView.a, ScrollView.b
{
  public static String[] fH = { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
  public static String[] fI = { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  private ImageView BA;
  protected ImageView BB;
  private ImageView Bw;
  private ImageView Bx;
  private ImageView By;
  private ImageView Bz;
  private List<PicInfo> DM;
  private View Fh;
  private View Fi;
  private View Fj;
  DialogInterface.OnClickListener R = new akdw(this);
  private TextView VA;
  private TextView VB;
  private TextView Vv;
  private TextView Vw;
  private TextView Vx;
  private TextView Vy;
  private TextView Vz;
  private akcx.c jdField_a_of_type_Akcx$c;
  akhp jdField_a_of_type_Akhp = null;
  akkq.b jdField_a_of_type_Akkq$b = new akdt(this);
  protected alck a;
  private aqdf jdField_a_of_type_Aqdf;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  protected NearbyProfileFragment a;
  private NestScrollLayout jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout;
  protected NearbyMomentFragment a;
  private AutoScrollImageView jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  protected NestViewPager a;
  private Animation aL;
  private Animation aM;
  AtomicInteger ay = new AtomicInteger(0);
  private afcy jdField_b_of_type_Afcy;
  private HeartLayout jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private NearbyCardVoteView jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  protected TabBarView b;
  AtomicInteger bA = new AtomicInteger(0);
  AtomicInteger bB = new AtomicInteger(0);
  int bIC = -1;
  String bTe = "";
  String bTf = "";
  String bTg = "";
  String bTh = "";
  protected String bTi;
  int bwF = 0;
  private Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new akea(this);
  private CustomImgView jdField_c_of_type_ComTencentWidgetCustomImgView;
  protected ArrayList<Fragment> cg;
  public boolean crO;
  public boolean crP;
  public boolean crQ;
  public boolean crR;
  public boolean crS;
  public boolean crT;
  public boolean crU;
  public boolean crV;
  public boolean crW;
  public boolean crX;
  boolean crY = true;
  boolean crZ = true;
  boolean csa = false;
  boolean csb = false;
  private boolean csc;
  boolean csd = false;
  boolean cse = false;
  boolean csf = false;
  private boolean csg;
  boolean csh = false;
  protected boolean csi = true;
  Handler.Callback jdField_d_of_type_AndroidOsHandler$Callback = new akcy(this);
  ProgressButton jdField_d_of_type_ComTencentMobileqqWidgetProgressButton;
  Handler dh = new akdv(this);
  private int dmF;
  int dmG;
  int dmH;
  int dmI = 0;
  int dmJ = 0;
  private byte[] eT;
  auru f;
  private View.OnClickListener fv = new akdu(this);
  private LinearLayout jv;
  private LinearLayout jw;
  protected LinearLayout jx;
  private RelativeLayout le;
  private aryx mDownloadListener = new akdx(this);
  protected FragmentManager mFragmentManager;
  ViewPager.OnPageChangeListener mOnPageChangeListener = new akeb(this);
  protected final Map<String, View> me = new HashMap();
  private View qi;
  private TextView tM;
  
  public akcx(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.f = new auru(ThreadManager.getSubThreadLooper(), this.jdField_d_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.csb = bool;
      this.csa = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      this.csg = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_now_plugin", false);
      this.jdField_a_of_type_Aqdf = new aqdf(paramNearbyPeopleProfileActivity.app);
      this.jdField_a_of_type_Aqdf.a(this);
      dAN();
      return;
      bool = false;
    }
  }
  
  private void Nk(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView != null))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 640;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 640;
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramString.getStatus() != 1) {
        break label113;
      }
      localObject = paramString.getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.12(this, paramString), 128, null, true);
      return;
      label113:
      paramString.setURLDrawableListener(new akda(this));
    }
  }
  
  private void Nl(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private void RM(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("operation", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("nearby.qq.com");
      aija.a("nearbyYanzhiCallback", localJSONObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyProfileDisplayPanel", 2, localJSONException.toString());
    }
  }
  
  private void Y(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(0);
    }
  }
  
  private TextView a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int i = aqcx.dip2px(this.mContext, 5.0F);
    int j = aqcx.dip2px(this.mContext, 14.0F);
    int k = aqcx.dip2px(this.mContext, 2.0F);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setTextSize(1, 10.0F);
    Object localObject = new LinearLayout.LayoutParams(-2, j);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, aqcx.dip2px(this.mContext, 2.0F), 0);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(paramInt1);
    ((GradientDrawable)localObject).setCornerRadius(k);
    localTextView.setBackgroundDrawable((Drawable)localObject);
    localTextView.setTextColor(Color.parseColor("#FFFFFFFF"));
    localTextView.setText(paramString);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setGravity(17);
    if (paramInt2 > 0)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(paramInt2), null, null, null);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView.setCompoundDrawablePadding(paramInt3);
      }
    }
    return localTextView;
  }
  
  private GridView a(List<PicInfo> paramList, int paramInt)
  {
    GridView localGridView = new GridView(this.mContext);
    paramList = new akcx.a(paramList, paramInt);
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    paramInt = wja.dp2px(1.0F, localResources);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth = ((localResources.getDisplayMetrics().widthPixels - paramInt * 2) / 3);
    localGridView.setNumColumns(3);
    localGridView.setStretchMode(2);
    localGridView.setSelector(new ColorDrawable(0));
    localGridView.setHorizontalSpacing(paramInt);
    localGridView.setVerticalSpacing(paramInt);
    localGridView.setAdapter(paramList);
    return localGridView;
  }
  
  private byte[] aj()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dms != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().T(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dms == 51) {
        localObject2 = this.eT;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private TextView b(int paramInt, String paramString)
  {
    return a(paramInt, paramString, -1, 0);
  }
  
  private void dAN()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mRequestWidth = ((int)aqgz.getWidth());
    localURLDrawableOptions.mRequestHeight = (localURLDrawableOptions.mRequestWidth / 2);
    URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", localURLDrawableOptions);
  }
  
  private void dAP()
  {
    this.jx.removeAllViews();
    int i = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender;
    Object localObject2;
    if ((i == 0) || (i == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0))
    {
      localObject2 = this.jx;
      if (i == 1)
      {
        localObject1 = "#ffffafea";
        int j = Color.parseColor((String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 0) {
          break label565;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + acfp.m(2131708874);
        label94:
        ((LinearLayout)localObject2).addView(a(j, (String)localObject1, aqek.jU(i), rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F)));
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
        break label571;
      }
      localObject1 = "1";
      label143:
      anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation >= 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation <= 12))
      {
        this.jx.addView(b(Color.parseColor("#ffbfa4f6"), aqek.fY(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label578;
        }
        localObject1 = "1";
        label245:
        anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus >= 2) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus <= 5))
      {
        this.jx.addView(b(Color.parseColor("#ff89e1b5"), aqek.fW(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label585;
        }
      }
    }
    label565:
    label571:
    label578:
    label585:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.is_authen.get() == 1))
      {
        localObject1 = a(Color.parseColor("#000000"), acfp.m(2131708837), 2130846346, rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { Color.parseColor("#ffa98df7"), Color.parseColor("#ff8aafff") });
        ((GradientDrawable)localObject2).setCornerRadius(aqcx.dip2px(this.mContext, 2.0F));
        ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
        ((TextView)localObject1).setOnClickListener(new akdc(this));
        this.jx.addView((View)localObject1);
        new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("cike_icon_exp").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).report();
      }
      return;
      localObject1 = "#ff96beff";
      break;
      localObject1 = "";
      break label94;
      localObject1 = "2";
      break label143;
      localObject1 = "2";
      break label245;
    }
  }
  
  private void dAQ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.Bw.setVisibility(8);
      this.Vv.setVisibility(0);
      this.Vv.setOnClickListener(this);
      return;
    }
    this.Bw.setVisibility(0);
    this.Vv.setVisibility(8);
    this.Bw.setOnClickListener(new akdd(this));
  }
  
  private void dAR()
  {
    if (this.jdField_a_of_type_Alck != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_Alck);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c.ad(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
  }
  
  private void dAS()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    aqfy.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void dAT()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
        break label253;
      }
      if (this.ay.get() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c.b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.ay.get(), 0);
        bool = ((ajqh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).ct(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
        if (PraiseManager.f(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app) <= 0) {
          break label239;
        }
        if (!bool) {
          break label234;
        }
        i = 3;
        anot.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.ay.get(), i, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), String.valueOf(this.ay.get()), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.ay.set(0);
      }
    }
    label234:
    label239:
    label253:
    while ((this.bA.get() == 0) && (this.bB.get() == 0)) {
      for (;;)
      {
        boolean bool;
        return;
        i = 2;
        continue;
        if (bool) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    ajqh.a locala = new ajqh.a();
    locala.dkt = this.bA.get();
    locala.dku = this.bB.get();
    locala.uin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
    locala.source = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource;
    localArrayList.add(locala);
    if (NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {}
    for (int i = 510;; i = 509)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c.D(localArrayList, i);
      this.bA.set(0);
      this.bB.set(0);
      return;
    }
  }
  
  private void fr(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmu == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bTc)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.cry))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().xx();
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131701035);
      }
      acqn.e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", NearbyPeopleProfileActivity.class.getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    ((Intent)localObject).putExtra("NEARBY_MSG_REPORT_SOURCE", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getStringExtra("NEARBY_MSG_REPORT_SOURCE"));
    ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJc != 0) {
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJc);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.nickname);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      return;
      if (paramInt == 1010)
      {
        ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf);
        ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      }
    }
  }
  
  private int getReportType()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getIntExtra("frome_where", 6);
    int i;
    if (j > 0)
    {
      i = j;
      if (j < 6) {}
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa;
      if (i != 5) {
        break label48;
      }
      i = 1;
    }
    return i;
    label48:
    if (ProfileActivity.gg(i)) {
      return 3;
    }
    if (((i >= 10) && (i <= 19)) || (i == 30)) {
      return 2;
    }
    return 6;
  }
  
  private int getSessionType()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return 1001;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
      return 0;
    }
    return aqep.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e);
  }
  
  private String getUin()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    }
    return str;
  }
  
  private void iW(int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramInt2)
    {
    default: 
      if (i == 0) {
        this.jv.setVisibility(8);
      }
      break;
    }
    label135:
    Object localObject2;
    Object localObject1;
    label190:
    do
    {
      return;
      i = 2131701558;
      break;
      i = 2131701020;
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.csc)
      {
        i = 2131698600;
        localObject2 = getUin();
        if (!this.csc) {
          break label190;
        }
      }
      for (localObject1 = "exp_followed";; localObject1 = "exp_follow")
      {
        anot.a(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
        break;
        i = 2131698598;
        break label135;
      }
      i = 2131719495;
      localObject1 = (Button)this.jv.getChildAt(paramInt1).findViewById(2131381048);
      ((Button)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167335));
      ((Button)localObject1).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846434));
      anot.a(null, "dc00899", "grp_lbs", getUin(), "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      i = 2131694846;
      break;
      i = 2131696257;
      break;
      i = 2131701078;
      break;
      localObject1 = this.jv.getChildAt(paramInt1);
      ((View)localObject1).setVisibility(0);
      if (paramInt2 == 40) {
        break label551;
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131381048);
      ((Button)localObject2).setText(i);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130851044);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165735));
      }
      ((Button)localObject2).setOnClickListener(this);
      albb localalbb = new albb(paramInt2, null);
      ((Button)localObject2).setTag(localalbb);
      ((View)localObject1).setTag(localalbb);
      if ((paramInt2 == 60) && (this.csc))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167337));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839564));
        return;
      }
      if ((paramInt2 == 8) && (this.dmI != 0) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130851044);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.cse) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend));
    ((Button)localObject2).setBackgroundResource(2130851044);
    ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label551:
    ((View)localObject1).setVisibility(8);
  }
  
  public int GN()
  {
    int i4 = 1;
    int i5 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.GN();
    int i;
    int j;
    label30:
    int k;
    label39:
    int m;
    label49:
    int n;
    label59:
    int i1;
    label69:
    int i2;
    label79:
    int i3;
    if (this.crX)
    {
      i = 1;
      if (!this.crW) {
        break label150;
      }
      j = 1;
      if (!this.crV) {
        break label155;
      }
      k = 1;
      if (!this.crU) {
        break label160;
      }
      m = 1;
      if (!this.crT) {
        break label166;
      }
      n = 1;
      if (!this.crS) {
        break label172;
      }
      i1 = 1;
      if (!this.crR) {
        break label178;
      }
      i2 = 1;
      if (!this.crQ) {
        break label184;
      }
      i3 = 1;
      label89:
      if (!this.crO) {
        break label190;
      }
    }
    for (;;)
    {
      return i3 << 2 | i5 | i << 10 | j << 9 | k << 8 | m << 6 | n << 5 | i1 << 4 | i2 << 3 | i4 << 0;
      i = 0;
      break;
      label150:
      j = 0;
      break label30;
      label155:
      k = 0;
      break label39;
      label160:
      m = 0;
      break label49;
      label166:
      n = 0;
      break label59;
      label172:
      i1 = 0;
      break label69;
      label178:
      i2 = 0;
      break label79;
      label184:
      i3 = 0;
      break label89;
      label190:
      i4 = 0;
    }
  }
  
  public void ML(boolean paramBoolean) {}
  
  void MM(boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()))
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label168;
        }
        bool2 = true;
        label59:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
        if (QSecFramework.a().c(1001).booleanValue())
        {
          localNearbyCardVoteView = this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
          QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(41), localNearbyCardVoteView }, null);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Afcy != null) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.crr = false;
      }
      return;
      bool1 = false;
      break;
      label168:
      bool2 = false;
      break label59;
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
  }
  
  public void MN(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
      this.ay.incrementAndGet();
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).likeCount += 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject).bAvailVoteCnt - 1));
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
      if (!this.f.hasMessages(1))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        this.f.sendMessageDelayed((Message)localObject, 2000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aWs = true;
      MM(paramBoolean);
      if (QSecFramework.a().c(1001).booleanValue()) {
        QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
      }
      return;
      if (paramBoolean) {
        this.bA.incrementAndGet();
      } else {
        this.bB.incrementAndGet();
      }
    }
  }
  
  protected void MO(boolean paramBoolean)
  {
    if ((this.cse) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
    {
      if (!TextUtils.isEmpty(this.bTf)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.bTf, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.crP = true;
    NearbyPeopleProfileActivity.dmy += 1;
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin;
    Object localObject2 = aqft.bytesToHexString(aj());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i;
    if (Friends.isValidUin(str))
    {
      localObject2 = ajri.encode(str);
      str = ((String)localObject1).toLowerCase();
      if (getSessionType() == 10002)
      {
        i = 6;
        if (!paramBoolean) {
          break label317;
        }
        localObject1 = "near.card.like";
        label138:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        i = aqek.jW(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa);
        if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
          break label342;
        }
        i = 6;
      }
    }
    label317:
    label342:
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i, 0, "", "", "", "");
      return;
      i = 1;
      break;
      localObject1 = "near.card.s";
      break label138;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695115));
      return;
    }
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayPanel", 2, "getAvatarWallItemView, position = " + paramInt + ", info = " + paramPicInfo.toString());
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.addView(localCustomImgView, new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth));
    Object localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject1).setBackgroundResource(2130842138);
    ((ImageView)localObject1).setImageResource(2130846748);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int i = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845956));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.fv);
    if (AppSetting.enableTalkBack) {
      localRelativeLayout.setContentDescription(acfp.m(2131708798) + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846612);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crG) || (TextUtils.isEmpty(paramPicInfo.videoUrl))) {
        break label524;
      }
      this.me.put(paramPicInfo.videoUrl, localRelativeLayout);
      if (advm.lj(paramPicInfo.videoUrl))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!aqiw.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label511;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.Nj(paramPicInfo.videoUrl);
      localRelativeLayout.getChildAt(1).setVisibility(0);
    }
    catch (MalformedURLException paramPicInfo)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.", 2, "PicGallery.getView() new URL(). " + paramPicInfo.getMessage(), paramPicInfo);
        return localRelativeLayout;
        label511:
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        label524:
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (aqmr.isEmpty(paramPicInfo.bSZ)) {
        break label632;
      }
      paramPicInfo = aomc.l(paramPicInfo.bSZ);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject2);
      paramPicInfo.setDownloadListener(new ajpe(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
      localCustomImgView.setImageDrawable(paramPicInfo);
      return localRelativeLayout;
      label632:
      if (paramPicInfo.bTa != "type_qq_head_pic") {
        break label660;
      }
      localCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840646));
    }
    if ((paramPicInfo.localPath != null) && (paramPicInfo.localPath.length() > 0))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.localPath).toURL(), (URLDrawable.URLDrawableOptions)localObject2));
      return localRelativeLayout;
    }
    label660:
    return localRelativeLayout;
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1))
    {
      if (ajrk.isColorLevel()) {
        ajrk.m("NearbyProfileDisplayPanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
      }
      return;
    }
    QQAppInterface localQQAppInterface;
    if (paramInterestTagInfo.bid != 0L)
    {
      paramView = "https://buluo.qq.com/mobile/barindex.html?bid=" + paramInterestTagInfo.bid + "&_wv=1027";
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (paramInterestTagInfo.bid == 0L) {
        break label310;
      }
      paramView = "tag_same";
      label162:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
        break label317;
      }
      paramInterestTagInfo = "1";
      label177:
      if (paramInt > 4) {
        break label324;
      }
    }
    label310:
    label317:
    label324:
    for (Object localObject = paramInt + 3 + "";; localObject = paramInt - 4 + "")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", (String)localObject, "");
      ThreadManager.post(new NearbyProfileDisplayPanel.33(this, paramInt), 5, null, false);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://buluo.qq.com/mobile/search_result.html?_bid=128&_wv=1027&search_keyword=" + paramInterestTagInfo.tagName + "&from=nearby_tag");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
      break;
      paramView = "clk_tag";
      break label162;
      paramInterestTagInfo = "2";
      break label177;
    }
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130851773);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    if (!TextUtils.isEmpty(paramPicInfo.bSZ)) {
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.bSZ, localURLDrawableOptions));
    }
    paramRelativeLayout.setVisibility(0);
  }
  
  public void a(ScrollView paramScrollView, int paramInt, boolean paramBoolean) {}
  
  protected void aH(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", jpa.r(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.getAppId() + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + ajri.encode(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.nickname + "&bn=" + paramBoolean));
      paramString.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  public void aK(String paramString1, String paramString2, String paramString3)
  {
    if (!aqiw.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131693404, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, acfp.m(2131708870), 0).show();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramString2);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    aglz.a().a(paramString1, localBundle, new akdy(this, paramString3));
  }
  
  public boolean arI()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Afcy != null) {
      bool = this.jdField_b_of_type_Afcy.bXr;
    }
    return bool;
  }
  
  boolean arJ()
  {
    return (aqft.equalsWithNullCheck(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.aOF, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bIX != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bIX != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bIX != 2);
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    label1048:
    label1065:
    label1344:
    label1368:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3))
      {
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode = 2;
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
          this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        }
        paramNearbyPeopleCard = aqmj.bt(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (TextUtils.isEmpty(paramNearbyPeopleCard)) {}
      }
      label1123:
      label1135:
      label1392:
      try
      {
        this.bTh = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
        if (!this.csh) {
          this.csh = true;
        }
        dAO();
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          paramNearbyPeopleCard = "1";
          anot.a((QQAppInterface)localObject, "dc00899", "grp_lbs", str, "data_card", "exp", 0, 0, paramNearbyPeopleCard, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from % 20, "", "");
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.getAdapter() == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setAdapter(new akcx.d(this.mFragmentManager, this.cg));
            i = -1;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
              break label1023;
            }
            i = aehy.H(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            if (i != 0) {
              break label1048;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(1, false);
            if (i == -1) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
            }
          }
          if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
            break label1065;
          }
          this.csd = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
          this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
          this.bTe = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
          this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
          this.dmJ = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
          bl(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          dAQ();
          dAP();
          dAJ();
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
            break label1123;
          }
          this.Bx.setVisibility(0);
          this.Bx.setImageResource(2130842145);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
            break label1148;
          }
          this.BA.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            break label1135;
          }
          this.BA.setImageResource(2130846803);
          ThreadManager.post(new NearbyProfileDisplayPanel.13(this), 8, null, true);
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.aOK)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)) {
            break label1160;
          }
          this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.aOK + " · " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + acfp.m(2131708824));
          this.Vz.setVisibility(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileDisplayPanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
            break label1368;
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
            break label1344;
          }
          paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
          ((TextView)this.jw.findViewById(2131381166)).setText(paramNearbyPeopleCard);
          dAR();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
            break label1416;
          }
          if (!this.csb) {
            break label1392;
          }
          this.jv.setVisibility(8);
          this.Fi.setVisibility(0);
          new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin).report();
          dAL();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
          {
            if (this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.qt() != 0) {
              break label1437;
            }
            this.BB.setVisibility(8);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.qt() != 1) {
            continue;
          }
          localObject = new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
            break label1534;
          }
          paramNearbyPeopleCard = "1";
          ((anov)localObject).a(new String[] { paramNearbyPeopleCard }).report();
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode = 3;
        }
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        label1148:
        label1534:
        for (;;)
        {
          Object localObject;
          int i;
          paramNearbyPeopleCard.printStackTrace();
          continue;
          paramNearbyPeopleCard = "2";
          continue;
          label1023:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
          {
            i = aehy.I(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            continue;
            if (i == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
              continue;
              this.dmI = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maskMsgFlag;
              this.csd = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
              this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
              this.bTe = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
              this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
              continue;
              this.Bx.setVisibility(8);
              continue;
              this.BA.setImageResource(2130846802);
              continue;
              this.BA.setVisibility(8);
              continue;
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
              {
                this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime + acfp.m(2131708808));
                this.Vz.setVisibility(0);
              }
              else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)))
              {
                this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + acfp.m(2131708923));
                this.Vz.setVisibility(0);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                {
                  paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                  continue;
                  if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                  {
                    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                    continue;
                    this.jv.setVisibility(0);
                    this.Fi.setVisibility(8);
                    dAK();
                    continue;
                    this.jv.setVisibility(8);
                    this.Fi.setVisibility(8);
                    continue;
                    this.BB.setVisibility(0);
                    localObject = new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
                    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
                    for (paramNearbyPeopleCard = "1";; paramNearbyPeopleCard = "2")
                    {
                      ((anov)localObject).a(new String[] { paramNearbyPeopleCard }).report();
                      break;
                    }
                    paramNearbyPeopleCard = "2";
                    continue;
                  }
                }
                paramNearbyPeopleCard = "";
              }
            }
          }
        }
      }
    }
  }
  
  public void bOF()
  {
    aqfp.Sz(true);
    int i = getSessionType();
    if (arJ())
    {
      localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      Intent localIntent;
      return;
    }
    fr(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i);
  }
  
  public void bl(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new nearby.Cmd0x1RspBody();
    for (;;)
    {
      try
      {
        ((nearby.Cmd0x1RspBody)localObject).mergeFrom(paramArrayOfByte);
        this.bTg = ((nearby.Cmd0x1RspBody)localObject).bytes_qunlist_url.get().toStringUtf8();
        this.eT = ((nearby.Cmd0x1RspBody)localObject).bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().t(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.eT);
        this.csc = ((nearby.Cmd0x1RspBody)localObject).bool_follow.get();
        this.dmI = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get();
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get() != 1) {
          break label454;
        }
        bool1 = true;
        this.csd = bool1;
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get() != 1) {
          break label460;
        }
        bool1 = bool2;
        this.cse = bool1;
        if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.has()) {
          this.bTe = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.get().toStringUtf8();
        }
        if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.has()) {
          this.bTf = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.get().toStringUtf8();
        }
        localObject = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject).FansInfo_fans.get();
        int i = ((nearby.FansInfo)localObject).uint32_follows_num.get();
        int j = ((nearby.FansInfo)localObject).uint32_fans_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject).bytes_follows_url.get().toStringUtf8();
        localObject = ((nearby.FansInfo)localObject).bytes_fans_url.get().toStringUtf8();
        this.Fh.findViewById(2131367388).setVisibility(0);
        this.VA.setText(acfp.m(2131708895) + i);
        this.VB.setText(acfp.m(2131708825) + j);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProfileDisplayPanel", 2, "getNearByInfo, followsNum=" + i + ", fansNum=" + j);
        }
        if (!TextUtils.isEmpty(paramArrayOfByte)) {
          this.VA.setOnClickListener(new akec(this, paramArrayOfByte));
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        this.VB.setOnClickListener(new aked(this, (String)localObject));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NearbyProfileDisplayPanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
      return;
      label454:
      boolean bool1 = false;
      continue;
      label460:
      bool1 = false;
    }
  }
  
  public void c(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  public void cB(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish, url = " + paramString + ", isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramString = (View)this.me.get(paramString);
      if (paramString != null)
      {
        if (!(paramString instanceof RelativeLayout)) {
          break label129;
        }
        paramString = (RelativeLayout)paramString;
        locala = (AvatarWallPagerAdapter.a)paramString.getTag(2131379193);
        if ((locala == null) || (locala.data == null)) {
          break label112;
        }
        a((PicInfo)locala.data, paramString);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      AvatarWallPagerAdapter.a locala;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
      return;
    }
    label129:
    QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
  }
  
  protected void cG(View paramView)
  {
    this.Fh = paramView;
    this.VA = ((TextView)this.Fh.findViewById(2131380718));
    this.VB = ((TextView)this.Fh.findViewById(2131380691));
    this.Vz = ((TextView)this.Fh.findViewById(2131381138));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.dmG = paramView.getDimensionPixelSize(2131297795);
    this.dmH = paramView.getDimensionPixelSize(2131297794);
    this.Bx = ((ImageView)this.Fh.findViewById(2131369091));
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.Fh.findViewById(2131382077));
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setIsTribe(false);
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.Fh.findViewById(2131368498));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout = ((NestScrollLayout)this.Fh.findViewById(2131363709));
    this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    this.qi = this.Fh.findViewById(2131377496);
    this.tM = ((TextView)this.Fh.findViewById(2131369579));
    this.Bw = ((ImageView)this.Fh.findViewById(2131369603));
    this.Vv = ((TextView)this.Fh.findViewById(2131369635));
    this.jv = ((LinearLayout)this.Fh.findViewById(2131363644));
    this.Fi = this.Fh.findViewById(2131363706);
    paramView = (ImageView)this.Fi.findViewById(2131372478);
    ImageView localImageView1 = (ImageView)this.Fi.findViewById(2131381565);
    ImageView localImageView2 = (ImageView)this.Fi.findViewById(2131370437);
    akdh localakdh = new akdh(this, paramView, localImageView1, localImageView2);
    paramView.setOnClickListener(localakdh);
    localImageView1.setOnClickListener(localakdh);
    localImageView2.setOnClickListener(localakdh);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130846473);
      localImageView1.setImageResource(2130846475);
      localImageView2.setImageResource(2130846471);
      this.Fi.setBackgroundColor(0);
    }
    this.BB = ((ImageView)this.Fh.findViewById(2131373817));
    this.BB.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.Fh.findViewById(2131363210));
    this.le = ((RelativeLayout)this.Fh.findViewById(2131377499));
    this.Vw = ((TextView)this.Fh.findViewById(2131372555));
    this.Fj = this.Fh.findViewById(2131372553);
    this.By = ((ImageView)this.Fh.findViewById(2131372552));
    this.Vx = ((TextView)this.Fh.findViewById(2131372558));
    this.Vy = ((TextView)this.Fh.findViewById(2131372557));
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView = ((AutoScrollImageView)this.Fh.findViewById(2131372556));
    this.Bz = ((ImageView)this.Fh.findViewById(2131372551));
    this.jw = ((LinearLayout)this.Fh.findViewById(2131370757));
    this.BA = ((ImageView)this.Fh.findViewById(2131369102));
    this.Fh.findViewById(2131380039).setBackgroundResource(2130846429);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setVerticalScrollBarEnabled(false);
    this.aL = new AlphaAnimation(0.0F, 1.0F);
    this.aL.setDuration(300L);
    this.aL.setAnimationListener(this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.aL.setInterpolator(new AccelerateInterpolator());
    this.aM = new AlphaAnimation(1.0F, 0.0F);
    this.aM.setDuration(300L);
    this.aM.setAnimationListener(this.jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.aM.setInterpolator(new AccelerateInterpolator());
    this.tM.setVisibility(0);
    this.tM.setText(2131690700);
    this.tM.setOnClickListener(new akdr(this));
    this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager = ((NestViewPager)this.Fh.findViewById(2131381929));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.mFragmentManager = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSupportFragmentManager();
    this.cg = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment = new NearbyProfileFragment();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.c(this);
    this.cg.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment = new NearbyMomentFragment();
    this.cg.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.Fh.findViewById(2131379139));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130852004));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#0dc4fd"));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectBgRes(2130846464);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setUnSelectBgRes(2130846465);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0.0F));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineMargin(aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 44.0F));
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 45.0F));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager);
    paramView = new LinearLayout.LayoutParams(0, -1);
    paramView.gravity = 17;
    paramView.weight = 1.0F;
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams(paramView);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(0, acfp.m(2131708793), true, true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.a(1, acfp.m(2131708851), true, true);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      i = aehy.H(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
      }
      for (;;)
      {
        if (i == -1) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(new akdz(this, i));
        this.jx = ((LinearLayout)this.Fh.findViewById(2131379200));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
          break label1241;
        }
        i = aehy.I(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
        break;
        if (i == 1) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
        }
      }
      label1241:
      i = -1;
    }
  }
  
  public void dAH()
  {
    aryr.c(this.mDownloadListener);
  }
  
  public void dAI()
  {
    if (this.jdField_a_of_type_Akhp != null) {
      this.jdField_a_of_type_Akhp.RP(10);
    }
    aryr.d(this.mDownloadListener);
    this.dh.removeMessages(1);
    this.dh.removeMessages(2);
    this.dh.removeMessages(3);
    this.dh.removeMessages(4);
    this.dh.removeMessages(5);
    this.dh.removeMessages(6);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L)) {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
    }
  }
  
  public void dAJ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.csb))
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      if (QSecFramework.a().c(1001).booleanValue())
      {
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(41), localNearbyCardVoteView }, null);
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Afcy != null) {
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.crr = false;
      }
      return;
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
  }
  
  public void dAK()
  {
    afck.n(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag), " sayhello flag is ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag) });
    Button localButton;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L)
    {
      this.jv.getChildAt(0).setVisibility(8);
      this.jv.getChildAt(1).setVisibility(8);
      if (!this.csa)
      {
        iW(2, 8);
        if ((this.csc) || (this.jv.getChildAt(2).getVisibility() == 0)) {
          break label391;
        }
        localButton = (Button)this.jv.getChildAt(1).findViewById(2131381048);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167335));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846434));
      }
    }
    for (;;)
    {
      if ((this.jv.getChildAt(1).getVisibility() != 0) && (this.jv.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jv.getChildAt(0).findViewById(2131381048);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167335));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846434));
      }
      return;
      this.jv.setVisibility(8);
      break;
      this.jv.getChildAt(0).setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf == null) && (!arJ())) {
        this.jv.getChildAt(2).setVisibility(8);
      }
      for (;;)
      {
        iW(1, 60);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.csa)) {
          iW(2, 8);
        } else {
          this.jv.getChildAt(2).setVisibility(8);
        }
      }
      label391:
      ((Button)this.jv.getChildAt(1).findViewById(2131381048)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846435));
    }
  }
  
  public void dAL()
  {
    this.DM = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz) {
      this.DM = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.size() > 0)) {
        Nk(((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.get(0)).bSZ);
      }
      localObject1 = new akcx.b(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter((AvatarWallPagerAdapter)localObject1);
      localObject2 = new ArrayList();
      this.dmF = ((int)Math.ceil(this.DM.size() / 6.0F));
      int i = 0;
      while (i < this.dmF)
      {
        ((List)localObject2).add(a(this.DM, i));
        i += 1;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
      {
        localObject1 = new PicInfo();
        ((PicInfo)localObject1).videoUrl = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
        this.DM.add(localObject1);
      }
      else
      {
        localObject1 = new PicInfo();
        ((PicInfo)localObject1).bTa = "type_qq_head_pic";
        this.DM.add(localObject1);
      }
    }
    ((akcx.b)localObject1).lG((List)localObject2);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      localObject1 = "2";
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject1, "", "", "");
      localObject1 = (RelativeLayout)this.Fh.findViewById(2131377428);
      localObject2 = (LinearLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.getLayoutParams();
      if (localObject2 != null)
      {
        if (this.DM.size() <= 3) {
          break label454;
        }
        ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);
      }
    }
    for (localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);; localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3))
    {
      ((LinearLayout.LayoutParams)localObject2).topMargin = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299627) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity));
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 4.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams((RelativeLayout.LayoutParams)localObject1);
      return;
      localObject1 = "1";
      break;
      label454:
      ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3);
    }
  }
  
  public void dAM()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bTd)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bTd, false);
    }
  }
  
  public void dAO()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData == null)
    {
      this.Fj.setVisibility(8);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "now anchor, jumpUrl=" + (String)localObject2);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_level.get();
    int j;
    if (i > 0)
    {
      this.Fj.setVisibility(0);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      String str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
      {
        localObject1 = "1";
        anot.a((QQAppInterface)localObject3, "dc00899", "grp_lbs", str, "status_bar", "bar_exp", 0, 0, (String)localObject1, "", "", "");
        localObject1 = acfp.m(2131708905);
        j = ((String)localObject1).length();
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() != 1) {
          break label499;
        }
        localObject3 = i + "";
        localObject1 = new SpannableString((String)localObject1 + (String)localObject3 + acfp.m(2131708921));
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-4352), j, ((String)localObject3).length() + j, 33);
        this.Vw.setText((CharSequence)localObject1);
        this.Vw.setTextColor(-1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setRadius(rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
        this.Bz.setImageResource(2130846438);
        this.Vx.setVisibility(8);
        this.Vy.setVisibility(0);
        this.By.setImageResource(2130846427);
        this.Fj.setOnClickListener(new akee(this, (String)localObject2));
        localObject2 = new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("live_exp").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label474;
        }
        localObject1 = "1";
      }
    }
    for (;;)
    {
      ((anov)localObject2).a(new String[] { localObject1 }).report();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
      {
        localObject1 = "2";
        break;
      }
      localObject1 = "0";
      break;
      this.Fj.setVisibility(8);
      return;
      label474:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
    }
    label499:
    Object localObject3 = i + "";
    Object localObject1 = new SpannableString((String)localObject1 + (String)localObject3 + acfp.m(2131708857));
    ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), j, ((String)localObject3).length() + j, 33);
    this.Vw.setTextColor(-16777216);
    this.Vw.setText((CharSequence)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(8);
    this.Bz.setImageResource(2130846428);
    this.Vx.setVisibility(0);
    this.Vy.setVisibility(8);
    this.By.setImageResource(2130846445);
    this.Fj.setOnClickListener(new akcz(this, (String)localObject2));
    localObject2 = new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_exp").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
      localObject1 = "1";
    }
    for (;;)
    {
      ((anov)localObject2).a(new String[] { localObject1 }).report();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) || (paramInt1 == 1001))
    {
      akks.c(this.mContext, paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.csr = true;
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
          return;
          if (paramInt1 != 1002) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.csr = true;
          break;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
        } while (paramIntent == null);
        return;
      } while (paramInt2 != -1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa = 25;
      dAK();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "NearbyPeopleProfileActivity->doOnActivityResult, resultCode=" + paramInt2);
      }
      if (NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
        paramInt1 = 510;
      }
      for (;;)
      {
        paramIntent = (ajrs)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(60);
        long l2 = 0L;
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          paramIntent.o(l1, 0L, paramInt1);
          return;
          paramInt1 = 509;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.e("NearbyLikeLimitManager", 2, "doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
              l1 = l2;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "doOnActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
      }
    } while (paramInt2 != -1);
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.dmI = 0;
          this.csd = false;
          paramInt2 = this.jv.getChildCount();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            paramIntent = this.jv.getChildAt(paramInt1);
            if ((!(paramIntent.getTag() instanceof albb)) || (((albb)paramIntent.getTag()).nType != 8)) {
              break label587;
            }
            if (QLog.isColorLevel()) {
              QLog.d("nearby.bindphone", 2, "updateBottomBtn, idx=" + paramInt1);
            }
            iW(paramInt1, 8);
          }
          ((ajpj)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).dyE();
          if (QLog.isColorLevel()) {
            QLog.d("nearby.bindphone", 2, "doOnActivityResult, cleanProfileCardCache");
          }
          try
          {
            paramIntent = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSystemService("input_method");
            if (paramIntent == null) {
              break;
            }
            paramIntent.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowToken(), 0);
            return;
          }
          catch (Exception paramIntent) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("nearby.bindphone", 2, "doOnActivityResult, hideSoftInputPanel exp:" + paramIntent);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("nearby.bindphone", 2, "doOnActivityResult, exp=" + paramIntent.toString());
      return;
      label587:
      paramInt1 += 1;
    }
  }
  
  public void doOnDestory()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().xX != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().xX.clear();
    }
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
  }
  
  public void doOnPause()
  {
    if (this.csg) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.35(this), 16, null, false);
    }
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.onActivityResume();
    }
    if (this.csg) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.34(this), 16, null, false);
    }
  }
  
  public void doOnStart()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.MH(true);
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_b_of_type_Afcy != null) {
      this.jdField_b_of_type_Afcy.cYw();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.MH(false);
    }
    if (this.f.hasMessages(1))
    {
      this.f.removeMessages(1);
      dAT();
    }
  }
  
  public void f(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_Alck != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_Alck);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.bTi = paramList.troopUin;
      this.jdField_a_of_type_Alck = new alck();
      this.jdField_a_of_type_Alck.drE = 1024;
      this.jdField_a_of_type_Alck.strTitle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131698396);
      this.jdField_a_of_type_Alck.strContent = paramList.troopName;
      this.jdField_a_of_type_Alck.bVk = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_Alck.strContent == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_Alck);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.bTi, "1", "", "");
      return;
    }
    anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.bTi, "0", "", "");
  }
  
  protected int getContentLayoutId()
  {
    return 2131561476;
  }
  
  public void iV(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        String str = aqep.pe(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
        Object localObject = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
        }
        localObject = new PicInfo();
        ((PicInfo)localObject).localPath = str;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crA)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crA = true;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Akcx$c != null) {
            this.jdField_a_of_type_Akcx$c.lG(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi);
          }
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dAF();
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.set(0, localObject);
          }
        }
        QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    } else if (paramInt2 == 1) {}
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof albb)))
    {
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      localObject1 = (albb)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileDisplayPanel", 2, "click  data.nType= [" + ((albb)localObject1).nType + "]");
      }
      switch (((albb)localObject1).nType)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      if ((((albb)localObject1).data instanceof alck))
      {
        localObject1 = (alck)((albb)localObject1).data;
        if (!aqmr.isEmpty(((alck)localObject1).strJumpUrl))
        {
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("portraitOnly", true);
          if (!aqmr.isEmpty(((alck)localObject1).strJumpUrl)) {
            break label404;
          }
          localObject1 = "";
          label325:
          ((Intent)localObject2).putExtra("url", (String)localObject1);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        label345:
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
        continue;
        label404:
        localObject1 = ((alck)localObject1).strJumpUrl;
        break label325;
        if ((((albb)localObject1).data instanceof Object[]))
        {
          localObject1 = (Object[])((albb)localObject1).data;
          aH(((Boolean)localObject1[0]).booleanValue(), (String)localObject1[1]);
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
        continue;
        if ((((albb)localObject1).data instanceof alck))
        {
          localObject1 = (alck)((albb)localObject1).data;
          if (!aqmr.isEmpty(((alck)localObject1).strJumpUrl)) {
            Nl(((alck)localObject1).strJumpUrl);
          }
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
        continue;
        Object localObject3;
        if ((((albb)localObject1).data instanceof alck))
        {
          localObject2 = (alck)((albb)localObject1).data;
          if (!aqmr.isEmpty(((alck)localObject2).strJumpUrl))
          {
            localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("url", ((alck)localObject2).strJumpUrl);
            ((Intent)localObject3).putExtra("hide_operation_bar", true);
            ((Intent)localObject3).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject3);
          }
        }
        if (28 != ((albb)localObject1).nType) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
        continue;
        if (!(((albb)localObject1).data instanceof alck)) {
          continue;
        }
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("isHost", bool);
          ((Intent)localObject1).putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
            break label916;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.bTi, "1", "", "");
          break;
        }
        label916:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.bTi, "0", "", "");
        continue;
        if (!(((albb)localObject1).data instanceof alck)) {
          continue;
        }
        localObject1 = (alck)((albb)localObject1).data;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((alck)localObject1).strJumpUrl + "&_webviewtype=1");
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        continue;
        localObject2 = getUin();
        if (this.csc) {}
        for (localObject1 = "clk_followed";; localObject1 = "clk_follow")
        {
          anot.a(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
          if (ajrk.isNetworkConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
            break label1193;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696270), 0).show();
          break;
        }
        label1193:
        ((ajpj)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).go.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 1)
        {
          label1247:
          long l1;
          long l2;
          if (this.csa)
          {
            i = 6;
            localObject1 = new ajww(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
            l2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId;
            j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType;
            if (this.csc) {
              break label1334;
            }
          }
          label1334:
          for (bool = true;; bool = false)
          {
            ((ajww)localObject1).a(l1, l2, j, i, bool, new akdf(this));
            break;
            i = 2;
            break label1247;
          }
        }
        label1352:
        label1359:
        String str1;
        if (this.csa)
        {
          localObject1 = "6";
          if (!this.csa) {
            break label1420;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          if (!this.csc) {
            break label1423;
          }
        }
        label1420:
        label1423:
        for (localObject2 = "2";; localObject2 = "1")
        {
          acig.a((QQAppInterface)localObject3, str1, (String)localObject1, (String)localObject2, 1, new akdg(this));
          break;
          localObject1 = "2";
          break label1352;
          break label1359;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, (String)localObject1, (String)localObject2, null, true, null, true, true, null, "from_internal");
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "mCard == null , or mCard.uin is Empty, " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.tribeAppDownload", 2, "sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen + ", sendMsgBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
          }
        }
        for (;;)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) && (this.dmI != 0))
          {
            if (this.dmI == 3)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_WX, mCard == null");
                break;
                QLog.w("NearbyProfileDisplayPanel", 1, "onClick DATA_TYPE_CHAT mcard == null!");
                continue;
              }
              bool = aqiz.isAppInstalled(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowPackage);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTip;
              str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipLeftBtn;
              if (bool) {}
              for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnInstalled;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnNotInstalled)
              {
                localObject1 = aqha.a((Context)localObject2, 230, null, (CharSequence)localObject3, str1, (String)localObject1, new akdi(this, bool), new akdj(this));
                ((aqju)localObject1).getBtnight().setTextColor(-15550475);
                ((aqju)localObject1).show();
                break;
              }
            }
            if (this.dmI == 2)
            {
              aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.bTe, 2131721058, 2131701360, new akdk(this), new akdl(this)).show();
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
                break;
              }
              ajrk.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "phone", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
              break;
            }
            if (this.dmI != 1) {
              break;
            }
            if (!TextUtils.isEmpty(this.bTe)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.bTe, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
              break;
            }
            ajrk.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "blocked", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.has()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.get() == 0))
        {
          localObject1 = ajoz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAccount(), 1);
          if (localObject1 != null)
          {
            ((ajoz)localObject1).ki(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.uint64_uid.get());
            ((ajoz)localObject1).d1 = "14";
            ((ajoz)localObject1).toUin = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            localObject2 = new akkm(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            ((akkm)localObject2).a((ajoz)localObject1);
            ((akkm)localObject2).show();
            ((ajrs)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(60)).ar(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
            continue;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          ajrk.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "pass", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        }
        this.crQ = true;
        bOF();
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        int i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null)) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;; localObject1 = "")
        {
          anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X8004826", "0X8004826", i, 0, (String)localObject1, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 76)) {
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
          }
          NearbyPeopleProfileActivity.dmy = 0;
          if (!ProfileActivity.gg(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)) {
            break label2391;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          break;
        }
        label2391:
        if (!ProfileActivity.gh(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
        continue;
        MO(false);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app == null) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
        {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1)) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crE)
        {
          afck.n("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          continue;
        }
        localObject1 = (ajrs)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(60);
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crE = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa == 19))
        {
          i = 8;
          label2680:
          j = i;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2770;
            }
          }
        }
        label2770:
        for (int j = 1;; j = 2)
        {
          j = i | j;
          ((ajrs)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), j, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(204, 1000L);
          break;
          i = 4;
          break label2680;
        }
        if (!(((albb)localObject1).data instanceof alck)) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
        localObject1 = (alck)((albb)localObject1).data;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((alck)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if (!(((albb)localObject1).data instanceof alck)) {
          continue;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
        localObject1 = (alck)((albb)localObject1).data;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((alck)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if (!(((albb)localObject1).data instanceof alck)) {
          continue;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
        localObject1 = (alck)((albb)localObject1).data;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((alck)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if ((this.jdField_a_of_type_Akhp == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
          continue;
        }
        if (!aqiw.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131693404, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299627));
          continue;
        }
        if (aqiz.isAppInstalled(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "com.guagua.qiqi"))
        {
          this.jdField_a_of_type_Akhp.kr(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid);
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          continue;
        }
        if (this.bwF == 1)
        {
          if (this.jdField_d_of_type_ComTencentMobileqqWidgetProgressButton != null) {
            this.jdField_d_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131701538);
          }
          this.jdField_a_of_type_Akhp.RP(3);
          this.bwF = 2;
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          continue;
        }
        if (aqiw.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.crY)
          {
            aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701077), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701076), 0, 2131701539, new akdm(this), null).show();
            this.crY = false;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
          for (;;)
          {
            this.jdField_a_of_type_Akhp.RP(2);
            if ((this.bwF != 2) && (this.bwF != 0)) {
              break;
            }
            this.bwF = 1;
            break;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
        }
        if ((this.bwF == 2) || (this.bwF == 0))
        {
          aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701077), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701075), this.R, this.R).show();
          this.bwF = 1;
          continue;
        }
        this.jdField_a_of_type_Akhp.RP(2);
        continue;
        if (paramView == this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView)
        {
          if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode)
          {
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
            if (TextUtils.isEmpty(this.bTh))
            {
              localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                i = 0;
                label3670:
                localObject2 = new Bundle();
                ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
                ((Bundle)localObject2).putLong("totalVoters", i);
                ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject2).putBoolean("votersOnly", true);
                if (i <= 0) {
                  break label4027;
                }
              }
              label4027:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject2).putBoolean("hasVoters", bool);
                ((Bundle)localObject2).putBoolean("extra_show_rank", true);
                ((Bundle)localObject2).putInt("frome_where", 4);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
                ajqp.dw(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                  dAJ();
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileDisplayPanel.25(this));
                }
                if (this.jdField_b_of_type_Afcy != null) {
                  this.jdField_b_of_type_Afcy.bXr = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
                  anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
                }
                anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
                localObject2 = "2";
                localObject1 = localObject2;
                if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.bN != null)
                {
                  localObject1 = localObject2;
                  if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.bN.getVisibility() == 0) {
                    localObject1 = "1";
                  }
                }
                anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, (String)localObject1, "", "", "");
                break;
                i = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break label3670;
              }
            }
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            if (getSessionType() == 10002) {}
            for (localObject1 = "6";; localObject1 = "1")
            {
              ((Intent)localObject2).putExtra("url", this.bTh + "&SOURCETYPE=" + (String)localObject1 + "&SIGN=" + aj() + "&UIN=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
              break;
            }
          }
          if (3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode) {
            continue;
          }
          this.crO = true;
          localObject2 = new HashMap();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694933));
            ((HashMap)localObject2).put("param_FailCode", "-210");
            anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayPanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          label4357:
          label4379:
          int k;
          label4484:
          label4586:
          String str2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            i = 1;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label4858;
            }
            j = 1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyLikeLimitManager", 2, "Profile->onClickVote, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + ", isFriend=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend + ", bAvailVoteCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ", bHaveVotedCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            }
            if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
              break label4863;
            }
            k = 510;
            if ((i != 0) || (j != 0)) {
              break label5040;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c == null) || (!aqiw.isNetSupport(BaseApplication.getContext()))) {
              break label4884;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
              break label4871;
            }
            ((ajqh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new akdn(this), k + "");
            str1 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
              break label5016;
            }
            localObject1 = "2";
            label4629:
            str2 = k + "";
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
              break label5024;
            }
            localObject2 = "1";
            label4666:
            if (!this.csi) {
              break label5032;
            }
          }
          label4871:
          label4884:
          label5016:
          label5024:
          label5032:
          for (localObject3 = "2";; localObject3 = "1")
          {
            anot.a(null, "dc00899", "grp_lbs", str1, "data_card", "like_head", 0, 0, (String)localObject1, str2, (String)localObject2, (String)localObject3);
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", getReportType(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileActivity.gg(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)) {
              anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label5387;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            break;
            i = 0;
            break label4357;
            label4858:
            j = 0;
            break label4379;
            label4863:
            k = 509;
            break label4484;
            MN(true);
            this.csi = true;
            break label4586;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c != null)
            {
              ((HashMap)localObject2).put("param_FailCode", "-203");
              anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject2, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131721956));
              break label4586;
            }
            ((HashMap)localObject2).put("param_FailCode", "-204");
            anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694933));
            break label4586;
            localObject1 = "1";
            break label4629;
            localObject2 = "2";
            break label4666;
          }
          label5040:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
          {
            localObject1 = acfp.m(2131708886);
            label5058:
            if (!this.csf)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
                break label5256;
              }
              localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, acfp.m(2131708859), "", acfp.m(2131708799), new akdo(this), null);
              label5111:
              ((Dialog)localObject1).show();
              this.csf = true;
              ((Dialog)localObject1).setOnDismissListener(new akds(this));
            }
            anot.a(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (j == 0) {
              break label5333;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), "", "", "");
          }
          for (;;)
          {
            anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            break;
            localObject1 = acfp.m(2131708816);
            break label5058;
            label5256:
            localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, acfp.m(2131708804) + (String)localObject1 + acfp.m(2131708879), acfp.m(2131708876), acfp.m(2131708853), new akdp(this), new akdq(this));
            break label5111;
            label5333:
            if (i != 0) {
              anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), "", "", "");
            }
          }
          label5387:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          continue;
        }
        if (paramView == this.BA)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if ((!Friends.isValidUin((String)localObject1)) || (!Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))) {
            continue;
          }
          bool = ((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (bool)
          {
            i = 0;
            label5496:
            if (!bool) {
              break label5579;
            }
          }
          for (;;)
          {
            localObject1 = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(i), localObject1 });
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("portraitOnly", true);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
            break;
            i = 1;
            break label5496;
            label5579:
            localObject1 = "";
          }
        }
        if (paramView == this.Vv)
        {
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmv == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dzt();
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.ko(300L);
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
          continue;
        }
        if (paramView != this.BB) {
          continue;
        }
        localObject1 = akks.dm();
        localObject1 = new akkq(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (ArrayList)localObject1);
        ((akkq)localObject1).a(this.jdField_a_of_type_Akkq$b);
        ((akkq)localObject1).e(aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 18.0F), aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 22.0F) + this.BB.getHeight(), 0.2F);
        localObject2 = new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("pub_download_exp").e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
        for (localObject1 = "1";; localObject1 = "2")
        {
          ((anov)localObject2).a(new String[] { localObject1 }).report();
          break;
        }
      }
      catch (SecurityException localSecurityException)
      {
        break label345;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      if (this.jdField_c_of_type_ComTencentWidgetCustomImgView != null) {
        this.jdField_c_of_type_ComTencentWidgetCustomImgView.setImageBitmap(paramBitmap);
      }
      Y(paramBitmap);
    }
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.bIC = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(paramInt2, false);
  }
  
  public class a
    extends BaseAdapter
  {
    private List<PicInfo> DN = new ArrayList();
    
    public a(int paramInt)
    {
      int j = i * 6;
      int i = j;
      while ((i < paramInt.size()) && (i < j + 6))
      {
        this.DN.add(paramInt.get(i));
        i += 1;
      }
    }
    
    public int getCount()
    {
      return this.DN.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.DN.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = akcx.this.a(paramInt, (PicInfo)this.DN.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
  }
  
  public class b
    extends AvatarWallPagerAdapter<GridView>
  {
    protected LinearLayout.LayoutParams f;
    
    public b(AvatarWallViewPager paramAvatarWallViewPager)
    {
      super();
    }
    
    public View a(int paramInt, GridView paramGridView)
    {
      return akcx.a(akcx.this, akcx.a(akcx.this), paramInt);
    }
    
    public View a(boolean paramBoolean, int paramInt)
    {
      View localView = new View(akcx.this.mContext);
      if (this.f == null)
      {
        this.f = new LinearLayout.LayoutParams(rpq.dip2px(akcx.this.mContext, 30.0F), rpq.dip2px(akcx.this.mContext, 1.5F));
        this.f.leftMargin = rpq.dip2px(akcx.this.mContext, 2.0F);
        this.f.rightMargin = rpq.dip2px(akcx.this.mContext, 2.0F);
      }
      localView.setLayoutParams(this.f);
      if (paramBoolean)
      {
        localView.setBackgroundColor(-1);
        return localView;
      }
      localView.setBackgroundColor(1728053247);
      return localView;
    }
    
    public void w(int paramInt, View paramView)
    {
      akcx.this.me.values().remove(paramView);
    }
  }
  
  public class c
    extends AvatarWallPagerAdapter<PicInfo>
  {
    protected LinearLayout.LayoutParams f;
    
    public View a(boolean paramBoolean, int paramInt)
    {
      View localView = new View(this.this$0.mContext);
      if (this.f == null)
      {
        this.f = new LinearLayout.LayoutParams(rpq.dip2px(this.this$0.mContext, 11.0F), rpq.dip2px(this.this$0.mContext, 1.0F));
        this.f.leftMargin = rpq.dip2px(this.this$0.mContext, 2.0F);
        this.f.rightMargin = rpq.dip2px(this.this$0.mContext, 2.0F);
      }
      localView.setLayoutParams(this.f);
      if (paramBoolean)
      {
        localView.setBackgroundColor(-1);
        return localView;
      }
      localView.setBackgroundColor(1728053247);
      return localView;
    }
    
    public View b(int paramInt, PicInfo paramPicInfo)
    {
      return this.this$0.a(paramInt, paramPicInfo);
    }
    
    public boolean b(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
    {
      return this.this$0.a.a(paramPicInfo1, paramPicInfo2);
    }
    
    public void w(int paramInt, View paramView)
    {
      this.this$0.me.values().remove(paramView);
    }
  }
  
  class d
    extends FragmentPagerAdapter
  {
    private List<Fragment> DO;
    
    d(List<Fragment> paramList)
    {
      super();
      Object localObject;
      this.DO = localObject;
    }
    
    Fragment a(int paramInt)
    {
      if ((this.DO != null) && (this.DO.size() > paramInt)) {
        return (Fragment)this.DO.get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.DO.get(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcx
 * JD-Core Version:    0.7.0.1
 */