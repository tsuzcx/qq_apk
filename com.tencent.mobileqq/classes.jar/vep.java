import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vep
  implements CompoundButton.OnCheckedChangeListener
{
  vep(veo paramveo) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 0;
      QCircleSetUserSwitchRequest localQCircleSetUserSwitchRequest = new QCircleSetUserSwitchRequest(0, i);
      VSNetworkHelper.a().a(localQCircleSetUserSwitchRequest, new veq(this, paramBoolean));
      if (!paramBoolean) {
        break label62;
      }
      vtq.a("", 11, 23, 3);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 1;
      break;
      label62:
      vtq.a("", 11, 23, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vep
 * JD-Core Version:    0.7.0.1
 */