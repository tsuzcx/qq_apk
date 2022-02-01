import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.SendBottomBar;

public class aufq
  implements View.OnClickListener
{
  public aufq(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str = "是否彻底删除 " + atwb.fN() + " 个已下载的文件?";
    this.this$0.m = aqha.a(SendBottomBar.a(this.this$0), 230, null, str, "取消", "删除", new aufr(this), new aufs(this));
    this.this$0.m.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufq
 * JD-Core Version:    0.7.0.1
 */