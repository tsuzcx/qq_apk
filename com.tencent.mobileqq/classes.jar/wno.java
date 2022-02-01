import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;

public class wno
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public void a(@NonNull wly paramwly, wns paramwns)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(paramwly).map(new wmo("MsgTabPreloader")).map(new wml(null)).subscribe(new wnp(this, paramwns, paramwly));
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
    }
    Stream.of(paramwly).map(new wmo("MsgTabPreloader")).subscribe(new wnr(this, paramwns, paramwly));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wno
 * JD-Core Version:    0.7.0.1
 */