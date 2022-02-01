import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRedPacketShareController.2;

public class mwj
  implements PopupWindow.OnDismissListener
{
  private mwj.a a;
  private boolean apQ;
  private mes b;
  private Context context;
  private VideoInfo l;
  private View lY;
  private View lZ;
  private VideoInfo m;
  
  public mwj(Context paramContext, boolean paramBoolean, View paramView1, View paramView2, mwj.a parama)
  {
    this.context = paramContext;
    this.lY = paramView1;
    this.a = parama;
    this.apQ = paramBoolean;
    this.lZ = paramView2;
  }
  
  private void aTp()
  {
    this.b = new mes(this.context);
    this.b.setOnDismissListener(this);
    this.b.aOO();
    this.b.setTips(RIJRedPacketManager.a().jC());
    this.b.rI(RIJRedPacketManager.a().oX());
    this.b.setGravity(3);
    if (this.lY.getWidth() > 0)
    {
      this.b.showAsDropDown(this.lY, -aqnm.dip2px(6.0F), -aqnm.dip2px(10.0F));
      return;
    }
    this.lY.post(new VideoFeedsRedPacketShareController.2(this));
  }
  
  public void H(VideoInfo paramVideoInfo)
  {
    int j = 1;
    this.l = paramVideoInfo;
    int i;
    if ((k(paramVideoInfo)) && (awit.aML()))
    {
      i = 1;
      if ((this.lY.getVisibility() != 0) || (this.lZ.getVisibility() != 0)) {
        break label86;
      }
      label43:
      if ((paramVideoInfo.isAD) || (i == 0) || (TextUtils.isEmpty(paramVideoInfo.WF)) || (j == 0)) {
        break label91;
      }
      awit.eDM();
      aTp();
      this.m = paramVideoInfo;
    }
    label86:
    label91:
    while (this.b == null)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label43;
    }
    this.b.dismiss();
  }
  
  public void I(VideoInfo paramVideoInfo)
  {
    int j = 0;
    if ((RIJRedPacketManager.a().Dr()) && (RIJRedPacketManager.a().Dt()) && (this.apQ)) {}
    for (int i = 1;; i = 0)
    {
      if ((paramVideoInfo == null) || (paramVideoInfo.Wz == null) || (!TextUtils.isEmpty(paramVideoInfo.WF))) {
        j = 1;
      }
      if ((j == 0) && (!paramVideoInfo.isAD) && (i != 0)) {
        break;
      }
      return;
    }
    RIJRedPacketManager.a().a(paramVideoInfo.Wz, new mwk(this, paramVideoInfo));
  }
  
  public boolean isShowing()
  {
    return (this.b != null) && (this.b.isShowing());
  }
  
  public boolean k(VideoInfo paramVideoInfo)
  {
    return (RIJRedPacketManager.a().Dr()) && (RIJRedPacketManager.a().Dt()) && (paramVideoInfo.adI) && (this.apQ);
  }
  
  public void onDismiss()
  {
    if ((this.a != null) && (this.m != null)) {
      this.a.C(this.m);
    }
    this.m = null;
  }
  
  public static abstract interface a
  {
    public abstract void C(VideoInfo paramVideoInfo);
    
    public abstract void D(VideoInfo paramVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwj
 * JD-Core Version:    0.7.0.1
 */