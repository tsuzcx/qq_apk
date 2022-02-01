import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.io.File;

public class rfq
  extends rfo
{
  private rdc a;
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface, rdc paramrdc)
  {
    super.a(paramActivity, paramString1, paramString2, paramAppInterface);
    this.a = paramrdc;
  }
  
  protected boolean b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem.action == 2)
    {
      if (this.a != null) {
        this.a.bsn();
      }
      return true;
    }
    return super.b(paramActionSheetItem);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (bqz != 2)
    {
      String str = new File(this.mVideoPath).getParent();
      if (str != null) {
        aqhq.cn(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfq
 * JD-Core Version:    0.7.0.1
 */