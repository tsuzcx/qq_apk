import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class ucz
  implements aqdf.a
{
  public ucz(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    String str2;
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str1 = (String)AccountManageActivity.a(this.this$0).getTag();
      str2 = (String)AccountManageActivity.b(this.this$0).getTag();
      if (!paramString.equals(str1)) {
        break label64;
      }
      AccountManageActivity.a(this.this$0).setImageBitmap(paramBitmap);
    }
    label64:
    while (!paramString.equals(str2)) {
      return;
    }
    AccountManageActivity.b(this.this$0).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucz
 * JD-Core Version:    0.7.0.1
 */