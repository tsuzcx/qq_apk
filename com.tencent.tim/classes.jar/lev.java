import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.b;

public class lev
  implements ScrollView.b
{
  public lev(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(ScrollView paramScrollView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "onScrollStateChanged onScrollStateChanged= " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lev
 * JD-Core Version:    0.7.0.1
 */