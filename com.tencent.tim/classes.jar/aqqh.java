import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import org.json.JSONObject;

public class aqqh
  implements Manager
{
  QQAppInterface app;
  public boolean cVE;
  public boolean cVF;
  public int ebG = 0;
  public int ebH = -1;
  public String jumpUrl;
  
  public aqqh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void aD(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "parseJson jsonStr empty");
      }
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.ebG = paramString.optInt("personalSwitch");
        this.jumpUrl = paramString.optString("enterUrl");
        if (paramString.has("isShowRed"))
        {
          i = paramString.getInt("isShowRed");
          this.ebH = i;
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("IndividuationABTestManager", 1, "parseJson error e = " + paramString.getMessage());
        this.ebG = 0;
        this.jumpUrl = "";
        this.ebH = -1;
        paramString.printStackTrace();
        return;
      }
      int i = -1;
    }
  }
  
  public void Vu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        Object localObject = null;
        File localFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
        this.cVF = true;
        paramString = localObject;
        try
        {
          if (localFile.exists()) {
            paramString = aqhq.readFileContent(localFile);
          }
          if (TextUtils.isEmpty(paramString))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("IndividuationABTestManager", 2, "parseJsonFromFile jsont str is empty");
          }
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "parseJsonFromFile fileStr = " + paramString);
      }
    } while (this.cVE);
    aD(paramString);
  }
  
  public void aa(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "updateJsonInfo jsonStr or uin empty");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationABTestManager", 2, "updateJsonInfo jsonStr = " + paramString1);
      }
      this.cVE = true;
      aD(paramString1);
      String str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "individuationABTestFile_" + paramString2;
      try
      {
        boolean bool = aqhq.writeFile(str, paramString1);
        if (!bool) {
          continue;
        }
        aqmj.o(BaseApplicationImpl.getContext(), paramInt, paramString2);
        return;
      }
      finally {}
    }
  }
  
  public void dW(int paramInt, String paramString)
  {
    this.cVE = true;
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationABTestManager", 2, "handlePostTask version = " + paramInt);
    }
    paramString = new File(BaseApplicationImpl.getContext().getFilesDir(), "individuationABTestFile_" + paramString);
    try
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      this.ebG = 0;
      this.jumpUrl = "";
      this.ebH = -1;
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqh
 * JD-Core Version:    0.7.0.1
 */