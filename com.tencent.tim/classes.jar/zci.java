import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.widget.SimpleTextView;

public class zci
  extends auve
{
  public zci(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, auvd.b paramb, View.OnClickListener paramOnClickListener)
  {
    paramb = super.a(paramInt, paramObject, paramb, paramOnClickListener);
    if ((paramb instanceof SimpleTextView)) {
      paramb.setTag(paramObject);
    }
    return paramb;
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    this.this$0.a(paramInt, paramArrayOfb, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zci
 * JD-Core Version:    0.7.0.1
 */