import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;

public class ypg
  extends SosoInterface.a
{
  public ypg(Face2FaceAddContactPresenter.3 param3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onLocationFinish errCode = " + paramInt + " info = " + paramSosoLbsInfo);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null)) {
      if (ype.a(this.a.this$0) != null) {
        ype.a(this.a.this$0).ckt();
      }
    }
    while ((TextUtils.isEmpty(this.a.aZq)) || (this.a.aZq.length() != 4)) {
      return;
    }
    ype.a(this.a.this$0, paramSosoLbsInfo, this.a.aZq, this.a.aZr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypg
 * JD-Core Version:    0.7.0.1
 */