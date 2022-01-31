import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic.QwTextAdapter;

public class xdq
  extends SendHbLogic.QwTextAdapter
{
  public xdq(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QzoneHbFragment.a(this.a).setEnabled(QzoneHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdq
 * JD-Core Version:    0.7.0.1
 */