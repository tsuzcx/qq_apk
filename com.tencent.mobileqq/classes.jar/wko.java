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

class wko
  extends batl
{
  wko(wkn paramwkn, wke paramwke, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(batm parambatm)
  {
    if (parambatm.a == 0)
    {
      parambatm = this.jdField_a_of_type_Wkn.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (parambatm.hasNext()) {
        if (!((File)parambatm.next()).exists())
        {
          this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wkn);
          return;
        }
      }
      try
      {
        parambatm = this.jdField_a_of_type_Wke.b.iterator();
        int i = 1;
        while (parambatm.hasNext())
        {
          String str = (String)parambatm.next();
          File localFile = new File(this.jdField_a_of_type_Wkn.a() + File.separator + "v_" + i + ".mp4");
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
            vlm.a(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Wkn.b();
      }
      catch (IOException parambatm)
      {
        QLog.e(".troop.VideoCombineHelper", 1, parambatm, new Object[0]);
        this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wkn);
        this.jdField_a_of_type_Wke.b = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.b(this.jdField_a_of_type_Wkn);
        this.jdField_a_of_type_Wkn.jdField_a_of_type_Wks = new wkf(this.jdField_a_of_type_Wkn.jdField_a_of_type_Wju, this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt, this.jdField_a_of_type_Wkn.c, this.jdField_a_of_type_Wke.b, this.jdField_a_of_type_Wke.d, this.jdField_a_of_type_Wke.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
        return;
        if (this.jdField_a_of_type_Wke.a) {
          this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.b(this.jdField_a_of_type_Wkn.jdField_a_of_type_Wks);
        } else {
          this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wkn.jdField_a_of_type_Wks);
        }
      }
    }
    this.jdField_a_of_type_Wkn.d = ("donwload failed!code = " + parambatm.a + "errmsg = " + parambatm.b);
    this.jdField_a_of_type_Wkn.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wkn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */