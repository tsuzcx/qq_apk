import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONObject;

class pmn
  extends SimpleJob<Object>
{
  pmn(pmm parampmm, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    Object localObject = (String)((psr)psx.a(10)).c("SP_KEY_AUTHKEY_SERVER_INFO", "");
    synchronized (this.a.bj)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = this.a.a.expireTime;
        if (l != 0L) {}
      }
      try
      {
        paramVarArgs = new pmm.b();
        localObject = new JSONObject((String)localObject);
        paramVarArgs.expireTime = ((JSONObject)localObject).getLong("t");
        paramVarArgs.bA = aqhs.hexStr2Bytes(((JSONObject)localObject).getString("ak"));
        this.a.a = paramVarArgs;
        ram.b("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init success -> %s", localObject);
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          ram.w("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init error , %s", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmn
 * JD-Core Version:    0.7.0.1
 */