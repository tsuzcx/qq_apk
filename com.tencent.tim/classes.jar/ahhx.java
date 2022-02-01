import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Set;

public class ahhx
  extends ahgq
{
  public ahhx(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public boolean anj()
  {
    super.anj();
    return true;
  }
  
  public boolean ann()
  {
    return true;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    int i = this.bf.getInt("key_hiboom_id");
    HiBoomTextView localHiBoomTextView = new HiBoomTextView(this.mActivity);
    localHiBoomTextView.setHiBoom(i, 0, ahxs.b);
    localHiBoomTextView.setText(this.bKu);
    localHiBoomTextView.setMaxSize(ahxs.dbR);
    localHiBoomTextView.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
    return localHiBoomTextView;
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected void dns()
  {
    this.e.setMessage(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhx
 * JD-Core Version:    0.7.0.1
 */