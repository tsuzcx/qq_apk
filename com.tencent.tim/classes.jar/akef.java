import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.jungle.nearby.nio.proto.nearby.BarInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.FeedInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.26;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.28;
import com.tencent.mobileqq.nearby.profilecard.SavorTagIcon;
import com.tencent.mobileqq.nearby.profilecard.SavorTagImg;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.a;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.c;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akef
  extends akcw
  implements akho, View.OnClickListener, BounceScrollView.c
{
  public static String[] fH = { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
  public static String[] fI = { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  private ImageView BA;
  ImageView BF;
  ImageView BG;
  ImageView BH;
  private ImageView Bw;
  private ImageView Bx;
  List<String> DP;
  private View Fh;
  private View Fi;
  View Fk;
  TextView Od;
  RedTouch P;
  DialogInterface.OnClickListener R = new akfa(this);
  private TextView VC;
  private TextView VD;
  private TextView VE;
  private TextView VF;
  private TextView VG;
  private TextView VH;
  private TextView VI;
  TextView VJ;
  TextView VK;
  TextView VL;
  TextView VM;
  TextView VN;
  TextView Vz;
  protected ajpb a;
  private ajrf jdField_a_of_type_Ajrf;
  private akef.a jdField_a_of_type_Akef$a;
  akhp jdField_a_of_type_Akhp = null;
  protected alck a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  public NearbyPeopleProfileActivity a;
  SavorTagImg jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  ajuu[] jdField_a_of_type_ArrayOfAjuu;
  SavorTagIcon[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
  SavorTagImg[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
  private Animation aL;
  private Animation aM;
  AtomicInteger ay = new AtomicInteger(0);
  private afcy jdField_b_of_type_Afcy;
  private HeartLayout jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private NearbyCardVoteView jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  AtomicInteger bA = new AtomicInteger(0);
  AtomicInteger bB = new AtomicInteger(0);
  String bTe = "";
  String bTf = "";
  String bTg = "";
  String bTh = "";
  protected String bTi;
  String bTl;
  private URLImageView bu;
  int bwF = 0;
  private Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new akfe(this);
  private URLImageView[] jdField_c_of_type_ArrayOfComTencentImageURLImageView;
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
  boolean csh = false;
  protected boolean csi = true;
  private boolean csk;
  public boolean csl;
  Handler.Callback jdField_d_of_type_AndroidOsHandler$Callback = new akeg(this);
  ProgressButton jdField_d_of_type_ComTencentMobileqqWidgetProgressButton;
  CustomImgView jdField_d_of_type_ComTencentWidgetCustomImgView;
  Handler dh = new akey(this);
  int dmG;
  int dmH;
  int dmJ = 0;
  private int dmL;
  int dmM;
  private byte[] eT;
  auru jdField_f_of_type_Auru;
  private ImmersiveTitleBar2 jdField_f_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String[] fJ;
  private View.OnClickListener fv = new akex(this);
  private Button gT;
  RelativeLayout ha;
  private WeakReference<aqdj> hv;
  RelativeLayout[] i;
  RelativeLayout[] j;
  private LinearLayout jA;
  private LinearLayout jB;
  private LinearLayout jC;
  LinearLayout jD;
  private LinearLayout jE;
  private LinearLayout jv;
  private LinearLayout jw;
  private LinearLayout jy;
  private LinearLayout jz;
  private BounceScrollView l;
  int[] lZ = { 2131370276, 2131370270, 2131370269, 2131370277 };
  private RelativeLayout le;
  private RelativeLayout lf;
  RelativeLayout lg;
  RelativeLayout lh;
  RelativeLayout li;
  RelativeLayout lj;
  RelativeLayout lk;
  private RelativeLayout ll;
  private RelativeLayout lm;
  private RelativeLayout ln;
  private RelativeLayout lo;
  private aryx mDownloadListener = new akfb(this);
  int[] ma = { 2131370274, 2131370275, 2131370271 };
  protected final Map<String, View> me = new HashMap();
  private TextView nO;
  TextView qB;
  private View qi;
  private TextView tM;
  private TextView tO;
  private TextView tP;
  
  public akef(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_f_of_type_Auru = new auru(ThreadManager.getSubThreadLooper(), this.jdField_d_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.csb = bool;
      this.csa = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      return;
      bool = false;
    }
  }
  
  private void K(TextView paramTextView)
  {
    int k = paramTextView.getWidth();
    int m = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.dmL > 0) {}
    for (Object localObject1 = "+ ";; localObject1 = "- ")
    {
      paramTextView.setText((String)localObject1 + String.valueOf(Math.abs(this.dmL)));
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, k / 2, m / 2);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localAnimationSet.setDuration(1500L);
      paramTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      this.dmL = 0;
      return;
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
      QLog.e("NearbyProfileDisplayTribePanel", 2, localJSONException.toString());
    }
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
  
  private void bm(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    this.VI.setVisibility(0);
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165381));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a != null) {}
        for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.i(localRichStatus.actionId, 200);; paramArrayOfByte = aqcu.decodeResource(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130850435))
        {
          paramArrayOfByte = new arjh(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int k = (int)(this.VI.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, k, k);
          paramArrayOfByte = new argi(paramArrayOfByte, 0);
          paramArrayOfByte.a(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          this.VI.setText((CharSequence)localObject);
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          return;
        }
      }
      paramArrayOfByte = aqmr.trim(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          this.VI.setVisibility(8);
          return;
        }
        this.VI.setVisibility(8);
        return;
      }
      this.VI.setText(paramArrayOfByte.trim());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.VI.setVisibility(8);
      return;
    }
    this.VI.setVisibility(8);
  }
  
  private void dAQ()
  {
    this.qi.setBackgroundResource(2130846454);
    this.tO.setOnClickListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.Bw.setVisibility(8);
      this.tP.setVisibility(0);
      this.tP.setText(2131697294);
      this.tP.setOnClickListener(new akem(this));
      return;
    }
    this.Bw.setVisibility(8);
    this.tP.setVisibility(0);
    this.tP.setText(2131697294);
    this.tP.setOnClickListener(new aken(this));
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
        break label255;
      }
      if (this.ay.get() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c.b(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.ay.get(), 0);
        bool = ((ajqh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).ct(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
        if (PraiseManager.f(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app) <= 0) {
          break label241;
        }
        if (!bool) {
          break label236;
        }
        k = 3;
        anot.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.ay.get(), k, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), String.valueOf(this.ay.get()), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.ay.set(0);
      }
    }
    label236:
    label241:
    label255:
    while ((this.bA.get() == 0) && (this.bB.get() == 0)) {
      for (;;)
      {
        boolean bool;
        return;
        k = 2;
        continue;
        if (bool) {
          k = 1;
        } else {
          k = 0;
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
    for (int k = 510;; k = 509)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c.D(localArrayList, k);
      this.bA.set(0);
      this.bB.set(0);
      return;
    }
  }
  
  private void dAU()
  {
    this.jdField_a_of_type_Ajrf.dyS();
  }
  
  private void dAV()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    Object localObject = new ArrayList(3);
    ArrayList localArrayList2 = new ArrayList(9);
    if (this.lk.getVisibility() == 0) {
      localArrayList2.add(this.lk);
    }
    int k = 0;
    String str1;
    label139:
    String str2;
    if (k < 3)
    {
      if (this.jdField_a_of_type_ArrayOfAjuu[(k + 4)].tagInfos.size() > 0)
      {
        ((List)localObject).add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k]);
        localArrayList2.add(this.j[k]);
        this.j[k].setVisibility(0);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          str1 = "1";
          if (this.jdField_a_of_type_ArrayOfAjuu[k].tagType > 4) {
            break label227;
          }
          str2 = this.jdField_a_of_type_ArrayOfAjuu[k].tagType + 3 + "";
          label183:
          anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        k += 1;
        break;
        str1 = "2";
        break label139;
        label227:
        str2 = this.jdField_a_of_type_ArrayOfAjuu[k].tagType - 4 + "";
        break label183;
        this.j[k].setVisibility(8);
      }
    }
    k = 0;
    if (k < 4)
    {
      if (this.jdField_a_of_type_ArrayOfAjuu[k].tagInfos.size() > 0)
      {
        localArrayList1.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k]);
        localArrayList2.add(this.i[k]);
        this.i[k].setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          str1 = "1";
          label359:
          if (this.jdField_a_of_type_ArrayOfAjuu[k].tagType > 4) {
            break label447;
          }
          str2 = this.jdField_a_of_type_ArrayOfAjuu[k].tagType + 3 + "";
          label403:
          anot.a((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        k += 1;
        break;
        str1 = "2";
        break label359;
        label447:
        str2 = this.jdField_a_of_type_ArrayOfAjuu[k].tagType - 4 + "";
        break label403;
        this.i[k].setVisibility(8);
      }
    }
    if (localArrayList2.size() > 0) {
      ((View)localArrayList2.get(0)).setBackgroundDrawable(null);
    }
    for (;;)
    {
      if (localArrayList2.size() > 1) {
        ((View)localArrayList2.get(localArrayList2.size() - 1)).setBackgroundResource(2130851356);
      }
      return;
      if (localArrayList2.size() == 0) {
        this.Fh.findViewById(2131370221).setVisibility(8);
      }
    }
  }
  
  private void dAW()
  {
    this.jB.setVisibility(8);
    if (this.jC != null) {
      this.jC.setVisibility(8);
    }
  }
  
  private void dAX()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.bu.setVisibility(8);
      this.jdField_d_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
      this.BF.setVisibility(8);
      this.BG.setVisibility(8);
      this.BH.setVisibility(8);
      return;
    }
    dAZ();
  }
  
  private void dAZ()
  {
    bool = true;
    this.bu.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167442));
    try
    {
      this.bu.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846450));
      this.bu.setOnClickListener(null);
      Object localObject = aqdj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 3);
      this.hv = new WeakReference(localObject);
      this.jdField_d_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
      this.jdField_d_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
      int k = (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity + 0.5D);
      int m = (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity + 0.5D);
      localObject = new Paint();
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setStrokeWidth(m);
      ((Paint)localObject).setAntiAlias(true);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(m * 2 + k, m * 2 + k, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          new Canvas(localBitmap).drawCircle(k / 2 + m, m + k / 2, k / 2, (Paint)localObject);
          this.BF.setVisibility(0);
          this.BF.setImageBitmap(localBitmap);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
            continue;
            this.BH.setBackgroundResource(2130846452);
            bool = false;
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
            {
              this.BG.setVisibility(8);
              this.BH.setVisibility(8);
              this.jdField_d_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
            }
          }
        }
      }
      this.qi.setBackgroundDrawable(null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        this.BG.setVisibility(0);
        this.BH.setVisibility(0);
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi.isEmpty())
        {
          this.BH.setBackgroundResource(2130846453);
          this.jdField_d_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
          this.jdField_d_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dAF();
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall getDrawable oom.");
        }
      }
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
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
    int m = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aj.getIntExtra("frome_where", 6);
    int k;
    if (m > 0)
    {
      k = m;
      if (m < 6) {}
    }
    else
    {
      k = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa;
      if (k != 5) {
        break label48;
      }
      k = 1;
    }
    return k;
    label48:
    if (ProfileActivity.gg(k)) {
      return 3;
    }
    if (((k >= 10) && (k <= 19)) || (k == 30)) {
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
  
  private void iW(int paramInt1, int paramInt2)
  {
    int k = 0;
    switch (paramInt2)
    {
    default: 
      if (k == 0) {
        this.jv.setVisibility(8);
      }
      break;
    }
    label140:
    Object localObject1;
    label194:
    do
    {
      return;
      k = 2131701558;
      break;
      k = 2131701020;
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.csc)
      {
        k = 2131698600;
        if (!this.csc) {
          break label194;
        }
      }
      for (localObject1 = "exp_followed";; localObject1 = "exp_follow")
      {
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
        break;
        k = 2131698598;
        break label140;
      }
      k = 2131719495;
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      k = 2131694846;
      break;
      k = 2131696257;
      break;
      k = 2131701078;
      break;
      localObject1 = this.jv.getChildAt(paramInt1);
      ((View)localObject1).setVisibility(0);
      if (paramInt1 == 0) {
        ((View)localObject1).setVisibility(8);
      }
      if (paramInt2 == 40) {
        break label514;
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131381048);
      ((Button)localObject2).setText(k);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130851044);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165735));
      }
      ((Button)localObject2).setOnClickListener(this);
      localObject3 = new albb(paramInt2, null);
      ((Button)localObject2).setTag(localObject3);
      ((View)localObject1).setTag(localObject3);
      if ((paramInt2 == 60) && (this.csc))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167337));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839564));
        return;
      }
      if ((paramInt2 == 8) && (this.csd) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130851044);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.cse) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend));
    ((Button)localObject2).setBackgroundResource(2130851044);
    ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label514:
    ((Button)((View)localObject1).findViewById(2131381048)).setVisibility(8);
    Object localObject2 = new albb(paramInt2, null);
    Object localObject3 = (ProgressButton)((View)localObject1).findViewById(2131373672);
    if (localObject3 != null)
    {
      ((ProgressButton)localObject3).setVisibility(0);
      ((ProgressButton)localObject3).setText(k);
      if (paramInt2 == 38)
      {
        ((ProgressButton)localObject3).setBackgroundResource(2130851044);
        ((ProgressButton)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165735));
      }
      ((ProgressButton)localObject3).setOnClickListener(this);
      ((ProgressButton)localObject3).setTag(localObject2);
    }
    ((View)localObject1).setTag(localObject2);
  }
  
  private void lC(List<StrangerInfo> paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (int k = 0;; k = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, k);
      localObject1 = akkx.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.P.e((BusinessInfoCheckUpdate.AppInfo)localObject1);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jD.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int m;
    for (k = 3;; k = paramList.size())
    {
      localObject1 = new ArrayList(3);
      m = 0;
      while (m < k)
      {
        localObject2 = (StrangerInfo)paramList.get(m);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        m += 1;
      }
    }
    int n = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jD.getLayoutParams();
    if (((RelativeLayout.LayoutParams)localObject2).width != this.dmG * n + (n - 1) * this.dmH) {
      ((RelativeLayout.LayoutParams)localObject2).width = (this.dmG * n + (n - 1) * this.dmH);
    }
    for (k = 1;; k = 0)
    {
      if ((!this.P.aux()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != wja.dp2px(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(35.0F, paramList);
        m = 1;
      }
      for (;;)
      {
        if (m != 0) {
          this.jD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        k = 0;
        while (k < n)
        {
          localObject2 = new LinearLayout.LayoutParams(wja.dp2px(30.0F, paramList), wja.dp2px(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(5.0F, paramList);
          StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(k);
          if (localStrangerInfo != null)
          {
            CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            Drawable localDrawable = localCustomImgView.getDrawable();
            if ((localDrawable != null) && ((localDrawable instanceof aqcr))) {
              ((aqcr)localDrawable).cancel();
            }
            localCustomImgView.setImageDrawable(aqdj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 202, String.valueOf(localStrangerInfo.tinyId), true));
            this.jD.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
          }
          k += 1;
        }
        m = k;
        if (this.P.aux())
        {
          m = k;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != wja.dp2px(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(45.0F, paramList);
            m = 1;
          }
        }
      }
      if (this.jD.getVisibility() == 0) {
        break;
      }
      this.jD.setVisibility(0);
      return;
    }
  }
  
  public int GN()
  {
    int i8 = 1;
    int k;
    int m;
    label21:
    int n;
    label30:
    int i1;
    label40:
    int i2;
    label50:
    int i3;
    label60:
    int i4;
    label70:
    int i5;
    label80:
    int i6;
    label90:
    int i7;
    if (this.crX)
    {
      k = 1;
      if (!this.crW) {
        break label169;
      }
      m = 1;
      if (!this.crV) {
        break label174;
      }
      n = 1;
      if (!this.csl) {
        break label179;
      }
      i1 = 1;
      if (!this.crU) {
        break label185;
      }
      i2 = 1;
      if (!this.crT) {
        break label191;
      }
      i3 = 1;
      if (!this.crS) {
        break label197;
      }
      i4 = 1;
      if (!this.crR) {
        break label203;
      }
      i5 = 1;
      if (!this.crQ) {
        break label209;
      }
      i6 = 1;
      if (!this.crP) {
        break label215;
      }
      i7 = 1;
      label100:
      if (!this.crO) {
        break label221;
      }
    }
    for (;;)
    {
      return i7 << 1 | k << 10 | m << 9 | n << 8 | i1 << 7 | i2 << 6 | i3 << 5 | i4 << 4 | i5 << 3 | i6 << 2 | i8 << 0;
      k = 0;
      break;
      label169:
      m = 0;
      break label21;
      label174:
      n = 0;
      break label30;
      label179:
      i1 = 0;
      break label40;
      label185:
      i2 = 0;
      break label50;
      label191:
      i3 = 0;
      break label60;
      label197:
      i4 = 0;
      break label70;
      label203:
      i5 = 0;
      break label80;
      label209:
      i6 = 0;
      break label90;
      label215:
      i7 = 0;
      break label100;
      label221:
      i8 = 0;
    }
  }
  
  public void ML(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "hideCharmChanged() showAnim=" + paramBoolean);
    }
    TextView localTextView = (TextView)this.lf.findViewById(2131365974);
    if (paramBoolean)
    {
      int k = localTextView.getWidth();
      int m = localTextView.getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, k / 2, m / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      localTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    localTextView.setVisibility(4);
  }
  
  void MM(boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()))
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label127;
        }
        bool2 = true;
        label67:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
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
      label127:
      bool2 = false;
      break label67;
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
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
      if (!this.jdField_f_of_type_Auru.hasMessages(1))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        this.jdField_f_of_type_Auru.sendMessageDelayed((Message)localObject, 2000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.aWs = true;
      MM(paramBoolean);
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
    int k;
    if (Friends.isValidUin(str))
    {
      localObject2 = ajri.encode(str);
      str = ((String)localObject1).toLowerCase();
      if (getSessionType() == 10002)
      {
        k = 6;
        if (!paramBoolean) {
          break label330;
        }
        localObject1 = "near.card.like";
        label139:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(k), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        k = aqek.jW(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa);
        if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
          break label355;
        }
        k = 6;
      }
    }
    label330:
    label355:
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", k, 0, "", "", "", "");
      return;
      k = 1;
      break;
      localObject1 = "near.card.s";
      break label139;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695115));
      return;
    }
  }
  
  public void RN(int paramInt)
  {
    this.dmL = paramInt;
    if (this.dmL == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "prepare2ScoreAnim() diff=" + paramInt);
    }
    TextView localTextView = (TextView)this.lf.findViewById(2131365974);
    Rect localRect;
    if (localTextView.getTag() == null)
    {
      localRect = new Rect();
      localTextView.setTag(localRect);
    }
    for (;;)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView();
      localTextView.getGlobalVisibleRect(localRect);
      if (localRect.bottom >= localView.getHeight()) {
        break;
      }
      K(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(202, 2500L);
      return;
      localRect = (Rect)localTextView.getTag();
    }
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "getAvatarWallItemView, position = " + paramInt + ", info = " + paramPicInfo.toString());
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localCustomImgView.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth));
    localRelativeLayout.addView(localCustomImgView, new LinearLayout.LayoutParams(-1, -1));
    Object localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject1).setBackgroundResource(2130842138);
    ((ImageView)localObject1).setImageResource(2130846748);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int k = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(k, k);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845956));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.fv);
    if (AppSetting.enableTalkBack) {
      localRelativeLayout.setContentDescription(acfp.m(2131708878) + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846612);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crG) || (TextUtils.isEmpty(paramPicInfo.videoUrl))) {
        break label536;
      }
      this.me.put(paramPicInfo.videoUrl, localRelativeLayout);
      if (advm.lj(paramPicInfo.videoUrl))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!aqiw.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label523;
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
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (aqmr.isEmpty(paramPicInfo.bSZ)) {
        break label641;
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
    label523:
    label536:
    return localRelativeLayout;
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 1))
    {
      if (ajrk.isColorLevel()) {
        ajrk.m("NearbyProfileDisplayTribePanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
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
        break label314;
      }
      paramView = "tag_same";
      label162:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
        break label321;
      }
      paramInterestTagInfo = "1";
      label177:
      if (paramInt > 4) {
        break label328;
      }
    }
    label314:
    label321:
    label328:
    for (Object localObject = paramInt + 3 + "";; localObject = paramInt - 4 + "")
    {
      anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", (String)localObject, "");
      ThreadManager.post(new NearbyProfileDisplayTribePanel.28(this, paramInt), 5, null, false);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130851773);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if (ShortVideoUtils.awI())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmA;
      localURLDrawableOptions.mExtraInfo = localObject;
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(advm.h(paramPicInfo.videoUrl), localURLDrawableOptions));
    }
    for (;;)
    {
      if (paramRelativeLayout.getVisibility() == 0) {
        paramRelativeLayout.setVisibility(8);
      }
      return;
      if (!TextUtils.isEmpty(paramPicInfo.bSZ)) {
        localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.bSZ, localURLDrawableOptions));
      }
    }
  }
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    }
    paramNearbyPeopleCard = aqmj.bt(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {}
    int k;
    int m;
    Object localObject1;
    Object localObject2;
    try
    {
      this.bTh = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      this.bu.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      if (!this.csh)
      {
        this.csh = true;
        this.fJ = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2130969875);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
        this.j = new RelativeLayout[3];
        this.i = new RelativeLayout[4];
        this.jdField_a_of_type_ArrayOfAjuu = new ajuu[7];
        k = 0;
        while (k < 7)
        {
          this.jdField_a_of_type_ArrayOfAjuu[k] = new ajuu(k + 1);
          k += 1;
        }
      }
    }
    catch (JSONException paramNearbyPeopleCard)
    {
      for (;;)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
      m = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167304);
      k = 0;
      while (k < 4)
      {
        this.i[k] = ((RelativeLayout)((ViewStub)this.Fh.findViewById(this.lZ[k])).inflate());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k] = ((SavorTagIcon)this.i[k].findViewById(2131377647));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].a(this.fJ[k], this.jdField_a_of_type_ArrayOfAjuu[k].tagType, this.jdField_a_of_type_ArrayOfAjuu[k].tagInfos, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].setTitleTextColor(m);
        if (AppSetting.enableTalkBack) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].setClickable(true);
        }
        k += 1;
      }
      k = 0;
      while (k < 3)
      {
        this.j[k] = ((RelativeLayout)((ViewStub)this.Fh.findViewById(this.ma[k])).inflate());
        int n = k + 4;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k] = ((SavorTagImg)this.j[k].findViewById(2131377647));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].a(this.fJ[n], this.jdField_a_of_type_ArrayOfAjuu[n].tagType, this.jdField_a_of_type_ArrayOfAjuu[n].tagInfos, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].setTitleTextColor(m);
        if (AppSetting.enableTalkBack) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].setClickable(true);
        }
        k += 1;
      }
      if (this.lk == null)
      {
        this.lk = ((RelativeLayout)((ViewStub)this.Fh.findViewById(2131370278)).inflate());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.lk.findViewById(2131377647));
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      localObject2 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
        break label2183;
      }
    }
    paramNearbyPeopleCard = "1";
    anot.a((QQAppInterface)localObject1, "dc00899", "grp_lbs", (String)localObject2, "data_card", "exp", 0, 0, paramNearbyPeopleCard, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from % 20, "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2)
    {
      this.lm.setVisibility(8);
      this.lg.setVisibility(8);
      label660:
      if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
        break label2301;
      }
      this.csd = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
      this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
      this.bTe = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
      this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
      label717:
      this.dmJ = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
      dBa();
      bl(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
      dAQ();
      dAJ();
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
      k = paramNearbyPeopleCard.getColor(2131167304);
      m = paramNearbyPeopleCard.getColor(2131167385);
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
        break label2348;
      }
      this.le.findViewById(2131369116).setVisibility(0);
      this.Bx.setVisibility(0);
      this.Bx.setImageResource(2130842145);
      label827:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        break label2400;
      }
      localObject1 = (TextView)this.jA.findViewById(2131379508);
      localObject2 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label2390;
      }
      paramNearbyPeopleCard = acfp.m(2131708850);
      label879:
      ((TextView)localObject1).setText(paramNearbyPeopleCard + acfp.m(2131708884));
      label902:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
        break label2438;
      }
      this.BA.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label2425;
      }
      this.BA.setImageResource(2130846803);
      label942:
      ThreadManager.post(new NearbyProfileDisplayTribePanel.13(this), 8, null, true);
      label957:
      localObject1 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label2450;
      }
      ((StringBuilder)localObject1).append("男 ");
      this.Vz.setBackgroundColor(-12348939);
      label995:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) {
        ((StringBuilder)localObject1).append("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁 ");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label2483;
        }
        paramNearbyPeopleCard = "1";
        label1098:
        anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, paramNearbyPeopleCard, "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0) && (aqep.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) != null))
      {
        ((StringBuilder)localObject1).append(aqep.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) + " ");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label2490;
        }
        paramNearbyPeopleCard = "1";
        label1212:
        anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, paramNearbyPeopleCard, "", "", "");
      }
      if ((!aqmr.isEmpty(aqek.fW(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus != 1)) {
        break label2497;
      }
      if (((StringBuilder)localObject1).toString().length() <= 0) {
        break label2581;
      }
      this.Od.setText((CharSequence)localObject1);
      this.ha.setVisibility(0);
      label1301:
      if (this.jdField_a_of_type_Ajpb == null) {
        this.jdField_a_of_type_Ajpb = ajpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
      }
      if (this.jdField_a_of_type_Ajpb.isExpired()) {
        ((ajpp)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(204)).a(new akel(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.aOK)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)) {
        break label2593;
      }
      this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.aOK + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + acfp.m(2131708810));
      this.Vz.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
      label1493:
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileDisplayTribePanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
      }
      if ((ajrm.arz()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null)) {
        gO(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.bSZ, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.videoUrl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
        break label2788;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
        break label2764;
      }
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
    }
    for (;;)
    {
      label1636:
      if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
        this.VC.setText(paramNearbyPeopleCard.trim());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
      {
        this.tO.setVisibility(8);
        this.jw.setVisibility(0);
        ((TextView)this.jw.findViewById(2131381166)).setText(paramNearbyPeopleCard);
        label1699:
        bm(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm != 0L) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3)) {
          break label2856;
        }
        this.lf.setVisibility(8);
        label1742:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          this.lh.setBackgroundDrawable(null);
        }
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = aqmr.trim(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
        if (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
          break label2989;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label2956;
        }
        this.VF.setTextColor(m);
        this.VF.setText(acfp.m(2131708889));
        this.lh.setVisibility(0);
        label1831:
        this.VG.setTextColor(m);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= aqek.cp.length)) {
          break label3079;
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
        this.li.setVisibility(0);
        this.VG.setText(aqek.cp[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
        this.VG.setTextColor(k);
        label1936:
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = aqmr.trim(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
          break label3163;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label3151;
        }
        this.VH.setTextColor(m);
        this.VH.setText(acfp.m(2131708802));
        this.lj.setVisibility(0);
        label2006:
        dAR();
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
          break label3286;
        }
        if (!this.csb) {
          break label3253;
        }
        this.jv.setVisibility(8);
        this.jy.setVisibility(8);
        this.Fi.setVisibility(0);
        new anov(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin).report();
      }
      for (;;)
      {
        dAX();
        dAL();
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAjuu);
        k = 0;
        while (k < 4)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].bJ(this.jdField_a_of_type_ArrayOfAjuu[k].tagInfos);
          if (AppSetting.enableTalkBack) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].xC());
          }
          k += 1;
        }
        label2183:
        paramNearbyPeopleCard = "2";
        break;
        this.lm.setVisibility(0);
        this.lg.setVisibility(0);
        this.lm.setOnClickListener(new akeh(this));
        this.lg.setOnClickListener(new akei(this));
        ((apsz)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(113)).a(1402, new akej(this));
        anot.a(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
        break label660;
        label2301:
        this.csd = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
        this.cse = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
        this.bTe = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
        this.bTf = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
        break label717;
        label2348:
        this.Bx.setVisibility(8);
        this.le.findViewById(2131369116).setVisibility(8);
        this.jz.findViewById(2131369116).setVisibility(8);
        break label827;
        label2390:
        paramNearbyPeopleCard = acfp.m(2131708831);
        break label879;
        label2400:
        ((TextView)this.jA.findViewById(2131379508)).setText(acfp.m(2131708827));
        break label902;
        label2425:
        this.BA.setImageResource(2130846802);
        break label942;
        label2438:
        this.BA.setVisibility(8);
        break label957;
        label2450:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
          break label995;
        }
        ((StringBuilder)localObject1).append("女 ");
        this.Vz.setBackgroundColor(-38511);
        break label995;
        label2483:
        paramNearbyPeopleCard = "2";
        break label1098;
        label2490:
        paramNearbyPeopleCard = "2";
        break label1212;
        label2497:
        ((StringBuilder)localObject1).append(aqek.fW(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
        for (paramNearbyPeopleCard = "1";; paramNearbyPeopleCard = "2")
        {
          anot.a((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, paramNearbyPeopleCard, "", "", "");
          break;
        }
        label2581:
        this.ha.setVisibility(8);
        break label1301;
        label2593:
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
        {
          this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.replace(" ", "·"));
          this.Vz.setVisibility(0);
          break label1493;
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff))) {
          break label1493;
        }
        this.Vz.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + acfp.m(2131708907));
        this.Vz.setVisibility(0);
        break label1493;
        label2764:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
          break label3394;
        }
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        break label1636;
        label2788:
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
          break label3394;
        }
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        break label1636;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label1699;
        }
        this.jw.setVisibility(8);
        this.tO.setVisibility(0);
        this.tO.setText(acfp.m(2131708867));
        break label1699;
        label2856:
        this.lf.setVisibility(0);
        this.VD.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strLevelType);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          this.VD.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.mHeartNum + acfp.m(2131708872));
          this.VD.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167304));
        }
        this.lf.setOnClickListener(this);
        break label1742;
        label2956:
        this.lh.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label1831;
        }
        this.li.setBackgroundResource(2130851365);
        break label1831;
        label2989:
        this.VF.setTextColor(k);
        this.VF.setText(new aofk(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
        this.lh.setOnClickListener(null);
        this.lh.setVisibility(0);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
        break label1831;
        label3079:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          this.VG.setText(acfp.m(2131708916));
          break label1936;
        }
        this.li.setVisibility(8);
        if ((this.lh.getVisibility() != 8) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2)) {
          break label1936;
        }
        this.lj.setBackgroundResource(2130851365);
        break label1936;
        label3151:
        this.lj.setVisibility(8);
        break label2006;
        label3163:
        this.VH.setTextColor(k);
        this.VH.setText(new aofk(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
        this.lj.setOnClickListener(null);
        this.lj.setVisibility(0);
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
        break label2006;
        label3253:
        this.jv.setVisibility(0);
        this.jy.setVisibility(8);
        this.Fi.setVisibility(8);
        dAK();
        continue;
        label3286:
        this.jv.setVisibility(8);
        this.jy.setVisibility(0);
        this.Fi.setVisibility(8);
        dAY();
      }
      k = 0;
      while (k < 3)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].bJ(this.jdField_a_of_type_ArrayOfAjuu[(k + 4)].tagInfos);
        if (AppSetting.enableTalkBack) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[k].xC());
        }
        k += 1;
      }
      dAV();
      new StringBuilder();
      dAW();
      return;
      label3394:
      paramNearbyPeopleCard = "";
    }
  }
  
  public void bOF()
  {
    aqfp.Sz(true);
    int k = getSessionType();
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
    fr(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, k);
  }
  
  public void bl(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.lo.setVisibility(8);
      this.ln.setVisibility(8);
      this.ll.setVisibility(8);
      this.jA.setVisibility(8);
      this.lk.setVisibility(8);
    }
    label181:
    label349:
    label379:
    int k;
    label412:
    label478:
    label746:
    do
    {
      return;
      nearby.Cmd0x1RspBody localCmd0x1RspBody = new nearby.Cmd0x1RspBody();
      int m;
      try
      {
        localCmd0x1RspBody.mergeFrom(paramArrayOfByte);
        localObject1 = localCmd0x1RspBody.bytes_bars_url.get().toStringUtf8();
        this.bTg = localCmd0x1RspBody.bytes_qunlist_url.get().toStringUtf8();
        this.eT = localCmd0x1RspBody.bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().t(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.eT);
        this.csc = localCmd0x1RspBody.bool_follow.get();
        if (localCmd0x1RspBody.uint32_if_mask_msg.get() != 1) {
          break label1086;
        }
        bool = true;
        this.csd = bool;
        if (localCmd0x1RspBody.uint32_if_mask_gift.get() != 1) {
          break label1092;
        }
        bool = true;
        this.cse = bool;
        paramArrayOfByte = localCmd0x1RspBody.bytes_feed_wording_title.get().toStringUtf8();
        localObject2 = localCmd0x1RspBody.bytes_feed_wording.get().toStringUtf8();
        this.VJ.setText(paramArrayOfByte);
        paramArrayOfByte = afcw.kv((String)localObject2);
        this.VK.setText(afcw.b(paramArrayOfByte, 16));
        if (localCmd0x1RspBody.bytes_mask_msg_reason.has()) {
          this.bTe = localCmd0x1RspBody.bytes_mask_msg_reason.get().toStringUtf8();
        }
        if (localCmd0x1RspBody.bytes_mask_gift_reason.has()) {
          this.bTf = localCmd0x1RspBody.bytes_mask_gift_reason.get().toStringUtf8();
        }
        localObject2 = new ArrayList();
        if ((!localCmd0x1RspBody.rpt_BarInfo_bars.has()) || (localCmd0x1RspBody.rpt_BarInfo_bars.get().size() <= 0)) {
          break label1173;
        }
        this.lk.setVisibility(0);
        paramArrayOfByte = localCmd0x1RspBody.rpt_BarInfo_bars.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          localObject3 = (nearby.BarInfo)paramArrayOfByte.next();
          if (((ArrayList)localObject2).size() < 12) {
            break label1098;
          }
        }
        k = localCmd0x1RspBody.uint32_bars_num.get();
        if (k > 12)
        {
          if (((ArrayList)localObject2).size() <= 11) {
            break label1185;
          }
          ((ArrayList)localObject2).remove(11);
          paramArrayOfByte = new InterestTagInfo();
          paramArrayOfByte.tagName = " ";
          paramArrayOfByte.tagIconUrl = "icon_more_url";
          paramArrayOfByte.tagJumpUrl = "icon_more_url";
          paramArrayOfByte.tagType = 10;
          ((ArrayList)localObject2).add(paramArrayOfByte);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
            break label1235;
          }
          paramArrayOfByte = "1";
          anot.a((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_more_tribe", 0, 0, paramArrayOfByte, "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.mListView == null) {
          break label1242;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.bJ((List)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.mTitleView.setText(acfp.m(2131708890) + k + ")");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label1280;
        }
        localObject1 = (nearby.FansInfo)localCmd0x1RspBody.FansInfo_fans.get();
        k = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
        m = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
        localObject1 = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
        this.VN.setText(acfp.m(2131708892) + k + acfp.m(2131708914));
        this.qB.setText(acfp.m(2131708893) + m + acfp.m(2131708814));
        this.ln.setOnClickListener(new akfg(this, paramArrayOfByte));
        this.lo.setOnClickListener(new akfh(this, (String)localObject1));
        if ((!localCmd0x1RspBody.rpt_FeedInfo_feeds.has()) || (localCmd0x1RspBody.rpt_FeedInfo_feeds.get().size() <= 0)) {
          break;
        }
        localObject2 = localCmd0x1RspBody.rpt_FeedInfo_feeds.get();
        m = ((List)localObject2).size();
        if (((List)localObject2).size() <= 0) {
          break label1327;
        }
        k = 0;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          paramArrayOfByte = URLDrawable.getDrawable("" + ((nearby.FeedInfo)((List)localObject2).get(k)).bytes_pic.get().toStringUtf8(), paramArrayOfByte);
          localObject3 = this.jdField_c_of_type_ArrayOfComTencentImageURLImageView[k];
          localObject1 = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            localObject1 = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166111));
          }
          ((URLImageView)localObject3).setImageDrawable((Drawable)localObject1);
          this.jdField_c_of_type_ArrayOfComTencentImageURLImageView[k].setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_c_of_type_ArrayOfComTencentImageURLImageView[k].setBackgroundColor(0);
          k += 1;
        }
        catch (Exception paramArrayOfByte)
        {
          boolean bool;
          Object localObject2;
          Object localObject3;
          QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label1040;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
        this.lo.setVisibility(8);
        this.ln.setVisibility(8);
        this.ll.setVisibility(8);
        this.jA.setVisibility(8);
        this.lk.setVisibility(8);
        return;
      }
      if ((k < m) && (k < 3))
      {
        paramArrayOfByte = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfByte.mLoadingDrawable = paramArrayOfByte.mFailedDrawable;
        paramArrayOfByte.mRequestWidth = ((int)(SavorTagImg.mc[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity));
        paramArrayOfByte.mRequestHeight = ((int)(SavorTagImg.mc[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity));
        if (!TextUtils.isEmpty(((nearby.FeedInfo)((List)localObject2).get(k)).bytes_pic.get().toStringUtf8())) {}
        for (;;)
        {
          bool = false;
          break;
          bool = false;
          break label181;
          InterestTagInfo localInterestTagInfo = new InterestTagInfo();
          localInterestTagInfo.tagName = ((nearby.BarInfo)localObject3).bytes_bar_name.get().toStringUtf8();
          localInterestTagInfo.tagIconUrl = ((nearby.BarInfo)localObject3).bytes_bar_pic.get().toStringUtf8();
          localInterestTagInfo.tagJumpUrl = ((nearby.BarInfo)localObject3).bytes_bar_url.get().toStringUtf8();
          localInterestTagInfo.tagType = 10;
          ((ArrayList)localObject2).add(localInterestTagInfo);
          break label349;
          this.lk.setVisibility(8);
          break label379;
          if (!QLog.isColorLevel()) {
            break label412;
          }
          QLog.w("NearbyProfileDisplayTribePanel", 2, "buluo num > 12 but the list's size < 12??? buluoNum:" + k + "   list.Size:" + ((ArrayList)localObject2).size());
          break label412;
          paramArrayOfByte = "2";
          break label478;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a(acfp.m(2131708848), 10, (List)localObject2, new akff(this, (String)localObject1));
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
          break label529;
          this.lo.setVisibility(8);
          this.ln.setVisibility(8);
          this.lo.setVisibility(8);
          break label746;
          paramArrayOfByte = null;
        }
      }
      k = 2;
      while ((k >= m) && (k >= 0))
      {
        this.jdField_c_of_type_ArrayOfComTencentImageURLImageView[k].setVisibility(8);
        k -= 1;
      }
      this.ll.setVisibility(0);
      this.jA.setVisibility(0);
      k = m;
      paramArrayOfByte = new akfi(this, localCmd0x1RspBody.bytes_feeds_url.get().toStringUtf8());
      this.ll.setOnClickListener(paramArrayOfByte);
      this.jA.setOnClickListener(paramArrayOfByte);
      if (this.jA.getVisibility() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
          break label1608;
        }
        paramArrayOfByte = "1";
        anot.a((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_pub", 0, 0, paramArrayOfByte, "", "" + k, "");
      }
    } while (this.lk.getVisibility() != 0);
    label529:
    label1086:
    label1092:
    label1098:
    label1235:
    label1242:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label1040:
    label1173:
    label1185:
    label1327:
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {}
    label1280:
    label1444:
    for (paramArrayOfByte = "1";; paramArrayOfByte = "2")
    {
      anot.a((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_tribe", 0, 0, paramArrayOfByte, "", "", "");
      return;
      k = 0;
      while (k < 3)
      {
        this.jdField_c_of_type_ArrayOfComTencentImageURLImageView[k].setVisibility(8);
        k += 1;
      }
      this.ll.setVisibility(8);
      this.jA.setVisibility(8);
      k = 0;
      break;
      label1608:
      paramArrayOfByte = "2";
      break label1444;
    }
  }
  
  public void c(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  public void cB(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish, url = " + paramString + ", isSuccess = " + paramBoolean);
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
      QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
      return;
    }
    label129:
    QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
  }
  
  protected void cG(View paramView)
  {
    this.Fh = paramView;
    this.ln = ((RelativeLayout)this.Fh.findViewById(2131370195));
    this.lo = ((RelativeLayout)this.Fh.findViewById(2131370198));
    this.jA = ((LinearLayout)this.Fh.findViewById(2131370231));
    this.VL = ((TextView)this.Fh.findViewById(2131379572));
    this.VM = ((TextView)this.Fh.findViewById(2131379508));
    this.VN = ((TextView)this.Fh.findViewById(2131379470));
    this.qB = ((TextView)this.Fh.findViewById(2131379473));
    this.Vz = ((TextView)this.Fh.findViewById(2131381138));
    this.ll = ((RelativeLayout)this.Fh.findViewById(2131370230));
    this.lm = ((RelativeLayout)this.Fh.findViewById(2131370309));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.dmG = paramView.getDimensionPixelSize(2131297795);
    this.dmH = paramView.getDimensionPixelSize(2131297794);
    this.jD = ((LinearLayout)this.Fh.findViewById(2131382049));
    this.P = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.lm).a(21).c(30).a();
    this.jdField_c_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[] { (URLImageView)this.Fh.findViewById(2131369046), (URLImageView)this.Fh.findViewById(2131369047), (URLImageView)this.Fh.findViewById(2131369048) };
    this.Bx = ((ImageView)this.Fh.findViewById(2131369091));
    this.VC = ((TextView)this.Fh.findViewById(2131381146));
    this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.Fh.findViewById(2131382077));
    if (this.csb) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.Fh.findViewById(2131368498));
    this.l = ((BounceScrollView)this.Fh.findViewById(2131363709));
    this.VF = ((TextView)this.Fh.findViewById(2131379448));
    this.VG = ((TextView)this.Fh.findViewById(2131379494));
    this.VH = ((TextView)this.Fh.findViewById(2131379447));
    this.VI = ((TextView)this.Fh.findViewById(2131382394));
    this.Od = ((TextView)this.Fh.findViewById(2131379514));
    this.VJ = ((TextView)this.Fh.findViewById(2131379510));
    this.VK = ((TextView)this.Fh.findViewById(2131379509));
    this.ha = ((RelativeLayout)this.Fh.findViewById(2131370237));
    this.lh = ((RelativeLayout)this.Fh.findViewById(2131370181));
    this.li = ((RelativeLayout)this.Fh.findViewById(2131370224));
    this.lj = ((RelativeLayout)this.Fh.findViewById(2131370177));
    this.lf = ((RelativeLayout)this.Fh.findViewById(2131365914));
    this.VD = ((TextView)this.Fh.findViewById(2131379445));
    this.qi = this.Fh.findViewById(2131377496);
    this.tO = ((TextView)this.Fh.findViewById(2131369627));
    this.tM = ((TextView)this.Fh.findViewById(2131369579));
    this.tP = ((TextView)this.Fh.findViewById(2131369612));
    this.Bw = ((ImageView)this.Fh.findViewById(2131369603));
    this.bu = ((URLImageView)this.Fh.findViewById(2131369094));
    this.bu.setColorFilter(436207616);
    this.jdField_d_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.Fh.findViewById(2131369113));
    this.BF = ((ImageView)this.Fh.findViewById(2131369114));
    this.BG = ((ImageView)this.Fh.findViewById(2131369103));
    this.BH = ((ImageView)this.Fh.findViewById(2131369104));
    if (this.csb)
    {
      paramView = this.Fh.findViewById(2131381446);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_f_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.Fh.findViewById(2131379866));
    this.jv = ((LinearLayout)this.Fh.findViewById(2131363644));
    this.Fi = this.Fh.findViewById(2131363706);
    paramView = (ImageView)this.Fi.findViewById(2131372478);
    Object localObject = (ImageView)this.Fi.findViewById(2131381565);
    ImageView localImageView = (ImageView)this.Fi.findViewById(2131370437);
    aker localaker = new aker(this, paramView, (ImageView)localObject, localImageView);
    paramView.setOnClickListener(localaker);
    ((ImageView)localObject).setOnClickListener(localaker);
    localImageView.setOnClickListener(localaker);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130846473);
      ((ImageView)localObject).setImageResource(2130846475);
      localImageView.setImageResource(2130846471);
      this.Fi.setBackgroundColor(0);
    }
    this.jy = ((LinearLayout)this.Fh.findViewById(2131368638));
    this.lg = ((RelativeLayout)this.Fh.findViewById(2131370236));
    this.VE = ((TextView)this.Fh.findViewById(2131379513));
    this.gT = ((Button)this.Fh.findViewById(2131363851));
    paramView = (RelativeLayout)this.Fh.findViewById(2131372389);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null)) {
      paramView.setBackgroundResource(2130846430);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.Fh.findViewById(2131363210));
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      paramView.addRule(12);
      paramView.bottomMargin = rpq.dip2px(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 28.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams(paramView);
      this.le = ((RelativeLayout)this.Fh.findViewById(2131377499));
      this.jz = ((LinearLayout)this.Fh.findViewById(2131380167));
      this.jw = ((LinearLayout)this.Fh.findViewById(2131370757));
      this.Fk = this.Fh.findViewById(2131377446);
      this.BA = ((ImageView)this.Fh.findViewById(2131369102));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
      {
        this.lm.setVisibility(8);
        this.ll.setVisibility(8);
        this.lg.setVisibility(8);
        this.jA.setVisibility(8);
      }
      paramView = (LinearLayout.LayoutParams)((RelativeLayout)this.Fh.findViewById(2131377428)).getLayoutParams();
      if (paramView != null) {
        paramView.height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt;
      }
      this.jdField_d_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845961));
      this.jdField_f_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      this.l.setVerticalScrollBarEnabled(false);
      this.l.mScrollFlag = 1;
      this.l.setOnScrollChangedListener(this);
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
      this.tM.setOnClickListener(new akez(this));
      this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      this.jB = ((LinearLayout)this.Fh.findViewById(2131370287));
      this.jE = ((LinearLayout)this.Fh.findViewById(2131370964));
      this.jE.setOnClickListener(new akfd(this));
      this.nO = ((TextView)this.Fh.findViewById(2131380666));
      this.jdField_a_of_type_Ajrf = new ajrf(this.mContext, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      this.jdField_a_of_type_Ajrf.J(this.nO);
      return;
      paramView.setBackgroundResource(2130846429);
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
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.csb))
    {
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_b_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label132;
        }
        label73:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, false, false, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
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
      label132:
      bool2 = false;
      break label73;
      this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
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
          break label702;
        }
        localButton = (Button)this.jv.getChildAt(1).findViewById(2131381048);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167335));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839524));
      }
    }
    for (;;)
    {
      if ((this.jv.getChildAt(1).getVisibility() != 0) && (this.jv.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jv.getChildAt(0).findViewById(2131381048);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167335));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839524));
      }
      return;
      this.jv.setVisibility(8);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 42) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa == 14) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 86) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 87) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 88) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 79) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 89)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()))
        {
          iW(0, 36);
          label441:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
            break label608;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa != 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf != null) || (arJ())) {
            break label565;
          }
          this.jv.getChildAt(2).setVisibility(8);
        }
      }
      for (;;)
      {
        iW(1, 60);
        break;
        iW(2, 40);
        break label441;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
        {
          this.jv.getChildAt(0).setVisibility(8);
          break label441;
        }
        this.jv.getChildAt(2).setVisibility(8);
        break label441;
        label565:
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.csa))
        {
          iW(2, 8);
        }
        else
        {
          this.jv.getChildAt(2).setVisibility(8);
          continue;
          label608:
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf == null) && (!arJ())) {
            this.jv.getChildAt(0).setVisibility(8);
          } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.csa)) {
            iW(0, 8);
          } else {
            this.jv.getChildAt(0).setVisibility(8);
          }
        }
      }
      label702:
      ((Button)this.jv.getChildAt(1).findViewById(2131381048)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839564));
    }
  }
  
  public void dAL()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(0);
      if (this.jdField_a_of_type_Akef$a == null)
      {
        this.jdField_a_of_type_Akef$a = new akef.a(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_Akef$a);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz)
      {
        this.jdField_a_of_type_Akef$a.lG(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
          break label207;
        }
      }
    }
    label207:
    for (Object localObject = "2";; localObject = "1")
    {
      anot.a(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject, "", "", "");
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)) {
        break;
      }
      localObject = new PicInfo();
      ((PicInfo)localObject).videoUrl = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      this.jdField_a_of_type_Akef$a.lG(localArrayList);
      break;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(8);
      break;
    }
  }
  
  public void dAM()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bTd)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.crz)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmx, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bTd, false);
    }
  }
  
  void dAY()
  {
    this.gT.setOnClickListener(this);
  }
  
  public void dBa()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentUin())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.getVersion());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    jnm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new akfc(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 1000: 
    case 11000: 
    case 1018: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
        } while (paramIntent == null);
        return;
      } while (paramInt2 != -1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa = 25;
      dAK();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "NearbyPeopleProfileActivity->doOnActivityResult, resultCode=" + paramInt2);
    }
    if (NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
      paramInt1 = 510;
    }
    for (;;)
    {
      paramIntent = (ajrs)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(60);
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
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          }
          long l1 = 0L;
        }
      }
    }
  }
  
  public void doOnDestory()
  {
    if (this.hv != null)
    {
      aqdj localaqdj = (aqdj)this.hv.get();
      if (localaqdj != null) {
        localaqdj.cancel();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().xX != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().xX.clear();
    }
    this.jdField_a_of_type_Ajrf.onDestroy();
  }
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
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
    if (this.jdField_f_of_type_Auru.hasMessages(1))
    {
      this.jdField_f_of_type_Auru.removeMessages(1);
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
  
  void gO(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.videoUrl = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.bSZ = paramString1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mRequestWidth = wja.dp2px(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mRequestHeight = wja.dp2px(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mFailedDrawable = aqhu.at();
      paramString1.mLoadingDrawable = aqhu.at();
      paramString1.mMemoryCacheKeySuffix = "NearbyVideoRoundIcon";
      paramString1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.bSZ, paramString1);
      paramString1.setDecodeHandler(aqbn.b);
      if (paramString1.getStatus() != 1) {
        paramString1.restartDownload();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561477;
  }
  
  public void iV(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        this.jdField_d_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
        this.BF.setVisibility(8);
        this.BG.setVisibility(8);
        this.BH.setVisibility(8);
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
          if (this.jdField_a_of_type_Akef$a != null) {
            this.jdField_a_of_type_Akef$a.lG(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.yi);
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
        QLog.i("NearbyProfileDisplayTribePanel", 2, "click  data.nType= [" + ((albb)localObject1).nType + "]");
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
            break label418;
          }
          localObject1 = "";
          label334:
          ((Intent)localObject2).putExtra("url", (String)localObject1);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        label354:
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e)), "", "", "");
        continue;
        label418:
        localObject1 = ((alck)localObject1).strJumpUrl;
        break label334;
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
            break label949;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.bTi, "1", "", "");
          break;
        }
        label949:
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
        label1156:
        label1249:
        label1254:
        String str1;
        if (this.csc)
        {
          localObject1 = "clk_followed";
          anot.a(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
          ((ajpj)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(106)).go.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          bool = NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
          if (!bool) {
            break label1315;
          }
          localObject1 = "1";
          if (!bool) {
            break label1338;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          if (!this.csc) {
            break label1351;
          }
        }
        label1315:
        label1338:
        label1351:
        for (localObject2 = "2";; localObject2 = "1")
        {
          acig.a((QQAppInterface)localObject3, str1, (String)localObject1, (String)localObject2, 1, new akep(this));
          break;
          localObject1 = "clk_follow";
          break label1156;
          if (this.csa)
          {
            localObject1 = "6";
            break label1249;
          }
          localObject1 = "2";
          break label1249;
          if (this.csa) {
            break label1254;
          }
          break label1254;
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
        if ((this.csd) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.tribeAppDownload", 2, "sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen + ", sendMsgBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl))) {
            ajpj.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 1);
          }
          for (;;)
          {
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_fail", 0, 0, "", "", "", "");
            break;
            if (!TextUtils.isEmpty(this.bTe)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.bTe, 0).show(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
          }
        }
        anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
        this.crQ = true;
        bOF();
        anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        int k = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null)) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;; localObject1 = "")
        {
          anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X8004826", "0X8004826", k, 0, (String)localObject1, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.pa == 76)) {
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
          }
          NearbyPeopleProfileActivity.dmy = 0;
          if (!ProfileActivity.gg(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)) {
            break label2005;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          break;
        }
        label2005:
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
          k = 8;
          label2312:
          m = k;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2402;
            }
          }
        }
        label2402:
        for (int m = 1;; m = 2)
        {
          m = k | m;
          ((ajrs)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), m, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.cf);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(204, 1000L);
          break;
          k = 4;
          break label2312;
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
            aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701077), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131701076), 0, 2131701539, new akeq(this), null).show();
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
                k = 0;
                label3327:
                localObject2 = new Bundle();
                ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
                ((Bundle)localObject2).putLong("totalVoters", k);
                ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject2).putBoolean("votersOnly", true);
                if (k <= 0) {
                  break label3700;
                }
              }
              label3700:
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
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileDisplayTribePanel.20(this));
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
                k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break label3327;
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
            QLog.i("NearbyProfileDisplayTribePanel", 2, "mCard is null,vote failed !");
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayTribePanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          label4031:
          label4053:
          int n;
          label4158:
          label4305:
          String str2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            k = 1;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label4552;
            }
            m = 1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyLikeLimitManager", 2, "Profile->onClickVote, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + ", isFriend=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend + ", bAvailVoteCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ", bHaveVotedCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            }
            if (!NearbyPeopleProfileActivity.kI(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
              break label4557;
            }
            n = 510;
            if ((k != 0) || (m != 0)) {
              break label4736;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c == null) || (!aqiw.isNetSupport(BaseApplication.getContext()))) {
              break label4578;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
              break label4565;
            }
            ((ajqh)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(207)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new akes(this), n + "");
            label4261:
            str1 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
              break label4712;
            }
            localObject1 = "2";
            str2 = n + "";
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
              break label4720;
            }
            localObject2 = "1";
            label4343:
            if (!this.csi) {
              break label4728;
            }
          }
          label4552:
          label4557:
          label4565:
          label4578:
          label4712:
          label4720:
          label4728:
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
              break label5100;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            break;
            k = 0;
            break label4031;
            m = 0;
            break label4053;
            n = 509;
            break label4158;
            MN(true);
            this.csi = true;
            break label4261;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c != null)
            {
              ((HashMap)localObject2).put("param_FailCode", "-203");
              anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject2, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131721956));
              break label4261;
            }
            ((HashMap)localObject2).put("param_FailCode", "-204");
            anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showToast(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694933));
            break label4261;
            localObject1 = "1";
            break label4305;
            localObject2 = "2";
            break label4343;
          }
          label4736:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
          {
            localObject1 = acfp.m(2131708904);
            label4754:
            if (!this.csf)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
                break label4964;
              }
              localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, acfp.m(2131708920), "", acfp.m(2131708864), new aket(this), null);
              label4808:
              ((Dialog)localObject1).show();
              this.csf = true;
              ((Dialog)localObject1).setOnDismissListener(new akew(this));
            }
            anot.a(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (m == 0) {
              break label5041;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), "", "", "");
          }
          for (;;)
          {
            anpc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            break;
            localObject1 = acfp.m(2131708822);
            break label4754;
            label4964:
            localObject1 = aqha.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, acfp.m(2131708807) + (String)localObject1 + acfp.m(2131708894), acfp.m(2131708856), acfp.m(2131708880), new akeu(this), new akev(this));
            break label4808;
            label5041:
            if (k != 0) {
              anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa)), "", "", "");
            }
          }
          label5100:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          continue;
        }
        if (paramView == this.jdField_d_of_type_ComTencentWidgetCustomImgView)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
          {
            localObject1 = (Boolean)paramView.getTag();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.ko(100L);
            if ((localObject1 != null) && (!((Boolean)localObject1).booleanValue())) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileDisplayTribePanel.26(this), 300L);
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
          }
          while (ProfileActivity.gg(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.bJa))
          {
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
            {
              localObject1 = new PicInfo();
              ((PicInfo)localObject1).localPath = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCustomFaceFilePath(32, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 200);
              if (QLog.isColorLevel()) {
                QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " local path is: " + ((PicInfo)localObject1).localPath);
              }
              localObject2 = sxx.getViewRect(paramView);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a((PicInfo)localObject1, (Rect)localObject2);
            }
          }
        }
        if (paramView == this.lf)
        {
          this.csl = true;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
          {
            localObject1 = ajri.encode(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e.uin);
            localObject1 = "https://buluo.qq.com/mobile/my_heart.html?from=zlk" + "&strangerUin=" + (String)localObject1;
            this.crN = true;
            label5519:
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
              break label5728;
            }
            localObject2 = "2";
            label5535:
            anot.a(null, "dc00899", "grp_lbs", "", "rank_data", "clk_rank", 0, 0, (String)localObject2, "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
              break label5736;
            }
          }
          label5728:
          label5736:
          for (localObject2 = "2";; localObject2 = "1")
          {
            anot.a(null, "dc00899", "grp_lbs", "", "data_card", "clk_rank", 0, 0, (String)localObject2, "", "", "");
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
              break label5744;
            }
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
              this.crN = true;
            }
            localObject1 = "https://buluo.qq.com/mobile/my_heart.html?from=zlk";
            break label5519;
            localObject2 = "1";
            break label5535;
          }
          label5744:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 3) {
            continue;
          }
          anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
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
            k = 0;
            label5859:
            if (!bool) {
              break label5942;
            }
          }
          for (;;)
          {
            localObject1 = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(k), localObject1 });
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("portraitOnly", true);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
            break;
            k = 1;
            break label5859;
            label5942:
            localObject1 = "";
          }
        }
        if (paramView == this.gT)
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
        if ((paramView == this.jB) || (paramView != this.jC)) {
          continue;
        }
      }
      catch (SecurityException localSecurityException)
      {
        break label354;
      }
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.dmt - 150.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity;
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 > paramInt4) && (paramInt2 >= f1) && (this.le.getVisibility() == 8)) {
      localObject1 = this.aL;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.le.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.le.startAnimation((Animation)localObject1);
        this.jdField_f_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (paramInt2 < paramInt4)
      {
        localObject1 = localObject2;
        if (paramInt2 <= f1)
        {
          localObject1 = localObject2;
          if (this.le.getVisibility() == 0) {
            localObject1 = this.aM;
          }
        }
      }
    }
  }
  
  public void w(float paramFloat1, float paramFloat2)
  {
    RN(this.dmL);
    if (!this.csk)
    {
      k = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (k == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon == null) {
          break label173;
        }
        k = 0;
        if (k >= 4) {
          break label173;
        }
        if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[k].arQ()) {
          break label157;
        }
      }
    }
    label157:
    label173:
    for (int k = 1;; k = 0)
    {
      int n = k;
      int m;
      if (k == 0)
      {
        n = k;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg != null) {
          m = 0;
        }
      }
      for (;;)
      {
        n = k;
        if (m < 3)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[m].arQ()) {
            n = 1;
          }
        }
        else
        {
          if (n != 0)
          {
            this.csk = true;
            anot.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
          }
          return;
          k += 1;
          break;
        }
        m += 1;
      }
    }
  }
  
  public class a
    extends AvatarWallPagerAdapter<PicInfo>
  {
    protected LinearLayout.LayoutParams f;
    
    public a(AvatarWallViewPager paramAvatarWallViewPager)
    {
      super();
    }
    
    public View a(boolean paramBoolean, int paramInt)
    {
      View localView = new View(akef.this.a);
      if (this.f == null)
      {
        paramInt = rpq.dip2px(akef.this.a, 5.0F);
        this.f = new LinearLayout.LayoutParams(paramInt, paramInt);
        paramInt = rpq.dip2px(akef.this.a, 4.0F);
        this.f.leftMargin = (paramInt / 2);
        this.f.rightMargin = (paramInt / 2);
      }
      if (paramBoolean) {}
      for (Drawable localDrawable = apuh.a(akef.this.a.getResources(), Color.parseColor("#CC12B7F5"), akef.this.a.getResources().getDrawable(2130844522));; localDrawable = apuh.a(akef.this.a.getResources(), Color.parseColor("#66FFFFFF"), akef.this.a.getResources().getDrawable(2130844522)))
      {
        localView.setLayoutParams(this.f);
        localView.setBackgroundDrawable(localDrawable);
        return localView;
      }
    }
    
    public View b(int paramInt, PicInfo paramPicInfo)
    {
      return akef.this.a(paramInt, paramPicInfo);
    }
    
    public boolean b(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
    {
      return akef.this.a.a(paramPicInfo1, paramPicInfo2);
    }
    
    public void w(int paramInt, View paramView)
    {
      akef.this.me.values().remove(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akef
 * JD-Core Version:    0.7.0.1
 */