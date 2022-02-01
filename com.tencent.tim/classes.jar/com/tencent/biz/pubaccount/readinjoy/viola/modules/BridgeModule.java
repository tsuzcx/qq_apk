package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import acbn;
import acja;
import aczc;
import afgc;
import ahgq;
import aifl;
import alkw;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import anwa;
import aoiz;
import apmj;
import aqcx;
import aqfy;
import aqgo;
import aqgz;
import aqgz.a;
import aqhv;
import aqik;
import aqiz;
import aqju;
import aqul;
import aqux;
import aquz;
import aqva;
import aqvc;
import arvv;
import arwu;
import aryx;
import aviz;
import avpw;
import awit;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.b;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.liveroom.LiveRoomProxyActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import jnl;
import jnm;
import jpa;
import jqc;
import kbp;
import kct;
import knd;
import knf;
import kpn;
import kqd;
import kqi;
import kvp;
import kxk;
import kxm;
import lbz;
import lcc;
import lcd;
import lgv;
import lwh;
import mix;
import mmr;
import mnw;
import mnw.c;
import moi;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mwq;
import myn;
import ncb;
import nce;
import nce.a;
import ndi;
import ntp;
import nug;
import nuk;
import nuk.a;
import nuq;
import nuu;
import nuv;
import nuw;
import nux;
import nuy;
import nuz;
import nva;
import nvb;
import nvc;
import nvd;
import nve;
import nvf;
import nvh;
import nvi;
import nvj;
import nvk;
import nvl;
import nvm;
import nvn;
import nvo;
import nvp;
import nvq;
import nvs;
import nvv;
import nvw;
import nvx;
import nvy;
import nvz;
import nwa;
import nwb;
import nwc;
import nwd;
import nwe;
import nwg;
import nwj;
import nww;
import nyy.b;
import nzb;
import nze;
import oaq;
import oaz;
import obw;
import odg;
import odg.a;
import oem;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rpw;
import rwt;
import skj;
import skj.a;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tgk;
import tgl;
import tkv;
import tkw;
import tla;
import tla.a;
import tlb;
import wja;

public class BridgeModule
  extends BaseModule
  implements Destroyable, IActivityState, nyy.b, skj.a
{
  public static final String BRIDGE_LOCAL_JS_URL = "https://viola.qq.com/viola_serve/dev";
  public static final String BRIDGE_METHOD_NAME_ONCLICKBUBBLETIPS = "onClickBubbleTips";
  public static final String BRIDGE_METHOD_NAME_REQUESTBUBBLETIPSWORDING = "requestBubbleTipsWording";
  public static final String BRIDGE_PARAMS = "params";
  public static final String BRIDGE_PARAMS_ACCURATE = "accurate";
  public static final String BRIDGE_PARAMS_ACTION = "action";
  public static final String BRIDGE_PARAMS_ANDROIDID = "androidID";
  public static final String BRIDGE_PARAMS_BID = "v_bid";
  public static final String BRIDGE_PARAMS_CHANNELID = "channelId";
  public static final String BRIDGE_PARAMS_FROMCALLBACK = "fromCallback";
  public static final String BRIDGE_PARAMS_IDENTIFIER = "identifier";
  public static final String BRIDGE_PARAMS_IMSI = "imsi";
  public static final String BRIDGE_PARAMS_JS = "js";
  public static final String BRIDGE_PARAMS_PICURL = "picUrl";
  public static final String BRIDGE_PARAMS_QIMEI = "qimei";
  public static final String BRIDGE_PARAMS_QUA = "qua";
  public static final String BRIDGE_PARAMS_RATE = "rate";
  public static final String BRIDGE_PARAMS_RECOMMEND = "showRecommendReason";
  public static final String BRIDGE_PARAMS_REDPACKET_ID = "redPacketId";
  public static final String BRIDGE_PARAMS_REDPACKET_ID_SM = "redpackid";
  public static final String BRIDGE_PARAMS_ROWKEY = "rowkey";
  public static final String BRIDGE_PARAMS_SHOULD_SHOW = "shouldShow";
  public static final String BRIDGE_PARAMS_STATUS = "status";
  public static final String BRIDGE_PARAMS_TID = "v_tid";
  public static final String BRIDGE_PARAMS_TYPE = "type";
  public static final String BRIDGE_PARAMS_VID = "vid";
  public static final String BRIDGE_PARAMS_VIDEOFEEDSJS = "VideoFeeds.js";
  public static final String BRIDGE_PARAMS_WORDING = "wording";
  public static final String BRIDGE_WX_CIRCLE_SHARE_URL = "wx_circle_share_url";
  public static final String BRIDGE_WX_SHARE_URL = "wx_share_url";
  public static final int CODE_QRCODE = 1;
  public static final byte CODE_SHARE_IMAGE = 18;
  public static final int DOWNLOAD_ACTION_CANCEL = 3;
  public static final int DOWNLOAD_ACTION_PAUSE = 1;
  public static final int DOWNLOAD_ACTION_RESUME = 2;
  public static final int DOWNLOAD_STAET_PAUSE = 5;
  public static final int DOWNLOAD_STATE_CANCEL = 3;
  public static final int DOWNLOAD_STATE_ERROR = 4;
  public static final int DOWNLOAD_STATE_FINISH = 2;
  public static final int DOWNLOAD_STATE_INSTALL_SUCCESS = 6;
  public static final int DOWNLOAD_STATE_UPDATE = 1;
  public static final String KEY_PREDOWNLOAD_MGR = "predownload";
  public static String MODULE_NAME = "bridge";
  public static final byte OPENCAMERA = 112;
  public static final byte OPENIMG = 111;
  public static final int PHOTO_CLIP_BANNER_H = 200;
  public static final int PHOTO_CLIP_BANNER_W = 360;
  public static final int PHOTO_CLIP_HEAD_SIZE = 360;
  public static final int PHOTO_CLIP_SIZE = 640;
  public static final int PHOTO_TAGGET_BANNER_W = 750;
  public static final int PHOTO_TARGET_BANNER_H = 416;
  public static final int PHOTO_TARGET_HEAD_SIZE = 160;
  public static final byte REQ_CODE_AQ_INVITE_FRIEND = 119;
  public static final byte REQ_CODE_COMMENT_EDITOR = 117;
  public static final byte REQ_CODE_DELIVER = 113;
  public static final byte REQ_CODE_DELIVER_QUESTION = 122;
  public static final byte REQ_CODE_DELIVER_TopicPic = 121;
  public static final byte REQ_CODE_DELIVER_UGC = 114;
  public static final byte REQ_CODE_SELECT_AND_UPLOAD_AVATAR = 118;
  public static final byte REQ_CODE_SHARE_QZONE = 125;
  public static final byte REQ_CODE_UGC_ADD_VIDEO = 124;
  public static final byte REQ_CODE_UGC_CAMERA_CAPTURE = 116;
  public static final byte REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM = 115;
  public static final byte REQ_CODE_UGC_MANAGE_COLUMN = 123;
  public static String TAG = "BridgeModule";
  public static GdtAppReceiver mGdtAppReceiver;
  public static String shareCallBackId;
  public static String shareCallBackName;
  public static int shareCallBackType;
  private Map<Long, String> columnToUploadCallbackMap = new HashMap();
  private String commentCallbaclId;
  private kqd dataManager;
  private boolean hasShareItemClick;
  private nuq mActionSheetHelper;
  private nwj mBridgeApiHelper;
  private String mCallBack;
  private skj mClient;
  private nww mCommentManager;
  private aryx mDownloadListener;
  private nwe mEventHelper;
  private Map<String, Object> mObjectMap = new ArrayMap();
  protected ShareActionSheetBuilder mShareActionSheet;
  private odg mShareHelper;
  private nwg mShareUtils = new nwg();
  private int mState = -100;
  private String mUploadCallBack;
  private VideoPreDownloadMgr mVideoPreDownloadMgr = new VideoPreDownloadMgr();
  private int maxSize = 204800;
  private int minDuration = 5;
  private INetInfoHandler netInfoHandler;
  private long preTime;
  private nze rijWatchWordPresenter;
  private String shareToFriendUin = "";
  private String shareToFriendUinName = "";
  private int shareToFriendUinType;
  private String shareVideoCallBackId;
  private mnw.c videoPublishCallback = new nvs(this);
  private moi violaVideoUpdateController;
  
  public BridgeModule()
  {
    this.mObjectMap.put("predownload", this.mVideoPreDownloadMgr);
    this.rijWatchWordPresenter = new nze(new nzb());
    this.rijWatchWordPresenter.a(this);
  }
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        int n = paramJSONObject.optInt("showType", 0);
        QLog.d(TAG, 1, "startShowComment  uniqueKey = " + str1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str4, str5, l));
        paramJSONObject.putInt("source", i);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool);
        paramJSONObject.putInt("jumpType", m);
        paramJSONObject.putInt("seq", paramInt);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).acb = ((String)localObject1);
        ((AnchorData)localObject2).acd = str2;
        ((AnchorData)localObject2).ahJ = bool;
        QLog.d(TAG, 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (n == 1)
        {
          bool = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, QLog.getStackTraceString(paramJSONObject));
      }
      bool = false;
    }
  }
  
  private void arouseReadInJoyNativeCommentView(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      arouseReadInJoyNativeCommentView(paramJSONObject, bindCommentCallback(paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(TAG, 1, "arouseReadInJoyNativeCommentView Exception:", paramJSONObject);
    }
  }
  
  private void batchCheckUpdate(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    paramJSONObject = paramJSONObject.optJSONArray("bids");
    ArrayList localArrayList;
    if (paramJSONObject != null) {
      localArrayList = new ArrayList();
    }
    try
    {
      while (i < paramJSONObject.length())
      {
        localArrayList.add(i, paramJSONObject.get(i).toString());
        i += 1;
      }
      jpa.a(localArrayList, kxm.getAppRuntime(), new nve(this, paramString), true, false);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "batchCheckUpdate error" + paramJSONObject.getMessage());
      invokeErrorCallJS(paramString, null);
    }
  }
  
  private int bindCommentCallback(String paramString)
  {
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    this.commentCallbaclId = paramString;
    return this.mClient.a(this);
  }
  
  private void canOpenPage(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = BaseActivity.sTopActivity;
    } while (localBaseActivity == null);
    ntp.a(localBaseActivity, paramJSONObject, new nvc(this, paramString));
  }
  
  private AnchorData createAnchorData(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("commentID");
    String str2 = paramJSONObject.optString("subCommentID");
    boolean bool = paramJSONObject.optBoolean("isAwesome");
    paramJSONObject = new AnchorData();
    paramJSONObject.acb = str1;
    paramJSONObject.acd = str2;
    paramJSONObject.ahJ = bool;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment anchorData commentId:" + str1 + " ,subCommentId :" + str2);
    }
    return paramJSONObject;
  }
  
  private ArticleInfo createArticleInfo(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("rowkey");
    String str2 = paramJSONObject.optString("title", "");
    String str3 = paramJSONObject.optString("cover", "");
    long l1 = paramJSONObject.optLong("articleId", 0L);
    long l2 = paramJSONObject.optLong("feedsID", 0L);
    int i = paramJSONObject.optInt("feedsType", 0);
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.innerUniqueID = str1;
    localArticleInfo.mTitle = str2;
    localArticleInfo.mSummary = null;
    localArticleInfo.mFirstPagePicUrl = str3;
    localArticleInfo.mArticleID = l1;
    localArticleInfo.mFeedId = l2;
    localArticleInfo.mFeedType = i;
    if (!TextUtils.isEmpty(paramJSONObject.optString("vid", ""))) {
      localArticleInfo.mVideoVid = paramJSONObject.optString("vid");
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("picUrl", ""))) {
      localArticleInfo.mVideoCoverUrl = kxm.b(paramJSONObject.optString("picUrl"));
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "openTopicVideoComment  uniqueKey = " + str1 + "feedsId = " + l2 + " feedsType=" + i + "title = " + str2 + "picUrl =" + str3 + "articleId =" + l1);
    }
    return localArticleInfo;
  }
  
  private void detailLog(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localObject == null) || (localBaseActivity == null)) {}
    StringBuilder localStringBuilder1;
    label243:
    label255:
    do
    {
      return;
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramJSONObject.optString("id")).append("|").append(paramJSONObject.optString("subid")).append("|").append(paramJSONObject.optString("content")).append("|").append("ANDROID").append("|").append("3.4.4.3058").append("|").append(aqgz.getDeviceOSVersion()).append("|").append(((QQAppInterface)localObject).getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
      if (TextUtils.isEmpty(aqgz.a(localBaseActivity).cth))
      {
        localObject = "未知";
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append("|");
        if (!TextUtils.isEmpty(aqgz.a(localBaseActivity).networkType)) {
          break label243;
        }
      }
      for (localObject = "未知";; localObject = aqgz.a(localBaseActivity).networkType)
      {
        localStringBuilder2.append((String)localObject);
        if (!paramJSONObject.optBoolean("isall", false)) {
          break label255;
        }
        QLog.w("ViolaLog", 1, localStringBuilder1.toString());
        invokeCallJS(paramString, null);
        return;
        localObject = aqgz.a(localBaseActivity).cth;
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ViolaLog", 2, localStringBuilder1.toString());
    invokeCallJS(paramString, null);
  }
  
  private void doPostShowComment(FragmentActivity paramFragmentActivity, VVideoView paramVVideoView, View paramView, JSONObject paramJSONObject)
  {
    Object localObject;
    if (this.mCommentManager == null)
    {
      localObject = paramFragmentActivity.getSupportFragmentManager();
      if ((getViolaInstance() == null) || (!((ViolaFragment)getViolaInstance().getFragment()).Gh()) || (!((ViolaFragment)getViolaInstance().getFragment()).a().Ge())) {
        break label214;
      }
    }
    label214:
    for (int i = ((ViolaFragment)getViolaInstance().getFragment()).a().qX();; i = 0)
    {
      this.mCommentManager = new nww(paramFragmentActivity, (FragmentManager)localObject, i);
      if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
      {
        paramFragmentActivity = (ViolaFragment)getViolaInstance().getFragment();
        if ((paramFragmentActivity.Gh()) && (paramFragmentActivity.a() != null)) {
          paramFragmentActivity.a().bbm();
        }
      }
      this.mCommentManager.a(new nvh(this));
      paramFragmentActivity = createArticleInfo(paramJSONObject);
      localObject = createAnchorData(paramJSONObject);
      float f = ViolaUtils.getFloat(paramJSONObject.optString("offset"), Float.valueOf(0.0F));
      this.mCommentManager.d(paramView, f);
      this.mCommentManager.a(paramVVideoView, paramView, paramFragmentActivity, (AnchorData)localObject, -16777216);
      return;
    }
  }
  
  private void downloadApk(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      String str = paramJSONObject.optString("apkUrl");
      localDownloadInfo.urlStr = str;
      localDownloadInfo.packageName = paramJSONObject.optString("packageName", null);
      localDownloadInfo.source = "biz_src_feeds_kandianads";
      if (this.mDownloadListener == null) {
        this.mDownloadListener = new nuz(this, str, paramString);
      }
      arvv.a().a(this.mDownloadListener);
      localDownloadInfo.emb();
      arvv.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApkAction(JSONObject paramJSONObject)
  {
    int i;
    if ((paramJSONObject != null) && (paramJSONObject.optString("apkUrl") != null) && (paramJSONObject.optInt("action", -1) != -1))
    {
      i = paramJSONObject.optInt("action", -1);
      if (i != 1) {
        break label44;
      }
      downloadApkPause(paramJSONObject);
    }
    label44:
    do
    {
      return;
      if (i == 2)
      {
        downloadApkResume(paramJSONObject);
        return;
      }
    } while (i != 3);
    downloadApkCancel(paramJSONObject);
  }
  
  private void downloadApkCancel(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      arvv.a().N(paramJSONObject, true);
    }
  }
  
  private void downloadApkPause(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      arvv.a().fx(paramJSONObject);
    }
  }
  
  private void downloadApkResume(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.urlStr = paramJSONObject;
      localDownloadInfo.source = "biz_src_feeds_kandianads";
      localDownloadInfo.emb();
      arvv.a().b(localDownloadInfo);
    }
  }
  
  private void downloadApp(String paramString)
  {
    Context localContext = getViolaInstance().getContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      Object localObject = oem.b(paramString);
      if (localObject != null)
      {
        ((DownloadInfo)localObject).emb();
        arvv.a().b((DownloadInfo)localObject);
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new Intent(localContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("big_brother_source_key", kxm.bg(0));
        ((Intent)localObject).putExtra("url", paramString.optString("url"));
        localContext.startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "downloadApp error" + paramString.getMessage());
  }
  
  private void downloadForGooglePlay(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.BROWSABLE");
      localIntent.setData(Uri.parse(paramString));
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        paramString.startActivity(localIntent);
      }
    }
  }
  
  private void ensureEventHelper()
  {
    if (this.mEventHelper == null) {
      this.mEventHelper = new nwe(this);
    }
  }
  
  private void feedsRefreshMessage(JSONObject paramJSONObject)
  {
    lwh.a().Z(paramJSONObject);
  }
  
  private void fireGetLocation(JSONObject paramJSONObject, String paramString)
  {
    int i = -1;
    if (paramJSONObject != null) {
      i = ViolaUtils.getInt(Integer.valueOf(paramJSONObject.optInt("allowCacheTime")));
    }
    if (hasAuthorizeLocation())
    {
      if (i > 0)
      {
        fireGetLocationFromCache("webview", paramString);
        return;
      }
      fireGetLocationFromSso("webview", paramString);
      return;
    }
    fireLocationErrorCallback(paramString, "no authorize");
  }
  
  private void fireGetLocationFromCache(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = aczc.a(paramString1);
    if ((paramString1 != null) && (paramString1.a != null))
    {
      fireLocationSuccessCallback(paramString1, paramString2);
      return;
    }
    fireLocationErrorCallback(paramString2, "fail to get locationInfo from cache");
  }
  
  private void fireGetLocationFromSso(String paramString1, String paramString2)
  {
    aczc.a(new nvz(this, paramString1, paramString2));
  }
  
  private void fireLocationErrorCallback(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramString2 = getFailInvokeObj(paramString2);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", 1).put("authroized", false);
        paramString2.put("data", localJSONObject);
        invokeJS(paramString1, paramString2);
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e(TAG, 1, "fireLocationErrorCallbackError: " + paramString1.getMessage());
        return;
      }
      paramString2 = "";
    }
  }
  
  private void fireLocationSuccessCallback(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
      return;
    }
    double d1 = paramSosoLbsInfo.a.cd;
    double d2 = 1000000;
    double d3 = paramSosoLbsInfo.a.ce;
    double d4 = 1000000;
    double d5 = paramSosoLbsInfo.a.cd;
    double d6 = paramSosoLbsInfo.a.ce;
    String str;
    if (paramSosoLbsInfo.a.city != null)
    {
      str = paramSosoLbsInfo.a.city;
      if (paramSosoLbsInfo.a.cityCode == null) {
        break label244;
      }
    }
    label244:
    for (paramSosoLbsInfo = paramSosoLbsInfo.a.cityCode;; paramSosoLbsInfo = "")
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("authroized", true);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ret", 0).put("latitude", d1 * d2).put("longitude", d3 * d4).put("origin_latitude", d5).put("origin_longitude", d6).put("city", str).put("cityCode", paramSosoLbsInfo).put("status", localJSONObject1);
        invokeCallJS(paramString, localJSONObject2.toString());
        return;
      }
      catch (JSONException paramSosoLbsInfo)
      {
        QLog.e(TAG, 1, "fireLocationSuccessCallbackError: " + paramSosoLbsInfo.getMessage());
        return;
      }
      str = "";
      break;
    }
  }
  
  private static HashMap<String, Object> generateMapFromInvokeJsUrl(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      HashMap localHashMap = new HashMap();
      if (TextUtils.isEmpty(paramJSONObject.optString("bgclr"))) {
        localHashMap.put(nuk.anR, paramJSONObject.optString("bgclr"));
      }
      if (TextUtils.isEmpty(paramJSONObject.optString("txtclr"))) {
        localHashMap.put(nuk.anQ, paramJSONObject.optString("txtclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("titleclr"))) {
        localHashMap.put(nuk.anS, paramJSONObject.optString("titleclr"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("alpha"))) {
        localHashMap.put(nuk.anT, paramJSONObject.optString("alpha"));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("statusBarColor"))) {
        localHashMap.put(nuk.anU, paramJSONObject.optString("statusBarColor"));
      }
      return localHashMap;
    }
    return null;
  }
  
  private void getCUKingStatus(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", aqux.Mv());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getCUKingStatus error e = ", paramString);
    }
  }
  
  private void getClientInfo(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      return;
    }
    localObject = aqgz.bd((Context)localObject);
    String str = aqgz.getQQVersion();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qqVersion", str);
      localJSONObject.put("qqBuild", localObject);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void getClipboard(String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = (ClipboardManager)((Context)localObject).getSystemService("clipboard");
        alkw.a((ClipboardManager)localObject);
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
      } while (localObject == null);
      localObject = ((ClipData)localObject).getItemAt(0).getText().toString();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", localObject);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getClipboard error" + paramString.getMessage());
  }
  
  private JSONObject getDeviceInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = aqgz.getAndroidID();
    String str2 = aqgz.getIMEI();
    try
    {
      localJSONObject.put("imsi", kxm.iU());
      localJSONObject.put("androidID", str1);
      localJSONObject.put("identifier", str2);
      localJSONObject.put("qimei", UserAction.getQIMEI());
      localJSONObject.put("qua", avpw.getQUA());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void getDownloadApkState(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("apkUrl"))))
    {
      paramJSONObject = paramJSONObject.optString("apkUrl");
      localObject = arvv.a().e(paramJSONObject);
      j = -1;
      i = 0;
      if (localObject != null)
      {
        j = ((DownloadInfo)localObject).getState();
        i = ((DownloadInfo)localObject).progress;
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("data", i);
      invokeCallJS(paramString, localObject);
      ViolaLogUtils.d(TAG, "downloadApk getDownloadApkState :" + j + " ,apkUrl : " + paramJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "getDownloadApkState error:" + paramString.getMessage());
      }
    }
  }
  
  private void getGdtInfo(String paramString)
  {
    ThreadManager.post(new BridgeModule.15(this, paramString), 8, null, true);
  }
  
  private String getNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentNickname();
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.name;
        }
      }
    }
    return str;
  }
  
  private void getPerformance(String paramString)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if (localViolaInstance == null) {
      return;
    }
    invokeCallJS(paramString, localViolaInstance.getMainPerformance());
  }
  
  private void getReadInJoyUgcPermission(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        long l = paramJSONObject.optLong("uin", 0L);
        if ((l == 0L) || (l != localQQAppInterface.getLongAccountUin()))
        {
          localJSONObject.put("hasPermission", 0);
          invokeJS(paramString, localJSONObject);
          return;
        }
        if (paramInt != 1) {
          break label138;
        }
        bool = mix.DJ();
      }
      catch (JSONException paramJSONObject)
      {
        invokeJS(paramString, localJSONObject);
        QLog.e(TAG, 1, "BridgeModule: getReadInJoyUgcPermission type =" + paramInt + paramJSONObject.toString());
        return;
      }
      localJSONObject.put("hasPermission", i);
      continue;
      label138:
      if (paramInt == 2) {
        bool = mix.DK();
      }
      while (!bool)
      {
        i = 0;
        break;
        QLog.e(TAG, 1, "BridgeModule: getReadInJoyUgcPermission app is null!");
        return;
        bool = false;
      }
      int i = 1;
    }
  }
  
  private int getRecommendFlag()
  {
    int i = 1;
    if (anwa.aze()) {
      i = 8193;
    }
    return i;
  }
  
  private void getRecommendFlag(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recommendFlag", getRecommendFlag());
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void getUploadingVideoList(@NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    mnw.a(paramQQAppInterface).a(paramLong, new nvn(this, paramLong, paramString));
  }
  
  private JSONObject getUserInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (QQAppInterface)kxm.getAppRuntime();
    String str;
    if (localObject3 != null)
    {
      localObject1 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      str = ((QQAppInterface)localObject3).getAccount();
      if (localObject1 == null) {
        break label131;
      }
    }
    label131:
    Object localObject2;
    for (Object localObject1 = ((TicketManager)localObject1).getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());; localObject2 = null)
    {
      localObject3 = getNickName((QQAppInterface)localObject3, str);
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("skey", localObject1);
        localJSONObject.put("nick", localObject3);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(TAG, 2, "getReportInfo() JSONException" + localJSONException.getMessage());
        return localJSONObject;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean hasAuthorizeLocation()
  {
    if (!VersionUtils.isM()) {}
    BaseActivity localBaseActivity;
    do
    {
      return true;
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return false;
      }
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  private boolean invokeBridgeApi(JSONObject paramJSONObject, String paramString)
  {
    return false;
  }
  
  private void isNightMode(String paramString)
  {
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i = 1;
      }
      localJSONObject.put("isNightMode", i);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void jumpUrl(Context paramContext, String paramString, Bundle paramBundle)
  {
    kxm.a(paramContext, paramString, paramBundle);
  }
  
  private void openPage(JSONObject paramJSONObject, String paramString)
  {
    paramString = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (paramJSONObject.optJSONObject("param") != null) {
      localBundle.putString("param", paramJSONObject.optJSONObject("param").toString());
    }
    ntp.b(BaseActivity.sTopActivity, "", paramString, localBundle);
  }
  
  private void openPrivateLetter()
  {
    Context localContext = getViolaInstance().getContext();
    if (localContext == null) {
      return;
    }
    Intent localIntent = new Intent(localContext, ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    localContext.startActivity(localIntent);
  }
  
  private void openUrl(JSONObject paramJSONObject, String paramString)
  {
    String str1;
    if (paramJSONObject != null)
    {
      str1 = paramJSONObject.optString("url");
      String str2 = paramJSONObject.optString("businessId", null);
      if (!TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(str2)) {
          break label78;
        }
        paramJSONObject = new Bundle();
        paramJSONObject.putString("big_brother_source_key", str2);
        paramJSONObject.putString("big_brother_ref_source_key", kxm.bg(0));
      }
    }
    for (;;)
    {
      openUrl(str1, paramJSONObject);
      invokeCallJS(paramString, null);
      return;
      label78:
      paramJSONObject = null;
    }
  }
  
  private void pageVisibility(String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    boolean bool;
    if (localObject != null)
    {
      bool = ((Fragment)localObject).getUserVisibleHint();
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("result", bool);
      invokeCallJS(paramString, localObject);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "pageVisibility error" + paramString.getMessage());
    }
  }
  
  private void popBack(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label33;
      }
      ((ViolaFragment)localFragment).doOnBackPressed();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label33:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  private void reportT(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("code");
    Object localObject3 = paramJSONObject.optJSONObject("params");
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
    {
      paramJSONObject = ((JSONObject)localObject3).optJSONObject("r2");
      localObject1 = ((JSONObject)localObject3).optJSONObject("r3");
      localObject2 = ((JSONObject)localObject3).optJSONObject("r4");
      localObject3 = ((JSONObject)localObject3).optJSONObject("r5");
      if (paramJSONObject == null) {
        break label124;
      }
      paramJSONObject = paramJSONObject.toString();
      if (localObject1 == null) {
        break label131;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      label85:
      if (localObject2 == null) {
        break label138;
      }
      localObject2 = ((JSONObject)localObject2).toString();
      label94:
      if (localObject3 == null) {
        break label145;
      }
    }
    label131:
    label138:
    label145:
    for (localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      kbp.a(null, null, str, str, 0, 0, paramJSONObject, (String)localObject1, (String)localObject2, (String)localObject3, false);
      return;
      label124:
      paramJSONObject = "";
      break;
      localObject1 = "";
      break label85;
      localObject2 = "";
      break label94;
    }
  }
  
  private void reportVideoShareClick(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    String str = "";
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("network", kvp.U(getViolaInstance().getActivity()));
        localJSONObject.put("os", "1");
        localJSONObject.put("uin", String.valueOf(kxm.getLongAccountUin()));
        localJSONObject.put("rowkey", paramString1);
        if (paramInt1 >= 0) {
          localJSONObject.put("source", String.valueOf(paramInt1));
        }
        localJSONObject.put("version", kct.XU);
        localJSONObject.put("vid", paramString2);
        if (paramBoolean) {
          localJSONObject.put("cancel", "1");
        }
        if (paramInt2 >= 0) {
          localJSONObject.put("sourcefrom", String.valueOf(paramInt2));
        }
        if (paramInt3 >= 0) {
          localJSONObject.put("share_unit", String.valueOf(paramInt3));
        }
        if (paramInt4 != 4) {
          continue;
        }
        localJSONObject.put("type", 3);
        paramString1 = localJSONObject.toString();
      }
      catch (Exception paramString2)
      {
        JSONObject localJSONObject;
        paramString1 = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "shareReport:" + paramString2.toString());
        paramString1 = str;
        continue;
        if (paramInt4 != 11) {
          continue;
        }
        kbp.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString5, "", paramString1.a().toJsonString(), false);
      }
      paramString1 = new nce.a(paramString1);
      if (paramInt4 != 4) {
        continue;
      }
      kbp.a(null, "", "0X8009546", "0X8009546", 0, 0, "", paramString4, paramString3, paramString1.a().toJsonString(), false);
      return;
      if (paramInt4 == 11) {
        localJSONObject.put("type", 4);
      }
    }
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2)
  {
    responseUploadingVideoList(paramLong, paramList, paramString1, paramInt, paramString2, false);
  }
  
  private void responseUploadingVideoList(long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new BridgeModule.37(this, paramList, paramInt, paramString2, paramBoolean, paramString1), 16, null, false);
  }
  
  private void saveImageToLocal(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?client=androidQQ");
        ((StringBuilder)localObject).append("&version=3.4.4.3058");
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
        ((StringBuilder)localObject).append("&uin=" + kxm.getAccount());
        paramString = afgc.insertMtype("VIP_xingying", ((StringBuilder)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "saveImageToLocal imageUrl=" + paramString);
        }
        localObject = System.currentTimeMillis() + ".jpg";
        ThreadManager.executeOnNetWorkThread(new BridgeModule.19(this, paramString, new File(aqul.getSDKPrivatePath(acbn.oM), (String)localObject)));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "saveImageToLocal imageUrl error=" + paramString.getMessage());
  }
  
  private void selectAndInviteFriend(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        String str = paramJSONObject.optString("rowkey", "");
        int j = paramJSONObject.optInt("maxSelect");
        int k = paramJSONObject.optInt("maxCount");
        Object localObject = paramJSONObject.optString("invitedUins", "[]");
        paramJSONObject = new StringBuilder();
        if ((localObject != null) && (((String)localObject).trim().length() > 0))
        {
          localObject = new JSONArray(((String)localObject).trim());
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramJSONObject.append(((JSONArray)localObject).get(i));
            if (i >= ((JSONArray)localObject).length() - 1) {
              break label262;
            }
            paramJSONObject.append(",");
            break label262;
          }
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("opentype", 1);
        ((Intent)localObject).putExtra("filterUins", paramJSONObject.toString());
        ((Intent)localObject).putExtra("maxSelect", j);
        if (k > 0) {
          ((Intent)localObject).putExtra("maxCount", k);
        }
        ((Intent)localObject).putExtra("rowkey", str);
        ((Intent)localObject).putExtra("callback", paramString);
        PublicFragmentActivity.startForResult(BaseActivity.sTopActivity, (Intent)localObject, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "selectAndInviteFriend e = " + paramJSONObject);
        }
        paramJSONObject.printStackTrace();
        return;
      }
      label262:
      i += 1;
    }
  }
  
  private void selectAndUploadAvatar(JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    int n = paramJSONObject.optInt("type", 1);
    int j;
    if (paramJSONObject.has("width")) {
      j = paramJSONObject.optInt("width");
    }
    for (int i = aqcx.dip2px(localBaseActivity, j / 2);; i = 640)
    {
      int m;
      if (paramJSONObject.has("height")) {
        m = paramJSONObject.optInt("height");
      }
      for (int k = aqcx.dip2px(localBaseActivity, m / 2);; k = 640)
      {
        selectPhotoFromGallery(1, n, (byte)118, i, k, j, m, paramString);
        return;
        m = 640;
      }
      j = 640;
    }
  }
  
  private void selectPhotoFromGallery(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    Activity localActivity = getViolaInstance().getActivity();
    if ((localObject != null) && (localActivity != null))
    {
      localObject = new Intent(localActivity, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("enter_from", 25);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarFragment.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("key_from_kandian_uploadimg", true);
      String str = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "readinjoy_avatar_upload/");
      ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
      ((Intent)localObject).putExtra("from", paramInt1);
      ((Intent)localObject).putExtra("type", paramInt2);
      ((Intent)localObject).putExtra("finish", true);
      ((Intent)localObject).putExtra("callbackId", paramString);
      localActivity.startActivityForResult((Intent)localObject, paramByte);
      aqfy.anim(localActivity, false, true);
    }
  }
  
  private void setClipboard(String paramString1, String paramString2)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ClipboardManager)((Context)localObject).getSystemService("clipboard");
      paramString1 = ClipData.newPlainText("article", paramString1);
      alkw.a((ClipboardManager)localObject, paramString1);
      ((ClipboardManager)localObject).setPrimaryClip(paramString1);
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", true);
        invokeCallJS(paramString2, paramString1);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "setClipboard error" + paramString1.getMessage());
  }
  
  private void setNavBar(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = generateMapFromInvokeJsUrl(paramJSONObject);
    if (paramJSONObject != null)
    {
      Fragment localFragment = getViolaInstance().getFragment();
      if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
      {
        ((ViolaFragment)localFragment).a(paramJSONObject, null);
        invokeCallJS(paramString, null);
      }
    }
  }
  
  private void setRightDragToGoBackParams(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.optBoolean("enable", true);
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ((ViolaFragment)getViolaInstance().getFragment()).L(bool);
      invokeCallJS(paramString, new JSONObject());
    }
  }
  
  private void setTitle(JSONObject paramJSONObject, String paramString)
  {
    if (getViolaInstance() == null) {}
    Fragment localFragment;
    String str1;
    do
    {
      do
      {
        return;
        localFragment = getViolaInstance().getFragment();
      } while ((localFragment == null) || (!(localFragment instanceof ViolaFragment)));
      String str2 = paramJSONObject.optString("title");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramJSONObject.optString("text");
      }
    } while (TextUtils.isEmpty(str1));
    ((ViolaFragment)localFragment).setTitle(str1);
    invokeCallJS(paramString, new JSONObject());
  }
  
  private void setTitleClickListener(String paramString)
  {
    Object localObject = getViolaInstance();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ViolaInstance)localObject).getFragment();
    } while (!(localObject instanceof ViolaFragment));
    ((ViolaFragment)localObject).o(new nvf(this, paramString));
  }
  
  private void sharePicMessage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString("imageUrl");
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        shareImageToAIO(paramJSONObject);
        localJSONObject.put("retCode", 0);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      localJSONObject.put("retCode", 1);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(TAG, 1, "sharePicMessage exception e = ", paramJSONObject);
    }
  }
  
  private void showCommentEditor(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (Object localObject2 = ((Fragment)localObject1).getActivity(); localObject2 == null; localObject2 = getViolaInstance().getActivity()) {
      return;
    }
    boolean bool1 = false;
    if (paramJSONObject.has("enableAnonymous")) {
      bool1 = paramJSONObject.optBoolean("enableAnonymous");
    }
    boolean bool2 = true;
    if (paramJSONObject.has("canBiu")) {
      bool2 = paramJSONObject.optBoolean("canBiu");
    }
    Object localObject3 = "";
    if (paramJSONObject.has("placeholder"))
    {
      localObject1 = paramJSONObject.optString("placeholder");
      QLog.d(TAG, 2, "ph5 | comment_placeholder: " + (String)localObject1);
    }
    try
    {
      localObject3 = new String(aqgo.decode((String)localObject1, 0));
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
    QLog.d(TAG, 2, "ph5 | comment_placeholder after decode: " + (String)localObject1);
    localObject3 = localObject1;
    localObject1 = "";
    if (paramJSONObject.has("defaultTxt")) {
      localObject1 = paramJSONObject.optString("defaultTxt");
    }
    try
    {
      localObject4 = new String(aqgo.decode((String)localObject1, 0));
      localObject1 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        int i;
        int j;
        int k;
        int m;
        localException2.printStackTrace();
      }
    }
    i = -1;
    if (paramJSONObject.has("maxLength")) {
      i = paramJSONObject.optInt("maxLength", -1);
    }
    j = 0;
    if (paramJSONObject.has("commentType")) {
      j = paramJSONObject.optInt("commentType", 0);
    }
    k = 0;
    if (paramJSONObject.has("sourceType")) {
      k = paramJSONObject.optInt("sourceType", 0);
    }
    localObject4 = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    m = paramJSONObject.optInt("openAt", 0);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("comment_type", false);
    paramJSONObject.putExtra("arg_comment_enable_anonymous", bool1);
    paramJSONObject.putExtra("arg_comment_placeholder", (String)localObject3);
    paramJSONObject.putExtra("arg_comment_default_txt", (String)localObject1);
    paramJSONObject.putExtra("arg_comment_max_length", i);
    paramJSONObject.putExtra("arg_comment_comment_type", j);
    paramJSONObject.putExtra("arg_comment_source_type", k);
    paramJSONObject.putExtra("arg_callback", paramString);
    paramJSONObject.putExtra("arg_comment_open_at", m);
    paramJSONObject.putExtra("comment_can_biu", bool2);
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    if (localObject4 != null) {
      paramJSONObject.putExtra("arg_comment_default_comment_at", ((JSONArray)localObject4).toString());
    }
    PublicTransFragmentActivity.startForResult((Activity)localObject2, paramJSONObject, ReadInJoyCommentComponentFragment.class, 117);
  }
  
  private void showDialog(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    aqju localaqju = new aqju(paramString, 2131756467);
    localaqju.setContentView(2131559127);
    localaqju.getMessageTextView().setMovementMethod(new ScrollingMovementMethod());
    localaqju.getMessageTextView().setMaxHeight(aqcx.dip2px(paramString, 200.0F));
    localaqju.setTitle(paramJSONObject.optString("title"));
    localaqju.setMessage(paramJSONObject.optString("text"));
    localaqju.setCanceledOnTouchOutside(false);
    if ((!paramJSONObject.optBoolean("needOkBtn", true)) || (paramJSONObject.optBoolean("needCancelBtn", true))) {}
    localaqju.show();
  }
  
  private void showMultiBiuEditPage(JSONObject paramJSONObject, String paramString)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      int m;
      int i2;
      try
      {
        Object localObject6 = paramJSONObject.optString("title");
        Object localObject3 = paramJSONObject.optString("sourceName");
        String str3 = paramJSONObject.optString("sourceUrl");
        int n;
        String str1;
        long l1;
        long l3;
        long l4;
        long l10;
        long l11;
        Object localObject5;
        if (TextUtils.isEmpty(str3))
        {
          str3 = "";
          n = paramJSONObject.optInt("hiddenBiuComponent");
          str1 = "";
          if (n == 1) {
            str1 = new String(aqgo.decode(paramJSONObject.optString("newComment"), 2));
          }
          l1 = 0L;
          l3 = 0L;
          l4 = 0L;
          l10 = 0L;
          l11 = 0L;
          localObject5 = "";
        }
        try
        {
          localObject1 = new String(aqgo.decode((String)localObject6, 0));
        }
        catch (Exception localException4)
        {
          Object localObject4;
          long l2;
          long l7;
          long l6;
          long l5;
          int j;
          String str4;
          int k;
          String str5;
          int i1;
          Object localObject7;
          Object localObject8;
          Object localObject10;
          Object localObject11;
          String str2;
          Object localObject9;
          String str6;
          String str7;
          boolean bool;
          Object localObject2 = localObject3;
          Object localObject1 = "";
          long l9 = l11;
          long l8 = l10;
          localObject3 = localObject6;
          continue;
        }
        try
        {
          localObject2 = new String(aqgo.decode((String)localObject3, 0));
        }
        catch (Exception localException1)
        {
          localObject6 = localObject1;
          localObject1 = "";
          localObject2 = localObject3;
          l9 = l11;
          l8 = l10;
          localObject3 = localObject6;
          continue;
        }
        try
        {
          localObject3 = paramJSONObject.optString("feedsId");
          localObject4 = paramJSONObject.optString("rowkey");
          localObject5 = localObject4;
          l2 = l1;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l1;
        }
        catch (Exception localException2)
        {
          localObject6 = "";
          localObject3 = localObject1;
          localObject1 = localObject6;
          l9 = l11;
          l8 = l10;
          continue;
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l3;
            l5 = l1;
            l2 = new BigInteger((String)localObject3).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l2;
          localObject4 = paramJSONObject.optString("ariticleId");
          l1 = l3;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l3;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l3;
            l5 = l2;
            l1 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l1;
          l5 = l2;
          localObject4 = paramJSONObject.optString("originFeedsId");
          l3 = l4;
          l9 = l11;
          l8 = l10;
          l7 = l4;
          l6 = l1;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l4;
            l6 = l1;
            l5 = l2;
            l3 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l10;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          localObject4 = paramJSONObject.optString("businessId");
          l4 = l10;
          l9 = l11;
          l8 = l10;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            l9 = l11;
            l8 = l10;
            l7 = l3;
            l6 = l1;
            l5 = l2;
            l4 = new BigInteger((String)localObject4).longValue();
          }
          l9 = l11;
          l8 = l4;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          l10 = paramJSONObject.optLong("accountID");
          l9 = l10;
          l8 = l4;
          l7 = l3;
          l6 = l1;
          l5 = l2;
          j = paramJSONObject.optInt("accountType");
          l8 = l4;
          localObject6 = localObject3;
          localObject4 = localObject1;
          localObject1 = localObject5;
          l5 = l2;
          l4 = l3;
          localObject3 = localObject2;
          l2 = l10;
          l3 = l1;
          localObject2 = localObject6;
          l1 = l5;
          l5 = paramJSONObject.optLong("originFeedsType", 1L);
          i = paramJSONObject.optInt("type");
          m = paramJSONObject.optInt("adtag");
          str4 = paramJSONObject.optString("picurl");
          k = paramJSONObject.optInt("duration");
          str5 = new String(aqgo.decode(paramJSONObject.optString("accountDesc"), 0));
          i1 = paramJSONObject.optInt("feedsType", 1);
          localObject6 = new ArticleInfo();
          ((ArticleInfo)localObject6).mArticleID = l3;
          ((ArticleInfo)localObject6).mTitle = ((String)localObject4);
          ((ArticleInfo)localObject6).mSubscribeName = ((String)localObject3);
          ((ArticleInfo)localObject6).mFirstPagePicUrl = str4;
          ((ArticleInfo)localObject6).mVideoDuration = k;
          ((ArticleInfo)localObject6).mFeedId = l1;
          ((ArticleInfo)localObject6).mSummary = str5;
          ((ArticleInfo)localObject6).businessId = l8;
          ((ArticleInfo)localObject6).mFeedType = i1;
          ((ArticleInfo)localObject6).innerUniqueID = ((String)localObject1);
        }
        catch (Exception localException3)
        {
          localObject6 = localObject1;
          localObject1 = localObject3;
          l4 = l7;
          l3 = l6;
          l1 = l5;
          localObject3 = localObject6;
          continue;
          paramJSONObject = str1;
          continue;
          localObject3 = str2;
          continue;
        }
        try
        {
          localObject5 = paramJSONObject.getJSONArray("biuLevelList");
          ((ArticleInfo)localObject6).mSocialFeedInfo = new SocializeFeedsInfo();
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = new SocializeFeedsInfo.c();
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.y = Long.valueOf(l4);
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.z = Long.valueOf(l5);
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT = new ArrayList();
          if (localObject5 != null)
          {
            k = 0;
            if (k < ((JSONArray)localObject5).length())
            {
              localObject7 = new SocializeFeedsInfo.BiuCommentInfo();
              localObject8 = ((JSONArray)localObject5).getJSONObject(k);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).i = Long.valueOf(((JSONObject)localObject8).optLong("uin"));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahU = new String(aqgo.decode(((JSONObject)localObject8).optString("comment"), 0));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject7).ahU;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aRW = ((JSONObject)localObject8).optInt("biuTime");
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aLh = ((JSONObject)localObject8).optInt("feeds_type", 1);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).aSO = ((JSONObject)localObject8).optInt("op_type");
              localObject10 = ((JSONObject)localObject8).optString("jumpName");
              localObject11 = ((JSONObject)localObject8).optString("jumpUrl");
              if ((!TextUtils.isEmpty((CharSequence)localObject10)) && (!TextUtils.isEmpty((CharSequence)localObject11))) {
                ((SocializeFeedsInfo.BiuCommentInfo)localObject7).a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode((String)localObject10, 0)), (String)localObject11);
              }
              if (n != 1) {}
            }
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            localObject8 = ((JSONObject)localObject8).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject8)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).x = Long.valueOf(new BigInteger((String)localObject8).longValue());
            }
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.add(localObject7);
            k += 1;
            continue;
            ((Exception)localObject4).printStackTrace();
            j = 0;
            localObject6 = localObject2;
            l2 = l9;
            localObject2 = localObject1;
            localObject4 = localObject3;
            localObject3 = localObject6;
            localObject1 = localObject5;
            continue;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
            str2 = null;
          }
          catch (Exception localException5)
          {
            localException5.printStackTrace();
            continue;
          }
          localObject7 = paramJSONObject.optJSONObject("ugcInfo");
          str2 = "";
          if (localObject7 == null) {
            continue;
          }
        }
        if (ndi.o(i1, l5))
        {
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new SocializeFeedsInfo.r();
          i2 = ((JSONObject)localObject7).optInt("ugcType", 0);
          str2 = ((JSONObject)localObject7).optString("ugcComment");
          localObject9 = ((JSONObject)localObject7).optJSONArray("ugcAtLevelList");
          if (localObject9 != null)
          {
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b = new SocializeFeedsInfo.c();
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT = new ArrayList();
            k = 0;
            if (k < ((JSONArray)localObject9).length())
            {
              localObject10 = new SocializeFeedsInfo.BiuCommentInfo();
              localObject11 = ((JSONArray)localObject9).getJSONObject(k);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).i = Long.valueOf(((JSONObject)localObject11).optLong("uin"));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).ahU = new String(aqgo.decode(((JSONObject)localObject11).optString("comment"), 0));
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).ahj = ((SocializeFeedsInfo.BiuCommentInfo)localObject10).ahU;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).aRW = ((JSONObject)localObject11).optInt("biuTime");
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).aLh = ((JSONObject)localObject11).optInt("feeds_type", 1);
              ((SocializeFeedsInfo.BiuCommentInfo)localObject10).aSO = ((JSONObject)localObject11).optInt("op_type");
              str6 = ((JSONObject)localObject11).optString("jumpName");
              str7 = ((JSONObject)localObject11).optString("jumpUrl");
              if ((!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7))) {
                ((SocializeFeedsInfo.BiuCommentInfo)localObject10).a = new SocializeFeedsInfo.JumpInfo(0L, new String(aqgo.decode(str6, 0)), str7);
              }
              try
              {
                localObject11 = ((JSONObject)localObject11).optString("feedsId");
                if (!TextUtils.isEmpty((CharSequence)localObject11)) {
                  ((SocializeFeedsInfo.BiuCommentInfo)localObject10).x = Long.valueOf(new BigInteger((String)localObject11).longValue());
                }
                ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.iT.add(localObject10);
                k += 1;
              }
              catch (Exception localException6)
              {
                localException6.printStackTrace();
                continue;
              }
            }
          }
          ((ArticleInfo)localObject6).mTitle = new String(aqgo.decode(str2, 0));
          ((ArticleInfo)localObject6).mSummary = "";
          if ((i2 != 3) && (i2 != 2)) {
            break label2434;
          }
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la = new ArrayList();
          localObject4 = new SocializeFeedsInfo.s();
          localObject7 = ((JSONObject)localObject7).optJSONArray("ugcPicInfo");
          if ((localObject7 == null) || (((JSONArray)localObject7).length() <= 0)) {
            break label2429;
          }
          ((SocializeFeedsInfo.s)localObject4).aii = ((JSONArray)localObject7).getJSONObject(0).optString("ugcPicUrl");
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.add(localObject4);
          break label2429;
          if (m == 22)
          {
            localObject4 = new SocializeFeedsInfo.a();
            ((SocializeFeedsInfo.a)localObject4).accountNick = ((String)localObject3);
            ((SocializeFeedsInfo.a)localObject4).ahS = str4;
            ((SocializeFeedsInfo.a)localObject4).ahT = str5;
            ((SocializeFeedsInfo.a)localObject4).vM = l2;
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a = ((SocializeFeedsInfo.a)localObject4);
          }
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = i2;
          ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail = ((ArticleInfo)localObject6).mTitle;
          localObject3 = str2;
          ((ArticleInfo)localObject6).mSocialFeedInfo.ahL = "";
          ((ArticleInfo)localObject6).mSocialFeedInfo.ahN = "";
          ((ArticleInfo)localObject6).mSocialFeedInfo.ahM = "";
          localObject4 = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverBiuActivity.class);
          ((Intent)localObject4).putExtra("arg_article_info", (Parcelable)localObject6);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Intent)localObject4).putExtra("biu_rowkey", (String)localObject1);
          }
          ((Intent)localObject4).putExtra("arg_from_type", m);
          ((Intent)localObject4).putExtra("arg_type", i);
          ((Intent)localObject4).putExtra("result_js_callback", paramString);
          i = 3;
          if (m != 5) {
            break label2457;
          }
          i = 4;
          ((Intent)localObject4).putExtra("biu_src", i);
          ((Intent)localObject4).putExtra("feed_id", (String)localObject2);
          ((Intent)localObject4).putExtra("feedsType", i1);
          ((Intent)localObject4).putExtra("ugc_comment", (String)localObject3);
          ((Intent)localObject4).putExtra("arg_account_id", l2);
          ((Intent)localObject4).putExtra("arg_account_type", j);
          ((Intent)localObject4).putExtra("arg_source_url", str3);
          if ((m == 23) && ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(((ArticleInfo)localObject6).mSubscribeName))))
          {
            QLog.d(TAG, 1, "web page share but core info empty !");
            return;
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb = new ArrayList();
            localObject9 = new SocializeFeedsInfo.t();
            localObject7 = ((JSONObject)localObject7).optJSONObject("ugcVideoInfo");
            if (localObject7 == null) {
              break label2449;
            }
            ((SocializeFeedsInfo.t)localObject9).pic_url = ((JSONObject)localObject7).optString("ugcVideoCoverUrl");
            ((SocializeFeedsInfo.t)localObject9).duration = ((JSONObject)localObject7).optInt("ugcVideoDuration");
            ((SocializeFeedsInfo.t)localObject9).title = ((String)localObject4);
            ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localObject9);
            break label2449;
            if (i2 != 1) {
              break label2454;
            }
            ((ArticleInfo)localObject6).mFirstPagePicUrl = "";
            break label2454;
          }
          if (n == 1)
          {
            if ((((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT == null) || (((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.iT.size() <= 0)) {
              continue;
            }
            paramJSONObject = str1 + "//";
            paramJSONObject = "：" + paramJSONObject;
            paramString = (QQAppInterface)kxm.getAppRuntime();
            if (paramString == null) {
              break;
            }
            ((lcd)paramString.getManager(163)).b().a(kxm.getLongAccountUin(), l1, ((ArticleInfo)localObject6).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c, 0L, paramJSONObject, l3, -1L, i, (String)localObject1, i1, (ArticleInfo)localObject6);
            return;
          }
          if (paramJSONObject.optInt("hideSuccessToast") == 1)
          {
            bool = true;
            ((Intent)localObject4).putExtra("hideSuccessToast", bool);
            BaseActivity.sTopActivity.startActivityForResult((Intent)localObject4, 113);
            BaseActivity.sTopActivity.overridePendingTransition(0, 0);
            return;
          }
          bool = false;
          continue;
        }
        continue;
        i = 1;
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      label2429:
      continue;
      label2434:
      if (i2 != 4) {
        if (i2 == 5)
        {
          continue;
          label2449:
          i = 2;
          continue;
          label2454:
          continue;
          label2457:
          if (m == 11) {
            i = 5;
          } else if (m == 6) {
            i = 6;
          } else if (m == 12) {
            i = 7;
          } else if (m == 13) {
            i = 8;
          } else if (m >= 15) {
            i = m;
          } else if (m == 8) {
            i = 2;
          }
        }
      }
    }
  }
  
  private void showPicture(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("imageIDs");
      int j = paramJSONObject.optInt("index");
      Object localObject2 = paramJSONObject.optString("srcID", "1");
      Object localObject1 = localObject2;
      if ("1".equals(localObject2)) {
        localObject1 = "4";
      }
      boolean bool = paramJSONObject.optBoolean("isNotShowIndex", true);
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "imageList is null or length is 0");
        }
      }
      else
      {
        paramJSONObject = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          paramJSONObject.add(localJSONArray.get(i).toString());
          i += 1;
        }
        localObject2 = getViolaInstance().getActivity();
        if (localObject2 != null)
        {
          apmj.a((Activity)localObject2, j, paramJSONObject, null, null, false, bool, (String)localObject1, 100, null, null, null, null, "", true);
          invokeCallJS(paramString, null);
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "showPicture error" + paramJSONObject.getMessage());
        invokeErrorCallJS(paramString, null);
      }
    }
  }
  
  private void showReadinjoyPicture(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = paramJSONObject.optJSONArray("imageIDs");
        int k = paramJSONObject.optInt("index");
        String str1 = paramJSONObject.optString("srcID");
        boolean bool1 = paramJSONObject.optBoolean("isNotShowIndex", true);
        boolean bool2 = paramJSONObject.optBoolean("showTitle", false);
        String str2 = new String(aqgo.decode(paramJSONObject.optString("title", ""), 0));
        String str3 = paramJSONObject.optString("articleUrl", "");
        boolean bool3 = paramJSONObject.optBoolean("isReport", false);
        long l1 = paramJSONObject.optLong("touin");
        long l2 = paramJSONObject.optLong("feeds_id");
        int m = paramJSONObject.optInt("feeds_type");
        long l3 = paramJSONObject.optLong("articleId");
        int n = paramJSONObject.optInt("source");
        int i = 0;
        if (localObject2 != null) {
          i = ((JSONArray)localObject2).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          Object localObject1 = new PublicAccountShowPictureReport();
          ((PublicAccountShowPictureReport)localObject1).parse(paramJSONObject);
          paramJSONObject = (JSONObject)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "imageList is null or length is 0");
            }
            invokeErrorCallJS(paramString, "imageList is null or length is 0");
            return;
          }
          localObject1 = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            ((ArrayList)localObject1).add(((JSONArray)localObject2).get(j).toString());
            j += 1;
            continue;
          }
          localObject2 = getViolaInstance().getActivity();
          if (localObject2 == null) {
            break;
          }
          Intent localIntent = new Intent((Context)localObject2, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", k);
          localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
          localBundle.putBoolean("needBottomBar", false);
          localBundle.putBoolean("IS_EDIT", false);
          localBundle.putBoolean("is_use_path", true);
          localBundle.putBoolean("is_show_action", true);
          localBundle.putBoolean("is_not_show_index", bool1);
          localBundle.putBoolean("is_grid_image_report", true);
          localBundle.putString("to_uin", Long.toString(l1));
          localBundle.putString("feeds_id", Long.toString(l2));
          localBundle.putString("article_id", Long.toString(l3));
          localBundle.putString("scroll_image_r5", kxm.a(i, -1, Integer.toString(n), m, "", "", null));
          localBundle.putString("read_article_r5", kxm.a(i, -1, Integer.toString(n), m, "", null));
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("src_id", str1);
          }
          if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          {
            localBundle.putBoolean("is_show_content_url", true);
            localBundle.putString("article_url", str3);
            localBundle.putString("article_title", str2);
          }
          if ((paramJSONObject != null) && (paramJSONObject.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramJSONObject.toString());
          }
          localIntent.putExtras(localBundle);
          ((Activity)localObject2).startActivityForResult(localIntent, 100);
          invokeCallJS(paramString, null);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      paramJSONObject = null;
    }
  }
  
  private void showShareMenu(JSONObject paramJSONObject, @NonNull String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject != null) {}
    for (localObject = ((Fragment)localObject).getActivity(); localObject == null; localObject = getViolaInstance().getActivity()) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)kxm.getAppRuntime();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("shareInfo");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("hide_items");
    if (paramJSONObject.optInt("show_diandian", 0) == 1) {}
    HashSet localHashSet;
    for (boolean bool = true;; bool = false)
    {
      localHashSet = new HashSet();
      if (localJSONArray == null) {
        break;
      }
      i = 0;
      while (i < localJSONArray.length())
      {
        localHashSet.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    this.mShareHelper = new odg((Activity)localObject, localAppInterface, new b(false, null, null, localJSONObject, new WeakReference(localObject), paramString));
    this.mShareHelper.a().setOnDismissListener(new nva(this));
    int i = paramJSONObject.optInt("report_from");
    this.mShareHelper.a(nwg.a(bool, localHashSet), i);
  }
  
  private void showShareReadInJoyMenu(JSONObject paramJSONObject, String paramString)
  {
    AppInterface localAppInterface = (AppInterface)kxm.getAppRuntime();
    Object localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null) {}
    for (localObject1 = ((Fragment)localObject1).getActivity(); localObject1 == null; localObject1 = getViolaInstance().getActivity()) {
      return;
    }
    Object localObject2 = paramJSONObject.optJSONArray("upline");
    Object localObject3 = paramJSONObject.optJSONArray("belowline");
    String str2 = paramJSONObject.optString("menu_title", "biu出去让更多好友看到");
    if (localObject2 == null)
    {
      localObject2 = odg.bm();
      if (localObject3 != null) {
        break label163;
      }
    }
    ArrayList localArrayList1;
    label163:
    for (localObject3 = odg.bn();; localObject3 = odg.b((JSONArray)localObject3, paramJSONObject))
    {
      localArrayList1 = new ArrayList();
      localObject4 = ((List)localObject2).iterator();
      while (((Iterator)localObject4).hasNext()) {
        localArrayList1.add(Integer.valueOf(((oaq)((Iterator)localObject4).next()).action));
      }
      localObject2 = odg.b((JSONArray)localObject2, paramJSONObject);
      break;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject4 = ((List)localObject3).iterator();
    while (((Iterator)localObject4).hasNext()) {
      localArrayList2.add(Integer.valueOf(((oaq)((Iterator)localObject4).next()).action));
    }
    String str3;
    String str1;
    if (paramJSONObject.optInt("from") == 1)
    {
      str3 = Aladdin.getConfig(273).getString("share_text_channel_list", "");
      str1 = Aladdin.getConfig(273).getString("share_text", "");
      localObject4 = str1;
    }
    try
    {
      if (!TextUtils.isEmpty(str1)) {
        localObject4 = kxk.a(String.format(str1, new Object[] { paramJSONObject.optString("share_url") }), "\\n", '\n');
      }
      paramJSONObject.put("shouldSharePlainTextChannel", str3);
      paramJSONObject.put("shareText", localObject4);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        QLog.e(TAG, 2, QLog.getStackTraceString(localException));
      }
    }
    i = paramJSONObject.optInt("report_from");
    this.mShareHelper = new odg((Activity)localObject1, localAppInterface, new b(true, (List)localObject2, (List)localObject3, paramJSONObject, new WeakReference(localObject1), paramString));
    this.mShareHelper.a(new List[] { localArrayList1, localArrayList2 }, i);
    this.mShareHelper.a().setActionSheetTitle(str2);
    localObject1 = paramJSONObject.optString("rowkey", "");
    i = paramJSONObject.optInt("source", -1);
    j = paramJSONObject.optInt("report_from", -1);
    localObject2 = paramJSONObject.optString("vid", "");
    localObject3 = paramJSONObject.optString("algorithmId", "");
    localObject4 = paramJSONObject.optString("articleId", "");
    paramJSONObject = paramJSONObject.optString("topicId", "");
    this.mShareHelper.a().setCancelListener(new nuw(this, j, (String)localObject1, (String)localObject2, i, (String)localObject3, (String)localObject4, paramJSONObject));
    this.mShareHelper.a().setOnDismissListener(new nux(this, paramString));
  }
  
  private void showTips(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getApplication();
    String str = paramJSONObject.optString("text");
    int i = paramJSONObject.optInt("iconMode", 2);
    if (!TextUtils.isEmpty(str))
    {
      switch (i)
      {
      case 4: 
      case 5: 
      default: 
        i = 2;
      }
      for (;;)
      {
        QQToast.a((Context)localObject, i, str, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299627));
        invokeCallJS(paramString, new JSONObject());
        return;
        i = 0;
        continue;
        i = 2;
        continue;
        i = 1;
        continue;
        i = 6;
      }
    }
    invokeErrorCallJS(paramString, "text为null!!");
  }
  
  private void showUGCEditPage(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = true;
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    String str1 = paramJSONObject.optString("topicId");
    Object localObject = paramJSONObject.optString("topicName");
    String str2 = paramJSONObject.optString("cookie");
    int i;
    if (paramJSONObject.optInt("isQuestion", 0) == 1) {
      i = 1;
    }
    for (;;)
    {
      int j;
      int k;
      if (paramJSONObject.optInt("isAnswer", 0) == 1)
      {
        j = 1;
        k = paramJSONObject.optInt("adtag");
      }
      try
      {
        paramJSONObject = new String(aqgo.decode((String)localObject, 0));
        localObject = new Intent(BaseActivity.sTopActivity, ReadInJoyDeliverUGCActivity.class);
        ((Intent)localObject).putExtra("arg_topic_id", str1);
        if ((i != 0) || (j != 0))
        {
          i = 1;
          if (i != 0) {
            break label243;
          }
          bool1 = true;
          ((Intent)localObject).putExtra("support_topic", bool1);
          if (i != 0) {
            break label249;
          }
          bool1 = bool2;
          ((Intent)localObject).putExtra("support_linkify", bool1);
          ((Intent)localObject).putExtra("arg_topic_name", paramJSONObject);
          ((Intent)localObject).putExtra("arg_ad_tag", k);
          ((Intent)localObject).putExtra("arg_callback", paramString);
          ((Intent)localObject).putExtra("arg_ugc_edit_cookie", str2);
          BaseActivity.sTopActivity.startActivityForResult((Intent)localObject, 114);
          return;
          i = 0;
          continue;
          j = 0;
        }
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = (JSONObject)localObject;
          continue;
          i = 0;
          continue;
          label243:
          boolean bool1 = false;
          continue;
          label249:
          bool1 = false;
        }
      }
    }
  }
  
  private void showUGCVideoRecordPage(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = (AppInterface)kxm.getAppRuntime();
    localObject1 = getViolaInstance().getFragment();
    if (localObject1 != null)
    {
      localObject1 = ((Fragment)localObject1).getActivity();
      if (localObject1 != null) {
        break label47;
      }
    }
    for (;;)
    {
      return;
      localObject1 = getViolaInstance().getActivity();
      break;
      label47:
      String str1 = paramJSONObject.optString("topicId");
      int i = paramJSONObject.optInt("adtag");
      paramJSONObject.optInt("mode");
      paramJSONObject.optString("vid");
      paramJSONObject.optString("videourl");
      paramJSONObject.optString("coverurl");
      paramJSONObject.optString("md5");
      Object localObject2 = paramJSONObject.optString("topicName");
      String str2 = paramJSONObject.optString("cookie");
      try
      {
        paramJSONObject = new String(aqgo.decode((String)localObject2, 0));
        if (kxm.nT() >= 2) {
          continue;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("arg_topic_id", str1);
        ((Bundle)localObject2).putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
        ((Bundle)localObject2).putString("arg_topic_id", str1);
        ((Bundle)localObject2).putString("arg_topic_name", paramJSONObject);
        ((Bundle)localObject2).putInt("arg_ad_tag", i);
        ((Bundle)localObject2).putString("arg_callback", paramString);
        ((Bundle)localObject2).putString("arg_ugc_edit_cookie", str2);
        kqi.a((Activity)localObject1, (Bundle)localObject2, (byte)116);
        kxm.bA("2", "2");
        return;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = (JSONObject)localObject2;
        }
      }
    }
  }
  
  private void suspensionPopBack(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if (localFragment != null)
    {
      if (!(localFragment instanceof ViolaFragment)) {
        break label81;
      }
      if (((ViolaFragment)localFragment).a() == null) {
        break label71;
      }
      if (!((ViolaFragment)localFragment).a().Gc()) {
        break label56;
      }
      localFragment.getActivity().doOnBackPressed();
    }
    for (;;)
    {
      invokeCallJS(paramString, null);
      return;
      label56:
      ((ViolaFragment)localFragment).a().dr(0, 3);
      continue;
      label71:
      localFragment.getActivity().doOnBackPressed();
      continue;
      label81:
      localFragment.getActivity().doOnBackPressed();
    }
  }
  
  public static void unRegisterReceiver()
  {
    if ((BaseApplicationImpl.getContext() != null) && (mGdtAppReceiver != null))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(mGdtAppReceiver);
      mGdtAppReceiver = null;
    }
  }
  
  private void updateIfNeed(JSONObject paramJSONObject, String paramString)
  {
    ntp.a(String.valueOf(paramJSONObject.optInt("bid", 3256)), new nvd(this, paramString));
  }
  
  private void uploadTopicPic(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {}
    int n;
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      localObject = ((Context)localObject).getResources().getDisplayMetrics();
      n = paramJSONObject.optInt("type");
      i = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
      j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 200.0D);
      k = 750;
      m = 416;
      if (n == 1)
      {
        j = Utils.rp2px(((DisplayMetrics)localObject).widthPixels, 360.0D);
        m = 160;
        k = 160;
        i = j;
      }
    } while ((n != 1) && (n != 2));
    selectPhotoFromGallery(2, 0, (byte)121, i, j, k, m, paramString);
  }
  
  @JSMethod
  public void addFavorite(JSONObject paramJSONObject)
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    Bundle localBundle;
    if (localObject != null)
    {
      str1 = paramJSONObject.optString("rowkey", "");
      str2 = paramJSONObject.optString("article_title", "");
      str3 = paramJSONObject.optString("article_title", "");
      str4 = paramJSONObject.optString("first_page_url", "");
      i = paramJSONObject.optInt("duration", 0);
      str5 = paramJSONObject.optString("article_url", "") + "&sourcefrom=6";
      int j = paramJSONObject.optInt("publishAccountUin", 0);
      String str6 = paramJSONObject.optString("publishAccountName", "");
      localObject = ((QQAppInterface)localObject).getAccount();
      localBundle = new Bundle();
      localBundle.putInt("videoDuration", i);
      localBundle.putLong("publishAccountUin", j);
      localBundle.putString("publishAccountName", str6);
      if (paramJSONObject.optInt("busiType", 6) != 6) {
        break label220;
      }
    }
    label220:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("videoType", i);
      lgv.a().a(getViolaInstance().getActivity(), (String)localObject, 2, str1, str2, str3, str4, str5, localBundle);
      return;
    }
  }
  
  @JSMethod
  public void c2sReport(JSONObject paramJSONObject)
  {
    try
    {
      tkw.d(TAG, paramJSONObject.toString());
      tlb.a(paramJSONObject.optInt("operationType"), paramJSONObject.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      tkw.e(TAG, "handleJsCallRequest", paramJSONObject);
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    if ("onCommentSend".equals(localObject1)) {}
    do
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        paramBundle.put("firstLevelComment", i + 1 + "");
        paramBundle.put("result", "success");
        paramBundle.put("type", "onCommentSend");
        invokeCallJS(this.commentCallbaclId, paramBundle);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("onCommentLike".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          localObject2 = paramBundle.getString("rowKey", "");
          paramBundle = paramBundle.getString("likeStatus", "");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("commentId", localObject1);
          ((JSONObject)localObject3).put("rowKey", localObject2);
          ((JSONObject)localObject3).put("likeStatus", paramBundle);
          ((JSONObject)localObject3).put("result", "success");
          ((JSONObject)localObject3).put("type", "onCommentLike");
          invokeCallJS(this.commentCallbaclId, localObject3);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
      if ("onCommentDelete".equals(localObject1)) {
        try
        {
          localObject1 = paramBundle.getString("commentId", "");
          paramBundle = paramBundle.getString("rowKey", "");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("commentId", localObject1);
          ((JSONObject)localObject2).put("rowKey", paramBundle);
          ((JSONObject)localObject2).put("result", "success");
          ((JSONObject)localObject2).put("type", "onCommentDelete");
          invokeJS(this.commentCallbaclId, (JSONObject)localObject2);
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    } while (!"onPanelClose".equals(localObject1));
    try
    {
      paramBundle = paramBundle.getString("rowKey", "");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("rowKey", paramBundle);
      ((JSONObject)localObject1).put("result", "success");
      ((JSONObject)localObject1).put("type", "onPanelClose");
      invokeJS(this.commentCallbaclId, (JSONObject)localObject1);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  @JSMethod
  public void cancelUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "cancelUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = kxm.a();
    if (paramJSONObject != null) {
      mnw.a(paramJSONObject).a(j, new nvp(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  @JSMethod
  public void cancelVideoPreDownload()
  {
    if (this.mVideoPreDownloadMgr != null) {
      this.mVideoPreDownloadMgr.aTZ();
    }
  }
  
  @JSMethod
  public void channelRequestSign(String paramString1, String paramString2)
  {
    paramString1 = arwu.toMD5("QQ_" + kxm.getAccount() + "_" + paramString1).toLowerCase();
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
    }
  }
  
  @JSMethod
  public void chooseVideoAddToTopic(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    QLog.i(TAG, 1, "chooseVideoAddToTopic, callback = " + paramString + ", jsonObject = " + paramJSONObject.toString());
    JSONArray localJSONArray = paramJSONObject.optJSONArray("videoList");
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          } else {
            QLog.i(TAG, 1, "chooseVideoAddToTopic index = " + i + "rowkey is empty.");
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        invokeJS(paramString, localJSONObject);
        QLog.e(TAG, 1, "chooseVideoAddToTopic error! e = " + paramJSONObject.toString());
        return;
      }
      i = paramJSONObject.optInt("topicId", 0);
      if ((!localArrayList.isEmpty()) && (i != 0))
      {
        mmr.a(localArrayList, i, new nvm(this, localJSONObject, paramString));
        return;
      }
      localJSONObject.put("errCode", -1);
      localJSONObject.put("errMsg", "rowkeys.isEmpty() || columnId == 0");
      invokeJS(paramString, localJSONObject);
      return;
      i += 1;
    }
  }
  
  public void destroy()
  {
    if (this.mShareHelper != null)
    {
      this.mShareHelper.onDestroy();
      this.mShareHelper = null;
    }
    if (this.mEventHelper != null)
    {
      this.mEventHelper.onDestroy();
      this.mEventHelper = null;
    }
    if (this.mClient != null) {
      this.mClient.bzk();
    }
    if (this.mShareUtils != null) {
      this.mShareUtils.destroy();
    }
    this.mCommentManager = null;
    if (this.netInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.netInfoHandler);
    }
    if (this.mVideoPreDownloadMgr != null)
    {
      this.mVideoPreDownloadMgr.aTZ();
      this.mVideoPreDownloadMgr = null;
    }
    if (this.violaVideoUpdateController != null) {
      this.violaVideoUpdateController.stop();
    }
    QQAppInterface localQQAppInterface = kxm.a();
    if (localQQAppInterface != null) {
      mnw.a(localQQAppInterface).b(this.videoPublishCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy by instance");
    }
    if (this.dataManager != null) {
      this.dataManager.clear();
    }
  }
  
  @JSMethod
  public void dwellTimeMillisReport(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("dwellTimeMillis");
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
      tla.a locala = new tla.a();
      locala.ad = new GdtAd(paramJSONObject);
      locala.a.landing_page_action_type.set(42);
      locala.a.latency_ms.set(i);
      tla.a(locala);
      return;
    }
    catch (Exception paramJSONObject)
    {
      tkw.e(TAG, "handleJsCallRequest", paramJSONObject);
    }
  }
  
  @JSMethod(uiThread=false)
  public void getALDConfig(JSONObject paramJSONObject, String paramString)
  {
    if ((!TextUtils.isEmpty(paramJSONObject.optString("key", ""))) && (paramJSONObject.has("id")) && (!TextUtils.isEmpty(paramString))) {
      paramJSONObject = Aladdin.getConfig(paramJSONObject.optInt("id")).getString(paramJSONObject.optString("key", ""), "");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramJSONObject);
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void getBiuTriggerType(JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (kpn.nx() == 1)
        {
          paramJSONObject = "fastBiu";
          String str;
          if (kpn.ny() == 1)
          {
            str = "fastBiu";
            localJSONObject.put("retCode", 0);
            localJSONObject.put("click", paramJSONObject);
            localJSONObject.put("longClick", str);
            if (!TextUtils.isEmpty(paramString)) {
              invokeCallJS(paramString, localJSONObject);
            }
          }
          else
          {
            str = "normalBiu";
            continue;
          }
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e(TAG, 1, "[getBiuTriggerType] ", paramJSONObject);
      }
      paramJSONObject = "normalBiu";
    }
  }
  
  @JSMethod
  public void getCreateTopicPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 1);
  }
  
  @JSMethod(uiThread=false)
  public void getDeviceInfo(String paramString)
  {
    getDeviceInfo(paramString, false);
  }
  
  public void getDeviceInfo(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = getDeviceInfo();
    if (paramBoolean)
    {
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  public JSONObject getFailInvokeObj(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorText", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString) {}
    return localJSONObject;
  }
  
  @Nullable
  public Object getField(String paramString)
  {
    return this.mObjectMap.get(paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject)
  {
    getGdtDeviceInfo(paramString, paramJSONObject, true);
  }
  
  public void getGdtDeviceInfo(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AdThreadManager.INSTANCE.post(new BridgeModule.6(this, paramJSONObject, paramBoolean, paramString), 4);
  }
  
  @JSMethod
  public void getMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    paramString = new nwb(this, paramString);
    if (localBaseActivity == null)
    {
      paramString.a(null, new tgk(5));
      return;
    }
    String str = paramJSONObject.optString("posId", "1041305064862972");
    long l1 = paramJSONObject.optLong("publicId", 0L);
    long l2 = paramJSONObject.optLong("articleId", 0L);
    int i = paramJSONObject.optInt("sourceFrom", 0);
    int j = paramJSONObject.optInt("shareRate", 0);
    knf.a().a(localBaseActivity, str, l1, l2, i, j, paramString);
  }
  
  @JSMethod(uiThread=false)
  public void getNetType(String paramString)
  {
    getNetType(paramString, false);
  }
  
  public void getNetType(String paramString, boolean paramBoolean)
  {
    int i = jqc.getNetWorkType();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNetType,netType:" + i);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", i);
      label56:
      if (paramBoolean) {
        invokeCallJS(paramString, localJSONObject);
      }
      for (;;)
      {
        vaNetworkChange(paramString);
        return;
        ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
      }
    }
    catch (JSONException localJSONException)
    {
      break label56;
    }
  }
  
  public JSONObject getNetworkInfo()
  {
    int k = jqc.getNetWorkType();
    String str = jqc.hS();
    int j = 0;
    Object localObject = aqgz.getIMSI();
    int i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = j;
      if (((String)localObject).length() > 5)
      {
        i = j;
        if (((String)localObject).startsWith("460"))
        {
          localObject = ((String)localObject).substring(3, 5);
          if ((!((String)localObject).equals("00")) && (!((String)localObject).equals("02")) && (!((String)localObject).equals("04")) && (!((String)localObject).equals("07"))) {
            break label147;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", k);
        ((JSONObject)localObject).put("radio", str);
        ((JSONObject)localObject).put("carriertype", i);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        label147:
        localJSONException.printStackTrace();
      }
      if ((((String)localObject).equals("01")) || (((String)localObject).equals("06")) || (((String)localObject).equals("09")))
      {
        i = 2;
      }
      else if ((((String)localObject).equals("03")) || (((String)localObject).equals("05")))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("20")) {
          i = 4;
        }
      }
    }
    return localObject;
  }
  
  public void getNetworkInfo(String paramString, boolean paramBoolean)
  {
    invokeCallJS(paramString, getNetworkInfo());
  }
  
  public JSONObject getSuccInvokeObj(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      localJSONObject.put("errorText", "");
      if (paramObject != null)
      {
        localJSONObject.put("data", paramObject);
        return localJSONObject;
      }
      localJSONObject.put("data", new JSONObject());
      return localJSONObject;
    }
    catch (JSONException paramObject) {}
    return localJSONObject;
  }
  
  @JSMethod
  public void getUploadVideoPermission(JSONObject paramJSONObject, String paramString)
  {
    getReadInJoyUgcPermission(paramJSONObject, paramString, 2);
  }
  
  @JSMethod
  public void getUploadingVideoInfo(JSONObject paramJSONObject, String paramString)
  {
    QLog.i(TAG, 1, "getUploadingVideoInfo,callback=" + paramString + ", content=" + paramJSONObject.toString());
    int i = paramJSONObject.optInt("topicId", 0);
    this.columnToUploadCallbackMap.put(Long.valueOf(i), paramString);
    paramJSONObject = kxm.a();
    if (paramJSONObject != null) {
      mnw.a(paramJSONObject).a(this.videoPublishCallback);
    }
    if (this.violaVideoUpdateController == null) {
      this.violaVideoUpdateController = new moi(new BridgeModule.32(this, i, paramString), 500L);
    }
    this.violaVideoUpdateController.start();
  }
  
  @JSMethod(uiThread=false)
  public void getUserInfo(String paramString)
  {
    getUserInfo(paramString, false);
  }
  
  public void getUserInfo(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localJSONObject = getUserInfo();
      if (paramBoolean) {
        invokeCallJS(paramString, localJSONObject);
      }
    }
    else
    {
      return;
    }
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
  }
  
  @JSMethod
  public void handleClick(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    try
    {
      tkw.i(TAG, paramJSONObject.toString());
      JSONObject localJSONObject = paramJSONObject.getJSONObject("options");
      boolean bool1 = localJSONObject.getBoolean("reportForClick");
      boolean bool2 = localJSONObject.getBoolean("appAutoDownload");
      boolean bool3 = localJSONObject.optBoolean("videoCeilingSupported", false);
      boolean bool4 = localJSONObject.optBoolean("videoCeilingSupportedIfInstalled", false);
      boolean bool5 = localJSONObject.optBoolean("videoSpliceSupported", false);
      int i = localJSONObject.optInt("clickPosition", 0);
      long l = localJSONObject.optLong("videoStartPositionMillis", 0L);
      Object localObject = localJSONObject.optJSONObject("mediaViewLocationRect");
      Rect localRect = new Rect();
      if (localObject != null)
      {
        int j = ((JSONObject)localObject).optInt("left", 0);
        int k = ((JSONObject)localObject).optInt("top", 0);
        int m = ((JSONObject)localObject).optInt("right", 0);
        int n = ((JSONObject)localObject).optInt("bottom", 0);
        localRect.left = j;
        localRect.top = k;
        localRect.right = m;
        localRect.bottom = n;
      }
      paramJSONObject = (qq_ad_get.QQAdGetRsp.AdInfo)tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramJSONObject.getJSONObject("adInfo"));
      localObject = new GdtHandler.Params();
      ((GdtHandler.Params)localObject).processId = 7;
      ((GdtHandler.Params)localObject).activity = new WeakReference(localBaseActivity);
      ((GdtHandler.Params)localObject).ad = new GdtAd(paramJSONObject);
      ((GdtHandler.Params)localObject).reportForClick = bool1;
      ((GdtHandler.Params)localObject).aOV = bool2;
      if (mGdtAppReceiver == null)
      {
        mGdtAppReceiver = new GdtAppReceiver();
        mGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      ((GdtHandler.Params)localObject).appReceiver = new WeakReference(mGdtAppReceiver);
      ((GdtHandler.Params)localObject).n = ReadInJoyVideoCeilingFragment.class;
      ((GdtHandler.Params)localObject).videoCeilingSupportedIfNotInstalled = bool3;
      ((GdtHandler.Params)localObject).videoCeilingSupportedIfInstalled = bool4;
      ((GdtHandler.Params)localObject).videoSpliceSupported = bool5;
      ((GdtHandler.Params)localObject).mediaViewLocationRect = localRect;
      ((GdtHandler.Params)localObject).p = ReadInJoyForCanvasFragment.class;
      ((GdtHandler.Params)localObject).componentID = i;
      ((GdtHandler.Params)localObject).extra = new Bundle();
      ((GdtHandler.Params)localObject).extra.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      bool1 = localJSONObject.optBoolean("videoPlayForced", false);
      ((GdtHandler.Params)localObject).videoStartPositionMillis = l;
      ((GdtHandler.Params)localObject).directPlay = bool1;
      GdtHandler.a((GdtHandler.Params)localObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      tkw.e(TAG, "handleJsCallRequest error", paramJSONObject);
    }
  }
  
  @JSMethod
  public void hasApp(String paramString1, String paramString2)
  {
    hasApp(paramString1, paramString2, false);
  }
  
  public void hasApp(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    boolean bool;
    if (("weishi://feed".equals(paramString1)) || ("weishi".equals(paramString1))) {
      bool = rpw.isWeishiInstalled(localBaseActivity);
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        if (!bool) {
          break label124;
        }
        paramString1.put("result", i);
        if (!paramBoolean) {
          break label130;
        }
        invokeCallJS(paramString2, paramString1);
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 2, "hasApp error" + paramString1.getMessage());
      return;
      bool = aqiz.isAppInstalled(localBaseActivity, paramString1);
      continue;
      label124:
      i = 0;
    }
    label130:
    ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString2, paramString1, true);
  }
  
  public void hasRedPacketPermission(String paramString)
  {
    try
    {
      if (RIJRedPacketManager.a().Dr())
      {
        RIJRedPacketManager.a().a(2, new nvl(this, paramString));
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "isInkanDianTab exception e = ", paramString);
    }
  }
  
  public void hasRedPacketSharePermission(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!awit.aML()) {
          continue;
        }
        i = 1;
        localJSONObject.put("result", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      invokeCallJS(paramString, localJSONObject);
      return;
      i = 0;
    }
  }
  
  @JSMethod
  public void hideTopicVideoComment(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    if (getViolaInstance() != null)
    {
      paramJSONObject = localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent(paramJSONObject);
      if ((paramJSONObject != null) && (paramJSONObject.getHostView() != null))
      {
        paramJSONObject.getHostView();
        this.mCommentManager.ql(false);
      }
    }
  }
  
  @JSMethod
  public void invoke(JSONObject paramJSONObject, String paramString)
  {
    Object localObject3 = paramJSONObject.optString("ns");
    Object localObject4 = paramJSONObject.optString("method");
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
      QLog.d(TAG, 1, "ns or method not exists");
    }
    label163:
    label3491:
    for (;;)
    {
      return;
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("ns: ").append((String)localObject3).append(" method: ").append((String)localObject4).append(" params: ");
      Object localObject1;
      int i;
      if (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.toString();
        QLog.d(str, 1, (String)localObject1);
        if (!"readinjoy".equals(localObject3)) {
          break label961;
        }
        if (!"openPrivateLetter".equals(localObject4)) {
          break label163;
        }
        openPrivateLetter();
        i = 0;
      }
      for (;;)
      {
        if ((i == 0) || (invokeBridgeApi(paramJSONObject, paramString))) {
          break label3491;
        }
        return;
        localObject1 = " null ";
        break;
        if ("openVideo".equals(localObject4))
        {
          openVideo(paramJSONObject.optJSONObject("params"));
          i = 0;
        }
        else
        {
          if ("QReport".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              reportT(paramJSONObject.optJSONObject("params"));
              i = 0;
            }
          }
          else if ("showUGCEditPage".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showUGCEditPage(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showMultiBiuEditPage".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showMultiBiuEditPage(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("selectAndInviteFriend".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              selectAndInviteFriend(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("selectAndUploadAvatar".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              this.mUploadCallBack = paramString;
              selectAndUploadAvatar(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("uploadTopicPic".endsWith((String)localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              this.mUploadCallBack = paramString;
              uploadTopicPic(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showPicture".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showReadinjoyPicture(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("openAccountPageMore".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              openAccountPageMore(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("socialize_feeds_update".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              socailFeedsUpdate(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("updateAccountCardFollowInfo".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              updateAccountCardFollowInfo(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("updateTopicCardFollowInfo".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              updateTopicCardFollowInfo(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else if ("showVisibleUserList".equals(localObject4))
          {
            if (paramJSONObject.optJSONObject("params") != null)
            {
              showVisibleUserList(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
            }
          }
          else
          {
            if ("getBiuTriggerType".equals(localObject4))
            {
              getBiuTriggerType(paramJSONObject.optJSONObject("params"), paramString);
              i = 0;
              continue;
            }
            if ("showShareReadInJoyMenu".equals(localObject4))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showShareReadInJoyMenu(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("showUGCVideoRecordPage".equals(localObject4))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showUGCVideoRecordPage(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("showCommentEditor".equals(localObject4))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                showCommentEditor(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
              }
            }
            else if ("feeds_refresh_message".equals(localObject4))
            {
              if (paramJSONObject.optJSONObject("params") != null)
              {
                feedsRefreshMessage(paramJSONObject.optJSONObject("params"));
                i = 0;
              }
            }
            else
            {
              if ("isInKanDianTab".equals(localObject4))
              {
                isInkanDianTab(paramString);
                i = 0;
                continue;
              }
              if ("hasRedPacketPermission".equals(localObject4))
              {
                hasRedPacketPermission(paramString);
                i = 0;
                continue;
              }
              if ("hasRedPacketSharePermission".equals(localObject4))
              {
                hasRedPacketSharePermission(paramString);
                i = 0;
                continue;
              }
              if ("updateRedPacketShareTime".equals(localObject4))
              {
                updateRedPacketShareTime();
                i = 0;
                continue;
              }
              if ("requestRedPacketContentShareToast".equals(localObject4))
              {
                requestRedPacketContentShareToast(paramString);
                i = 0;
                continue;
              }
              if ("requestBubbleTipsWording".equals(localObject4))
              {
                requestBubbleTipsWording(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
                continue;
              }
              if ("onClickBubbleTips".equals(localObject4))
              {
                onClickBubbleTips(paramJSONObject.optJSONObject("params"), paramString);
                i = 0;
                continue;
              }
              i = 1;
              continue;
              label961:
              if ("data".equals(localObject3))
              {
                if ("ssoRequest".equals(localObject4))
                {
                  sendRequest(paramJSONObject.optJSONObject("params"), paramString);
                  i = 0;
                  continue;
                }
                if ("getUserInfo".equals(localObject4))
                {
                  getUserInfo(paramString, true);
                  i = 0;
                  continue;
                }
                if ("setClipboard".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    setClipboard(paramJSONObject.optJSONObject("params").optString("text"), paramString);
                    i = 0;
                  }
                }
                else
                {
                  if ("getClipboard".equals(localObject4))
                  {
                    getClipboard(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getPerformance".equals(localObject4))
                  {
                    getPerformance(paramString);
                    i = 0;
                    continue;
                  }
                  i = 1;
                }
              }
              else if ("ui".equals(localObject3))
              {
                if ("showTips".equals(localObject4))
                {
                  showTips(paramJSONObject.optJSONObject("params"), paramString);
                  i = 0;
                  continue;
                }
                if ("openPage".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    openPage(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else
                {
                  if ("openUrl".equals(localObject4))
                  {
                    openUrl(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("setTitle".equals(localObject4))
                  {
                    setTitle(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("pageVisibility".equals(localObject4))
                  {
                    pageVisibility(paramString);
                    i = 0;
                    continue;
                  }
                  if ("popBack".equals(localObject4))
                  {
                    popBack(paramString);
                    i = 0;
                    continue;
                  }
                  if ("suspensionPopBack".equals(localObject4))
                  {
                    suspensionPopBack(paramString);
                    i = 0;
                    continue;
                  }
                  if ("setNavBtn".equals(localObject4))
                  {
                    setNavBtn(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("showDialog".equals(localObject4))
                  {
                    showDialog(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("showShareMenu".equals(localObject4))
                  {
                    showShareMenu(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                    continue;
                  }
                  if ("canOpenPage".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      canOpenPage(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("setNavBar".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      setNavBar(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("setRightDragToGoBackParams".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      setRightDragToGoBackParams(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else
                  {
                    if ("showActionSheet".equals(localObject4))
                    {
                      if (this.mActionSheetHelper == null) {
                        this.mActionSheetHelper = new nuq(this);
                      }
                      this.mActionSheetHelper.e(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("violaTitleBarClick".equals(localObject4))
                    {
                      setTitleClickListener(paramString);
                      i = 0;
                      continue;
                    }
                    if ("openPluginView".equals(localObject4))
                    {
                      if (paramJSONObject.optJSONObject("params") != null)
                      {
                        localObject1 = paramJSONObject.optJSONObject("params").optString("url");
                        localObject3 = BaseActivity.sTopActivity;
                        if ((localObject3 != null) && (localObject1 != null) && (!((String)localObject1).isEmpty())) {
                          LiveRoomProxyActivity.open((Activity)localObject3, (String)localObject1, "Readinjoy feeds");
                        }
                        i = 0;
                      }
                    }
                    else
                    {
                      if ("arouseReadInJoyNativeCommentView".equals(localObject4))
                      {
                        localObject3 = paramJSONObject.optJSONObject("params");
                        if (localObject3 != null)
                        {
                          if (((JSONObject)localObject3).optBoolean("isAlbum", true)) {
                            arouseReadInJoyNativeCommentView((JSONObject)localObject3, paramString);
                          }
                        }
                        else
                        {
                          i = 0;
                          continue;
                        }
                        if (TextUtils.isEmpty(((JSONObject)localObject3).optString("callback"))) {}
                        for (localObject1 = paramString;; localObject1 = ((JSONObject)localObject3).optString("callback"))
                        {
                          obw.a((JSONObject)localObject3, (String)localObject1, new nwc(this));
                          break;
                        }
                      }
                      if ("sharePicMessage".equals(localObject4))
                      {
                        if (paramJSONObject.optJSONObject("params") != null)
                        {
                          sharePicMessage(paramJSONObject.optJSONObject("params"), paramString);
                          i = 0;
                        }
                      }
                      else
                      {
                        if ("isNightMode".equals(localObject4))
                        {
                          isNightMode(paramString);
                          i = 0;
                          continue;
                        }
                        if ("biuCommentAladdinConfig".equals(localObject4))
                        {
                          UiApiPlugin.a(true, paramString, new nwd(this));
                          i = 0;
                          continue;
                        }
                        if ("showCommentEditor".equals(localObject4))
                        {
                          if (paramJSONObject.optJSONObject("params") != null)
                          {
                            UiApiPlugin.a(paramJSONObject.optJSONObject("params"), paramString, getViolaInstance().getActivity());
                            i = 0;
                          }
                        }
                        else {
                          i = 1;
                        }
                      }
                    }
                  }
                }
              }
              else if ("app".equals(localObject3))
              {
                if ("downloadApp".equals(localObject4))
                {
                  if (paramJSONObject.optString("params") != null)
                  {
                    downloadApp(paramJSONObject.optString("params"));
                    i = 0;
                  }
                }
                else if ("isAppInstalled".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    hasApp(paramJSONObject.optJSONObject("params").optString("identifier"), paramString, true);
                    i = 0;
                  }
                }
                else if ("launchApp".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    openApp(paramJSONObject.optJSONObject("params").optString("schema"), paramString, paramJSONObject.optJSONObject("params").optString("sourceId"));
                    i = 0;
                  }
                }
                else if ("getDownloadApkState".equals(localObject4))
                {
                  if ((paramJSONObject.optJSONObject("params") != null) && (!TextUtils.isEmpty(paramString)))
                  {
                    getDownloadApkState(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else if ("downloadApk".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApk(paramJSONObject.optJSONObject("params"), paramString);
                    i = 0;
                  }
                }
                else if ("downloadApkAction".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkAction(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkPause".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkPause(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkCancel".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkCancel(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else if ("downloadApkResume".equals(localObject4))
                {
                  if (paramJSONObject.optJSONObject("params") != null)
                  {
                    downloadApkResume(paramJSONObject.optJSONObject("params"));
                    i = 0;
                  }
                }
                else {
                  i = 1;
                }
              }
              else
              {
                if ("device".equals(localObject3))
                {
                  if ("getDeviceInfo".equals(localObject4))
                  {
                    getDeviceInfo(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getNetworkInfo".equals(localObject4))
                  {
                    getNetworkInfo(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getNetType".equals(localObject4))
                  {
                    getNetType(paramString, true);
                    i = 0;
                    continue;
                  }
                  if ("getClientInfo".equals(localObject4))
                  {
                    getClientInfo(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getCUKingStatus".equals(localObject4))
                  {
                    getCUKingStatus(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getGdtInfo".equals(localObject4))
                  {
                    getGdtInfo(paramString);
                    i = 0;
                    continue;
                  }
                  if ("getRecommendFlag".equals(localObject4))
                  {
                    getRecommendFlag(paramString);
                    i = 0;
                    continue;
                  }
                  i = 1;
                  continue;
                }
                if ("debug".equals(localObject3))
                {
                  if ("detailLog".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      detailLog(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else if ("media".equals(localObject3))
                {
                  if ("showPicture".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      showPicture(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("saveImage".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      saveImage(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else if ("offline".equals(localObject3))
                {
                  if ("updateIfNeed".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      updateIfNeed(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else if ("batchCheckUpdate".equals(localObject4))
                  {
                    if (paramJSONObject.optJSONObject("params") != null)
                    {
                      batchCheckUpdate(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                    }
                  }
                  else {
                    i = 1;
                  }
                }
                else
                {
                  if ("event".equals(localObject3))
                  {
                    if ("addEventListener".equals(localObject4))
                    {
                      ensureEventHelper();
                      this.mEventHelper.g(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("removeEventListener".equals(localObject4))
                    {
                      ensureEventHelper();
                      this.mEventHelper.h(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    if ("dispatchEvent".equals(localObject4))
                    {
                      ensureEventHelper();
                      this.mEventHelper.i(paramJSONObject.optJSONObject("params"), paramString);
                      i = 0;
                      continue;
                    }
                    i = 1;
                    continue;
                  }
                  if ("schema".equals(localObject3))
                  {
                    if ("jumpAction".equals(localObject4))
                    {
                      localObject1 = paramJSONObject.optJSONObject("params");
                      if (localObject1 == null)
                      {
                        invokeErrorCallJS(paramString, "params is null");
                        return;
                      }
                      if (!((JSONObject)localObject1).has("schema"))
                      {
                        invokeErrorCallJS(paramString, "schema is null");
                        return;
                      }
                      localObject3 = getViolaInstance().getActivity();
                      localObject4 = (QQAppInterface)kxm.getAppRuntime();
                      if ((localObject3 != null) && (localObject4 != null)) {}
                      for (;;)
                      {
                        try
                        {
                          localObject1 = aqik.c((QQAppInterface)localObject4, (Context)localObject3, ((JSONObject)localObject1).getString("schema"));
                          if (localObject1 != null)
                          {
                            ((aqhv)localObject1).setFrom("viola");
                            ((aqhv)localObject1).ace();
                            invokeCallJS(paramString, null);
                          }
                        }
                        catch (JSONException localJSONException)
                        {
                          localJSONException.printStackTrace();
                          continue;
                        }
                        i = 0;
                        break;
                        invokeErrorCallJS(paramString, "activity or app is null");
                      }
                    }
                    i = 1;
                    continue;
                  }
                  if ("gdt".equals(localObject3))
                  {
                    if ("getDeviceInfo".equals(localObject4))
                    {
                      getGdtDeviceInfo(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("handleClick".equals(localObject4))
                    {
                      handleClick(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("c2sReport".equals(localObject4))
                    {
                      c2sReport(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("dwellTimeMillisReport".equals(localObject4))
                    {
                      dwellTimeMillisReport(paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("getMotiveAd".equals(localObject4))
                    {
                      getMotiveAd(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("showMotiveAd".equals(localObject4))
                    {
                      showMotiveAd(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                      continue;
                    }
                    if ("openMiniApp".equals(localObject4))
                    {
                      openMiniApp(paramString, paramJSONObject.optJSONObject("params"));
                      i = 0;
                    }
                  }
                  else
                  {
                    Object localObject2;
                    if ("nowlive".equals(localObject3))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "nowlive   call method" + (String)localObject4);
                      }
                      if ("getPluginInfo".equals(localObject4))
                      {
                        i = 0;
                        continue;
                      }
                      if ("openRoom".equals(localObject4))
                      {
                        if (!TextUtils.isEmpty(paramJSONObject.optString("params")))
                        {
                          localObject3 = paramJSONObject.optString("params");
                          localObject2 = new Bundle();
                          ((Bundle)localObject2).putInt("jumpType", 1);
                          ((Bundle)localObject2).putString("roomid", (String)localObject3);
                          ((Bundle)localObject2).putString("fromid", "violaCall");
                          if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "nowlive openRoom  roomid = " + (String)localObject3);
                          }
                          localObject3 = BaseApplicationImpl.getApplication().getRuntime();
                          if ((localObject3 instanceof QQAppInterface)) {
                            ((aifl)((QQAppInterface)localObject3).getManager(306)).cL((Bundle)localObject2);
                          }
                          i = 0;
                        }
                      }
                      else
                      {
                        if ("install".equals(localObject4))
                        {
                          paramJSONObject.optInt("params", 0);
                          i = 0;
                          continue;
                        }
                        if ("preload".equals(localObject4))
                        {
                          ThreadManager.post(new BridgeModule.10(this), 8, null, true);
                          i = 0;
                        }
                      }
                    }
                    else if ("publicAccountNew".equals(localObject3))
                    {
                      if ("showReadInJoyNativeCommentView".equals(localObject4))
                      {
                        localObject3 = paramJSONObject.optJSONObject("params");
                        if (localObject3 != null) {
                          if (!TextUtils.isEmpty(((JSONObject)localObject3).optString("callback"))) {
                            break label3432;
                          }
                        }
                        label3432:
                        for (localObject2 = paramString;; localObject2 = ((JSONObject)localObject3).optString("callback"))
                        {
                          obw.a((JSONObject)localObject3, (String)localObject2, new nuv(this));
                          i = 0;
                          break;
                        }
                      }
                    }
                    else if ("sensor".equals(localObject3))
                    {
                      if ("getLocation".equals(localObject4))
                      {
                        fireGetLocation(paramJSONObject.optJSONObject("params"), paramString);
                        i = 0;
                      }
                    }
                    else
                    {
                      i = 1;
                      continue;
                    }
                  }
                }
              }
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void invokeCallJS(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      invokeJS(paramString, getSuccInvokeObj(paramObject));
    }
  }
  
  public void invokeErrorCallJS(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      invokeJS(paramString1, getFailInvokeObj(paramString2));
    }
  }
  
  public void invokeJS(String paramString, JSONObject paramJSONObject)
  {
    if (getViolaInstance() != null) {
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, paramJSONObject, true);
    }
  }
  
  public void isInkanDianTab(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (ReadinjoyTabFrame.Dx()) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("result", i);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "isInkanDianTab exception e = ", paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void isKindCard(String paramString)
  {
    boolean bool = true;
    if (getViolaInstance() != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (aqux.Mv() == 1)
        {
          localJSONObject.put("value", bool);
          ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, localJSONObject, true);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "isKindCard error" + paramString.getMessage());
      }
      bool = false;
    }
  }
  
  public boolean onActivityBack()
  {
    if ((this.mCommentManager != null) && (this.mCommentManager.El()))
    {
      this.mCommentManager.onBackPress();
      return true;
    }
    return super.onActivityBack();
  }
  
  public void onActivityDestroy()
  {
    destroy();
    this.rijWatchWordPresenter.detachView();
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 6
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_0
    //   10: iload_1
    //   11: iload_2
    //   12: aload_3
    //   13: invokespecial 3469	com/tencent/viola/module/BaseModule:onActivityResult	(IILandroid/content/Intent;)V
    //   16: aload_0
    //   17: getfield 739	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:mCommentManager	Lnww;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 739	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:mCommentManager	Lnww;
    //   27: iload_1
    //   28: iload_2
    //   29: aload_3
    //   30: invokevirtual 3470	nww:onActivityResult	(IILandroid/content/Intent;)V
    //   33: iload_1
    //   34: bipush 114
    //   36: if_icmpeq +21 -> 57
    //   39: iload_1
    //   40: bipush 115
    //   42: if_icmpeq +15 -> 57
    //   45: iload_1
    //   46: bipush 116
    //   48: if_icmpeq +9 -> 57
    //   51: iload_1
    //   52: bipush 122
    //   54: if_icmpne +287 -> 341
    //   57: aload_3
    //   58: ifnonnull +4 -> 62
    //   61: return
    //   62: aload_3
    //   63: ldc_w 1719
    //   66: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 13
    //   71: aload 13
    //   73: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne -15 -> 61
    //   79: ldc_w 265
    //   82: astore 12
    //   84: aload 12
    //   86: astore 11
    //   88: iload_1
    //   89: tableswitch	default:+51 -> 140, 114:+148->237, 115:+156->245, 116:+164->253, 117:+55->144, 118:+55->144, 119:+55->144, 120:+55->144, 121:+55->144, 122:+172->261
    //   141: fconst_1
    //   142: astore 11
    //   144: iload_2
    //   145: iconst_m1
    //   146: if_icmpne +123 -> 269
    //   149: aload_3
    //   150: ldc_w 3475
    //   153: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull -97 -> 61
    //   161: new 379	org/json/JSONObject
    //   164: dup
    //   165: aload_3
    //   166: invokespecial 876	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   169: astore_3
    //   170: aload_3
    //   171: ldc_w 1669
    //   174: iconst_0
    //   175: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload_3
    //   180: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   183: astore 12
    //   185: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +39 -> 227
    //   191: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   194: iconst_2
    //   195: new 431	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   202: aload 11
    //   204: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 3477
    //   210: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 12
    //   215: invokestatic 3480	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_0
    //   228: aload 13
    //   230: aload_3
    //   231: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   234: return
    //   235: astore_3
    //   236: return
    //   237: ldc_w 3073
    //   240: astore 11
    //   242: goto -98 -> 144
    //   245: ldc_w 3482
    //   248: astore 11
    //   250: goto -106 -> 144
    //   253: ldc_w 3123
    //   256: astore 11
    //   258: goto -114 -> 144
    //   261: ldc_w 3484
    //   264: astore 11
    //   266: goto -122 -> 144
    //   269: new 379	org/json/JSONObject
    //   272: dup
    //   273: invokespecial 985	org/json/JSONObject:<init>	()V
    //   276: astore_3
    //   277: aload_3
    //   278: ldc_w 1669
    //   281: iload_2
    //   282: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   285: pop
    //   286: aload_3
    //   287: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   290: astore_3
    //   291: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +35 -> 329
    //   297: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   300: iconst_2
    //   301: new 431	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   308: aload 11
    //   310: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 3477
    //   316: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_3
    //   320: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_0
    //   330: aload 13
    //   332: ldc_w 3486
    //   335: invokevirtual 602	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeErrorCallJS	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: return
    //   339: astore_3
    //   340: return
    //   341: iload_1
    //   342: bipush 113
    //   344: if_icmpne +121 -> 465
    //   347: iload_2
    //   348: iconst_m1
    //   349: if_icmpne +1548 -> 1897
    //   352: iconst_0
    //   353: istore_1
    //   354: aload_3
    //   355: ifnull -294 -> 61
    //   358: aload_3
    //   359: ldc_w 1991
    //   362: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   365: astore 11
    //   367: aload_3
    //   368: ldc_w 1995
    //   371: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   374: astore 12
    //   376: aload_3
    //   377: ldc_w 396
    //   380: iconst_1
    //   381: invokevirtual 3489	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   384: istore 4
    //   386: aload 11
    //   388: ifnull +52 -> 440
    //   391: aload 12
    //   393: ifnull +47 -> 440
    //   396: new 379	org/json/JSONObject
    //   399: dup
    //   400: invokespecial 985	org/json/JSONObject:<init>	()V
    //   403: astore_3
    //   404: aload_3
    //   405: ldc_w 1788
    //   408: aload 12
    //   410: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload_3
    //   415: ldc_w 1669
    //   418: iload_1
    //   419: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   422: pop
    //   423: aload_3
    //   424: ldc_w 396
    //   427: iload 4
    //   429: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   432: pop
    //   433: aload_0
    //   434: aload 11
    //   436: aload_3
    //   437: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   440: getstatic 3494	odg$d:a	Lodg$d;
    //   443: astore_3
    //   444: iload_2
    //   445: iconst_m1
    //   446: if_icmpne +13 -> 459
    //   449: iconst_1
    //   450: istore 5
    //   452: aload_3
    //   453: iload 5
    //   455: invokevirtual 3497	odg$d:nV	(Z)V
    //   458: return
    //   459: iconst_0
    //   460: istore 5
    //   462: goto -10 -> 452
    //   465: iload_1
    //   466: bipush 119
    //   468: if_icmpne +145 -> 613
    //   471: aload_3
    //   472: ifnull -411 -> 61
    //   475: getstatic 525	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   478: ifnull -417 -> 61
    //   481: aload_3
    //   482: ldc_w 1719
    //   485: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   488: astore 12
    //   490: aload 12
    //   492: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne -434 -> 61
    //   498: aload_3
    //   499: ldc_w 3499
    //   502: iconst_m1
    //   503: invokevirtual 3489	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   506: istore_1
    //   507: iload_1
    //   508: ifne +40 -> 548
    //   511: invokestatic 3505	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   514: ifnonnull +6 -> 520
    //   517: invokestatic 3508	android/os/Looper:prepare	()V
    //   520: new 3510	android/os/Handler
    //   523: dup
    //   524: getstatic 525	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   527: invokevirtual 3513	com/tencent/mobileqq/app/BaseActivity:getMainLooper	()Landroid/os/Looper;
    //   530: invokespecial 3516	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   533: new 3518	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$24
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 3519	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$24:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V
    //   541: ldc2_w 3520
    //   544: invokevirtual 3525	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   547: pop
    //   548: ldc_w 265
    //   551: astore 11
    //   553: aload_3
    //   554: ldc_w 3527
    //   557: invokevirtual 3530	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   560: ifeq +12 -> 572
    //   563: aload_3
    //   564: ldc_w 3527
    //   567: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   570: astore 11
    //   572: new 379	org/json/JSONObject
    //   575: dup
    //   576: invokespecial 985	org/json/JSONObject:<init>	()V
    //   579: astore_3
    //   580: aload_3
    //   581: ldc_w 1669
    //   584: iload_1
    //   585: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: aload_3
    //   590: ldc_w 3532
    //   593: aload 11
    //   595: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   598: pop
    //   599: aload_0
    //   600: aload 12
    //   602: aload_3
    //   603: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   606: return
    //   607: astore_3
    //   608: aload_3
    //   609: invokevirtual 1152	org/json/JSONException:printStackTrace	()V
    //   612: return
    //   613: iload_1
    //   614: bipush 118
    //   616: if_icmpeq +9 -> 625
    //   619: iload_1
    //   620: bipush 121
    //   622: if_icmpne +358 -> 980
    //   625: aload_3
    //   626: ifnonnull +102 -> 728
    //   629: iload_2
    //   630: ifne -569 -> 61
    //   633: new 379	org/json/JSONObject
    //   636: dup
    //   637: invokespecial 985	org/json/JSONObject:<init>	()V
    //   640: astore_3
    //   641: aload_3
    //   642: ldc_w 1669
    //   645: iconst_1
    //   646: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   649: pop
    //   650: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +36 -> 689
    //   656: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   659: iconst_2
    //   660: new 431	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 3534
    //   670: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_3
    //   674: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   677: invokestatic 3480	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   680: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 3084	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:mUploadCallBack	Ljava/lang/String;
    //   693: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   696: ifne -635 -> 61
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 3084	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:mUploadCallBack	Ljava/lang/String;
    //   704: aload_3
    //   705: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   708: return
    //   709: astore_3
    //   710: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq -652 -> 61
    //   716: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   719: iconst_2
    //   720: aload_3
    //   721: invokestatic 538	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   724: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: return
    //   728: aload_3
    //   729: ldc_w 1608
    //   732: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   735: astore 11
    //   737: aload 11
    //   739: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   742: ifne -681 -> 61
    //   745: iload_2
    //   746: iconst_m1
    //   747: if_icmpne +153 -> 900
    //   750: aload_3
    //   751: ldc_w 3536
    //   754: invokevirtual 3540	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   757: astore 12
    //   759: aload 12
    //   761: ifnull -700 -> 61
    //   764: aload 12
    //   766: ldc_w 1669
    //   769: invokevirtual 2504	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   772: istore_1
    //   773: aload 12
    //   775: ldc_w 620
    //   778: invokevirtual 2493	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: astore_3
    //   782: aload 12
    //   784: ldc_w 3532
    //   787: invokevirtual 2493	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   790: astore 12
    //   792: new 379	org/json/JSONObject
    //   795: dup
    //   796: invokespecial 985	org/json/JSONObject:<init>	()V
    //   799: astore 13
    //   801: aload 13
    //   803: ldc_w 1669
    //   806: iload_1
    //   807: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   810: pop
    //   811: aload 13
    //   813: ldc_w 620
    //   816: aload_3
    //   817: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   820: pop
    //   821: aload 13
    //   823: ldc_w 3532
    //   826: aload 12
    //   828: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   831: pop
    //   832: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +37 -> 872
    //   838: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   841: iconst_2
    //   842: new 431	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   849: ldc_w 3534
    //   852: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload 13
    //   857: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   860: invokestatic 3480	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   863: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload_0
    //   873: aload 11
    //   875: aload 13
    //   877: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   880: return
    //   881: astore_3
    //   882: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   885: ifeq -824 -> 61
    //   888: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   891: iconst_2
    //   892: aload_3
    //   893: invokestatic 538	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   896: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   899: return
    //   900: new 379	org/json/JSONObject
    //   903: dup
    //   904: invokespecial 985	org/json/JSONObject:<init>	()V
    //   907: astore_3
    //   908: aload_3
    //   909: ldc_w 1669
    //   912: iconst_m1
    //   913: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   916: pop
    //   917: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   920: ifeq +33 -> 953
    //   923: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   926: iconst_2
    //   927: new 431	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   934: ldc_w 3542
    //   937: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: aload_3
    //   941: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   944: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   953: aload_0
    //   954: aload 11
    //   956: aload_3
    //   957: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   960: return
    //   961: astore_3
    //   962: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq -904 -> 61
    //   968: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   971: iconst_2
    //   972: aload_3
    //   973: invokestatic 538	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   976: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: return
    //   980: iload_1
    //   981: bipush 117
    //   983: if_icmpne +183 -> 1166
    //   986: aload_3
    //   987: ifnull -926 -> 61
    //   990: aload_3
    //   991: ldc_w 1719
    //   994: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   997: astore 11
    //   999: aload 11
    //   1001: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1004: ifne -943 -> 61
    //   1007: iload_2
    //   1008: sipush 1699
    //   1011: if_icmpne +47 -> 1058
    //   1014: aload_0
    //   1015: getfield 2629	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:dataManager	Lkqd;
    //   1018: ifnull +10 -> 1028
    //   1021: aload_0
    //   1022: getfield 2629	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:dataManager	Lkqd;
    //   1025: invokevirtual 2634	kqd:clear	()V
    //   1028: aload_0
    //   1029: new 2631	kqd
    //   1032: dup
    //   1033: invokespecial 3543	kqd:<init>	()V
    //   1036: putfield 2629	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:dataManager	Lkqd;
    //   1039: aload_3
    //   1040: aload_0
    //   1041: getfield 2629	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:dataManager	Lkqd;
    //   1044: aload 11
    //   1046: new 3545	nvg
    //   1049: dup
    //   1050: aload_0
    //   1051: invokespecial 3546	nvg:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V
    //   1054: invokestatic 3549	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/content/Intent;Lkqd;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule$a;)V
    //   1057: return
    //   1058: aload_3
    //   1059: ldc_w 3475
    //   1062: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1065: astore_3
    //   1066: aload_3
    //   1067: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1070: ifne +73 -> 1143
    //   1073: new 379	org/json/JSONObject
    //   1076: dup
    //   1077: aload_3
    //   1078: invokespecial 876	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1081: astore_3
    //   1082: iload_2
    //   1083: iconst_m1
    //   1084: if_icmpne +70 -> 1154
    //   1087: aload_3
    //   1088: ldc_w 1669
    //   1091: iconst_0
    //   1092: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1095: pop
    //   1096: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1099: ifeq +36 -> 1135
    //   1102: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1105: iconst_2
    //   1106: new 431	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 3551
    //   1116: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_3
    //   1120: invokevirtual 1037	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1123: invokestatic 3480	com/tencent/biz/pubaccount/readinjoy/ugc/ReadInJoyDeliverUGCActivity:eS	(Ljava/lang/String;)Ljava/lang/String;
    //   1126: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: aload_0
    //   1136: aload 11
    //   1138: aload_3
    //   1139: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1142: return
    //   1143: new 379	org/json/JSONObject
    //   1146: dup
    //   1147: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1150: astore_3
    //   1151: goto -69 -> 1082
    //   1154: aload_3
    //   1155: ldc_w 1669
    //   1158: iconst_m1
    //   1159: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1162: pop
    //   1163: goto -67 -> 1096
    //   1166: iload_1
    //   1167: bipush 21
    //   1169: if_icmpne +242 -> 1411
    //   1172: iload_2
    //   1173: iconst_m1
    //   1174: if_icmpne +147 -> 1321
    //   1177: aload_0
    //   1178: invokevirtual 749	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   1181: ifnull +49 -> 1230
    //   1184: aload_0
    //   1185: invokevirtual 749	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   1188: invokevirtual 1377	com/tencent/viola/core/ViolaInstance:getActivity	()Landroid/app/Activity;
    //   1191: ifnull +39 -> 1230
    //   1194: invokestatic 583	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1197: checkcast 683	com/tencent/mobileqq/app/QQAppInterface
    //   1200: aload_0
    //   1201: invokevirtual 749	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   1204: invokevirtual 1377	com/tencent/viola/core/ViolaInstance:getActivity	()Landroid/app/Activity;
    //   1207: aload_0
    //   1208: invokevirtual 749	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:getViolaInstance	()Lcom/tencent/viola/core/ViolaInstance;
    //   1211: invokevirtual 1377	com/tencent/viola/core/ViolaInstance:getActivity	()Landroid/app/Activity;
    //   1214: aload_3
    //   1215: aconst_null
    //   1216: invokestatic 3556	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   1219: pop
    //   1220: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1223: iconst_2
    //   1224: ldc_w 3558
    //   1227: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: new 379	org/json/JSONObject
    //   1233: dup
    //   1234: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1237: astore_3
    //   1238: aload_3
    //   1239: ldc 94
    //   1241: getstatic 3560	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackType	I
    //   1244: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1247: pop
    //   1248: aload_3
    //   1249: ldc 37
    //   1251: getstatic 3562	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackName	Ljava/lang/String;
    //   1254: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1257: pop
    //   1258: aload_3
    //   1259: ldc 49
    //   1261: iconst_1
    //   1262: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1265: pop
    //   1266: getstatic 3564	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackId	Ljava/lang/String;
    //   1269: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1272: ifne +11 -> 1283
    //   1275: aload_0
    //   1276: getstatic 3564	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackId	Ljava/lang/String;
    //   1279: aload_3
    //   1280: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1283: aload_0
    //   1284: getfield 3566	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareVideoCallBackId	Ljava/lang/String;
    //   1287: astore_3
    //   1288: aload_3
    //   1289: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1292: ifne -1231 -> 61
    //   1295: new 379	org/json/JSONObject
    //   1298: dup
    //   1299: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1302: astore 11
    //   1304: aload 11
    //   1306: ldc_w 1074
    //   1309: iconst_1
    //   1310: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1313: pop
    //   1314: aload_0
    //   1315: aload_3
    //   1316: aload 11
    //   1318: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1321: getstatic 3494	odg$d:a	Lodg$d;
    //   1324: astore_3
    //   1325: iload_2
    //   1326: iconst_m1
    //   1327: if_icmpne +78 -> 1405
    //   1330: aload_3
    //   1331: iload 5
    //   1333: invokevirtual 3497	odg$d:nV	(Z)V
    //   1336: return
    //   1337: astore_3
    //   1338: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1341: iconst_1
    //   1342: new 431	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1349: ldc_w 3568
    //   1352: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: aload_3
    //   1356: invokevirtual 1007	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1359: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: goto -85 -> 1283
    //   1371: astore_3
    //   1372: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1375: iconst_2
    //   1376: new 431	java/lang/StringBuilder
    //   1379: dup
    //   1380: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1383: ldc_w 3570
    //   1386: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload_3
    //   1390: invokevirtual 597	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1393: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: goto -81 -> 1321
    //   1405: iconst_0
    //   1406: istore 5
    //   1408: goto -78 -> 1330
    //   1411: iload_1
    //   1412: bipush 123
    //   1414: if_icmpne +141 -> 1555
    //   1417: aload_3
    //   1418: ifnull -1357 -> 61
    //   1421: iload_2
    //   1422: iconst_1
    //   1423: if_icmpeq +8 -> 1431
    //   1426: iload_2
    //   1427: iconst_2
    //   1428: if_icmpne -1367 -> 61
    //   1431: aload_3
    //   1432: ldc_w 1719
    //   1435: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1438: astore 11
    //   1440: aload 11
    //   1442: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1445: ifne -1384 -> 61
    //   1448: new 379	org/json/JSONObject
    //   1451: dup
    //   1452: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1455: astore 12
    //   1457: aload_3
    //   1458: ldc_w 3572
    //   1461: iconst_0
    //   1462: invokevirtual 3575	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1465: ifeq +85 -> 1550
    //   1468: iload 4
    //   1470: istore_1
    //   1471: aload 12
    //   1473: ldc_w 2593
    //   1476: iload_1
    //   1477: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1480: pop
    //   1481: aload_3
    //   1482: ldc_w 3577
    //   1485: invokevirtual 3581	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1488: checkcast 3583	com/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo
    //   1491: astore_3
    //   1492: aload_3
    //   1493: ifnull +16 -> 1509
    //   1496: aload 12
    //   1498: ldc_w 2288
    //   1501: aload_3
    //   1502: getfield 3586	com/tencent/biz/pubaccount/readinjoy/struct/ColumnInfo:columnID	I
    //   1505: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1508: pop
    //   1509: aload_0
    //   1510: aload 11
    //   1512: aload 12
    //   1514: invokevirtual 1004	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeJS	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   1517: return
    //   1518: astore_3
    //   1519: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1522: iconst_1
    //   1523: new 431	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1530: ldc_w 3588
    //   1533: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: aload_3
    //   1537: invokevirtual 1228	org/json/JSONException:toString	()Ljava/lang/String;
    //   1540: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1546: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1549: return
    //   1550: iconst_m1
    //   1551: istore_1
    //   1552: goto -81 -> 1471
    //   1555: iload_1
    //   1556: bipush 101
    //   1558: if_icmpne +211 -> 1769
    //   1561: aload_3
    //   1562: ldc_w 1719
    //   1565: invokevirtual 3473	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1568: astore 11
    //   1570: aload 11
    //   1572: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1575: ifne -1514 -> 61
    //   1578: aload_3
    //   1579: invokevirtual 3592	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   1582: astore_3
    //   1583: aload_3
    //   1584: ldc_w 3594
    //   1587: invokevirtual 3597	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1590: lstore 7
    //   1592: aload_3
    //   1593: ldc_w 3599
    //   1596: invokevirtual 3597	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1599: lstore 9
    //   1601: aload_3
    //   1602: ldc_w 3601
    //   1605: iconst_0
    //   1606: invokevirtual 3603	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   1609: istore 5
    //   1611: aload_3
    //   1612: ldc_w 3605
    //   1615: iconst_0
    //   1616: invokevirtual 3603	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   1619: istore 6
    //   1621: invokestatic 534	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1624: ifeq +53 -> 1677
    //   1627: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1630: iconst_2
    //   1631: new 431	java/lang/StringBuilder
    //   1634: dup
    //   1635: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1638: ldc_w 3607
    //   1641: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: lload 7
    //   1646: invokevirtual 460	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1649: ldc_w 3609
    //   1652: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: lload 9
    //   1657: invokevirtual 460	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1660: ldc_w 3611
    //   1663: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: iload 5
    //   1668: invokevirtual 3614	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1677: new 379	org/json/JSONObject
    //   1680: dup
    //   1681: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1684: astore_3
    //   1685: iload_2
    //   1686: iconst_m1
    //   1687: if_icmpne +60 -> 1747
    //   1690: aload_3
    //   1691: ldc_w 1669
    //   1694: iconst_0
    //   1695: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1698: pop
    //   1699: aload_3
    //   1700: ldc_w 3616
    //   1703: lload 9
    //   1705: invokevirtual 3619	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1708: pop
    //   1709: aload_3
    //   1710: ldc_w 3621
    //   1713: lload 7
    //   1715: invokevirtual 3619	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1718: pop
    //   1719: aload_3
    //   1720: ldc_w 3623
    //   1723: iload 5
    //   1725: invokevirtual 995	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1728: pop
    //   1729: aload_3
    //   1730: ldc_w 3625
    //   1733: iload 6
    //   1735: invokevirtual 995	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   1738: pop
    //   1739: aload_0
    //   1740: aload 11
    //   1742: aload_3
    //   1743: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1746: return
    //   1747: aload_3
    //   1748: ldc_w 1669
    //   1751: iconst_m1
    //   1752: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1755: pop
    //   1756: goto -57 -> 1699
    //   1759: astore 12
    //   1761: aload 12
    //   1763: invokevirtual 1152	org/json/JSONException:printStackTrace	()V
    //   1766: goto -27 -> 1739
    //   1769: iload_1
    //   1770: bipush 125
    //   1772: if_icmpne -1711 -> 61
    //   1775: iload_2
    //   1776: iconst_m1
    //   1777: if_icmpne +56 -> 1833
    //   1780: new 379	org/json/JSONObject
    //   1783: dup
    //   1784: invokespecial 985	org/json/JSONObject:<init>	()V
    //   1787: astore_3
    //   1788: aload_3
    //   1789: ldc 94
    //   1791: getstatic 3560	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackType	I
    //   1794: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1797: pop
    //   1798: aload_3
    //   1799: ldc 37
    //   1801: getstatic 3562	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackName	Ljava/lang/String;
    //   1804: invokevirtual 1000	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1807: pop
    //   1808: aload_3
    //   1809: ldc 49
    //   1811: iconst_1
    //   1812: invokevirtual 990	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1815: pop
    //   1816: getstatic 3564	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackId	Ljava/lang/String;
    //   1819: invokestatic 626	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1822: ifne +11 -> 1833
    //   1825: aload_0
    //   1826: getstatic 3564	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:shareCallBackId	Ljava/lang/String;
    //   1829: aload_3
    //   1830: invokevirtual 735	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:invokeCallJS	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1833: getstatic 3494	odg$d:a	Lodg$d;
    //   1836: astore_3
    //   1837: iload_2
    //   1838: iconst_m1
    //   1839: if_icmpne +48 -> 1887
    //   1842: iload 6
    //   1844: istore 5
    //   1846: aload_3
    //   1847: iload 5
    //   1849: invokevirtual 3497	odg$d:nV	(Z)V
    //   1852: return
    //   1853: astore_3
    //   1854: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   1857: iconst_1
    //   1858: new 431	java/lang/StringBuilder
    //   1861: dup
    //   1862: invokespecial 432	java/lang/StringBuilder:<init>	()V
    //   1865: ldc_w 3568
    //   1868: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: aload_3
    //   1872: invokevirtual 1007	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1875: invokevirtual 438	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1881: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1884: goto -51 -> 1833
    //   1887: iconst_0
    //   1888: istore 5
    //   1890: goto -44 -> 1846
    //   1893: astore_3
    //   1894: goto -1454 -> 440
    //   1897: iconst_m1
    //   1898: istore_1
    //   1899: goto -1545 -> 354
    //   1902: astore_3
    //   1903: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1904	0	this	BridgeModule
    //   0	1904	1	paramInt1	int
    //   0	1904	2	paramInt2	int
    //   0	1904	3	paramIntent	Intent
    //   1	1468	4	i	int
    //   7	1882	5	bool1	boolean
    //   4	1839	6	bool2	boolean
    //   1590	124	7	l1	long
    //   1599	105	9	l2	long
    //   86	1655	11	localObject1	Object
    //   82	1431	12	localObject2	Object
    //   1759	3	12	localJSONException	JSONException
    //   69	807	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   161	227	235	java/lang/Exception
    //   227	234	235	java/lang/Exception
    //   269	329	339	java/lang/Exception
    //   329	338	339	java/lang/Exception
    //   580	606	607	org/json/JSONException
    //   633	689	709	java/lang/Exception
    //   689	708	709	java/lang/Exception
    //   792	872	881	java/lang/Exception
    //   872	880	881	java/lang/Exception
    //   900	953	961	java/lang/Exception
    //   953	960	961	java/lang/Exception
    //   1238	1283	1337	org/json/JSONException
    //   1304	1321	1371	java/lang/Exception
    //   1457	1468	1518	org/json/JSONException
    //   1471	1492	1518	org/json/JSONException
    //   1496	1509	1518	org/json/JSONException
    //   1509	1517	1518	org/json/JSONException
    //   1690	1699	1759	org/json/JSONException
    //   1699	1739	1759	org/json/JSONException
    //   1747	1756	1759	org/json/JSONException
    //   1788	1833	1853	org/json/JSONException
    //   404	440	1893	java/lang/Exception
    //   1066	1082	1902	java/lang/Exception
    //   1087	1096	1902	java/lang/Exception
    //   1096	1135	1902	java/lang/Exception
    //   1135	1142	1902	java/lang/Exception
    //   1143	1151	1902	java/lang/Exception
    //   1154	1163	1902	java/lang/Exception
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    AbstractGifImage.resumeAll();
  }
  
  public void onClickBubbleTips(JSONObject paramJSONObject, String paramString)
  {
    if ((getViolaInstance() != null) && (getViolaInstance().getActivity() != null)) {
      RIJRedPacketManager.a().a(getViolaInstance().getActivity(), 4, paramJSONObject.optString("redPacketId"), paramJSONObject.optString("rowkey"), new nvy(this, paramString), false, null);
    }
  }
  
  public void openAccountPageMore(JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((paramJSONObject != null) && (localActivity != null)) {}
    try
    {
      long l = paramJSONObject.getLong("puin");
      paramJSONObject = new Intent(localActivity, AccountDetailActivity.class);
      paramJSONObject.putExtra("uin", "" + l);
      paramJSONObject.putExtra("from_js", true);
      localActivity.startActivity(paramJSONObject);
      invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  @JSMethod
  public void openAddVideoView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId", 0);
    String str = paramJSONObject.optString("title");
    int j = paramJSONObject.optInt("fromType", 0);
    paramJSONObject = new ColumnInfo();
    paramJSONObject.columnID = i;
    paramJSONObject.title = str;
    mix.a(BaseActivity.sTopActivity, paramJSONObject, j, paramString, 124);
  }
  
  @JSMethod
  public void openApp(String paramString)
  {
    openApp(paramString, null, null);
  }
  
  public void openApp(String paramString1, String paramString2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {}
      }
      else
      {
        if ((paramString1.contains("weishi")) || (paramString1.contains("weishi://feed"))) {
          if (rpw.isWeishiInstalled(localBaseActivity)) {
            oem.aT(localBaseActivity, "video_type_videopublic");
          }
        }
        while (!TextUtils.isEmpty(paramString2))
        {
          invokeCallJS(paramString2, null);
          return;
          oem.aU(localBaseActivity, "video_type_videopublic");
          continue;
          if (!knd.D(localBaseActivity, paramString1))
          {
            Intent localIntent = new Intent();
            localIntent.setAction("android.intent.action.VIEW");
            String str = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              str = kxm.bg(0);
            }
            localIntent.putExtra("big_brother_source_key", str);
            localIntent.putExtra("big_brother_ref_source_key", kxm.bg(0));
            localIntent.setData(Uri.parse(paramString1));
            localBaseActivity.startActivity(localIntent);
          }
        }
      }
    }
  }
  
  @JSMethod
  public void openCreateTopicView(String paramString)
  {
    mix.g(BaseActivity.sTopActivity, paramString, 123);
  }
  
  @JSMethod
  public void openEditTopicView(JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("topicId", 0);
    String str1 = paramJSONObject.optString("iconUrl");
    String str2 = paramJSONObject.optString("title");
    paramJSONObject = paramJSONObject.optString("intro");
    mix.a(BaseActivity.sTopActivity, i, str1, str2, paramJSONObject, paramString, 123);
  }
  
  @JSMethod
  public void openMiniApp(String paramString, JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("res", 1);
      if (MiniAppLauncher.startMiniApp(localBaseActivity, paramJSONObject.optString("miniAppUrl"), 2103, null))
      {
        localJSONObject.put("res", 0);
        invokeCallJS(paramString, localJSONObject);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      invokeCallJS(paramString, localJSONObject);
      return;
    }
    invokeCallJS(paramString, localJSONObject);
  }
  
  @JSMethod
  public void openTopicVideoComment(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = paramJSONObject.optString("ref", "");
    ViolaDomManager localViolaDomManager = ViolaSDKManager.getInstance().getDomManager();
    Object localObject1 = getViolaInstance();
    if ((localObject1 != null) && ((((ViolaInstance)localObject1).getActivity() instanceof FragmentActivity)))
    {
      localObject2 = localViolaDomManager.getDomContext(getViolaInstance().getInstanceId()).getComponent((String)localObject2);
      localObject1 = (FragmentActivity)((ViolaInstance)localObject1).getActivity();
      if ((localObject2 == null) || (((VComponent)localObject2).getHostView() == null)) {}
    }
    for (;;)
    {
      try
      {
        int i = bindCommentCallback(paramString);
        if (((FragmentActivity)localObject1).getIntent().getBundleExtra("bundle") == null)
        {
          paramString = new Bundle();
          ((FragmentActivity)localObject1).getIntent().putExtra("bundle", paramString);
        }
        ((FragmentActivity)localObject1).getIntent().getBundleExtra("bundle").putInt("seq", i);
        localObject2 = ((VComponent)localObject2).getHostView();
        paramString = ((View)localObject2).findViewWithTag("VVideoView");
        if ((paramString instanceof VVideoView))
        {
          paramString = (VVideoView)paramString;
          doPostShowComment((FragmentActivity)localObject1, paramString, (View)localObject2, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, paramJSONObject, new Object[0]);
        return;
      }
      paramString = null;
    }
  }
  
  @JSMethod
  public void openUrl(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      jumpUrl(BaseActivity.sTopActivity, paramString, paramBundle);
    }
  }
  
  @JSMethod
  public void openVideo(JSONObject paramJSONObject)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      ntp.d(localBaseActivity, paramJSONObject);
    }
  }
  
  @JSMethod
  public void pauseUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "pauseUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = kxm.a();
    if (paramJSONObject != null) {
      mnw.a(paramJSONObject).a(j, new nvo(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  @JSMethod
  public void performLikeAnimation(JSONObject paramJSONObject)
  {
    ViolaInstance localViolaInstance = getViolaInstance();
    if ((paramJSONObject == null) || (localViolaInstance == null) || (localViolaInstance.getRenderContainer() == null)) {
      return;
    }
    float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageX"), 750);
    float f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("pageY"), 750);
    paramJSONObject = new VideoFeedsLikeAnimate(localViolaInstance.getRenderContainer(), f1, f2, new Random());
    paramJSONObject.sC(5);
    paramJSONObject.startAnimate();
  }
  
  @JSMethod(uiThread=true)
  public void popFromBottomStateChange(String paramString)
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment))) {
      ((ViolaFragment)getViolaInstance().getFragment()).a(new nwa(this, paramString));
    }
  }
  
  public void requestBubbleTipsWording(JSONObject paramJSONObject, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      RIJRedPacketManager.a().a(paramJSONObject.optString("rowkey"), paramJSONObject.optString("redPacketId"), 4, new nvx(this, paramString));
    }
  }
  
  public void requestRedPacketContentShareToast(String paramString)
  {
    QLog.i(TAG, 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    jnm.a(kxm.getAppRuntime(), new nvv(this, paramString), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  @JSMethod
  public void resumeUploadingVideo(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType", 0);
    int j = paramJSONObject.optInt("topicId", 0);
    QLog.i(TAG, 1, "resumeUploadingVideo, vid=" + str + "pageType=" + i);
    paramJSONObject = kxm.a();
    if (paramJSONObject != null) {
      mnw.a(paramJSONObject).a(j, new nvq(this, str, paramJSONObject, i, j, paramString));
    }
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (!CheckPermission.isHasStoragePermission(localActivity))
    {
      CheckPermission.requestSDCardPermission((AppActivity)localActivity, new nvi(this, paramJSONObject, paramString));
      return;
    }
    saveImagePermission(paramJSONObject, paramString);
  }
  
  public void saveImagePermission(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("content");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append("?client=androidQQ");
      ((StringBuilder)localObject).append("&version=3.4.4.3058");
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&device=" + Build.DEVICE);
      ((StringBuilder)localObject).append("&uin=" + kxm.getAccount());
      paramJSONObject = afgc.insertMtype("VIP_xingying", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "saveImage imageUrl=" + paramJSONObject);
      }
      localObject = System.currentTimeMillis() + ".jpg";
      ThreadManager.executeOnNetWorkThread(new BridgeModule.28(this, paramJSONObject, new File(acbn.oM, (String)localObject), paramString));
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "saveImage imageUrl error=" + paramJSONObject.getMessage());
      }
      invokeErrorCallJS(paramString, "saveImage error");
    }
  }
  
  protected void sendRequest(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    Object localObject1;
    Object localObject2;
    String str;
    QQAppInterface localQQAppInterface;
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = paramJSONObject.getString("host");
          localObject2 = paramJSONObject.getJSONObject("data");
          str = paramJSONObject.getString("cmd");
          localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
          if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (localQQAppInterface != null) && (!TextUtils.isEmpty(str)))
          {
            localObject2 = ((JSONObject)localObject2).toString();
            if (ViolaUtils.getBoolean(paramJSONObject.optString("disableFrequency"))) {
              break label202;
            }
            if (this.preTime == 0L) {
              break label195;
            }
            if (System.currentTimeMillis() - this.preTime >= this.minDuration * 1000) {
              break label158;
            }
            paramJSONObject = new JSONObject();
            paramJSONObject.put("cret", 1);
            invokeCallJS(paramString, paramJSONObject);
            return;
          }
        }
        catch (Exception paramJSONObject) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "send request error!");
    return;
    label158:
    if (((String)localObject2).getBytes().length > this.maxSize)
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("cret", 2);
      invokeCallJS(paramString, paramJSONObject);
      return;
      label195:
      this.preTime = System.currentTimeMillis();
    }
    label202:
    String[] arrayOfString = ((String)localObject1).split("\\.");
    paramJSONObject = "";
    int i = arrayOfString.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        localObject1 = paramJSONObject + arrayOfString[i];
        paramJSONObject = (JSONObject)localObject1;
        if (i != 0) {
          paramJSONObject = (String)localObject1 + "_";
        }
      }
      else
      {
        localObject1 = new NewIntent(localQQAppInterface.getApplication(), jnl.class);
        ((NewIntent)localObject1).putExtra("cmd", "MQUpdateSvc_" + paramJSONObject + ".web." + str);
        paramJSONObject = new WebSsoBody.WebSsoRequestBody();
        paramJSONObject.type.set(0);
        paramJSONObject.data.set((String)localObject2);
        ((NewIntent)localObject1).putExtra("data", paramJSONObject.toByteArray());
        ((NewIntent)localObject1).setObserver(new nuy(this, paramString));
        if (localQQAppInterface == null) {
          break;
        }
        localQQAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      i -= 1;
    }
  }
  
  @JSMethod
  public void setNavBtn(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = getViolaInstance().getFragment();
    if (localObject == null) {}
    label116:
    for (;;)
    {
      return;
      if ((localObject instanceof ViolaFragment)) {}
      for (localObject = ((ViolaFragment)localObject).a();; localObject = null)
      {
        if (localObject == null) {
          break label116;
        }
        String str = paramJSONObject.optString("position");
        paramJSONObject = paramJSONObject.optString("text");
        if (TextUtils.isEmpty(str)) {
          break;
        }
        if (str.equals("right"))
        {
          ((nuk.a)localObject).b(paramJSONObject, new nvk(this, paramString));
          return;
        }
        if (!str.equals("left")) {
          break;
        }
        ((nuk.a)localObject).c(paramJSONObject, new nvw(this, paramString));
        return;
      }
    }
  }
  
  @JSMethod(uiThread=true)
  public void setPresentPopFromBottom(int paramInt)
  {
    boolean bool = true;
    ViolaFragment localViolaFragment;
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if (paramInt != 1) {
        break label44;
      }
    }
    for (;;)
    {
      localViolaFragment.setCanCloseFromBottom(bool);
      return;
      label44:
      bool = false;
    }
  }
  
  protected void shareImageToAIO(String paramString)
  {
    Object localObject1 = getViolaInstance().getActivity();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {}
    while (!AppNetConnInfo.isNetSupport()) {
      return;
    }
    Object localObject2 = new File(aoiz.getFilePath(paramString));
    if (((File)localObject2).exists())
    {
      shareImageToAIOInner((File)localObject2);
      return;
    }
    localObject1 = new Bundle();
    localObject2 = new aquz(paramString, (File)localObject2);
    ((aquz)localObject2).atW = 60L;
    ((aqva)kxm.getAppRuntime().getManager(47)).a(1).a((aquz)localObject2, new nvj(this, paramString), (Bundle)localObject1);
  }
  
  protected void shareImageToAIOInner(File paramFile)
  {
    Activity localActivity = getViolaInstance().getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    ahgq.f(localActivity, (Intent)localObject, 18);
  }
  
  @JSMethod
  public void shareVideoWithFriend(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do shareVideoWithFriend start data: " + paramJSONObject.toString());
    }
    this.shareVideoCallBackId = paramString;
    paramString = new VideoInfo();
    paramString.title = paramJSONObject.optString("article_title", "");
    paramString.busiType = paramJSONObject.optInt("busiType");
    paramString.vid = paramJSONObject.optString("vid");
    paramString.webUrl = paramJSONObject.optString("article_url");
    paramString.aioShareUrl = paramJSONObject.optString("aio_share_url");
    paramString.qzoneShareUrl = paramJSONObject.optString("qzone_share_url");
    paramString.duration = paramJSONObject.optInt("duration");
    paramString.Wz = paramJSONObject.optString("rowkey");
    paramString.coverUrl = paramJSONObject.optString("first_page_url");
    paramString.width = paramJSONObject.optInt("width");
    paramString.height = paramJSONObject.optInt("height");
    paramString.accountName = paramJSONObject.optString("thridName");
    paramString.thirdAction = paramJSONObject.optString("thirdAction");
    paramString.WC = paramJSONObject.optString("thirdIcon");
    paramString.hH = paramJSONObject.optString("third_uin");
    paramString.thirdUinName = paramJSONObject.optString("third_uin_name");
    mwq.a(paramString, getViolaInstance().getActivity(), 1, this.shareToFriendUin, this.shareToFriendUinType, this.shareToFriendUinName);
  }
  
  public void showFailedToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 1, paramString, 0).show();
  }
  
  /* Error */
  @JSMethod
  public void showMotiveAd(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 525	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   6: astore 8
    //   8: ldc_w 265
    //   11: astore 6
    //   13: aload_2
    //   14: ldc_w 4060
    //   17: invokevirtual 427	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   20: istore_3
    //   21: aload_2
    //   22: ldc_w 2472
    //   25: invokevirtual 383	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 7
    //   30: aload 7
    //   32: astore 6
    //   34: aload_2
    //   35: ldc_w 4062
    //   38: iconst_0
    //   39: invokevirtual 389	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   42: istore 5
    //   44: iload 5
    //   46: istore 4
    //   48: aload 7
    //   50: astore 6
    //   52: invokestatic 2762	knf:a	()Lknf;
    //   55: aload 8
    //   57: iload_3
    //   58: aload 6
    //   60: iload 4
    //   62: aload_1
    //   63: invokevirtual 4065	knf:a	(Landroid/app/Activity;ILjava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: astore_2
    //   68: iconst_0
    //   69: istore_3
    //   70: getstatic 235	com/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule:TAG	Ljava/lang/String;
    //   73: iconst_1
    //   74: ldc_w 4067
    //   77: aload_2
    //   78: invokestatic 550	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   81: goto -29 -> 52
    //   84: astore_2
    //   85: goto -15 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	BridgeModule
    //   0	88	1	paramString	String
    //   0	88	2	paramJSONObject	JSONObject
    //   20	50	3	i	int
    //   1	60	4	j	int
    //   42	3	5	k	int
    //   11	48	6	localObject	Object
    //   28	21	7	str	String
    //   6	50	8	localBaseActivity	BaseActivity
    // Exception table:
    //   from	to	target	type
    //   13	21	67	java/lang/Exception
    //   21	30	84	java/lang/Exception
    //   34	44	84	java/lang/Exception
  }
  
  public void showSuccessToast(@NotNull String paramString)
  {
    QQToast.a(getViolaInstance().getActivity(), 2, paramString, 0).show();
  }
  
  public void showVisibleUserList(JSONObject paramJSONObject, String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return;
    }
    paramJSONObject = paramJSONObject.optString("feedsId");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      QLog.d(TAG, 2, "showVisibleUserList feedsId " + paramJSONObject);
      Intent localIntent = new Intent();
      localIntent.putExtra("feeds_id", new BigInteger(paramJSONObject).longValue());
      PublicFragmentActivity.start(localBaseActivity, localIntent, ReadInJoyPrivacyListFragment.class);
      invokeCallJS(paramString, null);
      return;
    }
    invokeErrorCallJS(paramString, "params error");
  }
  
  public void socailFeedsUpdate(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      String str = paramJSONObject.getString("feeds_id");
      paramJSONObject = paramJSONObject.optString("feeds_type", "1");
      lbz.a().aC(str, Integer.valueOf(paramJSONObject).intValue());
      invokeCallJS(paramString, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  @JSMethod
  public void startImagePreDownload(JSONObject paramJSONObject)
  {
    float f2 = 100.0F;
    String str;
    boolean bool;
    if (!TextUtils.isEmpty(paramJSONObject.optString("url", "")))
    {
      str = paramJSONObject.optString("url", "");
      bool = paramJSONObject.optBoolean("isGif", false);
      if (!paramJSONObject.has("width")) {
        break label169;
      }
    }
    label169:
    for (float f1 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("width"), 750);; f1 = 100.0F)
    {
      if (paramJSONObject.has("height")) {
        f2 = FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.opt("height"), 750);
      }
      paramJSONObject = URLDrawable.getDrawable(str, nug.a(bool, (int)f1, (int)f2));
      QLog.d(TAG, 2, "preload image, ur: " + str + ".isGif:" + bool + ",reqWidth:" + f1 + ",reqHeight:" + f2);
      paramJSONObject.startDownload();
      return;
    }
  }
  
  @JSMethod
  public void startVideoPreDownload(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("preload_array");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
        localArrayList.add(new VideoPreDownloadMgr.b(localJSONObject.optString("videoVid"), localJSONObject.optString("articleID"), localJSONObject.optInt("busitype"), localJSONObject.optInt("duration")));
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ViolaLogUtils.e(TAG, "startVideoPreDownload error :" + paramJSONObject.getMessage());
      if ((this.mVideoPreDownloadMgr != null) && (getViolaInstance() != null) && (getViolaInstance().getActivity() != null))
      {
        this.mVideoPreDownloadMgr.init(getViolaInstance().getActivity().getApplicationContext());
        this.mVideoPreDownloadMgr.a = new myn(myn.aWd, myn.aWf);
        this.mVideoPreDownloadMgr.a(new nuu(this, localArrayList));
      }
      this.mVideoPreDownloadMgr.ad(0, true);
    }
  }
  
  @JSMethod
  public void studyModeSelectGrade(JSONObject paramJSONObject, String paramString)
  {
    kxm.mE(paramJSONObject.optString("selectedGradeList", ""));
    invokeJS(paramString, new JSONObject());
  }
  
  @JSMethod
  public void susCommentViewHide()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.Gh()) && (localViolaFragment.a() != null)) {
        localViolaFragment.a().bbn();
      }
    }
  }
  
  @JSMethod
  public void susCommentViewShow()
  {
    if ((getViolaInstance() != null) && ((getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)getViolaInstance().getFragment();
      if ((localViolaFragment.Gh()) && (localViolaFragment.a() != null)) {
        localViolaFragment.a().bbm();
      }
    }
  }
  
  public void updateAccountCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = true;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        long l = paramJSONObject.getLong("followUin");
        int i = paramJSONObject.getInt("followInfo");
        if ((i == 2) || (i == 1))
        {
          paramJSONObject = lcc.a();
          if (i != 2) {
            break label120;
          }
          paramJSONObject.W(l, bool);
          ThreadManager.post(new BridgeModule.12(this, l, i), 8, null, true);
        }
        invokeCallJS(paramString, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
        return;
      }
      invokeErrorCallJS(paramString, "params error");
      return;
      label120:
      bool = false;
    }
  }
  
  @JSMethod(uiThread=true)
  public void updateIndepentTabState(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("state")))
    {
      int i = paramJSONObject.optInt("state");
      lcc.a().h(i, null);
    }
  }
  
  public void updateRedPacketShareTime() {}
  
  public void updateTopicCardFollowInfo(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      int i = paramJSONObject.getInt("topicId");
      int j = paramJSONObject.getInt("followInfo");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "topic id = " + i + "\t follow info =" + j);
      }
      if (!lbz.a().aa(i, j)) {
        lbz.a().cH(i, j);
      }
      invokeCallJS(paramString, null);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(TAG, 2, "openAccountPageMore->error:" + paramJSONObject);
    }
    invokeErrorCallJS(paramString, "params error");
    return;
  }
  
  @JSMethod(uiThread=false)
  public void vaNetworkChange(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface == null) {}
    while (this.netInfoHandler != null) {
      return;
    }
    this.netInfoHandler = new nvb(this, paramString);
    AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.netInfoHandler);
  }
  
  @JSMethod
  public void videoPlayFeedback(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "do videoPlayFeedback start data: " + paramJSONObject.toString());
    }
    ncb.ad(paramJSONObject);
    paramJSONObject = getViolaInstance();
    JSONObject localJSONObject;
    if (paramJSONObject != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("success", 1);
      ViolaBridgeManager.getInstance().callbackJavascript(paramJSONObject.getInstanceId(), MODULE_NAME, "callback", paramString, localJSONObject, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void j(String paramString, JSONObject paramJSONObject);
  }
  
  class b
    extends odg.a
  {
    JSONObject aI;
    private boolean auY;
    private List<oaq> kE;
    private List<oaq> kF;
    private WeakReference<Activity> mActivityReference;
    
    b(List<oaq> paramList1, List<oaq> paramList2, JSONObject paramJSONObject, WeakReference<Activity> paramWeakReference, String paramString)
    {
      this.aI = paramWeakReference;
      this.mActivityReference = paramString;
      Object localObject;
      BridgeModule.shareCallBackId = localObject;
      this.auY = paramList1;
      this.kE = paramList2;
      this.kF = paramJSONObject;
    }
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      if (this.mActivityReference.get() == null) {
        return false;
      }
      int i;
      int j;
      switch (paramInt)
      {
      default: 
        i = -1;
        j = -1;
      }
      Object localObject4;
      int k;
      label550:
      label686:
      Object localObject2;
      for (;;)
      {
        BridgeModule.shareCallBackType = BridgeModule.this.mShareUtils.dG(paramInt);
        BridgeModule.shareCallBackName = BridgeModule.this.mShareHelper.bI(paramInt);
        Object localObject1;
        if ("1".equals(this.aI.optString("from")))
        {
          localObject1 = Uri.parse(this.aI.optString("share_url")).buildUpon();
          if (paramInt != 2) {
            break label550;
          }
          ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "2");
        }
        try
        {
          this.aI.put("share_url", ((Uri.Builder)localObject1).build().toString());
          if (this.auY)
          {
            localObject1 = BridgeModule.this.mShareHelper;
            localObject3 = this.kE;
            localObject4 = this.kF;
            if (paramInt == 72)
            {
              k = 2;
              localObject1 = ((odg)localObject1).a((List)localObject3, (List)localObject4, k);
              if ((localObject1 == null) || (!((oaq)localObject1).avZ)) {
                break label686;
              }
              localObject1 = new JSONObject();
              if (paramInt == 72)
              {
                BridgeModule.shareCallBackName = "qq_friend";
                BridgeModule.access$702(BridgeModule.this, paramActionSheetItem.uin);
                BridgeModule.access$802(BridgeModule.this, paramActionSheetItem.uinType);
                BridgeModule.access$902(BridgeModule.this, paramActionSheetItem.label);
              }
            }
          }
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            for (;;)
            {
              ((JSONObject)localObject1).put("type", BridgeModule.shareCallBackType);
              ((JSONObject)localObject1).put("action", BridgeModule.shareCallBackName);
              ((JSONObject)localObject1).put("fromCallback", 0);
              if (!TextUtils.isEmpty(BridgeModule.shareCallBackId)) {
                BridgeModule.this.invokeCallJS(BridgeModule.shareCallBackId, localObject1);
              }
              return true;
              i = -1;
              j = 0;
              break;
              i = 19;
              j = 1;
              break;
              i = -1;
              j = 1;
              break;
              i = -1;
              j = 6;
              break;
              i = -1;
              j = 7;
              break;
              i = -1;
              j = 2;
              break;
              i = -1;
              j = 3;
              break;
              i = -1;
              j = 4;
              break;
              i = -1;
              j = 5;
              break;
              i = -1;
              j = 8;
              break;
              i = 3;
              j = -1;
              break;
              i = 5;
              j = -1;
              break;
              i = 4;
              j = -1;
              break;
              i = 7;
              j = -1;
              break;
              i = 2;
              j = -1;
              break;
              if (paramInt == 3)
              {
                ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "3");
              }
              else if ((paramInt == 9) || (paramInt == 10))
              {
                ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "6");
              }
              else if (paramInt == 13)
              {
                ((Uri.Builder)localObject1).appendQueryParameter("plat_source", "4");
                continue;
                localJSONException1 = localJSONException1;
                QLog.e(BridgeModule.TAG, 1, "processClick error=" + localJSONException1.getMessage());
              }
            }
            k = paramInt;
          }
          catch (JSONException paramActionSheetItem)
          {
            for (;;)
            {
              QLog.e(BridgeModule.TAG, 1, "processClick webhandle error=" + paramActionSheetItem.getMessage());
            }
          }
          if (this.aI == null) {
            return true;
          }
          localObject2 = this.aI.optString("share_url");
          localObject4 = this.aI.optString("aio_share_url");
          localObject3 = this.aI.optString("puin");
          BridgeModule.access$402(BridgeModule.this, true);
          if (paramInt != 1) {
            break label983;
          }
        }
      }
      Object localObject3 = (ClipboardManager)((Activity)this.mActivityReference.get()).getSystemService("clipboard");
      alkw.a((ClipboardManager)localObject3, (CharSequence)localObject2);
      ((ClipboardManager)localObject3).setText((CharSequence)localObject2);
      rwt.ez(2, 2131692332);
      for (;;)
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("type", BridgeModule.shareCallBackType);
          ((JSONObject)localObject2).put("action", BridgeModule.shareCallBackName);
          ((JSONObject)localObject2).put("fromCallback", 0);
          if (!TextUtils.isEmpty(BridgeModule.shareCallBackId)) {
            BridgeModule.this.invokeCallJS(BridgeModule.shareCallBackId, localObject2);
          }
          localObject2 = this.aI.optString("rowkey", "");
          k = this.aI.optInt("source", -1);
          int m = this.aI.optInt("report_from", -1);
          localObject3 = this.aI.optString("vid", "");
          localObject4 = this.aI.optString("algorithmId", "");
          String str1 = this.aI.optString("articleId", "");
          String str2 = this.aI.optString("topicId", "");
          if ((m == 4) || (m == 11)) {
            BridgeModule.access$100(BridgeModule.this, (String)localObject2, (String)localObject3, k, j, i, false, m, (String)localObject4, str1, str2);
          }
          return super.b(paramInt, paramActionSheetItem);
          label983:
          if (paramInt == 5)
          {
            if ((localObject4 != null) && (((String)localObject4).contains("kandianshare.html5.qq.com")))
            {
              BridgeModule.this.mShareHelper.po((String)localObject4);
              continue;
            }
            BridgeModule.this.mShareHelper.po((String)localObject2);
            continue;
          }
          if (paramInt == 4)
          {
            if ((localObject4 != null) && (((String)localObject4).contains("kandianshare.html5.qq.com")))
            {
              BridgeModule.this.mShareHelper.pp((String)localObject4);
              continue;
            }
            BridgeModule.this.mShareHelper.pp((String)localObject2);
            continue;
          }
          if (paramInt == 13) {
            continue;
          }
          if (paramInt == 6)
          {
            localObject2 = (QQAppInterface)kxm.getAppRuntime();
            if (localObject2 == null) {
              continue;
            }
            localObject2 = ((QQAppInterface)localObject2).getAccount();
            localObject3 = this.aI.optString("title");
            localObject4 = this.aI.optString("desc");
            str1 = this.aI.optString("image_url");
            aviz.a(0, (String)localObject3, this.aI.optString("share_url"), null, (String)localObject4, str1, null, null, false, -1L).c((String)localObject2).b((Activity)this.mActivityReference.get(), (String)localObject2, 2, null);
            continue;
          }
          if (paramInt == 11)
          {
            ThreadManager.executeOnSubThread(new BridgeModule.SheetItemClickProcessor.1(this, (String)localObject2));
            continue;
          }
          if (paramInt == 21)
          {
            BridgeModule.this.mShareHelper.bdE();
            continue;
          }
          if (paramInt == 7) {
            continue;
          }
          if (paramInt == 26)
          {
            BridgeModule.this.mShareHelper.pr((String)localObject2);
            continue;
          }
          if (paramInt == 35)
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              continue;
            }
            localObject2 = AddFriendLogicActivity.a((Context)this.mActivityReference.get(), 1, (String)localObject3, null, 3096, 1, this.aI.optString("nick_name"), null, null, null, null);
            ((Activity)this.mActivityReference.get()).startActivity((Intent)localObject2);
            continue;
          }
          if (paramInt == 37)
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              continue;
            }
            localObject2 = wja.a(new Intent((Context)this.mActivityReference.get(), SplashActivity.class), null);
            ((Intent)localObject2).putExtra("uin", (String)localObject3);
            ((Intent)localObject2).putExtra("uintype", 0);
            ((Activity)this.mActivityReference.get()).startActivity((Intent)localObject2);
            continue;
          }
          if (paramInt == 31)
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              continue;
            }
            localObject2 = new Intent((Context)this.mActivityReference.get(), AccountDetailActivity.class);
            ((Intent)localObject2).putExtra("uin", (String)localObject3);
            ((Intent)localObject2).putExtra("from_js", true);
            ((Activity)this.mActivityReference.get()).startActivity((Intent)localObject2);
            continue;
          }
          if (paramInt == 39)
          {
            localObject2 = BridgeModule.this.mShareHelper.a(this.kE, this.kF, paramInt);
            if (!(localObject2 instanceof oaz)) {
              continue;
            }
            localObject2 = ((oaz)localObject2).url;
            BridgeModule.this.saveImageToLocal((String)localObject2);
            continue;
          }
          if (paramInt == 134)
          {
            localObject2 = this.aI.optString("rowkey", "");
            k = this.aI.optInt("from_page");
            if (((String)localObject2).isEmpty())
            {
              QLog.e(BridgeModule.TAG, 1, "click add video to topic fail, rowkey=" + (String)localObject2);
              continue;
            }
            mix.h(BridgeModule.this.getViolaInstance().getActivity(), (String)localObject2, k);
            continue;
          }
          if (paramInt == 133)
          {
            localObject3 = this.aI.optString("rowkey", "");
            localObject4 = this.aI.optString("topicId", "");
            str1 = this.aI.optString("title", "");
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              BridgeModule.this.rijWatchWordPresenter.l((String)localObject3, (String)localObject2, (String)localObject4, str1);
              continue;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              BridgeModule.this.rijWatchWordPresenter.L((String)localObject4, (String)localObject2, str1);
              continue;
            }
            QLog.e(BridgeModule.TAG, 1, "args is illegal: " + this.aI.toString());
            continue;
          }
          localObject2 = null;
          if (paramActionSheetItem.action == 72) {
            localObject2 = paramActionSheetItem.uin;
          }
          BridgeModule.this.mShareUtils.a(this.aI, paramInt, (Activity)this.mActivityReference.get(), (String)localObject2, paramActionSheetItem.uinType, paramActionSheetItem.label);
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.e(BridgeModule.TAG, 1, "processClick error=" + localJSONException2.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule
 * JD-Core Version:    0.7.0.1
 */