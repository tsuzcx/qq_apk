import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.troop.VideoCombineHelper.1;
import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ysb
{
  public static final String a;
  long jdField_a_of_type_Long = 0L;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<String, ysl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  xtc jdField_a_of_type_Xtc;
  yqz jdField_a_of_type_Yqz;
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.aW + "/Tencent/QQ_business/videocombine";
  }
  
  public ysb(BaseActivity paramBaseActivity)
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.jdField_a_of_type_Xtc = xtc.a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_Xtc.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Yqz = yqz.a();
  }
  
  public beaj a()
  {
    return new beag(null).a(1);
  }
  
  public String a(ysl paramysl, ysj paramysj)
  {
    ??? = UUID.nameUUIDFromBytes(paramysl.c.getBytes());
    String str1 = "combineVideo_" + ((UUID)???).toString();
    String str2 = "prepareVideo_" + ((UUID)???).toString();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2))
      {
        ((ysl)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).b = true;
        Looper.prepare();
        new Handler().postDelayed(new VideoCombineHelper.1(this, paramysl, paramysj), 300L);
        return str1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramysl);
      ThreadManager.post(new VideoCombineHelper.2(this, paramysj, System.currentTimeMillis(), str1), 8, null, false);
      return str1;
    }
  }
  
  public void a(String paramString1, String paramString2, ysj paramysj)
  {
    Object localObject1 = new File(paramString1).getParentFile();
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject2 = new xti();
    Object localObject3 = ((File)localObject1).getAbsolutePath() + File.separator + "vn.m4a";
    Object localObject4 = new ArrayList();
    ((ArrayList)localObject4).add("-y");
    ((ArrayList)localObject4).add("-i");
    ((ArrayList)localObject4).add(paramString1);
    ((ArrayList)localObject4).add("-strict");
    ((ArrayList)localObject4).add("-2");
    ((ArrayList)localObject4).add("-acodec");
    ((ArrayList)localObject4).add("aac");
    ((ArrayList)localObject4).add("-vn");
    ((ArrayList)localObject4).add(localObject3);
    ((xti)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject4).toArray(new String[0]));
    ((xti)localObject2).jdField_a_of_type_Xtk = new ysf(this, paramysj, paramString1);
    localArrayList1.add(localObject2);
    ((ArrayList)localObject4).clear();
    localObject4 = new xti();
    localObject2 = ((File)localObject1).getAbsolutePath() + File.separator + "an.ts";
    Object localObject5 = new ArrayList();
    ((ArrayList)localObject5).add("-y");
    ((ArrayList)localObject5).add("-i");
    ((ArrayList)localObject5).add(paramString1);
    ((ArrayList)localObject5).add("-vcodec");
    ((ArrayList)localObject5).add("copy");
    ((ArrayList)localObject5).add("-an");
    ((ArrayList)localObject5).add(localObject2);
    ((xti)localObject4).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject5).toArray(new String[0]));
    ((xti)localObject4).jdField_a_of_type_Xtk = new ysg(this, paramysj, paramString1);
    localArrayList1.add(localObject4);
    localObject5 = new xti();
    localObject4 = ((File)localObject1).getAbsolutePath() + File.separator + "mixed.m4a";
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("-y");
    localArrayList2.add("-i");
    localArrayList2.add(localObject3);
    localArrayList2.add("-i");
    localArrayList2.add(paramString2);
    localArrayList2.add("-filter_complex");
    localArrayList2.add("amix=inputs=2:duration=first:dropout_transition=2");
    localArrayList2.add(localObject4);
    ((xti)localObject5).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList2.toArray(new String[0]));
    ((xti)localObject5).jdField_a_of_type_Xtk = new ysh(this, paramysj, paramString1);
    localArrayList1.add(localObject5);
    paramString2 = new xti();
    localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "combine.mp4";
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add("-y");
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject2);
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject4);
    ((ArrayList)localObject3).add("-strict");
    ((ArrayList)localObject3).add("2");
    ((ArrayList)localObject3).add("-vcodec");
    ((ArrayList)localObject3).add("copy");
    ((ArrayList)localObject3).add("-acodec");
    ((ArrayList)localObject3).add("aac");
    ((ArrayList)localObject3).add(localObject1);
    paramString2.jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject3).toArray(new String[0]));
    paramString2.jdField_a_of_type_Xtk = new ysi(this, paramysj, (String)localObject1, paramString1);
    localArrayList1.add(paramString2);
    ((ArrayList)localObject3).clear();
    if (this.jdField_a_of_type_Xtc.a()) {
      try
      {
        this.jdField_a_of_type_Xtc.b(localArrayList1);
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_Xtc.a(localArrayList1);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(ysl paramysl, ysj paramysj)
  {
    ??? = UUID.nameUUIDFromBytes(paramysl.c.getBytes());
    String str = "prepareVideo_" + ((UUID)???).toString();
    paramysl.a = true;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramysl);
      ThreadManager.post(new VideoCombineHelper.3(this, paramysj, System.currentTimeMillis(), str), 8, null, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysb
 * JD-Core Version:    0.7.0.1
 */