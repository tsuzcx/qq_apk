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
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qconn.protofile.appType.MsgIconsurl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class zfy
  implements View.OnClickListener, bfic
{
  public static String a;
  public static boolean f;
  protected float a;
  protected int a;
  protected long a;
  public abwu a;
  public Activity a;
  protected Context a;
  protected Handler a;
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public bagf a;
  public bety a;
  bfah jdField_a_of_type_Bfah;
  bfih jdField_a_of_type_Bfih = new bfih();
  public CustomWebView a;
  public AppInterface a;
  protected GetAppInfoProto.GetAppinfoResponse a;
  public SoftReference<Bitmap> a;
  public WeakReference<begg> a;
  protected BusinessObserver a;
  protected boolean a;
  public int b;
  Activity b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  public String b;
  protected boolean b;
  protected int c;
  protected ImageView c;
  public String c;
  protected boolean c;
  public int d;
  protected String d;
  protected boolean d;
  volatile int e;
  public String e;
  public boolean e;
  protected String f;
  protected String g;
  public boolean g;
  public String h;
  public String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  public String n;
  String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  protected String v = "";
  protected String w = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "share";
  }
  
  public zfy(AppInterface paramAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new zgb(this);
    this.jdField_a_of_type_AndroidOsHandler = new zgc(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Share secret init share");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.n = paramAppInterface.getAccount();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Float = paramActivity.getResources().getDisplayMetrics().density;
    if ((paramActivity instanceof begg)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((begg)paramActivity);
    }
    while (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "Error! mWebUiUtils still null! " + paramActivity.toString());
      return;
      if ((paramActivity instanceof begc))
      {
        paramAppInterface = ((begc)paramActivity).b();
        if (paramAppInterface != null)
        {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
        }
        else if ((paramActivity instanceof QQBrowserActivity))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "Caution! mWebUiUtils == null! maybe webviewfragment is invisible!");
          paramAppInterface = (QQBrowserActivity)paramActivity;
          localObject = paramAppInterface.getSupportFragmentManager();
          if (localObject != null)
          {
            localObject = ((FragmentManager)localObject).getFragments();
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              int i1 = paramAppInterface.jdField_d_of_type_Int;
              if ((i1 >= 0) && (i1 < ((List)localObject).size())) {}
              for (;;)
              {
                QLog.w(jdField_a_of_type_JavaLangString, 2, "cast Fragment (index: " + i1 + ") to WebViewFragment");
                if (!(((List)localObject).get(i1) instanceof WebViewFragment)) {
                  break label383;
                }
                this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((WebViewFragment)((List)localObject).get(i1));
                break;
                i1 = 0;
              }
              label383:
              QLog.e(jdField_a_of_type_JavaLangString, 2, "cast Fragment (index: " + i1 + ") is null!");
            }
          }
        }
      }
    }
    paramAppInterface = (begg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramAppInterface != null) && ((paramAppInterface instanceof belt)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((belt)paramAppInterface).getWebView();
      if (QLog.isColorLevel())
      {
        paramAppInterface = jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_AndroidContentContext = paramActivity.getApplicationContext();
      a();
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
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
    paramPBRepeatMessageField = a(paramPBRepeatMessageField);
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty())) {
      return a(paramPBRepeatMessageField, paramInt);
    }
    return null;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if (b(paramString1)) {}
    do
    {
      return paramString1;
      if (b(paramString2)) {
        return paramString2;
      }
    } while (!b(paramString3));
    return paramString3;
  }
  
  public static final String a(List<zgd> paramList, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i2;
    int i1;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (!paramList.isEmpty())
      {
        i2 = paramList.size();
        i1 = 0;
        localObject1 = null;
        if (i1 >= i2) {
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
    for (localObject2 = (zgd)paramList.get(i1);; localObject3 = localObject1)
    {
      try
      {
        int i3 = Integer.valueOf(((zgd)localObject2).b.get()).intValue();
        if (i3 >= paramInt)
        {
          localObject2 = ((zgd)localObject2).a.get();
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              i1 = i2 - 1;
              localObject1 = localObject2;
              if (i1 < 0) {
                break label270;
              }
              localObject2 = (zgd)paramList.get(i1);
            }
          }
          i1 += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.valueOf(((zgd)localObject2).b.get()).intValue();
          if (i2 >= paramInt) {
            break label267;
          }
          localObject2 = ((zgd)localObject2).a.get();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label260;
          }
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity findAppIcon() iconUrl = " + localObject1);
          }
          return localObject1;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          if (!QLog.isColorLevel()) {
            break label260;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException2.getMessage());
          i1 -= 1;
        }
        localNumberFormatException1 = localNumberFormatException1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, localNumberFormatException1.getMessage());
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
  
  private HashMap<String, String> a(String paramString)
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
      ArkAppCenter.c(jdField_a_of_type_JavaLangString, String.format("getArkInfo, parse param failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  public static List<zgd> a(PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GetAppInfoProto.MsgIconsurl localMsgIconsurl = (GetAppInfoProto.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new zgd(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetSummary. forWhat = " + paramInt + ", title=" + this.jdField_e_of_type_JavaLangString + ", desc=" + this.h + ", thumb=" + this.i + ", bitmap=" + paramBitmap);
    }
    Object localObject1;
    Object localObject2;
    int i2;
    int i1;
    if (this.jdField_b_of_type_AndroidAppActivity == null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
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
        i2 = 0;
        if (TextUtils.isEmpty(paramString4)) {
          i2 = 1;
        }
        i1 = i2;
        localObject1 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString2 = this.jdField_c_of_type_JavaLangString;
          i1 = i2;
          localObject1 = paramString2;
          if (TextUtils.isEmpty(paramString2))
          {
            i1 = i2 | 0x2;
            localObject1 = paramString2;
          }
        }
        i2 = i1;
        if (TextUtils.isEmpty(paramString1)) {
          i2 = i1 | 0x4;
        }
        ((Bundle)localObject2).putString("report_type", "102");
        ((Bundle)localObject2).putString("act_type", "94");
        paramString2 = new StringBuilder().append("");
        if (i2 != 0) {
          break label653;
        }
        i1 = 0;
        label268:
        ((Bundle)localObject2).putString("intext_1", i1);
        ((Bundle)localObject2).putString("intext_3", "" + bfif.b(paramInt));
        ((Bundle)localObject2).putString("intext_2", "" + i2);
        ((Bundle)localObject2).putString("stringext_1", paramString3);
        bfhz.a().a((Bundle)localObject2, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
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
      if (this.jdField_d_of_type_Int != -1) {
        ((Bundle)localObject1).putInt("iUrlInfoFrm", this.jdField_d_of_type_Int);
      }
      ((Bundle)localObject1).putLong("share_begin_time", beir.jdField_b_of_type_Long);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof begc)) {
        break label3714;
      }
      paramString1 = ((begc)this.jdField_a_of_type_AndroidAppActivity).b();
      if (paramString1 == null) {
        break label659;
      }
      ((Bundle)localObject1).putString("strurt_msgid", paramString1.j);
      ((Bundle)localObject1).putString("struct_uin", paramString1.i);
      ((Bundle)localObject1).putString("struct_url", paramString1.jdField_g_of_type_JavaLangString);
      ((Bundle)localObject1).putBoolean("from_web", true);
      if ((paramString1.k == null) || ("".equals(paramString1.k))) {
        break label3714;
      }
      ((Bundle)localObject1).putString("source_puin", paramString1.k);
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt != 0) || (!bjev.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null))) {
        ybk.a(1, 2131689512);
      }
      return;
      this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      break;
      label653:
      i1 = 1;
      break label268;
      label659:
      paramInt = 1;
      continue;
      label664:
      Intent localIntent;
      if (paramInt == 1)
      {
        localIntent = new Intent(this.jdField_b_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        paramBitmap = null;
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof begc))
        {
          paramBitmap = ((begc)this.jdField_a_of_type_AndroidAppActivity).b();
          if ((paramBitmap == null) || (paramBitmap.b() == null)) {
            break label3704;
          }
          localObject1 = (beir)paramBitmap.b().a(4);
          if (localObject1 == null) {
            break label3704;
          }
          paramBitmap = ((beir)localObject1).a();
          localObject1 = ((beir)localObject1).jdField_e_of_type_JavaLangString;
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
          i1 = paramBitmap.getInt("to_uin_type");
          paramInt = i1;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetSummary() called : toUin = " + (String)localObject2 + ", uinType = " + i1);
            localObject1 = localObject2;
            paramInt = i1;
          }
        }
        for (;;)
        {
          label1005:
          boolean bool1;
          boolean bool2;
          if ((localObject1 != null) && (((String)localObject1).length() >= 5))
          {
            localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
            localIntent.putExtra("toUin", (String)localObject1);
            localIntent.putExtra("uinType", paramInt);
            if ((paramBitmap != null) && (!paramBitmap.isEmpty()))
            {
              paramBitmap = paramBitmap.getString("to_uin_name");
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetSummary() called : nickName = " + paramBitmap);
              }
              localIntent.putExtra("nickName", paramBitmap);
            }
            localIntent.putExtra("key_flag_from_plugin", true);
            localIntent.putExtra("isWebCompShare", true);
            bool1 = b(localIntent);
            bool2 = c(localIntent);
            i1 = 0;
            if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
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
            long l1;
            try
            {
              localObject2 = Uri.parse(this.jdField_c_of_type_JavaLangString);
              localObject1 = ((Uri)localObject2).getHost();
              paramBitmap = null;
              if (((Uri)localObject2).isHierarchical()) {
                paramBitmap = ((Uri)localObject2).getQueryParameter("_pflag");
              }
              paramInt = i1;
              if (!TextUtils.isEmpty(paramBitmap)) {
                if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject1))
                {
                  paramInt = i1;
                  if (!"url.cn".equalsIgnoreCase((String)localObject1)) {}
                }
                else
                {
                  i2 = Integer.parseInt(paramBitmap);
                  paramInt = i1;
                  if ((i2 >> 4 & 0x1) == 1) {
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
              localObject3 = "http://url.cn/PWkhNu";
              localObject4 = ((Resources)localObject9).getString(2131696891);
              continue;
              paramBitmap = "plugin";
              localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { str2 });
              localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str2 });
              localObject3 = "http://url.cn/JS8oE7";
              continue;
              localObject6 = "";
              localObject4 = " ";
              localObject1 = null;
              localObject3 = null;
              localObject2 = null;
              localObject7 = "http://url.cn/UQoBHn";
              l1 = 801097412L;
              paramBitmap = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
              localObject5 = paramBitmap;
              if (!TextUtils.isEmpty(paramBitmap)) {
                continue;
              }
              localObject5 = this.l;
              localObject2 = this.m;
              paramBitmap = (Bitmap)localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                break label1833;
              }
              if (!jdField_f_of_type_Boolean) {
                break label2103;
              }
              localObject5 = "QQ看点";
              localObject8 = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
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
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser))
            {
              str2 = ((PublicAccountBrowser)this.jdField_a_of_type_AndroidAppActivity).a();
              localObject9 = this.jdField_a_of_type_AndroidAppActivity.getResources();
              localObject4 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("source_name");
              if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
                if (jdField_f_of_type_Boolean)
                {
                  localObject5 = "QQ看点";
                  localObject6 = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
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
                    localObject4 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696895);
                    localObject3 = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
                    paramBitmap = "plugin";
                    localObject1 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                    localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
                  }
                  bdna.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 146, "web_share", str2, paramString4, paramString1, paramString2, String.format(((Resources)localObject9).getString(2131696875), new Object[] { paramString1 }), paramString3, "web", null, null, null, paramBitmap, null, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, "", localIntent, -1, null, -1L);
                  i1 = 0;
                  if (TextUtils.isEmpty(paramString4)) {
                    i1 = 1;
                  }
                  paramInt = i1;
                  if (TextUtils.isEmpty(paramString2)) {
                    paramInt = i1 | 0x2;
                  }
                  i1 = paramInt;
                  if (TextUtils.isEmpty(paramString1)) {
                    i1 = paramInt | 0x4;
                  }
                  paramString1 = new Bundle();
                  paramString1.putString("report_type", "102");
                  paramString1.putString("act_type", "14");
                  paramString1.putString("intext_3", "1");
                  paramString1.putString("intext_2", "" + i1);
                  paramString1.putString("stringext_1", "" + paramString3);
                  bfhz.a().a(paramString1, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
                  return;
                  localIntent.putExtra("isWebCompShare", true);
                  localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
                  break label1005;
                }
              }
            }
            label1833:
            if (paramInt != 0)
            {
              localObject4 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696895);
              localObject2 = "plugin";
              localObject5 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              localObject3 = "mqqapi://readinjoy/open?src_type=internal&version=1&target=1";
              paramBitmap = "http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0";
            }
            for (;;)
            {
              if ("QQ空间".equals(localObject4)) {}
              for (localObject1 = "http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/logo_16.png";; localObject1 = paramBitmap)
              {
                paramBitmap = (Bitmap)localObject6;
                if ((this.jdField_a_of_type_AndroidAppActivity instanceof begc))
                {
                  localObject8 = ((begc)this.jdField_a_of_type_AndroidAppActivity).b();
                  paramBitmap = (Bitmap)localObject6;
                  if (localObject8 != null)
                  {
                    if ("".equals(((WebViewFragment)localObject8).k)) {
                      break label2244;
                    }
                    paramBitmap = ((WebViewFragment)localObject8).k;
                  }
                }
                label1942:
                if (baic.a(paramString3))
                {
                  localObject7 = "web";
                  localObject4 = alud.a(2131714265);
                  if (TextUtils.isEmpty(aoxg.a().h()))
                  {
                    localObject1 = baic.jdField_b_of_type_JavaLangString;
                    label1980:
                    localObject2 = baic.jdField_d_of_type_JavaLangString;
                    paramInt = 95;
                    l1 = baic.jdField_a_of_type_Long;
                    localObject6 = localObject1;
                    localObject1 = localObject7;
                  }
                }
                for (;;)
                {
                  if ((bool2) || (bool1))
                  {
                    i1 = 38;
                    label2015:
                    localObject7 = this.jdField_b_of_type_AndroidAppActivity;
                    localObject8 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696875, new Object[] { paramString1 });
                    if (this.jdField_a_of_type_Bagf != null) {
                      break label2273;
                    }
                  }
                  label2103:
                  label2244:
                  label2273:
                  for (i2 = -1;; i2 = 1001)
                  {
                    bdna.a((Context)localObject7, i1, paramInt, "web_share", paramBitmap, paramString4, paramString1, paramString2, (String)localObject8, paramString3, "web", null, null, null, (String)localObject1, null, (String)localObject5, (String)localObject3, (String)localObject2, (String)localObject4, "", localIntent, i2, (String)localObject6, l1);
                    break;
                    localObject2 = this.jdField_b_of_type_AndroidAppActivity.getString(2131696891);
                    paramBitmap = MttLoader.getBrowserInfo(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
                    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramBitmap.packageName))) {}
                    for (paramBitmap = paramBitmap.packageName + "://" + paramString3;; paramBitmap = "com.tencent.mtt://" + paramString3)
                    {
                      localObject3 = "tencent100446242://" + paramString3;
                      localObject1 = paramBitmap;
                      paramBitmap = (Bitmap)localObject2;
                      localObject2 = "http://url.cn/PWkhNu";
                      localObject4 = "app";
                      break;
                    }
                    paramBitmap = ((WebViewFragment)localObject8).i;
                    break label1942;
                    localObject1 = aoxg.a().h();
                    break label1980;
                    i1 = 1001;
                    break label2015;
                  }
                  if ((paramInt == 3) || (paramInt == 4)) {
                    if (paramInt == 3)
                    {
                      this.jdField_e_of_type_Int = 1;
                      if (this.jdField_a_of_type_Bfah == null)
                      {
                        this.jdField_a_of_type_Bfah = new zga(this, paramString3);
                        WXShareHelper.a().a(this.jdField_a_of_type_Bfah);
                      }
                      this.o = String.valueOf(System.currentTimeMillis());
                      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (!baic.jdField_b_of_type_JavaUtilMap.containsKey(this.jdField_f_of_type_JavaLangString))) {
                        break label2586;
                      }
                      paramString4 = (Integer)baic.jdField_b_of_type_JavaUtilMap.get(this.jdField_f_of_type_JavaLangString);
                      if (paramString4 == null) {
                        break label3631;
                      }
                      i1 = paramString4.intValue();
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
                          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat! ~~~ SUMMARY_FOR_SEND_TO_WECHAT!");
                        }
                        WXShareHelper.a().a(this.jdField_a_of_type_Bfah);
                        if ((a() != null) && (a().l != null))
                        {
                          paramString2 = "pages/detail/detail?scene=" + a().l;
                          if (QLog.isColorLevel()) {
                            QLog.d(jdField_a_of_type_JavaLangString, 2, "curFilePath=" + paramString2);
                          }
                          paramString1 = baic.a(this.jdField_g_of_type_JavaLangString);
                          if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (!baic.d(this.jdField_g_of_type_JavaLangString))) {
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
                          WXShareHelper.a().a(paramString2, "gh_252c5f06840b", paramString1, this.jdField_e_of_type_JavaLangString, this.h, paramString3);
                          return;
                          this.jdField_e_of_type_Int = 2;
                          break;
                          if ((paramString3 != null) && (paramString3.contains("doc/")))
                          {
                            i1 = 1;
                            break label2396;
                          }
                          if ((paramString3 == null) || (!paramString3.contains("sheet/"))) {
                            break label3625;
                          }
                          i1 = 2;
                          break label2396;
                          paramString2 = "pages/detail/detail?url=" + paramString3;
                          break label2487;
                          label2655:
                          paramString1 = baic.a(i1);
                          continue;
                          label2664:
                          paramString1 = baic.a(i1);
                        }
                        label2671:
                        break;
                      }
                      if (paramInt != 4) {
                        break;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToWeChat_Circle!~~~ SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE!");
                      }
                      WXShareHelper.a().a(this.jdField_a_of_type_Bfah);
                      paramString2 = WXShareHelper.a();
                      paramString4 = this.o;
                      paramBitmap = this.jdField_e_of_type_JavaLangString;
                      localObject1 = baic.b(i1);
                      if (TextUtils.isEmpty(this.h))
                      {
                        paramString1 = paramString3;
                        if (paramInt != 3) {
                          break label2770;
                        }
                      }
                      for (paramInt = 0;; paramInt = 1)
                      {
                        paramString2.b(paramString4, paramBitmap, (Bitmap)localObject1, paramString1, paramString3, paramInt);
                        return;
                        paramString1 = this.h;
                        break;
                      }
                    }
                    label2487:
                    label2770:
                    paramString4 = WXShareHelper.a();
                    label2586:
                    localObject1 = this.o;
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
                      paramString4.b((String)localObject1, paramString1, paramBitmap, paramString2, paramString3, paramInt);
                      return;
                      break;
                    }
                    if (paramInt == 5)
                    {
                      if ((this.jdField_c_of_type_Int == -1) || (TextUtils.isEmpty(this.k)))
                      {
                        azqs.b(null, "CliOper", "", "", "0X8006277", "0X8006277", 0, 0, "", "", "", "");
                        QLog.w(jdField_a_of_type_JavaLangString, 1, "onGetSummary invalid shareInfo");
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
                      ((Bundle)localObject1).putString("cover_url", this.k);
                      ((Bundle)localObject1).putString("source_name", this.l);
                      ((Bundle)localObject1).putInt("article_id", this.jdField_c_of_type_Int);
                      paramString1 = new ArrayList(1);
                      paramString1.add(paramString4);
                      ((Bundle)localObject1).putStringArrayList("image_url", paramString1);
                      ((Bundle)localObject1).putLong("req_share_id", 0L);
                      if (this.jdField_b_of_type_AndroidAppActivity == null) {
                        this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
                      }
                      if (bkbw.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_AndroidAppActivity, (Bundle)localObject1, null, 0)) {
                        break;
                      }
                      ybk.a(1, 2131689512);
                      return;
                    }
                    if ((paramInt == 6) || (paramInt == 7))
                    {
                      bfyh.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
                      return;
                    }
                    if (paramInt == 8)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
                      }
                      paramString2 = BaseApplicationImpl.getContext().getPackageManager();
                      try
                      {
                        paramString2 = paramString2.getApplicationInfo("com.sina.weibo", 8192);
                        if (QLog.isColorLevel()) {
                          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:true");
                        }
                        ThreadManager.executeOnSubThread(new Share.4(this, paramString4, paramString1, paramString3, paramString2));
                      }
                      catch (PackageManager.NameNotFoundException paramString2)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
                          }
                          try
                          {
                            paramString1 = URLEncoder.encode(paramString1, "UTF-8");
                            paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
                            paramString2 = URLEncoder.encode(paramString3, "UTF-8");
                            paramString1 = paramString1 + "&url=" + paramString2;
                            paramString2 = URLEncoder.encode(paramString4, "UTF-8");
                            paramString1 = paramString1 + "&pic=" + paramString2;
                            paramString1 = paramString1 + "&_wv=3";
                            paramString2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                            paramString2.putExtra("url", paramString1);
                            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString2);
                            if (QLog.isColorLevel()) {
                              QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
                            }
                          }
                          catch (Exception paramString1)
                          {
                            Toast.makeText(BaseApplicationImpl.getContext(), alud.a(2131714266), 1).show();
                            paramString1.printStackTrace();
                          }
                        }
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
                      return;
                    }
                    if (paramInt != 9) {
                      break;
                    }
                    paramString2 = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
                    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FastWebActivity))
                    {
                      paramString3 = owy.a().a();
                      paramString1 = null;
                      if (paramString3 != null) {
                        paramString1 = paramString3.a(this.w);
                      }
                      paramString3 = new Bundle();
                      if (paramString1 != null)
                      {
                        paramString3.putLong("publishAccountUin", paramString1.d);
                        paramString3.putString("publishAccountName", paramString1.jdField_e_of_type_JavaLangString);
                      }
                      pej.a().a(this.jdField_a_of_type_AndroidAppActivity, null, 1, this.w, this.jdField_e_of_type_JavaLangString, this.h, this.i, this.v, paramString3);
                      bivo.a(paramString2, 42, 2);
                      return;
                    }
                    if ((this.jdField_a_of_type_AndroidAppActivity instanceof begc))
                    {
                      paramString1 = ((begc)this.jdField_a_of_type_AndroidAppActivity).b();
                      if (paramString1 != null) {
                        if (TextUtils.isEmpty(paramString1.k)) {
                          paramString1 = paramString1.i;
                        }
                      }
                    }
                    for (;;)
                    {
                      if ((this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser)) {
                        paramString1 = ((PublicAccountBrowser)this.jdField_a_of_type_AndroidAppActivity).a();
                      }
                      ThreadManager.getUIHandler().post(new Share.5(this, paramString1));
                      break;
                      paramString1 = paramString1.k;
                      continue;
                      paramString1 = "";
                    }
                    label3625:
                    i1 = 1;
                    continue;
                    label3631:
                    i1 = 1;
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
    Bundle localBundle = bdjt.a(paramString2, paramString3, "0.0.0.1", paramString4, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, null, null);
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "ShareArkFromH5 buildArkShareIntent bundle = ", localBundle.toString() });
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
    localGetAppinfoRequest.qqv.set("8.3.5");
    localGetAppinfoRequest.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString2)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString2);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, bfiw.class);
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
    localGetAppinfoRequest.qqv.set("8.3.5");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong3);
    localGetAppinfoRequest.signature.set(paramString2);
    localGetAppinfoRequest.channel_source.set(paramLong2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, bfiw.class);
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
    localGetAppinfoRequest.qqv.set("8.3.5");
    localGetAppinfoRequest.setHasFlag(true);
    localGetAppinfoRequest.md5time.set(paramLong2);
    localGetAppinfoRequest.signature.set(paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(paramString3);
    }
    localGetAppinfoRequest.referer.set(2);
    paramContext = new NewIntent(paramContext, bfiw.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("data", localGetAppinfoRequest.toByteArray());
    paramContext.putExtra("cmd", "ConnAuthSvr.get_app_info");
    paramContext.putExtra("timeout", 15000L);
    paramContext.setObserver(paramBusinessObserver);
    paramAppInterface.startServlet(paramContext);
  }
  
  public static List<zgd> b(PBRepeatMessageField<appType.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        appType.MsgIconsurl localMsgIconsurl = (appType.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new zgd(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  private void b(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = new HashMap();
    if (paramInt == 1)
    {
      if (((paramString.length() > 180) || ((!(this.jdField_a_of_type_AndroidAppActivity instanceof PublicAccountBrowser)) && (paramString.length() > 60))) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof TeamWorkDocEditBrowserActivity)) && (!baic.a(paramString))) {
        ((HashMap)localObject).put("url", paramString);
      }
      if ((this.i != null) && (this.i.length() > 40)) {
        ((HashMap)localObject).put("thumb", this.i);
      }
    }
    Bitmap localBitmap;
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null)
    {
      localBitmap = null;
      if ((!paramBoolean) || ((paramInt != 3) && (paramInt != 4)) || (localBitmap != null) || (TextUtils.isEmpty(this.i))) {
        break label208;
      }
    }
    for (;;)
    {
      if (((!this.jdField_e_of_type_Boolean) && (((HashMap)localObject).size() <= 0) && (!bool)) || (paramInt == 2) || (paramInt == 9)) {
        break label214;
      }
      ThreadManager.executeOnNetWorkThread(new Share.2(this, (HashMap)localObject, paramInt, paramString, bool));
      return;
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      break;
      label208:
      bool = false;
    }
    label214:
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
    localObject = this.jdField_e_of_type_JavaLangString;
    String str1 = this.h;
    String str2 = this.i;
    if (paramBoolean) {}
    for (;;)
    {
      a(paramInt, (String)localObject, str1, paramString, str2, localBitmap);
      return;
      localBitmap = null;
    }
  }
  
  private boolean b(Intent paramIntent)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    String str1 = localBundle.getString("forward_ark_app_name");
    String str2 = localBundle.getString("forward_ark_app_view");
    if ((this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      a(paramIntent, a(a(), this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString), str1, str2, localBundle.getString("forward_ark_app_meta"), localBundle.getString("forward_ark_app_config"), "", localBundle.getString("forward_appId_ark_from_sdk"), localBundle.getString("struct_share_key_source_name"), localBundle.getString("struct_share_key_source_action_data"), localBundle.getString("struct_share_key_source_a_action_data"), localBundle.getString("struct_share_key_source_url"));
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("app")) && (paramString.contains("view"));
  }
  
  private boolean c(Intent paramIntent)
  {
    try
    {
      String str2 = a(a(), this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      Object localObject = a(str2);
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
      ArkAppCenter.c(jdField_a_of_type_JavaLangString, String.format("shareArkFromUrl, parse json failed, err=%s", new Object[] { paramIntent.getMessage() }));
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public bagf a()
  {
    return this.jdField_a_of_type_Bagf;
  }
  
  public bety a()
  {
    begg localbegg;
    int i1;
    if (this.jdField_a_of_type_Bety == null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label128;
      }
      localbegg = (begg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localbegg == null) || (!(localbegg instanceof bels)) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        break label134;
      }
      i1 = ((bels)localbegg).b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_Bety.c(2131689506);
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog show time :" + l1);
      }
      return this.jdField_a_of_type_Bety;
      label128:
      localbegg = null;
      break;
      label134:
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914);
      }
      else
      {
        i1 = (int)(50.0F * this.jdField_a_of_type_Float + 0.5F);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "use default yOffset when getting share progress dialog.");
      }
    }
  }
  
  public String a()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        return "";
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (begg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((localObject != null) && ((localObject instanceof belt))) {
            localObject = ((belt)localObject).b();
          }
        }
      }
      else
      {
        return ndq.a((String)localObject, new String[0]);
      }
      localObject = "";
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("appShareID", 146L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131369000));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
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
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131369001);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.n, bdff.b(this.jdField_a_of_type_Long), 0L, this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165267));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841717);
        localObject1 = new LinearLayout.LayoutParams((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840148);
        localObject1 = new LinearLayout.LayoutParams((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 30.0F), (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690190);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.75F);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165268));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 14.75F);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841513);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165268));
        localObject1 = new LinearLayout.LayoutParams((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 56.0F), (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 30.0F));
        ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
        localObject1 = new FrameLayout.LayoutParams(-1, (int)mww.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
        ((FrameLayout.LayoutParams)localObject1).gravity = 80;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof begc));
      localObject2 = ((begc)this.jdField_a_of_type_AndroidAppActivity).b();
    } while ((localObject2 == null) || (((WebViewFragment)localObject2).a.a == null));
    ((WebViewFragment)localObject2).a.a.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(int paramInt1, int paramInt2)
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
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWebviewSetFontSize: " + ((JSONObject)localObject).toString());
      }
      localObject = WebViewPlugin.toJsScript("QQWebviewSetFontSize", (JSONObject)localObject, null);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "QQWebviewSetFontSize jason error");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
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
        if ((paramInt3 == 1) && ((paramInt2 == 0) || (paramInt2 == 1)) && (this.jdField_a_of_type_Bagf != null)) {
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "share finished jason error");
        }
      }
    }
  }
  
  public void a(abwu paramabwu)
  {
    this.jdField_a_of_type_Abwu = paramabwu;
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
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
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", androidInfo is null, OR androidInfo.packName is null !!!");
          }
        }
        else
        {
          arrayOfByte = ndd.a(paramContext, paramGetAppinfoResponse, "GET", null, null);
          if (arrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo(): iconUrl = " + paramGetAppinfoResponse + ", imageBytes is NULL!!!!!!!!");
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      GetAppInfoProto.AndroidInfo localAndroidInfo;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramContext.getMessage());
        return;
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
        paramGetAppinfoResponse = localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          paramGetAppinfoResponse = localBitmap;
          localMessage.obj = localBitmap;
          paramGetAppinfoResponse = localBitmap;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = paramGetAppinfoResponse;
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
              localGetAppinfoResponse = paramGetAppinfoResponse;
            }
          }
          paramContext = ndd.a(paramContext, String.format("http://openmobile.qq.com/api/get_app_info_by_id?appid=%d", new Object[] { Long.valueOf(bdff.b(this.jdField_a_of_type_Long)) }), "GET", null, null);
          if (!TextUtils.isEmpty(paramContext)) {
            break label366;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity urlResponse is null");
          return;
          paramContext = new JSONObject(paramContext);
          if (paramContext.getInt("retcode") == 0) {
            break label402;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity retcode is -1");
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
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
          }
        }
        if (bdiv.a(paramContext, localAndroidInfo.packName.get()))
        {
          paramContext = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
          try
          {
            paramContext.obj = localBitmap;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramContext);
            return;
          }
          catch (OutOfMemoryError paramContext)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity getAppInfo image decode failed: oom ===== ");
        }
      }
    }
    label366:
  }
  
  public void a(bagf parambagf)
  {
    this.jdField_a_of_type_Bagf = parambagf;
  }
  
  public void a(begg parambegg)
  {
    boolean bool = true;
    if (parambegg == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambegg);
    }
    parambegg = (begg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((parambegg != null) && ((parambegg instanceof belt)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((belt)parambegg).getWebView();
      if (QLog.isColorLevel())
      {
        parambegg = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder().append(" Share secret webview is null?");
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          break label122;
        }
        bool = true;
        QLog.d(parambegg, 2, bool);
      }
    }
    label122:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidAppActivity.getApplicationContext();
        a();
        return;
        bool = false;
      }
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append(" Share secret baseInterface is null?");
    if (parambegg == null) {}
    for (;;)
    {
      QLog.d((String)localObject, 2, bool);
      break;
      bool = false;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      this.v = paramArticleInfo.mArticleContentUrl;
      this.w = paramArticleInfo.innerUniqueID;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "shareUrl = ", this.v, " , rowKey = ", this.w });
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "setReadInJoyShareData but articleInfo is null.");
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      paramString = "0";
    }
    for (;;)
    {
      a().show();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.p, new String[] { paramString });
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
  
  public boolean a()
  {
    QZoneShareData localQZoneShareData;
    if (this.jdField_b_of_type_AndroidAppActivity == null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")) {
        this.jdField_b_of_type_AndroidAppActivity = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      }
    }
    else
    {
      localQZoneShareData = new QZoneShareData();
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break label193;
      }
      localObject = null;
      label57:
      localQZoneShareData.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.h)) {
        break label201;
      }
    }
    label193:
    label201:
    for (Object localObject = null;; localObject = this.h)
    {
      localQZoneShareData.jdField_c_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.i);
      localQZoneShareData.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      localQZoneShareData.jdField_d_of_type_JavaLangString = a();
      if (this.jdField_d_of_type_Int != -1) {
        localQZoneShareData.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
      }
      localQZoneShareData.jdField_b_of_type_Long = beir.jdField_b_of_type_Long;
      localQZoneShareData.jdField_b_of_type_Int = 2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        localQZoneShareData.m = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      }
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break label209;
      }
      bjev.a(this.jdField_b_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
      this.jdField_b_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
      break;
      localObject = this.jdField_e_of_type_JavaLangString;
      break label57;
    }
    label209:
    ybk.a(1, 2131689512);
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    boolean bool1 = b(paramIntent);
    boolean bool2 = c(paramIntent);
    QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "ShareArkFromH5 shouldShareArkMsgToQQ bShareArkOpenApp=", Boolean.valueOf(bool1), ", bShareArkFromNormal=", Boolean.valueOf(bool2), " ,isShareArk=", Boolean.valueOf(this.jdField_g_of_type_Boolean) });
    return ((this.jdField_g_of_type_Boolean) && (bool1)) || (bool2);
  }
  
  public boolean a(String paramString)
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
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ybk.a(1, 2131689505);
      return false;
    }
    Bundle localBundle;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Bfih.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfih.jdField_b_of_type_Int = bfif.b(paramInt);
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "90");
      localStringBuilder = new StringBuilder().append("");
      if (this.jdField_a_of_type_Bfih.jdField_a_of_type_Int != 0) {
        break label407;
      }
    }
    label407:
    for (int i1 = 0;; i1 = 1)
    {
      localBundle.putString("intext_1", i1);
      localBundle.putString("intext_3", "" + this.jdField_a_of_type_Bfih.jdField_b_of_type_Int);
      localBundle.putString("intext_2", "" + this.jdField_a_of_type_Bfih.jdField_a_of_type_Int);
      localBundle.putString("stringext_1", "" + paramString);
      bfhz.a().a(localBundle, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      this.jdField_a_of_type_Bfih.jdField_a_of_type_Boolean = false;
      if (bdin.d(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSummary Fail_Network. title=" + this.jdField_e_of_type_JavaLangString + ", desc=" + this.h + ", thumb=" + this.i);
      }
      ybk.a(1, 2131694768);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "84");
      paramString.putString("intext_1", "" + bfif.a(1));
      paramString.putString("intext_3", "1");
      paramString.putString("intext_4", "0");
      bfhz.a().a(paramString, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      return false;
    }
    jdField_f_of_type_Boolean = false;
    if (Pattern.compile("http(s)?://([a-zA-Z])*\\.mp\\.qq\\.com/((kan/(article|show|album))|(group/show))(\\.)*").matcher(paramString).find()) {
      jdField_f_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("share_tool_trace", 2, "url is " + paramString);
      QLog.d("share_tool_trace", 2, "readInjoy JS work=" + jdField_f_of_type_Boolean);
    }
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString.length() > 30)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString.substring(0, 29);
    }
    if ((!TextUtils.isEmpty(this.h)) && (this.h != null) && (this.h.length() > 40)) {
      this.h = this.h.substring(0, 39);
    }
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.h)))
    {
      b(paramString, paramInt, paramBoolean);
      return true;
    }
    a().c(2131689506);
    boolean bool = TextUtils.isEmpty(this.w);
    if ((!this.jdField_a_of_type_Bety.isShowing()) && (bool)) {
      this.jdField_a_of_type_Bety.show();
    }
    ThreadManager.executeOnNetWorkThread(new Share.1(this, paramString, paramInt, paramBoolean));
    return true;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +13 -> 17
    //   7: aload_0
    //   8: aload_3
    //   9: invokevirtual 1690	zfy:a	(Ljava/lang/String;)Z
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 375	zfy:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   22: aload_0
    //   23: aload_2
    //   24: putfield 379	zfy:h	Ljava/lang/String;
    //   27: aload_0
    //   28: aload 4
    //   30: putfield 383	zfy:i	Ljava/lang/String;
    //   33: aload_0
    //   34: getfield 383	zfy:i	Ljava/lang/String;
    //   37: ifnull +43 -> 80
    //   40: aload_0
    //   41: getfield 383	zfy:i	Ljava/lang/String;
    //   44: ldc_w 1692
    //   47: invokevirtual 1695	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +30 -> 80
    //   53: aload_0
    //   54: new 155	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 1697
    //   64: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 383	zfy:i	Ljava/lang/String;
    //   71: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: putfield 383	zfy:i	Ljava/lang/String;
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 1137	zfy:jdField_e_of_type_Boolean	Z
    //   85: aload 5
    //   87: ifnull +173 -> 260
    //   90: aload 5
    //   92: ldc_w 1699
    //   95: invokevirtual 547	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   98: iconst_1
    //   99: if_icmpne +161 -> 260
    //   102: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +69 -> 174
    //   108: ldc_w 1701
    //   111: iconst_2
    //   112: new 155	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1703
    //   122: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: getfield 375	zfy:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   129: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1705
    //   135: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 379	zfy:h	Ljava/lang/String;
    //   142: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 381
    //   148: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 383	zfy:i	Ljava/lang/String;
    //   155: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 1707
    //   161: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_3
    //   165: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 168	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: getfield 76	zfy:jdField_a_of_type_Bfih	Lbfih;
    //   178: iconst_1
    //   179: putfield 1641	bfih:jdField_a_of_type_Boolean	Z
    //   182: aload_0
    //   183: getfield 76	zfy:jdField_a_of_type_Bfih	Lbfih;
    //   186: iconst_0
    //   187: putfield 1645	bfih:jdField_a_of_type_Int	I
    //   190: aload 4
    //   192: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +430 -> 625
    //   198: aload_0
    //   199: getfield 76	zfy:jdField_a_of_type_Bfih	Lbfih;
    //   202: astore 4
    //   204: aload 4
    //   206: aload 4
    //   208: getfield 1645	bfih:jdField_a_of_type_Int	I
    //   211: iconst_1
    //   212: ior
    //   213: putfield 1645	bfih:jdField_a_of_type_Int	I
    //   216: aload_2
    //   217: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +18 -> 238
    //   223: aload_0
    //   224: getfield 76	zfy:jdField_a_of_type_Bfih	Lbfih;
    //   227: astore_2
    //   228: aload_2
    //   229: aload_2
    //   230: getfield 1645	bfih:jdField_a_of_type_Int	I
    //   233: iconst_2
    //   234: ior
    //   235: putfield 1645	bfih:jdField_a_of_type_Int	I
    //   238: aload_1
    //   239: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifeq +18 -> 260
    //   245: aload_0
    //   246: getfield 76	zfy:jdField_a_of_type_Bfih	Lbfih;
    //   249: astore_1
    //   250: aload_1
    //   251: aload_1
    //   252: getfield 1645	bfih:jdField_a_of_type_Int	I
    //   255: iconst_4
    //   256: ior
    //   257: putfield 1645	bfih:jdField_a_of_type_Int	I
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 1135	zfy:jdField_a_of_type_JavaLangRefSoftReference	Ljava/lang/ref/SoftReference;
    //   265: aload 5
    //   267: ifnull +263 -> 530
    //   270: getstatic 62	zfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   273: iconst_1
    //   274: ldc_w 1709
    //   277: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: aload 5
    //   283: ldc_w 1711
    //   286: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: putfield 744	zfy:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   292: aload_0
    //   293: aload 5
    //   295: ldc_w 1713
    //   298: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   301: putfield 773	zfy:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   304: aload_0
    //   305: aload 5
    //   307: ldc_w 1699
    //   310: iconst_m1
    //   311: invokevirtual 1716	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   314: putfield 80	zfy:jdField_d_of_type_Int	I
    //   317: aload_0
    //   318: aload 5
    //   320: ldc_w 813
    //   323: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: putfield 800	zfy:k	Ljava/lang/String;
    //   329: aload_0
    //   330: aload 5
    //   332: ldc_w 607
    //   335: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: putfield 662	zfy:l	Ljava/lang/String;
    //   341: aload_0
    //   342: aload 5
    //   344: ldc_w 1718
    //   347: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: putfield 664	zfy:m	Ljava/lang/String;
    //   353: aload_0
    //   354: aload 5
    //   356: ldc_w 815
    //   359: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: invokestatic 597	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   365: putfield 78	zfy:jdField_c_of_type_Int	I
    //   368: aload_0
    //   369: aload 5
    //   371: ldc_w 1720
    //   374: invokevirtual 1723	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   377: putfield 69	zfy:jdField_a_of_type_Boolean	Z
    //   380: aload_0
    //   381: aload 5
    //   383: ldc_w 1725
    //   386: invokevirtual 1723	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   389: putfield 1727	zfy:jdField_b_of_type_Boolean	Z
    //   392: aload_0
    //   393: getfield 1729	zfy:jdField_d_of_type_Boolean	Z
    //   396: ifne +15 -> 411
    //   399: aload_0
    //   400: aload 5
    //   402: ldc_w 1731
    //   405: invokevirtual 1723	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   408: putfield 1729	zfy:jdField_d_of_type_Boolean	Z
    //   411: aload_0
    //   412: aload 5
    //   414: ldc_w 1733
    //   417: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: putfield 1734	zfy:j	Ljava/lang/String;
    //   423: aload_0
    //   424: aload 5
    //   426: ldc_w 1418
    //   429: invokevirtual 541	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: invokestatic 597	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   435: putfield 71	zfy:jdField_a_of_type_Int	I
    //   438: aload_0
    //   439: aload 5
    //   441: ldc_w 1736
    //   444: invokevirtual 1723	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   447: putfield 1738	zfy:jdField_c_of_type_Boolean	Z
    //   450: aload_0
    //   451: getfield 127	zfy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   454: ifnull +76 -> 530
    //   457: aload_0
    //   458: getfield 127	zfy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   461: instanceof 1131
    //   464: ifeq +66 -> 530
    //   467: aload_0
    //   468: getfield 127	zfy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   471: checkcast 1131	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   474: invokevirtual 1739	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   477: checkcast 1741	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   480: astore_1
    //   481: aload_1
    //   482: ifnull +48 -> 530
    //   485: aload_1
    //   486: aload_0
    //   487: getfield 69	zfy:jdField_a_of_type_Boolean	Z
    //   490: aload_0
    //   491: getfield 71	zfy:jdField_a_of_type_Int	I
    //   494: invokevirtual 1744	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZI)V
    //   497: aload_1
    //   498: aload_0
    //   499: getfield 1729	zfy:jdField_d_of_type_Boolean	Z
    //   502: invokevirtual 1747	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:f_	(Z)V
    //   505: aload_1
    //   506: invokevirtual 1749	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:o	()V
    //   509: aload_1
    //   510: iconst_1
    //   511: aload_0
    //   512: getfield 1734	zfy:j	Ljava/lang/String;
    //   515: aconst_null
    //   516: invokevirtual 1752	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   519: aload_0
    //   520: getfield 1738	zfy:jdField_c_of_type_Boolean	Z
    //   523: ifeq +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 1754	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:j	()V
    //   530: ldc_w 1756
    //   533: aload_0
    //   534: getfield 375	zfy:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   537: invokestatic 1759	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: ldc_w 1761
    //   543: aload_0
    //   544: getfield 379	zfy:h	Ljava/lang/String;
    //   547: invokestatic 1759	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: ldc_w 1763
    //   553: aload_0
    //   554: getfield 383	zfy:i	Ljava/lang/String;
    //   557: invokestatic 1759	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: ldc_w 1765
    //   563: aload_3
    //   564: invokestatic 1759	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: ldc_w 1767
    //   570: aload_0
    //   571: getfield 80	zfy:jdField_d_of_type_Int	I
    //   574: invokestatic 1768	cooperation/qzone/LocalMultiProcConfig:putInt	(Ljava/lang/String;I)V
    //   577: aload_0
    //   578: getfield 222	zfy:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   581: ifnull +16 -> 597
    //   584: ldc_w 1770
    //   587: aload_0
    //   588: getfield 222	zfy:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   591: invokevirtual 1614	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   594: invokestatic 1759	cooperation/qzone/LocalMultiProcConfig:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: new 507	android/content/Intent
    //   600: dup
    //   601: ldc_w 1772
    //   604: invokespecial 1773	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   607: astore_1
    //   608: aload_0
    //   609: getfield 127	zfy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   612: ifnull +11 -> 623
    //   615: aload_0
    //   616: getfield 127	zfy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   619: aload_1
    //   620: invokevirtual 1776	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   623: iconst_1
    //   624: ireturn
    //   625: aload_0
    //   626: iconst_2
    //   627: putfield 1777	zfy:jdField_b_of_type_Int	I
    //   630: goto -414 -> 216
    //   633: astore_1
    //   634: getstatic 62	zfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   637: iconst_1
    //   638: ldc_w 1779
    //   641: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_0
    //   645: iconst_m1
    //   646: putfield 78	zfy:jdField_c_of_type_Int	I
    //   649: goto -281 -> 368
    //   652: astore_1
    //   653: getstatic 62	zfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   656: iconst_1
    //   657: ldc_w 1781
    //   660: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: goto -295 -> 368
    //   666: astore_1
    //   667: aload_0
    //   668: aconst_null
    //   669: putfield 1734	zfy:j	Ljava/lang/String;
    //   672: getstatic 62	zfy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   675: iconst_1
    //   676: ldc_w 1783
    //   679: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: goto -259 -> 423
    //   685: astore_1
    //   686: aload_0
    //   687: iconst_m1
    //   688: putfield 71	zfy:jdField_a_of_type_Int	I
    //   691: goto -253 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	this	zfy
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
    if (!bdin.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      ybk.a(1, 2131694768);
      return false;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      ybk.a(1, 2131689505);
      return false;
    }
    if (this.jdField_a_of_type_Bety == null)
    {
      paramString7 = (begg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((paramString7 == null) || (!(paramString7 instanceof bels))) {
        break label456;
      }
    }
    label139:
    label186:
    label192:
    label456:
    for (int i1 = ((bels)paramString7).b();; i1 = 0)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, i1);
      this.jdField_a_of_type_Bety.c(2131689506);
      boolean bool;
      if (paramString4.length() > 180)
      {
        bool = true;
        if ((paramString5 == null) || (paramString5.length() <= 40)) {
          break label186;
        }
        i1 = 1;
        if ((!bool) && (i1 == 0)) {
          break label192;
        }
        this.jdField_a_of_type_Bety.show();
        new Share.6(this, bool, paramString5, paramString1, paramString2, paramString3, paramString4, paramString6).start();
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        i1 = 0;
        break label139;
        paramString7 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString8 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        String str = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696875), new Object[] { paramString2 });
        bdna.a(this.jdField_a_of_type_AndroidAppActivity, 1001, 146, "struct_msg_from_h5", paramString1, paramString5, paramString2, paramString3, str, paramString4, "web", null, null, null, "plugin", null, paramString7, paramString8, "http://url.cn/JS8oE7", paramString6, null);
        int i2 = 0;
        if (TextUtils.isEmpty(paramString5)) {
          i2 = 1;
        }
        i1 = i2;
        if (TextUtils.isEmpty(paramString3)) {
          i1 = i2 | 0x2;
        }
        i2 = i1;
        if (TextUtils.isEmpty(paramString2)) {
          i2 = i1 | 0x4;
        }
        paramString1 = new Bundle();
        paramString1.putString("report_type", "102");
        paramString1.putString("act_type", "14");
        paramString1.putString("intext_3", "1");
        paramString1.putString("intext_2", "" + i2);
        paramString1.putString("stringext_1", "" + paramString4);
        bfhz.a().a(paramString1, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.h = null;
    this.i = null;
    this.l = null;
    this.m = null;
    this.p = null;
    this.jdField_a_of_type_Abwu = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.j = null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    }
    if (this.jdField_a_of_type_Bfah != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_Bfah);
      this.jdField_a_of_type_Bfah = null;
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.i;
  }
  
  public void d()
  {
    if (this.p != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.p, new String[] { "7" });
    }
  }
  
  public String e()
  {
    return this.k;
  }
  
  public void e()
  {
    if (this.p != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.p, new String[] { "8" });
    }
  }
  
  public String f()
  {
    return this.l;
  }
  
  public void f()
  {
    if (this.p != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.p, new String[] { "9" });
    }
  }
  
  public String g()
  {
    return this.j;
  }
  
  public void g()
  {
    if (this.q != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.q, new String[] { "0" });
    }
  }
  
  public void h()
  {
    if (this.r != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.r, new String[] { "1" });
    }
  }
  
  public void i()
  {
    if (this.s != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.s, new String[] { "2" });
    }
  }
  
  public void j()
  {
    if (this.t != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.t, new String[] { "3" });
    }
  }
  
  public void onClick(View paramView)
  {
    GetAppInfoProto.AndroidInfo localAndroidInfo;
    if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localAndroidInfo = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      if ((paramView != this.jdField_a_of_type_AndroidWidgetImageView) && (paramView != this.jdField_a_of_type_AndroidViewView)) {
        break label196;
      }
      if (!bdiv.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get())) {
        break label97;
      }
      bdiv.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
      paramView = "run";
      ndq.a(null, "", "webviewsourceclick", bdff.b(this.jdField_a_of_type_Long), 0L, paramView);
    }
    label97:
    do
    {
      for (;;)
      {
        return;
        paramView = new Bundle();
        paramView.putString("uin", this.n);
        paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
        paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
        paramView.putBoolean("autoDownload", true);
        paramView.putString("packageName", localAndroidInfo.packName.get());
        bfir.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(bdff.b(this.jdField_a_of_type_Long)), 2470, paramView);
        paramView = "setup";
        break;
        if (paramView != this.jdField_b_of_type_AndroidWidgetTextView) {
          break label407;
        }
        if (bdiv.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get()))
        {
          bdiv.a(this.jdField_a_of_type_AndroidAppActivity, localAndroidInfo.packName.get(), null);
          bfnj.a().a(this.n, String.valueOf(bdff.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "203", false);
        }
        while (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          return;
          paramView = new Bundle();
          paramView.putString("uin", this.n);
          paramView.putString("sid", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("vkey"));
          paramView.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
          paramView.putBoolean("autoDownload", true);
          paramView.putString("packageName", localAndroidInfo.packName.get());
          paramView.putString("appId", String.valueOf(bdff.b(this.jdField_a_of_type_Long)));
          bfir.b(this.jdField_a_of_type_AndroidAppActivity, paramView);
          bfnj.a().a(this.n, String.valueOf(bdff.b(this.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "202", false);
        }
      }
    } while ((paramView != this.jdField_b_of_type_AndroidWidgetLinearLayout) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    label196:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    label407:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zfy
 * JD-Core Version:    0.7.0.1
 */