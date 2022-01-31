import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

class yog
  extends bdvu
{
  yog(yof paramyof, ynw paramynw, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (parambdvv.a == 0)
    {
      parambdvv = this.jdField_a_of_type_Yof.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambdvv.hasNext()) {
        if (!((File)parambdvv.next()).exists())
        {
          this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Yof);
          return;
        }
      }
      try
      {
        parambdvv = this.jdField_a_of_type_Ynw.b.iterator();
        int i = 1;
        while (parambdvv.hasNext())
        {
          String str = (String)parambdvv.next();
          File localFile = new File(this.jdField_a_of_type_Yof.a() + File.separator + "v_" + i + ".mp4");
          this.jdField_a_of_type_JavaUtilArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            xmx.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Yof.b();
      }
      catch (IOException parambdvv)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambdvv, new Object[0]);
        this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Yof);
        this.jdField_a_of_type_Ynw.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.b(this.jdField_a_of_type_Yof);
        this.jdField_a_of_type_Yof.jdField_a_of_type_Yok = new ynx(this.jdField_a_of_type_Yof.jdField_a_of_type_Ynm, this.jdField_a_of_type_Yof.jdField_a_of_type_Yol, this.jdField_a_of_type_Yof.c, this.jdField_a_of_type_Ynw.b, this.jdField_a_of_type_Ynw.d, this.jdField_a_of_type_Ynw.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Ynw.a) {
          this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.b(this.jdField_a_of_type_Yof.jdField_a_of_type_Yok);
        } else {
          this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Yof.jdField_a_of_type_Yok);
        }
      }
    }
    this.jdField_a_of_type_Yof.d = ("donwload failed!code = " + parambdvv.a + "errmsg = " + parambdvv.b);
    this.jdField_a_of_type_Yof.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Yof);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yog
 * JD-Core Version:    0.7.0.1
 */