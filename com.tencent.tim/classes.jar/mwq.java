import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class mwq
  implements nyy.b
{
  private int CP;
  private ausj F;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private jym jdField_a_of_type_Jym;
  private mwj jdField_a_of_type_Mwj;
  private mwq.a jdField_a_of_type_Mwq$a;
  private boolean afO;
  private boolean anU;
  private boolean anW = true;
  private boolean apR;
  private boolean apS;
  private Bitmap cd;
  private VideoInfo e;
  private URLDrawable jdField_i_of_type_ComTencentImageURLDrawable;
  private MqqHandler jdField_i_of_type_MqqOsMqqHandler = new mwq.c(null);
  private VideoInfo k;
  private QQAppInterface mApp;
  private Activity mContext;
  private int mFromType;
  private int mSceneType = 0;
  odg mShareHelper;
  private nze rijWatchWordPresenter;
  
  public mwq(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, int paramInt1, boolean paramBoolean, mwq.a parama, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.mContext = paramActivity;
    this.mFromType = paramInt1;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Mwq$a = parama;
    this.anU = paramBoolean;
    this.jdField_a_of_type_Jym = ((jym)this.mApp.getBusinessHandler(136));
    this.jdField_a_of_type_Jym.aBf();
    this.mSceneType = paramInt2;
    this.rijWatchWordPresenter = new nze(new nzb());
    this.rijWatchWordPresenter.a(this);
  }
  
  private void J(VideoInfo paramVideoInfo)
  {
    a(paramVideoInfo, "", 0, "");
  }
  
  public static Intent a(VideoInfo paramVideoInfo)
  {
    AbsStructMsg localAbsStructMsg = null;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("detail_url", paramVideoInfo.webUrl);
    localIntent.putExtra("title", paramVideoInfo.title);
    localIntent.putExtra("image_url_remote", paramVideoInfo.coverUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { paramVideoInfo.title }));
    if (paramVideoInfo.busiType == 6)
    {
      localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
      localIntent.putExtra("app_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localAbsStructMsg = anre.a(localIntent.getExtras());
      localAbsStructMsg.mMsgServiceID = 83;
    }
    for (;;)
    {
      if (localAbsStructMsg != null) {
        localIntent.putExtra("stuctmsg_bytes", localAbsStructMsg.getBytes());
      }
      return localIntent;
      if (paramVideoInfo.busiType == 7)
      {
        localIntent.putExtra("app_name", "QQ搜索");
        localIntent.putExtra("desc", paramVideoInfo.summary);
        localAbsStructMsg = anre.a(localIntent.getExtras());
        localAbsStructMsg.mMsgServiceID = 1;
      }
    }
  }
  
  public static Bundle a(VideoInfo paramVideoInfo, int paramInt)
  {
    String str1 = null;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("VINFO", paramVideoInfo.vid);
    ((Bundle)localObject).putString("TINFO", paramVideoInfo.vid);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramVideoInfo.duration);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramVideoInfo.width);
    ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramVideoInfo.height);
    ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramVideoInfo.duration);
    ((Bundle)localObject).putString("source_puin", paramVideoInfo.hH);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.hH);
    ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.accountName);
    ((Bundle)localObject).putInt("TYPE", paramVideoInfo.busiType);
    ((Bundle)localObject).putString("ARTICLE_ID", paramVideoInfo.Wz);
    ((Bundle)localObject).putInt("layout_item", 5);
    ((Bundle)localObject).putBoolean("video_url_load", false);
    ((Bundle)localObject).putString("image_url_remote", paramVideoInfo.coverUrl);
    label301:
    label343:
    String str2;
    String str4;
    if ((paramVideoInfo.aioShareUrl != null) && (paramVideoInfo.aioShareUrl.contains("kandianshare.html5.qq.com")))
    {
      ((Bundle)localObject).putString("detail_url", paramVideoInfo.aioShareUrl);
      ((Bundle)localObject).putString("video_url", paramVideoInfo.vid);
      ((Bundle)localObject).putString("title", paramVideoInfo.title);
      ((Bundle)localObject).putString("req_create_time", paramVideoInfo.createTime);
      ((Bundle)localObject).putString("brief_key", paramVideoInfo.title);
      if (paramVideoInfo.busiType != 6) {
        break label603;
      }
      ((Bundle)localObject).putInt("VIDEO_FEED_TYPE", paramVideoInfo.feedType);
      ((Bundle)localObject).putLong("VIDEO_FEED_ID", paramVideoInfo.rA);
      ((Bundle)localObject).putString("compatible_text", paramVideoInfo.title + ": " + paramVideoInfo.webUrl);
      ((Bundle)localObject).putInt("req_type", 125);
      ((Bundle)localObject).putInt("PREVIEW_START_POSI", myh.T(paramInt, paramVideoInfo.getDuration()));
      localObject = (StructMsgForGeneralShare)anre.a((Bundle)localObject);
      obo.a((StructMsgForGeneralShare)localObject);
      if (TextUtils.isEmpty(paramVideoInfo.WC)) {
        break label615;
      }
      str1 = paramVideoInfo.WC;
      str2 = paramVideoInfo.thirdAction;
      ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
      String str3 = paramVideoInfo.hH;
      str4 = obo.fj(str3);
      String str5 = paramVideoInfo.accountName;
      if (!TextUtils.isEmpty(str3)) {
        ((StructMsgForGeneralShare)localObject).mSourceAppid = Long.valueOf(str3).longValue();
      }
      ((StructMsgForGeneralShare)localObject).source_puin = paramVideoInfo.hH;
      if (paramVideoInfo.busiType <= 1) {
        break label669;
      }
      if ((TextUtils.isEmpty(str3)) || (str3.equals("16888"))) {
        break label643;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      label435:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
      }
      label456:
      if ((str5 != null) && (!"".equals(str5))) {
        ((StructMsgForGeneralShare)localObject).mSourceName = str5;
      }
      if ((str1 == null) || ("".equals(str1))) {
        break label678;
      }
    }
    label643:
    label669:
    label678:
    for (((StructMsgForGeneralShare)localObject).mSourceIcon = str1;; ((StructMsgForGeneralShare)localObject).mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramVideoInfo = new Bundle();
      paramVideoInfo.putInt("forward_type", -3);
      paramVideoInfo.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramVideoInfo.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      return paramVideoInfo;
      if ((paramVideoInfo.webUrl != null) && (!paramVideoInfo.webUrl.contains("&sourcefrom=0"))) {
        paramVideoInfo.webUrl += "&sourcefrom=0";
      }
      ((Bundle)localObject).putString("detail_url", a(paramVideoInfo.webUrl, paramVideoInfo));
      break;
      label603:
      ((Bundle)localObject).putInt("req_type", 140);
      break label301;
      label615:
      if (TextUtils.isEmpty(paramVideoInfo.hH)) {
        break label343;
      }
      str1 = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(Long.parseLong(paramVideoInfo.hH), null));
      break label343;
      if (!TextUtils.isEmpty(str2))
      {
        ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
        break label435;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label435;
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str4;
      break label456;
    }
  }
  
  private static String a(String paramString, VideoInfo paramVideoInfo)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.contains("redpackid"))
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramVideoInfo.WF))
        {
          str = paramString;
          if (paramVideoInfo.adI)
          {
            paramString = new StringBuilder(paramString);
            paramString.append("&").append("redpackid").append("=").append(paramVideoInfo.WF);
            str = paramString.toString();
          }
        }
      }
    }
    return str;
  }
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, VideoInfo paramVideoInfo, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", kvp.U(paramContext));
        localJSONObject.put("os", "1");
        localJSONObject.put("source", paramInt1 + "");
        localJSONObject.put("uin", paramVideoInfo.hH);
        localJSONObject.put("rowkey", paramVideoInfo.articleInfo.innerUniqueID);
        localJSONObject.put("version", kct.XU);
        localJSONObject.put("vid", paramVideoInfo.vid);
        if (paramBoolean1) {
          localJSONObject.put("cancel", String.valueOf(1));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("sourcefrom", paramInt3 + "");
        }
        if (paramInt4 < 0) {
          continue;
        }
        localJSONObject.put("share_unit", paramInt4 + "");
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        paramContext = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsShareController", 2, "shareReport:" + localException.toString());
        paramContext = str;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        paramInt1 = 0;
        continue;
      }
      localJSONObject.put("result", paramInt1);
      localJSONObject.put("show", paramInt2);
      paramContext = localJSONObject.toString();
      paramContext = new nce.a(paramContext);
      paramContext.a(paramVideoInfo);
      kbp.a(null, "", "0X800979D", "0X800979D", 0, 0, "", String.valueOf(paramVideoInfo.Wz), String.valueOf(paramVideoInfo.algorithmID), paramContext.a().toJsonString(), false);
      odg.d.a.nV(paramBoolean2);
      return;
      paramInt1 = 1;
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, Activity paramActivity, int paramInt1, @NotNull String paramString1, int paramInt2, String paramString2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (paramVideoInfo.busiType == 0)
    {
      paramVideoInfo = paramActivity.getIntent().getExtras();
      paramVideoInfo.putInt("forward_type", 21);
      paramVideoInfo.putBoolean("forward_need_sendmsg", true);
      paramVideoInfo.putString("forward_thumb", ShortVideoUtils.bw(paramActivity.getIntent().getExtras().getString("thumbfile_md5"), "jpg"));
      paramString1 = new Intent();
      paramString1.putExtras(paramVideoInfo);
      ahgq.P(paramActivity, paramString1);
      return;
    }
    if ((paramVideoInfo.busiType == 7) || ((paramVideoInfo.busiType == 6) && (TextUtils.isEmpty(paramVideoInfo.vid))))
    {
      ahgq.f(paramActivity, a(paramVideoInfo), 21);
      return;
    }
    paramVideoInfo = a(paramVideoInfo, paramInt1);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramVideoInfo);
    if (TextUtils.isEmpty(paramString1))
    {
      ahgq.f(paramActivity, localIntent, 21);
      return;
    }
    localIntent.putExtra("toUin", paramString1);
    localIntent.putExtra("uinType", paramInt2);
    localIntent.putExtra("uinname", paramString2);
    ahgq.a(paramActivity, localIntent, DirectForwardActivity.class, 21, -1, "");
  }
  
  private void a(VideoInfo paramVideoInfo, @NotNull String paramString1, int paramInt, String paramString2)
  {
    a(paramVideoInfo, this.mContext, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramString1, paramInt, paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oB(this.afO);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network", kvp.U(this.mContext));
      localJSONObject.put("os", "1");
      localJSONObject.put("source", this.mFromType + "");
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("rowkey", paramVideoInfo.articleInfo.innerUniqueID);
      localJSONObject.put("version", kct.XU);
      localJSONObject.put("vid", paramString3);
      if (paramBoolean) {
        localJSONObject.put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        localJSONObject.put("sourcefrom", paramInt1 + "");
      }
      if (paramInt2 >= 0) {
        localJSONObject.put("share_unit", paramInt2 + "");
      }
      localJSONObject.put("show", this.CP);
      localJSONObject.put("type", 1);
      paramString1 = localJSONObject.toString();
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoFeedsShareController", 2, "shareReport:" + paramString3.toString());
          paramString1 = str;
        }
      }
    }
    paramString1 = new nce.a(paramString1);
    paramString1.a(paramVideoInfo);
    kbp.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(paramString2), String.valueOf(paramLong), paramString1.a().toJsonString(), false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, String paramString6, boolean paramBoolean)
  {
    String str2 = "0X800740F";
    String str1 = str2;
    if (!paramBoolean) {
      if (this.mFromType != 9)
      {
        str1 = str2;
        if (this.mFromType != 12) {}
      }
      else
      {
        str1 = "0X800929A";
      }
    }
    paramString4 = new nce.a(paramString4, paramString1, paramString5, paramString3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV()).c(paramInt1 * 1000);
    if (!paramBoolean) {
      paramString4.e(paramLong).c(paramInt2).g(paramInt4).a(paramString6);
    }
    paramString4.a(paramInt3).N(this.mSceneType);
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      kbp.a(null, paramString1, str1, str1, 0, 0, "0", paramString2, paramString3, paramString4.a().toJsonString(), false);
      return;
      paramString3 = "0";
    }
  }
  
  private void aTs()
  {
    this.cd = null;
    this.jdField_i_of_type_ComTencentImageURLDrawable = null;
    if (this.k == null) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = muj.c(this.mContext)[0];
        int m = this.k.j(this.mContext);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = m;
        this.jdField_i_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.k.coverUrl, localURLDrawableOptions);
        if ((this.jdField_i_of_type_ComTencentImageURLDrawable != null) && (this.jdField_i_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_i_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.cd = ((RegionDrawable)this.jdField_i_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        logd("initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_i_of_type_ComTencentImageURLDrawable == null);
    this.jdField_i_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new mwz(this));
    this.jdField_i_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void aTt()
  {
    VideoInfo localVideoInfo = this.k;
    this.F = ((ausj)auss.a(this.mContext, null));
    Object localObject = new mxa(this);
    this.F.a((ausj.e)localObject);
    localObject = new ReadInJoyDisLikeDialogViewForAd(this.mContext);
    ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new mxb(this, localVideoInfo));
    ((ReadInJoyDisLikeDialogView)localObject).setOnComplainListener(new mws(this, localVideoInfo));
    ArrayList localArrayList = new ArrayList();
    if ((localVideoInfo != null) && (localVideoInfo.b != null) && (localVideoInfo.b.jO.size() > 0))
    {
      Iterator localIterator = localVideoInfo.b.jO.iterator();
      if (localIterator.hasNext())
      {
        VideoAdInfo.NegFeedback localNegFeedback = (VideoAdInfo.NegFeedback)localIterator.next();
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.agQ = localNegFeedback.Wy;
        localDislikeInfo.vf = ((int)localNegFeedback.rw);
        if (TextUtils.isEmpty(localVideoInfo.hH)) {}
        for (localDislikeInfo.puin = "";; localDislikeInfo.puin = localVideoInfo.hH)
        {
          localArrayList.add(localDislikeInfo);
          break;
        }
      }
    }
    if (localArrayList.size() == 0) {}
    for (;;)
    {
      return;
      ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(localArrayList);
      this.F.setActionContentView((View)localObject, null);
      try
      {
        if (!this.F.isShowing())
        {
          if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK()))
          {
            this.F.getWindow().setFlags(8, 8);
            this.F.getWindow().getDecorView().setSystemUiVisibility(this.mContext.getWindow().getDecorView().getSystemUiVisibility());
            this.F.setOnShowListener(new mwt(this));
          }
          this.F.show();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int j = 0;
    logd("shareMsgToSina start!");
    paramString2 = this.mContext;
    Object localObject = new String[0];
    localObject = localObject[new java.util.Random().nextInt(localObject.length)];
    paramString1 = "#QQ看点#" + (String)localObject + "【" + paramString1 + "】";
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      logd("shareMsgToSina empty title or share_url");
      QQToast.a(this.mContext, 0, 2131720152, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oB(this.afO);
    logd("shareMsgToSina installSinaWeibo:false");
    try
    {
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1 + "%F0%9F%8E%AC";
      paramString3 = URLEncoder.encode(paramString3, "UTF-8");
      paramString1 = paramString1 + "&url=" + paramString3;
      paramString3 = URLEncoder.encode(paramString4, "UTF-8");
      paramString1 = paramString1 + "&pic=" + paramString3;
      paramString1 = paramString1 + "&_wv=3";
      paramString3 = new Intent(paramString2, QQBrowserActivity.class);
      paramString3.putExtra("url", paramString1);
      if (this.anU) {
        j = 40677;
      }
      paramString3.putExtra("big_brother_source_key", kxm.bg(j));
      paramString2.startActivity(paramString3);
      logd("shareMsgToSina start webview!");
      return;
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      QQToast.a(this.mContext, 0, 2131720152, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      paramString1.printStackTrace();
      return;
    }
    finally {}
  }
  
  private void logd(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, paramString);
    }
  }
  
  @TargetApi(11)
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    String str1 = this.mContext.getResources().getString(2131720281);
    String str2 = this.mContext.getResources().getString(2131720239);
    String str3 = this.mContext.getResources().getString(2131720282);
    String str4 = this.mContext.getResources().getString(2131720259);
    String str5 = this.mContext.getResources().getString(2131721058);
    String str6 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = false;
    Object localObject = new File(str6);
    long l = ((File)localObject).length();
    boolean bool1 = bool2;
    if (((File)localObject).exists())
    {
      bool1 = bool2;
      if (l >= paramMessageForShortVideo.videoFileSize) {
        bool1 = true;
      }
    }
    if (ImmersiveUtils.isSupporImmersive() == -1)
    {
      localObject = ausj.c(this.mContext);
      ((ausj)localObject).addButton(str1);
      ((ausj)localObject).setOnDismissListener(new mwr(this));
      if ((paramMessageForShortVideo.videoFileStatus != 5001) && (!bool1)) {
        break label327;
      }
      ((ausj)localObject).addButton(str2);
      ((ausj)localObject).addButton(str4);
    }
    for (;;)
    {
      ((ausj)localObject).addCancelButton(str5);
      if (!((ausj)localObject).isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK()))
        {
          ((ausj)localObject).getWindow().setFlags(8, 8);
          if (VersionUtils.isJellyBean()) {
            ((ausj)localObject).getWindow().getDecorView().setSystemUiVisibility(this.mContext.getWindow().getDecorView().getSystemUiVisibility());
          }
          ((ausj)localObject).setOnShowListener(new mwu(this, (ausj)localObject));
        }
        ((ausj)localObject).show();
      }
      ((ausj)localObject).a(new mwv(this, (ausj)localObject, str1, paramMessageForShortVideo, str3, bool1, str6, str2, str4));
      return;
      localObject = ausj.b(this.mContext);
      break;
      label327:
      ((ausj)localObject).addButton(str2, 7);
      ((ausj)localObject).addButton(str4, 7);
    }
  }
  
  public void a(mwj parammwj)
  {
    this.jdField_a_of_type_Mwj = parammwj;
  }
  
  @TargetApi(11)
  public void aTr()
  {
    if (this.mShareHelper == null) {
      this.mShareHelper = new odg(this.mContext, this.mApp, new mwq.b());
    }
    this.mShareHelper.a().setActionSheetTitle("biu出去让更多好友看到");
    this.mShareHelper.a().setCancelListener(new mww(this));
    this.mShareHelper.a().setOnDismissListener(new mwx(this));
    try
    {
      if (!this.mShareHelper.a().isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK())) {
          this.mShareHelper.a().setOnShowListener(new mwy(this));
        }
        this.mShareHelper.a(b(), 3);
        aTs();
      }
      return;
    }
    catch (Exception localException)
    {
      logd("actionSheet.show exception=" + localException);
    }
  }
  
  public List<Integer>[] b()
  {
    List localList = odg.bl();
    ArrayList localArrayList = new ArrayList();
    if (mix.a(this.mApp, this.k.isForbidReprint))
    {
      localArrayList.add(Integer.valueOf(134));
      localArrayList.add(Integer.valueOf(133));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(1));
      if (this.k != null)
      {
        VideoInfo localVideoInfo = this.k;
        if ((localVideoInfo.jR != null) && (localVideoInfo.jR.size() > 0)) {
          localArrayList.add(Integer.valueOf(44));
        }
      }
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(22));
      return new List[] { localList, localArrayList };
      localArrayList.add(Integer.valueOf(133));
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.k != null)
    {
      paramIntent = this.k;
      if (paramInt2 != -1) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false) {
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    a(this.mContext, this.mFromType, this.CP, paramIntent, 0, -1, false, bool);
    return;
    a(this.mContext, this.mFromType, this.CP, paramIntent, 1, -1, false, bool);
    return;
    odg.d.a.nV(bool);
  }
  
  public void l(VideoInfo paramVideoInfo)
  {
    this.e = paramVideoInfo;
  }
  
  public void onDestroy()
  {
    if (this.mShareHelper != null) {
      this.mShareHelper.onDestroy();
    }
    this.rijWatchWordPresenter.detachView();
  }
  
  public void onPause()
  {
    this.anW = false;
  }
  
  public void onResume()
  {
    this.anW = true;
  }
  
  public void sJ(int paramInt)
  {
    logd("doOnShareButtonPressed()");
    this.CP = paramInt;
    if ((this.k != null) && (this.k.busiType == 0)) {
      a(this.k.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mwq$a != null) {
        this.jdField_a_of_type_Mwq$a.aRC();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.isPlaying())) {
        break;
      }
      this.afO = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.pause();
      return;
      if ((this.k != null) && (this.k.isAD) && (this.k.qU == 1) && (this.k.j(this.mContext))) {
        aTt();
      } else {
        aTr();
      }
    }
    this.afO = false;
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(this.mContext, 1, paramString, 0).show();
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(this.mContext, 2, paramString, 0).show();
  }
  
  public void v(VideoInfo paramVideoInfo)
  {
    this.k = paramVideoInfo;
  }
  
  public static abstract interface a
  {
    public abstract void B(VideoInfo paramVideoInfo);
    
    public abstract void aRC();
    
    public abstract void aRD();
  }
  
  class b
    extends odg.a
  {
    b() {}
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      if (mwq.a(mwq.this) == null) {
        return false;
      }
      VideoInfo localVideoInfo;
      Object localObject1;
      Object localObject7;
      int i;
      int j;
      switch (paramInt)
      {
      default: 
        localVideoInfo = mwq.a(mwq.this);
        if (mwq.a(mwq.this) != null) {
          mwq.a(mwq.this).B(localVideoInfo);
        }
        localObject1 = new StringBuilder();
        localObject5 = mwq.a(mwq.this).hW();
        if (!TextUtils.isEmpty(localVideoInfo.webUrl))
        {
          ((StringBuilder)localObject1).append(localVideoInfo.webUrl);
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            ((StringBuilder)localObject1).append("&iid=").append((String)localObject5);
          }
        }
        localObject7 = ((StringBuilder)localObject1).toString();
        k = 3;
        switch (paramInt)
        {
        default: 
          i = -1;
          j = -1;
        }
        break;
      }
      label325:
      int m;
      Object localObject6;
      for (;;)
      {
        if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6) && (!mwq.e(mwq.this)))
        {
          localObject5 = new ReportInfo.b();
          ((ReportInfo.b)localObject5).aSC = ((int)mwq.a(mwq.this).cV());
          ((ReportInfo.b)localObject5).videoDuration = (localVideoInfo.getDuration() * 1000);
          m = -1;
          if (mwq.a(mwq.this) != null)
          {
            ((ReportInfo.b)localObject5).aSA = mwq.a(mwq.this).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
            m = mwq.a(mwq.this).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
          }
          if (mwq.c(mwq.this) != 1) {
            break label3041;
          }
          localObject6 = mwq.a(mwq.this);
          if (mwq.b(mwq.this) == null) {
            break label3035;
          }
          localObject1 = mwq.b(mwq.this).Wz;
          label485:
          kct.a((VideoInfo)localObject6, m, 26, -1, (ReportInfo.b)localObject5, (String)localObject1);
        }
        if ((localVideoInfo.busiType != 0) || (localVideoInfo.a == null)) {
          break label3095;
        }
        localObject1 = localVideoInfo.a.getMd5();
        label525:
        if (mwq.a(mwq.this) == null) {
          break label3101;
        }
        m = mwq.a(mwq.this).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        label553:
        if (localVideoInfo.videoReportInfo == null) {
          break label3107;
        }
        localObject5 = localVideoInfo.videoReportInfo;
        label568:
        mwq.a(mwq.this, localVideoInfo.hH, Integer.toString(k), localVideoInfo.Wz, (String)localObject1, localVideoInfo.vid, localVideoInfo.getDuration(), localVideoInfo.algorithmID, localVideoInfo.strategyID, -1, m, (String)localObject5, false);
        mwq.a(mwq.this, localVideoInfo, String.valueOf(kxm.getLongAccountUin()), localVideoInfo.Wz, localVideoInfo.vid, localVideoInfo.algorithmID, j, i, false);
        return super.b(paramInt, paramActionSheetItem);
        if (mwq.a(mwq.this) == null) {
          break;
        }
        mwq.a(mwq.this).restart();
        break;
        try
        {
          if (mwq.a(mwq.this) != null)
          {
            mwq.a(mwq.this).oB(mwq.b(mwq.this));
            localObject1 = new Intent(mwq.a(mwq.this), ReadInJoyDeliverBiuActivity.class);
            if ((mwq.a(mwq.this).busiType == 6) && (mwq.a(mwq.this).articleInfo != null)) {
              ((Intent)localObject1).putExtra("feedsType", mwq.a(mwq.this).articleInfo.mFeedType);
            }
            ((Intent)localObject1).putExtra("ARG_VIDEO_ARTICLE_ID", mwq.a(mwq.this).Wz);
            ((Intent)localObject1).putExtra("biu_src", 2);
            ((Intent)localObject1).putExtra("arg_from_type", 8);
            ((Intent)localObject1).putExtra("arg_article_info", mwq.a(mwq.this).articleInfo);
            mwq.a(mwq.this).startActivityForResult((Intent)localObject1, 102);
            mwq.a(mwq.this).overridePendingTransition(0, 0);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoFeedsShareController", 2, "innerOpenReadInJoyBiuActivity error exception = " + localException1.getMessage());
            }
            mwq.a(mwq.this).oB(false);
          }
        }
        i = -1;
        j = 0;
        continue;
        ((ClipboardManager)mwq.a(mwq.this).getSystemService("clipboard")).setText((CharSequence)localObject7);
        rwt.ez(2, 2131692332);
        i = 3;
        j = -1;
        continue;
        localObject5 = null;
        Object localObject2 = localObject5;
        if (!TextUtils.isEmpty((CharSequence)localObject7)) {}
        try
        {
          localObject2 = URLEncoder.encode((String)localObject7, "UTF-8");
          if (!TextUtils.isEmpty(localVideoInfo.hH))
          {
            localObject5 = localVideoInfo.hH;
            i = 0;
            if (localVideoInfo.busiType == 6) {
              i = 1;
            }
            localObject2 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + (String)localObject5 + "&uin_type=" + i + "&url=" + (String)localObject2 + "&type=4&key=" + localVideoInfo.Wz;
            mwq.a(mwq.this, "click jubao btn, reportUrl:" + (String)localObject2);
            mwq.a(mwq.this).oB(mwq.b(mwq.this));
            localObject5 = new Intent(mwq.a(mwq.this), QQBrowserActivity.class);
            ((Intent)localObject5).putExtra("url", (String)localObject2);
            ((Intent)localObject5).putExtra("hide_more_button", true);
            mwq.a(mwq.this).startActivity((Intent)localObject5);
            i = 5;
            j = -1;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            mwq.a(mwq.this, "encode url failed, because UTF-8 is unknown");
            localObject3 = localObject5;
            continue;
            localObject5 = "0";
          }
        }
        mwq.a(mwq.this, localVideoInfo, paramActionSheetItem.uin, paramActionSheetItem.uinType, paramActionSheetItem.label);
        k = 0;
        i = 19;
        j = 1;
        continue;
        mwq.a(mwq.this, localVideoInfo);
        k = 0;
        i = -1;
        j = 1;
        continue;
        mwq.a(mwq.this).oB(mwq.b(mwq.this));
        if ((localVideoInfo.qzoneShareUrl != null) && (localVideoInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
        {
          mwq.this.mShareHelper.po(localVideoInfo.qzoneShareUrl);
          i = -1;
          j = 6;
        }
        else
        {
          mwq.this.mShareHelper.po((String)localObject7 + "&sourcefrom=6");
          i = -1;
          j = 6;
          continue;
          mwq.a(mwq.this).oB(mwq.b(mwq.this));
          if ((localVideoInfo.aioShareUrl != null) && (localVideoInfo.aioShareUrl.contains("kandianshare.html5.qq.com")))
          {
            mwq.this.mShareHelper.pp(localVideoInfo.aioShareUrl);
            i = -1;
            j = 7;
          }
          else
          {
            mwq.this.mShareHelper.pp((String)localObject7 + "&sourcefrom=6");
            i = -1;
            j = 7;
          }
        }
      }
      int k = 1;
      mwq.a(mwq.this).oB(mwq.b(mwq.this));
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", localVideoInfo.title);
      ((Bundle)localObject3).putString("desc", localVideoInfo.summary);
      if ((localVideoInfo.qzoneShareUrl != null) && (localVideoInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com"))) {
        ((Bundle)localObject3).putString("detail_url", localVideoInfo.qzoneShareUrl);
      }
      for (;;)
      {
        localObject5 = new ArrayList(1);
        ((ArrayList)localObject5).add(localVideoInfo.coverUrl);
        ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject5);
        ((Bundle)localObject3).putLong("req_share_id", 0L);
        avqq.a(mwq.a(mwq.this), mwq.a(mwq.this), (Bundle)localObject3, null, 10001);
        i = -1;
        j = 2;
        break;
        ((Bundle)localObject3).putString("detail_url", mwq.b((String)localObject7, localVideoInfo) + "&sourcefrom=1");
      }
      if (!aqiw.isNetworkAvailable(mwq.a(mwq.this))) {
        return false;
      }
      muj.a(mwq.a(mwq.this), mwq.a(mwq.this));
      k = 6;
      localVideoInfo.adC = true;
      mwq.a(mwq.this).oB(mwq.b(mwq.this));
      if ((mwq.a(mwq.this) instanceof VideoFeedsPlayActivity)) {
        ((VideoFeedsPlayActivity)mwq.a(mwq.this)).oA(true);
      }
      localObject3 = localVideoInfo.accountName;
      Object localObject5 = new Bundle();
      ((Bundle)localObject5).putInt("videoDuration", localVideoInfo.duration);
      long l;
      if (TextUtils.isEmpty(localVideoInfo.hH))
      {
        l = 0L;
        label1785:
        ((Bundle)localObject5).putLong("publishAccountUin", l);
        ((Bundle)localObject5).putString("publishAccountName", (String)localObject3);
        ((Bundle)localObject5).putLong("feedsId", localVideoInfo.rA);
        ((Bundle)localObject5).putInt("feedsType", localVideoInfo.feedType);
        if (localVideoInfo.busiType != 6) {
          break label1961;
        }
        i = 1;
        label1842:
        ((Bundle)localObject5).putInt("videoType", i);
        if (localVideoInfo.Wz != null) {
          break label1966;
        }
      }
      label1961:
      label1966:
      for (localObject3 = "";; localObject3 = localVideoInfo.Wz)
      {
        lgv.a().a(mwq.a(mwq.this), mwq.a(mwq.this).getCurrentUin(), 2, (String)localObject3, localVideoInfo.title, localVideoInfo.summary, localVideoInfo.coverUrl, localVideoInfo.webUrl + "&sourcefrom=6", (Bundle)localObject5);
        localVideoInfo.isFavorite = true;
        i = 4;
        j = -1;
        break;
        l = Long.valueOf(localVideoInfo.hH).longValue();
        break label1785;
        i = 2;
        break label1842;
      }
      mwq.a(mwq.this).oB(mwq.b(mwq.this));
      boolean bool1 = false;
      if (!TextUtils.isEmpty(localVideoInfo.wechatShareUrl))
      {
        localObject3 = localVideoInfo.wechatShareUrl;
        bool1 = true;
        j = 3;
        i = -1;
        label2022:
        if ((localVideoInfo.qzoneShareUrl == null) || (!localVideoInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com"))) {
          break label3124;
        }
        localObject3 = localVideoInfo.qzoneShareUrl;
      }
      label2980:
      label3115:
      label3124:
      for (;;)
      {
        for (;;)
        {
          localObject7 = new StringBuilder();
          if (localVideoInfo.playCount > 0) {
            ((StringBuilder)localObject7).append(muj.bv(localVideoInfo.playCount)).append(" ");
          }
          localObject5 = (BaseActivity)mwq.a(mwq.this);
          localObject6 = localVideoInfo.title;
          localObject7 = ((StringBuilder)localObject7).toString();
          localObject8 = mwq.a(mwq.this);
          if (paramInt == 9) {}
          for (boolean bool2 = true;; bool2 = false)
          {
            kcu.a((BaseActivity)localObject5, (String)localObject6, (String)localObject7, (String)localObject3, (Bitmap)localObject8, bool2, localVideoInfo.Wz, bool1, new mwq.d(mwq.a(mwq.this), mwq.a(mwq.this), mwq.b(mwq.this), i, -1, localVideoInfo));
            k = j;
            j = i;
            i = -1;
            break;
            if (paramInt == 9)
            {
              i = 3;
              localObject3 = (String)localObject7 + "&sourcefrom=2";
              j = 2;
              break label2022;
            }
            i = 4;
            localObject3 = (String)localObject7 + "&sourcefrom=3";
            j = 4;
            break label2022;
          }
          k = 5;
          if ((localVideoInfo.qzoneShareUrl != null) && (localVideoInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
          {
            mwq.a(mwq.this, localVideoInfo.title, "", localVideoInfo.qzoneShareUrl, localVideoInfo.coverUrl);
            i = -1;
            j = 5;
            break;
          }
          mwq.a(mwq.this, localVideoInfo.title, "", (String)localObject7 + "&sourcefrom=4", localVideoInfo.coverUrl);
          i = -1;
          j = 5;
          break;
          mwq.b(mwq.this, true);
          localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("channel_id", 409409);
            ((JSONObject)localObject3).put("source", 2);
            localObject5 = mwq.a(mwq.this);
            if ((((VideoInfo)localObject5).jR == null) || (((VideoInfo)localObject5).jR.size() <= 0)) {
              break label3115;
            }
            mwq.a(mwq.this, (ausj)auss.a(mwq.a(mwq.this), null));
            localObject6 = new mxc(this);
            mwq.a(mwq.this).a((ausj.e)localObject6);
            localObject6 = new ReadInJoyDisLikeDialogView(mwq.a(mwq.this));
            ((ReadInJoyDisLikeDialogView)localObject6).setOnUninterestConfirmListener(new mxd(this, (VideoInfo)localObject5, (JSONObject)localObject3));
            ((ReadInJoyDisLikeDialogView)localObject6).setUninterestData(((VideoInfo)localObject5).jR);
            mwq.a(mwq.this).setActionContentView((View)localObject6, null);
            try
            {
              if (!mwq.a(mwq.this).isShowing())
              {
                if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK()))
                {
                  mwq.a(mwq.this).getWindow().setFlags(8, 8);
                  mwq.a(mwq.this).getWindow().getDecorView().setSystemUiVisibility(mwq.a(mwq.this).getWindow().getDecorView().getSystemUiVisibility());
                  mwq.a(mwq.this).setOnShowListener(new mxe(this));
                }
                mwq.a(mwq.this).show();
                kbp.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new nce.a(kct.a(null, null, null, null, (JSONObject)localObject3)).h(((VideoInfo)localObject5).Wz).a().toJsonString(), false);
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                mwq.a(mwq.this, "dislikeSheet.show exception=" + localException2);
              }
            }
            i = 7;
            j = -1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
        mwq.this.mShareHelper.pr((String)localObject7);
        i = 2;
        j = -1;
        break label325;
        Object localObject4 = mwq.a(mwq.this);
        if ((localObject4 == null) || (TextUtils.isEmpty(((VideoInfo)localObject4).Wz))) {
          break;
        }
        ncb.a(mwq.a(mwq.this), mrv.a((VideoInfo)localObject4), mwq.a(mwq.this).a(((VideoInfo)localObject4).Wz), 1, 0);
        ncb.s(((VideoInfo)localObject4).Wz, 1, 1);
        i = -1;
        j = -1;
        break label325;
        localObject4 = mwq.a(mwq.this);
        if (localObject4 != null)
        {
          mix.h(mwq.a(mwq.this), ((VideoInfo)localObject4).Wz, 1);
          i = -1;
          j = -1;
          break label325;
        }
        QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
        i = -1;
        j = -1;
        break label325;
        String str = null;
        localObject4 = str;
        if (localVideoInfo.jQ != null)
        {
          localObject4 = str;
          if (!localVideoInfo.jQ.isEmpty()) {
            localObject4 = "" + localVideoInfo.jQ.get(0);
          }
        }
        Object localObject8 = mwq.a(mwq.this);
        if (localVideoInfo.Wz == null)
        {
          str = "";
          if (localVideoInfo.Wz != null) {
            break label3025;
          }
        }
        label3025:
        for (localObject6 = "";; localObject6 = localVideoInfo.title)
        {
          ((nze)localObject8).l(str, (String)localObject7, (String)localObject4, (String)localObject6);
          i = -1;
          j = 8;
          break;
          str = localVideoInfo.Wz;
          break label2980;
        }
        label3035:
        localObject4 = null;
        break label485;
        label3041:
        localObject6 = mwq.a(mwq.this);
        if (mwq.b(mwq.this) != null) {}
        for (localObject4 = mwq.b(mwq.this).Wz;; localObject4 = null)
        {
          kct.b((VideoInfo)localObject6, m, 26, -1, str, (String)localObject4);
          break;
        }
        localObject4 = null;
        break label525;
        m = 0;
        break label553;
        str = "";
        break label568;
        i = 7;
        j = -1;
        break label325;
      }
    }
  }
  
  class c
    extends MqqHandler
  {
    private c() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        QQToast.a(mwq.a(mwq.this), 2131720241, 0).show();
        return;
        String str = mwq.a(mwq.this).getString(2131720242);
        paramMessage = (String)paramMessage.obj;
        QQToast.a(mwq.a(mwq.this), 2, str + paramMessage, 0).show();
        aqhu.cn(mwq.a(mwq.this), paramMessage);
        return;
      } while ((mwq.a(mwq.this) == null) || (mwq.a(mwq.this).busiType != 0));
      paramMessage = ShortVideoUtils.a(mwq.a(mwq.this).a, "mp4");
      aqha.a(mwq.a(mwq.this), 232, mwq.a(mwq.this).getResources().getString(2131720274), mwq.a(mwq.this).getResources().getString(2131720273), 2131720256, 2131718798, new mxf(this, paramMessage), new mxg(this)).show();
    }
  }
  
  static class d
    implements odg.e
  {
    private int CP;
    private int aVB;
    private int aVC;
    private WeakReference<Context> mContextReference;
    private int mFromType;
    private VideoInfo o;
    
    public d(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoInfo paramVideoInfo)
    {
      this.mContextReference = new WeakReference(paramContext);
      this.mFromType = paramInt1;
      this.CP = paramInt2;
      this.aVB = paramInt3;
      this.aVC = paramInt4;
      this.o = paramVideoInfo;
    }
    
    public void onResult(boolean paramBoolean)
    {
      if ((this.mContextReference != null) && (this.mContextReference.get() != null)) {
        mwq.b((Context)this.mContextReference.get(), this.mFromType, this.CP, this.o, this.aVB, this.aVC, false, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwq
 * JD-Core Version:    0.7.0.1
 */