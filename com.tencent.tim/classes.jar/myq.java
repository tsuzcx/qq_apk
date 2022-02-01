import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class myq
  implements AdapterView.OnItemClickListener, nyy.b
{
  private Bundle D;
  private ausj F;
  private HashSet<String> S = new HashSet();
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private jym jdField_a_of_type_Jym;
  private lgv.b jdField_a_of_type_Lgv$b = new myy(this);
  private mye jdField_a_of_type_Mye;
  private myz jdField_a_of_type_Myz;
  private boolean anG = true;
  private boolean anH;
  private boolean aqx;
  private ndi b;
  private Bitmap cd;
  private URLDrawable i;
  private BaseArticleInfo j;
  private Activity mActivity;
  private int mChannelID;
  private Context mContext;
  private int mCurrentPosition;
  private odg mShareHelper;
  private View mb;
  private nze rijWatchWordPresenter;
  
  public myq(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Lgv$b);
    paramActivity = new IntentFilter();
    paramActivity.addAction("com.tencent.process.fav");
    this.mActivity.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, paramActivity);
    this.rijWatchWordPresenter = new nze(new nzb());
    this.rijWatchWordPresenter.a(this);
  }
  
  private Intent a(Bundle paramBundle, String paramString, int paramInt)
  {
    paramString = (StructMsgForGeneralShare)anre.a(paramBundle.getByteArray("STRUCT_MSG_BYTES"));
    obo.a(paramString);
    paramInt = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE", -1);
    String str1 = paramBundle.getString("VIDEO_THIRD_ICON");
    String str2 = paramBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = paramBundle.getString("VIDEO_THIRD_NAME");
    String str4 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    paramBundle = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    String str5 = obo.fj(str4);
    paramString.mSourceAction = "web";
    long l;
    if (TextUtils.isEmpty(str4))
    {
      l = 0L;
      paramString.mSourceAppid = l;
      paramString.source_puin = str4;
      if (paramInt <= 1) {
        break label286;
      }
      if ((TextUtils.isEmpty(str4)) || (str4.equals("16888"))) {
        break label260;
      }
      paramString.mSourceUrl = str5;
      label129:
      if ((paramBundle != null) && (!"".equals(str3))) {
        paramString.mSourceThirdName = paramBundle;
      }
      label148:
      if ((str3 == null) || ("".equals(str3))) {
        break label295;
      }
      paramString.mSourceName = str3;
      label169:
      if ((str1 == null) || ("".equals(str1))) {
        break label303;
      }
    }
    label260:
    label286:
    label295:
    label303:
    for (paramString.mSourceIcon = str1;; paramString.mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png")
    {
      paramString.setFlag(0);
      paramBundle = new Bundle();
      paramBundle.putInt("forward_type", -3);
      paramBundle.putInt("structmsg_service_id", paramString.mMsgServiceID);
      paramBundle.putByteArray("stuctmsg_bytes", paramString.getBytes());
      paramString = new Intent();
      paramString.putExtras(paramBundle);
      return paramString;
      l = Long.valueOf(str4).longValue();
      break;
      if (!TextUtils.isEmpty(str2))
      {
        paramString.mSourceUrl = str2;
        break label129;
      }
      paramString.mSourceUrl = "";
      break label129;
      paramString.mSourceUrl = str5;
      break label148;
      paramString.mSourceName = paramBundle;
      break label169;
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    paramBundle = a(paramBundle, paramString1, paramInt);
    if ((paramString1 == null) || (paramString1.length() < 5))
    {
      ahgq.f(this.mActivity, paramBundle, 21);
      return;
    }
    paramBundle.setClass(this.mActivity, DirectForwardActivity.class);
    paramBundle.putExtra("toUin", paramString1);
    paramBundle.putExtra("uinType", paramInt);
    paramBundle.putExtra("uinname", paramString2);
    this.mActivity.startActivityForResult(paramBundle, 21);
  }
  
  private void aTr()
  {
    if (this.mShareHelper == null) {
      this.mShareHelper = new odg(this.mActivity, getQQAppInterface(), new myq.a());
    }
    this.mShareHelper.a().setActionSheetTitle("biu出去让更多好友看到");
    this.mShareHelper.a().setOnDismissListener(new myr(this));
    this.mShareHelper.a().setCancelListener(new mys(this));
    this.mShareHelper.a(b(), 14);
    aTs();
  }
  
  private void aTs()
  {
    this.cd = null;
    this.i = null;
    do
    {
      try
      {
        this.i = URLDrawable.getDrawable(this.j.getVideoCoverURL(), null, null);
        if ((this.i != null) && (this.i.getStatus() == 1) && ((this.i.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.cd = ((RegionDrawable)this.i.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.VideoShareHelper", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.i == null);
    this.i.setURLDrawableListener(new myx(this));
    this.i.startDownload();
  }
  
  private boolean c(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i1 = -1;
    int i2 = -1;
    this.anH = true;
    BaseArticleInfo localBaseArticleInfo = this.j;
    Object localObject1 = new StringBuilder();
    Object localObject3 = this.jdField_a_of_type_Jym.hW();
    if (!TextUtils.isEmpty(localBaseArticleInfo.getShareUrl()))
    {
      ((StringBuilder)localObject1).append(localBaseArticleInfo.getShareUrl());
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((StringBuilder)localObject1).append("&iid=").append((String)localObject3);
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    int i3 = 3;
    int k;
    int n;
    int m;
    if (paramInt == 13)
    {
      k = 0;
      paramActionSheetItem = new Intent(this.mContext, ReadInJoyDeliverBiuActivity.class);
      if (this.j.busiType == 6) {
        paramActionSheetItem.putExtra("feedsType", this.j.mFeedType);
      }
      paramActionSheetItem.putExtra("ARG_VIDEO_ARTICLE_ID", this.j.mArticleID);
      paramActionSheetItem.putExtra("biu_src", 2);
      paramActionSheetItem.putExtra("arg_from_type", 8);
      paramActionSheetItem.putExtra("arg_article_info", (ArticleInfo)localBaseArticleInfo);
      this.mActivity.startActivityForResult(paramActionSheetItem, 102);
      this.mActivity.overridePendingTransition(0, 0);
      n = i1;
      m = i3;
    }
    label362:
    Object localObject4;
    label413:
    Object localObject2;
    for (;;)
    {
      localObject1 = new nce.a(null, localBaseArticleInfo.mSubscribeID, localBaseArticleInfo.mVideoVid, String.valueOf(localBaseArticleInfo.innerUniqueID), this.jdField_a_of_type_Mye.cZ(), localBaseArticleInfo.mVideoDuration * 1000).e(localBaseArticleInfo.mAlgorithmID).c(localBaseArticleInfo.mStrategyId).a(this.mChannelID).a().toJsonString();
      if ((paramInt != 1) && (paramInt != 11) && (paramInt != 6))
      {
        long l = this.mActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
        paramActionSheetItem = new ReportInfo.b();
        paramActionSheetItem.aSC = ((int)this.jdField_a_of_type_Mye.cZ());
        paramActionSheetItem.videoDuration = (localBaseArticleInfo.getVideoDuration() * 1000);
        if (l != 0L) {
          break label2628;
        }
        paramInt = 1;
        paramActionSheetItem.aSB = paramInt;
        kct.a(localBaseArticleInfo, this.mChannelID, 26, -1L, paramActionSheetItem);
      }
      localObject3 = localBaseArticleInfo.mSubscribeID;
      localObject4 = Integer.toString(m);
      if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
        break label2633;
      }
      paramActionSheetItem = localBaseArticleInfo.innerUniqueID;
      kbp.a(null, (String)localObject3, "0X800740F", "0X800740F", 0, 0, "1", (String)localObject4, paramActionSheetItem, (String)localObject1, false);
      l(k, n, false);
      return true;
      if (paramInt == 26)
      {
        this.mShareHelper.pr((String)localObject1 + "&sourcefrom=6");
        n = 2;
        m = i3;
        k = i2;
      }
      else if (paramInt == 1)
      {
        this.mShareHelper.pq((String)localObject1 + "&sourcefrom=6");
        n = 3;
        m = i3;
        k = i2;
      }
      else if (paramInt == 11)
      {
        this.anG = false;
        paramActionSheetItem = null;
        try
        {
          localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
          if (!TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin()))
          {
            paramActionSheetItem = localBaseArticleInfo.getSubscribeUin();
            paramActionSheetItem = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + paramActionSheetItem + "&uin_type=0&url=" + (String)localObject1 + "&type=4&key=" + localBaseArticleInfo.getInnerUniqueID();
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "click jubao btn, reportUrl:" + paramActionSheetItem);
            }
            localObject1 = new Intent(this.mActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramActionSheetItem);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.mActivity.startActivity((Intent)localObject1);
            n = 5;
            m = i3;
            k = i2;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localObject2 = paramActionSheetItem;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
              localObject2 = paramActionSheetItem;
              continue;
              if (!TextUtils.isEmpty(localBaseArticleInfo.thirdUin)) {
                paramActionSheetItem = localBaseArticleInfo.thirdUin;
              } else {
                paramActionSheetItem = "0";
              }
            }
          }
        }
      }
      else if (paramInt == 72)
      {
        k = 1;
        this.anG = false;
        a(this.D, paramActionSheetItem.uin, paramActionSheetItem.uinType, paramActionSheetItem.label);
        m = 0;
        n = 19;
      }
      else if ((paramInt == 2) || (paramInt == 73))
      {
        k = 1;
        this.anG = false;
        a(this.D, null, 0, "");
        m = 0;
        n = i1;
      }
      else if (paramInt == 5)
      {
        k = 6;
        if ((localBaseArticleInfo.qzoneShareUrl != null) && (localBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
        {
          this.mShareHelper.po(localBaseArticleInfo.qzoneShareUrl);
          m = i3;
          n = i1;
        }
        else
        {
          this.mShareHelper.po((String)localObject2 + "&sourcefrom=6");
          m = i3;
          n = i1;
        }
      }
      else
      {
        if (paramInt != 4) {
          break;
        }
        k = 7;
        this.anG = false;
        localObject2 = (String)localObject2 + "&sourcefrom=6";
        paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject2;
        if (localBaseArticleInfo.qzoneShareUrl != null)
        {
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject2;
          if (localBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
            paramActionSheetItem = localBaseArticleInfo.qzoneShareUrl;
          }
        }
        paramActionSheetItem = new Intent("android.intent.action.VIEW", Uri.parse(paramActionSheetItem));
        paramActionSheetItem.putExtra("big_brother_source_key", kxm.bg(0));
        paramActionSheetItem.putExtra("normal", true);
        try
        {
          this.mActivity.startActivity(paramActionSheetItem);
          m = i3;
          n = i1;
        }
        catch (ActivityNotFoundException paramActionSheetItem)
        {
          rwt.ez(1, 2131697436);
          m = i3;
          n = i1;
        }
      }
    }
    if (paramInt == 3)
    {
      k = 2;
      this.anG = false;
      m = 1;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("title", localBaseArticleInfo.mTitle);
      ((Bundle)localObject3).putString("desc", localBaseArticleInfo.mSummary);
      if ((localBaseArticleInfo.qzoneShareUrl != null) && (localBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
      {
        ((Bundle)localObject3).putString("detail_url", localBaseArticleInfo.qzoneShareUrl);
        label1174:
        localObject2 = new ArrayList(1);
        if (localBaseArticleInfo.getVideoCoverURL() != null) {
          break label1277;
        }
      }
      label1277:
      for (paramActionSheetItem = null;; paramActionSheetItem = localBaseArticleInfo.getVideoCoverURL().getFile())
      {
        ((ArrayList)localObject2).add(paramActionSheetItem);
        ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject2);
        ((Bundle)localObject3).putLong("req_share_id", 0L);
        avqq.a(getQQAppInterface(), this.mActivity, (Bundle)localObject3, null, 19202);
        n = i1;
        break;
        ((Bundle)localObject3).putString("detail_url", (String)localObject2 + "&sourcefrom=1");
        break label1174;
      }
    }
    label1440:
    label1463:
    Object localObject5;
    if (paramInt == 6)
    {
      if (!aqiw.isNetworkAvailable(this.mContext)) {
        return true;
      }
      muj.a(getQQAppInterface(), this.mActivity);
      m = 6;
      localObject3 = (String)localObject2 + "&sourcefrom=6";
      paramActionSheetItem = muj.p(localBaseArticleInfo);
      localObject2 = muj.a(localBaseArticleInfo);
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("videoDuration", localBaseArticleInfo.getVideoDuration());
      ((Bundle)localObject4).putLong("publishAccountUin", ((Long)localObject2).longValue());
      ((Bundle)localObject4).putString("publishAccountName", paramActionSheetItem);
      ((Bundle)localObject4).putLong("feedsId", localBaseArticleInfo.mFeedId);
      ((Bundle)localObject4).putInt("feedsType", localBaseArticleInfo.mFeedType);
      Activity localActivity;
      String str1;
      String str2;
      String str3;
      if (localBaseArticleInfo.busiType == 6)
      {
        k = 1;
        ((Bundle)localObject4).putInt("videoType", k);
        paramActionSheetItem = getQQAppInterface();
        if (paramActionSheetItem == null) {
          break label1555;
        }
        paramActionSheetItem = paramActionSheetItem.getCurrentUin();
        localObject5 = lgv.a();
        localActivity = this.mActivity;
        str1 = localBaseArticleInfo.getInnerUniqueID();
        str2 = localBaseArticleInfo.mTitle;
        str3 = localBaseArticleInfo.mSummary;
        if (localBaseArticleInfo.getVideoCoverURL() != null) {
          break label1561;
        }
      }
      label1555:
      label1561:
      for (localObject2 = "";; localObject2 = localBaseArticleInfo.getVideoCoverURL().getPath())
      {
        ((lgv)localObject5).a(localActivity, paramActionSheetItem, 2, str1, str2, str3, (String)localObject2, (String)localObject3, (Bundle)localObject4);
        this.S.add(localBaseArticleInfo.getInnerUniqueID());
        n = 4;
        k = i2;
        break;
        k = 2;
        break label1440;
        paramActionSheetItem = "";
        break label1463;
      }
    }
    boolean bool1;
    if ((paramInt == 9) || (paramInt == 10))
    {
      this.anG = false;
      bool1 = false;
      if (!TextUtils.isEmpty(localBaseArticleInfo.wechatShareUrl))
      {
        paramActionSheetItem = localBaseArticleInfo.wechatShareUrl;
        bool1 = true;
        k = 3;
        m = -1;
        label1619:
        if ((localBaseArticleInfo.qzoneShareUrl == null) || (!localBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com"))) {
          break label2640;
        }
        paramActionSheetItem = localBaseArticleInfo.qzoneShareUrl;
      }
    }
    label2326:
    label2628:
    label2633:
    label2640:
    for (;;)
    {
      for (;;)
      {
        localObject4 = new StringBuilder();
        if (localBaseArticleInfo.mVideoPlayCount > 0) {
          ((StringBuilder)localObject4).append(muj.bv(localBaseArticleInfo.mVideoPlayCount)).append(" ");
        }
        localObject2 = (BaseActivity)this.mActivity;
        localObject3 = localBaseArticleInfo.mTitle;
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject5 = this.cd;
        if (paramInt == 9) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          kcu.a((BaseActivity)localObject2, (String)localObject3, (String)localObject4, paramActionSheetItem, (Bitmap)localObject5, bool2, localBaseArticleInfo.innerUniqueID, bool1, null);
          n = m;
          m = k;
          k = n;
          n = i1;
          break;
          if (paramInt == 9)
          {
            paramActionSheetItem = (String)localObject2 + "&sourcefrom=2";
            k = 2;
            m = 3;
            break label1619;
          }
          paramActionSheetItem = (String)localObject2 + "&sourcefrom=3";
          k = 4;
          m = 4;
          break label1619;
        }
        if (paramInt == 12)
        {
          k = 5;
          this.anG = false;
          m = 5;
          localObject2 = (String)localObject2 + "&sourcefrom=4";
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject2;
          if (localBaseArticleInfo.qzoneShareUrl != null)
          {
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject2;
            if (localBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
              paramActionSheetItem = localBaseArticleInfo.qzoneShareUrl;
            }
          }
          localObject3 = localBaseArticleInfo.mTitle;
          if (localBaseArticleInfo.getVideoCoverURL() == null) {}
          for (localObject2 = "";; localObject2 = localBaseArticleInfo.getVideoCoverURL().getFile())
          {
            k((String)localObject3, "", paramActionSheetItem, (String)localObject2);
            n = i1;
            break;
          }
        }
        if (paramInt != 44) {
          break label2394;
        }
        i1 = 7;
        this.anG = false;
        paramActionSheetItem = new JSONObject();
        try
        {
          for (;;)
          {
            paramActionSheetItem.put("channel_id", this.mChannelID);
            paramActionSheetItem.put("source", 1);
            if ((localBaseArticleInfo.mDislikeInfos == null) || (localBaseArticleInfo.mDislikeInfos.size() <= 0)) {
              break label2326;
            }
            this.F = ((ausj)auss.a(this.mActivity, null));
            localObject2 = new myt(this);
            this.F.a((ausj.e)localObject2);
            localObject2 = new ReadInJoyDisLikeDialogView(this.mContext);
            ((ReadInJoyDisLikeDialogView)localObject2).setOnUninterestConfirmListener(new myu(this, localBaseArticleInfo, paramActionSheetItem));
            ((ReadInJoyDisLikeDialogView)localObject2).setUninterestData(localBaseArticleInfo.mDislikeInfos);
            this.F.setActionContentView((View)localObject2, null);
            m = i3;
            k = i2;
            n = i1;
            try
            {
              if (this.F.isShowing()) {
                break;
              }
              if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.awK()))
              {
                this.F.getWindow().setFlags(8, 8);
                this.F.getWindow().getDecorView().setSystemUiVisibility(this.mActivity.getWindow().getDecorView().getSystemUiVisibility());
                this.F.setOnShowListener(new myw(this));
              }
              this.F.show();
              kbp.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new nce.a(kct.a(null, null, null, null, paramActionSheetItem)).h(localBaseArticleInfo.innerUniqueID).a().toJsonString(), false);
              m = i3;
              k = i2;
              n = i1;
            }
            catch (Exception paramActionSheetItem)
            {
              m = i3;
              k = i2;
              n = i1;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "dislikeSheet.show exception=" + paramActionSheetItem);
          m = i3;
          k = i2;
          n = i1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          m = i3;
          k = i2;
          n = i1;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "文章ID为：" + localBaseArticleInfo.mArticleID + "的负反馈数据为空!");
      m = i3;
      k = i2;
      n = i1;
      break;
      label2394:
      if (paramInt == 22)
      {
        ncb.a(this.mActivity, localBaseArticleInfo, this.jdField_a_of_type_Mye.b(localBaseArticleInfo.getInnerUniqueID()), 3, 1);
        ncb.s(localBaseArticleInfo.getInnerUniqueID(), 3, 1);
        m = i3;
        k = i2;
        n = i1;
        break;
      }
      if (paramInt == 134)
      {
        paramActionSheetItem = this.j;
        if (paramActionSheetItem != null)
        {
          mix.h(this.mActivity, paramActionSheetItem.innerUniqueID, 3);
          m = i3;
          k = i2;
          n = i1;
          break;
        }
        QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
        m = i3;
        k = i2;
        n = i1;
        break;
      }
      m = i3;
      k = i2;
      n = i1;
      if (paramInt != 133) {
        break;
      }
      i2 = 8;
      localObject3 = this.j;
      m = i3;
      k = i2;
      n = i1;
      if (localObject3 == null) {
        break;
      }
      paramActionSheetItem = null;
      if (((BaseArticleInfo)localObject3).mVideoColumnInfo != null) {
        paramActionSheetItem = "" + ((BaseArticleInfo)localObject3).mVideoColumnInfo.aHc;
      }
      this.rijWatchWordPresenter.l(((BaseArticleInfo)localObject3).innerUniqueID, localJSONException, paramActionSheetItem, ((BaseArticleInfo)localObject3).mTitle);
      m = i3;
      k = i2;
      n = i1;
      break;
      paramInt = 2;
      break label362;
      paramActionSheetItem = "0";
      break label413;
    }
  }
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.mActivity;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(this.mContext, 0, 2131720152, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    for (;;)
    {
      return;
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
        paramString3.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina start webview!");
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareMsgToSina end!");
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(this.mContext, 0, 2131720152, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          paramString1.printStackTrace();
        }
      }
    }
  }
  
  private void l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.j == null) {
      return;
    }
    str = "";
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("network", kvp.U(this.mContext));
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("uin", String.valueOf(kxm.getLongAccountUin()));
      ((JSONObject)localObject).put("rowkey", this.j.innerUniqueID);
      ((JSONObject)localObject).put("source", "2");
      ((JSONObject)localObject).put("version", kct.XU);
      ((JSONObject)localObject).put("vid", this.j.getVideoVid());
      if (paramBoolean) {
        ((JSONObject)localObject).put("cancel", String.valueOf(1));
      }
      if (paramInt1 >= 0) {
        ((JSONObject)localObject).put("sourcefrom", String.valueOf(paramInt1));
      }
      if (paramInt2 >= 0) {
        ((JSONObject)localObject).put("share_unit", String.valueOf(paramInt2));
      }
      ((JSONObject)localObject).put("type", 2);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "shareReport:" + localException.toString());
          localObject = str;
        }
      }
    }
    localObject = new nce.a((String)localObject);
    kbp.a(null, "", "0X8009546", "0X8009546", 0, 0, "", String.valueOf(this.j.mArticleID), String.valueOf(this.j.mAlgorithmID), ((nce.a)localObject).a().toJsonString(), false);
  }
  
  public void K(View paramView, int paramInt)
  {
    this.mb = paramView;
    this.mCurrentPosition = paramInt;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, mye parammye, myz parammyz, int paramInt)
  {
    a(paramBaseArticleInfo, paramBundle, parammye, parammyz, paramInt, true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, Bundle paramBundle, mye parammye, myz parammyz, int paramInt, boolean paramBoolean)
  {
    this.j = paramBaseArticleInfo;
    this.jdField_a_of_type_Myz = parammyz;
    this.D = paramBundle;
    this.jdField_a_of_type_Mye = parammye;
    this.mChannelID = paramInt;
    if (paramBoolean) {
      aTr();
    }
    this.jdField_a_of_type_Jym = ((jym)getQQAppInterface().getBusinessHandler(136));
    this.jdField_a_of_type_Jym.aBf();
  }
  
  public List<Integer>[] b()
  {
    List localList = odg.bl();
    ArrayList localArrayList = new ArrayList();
    if (mix.a(getQQAppInterface(), this.j.isForbidReprint))
    {
      localArrayList.add(Integer.valueOf(134));
      localArrayList.add(Integer.valueOf(133));
    }
    for (;;)
    {
      if ((this.j.mDislikeInfos != null) && (!this.j.mDislikeInfos.isEmpty())) {
        localArrayList.add(Integer.valueOf(44));
      }
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(11));
      localArrayList.add(Integer.valueOf(22));
      return new List[] { localList, localArrayList };
      localArrayList.add(Integer.valueOf(133));
      localArrayList.add(Integer.valueOf(6));
    }
  }
  
  public void doOnDestory()
  {
    if ((this.mActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null))
    {
      this.mActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = null;
    }
    this.mb = null;
    this.rijWatchWordPresenter.detachView();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject == null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, bool);
      if (localObject == null) {}
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  public void setAdapter(ndi paramndi)
  {
    this.b = paramndi;
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(this.mActivity, 1, paramString, 0).show();
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(this.mActivity, 2, paramString, 0).show();
  }
  
  class a
    extends odg.a
  {
    a() {}
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      return myq.a(myq.this, paramInt, paramActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myq
 * JD-Core Version:    0.7.0.1
 */