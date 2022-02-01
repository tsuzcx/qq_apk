import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class alaq
  extends QIPCModule
{
  alaq(alap paramalap, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverIPCServer", 2, new Object[] { "onCall, action=" + paramString + ", params=" + paramBundle + ", callbackId=", Integer.valueOf(paramInt) });
    }
    if (paramBundle == null) {
      QLog.d("PrecoverIPCServer", 1, new Object[] { "onCall, params is null!!. action=" + paramString + ", callbackId=", Integer.valueOf(paramInt) });
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return null;
          if (alap.a(this.b) == null)
          {
            QLog.d("PrecoverIPCServer", 1, new Object[] { "onCall, mManager is null!!. action=" + paramString + ", callbackId=", Integer.valueOf(paramInt) });
            return null;
          }
          paramBundle.putString("key_action", paramString);
          if (alao.bVb.equals(paramString)) {
            return alap.a(this.b, paramBundle, paramInt);
          }
          if (alao.bVc.equals(paramString))
          {
            paramString = alap.a(this.b, paramBundle, paramInt);
            if (paramString.isSuccess())
            {
              localObject = (PrecoverResource)paramBundle.getParcelable("resource");
              if (QLog.isColorLevel()) {
                QLog.d("PrecoverIPCServer", 2, "onCall, params.getParcelable, res=" + localObject);
              }
              if (alap.a(this.b).a().a((PrecoverResource)localObject, new Object[] { "PrecoverIPCServer_MODEL", Integer.valueOf(paramInt) })) {
                return EIPCResult.createResult(11, paramBundle);
              }
              paramBundle.putInt("errCode", -2);
              paramBundle.putString("errDesc", "args invalid or file already exist!");
              alap.a(this.b).callbackResult(paramInt, EIPCResult.createResult(-2, paramBundle));
            }
            return paramString;
          }
        } while (!alao.bVd.equals(paramString));
        paramString = paramBundle.getString("businessId");
        localObject = paramBundle.getString("md5");
      } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)));
      paramString = alap.a(this.b).a().a((String)localObject);
    } while (paramString == null);
    paramBundle.putLong("key_total", paramString.total);
    paramBundle.putLong("key_loaded", paramString.afW);
    return EIPCResult.createSuccessResult(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alaq
 * JD-Core Version:    0.7.0.1
 */