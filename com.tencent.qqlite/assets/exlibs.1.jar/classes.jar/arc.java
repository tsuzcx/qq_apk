import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import protocol.KQQConfig.GetResourceRespInfo;

public class arc
  extends ConfigObserver
{
  public arc(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramBoolean) {
      this.a.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     arc
 * JD-Core Version:    0.7.0.1
 */