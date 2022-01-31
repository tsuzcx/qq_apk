import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class tnd
  implements Runnable
{
  tnd(tnc paramtnc, tni paramtni) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_Tnc.a.app.getPreferences().edit();
    localEditor.putString("chatHistoryEventName", this.jdField_a_of_type_Tni.a);
    localEditor.putBoolean("chatHistoryEventEntryFirstShow", true);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnd
 * JD-Core Version:    0.7.0.1
 */