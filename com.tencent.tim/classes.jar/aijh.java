import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin.1.1;
import mqq.app.QQPermissionCallback;

public class aijh
  implements QQPermissionCallback
{
  public aijh(IdentificationApiPlugin.1.1 param1) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(aijf.a(this.a.a.a), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("FaceRecognition.AppConf", this.a.b);
    aijf.a(this.a.a.a, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */