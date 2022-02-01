import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class tyx
  extends ViewBase
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected View a;
  protected FrameLayout a;
  public TextView a;
  public NativeAdDownloadView a;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AdData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData;
  private pvc jdField_a_of_type_Pvc;
  private tql jdField_a_of_type_Tql;
  private tqq jdField_a_of_type_Tqq;
  private tqr jdField_a_of_type_Tqr;
  protected txh a;
  
  public tyx(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_Int = -6447715;
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    e();
  }
  
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
    if (this.jdField_a_of_type_Tqq != null)
    {
      int i = (int)this.jdField_a_of_type_Tqq.h;
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
    for (this.jdField_a_of_type_Txh = txh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);; this.jdField_a_of_type_Txh = txh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      h();
      a();
      f();
      do
      {
        return;
      } while (!(paramObject instanceof AdData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = ((AdData)paramObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = tws.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
    }
  }
  
  private void a(tqq paramtqq)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramtqq == null)) {
      return;
    }
    tqc.a(this.jdField_a_of_type_AndroidContentContext, this, paramtqq, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView);
  }
  
  private void a(tqr paramtqr)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView != null) && (paramtqr != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setStyle(paramtqr);
    }
  }
  
  private int b()
  {
    int j = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (this.jdField_a_of_type_Tqq != null)
    {
      int k = (int)this.jdField_a_of_type_Tqq.g;
      i = j;
      if (k > 0) {
        i = AIOUtils.dp2px(k, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
    }
    return i;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Tql.jdField_a_of_type_Oau != null) {
      this.jdField_a_of_type_Tql.jdField_a_of_type_Oau.a(new tyy(this));
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560047, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370418));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362810));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView = ((NativeAdDownloadView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380773));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setOnClickListener(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((f()) && (g()))
    {
      setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(true);
      twp.a("ReadInJoyAdDownloadView", "mAppButton is clickable");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Txh != null) {
        twp.a("ReadInJoyAdDownloadView", "allowShowProgress = " + f() + " isApp = " + AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo) + " PackageName = " + this.jdField_a_of_type_Txh.d + " AppID= " + this.jdField_a_of_type_Txh.a);
      }
      return;
      setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClickable(false);
      twp.a("ReadInJoyAdDownloadView", "mAppButton is unClickable");
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
    int j;
    int i;
    if ((this.jdField_a_of_type_Tqq != null) && (a()) && (this.jdField_a_of_type_Tqq.b == 1.0F))
    {
      j = -15550475;
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Tqq.a)) {
        i = obg.a(this.jdField_a_of_type_Tqq.a, "#12B7F5");
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
      if ((this.jdField_a_of_type_Txh == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {}
      do
      {
        return;
        localObject = this.jdField_a_of_type_Txh.d;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      if (tqa.a((String)localObject))
      {
        if (twh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
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
      tpy.a.a(this.jdField_a_of_type_Txh, new tyz(this));
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
  
  private boolean g()
  {
    return ((AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (twh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.a));
  }
  
  private void h()
  {
    this.jdField_a_of_type_Tql = new tql();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof tyk)) {
      if (this.jdField_a_of_type_Txh == null) {
        break label156;
      }
    }
    label156:
    for (Object localObject = this.jdField_a_of_type_Txh.d;; localObject = "")
    {
      localObject = ((tyk)this.jdField_a_of_type_AndroidContentContext).a((String)localObject);
      if (localObject != null) {
        this.jdField_a_of_type_Tql = ((tql)localObject);
      }
      if (this.jdField_a_of_type_Tql.jdField_a_of_type_Oau == null) {
        this.jdField_a_of_type_Tql.jdField_a_of_type_Oau = a();
      }
      this.jdField_a_of_type_Tql.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Tql.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      this.jdField_a_of_type_Tql.a(this.jdField_a_of_type_Txh);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        this.jdField_a_of_type_Tql.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData);
      }
      this.jdField_a_of_type_Tql.a(new tza(this));
      d();
      return;
    }
  }
  
  protected Drawable a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Drawable localDrawable;
    if (this.jdField_a_of_type_Tqq != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Tqq.b == 1.0F)
      {
        localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842737);
        if ((this.jdField_a_of_type_Txh == null) || (!bfwv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Txh.d))) {
          break label79;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842737);
      }
    }
    label79:
    do
    {
      return localObject1;
      if (e()) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842735);
      }
      if ((c()) || (d())) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842738);
      }
      localObject1 = localObject2;
    } while (b());
    return localDrawable;
  }
  
  protected String a()
  {
    return twr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public oau a()
  {
    oau localoau1 = null;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof tyk)) {
      localoau1 = ((tyk)this.jdField_a_of_type_AndroidContentContext).a();
    }
    oau localoau2 = localoau1;
    if (localoau1 == null)
    {
      localoau2 = localoau1;
      if (this.jdField_a_of_type_Pvc != null)
      {
        localoau2 = localoau1;
        if (this.jdField_a_of_type_Pvc.a() != null) {
          localoau2 = this.jdField_a_of_type_Pvc.a().a();
        }
      }
    }
    return localoau2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Tql != null)
    {
      String str = this.jdField_a_of_type_Tql.b();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
  }
  
  public void a(pvc parampvc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pvc = parampvc;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mShowAdButton))
    {
      c();
      f();
    }
  }
  
  public void a(txh paramtxh, int paramInt1, int paramInt2)
  {
    if ((paramtxh == null) || (this.jdField_a_of_type_Tql == null) || (this.jdField_a_of_type_Tql.jdField_a_of_type_Txh == null) || (this.jdField_a_of_type_Tql.jdField_a_of_type_Txh.d == null) || (!this.jdField_a_of_type_Tql.jdField_a_of_type_Txh.d.trim().equals(paramtxh.d)))
    {
      twp.a("ReadInJoyAdDownloadView", "updateDownloadState error : maybe packageName not equal");
      return;
    }
    this.jdField_a_of_type_Tql.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewNativeAdDownloadView, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    if ((paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(a())))
    {
      paramAdvertisementInfo = BaseApplicationImpl.getContext().getResources().getString(2131717386);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdvertisementInfo);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
    }
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
    return twr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (a()) {
        g();
      }
    }
    else {
      return;
    }
    a();
  }
  
  protected boolean c()
  {
    return twr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean d()
  {
    return twr.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_Txh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Txh.c));
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
      case 2131362810: 
        if (this.jdField_a_of_type_Tql != null) {
          this.jdField_a_of_type_Tql.a(a());
        }
        break;
      case 2131380773: 
        if (this.jdField_a_of_type_Tql != null) {
          this.jdField_a_of_type_Tql.b(a());
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
      this.jdField_a_of_type_Tqr = tqr.a(1, (JSONObject)paramObject);
      a(this.jdField_a_of_type_Tqr);
      return true;
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    this.jdField_a_of_type_Tqq = tqq.a((JSONObject)paramObject);
    a(this.jdField_a_of_type_Tqq);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyx
 * JD-Core Version:    0.7.0.1
 */