import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wsa
{
  private static volatile wsa jdField_a_of_type_Wsa;
  private MQLruCache<String, AnimationDrawable> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(10);
  
  private Bitmap a(File paramFile)
  {
    QLog.i("AnimationDrawableFactory", 2, "getBitMapFromFile fileName:" + paramFile.getName());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFile.exists())
    {
      localObject1 = localObject2;
      if (paramFile.isFile()) {
        localObject1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      }
    }
    return localObject1;
  }
  
  public static wsa a()
  {
    if (jdField_a_of_type_Wsa == null) {}
    try
    {
      if (jdField_a_of_type_Wsa == null) {
        jdField_a_of_type_Wsa = new wsa();
      }
      return jdField_a_of_type_Wsa;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString) != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, wsc paramwsc, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramwsc != null) {
        paramwsc.a();
      }
    }
    ThreadManagerV2.executeOnSubThread(new AnimationDrawableFactory.1(this, paramBoolean, paramString, paramInt, paramwsc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */