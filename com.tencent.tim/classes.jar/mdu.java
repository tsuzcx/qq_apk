import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.Nullable;

public abstract class mdu
  implements View.OnClickListener
{
  protected ViewGroup ba;
  protected ImageView backgroundView;
  private View contentView;
  private boolean isShowing;
  private ImageView ju;
  private View maskView;
  
  mdu(ViewGroup paramViewGroup)
  {
    this.ba = paramViewGroup;
    this.contentView = b(paramViewGroup);
    this.maskView = this.contentView.findViewById(2131382116);
    this.backgroundView = ((ImageView)this.contentView.findViewById(2131382108));
    this.ju = ((ImageView)this.contentView.findViewById(2131382111));
    this.ju.setOnClickListener(this);
  }
  
  protected void aOL() {}
  
  abstract View b(ViewGroup paramViewGroup);
  
  public void dismiss()
  {
    nN(true);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return this.contentView.findViewById(paramInt);
  }
  
  protected void i(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    kxm.b localb1 = new kxm.b();
    int i;
    kxm.b localb2;
    if (RIJRedPacketManager.a().Dq())
    {
      i = 1;
      localb2 = localb1.a("redpack_status", Integer.valueOf(i)).a("redpack_type", Integer.valueOf(paramInt2)).a("plat_source", Integer.valueOf(paramInt3)).a("action_position", Integer.valueOf(paramInt1));
      if (!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
        break label137;
      }
    }
    label137:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      localb2.a("network_type", Integer.valueOf(paramInt1)).a("os", Integer.valueOf(1)).a("imei", kxm.iT());
      if (!TextUtils.isEmpty(paramString)) {
        localb1.a("rowkey", paramString);
      }
      kbp.bp("0X800ABB5", localb1.build());
      return;
      i = 0;
      break;
    }
  }
  
  public boolean isShowing()
  {
    return this.isShowing;
  }
  
  protected void j(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    kxm.b localb1 = new kxm.b();
    int i;
    kxm.b localb2;
    if (RIJRedPacketManager.a().Dq())
    {
      i = 1;
      localb2 = localb1.a("redpack_status", Integer.valueOf(i)).a("redpack_type", Integer.valueOf(paramInt1)).a("plat_source", Integer.valueOf(paramInt2));
      if (!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
        break label126;
      }
    }
    label126:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      localb2.a("network_type", Integer.valueOf(paramInt1)).a("os", Integer.valueOf(1)).a("imei", kxm.iT());
      if (!TextUtils.isEmpty(paramString)) {
        localb1.a("rowkey", paramString);
      }
      kbp.bp("0X800ABB4", localb1.build());
      return;
      i = 0;
      break;
    }
  }
  
  public void nN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new mdv(this));
      this.contentView.startAnimation(localAlphaAnimation);
    }
    for (;;)
    {
      this.isShowing = false;
      return;
      this.ba.removeView(this.contentView);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.ju)
    {
      if ((this instanceof mdw)) {
        RIJRedPacketManager.a().aOE();
      }
      aOL();
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    show(true);
  }
  
  public void show(boolean paramBoolean)
  {
    this.ba.addView(this.contentView);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      this.maskView.startAnimation(localAlphaAnimation);
    }
    this.isShowing = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdu
 * JD-Core Version:    0.7.0.1
 */