import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;

class xzt
  extends ExecuteBinResponseCallback
{
  private String jdField_a_of_type_JavaLangString;
  
  xzt(xzs paramxzs, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    paramString = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putString("keySucceedGeneratePath", this.jdField_a_of_type_JavaLangString);
    paramString.setData(localBundle);
    paramString.what = 30;
    this.jdField_a_of_type_Xzs.a.a.sendMessage(paramString);
  }
  
  public void b(String paramString)
  {
    xzs.a(this.jdField_a_of_type_Xzs, "mix failed, error ret = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzt
 * JD-Core Version:    0.7.0.1
 */