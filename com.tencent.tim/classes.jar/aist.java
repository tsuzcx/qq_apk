import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class aist
  implements ayrd
{
  public aist(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3, ImageView paramImageView, View paramView4) {}
  
  public void cancelAnimator() {}
  
  public void displayPanel() {}
  
  public void displayPanelFinish()
  {
    if (LocationPickFragment.a(this.this$0) != null) {
      LocationPickFragment.a(this.this$0).setEnabled(false);
    }
    anot.a(null, "CliOper", "", "", "0X800A95F", "0X800A95F", LocationPickFragment.a(this.this$0).FZ(), 0, "", "0", "0", "");
    this.Bg.setVisibility(8);
    this.DQ.setContentDescription(this.this$0.getString(2131695480));
    if ((this.AY != null) && (LocationPickFragment.a(this.this$0).aQZ())) {
      this.AY.setImageResource(2130850667);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationPickFragment", 2, "[panel] fadeBackground: invoked. alpha: " + paramFloat);
    }
    this.DP.setBackgroundColor(Color.argb(Math.round(0.7F * paramFloat * 255.0F), 0, 0, 0));
  }
  
  public void hidePanel()
  {
    LocationPickFragment.b(this.this$0);
  }
  
  public void hidePanelFinish()
  {
    if (LocationPickFragment.a(this.this$0) != null) {
      LocationPickFragment.a(this.this$0).setEnabled(true);
    }
    LocationPickFragment.a(this.this$0).setDisplayFromType(2);
    this.Co.requestFocus();
    this.Bg.setVisibility(0);
    this.DQ.setContentDescription(this.this$0.getString(2131695478));
    if ((this.AY != null) && (!LocationPickFragment.a(this.this$0).aQZ())) {
      this.AY.setImageResource(2130850666);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aist
 * JD-Core Version:    0.7.0.1
 */