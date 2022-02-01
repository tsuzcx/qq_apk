import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qjv
  extends qjw
  implements View.OnClickListener
{
  private long AO;
  
  public qjv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.mItemView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.AO >= 500L)
      {
        this.AO = System.currentTimeMillis();
        pty localpty = this.a.b().getVideoLinkInfo();
        if ((localpty != null) && (localpty.IX()) && (localpty.a.IY()))
        {
          qgg.b(n(), localpty.a.vid, localpty.a.feedID, 1010);
          rar.a("play_video", "clk_tips", 0, 0, new String[] { "", "", "", this.a.vid });
        }
        else
        {
          this.mItemView.setVisibility(8);
        }
      }
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjv
 * JD-Core Version:    0.7.0.1
 */