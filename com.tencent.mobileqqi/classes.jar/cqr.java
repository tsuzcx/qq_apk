import android.view.View;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import protocol.KQQConfig.GetResourceRespInfo;

public class cqr
  extends ConfigObserver
{
  public cqr(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo)
  {
    View localView;
    if (paramBoolean)
    {
      paramGetResourceRespInfo = this.a.findViewById(2131231817);
      localView = this.a.findViewById(2131231819);
    }
    switch (IndividuationSetActivity.a(this.a))
    {
    default: 
      IndividuationSetActivity.a(this.a, false);
      paramGetResourceRespInfo.setVisibility(8);
      localView.setVisibility(8);
      return;
    case 1: 
      IndividuationSetActivity.a(this.a, true);
      paramGetResourceRespInfo.setVisibility(0);
      localView.setVisibility(8);
      return;
    }
    IndividuationSetActivity.a(this.a, true);
    paramGetResourceRespInfo.setVisibility(8);
    localView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cqr
 * JD-Core Version:    0.7.0.1
 */