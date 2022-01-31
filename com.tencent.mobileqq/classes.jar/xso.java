import android.os.SystemClock;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.net.URL;

class xso
  implements URLDrawable.DownloadListener, URLDrawable.URLDrawableListener
{
  public static String c;
  public static int f = 1;
  public static int g = 2;
  public static int h = 4;
  public static int i = 8;
  public static int j = 16;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString;
  xsq jdField_a_of_type_Xsq;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  int c;
  int d = 0;
  int e = 0;
  
  static
  {
    jdField_c_of_type_JavaLangString = "story_url_drawable";
  }
  
  public xso(xsq paramxsq, URLDrawable paramURLDrawable, String paramString)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_Xsq = paramxsq;
    this.jdField_a_of_type_JavaLangString = paramURLDrawable.getURL().toString();
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  void a()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    wxj.b(jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_Int, new String[] { String.valueOf(this.jdField_a_of_type_Long), String.valueOf(l1 - l2), String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString });
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_b_of_type_Int |= g;
    this.jdField_a_of_type_Int = paramInt;
    wxe.a("Q.qqstory.UIUtils", "onFileDownloadFailed() %s, error(%d), %s, %d", this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    wxe.a("Q.qqstory.UIUtils", "onFileDownloadStarted() %s, %s, %d", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.jdField_b_of_type_Int |= f;
    this.jdField_a_of_type_Long = paramLong;
    wxe.a("Q.qqstory.UIUtils", "onFileDownloadSucceed() %s, %d, %s, %d", this.jdField_a_of_type_JavaLangString, Long.valueOf(paramLong), this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_b_of_type_Int |= j;
    wxe.a("Q.qqstory.UIUtils", "onLoadCanceled() %s, %s, %d", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.e += 1;
    this.jdField_a_of_type_Xsq.a(this);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int |= i;
    wxe.a("Q.qqstory.UIUtils", "onLoadFialed() %s, %s, %d", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.jdField_c_of_type_Int += 1;
    this.jdField_a_of_type_Xsq.a(this);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    wxe.a("Q.qqstory.UIUtils", "onLoadProgressed(%d/10000%%) %s, %s, %d", Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_b_of_type_Int |= h;
    wxe.a("Q.qqstory.UIUtils", "onLoadSuccessed() %s, %s, %d", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentImageURLDrawable, Integer.valueOf(System.identityHashCode(this)));
    a();
    this.d += 1;
    this.jdField_a_of_type_Xsq.a(this);
  }
  
  public String toString()
  {
    return "DrawableListenerHolder{url='" + this.jdField_a_of_type_JavaLangString + '\'' + ", fileSize=" + this.jdField_a_of_type_Long + ", startTime=" + this.jdField_b_of_type_Long + ", errorCode=" + this.jdField_a_of_type_Int + ", result=" + this.jdField_b_of_type_Int + ", loadFailTime=" + this.jdField_c_of_type_Int + ", loadSuccessTime=" + this.d + ", loadCancelTime=" + this.e + ", op_name='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xso
 * JD-Core Version:    0.7.0.1
 */