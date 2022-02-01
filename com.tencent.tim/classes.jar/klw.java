import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;
import org.json.JSONException;
import org.json.JSONObject;

public class klw
  implements mxm.b
{
  private Set<String> J;
  private Set<String> K;
  private Set<String> L;
  private jzr jdField_a_of_type_Jzr;
  private mtg.l jdField_a_of_type_Mtg$l;
  private muc jdField_a_of_type_Muc;
  private mxm.a jdField_a_of_type_Mxm$a;
  private int aJK;
  private boolean agn;
  private boolean ago;
  private boolean agp;
  private boolean agq;
  private boolean agr;
  private mrm b;
  private VideoInfo c;
  private HashMap<String, mrm> dm = new HashMap();
  private boolean isUserClick;
  private int linkType = -1;
  private Activity mActivity;
  
  private JSONObject a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 3;
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("source_id", this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId);
        localJSONObject2.put("platform_id", this.c.advertisementInfo.mAdvertisementSoftInfo.aJL);
        localJSONObject2.put("goods_type", this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType);
        localJSONObject2.put("goods_id", this.c.advertisementInfo.mAdvertisementSoftInfo.aay);
        localJSONObject2.put("goods_name", this.c.advertisementInfo.mAdvertisementSoftInfo.goodsName);
        localJSONObject2.put("account_id", this.c.advertisementInfo.mAdvertisementSoftInfo.accountId);
        localJSONObject2.put("content_type", 1);
        localJSONObject2.put("rowkey", this.c.advertisementInfo.mRowKey);
        localJSONObject2.put("cmsid", this.c.advertisementInfo.mAdvertisementSoftInfo.aaL);
        if (paramInt3 != -1) {
          localJSONObject2.put("button_state", paramInt3);
        }
        if (this.agq)
        {
          paramInt3 = i;
          if (this.agn) {
            paramInt3 = 4;
          }
          localJSONObject2.put("card_style", paramInt3);
          if (paramBoolean) {
            localJSONObject2.put("is_ams_reported", 1);
          }
          if (paramInt1 == jzk.aEJ)
          {
            if (paramInt2 != 0) {
              localJSONObject2.put("click_pos", paramInt2);
            }
            localJSONObject2.put("link_type", this.linkType);
            localJSONObject2.put("click_type", 3);
            localJSONObject1.put("click_info_report", localJSONObject2.toString());
            return localJSONObject1;
          }
        }
        else
        {
          if (!this.agn) {
            break label355;
          }
          paramInt3 = 1;
          continue;
        }
        localJSONObject2.put("exposure_type", 3);
        localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
        return localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      label355:
      paramInt3 = 0;
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d = paramLong / 1000L * paramDouble / 100.0D;
    if (this.agq)
    {
      if (TextUtils.isEmpty(paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaN)) {
        break label148;
      }
      if (paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaN.equals("1")) {
        if (paramDouble <= Integer.valueOf(paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaO).intValue()) {}
      }
    }
    while (paramDouble > this.aJK)
    {
      int i;
      do
      {
        return true;
        return false;
        if (!paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaN.equals("2")) {
          break;
        }
        i = Integer.valueOf(paramVideoInfo.advertisementInfo.mAdvertisementSoftInfo.aaP).intValue();
      } while ((d != 0.0D) && (d > i));
      return false;
    }
    return false;
    label148:
    return false;
  }
  
  private void aDW()
  {
    if (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId == 0)
    {
      ods.a(this.mActivity, this.c.advertisementInfo, null, 3, true);
      this.agp = true;
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aax)) || (TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aaw))) {
        break;
      }
      this.linkType = 1;
    } while (ods.a(this.c.advertisementInfo.mAdvertisementSoftInfo.aaw, this.mActivity));
    if (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aax)) {
      this.linkType = 0;
    }
    for (;;)
    {
      kmx.g(this.mActivity, this.c.advertisementInfo.mAdvertisementSoftInfo.jmpUrl, this.c.advertisementInfo.mAdvertisementSoftInfo.aax, "");
      this.agp = false;
      return;
      if (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.jmpUrl)) {
        this.linkType = 2;
      }
    }
  }
  
  private void aEl()
  {
    if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.b.mPackageName)) {
      this.jdField_a_of_type_Mtg$l.bT.setVisibility(0);
    }
    while (this.b.mState != 5) {
      return;
    }
    this.jdField_a_of_type_Mtg$l.bT.setVisibility(0);
  }
  
  private void aEm()
  {
    if (this.c != null)
    {
      String str = this.c.vid;
      if (this.c.vid != null) {
        str = this.c.vid + "_B";
      }
      if ((this.L != null) && (!this.L.contains(str)))
      {
        this.L.add(str);
        onExposure();
      }
    }
  }
  
  private void aEn()
  {
    if (this.agq) {}
    for (ReadInjoyHeaderAdDownloadView localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Mtg$l.b;; localReadInjoyHeaderAdDownloadView = this.jdField_a_of_type_Mtg$l.a)
    {
      localReadInjoyHeaderAdDownloadView.updateProgress(this.b.aTP);
      return;
    }
  }
  
  private CharSequence b()
  {
    float f = 13.0F;
    if (TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aaA))
    {
      this.c.advertisementInfo.mAdvertisementSoftInfo.aaA = this.c.advertisementInfo.mAdvertisementSoftInfo.aaz;
      this.c.advertisementInfo.mAdvertisementSoftInfo.aaz = "";
    }
    String str1 = this.c.advertisementInfo.mAdvertisementSoftInfo.aaA + " " + this.c.advertisementInfo.mAdvertisementSoftInfo.aaz;
    if (!TextUtils.isEmpty(str1.trim()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      int j;
      if (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aaA))
      {
        str2 = this.c.advertisementInfo.mAdvertisementSoftInfo.aaA;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(wja.dp2px(13.0F, this.mActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new klw.a(wja.dp2px(4.0F, this.mActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.c.advertisementInfo.mAdvertisementSoftInfo.aaz;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (zN()) {
          break label403;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!zN()) {
          break label428;
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(wja.dp2px(f, this.mActivity.getResources())), i, j, 33);
        return localSpannableStringBuilder;
        label403:
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
        break;
        label428:
        f = 11.0F;
      }
    }
    return this.c.advertisementInfo.mAdvertisementSoftInfo.buttonTxt;
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    this.c = paramVideoInfo;
    if ((this.c.advertisementInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo != null))
    {
      this.aJK = this.c.advertisementInfo.mAdvertisementSoftInfo.aJK;
      this.agq = this.c.advertisementInfo.mAdvertisementSoftInfo.aaM.equals("1");
      this.agr = false;
    }
  }
  
  private int cV(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    case 3: 
      return 1;
    case 4: 
      return 4;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    jzk.a(new kku.a().a(this.mActivity).a(paramInt1).b(jzk.aFW).e(a(paramInt1, paramInt2, paramInt3, paramBoolean)).a(this.c.advertisementInfo).a());
  }
  
  private String iq()
  {
    return this.c.advertisementInfo.mAdvertisementSoftInfo.aav;
  }
  
  private void onExposure()
  {
    report(jzk.aEK, -1);
  }
  
  private void report(int paramInt1, int paramInt2)
  {
    d(paramInt1, 0, paramInt2, false);
  }
  
  private void setClickPos(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.c != null) && (this.c.advertisementInfo != null)) {
        this.c.advertisementInfo.setClickPos(paramInt);
      }
      return;
      paramInt = 41;
      continue;
      paramInt = 42;
      continue;
      paramInt = 8;
      continue;
      paramInt = 40;
    }
  }
  
  private boolean zO()
  {
    return (this.c != null) && (this.c.advertisementInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId == 0);
  }
  
  public CharSequence a()
  {
    if ((this.c.advertisementInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject;
      if ((this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 1) || (this.c.advertisementInfo.mAdProductType == 12))
      {
        localObject = this.c.advertisementInfo.mAdvertisementSoftInfo.buttonTxt;
        return localObject;
      }
      if (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 0) {
        return b();
      }
      if (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 2)
      {
        if (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId != 0) {}
        for (String str = this.c.advertisementInfo.mAdvertisementSoftInfo.buttonTxt;; str = this.c.advertisementInfo.mAdDesc)
        {
          localObject = str;
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          return this.c.advertisementInfo.mAdvertisementSoftInfo.buttonTxt;
        }
      }
    }
    return null;
  }
  
  public void a(VideoInfo paramVideoInfo, mtg.l paraml)
  {
    this.isUserClick = false;
    this.jdField_a_of_type_Mtg$l = paraml;
    String str;
    mrm localmrm2;
    mrm localmrm1;
    if (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId == 0) {
      if (this.c.advertisementInfo.mAdProductType == 12)
      {
        str = paramVideoInfo.vid;
        localmrm2 = (mrm)this.dm.get(str);
        localmrm1 = localmrm2;
        if (localmrm2 == null)
        {
          localmrm1 = mrm.a(this.c.advertisementInfo);
          this.dm.put(str, localmrm1);
        }
        if (localmrm1 != null)
        {
          this.c.advertisementInfo.mAdvertisementSoftInfo.aaC = localmrm1.mPackageName;
          if ((jzg.a(BaseApplicationImpl.getApplication(), localmrm1)) || (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), localmrm1.mPackageName))) {
            localmrm1.mState = 5;
          }
          this.b = localmrm1;
          if (!this.agq) {
            break label248;
          }
          aEl();
          paraml.b.ct(cV(localmrm1.mState), localmrm1.aTP);
        }
      }
    }
    label459:
    for (;;)
    {
      paraml.by.setTag(2131381960, this.c.advertisementInfo.mAdvertisementSoftInfo);
      if (!this.J.contains(paramVideoInfo.vid))
      {
        this.J.add(paramVideoInfo.vid);
        this.jdField_a_of_type_Muc.aSr();
        onExposure();
      }
      return;
      label248:
      paraml.a.ct(cV(localmrm1.mState), localmrm1.aTP);
      continue;
      if (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 1)
      {
        str = paramVideoInfo.vid;
        localmrm2 = (mrm)this.dm.get(str);
        int i = knd.f(this.c.advertisementInfo);
        localmrm1 = localmrm2;
        if (localmrm2 == null)
        {
          localmrm1 = mrm.a(this.c.advertisementInfo.mAdvertisementSoftInfo, i);
          this.dm.put(str, localmrm1);
        }
        if ((jzg.a(BaseApplicationImpl.getApplication(), localmrm1)) || (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), localmrm1.mPackageName))) {
          localmrm1.mState = 5;
        }
        this.b = localmrm1;
        if (this.agq)
        {
          aEl();
          paraml.b.ct(cV(localmrm1.mState), localmrm1.aTP);
        }
        for (;;)
        {
          if (i == 0) {
            break label459;
          }
          aDE();
          break;
          paraml.a.ct(cV(localmrm1.mState), localmrm1.aTP);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.mActivity = paramActivity;
    this.J = new HashSet();
    this.K = new HashSet();
    this.L = new HashSet();
    this.jdField_a_of_type_Jzr = new jzr(paramActivity, true, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Muc = new muc(paramQQAppInterface);
  }
  
  public void a(mtg.l paraml)
  {
    LinearLayout.LayoutParams localLayoutParams1;
    if (!this.agq)
    {
      localLayoutParams1 = (LinearLayout.LayoutParams)paraml.lT.getLayoutParams();
      if (TextUtils.isEmpty(paraml.sd.getText().toString().trim()))
      {
        paraml.sd.setVisibility(8);
        localLayoutParams1.gravity = 16;
        paraml.lT.setLayoutParams(localLayoutParams1);
        if ((this.c.advertisementInfo.mAdProductType == 12) || (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 1)) {
          break label209;
        }
        paraml.a.setVisibility(8);
        paraml.lT.setVisibility(0);
        label111:
        if ((this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 0) && (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aav))) {
          paraml.sc.setText(iq());
        }
      }
    }
    for (;;)
    {
      return;
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)paraml.sd.getLayoutParams();
      localLayoutParams2.topMargin = wja.dp2px(1.0F, this.mActivity.getResources());
      paraml.sd.setLayoutParams(localLayoutParams2);
      paraml.sd.setVisibility(0);
      localLayoutParams1.gravity = 16;
      break;
      label209:
      paraml.a.setVisibility(0);
      paraml.lT.setVisibility(8);
      break label111;
      if ((this.c.advertisementInfo.mAdProductType != 12) && (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType != 1))
      {
        paraml.b.setVisibility(8);
        paraml.bT.setVisibility(0);
      }
      while ((this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 0) && (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aav)))
      {
        paraml.sf.setText(iq());
        return;
        paraml.b.setVisibility(0);
        paraml.bT.setVisibility(0);
      }
    }
  }
  
  public void a(mtg.l paraml, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      return;
    }
    this.b.aTP = paramInt2;
    if (paramInt1 != 8) {
      this.b.mState = paramInt1;
    }
    this.ago = false;
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
      return;
    case 1: 
      if (this.agq)
      {
        paraml.bT.setVisibility(0);
        paraml.b.ct(2, 100);
      }
    case 3: 
    case 5: 
      for (;;)
      {
        this.ago = true;
        if (!this.agn) {
          break;
        }
        if (!this.agq) {
          break label254;
        }
        paraml.b.setVisibility(0);
        return;
        aEn();
        if (!this.agq) {
          break;
        }
        paraml.bT.setVisibility(8);
        return;
        if (this.agq)
        {
          paraml.bT.setVisibility(0);
          paraml.b.ct(2, 100);
          this.ago = true;
          if (this.agn)
          {
            if (!this.agq) {
              break label230;
            }
            paraml.b.setVisibility(0);
          }
        }
        for (;;)
        {
          ph(paramInt1);
          return;
          paraml.a.ct(2, 100);
          break;
          paraml.lU.setVisibility(0);
        }
        paraml.a.ct(2, 100);
      }
      paraml.lU.setVisibility(0);
      return;
    case 4: 
      if (this.agq)
      {
        paraml.bT.setVisibility(8);
        paraml.b.ct(4, paramInt2);
        return;
      }
      paraml.a.ct(4, paramInt2);
      return;
    case 6: 
      label230:
      label254:
      if (this.agq)
      {
        paraml.bT.setVisibility(0);
        paraml.b.ct(0, 0);
        return;
      }
      paraml.a.ct(0, 0);
      return;
    }
    aDI();
  }
  
  public void a(mxm.a parama)
  {
    this.jdField_a_of_type_Mxm$a = parama;
  }
  
  public boolean a(VideoInfo paramVideoInfo, mtg.l paraml, double paramDouble, long paramLong)
  {
    if ((paraml.by != null) && (paraml.by.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "进度判断 video_percent=" + paramDouble);
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  protected void aDE()
  {
    if ((this.jdField_a_of_type_Jzr != null) && (this.b != null)) {
      this.jdField_a_of_type_Jzr.c(this.b);
    }
  }
  
  protected void aDF()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Jzr != null)) {
      this.jdField_a_of_type_Jzr.f(this.b);
    }
  }
  
  protected void aDH()
  {
    if ((zy()) && (this.b != null))
    {
      if (!TextUtils.isEmpty(this.b.mPackageName)) {
        knd.D(this.mActivity, this.b.mPackageName);
      }
    }
    else {
      return;
    }
    ods.b(this.mActivity, this.c.advertisementInfo, null, (int)this.c.advertisementInfo.mChannelID, true);
  }
  
  public void aDI()
  {
    if (this.b == null) {}
    do
    {
      do
      {
        return;
        if (this.isUserClick) {
          break;
        }
        if (this.b.mState == 4)
        {
          a(this.jdField_a_of_type_Mtg$l, 4, getProgress());
          return;
        }
        if (this.b.mState == 5)
        {
          String str = this.b.mPackageName;
          if (aqiz.isAppInstalled(BaseApplicationImpl.getContext(), str))
          {
            this.b.mState = 1;
            a(this.jdField_a_of_type_Mtg$l, 1, getProgress());
            return;
          }
          a(this.jdField_a_of_type_Mtg$l, 5, getProgress());
          return;
        }
      } while (this.b.mState != 3);
      a(this.jdField_a_of_type_Mtg$l, 3, getProgress());
    } while ((this.b == null) || (this.jdField_a_of_type_Jzr == null));
    this.jdField_a_of_type_Jzr.a(this.b);
    return;
    int i = jzk.aEJ;
    if (jzg.a(this.b, getDownloadState()))
    {
      aDF();
      this.b.mState = 5;
      report(i, 3);
      return;
    }
    doDownload();
    report(i, 0);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.agn = false;
    this.ago = false;
    c(paramVideoInfo);
  }
  
  public void b(mtg.l paraml)
  {
    this.agn = false;
  }
  
  public boolean b(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {}
    do
    {
      do
      {
        return true;
      } while (this.J.contains(paramVideoInfo.vid));
      if (knd.a(this.jdField_a_of_type_Muc)) {
        return false;
      }
    } while (!this.K.contains(paramVideoInfo.vid));
    return false;
  }
  
  public void c(mtg.l paraml)
  {
    this.agn = true;
    if (this.ago)
    {
      if (!this.agq) {
        break label39;
      }
      paraml.b.setVisibility(0);
    }
    for (;;)
    {
      if (this.agq) {
        aEm();
      }
      return;
      label39:
      paraml.lU.setVisibility(0);
    }
  }
  
  public void ck(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_Mtg$l, paramInt1, paramInt2);
  }
  
  protected void doDownload()
  {
    if ((this.jdField_a_of_type_Jzr != null) && (this.b != null)) {
      this.jdField_a_of_type_Jzr.a(this.b);
    }
    if ((this.jdField_a_of_type_Mtg$l.a != null) || ((this.jdField_a_of_type_Mtg$l.b != null) && (this.b != null))) {
      aEn();
    }
  }
  
  protected void doPause()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Jzr != null)) {
      this.jdField_a_of_type_Jzr.a(this.b, true);
    }
  }
  
  public String getBtnText()
  {
    String str2 = "详情";
    String str1 = str2;
    if (this.c != null)
    {
      str1 = str2;
      if (this.c.advertisementInfo != null)
      {
        str1 = str2;
        if (this.c.advertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.button)) {
            str1 = this.c.advertisementInfo.mAdvertisementSoftInfo.button;
          }
        }
      }
    }
    return str1;
  }
  
  protected int getDownloadState()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.mState;
  }
  
  protected int getProgress()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.aTP;
  }
  
  public int getStyle()
  {
    if ((this.c.advertisementInfo.mAdProductType == 12) || (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 1)) {
      return 1;
    }
    return this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType;
  }
  
  public String getTitle()
  {
    String str2 = "";
    String str1 = str2;
    if (this.c.advertisementInfo != null)
    {
      str1 = str2;
      if (this.c.advertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId != 0) {
          break label103;
        }
        if (this.c.advertisementInfo.mAdProductType != 12) {
          break label74;
        }
        str1 = this.c.advertisementInfo.mAdCorporateImageName;
      }
    }
    label74:
    label103:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 0);
      return this.c.advertisementInfo.mAdTxt;
      str1 = str2;
    } while (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 0);
    return this.c.advertisementInfo.mAdvertisementSoftInfo.aav;
  }
  
  public String ir()
  {
    if ((this.c.advertisementInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (this.c.advertisementInfo.mAdvertisementSoftInfo.sourceId == 0)
      {
        if (this.c.advertisementInfo.mAdProductType == 12) {
          return this.c.advertisementInfo.mAdCorporateLogo;
        }
        return this.c.advertisementInfo.mAdImg;
      }
      return this.c.advertisementInfo.mAdvertisementSoftInfo.aat;
    }
    return null;
  }
  
  public String is()
  {
    String str2 = "";
    String str1 = str2;
    if (this.c != null)
    {
      str1 = str2;
      if (this.c.advertisementInfo != null)
      {
        str1 = str2;
        if (this.c.advertisementInfo.mAdvertisementSoftInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(this.c.advertisementInfo.mAdvertisementSoftInfo.aaR)) {
            str1 = "来自" + this.c.advertisementInfo.mAdvertisementSoftInfo.aaR;
          }
        }
      }
    }
    return str1;
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i = 0;
    int j = 1;
    mtg.l locall = (mtg.l)paramView.getTag();
    int m = jzk.aEJ;
    this.isUserClick = true;
    switch (paramView.getId())
    {
    default: 
    case 2131362057: 
    case 2131362056: 
    case 2131362059: 
    case 2131368494: 
    case 2131381672: 
    case 2131381673: 
      do
      {
        return;
        if (this.jdField_a_of_type_Mxm$a != null) {
          this.jdField_a_of_type_Mxm$a.aTz();
        }
        this.agr = true;
        setClickPos(paramView.getId());
        d(m, 3, -1, false);
        return;
        setClickPos(paramView.getId());
        if (!this.agq) {
          break label301;
        }
        if ((getStyle() != 1) || (paramView.getId() != 2131362056) || (locall == null)) {
          break;
        }
        locall.b.callOnClick();
      } while (locall.b.getState() == 2);
      locall.bT.setVisibility(8);
      return;
      if (paramView.getId() == 2131362056) {}
      for (i = 1;; i = 0)
      {
        d(m, i, -1, zO());
        if ((paramView.getId() != 2131362056) || (TextUtils.isEmpty(ods.a(this.c)))) {
          break;
        }
        ods.h(this.mActivity, ods.a(this.c), this.c.advertisementInfo.mAdRl, this.c.advertisementInfo.mAdTraceId);
        return;
      }
      label301:
      if (paramView.getId() == 2131368494) {}
      for (i = j;; i = 0)
      {
        d(m, i, -1, zO());
        break;
      }
      aDW();
      return;
    }
    if (this.agq)
    {
      j = locall.b.getState();
      if (j != 2) {
        break label520;
      }
      if (!aqiz.isAppInstalled(BaseApplicationImpl.getContext(), this.b.mPackageName)) {
        break label414;
      }
      i = 5;
      aDH();
      this.b.mState = 1;
    }
    label520:
    for (;;)
    {
      d(m, 1, i, this.agp);
      return;
      j = locall.a.getState();
      break;
      label414:
      if (jzh.a(this.mActivity, this.b))
      {
        paramView = arvv.a().f(this.b.mPackageName);
        arvv.a().d(paramView);
        this.b.mState = 5;
        i = 3;
      }
      else if (jzg.a(this.b, this.b.mState))
      {
        aDF();
        this.b.mState = 5;
        i = 3;
      }
      else if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
      {
        doDownload();
      }
      else
      {
        aDW();
        continue;
        if ((j == 0) || (j == 4))
        {
          i = k;
          if (j == 4) {
            i = 2;
          }
          if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
          {
            if (j == 0)
            {
              if (this.b.anA)
              {
                aDE();
                return;
              }
              doDownload();
            }
            else
            {
              doDownload();
            }
          }
          else {
            aDW();
          }
        }
        else if (j == 1)
        {
          doPause();
          i = 1;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.agr = false;
    this.isUserClick = false;
    this.mActivity = null;
    if (this.jdField_a_of_type_Jzr != null) {
      this.jdField_a_of_type_Jzr.doOnDestory();
    }
  }
  
  protected void ph(int paramInt) {}
  
  public boolean zL()
  {
    boolean bool;
    if ((this.c.advertisementInfo != null) && (this.c.advertisementInfo.mAdvertisementSoftInfo != null) && (this.c.advertisementInfo.mSoftAdType == 2)) {
      bool = true;
    }
    while ((bool) && (this.c.advertisementInfo.mAdvertisementSoftInfo.goodsType == 2))
    {
      String str1 = getTitle();
      String str2 = ir();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean zM()
  {
    return this.agr;
  }
  
  public boolean zN()
  {
    return this.agq;
  }
  
  protected boolean zy()
  {
    return true;
  }
  
  static class a
    extends ReplacementSpan
  {
    private int aKb;
    
    public a(int paramInt)
    {
      this.aKb = paramInt;
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {}
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      return this.aKb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klw
 * JD-Core Version:    0.7.0.1
 */