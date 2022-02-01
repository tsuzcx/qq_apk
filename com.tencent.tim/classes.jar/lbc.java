import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

public class lbc
  extends lce
{
  public lbc(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment) {}
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    ReadInJoyDynamicChannelFragment.a(this.this$0, paramTopBannerInfo);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.d(this.this$0)) {
      return;
    }
    paramInt = lbz.a().a(Integer.valueOf(paramInt));
    if ((paramBoolean1) && (paramInt > 0)) {}
    for (String str = String.format(this.this$0.getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt) });; str = this.this$0.getResources().getString(2131718335))
    {
      ReadInJoyDynamicChannelFragment.c(this.this$0).t(paramBoolean1, str);
      if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
        ReadInJoyDynamicChannelFragment.a(this.this$0).setData(lbz.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.e(this.this$0)), paramList));
      }
      ReadInJoyDynamicChannelFragment.d(this.this$0).ad(true, true);
      return;
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.f(this.this$0)) {
      return;
    }
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyDynamicChannelFragment.a(this.this$0).setData(lbz.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.g(this.this$0)), paramList));
    }
    ReadInJoyDynamicChannelFragment.e(this.this$0).ad(paramBoolean1, true);
  }
  
  public void j(int paramInt, List<Long> paramList)
  {
    if (paramInt != ReadInJoyDynamicChannelFragment.a(this.this$0)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyDynamicChannelFragment.a(this.this$0).setData(lbz.a().a(Integer.valueOf(ReadInJoyDynamicChannelFragment.b(this.this$0)), paramList));
      ReadInJoyDynamicChannelFragment.a(this.this$0).ad(true, true);
    }
    for (;;)
    {
      paramList = lbz.a().a();
      if (paramList == null) {
        break;
      }
      ReadInJoyDynamicChannelFragment.a(this.this$0, paramList.a(ReadInJoyDynamicChannelFragment.c(this.this$0)));
      return;
      ReadInJoyDynamicChannelFragment.b(this.this$0).aXj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbc
 * JD-Core Version:    0.7.0.1
 */