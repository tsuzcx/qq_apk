import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aqpo
  extends afko
{
  aqpo(aqpm paramaqpm) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "emotion onJsonComplete id = " + paramEmoticonPackage.epId + " resultCode = " + paramInt);
    }
    if (this.this$0.dK != null) {
      this.this$0.dK.sendEmptyMessage(257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpo
 * JD-Core Version:    0.7.0.1
 */