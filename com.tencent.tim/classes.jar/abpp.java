import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abpp
  implements abya.a
{
  abpp(abpm paramabpm, String paramString) {}
  
  public void HM(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "[onVerifyResult], retCode:", Integer.valueOf(paramInt) });
      }
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("packName", this.bhm);
        localJSONObject.put("result", paramInt);
        localApolloCmdChannel.callbackFromRequest(abpm.a(this.this$0), 0, "cs.file_correctness_check.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpp
 * JD-Core Version:    0.7.0.1
 */