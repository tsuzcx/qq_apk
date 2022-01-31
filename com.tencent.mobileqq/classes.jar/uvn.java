import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;

public class uvn
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public void a(@NonNull utx paramutx, uvr paramuvr)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(paramutx).map(new uun("MsgTabPreloader")).map(new uuk(null)).subscribe(new uvo(this, paramuvr, paramutx));
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
    }
    Stream.of(paramutx).map(new uun("MsgTabPreloader")).subscribe(new uvq(this, paramuvr, paramutx));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */