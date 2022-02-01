import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecognition.b;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adhr
{
  public long Sl = 0L;
  public adhh a;
  public adhk a;
  public adhl a;
  public adht a;
  public adhy a;
  public adin a;
  public adji a;
  public aknt a;
  public TranslateResult a;
  public int businessType = -1;
  public String sessionId = "";
  public long uin = 0L;
  
  public adhr()
  {
    this.jdField_a_of_type_Adhh = null;
  }
  
  public static adhf a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr)
  {
    adhf localadhf = new adhf();
    if (paramadhr == null) {
      return localadhf;
    }
    ARRecognition.b localb = ARRecognition.a(paramArrayList, paramadhr);
    if (localb.Sb == 1L)
    {
      paramArrayList = localadhf;
      if (paramadhr.jdField_a_of_type_Adhh.bNi) {
        paramArrayList = paramadhr.jdField_a_of_type_Adhh.jdField_a_of_type_Adhf;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSLocationCheckResult. retCode = " + paramArrayList.retCode);
      return paramArrayList;
      if (localb.Sb == 2L)
      {
        paramArrayList = localadhf;
        if (paramadhr.jdField_a_of_type_Adhk.bNi) {
          paramArrayList = paramadhr.jdField_a_of_type_Adhk.jdField_a_of_type_Adhf;
        }
      }
      else if (localb.Sb == 128L)
      {
        paramArrayList = localadhf;
        if (paramadhr.jdField_a_of_type_Adin.bNi) {
          paramArrayList = paramadhr.jdField_a_of_type_Adin.jdField_a_of_type_Adhf;
        }
      }
      else
      {
        paramArrayList = localadhf;
        if (localb.Sb == 2048L)
        {
          paramArrayList = localadhf;
          if (paramadhr.jdField_a_of_type_Adhy.bNi) {
            paramArrayList = paramadhr.jdField_a_of_type_Adhy.jdField_a_of_type_Adhf;
          }
        }
      }
    }
  }
  
  public static ArLBSActivity a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr)
  {
    Object localObject = null;
    if (paramadhr == null) {
      return null;
    }
    ARRecognition.b localb = ARRecognition.a(paramArrayList, paramadhr);
    if (localb.Sb == 1L)
    {
      paramArrayList = localObject;
      if (!paramadhr.jdField_a_of_type_Adhh.bNi) {}
    }
    for (;;)
    {
      try
      {
        paramadhr = adhg.a(new String(paramadhr.jdField_a_of_type_Adhh.jdField_a_of_type_ArrayOfAdhh$a[0].dl, "utf-8"));
        paramArrayList = localObject;
        if (paramadhr != null) {
          paramArrayList = paramadhr.a;
        }
        QLog.i("AREngine_ARCloudRecogResult", 1, "getLBSActivity. activity info = " + paramArrayList);
        return paramArrayList;
      }
      catch (Exception paramArrayList)
      {
        QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
        paramadhr = null;
        continue;
      }
      if (localb.Sb == 2L)
      {
        paramArrayList = localObject;
        if (!paramadhr.jdField_a_of_type_Adhk.bNi) {
          continue;
        }
        try
        {
          paramadhr = adhg.a(new String(paramadhr.jdField_a_of_type_Adhk.jdField_a_of_type_ArrayOfAdhk$a[0].dl, "utf-8"));
          paramArrayList = localObject;
          if (paramadhr == null) {
            continue;
          }
          paramArrayList = paramadhr.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramadhr = null;
          }
        }
      }
      if (localb.Sb == 128L)
      {
        paramArrayList = localObject;
        if (!paramadhr.jdField_a_of_type_Adin.bNi) {
          continue;
        }
        try
        {
          paramadhr = adhg.a(new String(paramadhr.jdField_a_of_type_Adin.U(), "utf-8"));
          paramArrayList = localObject;
          if (paramadhr == null) {
            continue;
          }
          paramArrayList = paramadhr.a;
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
            paramadhr = null;
          }
        }
      }
      paramArrayList = localObject;
      if (localb.Sb != 2048L) {
        continue;
      }
      paramArrayList = localObject;
      if (!paramadhr.jdField_a_of_type_Adhy.bNi) {
        continue;
      }
      try
      {
        paramadhr = adhg.a(new String(paramadhr.jdField_a_of_type_Adhy.jdField_a_of_type_ArrayOfAdhy$a[0].dl, "utf-8"));
        paramArrayList = localObject;
        if (paramadhr == null) {
          continue;
        }
        paramArrayList = paramadhr.a;
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          QLog.i("AREngine_ARCloudRecogResult", 1, "parse json failed. error msg = " + paramArrayList.getMessage());
          paramadhr = null;
        }
      }
    }
  }
  
  public static String a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr)
  {
    if (paramadhr == null) {
      return "";
    }
    String str = "";
    ARRecognition.b localb = ARRecognition.a(paramArrayList, paramadhr);
    if (localb.Sb == 1L) {
      paramArrayList = paramadhr.jdField_a_of_type_Adhh.jdField_a_of_type_ArrayOfAdhh$a[0].imageId;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "getImageId. imageId = " + paramArrayList);
      return paramArrayList;
      if (localb.Sb == 2L)
      {
        paramArrayList = paramadhr.jdField_a_of_type_Adhk.jdField_a_of_type_ArrayOfAdhk$a[0].imageId;
      }
      else if (localb.Sb == 2048L)
      {
        paramArrayList = paramadhr.jdField_a_of_type_Adhy.jdField_a_of_type_ArrayOfAdhy$a[0].imageId;
      }
      else
      {
        paramArrayList = str;
        if (localb.Sb == 128L) {
          paramArrayList = paramadhr.jdField_a_of_type_Adin.btg;
        }
      }
    }
  }
  
  public static void a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr, adhf paramadhf)
  {
    if (paramadhr == null) {}
    do
    {
      return;
      QLog.i("AREngine_ARCloudRecogResult", 1, "setLBSLocationCheckResult. retCode = " + paramadhf.retCode);
      paramArrayList = ARRecognition.a(paramArrayList, paramadhr);
      if (paramArrayList.Sb == 1L)
      {
        paramadhr.jdField_a_of_type_Adhh.jdField_a_of_type_Adhf = paramadhf;
        return;
      }
      if (paramArrayList.Sb == 2L)
      {
        paramadhr.jdField_a_of_type_Adhk.jdField_a_of_type_Adhf = paramadhf;
        return;
      }
      if (paramArrayList.Sb == 128L)
      {
        paramadhr.jdField_a_of_type_Adin.jdField_a_of_type_Adhf = paramadhf;
        return;
      }
    } while (paramArrayList.Sb != 2048L);
    paramadhr.jdField_a_of_type_Adhy.jdField_a_of_type_Adhf = paramadhf;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, adhr paramadhr)
  {
    boolean bool = false;
    if (paramadhr == null) {
      return false;
    }
    paramArrayList = ARRecognition.a(paramArrayList, paramadhr);
    if (paramArrayList.Sb == 1L) {
      bool = paramadhr.jdField_a_of_type_Adhh.bNi;
    }
    for (;;)
    {
      QLog.i("AREngine_ARCloudRecogResult", 1, "isNeedUploadLBSLocation. isNeed = " + bool);
      return bool;
      if (paramArrayList.Sb == 2L) {
        bool = paramadhr.jdField_a_of_type_Adhk.bNi;
      } else if (paramArrayList.Sb == 128L) {
        bool = paramadhr.jdField_a_of_type_Adin.bNi;
      } else if (paramArrayList.Sb == 2048L) {
        bool = paramadhr.jdField_a_of_type_Adhy.bNi;
      }
    }
  }
  
  public String toString()
  {
    return "ARCloudRecogResult{, sessionId = " + this.sessionId + ", recogType = " + this.Sl + ", businessType = " + this.businessType + ", markerResult = " + this.jdField_a_of_type_Adhh + ", objectClassifyResult = " + this.jdField_a_of_type_Adhk + ", faceResult = " + this.jdField_a_of_type_Adht + ", ocrResult = " + this.jdField_a_of_type_Aknt + ", preOcrResult = " + this.jdField_a_of_type_Adhl + ", questionResult = " + this.jdField_a_of_type_Adji + ", sceneRecogResult = " + this.jdField_a_of_type_Adhy + ", translateReslut = " + this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult + ", uin = " + this.uin + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhr
 * JD-Core Version:    0.7.0.1
 */