import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aflc
  extends afko
{
  aflc(aflb paramaflb) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    super.a(paramEmoticonPackage, paramInt, paramBundle);
    if ((paramEmoticonPackage != null) && (paramInt == 0))
    {
      paramBundle = paramBundle.getBundle("jsonReqParams");
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt(aflb.bDP);
        paramBundle = paramBundle.getString(aflb.bDQ);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack begins, taskId:" + paramInt + ",packId:" + paramEmoticonPackage.epId);
        }
        boolean bool = this.this$0.a.js(paramInt);
        if (bool) {
          this.this$0.J(paramEmoticonPackage.epId, paramBundle, false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack ends, isTaskExist:" + bool);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflc
 * JD-Core Version:    0.7.0.1
 */