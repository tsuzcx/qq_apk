import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.DatalineMathUtil;
import com.dataline.util.HttpDownload;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class db
  implements Runnable
{
  public db(MpfileDataCenter paramMpfileDataCenter, String paramString) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(this.jdField_a_of_type_JavaLangString);
    MpfileTaskInfo localMpfileTaskInfo = this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(this.jdField_a_of_type_JavaLangString);
    if (str == null)
    {
      MpfileDataCenter.a("loadFileMd5FromServerBackground failed, content is null");
      this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(localMpfileTaskInfo.jdField_d_of_type_Long, 0L, false, 251);
    }
    int i;
    long l;
    File localFile;
    for (;;)
    {
      return;
      try
      {
        localObject = new JSONObject(str);
        i = 0;
        if (((JSONObject)localObject).has("result")) {
          i = ((JSONObject)localObject).getInt("result");
        }
        if (i != 0) {
          break label352;
        }
        str = ((JSONObject)localObject).getString("md5");
        l = localMpfileTaskInfo.jdField_b_of_type_Long;
        if (((JSONObject)localObject).has("size")) {
          l = ((JSONObject)localObject).getLong("size");
        }
        if (localMpfileTaskInfo != null)
        {
          if ((str == null) || (str.length() <= 0)) {
            break label321;
          }
          localObject = localMpfileTaskInfo.jdField_e_of_type_JavaLangString;
          localFile = new File((String)localObject);
          if (!localFile.exists()) {
            break label233;
          }
          if (str.equalsIgnoreCase(DatalineMathUtil.a(DatalineMathUtil.a((String)localObject))))
          {
            this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(localMpfileTaskInfo.jdField_d_of_type_Long, localMpfileTaskInfo.jdField_b_of_type_Long, true, 0);
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(localMpfileTaskInfo.jdField_d_of_type_Long, 0L, false, 251);
        return;
      }
    }
    localFile.delete();
    label233:
    Object localObject = String.format("%s/%s.%s", new Object[] { MpfileDataCenter.b(), localMpfileTaskInfo.jdField_d_of_type_JavaLangString, localJSONException });
    localMpfileTaskInfo.jdField_g_of_type_JavaLangString = localJSONException;
    localMpfileTaskInfo.f = ((String)localObject);
    localMpfileTaskInfo.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a.a(localMpfileTaskInfo.jdField_d_of_type_Long, localMpfileTaskInfo.c, localMpfileTaskInfo.jdField_b_of_type_JavaLangString, (String)localObject, localMpfileTaskInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter);
    return;
    label321:
    MpfileDataCenter.a("loadFileMd5FromServerBackground failed, task not exist or md5 is empty");
    localMpfileTaskInfo.jdField_g_of_type_Int = MpfileTaskInfo.jdField_e_of_type_Int;
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(localMpfileTaskInfo.jdField_d_of_type_Long, 0L, false, 249);
    return;
    label352:
    MpfileDataCenter.a(String.format("loadFileMd5FromServerBackground failed, result is not ok result is %d", new Object[] { Integer.valueOf(i) }));
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.a(localMpfileTaskInfo.jdField_d_of_type_Long, 0L, false, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     db
 * JD-Core Version:    0.7.0.1
 */