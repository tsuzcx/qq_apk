import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoInfo.GameAdDownloadInfo;
import com.tencent.biz.pubaccount.VideoInfo.KdTagItem;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class tsf
  implements View.OnClickListener, tyd
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + tsf.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private oau jdField_a_of_type_Oau;
  private ruw jdField_a_of_type_Ruw;
  private rvv jdField_a_of_type_Rvv;
  private tse jdField_a_of_type_Tse;
  private tsk jdField_a_of_type_Tsk;
  private txh jdField_a_of_type_Txh;
  private txz jdField_a_of_type_Txz;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public tsf(QQAppInterface paramQQAppInterface, Activity paramActivity, ruw paramruw, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Tse = new tse(paramQQAppInterface);
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(paramActivity, 3.0F);
    this.jdField_a_of_type_Ruw = paramruw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Oau = new oau(paramActivity);
    this.jdField_a_of_type_Oau.a(new tsg(this));
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "游戏组件上报 type = " + paramInt + " adTitle = " + str);
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    obb.a(new trn().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(obb.af).c(obb.as).d(obb.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, rvv paramrvv)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rvv = paramrvv;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramrvv.v == null) && ((paramrvv instanceof rvs)))
    {
      paramrvv.v = ((ViewGroup)((ViewStub)paramrvv.r.findViewById(2131380576)).inflate());
      paramrvv.f = ((URLImageView)paramrvv.v.findViewById(2131367384));
      paramrvv.E = ((TextView)paramrvv.v.findViewById(2131367387));
      paramrvv.F = ((TextView)paramrvv.v.findViewById(2131367386));
      paramrvv.G = ((TextView)paramrvv.v.findViewById(2131367385));
      paramrvv.H = ((TextView)paramrvv.v.findViewById(2131367383));
    }
    if (paramrvv.v != null)
    {
      paramrvv.v.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bfol.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bfol.k);
      paramrvv.f.setImageDrawable(localURLDrawable);
      paramrvv.E.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramrvv.F.setText(paramGameAdComData.i);
      if (twq.a()) {
        paramrvv.F.setTextColor(Color.parseColor("#80000000"));
      }
      paramrvv.v.setTag(paramrvv);
      paramrvv.G.setTag(paramrvv);
      paramrvv.H.setTag(paramrvv);
      paramrvv.v.setOnClickListener(this);
      paramrvv.G.setOnClickListener(this);
      paramrvv.H.setOnClickListener(this);
      paramrvv.v.setTag(2131380831, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramrvv);
      rwv.a(paramrvv.v, 200);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramGameAdComData.j);
        }
      }
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    if (bfwv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Txh.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = obb.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Rvv.G.setVisibility(0);
        this.jdField_a_of_type_Rvv.H.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh)) {
          break;
        }
        DownloadInfo localDownloadInfo = bhyo.a().c(this.jdField_a_of_type_Txh.d);
        bhyo.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = obb.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
      return true;
      if (!oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = obb.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Rvv.G.setVisibility(0);
    this.jdField_a_of_type_Rvv.H.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (twr.a(this.jdField_a_of_type_Tse)) {
      return true;
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString);
  }
  
  private String b()
  {
    Object localObject1 = "";
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("jump_page", 6);
      ((JSONObject)localObject2).put("jump_bus_type", 5);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, localException.getMessage());
    }
    return localObject1;
    return "";
  }
  
  private void b(rvv paramrvv)
  {
    Object localObject = amtj.a(2131715265);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        String str;
      }
    }
    bool = twq.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131717386);
        paramrvv.G.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramrvv.G.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramrvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramrvv.G.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = amtj.a(2131715198))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
        }
        paramrvv.G.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (obb.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = amtj.a(2131715228))
          {
            paramrvv.G.setTextColor(-1);
            paramrvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramrvv.G.setText((CharSequence)localObject);
            return;
          }
        }
        if (bool)
        {
          str = "下载";
          label273:
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
            str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
          }
          paramrvv.G.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842910);
          paramrvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramrvv.G.setText(str);
          localObject = str;
          if (this.jdField_b_of_type_Boolean) {
            break;
          }
          localObject = str;
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          this.jdField_c_of_type_Boolean = true;
          b();
          return;
          str = amtj.a(2131715196);
          break label273;
          label387:
          paramrvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = amtj.a(2131715195);
      paramrvv.G.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramrvv.G.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramrvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;; localObject = amtj.a(2131715170))
    {
      paramrvv.G.setTextColor(-1);
      break;
    }
  }
  
  private void c(rvv paramrvv)
  {
    if ((paramrvv != null) && (paramrvv.v != null)) {
      paramrvv.v.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Txh != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Txh.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bhyo.a().c((String)localObject);
          if ((oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
          {
            h();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private boolean f()
  {
    Object localObject = this.jdField_a_of_type_Txh.d;
    int i = obb.af;
    i = obb.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bfwv.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = obb.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh))
    {
      localObject = bhyo.a().c(this.jdField_a_of_type_Txh.d);
      bhyo.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = obb.af;
        i = obb.e;
        localHashMap.put("download_state", "3");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    return false;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Txh == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 4)
        {
          a(4, d());
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 5)
        {
          localObject = this.jdField_a_of_type_Txh.d;
          if (bfwv.a(BaseApplicationImpl.getContext(), (String)localObject))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
            a(1, d());
            return;
          }
          a(5, d());
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3);
      a(3, d());
    } while ((this.jdField_a_of_type_Txh == null) || (this.jdField_a_of_type_Oau == null));
    this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    return;
    int i = obb.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = obb.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    twp.a(jdField_a_of_type_JavaLangString, "queryCallback and download: appId is " + this.jdField_a_of_type_Txh.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Txh.e);
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
    {
      i = obb.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Rvv.G.setVisibility(8);
    this.jdField_a_of_type_Rvv.H.setVisibility(0);
    if (!twq.a())
    {
      this.jdField_a_of_type_Rvv.H.setText(amtj.a(2131715231) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Rvv.H.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Rvv.H.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Rvv.H.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Rvv.G.setClickable(false);
      this.jdField_a_of_type_Rvv.v.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvv.H.setClickable(false);
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rvv.G.setClickable(true);
      this.jdField_a_of_type_Rvv.v.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Tsk = new tsk(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void p()
  {
    if (b())
    {
      this.jdField_a_of_type_Rvv.G.setClickable(false);
      this.jdField_a_of_type_Rvv.v.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvv.H.setClickable(false);
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rvv.G.setClickable(true);
      this.jdField_a_of_type_Rvv.v.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Txh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Rvv.G.setClickable(true);
      this.jdField_a_of_type_Rvv.v.setClickable(true);
      this.jdField_a_of_type_Rvv.H.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Rvv.G.setClickable(false);
      this.jdField_a_of_type_Rvv.v.setClickable(false);
      this.jdField_a_of_type_Rvv.H.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Tse.a();
  }
  
  public tse a()
  {
    return this.jdField_a_of_type_Tse;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Oau != null) {
      this.jdField_a_of_type_Oau.a();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = obb.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)))
    {
      paramInt = obb.e;
      localHashMap.put("download_state", "2");
      a(paramInt, localHashMap);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
    case 3: 
    case 5: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          return;
          m();
          this.jdField_a_of_type_Rvv.G.setVisibility(8);
          this.jdField_a_of_type_Rvv.H.setVisibility(0);
          this.jdField_a_of_type_Rvv.H.setTextColor(Color.parseColor("#262626"));
        } while (!twq.a());
        this.jdField_a_of_type_Rvv.H.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Rvv.G.setVisibility(0);
        this.jdField_a_of_type_Rvv.G.setText(amtj.a(2131715182));
        if (twq.a()) {
          this.jdField_a_of_type_Rvv.G.setText("安装");
        }
        this.jdField_a_of_type_Rvv.G.setTextColor(-1);
        this.jdField_a_of_type_Rvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rvv.H.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Rvv.G.setVisibility(0);
        this.jdField_a_of_type_Rvv.G.setText(amtj.a(2131715160));
        if (twq.a()) {
          this.jdField_a_of_type_Rvv.G.setText("打开");
        }
        this.jdField_a_of_type_Rvv.G.setTextColor(-1);
        this.jdField_a_of_type_Rvv.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rvv.H.setVisibility(8);
        return;
        this.jdField_a_of_type_Rvv.G.setVisibility(8);
        this.jdField_a_of_type_Rvv.H.setVisibility(0);
        this.jdField_a_of_type_Rvv.H.setText(amtj.a(2131715251));
        this.jdField_a_of_type_Rvv.H.setTextColor(-1);
      } while (!twq.a());
      this.jdField_a_of_type_Rvv.H.setText("继续");
      this.jdField_a_of_type_Rvv.H.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, amtj.a(2131715241), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) && (this.jdField_a_of_type_Tsk != null) && (this.jdField_a_of_type_Tsk.a == paramLong)) {
      this.jdField_a_of_type_Rvv.G.post(new VideoFeedsGameAdComManager.2(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Txz != null))
    {
      this.jdField_a_of_type_Txz.a(paramConfiguration);
      this.jdField_a_of_type_Txz.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, rvv paramrvv)
  {
    if (paramrvv.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramrvv.v != null) && (paramrvv.v.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
      if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
      {
        if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
        {
          o();
          if (c())
          {
            this.jdField_b_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramrvv);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        Object localObject = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            ((StringBuilder)localObject).append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        localObject = ((StringBuilder)localObject).toString();
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (localObject = "";; localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = ((String)localObject);
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          oeg.a().a(paramrvv.getAdapterPosition());
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
            this.jdField_a_of_type_Tse.a();
          }
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
            oeg.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
          }
          paramrvv = "";
          paramVideoInfo = paramrvv;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramrvv;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramrvv = new HashMap();
          a(obb.jdField_b_of_type_Int, paramrvv);
          odq.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(obb.af), String.valueOf(obb.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramrvv.v == null) || (paramrvv.v.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrvv.v.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
      this.jdField_a_of_type_Txh = txh.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(rvv paramrvv)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramrvv);
  }
  
  public void a(boolean paramBoolean)
  {
    twk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new tsi(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(rvv paramrvv, boolean paramBoolean)
  {
    if ((paramrvv.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramrvv.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1) && (paramrvv.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null))
    {
      a(paramrvv.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramrvv.a.a, paramrvv);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Tse.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Oau != null) && (this.jdField_a_of_type_Txh != null))
    {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
      twp.a(jdField_a_of_type_JavaLangString, "doQuery : appId is " + this.jdField_a_of_type_Txh.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Txh.e);
      return;
    }
    twp.a(jdField_a_of_type_JavaLangString, "doQuery cancel, manager is " + this.jdField_a_of_type_Oau + " downloadData is " + this.jdField_a_of_type_Txh);
  }
  
  public void b(boolean paramBoolean)
  {
    twk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new tsj(this, paramBoolean));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Oau != null) && (this.jdField_a_of_type_Txh != null)) {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh);
    }
    if (this.jdField_a_of_type_Rvv.H != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Tsk == null) {
      return false;
    }
    return ttp.a(null, this.jdField_a_of_type_Tsk.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Txh != null) && (this.jdField_a_of_type_Oau != null)) {
      this.jdField_a_of_type_Oau.d(this.jdField_a_of_type_Txh);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Txh != null) && (this.jdField_a_of_type_Oau != null)) {
      this.jdField_a_of_type_Oau.a(this.jdField_a_of_type_Txh, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Txh != null))
    {
      if ((this.jdField_a_of_type_Txh.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.d))) {
        twr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Txh.d);
      }
    }
    else {
      return;
    }
    uhs.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Rvv == null) {
      return;
    }
    this.jdField_a_of_type_Rvv.H.setVisibility(8);
    int i = c();
    if (i == 1)
    {
      p();
      return;
    }
    if (i == 2)
    {
      q();
      return;
    }
    n();
  }
  
  protected void j()
  {
    try
    {
      if (this.jdField_a_of_type_Txh != null)
      {
        bool1 = bfwv.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Txh.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Rvv.G.setVisibility(8);
        this.jdField_a_of_type_Rvv.H.setVisibility(0);
        a(e(), d());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        boolean bool1 = false;
      }
      label118:
      this.jdField_a_of_type_Rvv.G.setVisibility(0);
      this.jdField_a_of_type_Rvv.H.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Txh != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (rvv)paramView.getTag();
    int i = obb.af;
    int j = obb.jdField_a_of_type_Int;
    localObject = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      String str = "";
      localObject = str;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
        }
      }
      odq.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(obb.af), String.valueOf(obb.jdField_a_of_type_Int), (String)localObject, b());
      label140:
      label189:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          try
          {
            i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
            if (i == 1) {
              break;
            }
            if (i != 3) {
              break label189;
            }
            f();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        break;
      } while (this.jdField_a_of_type_Txh == null);
      if (!a(j, localException1, false)) {
        if (absl.a())
        {
          if (i == 2) {
            b();
          }
        }
        else if (!f())
        {
          a(false);
          continue;
          for (;;)
          {
            try
            {
              if (this.jdField_a_of_type_Txh == null) {
                break label140;
              }
              if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue() != 2) {
                break;
              }
              boolean bool = a(j, localException1, true);
              if (bool) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3) {
                break label348;
              }
              e();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
              {
                localException1.put("download_state", "8");
                i = obb.e;
              }
              a(i, localException1);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            break;
            label348:
            if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 4)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 0) {}
            }
            else
            {
              c();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
              {
                localException2.put("download_state", "9");
                i = obb.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          twr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          a(j, localException2);
          twh.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsf
 * JD-Core Version:    0.7.0.1
 */