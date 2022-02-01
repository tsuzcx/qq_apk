import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class vfr
  implements vff
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected static final vfn a;
  public static boolean a;
  public int a;
  public long a;
  public transient UniAttribute a;
  public Object a;
  public transient String a;
  private WeakReference<Handler> jdField_a_of_type_JavaLangRefWeakReference;
  public HashMap<Object, Object> a;
  public transient vfg a;
  public vfh a;
  public vfo a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Vfn = vfn.a();
  }
  
  public vfr()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public vfr(vfo paramvfo, Handler paramHandler, vfg paramvfg, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Vfo = paramvfo;
    this.c = paramInt;
    this.jdField_a_of_type_Vfg = paramvfg;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramHandler != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    default: 
      return "";
    case 1000006: 
      QZLog.i("QZLog", 1, "WeishiTask\t 网络无连接");
      return QzoneConfig.getInstance().getConfig("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    case 1000004: 
      return "";
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vfo != null)
    {
      this.jdField_a_of_type_Vfo.a(this.d);
      if (jdField_a_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.jdField_a_of_type_Vfo.a != null) {
          this.jdField_a_of_type_Vfo.a.display(localStringBuilder, 0);
        }
      }
      vmp.a("WeishiTask", "startRunTask: " + this.jdField_a_of_type_Vfo.getCmdString() + ", " + this.jdField_a_of_type_Vfo.toString());
    }
    int i = jdField_a_of_type_Vfn.a(this.jdField_a_of_type_Vfo, this);
    if (i != 0) {
      a(null, i, i, a(i), false, this.jdField_a_of_type_Vfh);
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, vfh paramvfh)
  {
    if ((paramObject instanceof UniAttribute)) {
      this.jdField_a_of_type_ComQqJceWupUniAttribute = ((UniAttribute)paramObject);
    }
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Vfh = paramvfh;
    if (1000006 == paramInt1) {
      this.jdField_a_of_type_JavaLangString = anvx.a(2131716281);
    }
    vfk.a().b(this);
  }
  
  public boolean a()
  {
    return (this.b == 0) || (this.b == 1000) || ((Math.abs(this.b) <= 19999) && (Math.abs(this.b) >= 19000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfr
 * JD-Core Version:    0.7.0.1
 */