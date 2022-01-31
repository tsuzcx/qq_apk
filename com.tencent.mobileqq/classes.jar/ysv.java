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

class ysv
  extends bead
{
  ysv(ysu paramysu, ysl paramysl, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(beae parambeae)
  {
    if (parambeae.a == 0)
    {
      parambeae = this.jdField_a_of_type_Ysu.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambeae.hasNext()) {
        if (!((File)parambeae.next()).exists())
        {
          this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysu);
          return;
        }
      }
      try
      {
        parambeae = this.jdField_a_of_type_Ysl.b.iterator();
        int i = 1;
        while (parambeae.hasNext())
        {
          String str = (String)parambeae.next();
          File localFile = new File(this.jdField_a_of_type_Ysu.a() + File.separator + "v_" + i + ".mp4");
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
            xrg.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Ysu.b();
      }
      catch (IOException parambeae)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambeae, new Object[0]);
        this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysu);
        this.jdField_a_of_type_Ysl.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.b(this.jdField_a_of_type_Ysu);
        this.jdField_a_of_type_Ysu.jdField_a_of_type_Ysz = new ysm(this.jdField_a_of_type_Ysu.jdField_a_of_type_Ysb, this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta, this.jdField_a_of_type_Ysu.c, this.jdField_a_of_type_Ysl.b, this.jdField_a_of_type_Ysl.d, this.jdField_a_of_type_Ysl.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Ysl.a) {
          this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.b(this.jdField_a_of_type_Ysu.jdField_a_of_type_Ysz);
        } else {
          this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysu.jdField_a_of_type_Ysz);
        }
      }
    }
    this.jdField_a_of_type_Ysu.d = ("donwload failed!code = " + parambeae.a + "errmsg = " + parambeae.b);
    this.jdField_a_of_type_Ysu.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */