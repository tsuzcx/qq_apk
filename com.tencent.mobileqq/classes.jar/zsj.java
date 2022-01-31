import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;

class zsj
  extends SimpleObserver<armr>
{
  zsj(zsi paramzsi, zss paramzss) {}
  
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
    if ((paramError instanceof AppInfoError)) {}
    for (int i = ((AppInfoError)paramError).type;; i = 0)
    {
      this.jdField_a_of_type_Zss.a(null, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsj
 * JD-Core Version:    0.7.0.1
 */