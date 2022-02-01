import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;

class wyb
  extends acfd
{
  wyb(wxz paramwxz) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.this$0.mApp != null) && (paramString.equals(this.this$0.mApp.getCurrentAccountUin())))
    {
      paramString = this.this$0.mApp.a(this.this$0.mApp.getCurrentAccountUin(), (byte)1, false);
      if ((paramString != null) && (wxz.a(this.this$0) != null)) {
        wxz.a(this.this$0).setImageBitmap(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyb
 * JD-Core Version:    0.7.0.1
 */