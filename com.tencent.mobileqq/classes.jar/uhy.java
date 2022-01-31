import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONObject;

class uhy
  extends SimpleJob<Object>
{
  uhy(uhx paramuhx, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    Object localObject = (String)((urk)urr.a(10)).b("SP_KEY_AUTHKEY_SERVER_INFO", "");
    synchronized (this.a.b)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = this.a.a.jdField_a_of_type_Long;
        if (l != 0L) {}
      }
      try
      {
        paramVarArgs = new uib();
        localObject = new JSONObject((String)localObject);
        paramVarArgs.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("t");
        paramVarArgs.jdField_a_of_type_ArrayOfByte = bdcv.a(((JSONObject)localObject).getString("ak"));
        this.a.a = paramVarArgs;
        wsv.a("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init success -> %s", localObject);
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          wsv.b("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init error , %s", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhy
 * JD-Core Version:    0.7.0.1
 */