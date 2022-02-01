import android.text.Editable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.a;
import com.tencent.widget.XEditTextEx;

public class uiq
  implements PhotoListPanel.a
{
  public uiq(BaseChatPie paramBaseChatPie) {}
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    return false;
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    if (this.this$0.aSM) {}
    while ((this.this$0.OS()) || (this.this$0.a == null) || (this.this$0.a.getText() == null) || (this.this$0.a.getText().length() <= 0)) {
      return false;
    }
    this.this$0.bIb();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uiq
 * JD-Core Version:    0.7.0.1
 */