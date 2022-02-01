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

public class rfg
  extends QIPCModule
{
  private static rfg a;
  public long BV;
  public rfi a;
  public String aAc;
  public String aAd;
  public SparseArray<aojc> aZ = new SparseArray();
  
  private rfg()
  {
    super("ArtFilterModule");
  }
  
  public static rfg a()
  {
    if (jdField_a_of_type_Rfg == null) {}
    try
    {
      if (jdField_a_of_type_Rfg == null) {
        jdField_a_of_type_Rfg = new rfg();
      }
      return jdField_a_of_type_Rfg;
    }
    finally {}
  }
  
  public static String mU()
  {
    return ((ArtFilterManager)BaseApplicationImpl.sApplication.getRuntime().getManager(188)).mU();
  }
  
  public static String mX()
  {
    Object localObject1 = (ArtFilterManager)BaseApplicationImpl.sApplication.getRuntime().getManager(188);
    if (!((ArtFilterManager)localObject1).aHy)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterModule", 2, "getFilterString:  switch is closed");
      }
      return null;
    }
    Object localObject2 = ((ArtFilterManager)localObject1).cc();
    localObject1 = new JSONArray();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JSONObject localJSONObject = ((rfb)((Iterator)localObject2).next()).toJsonObject();
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
  
  public aojc a()
  {
    aool localaool = new aool();
    localaool.mFileType = 1;
    localaool.mUniseq = 0L;
    localaool.mUinType = 0;
    localaool.mPeerUin = "";
    localaool.cNy = true;
    localaool.cMb = false;
    return new aojc(((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(), localaool, this.aAc);
  }
  
  public boolean aa(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 0;
    Object localObject1 = new File(EditVideoArtFilter.azw);
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
      new File(EditVideoArtFilter.azw + ".nomeida").createNewFile();
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
  
  public void btI()
  {
    int i = 0;
    while (i < this.aZ.size())
    {
      ((aojc)this.aZ.valueAt(i)).cancel();
      i += 1;
    }
    this.aZ.clear();
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
      this.aAd = paramString;
      this.BV = 0L;
      this.aAc = null;
      btI();
      this.jdField_a_of_type_Rfi = rfi.a(paramString, l1);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterModule", 2, "ACTION_IMG_PREUPLOAD:  currentFilterImgPath:" + this.aAd + " currentFilterUploadProcessors:" + this.aZ + "\n currentFilterUploadInfo:" + this.jdField_a_of_type_Rfi);
      }
      a().a(paramInt, -1, "", 0, this.jdField_a_of_type_Rfi, true);
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
          QLog.d("ArtFilterModule", 2, "ACTION_ART_FILTER_PATH:  currentFilterImgPath:" + this.aAd + " filePath:" + str + "\n currentFilterUploadProcessors:" + this.aZ + "\n styleId:" + i + " currentUKey:" + this.aAc + " lastUpdateImgTime" + this.BV + " currentTime:" + l2);
        }
        if ((this.aAd != null) && (this.aAd.equals(str)))
        {
          if (this.aZ.get(i) == null)
          {
            boolean bool1 = bool2;
            if (this.aAc != null)
            {
              bool1 = bool2;
              if (this.BV != 0L) {
                if (l2 - this.BV > 480000L) {
                  break label525;
                }
              }
            }
            for (bool1 = false;; bool1 = bool2)
            {
              if (this.jdField_a_of_type_Rfi == null) {
                this.jdField_a_of_type_Rfi = rfi.a(str, l1);
              }
              paramBundle = a();
              paramBundle.hI("current_TaskCount", String.valueOf(this.aZ.size()));
              paramBundle.a(paramInt, i, paramString, j, this.jdField_a_of_type_Rfi, bool1);
              this.aZ.put(i, paramBundle);
              break;
              label525:
              this.BV = 0L;
              this.aAc = null;
            }
          }
        }
        else
        {
          this.aAd = str;
          this.BV = 0L;
          this.aAc = null;
          btI();
          if (QLog.isColorLevel()) {
            QLog.d("ArtFilterModule", 2, "ACTION_ART_FILTER_PATH:  currentFilterImgPath:" + this.aAd + " filePath:" + str + "\n currentFilterUploadProcessors:" + this.aZ + "\n styleId:" + i + " currentUKey:" + this.aAc + " lastUpdateImgTime" + this.BV + " currentTime:" + l2);
          }
          this.jdField_a_of_type_Rfi = rfi.a(str, l1);
          paramBundle = a();
          this.aZ.put(i, paramBundle);
          paramBundle.a(paramInt, i, paramString, j, this.jdField_a_of_type_Rfi, true);
        }
      }
      else if ("action_cancel_art_filter_task".equals(paramString))
      {
        paramInt = paramBundle.getInt("param_art_filter_task_id");
        if (this.aZ.get(paramInt) != null)
        {
          ((aojc)this.aZ.get(paramInt)).cancel();
          this.aZ.remove(paramInt);
        }
      }
      else if ("action_exit_art_filter".equals(paramString))
      {
        aa(true);
        btI();
        this.jdField_a_of_type_Rfi = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfg
 * JD-Core Version:    0.7.0.1
 */