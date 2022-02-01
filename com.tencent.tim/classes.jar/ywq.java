import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ywq
  extends acnd
{
  public ywq(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  protected void b(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    this.this$0.gV = false;
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0))
    {
      this.this$0.cbG = 0;
      if (this.this$0.mListView.isOverscrollHeadVisiable())
      {
        this.this$0.mHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.this$0);
      }
      if (!this.this$0.xv)
      {
        paramList = new ArrayList();
        this.this$0.a.setData(paramList);
        paramInt = this.this$0.getTitleBarHeight();
        QQToast.a(this.this$0, 1, this.this$0.getString(2131698408), 0).show(paramInt);
        return;
      }
      this.this$0.showEmptyView();
      return;
    }
    if (this.this$0.mListView.isOverscrollHeadVisiable())
    {
      this.this$0.i.tT(0);
      this.this$0.mHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.this$0);
    }
    this.this$0.Me.setVisibility(0);
    if (this.this$0.a != null)
    {
      this.this$0.cbG = paramList.size();
      this.this$0.a.setData(paramList);
    }
    this.this$0.ab(paramList1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywq
 * JD-Core Version:    0.7.0.1
 */