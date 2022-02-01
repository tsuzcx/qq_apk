import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jbh
  implements View.OnClickListener
{
  public jbh(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ((TextView)this.this$0.mRootView.findViewById(2131374266)).setVisibility(8);
    this.gz.setVisibility(8);
    this.this$0.Xk = true;
    anot.a(null, "CliOper", "", "", "0X800AEB8", "0X800AEB8", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbh
 * JD-Core Version:    0.7.0.1
 */