import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.armap.wealthgod.ARMapThreadStubReceiver;
import com.tencent.qphone.base.util.QLog;

public class whr
  implements Handler.Callback
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  private wht jdField_a_of_type_Wht;
  
  public whr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new whs(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Wht = null;
  }
  
  public void a(String paramString, long paramLong, wht paramwht)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreCallUpToolProc", 2, String.format("callUpToolProc from=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_Wht = paramwht;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramwht = new Intent(this.jdField_a_of_type_AndroidContentContext, ARMapThreadStubReceiver.class);
    paramwht.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD");
    paramwht.putExtra("from", paramString);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramwht);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(108);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(108, paramLong);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Wht != null) {
        this.jdField_a_of_type_Wht.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     whr
 * JD-Core Version:    0.7.0.1
 */