import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk;
import com.tencent.qphone.base.util.QLog;

public class fyx
{
  int jdField_a_of_type_Int;
  public final long a;
  public UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  final String jdField_a_of_type_JavaLangString;
  public int b;
  public final long b;
  Object b;
  long jdField_c_of_type_Long;
  Object jdField_c_of_type_JavaLangObject = new Object();
  long d;
  
  public fyx(UniformDownloaderAppBabySdk paramUniformDownloaderAppBabySdk, long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = 0L;
    this.d = 0L;
    this.jdField_b_of_type_Int = -1;
  }
  
  int a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public long a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      long l = this.jdField_c_of_type_Long;
      return l;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      QLog.i(UniformDownloaderAppBabySdk.jdField_a_of_type_JavaLangString, 1, "[UniformDL] setStatus:" + this.jdField_a_of_type_Int + " -> " + paramInt + "url:" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
  }
  
  public long b()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      long l = this.d;
      return l;
    }
  }
  
  public void b(long paramLong)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.d = paramLong;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fyx
 * JD-Core Version:    0.7.0.1
 */