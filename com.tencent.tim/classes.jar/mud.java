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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class mud
  implements View.OnClickListener, kns.a
{
  private static final String TAG = "Q.readinjoy.video." + mud.class.getSimpleName();
  private Set<String> J = new HashSet();
  private Set<String> K = new HashSet();
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private jzj jdField_a_of_type_Jzj;
  private kns jdField_a_of_type_Kns;
  private mtg.l jdField_a_of_type_Mtg$l;
  private muc jdField_a_of_type_Muc;
  private mud.a jdField_a_of_type_Mud$a;
  private final int aUB;
  private AdvertisementInfo advertisementInfo;
  private boolean afT;
  private String akk;
  private mrm jdField_b_of_type_Mrm;
  private mtg jdField_b_of_type_Mtg;
  private boolean isUserClick;
  private Activity mActivity;
  private String mCurrentVid;
  private boolean mIsShowing;
  private int orientation;
  
  public mud(QQAppInterface paramQQAppInterface, Activity paramActivity, mtg parammtg, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Muc = new muc(paramQQAppInterface);
    this.aUB = aqcx.dip2px(paramActivity, 3.0F);
    this.jdField_b_of_type_Mtg = parammtg;
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Jzj = new jzj(paramActivity, true, paramVideoFeedsRecyclerView);
  }
  
  private boolean En()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xc)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.sGameName)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xb));
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.mCurrentVid);
    jzk.a(new kku.a().a(this.mActivity).a(paramInt).b(jzk.aFO).c(jzk.aGb).d(jzk.a(null, this.advertisementInfo.mRowKey, this.akk, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.WX, paramHashMap)).a(this.advertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, mtg.l paraml)
  {
    this.mIsShowing = true;
    this.jdField_a_of_type_Mtg$l = paraml;
    this.isUserClick = false;
    this.afT = false;
    if ((paraml.bv == null) && ((paraml instanceof mtg.k)))
    {
      paraml.bv = ((ViewGroup)((ViewStub)paraml.bt.findViewById(2131381698)).inflate());
      paraml.B = ((URLImageView)paraml.bv.findViewById(2131367848));
      paraml.rU = ((TextView)paraml.bv.findViewById(2131367851));
      paraml.rV = ((TextView)paraml.bv.findViewById(2131367850));
      paraml.rW = ((TextView)paraml.bv.findViewById(2131367849));
      paraml.rX = ((TextView)paraml.bv.findViewById(2131367847));
    }
    if (paraml.bv != null)
    {
      paraml.bv.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.Xc)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.Xc, localURLDrawableOptions);
      localURLDrawable.setTag(aqbn.d(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.aUB));
      localURLDrawable.setDecodeHandler(aqbn.j);
      paraml.B.setImageDrawable(localURLDrawable);
      paraml.rU.setText(paramGameAdComData.sGameName);
      paraml.rV.setText(paramGameAdComData.Xb);
      if (knc.zR()) {
        paraml.rV.setTextColor(Color.parseColor("#80000000"));
      }
      paraml.bv.setTag(paraml);
      paraml.rW.setTag(paraml);
      paraml.rX.setTag(paraml);
      paraml.bv.setOnClickListener(this);
      paraml.rW.setOnClickListener(this);
      paraml.rX.setOnClickListener(this);
      paraml.bv.setTag(2131381960, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      bindData();
      g(paraml);
      muj.a(paraml.bv, 200);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "后台下发的url格式有问题：" + paramGameAdComData.Xc);
        }
      }
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.jdField_b_of_type_Mrm.mPackageName))
    {
      aDH();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = jzk.aEN;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
        this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!jzh.a(this.mActivity, this.jdField_b_of_type_Mrm)) {
          break;
        }
        DownloadInfo localDownloadInfo = arvv.a().f(this.jdField_b_of_type_Mrm.mPackageName);
        arvv.a().d(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = jzk.aEN;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      return true;
      if (!jzg.a(this.jdField_b_of_type_Mrm, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState)) {
        break;
      }
      aDF();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = jzk.aEN;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
    this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
    return true;
    return false;
  }
  
  private void aDI()
  {
    if (this.jdField_b_of_type_Mrm == null) {}
    do
    {
      do
      {
        return;
        if (this.isUserClick) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState == 4)
        {
          ck(4, getProgress());
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState == 5)
        {
          localObject = this.jdField_b_of_type_Mrm.mPackageName;
          if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 1;
            ck(1, getProgress());
            return;
          }
          ck(5, getProgress());
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState != 3);
      ck(3, getProgress());
    } while ((this.jdField_b_of_type_Mrm == null) || (this.jdField_a_of_type_Jzj == null));
    this.jdField_a_of_type_Jzj.a(this.jdField_b_of_type_Mrm);
    return;
    int i = jzk.aEJ;
    Object localObject = new HashMap();
    if (jzg.a(this.jdField_b_of_type_Mrm, getDownloadState()))
    {
      aDF();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk))
      {
        i = jzk.aEN;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    doDownload();
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk))
    {
      i = jzk.aEN;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void aEn()
  {
    this.jdField_a_of_type_Mtg$l.rW.setVisibility(8);
    this.jdField_a_of_type_Mtg$l.rX.setVisibility(0);
    if (!knc.zR())
    {
      this.jdField_a_of_type_Mtg$l.rX.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Mtg$l.rX.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.progress + "%");
    this.jdField_a_of_type_Mtg$l.rX.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void aFf()
  {
    if (zA())
    {
      this.jdField_a_of_type_Mtg$l.rW.setClickable(false);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mtg$l.rX.setClickable(false);
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      return;
      this.jdField_a_of_type_Mtg$l.rW.setClickable(true);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(true);
    }
  }
  
  private void aFg()
  {
    if ((zy()) && (this.jdField_b_of_type_Mrm != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mDownloadUrl)))
    {
      this.jdField_a_of_type_Mtg$l.rW.setClickable(true);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(true);
      this.jdField_a_of_type_Mtg$l.rX.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      aDU();
      return;
      this.jdField_a_of_type_Mtg$l.rW.setClickable(false);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(false);
      this.jdField_a_of_type_Mtg$l.rX.setClickable(false);
    }
  }
  
  private void aSs()
  {
    if (Eo())
    {
      this.jdField_a_of_type_Mtg$l.rW.setClickable(false);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mtg$l.rX.setClickable(false);
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      return;
      this.jdField_a_of_type_Mtg$l.rW.setClickable(true);
      this.jdField_a_of_type_Mtg$l.bv.setClickable(true);
    }
  }
  
  private void aSt()
  {
    try
    {
      this.jdField_a_of_type_Mud$a = new mud.a(new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xm));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void g(mtg.l paraml)
  {
    String str2 = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        Object localObject;
        continue;
        String str1 = "";
      }
    }
    bool = knc.zR();
    if (i == 1) {
      if (zA())
      {
        paraml.rW.setTextColor(Color.parseColor("#262626"));
        if (!bool) {
          break label379;
        }
        paraml.rW.setTextColor(Color.parseColor("#80000000"));
        localObject = "";
        paraml.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    do
    {
      paraml.rW.setText((CharSequence)localObject);
      return;
      localObject = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xn)) {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xn;
      }
      paraml.rW.setTextColor(-1);
      break;
      if (i != 2) {
        break label307;
      }
      localObject = str2;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.WX));
    if (jzk.C(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.WX))
    {
      paraml.rW.setTextColor(-1);
      paraml.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      paraml.rW.setText("");
      return;
    }
    paraml.rW.setTextColor(-1);
    if (!bool)
    {
      localObject = this.mActivity.getResources().getDrawable(2130843720);
      paraml.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      paraml.rW.setText("");
      localObject = str2;
      if (this.isUserClick) {
        break;
      }
      localObject = str2;
      if (this.afT) {
        break;
      }
      this.afT = true;
      aDE();
      return;
      paraml.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label307:
    if (Eo())
    {
      paraml.rW.setTextColor(Color.parseColor("#262626"));
      if (bool) {
        paraml.rW.setTextColor(Color.parseColor("#80000000"));
      }
    }
    for (;;)
    {
      paraml.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      localObject = str2;
      break;
      paraml.rW.setTextColor(-1);
    }
  }
  
  private boolean h(VideoInfo paramVideoInfo)
  {
    if (this.J.contains(paramVideoInfo.vid)) {
      return false;
    }
    if (knd.a(this.jdField_a_of_type_Muc)) {
      return true;
    }
    return this.K.contains(paramVideoInfo.vid);
  }
  
  private void i(mtg.l paraml)
  {
    if ((paraml != null) && (paraml.bv != null)) {
      paraml.bv.setVisibility(8);
    }
  }
  
  private String ku()
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
      QLog.d(TAG, 2, localException.getMessage());
    }
    return localObject1;
    return "";
  }
  
  private boolean zv()
  {
    Object localObject = this.jdField_b_of_type_Mrm.mPackageName;
    int i = jzk.aFO;
    i = jzk.aEJ;
    HashMap localHashMap = new HashMap();
    if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), (String)localObject))
    {
      aDH();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk))
      {
        i = jzk.aEN;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.mCurrentVid);
      a(i, localHashMap);
      return true;
    }
    if (jzh.a(this.mActivity, this.jdField_b_of_type_Mrm))
    {
      localObject = arvv.a().f(this.jdField_b_of_type_Mrm.mPackageName);
      arvv.a().d((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk))
      {
        i = jzk.aFO;
        i = jzk.aEN;
        localHashMap.put("download_state", "3");
      }
      localHashMap.put("vid", this.mCurrentVid);
      a(i, localHashMap);
      return true;
    }
    return false;
  }
  
  private boolean zw()
  {
    if ((zy()) && (this.jdField_b_of_type_Mrm != null)) {
      try
      {
        String str = this.jdField_b_of_type_Mrm.mPackageName;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = arvv.a().f(str);
          if ((jzh.B(this.mActivity, str)) && (localDownloadInfo != null) && (localDownloadInfo.getState() == 4))
          {
            aDG();
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
  
  protected boolean Eo()
  {
    if (this.jdField_a_of_type_Mud$a == null) {
      return false;
    }
    return klt.a(null, this.jdField_a_of_type_Mud$a.wP);
  }
  
  public muc a()
  {
    return this.jdField_a_of_type_Muc;
  }
  
  public boolean a(mtg.l paraml, boolean paramBoolean)
  {
    if ((paraml.a.d.advertisementInfo != null) && (paraml.a.d.advertisementInfo.mSoftAdType == 1))
    {
      l(paraml.a.d.advertisementInfo);
      if (!paramBoolean) {
        b(paraml.a.d, paraml);
      }
      return true;
    }
    return false;
  }
  
  public void aDD()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.2(this));
  }
  
  protected void aDE()
  {
    if ((this.jdField_a_of_type_Jzj != null) && (this.jdField_b_of_type_Mrm != null)) {
      this.jdField_a_of_type_Jzj.c(this.jdField_b_of_type_Mrm);
    }
  }
  
  protected void aDF()
  {
    if ((this.jdField_b_of_type_Mrm != null) && (this.jdField_a_of_type_Jzj != null)) {
      this.jdField_a_of_type_Jzj.f(this.jdField_b_of_type_Mrm);
    }
  }
  
  protected void aDG()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.progress = 100;
  }
  
  protected void aDH()
  {
    if ((zy()) && (this.jdField_b_of_type_Mrm != null))
    {
      if ((this.jdField_b_of_type_Mrm.anA) && (!TextUtils.isEmpty(this.jdField_b_of_type_Mrm.mPackageName))) {
        knd.D(this.mActivity, this.jdField_b_of_type_Mrm.mPackageName);
      }
    }
    else {
      return;
    }
    ods.b(this.mActivity, this.advertisementInfo, null, (int)this.advertisementInfo.mChannelID, true);
  }
  
  protected void aDU()
  {
    try
    {
      if (this.jdField_b_of_type_Mrm != null)
      {
        bool1 = aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.jdField_b_of_type_Mrm.mPackageName);
        boolean bool2 = zw();
        if ((bool1) || (bool2) || ((getDownloadState() != 4) && (getDownloadState() != 3)) || (getProgress() < 0) || (getProgress() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Mtg$l.rW.setVisibility(8);
        this.jdField_a_of_type_Mtg$l.rX.setVisibility(0);
        ck(getDownloadState(), getProgress());
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
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
    }
  }
  
  public void b(VideoInfo paramVideoInfo, mtg.l paraml)
  {
    if (paraml.be.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paraml.bv != null) && (paraml.bv.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.vid)) && (!En()) && (h(paramVideoInfo))));
      if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
      {
        if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk))
        {
          aSt();
          if (Eo())
          {
            this.K.add(paramVideoInfo.vid);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paraml);
        this.mCurrentVid = paramVideoInfo.vid;
        paraml = new StringBuilder();
        if ((paramVideoInfo.a != null) && (paramVideoInfo.a.jU != null) && (!paramVideoInfo.a.jU.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.a.jU.iterator();
          while (localIterator.hasNext()) {
            paraml.append(((VideoInfo.KdTagItem)localIterator.next()).name).append(",");
          }
        }
        paraml = paraml.toString();
        if (TextUtils.isEmpty(paraml)) {}
        for (paraml = "";; paraml = paraml.substring(0, paraml.length() - 1))
        {
          this.akk = paraml;
          if (this.J.contains(paramVideoInfo.vid)) {
            break;
          }
          this.J.add(paramVideoInfo.vid);
          this.jdField_a_of_type_Muc.aSr();
          paraml = "";
          paramVideoInfo = paraml;
          if (this.advertisementInfo != null)
          {
            paramVideoInfo = paraml;
            if (!TextUtils.isEmpty(this.advertisementInfo.mAdViewId)) {
              paramVideoInfo = this.advertisementInfo.mAdViewId;
            }
          }
          paraml = new HashMap();
          a(jzk.aEK, paraml);
          kbp.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(jzk.aFO), String.valueOf(jzk.aEJ), paramVideoInfo, ku());
          return;
        }
      }
    } while ((paraml.bv == null) || (paraml.bv.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "默认不显示引流条");
    }
    paraml.bv.setVisibility(8);
  }
  
  protected void bindData()
  {
    if (this.jdField_a_of_type_Mtg$l == null) {
      return;
    }
    this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
    int i = ns();
    if (i == 1)
    {
      aFf();
      return;
    }
    if (i == 2)
    {
      aFg();
      return;
    }
    aSs();
  }
  
  public void ck(int paramInt1, int paramInt2)
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
          aEn();
          this.jdField_a_of_type_Mtg$l.rW.setVisibility(8);
          this.jdField_a_of_type_Mtg$l.rX.setVisibility(0);
          this.jdField_a_of_type_Mtg$l.rX.setTextColor(Color.parseColor("#262626"));
        } while (!knc.zR());
        this.jdField_a_of_type_Mtg$l.rX.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
        if (knc.zR()) {
          this.jdField_a_of_type_Mtg$l.rW.setText("安装");
        }
        this.jdField_a_of_type_Mtg$l.rW.setTextColor(-1);
        this.jdField_a_of_type_Mtg$l.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
        ph(paramInt1);
        return;
        this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
        if (knc.zR()) {
          this.jdField_a_of_type_Mtg$l.rW.setText("打开");
        }
        this.jdField_a_of_type_Mtg$l.rW.setTextColor(-1);
        this.jdField_a_of_type_Mtg$l.rW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
        return;
        this.jdField_a_of_type_Mtg$l.rW.setVisibility(8);
        this.jdField_a_of_type_Mtg$l.rX.setVisibility(0);
        this.jdField_a_of_type_Mtg$l.rX.setTextColor(-1);
      } while (!knc.zR());
      this.jdField_a_of_type_Mtg$l.rX.setText("继续");
      this.jdField_a_of_type_Mtg$l.rX.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Mtg$l.rW.setVisibility(0);
      this.jdField_a_of_type_Mtg$l.rX.setVisibility(8);
      return;
    }
    aDI();
  }
  
  protected void doDownload()
  {
    if ((this.jdField_a_of_type_Jzj != null) && (this.jdField_b_of_type_Mrm != null)) {
      this.jdField_a_of_type_Jzj.a(this.jdField_b_of_type_Mrm);
    }
    if (this.jdField_a_of_type_Mtg$l.rX != null) {
      aEn();
    }
  }
  
  public void doOnDestory()
  {
    this.isUserClick = false;
    this.mActivity = null;
    if (this.jdField_a_of_type_Jzj != null) {
      this.jdField_a_of_type_Jzj.doOnDestory();
    }
  }
  
  public void doOnResume()
  {
    this.isUserClick = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_b_of_type_Mrm != null)) {
      aDE();
    }
  }
  
  protected void doPause()
  {
    if ((this.jdField_b_of_type_Mrm != null) && (this.jdField_a_of_type_Jzj != null)) {
      this.jdField_a_of_type_Jzj.a(this.jdField_b_of_type_Mrm, true);
    }
  }
  
  public void el(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk)) && (this.jdField_a_of_type_Mud$a != null) && (this.jdField_a_of_type_Mud$a.wP == paramLong)) {
      this.jdField_a_of_type_Mtg$l.rW.post(new VideoFeedsGameAdComManager.1(this));
    }
  }
  
  protected int getDownloadState()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState;
  }
  
  protected int getProgress()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.progress;
  }
  
  public void h(mtg.l paraml)
  {
    this.mIsShowing = false;
    i(paraml);
  }
  
  public void l(AdvertisementInfo paramAdvertisementInfo)
  {
    this.advertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk)) {
      this.jdField_b_of_type_Mrm = mrm.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  protected int ns()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk).intValue();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (mtg.l)paramView.getTag();
    int i = jzk.aFO;
    int j = jzk.aEJ;
    localObject = new HashMap();
    this.isUserClick = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      String str = "";
      localObject = str;
      if (this.advertisementInfo != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.advertisementInfo.mAdViewId)) {
          localObject = this.advertisementInfo.mAdViewId;
        }
      }
      kbp.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(jzk.aFO), String.valueOf(jzk.aEJ), (String)localObject, ku());
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
            i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk).intValue();
            if (i == 1) {
              break;
            }
            if (i != 3) {
              break label190;
            }
            aDD();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        break;
      } while (this.jdField_b_of_type_Mrm == null);
      if (!a(j, localException1, false)) {
        if (tll.isWifiConnected())
        {
          if (i == 2) {
            aDE();
          }
        }
        else if (!zv())
        {
          or(false);
          continue;
          for (;;)
          {
            try
            {
              if (this.jdField_b_of_type_Mrm == null) {
                break label141;
              }
              if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk).intValue() != 2) {
                break;
              }
              boolean bool = a(j, localException1, true);
              if (bool) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState != 3) {
                break label349;
              }
              doPause();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk.equals("2"))
              {
                localException1.put("download_state", "8");
                i = jzk.aEN;
              }
              a(i, localException1);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            break;
            label349:
            if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState != 4)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.downloadState != 0) {}
            }
            else
            {
              doDownload();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk.equals("2"))
              {
                localException2.put("download_state", "9");
                i = jzk.aEN;
              }
            }
          }
          this.isUserClick = false;
          knd.f(this.advertisementInfo);
          kmx.g(this.mActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xh, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xi, "");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Kns != null))
    {
      this.jdField_a_of_type_Kns.onConfigurationChanged(paramConfiguration);
      this.jdField_a_of_type_Kns.dismiss();
    }
    this.orientation = paramConfiguration.orientation;
  }
  
  public void or(boolean paramBoolean)
  {
    kna.b(this.mActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.Xv, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.WX, new muf(this, paramBoolean));
  }
  
  public void os(boolean paramBoolean)
  {
    kna.a(this.mActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.WX, new mug(this, paramBoolean));
  }
  
  public int pM()
  {
    return this.jdField_a_of_type_Muc.pL();
  }
  
  public int pN()
  {
    return this.jdField_a_of_type_Muc.pH();
  }
  
  protected void ph(int paramInt)
  {
    int i = jzk.aEJ;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.Xk)))
    {
      paramInt = jzk.aEN;
      localHashMap.put("download_state", "2");
      a(paramInt, localHashMap);
    }
  }
  
  protected boolean zA()
  {
    return false;
  }
  
  protected boolean zy()
  {
    return true;
  }
  
  public class a
  {
    public String akl;
    public String akm;
    public String akn;
    public long wP;
    
    a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return;
      }
      this.akl = paramJSONObject.optString("sActivityId");
      this.akm = paramJSONObject.optString("sGiftName");
      this.akn = paramJSONObject.optString("sNeedRole");
      this.wP = paramJSONObject.optInt("iGiftId");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mud
 * JD-Core Version:    0.7.0.1
 */