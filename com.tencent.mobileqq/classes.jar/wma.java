import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

public class wma
  extends SwipTextViewMenuBuilder
{
  public wma(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    paramSwipRightMenuItem = super.a(paramInt, paramObject, paramSwipRightMenuItem, paramOnClickListener);
    if ((paramSwipRightMenuItem instanceof SimpleTextView)) {
      paramSwipRightMenuItem.setTag(paramObject);
    }
    return paramSwipRightMenuItem;
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    this.a.a(paramInt, paramArrayOfSwipRightMenuItem, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wma
 * JD-Core Version:    0.7.0.1
 */