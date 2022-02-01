import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.b;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.Switch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class juk
{
  protected Handler.Callback a;
  PhotoWallViewForAccountDetail.b jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$b = new jum(this);
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  protected juk.a a;
  protected ViewGroup aI;
  boolean abB = false;
  boolean abG = false;
  boolean abP = true;
  boolean abQ = true;
  protected boolean abR;
  protected boolean abS;
  public QQAppInterface app;
  protected acfd b;
  protected adai b;
  jzs.a b;
  float density;
  LinearLayout dq;
  protected MqqHandler g;
  View iP;
  View iQ;
  protected ArrayList<String> ju = new ArrayList();
  WeakReference<BaseActivity> mActivity;
  String mUin;
  TextView nH;
  SharedPreferences sp = null;
  int state = -1;
  TextView statusTextView;
  
  public juk(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    this.jdField_b_of_type_Jzs$a = null;
    this.jdField_b_of_type_Acfd = new jva(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new jvg(this);
    this.app = paramQQAppInterface;
    this.mUin = paramString;
    this.mActivity = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.abG = paramBoolean;
    createView();
    this.jdField_a_of_type_Juk$a = new juk.a(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Juk$a);
    paramQQAppInterface.addObserver(this.jdField_b_of_type_Acfd);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      G(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin), Long.parseLong(paramQQAppInterface.getCurrentUin()));
    }
    azT();
    this.g = new aqgw(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQQAppInterface.setHandler(getClass(), this.g);
  }
  
  private void G(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "ConfigSvc.getRecvMsgState");
    Object localObject = new GetRecvMsgStateReq();
    ((GetRecvMsgStateReq)localObject).puin = paramLong1;
    ((GetRecvMsgStateReq)localObject).uin = paramLong2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("GetRecvMsgStateReq", localObject);
    localToServiceMsg.setAttributes(localHashMap);
    localObject = new NewIntent(this.app.getApplication(), kbs.class);
    ((NewIntent)localObject).putExtra("cmd", "ConfigSvc.getRecvMsgState");
    ((NewIntent)localObject).putExtra("uin", paramLong1);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getName(), localToServiceMsg);
    kbs.aL((Intent)localObject);
    this.app.startServlet((NewIntent)localObject);
  }
  
  private void J(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject jsonObject is null");
      }
    }
    do
    {
      do
      {
        return;
        i = -1;
        if (paramJSONObject.has("retcode")) {
          i = paramJSONObject.optInt("retcode");
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject errorCode is " + i);
        }
      } while (i != 0);
      localObject = paramJSONObject.optJSONObject("result").optJSONObject("group_bar");
    } while (localObject == null);
    paramJSONObject = new ArrayList();
    Object localObject = ((JSONObject)localObject).optJSONArray("group_list");
    int j = ((JSONArray)localObject).length();
    int i = j;
    if (j > 3) {
      i = 3;
    }
    j = 0;
    while (j < i)
    {
      paramJSONObject.add(((JSONArray)localObject).optJSONObject(j).optString("code"));
      j += 1;
    }
    this.ju.clear();
    this.ju.addAll(paramJSONObject);
    localObject = (apsa)this.app.getManager(132);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("mIsAbleBindTroop", this.abR);
    localBundle.putStringArrayList("mBindedTroopUins", paramJSONObject);
    ((apsa)localObject).H(this.mUin, localBundle);
    azU();
  }
  
  private View Y()
  {
    return ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559213, null);
  }
  
  private View a(jzs.a parama, int paramInt)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvn(this, paramInt, parama));
    return localView;
  }
  
  private smu.a a()
  {
    smu.a locala = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      locala = new smu.a(this.mUin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return locala;
  }
  
  private void a(ViewGroup paramViewGroup, List<jzs.a> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.mActivity.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$b);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.mActivity.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(jzs.a parama)
  {
    if (this.statusTextView != null)
    {
      int i = parama.state;
      if ((i == 1) || (i == 2)) {
        this.statusTextView.setText(2131695281);
      }
    }
    else
    {
      return;
    }
    this.statusTextView.setText(2131695282);
  }
  
  private void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int k = paramJSONArray.length();
    if (k <= 0) {
      return;
    }
    int i = 0;
    while ((i < 3) && (i + 1 <= k))
    {
      int j = (int)(6.0F * this.density);
      int m = (int)(32.0F * this.density);
      ImageView localImageView = new ImageView((Context)this.mActivity.get());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      if (i == 2)
      {
        j = 0;
        label101:
        localLayoutParams.setMargins(0, 0, j, 0);
        localImageView.setLayoutParams(localLayoutParams);
      }
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i))) {
          localImageView.setImageResource(2130840068);
        }
        for (;;)
        {
          paramLinearLayout.addView(localImageView);
          i += 1;
          break;
          break label101;
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i)));
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(jzs.a parama)
  {
    if ((parama.type == 3) && ((parama.aGH == 3) || (parama.aGH == 16) || (parama.aGH == 21) || (parama.aGH == 13))) {}
    while ((parama.aGI == 5) || ((parama.aGG == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1))) {
      return true;
    }
    return false;
  }
  
  private boolean a(jzs paramjzs, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramjzs.fR;
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = i();
      if (paramjzs.type != 1) {
        break;
      }
      localObject = paramjzs.fR.iterator();
      while (((Iterator)localObject).hasNext())
      {
        jzs.a locala = (jzs.a)((Iterator)localObject).next();
        if (TextUtils.isEmpty(locala.pic_url)) {
          ((Iterator)localObject).remove();
        } else if ((locala.aGG == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
    } while (paramjzs.fR.size() < 3);
    a(localViewGroup, paramjzs.fR);
    this.dq.addView(localViewGroup);
    g(this.dq);
    return false;
    int i = ((List)localObject).size();
    if (i <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i > 0) && (paramBoolean))
    {
      paramjzs = new View((Context)this.mActivity.get());
      paramjzs.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.density)));
      paramjzs.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramjzs);
    }
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      if (i > 1) {
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (jzs.a)((List)localObject).get(paramInt2), paramInt1);
        paramInt2 += 1;
        break;
        if (paramInt2 == i - 1)
        {
          paramInt1 = 2;
        }
        else
        {
          paramInt1 = 3;
          continue;
          paramInt1 = 0;
        }
      }
    }
    this.dq.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  private void aAa()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559805, null);
    ((TextView)localView.findViewById(2131364414)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131369459)).setVisibility(8);
    ((TextView)localView.findViewById(2131379769)).setText(2131697477);
    this.dq.addView(localView);
  }
  
  private void azD()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new smu(this.app, (BaseActivity)this.mActivity.get(), a(), 1, getShareUrl()).Qq();
  }
  
  private void azZ()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    g(this.dq);
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559805, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131364414)).setText(str);
    this.dq.addView(localView);
  }
  
  private void c(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131369459);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private View e(jzs.a parama)
  {
    this.jdField_b_of_type_Jzs$a = parama;
    if (parama.aGI != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + parama.type + ", " + parama.aGH + ", " + parama.aGI + ")");
      }
      return null;
    }
    parama = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131563112, null);
    this.statusTextView = ((TextView)parama.findViewById(2131378717));
    this.nH = ((TextView)parama.findViewById(2131378729));
    ((TextView)parama.findViewById(2131379769)).setText(this.jdField_b_of_type_Jzs$a.title);
    this.sp = this.app.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    int i;
    if (this.sp != null)
    {
      i = this.sp.getInt("setting_result_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.app.getCurrentAccountUin(), -10000);
      this.state = this.sp.getInt("setting_status_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.app.getCurrentAccountUin(), -1);
    }
    for (;;)
    {
      if ((i == 0) && (this.state > -1))
      {
        this.abP = false;
        oo(this.state);
        parama.setOnClickListener(new jun(this));
      }
      for (;;)
      {
        return parama;
        a(this.jdField_b_of_type_Jzs$a);
        parama.setOnClickListener(new juo(this));
      }
      i = -10000;
    }
  }
  
  private View f(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131563149, null);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    Switch localSwitch = (Switch)localView.findViewById(2131378710);
    if (parama.state == 1) {
      localSwitch.setChecked(true);
    }
    for (;;)
    {
      localSwitch.setOnCheckedChangeListener(new juv(this, parama, localSwitch));
      return localView;
      localSwitch.setChecked(false);
    }
  }
  
  private void g(ViewGroup paramViewGroup)
  {
    View localView = new View((Context)this.mActivity.get());
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(0.7D * this.density)));
    localView.setBackgroundColor(Color.parseColor("#dedfe0"));
    paramViewGroup.addView(localView);
  }
  
  private String getShareUrl()
  {
    int i = ocp.getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.mUin + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.mUin;
  }
  
  private View h(jzs.a parama)
  {
    if ((TextUtils.isEmpty(parama.lat)) || (TextUtils.isEmpty(parama.lng))) {
      return null;
    }
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    TextView localTextView = (TextView)localView.findViewById(2131379769);
    String str1 = parama.title;
    String str2 = parama.content;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new jul(this, parama, str2));
      return localView;
    }
    return null;
  }
  
  private View i(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    String str = parama.Vq;
    if (str != null)
    {
      str = str.trim();
      if (!Pattern.compile("[\\d-]+?").matcher(str).matches()) {
        return null;
      }
    }
    else
    {
      return null;
    }
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    localView.setOnClickListener(new juy(this, str, parama));
    return localView;
  }
  
  private ViewGroup i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout((Context)this.mActivity.get());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }
  
  private View j(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559213, null);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    return localView;
  }
  
  private View k(jzs.a parama)
  {
    boolean bool = false;
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559768, null);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    String str = parama.url;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131370005).setVisibility(0);
      localView.setOnClickListener(new jvi(this, str, parama));
      bool = true;
    }
    for (;;)
    {
      try
      {
        parama = new JSONArray(parama.pic_url);
        a(bool, (LinearLayout)localView.findViewById(2131369086), parama);
        return localView;
      }
      catch (JSONException parama)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
        parama.printStackTrace();
      }
      localView.findViewById(2131370005).setVisibility(8);
    }
    return localView;
  }
  
  private View l(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvj(this, parama));
    return localView;
  }
  
  private void lp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent((Context)this.mActivity.get(), PublicAccountBrowser.class);
    } while ((this.app == null) || (TextUtils.isEmpty(this.mUin)) || (TextUtils.isEmpty(this.app.getAccount())));
    paramString = paramString.replace("${puin}", this.mUin).replace("${uin}", this.app.getAccount());
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.mUin);
    localIntent.putExtra("big_brother_source_key", ocp.fq(this.mUin));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    ((BaseActivity)this.mActivity.get()).startActivity(localIntent);
  }
  
  private void lq(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog((Context)this.mActivity.get(), 2131756467);
    localReportDialog.setContentView(2131561286);
    ((TextView)localReportDialog.findViewById(2131365903)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365891);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365889);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365895);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131721058);
    localTextView3.setText(2131692643);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new jvc(this, localReportDialog));
    localTextView3.setOnClickListener(new jvd(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void lr(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", this.mUin, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  private View m(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvk(this, parama));
    return localView;
  }
  
  private View n(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvl(this, parama));
    return localView;
  }
  
  private View o(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvm(this, parama));
    return localView;
  }
  
  private void oh(int paramInt)
  {
    if ((this.mActivity != null) && (this.mActivity.get() != null)) {
      Toast.makeText(((BaseActivity)this.mActivity.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void oo(int paramInt)
  {
    if ((this.statusTextView != null) && (this.nH != null))
    {
      if (paramInt != 0) {
        break label38;
      }
      this.statusTextView.setText(2131695281);
      this.nH.setVisibility(8);
    }
    label38:
    do
    {
      return;
      if (paramInt == 1)
      {
        this.statusTextView.setText(2131695283);
        this.nH.setText(2131695284);
        this.nH.setVisibility(0);
        return;
      }
    } while (paramInt != 2);
    this.statusTextView.setText(2131695280);
    this.nH.setText(2131695285);
    this.nH.setVisibility(0);
  }
  
  private View p(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    String str = parama.url;
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new jvo(this, str, parama));
    return localView;
  }
  
  private View q(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131563302, null);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    return localView;
  }
  
  private View r(jzs.a parama)
  {
    View localView = ((BaseActivity)this.mActivity.get()).getLayoutInflater().inflate(2131559458, null);
    c(localView, parama.icon);
    String str = parama.url;
    ((TextView)localView.findViewById(2131379769)).setText(parama.title);
    ((TextView)localView.findViewById(2131365360)).setText(parama.content);
    localView.setOnClickListener(new juw(this, str, parama));
    return localView;
  }
  
  public View X()
  {
    return this.dq;
  }
  
  void a(ViewGroup paramViewGroup, jzs.a parama, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
    }
    if (a(parama)) {
      return;
    }
    label59:
    int i;
    if (parama.type == 3) {
      if (parama.aGH == 10)
      {
        this.iP = e(parama);
        this.iQ = this.iP;
        if (this.iP == null) {
          break label492;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.iP.setLayoutParams(localLayoutParams);
        this.iP.setBackgroundResource(2130837605);
        paramInt = (int)(16.0F * this.density);
        i = (int)(12.0F * this.density);
        if (parama.type != 4) {
          break label494;
        }
        this.iP.setPadding(paramInt, i, paramInt, i);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(this.iP);
      g(paramViewGroup);
      return;
      if (parama.aGH == 7)
      {
        this.iP = h(parama);
        break label59;
      }
      if (parama.aGH == 8)
      {
        this.iP = i(parama);
        break label59;
      }
      if (parama.aGH == 11)
      {
        this.iP = l(parama);
        break label59;
      }
      if (parama.aGH == 20)
      {
        this.iP = m(parama);
        break label59;
      }
      if (parama.aGH == 2)
      {
        this.iP = n(parama);
        break label59;
      }
      if (parama.aGH == 17)
      {
        this.iP = o(parama);
        break label59;
      }
      if (parama.aGH == 19)
      {
        this.iP = a(parama, 9);
        break label59;
      }
      if (parama.aGH == 18)
      {
        this.iP = a(parama, 10);
        break label59;
      }
      if (parama.aGH == 22)
      {
        this.iP = p(parama);
        break label59;
      }
      if (parama.aGH == 24)
      {
        this.iP = q(parama);
        break label59;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + parama.aGH);
      return;
      if (parama.type == 1)
      {
        this.iP = r(parama);
        break label59;
      }
      if (parama.type == 2)
      {
        this.iP = f(parama);
        break label59;
      }
      if (parama.type == 4)
      {
        this.iP = j(parama);
        break label59;
      }
      if (parama.type == 5)
      {
        this.iP = k(parama);
        break label59;
      }
      this.iP = Y();
      break label59;
      label492:
      break;
      label494:
      if ((parama.type == 2) || ((parama.type == 5) && (!parama.pic_url.equals("[]")))) {
        this.iP.setPadding(paramInt, 0, paramInt, 0);
      } else {
        this.iP.setPadding(paramInt, i, paramInt, i);
      }
    }
  }
  
  void a(jzs.a parama, int paramInt)
  {
    ausj localausj = (ausj)auss.b((Context)this.mActivity.get(), null);
    localausj.addRadioButton(2131695281, 5, false);
    localausj.addRadioButton(2131695282, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localausj.setRadioButtonChecked(0);
    }
    for (;;)
    {
      if ((paramInt != 1) && (paramInt == 2)) {}
      localausj.addCancelButton(2131721058);
      localausj.setOnDismissListener(new jup(this));
      localausj.a(new juq(this, parama, localausj));
      if (!localausj.isShowing())
      {
        this.abB = false;
        localausj.show();
      }
      return;
      localausj.setRadioButtonChecked(1);
    }
  }
  
  void a(jzs.a parama, Switch paramSwitch)
  {
    boolean bool = true;
    if (parama.state == 1) {}
    for (;;)
    {
      this.abQ = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  void a(jzs.a parama, Switch paramSwitch, boolean paramBoolean)
  {
    aqju localaqju = aqha.a((Context)this.mActivity.get(), 0);
    localaqju.setCanceledOnTouchOutside(false);
    String str = parama.Vp;
    if (3 == parama.aGI) {
      str = String.format(((BaseActivity)this.mActivity.get()).getString(2131693261), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name });
    }
    localaqju.setTitle("");
    localaqju.setMessage(str);
    localaqju.setOnCancelListener(new jve(this, parama, paramSwitch));
    new jvf(this, parama, paramBoolean, paramSwitch);
    try
    {
      localaqju.show();
      return;
    }
    catch (Exception parama) {}
  }
  
  void a(jzs.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      jtz.a(this.app, this.mUin, parama, i);
      return;
    }
  }
  
  void azT()
  {
    if (!yu()) {
      return;
    }
    Object localObject = ((apsa)this.app.getManager(132)).h(this.mUin);
    if (localObject != null)
    {
      this.abR = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
      localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.ju.clear();
        this.ju.addAll((Collection)localObject);
      }
    }
    azX();
    azY();
  }
  
  public void azU()
  {
    this.dq.removeAllViews();
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.paConfigAttrs;
      if (localList == null) {
        localList = jzs.D(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList);
      }
    }
    for (;;)
    {
      int i;
      if (localList != null)
      {
        int j = localList.size();
        i = 0;
        boolean bool = false;
        if (i < j)
        {
          if ((((jzs)localList.get(i)).type != 0) && (((jzs)localList.get(i)).type != 1)) {
            break label128;
          }
          bool = a((jzs)localList.get(i), i, j, bool);
        }
      }
      label128:
      for (;;)
      {
        i += 1;
        break;
        azV();
        return;
      }
      continue;
      localList = null;
    }
  }
  
  void azV()
  {
    h(this.dq);
    aAa();
    azZ();
  }
  
  void azW()
  {
    if (yu())
    {
      Object localObject = ((apsa)this.app.getManager(132)).h(this.mUin);
      if (localObject != null)
      {
        this.abR = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
        localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.ju.clear();
          this.ju.addAll((Collection)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "loadCache, hit cache");
        }
      }
    }
  }
  
  public void azX()
  {
    if (!yu()) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(this.mUin);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops:" + l);
        }
        if (l == -1L) {
          continue;
        }
        oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
        localReqBody.uint32_channel.set(1);
        localReqBody.uint64_subscribe_code.set(l);
        jnm.b(this.app, new juz(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  public void azY()
  {
    if ((!yu()) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    Object localObject = (TicketManager)this.app.getManager(2);
    String str1 = this.app.getCurrentAccountUin();
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(str1);; localObject = null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bid", "0");
      localBundle.putString("keyword", str2);
      localBundle.putString("ver", "1");
      localBundle.putString("from", "1");
      localBundle.putString("link", "0");
      localBundle.putString("puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle.putString("Cookie", "uin=" + str1 + ";skey=" + (String)localObject);
      localBundle.putString("Referer", "https://buluo.qq.com/");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.app.getApp().getApplicationContext());
      new aprc("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new jvb(this), 1000, null).J(localHashMap);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
      anot.a(this.app, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.mUin, (String)localObject, "", "");
      return;
    }
  }
  
  void createView()
  {
    this.dq = new LinearLayout(((BaseActivity)this.mActivity.get()).getBaseContext());
    this.dq.setOrientation(1);
    this.dq.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.density = ((BaseActivity)this.mActivity.get()).getResources().getDisplayMetrics().density;
    azU();
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Juk$a != null)
    {
      this.jdField_a_of_type_Juk$a.onDestroy();
      this.app.removeObserver(this.jdField_a_of_type_Juk$a);
    }
    this.app.removeObserver(this.jdField_b_of_type_Adai);
    this.app.removeObserver(this.jdField_b_of_type_Acfd);
  }
  
  void h(ViewGroup paramViewGroup)
  {
    if (!yu()) {}
    int j;
    do
    {
      return;
      azW();
      j = this.ju.size();
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "addBindedTroopItem:" + j + "," + this.abR);
      }
    } while ((j == 0) && (!this.abR));
    View localView = LayoutInflater.from((Context)this.mActivity.get()).inflate(2131560166, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131369086);
    Object localObject = localView.findViewById(2131365360);
    this.aI = localLinearLayout;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        anot.a(this.app, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      ((View)localObject).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        localObject = new ImageView((Context)this.mActivity.get());
        int k = (int)(32.0F * this.density);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.leftMargin = ((int)(6.0F * this.density));
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setImageDrawable(this.app.l((String)this.ju.get(i)));
        ((ImageView)localObject).setTag(this.ju.get(i));
        localLinearLayout.addView((View)localObject);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        anot.a(this.app, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    localView.setOnClickListener(new jux(this, j));
    paramViewGroup.addView(localView);
    g(paramViewGroup);
  }
  
  void on(int paramInt)
  {
    ausj localausj = (ausj)auss.b((Context)this.mActivity.get(), null);
    localausj.addRadioButton(2131695281, 5, false);
    localausj.addRadioButton(2131695280, 5, false);
    localausj.addRadioButton(2131695283, 5, false);
    if (paramInt == 0) {
      localausj.setRadioButtonChecked(0);
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.setOnDismissListener(new jus(this));
      localausj.a(new jut(this, localausj));
      if (!localausj.isShowing())
      {
        this.abB = false;
        localausj.show();
      }
      return;
      if (paramInt == 1) {
        localausj.setRadioButtonChecked(2);
      } else if (paramInt == 2) {
        localausj.setRadioButtonChecked(1);
      }
    }
  }
  
  protected boolean yu()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      bool1 = bool2;
      if (ocp.getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "needShowBindTroopItem:" + bool1);
    }
    return bool1;
  }
  
  class a
    extends acje
  {
    private juk c;
    
    public a(juk paramjuk)
    {
      this.c = paramjuk;
    }
    
    public void a(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "onGetRecvMsgState isSuccess = " + paramBoolean);
      }
      if ((paramBoolean) && (paramSetRecvMsgStateRsp.result == 0))
      {
        juk.b(juk.this, juk.this.state);
        if (juk.this.sp != null) {
          juk.this.sp.edit().putInt("setting_status_" + juk.this.a.uin + "_" + juk.this.app.getCurrentAccountUin(), juk.this.state).commit();
        }
      }
    }
    
    public void a(boolean paramBoolean, jzs.a parama)
    {
      if ((paramBoolean) && (parama != null)) {
        if (parama.aGI != 3) {}
      }
      while (this.c == null) {
        for (;;)
        {
          ocp.a(juk.this.app, juk.this.app.getApplication(), juk.this.mUin);
          return;
          if ((parama.aGI == 6) && (this.c != null)) {
            juk.a(this.c, parama);
          }
        }
      }
      juk.a(this.c, 2131697432);
    }
    
    public void onDestroy()
    {
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juk
 * JD-Core Version:    0.7.0.1
 */