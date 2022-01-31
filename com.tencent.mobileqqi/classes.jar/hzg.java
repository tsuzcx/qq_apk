import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.HashMap;

public abstract class hzg
  extends Thread
{
  HashMap jdField_a_of_type_JavaUtilHashMap = null;
  boolean jdField_a_of_type_Boolean = true;
  boolean[] jdField_a_of_type_ArrayOfBoolean = { false };
  
  hzg(TraeAudioManager paramTraeAudioManager)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " ++switchThread:" + a());
    }
  }
  
  public abstract String a();
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.b.b();
    AudioDeviceInterface.LogTraceEntry(a() + " err:" + paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.b.a();
    }
    do
    {
      return;
      this.b.ak = this.b.a.d();
      localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " sessonID:" + localObject);
      }
      if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
        break;
      }
      this.b.a();
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
    return;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PARAM_DEVICE"));
    if (this.b.a((Intent)localObject, this.jdField_a_of_type_JavaUtilHashMap, paramInt) == 0) {
      this.b.a();
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void a(HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public abstract void b();
  
  void e()
  {
    this.b.a.d(a());
    a(0);
  }
  
  public void f()
  {
    AudioDeviceInterface.LogTraceEntry(a());
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " quit:" + a() + " _running:" + this.jdField_a_of_type_Boolean);
    }
    interrupt();
    b();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      label91:
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label91;
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry(a());
    this.b.a.c(a());
    this.b.b();
    a();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzg
 * JD-Core Version:    0.7.0.1
 */