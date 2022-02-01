import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajpw
  implements View.OnClickListener
{
  ajpw(ajpu paramajpu) {}
  
  public void onClick(View paramView)
  {
    ajpu.b localb = (ajpu.b)paramView.getTag();
    if (this.this$0.mOnItemClickListener != null) {
      this.this$0.mOnItemClickListener.onItemClick(null, paramView, localb.position, localb.position);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpw
 * JD-Core Version:    0.7.0.1
 */