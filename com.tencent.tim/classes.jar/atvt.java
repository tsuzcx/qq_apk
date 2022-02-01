import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class atvt
  extends AsyncTask<Bundle, Integer, Set<Long>>
{
  byte[] hP;
  String path;
  
  atvt(atvp paramatvp, atvp.d paramd) {}
  
  protected Set<Long> a(Bundle... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    this.hP = paramVarArgs.getByteArray("cloudId");
    this.path = paramVarArgs.getString("filePath");
    if (atvp.a(this.this$0))
    {
      paramVarArgs = atvp.a(this.this$0, atvp.a(this.this$0, this.hP, this.path));
      atvp.a(this.this$0, paramVarArgs);
      return paramVarArgs;
    }
    QLog.i("WpsFileEditStore", 1, "[WPSEDIT] takeOutOwCloudFileStopRecrd. load from pref");
    try
    {
      paramVarArgs = BaseApplication.getContext().getSharedPreferences(atvp.a(this.this$0), 0).getAll();
      atvp.a(this.this$0, paramVarArgs);
      atvp.a(this.this$0, true);
      paramVarArgs = atvp.a(this.this$0, atvp.a(this.this$0, this.hP, this.path));
      atvp.a(this.this$0, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  protected void u(Set<Long> paramSet)
  {
    if (this.a != null) {
      this.a.a(this.hP, this.path, paramSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvt
 * JD-Core Version:    0.7.0.1
 */