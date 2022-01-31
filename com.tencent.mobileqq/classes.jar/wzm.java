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

public class wzm
  extends wzr
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public wzm(wyt paramwyt, wzs paramwzs, String paramString)
  {
    super(paramwyt, paramwzs, paramString);
    paramwyt = a();
    int i = 0;
    while (i < paramwyt.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramwzs = (String)paramwyt.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramwzs, ".mp4");
      paramwyt.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwzs)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwzs);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwzs, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramwyt.jdField_b_of_type_JavaLangString))
    {
      paramwzs = new File(a(paramwyt.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramwzs.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwyt.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwyt.jdField_b_of_type_JavaLangString, new File(paramwzs.getAbsolutePath()));
      }
      paramwyt.d = paramwzs.getAbsolutePath();
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
    wzd localwzd = a();
    if (localwzd.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Wzs.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bbwu(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bbwu)localObject2).b = 3;
      this.jdField_a_of_type_Wyt.a().a((bbwu)localObject2, new wzn(this, localwzd, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localwzd.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            vyf.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Wzs.a(this);
        localwzd.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Wzs.b(this);
        this.jdField_a_of_type_Wzr = new wze(this.jdField_a_of_type_Wyt, this.jdField_a_of_type_Wzs, this.c, localwzd.jdField_b_of_type_JavaUtilArrayList, localwzd.d, localwzd.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localwzd.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Wzs.b(this.jdField_a_of_type_Wzr);
      }
      else
      {
        this.jdField_a_of_type_Wzr.d = "lib not ready";
        this.jdField_a_of_type_Wzs.a(this.jdField_a_of_type_Wzr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzm
 * JD-Core Version:    0.7.0.1
 */