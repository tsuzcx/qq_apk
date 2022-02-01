import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_COMM.COMM.Entry;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.network.SubscribeDeleteFeedRequest;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.3;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
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
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class siu
  extends ode
{
  public static String aEm = "certified_account=1";
  private String Qt;
  private WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  private sio jdField_a_of_type_Sio;
  private siu.b jdField_a_of_type_Siu$b;
  private String aEn;
  public boolean aLH;
  private san c;
  private arhz m;
  private aeay mColorNoteController;
  
  public siu(Activity paramActivity)
  {
    this(paramActivity, null);
  }
  
  public siu(Activity paramActivity, siu.a parama)
  {
    if (Integer.parseInt(QzoneConfig.getInstance().getConfig("qqsubscribe", "ShowShopConfigEntrance", "0")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aLH = bool;
      this.s = paramActivity;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new siv(this));
      }
      if (this.jdField_a_of_type_Ode$c == null) {
        this.jdField_a_of_type_Ode$c = new ode.c();
      }
      if (this.jdField_a_of_type_Siu$b == null)
      {
        this.jdField_a_of_type_Siu$b = new siu.b(parama);
        a(this.jdField_a_of_type_Siu$b);
      }
      if (this.jdField_a_of_type_Sio == null) {
        this.jdField_a_of_type_Sio = new sio(this.s);
      }
      return;
    }
  }
  
  private boolean MS()
  {
    if ((this.c == null) || (this.c.mFeed == null)) {
      return false;
    }
    return rze.bg(this.c.mFeed.poster.attr.get());
  }
  
  private boolean MT()
  {
    if ((this.c == null) || (this.c.mFeed == null) || (this.c.mFeed.poster == null) || (this.c.mFeed.poster.youZhan.size() <= 0)) {
      return false;
    }
    return ((CertifiedAccountMeta.StYouZanShop)this.c.mFeed.poster.youZhan.get(0)).type.get() > 1;
  }
  
  private boolean MU()
  {
    if ((this.c == null) || (this.c.mFeed == null)) {
      return false;
    }
    return rze.bj(this.c.mFeed.poster.attr.get());
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
  
  public static String a(san paramsan)
  {
    if (paramsan != null)
    {
      String str = paramsan.nr();
      Object localObject = str;
      if (paramsan.mExtraTypeInfo != null) {
        if (paramsan.mExtraTypeInfo.pageType != 7002)
        {
          localObject = str;
          if (paramsan.mExtraTypeInfo.pageType != 7005) {}
        }
        else
        {
          paramsan = paramsan.a().poster.desc.get();
          if ((!TextUtils.isEmpty(paramsan)) && (!paramsan.equals(acfp.m(2131720626))))
          {
            localObject = paramsan;
            if (!TextUtils.isEmpty(paramsan.trim())) {}
          }
          else
          {
            localObject = acfp.m(2131720625);
          }
        }
      }
      return localObject;
    }
    return "";
  }
  
  private List<Integer> a(san paramsan)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramsan != null) && (paramsan.mFeed != null) && (paramsan.mExtraTypeInfo != null))
    {
      paramsan.mFeed.type.get();
      int i = paramsan.mExtraTypeInfo.pageType;
      if ((i == 7000) || (i == 8001)) {
        localArrayList.add(Integer.valueOf(12));
      }
      cz(localArrayList);
      if ((i == 7002) && (MS()))
      {
        if (MU())
        {
          localArrayList.add(Integer.valueOf(27));
          sqn.c(this.c.mFeed.poster.id.get(), "auth_share", "exp_shoplist", 0, 0, new String[0]);
        }
        if (this.aLH)
        {
          localArrayList.add(Integer.valueOf(26));
          if ((this.c != null) && (this.c.mFeed != null)) {
            sqn.b(this.c.mFeed.poster.id.get(), "auth_share", "exp_shop", 0, 0, new String[0]);
          }
        }
      }
      if ((paramsan.ayK) && (!MS())) {
        localArrayList.add(Integer.valueOf(20));
      }
      int j = QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntrance", 1);
      if ((i == 7002) && (MS()) && (j == 1)) {
        localArrayList.add(Integer.valueOf(29));
      }
      if ((i == 7002) && (paramsan.aKJ)) {
        localArrayList.add(Integer.valueOf(34));
      }
      if ((i == 7001) && (MS()) && (MT())) {
        localArrayList.add(Integer.valueOf(35));
      }
      if ((i == 7000) && (MS()) && (MT())) {
        localArrayList.add(Integer.valueOf(35));
      }
      if ((this.s != null) && (this.mColorNoteController != null) && (this.mColorNoteController.shouldDisplayColorNote()))
      {
        if (!this.mColorNoteController.isColorNoteExist()) {
          break label411;
        }
        localArrayList.add(Integer.valueOf(33));
      }
    }
    return localArrayList;
    label411:
    localArrayList.add(Integer.valueOf(32));
    return localArrayList;
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((paramStFeed != null) && (!aqmr.isEmpty(paramStFeed.poster.id.get())) && (!aqmr.isEmpty(paramStFeed.id.get())) && (paramExtraTypeInfo != null)) {
      sqn.b(paramStFeed.poster.id.get(), "auth_share", "clk_" + b(paramExtraTypeInfo), paramInt, 0, new String[] { "", "", paramStFeed.id.get() });
    }
  }
  
  @NotNull
  private List[] a(san paramsan)
  {
    List localList = cn();
    paramsan = a(paramsan);
    if ((((String)spp.a().getValue("is_open_sharing", "1")).equals("1")) && (this.c != null) && (this.c.mFeed != null) && (rze.fh(this.c.mFeed.status.get()))) {}
    for (int i = 1; i != 0; i = 0) {
      return new List[] { localList, paramsan };
    }
    return new List[] { paramsan };
  }
  
  private void aT(Activity paramActivity)
  {
    if (this.m == null) {
      this.m = new arhz(paramActivity);
    }
  }
  
  public static String b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return gE(paramStFeed.poster.id.get());
  }
  
  public static String b(ExtraTypeInfo paramExtraTypeInfo)
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
  
  private void bar()
  {
    if ((this.c == null) || (this.c.mFeed == null)) {
      return;
    }
    SubscribeDeleteFeedRequest localSubscribeDeleteFeedRequest = new SubscribeDeleteFeedRequest(this.c.mFeed);
    VSNetworkHelper.a().a(localSubscribeDeleteFeedRequest, new siw(this));
    try
    {
      sqn.b(this.c.np(), "auth_share", "delete", 0, 0, new String[] { "", "", ((CertifiedAccountMeta.StUser)this.c.a.author.get()).nick.get(), this.c.getShareTitle() });
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bdG()
  {
    String str2;
    String str3;
    String str4;
    String str1;
    if ((this.c != null) && (this.c.mFeed != null) && (this.c.mExtraTypeInfo != null))
    {
      str2 = this.c.getShareTitle();
      this.c.nr();
      str3 = this.c.ns();
      str4 = this.c.np();
      switch (this.c.mExtraTypeInfo.pageType)
      {
      default: 
        str1 = null;
      }
    }
    for (;;)
    {
      String str5 = this.c.nt();
      aviz.a(3, str2, str1, null, null, str3, null, null, false, -1L).c(str4).a("lCategory", 10L).b("sUin", str5).b("sName", str5).c(this.s, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 2, null);
      return;
      str1 = a(this.c.mFeed);
      continue;
      str1 = this.c.nq();
    }
  }
  
  private void bir()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", this.c.getShareTitle());
    localBundle.putString("desc", a(this.c));
    localBundle.putString("detail_url", this.c.nq() + "&source=qzone");
    Object localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(this.c.ns());
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    if (this.c.a != null)
    {
      Object localObject2 = this.c.a.shareQzoneInfo.entrys.get();
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
      avqq.a(String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()), this.s, localBundle, null, -1);
      return;
      localObject1 = null;
    }
  }
  
  private void bis()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new six(this);
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
  }
  
  private void byT()
  {
    rzd.sW(a(this.c.mFeed, this.c.mExtraTypeInfo));
  }
  
  public static String c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/imagedetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  private List<Integer> cn()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    if (this.c.aKK)
    {
      int i = this.c.mExtraTypeInfo.pageType;
      if ((i == 7001) || (i == 7002) || (i == 7005) || (i == 7000)) {
        localArrayList.add(Integer.valueOf(30));
      }
    }
    return localArrayList;
  }
  
  public static String cutString(String paramString)
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
  
  private void cz(ArrayList<Integer> paramArrayList)
  {
    if ((this.c != null) && (this.c.mExtraTypeInfo != null) && (MS()) && ((this.c.mExtraTypeInfo.pageType == 7000) || (this.c.mExtraTypeInfo.pageType == 7001) || (this.c.mExtraTypeInfo.pageType == 8001))) {
      paramArrayList.add(Integer.valueOf(25));
    }
  }
  
  public static String d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/carousel/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  public static String e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return String.format("https://h5.qzone.qq.com/subscription/videodetail/%s?_proxy=1&_wv=16777217&_wwv=4&userid=%s&time=%d", new Object[] { paramStFeed.id.get(), paramStFeed.poster.id.get(), Long.valueOf(paramStFeed.createTime.get()) });
  }
  
  public static String gE(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/homepage/%s?_proxy=1&_wv=16777217&_wwv=4", new Object[] { paramString });
  }
  
  private Intent n()
  {
    if ((this.c == null) || (this.c.a == null) || (TextUtils.isEmpty(this.c.a.shareCardInfo.get()))) {
      return null;
    }
    Intent localIntent = new Intent(this.s.getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c.a.shareCardInfo.get());
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
      localIntent.putExtras(aqjn.a.a((String)localObject, str2, str1, str3, adqr.getDensity(), null, null));
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
  
  private Intent o()
  {
    if ((this.c == null) || (this.c.mFeed == null) || (TextUtils.isEmpty(this.c.mFeed.poster.nick.get()))) {
      return null;
    }
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.putExtra("isWebCompShare", true);
    localIntent.setClass(this.s.getApplicationContext(), ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", this.s.getString(2131697475));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", this.c.nq());
    localIntent.putExtra("title", this.c.nt());
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { this.c.nt() }));
    localIntent.putExtra("desc", cutString(this.c.nu()));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", this.c.mFeed.poster.id.get());
    localIntent.putExtra("pluginName", "public_account");
    localIntent.putExtra("pubUin", this.c.mFeed.poster.id.get());
    localIntent.putExtra("image_url_remote", this.c.mFeed.poster.icon.get());
    localIntent.putExtra("struct_share_key_content_action_DATA", r(this.c.mFeed.poster.id.get(), this.c.mFeed.poster.nick.get(), this.c.mFeed.poster.icon.get()));
    AbsStructMsg localAbsStructMsg = anre.a(localIntent.getExtras());
    if (localAbsStructMsg != null)
    {
      localAbsStructMsg.mMsgServiceID = 152;
      localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      localIntent.putExtra("from_card", true);
      return localIntent;
    }
    return null;
  }
  
  public static String r(String paramString1, String paramString2, String paramString3)
  {
    return "mqqapi://qsubscribe" + "/" + "openhomepage" + "?" + "src_type=internal" + "&version=1" + "&uid=" + paramString1 + "&nick=" + paramString2 + "&icon=" + paramString3;
  }
  
  private void shareToQQ()
  {
    int i = 21;
    if (this.c.mExtraTypeInfo != null) {}
    Intent localIntent;
    switch (this.c.mExtraTypeInfo.pageType)
    {
    default: 
      localIntent = null;
      if (localIntent == null) {
        if (this.s != null) {
          QQToast.a(this.s, acfp.m(2131715061), 0).show();
        }
      }
      break;
    }
    while (this.s == null)
    {
      return;
      localIntent = n();
      break;
      localIntent = n();
      i = 1;
      break;
      localIntent = o();
      i = 1;
      break;
    }
    this.s.startActivityForResult(localIntent, i);
  }
  
  private void yx(int paramInt)
  {
    if ((this.c == null) || (this.s == null)) {
      return;
    }
    Object localObject = this.c.nq();
    String str1 = cutString(this.c.getShareTitle());
    String str2 = cutString(this.c.nr());
    HashMap localHashMap = new HashMap(1);
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      QQToast.a(this.s, 1, acfp.m(2131715058), 0).show();
      return;
    }
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1)
      {
        rwt.ez(0, i);
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        bis();
        localObject = new SubscribeShareHelper.3(this, localHashMap, str1, str2, (String)localObject, paramInt);
        if (TextUtils.isEmpty(this.c.ns()))
        {
          ((Runnable)localObject).run();
          return;
        }
        aT(this.s);
        this.m.setMessage(2131695695);
        this.m.show();
        ThreadManager.post(new SubscribeShareHelper.4(this, localHashMap, (Runnable)localObject), 8, null, false);
        return;
      }
      i = -1;
    }
  }
  
  public ShareActionSheetBuilder a(san paramsan, aeay paramaeay)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) || (this.jdField_a_of_type_Siu$b == null) || (this.jdField_a_of_type_Ode$c == null)) {
      return null;
    }
    san localsan = paramsan;
    if (paramsan == null) {
      localsan = new san();
    }
    this.c = localsan;
    this.mColorNoteController = paramaeay;
    if ((this.c.mFeed == null) || (TextUtils.isEmpty(this.c.mFeed.poster.nick.get())))
    {
      QQToast.a(this.s, acfp.m(2131715072), 0).show();
      return null;
    }
    paramsan = a(localsan);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(paramsan, this.jdField_a_of_type_Ode$c));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    rwv.a().a(new SharePanelShowStateEvent(true));
    return this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  }
  
  public void dismiss()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
    if (this.jdField_a_of_type_Sio != null) {
      this.jdField_a_of_type_Sio.release();
    }
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
    }
  }
  
  public void th(String paramString)
  {
    this.aEn = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt);
  }
  
  class b
    extends ode.a
  {
    private final siu.a a;
    
    public b(siu.a parama)
    {
      this.a = parama;
    }
    
    protected boolean c(Integer paramInteger)
    {
      if ((siu.a(siu.this) == null) || (siu.this.s == null)) {
        return false;
      }
      if (this.a != null) {
        this.a.onClick(paramInteger.intValue());
      }
      switch (paramInteger.intValue())
      {
      }
      for (;;)
      {
        if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (siu.a(siu.this) != null)) {
          siu.a(siu.this, siu.a(siu.this).mFeed, paramInteger.intValue() - 1, siu.a(siu.this).mExtraTypeInfo);
        }
        return super.c(paramInteger);
        siu.a(siu.this);
        continue;
        siu.b(siu.this);
        continue;
        siu.a(siu.this, paramInteger.intValue());
        continue;
        siu.c(siu.this);
        continue;
        siu.d(siu.this);
        continue;
        siu.d(siu.this);
        continue;
        siu.e(siu.this);
        continue;
        if ((siu.a(siu.this) != null) && (siu.a(siu.this).mFeed != null))
        {
          sqn.b(siu.a(siu.this).mFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          rzd.sW(ryy.gu(siu.a(siu.this).mFeed.poster.id.get()));
          continue;
          if ((siu.a(siu.this) != null) && (siu.a(siu.this).mFeed != null))
          {
            rzd.sW(siu.a(siu.this).mFeed.poster.yzOrderPage.get());
            sqn.c(siu.a(siu.this).mFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((siu.a(siu.this) != null) && (siu.a(siu.this).mFeed != null))
            {
              rzd.sW(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", siu.a(siu.this).mFeed.poster.id.get()));
              sqn.b(siu.a(siu.this).mFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              siu.a(siu.this).b(siu.a(siu.this));
              if ((siu.a(siu.this) != null) && (siu.a(siu.this).mFeed != null))
              {
                sqn.b(siu.a(siu.this).mFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, siu.a(siu.this).nt(), siu.a(siu.this).getShareTitle() });
                continue;
                rzd.sW("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", siu.a(siu.this).mFeed.poster.id.get()));
                sqn.c(siu.a(siu.this).mFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                Intent localIntent = new Intent();
                localIntent.putExtra("postUin", siu.a(siu.this).mFeed.poster.id.get());
                localIntent.putExtra("has_shop", true);
                localIntent.putExtra("is_edit", true);
                localIntent.putExtra("feed", siu.a(siu.this).mFeed.toByteArray());
                avpw.i(siu.this.s, localIntent, 3);
                continue;
                if (siu.a(siu.this) != null) {
                  if (siu.a(siu.this).canAddColorNote())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    siu.a(siu.this).insertColorNote();
                  }
                  else
                  {
                    siu.a(siu.this).onCannotAdd();
                    continue;
                    if ((siu.a(siu.this) != null) && (siu.a(siu.this).isColorNoteExist()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131691723), 5000).show();
                      siu.a(siu.this).deleteColorNote();
                      QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     siu
 * JD-Core Version:    0.7.0.1
 */