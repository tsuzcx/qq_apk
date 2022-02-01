import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class oef
  extends acdl
{
  oef(oee paramoee) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(oee.a(this.c))))
    {
      paramLong = BaseApplicationImpl.getApplication().getBaseContext();
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131719496, 0).show(paramLong.getResources().getDimensionPixelSize(2131299627));
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719483, 0).show(paramLong.getResources().getDimensionPixelSize(2131299627));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oef
 * JD-Core Version:    0.7.0.1
 */