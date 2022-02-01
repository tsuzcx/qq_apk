import android.view.View;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.qphone.base.util.QLog;

public class amis
  implements amiq.a
{
  public amis(ScreenShotFragment paramScreenShotFragment) {}
  
  public void onItemClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotInnerAdapter OnItemClickListener : position = " + paramInt + ", view = " + paramView);
    }
    ScreenShotFragment.a(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amis
 * JD-Core Version:    0.7.0.1
 */