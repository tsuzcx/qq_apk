import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment.UrlNotauthorizedError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class zsm
  extends SimpleObserver<armr>
{
  zsm(zsi paramzsi, zss paramzss) {}
  
  public void a(armr paramarmr)
  {
    zss localzss = this.jdField_a_of_type_Zss;
    if (paramarmr.c == 1) {}
    for (int i = 2;; i = 3)
    {
      localzss.a(paramarmr, i);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper", 2, "onError: " + paramError.getMessage());
    }
    int i;
    if ((paramError instanceof VerifyUrlJobSegment.UrlNotauthorizedError)) {
      i = 4;
    }
    for (;;)
    {
      this.jdField_a_of_type_Zss.a(null, i);
      return;
      if ((paramError instanceof AppInfoError)) {
        i = ((AppInfoError)paramError).type;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsm
 * JD-Core Version:    0.7.0.1
 */