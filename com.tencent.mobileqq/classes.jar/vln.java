import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONObject;

class vln
  extends SimpleJob<Object>
{
  vln(vlm paramvlm, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    Object localObject = (String)((vuq)vux.a(10)).b("SP_KEY_AUTHKEY_SERVER_INFO", "");
    synchronized (this.a.b)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        long l = this.a.a.jdField_a_of_type_Long;
        if (l != 0L) {}
      }
      try
      {
        paramVarArgs = new vlq();
        localObject = new JSONObject((String)localObject);
        paramVarArgs.jdField_a_of_type_Long = ((JSONObject)localObject).getLong("t");
        paramVarArgs.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(((JSONObject)localObject).getString("ak"));
        this.a.a = paramVarArgs;
        xvv.a("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init success -> %s", localObject);
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          xvv.b("Q.qqstory.publish:VideoServerInfoManager", "ServerInfo init error , %s", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vln
 * JD-Core Version:    0.7.0.1
 */