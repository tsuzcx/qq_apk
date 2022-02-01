package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anre;
import aqdf;
import aqfo;
import aqho;
import aqiw;
import ausj;
import awit;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.c;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jqc;
import kbp;
import kji;
import kjj;
import kjk;
import kjl;
import kjm;
import kwz;
import kxa;
import kxm;
import lbz;
import lcc;
import lce;
import lgd;
import mdn;
import mgu;
import mih;
import mih.b;
import mrr;
import mso;
import mst;
import muj;
import myc.b;
import mye;
import mye.a;
import mye.b;
import myi;
import mza;
import mza.b;
import mza.c;
import mzj;
import nce;
import nce.a;
import ndh;
import ndi;
import ndi.c;
import nha;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import sum;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, ReadInJoyBaseListView.c, AbsListView.e, myc.b, mye.a, mza.b, mza.c, ndi.c
{
  private ausj B;
  protected aqdf a;
  public ReadInJoyXListView a;
  public kxa a;
  private mdn jdField_a_of_type_Mdn;
  private mso jdField_a_of_type_Mso;
  private mst jdField_a_of_type_Mst;
  private mye jdField_a_of_type_Mye;
  private mza jdField_a_of_type_Mza;
  private int aIz = 1;
  private boolean aeL;
  private boolean aeM;
  private boolean afL;
  private boolean afM;
  private boolean afN;
  private boolean afO;
  private ndi b;
  private Map<Integer, Set<Long>> dB = new HashMap();
  public Map<Integer, Boolean> dC = new HashMap();
  private Map<Integer, Map<Long, mgu>> dD = new HashMap();
  private int[] dc = new int[2];
  private int[] dd = new int[2];
  private RelativeLayout eE;
  private ImageView ic;
  private ImageView id;
  private View jH;
  private int mChannelID = -1;
  private String mChannelName;
  private int mChannelType = -1;
  public int mColumnType = 1;
  protected lce mObserver = new kjj(this);
  private RIJRedPacketProgressView mRedPacketProgressView;
  private RelativeLayout mRoot;
  private ViewGroup mTitleBar;
  private TextView mTitleText;
  private TextView nV;
  private TextView nW;
  private TextView nX;
  private TextView nY;
  private TextView nZ;
  private TextView oa;
  protected long sd;
  
  private boolean N(boolean paramBoolean)
  {
    boolean bool1;
    if (this.b.getCount() == 0)
    {
      bool1 = true;
      if ((!bool1) && (!paramBoolean)) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isFristLoadFromDB=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) }));
      if (bool2) {
        P(false, 1);
      }
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  private void P(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Kxa.sT = System.currentTimeMillis();
    awit.a(this.mChannelID, this.jdField_a_of_type_Kxa.sT, (QQAppInterface)kxm.getAppRuntime());
    Object localObject2 = null;
    if (this.b != null) {
      this.b.nq(paramBoolean);
    }
    int j = -1;
    Object localObject1 = localObject2;
    int i = j;
    if (nm() == 5)
    {
      Object localObject3 = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
      localObject1 = localObject2;
      i = j;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        i = j;
        if (((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap() != null)
        {
          localObject3 = ((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap();
          Long localLong = (Long)((Map)localObject3).get("param_key_insert_article_id");
          localObject1 = localObject2;
          i = j;
          if (localLong != null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(localLong);
            i = 5;
            ((Map)localObject3).remove("param_key_insert_article_id");
          }
        }
      }
    }
    lbz.a().a(this.mChannelID, (List)localObject1, i, true, false, this.aIz, null, -1L, null, ni(), 0L, 0L, null, paramInt, false, null, 0);
    this.aIz += 1;
    odv.a(paramInt, this.mChannelID, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void Q(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aXd();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131718335))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.t(true, str);
      return;
    }
  }
  
  private void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.mTitleText.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label31;
        }
        muj.a(this.mTitleText, 0, 300);
      }
    }
    label31:
    while (this.mTitleText.getVisibility() != 0)
    {
      return;
      this.mTitleText.setVisibility(0);
      return;
    }
    if (paramBoolean2)
    {
      muj.a(this.mTitleText, 4, 300);
      return;
    }
    this.mTitleText.setVisibility(4);
  }
  
  private Intent a(ChannelInfo paramChannelInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", mso.a(paramChannelInfo, 0));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = anre.a(localIntent.getExtras());
    paramChannelInfo.mMsgServiceID = 83;
    localIntent.putExtra("stuctmsg_bytes", paramChannelInfo.getBytes());
    return localIntent;
  }
  
  private void a(ChannelInfo paramChannelInfo)
  {
    if ((this.B != null) && (this.B.isShowing())) {
      return;
    }
    this.B = ausj.b(this);
    this.B.show();
    this.B.a(new kjm(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    mn(paramChannelInfo.mIsFollowed);
    lbz.a().b(paramChannelInfo);
    lbz.a().f(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.9(this, paramChannelInfo, paramBoolean));
  }
  
  private void aC()
  {
    this.mTitleBar = ((ViewGroup)findViewById(2131379879));
    this.nV = ((TextView)findViewById(2131379808));
    this.mTitleText = ((TextView)findViewById(2131379863));
    this.ic = ((ImageView)findViewById(2131379851));
    this.mRedPacketProgressView = ((RIJRedPacketProgressView)findViewById(2131378910));
    if (this.mColumnType == 0)
    {
      this.mTitleText.setText(im());
      this.mTitleText.setVisibility(0);
    }
    this.mTitleBar.setOnClickListener(this);
    this.nV.setOnClickListener(this);
    this.mTitleText.setOnClickListener(this);
    this.ic.setOnClickListener(this);
    this.mRedPacketProgressView.setOnClickListener(this);
  }
  
  private void aDA()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mRedPacketProgressView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.mRedPacketProgressView.getLayoutParams();
      if (this.ic.getVisibility() == 0)
      {
        localLayoutParams.addRule(0, 2131379851);
        localLayoutParams.addRule(11, 0);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(0, 0);
  }
  
  private void aDB()
  {
    if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.c() != null)) {
      this.jdField_a_of_type_Mye.stop(11);
    }
  }
  
  private void aDy()
  {
    if (this.jH != null) {
      this.jH.setVisibility(8);
    }
    View localView = findViewById(2131374329);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void aDz()
  {
    boolean bool = true;
    if ((this.mTitleBar == null) || (this.nX == null)) {}
    label142:
    for (;;)
    {
      return;
      this.nX.getLocationOnScreen(this.dd);
      this.mTitleBar.getLocationOnScreen(this.dc);
      int i = this.dd[1] + this.nX.getHeight();
      int j = this.dc[1] + this.mTitleBar.getHeight();
      if ((i != 0) && (j != 0))
      {
        if (i <= j) {}
        for (;;)
        {
          if (bool == this.afL) {
            break label142;
          }
          this.afL = bool;
          mm(this.afL);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.readinjoy.video.SubChannelActivity", 2, "checkIsTopFixed(): mFixed=" + this.afL);
          return;
          bool = false;
        }
      }
    }
  }
  
  private Map<Long, mgu> b(Integer paramInteger)
  {
    Map localMap = (Map)this.dD.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.dD.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private void b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (this.mColumnType == 0) {
      break label7;
    }
    label7:
    while (paramChannelInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "updateHeaderUI(): fromServer = " + paramBoolean + ", channelInfo = " + paramChannelInfo.toString());
    }
    this.nX.setText(im());
    this.mTitleText.setText(im());
    if (this.nZ != null)
    {
      if (paramChannelInfo.mFollowNum <= 0) {
        this.nZ.setVisibility(8);
      }
    }
    else {
      label102:
      if (this.ic != null)
      {
        if (!paramChannelInfo.mIsTopic) {
          break label172;
        }
        this.ic.setVisibility(0);
      }
    }
    for (;;)
    {
      aDA();
      mn(paramChannelInfo.mIsFollowed);
      if (this.afN) {
        break;
      }
      this.afN = true;
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.11(this, paramChannelInfo));
      return;
      this.nZ.setVisibility(0);
      break label102;
      label172:
      this.ic.setVisibility(8);
    }
  }
  
  private void b(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.values() == null) || (!paramBoolean)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramMap = paramMap.values().iterator();
      for (;;)
      {
        if (paramMap.hasNext())
        {
          mgu localmgu = (mgu)paramMap.next();
          if (localmgu.amp) {
            continue;
          }
          localmgu.amp = true;
          if (localmgu.j == null) {
            continue;
          }
          kbp.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, this.mChannelID, localmgu.aRx), false);
          kbp.d("0X80066FC", "", "", Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, this.mChannelID, localmgu.aRx));
          if (ndi.am(localmgu.j))
          {
            int i = 0;
            while (i < localmgu.j.mTopicRecommendFeedsInfo.ld.size())
            {
              kbp.a(null, localmgu.agN, "0X8007626", "0X8007626", 0, 0, Long.toString(localmgu.j.mFeedId), ((mih.b)localmgu.j.mTopicRecommendFeedsInfo.ld.get(i)).businessId + "", Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, this.mChannelID, localmgu.aRx, localmgu.aRy, aqiw.isWifiConnected(getContext()), localmgu.agM, localmgu.mStrCircleId, localmgu.agO, kxm.h(localmgu.j), (ArticleInfo)localmgu.j, 0L, -1, localmgu.aRz, localmgu.aRA, localmgu.aRB, localmgu.amu, localmgu.aRD, localmgu.aRC, localmgu.aRF), false);
              i += 1;
            }
          }
          Object localObject1 = new nce.a(kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, this.mChannelID, localmgu.aRx, localmgu.aRy, aqiw.isWifiConnected(getContext()), localmgu.agM, localmgu.mStrCircleId, localmgu.agO, kxm.h(localmgu.j), (ArticleInfo)localmgu.j, 0L, -1, localmgu.aRz, localmgu.aRA, localmgu.aRB, localmgu.amu, localmgu.aRD, localmgu.aRC, localmgu.aRF)).a(localmgu.k).O(nm()).b(localmgu.k).f(localmgu.k).a().toJsonString();
          kbp.a(null, "CliOper", "", localmgu.agN, "0X8007626", "0X8007626", 0, 0, Long.toString(localmgu.j.mFeedId), Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), (String)localObject1, false);
          kbp.d("0X8007626", localmgu.agN, Long.toString(localmgu.j.mFeedId), Long.toString(localmgu.v.longValue()), Integer.toString(localmgu.mStrategyId), kxm.a(localmgu.mAlgorithmID, localmgu.mArticleType, this.mChannelID, localmgu.aRx, localmgu.aRy, aqiw.isWifiConnected(getContext()), localmgu.agM, localmgu.mStrCircleId, localmgu.agO, kxm.h(localmgu.j), (ArticleInfo)localmgu.j, 0L, -1, localmgu.aRz, localmgu.aRA, localmgu.aRB, localmgu.amu, localmgu.aRD, localmgu.aRC, localmgu.aRF));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = kxm.getLongAccountUin();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localmgu.v.longValue();
          ((ReportInfo)localObject1).mChannelId = this.mChannelID;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localmgu.mAlgorithmID);
          ((ReportInfo)localObject1).mStrategyId = localmgu.mStrategyId;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localmgu.mServerContext;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localmgu.agO;
          if (localmgu.j.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localmgu.j.mVideoColumnInfo.aHc;
          }
          Object localObject2;
          if (localmgu.j.mSocialFeedInfo != null)
          {
            localObject2 = new ReportInfo.a();
            ((ReportInfo.a)localObject2).vd = localmgu.j.mSocialFeedInfo.mFeedId;
            if (localmgu.j.mSocialFeedInfo.a != null) {
              ((ReportInfo.a)localObject2).vg = localmgu.j.mSocialFeedInfo.a.uin;
            }
            ((ReportInfo.a)localObject2).aSx = localmgu.j.mSocialFeedInfo.mLikeCount;
            ((ReportInfo.a)localObject2).aSy = localmgu.j.mSocialFeedInfo.mCommentCount;
            Object localObject3 = localmgu.j.mSocialFeedInfo.iS;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((ReportInfo.a)localObject2).iR = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject3).next();
                if (locale != null) {
                  ((ReportInfo.a)localObject2).iR.add(Long.valueOf(locale.uin));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.a)localObject2);
          }
          localArrayList.add(localObject1);
          if (localmgu.amr) {}
          try
          {
            if (localmgu.ams)
            {
              localObject2 = kxm.v();
              ((JSONObject)localObject2).put("feeds_source", localmgu.agM);
              ((JSONObject)localObject2).put("kandian_mode", kxm.nR());
              kbp.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, kxm.g(localmgu.j), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.mChannelID == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new ReportInfo.b();
              ((ReportInfo.b)localObject2).aSB = 1;
              localObject2 = ((ReportInfo.b)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localmgu.agO;
              if (QLog.isColorLevel()) {
                QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed subchannel--mUin:" + ((ReportInfo)localObject1).mUin + "; mSource:" + ((ReportInfo)localObject1).mSource + "; mOpSource:" + ((ReportInfo)localObject1).mOpSource + "; mInnerId:" + ((ReportInfo)localObject1).mInnerId + "; mChannelId:" + ((ReportInfo)localObject1).mChannelId + "; mAlgorithmId:" + ((ReportInfo)localObject1).mAlgorithmId + "; mStrategyId:" + ((ReportInfo)localObject1).mStrategyId + "; mOperation:" + ((ReportInfo)localObject1).mOperation + "; mPlayTimeLength:" + ((ReportInfo)localObject1).mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject2);
              }
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
    } while (localArrayList.isEmpty());
    lbz.a().cb(localArrayList);
  }
  
  private boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.dC.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private boolean da(int paramInt)
  {
    if ((this.jdField_a_of_type_Mye != null) && (this.jdField_a_of_type_Mye.isPlaying()) && (this.jdField_a_of_type_Mza != null) && (!this.jdField_a_of_type_Mza.EV()))
    {
      this.jdField_a_of_type_Mza.sQ(paramInt);
      return true;
    }
    return false;
  }
  
  private void f(ListView paramListView)
  {
    if (this.mColumnType != 0)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131560554, paramListView, false);
      this.eE = ((RelativeLayout)localView.findViewById(2131368471));
      this.nW = ((TextView)localView.findViewById(2131368468));
      this.nY = ((TextView)localView.findViewById(2131368462));
      this.nX = ((TextView)localView.findViewById(2131368469));
      this.nZ = ((TextView)localView.findViewById(2131368461));
      this.nW.getPaint().setFakeBoldText(true);
      this.nX.getPaint().setFakeBoldText(true);
      this.nY.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private Context getContext()
  {
    return this;
  }
  
  private String im()
  {
    if (!TextUtils.isEmpty(this.mChannelName)) {
      return this.mChannelName;
    }
    return getIntent().getStringExtra("channel_name");
  }
  
  private void initData()
  {
    this.mChannelID = nh();
    this.mChannelType = ni();
    this.mChannelName = im();
    this.jdField_a_of_type_Mye = new mye(this);
    this.jdField_a_of_type_Kxa = new kxa();
    this.jdField_a_of_type_Kxa.sT = awit.a(nh(), (QQAppInterface)kxm.getAppRuntime());
    this.jdField_a_of_type_Mst = mst.a();
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.mColumnType = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private void initListView()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131370584));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(nh());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this);
    f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.b = new ndh(this, getLayoutInflater(), nh(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Aqdf, lgd.a(null));
    this.b.setChannelType(ni());
    this.b.a(this.jdField_a_of_type_Mye, this.jdField_a_of_type_Mst);
    this.b.aVN();
    this.b.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.b);
  }
  
  private void initUI()
  {
    aC();
    initListView();
    aDy();
    ChannelInfo localChannelInfo = lbz.a().a(nh());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_Mza = new mza((FrameLayout)findViewById(2131381801), (ReadInJoyBaseListView)findViewById(2131370584), this);
    this.jdField_a_of_type_Mza.a(this);
    this.jdField_a_of_type_Mye.b(this.jdField_a_of_type_Mza);
    this.jdField_a_of_type_Mza.a(this);
    this.b.aVO();
    this.b.eJ(nm());
    this.jdField_a_of_type_Mdn = new mdn(this.mRedPacketProgressView);
    this.jdField_a_of_type_Mye.a(this.jdField_a_of_type_Mdn);
    RIJRedPacketManager.a().a(new kji(this));
  }
  
  private void ma(boolean paramBoolean)
  {
    if ((this.sd != 0L) && (this.jdField_a_of_type_Mye != null) && (this.b != null) && (this.b.getData() != null) && (this.b.getData().size() > 0)) {
      kxm.a(nh(), (System.currentTimeMillis() - this.sd) / 1000L, this.jdField_a_of_type_Mye.c(), (BaseArticleInfo)this.b.getData().get(0), paramBoolean);
    }
  }
  
  private void mb(String paramString)
  {
    findViewById(2131374329).setVisibility(8);
    if (this.jH == null)
    {
      this.jH = ((ViewStub)findViewById(2131372278)).inflate();
      this.oa = ((TextView)this.jH.findViewById(2131376708));
      this.id = ((ImageView)this.jH.findViewById(2131376707));
    }
    this.oa.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jH);
    this.jH.setOnClickListener(this);
  }
  
  private void mn(boolean paramBoolean)
  {
    if (this.nY != null)
    {
      if (paramBoolean)
      {
        this.nY.setTextColor(-9211021);
        this.nY.setBackgroundResource(2130843826);
        this.nY.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.nY.setBackgroundResource(2130843808);
    this.nY.setTextColor(-1);
  }
  
  private int nh()
  {
    if (this.mChannelID != -1) {
      return this.mChannelID;
    }
    return getIntent().getIntExtra("channel_id", 0);
  }
  
  private int ni()
  {
    return 3;
  }
  
  private int nm()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.dB.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.dB.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt != 0) {}
    P(true, 3);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    kwz.clearMemoryCache();
    awit.g((QQAppInterface)kxm.getAppRuntime(), System.currentTimeMillis(), this.mChannelID);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, mgu> paramMap)
  {
    if (this.b != null) {
      this.b.b(paramSet, paramMap);
    }
    this.jdField_a_of_type_Kxa.sX = System.currentTimeMillis();
    this.jdField_a_of_type_Kxa.sZ = awit.c((QQAppInterface)kxm.getAppRuntime(), this.mChannelID);
    lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
    lbz.a().N(56, 3, nh());
    this.dC.put(Integer.valueOf(this.mChannelID), Boolean.valueOf(true));
  }
  
  public void a(mrr parammrr1, mrr parammrr2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + parammrr1 + "  nextVideoPlayParam:" + parammrr2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    ndi localndi;
    if ((parammrr1 != null) && ((parammrr1 instanceof mye.b)) && (parammrr2 != null) && ((parammrr2 instanceof mye.b)))
    {
      parammrr1 = ((mye.b)parammrr1).d;
      parammrr2 = ((mye.b)parammrr2).d;
      if ((parammrr1 != null) && (parammrr2 != null))
      {
        localndi = this.b;
        if (paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localndi.a(parammrr1, parammrr2, paramBoolean);
      return;
    }
  }
  
  public void a(mye.b paramb, int paramInt1, int paramInt2) {}
  
  public void a(mye.b paramb1, mye.b paramb2)
  {
    this.b.a(paramb1, paramb2);
    mo(false);
  }
  
  public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void aCB() {}
  
  public void aCj()
  {
    if (this.jdField_a_of_type_Mye.a() != null) {
      this.jdField_a_of_type_Mye.a().aUp();
    }
  }
  
  public void aCk()
  {
    this.b.aCk();
    mo(true);
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label104;
      }
      if ((!aqfo.isMIUI()) && (!aqfo.isFlyme())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label104:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.aeL = bool;
      lbz.a().b(this.mChannelID, ni(), paramInt, 0, 1);
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
      return;
    }
  }
  
  public void bP(List<Long> paramList)
  {
    if (!PreloadManager.a().Gu()) {}
    for (;;)
    {
      return;
      PreloadManager.a().bdm();
      int j = this.b.nh();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.b.a(j, l);
          if ((localObject != null) && (!kxm.j((BaseArticleInfo)localObject)) && (!this.b.m(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (sum.gg((String)localObject)) {
              PreloadManager.a().oZ((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doOnActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (paramInt1 == 101) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (!paramIntent.getBooleanExtra("bFailed", false)) {
        i = 1;
      }
      QQToast localQQToast = new QQToast(this);
      localQQToast.setDuration(2000);
      if (i != 0)
      {
        localQQToast.setToastIcon(QQToast.getIconRes(2));
        localQQToast.setToastMsg(2131693408);
        localQQToast.show(getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getApplicationContext(), 5.0F));
      }
      else
      {
        localQQToast.setToastIcon(QQToast.getIconRes(1));
        localQQToast.setToastMsg(2131693409);
        localQQToast.show(getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.b.s(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)kxm.getAppRuntime(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.sd = System.currentTimeMillis();
    mzj.a().aO(this);
    lcc.a().b(this.mObserver);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560553);
    this.mRoot = ((RelativeLayout)findViewById(2131379881));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mRoot.setFitsSystemWindows(true);
      this.mRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    initData();
    initUI();
    a(a(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.sd = 0L;
    lcc.a().c(this.mObserver);
    mzj.a().aP(this);
    a(b(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.destroy();
    }
    if (this.b != null)
    {
      this.b.aVM();
      this.b.clearData();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onDestory();
    }
    this.dB.clear();
    this.dD.clear();
    this.dC.clear();
    nha.a(this).doOnDestory();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 25) {
      bool1 = da(-1);
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.doOnKeyDown(paramInt, paramKeyEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (paramInt == 24) {
        bool1 = da(1);
      } else {
        bool1 = false;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Mye.aTN();
    nha.a(this).aWY();
    if (this.b != null) {
      this.b.doOnPause();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aDb();
    this.jdField_a_of_type_Mye.aTO();
    nha.a(this).di(ni(), nh());
    if (this.b != null) {
      this.b.doOnResume();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.b.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new kjk(this));
    }
  }
  
  public void doOnStop()
  {
    mzj.a().z(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void mm(boolean paramBoolean)
  {
    this.afL = paramBoolean;
    U(paramBoolean, true);
  }
  
  public void mo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(4);
      return;
    }
    this.mTitleBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(0);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Mye;
    if ((localObject != null) && (((mye)localObject).a() != null))
    {
      localObject = ((mye)localObject).a();
      if (((mza)localObject).EV())
      {
        ((mza)localObject).aUp();
        return true;
      }
    }
    ma(false);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131379808: 
    case 2131372277: 
    case 2131368462: 
    case 2131379863: 
    case 2131379879: 
    case 2131379851: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        finish();
        continue;
        aDy();
        P(true, 3);
        lbz.a().N(56, 3, nh());
        continue;
        if (jqc.ak(this))
        {
          this.afM = true;
          localObject = lbz.a().a(nh());
          if (localObject != null) {
            if (((ChannelInfo)localObject).mIsFollowed)
            {
              a((ChannelInfo)localObject);
            }
            else
            {
              a((ChannelInfo)localObject, true);
              continue;
              if ((this.afL) || (this.mColumnType == 0))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWi();
                ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
                continue;
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWi();
                ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.6(this));
                continue;
                if (this.jdField_a_of_type_Mye.isPlaying())
                {
                  this.jdField_a_of_type_Mye.pause();
                  this.afO = true;
                }
                if (this.jdField_a_of_type_Mso == null) {
                  this.jdField_a_of_type_Mso = new mso(this);
                }
                localObject = lbz.a().a(nh());
                if (localObject != null)
                {
                  localObject = ((ChannelInfo)localObject).clone();
                  if (localObject != null)
                  {
                    if (TextUtils.isEmpty(((ChannelInfo)localObject).mChannelName)) {
                      ((ChannelInfo)localObject).mChannelName = im();
                    }
                    this.jdField_a_of_type_Mso.a((ChannelInfo)localObject, a((ChannelInfo)localObject), new kjl(this));
                  }
                }
              }
            }
          }
        }
      }
    }
    RIJRedPacketManager.a().a(this, 2, 1, 1);
    if (this.jdField_a_of_type_Mye.c() != null) {}
    for (Object localObject = this.jdField_a_of_type_Mye.c().getInnerUniqueID();; localObject = null)
    {
      this.mRedPacketProgressView.b(4, this.jdField_a_of_type_Mdn.Dw(), (String)localObject);
      break;
    }
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWi();
    aDB();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mColumnType != 0) {
      aDz();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.mColumnType != 0) {
      aDz();
    }
  }
  
  public void setAdapterData(List<Long> paramList, int paramInt)
  {
    this.b.setData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList));
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */