import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.c;
import com.tencent.mobileqq.widget.QQToast;

public class aaqz
  implements NewFlowCameraActivity.c
{
  public aaqz(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (this.this$0.ciS == 10011)
    {
      NewFlowCameraActivity.a(this.this$0, paramString1);
      return;
    }
    if (paramBoolean)
    {
      NewFlowCameraActivity.b(this.this$0, paramString1);
      return;
    }
    this.this$0.CR(true);
    QQToast.a(this.this$0, acfp.m(2131709027), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqz
 * JD-Core Version:    0.7.0.1
 */