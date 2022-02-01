import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class axra
  extends axqo
{
  public axyc a;
  public QIMMusicConfigManager b;
  private Animator l;
  private Animator m;
  
  public axra(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.dwe = true;
    this.modeType = 4;
    this.jdField_b_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)axov.a(2));
  }
  
  private void eOc()
  {
    if (this.l == null) {
      this.l = ObjectAnimator.ofFloat(this.a.t(), "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.m != null) && (this.m.isRunning())) {
      this.m.cancel();
    }
    this.a.t().setVisibility(0);
    this.a.t().bringToFront();
    if (this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.eZ != null) {
      this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.eZ.bringToFront();
    }
    this.l.start();
    boolean bool = rpw.isWeishiInstalled(this.jdField_b_of_type_Awrq.getActivity());
    this.a.Ze(bool);
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      rar.a("weishi_share", "clk_ws_entry", 0, 0, new String[] { String.valueOf(i) });
      return;
    }
  }
  
  private void eOd()
  {
    if (this.m == null)
    {
      this.m = ObjectAnimator.ofFloat(this.a.t(), "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.m.addListener(new axrc(this));
    }
    if ((this.l != null) && (this.l.isRunning())) {
      this.l.cancel();
    }
    if (this.a.t().getVisibility() != 8) {
      this.m.start();
    }
  }
  
  protected void YQ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initView();
      eOc();
    }
    while (this.a == null) {
      return;
    }
    eOd();
  }
  
  public void initView()
  {
    if (this.a == null)
    {
      ((ViewStub)this.mBaseView.findViewById(2131382200)).inflate();
      this.jdField_b_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.eNH();
      this.a = new axyc(this.mBaseView, "biz_src_jc_hyws");
      this.a.P(this);
      this.a.ads(this.jdField_b_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.cVP);
      this.a.t().setOnTouchListener(new axrb(this));
    }
  }
  
  public boolean isSupport()
  {
    return this.jdField_b_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.aPC();
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
      this.jdField_b_of_type_Awrq.auC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axra
 * JD-Core Version:    0.7.0.1
 */