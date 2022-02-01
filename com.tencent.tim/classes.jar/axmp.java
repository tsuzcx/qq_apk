import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.a;

public class axmp
  implements SeekBar.OnSeekBarChangeListener
{
  public axmp(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramSeekBar.getVisibility() == 0))
    {
      if (AEEditorFilterControlPanel.a(this.b) != null) {
        AEEditorFilterControlPanel.a(this.b).setText(paramInt + "%");
      }
      if (AEEditorFilterControlPanel.a(this.b) != null) {
        AEEditorFilterControlPanel.a(this.b).v(this.b.getSelectedIndex(), paramInt / 100.0F);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.b) != null) {
      AEEditorFilterControlPanel.a(this.b).setVisibility(0);
    }
    if (AEEditorFilterControlPanel.a(this.b) != null) {
      AEEditorFilterControlPanel.a(this.b).eMC();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.b) != null) {
      AEEditorFilterControlPanel.a(this.b).setVisibility(4);
    }
    if (AEEditorFilterControlPanel.a(this.b) != null) {
      AEEditorFilterControlPanel.a(this.b).eMD();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmp
 * JD-Core Version:    0.7.0.1
 */