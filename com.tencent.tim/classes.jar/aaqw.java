import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class aaqw
  implements Comparator<aasq>
{
  public aaqw(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(aasq paramaasq1, aasq paramaasq2)
  {
    if ((paramaasq1.mWidth < paramaasq2.mWidth) || ((paramaasq1.mWidth == paramaasq2.mWidth) && (paramaasq1.mHeight < paramaasq2.mHeight))) {
      return -1;
    }
    if ((paramaasq1.mWidth != paramaasq2.mWidth) || (paramaasq1.mHeight != paramaasq2.mHeight)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqw
 * JD-Core Version:    0.7.0.1
 */