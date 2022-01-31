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

class wzq
  extends bbwf
{
  wzq(wzp paramwzp, wzg paramwzg, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(bbwg parambbwg)
  {
    if (parambbwg.a == 0)
    {
      parambbwg = this.jdField_a_of_type_Wzp.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambbwg.hasNext()) {
        if (!((File)parambbwg.next()).exists())
        {
          this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzp);
          return;
        }
      }
      try
      {
        parambbwg = this.jdField_a_of_type_Wzg.b.iterator();
        int i = 1;
        while (parambbwg.hasNext())
        {
          String str = (String)parambbwg.next();
          File localFile = new File(this.jdField_a_of_type_Wzp.a() + File.separator + "v_" + i + ".mp4");
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
            vyi.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Wzp.b();
      }
      catch (IOException parambbwg)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambbwg, new Object[0]);
        this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzp);
        this.jdField_a_of_type_Wzg.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.b(this.jdField_a_of_type_Wzp);
        this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzu = new wzh(this.jdField_a_of_type_Wzp.jdField_a_of_type_Wyw, this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv, this.jdField_a_of_type_Wzp.c, this.jdField_a_of_type_Wzg.b, this.jdField_a_of_type_Wzg.d, this.jdField_a_of_type_Wzg.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Wzg.a) {
          this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.b(this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzu);
        } else {
          this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzu);
        }
      }
    }
    this.jdField_a_of_type_Wzp.d = ("donwload failed!code = " + parambbwg.a + "errmsg = " + parambbwg.b);
    this.jdField_a_of_type_Wzp.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzq
 * JD-Core Version:    0.7.0.1
 */