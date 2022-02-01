package dov.com.qq.im.capture.adapter;

import axpa;
import axpc;
import ayzs;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class QIMPtvTemplateAdapter$2$1
  implements Runnable
{
  public QIMPtvTemplateAdapter$2$1(axpc paramaxpc, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.a.this$0.e.getFirstVisiblePosition();
    int k = this.a.this$0.e.getLastVisiblePosition();
    int i = j;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.this$0.mTemplateList.get(i);
      } while ((localPtvTemplateInfo == null) || (!localPtvTemplateInfo.id.equals(this.d.id)));
      localPtvTemplateInfo.downloading = false;
      localPtvTemplateInfo.usable = this.val$isSuccess;
      localObject = this.a.this$0.e.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (!this.val$isSuccess) {
          break label217;
        }
        i = 1000;
        ((PtvTemplateItemView)localObject).mE(i);
      }
      if (this.val$isSuccess) {
        this.a.this$0.a.F(112, localPtvTemplateInfo);
      }
    }
    if ((axpa.a(this.a.this$0) < 0) || (axpa.a(this.a.this$0) >= this.a.this$0.mTemplateList.size())) {}
    label217:
    do
    {
      return;
      i = -1;
      break;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.this$0.mTemplateList.get(axpa.a(this.a.this$0));
    } while ((!localPtvTemplateInfo.id.equals(this.d.id)) || (!this.val$isSuccess) || (axpa.a(this.a.this$0) == null));
    Object localObject = ayzs.bYM + this.d.name;
    axpa.bec = (String)localObject;
    axpa.eGs = this.d.categoryId;
    axpa.cVC = this.d.id;
    if (this.a.this$0.b.kind == 3)
    {
      axpa.bec = "";
      axpa.a(this.a.this$0).adg((String)localObject);
      axpa.a(this.a.this$0).a(null, "");
    }
    for (;;)
    {
      i = AdvancedProviderView.QU();
      axpa.a(this.a.this$0).aev(i);
      i = AdvancedProviderView.QV();
      axpa.a(this.a.this$0).aew(i);
      this.a.this$0.a.c(this.d, 111);
      this.a.this$0.a.F(113, null);
      this.a.this$0.a.adM(axpa.cVC);
      return;
      axpa.a(this.a.this$0).a(localPtvTemplateInfo, (String)localObject);
      axpa.a(this.a.this$0).adg(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */