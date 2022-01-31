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

public class wju
{
  public static final String a;
  long jdField_a_of_type_Long = 0L;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<String, wke> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  vni jdField_a_of_type_Vni;
  wis jdField_a_of_type_Wis;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aT + "/Tencent/QQ_business/videocombine";
  }
  
  public wju(BaseActivity paramBaseActivity)
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.jdField_a_of_type_Vni = vni.a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_Vni.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Wis = wis.a();
  }
  
  public batr a()
  {
    return new bato(null).a(1);
  }
  
  public String a(wke paramwke, wkc paramwkc)
  {
    ??? = UUID.nameUUIDFromBytes(paramwke.c.getBytes());
    String str1 = "combineVideo_" + ((UUID)???).toString();
    String str2 = "prepareVideo_" + ((UUID)???).toString();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2))
      {
        ((wke)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).b = true;
        Looper.prepare();
        new Handler().postDelayed(new VideoCombineHelper.1(this, paramwke, paramwkc), 300L);
        return str1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramwke);
      ThreadManager.post(new VideoCombineHelper.2(this, paramwkc, System.currentTimeMillis(), str1), 8, null, false);
      return str1;
    }
  }
  
  public void a(String paramString1, String paramString2, wkc paramwkc)
  {
    Object localObject1 = new File(paramString1).getParentFile();
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject2 = new vno();
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
    ((vno)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject4).toArray(new String[0]));
    ((vno)localObject2).jdField_a_of_type_Vnq = new wjy(this, paramwkc, paramString1);
    localArrayList1.add(localObject2);
    ((ArrayList)localObject4).clear();
    localObject4 = new vno();
    localObject2 = ((File)localObject1).getAbsolutePath() + File.separator + "an.ts";
    Object localObject5 = new ArrayList();
    ((ArrayList)localObject5).add("-y");
    ((ArrayList)localObject5).add("-i");
    ((ArrayList)localObject5).add(paramString1);
    ((ArrayList)localObject5).add("-vcodec");
    ((ArrayList)localObject5).add("copy");
    ((ArrayList)localObject5).add("-an");
    ((ArrayList)localObject5).add(localObject2);
    ((vno)localObject4).jdField_a_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject5).toArray(new String[0]));
    ((vno)localObject4).jdField_a_of_type_Vnq = new wjz(this, paramwkc, paramString1);
    localArrayList1.add(localObject4);
    localObject5 = new vno();
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
    ((vno)localObject5).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList2.toArray(new String[0]));
    ((vno)localObject5).jdField_a_of_type_Vnq = new wka(this, paramwkc, paramString1);
    localArrayList1.add(localObject5);
    paramString2 = new vno();
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
    paramString2.jdField_a_of_type_Vnq = new wkb(this, paramwkc, (String)localObject1, paramString1);
    localArrayList1.add(paramString2);
    ((ArrayList)localObject3).clear();
    if (this.jdField_a_of_type_Vni.a()) {
      try
      {
        this.jdField_a_of_type_Vni.b(localArrayList1);
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
      this.jdField_a_of_type_Vni.a(localArrayList1);
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
  
  public void a(wke paramwke, wkc paramwkc)
  {
    ??? = UUID.nameUUIDFromBytes(paramwke.c.getBytes());
    String str = "prepareVideo_" + ((UUID)???).toString();
    paramwke.a = true;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramwke);
      ThreadManager.post(new VideoCombineHelper.3(this, paramwkc, System.currentTimeMillis(), str), 8, null, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wju
 * JD-Core Version:    0.7.0.1
 */