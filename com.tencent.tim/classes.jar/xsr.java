import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.io.File;

class xsr
  implements ausj.a
{
  xsr(xsk paramxsk, ausj paramausj, AIOImageData paramAIOImageData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    paramView = this.val$actionSheet.getContent(paramInt);
    if (paramView == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.val$actionSheet.dismiss();
      return;
    }
    if (this.this$0.a(paramView, this.a, this.S)) {}
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsr
 * JD-Core Version:    0.7.0.1
 */