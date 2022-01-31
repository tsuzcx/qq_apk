import com.tencent.mobileqq.filemanager.activity.FMCloudActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import java.util.List;

public class fve
  extends FMObserver
{
  public fve(FMCloudActivity paramFMCloudActivity) {}
  
  protected void a(List paramList)
  {
    super.a(paramList);
    FMCloudActivity.a(this.a, paramList);
    FMCloudActivity.a(this.a);
  }
  
  protected void c(int paramInt, String paramString)
  {
    super.c(paramInt, paramString);
    FMCloudActivity.a(this.a);
    FMToastUtil.a(2131562097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fve
 * JD-Core Version:    0.7.0.1
 */