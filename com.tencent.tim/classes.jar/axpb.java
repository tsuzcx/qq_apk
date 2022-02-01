import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class axpb
  implements axpa.a
{
  axpb(axpa paramaxpa) {}
  
  public void Gr(int paramInt)
  {
    axpa.a(this.this$0).eNr();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.this$0.mTemplateList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.this$0.mTemplateList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    if (localPtvTemplateInfo.isWsBanner())
    {
      rpw.a(this.this$0.mContext, localPtvTemplateInfo);
      return;
    }
    if (axpa.a(this.this$0) == paramInt)
    {
      axpa.dvM = true;
      axpa.a(this.this$0, paramInt);
      axpa.eGt = paramInt;
      axpa.eGs = localPtvTemplateInfo.categoryId;
      axpa.cVC = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(axpa.cVC)) {
        break label418;
      }
      if (!"0".equals(axpa.cVC)) {
        break label393;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label175:
        Object localObject;
        QLog.d("Q.videostory.capture", 1, "report failed");
        continue;
        String str = "empty";
      }
    }
    localJSONObject.put("lens_id", localObject);
    if (axpa.eGs != 0) {}
    for (localObject = Integer.valueOf(axpa.eGs);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", axpa.eGt);
      sqn.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(aaqh.cix), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", 1, "change material result:" + localJSONObject.toString());
      ((axtq)axov.a(14)).hk(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        axpa.dvL = true;
        if (!axpa.dvM) {
          axpa.dvK = false;
        }
        this.this$0.a.c(localPtvTemplateInfo, 111);
      }
      this.this$0.a(null);
      if (!localPtvTemplateInfo.usable) {
        aytq.ec("", "0X8006A1A");
      }
      ((axpr)axov.a(5)).a(this.this$0.eCJ, (Activity)this.this$0.mContext);
      return;
      axpa.dvM = false;
      break;
      label393:
      localObject = axpa.cVC;
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpb
 * JD-Core Version:    0.7.0.1
 */