package com.tencent.mobileqq.gamecenter.fragment;

import aalb;
import abmt;
import acfp;
import ahrb;
import ahsl;
import ahsm;
import ahso;
import ahsp;
import ahsq;
import ahsr;
import ahss;
import ahst;
import ahsu;
import ahsv;
import ahsx;
import ahta;
import ahtv;
import ahty;
import ahtz;
import ahuh;
import ahup;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import aqgz;
import aqiz;
import aqrb;
import aqrd;
import awoe;
import awok;
import awol;
import awos;
import awot;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.ArkHeaderView;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.view.MoreMsgHeaderView;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView.a;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import tbb;
import wja;

public class QQGamePubAccountFragment
  extends PublicBaseFragment
  implements Handler.Callback, awoe, awos, QQGameStatusView.a, Observer
{
  public static final byte[] ex = new byte[0];
  private RecyclerView A;
  private ImageView An;
  private ImageView Ao;
  private ImageView Ap;
  private View E;
  private ahtv jdField_a_of_type_Ahtv;
  private FeedsItemData.GameInfo jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView;
  QQGameIndicator jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator;
  public QQGamePubViewpager a;
  private QQGameStatusView jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView;
  PagerAdapter c;
  private boolean chY;
  private boolean chZ;
  private boolean cia;
  private ahuh currIHeaderView;
  private ahrb d;
  private aqrd g = new ahsl(this);
  private RelativeLayout kB;
  private RelativeLayout kC;
  private Map<Long, List<FeedsItemData>> kX = new HashMap();
  private Map<Long, Integer> kY = new HashMap();
  private Map<Long, String> kZ = new HashMap();
  private Map<Long, FeedsItemData.TopCardInfo> la = new HashMap();
  Map<String, WadlParams> lb = new HashMap();
  private QQAppInterface mApp;
  public GestureDetector mGestureDetector;
  public List<ahuh> mHeaderRecords = new ArrayList();
  public boolean mIsPause;
  private TextView mTitle;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  private ArrayList<MessageRecord> xb;
  
  private static void A(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramQQAppInterface = "msgPos" + paramQQAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putInt(paramQQAppInterface, paramInt).commit();
  }
  
  private static int N(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getInt("msgPos" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  private void a(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if ("12820".equals(paramString)) {
      if ((paramIntent == null) || (paramLong != 0L) || (paramJSONObject == null)) {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView != null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.hideLoading();
        }
      }
    }
    label864:
    label997:
    label1003:
    do
    {
      String str;
      Object localObject1;
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramIntent = paramIntent.getStringExtra("appid");
              paramString = paramJSONObject.optString("jump_text");
              str = paramJSONObject.optString("tribe_url");
              localObject1 = paramJSONObject.optJSONObject("share_ark");
            } while ((paramJSONObject.optInt("result") != 2) || (this.d == null));
            if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId)) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId.equals(paramIntent)))
            {
              this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameStatus = 2;
              this.d.Kx(true);
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.hideLoading();
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.eO(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, 4);
              this.d.a(paramIntent, paramString, str, (JSONObject)localObject1, wC());
            }
            try
            {
              if (this.kX != null)
              {
                paramString = this.kX.keySet().iterator();
                while (paramString.hasNext())
                {
                  paramLong = ((Long)paramString.next()).longValue();
                  paramJSONObject = (List)this.kX.get(Long.valueOf(paramLong));
                  if ((paramJSONObject != null) && (paramJSONObject.size() > 0) && (!TextUtils.isEmpty(((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameAppId)) && (((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameAppId.equals(paramIntent))) {
                    ((FeedsItemData)paramJSONObject.get(0)).gameInfo.gameStatus = 2;
                  }
                }
                ahtz.b(this.mApp, "sp_key_game_center_feeds_info", this.kX);
              }
            }
            catch (Throwable paramIntent)
            {
              QLog.e("QQGamePubAccountFragment", 1, "savaFeedsData preloadGame error e=" + paramIntent.toString());
              return;
            }
          } while (this.la == null);
          paramString = this.la.keySet().iterator();
          while (paramString.hasNext())
          {
            paramLong = ((Long)paramString.next()).longValue();
            paramJSONObject = (FeedsItemData.TopCardInfo)this.la.get(Long.valueOf(paramLong));
            if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.gameInfo.gameAppId)) && (paramJSONObject.gameInfo.gameAppId.equals(paramIntent))) {
              paramJSONObject.gameInfo.gameStatus = 2;
            }
          }
          ahtz.b(this.mApp, "sp_key_game_center_feeds_topcard_info", this.la);
          return;
        } while ((!"12787".equals(paramString)) || (paramIntent == null));
        l = paramIntent.getLongExtra("msgSeq", 0L);
        paramString = paramIntent.getStringExtra("pa_msgId");
        str = paramIntent.getStringExtra("appId");
        boolean bool2 = paramIntent.getBooleanExtra("fromBottom", true);
        if ((paramLong != 0L) || (paramJSONObject == null)) {
          break label2565;
        }
        paramIntent = new ArrayList();
        localObject1 = new FeedsItemData.TopCardInfo();
        Object localObject2 = paramJSONObject.optJSONArray("feed_list");
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("layer_condition");
        paramJSONObject = paramJSONObject.optJSONObject("top_card");
        Object localObject3;
        Object localObject4;
        int j;
        if (paramJSONObject != null)
        {
          boolean bool1;
          Object localObject6;
          JSONObject localJSONObject2;
          if (paramJSONObject.optInt("top_card_display_flag", 1) == 0)
          {
            bool1 = false;
            ((FeedsItemData.TopCardInfo)localObject1).showTopCard = bool1;
            ((FeedsItemData.TopCardInfo)localObject1).msgId = paramString;
            localObject3 = paramJSONObject.optJSONObject("game_info");
            ((FeedsItemData.TopCardInfo)localObject1).gameInfo = new FeedsItemData.GameInfo();
            if (localObject3 != null)
            {
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameName = ((JSONObject)localObject3).optString("name");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameIcon = ((JSONObject)localObject3).optString("icon");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gamePkgName = ((JSONObject)localObject3).optString("pkg_name");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gamePkgSize = ((JSONObject)localObject3).optInt("pkg_size");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameStatus = ((JSONObject)localObject3).optInt("status");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameApkUrl = ((JSONObject)localObject3).optString("apk_url");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameAppId = ((JSONObject)localObject3).optString("appid");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameVersionCode = ((JSONObject)localObject3).optString("version_code");
              ((FeedsItemData.TopCardInfo)localObject1).gameInfo.gameTicket = ((JSONObject)localObject3).optString("tickets");
            }
            ((FeedsItemData.TopCardInfo)localObject1).actionDesc = paramJSONObject.optString("game_info_text");
            localObject3 = paramJSONObject.optJSONArray("entry_list");
            localObject4 = new FeedsItemData.LabelInfo();
            ((FeedsItemData.TopCardInfo)localObject1).labelInfos = new ArrayList();
            if (paramJSONObject.optInt("friend_display_flag", 1) != 0) {
              break label997;
            }
            bool1 = false;
            ((FeedsItemData.LabelInfo)localObject4).showFriend = bool1;
            if (!((FeedsItemData.LabelInfo)localObject4).showFriend) {
              break label1084;
            }
            ((FeedsItemData.LabelInfo)localObject4).isFriend = true;
            ((FeedsItemData.LabelInfo)localObject4).friendType = paramJSONObject.optInt("friend_type");
            ((FeedsItemData.LabelInfo)localObject4).friendNum = paramJSONObject.optInt("game_friend_total_num");
            ((FeedsItemData.LabelInfo)localObject4).reportId = "10001";
            localObject5 = paramJSONObject.optJSONArray("friend_list");
            localObject6 = new ArrayList();
            if ((localObject5 == null) || (((JSONArray)localObject5).length() <= 0)) {
              break label1071;
            }
            i = 0;
            j = ((JSONArray)localObject5).length();
            if (i >= j) {
              break label1064;
            }
            localJSONObject2 = ((JSONArray)localObject5).optJSONObject(i);
            if (localJSONObject2 != null) {
              break label1003;
            }
          }
          for (;;)
          {
            i += 1;
            break label961;
            bool1 = true;
            break;
            bool1 = true;
            break label864;
            FeedsItemData.FriendInfo localFriendInfo = new FeedsItemData.FriendInfo();
            localFriendInfo.icon = localJSONObject2.optString("icon");
            localFriendInfo.name = localJSONObject2.optString("name");
            localFriendInfo.uin = localJSONObject2.optString("uin");
            ((List)localObject6).add(localFriendInfo);
          }
          ((FeedsItemData.LabelInfo)localObject4).friendList = ((List)localObject6);
          ((FeedsItemData.TopCardInfo)localObject1).labelInfos.add(localObject4);
          Object localObject5 = paramJSONObject.optJSONObject("friend_red_point");
          ((FeedsItemData.LabelInfo)localObject4).redInfo = new FeedsItemData.RedInfo();
          if (localObject5 != null)
          {
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointId = ((JSONObject)localObject5).optString("red_point_id");
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointStartTime = ((JSONObject)localObject5).optLong("begin_time");
            ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointEndTime = ((JSONObject)localObject5).optLong("end_time");
          }
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              localObject5 = ((JSONArray)localObject3).optJSONObject(i);
              if (localObject5 == null) {}
              for (;;)
              {
                i += 1;
                break;
                localObject4 = new FeedsItemData.LabelInfo();
                ((FeedsItemData.LabelInfo)localObject4).iconUrl = ((JSONObject)localObject5).optString("entry_icon");
                ((FeedsItemData.LabelInfo)localObject4).name = ((JSONObject)localObject5).optString("entry_name");
                ((FeedsItemData.LabelInfo)localObject4).jumpUrl = ((JSONObject)localObject5).optString("entry_url");
                ((FeedsItemData.LabelInfo)localObject4).desc = ((JSONObject)localObject5).optString("entry_text");
                ((FeedsItemData.LabelInfo)localObject4).reportId = ((JSONObject)localObject5).optString("report_id");
                ((FeedsItemData.LabelInfo)localObject4).msgId = paramString;
                ((FeedsItemData.LabelInfo)localObject4).appId = str;
                localObject6 = ((JSONObject)localObject5).optJSONObject("red_point");
                ((FeedsItemData.LabelInfo)localObject4).redInfo = new FeedsItemData.RedInfo();
                if (localObject6 != null)
                {
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointId = ((JSONObject)localObject6).optString("red_point_id");
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointStartTime = ((JSONObject)localObject6).optLong("begin_time");
                  ((FeedsItemData.LabelInfo)localObject4).redInfo.redPointEndTime = ((JSONObject)localObject6).optLong("end_time");
                }
                localObject5 = ((JSONObject)localObject5).optJSONArray("entry_icon_list");
                ((FeedsItemData.LabelInfo)localObject4).icons = new ArrayList();
                if (localObject5 != null)
                {
                  j = 0;
                  if (j < ((JSONArray)localObject5).length())
                  {
                    localObject6 = ((JSONArray)localObject5).optJSONObject(j);
                    if (localObject6 == null) {}
                    for (;;)
                    {
                      j += 1;
                      break;
                      ((FeedsItemData.LabelInfo)localObject4).icons.add(((JSONObject)localObject6).optString("entry_icon"));
                    }
                  }
                }
                ((FeedsItemData.TopCardInfo)localObject1).labelInfos.add(localObject4);
              }
            }
          }
          paramJSONObject = paramJSONObject.optJSONObject("banner");
          if (paramJSONObject != null)
          {
            ((FeedsItemData.TopCardInfo)localObject1).bannerIconZip = paramJSONObject.optString("banner_icon_zip");
            ((FeedsItemData.TopCardInfo)localObject1).bannerGap = paramJSONObject.optInt("banner_gap", 60);
            ((FeedsItemData.TopCardInfo)localObject1).bannerUrl = paramJSONObject.optString("banner_url");
            ((FeedsItemData.TopCardInfo)localObject1).bannerBeginTime = paramJSONObject.optLong("begin_time", 0L);
            ((FeedsItemData.TopCardInfo)localObject1).bannerEndTime = paramJSONObject.optLong("end_time", 0L);
          }
        }
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          j = ((JSONArray)localObject2).length();
          while (i < j)
          {
            paramJSONObject = new FeedsItemData();
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 == null)
            {
              i += 1;
            }
            else
            {
              localObject4 = ((JSONObject)localObject3).optJSONObject("feed_info");
              paramJSONObject.msgId = paramString;
              paramJSONObject.authorName = ((JSONObject)localObject4).optString("anchor_name");
              paramJSONObject.authorIcon = ((JSONObject)localObject4).optString("anchor_icon");
              paramJSONObject.type = ((JSONObject)localObject4).optInt("feed_type");
              paramJSONObject.feedId = ((JSONObject)localObject4).optString("feed_id");
              paramJSONObject.coverImgUrl = ((JSONObject)localObject4).optString("cover_url");
              paramJSONObject.commentNum = ((JSONObject)localObject4).optInt("comment_num");
              paramJSONObject.title = ((JSONObject)localObject4).optString("title");
              paramJSONObject.jumpUrl = ((JSONObject)localObject4).optString("jump_url");
              paramJSONObject.algorithmId = ((JSONObject)localObject4).optString("algorithm_id");
              if (paramJSONObject.type == 1)
              {
                paramJSONObject.videoUrl = ((JSONObject)localObject4).optString("live_stream_url");
                paramJSONObject.videoViewers = ((JSONObject)localObject4).optInt("live_online_num");
                paramJSONObject.videoSrcName = ((JSONObject)localObject4).optString("video_source");
                paramJSONObject.videoSrcImg = ((JSONObject)localObject4).optString("video_source_icon");
              }
              for (;;)
              {
                paramJSONObject.viewersNum = ((JSONObject)localObject4).optInt("vv");
                localObject3 = ((JSONObject)localObject3).optJSONObject("game_info");
                paramJSONObject.gameInfo = new FeedsItemData.GameInfo();
                paramJSONObject.gameInfo.gameName = ((JSONObject)localObject3).optString("name");
                paramJSONObject.gameInfo.gameIcon = ((JSONObject)localObject3).optString("icon");
                paramJSONObject.gameInfo.gamePkgName = ((JSONObject)localObject3).optString("pkg_name");
                paramJSONObject.gameInfo.gamePkgSize = ((JSONObject)localObject3).optInt("pkg_size");
                paramJSONObject.gameInfo.gameStatus = ((JSONObject)localObject3).optInt("status");
                paramJSONObject.gameInfo.gameApkUrl = ((JSONObject)localObject3).optString("apk_url");
                paramJSONObject.gameInfo.gameAppId = ((JSONObject)localObject3).optString("appid");
                paramJSONObject.gameInfo.gameVersionCode = ((JSONObject)localObject3).optString("version_code");
                paramJSONObject.gameInfo.gameTicket = ((JSONObject)localObject3).optString("tickets");
                paramIntent.add(paramJSONObject);
                break;
                if (paramJSONObject.type == 2)
                {
                  paramJSONObject.videoUrl = ((JSONObject)localObject4).optString("video_url");
                  paramJSONObject.videoDuration = ((JSONObject)localObject4).optInt("video_duration");
                  paramJSONObject.videoSrcType = ((JSONObject)localObject4).optInt("video_source_type");
                  paramJSONObject.videoVid = ((JSONObject)localObject4).optString("video_vid");
                }
              }
            }
          }
        }
        if (localJSONObject1 != null)
        {
          ahty.dbb = localJSONObject1.optInt("video_count");
          ahty.dbc = localJSONObject1.optInt("video_time") * 1000;
          ahty.dbd = localJSONObject1.optInt("layer_duration") * 1000;
          if (getActivity() != null)
          {
            paramJSONObject = getActivity().getSharedPreferences("game_center_sp", 0);
            localObject2 = "sp_key_game_center_feeds_float_condition" + this.mApp.getCurrentAccountUin();
            paramJSONObject.edit().putString((String)localObject2, localJSONObject1.toString()).commit();
          }
        }
        if (!bool2) {
          break;
        }
        if (paramIntent.size() == 0)
        {
          tbb.a(abmt.getAppInterface(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
          this.d.cd(false, true);
          return;
        }
        paramString = (List)this.kX.get(Long.valueOf(l));
        paramString.addAll(paramIntent);
        this.kX.put(Long.valueOf(l), paramString);
        i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      } while ((this.xb == null) || (i >= this.xb.size()) || (((MessageRecord)this.xb.get(i)).uniseq != l));
      this.d.aGQ();
      this.d.ca(paramIntent);
      return;
      this.la.put(Long.valueOf(l), localObject1);
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (paramIntent.size() == 0)
      {
        this.kZ.put(Long.valueOf(l), ahtz.bLL);
        this.d.cd(false, false);
        tbb.a(abmt.getAppInterface(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      }
      for (;;)
      {
        this.kX.put(Long.valueOf(l), paramIntent);
        if ((this.xb == null) || (i >= this.xb.size()) || (((MessageRecord)this.xb.get(i)).uniseq != l)) {
          break;
        }
        this.d.a(paramIntent, (FeedsItemData.TopCardInfo)localObject1);
        a((FeedsItemData.TopCardInfo)localObject1);
        return;
        this.kZ.put(Long.valueOf(l), ahtz.bLK);
        this.d.cd(false, false);
      }
      tbb.a(abmt.getAppInterface(), "769", "205353", str, "76901", "1", "160", new String[] { paramString, "", "20" });
      QLog.e("QQGamePubAccountFragment", 1, "[onGetGameCenterPubAccountFeeds] get feeds fail.");
      i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.xb != null) && (i < this.xb.size()) && (((MessageRecord)this.xb.get(i)).uniseq == l))
      {
        this.d.cd(false, false);
        this.kZ.put(Long.valueOf(l), ahtz.bLL);
      }
    } while (getActivity() == null);
    label961:
    QQToast.a(getActivity(), acfp.m(2131711712), 0).show();
    label1064:
    label1071:
    label1084:
    return;
  }
  
  private void a(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(8);
        if ((paramTopCardInfo == null) || (paramTopCardInfo.gameInfo == null) || (TextUtils.isEmpty(paramTopCardInfo.gameInfo.gameAppId))) {
          break;
        }
        Object localObject = paramTopCardInfo.gameInfo;
        String[] arrayOfString;
        if ((paramTopCardInfo.priorities != null) && (paramTopCardInfo.priorities.size() > 0))
        {
          arrayOfString = new String[paramTopCardInfo.priorities.size()];
          paramTopCardInfo.priorities.toArray(arrayOfString);
          QQGameStatusView localQQGameStatusView = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView;
          String str1 = paramTopCardInfo.gameInfo.gameAppId;
          String str2 = ((FeedsItemData.GameInfo)localObject).gameIcon;
          localObject = ((FeedsItemData.GameInfo)localObject).gameName;
          if (paramTopCardInfo.prioritiesIconFlag == 1)
          {
            localQQGameStatusView.a(str1, str2, (String)localObject, arrayOfString, 100, bool);
            if (isAdded())
            {
              if (getResources() != null) {
                ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView, "translationY", new float[] { wja.dp2px(70.0F, getResources()), 0.0F }).setDuration(500L).start();
              }
              this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(0);
            }
            b(paramTopCardInfo);
          }
        }
        else
        {
          arrayOfString = new String[1];
          arrayOfString[0] = paramTopCardInfo.actionDesc;
          continue;
        }
        bool = false;
      }
      catch (Throwable paramTopCardInfo)
      {
        paramTopCardInfo.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setVisibility(8);
  }
  
  private void b(FeedsItemData.TopCardInfo paramTopCardInfo)
  {
    paramTopCardInfo = paramTopCardInfo.gameInfo;
    if (!paramTopCardInfo.gameAppId.equals(b().gameAppId)) {
      return;
    }
    if (b().gameStatus == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.eO(paramTopCardInfo.gameAppId, 3);
      return;
    }
    if (b().gameStatus == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.eO(paramTopCardInfo.gameAppId, 4);
      return;
    }
    if (aqiz.isAppInstalled(this.E.getContext(), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.eO(paramTopCardInfo.gameAppId, 1);
      return;
    }
    U(new String[] { paramTopCardInfo.gameAppId });
  }
  
  private void dpG()
  {
    int i;
    if (this.mHeaderRecords != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mHeaderRecords.size())
        {
          if ((this.mHeaderRecords.get(i) instanceof ArkHeaderView))
          {
            ((ArkHeaderView)this.mHeaderRecords.get(i)).destroy();
            if (QLog.isColorLevel()) {
              QLog.d("QQGamePubAccountFragment", 2, "header destroy i=" + i);
            }
          }
        }
        else
        {
          this.mHeaderRecords.clear();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGamePubAccountFragment", 1, "header destroy error=" + localThrowable.toString());
        return;
      }
      i += 1;
    }
  }
  
  private void dpJ()
  {
    awok.eEF();
    awok.a(this);
  }
  
  private void dpK()
  {
    awok.b(this);
  }
  
  public void KA(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.2(this, paramBoolean));
  }
  
  public void KB(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.cia)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 1, "isLoadMoreing:" + this.cia);
      }
    }
    label338:
    do
    {
      do
      {
        return;
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("QQGamePubAccountFragment", 1, "get more data isLoadMoreing:" + this.cia);
        }
        this.cia = true;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null) {}
        MessageRecord localMessageRecord;
        ArrayList localArrayList;
        for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem())
        {
          if ((this.xb == null) || (this.xb.size() <= i)) {
            break label338;
          }
          localMessageRecord = (MessageRecord)this.xb.get(i);
          localArrayList = new ArrayList();
          localObject1 = (List)this.kX.get(Long.valueOf(localMessageRecord.uniseq));
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FeedsItemData)((Iterator)localObject1).next();
            if (((FeedsItemData)localObject2).type != 100) {
              localArrayList.add(((FeedsItemData)localObject2).feedId);
            }
          }
        }
        Object localObject1 = (aqrb)this.mApp.getBusinessHandler(71);
        Object localObject2 = ahtz.b((MessageRecord)this.xb.get(i), 0);
        String str = ahtz.b((MessageRecord)this.xb.get(i), 2);
        ((aqrb)localObject1).a(ahtz.t(localMessageRecord), localMessageRecord.uniseq, localMessageRecord.time, localArrayList, paramBoolean, (String)localObject2, str);
      } while (this.d == null);
      if (!paramBoolean)
      {
        this.d.cd(true, false);
        return;
      }
      this.d.cd(true, false);
      return;
    } while ((this.d == null) || (paramBoolean));
    this.d.cd(false, false);
  }
  
  public void KC(String paramString)
  {
    QQToast.a(getActivity(), acfp.m(2131711730), 0).show();
    ahty.a(getActivity(), b());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.eO(paramString, 5);
    paramString = new HashMap();
    paramString.put(Integer.valueOf(2), wC());
    paramString.put(Integer.valueOf(4), "1");
    tbb.a(abmt.getAppInterface(), "769", "205612", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
  }
  
  public void KD(String paramString)
  {
    if (b().gameAppId.equals(paramString))
    {
      ahtz.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gamePkgName, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameTicket, getActivity());
      paramString = new HashMap(10);
      paramString.put(Integer.valueOf(2), wC());
      paramString.put(Integer.valueOf(6), b().gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      tbb.a(abmt.getAppInterface(), "769", "205613", b().gameAppId, "76903", "1", "160", paramString);
    }
  }
  
  public void KE(String paramString)
  {
    if ((b().gameAppId.equals(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameStatus == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.showLoading();
      awot.a().jH(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "10000144");
      paramString = new HashMap();
      tbb.b(paramString, wC());
      paramString.put(Integer.valueOf(2), wC());
      paramString.put(Integer.valueOf(6), this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId);
      paramString.put(Integer.valueOf(4), "20");
      paramString.put(Integer.valueOf(18), "GameAIO");
      paramString.put(Integer.valueOf(35), "10000144");
      tbb.a(abmt.getAppInterface(), "769", "205610", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString);
    }
  }
  
  public void KF(String paramString)
  {
    paramString = "";
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) {
      paramString = en(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem());
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("title", acfp.m(2131711735));
    localIntent.putExtra("selfSet_leftViewText", getString(2131691039));
    localIntent.putExtra("url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
    startActivity(localIntent);
    tbb.a(abmt.getAppInterface(), "769", "205018", paramString, "76902", "1", "160", new String[] { "", "", "" });
  }
  
  public void U(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      awok.eEF();
      ArrayList localArrayList = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramVarArgs[i]);
        i += 1;
      }
      awok.a().a(this);
      awok.a().fz(localArrayList);
    }
  }
  
  public void a(FeedsItemData.GameInfo paramGameInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo = paramGameInfo;
  }
  
  public FeedsItemData.GameInfo b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo = new FeedsItemData.GameInfo();
    }
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo;
  }
  
  public void bU(Activity paramActivity)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("qqgame_enter", 1);
      String str = getString(2131697440);
      aalb.a(paramActivity, (QQAppInterface)abmt.getAppInterface(), "2747277822", 1008, str, true, localBundle);
      return;
    }
    catch (Throwable paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQGamePubAccountFragment", 1, "enterHistory fail :" + paramActivity.getMessage());
    }
  }
  
  public View ci()
  {
    if (this.xb.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 2, "no msg createEmptyView");
      }
      return createEmptyView();
    }
    View localView = LayoutInflater.from(getActivity()).inflate(2131559366, null, false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager = ((QQGamePubViewpager)localView.findViewById(2131366996));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator = ((QQGameIndicator)localView.findViewById(2131372828));
    this.Ap = ((ImageView)localView.findViewById(2131377436));
    this.An = ((ImageView)localView.findViewById(2131370479));
    this.Ao = ((ImageView)localView.findViewById(2131370484));
    this.Ap.setImageDrawable(ahtz.a(null, null, "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png", "https://i.gtimg.cn/channel/imglib/202004/upload_a0fdb03e7c5c42246be0bf79cce9958f.png"));
    this.Ap.setOnClickListener(new ahso(this));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setNestedpParent(this.A);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setOffscreenPageLimit(10);
    dpF();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setAdapter(this.c);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.refreshIndicator();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setPageListener(new ahsp(this));
    int i = N(this.mApp);
    if (i >= this.xb.size()) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahtv != null) {
        if (i != 0) {
          break label408;
        }
      }
      label408:
      for (this.jdField_a_of_type_Ahtv.cii = true;; this.jdField_a_of_type_Ahtv.cii = false)
      {
        if (this.chY)
        {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i);
          if (i < this.mHeaderRecords.size()) {
            this.currIHeaderView = ((ahuh)this.mHeaderRecords.get(i));
          }
        }
        dpH();
        if (i == 0)
        {
          tbb.a(abmt.getAppInterface(), "769", "205017", en(0), "76901", "1", "160", new String[] { ahtz.t((MessageRecord)this.xb.get(0)), "0", "8" });
          ((aqrb)this.mApp.getBusinessHandler(71)).X(2, ((MessageRecord)this.xb.get(0)).getExtInfoFromExtStr("pa_msgId"), "");
        }
        return localView;
      }
    }
  }
  
  public View createEmptyView()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131559371, this.A, false);
    ((ImageView)localView.findViewById(2131366418)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_no_message@2x.png"));
    return localView;
  }
  
  public ArrayList<MessageRecord> dg()
  {
    Object localObject1 = ((QQAppInterface)abmt.getAppInterface()).b().i("2747277822", 1008, 10);
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      i = ((List)localObject1).size() - 1;
    }
    for (;;)
    {
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ("2747277822".equals(((MessageRecord)localObject2).frienduin))
        {
          if (((localObject2 instanceof MessageForArkApp)) || ((localObject2 instanceof MessageForPubAccount)) || ((localObject2 instanceof MessageForStructing))) {
            localArrayList.add(localObject2);
          }
          if (localArrayList.size() != 3) {}
        }
      }
      else
      {
        this.mHeaderRecords.clear();
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          ahtz.b((MessageRecord)localObject2, 0);
          localObject2 = ahup.a((MessageRecord)localObject2, getActivity());
          this.mHeaderRecords.add(localObject2);
        }
      }
      i -= 1;
    }
    this.mHeaderRecords.add(new MoreMsgHeaderView(getActivity()));
    return localArrayList;
  }
  
  public void dpD()
  {
    Object localObject = abmt.getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((AppInterface)localObject).getManager(13);
      if (localObject != null) {
        ((WebProcessManager)localObject).egu();
      }
      localObject = new Intent(getActivity(), WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      getActivity().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    }
  }
  
  public void dpE()
  {
    localLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.A.setLayoutManager(localLinearLayoutManager);
    this.A.setItemAnimator(null);
    localLinearLayoutManager.setOrientation(1);
    this.xb = dg();
    if ((this.xb != null) && (this.xb.size() > 0)) {
      this.jdField_a_of_type_Ahtv = new ahtv(getActivity(), (MessageRecord)this.xb.get(0));
    }
    this.kX = new HashMap();
    this.kY = new HashMap();
    this.chY = false;
    try
    {
      ahty.cX(this.mApp);
      localObject3 = (Queue)ahtz.a(this.mApp, "sp_key_game_center_feeds_red_dot_status");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayDeque(100);
      }
      ahtz.H = (Queue)localObject1;
      localObject1 = (Map)ahtz.a(this.mApp, "sp_key_game_center_feeds_info");
      if (localObject1 == null) {
        break label270;
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        int i;
        label270:
        long l;
        Object localObject4;
        localException.printStackTrace();
        this.d = new ahrb(getActivity(), this.mApp, this);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView = new GameSessionView(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.i(this.mApp);
        this.d.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView);
        this.d.addHeaderView(ci());
        this.mApp.addObserver(this.g);
        this.d.dps();
        this.d.cmZ();
        Object localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager == null)
        {
          i = 0;
          if ((this.xb == null) || (this.xb.size() <= i)) {
            break label1012;
          }
          localObject2 = (MessageRecord)this.xb.get(i);
          localObject3 = (List)this.kX.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          localObject4 = (FeedsItemData.TopCardInfo)this.la.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
          this.d.a((List)localObject3, (FeedsItemData.TopCardInfo)localObject4);
          a((FeedsItemData.TopCardInfo)localObject4);
          GameCenterVideoViewController.daZ = 0;
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break label1004;
          }
          if (this.kY.containsKey(Long.valueOf(((MessageRecord)localObject2).uniseq)))
          {
            localObject3 = (Integer)this.kY.get(Long.valueOf(((MessageRecord)localObject2).uniseq));
            this.A.scrollToPosition(((Integer)this.kY.get(Long.valueOf(((MessageRecord)localObject2).uniseq))).intValue());
            if (((Integer)localObject3).intValue() == 0) {
              ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGamePubAccountFragment.8(this), 1000L);
            }
          }
        }
        for (;;)
        {
          this.A.setAdapter(this.d);
          this.A.setOnScrollListener(new ahsv(this, localLinearLayoutManager));
          return;
          localObject2 = (Map)ahtz.a(this.mApp, "sp_key_game_center_feeds_topcard_info");
          if (localObject2 != null)
          {
            localObject3 = ((Map)localObject2).keySet().iterator();
            for (;;)
            {
              if (!((Iterator)localObject3).hasNext()) {
                break label872;
              }
              l = ((Long)((Iterator)localObject3).next()).longValue();
              localObject4 = this.xb.iterator();
              if (((Iterator)localObject4).hasNext())
              {
                if (((MessageRecord)((Iterator)localObject4).next()).uniseq != l) {
                  break;
                }
                this.la.put(Long.valueOf(l), ((Map)localObject2).get(Long.valueOf(l)));
              }
            }
          }
          localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).getString("sp_key_game_center_feeds_float_condition" + this.mApp.getCurrentAccountUin(), "");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new JSONObject((String)localObject2);
            ahty.dbb = ((JSONObject)localObject2).optInt("video_count");
            ahty.dbc = ((JSONObject)localObject2).optInt("video_time") * 1000;
            ahty.dbd = ((JSONObject)localObject2).optInt("layer_duration") * 1000;
            break;
          }
          QLog.e("QQGamePubAccountFragment", 1, "[initFeeds] condition is null");
          break;
          i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
          break label511;
          KB(false);
          continue;
          if ((this.xb == null) || (this.xb.size() == 0)) {
            KA(true);
          } else {
            KB(false);
          }
        }
        i += 1;
      }
    }
    if (i < this.xb.size())
    {
      localObject3 = (MessageRecord)this.xb.get(i);
      if (((Map)localObject1).containsKey(Long.valueOf(((MessageRecord)localObject3).uniseq)))
      {
        this.kX.put(Long.valueOf(((MessageRecord)localObject3).uniseq), ((Map)localObject1).get(Long.valueOf(((MessageRecord)localObject3).uniseq)));
        if (i == 0) {
          this.chY = true;
        }
      }
    }
    else
    {
      localObject1 = (Map)ahtz.a(this.mApp, "sp_key_game_center_feeds_position");
      if (localObject1 != null)
      {
        localObject3 = ((Map)localObject1).keySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label749;
          }
          l = ((Long)((Iterator)localObject3).next()).longValue();
          localObject4 = this.xb.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            if (((MessageRecord)((Iterator)localObject4).next()).uniseq != l) {
              break;
            }
            this.kY.put(Long.valueOf(l), ((Map)localObject1).get(Long.valueOf(l)));
          }
        }
      }
    }
  }
  
  public void dpF()
  {
    this.c = new ahsm(this);
  }
  
  public void dpH()
  {
    if ((this.An == null) || (this.Ao == null)) {
      return;
    }
    if ((this.xb == null) || (this.xb.size() == 0))
    {
      this.An.setVisibility(8);
      this.Ao.setVisibility(8);
      return;
    }
    this.An.setVisibility(0);
    this.Ao.setVisibility(0);
    int i = (int)((float)(aqgz.getWidth() / 2L) - this.xb.size() * 10 * aqgz.density / 2.0F - 8.0F * aqgz.density);
    this.An.getLayoutParams().width = i;
    this.Ao.getLayoutParams().width = i;
  }
  
  public void dpI()
  {
    if (this.A != null) {
      this.A.smoothScrollToPosition(0);
    }
  }
  
  public String en(int paramInt)
  {
    if ((this.xb != null) && (paramInt < this.xb.size())) {
      return ahtz.b((MessageRecord)this.xb.get(paramInt), 0);
    }
    return null;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("12820");
    localHashSet.add("12787");
    return localHashSet;
  }
  
  public void gj(String paramString1, String paramString2)
  {
    paramString1 = (WadlParams)this.lb.get(paramString1);
    if (paramString1 != null) {
      ahty.d(paramString1);
    }
    for (;;)
    {
      paramString1 = new HashMap();
      paramString1.put(Integer.valueOf(2), wC());
      paramString1.put(Integer.valueOf(4), "2");
      tbb.a(abmt.getAppInterface(), "769", "205611", this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData$GameInfo.gameAppId, "76903", "1", "160", paramString1);
      return;
      QQToast.a(getActivity(), acfp.m(2131711733), 0).show();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.kB.setVisibility(8);
    }
  }
  
  public void initTitle(View paramView)
  {
    paramView = (NavBarCommon)paramView.findViewById(2131377361);
    paramView.setBackgroundColor(0);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369967);
    paramView.setRightImage(getResources().getDrawable(2130851146));
    localImageView.setImageResource(2130851759);
    this.mTitle = ((TextView)paramView.findViewById(2131369627));
    this.mTitle.setText(2131697440);
    this.mTitle.setTextColor(-1);
    paramView.setOnItemSelectListener(new ahss(this));
    initTitleEvent();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void initTitleEvent()
  {
    this.mGestureDetector = new GestureDetector(getActivity(), new ahst(this));
    this.mTitle.setOnTouchListener(new ahsu(this));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public boolean onBackEvent()
  {
    if (this.kC != null)
    {
      ((FrameLayout)getActivity().getWindow().getDecorView()).removeView(this.kC);
      this.kC = null;
      return true;
    }
    GameCenterVideoViewController localGameCenterVideoViewController = ahsx.a().a();
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.isFullScreenMode()))
    {
      localGameCenterVideoViewController.aUp();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.14(this, paramIntent, paramString, paramLong, paramJSONObject));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApp = ((QQAppInterface)getActivity().getAppInterface());
    ((WebProcessManager)this.mApp.getManager(13)).egu();
    ((ahta)this.mApp.getManager(358)).dpY();
    ahtz.cij = true;
    paramBundle = new HashMap();
    paramBundle.put(Integer.valueOf(4), "8");
    tbb.a(abmt.getAppInterface(), "769", "205838", "", "76902", "160", "1", paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.E = paramLayoutInflater.inflate(2131559370, paramViewGroup, false);
    paramLayoutInflater = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenterBackground.png");
    paramViewGroup = (ImageView)this.E.findViewById(2131363236);
    paramViewGroup.setScaleType(ImageView.ScaleType.FIT_START);
    paramViewGroup.setImageDrawable(paramLayoutInflater);
    if (!anlm.ayn())
    {
      getActivity().mSystemBarComp = null;
      getActivity().setImmersiveStatus(0);
    }
    initTitle(this.E);
    dpD();
    this.xb = dg();
    this.A = ((RecyclerView)this.E.findViewById(2131366997));
    this.kB = ((RelativeLayout)this.E.findViewById(2131372310));
    this.An = ((ImageView)this.E.findViewById(2131370479));
    this.Ao = ((ImageView)this.E.findViewById(2131370484));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView = ((QQGameStatusView)this.E.findViewById(2131381916));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView.setListener(this);
    dpJ();
    dpE();
    if (this.jdField_a_of_type_Ahtv != null) {
      this.jdField_a_of_type_Ahtv.u(this.E);
    }
    awot.a().a(this);
    ((QQAppInterface)abmt.getAppInterface()).b().addObserver(this);
    ((ImageView)this.E.findViewById(2131372309)).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_newMsg_normal@2x.png"));
    this.kB.setOnClickListener(new ahsq(this));
    paramLayoutInflater = this.mApp.getApp().getSharedPreferences("game_center_sp", 0);
    paramViewGroup = "sp_key_game_center_guide_is_show" + this.mApp.getCurrentAccountUin();
    if (!paramLayoutInflater.getBoolean(paramViewGroup, false))
    {
      this.kC = new RelativeLayout(getActivity());
      paramBundle = new URLImageView(getActivity());
      URLImageView localURLImageView = new URLImageView(getActivity());
      Object localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_guid_rightscroll.png");
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_guid_upscroll.png");
      paramBundle.setImageDrawable((Drawable)localObject1);
      localURLImageView.setImageDrawable((Drawable)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(wja.dp2px(220.0F, getResources()), wja.dp2px(220.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject1).topMargin = wja.dp2px(150.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      localObject2 = new RelativeLayout.LayoutParams(wja.dp2px(160.0F, getResources()), wja.dp2px(100.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = wja.dp2px(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.kC.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
      this.kC.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
      this.kC.setBackgroundColor(-1358954496);
      paramBundle = (FrameLayout)getActivity().getWindow().getDecorView();
      paramBundle.addView(this.kC, new FrameLayout.LayoutParams(-1, -1));
      this.kC.setOnClickListener(new ahsr(this, paramBundle));
      paramLayoutInflater.edit().putBoolean(paramViewGroup, true).commit();
    }
    paramLayoutInflater = this.E;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awot.a().b(this);
    if (this.mApp != null) {
      this.mApp.removeObserver(this.g);
    }
    try
    {
      ahtz.b(this.mApp, "sp_key_game_center_feeds_position", this.kY);
      ahtz.b(this.mApp, "sp_key_game_center_feeds_topcard_info", this.la);
      ahtz.b(this.mApp, "sp_key_game_center_feeds_info", this.kX);
      ahtz.b(this.mApp, "sp_key_game_center_feeds_red_dot_status", ahtz.H);
      ((ahta)this.mApp.getManager(358)).Pr(0);
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.onDestory();
      }
      ahsx.a().cOC();
      this.mUiHandler.removeCallbacksAndMessages(null);
      if (this.d != null) {
        this.d.clear();
      }
      dpG();
      dpK();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    try
    {
      ((QQAppInterface)abmt.getAppInterface()).b().deleteObserver(this);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    GameCenterVideoViewController localGameCenterVideoViewController = ahsx.a().a();
    if (localGameCenterVideoViewController != null) {
      localGameCenterVideoViewController.pause();
    }
    this.mIsPause = true;
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onPause();
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 0)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.16(this, paramArrayList));
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onResume()
  {
    super.onResume();
    QLog.e("QQGamePubAccountFragment", 1, "[onResume] show floatButton.");
    this.mIsPause = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameStatusView != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if ((this.xb != null) && (i < this.xb.size()))
      {
        FeedsItemData.TopCardInfo localTopCardInfo = (FeedsItemData.TopCardInfo)this.la.get(Long.valueOf(((MessageRecord)this.xb.get(i)).uniseq));
        if (localTopCardInfo != null) {
          a(localTopCardInfo);
        }
      }
    }
    ((ahta)this.mApp.getManager(358)).Pr(0);
    this.mApp.b().a("2747277822", 1008, true, true);
    if (this.currIHeaderView != null) {
      this.currIHeaderView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.xb != null) && (this.xb.size() > 0) && (this.jdField_a_of_type_Ahtv != null)) {
      this.jdField_a_of_type_Ahtv.a(this.mApp, (MessageRecord)this.xb.get(0), null);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePubAccountFragment", 1, "onWadlTaskStatusChanged taskStatus is :" + paramWadlResult.bBa);
      }
    } while ((paramWadlResult.bBa == 9) || (paramWadlResult.bBa == 10) || (paramWadlResult.bBa == 11) || (paramWadlResult.bBa == 2) || (paramWadlResult.bBa == 13));
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.15(this, paramWadlResult));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof MessageRecord)) {}
    do
    {
      return;
      paramObservable = (MessageRecord)paramObject;
    } while ((!"2747277822".equals(paramObservable.frienduin)) || ((!(paramObservable instanceof MessageForArkApp)) && (!(paramObservable instanceof MessageForPubAccount)) && (!(paramObservable instanceof MessageForStructing))) || (this.xb == null) || (this.xb.size() >= 5));
    ThreadManagerV2.getUIHandlerV2().post(new QQGamePubAccountFragment.10(this, paramObservable));
  }
  
  public String wC()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager != null) && (this.xb != null) && (this.xb.size() > 0))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
      if (i < this.xb.size()) {
        return ahtz.t((MessageRecord)this.xb.get(i));
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment
 * JD-Core Version:    0.7.0.1
 */