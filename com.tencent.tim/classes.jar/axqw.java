import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;

public class axqw
  extends axqo
  implements plh.a
{
  public View MQ;
  protected plh a;
  protected int dyy = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getIntent().getIntExtra("edit_video_type", 10002);
  private Animator j;
  private Animator k;
  
  public axqw(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.dwe = true;
    this.modeType = 2;
  }
  
  protected void YQ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initView();
      eOa();
    }
    for (;;)
    {
      if (this.a != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.a.onResume();
      }
      return;
      if (this.MQ != null) {
        eOb();
      }
    }
    this.a.onStop();
  }
  
  public void blC()
  {
    this.jdField_b_of_type_Awrq.auC();
  }
  
  public void blD()
  {
    this.jdField_b_of_type_Awrq.eFj();
  }
  
  protected void eOa()
  {
    if (this.j == null) {
      this.j = ObjectAnimator.ofFloat(this.MQ, "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.k != null) && (this.k.isRunning())) {
      this.k.cancel();
    }
    this.MQ.setVisibility(0);
    this.j.start();
    String str;
    Bundle localBundle;
    if (this.a != null)
    {
      str = this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getIntent().getExtras().getString("story_capture_album_id", "");
      localBundle = new Bundle();
      if (!TextUtils.isEmpty(str))
      {
        if (!"default_id".equals(str)) {
          break label144;
        }
        localBundle.putInt("BUNDLE_KEY_LOCATE_INDEX", 1);
      }
    }
    for (;;)
    {
      this.a.onCreate(localBundle);
      return;
      try
      {
        label144:
        localBundle.putLong("BUNDLE_KEY_LOCATE_ALBUM_ID", Long.valueOf(str).longValue());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ram.e("SlidesMode", "format albumId error : %s", localNumberFormatException);
      }
    }
  }
  
  protected void eOb()
  {
    if (this.k == null)
    {
      this.k = ObjectAnimator.ofFloat(this.MQ, "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.k.addListener(new axqy(this));
    }
    if ((this.j != null) && (this.j.isRunning())) {
      this.j.cancel();
    }
    if (this.MQ.getVisibility() != 8) {
      this.k.start();
    }
  }
  
  public void initView()
  {
    if (this.MQ != null) {
      return;
    }
    if (this.dyy == 10002)
    {
      pju localpju = (pju)psx.a(30);
      localpju.Bi();
      if (localpju.ax(this.mBaseView.getContext()))
      {
        ((ViewStub)this.mBaseView.findViewById(2131364255)).inflate();
        this.MQ = this.mBaseView.findViewById(2131364254);
        if (this.MQ != null)
        {
          ram.d("SlidesMode", "init album gallery view part success");
          this.a = new plh(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity(), this.MQ, this);
        }
      }
    }
    if (this.MQ == null)
    {
      ((ViewStub)this.mBaseView.findViewById(2131378492)).inflate();
      this.MQ = this.mBaseView.findViewById(2131378491);
      this.mBaseView.findViewById(2131378490).setOnClickListener(this);
      this.mBaseView.findViewById(2131364004).setOnClickListener(this);
    }
    this.MQ.setOnTouchListener(new axqx(this));
  }
  
  public void onActivityDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onActivityResume()
  {
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void onActivityStop()
  {
    if (this.a != null) {
      this.a.onStop();
    }
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
      this.jdField_b_of_type_Awrq.eFj();
      continue;
      this.jdField_b_of_type_Awrq.auC();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqw
 * JD-Core Version:    0.7.0.1
 */