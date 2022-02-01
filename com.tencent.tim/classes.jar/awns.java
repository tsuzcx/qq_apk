import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.jsoninflate.model.AlumBasicData.a;
import java.lang.ref.WeakReference;
import java.util.List;

class awns
  implements View.OnClickListener
{
  awns(awnr paramawnr) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131367956))
    {
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo dispear");
      awnm localawnm = new awnm((Activity)awnr.a(this.this$0));
      Object localObject = new awnm.b();
      awnm.b localb = new awnm.b();
      int i;
      if ((awnr.a(this.this$0).LU != null) && (awnr.a(this.this$0).LU.size() != 0)) {
        i = 0;
      }
      while (i < awnr.a(this.this$0).LU.size())
      {
        localObject = new awnm.b();
        ((awnm.b)localObject).type = ((AlumBasicData.a)awnr.a(this.this$0).LU.get(i)).actionType;
        ((awnm.b)localObject).actionData = ((AlumBasicData.a)awnr.a(this.this$0).LU.get(i)).logo_url;
        ((awnm.b)localObject).jumpUrl = ((AlumBasicData.a)awnr.a(this.this$0).LU.get(i)).jumpUrl;
        ((awnm.b)localObject).Kn = ((AlumBasicData.a)awnr.a(this.this$0).LU.get(i)).content;
        localawnm.a((awnm.b)localObject);
        i += 1;
        continue;
        ((awnm.b)localObject).actionData = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
        ((awnm.b)localObject).type = 0;
        ((awnm.b)localObject).Kn = acfp.m(2131716782);
        localb.actionData = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
        localb.type = 1;
        localb.Kn = acfp.m(2131716783);
        localb.jumpUrl = "https://www.qq.com";
        localawnm.a((awnm.b)localObject);
        localawnm.a(localb);
      }
      localawnm.ajM();
      localawnm.setOnItemClickListener(new awnt(this, localawnm));
      localObject = new awnl.a(paramView.getLeft(), paramView.getTop(), 0, 0, paramView.getWidth(), paramView.getHeight());
      awnl.a((Activity)awnr.a(this.this$0), paramView, (awnl.a)localObject, localawnm);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (awnr.a(this.this$0) != null)
      {
        this.this$0.af(2, awnr.a(this.this$0).cRl, awnr.a(this.this$0) + 1);
        this.this$0.a(new WeakReference((Activity)awnr.a(this.this$0)), awnr.b(this.this$0), this.this$0.a(awnr.c(this.this$0)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awns
 * JD-Core Version:    0.7.0.1
 */