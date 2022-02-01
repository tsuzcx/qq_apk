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

public class zqj
  extends zqo
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public zqj(zpq paramzpq, zqp paramzqp, String paramString)
  {
    super(paramzpq, paramzqp, paramString);
    paramzpq = a();
    if (paramzpq != null)
    {
      int i = 0;
      while (i < paramzpq.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramzqp = (String)paramzpq.jdField_a_of_type_JavaUtilArrayList.get(i);
        paramString = a(paramzqp, ".mp4");
        paramzpq.jdField_b_of_type_JavaUtilArrayList.add(paramString);
        if ((!new File(paramString).exists()) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramzqp)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramzqp);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramzqp, new File(paramString));
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(paramzpq.jdField_b_of_type_JavaLangString))
      {
        paramzqp = new File(a(paramzpq.jdField_b_of_type_JavaLangString, ".m4a"));
        if (!paramzqp.exists())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramzpq.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramzpq.jdField_b_of_type_JavaLangString, new File(paramzqp.getAbsolutePath()));
        }
        paramzpq.d = paramzqp.getAbsolutePath();
      }
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
    zqa localzqa = a();
    if (localzqa.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Zqp.b(this);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new bgoe(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilHashMap, this.c);
      ((bgoe)localObject2).b = 3;
      this.jdField_a_of_type_Zpq.a().a((bgoe)localObject2, new zqk(this, localzqa, localArrayList, l), (Bundle)localObject1);
      label111:
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.c);
      }
    }
    else
    {
      try
      {
        localObject1 = localzqa.jdField_b_of_type_JavaUtilArrayList.iterator();
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
            ypi.a(new File((String)localObject2), localFile);
            i += 1;
          }
        }
        b();
      }
      catch (IOException localIOException)
      {
        QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
        this.jdField_a_of_type_Zqp.a(this);
        localzqa.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        this.jdField_a_of_type_Zqp.b(this);
        this.jdField_a_of_type_Zqo = new zqb(this.jdField_a_of_type_Zpq, this.jdField_a_of_type_Zqp, this.c, localzqa.jdField_b_of_type_JavaUtilArrayList, localzqa.d, localzqa.c);
        if (!VideoEnvironment.checkAVCodecLoadIsOK((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
      }
    }
    for (;;)
    {
      QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
      break label111;
      break;
      if (localzqa.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Zqp.b(this.jdField_a_of_type_Zqo);
      }
      else
      {
        this.jdField_a_of_type_Zqo.d = "lib not ready";
        this.jdField_a_of_type_Zqp.a(this.jdField_a_of_type_Zqo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqj
 * JD-Core Version:    0.7.0.1
 */