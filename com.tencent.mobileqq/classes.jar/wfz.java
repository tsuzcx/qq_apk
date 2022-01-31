import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_COMM.COMM.Entry;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.3;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.4;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class wfz
  extends rug
{
  public static String a;
  private alrv jdField_a_of_type_Alrv;
  private bbms jdField_a_of_type_Bbms;
  private bbsh jdField_a_of_type_Bbsh;
  private vxn jdField_a_of_type_Vxn;
  private wfw jdField_a_of_type_Wfw;
  private wge jdField_a_of_type_Wge;
  public boolean a;
  private String b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "certified_account=1";
  }
  
  public wfz(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public wfz(Activity paramActivity, wgd paramwgd)
  {
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowShopConfigEntrance", "0")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      if (this.jdField_a_of_type_Bahv == null)
      {
        this.jdField_a_of_type_Bahv = new bahv(paramActivity);
        this.jdField_a_of_type_Bahv.a(new wga(this));
      }
      if (this.jdField_a_of_type_Rul == null) {
        this.jdField_a_of_type_Rul = new rul();
      }
      if (this.jdField_a_of_type_Wge == null)
      {
        this.jdField_a_of_type_Wge = new wge(this, paramwgd);
        a(this.jdField_a_of_type_Wge);
      }
      return;
    }
  }
  
  private Intent a()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get()))) {
      return null;
    }
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.putExtra("isWebCompShare", true);
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", this.jdField_a_of_type_AndroidAppActivity.getString(2131629930));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", this.jdField_a_of_type_Vxn.b());
    localIntent.putExtra("title", this.jdField_a_of_type_Vxn.f());
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131630985, new Object[] { this.jdField_a_of_type_Vxn.f() }));
    localIntent.putExtra("desc", a(this.jdField_a_of_type_Vxn.g()));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
    localIntent.putExtra("pluginName", "public_account");
    localIntent.putExtra("pubUin", this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
    localIntent.putExtra("image_url_remote", this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get());
    localIntent.putExtra("struct_share_key_content_action_DATA", a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get()));
    AbsStructMsg localAbsStructMsg = awuw.a(localIntent.getExtras());
    if (localAbsStructMsg != null)
    {
      localAbsStructMsg.mMsgServiceID = 152;
      localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      localIntent.putExtra("from_card", true);
      return localIntent;
    }
    return null;
  }
  
  public static String a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return "mqqapi://qsubscribe" + "/" + "opendetail" + "?" + "src_type=internal" + "&version=1" + "&uin=" + paramStFeed.poster.id.get() + "&feedId=" + paramStFeed.id.get() + "&type=" + paramStFeed.type.get() + "&width=" + paramStFeed.video.width.get() + "&height=" + paramStFeed.video.height.get() + "&createtime=" + paramStFeed.createTime.get();
  }
  
  private static String a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramExtraTypeInfo != null) && (paramExtraTypeInfo.pageType == 7002)) {
      return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&usertype=%s", new Object[] { paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
    }
    return String.format("https://h5.qzone.qq.com/subscription/report/%s?_proxy=1&_wv=3&userid=%s&usertype=%s", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Integer.valueOf(paramStFeed.poster.type.get()) });
  }
  
  public static String a(ExtraTypeInfo paramExtraTypeInfo)
  {
    if (paramExtraTypeInfo == null) {
      return "";
    }
    switch (paramExtraTypeInfo.pageType)
    {
    default: 
      return "";
    case 7002: 
      return "person";
    case 7000: 
      return "video";
    case 8001: 
      return "image";
    }
    return "multi_pic";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.length() > 30) {
        break;
      }
      str = paramString;
    } while (paramString.getBytes().length <= 100);
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return "mqqapi://qsubscribe" + "/" + "openhomepage" + "?" + "src_type=internal" + "&version=1" + "&uid=" + paramString1 + "&nick=" + paramString2 + "&icon=" + paramString3;
  }
  
  private List<Integer> a(vxn paramvxn)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramvxn != null) && (paramvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (paramvxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      paramvxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.type.get();
      int k = paramvxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      if ((k == 7000) || (k == 8001)) {
        localArrayList.add(Integer.valueOf(12));
      }
      a(localArrayList);
      if ((k == 7002) && (b()))
      {
        if (d())
        {
          localArrayList.add(Integer.valueOf(27));
          wye.b(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localArrayList.add(Integer.valueOf(26));
          if ((this.jdField_a_of_type_Vxn != null) && (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
            wye.a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
          }
        }
      }
      if ((paramvxn.jdField_a_of_type_Boolean) && (!b())) {
        localArrayList.add(Integer.valueOf(20));
      }
      int i = QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntrance", 1);
      if ((k == 7002) && (b()) && (i == 1)) {
        localArrayList.add(Integer.valueOf(29));
      }
      if ((k == 7002) && (paramvxn.b)) {
        localArrayList.add(Integer.valueOf(34));
      }
      if (k == 7001)
      {
        i = j;
        if (((String)wwt.a().a("is_open_sharing", "0")).equals("1"))
        {
          i = j;
          if (this.jdField_a_of_type_Vxn != null)
          {
            i = j;
            if (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
            {
              i = j;
              if (vvz.a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.get())) {
                i = 1;
              }
            }
          }
        }
        if (i != 0) {
          localArrayList.add(Integer.valueOf(30));
        }
        if ((b()) && (c())) {
          localArrayList.add(Integer.valueOf(35));
        }
      }
      if ((k == 7000) && (b()) && (c())) {
        localArrayList.add(Integer.valueOf(35));
      }
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_Alrv != null) && (this.jdField_a_of_type_Alrv.a()))
      {
        if (!this.jdField_a_of_type_Alrv.c()) {
          break label505;
        }
        localArrayList.add(Integer.valueOf(33));
      }
    }
    return localArrayList;
    label505:
    localArrayList.add(Integer.valueOf(32));
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Vxn.b();
    String str1 = a(this.jdField_a_of_type_Vxn.c());
    String str2 = a(this.jdField_a_of_type_Vxn.d());
    HashMap localHashMap = new HashMap(1);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131648848), 0).a();
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131655008;
    }
    for (;;)
    {
      if (i != -1)
      {
        vvp.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131655009;
        }
      }
      else
      {
        g();
        localObject = new SubscribeShareHelper.3(this, localHashMap, str1, str2, (String)localObject, paramInt);
        if (TextUtils.isEmpty(this.jdField_a_of_type_Vxn.e()))
        {
          ((Runnable)localObject).run();
          return;
        }
        a(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bbms.c(2131628457);
        this.jdField_a_of_type_Bbms.show();
        ThreadManager.post(new SubscribeShareHelper.4(this, localHashMap, (Runnable)localObject), 8, null, false);
        return;
      }
      i = -1;
    }
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramStFeed != null) && (!baip.a(paramStFeed.poster.id.get())) && (!baip.a(paramStFeed.id.get())) && (paramExtraTypeInfo != null)) {
      wye.a(paramStFeed.poster.id.get(), "auth_share", "clk_" + a(paramExtraTypeInfo), paramInt, 0, new String[] { "", "", paramStFeed.id.get() });
    }
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(paramActivity);
    }
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    if ((this.jdField_a_of_type_Vxn != null) && (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (b()) && ((this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7000) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 7001) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType == 8001))) {
      paramArrayList.add(Integer.valueOf(25));
    }
  }
  
  private Intent b()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get()))) {
      return null;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareCardInfo.get());
      Object localObject = localJSONObject.getJSONObject("aio");
      localJSONObject = localJSONObject.getJSONObject("popUp");
      String str1 = ((JSONObject)localObject).getString("app");
      String str2 = ((JSONObject)localObject).getString("ver");
      String str3 = ((JSONObject)localObject).getString("view");
      String str4 = ((JSONObject)localObject).getString("meta");
      localObject = ((JSONObject)localObject).getString("prompt");
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", str1);
      localIntent.putExtra("forward_ark_app_view", str3);
      localIntent.putExtra("forward_ark_app_ver", str2);
      localIntent.putExtra("forward_ark_app_prompt", (String)localObject);
      localIntent.putExtra("forward_ark_app_meta", str4);
      localObject = localJSONObject.getString("app");
      str1 = localJSONObject.getString("ver");
      str2 = localJSONObject.getString("view");
      str3 = localJSONObject.getString("meta");
      localJSONObject.getString("prompt");
      localIntent.putExtras(baev.a((String)localObject, str2, str1, str3, alem.a(), null, null));
      return localIntent;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static String b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return b(paramStFeed.poster.id.get());
  }
  
  public static String b(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", new Object[] { paramString });
  }
  
  private List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    if ((((String)wwt.a().a("is_open_sharing", "0")).equals("1")) && (this.jdField_a_of_type_Vxn != null) && (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (vvz.a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.get()))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localArrayList.add(Integer.valueOf(2));
        localArrayList.add(Integer.valueOf(3));
        localArrayList.add(Integer.valueOf(4));
        localArrayList.add(Integer.valueOf(5));
      }
      return localArrayList;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return false;
    }
    return vvz.a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
  }
  
  public static String c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.youZhan.size() <= 0)) {
      return false;
    }
    return ((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.youZhan.get(0)).type.get() > 1;
  }
  
  public static String d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return;
    }
    SubscribeDeleteFeedRequest localSubscribeDeleteFeedRequest = new SubscribeDeleteFeedRequest(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    VSNetworkHelper.a().a(localSubscribeDeleteFeedRequest, new wgb(this));
    try
    {
      wye.a(this.jdField_a_of_type_Vxn.a(), "auth_share", "delete", 0, 0, new String[] { "", "", ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.author.get()).nick.get(), this.jdField_a_of_type_Vxn.c() });
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_Vxn == null) || (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
      return false;
    }
    return vvz.d(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.attr.get());
  }
  
  public static String e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private void e()
  {
    String str2;
    String str3;
    String str4;
    String str1;
    if ((this.jdField_a_of_type_Vxn != null) && (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      str2 = this.jdField_a_of_type_Vxn.c();
      this.jdField_a_of_type_Vxn.d();
      str3 = this.jdField_a_of_type_Vxn.e();
      str4 = this.jdField_a_of_type_Vxn.a();
      switch (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      default: 
        str1 = null;
      }
    }
    for (;;)
    {
      String str5 = this.jdField_a_of_type_Vxn.f();
      bfhl.a(3, str2, str1, null, null, str3, null, null, false, -1L).c(str4).a("lCategory", 10L).b("sUin", str5).b("sName", str5).c(this.jdField_a_of_type_AndroidAppActivity, str4, 2, null);
      return;
      str1 = a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      continue;
      str1 = this.jdField_a_of_type_Vxn.b();
    }
  }
  
  private void f()
  {
    vvy.a(a(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Bbsh != null) {
      return;
    }
    this.jdField_a_of_type_Bbsh = new wgc(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
  }
  
  private void h()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.jdField_a_of_type_Vxn.c());
    localBundle.putString("desc", this.jdField_a_of_type_Vxn.d());
    localBundle.putString("detail_url", this.jdField_a_of_type_Vxn.b() + "&source=qzone");
    Object localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(this.jdField_a_of_type_Vxn.e());
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    if (this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare != null)
    {
      Object localObject2 = this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StShare.shareQzoneInfo.entrys.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new SerializableMap();
        HashMap localHashMap = new HashMap();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          COMM.Entry localEntry = (COMM.Entry)((Iterator)localObject2).next();
          localHashMap.put(localEntry.key.get(), localEntry.value.get());
        }
        ((SerializableMap)localObject1).setMap(localHashMap);
      }
    }
    for (;;)
    {
      localBundle.putSerializable("share_qzone_info", (Serializable)localObject1);
      bfqn.a(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.jdField_a_of_type_AndroidAppActivity, localBundle, null, -1);
      return;
      localObject1 = null;
    }
  }
  
  private void i()
  {
    int i = 21;
    if (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) {}
    Intent localIntent;
    switch (this.jdField_a_of_type_Vxn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
    {
    default: 
      localIntent = null;
      if (localIntent == null) {
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, ajjy.a(2131648851), 0).a();
        }
      }
      break;
    }
    while (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      return;
      localIntent = b();
      break;
      localIntent = b();
      i = 1;
      break;
      localIntent = a();
      i = 1;
      break;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, i);
  }
  
  public bahv a(vxn paramvxn, alrv paramalrv)
  {
    if ((this.jdField_a_of_type_Bahv == null) || (this.jdField_a_of_type_Wge == null) || (this.jdField_a_of_type_Rul == null)) {
      return null;
    }
    Object localObject = paramvxn;
    if (paramvxn == null) {
      localObject = new vxn();
    }
    this.jdField_a_of_type_Vxn = ((vxn)localObject);
    this.jdField_a_of_type_Alrv = paramalrv;
    if ((this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Vxn.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get())))
    {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, ajjy.a(2131648862), 0).a();
      return null;
    }
    paramvxn = this.jdField_a_of_type_Bahv;
    paramalrv = b();
    localObject = a((vxn)localObject);
    rul localrul = this.jdField_a_of_type_Rul;
    paramvxn.a(a(new List[] { paramalrv, localObject }, localrul));
    this.jdField_a_of_type_Bahv.a(this);
    this.jdField_a_of_type_Bahv.a();
    wcj.a().a(new SharePanelShowStateEvent(true));
    return this.jdField_a_of_type_Bahv;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bahv != null) && (this.jdField_a_of_type_Bahv.a())) {
      this.jdField_a_of_type_Bahv.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bahv != null) {
      this.jdField_a_of_type_Bahv.a(paramBoolean);
    }
  }
  
  public void b()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
    if (this.jdField_a_of_type_Wfw != null) {
      this.jdField_a_of_type_Wfw.d();
    }
  }
  
  public void f(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfz
 * JD-Core Version:    0.7.0.1
 */