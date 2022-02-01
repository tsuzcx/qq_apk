import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.3;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.5;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.1;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class kfn
  extends kfr
  implements lcm.e, mfo.a, mfs.a
{
  private String YU;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private kfn.b jdField_a_of_type_Kfn$b;
  private kgp jdField_a_of_type_Kgp;
  private mdn jdField_a_of_type_Mdn;
  private mye jdField_a_of_type_Mye;
  private mza jdField_a_of_type_Mza;
  private boolean aeB;
  private boolean aeC = true;
  private boolean aeD;
  private Activity mContext;
  protected lce mObserver = new kfp(this);
  private ViewGroup mViewGroup;
  
  public kfn(Activity paramActivity)
  {
    super(paramActivity);
    this.mContext = paramActivity;
  }
  
  private void aBX()
  {
    if ((this.mContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.mContext).getAppInterface();
      if (localObject != null)
      {
        mfs localmfs = (mfs)((AppInterface)localObject).getManager(261);
        this.jdField_a_of_type_Kgp = new kgp(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, this.mContext);
        if (localmfs != null) {
          localmfs.a(this);
        }
        localObject = (mfo)((AppInterface)localObject).getManager(270);
        if (localObject != null) {
          ((mfo)localObject).a(this);
        }
      }
    }
  }
  
  private void aCa()
  {
    if ((this.mContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.mContext).getAppInterface();
      if (localObject != null)
      {
        mfs localmfs = (mfs)((AppInterface)localObject).getManager(261);
        localmfs.b(this);
        localmfs.clearData();
        localObject = (mfo)((AppInterface)localObject).getManager(270);
        ((mfo)localObject).b(this);
        ((mfo)localObject).clearData();
      }
    }
  }
  
  private void aCd()
  {
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).aID();
  }
  
  private void aCf()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new kfn.a());
    }
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    super.O(paramBoolean, paramInt);
    this.aeD = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.O(paramBoolean, paramInt);
  }
  
  public mye a()
  {
    return this.jdField_a_of_type_Mye;
  }
  
  public void aBY()
  {
    super.aBY();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(0)), b(Integer.valueOf(0)));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.F(this.dE);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.H(this.dC);
    }
    if (!this.aeC) {
      aCd();
    }
    this.aeC = false;
  }
  
  public void aBZ()
  {
    super.aBZ();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), b(Integer.valueOf(0)));
    }
  }
  
  public void aCb()
  {
    if (this.aeB) {
      aCd();
    }
  }
  
  public void aCc()
  {
    if ((this.mContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.mContext).getAppInterface();
      if ((localAppInterface != null) && (((mfs)localAppInterface.getManager(261)).pg() == 1) && (this.jdField_a_of_type_Kgp != null)) {
        ThreadManager.post(new KanDianViewController.3(this), 8, null, true);
      }
    }
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTN();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).aWg();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onPause();
    }
  }
  
  public void aCe()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))
    {
      Map localMap1 = a(Integer.valueOf(0));
      Map localMap2 = odv.a(0);
      ThreadManager.executeOnSubThread(new KanDianViewController.5(this, localMap1, b(Integer.valueOf(0)), localMap2, kxm.bf(0)));
      b(Integer.valueOf(0)).clear();
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).D(this.dE);
      this.dE.clear();
      this.dB.clear();
    }
  }
  
  public void aCg()
  {
    QLog.d("KanDianViewController", 2, "[onAppStatusChange] switch to background, report and clear");
    aCe();
  }
  
  public void aCh()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).aCh();
    }
  }
  
  public void b(int paramInt, String paramString, long paramLong)
  {
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setRefreshHeader(paramInt);
  }
  
  public void d(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KanDianViewController", 1, "onSkinChanged");
      }
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setSkinHeader(paramInt, paramBoolean);
    }
    if ((getActivity() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)getActivity()).d(paramInt, paramString, paramBoolean);
    }
  }
  
  public void foreground() {}
  
  public Activity getActivity()
  {
    return this.mContext;
  }
  
  public void i(ViewGroup paramViewGroup)
  {
    super.i(paramViewGroup);
    this.mViewGroup = paramViewGroup;
  }
  
  public ViewGroup j()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public void lP(boolean paramBoolean)
  {
    super.lP(paramBoolean);
    O(paramBoolean, 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      return ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).onBackPressed();
    }
    return false;
  }
  
  public void onCreate()
  {
    int i = 0;
    super.onCreate();
    this.jdField_a_of_type_Mye = new mye(this.activity);
    this.jdField_a_of_type_Mdn = new mdn();
    this.jdField_a_of_type_Mye.a(this.jdField_a_of_type_Mdn);
    this.dC.put(Integer.valueOf(0), Boolean.valueOf(true));
    if (lhn.oC() != -1) {
      i = lhn.oC();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, i, null);
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setNotifyEndRefresh(new kfo(this));
    ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(new kfn.a());
    aBX();
    this.jdField_a_of_type_Mza = new mza((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131381801), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131379011), this.activity);
    this.jdField_a_of_type_Mye.b(this.jdField_a_of_type_Mza);
    lcc.a().b(this.mObserver);
    lbz.a().aJh();
    aBY();
    this.jdField_a_of_type_Kfn$b = new kfn.b(this);
    lcm.d.a(this);
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.mObserver);
    super.onDestroy();
    aCa();
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.destroy();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(b(Integer.valueOf(0)), b(Integer.valueOf(0)));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.G(this.dC);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onDestroy();
    this.dB.clear();
    this.dD.clear();
    this.dC.clear();
    this.dE.clear();
    if (this.jdField_a_of_type_Kgp != null) {
      this.jdField_a_of_type_Kgp.destroy();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onDestory();
    }
    lcm.d.b(this);
    nxr.destroy();
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).onLogout();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTN();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onPause();
    if ((this.mContext instanceof BaseActivity))
    {
      AppInterface localAppInterface = ((BaseActivity)this.mContext).getAppInterface();
      if ((localAppInterface != null) && (((mfs)localAppInterface.getManager(261)).pg() == 1) && (this.jdField_a_of_type_Kgp != null)) {
        ThreadManager.post(new KanDianViewController.2(this), 8, null, true);
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).aWg();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ndh localndh = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      localndh = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    }
    if ((this.jdField_a_of_type_Mye != null) && (localndh != null))
    {
      mye.b localb = this.jdField_a_of_type_Mye.c();
      if ((localb != null) && (localb.aqp)) {
        localndh.aVX();
      }
    }
    if (this.jdField_a_of_type_Mye != null) {
      this.jdField_a_of_type_Mye.aTO();
    }
    if (this.jdField_a_of_type_Mdn != null) {
      this.jdField_a_of_type_Mdn.onResume();
    }
    lcc.a().b(this.mObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onResume();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).aWh();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStart();
    this.aeB = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.onStop();
    this.aeB = false;
  }
  
  public boolean zg()
  {
    return this.aeD;
  }
  
  public class a
    implements npy.b
  {
    public a() {}
    
    public void lQ(boolean paramBoolean)
    {
      AppInterface localAppInterface;
      if ((kfn.a(kfn.this) instanceof BaseActivity))
      {
        localAppInterface = ((BaseActivity)kfn.a(kfn.this)).getAppInterface();
        if ((localAppInterface != null) && (kfn.a(kfn.this) != null) && (!paramBoolean))
        {
          mfo localmfo = (mfo)localAppInterface.getManager(270);
          if ((localmfo.oH() != 1) || (!localmfo.Dz())) {
            break label87;
          }
          ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
        }
      }
      label87:
      while (((mfs)localAppInterface.getManager(261)).pg() != 1) {
        return;
      }
      ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
    }
  }
  
  public static class b
    extends Handler
  {
    private WeakReference<kfn> C;
    
    public b(kfn paramkfn)
    {
      this.C = new WeakReference(paramkfn);
    }
    
    public void handleMessage(Message paramMessage)
    {
      kfn localkfn = (kfn)this.C.get();
      if (localkfn == null) {}
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            kfn.a(localkfn);
            return;
          }
        } while (kfn.a(localkfn) == null);
        kfn.a(localkfn).show(kfn.a(localkfn));
        return;
      } while (kfn.a(localkfn) == null);
      kfn.a(localkfn).hide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfn
 * JD-Core Version:    0.7.0.1
 */