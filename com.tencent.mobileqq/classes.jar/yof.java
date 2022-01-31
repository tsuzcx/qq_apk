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

public class yof
  extends yok
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public yof(ynm paramynm, yol paramyol, String paramString)
  {
    super(paramynm, paramyol, paramString);
    paramynm = a();
    int i = 0;
    while (i < paramynm.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramyol = (String)paramynm.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramyol, ".mp4");
      paramynm.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramyol)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramyol);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramyol, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramynm.jdField_b_of_type_JavaLangString))
    {
      paramyol = new File(a(paramynm.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramyol.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramynm.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramynm.jdField_b_of_type_JavaLangString, new File(paramyol.getAbsolutePath()));
      }
      paramynm.d = paramyol.getAbsolutePath();
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
    ynw localynw = a();
    if (localynw.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Yol.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bdvv(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bdvv)localObject2).b = 3;
      this.jdField_a_of_type_Ynm.a().a((bdvv)localObject2, new yog(this, localynw, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localynw.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            xmx.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Yol.a(this);
        localynw.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Yol.b(this);
        this.jdField_a_of_type_Yok = new ynx(this.jdField_a_of_type_Ynm, this.jdField_a_of_type_Yol, this.c, localynw.jdField_b_of_type_JavaUtilArrayList, localynw.d, localynw.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localynw.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Yol.b(this.jdField_a_of_type_Yok);
      }
      else
      {
        this.jdField_a_of_type_Yok.d = "lib not ready";
        this.jdField_a_of_type_Yol.a(this.jdField_a_of_type_Yok);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */