import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class myy
  extends lgv.b
{
  myy(myq parammyq) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!myq.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(myq.a(this.a));
    paramString2.setDuration(2000);
    if (paramBoolean)
    {
      paramString2.setToastIcon(QQToast.getIconRes(2));
      paramString2.setToastMsg(2131693408);
      paramString2.show(myq.a(this.a).getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(myq.a(this.a), 5.0F));
    }
    for (;;)
    {
      myq.a(this.a).remove(paramString1);
      return;
      paramString2.setToastIcon(QQToast.getIconRes(1));
      paramString2.setToastMsg(2131693409);
      paramString2.show(myq.a(this.a).getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(myq.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myy
 * JD-Core Version:    0.7.0.1
 */