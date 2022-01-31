import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.common.util.CommUtils;
import com.tencent.biz.common.util.CommUtils.IHttpGetString;

public final class lr
  extends AsyncTask
{
  String jdField_a_of_type_JavaLangString = "";
  
  public lr(CommUtils.IHttpGetString paramIHttpGetString, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = CommUtils.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lr
 * JD-Core Version:    0.7.0.1
 */