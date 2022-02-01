import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class jbl
  implements View.OnClickListener
{
  public jbl(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.isDestroyed()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d(this.this$0.TAG, 1, "onClick R.id.qav_btn_accept_video");
      jjk.E(aqiw.isWifiConnected((Context)this.this$0.mContext.get()), this.this$0.a.b().anb);
      this.this$0.vF();
      this.this$0.a.b().Rb = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbl
 * JD-Core Version:    0.7.0.1
 */