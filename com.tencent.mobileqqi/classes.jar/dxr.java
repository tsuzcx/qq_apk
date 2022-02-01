import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class dxr
  extends AsyncTask
{
  private Object jdField_a_of_type_JavaLangObject;
  
  public dxr(dxq paramdxq, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.jdField_a_of_type_Dxq.a((int)l3, this.jdField_a_of_type_JavaLangObject, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        dxq.a(this.jdField_a_of_type_Dxq, paramVarArgs);
        l2 = SystemClock.uptimeMillis();
        if (l2 < l1)
        {
          this.jdField_a_of_type_Dxq.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Dxq, l1 - l2);
          return null;
        }
        this.jdField_a_of_type_Dxq.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_Dxq);
        return null;
      }
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VipBubbleAnimation", 4, "", paramVarArgs);
      }
      dxq.a(this.jdField_a_of_type_Dxq, null);
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.jdField_a_of_type_Dxq.jdField_a_of_type_Dxr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dxr
 * JD-Core Version:    0.7.0.1
 */