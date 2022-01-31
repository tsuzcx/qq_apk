import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ScoreManager;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class tra
  extends AsyncTask
{
  public tra(ScoreQAVFragment paramScoreQAVFragment) {}
  
  protected HashMap a(String... paramVarArgs)
  {
    int i = 0;
    if ((this.a.jdField_d_of_type_JavaLangString == null) || (this.a.jdField_d_of_type_JavaLangString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mSelfUin is null!");
      }
      return null;
    }
    paramVarArgs = SharedPreUtils.f(this.a.jdField_d_of_type_JavaLangString);
    this.a.b = paramVarArgs.getString(VideoConstants.h, "");
    paramVarArgs = ScoreManager.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 270, this.a.jdField_d_of_type_JavaLangString);
    this.a.b(paramVarArgs);
    paramVarArgs = ScoreManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), 270, this.a.jdField_d_of_type_JavaLangString);
    this.a.a(paramVarArgs);
    if (this.a.e.isEmpty())
    {
      this.a.e = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429663);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Video config data is invalid, use default!");
      }
    }
    if (this.a.f.isEmpty())
    {
      this.a.f = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429664);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Audio config data is invalid, use default!");
      }
    }
    if (this.a.g.isEmpty())
    {
      this.a.g = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131429665);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Net config data is invalid, use default!");
      }
    }
    if (this.a.jdField_d_of_type_Long == 0L) {
      paramVarArgs = this.a.e + "/" + this.a.f + "/" + this.a.g;
    }
    try
    {
      this.a.jdField_a_of_type_JavaUtilList = Arrays.asList(paramVarArgs.split("/"));
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        i = 0;
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label794;
        }
      }
    }
    catch (Exception paramVarArgs)
    {
      try
      {
        do
        {
          for (;;)
          {
            paramVarArgs = ((String)this.a.jdField_a_of_type_JavaUtilList.get(i)).split(",");
            this.a.jdField_a_of_type_JavaUtilList.set(i, paramVarArgs[1]);
            int j = Integer.parseInt(paramVarArgs[0]);
            this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(j));
            i += 1;
            continue;
            paramVarArgs = this.a.f + "/" + this.a.g;
          }
          paramVarArgs = paramVarArgs;
          paramVarArgs.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "processDataTask mDatas is invalid, use default!");
      }
      this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.a.jdField_a_of_type_JavaUtilList.add("通话卡帧");
      this.a.jdField_a_of_type_JavaUtilList.add("通话有杂音");
      this.a.jdField_a_of_type_JavaUtilList.add("听到自己的回声");
      this.a.jdField_a_of_type_JavaUtilList.add("声音太小");
      this.a.jdField_a_of_type_JavaUtilList.add("视频画面模糊");
      this.a.jdField_a_of_type_JavaUtilList.add("视频画面卡帧");
      this.a.jdField_a_of_type_JavaUtilList.add("音频和视频不同步");
      this.a.jdField_a_of_type_JavaUtilList.add("画面花屏");
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(i));
        i += 1;
      }
    }
    label794:
    return this.a.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected void a(HashMap paramHashMap)
  {
    super.onPostExecute(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tra
 * JD-Core Version:    0.7.0.1
 */