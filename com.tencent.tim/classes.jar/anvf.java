import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3;
import com.tencent.mobileqq.structmsg.view.TitledImageView;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.model.WeishiFeedCommInfo;
import cooperation.qzone.model.WeishiFeedInfo;
import cooperation.qzone.model.WeishiUserInfo;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class anvf
  extends anqu
{
  public String Wz;
  public anvf.c a;
  public String accountName;
  public boolean cKb;
  public boolean cKc = true;
  boolean cKd = false;
  String chg;
  String chh;
  String chs;
  public String ciu;
  public String civ;
  public int dMH;
  public int dMI;
  public int dMJ;
  public int dMK;
  public int dML;
  public int dMM;
  private View.OnClickListener fP = new anvg(this);
  public String hH;
  public String imgUrl;
  String jumpUrl;
  public long mFeedId;
  public int mFeedType;
  protected View.OnClickListener mOnClickListener = new anvk(this);
  private URLDrawableDownListener.Adapter mUrlAdapter = new anvj(this);
  public String summary;
  String thirdAction = "";
  String thirdIcon = "";
  String thirdName = "";
  String thirdUinName = "";
  public String title;
  public int type;
  public String videoUrl;
  
  public anvf()
  {
    this.mTypeName = "video";
    this.mVersion = 14;
  }
  
  public anvf(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.mTypeName = "video";
    this.imgUrl = paramString1;
    this.type = paramInt1;
    this.ciu = paramString2;
    this.civ = paramString3;
    this.summary = paramString4;
    this.dMJ = paramInt2;
    this.dMI = paramInt3;
    this.dMK = paramInt4;
    this.dML = paramInt5;
    this.dMM = paramInt6;
    this.hH = paramString5;
    this.accountName = paramString6;
    this.Wz = paramString7;
    this.mFeedId = paramLong;
    this.mFeedType = paramInt7;
    this.mVersion = 14;
  }
  
  public anvf(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mTypeName = "video";
    this.imgUrl = paramString1;
    this.videoUrl = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.dMH = i;
      this.mVersion = 14;
      return;
      i = 0;
    }
  }
  
  private Intent b(JSONObject paramJSONObject)
    throws JSONException
  {
    long l = paramJSONObject.getLong("uin");
    String str1 = paramJSONObject.getString("ugcKey");
    Object localObject = paramJSONObject.getString("videoUrl");
    String str2 = paramJSONObject.getString("videoID");
    String str3 = paramJSONObject.getString("nickname");
    String str4 = paramJSONObject.getString("isTXVideo");
    int i = paramJSONObject.getInt("appid");
    paramJSONObject = new WeishiFeedInfo();
    paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
    paramJSONObject.feedCommInfo = new WeishiFeedCommInfo(i, str1, null, null, null);
    paramJSONObject.videoInfo = new VideoInfo();
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = new PictureUrl(this.imgUrl, this.dMK, this.dML);
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {}
    for (paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.orgwebsite = 0;; paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.orgwebsite = 1)
    {
      paramJSONObject.videoInfo.width = this.dMK;
      paramJSONObject.videoInfo.height = this.dML;
      paramJSONObject.videoInfo.videoId = str2;
      paramJSONObject.videoInfo.videoTime = this.dMM;
      paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramJSONObject);
      paramJSONObject = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
      paramJSONObject.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      paramJSONObject.setFlags(268435456);
      paramJSONObject.putExtra("key_weishi_entrance_type", 2);
      paramJSONObject.putParcelableArrayListExtra("key_videolist", (ArrayList)localObject);
      paramJSONObject.putExtra("key_current_feeduin", String.valueOf(l));
      paramJSONObject.putExtra("key_weishi_feeds_id", str1);
      paramJSONObject.putExtra("key_weishi_feed_appid", i);
      paramJSONObject.putExtra("key_weishi_entrance_type", 22);
      return paramJSONObject;
    }
  }
  
  private void bZ(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
    if (!TextUtils.isEmpty(getWebUrl()))
    {
      paramContext = anqx.getDomain(getWebUrl());
      if (!TextUtils.isEmpty(paramContext)) {
        anot.a(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private void fh(Context paramContext)
  {
    if ((TextUtils.isEmpty(getWebUrl())) || ((!getWebUrl().startsWith("http://")) && (!getWebUrl().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", getWebUrl());
        ocp.f(localIntent, getWebUrl());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(getWebUrl()));
      paramContext = anqx.getDomain(getWebUrl());
    } while (TextUtils.isEmpty(paramContext));
    anot.a(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private String getWebUrl()
  {
    return this.e.mMsgUrl;
  }
  
  private void o(Context paramContext, View paramView)
  {
    if (this.dMH == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839649);
      }
      if (this.a == null) {
        this.a = new anvf.c(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    bZ(paramContext, this.videoUrl);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (aza())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.cKb = true;
      this.title = localBundle.getString("public_account_video_title");
    }
    if (!this.e.hasFlag(4)) {}
    for (boolean bool1 = true; !this.cKb; bool1 = false) {
      return c(paramContext, paramView, localBundle);
    }
    if ((this.e instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label262;
      }
      this.hH = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.accountName = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.accountName = String.valueOf(((StructMsgForGeneralShare)this.e).mSourceName))
    {
      this.thirdIcon = ((StructMsgForGeneralShare)this.e).mSourceIcon;
      this.thirdName = ((StructMsgForGeneralShare)this.e).mSourceName;
      this.thirdAction = ((StructMsgForGeneralShare)this.e).mSourceUrl;
      this.thirdUinName = ((StructMsgForGeneralShare)this.e).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131378850) != null)
      {
        paramContext = paramView.getTag(2131378850);
        if ((paramContext instanceof anvf.b))
        {
          paramContext = (anvf.b)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.hH = String.valueOf(((StructMsgForGeneralShare)this.e).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131378850);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131720493));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int j;
    int k;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.TC(true);
      paramBundle.TE(true);
      if ((this.e != null) && (this.e.message != null)) {
        paramBundle.mIsSend = this.e.message.isSend();
      }
      if (this.dMK >= this.dML)
      {
        paramBundle.mMode = PAVideoView.egS;
        paramBundle.dau = true;
        paramBundle.dav = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130844049);
        ((ImageView)localObject2).setVisibility(8);
        i = wja.dp2px(62.0F, (Resources)localObject1);
        if (bool1) {
          i = wja.dp2px(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i = wja.dp2px(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.mIsSend) {
            break label1338;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131378850);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131378850);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131378850);
        if (!bool1) {
          break label1348;
        }
        i = wja.dp2px(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1405;
        }
        if ((this.e == null) || (this.e.message == null) || (!this.e.message.isSend())) {
          break label1361;
        }
        j = wja.dp2px(10.0F, (Resources)localObject1) + i;
        k = i;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(k, i, j, i);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131378849);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label753:
      Object localObject5;
      if (bool1)
      {
        ((TextView)localObject4).setTextSize(1, 14.0F);
        localObject5 = new LinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject5).rightMargin = wja.dp2px(7.0F, (Resources)localObject1);
        ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setSingleLine(true);
        if (!bool1) {
          break label1393;
        }
        ((TextView)localObject1).setTextSize(1, 12.0F);
      }
      for (;;)
      {
        ((TextView)localObject1).setTextColor(-1);
        localObject5 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject5).gravity = 85;
        ((LinearLayout.LayoutParams)localObject5).weight = 0.0F;
        ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new anvf.b();
        ((anvf.b)localObject5).a = paramBundle;
        ((anvf.b)localObject5).mTitleText = ((TextView)localObject4);
        ((anvf.b)localObject5).bU = ((ImageView)localObject2);
        ((anvf.b)localObject5).mTimeText = ((TextView)localObject1);
        ((anvf.b)localObject5).mTitleBar = ((View)localObject3);
        paramView.setTag(2131378850, localObject5);
        paramView.setTag(this);
        ((anvf.b)localObject5).a.a(this, (anvf.b)localObject5);
        boolean bool2 = anqs.a().d(paramContext, 3, this.e.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.e.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.ciu);
        }
        ((anvf.b)localObject5).a.showCover();
        if (this.dMJ > 0) {
          ((anvf.b)localObject5).mTimeText.setText(ShortVideoUtils.stringForTime(this.dMJ * 1000));
        }
        if (!TextUtils.isEmpty(this.jumpUrl)) {
          paramView.setTag(2131378856, this.jumpUrl);
        }
        paramView.setOnClickListener(this.mOnClickListener);
        if (this.hU != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.hU.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.hU.get());
        }
        return paramView;
        paramBundle.dav = false;
        paramBundle.dau = false;
        localObject3 = ShortVideoUtils.d(this.dMK, this.dML);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
        break;
        if (!this.cKc) {
          paramBundle.setRadiusTop(5.0F);
        }
        for (;;)
        {
          paramBundle.dav = true;
          paramBundle.dau = false;
          paramBundle.TC(true);
          paramBundle.TE(false);
          if (this.dMK >= this.dML) {
            break label1257;
          }
          paramBundle.mMode = PAVideoView.egR;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1257:
        if (this.dMK > this.dML)
        {
          paramBundle.mMode = PAVideoView.egQ;
          break;
        }
        if ((this.dMK == this.dML) && (this.dMK != 0) && (this.dML != 0))
        {
          if (bool1)
          {
            paramBundle.mMode = PAVideoView.egS;
            break;
          }
          paramBundle.mMode = PAVideoView.egR;
          break;
        }
        paramBundle.mMode = PAVideoView.egQ;
        break;
        label1338:
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
        break label547;
        label1348:
        i = wja.dp2px(12.0F, (Resources)localObject1);
        break label628;
        label1361:
        k = wja.dp2px(10.0F, (Resources)localObject1) + i;
        j = i;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1393:
        ((TextView)localObject1).setTextSize(1, 14.0F);
      }
      label1405:
      j = i;
      k = i;
    }
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {}
    label156:
    label834:
    label858:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((mzj.av(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.bF())))
        {
          QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
          }
          localObject = null;
        }
        if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mQzoneExtraMsg))
        {
          i((QQAppInterface)localObject, paramContext, paramStructMsgForGeneralShare.mQzoneExtraMsg);
          return;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.hH);
        if (this.type <= 1) {
          break label834;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.thirdUinName);
      localBundle.putString("VIDEO_H5_URL", this.e.mMsgUrl);
      if (!TextUtils.isEmpty(this.e.mMsgUrl)) {
        localBundle.putString("RED_PACKET_ID", Uri.parse(this.e.mMsgUrl).getQueryParameter("redpackid"));
      }
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (Object localObject = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; localObject = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.dMM));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.dMK));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.dML));
        localBundle.putString("VIDEO_VID", this.civ);
        localBundle.putString("VIDEO_COVER", this.imgUrl);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.Wz);
        localBundle.putString("VIDEO_TITLE", this.title);
        boolean bool1 = true;
        if ((this.type == 2) || (this.type == 3)) {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.type);
        if (isUgcVideo())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.mFeedType);
          localBundle.putLong("VIDEO_FEED_ID", this.mFeedId);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.thirdIcon);
          localBundle.putString("VIDEO_THIRD_NAME", this.thirdName);
          localBundle.putString("VIDEO_THIRD_ACTION", this.thirdAction);
          if (this.type == 2)
          {
            kxv.a();
            localBundle.putString("VIDEO_THIRD_URL", kxv.eC(this.civ));
          }
        }
        if ((this.e != null) && (this.e.message != null)) {
          anot.a(null, "dc00899", "Pb_account_lifeservice", this.e.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.ciu, "" + this.type, "" + this.e.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.e.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 0);
        localObject = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(acfp.m(2131717020)))) && (((AladdinConfig)localObject).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (awix.a(paramContext, this.Wz, localBundle))) {
          break;
        }
        bool1 = false;
        try
        {
          boolean bool2 = kzc.b(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label788;
        }
        if (!bool1) {
          break label858;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        MultiVideoFragment.s(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772077, 2130772079);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.accountName);
        break label156;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    label788:
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772077, 2130772079);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.imgUrl)) {
      paramXmlSerializer.attribute(null, "cover", this.imgUrl);
    }
    if (!TextUtils.isEmpty(this.videoUrl)) {
      paramXmlSerializer.attribute(null, "src", this.videoUrl);
    }
    if (!TextUtils.isEmpty(this.ciu)) {
      paramXmlSerializer.attribute(null, "vInfo", this.ciu);
    }
    if (!TextUtils.isEmpty(this.civ)) {
      paramXmlSerializer.attribute(null, "tInfo", this.civ);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.dMI));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.dMJ));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.dMK));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.dML));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.dMM));
    if (!TextUtils.isEmpty(this.summary)) {
      paramXmlSerializer.attribute(null, "summary", this.summary);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.type));
    if (!TextUtils.isEmpty(this.Wz)) {
      paramXmlSerializer.attribute(null, "aID", this.Wz);
    }
    if (this.dMH == 1) {
      paramXmlSerializer.attribute(null, "load", this.dMH + "");
    }
    if (!TextUtils.isEmpty(this.jumpUrl)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.jumpUrl);
    }
    if (this.cKd) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.chh)) {
        paramXmlSerializer.attribute(null, "apurl", this.chh);
      }
      if (!TextUtils.isEmpty(this.chs)) {
        paramXmlSerializer.attribute(null, "rl", this.chs);
      }
      if (!TextUtils.isEmpty(this.chg)) {
        paramXmlSerializer.attribute(null, "disType", this.chg);
      }
      if (this.mFeedId != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.mFeedId));
      }
      if (this.mFeedType != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.mFeedType));
      }
      if (this.dLY != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.dLY));
      }
      if (!TextUtils.isEmpty(this.chi)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.chi);
      }
      if (!TextUtils.isEmpty(this.chj)) {
        paramXmlSerializer.attribute(null, "aid", this.chj);
      }
      if (!TextUtils.isEmpty(this.chk)) {
        paramXmlSerializer.attribute(null, "app_download_schema", this.chk);
      }
      if (!TextUtils.isEmpty(this.chl)) {
        paramXmlSerializer.attribute(null, "canvas_json", this.chl);
      }
      if (!TextUtils.isEmpty(this.chm)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.chm);
      }
      if (this.dLZ != 0) {
        paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.dLZ));
      }
      if (!TextUtils.isEmpty(this.chn)) {
        paramXmlSerializer.attribute(null, "effect_url", this.chn);
      }
      if (!TextUtils.isEmpty(this.cho)) {
        paramXmlSerializer.attribute(null, "landing_page", this.cho);
      }
      if (!TextUtils.isEmpty(this.chp)) {
        paramXmlSerializer.attribute(null, "landing_page_report_url", this.chp);
      }
      if (!TextUtils.isEmpty(this.chq)) {
        paramXmlSerializer.attribute(null, "noco_id", this.chq);
      }
      if (!TextUtils.isEmpty(this.chr)) {
        paramXmlSerializer.attribute(null, "product_id", this.chr);
      }
      if (!TextUtils.isEmpty(this.chh)) {
        paramXmlSerializer.attribute(null, "apurl", this.chh);
      }
      if (this.dMa != 0) {
        paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.dMa));
      }
      if (this.dMb != 0) {
        paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.dMb));
      }
      if (!TextUtils.isEmpty(this.chs)) {
        paramXmlSerializer.attribute(null, "rl", this.chs);
      }
      if (!TextUtils.isEmpty(this.cht)) {
        paramXmlSerializer.attribute(null, "subordinate_product_id", this.cht);
      }
      if (!TextUtils.isEmpty(this.chu)) {
        paramXmlSerializer.attribute(null, "traceid", this.chu);
      }
      if (!TextUtils.isEmpty(this.chv)) {
        paramXmlSerializer.attribute(null, "via", this.chv);
      }
      if (!TextUtils.isEmpty(this.chw)) {
        paramXmlSerializer.attribute(null, "video_url", this.chw);
      }
      if (!TextUtils.isEmpty(this.mAppName)) {
        paramXmlSerializer.attribute(null, "appname", this.mAppName);
      }
      if (!TextUtils.isEmpty(this.chx)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.chx);
      }
      if (!TextUtils.isEmpty(this.mPkgName)) {
        paramXmlSerializer.attribute(null, "pkg_name", this.mPkgName);
      }
      if (!TextUtils.isEmpty(this.chy)) {
        paramXmlSerializer.attribute(null, "pkgurl", this.chy);
      }
      if (!TextUtils.isEmpty(this.Wm)) {
        paramXmlSerializer.attribute(null, "corporate_image_name", this.Wm);
      }
      if (!TextUtils.isEmpty(this.Wn)) {
        paramXmlSerializer.attribute(null, "corporate_logo", this.Wn);
      }
      if (this.cdl != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.cdl));
      }
      if (this.dMc != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.dMc));
      }
      if (!TextUtils.isEmpty(this.chB)) {
        paramXmlSerializer.attribute(null, "negative_feedback_url", this.chB);
      }
      if (!TextUtils.isEmpty(this.chC)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.chC);
      }
      if (!TextUtils.isEmpty(this.chD)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.chD);
      }
      if (this.dMd != 0) {
        paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.dMd));
      }
      if (this.dMe != 0) {
        paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.dMe));
      }
      if (this.dMf != 0) {
        paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.dMf));
      }
      if (this.dMg != 0) {
        paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.dMg));
      }
      if (!TextUtils.isEmpty(this.chE)) {
        paramXmlSerializer.attribute(null, "universal_link", this.chE);
      }
      if (!TextUtils.isEmpty(this.chF)) {
        paramXmlSerializer.attribute(null, "ext_json", this.chE);
      }
      if (!TextUtils.isEmpty(this.chG)) {
        paramXmlSerializer.attribute(null, "tencent_video_id", this.chG);
      }
      if (!TextUtils.isEmpty(this.Wj)) {
        paramXmlSerializer.attribute(null, "view_id", this.Wj);
      }
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    for (;;)
    {
      return true;
      this.imgUrl = paramansf.getAttribute("cover");
      this.videoUrl = paramansf.getAttribute("src");
      Object localObject = paramansf.getAttribute("load");
      this.ciu = paramansf.getAttribute("vInfo");
      this.civ = paramansf.getAttribute("tInfo");
      String str = paramansf.getAttribute("preTime");
      if (str != null) {}
      try
      {
        this.dMJ = Integer.valueOf(str).intValue();
        str = paramansf.getAttribute("preWidth");
        if (str == null) {}
      }
      catch (Exception localNumberFormatException8)
      {
        try
        {
          this.dMK = Integer.valueOf(str).intValue();
          label104:
          str = paramansf.getAttribute("preHeight");
          if (str != null) {}
          try
          {
            this.dML = Integer.valueOf(str).intValue();
            label127:
            str = paramansf.getAttribute("fullTime");
            if (str != null) {}
            try
            {
              this.dMM = Integer.valueOf(str).intValue();
              label150:
              this.summary = paramansf.getAttribute("summary");
              if (!TextUtils.isEmpty((CharSequence)localObject)) {}
              try
              {
                this.dMH = Integer.parseInt((String)localObject);
                label176:
                localObject = paramansf.getAttribute("busiType");
                if (TextUtils.isEmpty((CharSequence)localObject)) {}
              }
              catch (RuntimeException localNumberFormatException8)
              {
                try
                {
                  this.type = Integer.parseInt((String)localObject);
                  label199:
                  this.Wz = paramansf.getAttribute("aID");
                  this.jumpUrl = paramansf.getAttribute("jumpUrl");
                  this.cKd = "1".equals(paramansf.getAttribute("isJump2Web"));
                  localObject = paramansf.getAttribute("preStartPosi");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {}
                  try
                  {
                    this.dMI = Integer.valueOf((String)localObject).intValue();
                    this.chh = paramansf.getAttribute("apurl");
                    this.chs = paramansf.getAttribute("rl");
                    this.chg = paramansf.getAttribute("disType");
                    localObject = paramansf.getAttribute("feedId");
                    if (TextUtils.isEmpty((CharSequence)localObject)) {}
                  }
                  catch (Exception localNumberFormatException8)
                  {
                    try
                    {
                      this.mFeedId = Long.parseLong((String)localObject);
                      localObject = paramansf.getAttribute("feedType");
                      if (TextUtils.isEmpty((CharSequence)localObject)) {}
                    }
                    catch (Exception localNumberFormatException8)
                    {
                      try
                      {
                        this.mFeedType = Integer.parseInt((String)localObject);
                        if (this.mVersion >= 13)
                        {
                          localObject = paramansf.getAttribute("action_type");
                          if (TextUtils.isEmpty((CharSequence)localObject)) {}
                        }
                      }
                      catch (Exception localNumberFormatException8)
                      {
                        try
                        {
                          this.dLY = Integer.parseInt((String)localObject);
                          localObject = paramansf.getAttribute("dest_type");
                          if (TextUtils.isEmpty((CharSequence)localObject)) {}
                        }
                        catch (NumberFormatException localNumberFormatException8)
                        {
                          try
                          {
                            this.dLZ = Integer.parseInt((String)localObject);
                            localObject = paramansf.getAttribute("product_type");
                            if (TextUtils.isEmpty((CharSequence)localObject)) {}
                          }
                          catch (NumberFormatException localNumberFormatException8)
                          {
                            try
                            {
                              this.dMa = Integer.parseInt((String)localObject);
                              this.chi = paramansf.getAttribute("advertiser_id");
                              this.chj = paramansf.getAttribute("aid");
                              this.chk = paramansf.getAttribute("app_download_schema");
                              this.chl = paramansf.getAttribute("canvas_json");
                              this.chm = paramansf.getAttribute("customized_invoke_url");
                              this.chn = paramansf.getAttribute("effect_url");
                              this.cho = paramansf.getAttribute("landing_page");
                              this.chp = paramansf.getAttribute("landing_page_report_url");
                              this.chq = paramansf.getAttribute("noco_id");
                              this.chr = paramansf.getAttribute("product_id");
                              this.cht = paramansf.getAttribute("subordinate_product_id");
                              this.chu = paramansf.getAttribute("traceid");
                              this.chv = paramansf.getAttribute("via");
                              this.chw = paramansf.getAttribute("video_url");
                              this.mAppName = paramansf.getAttribute("appname");
                              this.chx = paramansf.getAttribute("customized_invoke_url");
                              this.mPkgName = paramansf.getAttribute("pkg_name");
                              this.chy = paramansf.getAttribute("pkgurl");
                              this.chs = paramansf.getAttribute("rl");
                              this.chh = paramansf.getAttribute("apurl");
                              this.Wm = paramansf.getAttribute("corporate_image_name");
                              this.Wn = paramansf.getAttribute("corporate_logo");
                              if (this.mVersion >= 14)
                              {
                                localObject = paramansf.getAttribute("mini_program_type");
                                if (TextUtils.isEmpty((CharSequence)localObject)) {}
                              }
                            }
                            catch (NumberFormatException localNumberFormatException8)
                            {
                              try
                              {
                                this.dMb = Integer.parseInt((String)localObject);
                                if (this.mVersion >= 15)
                                {
                                  localObject = paramansf.a;
                                  if (localObject != null)
                                  {
                                    str = ((ansf)localObject).getAttribute("tab_id");
                                    if (aqmr.isEmpty(str)) {}
                                  }
                                }
                              }
                              catch (NumberFormatException localNumberFormatException8)
                              {
                                try
                                {
                                  this.cdl = Integer.parseInt(str);
                                  localObject = ((ansf)localObject).getAttribute("is_hidden");
                                  if (aqmr.isEmpty((String)localObject)) {}
                                }
                                catch (NumberFormatException localNumberFormatException8)
                                {
                                  try
                                  {
                                    this.dMc = Integer.parseInt((String)localObject);
                                    if (this.mVersion < 16) {
                                      continue;
                                    }
                                    paramansf = paramansf.a;
                                    this.chB = paramansf.getAttribute("negative_feedback_url");
                                    this.chC = paramansf.getAttribute("sdk_exposure_monitor_url");
                                    this.chD = paramansf.getAttribute("sdk_click_monitor_url");
                                    localObject = paramansf.getAttribute("media_duration");
                                    if (aqmr.isEmpty((String)localObject)) {}
                                  }
                                  catch (NumberFormatException localNumberFormatException8)
                                  {
                                    try
                                    {
                                      this.dMd = Integer.parseInt((String)localObject);
                                      localObject = paramansf.getAttribute("video_file_size");
                                      if (aqmr.isEmpty((String)localObject)) {}
                                    }
                                    catch (NumberFormatException localNumberFormatException8)
                                    {
                                      try
                                      {
                                        this.dMe = Integer.parseInt((String)localObject);
                                        localObject = paramansf.getAttribute("app_score_num");
                                        if (aqmr.isEmpty((String)localObject)) {}
                                      }
                                      catch (NumberFormatException localNumberFormatException8)
                                      {
                                        try
                                        {
                                          this.dMf = Integer.parseInt((String)localObject);
                                          localObject = paramansf.getAttribute("download_num");
                                          if (aqmr.isEmpty((String)localObject)) {}
                                        }
                                        catch (NumberFormatException localNumberFormatException8)
                                        {
                                          try
                                          {
                                            for (;;)
                                            {
                                              for (;;)
                                              {
                                                this.dMg = Integer.parseInt((String)localObject);
                                                this.chE = paramansf.getAttribute("universal_link");
                                                this.chF = paramansf.getAttribute("ext_json");
                                                this.chG = paramansf.getAttribute("tencent_video_id");
                                                this.Wj = paramansf.getAttribute("view_id");
                                                return true;
                                                localException10 = localException10;
                                                try
                                                {
                                                  this.dMJ = ((int)Float.valueOf(str).floatValue());
                                                  if (!QLog.isColorLevel()) {
                                                    break;
                                                  }
                                                  QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.dMJ);
                                                }
                                                catch (Exception localException5) {}
                                              }
                                              break;
                                              localRuntimeException = localRuntimeException;
                                              this.dMH = 0;
                                              break label176;
                                              localException6 = localException6;
                                              try
                                              {
                                                this.dMI = ((int)Float.valueOf(localRuntimeException).floatValue());
                                                if (!QLog.isColorLevel()) {
                                                  continue;
                                                }
                                                QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.dMI);
                                              }
                                              catch (Exception localException1) {}
                                              continue;
                                              localException2 = localException2;
                                              if (QLog.isColorLevel())
                                              {
                                                QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
                                                continue;
                                                localException3 = localException3;
                                                if (QLog.isColorLevel())
                                                {
                                                  QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
                                                  continue;
                                                  localNumberFormatException1 = localNumberFormatException1;
                                                  this.dLY = 0;
                                                  continue;
                                                  localNumberFormatException2 = localNumberFormatException2;
                                                  this.dLZ = 0;
                                                  continue;
                                                  localNumberFormatException3 = localNumberFormatException3;
                                                  this.dMa = 0;
                                                  continue;
                                                  localNumberFormatException4 = localNumberFormatException4;
                                                  this.dMb = 0;
                                                  continue;
                                                  localNumberFormatException10 = localNumberFormatException10;
                                                  this.cdl = 0;
                                                  continue;
                                                  localNumberFormatException5 = localNumberFormatException5;
                                                  this.dMc = 0;
                                                  continue;
                                                  localNumberFormatException6 = localNumberFormatException6;
                                                  this.dMd = 0;
                                                  continue;
                                                  localNumberFormatException7 = localNumberFormatException7;
                                                  this.dMe = 0;
                                                }
                                              }
                                            }
                                            localNumberFormatException8 = localNumberFormatException8;
                                            this.dMf = 0;
                                          }
                                          catch (NumberFormatException localNumberFormatException9)
                                          {
                                            for (;;)
                                            {
                                              this.dMg = 0;
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
                      }
                    }
                  }
                }
                catch (Exception localException4)
                {
                  break label199;
                }
              }
            }
            catch (Exception localException7)
            {
              break label150;
            }
          }
          catch (Exception localException8)
          {
            break label127;
          }
        }
        catch (Exception localException9)
        {
          break label104;
        }
      }
    }
  }
  
  public boolean aza()
  {
    return (this.type >= 1) && (this.type <= 100);
  }
  
  protected View c(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    int i;
    int j;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      i = wja.dp2px(6.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      j = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130846330);
        paramView.setTag(this);
        try
        {
          localObject2 = new anqz(-16777216, j, j, i);
          if (TextUtils.isEmpty(this.imgUrl))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.hU != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.hU.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.hU.get());
            }
            paramView.setOnClickListener(this.fP);
            paramView.setOnClickListener(this.fP);
            if (this.hU != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.hU.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.hU.get());
            }
            return localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131369004);
            paramView.setContentDescription(((Resources)localObject1).getString(2131696498));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131720493));
            localObject1 = paramView;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localDrawable = null;
          }
        }
      }
    }
    for (;;)
    {
      URLDrawable localURLDrawable;
      try
      {
        localURLDrawable = URLDrawable.getDrawable(this.imgUrl, j, j, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new anvf.a(i, j, j));
        }
        if ((aoiz.hasFile(this.imgUrl)) || (!aoop.bD(paramContext))) {
          break label402;
        }
        localURLDrawable.setAutoDownload(bool);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1)) {
          break label379;
        }
        paramView.setBackgroundDrawable(localURLDrawable);
      }
      catch (Throwable paramContext)
      {
        paramView.setBackgroundDrawable(localDrawable);
      }
      break label113;
      label379:
      paramView.setURLDrawableDownListener(this.mUrlAdapter);
      paramView.setBackgroundDrawable(localURLDrawable);
      break label113;
      i = 0;
      break;
      label402:
      bool = true;
    }
  }
  
  public String getLayoutStr()
  {
    return "video";
  }
  
  protected void i(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = new JSONObject(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.optInt("enterVideoLayer") == 1))
      {
        QLog.d("structmsg.StructMsgItemVideo", 2, "[enterQzoneFullScreen] rays, qzShareMsg=" + paramQQAppInterface.toString());
        paramQQAppInterface = b(paramQQAppInterface);
        BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("structmsg.StructMsgItemVideo", 1, "[enterQzoneFullScreen] rays", paramQQAppInterface);
    }
  }
  
  public boolean isUgcVideo()
  {
    return this.type == 6;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.imgUrl = paramObjectInput.readUTF();
    this.videoUrl = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.dMH = Integer.parseInt(str);
      if (this.mVersion >= 7)
      {
        this.ciu = paramObjectInput.readUTF();
        this.civ = paramObjectInput.readUTF();
        this.dMJ = paramObjectInput.readInt();
        this.dMK = paramObjectInput.readInt();
        this.dML = paramObjectInput.readInt();
        this.dMM = paramObjectInput.readInt();
        this.summary = paramObjectInput.readUTF();
        this.type = paramObjectInput.readInt();
      }
      if (this.mVersion >= 8) {
        this.Wz = paramObjectInput.readUTF();
      }
      if (this.mVersion >= 9)
      {
        this.jumpUrl = paramObjectInput.readUTF();
        this.cKd = "1".equals(paramObjectInput.readUTF());
      }
      if (this.mVersion >= 10) {
        this.dMI = paramObjectInput.readInt();
      }
      if (this.mVersion >= 11)
      {
        this.chh = paramObjectInput.readUTF();
        this.chs = paramObjectInput.readUTF();
        this.chg = paramObjectInput.readUTF();
      }
      if ((this.mVersion >= 12) && (isUgcVideo()))
      {
        this.mFeedType = paramObjectInput.readInt();
        this.mFeedId = paramObjectInput.readLong();
      }
      if (this.mVersion >= 13)
      {
        this.chh = paramObjectInput.readUTF();
        this.chs = paramObjectInput.readUTF();
        this.dLY = paramObjectInput.readInt();
        this.chi = paramObjectInput.readUTF();
        this.chj = paramObjectInput.readUTF();
        this.chk = paramObjectInput.readUTF();
        this.chl = paramObjectInput.readUTF();
        this.chm = paramObjectInput.readUTF();
        this.dLZ = paramObjectInput.readInt();
        this.chn = paramObjectInput.readUTF();
        this.cho = paramObjectInput.readUTF();
        this.chp = paramObjectInput.readUTF();
        this.chq = paramObjectInput.readUTF();
        this.chr = paramObjectInput.readUTF();
        this.dMa = paramObjectInput.readInt();
        this.cht = paramObjectInput.readUTF();
        this.chu = paramObjectInput.readUTF();
        this.chv = paramObjectInput.readUTF();
        this.chw = paramObjectInput.readUTF();
        this.mAppName = paramObjectInput.readUTF();
        this.chx = paramObjectInput.readUTF();
        this.mPkgName = paramObjectInput.readUTF();
        this.chy = paramObjectInput.readUTF();
        this.Wm = paramObjectInput.readUTF();
        this.Wn = paramObjectInput.readUTF();
      }
      if (this.mVersion >= 14) {
        this.dMb = paramObjectInput.readInt();
      }
      if (this.mVersion >= 15)
      {
        this.cdl = paramObjectInput.readInt();
        this.dMc = paramObjectInput.readInt();
      }
      if (this.mVersion >= 16)
      {
        this.chB = paramObjectInput.readUTF();
        this.chC = paramObjectInput.readUTF();
        this.chD = paramObjectInput.readUTF();
        this.dMd = paramObjectInput.readInt();
        this.dMe = paramObjectInput.readInt();
        this.dMf = paramObjectInput.readInt();
        this.dMg = paramObjectInput.readInt();
        this.chE = paramObjectInput.readUTF();
        this.chF = paramObjectInput.readUTF();
        this.chG = paramObjectInput.readUTF();
        this.Wj = paramObjectInput.readUTF();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.mVersion).append("\n");
        paramObjectInput.append("imgUrl:").append(this.imgUrl).append("\n");
        paramObjectInput.append("videoUrl:").append(this.videoUrl).append("\n");
        paramObjectInput.append("vInfo:").append(this.ciu).append("\n");
        paramObjectInput.append("tInfo:").append(this.civ).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.dMJ).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.dMK).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.dML).append("\n");
        paramObjectInput.append("type:").append(this.type).append("\n");
        paramObjectInput.append("articleID").append(this.Wz).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.jumpUrl).append("\n");
        paramObjectInput.append("jump2Web:").append(this.cKd).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.dMI).append("\n");
        if ((this.mVersion >= 12) && (isUgcVideo()))
        {
          paramObjectInput.append("feedId:").append(this.mFeedId).append("\n");
          paramObjectInput.append("feedType:").append(this.mFeedType).append("\n");
        }
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.dMH = 0;
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.imgUrl != null)
    {
      str = this.imgUrl;
      paramObjectOutput.writeUTF(str);
      if (this.videoUrl == null) {
        break label1022;
      }
      str = this.videoUrl;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.dMH + "");
      if (this.mVersion >= 7)
      {
        if (this.ciu == null) {
          break label1028;
        }
        str = this.ciu;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.civ == null) {
          break label1034;
        }
        str = this.civ;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.dMJ);
        paramObjectOutput.writeInt(this.dMK);
        paramObjectOutput.writeInt(this.dML);
        paramObjectOutput.writeInt(this.dMM);
        if (this.summary == null) {
          break label1040;
        }
        str = this.summary;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.type);
      }
      if (this.mVersion >= 8)
      {
        if (this.Wz == null) {
          break label1046;
        }
        str = this.Wz;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.mVersion >= 9)
      {
        if (this.jumpUrl == null) {
          break label1052;
        }
        str = this.jumpUrl;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.cKd) {
          break label1058;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.mVersion >= 10) {
        paramObjectOutput.writeInt(this.dMI);
      }
      if (this.mVersion >= 11)
      {
        if (this.chh == null) {
          break label1064;
        }
        str = this.chh;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.chs == null) {
          break label1070;
        }
        str = this.chs;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.chg == null) {
          break label1076;
        }
        str = this.chg;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.mVersion >= 12) && (isUgcVideo()))
      {
        paramObjectOutput.writeInt(this.mFeedType);
        paramObjectOutput.writeLong(this.mFeedId);
      }
      if (this.mVersion >= 13)
      {
        if (this.chh == null) {
          break label1082;
        }
        str = this.chh;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.chs == null) {
          break label1088;
        }
        str = this.chs;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.dLY);
        if (this.chi != null) {
          break label1094;
        }
        str = "0";
        label449:
        paramObjectOutput.writeUTF(str);
        if (this.chj != null) {
          break label1102;
        }
        str = "0";
        label466:
        paramObjectOutput.writeUTF(str);
        if (this.chk != null) {
          break label1110;
        }
        str = "";
        label483:
        paramObjectOutput.writeUTF(str);
        if (this.chl != null) {
          break label1118;
        }
        str = "";
        label500:
        paramObjectOutput.writeUTF(str);
        if (this.chm != null) {
          break label1126;
        }
        str = "";
        label517:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.dLZ);
        if (this.chn != null) {
          break label1134;
        }
        str = "";
        label544:
        paramObjectOutput.writeUTF(str);
        if (this.cho != null) {
          break label1142;
        }
        str = "";
        label561:
        paramObjectOutput.writeUTF(str);
        if (this.chp != null) {
          break label1150;
        }
        str = "";
        label578:
        paramObjectOutput.writeUTF(str);
        if (this.chq != null) {
          break label1158;
        }
        str = "";
        label595:
        paramObjectOutput.writeUTF(str);
        if (this.chr != null) {
          break label1166;
        }
        str = "";
        label612:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.dMa);
        if (this.cht != null) {
          break label1174;
        }
        str = "";
        label639:
        paramObjectOutput.writeUTF(str);
        if (this.chu != null) {
          break label1182;
        }
        str = "";
        label656:
        paramObjectOutput.writeUTF(str);
        if (this.chv != null) {
          break label1190;
        }
        str = "";
        label673:
        paramObjectOutput.writeUTF(str);
        if (this.chw != null) {
          break label1198;
        }
        str = "";
        label690:
        paramObjectOutput.writeUTF(str);
        if (this.mAppName != null) {
          break label1206;
        }
        str = "";
        label707:
        paramObjectOutput.writeUTF(str);
        if (this.chx != null) {
          break label1214;
        }
        str = "";
        label724:
        paramObjectOutput.writeUTF(str);
        if (this.mPkgName != null) {
          break label1222;
        }
        str = "";
        label741:
        paramObjectOutput.writeUTF(str);
        if (this.chy != null) {
          break label1230;
        }
        str = "";
        label758:
        paramObjectOutput.writeUTF(str);
        if (this.Wm != null) {
          break label1238;
        }
        str = "";
        label775:
        paramObjectOutput.writeUTF(str);
        if (this.Wn != null) {
          break label1246;
        }
        str = "";
        label792:
        paramObjectOutput.writeUTF(str);
      }
      if (this.mVersion >= 14) {
        paramObjectOutput.writeInt(this.dMb);
      }
      if (this.mVersion >= 15)
      {
        paramObjectOutput.writeInt(this.cdl);
        paramObjectOutput.writeInt(this.dMc);
      }
      if (this.mVersion >= 16)
      {
        if (this.chB != null) {
          break label1254;
        }
        str = "";
        label866:
        paramObjectOutput.writeUTF(str);
        if (this.chC != null) {
          break label1262;
        }
        str = "";
        label883:
        paramObjectOutput.writeUTF(str);
        if (this.chD != null) {
          break label1270;
        }
        str = "";
        label900:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.dMd);
        paramObjectOutput.writeInt(this.dMe);
        paramObjectOutput.writeInt(this.dMf);
        paramObjectOutput.writeInt(this.dMg);
        if (this.chE != null) {
          break label1278;
        }
        str = "";
        label957:
        paramObjectOutput.writeUTF(str);
        if (this.chF != null) {
          break label1286;
        }
        str = "";
        label974:
        paramObjectOutput.writeUTF(str);
        if (this.chG != null) {
          break label1294;
        }
        str = "";
        label991:
        paramObjectOutput.writeUTF(str);
        if (this.Wj != null) {
          break label1302;
        }
      }
    }
    label1028:
    label1034:
    label1040:
    label1302:
    for (String str = "";; str = this.Wj)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      label1022:
      str = "";
      break label36;
      str = "";
      break label92;
      str = "";
      break label111;
      str = "";
      break label170;
      label1046:
      str = "";
      break label208;
      label1052:
      str = "";
      break label236;
      label1058:
      str = "0";
      break label254;
      label1064:
      str = "";
      break label301;
      label1070:
      str = "";
      break label320;
      label1076:
      str = "";
      break label339;
      label1082:
      str = "";
      break label403;
      label1088:
      str = "";
      break label422;
      label1094:
      str = this.chi;
      break label449;
      label1102:
      str = this.chj;
      break label466;
      label1110:
      str = this.chk;
      break label483;
      label1118:
      str = this.chl;
      break label500;
      label1126:
      str = this.chm;
      break label517;
      label1134:
      str = this.chn;
      break label544;
      label1142:
      str = this.cho;
      break label561;
      label1150:
      str = this.chp;
      break label578;
      str = this.chq;
      break label595;
      str = this.chr;
      break label612;
      label1174:
      str = this.cht;
      break label639;
      label1182:
      str = this.chu;
      break label656;
      label1190:
      str = this.chv;
      break label673;
      label1198:
      str = this.chw;
      break label690;
      label1206:
      str = this.mAppName;
      break label707;
      label1214:
      str = this.chx;
      break label724;
      label1222:
      str = this.mPkgName;
      break label741;
      label1230:
      str = this.chy;
      break label758;
      label1238:
      str = this.Wm;
      break label775;
      label1246:
      str = this.Wn;
      break label792;
      label1254:
      str = this.chB;
      break label866;
      label1262:
      str = this.chC;
      break label883;
      label1270:
      str = this.chD;
      break label900;
      label1278:
      str = this.chE;
      break label957;
      str = this.chF;
      break label974;
      str = this.chG;
      break label991;
    }
  }
  
  class a
    extends aqbn
  {
    private int height;
    private int radius;
    private int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.radius = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
    }
    
    public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
    {
      if (paramBitmap == null) {
        return null;
      }
      int j = this.height;
      int k = paramBitmap.getWidth();
      if (paramBitmap.getHeight() != 0) {}
      for (int i = paramBitmap.getHeight();; i = this.height)
      {
        i = k * j / i;
        return aqhu.c(paramBitmap, this.radius, i, this.height);
      }
    }
  }
  
  public static class b
  {
    public PAVideoView a;
    public ImageView bU;
    public TextView mTimeText;
    public View mTitleBar;
    public TextView mTitleText;
  }
  
  public static class c
    extends Handler
  {
    private WeakReference<anvf> an;
    
    public c(anvf paramanvf)
    {
      this.an = new WeakReference(paramanvf);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((anvf)this.an.get() != null) {
        ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130846330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvf
 * JD-Core Version:    0.7.0.1
 */