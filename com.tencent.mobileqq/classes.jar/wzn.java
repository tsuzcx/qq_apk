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

class wzn
  extends bbwt
{
  wzn(wzm paramwzm, wzd paramwzd, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (parambbwu.a == 0)
    {
      parambbwu = this.jdField_a_of_type_Wzm.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambbwu.hasNext()) {
        if (!((File)parambbwu.next()).exists())
        {
          this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wzm);
          return;
        }
      }
      try
      {
        parambbwu = this.jdField_a_of_type_Wzd.b.iterator();
        int i = 1;
        while (parambbwu.hasNext())
        {
          String str = (String)parambbwu.next();
          File localFile = new File(this.jdField_a_of_type_Wzm.a() + File.separator + "v_" + i + ".mp4");
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
            vyf.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Wzm.b();
      }
      catch (IOException parambbwu)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambbwu, new Object[0]);
        this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wzm);
        this.jdField_a_of_type_Wzd.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.b(this.jdField_a_of_type_Wzm);
        this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzr = new wze(this.jdField_a_of_type_Wzm.jdField_a_of_type_Wyt, this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs, this.jdField_a_of_type_Wzm.c, this.jdField_a_of_type_Wzd.b, this.jdField_a_of_type_Wzd.d, this.jdField_a_of_type_Wzd.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Wzd.a) {
          this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.b(this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzr);
        } else {
          this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzr);
        }
      }
    }
    this.jdField_a_of_type_Wzm.d = ("donwload failed!code = " + parambbwu.a + "errmsg = " + parambbwu.b);
    this.jdField_a_of_type_Wzm.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */