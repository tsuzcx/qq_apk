import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uxe
  extends QIPCModule
{
  private static uxe a;
  public long a;
  public SparseArray<axoi> a;
  public String a;
  public uxg a;
  public String b;
  
  private uxe()
  {
    super("ArtFilterModule");
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static String a()
  {
    Object localObject1 = (ArtFilterManager)BaseApplicationImpl.sApplication.getRuntime().getManager(188);
    if (!((ArtFilterManager)localObject1).jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterModule", 2, "getFilterString:  switch is closed");
      }
      return null;
    }
    Object localObject2 = ((ArtFilterManager)localObject1).a();
    localObject1 = new JSONArray();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JSONObject localJSONObject = ((uwz)((Iterator)localObject2).next()).a();
        if (localJSONObject != null) {
          try
          {
            Object localObject3 = localJSONObject.getString("thumbPath");
            localObject3 = new File((String)localObject3);
            if ((((File)localObject3).exists()) && (((File)localObject3).isFile())) {
              ((JSONArray)localObject1).put(localJSONObject);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    if (((JSONArray)localObject1).length() > 0) {
      return ((JSONArray)localObject1).toString();
    }
    return null;
  }
  
  public static uxe a()
  {
    if (jdField_a_of_type_Uxe == null) {}
    try
    {
      if (jdField_a_of_type_Uxe == null) {
        jdField_a_of_type_Uxe = new uxe();
      }
      return jdField_a_of_type_Uxe;
    }
    finally {}
  }
  
  public static String b()
  {
    return ((ArtFilterManager)BaseApplicationImpl.sApplication.getRuntime().getManager(188)).a();
  }
  
  public axoi a()
  {
    axvt localaxvt = new axvt();
    localaxvt.b = 1;
    localaxvt.jdField_a_of_type_Long = 0L;
    localaxvt.jdField_a_of_type_Int = 0;
    localaxvt.c = "";
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.e = false;
    return new axoi(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(), localaxvt, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((axoi)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 0;
    Object localObject1 = new File(EditVideoArtFilter.jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      paramBoolean = bool;
      if (!((File)localObject1).isDirectory()) {
        break label133;
      }
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!localObject2.getName().endsWith(".nomeida")) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
    else if (paramBoolean)
    {
      ((File)localObject1).mkdir();
    }
    try
    {
      new File(EditVideoArtFilter.jdField_a_of_type_JavaLangString + ".nomeida").createNewFile();
      paramBoolean = true;
      label133:
      return paramBoolean;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterModule", 2, "[onCall] action = " + paramString + ", params = " + paramBundle + ", callbackId=" + paramInt);
    }
    if (!QQAppInterface.class.isInstance(BaseApplicationImpl.sApplication.getRuntime()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArtFilterModule", 2, "[onCall] get app failed.");
      }
      return null;
    }
    long l1;
    if ("action_img_preupload".equals(paramString))
    {
      paramString = paramBundle.getString("param_art_filter_resource_path");
      l1 = paramBundle.getLong("param_art_filter_file_name");
      this.b = paramString;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = null;
      a();
      this.jdField_a_of_type_Uxg = uxg.a(paramString, l1);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterModule", 2, "ACTION_IMG_PREUPLOAD:  currentFilterImgPath:" + this.b + " currentFilterUploadProcessors:" + this.jdField_a_of_type_AndroidUtilSparseArray + "\n currentFilterUploadInfo:" + this.jdField_a_of_type_Uxg);
      }
      a().a(paramInt, -1, "", 0, this.jdField_a_of_type_Uxg, true);
    }
    for (;;)
    {
      return null;
      if ("action_get_art_filter_path".equals(paramString))
      {
        String str = paramBundle.getString("param_art_filter_resource_path");
        int i = paramBundle.getInt("param_art_filter_style_id");
        paramString = paramBundle.getString("param_art_filter_style_name");
        int j = paramBundle.getInt("param_art_filter_task_id");
        l1 = paramBundle.getLong("param_art_filter_file_name");
        boolean bool2 = true;
        long l2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterModule", 2, "ACTION_ART_FILTER_PATH:  currentFilterImgPath:" + this.b + " filePath:" + str + "\n currentFilterUploadProcessors:" + this.jdField_a_of_type_AndroidUtilSparseArray + "\n styleId:" + i + " currentUKey:" + this.jdField_a_of_type_JavaLangString + " lastUpdateImgTime" + this.jdField_a_of_type_Long + " currentTime:" + l2);
        }
        if ((this.b != null) && (this.b.equals(str)))
        {
          if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
          {
            boolean bool1 = bool2;
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_Long != 0L) {
                if (l2 - this.jdField_a_of_type_Long > 480000L) {
                  break label520;
                }
              }
            }
            for (bool1 = false;; bool1 = bool2)
            {
              if (this.jdField_a_of_type_Uxg == null) {
                this.jdField_a_of_type_Uxg = uxg.a(str, l1);
              }
              paramBundle = a();
              paramBundle.a("current_TaskCount", String.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.size()));
              paramBundle.a(paramInt, i, paramString, j, this.jdField_a_of_type_Uxg, bool1);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramBundle);
              break;
              label520:
              this.jdField_a_of_type_Long = 0L;
              this.jdField_a_of_type_JavaLangString = null;
            }
          }
        }
        else
        {
          this.b = str;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_a_of_type_JavaLangString = null;
          a();
          if (QLog.isColorLevel()) {
            QLog.d("ArtFilterModule", 2, "ACTION_ART_FILTER_PATH:  currentFilterImgPath:" + this.b + " filePath:" + str + "\n currentFilterUploadProcessors:" + this.jdField_a_of_type_AndroidUtilSparseArray + "\n styleId:" + i + " currentUKey:" + this.jdField_a_of_type_JavaLangString + " lastUpdateImgTime" + this.jdField_a_of_type_Long + " currentTime:" + l2);
          }
          this.jdField_a_of_type_Uxg = uxg.a(str, l1);
          paramBundle = a();
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramBundle);
          paramBundle.a(paramInt, i, paramString, j, this.jdField_a_of_type_Uxg, true);
        }
      }
      else if ("action_cancel_art_filter_task".equals(paramString))
      {
        paramInt = paramBundle.getInt("param_art_filter_task_id");
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)
        {
          ((axoi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a();
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        }
      }
      else if ("action_exit_art_filter".equals(paramString))
      {
        a(true);
        a();
        this.jdField_a_of_type_Uxg = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */