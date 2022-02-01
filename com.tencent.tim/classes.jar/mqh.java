import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoUIDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoUIDelegate.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class mqh
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, nbh
{
  private ImageButton Q;
  private nbi a;
  private boolean any;
  private mir.a b;
  private TextView bN;
  private ViewGroup be;
  private ViewGroup containerView;
  private SeekBar d;
  private Handler handler = new mqh.a(this);
  private ImageView jC;
  private ProgressBar progressBar;
  private TextView ri;
  private ViewGroup rootView = (ViewGroup)LayoutInflater.from(BaseApplication.getContext()).inflate(2131560229, null, false);
  private TextView titleView;
  
  private boolean DT()
  {
    return this.Q.getVisibility() == 0;
  }
  
  private boolean DU()
  {
    return this.be.getVisibility() == 0;
  }
  
  private void aRk()
  {
    int i = (int)this.a.getDuration() / 1000;
    this.d.setMax(i);
    this.progressBar.setMax(i);
    eI(0L);
    this.ri.setText(kwz.ba(i));
    this.bN.setText(kwz.ba(0));
  }
  
  private void aRl()
  {
    this.a.setLoopback(true);
    this.a.setMute(false);
  }
  
  private void aRm()
  {
    if (this.be.getVisibility() != 0) {
      return;
    }
    this.be.setVisibility(8);
    this.progressBar.setVisibility(0);
  }
  
  private void aRn()
  {
    if (DU())
    {
      aRm();
      return;
    }
    aRo();
  }
  
  private void aRo()
  {
    if (this.be.getVisibility() == 0) {
      return;
    }
    if (this.a.isPause()) {
      si(1);
    }
    for (;;)
    {
      muj.a(this.be, 0, 300);
      this.progressBar.setVisibility(8);
      this.handler.removeMessages(101);
      if (!this.a.isPlaying()) {
        break;
      }
      this.handler.sendEmptyMessageDelayed(101, 3000L);
      return;
      if (this.a.isPlaying()) {
        si(2);
      }
    }
  }
  
  private void eI(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (!this.any)
    {
      this.d.setProgress(i);
      this.progressBar.setProgress(i);
    }
    this.bN.setText(kwz.ba(i));
  }
  
  private int f(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    return 1;
  }
  
  private void initPlayer()
  {
    this.a = new nbi(1000);
    this.a.a(this);
  }
  
  private void initView()
  {
    this.d = ((SeekBar)this.rootView.findViewById(2131377914));
    this.progressBar = ((ProgressBar)this.rootView.findViewById(2131381792));
    this.Q = ((ImageButton)this.rootView.findViewById(2131373379));
    this.be = ((ViewGroup)this.rootView.findViewById(2131381639));
    this.bN = ((TextView)this.rootView.findViewById(2131381794));
    this.ri = ((TextView)this.rootView.findViewById(2131381660));
    this.jC = ((ImageView)this.rootView.findViewById(2131365488));
    this.titleView = ((TextView)this.rootView.findViewById(2131380976));
    this.d.setOnSeekBarChangeListener(this);
    this.Q.setOnClickListener(this);
    this.containerView.setOnClickListener(this);
    this.be.setVisibility(8);
    this.progressBar.setVisibility(8);
  }
  
  private void si(int paramInt)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    this.Q.clearAnimation();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.Q.setImageDrawable(localResources.getDrawable(2130844049));
      this.Q.setTag(Integer.valueOf(1));
      return;
    }
    this.Q.setImageDrawable(localResources.getDrawable(2130844048));
    this.Q.setTag(Integer.valueOf(2));
  }
  
  public void HN()
  {
    si(2);
    this.handler.removeMessages(101);
    this.handler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void HO()
  {
    if (DT()) {
      si(1);
    }
    this.handler.removeMessages(101);
  }
  
  public void aRp()
  {
    aRl();
    this.a.start();
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.2(this));
  }
  
  public void aRq()
  {
    si(2);
    this.handler.removeMessages(101);
    this.handler.sendEmptyMessageDelayed(101, 3000L);
  }
  
  public void aRr() {}
  
  public void aRs() {}
  
  public void aRt() {}
  
  public void e(mir.a parama)
  {
    if (parama == null) {
      return;
    }
    this.b = parama;
    this.titleView.setText(parama.videoFileName);
    ThreadManager.getUIHandler().post(new SelectVideoUIDelegate.1(this, parama));
  }
  
  public void k(int paramInt1, int paramInt2, String paramString) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.Q.getId()) {
      switch (f(paramView))
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.start();
      continue;
      this.a.pause();
      continue;
      if (i == this.containerView.getId()) {
        aRn();
      }
    }
  }
  
  public void onCompletion() {}
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  public void onProgressChanged(long paramLong)
  {
    eI(paramLong);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onResume()
  {
    this.a.onResume();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.any = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.any = false;
    int i = paramSeekBar.getProgress();
    this.a.seekTo(i * 1000);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoStop() {}
  
  public void r(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
    {
      QLog.e("RIJUGC.SelectVideoUIDelegate", 1, "attachVideoView failed for containerView is null.");
      return;
    }
    this.containerView = paramViewGroup;
    paramViewGroup.setEnabled(false);
    initView();
    initPlayer();
    this.a.u(paramViewGroup);
    paramViewGroup.addView(this.rootView);
  }
  
  public void sj(int paramInt) {}
  
  static class a
    extends Handler
  {
    private WeakReference<mqh> z;
    
    public a(mqh parammqh)
    {
      this.z = new WeakReference(parammqh);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      mqh localmqh = (mqh)this.z.get();
      if (localmqh == null) {}
      while (paramMessage.what != 101) {
        return;
      }
      mqh.a(localmqh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqh
 * JD-Core Version:    0.7.0.1
 */