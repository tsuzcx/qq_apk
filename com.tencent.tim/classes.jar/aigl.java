import android.os.Bundle;
import com.tencent.qqinterface.CommonCallback;

class aigl
  implements jsr.a
{
  aigl(aigi paramaigi, jsr paramjsr, CommonCallback paramCommonCallback) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.b.a.d(this.jdField_a_of_type_Jsr.mV(), this.jdField_a_of_type_Jsr.hU(), paramLong, 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOnline", paramBoolean);
    localBundle.putString("videoUrl", paramString1);
    localBundle.putString("vid", paramString2);
    localBundle.putLong("timeConsume", paramLong);
    localBundle.putString("mqqApi", paramString3);
    this.jdField_a_of_type_ComTencentQqinterfaceCommonCallback.onResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigl
 * JD-Core Version:    0.7.0.1
 */