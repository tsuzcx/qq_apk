import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class ubu
  extends anwb
{
  ubu(ubt paramubt) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(ubt.a(this.a))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131717888, 0).b(paramLong.getResources().getDimensionPixelSize(2131299011));
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131717877, 0).b(paramLong.getResources().getDimensionPixelSize(2131299011));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubu
 * JD-Core Version:    0.7.0.1
 */