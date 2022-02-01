import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ahrj
  implements ausj.a
{
  ahrj(ahrb.b paramb) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramView = new HashMap();
      tbb.b(paramView, ahrb.b.a(this.a).msgId);
      paramView.put(Integer.valueOf(2), ahrb.b.a(this.a).msgId);
      paramView.put(Integer.valueOf(6), ahrb.b.a(this.a).feedId);
      paramView.put(Integer.valueOf(4), "20");
      paramView.put(Integer.valueOf(43), ahrb.b.a(this.a).algorithmId);
      paramView.put(Integer.valueOf(44), ahrb.b.a(this.a).type + "");
      tbb.a(abmt.getAppInterface(), "769", "205027", ahrb.b.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
      paramView = new ajam(ahrb.a(ahrb.b.a(this.a)), ahrb.a(ahrb.b.a(this.a)));
      paramView.a(ahrb.b.a(this.a).title, ahrb.b.a(this.a).a().gameName, ahrb.b.a(this.a).jumpUrl, ahrb.b.a(this.a).coverImgUrl, "QQ手游中心", null);
      paramView.c(new ahrk(this));
      return;
    }
    paramView = new HashMap();
    tbb.b(paramView, ahrb.b.a(this.a).msgId);
    paramView.put(Integer.valueOf(2), ahrb.b.a(this.a).msgId);
    paramView.put(Integer.valueOf(6), ahrb.b.a(this.a).feedId);
    paramView.put(Integer.valueOf(4), "20");
    paramView.put(Integer.valueOf(43), ahrb.b.a(this.a).algorithmId);
    paramView.put(Integer.valueOf(44), ahrb.b.a(this.a).type + "");
    tbb.a(abmt.getAppInterface(), "769", "205025", ahrb.b.a(this.a).a().gameAppId, "76902", "1", "160", paramView);
    paramView = (aqrb)ahrb.a(ahrb.b.a(this.a)).getBusinessHandler(71);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ahrb.b.a(this.a).feedId);
    paramView.nc(localArrayList);
    if (ahrb.b.a(this.a) != null) {
      ahrb.b.a(this.a).dismiss();
    }
    ahrb.b.a(this.a).Pm(ahrb.b.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrj
 * JD-Core Version:    0.7.0.1
 */