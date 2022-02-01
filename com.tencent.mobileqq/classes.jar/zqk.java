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

class zqk
  extends bgod
{
  zqk(zqj paramzqj, zqa paramzqa, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (parambgoe.a == 0)
    {
      parambgoe = this.jdField_a_of_type_Zqj.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambgoe.hasNext()) {
        if (!((File)parambgoe.next()).exists())
        {
          this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqj);
          return;
        }
      }
      try
      {
        parambgoe = this.jdField_a_of_type_Zqa.b.iterator();
        int i = 1;
        while (parambgoe.hasNext())
        {
          String str = (String)parambgoe.next();
          File localFile = new File(this.jdField_a_of_type_Zqj.a() + File.separator + "v_" + i + ".mp4");
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
            ypi.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Zqj.b();
      }
      catch (IOException parambgoe)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambgoe, new Object[0]);
        this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqj);
        this.jdField_a_of_type_Zqa.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.b(this.jdField_a_of_type_Zqj);
        this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqo = new zqb(this.jdField_a_of_type_Zqj.jdField_a_of_type_Zpq, this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp, this.jdField_a_of_type_Zqj.c, this.jdField_a_of_type_Zqa.b, this.jdField_a_of_type_Zqa.d, this.jdField_a_of_type_Zqa.c);
        if (!VideoEnvironment.checkAVCodecLoadIsOK((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Zqa.a) {
          this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.b(this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqo);
        } else {
          this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqo);
        }
      }
    }
    this.jdField_a_of_type_Zqj.d = ("donwload failed!code = " + parambgoe.a + "errmsg = " + parambgoe.b);
    this.jdField_a_of_type_Zqj.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqk
 * JD-Core Version:    0.7.0.1
 */