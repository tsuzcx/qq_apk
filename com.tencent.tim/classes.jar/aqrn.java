import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class aqrn
  implements Handler.Callback
{
  private aqro jdField_a_of_type_Aqro;
  private aqrp jdField_a_of_type_Aqrp;
  private AppRuntime mApp;
  private Handler mUIHandler;
  
  public aqrn(AppRuntime paramAppRuntime, int paramInt)
  {
    this.mApp = paramAppRuntime;
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aqrp = new aqrp(paramInt, this.mApp, this.mUIHandler);
  }
  
  public aqro a()
  {
    return this.jdField_a_of_type_Aqro;
  }
  
  public aqrp a()
  {
    return this.jdField_a_of_type_Aqrp;
  }
  
  public void a(aqro paramaqro)
  {
    this.jdField_a_of_type_Aqro = paramaqro;
    this.jdField_a_of_type_Aqro.load();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Aqro == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Aqro.O(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_Aqro.load();
    }
  }
  
  public void recycle()
  {
    if (this.jdField_a_of_type_Aqro != null) {
      this.jdField_a_of_type_Aqro.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrn
 * JD-Core Version:    0.7.0.1
 */