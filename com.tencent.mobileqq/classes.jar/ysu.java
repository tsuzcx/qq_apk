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

public class ysu
  extends ysz
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ysu(ysb paramysb, yta paramyta, String paramString)
  {
    super(paramysb, paramyta, paramString);
    paramysb = a();
    int i = 0;
    while (i < paramysb.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramyta = (String)paramysb.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramyta, ".mp4");
      paramysb.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramyta)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramyta);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramyta, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramysb.jdField_b_of_type_JavaLangString))
    {
      paramyta = new File(a(paramysb.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramyta.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramysb.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramysb.jdField_b_of_type_JavaLangString, new File(paramyta.getAbsolutePath()));
      }
      paramysb.d = paramyta.getAbsolutePath();
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
    ysl localysl = a();
    if (localysl.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Yta.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new beae(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((beae)localObject2).b = 3;
      this.jdField_a_of_type_Ysb.a().a((beae)localObject2, new ysv(this, localysl, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localysl.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            xrg.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Yta.a(this);
        localysl.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Yta.b(this);
        this.jdField_a_of_type_Ysz = new ysm(this.jdField_a_of_type_Ysb, this.jdField_a_of_type_Yta, this.c, localysl.jdField_b_of_type_JavaUtilArrayList, localysl.d, localysl.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localysl.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Yta.b(this.jdField_a_of_type_Ysz);
      }
      else
      {
        this.jdField_a_of_type_Ysz.d = "lib not ready";
        this.jdField_a_of_type_Yta.a(this.jdField_a_of_type_Ysz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */