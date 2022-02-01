import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

@Deprecated
public class una
  extends ViewBase
  implements View.OnClickListener
{
  protected Context a;
  protected View a;
  protected FrameLayout a;
  public TextView a;
  public NativeAdDownloadView a;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private qfw jdField_a_of_type_Qfw;
  private ued jdField_a_of_type_Ued;
  private uei jdField_a_of_type_Uei;
  private uej jdField_a_of_type_Uej;
  protected ule a;
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 0L) {
      return 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 95555552L) {
      return 2;
    }
    return 3;
  }
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (this.jdField_a_of_type_Uei != null)
    {
      int i = (int)this.jdField_a_of_type_Uei.h;
      if (i > 0)
      {
        i = AIOUtils.dp2px(i, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramDrawable.setBounds(0, 0, i, i);
        return;
      }
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof AdvertisementInfo)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
    }
    for (this.jdField_a_of_type_Ule = ule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);; this.jdField_a_of_type_Ule = ule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      g();
      a();
      e();
      do
      {
        return;
      } while (!(paramObject instanceof AdData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = ((AdData)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ukt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
  }
  
  private void a(uei paramuei)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramuei == null)) {
      return;
    }
    udv.a(this.jdField_a_of_type_AndroidContentContext, this, paramuei, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView);
  }
  
  private void a(uej paramuej)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null) && (paramuej != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(paramuej);
    }
  }
  
  private int b()
  {
    int j = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (this.jdField_a_of_type_Uei != null)
    {
      int k = (int)this.jdField_a_of_type_Uei.g;
      i = j;
      if (k > 0) {
        i = AIOUtils.dp2px(k, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    return i;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ued.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Ued.jdField_a_of_type_Oil.a(new unb(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((f()) && (g()))
    {
      setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(true);
      ukq.a("ReadInJoyAdDownloadView", "mAppButton is clickable");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ule != null) {
        ukq.a("ReadInJoyAdDownloadView", "allowShowProgress = " + f() + " isApp = " + AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) + " PackageName = " + this.jdField_a_of_type_Ule.d + " AppID= " + this.jdField_a_of_type_Ule.a);
      }
      return;
      setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(false);
      ukq.a("ReadInJoyAdDownloadView", "mAppButton is unClickable");
    }
  }
  
  private void f()
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_Uei != null) && (a()) && (this.jdField_a_of_type_Uei.b == 1.0F))
    {
      j = -15550475;
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Uei.a)) {
        i = oix.a(this.jdField_a_of_type_Uei.a, "#12B7F5");
      }
      Object localObject = a();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        a((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
        i = b();
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
      }
      if ((this.jdField_a_of_type_Ule == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {}
      do
      {
        return;
        localObject = this.jdField_a_of_type_Ule.d;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      if (udt.a((String)localObject))
      {
        if (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("打开");
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("立即打开");
        return;
      }
      if (!f()) {
        a();
      }
      udr.a.a(this.jdField_a_of_type_Ule, new unc(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private boolean f()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID == 0L) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return false;
        i = 0;
      }
      else
      {
        return true;
        i = 1;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ued = new ued();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof umi)) {
      if (this.jdField_a_of_type_Ule == null) {
        break label156;
      }
    }
    label156:
    for (Object localObject = this.jdField_a_of_type_Ule.d;; localObject = "")
    {
      localObject = ((umi)this.jdField_a_of_type_AndroidContentContext).a((String)localObject);
      if (localObject != null) {
        this.jdField_a_of_type_Ued = ((ued)localObject);
      }
      if (this.jdField_a_of_type_Ued.jdField_a_of_type_Oil == null) {
        this.jdField_a_of_type_Ued.jdField_a_of_type_Oil = a();
      }
      this.jdField_a_of_type_Ued.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ued.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      this.jdField_a_of_type_Ued.a(this.jdField_a_of_type_Ule);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        this.jdField_a_of_type_Ued.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
      }
      this.jdField_a_of_type_Ued.a(new und(this));
      d();
      return;
    }
  }
  
  private boolean g()
  {
    return ((AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (uki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.a));
  }
  
  protected Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Drawable localDrawable;
    if (this.jdField_a_of_type_Uei != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Uei.b == 1.0F)
      {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842769);
        if ((this.jdField_a_of_type_Ule == null) || (!bhfn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ule.d))) {
          break label79;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842769);
      }
    }
    label79:
    do
    {
      return localObject1;
      if (e()) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842767);
      }
      if ((c()) || (d())) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842770);
      }
      localObject1 = localObject2;
    } while (b());
    return localDrawable;
  }
  
  public oil a()
  {
    oil localoil1 = null;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof umi)) {
      localoil1 = ((umi)this.jdField_a_of_type_AndroidContentContext).a();
    }
    oil localoil2 = localoil1;
    if (localoil1 == null)
    {
      localoil2 = localoil1;
      if (this.jdField_a_of_type_Qfw != null)
      {
        localoil2 = localoil1;
        if (this.jdField_a_of_type_Qfw.a() != null) {
          localoil2 = this.jdField_a_of_type_Qfw.a().a();
        }
      }
    }
    return localoil2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ued != null)
    {
      String str = this.jdField_a_of_type_Ued.b();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
  }
  
  public void a(qfw paramqfw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qfw = paramqfw;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton))
    {
      c();
      e();
    }
  }
  
  public void a(ule paramule, int paramInt1, int paramInt2)
  {
    if ((paramule == null) || (this.jdField_a_of_type_Ued == null) || (this.jdField_a_of_type_Ued.jdField_a_of_type_Ule == null) || (this.jdField_a_of_type_Ued.jdField_a_of_type_Ule.d == null) || (!this.jdField_a_of_type_Ued.jdField_a_of_type_Ule.d.trim().equals(paramule.d)))
    {
      ukq.a("ReadInJoyAdDownloadView", "updateDownloadState error : maybe packageName not equal");
      return;
    }
    this.jdField_a_of_type_Ued.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return false;
    }
    return AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 8;
    }
  }
  
  protected boolean b()
  {
    return uks.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (a()) {
        f();
      }
    }
    else {
      return;
    }
    a();
  }
  
  protected boolean c()
  {
    return uks.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean d()
  {
    return uks.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_Ule != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ule.c));
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362826: 
        if (this.jdField_a_of_type_Ued != null) {
          this.jdField_a_of_type_Ued.a(a());
        }
        break;
      case 2131381124: 
        if (this.jdField_a_of_type_Ued != null) {
          this.jdField_a_of_type_Ued.b(a());
        }
        break;
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              a(paramObject);
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null);
            bool1 = bool2;
          } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd());
          bool1 = bool2;
        } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT);
        return true;
        bool1 = bool2;
      } while (!(paramObject instanceof JSONObject));
      this.jdField_a_of_type_Uej = uej.a(1, (JSONObject)paramObject);
      a(this.jdField_a_of_type_Uej);
      return true;
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    this.jdField_a_of_type_Uei = uei.a((JSONObject)paramObject);
    a(this.jdField_a_of_type_Uei);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     una
 * JD-Core Version:    0.7.0.1
 */