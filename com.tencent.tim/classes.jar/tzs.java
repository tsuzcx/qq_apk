import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class tzs
  extends SimpleObserver<ajcn>
{
  tzs(tzr paramtzr, tzr.c paramc) {}
  
  public void a(ajcn paramajcn)
  {
    tzr.c localc = this.a;
    if (paramajcn.appState == 1) {}
    for (int i = 2;; i = 3)
    {
      localc.a(paramajcn, i);
      return;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper", 2, "onError: " + paramError.getMessage());
    }
    if ((paramError instanceof AppInfoError)) {}
    for (int i = ((AppInfoError)paramError).type;; i = 0)
    {
      this.a.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzs
 * JD-Core Version:    0.7.0.1
 */