import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class cgg
  implements IIconListener
{
  public cgg(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (DetailProfileActivity.a(this.a) == null) {
      DetailProfileActivity.a(this.a, (StatusManager)this.a.b.getManager(13));
    }
    if ((DetailProfileActivity.a(this.a) != null) && (DetailProfileActivity.a(this.a).a().b == paramInt1) && (paramInt2 == 201) && (paramBitmap != null)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgg
 * JD-Core Version:    0.7.0.1
 */