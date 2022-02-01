import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController.3;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kfs
  extends kfr
  implements View.OnClickListener, View.OnKeyListener, mfo.a, mfs.a, myc.b, mye.a, mza.a, mza.b, mza.c
{
  private static boolean aeF = true;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private mdn jdField_a_of_type_Mdn;
  private mye jdField_a_of_type_Mye;
  private myp jdField_a_of_type_Myp;
  private mza jdField_a_of_type_Mza;
  ndi jdField_a_of_type_Ndi;
  private ViewGroup aM;
  private int from = -1;
  private int mChannelID = -1;
  private int mChannelType = -1;
  protected lce mObserver = new kfu(this);
  private volatile boolean zw;
  
  public kfs(Activity paramActivity)
  {
    super(paramActivity);
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
  
  private int nh()
  {
    if (this.mChannelID != -1) {
      return this.mChannelID;
    }
    return this.activity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private int ni()
  {
    if (this.mChannelType != -1) {
      return this.mChannelType;
    }
    return this.activity.getIntent().getIntExtra("channel_type", 0);
  }
  
  private boolean zh()
  {
    return nh() == 40677;
  }
  
  private boolean zi()
  {
    return nh() == 56;
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.lP(paramBoolean);
    super.O(paramBoolean, paramInt);
  }
  
  public mye a()
  {
    return this.jdField_a_of_type_Mye;
  }
  
  public myp a()
  {
    return this.jdField_a_of_type_Myp;
  }
  
  public void a(mrr parammrr1, mrr parammrr2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + parammrr1 + "  nextVideoPlayParam:" + parammrr2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    BaseArticleInfo localBaseArticleInfo;
    ndi localndi;
    if ((parammrr1 != null) && ((parammrr1 instanceof mye.b)) && (parammrr2 != null) && ((parammrr2 instanceof mye.b)))
    {
      parammrr1 = ((mye.b)parammrr1).d;
      localBaseArticleInfo = ((mye.b)parammrr2).d;
      if ((parammrr1 != null) && (localBaseArticleInfo != null))
      {
        localndi = this.jdField_a_of_type_Ndi;
        if (paramBoolean) {
          break label155;
        }
      }
    }
    label155:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localndi.a(parammrr1, localBaseArticleInfo, paramBoolean);
      if (!this.jdField_a_of_type_Mza.EV()) {
        this.jdField_a_of_type_Ndi.e((mye.b)parammrr2, 1);
      }
      return;
    }
  }
  
  public void a(mye.b paramb)
  {
    if (mst.anQ) {
      return;
    }
    this.jdField_a_of_type_Ndi.e(paramb);
  }
  
  public void a(mye.b paramb, int paramInt1, int paramInt2) {}
  
  public void a(mye.b paramb1, mye.b paramb2)
  {
    this.jdField_a_of_type_Ndi.a(paramb1, paramb2);
  }
  
  public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void aBY()
  {
    if (this.zw) {}
    do
    {
      do
      {
        return;
        this.zw = true;
        super.aBY();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.H(this.dC);
    } while (this.aM == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.aM.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void aBZ()
  {
    if (!this.zw) {}
    do
    {
      do
      {
        return;
        this.zw = false;
        super.aBZ();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
    } while (this.aM == null);
    this.aM.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void aCc()
  {
    this.jdField_a_of_type_Mye.aTN();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onPause();
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onPause();
    }
    if ((this.jdField_a_of_type_Mza != null) && (this.jdField_a_of_type_Mza.a() != null)) {
      this.jdField_a_of_type_Mza.a().onPause();
    }
  }
  
  public void aCe()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      Map localMap1 = a(Integer.valueOf(nh()));
      Map localMap2 = odv.a(nh());
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewController.3(this, localMap1, b(Integer.valueOf(nh())), localMap2, kxm.bf(nh())));
      b(Integer.valueOf(nh())).clear();
      this.dB.clear();
    }
  }
  
  public void aCj()
  {
    this.jdField_a_of_type_Mza.aUp();
  }
  
  public void aCk()
  {
    this.jdField_a_of_type_Ndi.aCk();
  }
  
  public void aCl()
  {
    if ((this.jdField_a_of_type_Mza != null) && (this.jdField_a_of_type_Mza.a() != null)) {
      this.jdField_a_of_type_Mza.a().onResume();
    }
  }
  
  public void aCm()
  {
    if (rpw.isWeishiInstalled(getActivity()))
    {
      oem.aT(getActivity(), "video_type_videopublic");
      kbp.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", kct.eh("0"), false);
      return;
    }
    oem.aU(getActivity(), "video_type_videopublic");
    kbp.a(null, "", "0X8009338", "0X8009338", 0, 0, "", "", "", kct.eh("1"), false);
  }
  
  public View af()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public List<BaseArticleInfo> ao()
  {
    if (this.jdField_a_of_type_Ndi == null) {
      return null;
    }
    return this.jdField_a_of_type_Ndi.getData();
  }
  
  public void b(int paramInt, String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
    }
  }
  
  public void d(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setSkinHeader(paramInt, paramBoolean);
    }
  }
  
  public int getFrom()
  {
    int i = -1;
    if (this.from != -1) {
      i = this.from;
    }
    while (getActivity().getIntent() == null) {
      return i;
    }
    return getActivity().getIntent().getIntExtra("channel_from", -1);
  }
  
  public void i(ViewGroup paramViewGroup)
  {
    super.i(paramViewGroup);
    this.aM = paramViewGroup;
  }
  
  public ViewGroup j()
  {
    return this.aM;
  }
  
  public void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      ReadInJoyListViewGroup localReadInJoyListViewGroup = (ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
      if (!paramBoolean1) {
        localReadInJoyListViewGroup.aWM();
      }
      if (!paramBoolean2) {
        localReadInJoyListViewGroup.aWN();
      }
    }
  }
  
  public void lP(boolean paramBoolean)
  {
    super.lP(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.lP(paramBoolean);
  }
  
  public void oD(int paramInt)
  {
    this.mChannelID = paramInt;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (zh())
      {
        Context localContext = this.aM.getContext();
        Intent localIntent = new Intent(localContext, AccountDetailActivity.class);
        localIntent.putExtra("uin", String.valueOf(2062433139L));
        localIntent.putExtra("uintype", 1008);
        localIntent.putExtra("source", 119);
        localContext.startActivity(localIntent);
        kbp.a(null, null, "0X800932E", "0X800932E", 0, 0, "", "", "", kct.d(null), false);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Myp = new myp(this.activity);
    this.jdField_a_of_type_Mye = new mye(this.activity);
    this.jdField_a_of_type_Mye.a(this.jdField_a_of_type_Myp);
    this.jdField_a_of_type_Mdn = new mdn();
    this.jdField_a_of_type_Mye.a(this.jdField_a_of_type_Mdn);
    this.dC.put(Integer.valueOf(nh()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, nh(), ni(), this.from, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new kft(this));
    this.jdField_a_of_type_Ndi = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_Ndi != null) {
      this.jdField_a_of_type_Ndi.aVN();
    }
    Object localObject;
    if (((this.activity instanceof ReadInJoyNewFeedsActivity)) || ((this.activity instanceof SplashActivity)))
    {
      localObject = kct.ic();
      kct.cZ.put(ReadInJoyVideoChannelFragment.class, localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mye.nZ((String)localObject);
      this.jdField_a_of_type_Myp.nZ((String)localObject);
      this.jdField_a_of_type_Mza = new mza((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381801), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379011), this.activity);
      this.jdField_a_of_type_Mza.a(this);
      this.jdField_a_of_type_Mye.b(this.jdField_a_of_type_Mza);
      this.jdField_a_of_type_Mza.a(this);
      this.jdField_a_of_type_Mza.a(this);
      this.jdField_a_of_type_Mza.b(this);
      this.jdField_a_of_type_Mye.a(this);
      this.jdField_a_of_type_Ndi.aVO();
      if (zi())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.requestFocus();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.setOnKeyListener(this);
      }
      lcc.a().b(this.mObserver);
      if (aeF)
      {
        aeF = false;
        lbz.a().aJi();
      }
      aBY();
      return;
      String str = (String)kct.cZ.get(ReadInJoyChannelActivity.class);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = kct.ic();
      }
    }
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(nh())), b(Integer.valueOf(nh())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.G(this.dC);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onDestroy();
    this.jdField_a_of_type_Ndi.aVM();
    this.dB.clear();
    this.dD.clear();
    this.dC.clear();
    if (this.jdField_a_of_type_Mye != null)
    {
      this.jdField_a_of_type_Mye.b(this);
      this.jdField_a_of_type_Mye.destroy();
    }
    if (this.jdField_a_of_type_Mza != null) {
      this.jdField_a_of_type_Mza.a(null);
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onDestory();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (zi())
    {
      bool1 = bool2;
      if (paramKeyEvent.getAction() == 0)
      {
        if (paramInt != 25) {
          break label41;
        }
        bool1 = da(-1);
      }
    }
    label41:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramInt != 24);
    return da(1);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Mye.aTN();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    lcc.a().b(this.mObserver);
    this.jdField_a_of_type_Mye.aTO();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onResume();
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ndi != null) {
      this.jdField_a_of_type_Ndi.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStop();
  }
  
  public void refreshList()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(null, 1);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.mChannelType = paramInt;
  }
  
  public void setFrom(int paramInt)
  {
    this.from = paramInt;
    if (getActivity().getIntent() != null) {
      getActivity().getIntent().putExtra("channel_from", paramInt);
    }
    if (this.jdField_a_of_type_Ndi != null) {
      this.jdField_a_of_type_Ndi.eJ(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfs
 * JD-Core Version:    0.7.0.1
 */