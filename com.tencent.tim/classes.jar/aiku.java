import com.tencent.biz.ui.RefreshView.b;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class aiku
  implements RefreshView.b
{
  public aiku(UiApiPlugin paramUiApiPlugin) {}
  
  public void onRefresh()
  {
    this.this$0.dispatchJsEvent("qbrowserPullDown", null, null);
    this.this$0.mIsUpdating = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiku
 * JD-Core Version:    0.7.0.1
 */