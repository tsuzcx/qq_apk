import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class wyc
  implements aqdf.a
{
  wyc(wxz paramwxz) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    for (;;)
    {
      return;
      if (paramString.equals(this.this$0.mMemberUin)) {
        wxz.b(this.this$0).setImageBitmap(paramBitmap);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("intimate_relationship", 2, "onDecodeTaskCompleted, uin: " + paramString + ", type: " + paramInt2);
        return;
        if ((this.this$0.mApp != null) && (paramString.equals(this.this$0.mApp.getCurrentAccountUin()))) {
          wxz.a(this.this$0).setImageBitmap(paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyc
 * JD-Core Version:    0.7.0.1
 */