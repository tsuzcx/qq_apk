package cooperation.qzone.share;

import acci;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anpc;
import aofr;
import aofw;
import aqha;
import aqiw;
import aqju;
import aqmr;
import aqnm;
import arhz;
import avpw;
import avqq;
import avzs;
import avzt;
import avzv;
import avzw;
import avzx;
import avzy;
import avzz;
import awaa;
import awab;
import awac;
import awad;
import awaf;
import awag;
import awah;
import awai;
import awdb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.AgentActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import eipc.EIPCClient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import rwt;
import svi;

public class QZoneShareActivity
  extends IphoneTitleBarActivity
{
  public static final Object dZ = new Object();
  public static final String simpleClassname = QZoneShareActivity.class.getSimpleName();
  private int HJ;
  private int HP = -1;
  private int HQ = -1;
  private int Hi = 1;
  private int Hj = 1;
  private arhz jdField_a_of_type_Arhz;
  public GetAppInfoProto.GetAppinfoResponse a;
  private QZoneShareData jdField_a_of_type_CooperationQzoneQZoneShareData;
  public long aaE;
  protected TextView agx;
  private TextView agy;
  private TextView agz;
  public EditText bK;
  private String cOB;
  private URLImageView cg;
  public boolean chl;
  private FrameLayout cy;
  protected InputMethodManager d;
  protected SystemEmoticonPanel d;
  protected View dg;
  protected ImageView dg;
  public List<avzs> dg;
  protected View dh;
  public View dj;
  private boolean dpA;
  private boolean dpB;
  private boolean dpC = true;
  public boolean dpy;
  public boolean dpz = true;
  private RelativeLayout dw;
  protected BusinessObserver e = new awaa(this);
  private int ezA;
  private String mSummary;
  private String mThumbUrl;
  private String mTitle;
  RelativeLayout nM;
  private boolean needShareCallback;
  public int oO;
  public boolean rY;
  public boolean rZ;
  BroadcastReceiver receiver = new awac(this);
  public boolean sa;
  protected boolean sb;
  protected boolean sn;
  private String ve = "";
  
  private void Ez()
  {
    this.ve = "";
    this.HP = -1;
    this.HQ = -1;
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    return avzt.a(paramCharSequence, paramInt, this.ezA, this.jdField_dg_of_type_JavaUtilList, this.HP, this.HQ, this.ve);
  }
  
  private void a(Activity paramActivity, QZoneShareData paramQZoneShareData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramQZoneShareData == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramQZoneShareData.action)) {
      paramQZoneShareData.action = "shareToQzone";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramQZoneShareData.appid + " action=" + paramQZoneShareData.action);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramQZoneShareData.appid), paramQZoneShareData.action })));
    }
    for (;;)
    {
      localIntent.setPackage(paramQZoneShareData.pkgname);
      avpw.ay(localIntent);
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        QLog.e("QZoneShare", 1, paramActivity.getStackTrace());
        return;
      }
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramQZoneShareData.appid), paramQZoneShareData.action })));
    }
  }
  
  private void a(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    this.aaE = System.currentTimeMillis();
    this.chl = true;
    long l = System.currentTimeMillis() / 1000L;
    String str = AgentActivity.q(this, paramString, l + "");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "-->sdk_share, getting appinfo in construct. sign: " + str);
    }
    svi.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l, this.e, paramString);
  }
  
  private void a(QZoneShareData paramQZoneShareData)
  {
    if ((paramQZoneShareData != null) && (paramQZoneShareData.azQ > 0L))
    {
      localHashMap = new HashMap();
      localHashMap.put("url", paramQZoneShareData.targetUrl);
      localHashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - paramQZoneShareData.azQ));
      localHashMap.put("time_interval", String.valueOf((System.currentTimeMillis() - paramQZoneShareData.azQ) / 100L));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "timecost:" + (System.currentTimeMillis() - paramQZoneShareData.azQ));
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(this.cOB, "qzonesharetimecost", true, 0L, 0L, localHashMap, null, true);
    }
    while (!QLog.isColorLevel())
    {
      HashMap localHashMap;
      return;
    }
    QLog.d("QZoneShare", 2, "timecost: -1");
  }
  
  public static String b(EditText paramEditText)
  {
    if (paramEditText == null) {
      return "";
    }
    paramEditText = paramEditText.getText();
    if ((paramEditText instanceof aofr)) {
      return ((aofr)paramEditText).AE();
    }
    return paramEditText.toString();
  }
  
  private void dz(boolean paramBoolean)
  {
    if ((this.sn) && (!paramBoolean))
    {
      this.dj.setVisibility(4);
      return;
    }
    this.dj.setVisibility(0);
  }
  
  private void eAk()
  {
    eCT();
    if (!aqiw.isNetSupport(this))
    {
      rwt.ez(1, 2131696272);
      return;
    }
    ThreadManager.postImmediately(new QZoneShareActivity.7(this), null, true);
  }
  
  private void eCT()
  {
    Bundle localBundle;
    if (this.dpA)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.dpB) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "success");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.needShareCallback) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  private void eCU()
  {
    Bundle localBundle;
    if (this.dpA)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.dpB) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "fail");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.needShareCallback) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  private void eCV()
  {
    Object localObject;
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null)
    {
      if ((this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.size() > 0))
      {
        localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            this.mThumbUrl = str;
          }
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.mTitle)) {
        break label294;
      }
      localObject = null;
      this.mTitle = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.mSummary)) {
        break label308;
      }
      localObject = null;
      label107:
      this.mSummary = ((String)localObject);
      if ((!TextUtils.isEmpty(this.mTitle)) && (!TextUtils.isEmpty(this.mSummary)))
      {
        if (!this.mTitle.equals(this.mSummary)) {
          break label322;
        }
        this.mSummary = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "params: " + this.jdField_a_of_type_CooperationQzoneQZoneShareData.toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.cMZ)) {
        this.bK.setText(this.jdField_a_of_type_CooperationQzoneQZoneShareData.cMZ);
      }
      b(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      a(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      if ((this.app != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.appid > 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.pkgname))) {
        a(this.app, this.jdField_a_of_type_CooperationQzoneQZoneShareData.appid, this.jdField_a_of_type_CooperationQzoneQZoneShareData.pkgname);
      }
      return;
      label294:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.mTitle.trim();
      break;
      label308:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.mSummary.trim();
      break label107;
      label322:
      if (this.mTitle.length() > 20)
      {
        localObject = this.mTitle.substring(0, 20);
        if (this.mSummary.startsWith((String)localObject)) {
          this.mSummary = null;
        }
      }
    }
  }
  
  private void eCW()
  {
    String str2 = this.mTitle;
    String str1 = str2;
    if (str2 != null) {
      str1 = this.mTitle.replace("[em]e10086[/em]", "");
    }
    this.agy.setText(str1);
  }
  
  private void eCX()
  {
    Object localObject = getResources().getDrawable(2130848705);
    if (!TextUtils.isEmpty(this.mThumbUrl))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestHeight = aqnm.dpToPx(70.0F);
      localURLDrawableOptions.mRequestWidth = aqnm.dpToPx(70.0F);
      if (isValidUrl(this.mThumbUrl)) {}
      for (localObject = URLDrawable.getDrawable(this.mThumbUrl, localURLDrawableOptions);; localObject = URLDrawable.getDrawable(new File(this.mThumbUrl), localURLDrawableOptions))
      {
        this.cg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cg.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    this.cg.setBackgroundDrawable((Drawable)localObject);
  }
  
  public static String filterText(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  private boolean i(String paramString, boolean paramBoolean)
  {
    return avzt.a(paramString, paramBoolean, this.jdField_dg_of_type_JavaUtilList, this.HP, this.HQ, this.ve);
  }
  
  private void initData()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_CooperationQzoneQZoneShareData = ((QZoneShareData)localIntent.getParcelableExtra("extraIntentKeyParcelable"));
    this.dpA = localIntent.getBooleanExtra("isSharedFromMiniProgram", false);
    this.cOB = localIntent.getStringExtra("qzone_uin");
    if (TextUtils.isEmpty(this.cOB)) {
      this.cOB = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (this.dpA)
    {
      am(2131720190);
      boolean bool = localIntent.getBooleanExtra("isSharedFromThirdParty", false);
      String str1 = localIntent.getStringExtra("miniShareParamAppId");
      String str2 = localIntent.getStringExtra("miniShareParamTitle");
      String str3 = localIntent.getStringExtra("miniShareParamDescription");
      int i = localIntent.getIntExtra("miniShareParamShareScene", 1);
      int j = localIntent.getIntExtra("miniShareParamTemplateType", 1);
      int k = localIntent.getIntExtra("miniShareParamBusinessType", 0);
      String str4 = localIntent.getStringExtra("miniShareParamPicUrl");
      String str5 = localIntent.getStringExtra("miniShareParamJumpUrl");
      String str6 = localIntent.getStringExtra("miniShareParamIconUrl");
      int m = localIntent.getIntExtra("miniShareParamVersionType", -1);
      String str7 = localIntent.getStringExtra("miniShareParamVersionId");
      String str8 = localIntent.getStringExtra("miniShareAppRichId");
      Object localObject = localIntent.getStringExtra("miniSharePkgName");
      String str9 = localIntent.getStringExtra("miniShareOpenId");
      this.dpB = localIntent.getBooleanExtra("miniShareIsFromInnerButton", false);
      this.jdField_a_of_type_CooperationQzoneQZoneShareData = new QZoneShareData();
      this.jdField_a_of_type_CooperationQzoneQZoneShareData.mTitle = str2;
      if (str8 != null) {}
      try
      {
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.appid = Long.parseLong(str8);
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.openId = str9;
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.pkgname = ((String)localObject);
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.mSummary = str3;
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER = new ArrayList();
        if (!aqmr.isEmpty(str4))
        {
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.add(str4);
          if (bool) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.from = 1;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.xcxMapEx = new HashMap();
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.xcxMapEx.put("xcxPath", str5);
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.xcxMapEx.put("xcxAppId", str1);
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.xcxMapEx.put("xcxSourceType", String.valueOf(k));
          localObject = new awad(this);
          if (!TextUtils.isEmpty(str6)) {
            break label532;
          }
          MiniAppCmdUtil.getInstance().getAppInfoById(null, str1, str5, String.valueOf(m), new awaf(this, str2, str3, str1, i, j, k, str4, str5, m, str8, (MiniAppCmdInterface)localObject));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("QZoneShare", 1, "Long.parseLong(appRichId) get an Exception", localNumberFormatException);
          continue;
          if (!aqmr.isEmpty(str6)) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.add(str6);
          }
        }
        label532:
        MiniProgramShareUtils.shareAsQzoneFeeds(str1, str2, str3, i, j, k, str4, null, str5, str6, m, str7, str8, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    eCV();
  }
  
  private void initUI()
  {
    setContentView(2131562327);
    setRightButton(2131718203, new awag(this));
    this.dw = ((RelativeLayout)findViewById(2131376103));
    this.bK = ((EditText)findViewById(2131367535));
    this.cy = ((FrameLayout)findViewById(2131367537));
    this.cg = ((URLImageView)findViewById(2131367540));
    this.agy = ((TextView)findViewById(2131367549));
    this.agz = ((TextView)findViewById(2131367545));
    EB();
    this.dh = findViewById(2131375629);
    aeB();
    this.jdField_dg_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375662));
    Es();
    Eq();
    this.agx = ((TextView)findViewById(2131367547));
    this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_dg_of_type_JavaUtilList = new ArrayList();
  }
  
  public static final boolean isValidUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private int k(String paramString, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(BaseApplication.getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(2, paramInt1);
    localTextView.setMaxLines(2);
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    return localTextView.getLineCount();
  }
  
  private void updateData()
  {
    int j = 0;
    int k = 1;
    Object localObject2 = null;
    for (;;)
    {
      int i;
      String str3;
      String str4;
      try
      {
        if (this.jdField_a_of_type_CooperationQzoneQZoneShareData == null) {
          this.jdField_a_of_type_CooperationQzoneQZoneShareData = new QZoneShareData();
        }
        i = this.jdField_a_of_type_CooperationQzoneQZoneShareData.from;
        if (i != 2) {
          return;
        }
        String str1 = LocalMultiProcConfig.getString("msharecururl", "");
        if ((TextUtils.isEmpty(str1)) || (!str1.equals(this.jdField_a_of_type_CooperationQzoneQZoneShareData.cNa))) {
          continue;
        }
        str3 = LocalMultiProcConfig.getString("msharetitle", "");
        str1 = LocalMultiProcConfig.getString("msharedesc", "");
        str4 = LocalMultiProcConfig.getString("msharethumb", "");
        String str5 = LocalMultiProcConfig.getString("mshareurl", "");
        int m = LocalMultiProcConfig.getInt("msharefrom", -1);
        if (TextUtils.isEmpty(str3))
        {
          str3 = null;
          if (!TextUtils.isEmpty(str1)) {
            break label396;
          }
          str1 = null;
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1))) {
            break label458;
          }
          if (!str3.equals(str1)) {
            break label406;
          }
          i = j;
          if (!TextUtils.isEmpty(str3))
          {
            i = j;
            if (!str3.equals(this.mTitle))
            {
              this.mTitle = str3;
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.mTitle = str3;
              i = 1;
            }
          }
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            j = i;
            if (!((String)localObject2).equals(this.mSummary))
            {
              this.mSummary = ((String)localObject2);
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.mSummary = ((String)localObject2);
              j = 1;
            }
          }
          if ((TextUtils.isEmpty(str4)) || (str4.equals(this.mThumbUrl))) {
            break label453;
          }
          this.mThumbUrl = str4;
          if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER == null) {
            break label435;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.clear();
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.ER.add(str4);
          i = k;
          if ((!TextUtils.isEmpty(str5)) && (!str5.equals(this.jdField_a_of_type_CooperationQzoneQZoneShareData.targetUrl))) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.targetUrl = str5;
          }
          if (i == 0) {
            continue;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.iUrlInfoFrm = m;
          ThreadManager.getUIHandler().post(new QZoneShareActivity.23(this));
          continue;
        }
        str3 = str3.trim();
      }
      finally {}
      continue;
      label396:
      String str2 = localObject1.trim();
      continue;
      label406:
      if (str3.length() > 20)
      {
        if (str2.startsWith(str3.substring(0, 20))) {
          continue;
        }
        break label458;
        label435:
        new ArrayList().add(str4);
        i = k;
        continue;
        label453:
        i = j;
        continue;
      }
      label458:
      localObject2 = str2;
    }
  }
  
  private void updateLayout()
  {
    Object localObject = getResources().getColorStateList(2131165193);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165195);
    if (TextUtils.isEmpty(this.mTitle))
    {
      this.agy.setVisibility(8);
      this.agz.setVisibility(0);
      if ((TextUtils.isEmpty(this.mSummary)) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null))
      {
        this.agz.setText(this.jdField_a_of_type_CooperationQzoneQZoneShareData.targetUrl);
        if (localObject != null) {
          this.agz.setTextColor((ColorStateList)localObject);
        }
        this.agz.setMaxLines(2);
      }
    }
    for (;;)
    {
      localObject = getResources().getDrawable(2130848705);
      this.cg.setBackgroundDrawable((Drawable)localObject);
      return;
      this.agz.setText(this.mSummary);
      break;
      if (TextUtils.isEmpty(this.mSummary))
      {
        this.agy.setVisibility(0);
        this.agz.setVisibility(8);
        eCW();
        if (localObject != null) {
          this.agy.setTextColor((ColorStateList)localObject);
        }
        this.agy.setMaxLines(2);
      }
      else
      {
        int i = aqnm.getScreenWidth();
        int j = aqnm.dpToPx(24.0F);
        int k = aqnm.dpToPx(24.0F);
        int m = aqnm.dpToPx(80.0F);
        if (k(this.mTitle, 14, i - j - k - m) > 1)
        {
          this.agy.setVisibility(0);
          this.agz.setVisibility(8);
          eCW();
          if (localObject != null) {
            this.agy.setTextColor((ColorStateList)localObject);
          }
          this.agy.setMaxLines(2);
        }
        else
        {
          this.agy.setVisibility(0);
          if (localObject != null) {
            this.agy.setTextColor((ColorStateList)localObject);
          }
          this.agz.setVisibility(0);
          if (localObject != null) {
            this.agz.setTextColor(localColorStateList);
          }
          eCW();
          this.agy.setMaxLines(1);
          this.agz.setText(this.mSummary);
          this.agz.setMaxLines(1);
        }
      }
    }
  }
  
  protected final void EB()
  {
    this.bK.setEditableFactory(aofw.a);
    try
    {
      this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = avzt.a(this, this.bK);
      EC();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void EC()
  {
    Object localObject = y();
    if ((localObject instanceof RelativeLayout))
    {
      localObject = (RelativeLayout)localObject;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.nM = new RelativeLayout(this);
      this.dj = LayoutInflater.from(this).inflate(2131562521, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.dj.setVisibility(4);
      this.nM.addView(this.dj, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.dj.getId());
      this.jdField_dg_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562415, null);
      this.nM.addView(this.jdField_dg_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(150.0F * aqnm.getDensity()));
      localLayoutParams2.addRule(3, this.jdField_dg_of_type_AndroidViewView.getId());
      this.nM.addView(this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams2);
      this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundColor(getResources().getColor(2131166932));
      ((RelativeLayout)localObject).addView(this.nM, localLayoutParams1);
      this.HJ = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new awah(this, (RelativeLayout)localObject));
    }
  }
  
  protected void Eo()
  {
    dy(true);
  }
  
  public void Ep()
  {
    ThreadManager.postImmediately(new QZoneShareActivity.14(this), null, true);
  }
  
  protected void Eq()
  {
    if (this.bK == null) {
      return;
    }
    this.bK.addTextChangedListener(new avzv(this));
    this.bK.setOnTouchListener(new avzw(this));
  }
  
  protected void Es()
  {
    if (this.jdField_dg_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_dg_of_type_AndroidWidgetImageView.setOnClickListener(new avzx(this));
  }
  
  public void Et()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_dg_of_type_AndroidViewView == null) || (this.jdField_dg_of_type_AndroidWidgetImageView == null)) {}
    while (this.sb) {
      return;
    }
    iZ();
    this.bK.requestFocus();
    this.sb = true;
    ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.13(this), 100L);
  }
  
  public final void a(Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    paramQZoneShareData = new avzz(this, paramActivity, paramQZoneShareData);
    aqju localaqju = aqha.a(paramActivity, 230);
    localaqju.setMessage(2131697425);
    localaqju.setTitle(2131693317);
    localaqju.setNegativeButton(2131721058, paramQZoneShareData);
    localaqju.setPositiveButton(2131720034, paramQZoneShareData);
    localaqju.setCancelable(false);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      localaqju.show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("QZoneShare", 1, paramActivity.toString());
    }
  }
  
  protected boolean a(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    for (;;)
    {
      synchronized (dZ)
      {
        if (this.chl)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            am(2131693321);
            dZ.wait(5000L);
            if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QZoneShare", 2, "-->sdk_share, response is null and show result dialog.");
            }
            hideProgressDialog();
            return true;
          }
          catch (InterruptedException paramAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
            continue;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)
      {
        this.chl = true;
        long l = System.currentTimeMillis() / 1000L;
        String str = AgentActivity.q(this, paramString, l + "");
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
        }
        am(2131693321);
        svi.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l, this.e, paramString);
        try
        {
          dZ.wait(5000L);
        }
        catch (InterruptedException paramAppInterface) {}
        if (QLog.isColorLevel()) {
          QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
        }
      }
    }
    int i = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    if ((i == 110507) || (i == 110401))
    {
      ThreadManager.getUIHandler().post(new QZoneShareActivity.18(this));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "-->sdk_share, response ret: " + i + " and show result dialog.");
      }
      hideProgressDialog();
      return false;
    }
    hideProgressDialog();
    return true;
  }
  
  protected void aeB()
  {
    if (this.dh == null) {
      return;
    }
    this.dh.setOnClickListener(new awai(this));
  }
  
  public void am(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.20(this, paramInt));
  }
  
  protected void an(ArrayList<ResultRecord> paramArrayList)
  {
    if (this.bK == null) {
      return;
    }
    if (this.rZ)
    {
      int i = this.bK.getSelectionStart();
      Editable localEditable = this.bK.getEditableText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())) && (localEditable.toString().substring(i - 1, i).equals("@"))) {
        localEditable.delete(i - 1, i);
      }
      this.rZ = false;
    }
    this.ezA = avzt.a(this.bK, paramArrayList, this.jdField_dg_of_type_JavaUtilList, this.ezA);
  }
  
  public void b(QZoneShareData paramQZoneShareData)
  {
    if (paramQZoneShareData == null) {}
    label4:
    Object localObject;
    String str;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while ((paramQZoneShareData.from != 1) || ("login".equals(paramQZoneShareData.cMY)));
          localObject = paramQZoneShareData.cMX;
          str = paramQZoneShareData.openId;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        } while (((String)localObject).equals(this.cOB));
        a(this, paramQZoneShareData);
        return;
      } while (TextUtils.isEmpty(str));
      localObject = new avzy(this, str, paramQZoneShareData);
      localObject = avqq.a(BaseApplicationImpl.getApplication().getRuntime(), String.valueOf(paramQZoneShareData.appid), (acci)localObject);
    } while ((localObject == null) || (((OpenID)localObject).openID == null) || (((OpenID)localObject).openID.equals(str)));
    a(this, paramQZoneShareData);
  }
  
  protected final String cU()
  {
    return avzt.a(this.bK, this.jdField_dg_of_type_JavaUtilList);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
    {
      this.rZ = false;
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    n(paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "doOnCreate()");
    }
    if (getIntent() == null)
    {
      QLog.e("QZoneShare", 1, "onCreate getIntent is null");
      finish();
    }
    getWindow().setSoftInputMode(3);
    initUI();
    initData();
    updateLayout();
    if ((!ImmersiveUtils.dly) && (!isInMultiWindow())) {
      getWindow().getDecorView().post(new QZoneShareActivity.1(this));
    }
    if ((!TextUtils.isEmpty(this.mThumbUrl)) && (!isValidUrl(this.mThumbUrl)) && (getIntent().getBooleanExtra("key_require_storage_permission", false)))
    {
      if (awdb.a(this, new awab(this), 1)) {
        eCX();
      }
      return false;
    }
    eCX();
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        jb();
        return true;
      }
      onBack();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    try
    {
      unregisterReceiver(this.receiver);
      iZ();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QZoneShare", 1, localException, new Object[0]);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.shareupdate");
    registerReceiver(this.receiver, localIntentFilter);
    if (!this.dpy)
    {
      ThreadManager.postImmediately(new QZoneShareActivity.3(this), null, true);
      this.dpy = true;
      return;
    }
    eCX();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.bK != null))
    {
      this.bK.setFocusable(true);
      this.bK.requestFocus();
      ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.15(this), 300L);
    }
  }
  
  public void dy(boolean paramBoolean)
  {
    if (this.bK == null) {
      return;
    }
    n(paramBoolean);
    jb();
  }
  
  protected int fP()
  {
    if (this.oO > 0) {
      return this.oO;
    }
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  public int fQ()
  {
    if (this.bK != null) {
      return filterText(b(this.bK)).length();
    }
    return 0;
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  public void hideProgressDialog()
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.21(this));
  }
  
  protected boolean iZ()
  {
    return n(true);
  }
  
  public boolean jb()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_dg_of_type_AndroidViewView == null) || (this.jdField_dg_of_type_AndroidWidgetImageView == null)) {}
    while (!this.sa) {
      return false;
    }
    this.sa = false;
    this.jdField_d_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_dg_of_type_AndroidViewView.setVisibility(4);
    dz(this.sa);
    this.jdField_dg_of_type_AndroidWidgetImageView.setImageResource(2130849924);
    return true;
  }
  
  protected void n(int paramInt, Intent paramIntent)
  {
    an(paramIntent.getParcelableArrayListExtra("result_set"));
  }
  
  protected boolean n(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.bK == null)) {
      return false;
    }
    if (this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.bK.getWindowToken(), 0))
    {
      if (paramBoolean) {
        this.bK.clearFocus();
      }
      this.sn = true;
      return true;
    }
    return false;
  }
  
  protected void onBack()
  {
    Eo();
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.from == 1) {
      a(this, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    }
    setResult(0, getIntent());
    onBackEvent();
  }
  
  public boolean onBackEvent()
  {
    eCU();
    return super.onBackEvent();
  }
  
  public void showKeyboard()
  {
    if (!this.dpC) {}
    while ((this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.bK == null)) {
      return;
    }
    this.jdField_d_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.bK, 2);
    this.sn = false;
  }
  
  protected View y()
  {
    return this.dw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity
 * JD-Core Version:    0.7.0.1
 */