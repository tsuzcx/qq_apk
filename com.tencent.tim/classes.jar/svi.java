import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.webviewplugin.Share.1;
import com.tencent.biz.webviewplugin.Share.10;
import com.tencent.biz.webviewplugin.Share.2;
import com.tencent.biz.webviewplugin.Share.4;
import com.tencent.biz.webviewplugin.Share.5;
import com.tencent.biz.webviewplugin.Share.6;
import com.tencent.biz.webviewplugin.Share.9;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qconn.protofile.appType.MsgIconsurl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.stat.MttLoader.BrowserInfo;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qzone.QZoneShareData;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class svi
  implements View.OnClickListener, artv
{
  public static String TAG = "share";
  public static boolean aNt;
  Activity A = null;
  protected TextView AZ;
  protected TextView Ba;
  protected long DF;
  String Qt;
  public String TQ;
  artv.c.a jdField_a_of_type_Artv$c$a = new artv.c.a();
  public CustomWebView a;
  public SharePolicyInfo a;
  WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  protected GetAppInfoProto.GetAppinfoResponse a;
  public tzd a;
  protected String aHc;
  protected String aHd;
  protected String aHe;
  protected String aHf;
  public String aHg;
  public String aHh;
  public String aHi;
  public String aHj;
  public String aHk;
  public String aHl;
  protected String aHm = "";
  protected String aHn = "";
  protected boolean aNq;
  protected boolean aNr;
  public boolean aNs;
  public boolean aNu;
  public Activity activity;
  protected Handler aq = new svm(this);
  public String aue;
  public String auf;
  protected int bzk = -1;
  public int bzl;
  protected int bzm = -1;
  public int bzn = -1;
  volatile int bzo = 0;
  public AppInterface c;
  protected boolean ca;
  public WeakReference<aqzv> ds = null;
  protected BusinessObserver e = new svl(this);
  protected LinearLayout fA;
  protected LinearLayout fB;
  public SoftReference<Bitmap> j;
  protected Context mContext;
  protected String mCoverUrl;
  protected float mDensity;
  protected boolean mEditable = true;
  public String mShareUrl;
  protected String mSourceIcon;
  protected String mSourceName;
  protected ImageView oN;
  protected ImageView oO;
  protected ImageView oP;
  protected View qJ;
  public arhz s;
  public String uin;
  public String zc;
  
  public svi(AppInterface paramAppInterface, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "Share secret init share");
    }
    this.c = paramAppInterface;
    this.uin = paramAppInterface.getAccount();
    this.activity = paramActivity;
    this.mDensity = paramActivity.getResources().getDisplayMetrics().density;
    if ((paramActivity instanceof aqzv)) {
      this.ds = new WeakReference((aqzv)paramActivity);
    }
    while (this.ds == null)
    {
      QLog.e(TAG, 2, "Error! mWebUiUtils still null! " + paramActivity.toString());
      return;
      if ((paramActivity instanceof aqzs))
      {
        paramAppInterface = ((aqzs)paramActivity).c();
        if (paramAppInterface != null)
        {
          this.ds = new WeakReference(paramAppInterface);
        }
        else if ((paramActivity instanceof QQBrowserActivity))
        {
          QLog.w(TAG, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
          paramAppInterface = (QQBrowserActivity)paramActivity;
          localObject = paramAppInterface.getSupportFragmentManager();
          if (localObject != null)
          {
            localObject = ((FragmentManager)localObject).getFragments();
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              int i = paramAppInterface.bJm;
              if ((i >= 0) && (i < ((List)localObject).size())) {}
              for (;;)
              {
                QLog.w(TAG, 2, "cast Fragment (index: " + i + ") to WebViewFragment");
                if (!(((List)localObject).get(i) instanceof WebViewFragment)) {
                  break label383;
                }
                this.ds = new WeakReference((WebViewFragment)((List)localObject).get(i));
                break;
                i = 0;
              }
              label383:
              QLog.e(TAG, 2, "cast Fragment (index: " + i + ") is null!");
            }
          }
        }
      }
    }
    paramAppInterface = (aqzv)this.ds.get();
    if ((paramAppInterface != null) && ((paramAppInterface instanceof ardm.o)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((ardm.o)paramAppInterface).getWebView();
      if (QLog.isColorLevel())
      {
        paramAppInterface = TAG;
        localObject = new StringBuilder().append(" Share secret webview is null?");
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
          bool1 = true;
        }
        QLog.d(paramAppInterface, 2, bool1);
      }
    }
    while (!QLog.isColorLevel())
    {
      this.mContext = paramActivity.getApplicationContext();
      init();
      return;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append(" Share secret baseInterface is null?");
    if (paramAppInterface == null) {}
    for (;;)
    {
      QLog.d((String)localObject, 2, bool1);
      break;
      bool1 = false;
    }
  }
  
  public static final String a(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField, int paramInt)
  {
    paramPBRepeatMessageField = b(paramPBRepeatMessageField);
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty())) {
      return a(paramPBRepeatMessageField, paramInt);
    }
    return null;
  }
  
  public static final String a(List<svi.a> paramList, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k;
    int i;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (!paramList.isEmpty())
      {
        k = paramList.size();
        i = 0;
        localObject1 = null;
        if (i >= k) {
          break label276;
        }
      }
    }
    label176:
    Object localObject3;
    label260:
    label267:
    label270:
    label276:
    for (localObject2 = (svi.a)paramList.get(i);; localObject3 = localObject1)
    {
      try
      {
        int m = Integer.valueOf(((svi.a)localObject2).size.get()).intValue();
        if (m >= paramInt)
        {
          localObject2 = ((svi.a)localObject2).url.get();
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              i = k - 1;
              localObject1 = localObject2;
              if (i < 0) {
                break label270;
              }
              localObject2 = (svi.a)paramList.get(i);
            }
          }
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          k = Integer.valueOf(((svi.a)localObject2).size.get()).intValue();
          if (k >= paramInt) {
            break label267;
          }
          localObject2 = ((svi.a)localObject2).url.get();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label260;
          }
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QQBrowserActivity findAppIcon() iconUrl = " + localObject1);
          }
          return localObject1;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break label260;
          }
          QLog.d(TAG, 2, localNumberFormatException2.getMessage());
          i -= 1;
        }
        localNumberFormatException1 = localNumberFormatException1;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, localNumberFormatException1.getMessage());
        }
      }
      for (;;)
      {
        break;
        for (;;)
        {
          break;
        }
        break label176;
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onGetSummary. forWhat = " + paramInt + ", title=" + this.zc + ", desc=" + this.aue + ", thumb=" + this.auf + ", bitmap=" + paramBitmap);
    }
    Object localObject1;
    Object localObject2;
    int k;
    int i;
    if (this.A == null)
    {
      if (this.activity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.A = ((PluginBaseActivity)this.activity).getOutActivity();
      }
    }
    else
    {
      if ((paramInt != 2) && (paramInt != 1) && (paramInt != 3))
      {
        localObject1 = paramString2;
        if (paramInt != 4) {}
      }
      else
      {
        localObject2 = new Bundle();
        k = 0;
        if (TextUtils.isEmpty(paramString4)) {
          k = 1;
        }
        i = k;
        localObject1 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString2 = this.TQ;
          i = k;
          localObject1 = paramString2;
          if (TextUtils.isEmpty(paramString2))
          {
            i = k | 0x2;
            localObject1 = paramString2;
          }
        }
        k = i;
        if (TextUtils.isEmpty(paramString1)) {
          k = i | 0x4;
        }
        ((Bundle)localObject2).putString("report_type", "102");
        ((Bundle)localObject2).putString("act_type", "94");
        paramString2 = new StringBuilder().append("");
        if (k != 0) {
          break label653;
        }
        i = 0;
        label268:
        ((Bundle)localObject2).putString("intext_1", i);
        ((Bundle)localObject2).putString("intext_3", "" + artv.b.kL(paramInt));
        ((Bundle)localObject2).putString("intext_2", "" + k);
        ((Bundle)localObject2).putString("stringext_1", paramString3);
        arts.a().a((Bundle)localObject2, "", this.c.getAccount(), false);
      }
      paramString2 = (String)localObject1;
      if (paramInt != 2) {
        break label664;
      }
      localObject1 = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject1).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject1).putString("desc", paramString1);
      ((Bundle)localObject1).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject1).putLong("req_share_id", 0L);
      if (this.bzn != -1) {
        ((Bundle)localObject1).putInt("iUrlInfoFrm", this.bzn);
      }
      ((Bundle)localObject1).putLong("share_begin_time", arbt.In);
      if (!(this.activity instanceof aqzs)) {
        break label3714;
      }
      paramString1 = ((aqzs)this.activity).c();
      if (paramString1 == null) {
        break label659;
      }
      ((Bundle)localObject1).putString("strurt_msgid", paramString1.msgid);
      ((Bundle)localObject1).putString("struct_uin", paramString1.awT);
      ((Bundle)localObject1).putString("struct_url", paramString1.mUrl);
      ((Bundle)localObject1).putBoolean("from_web", true);
      if ((paramString1.aTX == null) || ("".equals(paramString1.aTX))) {
        break label3714;
      }
      ((Bundle)localObject1).putString("source_puin", paramString1.aTX);
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt != 0) || (!avqq.a(this.c, this.A, (Bundle)localObject1, null))) {
        rwt.ez(1, 2131689537);
      }
      return;
      this.A = this.activity;
      break;
      label653:
      i = 1;
      break label268;
      label659:
      paramInt = 1;
      continue;
      label664:
      Intent localIntent;
      if (paramInt == 1)
      {
        localIntent = new Intent(this.A, ForwardRecentActivity.class);
        paramBitmap = null;
        if ((this.activity instanceof aqzs))
        {
          paramBitmap = ((aqzs)this.activity).c();
          if ((paramBitmap == null) || (paramBitmap.b() == null)) {
            break label3704;
          }
          localObject1 = (arbt)paramBitmap.b().q(4);
          if (localObject1 == null) {
            break label3704;
          }
          paramBitmap = ((arbt)localObject1).u();
          localObject1 = ((arbt)localObject1).bQs;
        }
      }
      for (;;)
      {
        localIntent.putExtra("forward_source_business_type", 100500);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = "";
        }
        localIntent.putExtra("forward_source_sub_business_type", (String)localObject2);
        if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
        {
          localObject2 = paramBitmap.getString("to_qq");
          i = paramBitmap.getInt("to_uin_type");
          paramInt = i;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(TAG, 2, "onGetSummary() called : toUin = " + (String)localObject2 + ", uinType = " + i);
            localObject1 = localObject2;
            paramInt = i;
          }
        }
        for (;;)
        {
          label1005:
          boolean bool1;
          boolean bool2;
          if ((localObject1 != null) && (((String)localObject1).length() >= 5))
          {
            localIntent.setClass(this.mContext, DirectForwardActivity.class);
            localIntent.putExtra("toUin", (String)localObject1);
            localIntent.putExtra("uinType", paramInt);
            if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
            {
              paramBitmap = paramBitmap.getString("to_uin_name");
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onGetSummary() called : nickName = " + paramBitmap);
              }
              localIntent.putExtra("nickName", paramBitmap);
            }
            localIntent.putExtra("key_flag_from_plugin", true);
            localIntent.putExtra("isWebCompShare", true);
            bool1 = t(localIntent);
            bool2 = u(localIntent);
            i = 0;
            if (TextUtils.isEmpty(this.TQ)) {
              break label3690;
            }
          }
          for (;;)
          {
            Object localObject4;
            Object localObject5;
            Object localObject6;
            Object localObject7;
            Object localObject8;
            Object localObject3;
            long l;
            try
            {
              localObject2 = Uri.parse(this.TQ);
              localObject1 = ((Uri)localObject2).getHost();
              paramBitmap = null;
              if (((Uri)localObject2).isHierarchical()) {
                paramBitmap = ((Uri)localObject2).getQueryParameter("_pflag");
              }
              paramInt = i;
              if (!TextUtils.isEmpty(paramBitmap)) {
                if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject1))
                {
                  paramInt = i;
                  if (!"url.cn".equalsIgnoreCase((String)localObject1)) {}
                }
                else
                {
                  k = Integer.parseInt(paramBitmap);
                  paramInt = i;
                  if ((k >> 4 & 0x1) == 1) {
                    paramInt = 1;
                  }
                }
              }
            }
            catch (Exception paramBitmap)
            {
              paramInt = 0;
              continue;
              paramBitmap = " ";
              localObject1 = null;
              localObject2 = null;
              localObject3 = "https://url.cn/PWkhNu";
              localObject4 = ((Resources)localObject9).getString(2131698649);
              continue;
              paramBitmap = "plugin";
              localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { str2 });
              localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str2 });
              localObject3 = "https://url.cn/JS8oE7";
              continue;
              localObject6 = "";
              localObject4 = " ";
              localObject1 = null;
              localObject3 = null;
              localObject2 = null;
              localObject7 = "https://url.cn/UQoBHn";
              l = 801097412L;
              paramBitmap = this.activity.getIntent().getStringExtra("source_name");
              localObject5 = paramBitmap;
              if (!TextUtils.isEmpty(paramBitmap)) {
                continue;
              }
              localObject5 = this.mSourceName;
              localObject2 = this.mSourceIcon;
              paramBitmap = (Bitmap)localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                break label1833;
              }
              if (!aNt) {
                break label2103;
              }
              localObject5 = "QQ看点";
              localObject8 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
              String str1 = "plugin";
              String str2 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              Object localObject9 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              paramBitmap = (Bitmap)localObject5;
              localObject2 = localObject8;
              localObject4 = str1;
              localObject1 = str2;
              localObject3 = localObject9;
              if (!QLog.isColorLevel()) {
                break label1833;
              }
              QLog.d("share_tool_trace", 2, "QQ kandian");
              localObject3 = localObject9;
              localObject1 = str2;
              localObject4 = str1;
              localObject2 = localObject8;
              paramBitmap = (Bitmap)localObject5;
            }
            if ((this.activity instanceof PublicAccountBrowser))
            {
              str2 = ((PublicAccountBrowser)this.activity).hX();
              localObject9 = this.activity.getResources();
              localObject4 = this.activity.getIntent().getStringExtra("source_name");
              if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
                if (aNt)
                {
                  localObject5 = "QQ看点";
                  localObject6 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
                  localObject7 = "plugin";
                  localObject8 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                  str1 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                  paramBitmap = (Bitmap)localObject7;
                  localObject1 = localObject8;
                  localObject2 = str1;
                  localObject3 = localObject6;
                  localObject4 = localObject5;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("share_tool_trace", 2, "QQ kandian");
                    localObject4 = localObject5;
                    localObject3 = localObject6;
                    localObject2 = str1;
                    localObject1 = localObject8;
                    paramBitmap = (Bitmap)localObject7;
                  }
                  if (paramInt != 0)
                  {
                    localObject4 = this.A.getString(2131698654);
                    localObject3 = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
                    paramBitmap = "plugin";
                    localObject1 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                    localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                  }
                  aqmf.a(this.activity, 1001, 146, "web_share", str2, paramString4, paramString1, paramString2, String.format(((Resources)localObject9).getString(2131698632), new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "", localIntent, -1, null, -1L);
                  i = 0;
                  if (TextUtils.isEmpty(paramString4)) {
                    i = 1;
                  }
                  paramInt = i;
                  if (TextUtils.isEmpty(paramString2)) {
                    paramInt = i | 0x2;
                  }
                  i = paramInt;
                  if (TextUtils.isEmpty(paramString1)) {
                    i = paramInt | 0x4;
                  }
                  paramString1 = new Bundle();
                  paramString1.putString("report_type", "102");
                  paramString1.putString("act_type", "14");
                  paramString1.putString("intext_3", "1");
                  paramString1.putString("intext_2", "" + i);
                  paramString1.putString("stringext_1", "" + paramString3);
                  arts.a().a(paramString1, "", this.c.getAccount(), false);
                  return;
                  localIntent.putExtra("isWebCompShare", true);
                  localIntent.setClass(this.mContext, ForwardRecentActivity.class);
                  break label1005;
                }
              }
            }
            label1833:
            if (paramInt != 0)
            {
              localObject4 = this.A.getString(2131698654);
              localObject2 = "plugin";
              localObject5 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              paramBitmap = "https://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
            }
            for (;;)
            {
              if ("QQ空间".equals(localObject4)) {}
              for (localObject1 = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";; localObject1 = paramBitmap)
              {
                paramBitmap = (Bitmap)localObject6;
                if ((this.activity instanceof aqzs))
                {
                  localObject8 = ((aqzs)this.activity).c();
                  paramBitmap = (Bitmap)localObject6;
                  if (localObject8 != null)
                  {
                    if ("".equals(((WebViewFragment)localObject8).aTX)) {
                      break label2244;
                    }
                    paramBitmap = ((WebViewFragment)localObject8).aTX;
                  }
                }
                label1942:
                if (aobw.pN(paramString3))
                {
                  localObject7 = "web";
                  localObject4 = acfp.m(2131714343);
                  if (TextUtils.isEmpty(aetq.a().tV()))
                  {
                    localObject1 = aobw.cjS;
                    label1980:
                    localObject2 = aobw.cjU;
                    paramInt = 95;
                    l = aobw.aoS;
                    localObject6 = localObject1;
                    localObject1 = localObject7;
                  }
                }
                for (;;)
                {
                  if ((bool2) || (bool1))
                  {
                    i = 38;
                    label2015:
                    localObject7 = this.A;
                    localObject8 = this.A.getString(2131698632, new Object[] { paramString1 });
                    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) {
                      break label2273;
                    }
                  }
                  label2103:
                  label2244:
                  label2273:
                  for (k = -1;; k = 1001)
                  {
                    aqmf.a((Context)localObject7, i, paramInt, "web_share", paramBitmap, paramString4, paramString1, paramString2, (String)localObject8, paramString3, "web", null, null, null, (String)localObject1, null, (String)localObject5, (String)localObject3, (String)localObject2, (String)localObject4, "", localIntent, k, (String)localObject6, l);
                    break;
                    localObject2 = this.A.getString(2131698649);
                    paramBitmap = MttLoader.getBrowserInfo(this.activity.getApplicationContext());
                    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramBitmap.packageName))) {}
                    for (paramBitmap = paramBitmap.packageName + "://" + paramString3;; paramBitmap = "com.tencent.mtt://" + paramString3)
                    {
                      localObject3 = "tencent100446242://" + paramString3;
                      localObject1 = paramBitmap;
                      paramBitmap = (Bitmap)localObject2;
                      localObject2 = "https://url.cn/PWkhNu";
                      localObject4 = "app";
                      break;
                    }
                    paramBitmap = ((WebViewFragment)localObject8).awT;
                    break label1942;
                    localObject1 = aetq.a().tV();
                    break label1980;
                    i = 1001;
                    break label2015;
                  }
                  if ((paramInt == 3) || (paramInt == 4)) {
                    if (paramInt == 3)
                    {
                      this.bzo = 1;
                      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new svk(this, paramString3);
                        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
                      }
                      this.Qt = String.valueOf(System.currentTimeMillis());
                      if ((TextUtils.isEmpty(this.aHd)) || (!aobw.nt.containsKey(this.aHd))) {
                        break label2586;
                      }
                      paramString4 = (Integer)aobw.nt.get(this.aHd);
                      if (paramString4 == null) {
                        break label3631;
                      }
                      i = paramString4.intValue();
                    }
                  }
                  for (;;)
                  {
                    label2396:
                    if ((paramString3 != null) && (paramString3.contains("docs.qq.com/")))
                    {
                      if (paramInt == 3)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d(TAG, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
                        }
                        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
                        if ((a() != null) && (a().cjk != null))
                        {
                          paramString2 = "pages/detail/detail?scene=" + a().cjk;
                          if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "curFilePath=" + paramString2);
                          }
                          paramString1 = aobw.J(this.aHe);
                          if ((TextUtils.isEmpty(this.aHe)) || (!aobw.pQ(this.aHe))) {
                            break label2664;
                          }
                          if (paramString1 == null) {
                            break label2655;
                          }
                        }
                        for (;;)
                        {
                          if (paramString1 == null) {
                            break label2671;
                          }
                          WXShareHelper.a().d(paramString2, "gh_252c5f06840b", paramString1, this.zc, this.aue, paramString3);
                          return;
                          this.bzo = 2;
                          break;
                          if ((paramString3 != null) && (paramString3.contains("doc/")))
                          {
                            i = 1;
                            break label2396;
                          }
                          if ((paramString3 == null) || (!paramString3.contains("sheet/"))) {
                            break label3625;
                          }
                          i = 2;
                          break label2396;
                          paramString2 = "pages/detail/detail?url=" + paramString3;
                          break label2487;
                          label2655:
                          paramString1 = aobw.o(i);
                          continue;
                          label2664:
                          paramString1 = aobw.o(i);
                        }
                        label2671:
                        break;
                      }
                      if (paramInt != 4) {
                        break;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
                      }
                      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
                      paramString2 = WXShareHelper.a();
                      paramString4 = this.Qt;
                      paramBitmap = this.zc;
                      localObject1 = aobw.p(i);
                      if (TextUtils.isEmpty(this.aue))
                      {
                        paramString1 = paramString3;
                        if (paramInt != 3) {
                          break label2770;
                        }
                      }
                      for (paramInt = 0;; paramInt = 1)
                      {
                        paramString2.a(paramString4, paramBitmap, (Bitmap)localObject1, paramString1, paramString3, paramInt);
                        return;
                        paramString1 = this.aue;
                        break;
                      }
                    }
                    label2487:
                    label2770:
                    paramString4 = WXShareHelper.a();
                    label2586:
                    localObject1 = this.Qt;
                    if (TextUtils.isEmpty(paramString2))
                    {
                      paramString2 = paramString3;
                      if (paramInt != 3) {
                        break label2821;
                      }
                    }
                    label2821:
                    for (paramInt = 0;; paramInt = 1)
                    {
                      paramString4.a((String)localObject1, paramString1, paramBitmap, paramString2, paramString3, paramInt);
                      return;
                      break;
                    }
                    if (paramInt == 5)
                    {
                      if ((this.bzm == -1) || (TextUtils.isEmpty(this.mCoverUrl)))
                      {
                        anot.a(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
                        QLog.w(TAG, 1, "onGetSummary invalid shareInfo");
                        return;
                      }
                      localObject1 = new Bundle();
                      paramBitmap = paramString1;
                      if (TextUtils.isEmpty(paramString1)) {
                        paramBitmap = paramString3;
                      }
                      ((Bundle)localObject1).putString("title", paramBitmap);
                      paramString1 = paramString2;
                      if (TextUtils.isEmpty(paramString2)) {
                        paramString1 = paramString3;
                      }
                      ((Bundle)localObject1).putString("desc", paramString1);
                      ((Bundle)localObject1).putString("detail_url", paramString3);
                      ((Bundle)localObject1).putString("cover_url", this.mCoverUrl);
                      ((Bundle)localObject1).putString("source_name", this.mSourceName);
                      ((Bundle)localObject1).putInt("article_id", this.bzm);
                      paramString1 = new ArrayList(1);
                      paramString1.add(paramString4);
                      ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
                      ((Bundle)localObject1).putLong("req_share_id", 0L);
                      if (this.A == null) {
                        this.A = this.activity;
                      }
                      if (awiw.b(this.c, this.A, (Bundle)localObject1, null, 0)) {
                        break;
                      }
                      rwt.ez(1, 2131689537);
                      return;
                    }
                    if ((paramInt == 6) || (paramInt == 7))
                    {
                      asgx.a(this.activity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
                      return;
                    }
                    if (paramInt == 8)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "shareMsgToSina start!");
                      }
                      paramString2 = BaseApplicationImpl.getContext().getPackageManager();
                      try
                      {
                        paramString2 = paramString2.getApplicationInfo("com.sina.weibo", 8192);
                        if (QLog.isColorLevel()) {
                          QLog.d(TAG, 2, "shareMsgToSina installSinaWeibo:true");
                        }
                        ThreadManager.executeOnSubThread(new Share.4(this, paramString4, paramString1, paramString3, paramString2));
                      }
                      catch (PackageManager.NameNotFoundException paramString2)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "shareMsgToSina installSinaWeibo:false");
                          }
                          try
                          {
                            paramString1 = URLEncoder.encode(paramString1, "UTF-8");
                            paramString1 = "https://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
                            paramString2 = URLEncoder.encode(paramString3, "UTF-8");
                            paramString1 = paramString1 + "&url=" + paramString2;
                            paramString2 = URLEncoder.encode(paramString4, "UTF-8");
                            paramString1 = paramString1 + "&pic=" + paramString2;
                            paramString1 = paramString1 + "&_wv=3";
                            paramString2 = new Intent(this.activity, QQBrowserActivity.class);
                            paramString2.putExtra("url", paramString1);
                            this.activity.startActivity(paramString2);
                            if (QLog.isColorLevel()) {
                              QLog.d(TAG, 2, "shareMsgToSina start webview!");
                            }
                          }
                          catch (Exception paramString1)
                          {
                            Toast.makeText(BaseApplicationImpl.getContext(), acfp.m(2131714344), 1).show();
                            paramString1.printStackTrace();
                          }
                        }
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(TAG, 2, "shareMsgToSina end!");
                      return;
                    }
                    if (paramInt != 9) {
                      break;
                    }
                    paramString2 = ((AppActivity)this.activity).getAppRuntime();
                    if ((this.activity instanceof FastWebActivity))
                    {
                      paramString3 = lbz.a().a();
                      paramString1 = null;
                      if (paramString3 != null) {
                        paramString1 = paramString3.a(this.aHn);
                      }
                      paramString3 = new Bundle();
                      if (paramString1 != null)
                      {
                        paramString3.putLong("publishAccountUin", paramString1.puin);
                        paramString3.putString("publishAccountName", paramString1.accountName);
                      }
                      lgv.a().a(this.activity, null, 1, this.aHn, this.zc, this.aue, this.auf, this.aHm, paramString3);
                      avjg.a(paramString2, 42, 2);
                      return;
                    }
                    if ((this.activity instanceof aqzs))
                    {
                      paramString1 = ((aqzs)this.activity).c();
                      if (paramString1 != null) {
                        if (TextUtils.isEmpty(paramString1.aTX)) {
                          paramString1 = paramString1.awT;
                        }
                      }
                    }
                    for (;;)
                    {
                      if ((this.activity instanceof PublicAccountBrowser)) {
                        paramString1 = ((PublicAccountBrowser)this.activity).hX();
                      }
                      ThreadManager.getUIHandler().post(new Share.5(this, paramString1));
                      break;
                      paramString1 = paramString1.aTX;
                      continue;
                      paramString1 = "";
                    }
                    label3625:
                    i = 1;
                    continue;
                    label3631:
                    i = 1;
                  }
                  localObject6 = localObject1;
                  localObject1 = localObject2;
                  paramInt = 146;
                  localObject2 = localObject6;
                  localObject6 = localObject7;
                }
              }
              localObject5 = paramBitmap;
              paramBitmap = (Bitmap)localObject2;
              localObject2 = localObject4;
              localObject4 = localObject5;
              localObject5 = localObject1;
            }
            label3690:
            paramInt = 0;
          }
          paramInt = 0;
          localObject1 = "";
        }
        label3704:
        localObject1 = "";
        paramBitmap = null;
      }
      label3714:
      paramInt = 0;
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Bundle localBundle = aqjn.a.a(paramString2, paramString3, "0.0.0.1", paramString4, this.mContext.getResources().getDisplayMetrics().scaledDensity, null, null);
    localBundle.putBoolean("forward_ark_app_direct", false);
    localBundle.putString("forward_ark_app_name", paramString2);
    localBundle.putString("forward_ark_app_view", paramString3);
    localBundle.putString("forward_ark_app_meta", paramString4);
    localBundle.putString("forward_ark_app_config", paramString5);
    if (!TextUtils.isEmpty(paramString6)) {
      localBundle.putString("forward_ark_app_ver", paramString6);
    }
    localBundle.putBoolean("forward_ark_from_h5", true);
    localBundle.putString("forward_ark_h5_from_normal", paramString1);
    localBundle.putBoolean("is_ark_display_share", true);
    localBundle.putString("forward_appId_ark_from_sdk", paramString7);
    localBundle.putString("struct_share_key_source_name", paramString8);
    localBundle.putString("struct_share_key_source_action_data", paramString9);
    localBundle.putString("struct_share_key_source_a_action_data_from_h5", paramString10);
    localBundle.putString("struct_share_key_source_url", paramString11);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "ShareArkFromH5 buildArkShareIntent bundle = ", localBundle.toString() });
    }
    paramIntent.putExtras(localBundle);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString, long paramLong1, long paramLong2, BusinessObserver paramBusinessObserver)
  {
    a(paramAppInterface, paramContext, paramString, paramLong1, paramLong2, paramBusinessObserver, MobileQQ.getContext().getPackageName());
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, long paramLong2, BusinessObserver paramBusinessObserver, String paramString2)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("3.4.4");
    localGetAppinfoRequest.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString2);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, aruh.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    if (paramLong2 > 0L) {
      paramContext.putExtra("timeout", paramLong2);
    }
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3, BusinessObserver paramBusinessObserver, String paramString3, long paramLong4, boolean paramBoolean)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("3.4.4");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong3);
    localGetAppinfoRequest.signature.set(paramString2);
    localGetAppinfoRequest.channel_source.set(paramLong2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, aruh.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", paramLong4);
    paramContext.putExtra("key_support_retry", paramBoolean);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static final void a(AppInterface paramAppInterface, Context paramContext, String paramString1, long paramLong1, String paramString2, long paramLong2, BusinessObserver paramBusinessObserver, String paramString3)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong1);
    localGetAppinfoRequest.sdkp.set("android");
    localGetAppinfoRequest.os.set(Build.VERSION.RELEASE);
    localGetAppinfoRequest.qqv.set("3.4.4");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong2);
    localGetAppinfoRequest.signature.set(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, aruh.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000L);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static List<svi.a> b(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GetAppInfoProto.MsgIconsurl localMsgIconsurl = (GetAppInfoProto.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new svi.a(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  public static List<svi.a> c(PBRepeatMessageField<appType.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        appType.MsgIconsurl localMsgIconsurl = (appType.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new svi.a(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  private void f(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = new HashMap();
    if ((paramInt == 1) && (gn(paramString)))
    {
      if (((paramString.length() > 180) || ((!(this.activity instanceof PublicAccountBrowser)) && (paramString.length() > 60))) && (!(this.activity instanceof TeamWorkDocEditBrowserActivity)) && (!aobw.pN(paramString))) {
        ((HashMap)localObject).put("url", paramString);
      }
      if ((this.auf != null) && (this.auf.length() > 40)) {
        ((HashMap)localObject).put("thumb", this.auf);
      }
    }
    Bitmap localBitmap;
    if (this.j == null)
    {
      localBitmap = null;
      if ((!paramBoolean) || ((paramInt != 3) && (paramInt != 4)) || (localBitmap != null) || (TextUtils.isEmpty(this.auf))) {
        break label216;
      }
    }
    for (;;)
    {
      if (((!this.aNs) && (((HashMap)localObject).size() <= 0) && (!bool)) || (paramInt == 2) || (paramInt == 9)) {
        break label222;
      }
      ThreadManager.executeOnNetWorkThread(new Share.2(this, (HashMap)localObject, paramInt, paramString, bool));
      return;
      localBitmap = (Bitmap)this.j.get();
      break;
      label216:
      bool = false;
    }
    label222:
    if ((this.s != null) && (this.s.isShowing())) {
      this.s.dismiss();
    }
    localObject = this.zc;
    String str1 = this.aue;
    String str2 = this.auf;
    if (paramBoolean) {}
    for (;;)
    {
      a(paramInt, (String)localObject, str1, paramString, str2, localBitmap);
      return;
      localBitmap = null;
    }
  }
  
  private boolean gn(String paramString)
  {
    try
    {
      boolean bool = "1".equals(Uri.parse(paramString).getQueryParameter("not_short"));
      if (bool) {
        return false;
      }
    }
    catch (Throwable paramString)
    {
      QLog.d(TAG, 1, paramString, new Object[0]);
    }
    return true;
  }
  
  private boolean go(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("app")) && (paramString.contains("view"));
  }
  
  private HashMap<String, String> k(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        Iterator localIterator = paramString.getQueryParameterNames().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramString.getQueryParameter(str1);
            if (!TextUtils.isEmpty(str2)) {
              localHashMap.put(str1, str2);
            }
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      ArkAppCenter.r(TAG, String.format("getArkInfo, parse param failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  private String s(String paramString1, String paramString2, String paramString3)
  {
    if (go(paramString1)) {}
    do
    {
      return paramString1;
      if (go(paramString2)) {
        return paramString2;
      }
    } while (!go(paramString3));
    return paramString3;
  }
  
  private boolean t(Intent paramIntent)
  {
    Bundle localBundle = this.activity.getIntent().getExtras();
    String str1 = localBundle.getString("forward_ark_app_name");
    String str2 = localBundle.getString("forward_ark_app_view");
    if ((this.aNu) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      a(paramIntent, s(getShareUrl(), this.aHc, this.TQ), str1, str2, localBundle.getString("forward_ark_app_meta"), localBundle.getString("forward_ark_app_config"), "", localBundle.getString("forward_appId_ark_from_sdk"), localBundle.getString("struct_share_key_source_name"), localBundle.getString("struct_share_key_source_action_data"), localBundle.getString("struct_share_key_source_a_action_data"), localBundle.getString("struct_share_key_source_url"));
      return true;
    }
    return false;
  }
  
  private boolean u(Intent paramIntent)
  {
    try
    {
      String str2 = s(getShareUrl(), this.aHc, this.TQ);
      Object localObject = k(str2);
      if ((!((Map)localObject).isEmpty()) && (((Map)localObject).containsKey("app")) && (((Map)localObject).containsKey("view")))
      {
        String str3 = (String)((Map)localObject).get("app");
        String str4 = (String)((Map)localObject).get("view");
        String str1 = "{}";
        if (((Map)localObject).containsKey("meta")) {
          str1 = (String)((Map)localObject).get("meta");
        }
        String str5 = (String)((Map)localObject).get("config");
        localObject = (String)((Map)localObject).get("ver");
        if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
        {
          a(paramIntent, str2, str3, str4, str1, str5, (String)localObject, "", "", "", "", "");
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      ArkAppCenter.r(TAG, String.format("shareArkFromUrl, parse json failed, err=%s", new Object[] { paramIntent.getMessage() }));
    }
    return false;
  }
  
  public void K(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      this.aHm = paramArticleInfo.mArticleContentUrl;
      this.aHn = paramArticleInfo.innerUniqueID;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, new Object[] { "shareUrl = ", this.aHm, " , rowKey = ", this.aHn });
      }
      return;
    }
    QLog.d(TAG, 1, "setReadInJoyShareData but articleInfo is null.");
  }
  
  public boolean No()
  {
    QZoneShareData localQZoneShareData;
    if (this.A == null)
    {
      if (this.activity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.A = ((PluginBaseActivity)this.activity).getOutActivity();
      }
    }
    else
    {
      localQZoneShareData = new QZoneShareData();
      if (!TextUtils.isEmpty(this.zc)) {
        break label193;
      }
      localObject = null;
      label57:
      localQZoneShareData.mTitle = ((String)localObject);
      if (!TextUtils.isEmpty(this.aue)) {
        break label201;
      }
    }
    label193:
    label201:
    for (Object localObject = null;; localObject = this.aue)
    {
      localQZoneShareData.mSummary = ((String)localObject);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.auf);
      localQZoneShareData.ER = ((ArrayList)localObject);
      localQZoneShareData.targetUrl = getShareUrl();
      if (this.bzn != -1) {
        localQZoneShareData.iUrlInfoFrm = this.bzn;
      }
      localQZoneShareData.azQ = arbt.In;
      localQZoneShareData.from = 2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        localQZoneShareData.cNa = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      }
      if (this.c == null) {
        break label209;
      }
      avqq.a(this.A, this.c.getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
      this.A = this.activity;
      break;
      localObject = this.zc;
      break label57;
    }
    label209:
    rwt.ez(1, 2131689537);
    return true;
  }
  
  public boolean Np()
  {
    return this.aNq;
  }
  
  public SharePolicyInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  }
  
  public void a(Context paramContext, GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    Bitmap localBitmap = null;
    byte[] arrayOfByte;
    try
    {
      if ((paramGetAppinfoResponse.has()) && (paramGetAppinfoResponse.ret.get() == 0))
      {
        this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = paramGetAppinfoResponse;
        paramGetAppinfoResponse = a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 64);
        localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if ((TextUtils.isEmpty(paramGetAppinfoResponse)) || (localAndroidInfo == null) || (localAndroidInfo.packName == null))
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", androidInfo is null, OR androidInfo.packName is null !!!");
          }
        }
        else
        {
          arrayOfByte = jqc.a(paramContext, paramGetAppinfoResponse, "GET", null, null);
          if (arrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(TAG, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", imageBytes is NULL!!!!!!!!");
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      GetAppInfoProto.AndroidInfo localAndroidInfo;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, paramContext.getMessage());
        return;
        Message localMessage = this.aq.obtainMessage(1002);
        paramGetAppinfoResponse = localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          paramGetAppinfoResponse = localBitmap;
          localMessage.obj = localBitmap;
          paramGetAppinfoResponse = localBitmap;
          this.aq.sendMessage(localMessage);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = paramGetAppinfoResponse;
            if (QLog.isColorLevel())
            {
              QLog.e(TAG, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
              localGetAppinfoResponse = paramGetAppinfoResponse;
            }
          }
          paramContext = jqc.a(paramContext, String.format("https://openmobile.qq.com/api/get_app_info_by_id?appid=%d", new Object[] { Long.valueOf(aqgb.X(this.DF)) }), "GET", null, null);
          if (!TextUtils.isEmpty(paramContext)) {
            break label366;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(TAG, 2, "QQBrowserActivity urlResponse is null");
          return;
          paramContext = new JSONObject(paramContext);
          if (paramContext.getInt("retcode") == 0) {
            break label402;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(TAG, 2, "QQBrowserActivity retcode is -1");
          return;
          paramContext = paramContext.getJSONObject("result");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("mobile");
          if (paramContext == null) {
            return;
          }
          paramContext = paramContext.getJSONObject("android");
          if (paramContext == null) {
            return;
          }
          paramGetAppinfoResponse = paramContext.getString("yyb_url");
          if ((paramContext.getInt("AppState") != 1) || (TextUtils.isEmpty(paramGetAppinfoResponse))) {
            return;
          }
          paramContext = this.aq.obtainMessage(1001);
          try
          {
            paramContext.obj = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            this.aq.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(TAG, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
          }
        }
        if (aqiz.isAppInstalled(paramContext, localAndroidInfo.packName.get()))
        {
          paramContext = this.aq.obtainMessage(1001);
          try
          {
            paramContext.obj = localBitmap;
            this.aq.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.e(TAG, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
        }
      }
    }
    label366:
  }
  
  public void a(aqzv paramaqzv)
  {
    boolean bool = true;
    if (paramaqzv == null) {
      return;
    }
    if (this.ds == null) {
      this.ds = new WeakReference(paramaqzv);
    }
    paramaqzv = (aqzv)this.ds.get();
    if ((paramaqzv != null) && ((paramaqzv instanceof ardm.o)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((ardm.o)paramaqzv).getWebView();
      if (QLog.isColorLevel())
      {
        paramaqzv = TAG;
        localObject = new StringBuilder().append(" Share secret webview is null?");
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          break label123;
        }
        bool = true;
        QLog.d(paramaqzv, 2, bool);
      }
    }
    label123:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        this.mContext = this.activity.getApplicationContext();
        init();
        return;
        bool = false;
      }
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append(" Share secret baseInterface is null?");
    if (paramaqzv == null) {}
    for (;;)
    {
      QLog.d((String)localObject, 2, bool);
      break;
      bool = false;
    }
  }
  
  public void a(SharePolicyInfo paramSharePolicyInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = paramSharePolicyInfo;
  }
  
  public void a(tzd paramtzd)
  {
    this.jdField_a_of_type_Tzd = paramtzd;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      rwt.ez(1, 2131689530);
      return false;
    }
    Bundle localBundle;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Artv$c$a.valid)
    {
      this.jdField_a_of_type_Artv$c$a.cXj = artv.b.kL(paramInt);
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "90");
      localStringBuilder = new StringBuilder().append("");
      if (this.jdField_a_of_type_Artv$c$a.ekY != 0) {
        break label407;
      }
    }
    label407:
    for (int i = 0;; i = 1)
    {
      localBundle.putString("intext_1", i);
      localBundle.putString("intext_3", "" + this.jdField_a_of_type_Artv$c$a.cXj);
      localBundle.putString("intext_2", "" + this.jdField_a_of_type_Artv$c$a.ekY);
      localBundle.putString("stringext_1", "" + paramString);
      arts.a().a(localBundle, "", this.c.getAccount(), false);
      this.jdField_a_of_type_Artv$c$a.valid = false;
      if (aqiw.isNetSupport(this.activity)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getSummary Fail_Network. title=" + this.zc + ", desc=" + this.aue + ", thumb=" + this.auf);
      }
      rwt.ez(1, 2131696272);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "84");
      paramString.putString("intext_1", "" + artv.b.kK(1));
      paramString.putString("intext_3", "1");
      paramString.putString("intext_4", "0");
      arts.a().a(paramString, "", this.c.getAccount(), false);
      return false;
    }
    aNt = false;
    if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(paramString).find()) {
      aNt = true;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("share_tool_trace", 2, "url is " + paramString);
      QLog.d("share_tool_trace", 2, "readInjoy JS work=" + aNt);
    }
    if ((!TextUtils.isEmpty(this.zc)) && (this.zc.length() > 30)) {
      this.zc = this.zc.substring(0, 29);
    }
    if ((!TextUtils.isEmpty(this.aue)) && (this.aue != null) && (this.aue.length() > 40)) {
      this.aue = this.aue.substring(0, 39);
    }
    if ((!TextUtils.isEmpty(this.auf)) && (!TextUtils.isEmpty(this.zc)) && (!TextUtils.isEmpty(this.aue)))
    {
      f(paramString, paramInt, paramBoolean);
      return true;
    }
    b().setMessage(2131689531);
    boolean bool = TextUtils.isEmpty(this.aHn);
    if ((!this.s.isShowing()) && (bool)) {
      this.s.show();
    }
    ThreadManager.executeOnNetWorkThread(new Share.1(this, paramString, paramInt, paramBoolean));
    return true;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_0
    //   8: aload_3
    //   9: invokevirtual 1525	svi:bw	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 332	svi:zc	Ljava/lang/String;
    //   22: aload_0
    //   23: aload_2
    //   24: putfield 336	svi:aue	Ljava/lang/String;
    //   27: aload_0
    //   28: aload 4
    //   30: putfield 340	svi:auf	Ljava/lang/String;
    //   33: aload_0
    //   34: getfield 340	svi:auf	Ljava/lang/String;
    //   37: ifnull +43 -> 80
    //   40: aload_0
    //   41: getfield 340	svi:auf	Ljava/lang/String;
    //   44: ldc_w 1527
    //   47: invokevirtual 1530	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +30 -> 80
    //   53: aload_0
    //   54: new 190	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 1532
    //   64: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 340	svi:auf	Ljava/lang/String;
    //   71: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: putfield 340	svi:auf	Ljava/lang/String;
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 1188	svi:aNs	Z
    //   85: aload 5
    //   87: ifnull +173 -> 260
    //   90: aload 5
    //   92: ldc_w 1534
    //   95: invokevirtual 529	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   98: iconst_1
    //   99: if_icmpne +161 -> 260
    //   102: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +69 -> 174
    //   108: ldc_w 1536
    //   111: iconst_2
    //   112: new 190	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1538
    //   122: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 332	svi:zc	Ljava/lang/String;
    //   129: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1540
    //   135: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 336	svi:aue	Ljava/lang/String;
    //   142: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 338
    //   148: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 340	svi:auf	Ljava/lang/String;
    //   155: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 1542
    //   161: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_3
    //   165: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: getfield 110	svi:jdField_a_of_type_Artv$c$a	Lartv$c$a;
    //   178: iconst_1
    //   179: putfield 1458	artv$c$a:valid	Z
    //   182: aload_0
    //   183: getfield 110	svi:jdField_a_of_type_Artv$c$a	Lartv$c$a;
    //   186: iconst_0
    //   187: putfield 1466	artv$c$a:ekY	I
    //   190: aload 4
    //   192: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +430 -> 625
    //   198: aload_0
    //   199: getfield 110	svi:jdField_a_of_type_Artv$c$a	Lartv$c$a;
    //   202: astore 4
    //   204: aload 4
    //   206: aload 4
    //   208: getfield 1466	artv$c$a:ekY	I
    //   211: iconst_1
    //   212: ior
    //   213: putfield 1466	artv$c$a:ekY	I
    //   216: aload_2
    //   217: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +18 -> 238
    //   223: aload_0
    //   224: getfield 110	svi:jdField_a_of_type_Artv$c$a	Lartv$c$a;
    //   227: astore_2
    //   228: aload_2
    //   229: aload_2
    //   230: getfield 1466	artv$c$a:ekY	I
    //   233: iconst_2
    //   234: ior
    //   235: putfield 1466	artv$c$a:ekY	I
    //   238: aload_1
    //   239: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifeq +18 -> 260
    //   245: aload_0
    //   246: getfield 110	svi:jdField_a_of_type_Artv$c$a	Lartv$c$a;
    //   249: astore_1
    //   250: aload_1
    //   251: aload_1
    //   252: getfield 1466	artv$c$a:ekY	I
    //   255: iconst_4
    //   256: ior
    //   257: putfield 1466	artv$c$a:ekY	I
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 1186	svi:j	Ljava/lang/ref/SoftReference;
    //   265: aload 5
    //   267: ifnull +263 -> 530
    //   270: getstatic 96	svi:TAG	Ljava/lang/String;
    //   273: iconst_1
    //   274: ldc_w 1544
    //   277: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: aload 5
    //   283: ldc_w 1546
    //   286: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: putfield 747	svi:aHd	Ljava/lang/String;
    //   292: aload_0
    //   293: aload 5
    //   295: ldc_w 1548
    //   298: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: putfield 780	svi:aHe	Ljava/lang/String;
    //   304: aload_0
    //   305: aload 5
    //   307: ldc_w 1534
    //   310: iconst_m1
    //   311: invokevirtual 1551	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   314: putfield 114	svi:bzn	I
    //   317: aload_0
    //   318: aload 5
    //   320: ldc_w 824
    //   323: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: putfield 811	svi:mCoverUrl	Ljava/lang/String;
    //   329: aload_0
    //   330: aload 5
    //   332: ldc_w 600
    //   335: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: putfield 659	svi:mSourceName	Ljava/lang/String;
    //   341: aload_0
    //   342: aload 5
    //   344: ldc_w 1553
    //   347: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: putfield 661	svi:mSourceIcon	Ljava/lang/String;
    //   353: aload_0
    //   354: aload 5
    //   356: ldc_w 826
    //   359: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   365: putfield 112	svi:bzm	I
    //   368: aload_0
    //   369: aload 5
    //   371: ldc_w 1555
    //   374: invokevirtual 1558	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   377: putfield 103	svi:mEditable	Z
    //   380: aload_0
    //   381: aload 5
    //   383: ldc_w 1560
    //   386: invokevirtual 1558	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   389: putfield 1330	svi:aNq	Z
    //   392: aload_0
    //   393: getfield 1562	svi:aNr	Z
    //   396: ifne +15 -> 411
    //   399: aload_0
    //   400: aload 5
    //   402: ldc_w 1564
    //   405: invokevirtual 1558	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   408: putfield 1562	svi:aNr	Z
    //   411: aload_0
    //   412: aload 5
    //   414: ldc_w 1566
    //   417: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: putfield 1568	svi:aHf	Ljava/lang/String;
    //   423: aload_0
    //   424: aload 5
    //   426: ldc_w 1570
    //   429: invokevirtual 523	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokestatic 589	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   435: putfield 105	svi:bzk	I
    //   438: aload_0
    //   439: aload 5
    //   441: ldc_w 1572
    //   444: invokevirtual 1558	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   447: putfield 1574	svi:ca	Z
    //   450: aload_0
    //   451: getfield 162	svi:activity	Landroid/app/Activity;
    //   454: ifnull +76 -> 530
    //   457: aload_0
    //   458: getfield 162	svi:activity	Landroid/app/Activity;
    //   461: instanceof 1178
    //   464: ifeq +66 -> 530
    //   467: aload_0
    //   468: getfield 162	svi:activity	Landroid/app/Activity;
    //   471: checkcast 1178	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   474: invokevirtual 1575	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:c	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   477: checkcast 1577	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   480: astore_1
    //   481: aload_1
    //   482: ifnull +48 -> 530
    //   485: aload_1
    //   486: aload_0
    //   487: getfield 103	svi:mEditable	Z
    //   490: aload_0
    //   491: getfield 105	svi:bzk	I
    //   494: invokevirtual 1581	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:ax	(ZI)V
    //   497: aload_1
    //   498: aload_0
    //   499: getfield 1562	svi:aNr	Z
    //   502: invokevirtual 1584	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:yb	(Z)V
    //   505: aload_1
    //   506: invokevirtual 1587	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:bVQ	()V
    //   509: aload_1
    //   510: iconst_1
    //   511: aload_0
    //   512: getfield 1568	svi:aHf	Ljava/lang/String;
    //   515: aconst_null
    //   516: invokevirtual 1590	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:m	(ZLjava/lang/String;Ljava/lang/String;)V
    //   519: aload_0
    //   520: getfield 1574	svi:ca	Z
    //   523: ifeq +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 1593	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:bVK	()V
    //   530: ldc_w 1595
    //   533: aload_0
    //   534: getfield 332	svi:zc	Ljava/lang/String;
    //   537: invokestatic 1598	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: ldc_w 1600
    //   543: aload_0
    //   544: getfield 336	svi:aue	Ljava/lang/String;
    //   547: invokestatic 1598	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: ldc_w 1602
    //   553: aload_0
    //   554: getfield 340	svi:auf	Ljava/lang/String;
    //   557: invokestatic 1598	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: ldc_w 1604
    //   563: aload_3
    //   564: invokestatic 1598	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: ldc_w 1606
    //   570: aload_0
    //   571: getfield 114	svi:bzn	I
    //   574: invokestatic 1607	cooperation/qzone/LocalMultiProcConfig:putInt	(Ljava/lang/String;I)V
    //   577: aload_0
    //   578: getfield 260	svi:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   581: ifnull +16 -> 597
    //   584: ldc_w 1609
    //   587: aload_0
    //   588: getfield 260	svi:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   591: invokevirtual 1318	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   594: invokestatic 1598	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: new 484	android/content/Intent
    //   600: dup
    //   601: ldc_w 1611
    //   604: invokespecial 1612	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   607: astore_1
    //   608: aload_0
    //   609: getfield 162	svi:activity	Landroid/app/Activity;
    //   612: ifnull +11 -> 623
    //   615: aload_0
    //   616: getfield 162	svi:activity	Landroid/app/Activity;
    //   619: aload_1
    //   620: invokevirtual 1615	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   623: iconst_1
    //   624: ireturn
    //   625: aload_0
    //   626: iconst_2
    //   627: putfield 1617	svi:bzl	I
    //   630: goto -414 -> 216
    //   633: astore_1
    //   634: getstatic 96	svi:TAG	Ljava/lang/String;
    //   637: iconst_1
    //   638: ldc_w 1619
    //   641: invokestatic 215	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_0
    //   645: iconst_m1
    //   646: putfield 112	svi:bzm	I
    //   649: goto -281 -> 368
    //   652: astore_1
    //   653: getstatic 96	svi:TAG	Ljava/lang/String;
    //   656: iconst_1
    //   657: ldc_w 1621
    //   660: invokestatic 215	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: goto -295 -> 368
    //   666: astore_1
    //   667: aload_0
    //   668: aconst_null
    //   669: putfield 1568	svi:aHf	Ljava/lang/String;
    //   672: getstatic 96	svi:TAG	Ljava/lang/String;
    //   675: iconst_1
    //   676: ldc_w 1623
    //   679: invokestatic 215	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: goto -259 -> 423
    //   685: astore_1
    //   686: aload_0
    //   687: iconst_m1
    //   688: putfield 105	svi:bzk	I
    //   691: goto -253 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	this	svi
    //   0	694	1	paramString1	String
    //   0	694	2	paramString2	String
    //   0	694	3	paramString3	String
    //   0	694	4	paramString4	String
    //   0	694	5	paramBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   270	368	633	java/lang/NumberFormatException
    //   270	368	652	java/lang/Exception
    //   411	423	666	java/lang/Exception
    //   423	438	685	java/lang/Exception
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (!aqiw.isNetSupport(this.activity))
    {
      rwt.ez(1, 2131696272);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      rwt.ez(1, 2131689530);
      return false;
    }
    if (this.s == null)
    {
      paramString7 = (aqzv)this.ds.get();
      if ((paramString7 == null) || (!(paramString7 instanceof ardm.n))) {
        break label456;
      }
    }
    label139:
    label186:
    label192:
    label456:
    for (int i = ((ardm.n)paramString7).getTitleBarHeight();; i = 0)
    {
      this.s = new arhz(this.activity, i);
      this.s.setMessage(2131689531);
      boolean bool;
      if (paramString4.length() > 180)
      {
        bool = true;
        if ((paramString5 == null) || (paramString5.length() <= 40)) {
          break label186;
        }
        i = 1;
        if ((!bool) && (i == 0)) {
          break label192;
        }
        this.s.show();
        new Share.6(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        i = 0;
        break label139;
        paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        String str = String.format(this.activity.getResources().getString(2131698632), new Object[] { paramString2 });
        aqmf.a(this.activity, 1001, 146, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "https://url.cn/JS8oE7", paramString6, null);
        int k = 0;
        if (TextUtils.isEmpty(paramString5)) {
          k = 1;
        }
        i = k;
        if (TextUtils.isEmpty(paramString3)) {
          i = k | 0x2;
        }
        k = i;
        if (TextUtils.isEmpty(paramString2)) {
          k = i | 0x4;
        }
        paramString1 = new Bundle();
        paramString1.putString("report_type", "102");
        paramString1.putString("act_type", "14");
        paramString1.putString("intext_3", "1");
        paramString1.putString("intext_2", "" + k);
        paramString1.putString("stringext_1", "" + paramString4);
        arts.a().a(paramString1, "", this.c.getAccount(), false);
      }
    }
  }
  
  public arhz b()
  {
    aqzv localaqzv;
    int i;
    if (this.s == null)
    {
      if (this.ds == null) {
        break label128;
      }
      localaqzv = (aqzv)this.ds.get();
      if ((localaqzv == null) || (!(localaqzv instanceof ardm.n)) || (this.activity.isFinishing())) {
        break label134;
      }
      i = ((ardm.n)localaqzv).getTitleBarHeight();
    }
    for (;;)
    {
      this.s = new arhz(this.activity, i);
      this.s.setMessage(2131689531);
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "dialog show time :" + l);
      }
      return this.s;
      label128:
      localaqzv = null;
      break;
      label134:
      if (this.activity != null)
      {
        i = this.activity.getResources().getDimensionPixelSize(2131299627);
      }
      else
      {
        i = (int)(50.0F * this.mDensity + 0.5F);
        QLog.e(TAG, 1, "use default yOffset when getting share progress dialog.");
      }
    }
  }
  
  public void bBf()
  {
    if (this.aHg != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHg, new String[] { "7" });
    }
  }
  
  public void bBg()
  {
    if (this.aHg != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHg, new String[] { "8" });
    }
  }
  
  public void bBh()
  {
    if (this.aHg != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHg, new String[] { "9" });
    }
  }
  
  public void bBi()
  {
    if (this.aHh != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHh, new String[] { "0" });
    }
  }
  
  public void bBj()
  {
    if (this.aHi != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHi, new String[] { "1" });
    }
  }
  
  public void bBk()
  {
    if (this.aHj != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHj, new String[] { "2" });
    }
  }
  
  public void bBl()
  {
    if (this.aHk != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHk, new String[] { "3" });
    }
  }
  
  public boolean bw(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    Object localObject;
    Uri localUri;
    do
    {
      do
      {
        return false;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramString)));
      localObject = Uri.parse((String)localObject);
      localUri = Uri.parse(paramString);
    } while ((((Uri)localObject).isOpaque()) || (localUri.isOpaque()) || (!((Uri)localObject).getScheme().equals(localUri.getScheme())) || (!((Uri)localObject).getHost().equals(localUri.getHost())));
    this.mShareUrl = paramString;
    this.j = null;
    return true;
  }
  
  public void destroy()
  {
    if (this.aq != null)
    {
      this.aq.removeMessages(1001);
      this.aq.removeMessages(1002);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = null;
    }
  }
  
  public void eK(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("fontSize", paramInt1);
      ((JSONObject)localObject).put("fontScale", paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "QQWebviewSetFontSize: " + ((JSONObject)localObject).toString());
      }
      localObject = WebViewPlugin.toJsScript("QQWebviewSetFontSize", (JSONObject)localObject, null);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "QQWebviewSetFontSize jason error");
    }
  }
  
  public void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("policy", paramInt1);
      ((JSONObject)localObject).put("result", paramBoolean);
      ((JSONObject)localObject).put("shareSource", paramInt3);
      ((JSONObject)localObject).put("prePolicy", paramInt2);
      localObject = WebViewPlugin.toJsScript("didFinishShare", (JSONObject)localObject, null);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs((String)localObject);
      }
      for (;;)
      {
        if ((paramInt3 == 1) && ((paramInt2 == 0) || (paramInt2 == 1)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null)) {
          ThreadManager.excute(new Share.10(this), 128, null, false);
        }
        return;
        ThreadManager.getUIHandler().post(new Share.9(this, (String)localObject));
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "share finished jason error");
        }
      }
    }
  }
  
  public void g(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    }
    for (;;)
    {
      b().show();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.aHg, new String[] { paramString });
      return;
      if (paramInt == 2) {
        paramString = "1";
      } else if (paramInt == 3) {
        paramString = "2";
      } else if (paramInt == 4) {
        paramString = "3";
      } else if (paramInt == 8) {
        paramString = "4";
      } else if (paramInt == 6) {
        paramString = "5";
      } else if (paramInt == 7) {
        paramString = "6";
      } else {
        paramString = "-1";
      }
    }
  }
  
  public String getShareTitle()
  {
    return this.zc;
  }
  
  public String getShareUrl()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.mShareUrl)) {
      localObject = this.mShareUrl;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        return "";
        if (this.ds != null)
        {
          localObject = (aqzv)this.ds.get();
          if ((localObject != null) && ((localObject instanceof ardm.o))) {
            localObject = ((ardm.o)localObject).getCurrentUrl();
          }
        }
      }
      else
      {
        return jqo.a((String)localObject, new String[0]);
      }
      localObject = "";
    }
  }
  
  void init()
  {
    this.DF = this.activity.getIntent().getLongExtra("appShareID", 146L);
    if (this.DF > 0L)
    {
      this.oN = ((ImageView)this.activity.findViewById(2131369989));
      if (this.oN != null) {
        break label54;
      }
    }
    label54:
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        this.oN.setOnClickListener(this);
        this.qJ = this.activity.findViewById(2131369990);
        this.qJ.setOnClickListener(this);
        a(this.c, this.activity, this.uin, aqgb.X(this.DF), 0L, this.e);
        this.fA = new LinearLayout(this.mContext);
        this.fA.setBackgroundColor(this.mContext.getResources().getColor(2131165330));
        this.fA.setOrientation(0);
        this.fA.setVisibility(8);
        this.oO = new ImageView(this.mContext);
        this.oO.setImageResource(2130842910);
        localObject1 = new LinearLayout.LayoutParams((int)jll.dp2px(this.mContext, 19.0F), (int)jll.dp2px(this.mContext, 19.0F));
        this.fB = new LinearLayout(this.mContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        this.fB.setPadding((int)jll.dp2px(this.mContext, 10.0F), 0, (int)jll.dp2px(this.mContext, 10.0F), 0);
        this.fB.setOnClickListener(this);
        this.fB.addView(this.oO, (ViewGroup.LayoutParams)localObject1);
        this.fA.addView(this.fB, (ViewGroup.LayoutParams)localObject2);
        this.oP = new ImageView(this.mContext);
        this.oP.setImageResource(2130840719);
        localObject1 = new LinearLayout.LayoutParams((int)jll.dp2px(this.mContext, 30.0F), (int)jll.dp2px(this.mContext, 30.0F));
        this.fA.addView(this.oP, (ViewGroup.LayoutParams)localObject1);
        this.AZ = new TextView(this.mContext);
        this.AZ.setPadding((int)jll.dp2px(this.mContext, 8.0F), 0, (int)jll.dp2px(this.mContext, 8.0F), 0);
        this.AZ.setSingleLine(true);
        this.AZ.setEllipsize(TextUtils.TruncateAt.END);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        this.AZ.setText(2131690408);
        this.AZ.setTextSize(2, 13.75F);
        this.AZ.setGravity(16);
        this.AZ.setTextColor(this.mContext.getResources().getColor(2131165331));
        this.fA.addView(this.AZ, (ViewGroup.LayoutParams)localObject1);
        this.Ba = new TextView(this.mContext);
        this.Ba.setTextSize(2, 14.75F);
        this.Ba.setOnClickListener(this);
        this.Ba.setBackgroundResource(2130842701);
        this.Ba.setGravity(17);
        this.Ba.setTextColor(this.mContext.getResources().getColor(2131165331));
        localObject1 = new LinearLayout.LayoutParams((int)jll.dp2px(this.mContext, 56.0F), (int)jll.dp2px(this.mContext, 30.0F));
        ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)jll.dp2px(this.mContext, 10.0F));
        this.fA.addView(this.Ba, (ViewGroup.LayoutParams)localObject1);
        this.fA.setGravity(16);
        localObject1 = new FrameLayout.LayoutParams(-1, (int)jll.dp2px(this.mContext, 44.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 80;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)jll.dp2px(this.mContext, 50.0F));
      } while (!(this.activity instanceof aqzs));
      localObject2 = ((aqzs)this.activity).c();
    } while ((localObject2 == null) || (((WebViewFragment)localObject2).a.cg == null));
    ((WebViewFragment)localObject2).a.cg.addView(this.fA, (ViewGroup.LayoutParams)localObject1);
  }
  
  public boolean isEditable()
  {
    return this.mEditable;
  }
  
  public String nP()
  {
    return this.auf;
  }
  
  public String nQ()
  {
    return this.mSourceName;
  }
  
  public String nR()
  {
    return this.aHf;
  }
  
  public String nr()
  {
    return this.aue;
  }
  
  public String ns()
  {
    return this.mCoverUrl;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      if ((paramView != this.oN) && (paramView != this.qJ)) {
        break label203;
      }
      if (!aqiz.isAppInstalled(this.activity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
        break label104;
      }
      aqiz.r(this.activity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
      localObject = "run";
      jqo.a(null, "", "webviewsourceclick", aqgb.X(this.DF), 0L, (String)localObject);
    }
    label414:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label104:
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", this.uin);
      localBundle.putString("sid", this.activity.getIntent().getStringExtra("vkey"));
      localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
      localBundle.putBoolean("autoDownload", true);
      localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
      arue.a(this.activity, String.valueOf(aqgb.X(this.DF)), 2470, localBundle);
      localObject = "setup";
      break;
      label203:
      if (paramView == this.Ba)
      {
        if (aqiz.isAppInstalled(this.activity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get()))
        {
          aqiz.r(this.activity, ((GetAppInfoProto.AndroidInfo)localObject).packName.get(), null);
          aryb.a().d(this.uin, String.valueOf(aqgb.X(this.DF)), "ANDROIDQQ.SHAREBAR", "203", false);
        }
        for (;;)
        {
          if (this.fA == null) {
            break label414;
          }
          this.fA.setVisibility(8);
          break;
          localBundle = new Bundle();
          localBundle.putString("uin", this.uin);
          localBundle.putString("sid", this.activity.getIntent().getStringExtra("vkey"));
          localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          localBundle.putBoolean("autoDownload", true);
          localBundle.putString("packageName", ((GetAppInfoProto.AndroidInfo)localObject).packName.get());
          localBundle.putString("appId", String.valueOf(aqgb.X(this.DF)));
          arue.s(this.activity, localBundle);
          aryb.a().d(this.uin, String.valueOf(aqgb.X(this.DF)), "ANDROIDQQ.SHAREBAR", "202", false);
        }
      }
      else if ((paramView == this.fB) && (this.fA != null))
      {
        this.fA.setVisibility(8);
      }
    }
  }
  
  public void reset()
  {
    this.mShareUrl = null;
    this.zc = null;
    this.aHd = null;
    this.aHe = null;
    this.aue = null;
    this.auf = null;
    this.mSourceName = null;
    this.mSourceIcon = null;
    this.aHg = null;
    this.jdField_a_of_type_Tzd = null;
    this.aHh = null;
    this.aHi = null;
    this.aHj = null;
    this.aHk = null;
    this.mEditable = false;
    this.bzk = -1;
    this.aHf = null;
  }
  
  public boolean s(Intent paramIntent)
  {
    boolean bool1 = t(paramIntent);
    boolean bool2 = u(paramIntent);
    QLog.d(TAG, 1, new Object[] { "ShareArkFromH5 shouldShareArkMsgToQQ bShareArkOpenApp=", Boolean.valueOf(bool1), ", bShareArkFromNormal=", Boolean.valueOf(bool2), " ,isShareArk=", Boolean.valueOf(this.aNu) });
    return ((this.aNu) && (bool1)) || (bool2);
  }
  
  public void tR(String paramString)
  {
    this.aHg = paramString;
  }
  
  public int uv()
  {
    return this.bzm;
  }
  
  public int uw()
  {
    return this.bzk;
  }
  
  public static final class a
  {
    public PBStringField size;
    public PBStringField url;
    
    public a(PBStringField paramPBStringField1, PBStringField paramPBStringField2)
    {
      this.url = paramPBStringField1;
      this.size = paramPBStringField2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */