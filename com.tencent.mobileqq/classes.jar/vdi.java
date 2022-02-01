import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.LbsDescPublishEvent;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import java.util.ArrayList;

public class vdi
  extends vbk
  implements aaam
{
  private TextView a;
  private TextView b;
  
  private String a(FeedCloudMeta.StPoiInfoV2 paramStPoiInfoV2)
  {
    Object localObject2 = paramStPoiInfoV2.defaultName.get();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramStPoiInfoV2.name.get();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramStPoiInfoV2.address.get();
    }
    return localObject2;
  }
  
  private void a(View paramView, FeedCloudMeta.StPoiInfoV2 paramStPoiInfoV2)
  {
    paramView = ((ViewStub)paramView.findViewById(2131381254)).inflate();
    this.a = ((TextView)paramView.findViewById(2131379919));
    this.b = ((TextView)paramView.findViewById(2131379918));
    this.a.setText(a(paramStPoiInfoV2));
  }
  
  public String a()
  {
    return "QCircleLbsHeaderPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getPoiInfo();
    if (localStPoiInfoV2.has())
    {
      a(paramView, localStPoiInfoV2);
      aaak.a().a(this);
    }
  }
  
  protected String b()
  {
    return "fuellist";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LbsDescPublishEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof LbsDescPublishEvent))
    {
      paramSimpleBaseEvent = (LbsDescPublishEvent)paramSimpleBaseEvent;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent.mDesc)) {
        this.b.setText(paramSimpleBaseEvent.mDesc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */