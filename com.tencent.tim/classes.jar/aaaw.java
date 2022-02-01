import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment.a;

public class aaaw
  implements zxt.a
{
  public aaaw(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void aM(Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramObject = QzoneHbFragment.a(this.this$0).obtainMessage();
      paramObject.what = 102;
      QzoneHbFragment.a(this.this$0).sendMessage(paramObject);
    }
  }
  
  public void onLoadFail() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaaw
 * JD-Core Version:    0.7.0.1
 */