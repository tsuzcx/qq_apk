import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.HorizontalListView.d;

public class noe
  implements HorizontalListView.d
{
  public noe(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((ReadInJoyDiandianHeaderController.b(this.a)) && (paramInt == 4097)) {
      kbp.a(null, "", "0X8009BA4", "0X8009BA4", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noe
 * JD-Core Version:    0.7.0.1
 */