import com.tencent.biz.PoiMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class jmu
  implements AbsListView.e
{
  public jmu(PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
      }
      if ((!this.this$0.aaF) && (this.this$0.aaE))
      {
        this.this$0.aaF = true;
        paramAbsListView = this.this$0;
        paramAbsListView.aBS += 1;
        if (QLog.isDevelopLevel()) {
          QLog.i("PoiMapActivity", 4, "onScrollStateChanged mSearchPage:" + this.this$0.aBS);
        }
        this.this$0.b(this.this$0.aBM, this.this$0.aBN, this.this$0.Tl, "", this.this$0.aBS, 20);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmu
 * JD-Core Version:    0.7.0.1
 */