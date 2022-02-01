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

public class tmk
  implements View.OnClickListener, trk
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + tmk.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nzj jdField_a_of_type_Nzj;
  private rnu jdField_a_of_type_Rnu;
  private rot jdField_a_of_type_Rot;
  private tmj jdField_a_of_type_Tmj;
  private tmp jdField_a_of_type_Tmp;
  private tqt jdField_a_of_type_Tqt;
  private trg jdField_a_of_type_Trg;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public tmk(QQAppInterface paramQQAppInterface, Activity paramActivity, rnu paramrnu, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Tmj = new tmj(paramQQAppInterface);
    this.jdField_a_of_type_Int = bhgr.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Rnu = paramrnu;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nzj = new nzj(paramActivity);
    this.jdField_a_of_type_Nzj.a(new tml(this));
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(nzq.af).c(nzq.as).d(nzq.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, rot paramrot)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rot = paramrot;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramrot.u == null) && ((paramrot instanceof roq)))
    {
      paramrot.u = ((ViewGroup)((ViewStub)paramrot.q.findViewById(2131380850)).inflate());
      paramrot.f = ((URLImageView)paramrot.u.findViewById(2131367358));
      paramrot.E = ((TextView)paramrot.u.findViewById(2131367361));
      paramrot.F = ((TextView)paramrot.u.findViewById(2131367360));
      paramrot.G = ((TextView)paramrot.u.findViewById(2131367359));
      paramrot.H = ((TextView)paramrot.u.findViewById(2131367357));
    }
    if (paramrot.u != null)
    {
      paramrot.u.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bhez.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bhez.k);
      paramrot.f.setImageDrawable(localURLDrawable);
      paramrot.E.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramrot.F.setText(paramGameAdComData.i);
      if (tpz.a()) {
        paramrot.F.setTextColor(Color.parseColor("#80000000"));
      }
      paramrot.u.setTag(paramrot);
      paramrot.G.setTag(paramrot);
      paramrot.H.setTag(paramrot);
      paramrot.u.setOnClickListener(this);
      paramrot.G.setOnClickListener(this);
      paramrot.H.setOnClickListener(this);
      paramrot.u.setTag(2131381109, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramrot);
      rpt.a(paramrot.u, 200);
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
    if (bhny.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Tqt.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = nzq.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Rot.G.setVisibility(0);
        this.jdField_a_of_type_Rot.H.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!nzj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt)) {
          break;
        }
        DownloadInfo localDownloadInfo = bjsz.a().c(this.jdField_a_of_type_Tqt.d);
        bjsz.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = nzq.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
      return true;
      if (!nzj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = nzq.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Rot.G.setVisibility(0);
    this.jdField_a_of_type_Rot.H.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (tqa.a(this.jdField_a_of_type_Tmj)) {
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
  
  private void b(rot paramrot)
  {
    Object localObject = anzj.a(2131715031);
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
    bool = tpz.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131717149);
        paramrot.G.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramrot.G.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramrot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramrot.G.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = anzj.a(2131714964))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
        }
        paramrot.G.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (nzq.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = anzj.a(2131714994))
          {
            paramrot.G.setTextColor(-1);
            paramrot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramrot.G.setText((CharSequence)localObject);
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
          paramrot.G.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842856);
          paramrot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramrot.G.setText(str);
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
          str = anzj.a(2131714962);
          break label273;
          label387:
          paramrot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = anzj.a(2131714961);
      paramrot.G.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramrot.G.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramrot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;; localObject = anzj.a(2131714936))
    {
      paramrot.G.setTextColor(-1);
      break;
    }
  }
  
  private void c(rot paramrot)
  {
    if ((paramrot != null) && (paramrot.u != null)) {
      paramrot.u.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Tqt != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Tqt.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bjsz.a().c((String)localObject);
          if ((nzj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
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
    Object localObject = this.jdField_a_of_type_Tqt.d;
    int i = nzq.af;
    i = nzq.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bhny.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nzq.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (nzj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt))
    {
      localObject = bjsz.a().c(this.jdField_a_of_type_Tqt.d);
      bjsz.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nzq.af;
        i = nzq.e;
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
    if (this.jdField_a_of_type_Tqt == null) {}
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
          localObject = this.jdField_a_of_type_Tqt.d;
          if (bhny.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Tqt == null) || (this.jdField_a_of_type_Nzj == null));
    this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
    return;
    int i = nzq.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nzj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nzq.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    tpx.a(jdField_a_of_type_JavaLangString, "queryCallback and download: appId is " + this.jdField_a_of_type_Tqt.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Tqt.e);
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
    {
      i = nzq.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Rot.G.setVisibility(8);
    this.jdField_a_of_type_Rot.H.setVisibility(0);
    if (!tpz.a())
    {
      this.jdField_a_of_type_Rot.H.setText(anzj.a(2131714997) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Rot.H.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Rot.H.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Rot.H.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Rot.G.setClickable(false);
      this.jdField_a_of_type_Rot.u.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rot.H.setClickable(false);
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rot.G.setClickable(true);
      this.jdField_a_of_type_Rot.u.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Tmp = new tmp(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u));
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
      this.jdField_a_of_type_Rot.G.setClickable(false);
      this.jdField_a_of_type_Rot.u.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rot.H.setClickable(false);
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rot.G.setClickable(true);
      this.jdField_a_of_type_Rot.u.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Tqt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tqt.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Rot.G.setClickable(true);
      this.jdField_a_of_type_Rot.u.setClickable(true);
      this.jdField_a_of_type_Rot.H.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Rot.G.setClickable(false);
      this.jdField_a_of_type_Rot.u.setClickable(false);
      this.jdField_a_of_type_Rot.H.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Tmj.a();
  }
  
  public tmj a()
  {
    return this.jdField_a_of_type_Tmj;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nzj != null) {
      this.jdField_a_of_type_Nzj.a();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = nzq.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)))
    {
      paramInt = nzq.e;
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
          this.jdField_a_of_type_Rot.G.setVisibility(8);
          this.jdField_a_of_type_Rot.H.setVisibility(0);
          this.jdField_a_of_type_Rot.H.setTextColor(Color.parseColor("#262626"));
        } while (!tpz.a());
        this.jdField_a_of_type_Rot.H.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Rot.G.setVisibility(0);
        this.jdField_a_of_type_Rot.G.setText(anzj.a(2131714948));
        if (tpz.a()) {
          this.jdField_a_of_type_Rot.G.setText("安装");
        }
        this.jdField_a_of_type_Rot.G.setTextColor(-1);
        this.jdField_a_of_type_Rot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rot.H.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Rot.G.setVisibility(0);
        this.jdField_a_of_type_Rot.G.setText(anzj.a(2131714926));
        if (tpz.a()) {
          this.jdField_a_of_type_Rot.G.setText("打开");
        }
        this.jdField_a_of_type_Rot.G.setTextColor(-1);
        this.jdField_a_of_type_Rot.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rot.H.setVisibility(8);
        return;
        this.jdField_a_of_type_Rot.G.setVisibility(8);
        this.jdField_a_of_type_Rot.H.setVisibility(0);
        this.jdField_a_of_type_Rot.H.setText(anzj.a(2131715017));
        this.jdField_a_of_type_Rot.H.setTextColor(-1);
      } while (!tpz.a());
      this.jdField_a_of_type_Rot.H.setText("继续");
      this.jdField_a_of_type_Rot.H.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131715007), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) && (this.jdField_a_of_type_Tmp != null) && (this.jdField_a_of_type_Tmp.a == paramLong)) {
      this.jdField_a_of_type_Rot.G.post(new VideoFeedsGameAdComManager.2(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Trg != null))
    {
      this.jdField_a_of_type_Trg.a(paramConfiguration);
      this.jdField_a_of_type_Trg.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, rot paramrot)
  {
    if (paramrot.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramrot.u != null) && (paramrot.u.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
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
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramrot);
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
          oct.a().a(paramrot.getAdapterPosition());
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
            this.jdField_a_of_type_Tmj.a();
          }
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
            oct.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
          }
          paramrot = "";
          paramVideoInfo = paramrot;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramrot;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramrot = new HashMap();
          a(nzq.jdField_b_of_type_Int, paramrot);
          ocd.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(nzq.af), String.valueOf(nzq.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramrot.u == null) || (paramrot.u.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrot.u.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
      this.jdField_a_of_type_Tqt = tqt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(rot paramrot)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramrot);
  }
  
  public void a(boolean paramBoolean)
  {
    tps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new tmn(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(rot paramrot, boolean paramBoolean)
  {
    if ((paramrot.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramrot.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1) && (paramrot.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null))
    {
      a(paramrot.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramrot.a.a, paramrot);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Tmj.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nzj != null) && (this.jdField_a_of_type_Tqt != null))
    {
      this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
      tpx.a(jdField_a_of_type_JavaLangString, "doQuery : appId is " + this.jdField_a_of_type_Tqt.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Tqt.e);
      return;
    }
    tpx.a(jdField_a_of_type_JavaLangString, "doQuery cancel, manager is " + this.jdField_a_of_type_Nzj + " downloadData is " + this.jdField_a_of_type_Tqt);
  }
  
  public void b(boolean paramBoolean)
  {
    tps.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new tmo(this, paramBoolean));
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
    if ((this.jdField_a_of_type_Nzj != null) && (this.jdField_a_of_type_Tqt != null)) {
      this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt);
    }
    if (this.jdField_a_of_type_Rot.H != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Tmp == null) {
      return false;
    }
    return tns.a(null, this.jdField_a_of_type_Tmp.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Tqt != null) && (this.jdField_a_of_type_Nzj != null)) {
      this.jdField_a_of_type_Nzj.d(this.jdField_a_of_type_Tqt);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Tqt != null) && (this.jdField_a_of_type_Nzj != null)) {
      this.jdField_a_of_type_Nzj.a(this.jdField_a_of_type_Tqt, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Tqt != null))
    {
      if ((this.jdField_a_of_type_Tqt.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tqt.d))) {
        tqa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tqt.d);
      }
    }
    else {
      return;
    }
    ubd.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Rot == null) {
      return;
    }
    this.jdField_a_of_type_Rot.H.setVisibility(8);
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
      if (this.jdField_a_of_type_Tqt != null)
      {
        bool1 = bhny.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Tqt.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Rot.G.setVisibility(8);
        this.jdField_a_of_type_Rot.H.setVisibility(0);
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
      this.jdField_a_of_type_Rot.G.setVisibility(0);
      this.jdField_a_of_type_Rot.H.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Tqt != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (rot)paramView.getTag();
    int i = nzq.af;
    int j = nzq.jdField_a_of_type_Int;
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
      ocd.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(nzq.af), String.valueOf(nzq.jdField_a_of_type_Int), (String)localObject, b());
      label141:
      label190:
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
              break label190;
            }
            f();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        break;
      } while (this.jdField_a_of_type_Tqt == null);
      if (!a(j, localException1, false)) {
        if (acwa.a())
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
              if (this.jdField_a_of_type_Tqt == null) {
                break label141;
              }
              if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue() != 2) {
                break;
              }
              boolean bool = a(j, localException1, true);
              if (bool) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3) {
                break label349;
              }
              e();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
              {
                localException1.put("download_state", "8");
                i = nzq.e;
              }
              a(i, localException1);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            break;
            label349:
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
                i = nzq.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          tqa.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          tpp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmk
 * JD-Core Version:    0.7.0.1
 */