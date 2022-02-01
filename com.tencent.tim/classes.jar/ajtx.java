import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;

public class ajtx
{
  private static final String TAG = ajtx.class.getName() + "Q.nearby.video_chat.gift";
  public static long adl;
  public static long[] al = new long[2];
  private TroopGiftPanel a;
  private boolean cqg;
  private int dkZ;
  private AppInterface mApp;
  private Context mContext;
  private ViewGroup mRootView;
  private SessionInfo mSessionInfo;
  
  public ajtx(AppInterface paramAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopGiftPanel paramTroopGiftPanel, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.a = paramTroopGiftPanel;
    this.mRootView = paramViewGroup;
    this.cqg = paramBoolean1;
    this.dkZ = 3;
    init();
  }
  
  private void init()
  {
    this.a.a(this.mApp, this.mSessionInfo, this.cqg);
    this.a.setIsShow(true);
    snf localsnf = snf.a(this.mContext, this.dkZ);
    if (localsnf != null)
    {
      this.a.setGiftData(localsnf, true);
      return;
    }
    this.a.showLoading();
  }
  
  public void hide()
  {
    if (this.mRootView.findViewWithTag("mTroopGiftPanel") != null)
    {
      this.mRootView.removeView(this.a);
      this.a.setIsShow(false);
    }
  }
  
  public void i(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = System.currentTimeMillis();
    apqk localapqk = (apqk)this.mApp.getManager(223);
    apsz localapsz = (apsz)this.mApp.getManager(113);
    String str = this.mSessionInfo.aTl;
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      localapsz.a("OidbSvc.0x7f8", 2040, paramInt2, str, 2, i, 0, new ajty(this, localapsz, l, localapqk, paramInt1));
      return;
    }
  }
  
  public boolean isShow()
  {
    return this.a.isShow();
  }
  
  public void m(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.a != null)
    {
      this.a.setIsShow(true);
      Object localObject;
      if (paramBoolean1)
      {
        this.a.reset(TroopGiftPanel.byn);
        localObject = snf.a(this.mContext, this.dkZ);
        if (localObject == null) {
          break label172;
        }
        this.a.setGiftData((snf)localObject, true);
        i(0, paramBoolean2, paramInt);
      }
      if (this.mRootView.findViewWithTag("mTroopGiftPanel") == null)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(8);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.mRootView.addView(this.a, (ViewGroup.LayoutParams)localObject);
        this.a.setTag("mTroopGiftPanel");
      }
    }
    if ((Build.VERSION.SDK_INT >= 23) && (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        SosoInterface.a(new ajtx.a(3, true, true, 60000L, true, false, "NearbyTroopsView"));
      }
      return;
      label172:
      this.a.showLoading();
      break;
    }
  }
  
  public static class a
    extends SosoInterface.a
  {
    public a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
    {
      super(paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        ajtx.al[0] = ((paramSosoLbsInfo.a.ce * 1000000.0D));
        ajtx.al[1] = ((paramSosoLbsInfo.a.cd * 1000000.0D));
        ajtx.adl = System.currentTimeMillis();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtx
 * JD-Core Version:    0.7.0.1
 */