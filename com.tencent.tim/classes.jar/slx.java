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

class slx
  extends aquy
{
  slx(sli.e parame, sli.c paramc, ArrayList paramArrayList, long paramLong) {}
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz.errCode == 0)
    {
      paramaquz = this.jdField_a_of_type_Sli$e.fP.values().iterator();
      while (paramaquz.hasNext()) {
        if (!((File)paramaquz.next()).exists())
        {
          this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.a(this.jdField_a_of_type_Sli$e);
          return;
        }
      }
      try
      {
        paramaquz = this.jdField_a_of_type_Sli$c.of.iterator();
        int i = 1;
        while (paramaquz.hasNext())
        {
          String str = (String)paramaquz.next();
          File localFile = new File(this.jdField_a_of_type_Sli$e.getRootDir() + File.separator + "v_" + i + ".mp4");
          this.val$paths.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            rox.copyFile(new File(str), localFile);
            i += 1;
          }
        }
        this.jdField_a_of_type_Sli$e.runNext();
      }
      catch (IOException paramaquz)
      {
        QLog.e(".troop.VideoCombineHelper", 1, paramaquz, new Object[0]);
        this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.a(this.jdField_a_of_type_Sli$e);
        this.jdField_a_of_type_Sli$c.of = this.val$paths;
        this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.b(this.jdField_a_of_type_Sli$e);
        this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$h = new sli.d(this.jdField_a_of_type_Sli$e.this$0, this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i, this.jdField_a_of_type_Sli$e.key, this.jdField_a_of_type_Sli$c.of, this.jdField_a_of_type_Sli$c.Qp, this.jdField_a_of_type_Sli$c.wording);
        if (!VideoEnvironment.r((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.CU));
        return;
        if (this.jdField_a_of_type_Sli$c.aLV) {
          this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.b(this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$h);
        } else {
          this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.a(this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$h);
        }
      }
    }
    this.jdField_a_of_type_Sli$e.msg = ("donwload failed!code = " + paramaquz.errCode + "errmsg = " + paramaquz.errMsg);
    this.jdField_a_of_type_Sli$e.jdField_a_of_type_Sli$i.a(this.jdField_a_of_type_Sli$e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */