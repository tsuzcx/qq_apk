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
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
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

public class ugq
  implements View.OnClickListener, umb
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + ugq.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private oil jdField_a_of_type_Oil;
  private shl jdField_a_of_type_Shl;
  private swu jdField_a_of_type_Swu;
  private ugp jdField_a_of_type_Ugp;
  private ugv jdField_a_of_type_Ugv;
  private ule jdField_a_of_type_Ule;
  private ulx jdField_a_of_type_Ulx;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public ugq(QQAppInterface paramQQAppInterface, Activity paramActivity, shl paramshl, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Ugp = new ugp(paramQQAppInterface);
    this.jdField_a_of_type_Int = DisplayUtil.dip2px(paramActivity, 3.0F);
    this.jdField_a_of_type_Shl = paramshl;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Oil = new oil(paramActivity);
    this.jdField_a_of_type_Oil.a(new ugr(this));
  }
  
  private void a(int paramInt, ExposeMode paramExposeMode, JumpMode paramJumpMode, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "游戏组件上报 type = " + paramInt + " adTitle = " + str);
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(26).c(1).a(paramExposeMode).a(paramJumpMode).d(ois.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(int paramInt, ExposeMode paramExposeMode, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    a(paramInt, paramExposeMode, null, paramHashMap, paramBoolean);
  }
  
  private void a(int paramInt, JumpMode paramJumpMode, HashMap<String, Object> paramHashMap)
  {
    a(paramInt, null, paramJumpMode, paramHashMap, false);
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, swu paramswu)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Swu = paramswu;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramswu.r == null) && ((paramswu instanceof swr)))
    {
      paramswu.r = ((ViewGroup)((ViewStub)paramswu.n.findViewById(2131380921)).inflate());
      paramswu.e = ((URLImageView)paramswu.r.findViewById(2131367508));
      paramswu.A = ((TextView)paramswu.r.findViewById(2131367511));
      paramswu.B = ((TextView)paramswu.r.findViewById(2131367510));
      paramswu.C = ((TextView)paramswu.r.findViewById(2131367509));
      paramswu.D = ((TextView)paramswu.r.findViewById(2131367507));
    }
    if (paramswu.r != null)
    {
      paramswu.r.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bgxc.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bgxc.k);
      paramswu.e.setImageDrawable(localURLDrawable);
      paramswu.A.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramswu.B.setText(paramGameAdComData.i);
      if (ukr.a()) {
        paramswu.B.setTextColor(Color.parseColor("#80000000"));
      }
      paramswu.r.setTag(paramswu);
      paramswu.C.setTag(paramswu);
      paramswu.D.setTag(paramswu);
      paramswu.r.setOnClickListener(this);
      paramswu.C.setOnClickListener(this);
      paramswu.D.setOnClickListener(this);
      paramswu.r.setTag(2131381183, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramswu);
      six.a(paramswu.r, 200);
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
    int i = 5;
    if (bhfn.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ule.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = 5;
      }
      a(paramInt, JumpMode.ANDROID_OPEN_APP, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Swu.C.setVisibility(0);
        this.jdField_a_of_type_Swu.D.setVisibility(8);
      }
      return true;
    }
    if (oil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule))
    {
      DownloadInfo localDownloadInfo = bjjq.a().c(this.jdField_a_of_type_Ule.d);
      bjjq.a().a(localDownloadInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
        break label310;
      }
      paramHashMap.put("download_state", "3");
    }
    for (;;)
    {
      a(i, JumpMode.ANDROID_INSTALL, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Swu.C.setVisibility(0);
        this.jdField_a_of_type_Swu.D.setVisibility(8);
      }
      return true;
      if (oil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule))
      {
        d();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
          break label304;
        }
        paramHashMap.put("download_state", "3");
      }
      for (;;)
      {
        a(i, JumpMode.ANDROID_INSTALL, paramHashMap);
        if (paramBoolean)
        {
          this.jdField_a_of_type_Swu.C.setVisibility(0);
          this.jdField_a_of_type_Swu.D.setVisibility(8);
        }
        return true;
        return false;
        label304:
        i = paramInt;
      }
      label310:
      i = paramInt;
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (uks.a(this.jdField_a_of_type_Ugp)) {
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
  
  private void b(swu paramswu)
  {
    Object localObject = anvx.a(2131715613);
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
    bool = ukr.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131717752);
        paramswu.C.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramswu.C.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramswu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramswu.C.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = anvx.a(2131715546))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
        }
        paramswu.C.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (ois.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = anvx.a(2131715576))
          {
            paramswu.C.setTextColor(-1);
            paramswu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramswu.C.setText((CharSequence)localObject);
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
          paramswu.C.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842942);
          paramswu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramswu.C.setText(str);
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
          str = anvx.a(2131715544);
          break label273;
          label387:
          paramswu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = anvx.a(2131715543);
      paramswu.C.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramswu.C.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramswu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;; localObject = anvx.a(2131715518))
    {
      paramswu.C.setTextColor(-1);
      break;
    }
  }
  
  private void c(swu paramswu)
  {
    if ((paramswu != null) && (paramswu.r != null)) {
      paramswu.r.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Ule != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Ule.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bjjq.a().c((String)localObject);
          if ((oil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
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
    int i = 5;
    Object localObject = this.jdField_a_of_type_Ule.d;
    HashMap localHashMap = new HashMap();
    if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        break label189;
      }
      localHashMap.put("download_state", "5");
    }
    for (;;)
    {
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, JumpMode.ANDROID_OPEN_APP, localHashMap);
      return true;
      if (oil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule))
      {
        localObject = bjjq.a().c(this.jdField_a_of_type_Ule.d);
        bjjq.a().a((DownloadInfo)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
          break label184;
        }
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
        a(i, JumpMode.ANDROID_INSTALL, localHashMap);
        return true;
        return false;
        label184:
        i = 1;
      }
      label189:
      i = 1;
    }
  }
  
  private void l()
  {
    int i = 5;
    if (this.jdField_a_of_type_Ule == null) {}
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
          localObject = this.jdField_a_of_type_Ule.d;
          if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Ule == null) || (this.jdField_a_of_type_Oil == null));
    this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
    return;
    Object localObject = new HashMap();
    if (oil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        break label307;
      }
      ((HashMap)localObject).put("download_state", "3");
    }
    for (;;)
    {
      a(i, JumpMode.ANDROID_INSTALL, (HashMap)localObject);
      return;
      c();
      ukq.a(jdField_a_of_type_JavaLangString, "queryCallback and download: appId is " + this.jdField_a_of_type_Ule.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Ule.e);
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        ((HashMap)localObject).put("download_state", "1");
      }
      for (;;)
      {
        a(i, JumpMode.ANDROID_DOWNLOAD, (HashMap)localObject);
        return;
        i = 1;
      }
      label307:
      i = 1;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Swu.C.setVisibility(8);
    this.jdField_a_of_type_Swu.D.setVisibility(0);
    if (!ukr.a())
    {
      this.jdField_a_of_type_Swu.D.setText(anvx.a(2131715579) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Swu.D.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Swu.D.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Swu.D.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Swu.C.setClickable(false);
      this.jdField_a_of_type_Swu.r.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Swu.D.setClickable(false);
      this.jdField_a_of_type_Swu.C.setVisibility(0);
      this.jdField_a_of_type_Swu.D.setVisibility(8);
      return;
      this.jdField_a_of_type_Swu.C.setClickable(true);
      this.jdField_a_of_type_Swu.r.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Ugv = new ugv(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u));
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
      this.jdField_a_of_type_Swu.C.setClickable(false);
      this.jdField_a_of_type_Swu.r.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Swu.D.setClickable(false);
      this.jdField_a_of_type_Swu.C.setVisibility(0);
      this.jdField_a_of_type_Swu.D.setVisibility(8);
      return;
      this.jdField_a_of_type_Swu.C.setClickable(true);
      this.jdField_a_of_type_Swu.r.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Ule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Swu.C.setClickable(true);
      this.jdField_a_of_type_Swu.r.setClickable(true);
      this.jdField_a_of_type_Swu.D.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Swu.C.setVisibility(0);
      this.jdField_a_of_type_Swu.D.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Swu.C.setClickable(false);
      this.jdField_a_of_type_Swu.r.setClickable(false);
      this.jdField_a_of_type_Swu.D.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ugp.a();
  }
  
  public ugp a()
  {
    return this.jdField_a_of_type_Ugp;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Oil.a();
    }
  }
  
  protected void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)))
    {
      localHashMap.put("download_state", "2");
      a(5, null, null, localHashMap, false);
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
          this.jdField_a_of_type_Swu.C.setVisibility(8);
          this.jdField_a_of_type_Swu.D.setVisibility(0);
          this.jdField_a_of_type_Swu.D.setTextColor(Color.parseColor("#262626"));
        } while (!ukr.a());
        this.jdField_a_of_type_Swu.D.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Swu.C.setVisibility(0);
        this.jdField_a_of_type_Swu.C.setText(anvx.a(2131715530));
        if (ukr.a()) {
          this.jdField_a_of_type_Swu.C.setText("安装");
        }
        this.jdField_a_of_type_Swu.C.setTextColor(-1);
        this.jdField_a_of_type_Swu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Swu.D.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Swu.C.setVisibility(0);
        this.jdField_a_of_type_Swu.C.setText(anvx.a(2131715508));
        if (ukr.a()) {
          this.jdField_a_of_type_Swu.C.setText("打开");
        }
        this.jdField_a_of_type_Swu.C.setTextColor(-1);
        this.jdField_a_of_type_Swu.C.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Swu.D.setVisibility(8);
        return;
        this.jdField_a_of_type_Swu.C.setVisibility(8);
        this.jdField_a_of_type_Swu.D.setVisibility(0);
        this.jdField_a_of_type_Swu.D.setText(anvx.a(2131715599));
        this.jdField_a_of_type_Swu.D.setTextColor(-1);
      } while (!ukr.a());
      this.jdField_a_of_type_Swu.D.setText("继续");
      this.jdField_a_of_type_Swu.D.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Swu.C.setVisibility(0);
      this.jdField_a_of_type_Swu.D.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131715589), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) && (this.jdField_a_of_type_Ugv != null) && (this.jdField_a_of_type_Ugv.a == paramLong)) {
      this.jdField_a_of_type_Swu.C.post(new VideoFeedsGameAdComManager.2(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Ulx != null))
    {
      this.jdField_a_of_type_Ulx.a(paramConfiguration);
      this.jdField_a_of_type_Ulx.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, swu paramswu)
  {
    if (paramswu.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramswu.r != null) && (paramswu.r.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
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
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramswu);
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
          olx.a().a(paramswu.getAdapterPosition());
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
            this.jdField_a_of_type_Ugp.a();
          }
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
            olx.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
          }
          paramswu = "";
          paramVideoInfo = paramswu;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramswu;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramswu = new HashMap();
          a(2, ExposeMode.LOOSE, paramswu, true);
          a(2, ExposeMode.STRICT, paramswu, false);
          olh.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(26), String.valueOf(1), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramswu.r == null) || (paramswu.r.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramswu.r.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
      this.jdField_a_of_type_Ule = ule.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(swu paramswu)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramswu);
  }
  
  public void a(boolean paramBoolean)
  {
    ukl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new ugt(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(swu paramswu, boolean paramBoolean)
  {
    if ((paramswu.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramswu.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1) && (paramswu.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null))
    {
      a(paramswu.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramswu.a.a, paramswu);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Ugp.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Oil != null) && (this.jdField_a_of_type_Ule != null))
    {
      this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
      ukq.a(jdField_a_of_type_JavaLangString, "doQuery : appId is " + this.jdField_a_of_type_Ule.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Ule.e);
      return;
    }
    ukq.a(jdField_a_of_type_JavaLangString, "doQuery cancel, manager is " + this.jdField_a_of_type_Oil + " downloadData is " + this.jdField_a_of_type_Ule);
  }
  
  public void b(boolean paramBoolean)
  {
    ukl.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new ugu(this, paramBoolean));
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
    if ((this.jdField_a_of_type_Oil != null) && (this.jdField_a_of_type_Ule != null)) {
      this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule);
    }
    if (this.jdField_a_of_type_Swu.D != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Ugv == null) {
      return false;
    }
    return uhw.a(null, this.jdField_a_of_type_Ugv.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Ule != null) && (this.jdField_a_of_type_Oil != null)) {
      this.jdField_a_of_type_Oil.d(this.jdField_a_of_type_Ule);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Ule != null) && (this.jdField_a_of_type_Oil != null)) {
      this.jdField_a_of_type_Oil.a(this.jdField_a_of_type_Ule, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Ule != null))
    {
      if ((this.jdField_a_of_type_Ule.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.d))) {
        uks.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Ule.d);
      }
    }
    else {
      return;
    }
    uvp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Swu == null) {
      return;
    }
    this.jdField_a_of_type_Swu.D.setVisibility(8);
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
      if (this.jdField_a_of_type_Ule != null)
      {
        bool1 = bhfn.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Ule.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Swu.C.setVisibility(8);
        this.jdField_a_of_type_Swu.D.setVisibility(0);
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
      this.jdField_a_of_type_Swu.C.setVisibility(0);
      this.jdField_a_of_type_Swu.D.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Ule != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (swu)paramView.getTag();
    HashMap localHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    Object localObject3;
    label129:
    int i;
    switch (paramView.getId())
    {
    default: 
    case 2131367509: 
      for (;;)
      {
        localObject3 = "";
        localObject1 = localObject3;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
        {
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
          }
        }
        olh.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(26), String.valueOf(1), (String)localObject1, b());
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
            }
            try
            {
              i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
              if (i == 1) {
                break;
              }
              if (i != 3) {
                break label195;
              }
              f();
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
          break;
        } while (this.jdField_a_of_type_Ule == null);
        if (!a(1, localHashMap, false)) {
          if (acik.a())
          {
            if (i == 2) {
              b();
            }
          }
          else if (!f()) {
            a(false);
          }
        }
      }
    case 2131367507: 
      label195:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ule == null) {
          break label129;
        }
        if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue() != 2) {
          break;
        }
        boolean bool = a(1, localHashMap, true);
        if (bool) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3) {
          break label376;
        }
        e();
        JumpMode localJumpMode = JumpMode.ANDROID_DOWNLOAD_PAUSE;
        localObject3 = localJumpMode;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
          break label569;
        }
        localHashMap.put("download_state", "8");
        i = 5;
        a(i, localJumpMode, localHashMap);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      break;
      label376:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 0))
      {
        c();
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 4) {}
        for (localObject2 = JumpMode.ANDROID_DOWNLOAD_CONTINUE;; localObject2 = JumpMode.ANDROID_DOWNLOAD)
        {
          localObject3 = localObject2;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
            break label569;
          }
          localHashMap.put("download_state", "9");
          i = 5;
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdComponent);
        }
        this.jdField_b_of_type_Boolean = false;
        uks.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        localObject3 = uki.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, "");
        localObject2 = ueb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3050107L, 9L, "", "");
        localObject3 = uec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 39, 119, (JumpMode)localObject3);
        ((ufy)localObject3).e((JSONObject)localObject2);
        ois.a(((ufy)localObject3).a());
        break;
        i = 1;
        localObject2 = localObject3;
        continue;
      }
      label569:
      Object localObject2 = null;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */