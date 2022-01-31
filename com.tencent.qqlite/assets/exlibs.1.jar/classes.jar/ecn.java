import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;

class ecn
  extends AsyncTask
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ecn(ecm paramecm, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  private Bitmap a(File paramFile)
  {
    Bitmap localBitmap1 = null;
    Bitmap localBitmap2 = null;
    if (paramFile.exists()) {
      localBitmap2 = localBitmap1;
    }
    try
    {
      localBitmap1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        localBitmap2 = localBitmap1;
        paramFile.delete();
        localBitmap2 = localBitmap1;
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError paramFile) {}
    return localBitmap2;
  }
  
  protected Bitmap a(Void... paramVarArgs)
  {
    Object localObject1 = null;
    paramVarArgs = null;
    boolean bool2 = true;
    Object localObject2 = ecm.a();
    if (localObject2 != null)
    {
      localObject1 = new File((File)localObject2, this.jdField_a_of_type_JavaLangString);
      boolean bool1 = bool2;
      if (!((File)localObject1).exists())
      {
        if (!TextUtils.isEmpty(this.b))
        {
          localObject2 = a(new File((File)localObject2, this.b));
          if (localObject2 != null) {
            publishProgress(new Bitmap[] { localObject2 });
          }
        }
        bool1 = bool2;
        if (this.c != null)
        {
          if ((ecm.a(this.jdField_a_of_type_Ecm) > 3L) && (Math.abs(SystemClock.uptimeMillis() - ecm.a(this.jdField_a_of_type_Ecm)) > 60000L)) {
            ecm.a(this.jdField_a_of_type_Ecm, 0L);
          }
          bool1 = bool2;
          if (ecm.a(this.jdField_a_of_type_Ecm) < 3L) {
            bool1 = ecm.a(this.jdField_a_of_type_Ecm, this.c, (File)localObject1);
          }
        }
      }
      if (bool1) {
        paramVarArgs = a((File)localObject1);
      }
      if ((!bool1) || (paramVarArgs == null)) {
        break label253;
      }
      ecm.a(this.jdField_a_of_type_Ecm, 0L);
      localObject1 = paramVarArgs;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.img", 2, "decodeBitmap finish with " + localObject1 + ", " + ecm.a(this.jdField_a_of_type_Ecm));
      }
      return localObject1;
      label253:
      localObject1 = paramVarArgs;
      if (!TextUtils.isEmpty(this.c))
      {
        localObject1 = paramVarArgs;
        if (ecm.b(this.jdField_a_of_type_Ecm) == 3L)
        {
          ecm.a(this.jdField_a_of_type_Ecm, SystemClock.uptimeMillis());
          localObject1 = paramVarArgs;
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      BaseApplicationImpl.a.put(ecm.a(this.jdField_a_of_type_Ecm) + this.jdField_a_of_type_JavaLangString, paramBitmap, (byte)0);
    }
    ecm.a(this.jdField_a_of_type_Ecm).remove(this.jdField_a_of_type_JavaLangString);
    if (ecm.a(this.jdField_a_of_type_Ecm) != null) {
      ecm.a(this.jdField_a_of_type_Ecm).a(this.jdField_a_of_type_JavaLangString, this.c, paramBitmap, 1);
    }
  }
  
  protected void a(Bitmap... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    BaseApplicationImpl.a.put(ecm.a(this.jdField_a_of_type_Ecm) + this.b, paramVarArgs, (byte)0);
    if (ecm.a(this.jdField_a_of_type_Ecm) != null) {
      ecm.a(this.jdField_a_of_type_Ecm).a(this.jdField_a_of_type_JavaLangString, this.c, paramVarArgs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecn
 * JD-Core Version:    0.7.0.1
 */