import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

public class aoys
  extends Handler
{
  public aoys(NewTroopContactView paramNewTroopContactView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.b.b.scrollTo(this.b.m.getLayoutParams().width, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoys
 * JD-Core Version:    0.7.0.1
 */