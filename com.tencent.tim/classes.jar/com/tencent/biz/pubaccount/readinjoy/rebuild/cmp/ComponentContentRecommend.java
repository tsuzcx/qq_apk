package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqgo;
import aqiw;
import awit;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kbp;
import kwt;
import kxm;
import lbz;
import lcc;
import lce;
import lie;
import ljc;
import lwk;
import lwm.a;
import mas;
import mbf;
import mbg;
import mbj;
import mbk;
import mbl;
import mbm;
import mhx;
import ndi;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentRecommend
  extends FrameLayout
  implements lwk
{
  public static final String TAG = ComponentContentRecommend.class.getSimpleName();
  private static int aQo = -1;
  private ListViewForListview jdField_a_of_type_ComTencentBizWidgetsListViewForListview;
  private mas jdField_a_of_type_Mas;
  private ArticleInfo b;
  private LinearLayout dQ;
  protected lce g = new mbm(this);
  private ImageView jj;
  private BaseAdapter mAdapter;
  private Context mContext;
  private ArrayList<RecommendFollowInfo> mDataList = new ArrayList();
  private TextView qo;
  
  public ComponentContentRecommend(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public static String a(int paramInt1, long paramLong1, BaseArticleInfo paramBaseArticleInfo, long paramLong2, int paramInt2, int paramInt3, int paramInt4, List<RecommendFollowInfo> paramList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("algorithm_id", paramLong2 + "");
        localJSONObject.put("folder_status", kxm.aMw + "");
        localJSONObject.put("feeds_type", "70");
        localJSONObject.put("time", System.currentTimeMillis());
        localJSONObject.put("channel_id", paramInt1);
        if (!NetworkState.isWifiConn()) {
          break label425;
        }
        paramInt1 = 2;
        localJSONObject.put("network_type", paramInt1);
        localJSONObject.put("feeds_source", paramLong1 + "");
        localJSONObject.put("imei", kxm.iT());
        localJSONObject.put("imsi", kxm.iU());
        localJSONObject.put("idfa", "");
        localJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID + "");
        localJSONObject.put("comment", 0);
        if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label430;
        }
        paramInt1 = 1;
        localJSONObject.put("reddot_style", paramInt1);
        localJSONObject.put("tab_source", paramInt4);
        localJSONObject.put("kandian_mode", kxm.nR());
        if (paramInt3 != 0) {
          localJSONObject.put("select_num", paramInt3);
        }
        localJSONObject.put("sub_type", paramInt2);
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          paramBaseArticleInfo = new StringBuilder();
          paramInt1 = 0;
          if (paramInt1 < paramList.size())
          {
            paramBaseArticleInfo.append(((RecommendFollowInfo)paramList.get(paramInt1)).uin);
            if (paramInt1 < paramList.size() - 1) {
              paramBaseArticleInfo.append("|");
            }
          }
          else
          {
            localJSONObject.put("feedssource_more", paramBaseArticleInfo.toString());
          }
        }
        else
        {
          paramBaseArticleInfo = localJSONObject.toString();
          return paramBaseArticleInfo;
        }
      }
      catch (JSONException paramBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "report" + QLog.getStackTraceString(paramBaseArticleInfo));
        }
        return "";
      }
      paramInt1 += 1;
      continue;
      label425:
      paramInt1 = 1;
      continue;
      label430:
      paramInt1 = 0;
    }
  }
  
  public static void a(String paramString, int paramInt1, long paramLong1, BaseArticleInfo paramBaseArticleInfo, long paramLong2, int paramInt2)
  {
    String str = a(paramInt1, paramLong1, paramBaseArticleInfo, paramLong2, 1, 0, aQo, null);
    kbp.a(null, kxm.getLongAccountUin() + "", paramString, paramString, 0, 0, paramBaseArticleInfo.mRecommendFollowId + "", paramBaseArticleInfo.mArticleID + "", paramInt2 + "", str, false);
  }
  
  private void a(String paramString, RecommendFollowInfo paramRecommendFollowInfo)
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Mas != null)
    {
      i = j;
      if (this.jdField_a_of_type_Mas.a() != null)
      {
        i = j;
        if (this.jdField_a_of_type_Mas.a().b() != null) {
          i = this.jdField_a_of_type_Mas.a().b().nh();
        }
      }
    }
    a(paramString, i, paramRecommendFollowInfo.uin, this.b, paramRecommendFollowInfo.algorithmId, paramRecommendFollowInfo.strategyId);
  }
  
  private void aNY()
  {
    if ((this.jdField_a_of_type_Mas != null) && (this.jdField_a_of_type_Mas.a() != null) && (this.jdField_a_of_type_Mas.a().b() != null)) {}
    for (int i = this.jdField_a_of_type_Mas.a().b().nh();; i = 0)
    {
      a("0X8009494", i, 0L, this.b, 0L, 0);
      return;
    }
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    this.mContext = paramContext;
    init(paramContext);
    aHq();
  }
  
  public static void i(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mRecommendFollowInfos == null) || (paramBaseArticleInfo.mRecommendFollowInfos.reportMap == null) || (paramBaseArticleInfo.mRecommendFollowInfos.reportMap.size() <= 0)) {
      return;
    }
    Iterator localIterator = paramBaseArticleInfo.mRecommendFollowInfos.reportMap.values().iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      a("0X80094DB", paramInt, localRecommendFollowInfo.uin, paramBaseArticleInfo, localRecommendFollowInfo.algorithmId, localRecommendFollowInfo.strategyId);
    }
    paramBaseArticleInfo.mRecommendFollowInfos.reportMap.clear();
  }
  
  private void setContent(lie paramlie)
  {
    this.b = paramlie.a();
    if (this.b == null) {}
    do
    {
      return;
      aQo = kxm.nQ();
      paramlie = this.b.mRecommendFollowInfos;
      if ((paramlie != null) && (paramlie.iM != null) && (paramlie.iM.size() > 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "setContent(): data is empty");
    return;
    if (this.b.mRecommendFollowInfos.amI) {
      this.dQ.setVisibility(0);
    }
    for (;;)
    {
      this.mDataList.clear();
      this.mDataList.addAll(this.b.mRecommendFollowInfos.iM);
      this.mAdapter.notifyDataSetChanged();
      paramlie = new mbf(this);
      this.qo.setOnClickListener(paramlie);
      this.jj.setOnClickListener(paramlie);
      return;
      this.dQ.setVisibility(8);
    }
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    lcc.a().W(paramRecommendFollowInfo.uin, paramRecommendFollowInfo.isFollowed);
    lbz.a().l(this.b);
    ThreadManager.post(new ComponentContentRecommend.6(this, paramRecommendFollowInfo), 5, null, true);
  }
  
  public void a(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    if (aqiw.isNetworkAvailable(getContext()))
    {
      if (!paramBoolean) {
        break label44;
      }
      a("0X80094DC", paramRecommendFollowInfo);
      if (paramRecommendFollowInfo.type != 1) {
        break label55;
      }
      c(paramRecommendFollowInfo, paramBoolean);
    }
    for (;;)
    {
      this.mAdapter.notifyDataSetChanged();
      return;
      label44:
      a("0X80094DD", paramRecommendFollowInfo);
      break;
      label55:
      if (paramRecommendFollowInfo.type == 2) {
        b(paramRecommendFollowInfo, paramBoolean);
      } else {
        QLog.e(TAG, 1, "followAccount, error type, info.type = " + paramRecommendFollowInfo.type + ", follow = " + paramBoolean);
      }
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void aHq() {}
  
  protected BaseAdapter b()
  {
    return new mbg(this);
  }
  
  public void b(RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (!aqiw.isNetworkAvailable(getContext())) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "jumpToProfile, info = " + paramRecommendFollowInfo);
      }
    } while (paramRecommendFollowInfo == null);
    paramRecommendFollowInfo = kwt.acJ + aqgo.encodeToString(String.valueOf(paramRecommendFollowInfo.uin).getBytes(), 2);
    Intent localIntent = new Intent(getContext(), PublicAccountBrowser.class);
    localIntent.putExtra("url", paramRecommendFollowInfo);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    ((Activity)getContext()).startActivityForResult(localIntent, 1);
  }
  
  protected void b(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    lbz.a().a().a(localQQAppInterface.getCurrentAccountUin(), paramRecommendFollowInfo.uin + "", paramBoolean, new mbj(this, paramRecommendFollowInfo), 2);
  }
  
  protected void c(RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, true, new mbk(this, paramRecommendFollowInfo), 1);
      return;
    }
    lbz.a().a().a(localQQAppInterface.getAccount(), paramRecommendFollowInfo.uin, false, new mbl(this, paramRecommendFollowInfo), 1);
  }
  
  public void cG(View paramView)
  {
    this.dQ = ((LinearLayout)paramView.findViewById(2131370239));
    this.jj = ((ImageView)paramView.findViewById(2131369700));
    this.qo = ((TextView)paramView.findViewById(2131380597));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)paramView.findViewById(2131370948));
    this.mAdapter = b();
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.mAdapter);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560303, this, true);
  }
  
  public void i(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772257);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    lcc.a().b(this.g);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lcc.a().c(this.g);
  }
  
  public class a
  {
    public RingAvatarView a;
    public View ev;
    public ReadInJoyNickNameTextView h;
    public ImageView jk;
    public ReadInJoyHeadImageView k;
    public TextView qp;
    public TextView qq;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend
 * JD-Core Version:    0.7.0.1
 */