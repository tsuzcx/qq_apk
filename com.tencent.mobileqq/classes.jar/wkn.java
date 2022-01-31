import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import mqq.app.AppRuntime;

public class wkn
  extends wks
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public wkn(wju paramwju, wkt paramwkt, String paramString)
  {
    super(paramwju, paramwkt, paramString);
    paramwju = a();
    int i = 0;
    while (i < paramwju.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramwkt = (String)paramwju.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramwkt, ".mp4");
      paramwju.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwkt)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwkt);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwkt, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramwju.jdField_b_of_type_JavaLangString))
    {
      paramwkt = new File(a(paramwju.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramwkt.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwju.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwju.jdField_b_of_type_JavaLangString, new File(paramwkt.getAbsolutePath()));
      }
      paramwju.d = paramwkt.getAbsolutePath();
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = UUID.nameUUIDFromBytes(paramString1.getBytes());
    paramString1 = b().getAbsolutePath() + File.separator + "v_" + paramString1.toString() + paramString2;
    paramString2 = new File(paramString1);
    if (!paramString2.getParentFile().exists()) {
      paramString2.mkdirs();
    }
    return paramString1;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new Bundle();
    wke localwke = a();
    if (localwke.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Wkt.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new batm(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((batm)localObject2).b = 3;
      this.jdField_a_of_type_Wju.a().a((batm)localObject2, new wko(this, localwke, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localwke.jdField_b_of_type_JavaUtilArrayList.iterator();
        int i = 1;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          File localFile = new File(a() + File.separator + "v_" + i + ".mp4");
          localArrayList.add(localFile.getAbsolutePath());
          if (localFile.exists())
          {
            i += 1;
          }
          else
          {
            if (!localFile.exists()) {
              localFile.createNewFile();
            }
            vlm.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Wkt.a(this);
        localwke.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Wkt.b(this);
        this.jdField_a_of_type_Wks = new wkf(this.jdField_a_of_type_Wju, this.jdField_a_of_type_Wkt, this.c, localwke.jdField_b_of_type_JavaUtilArrayList, localwke.d, localwke.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localwke.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Wkt.b(this.jdField_a_of_type_Wks);
      }
      else
      {
        this.jdField_a_of_type_Wks.d = "lib not ready";
        this.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Wks);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkn
 * JD-Core Version:    0.7.0.1
 */