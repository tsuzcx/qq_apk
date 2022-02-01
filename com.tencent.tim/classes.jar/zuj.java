import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zuj
  implements View.OnClickListener
{
  zuj(zug paramzug) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onMagicStickClick(paramView, -1, new Bundle(), 2, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuj
 * JD-Core Version:    0.7.0.1
 */