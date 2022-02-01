import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class uwh
  extends ansy
{
  uwh(uwg paramuwg) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(uwg.a(this.a))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131718513, 0).b(paramLong.getResources().getDimensionPixelSize(2131299080));
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131718500, 0).b(paramLong.getResources().getDimensionPixelSize(2131299080));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwh
 * JD-Core Version:    0.7.0.1
 */