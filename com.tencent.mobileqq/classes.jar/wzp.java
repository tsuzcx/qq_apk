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

public class wzp
  extends wzu
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public wzp(wyw paramwyw, wzv paramwzv, String paramString)
  {
    super(paramwyw, paramwzv, paramString);
    paramwyw = a();
    int i = 0;
    while (i < paramwyw.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramwzv = (String)paramwyw.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramString = a(paramwzv, ".mp4");
      paramwyw.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramwzv)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwzv);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwzv, new File(paramString));
      }
      i += 1;
    }
    if (!TextUtils.isEmpty(paramwyw.jdField_b_of_type_JavaLangString))
    {
      paramwzv = new File(a(paramwyw.jdField_b_of_type_JavaLangString, ".m4a"));
      if (!paramwzv.exists())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramwyw.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramwyw.jdField_b_of_type_JavaLangString, new File(paramwzv.getAbsolutePath()));
      }
      paramwyw.d = paramwzv.getAbsolutePath();
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
    wzg localwzg = a();
    if (localwzg.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Wzv.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bbwg(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bbwg)localObject2).b = 3;
      this.jdField_a_of_type_Wyw.a().a((bbwg)localObject2, new wzq(this, localwzg, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localwzg.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            vyi.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Wzv.a(this);
        localwzg.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Wzv.b(this);
        this.jdField_a_of_type_Wzu = new wzh(this.jdField_a_of_type_Wyw, this.jdField_a_of_type_Wzv, this.c, localwzg.jdField_b_of_type_JavaUtilArrayList, localwzg.d, localwzg.c);
        if (!VideoEnvironment.e((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localwzg.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Wzv.b(this.jdField_a_of_type_Wzu);
      }
      else
      {
        this.jdField_a_of_type_Wzu.d = "lib not ready";
        this.jdField_a_of_type_Wzv.a(this.jdField_a_of_type_Wzu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzp
 * JD-Core Version:    0.7.0.1
 */