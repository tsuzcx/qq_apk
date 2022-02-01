package com.tencent.biz.pubaccount.readinjoy.ad.multiVideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqbn;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jzk;
import kku.a;
import kmc;
import kmd;
import knd;
import knl;
import mqq.util.WeakReference;
import nai;
import naq.d;
import ods;
import wja;

public class MultiVideoAdFooterView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final String TAG = MultiVideoAdFooterView.class.getSimpleName();
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  public GdtHandler.Params a;
  private naq.d jdField_a_of_type_Naq$d;
  private int aKc = 1;
  private FrameLayout ad;
  private ImageView arrow;
  private ReadInJoyHeadImageView b;
  private VideoInfo c;
  private RelativeLayout eF;
  private boolean isChanged;
  private Activity mActivity;
  private TextView ok;
  private TextView ol;
  public long sr = -2147483648L;
  private WeakReference<kmd> t;
  
  public MultiVideoAdFooterView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void aEq()
  {
    int i = 1;
    Object localObject2;
    if ((this.c.isAD) && (this.c.b != null)) {
      if (this.c.b.mRevisionVideoType == 1)
      {
        aEs();
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder().append("MultiAdFooter setStyle: mRevisionVideoType = ");
          if (this.c.b != null) {
            break label228;
          }
          label73:
          QLog.d((String)localObject1, 2, i);
        }
        if (!TextUtils.isEmpty(this.c.WC)) {
          break label242;
        }
      }
    }
    label228:
    label242:
    for (Object localObject1 = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";; localObject1 = this.c.WC)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = wja.dp2px(18.0F, this.mActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = wja.dp2px(18.0F, this.mActivity.getResources());
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "ad_icon_footer";
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject1).setTag(aqbn.d(((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight, wja.dp2px(2.0F, this.mActivity.getResources())));
      ((URLDrawable)localObject1).setDecodeHandler(aqbn.a);
      this.b.setImageDrawable((Drawable)localObject1);
      this.ol.setText(knd.a(this.mActivity, this.c, getResources()));
      return;
      aEt();
      break;
      aEs();
      break;
      i = this.c.b.mRevisionVideoType;
      break label73;
    }
  }
  
  private void aEs()
  {
    this.isChanged = false;
    this.aKc = 1;
    this.ad.setVisibility(8);
    this.b.setVisibility(8);
    this.ok.setText(knd.a(this.mActivity, this.c, getResources()));
    this.arrow.setVisibility(0);
    this.ol.setVisibility(8);
  }
  
  private void aEt()
  {
    this.isChanged = false;
    this.aKc = 2;
    this.ad.setVisibility(8);
    this.b.setVisibility(8);
    this.ok.setText(knd.a(this.mActivity, this.c, getResources()));
    this.arrow.setVisibility(0);
    this.ol.setVisibility(8);
    this.eF.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  private void aEu()
  {
    this.isChanged = true;
    this.ad.setVisibility(0);
    this.b.setVisibility(0);
    this.ok.setText(this.c.title);
    this.arrow.setVisibility(8);
    this.ol.setVisibility(0);
    this.ol.setText(knd.a(this.mActivity, this.c, getResources()));
  }
  
  private void aEv()
  {
    this.isChanged = true;
    this.eF.setBackgroundColor(Color.parseColor("#FF12B7F6"));
  }
  
  private void b(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = jzk.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ods.h(this.mActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131560236, this);
    this.ad = ((FrameLayout)findViewById(2131364691));
    this.eF = ((RelativeLayout)findViewById(2131365735));
    this.b = ((ReadInJoyHeadImageView)findViewById(2131362111));
    this.b.setOnClickListener(this);
    this.ok = ((TextView)findViewById(2131362079));
    this.ok.setOnClickListener(this);
    this.arrow = ((ImageView)findViewById(2131362978));
    this.ol = ((TextView)findViewById(2131379942));
    this.ol.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    this.eF.setOnClickListener(this);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (knd.h(this.c.b))
    {
      b(this.c.b);
      i = jzk.aGg;
      if (this.isChanged) {
        i = jzk.aGy;
      }
      jzk.a(new kku.a().a(getContext()).d(i).a(jzk.aFA).b(jzk.aFy).a(paramAdvertisementInfo).a());
      return;
    }
    int i = 8;
    if (this.isChanged) {
      i = 38;
    }
    knd.a(paramAdvertisementInfo, i, this.jdField_a_of_type_Naq$d.a());
    kmc.a(this.mActivity, i, this.c, paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
  }
  
  public void aEr()
  {
    if (this.aKc == 1)
    {
      aEu();
      return;
    }
    aEv();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (kmd)this.t.get();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Naq$d.a((nai)localObject))
      {
        localObject = knl.b(this.c.b);
        this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ods.a(this.mActivity, (AdvertisementInfo)localObject, null, 3, false, null);
        if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
        for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
        {
          this.sr = l;
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131362079: 
            if ((this.aKc != 1) || (!this.isChanged)) {
              break label372;
            }
            knd.a((AdvertisementInfo)localObject, 35, this.jdField_a_of_type_Naq$d.a());
            ods.b(this.mActivity, (AdvertisementInfo)localObject, null, 3, false, null);
            kmc.a(this.mActivity, jzk.aGu, this.c);
            break;
          }
        }
        aEs();
        jzk.a(new kku.a().a(getContext()).a(jzk.aEJ).b(jzk.aFJ).a((AdvertisementInfo)localObject).a(this.c.b).d(jzk.aGz).a());
        continue;
        if (this.isChanged)
        {
          knd.a((AdvertisementInfo)localObject, 34, this.jdField_a_of_type_Naq$d.a());
          ods.b(this.mActivity, (AdvertisementInfo)localObject, null, 3, false, null);
          kmc.a(this.mActivity, jzk.aGv, this.c);
        }
        else
        {
          knd.a((AdvertisementInfo)localObject, 2, this.jdField_a_of_type_Naq$d.a());
          ods.b(this.mActivity, (AdvertisementInfo)localObject, null, 3, false, null);
          kmc.a(this.mActivity, jzk.aGd, this.c);
          continue;
          label372:
          a((AdvertisementInfo)localObject);
        }
      }
    }
  }
  
  public void resetStyle()
  {
    aEq();
  }
  
  public void setData(kmd paramkmd, VideoInfo paramVideoInfo, Activity paramActivity, naq.d paramd)
  {
    this.t = new WeakReference(paramkmd);
    this.c = paramVideoInfo;
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Naq$d = paramd;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(this.mActivity, false);
    aEq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.multiVideo.MultiVideoAdFooterView
 * JD-Core Version:    0.7.0.1
 */