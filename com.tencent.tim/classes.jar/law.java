import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

public class law
  extends lbf
{
  public law(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a(int paramInt1, boolean paramBoolean, List<lbm> paramList, int paramInt2)
  {
    int i = 0;
    if (paramInt1 != ReadInJoyCGIDynamicChannelFragment.d(this.this$0)) {
      return;
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyCGIDynamicChannelFragment.a(this.this$0, paramInt1, paramList);
    }
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onHeaderRefreshed, channelID = ", Integer.valueOf(paramInt1), ", success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i), ", insertIndex = ", Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.b(this.this$0)) {
      return;
    }
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      if ((!paramBoolean1) || (i <= 0)) {
        break label175;
      }
    }
    label175:
    for (String str = String.format(this.this$0.getResources().getString(2131718336), new Object[] { Integer.valueOf(i) });; str = this.this$0.getResources().getString(2131718335))
    {
      ReadInJoyCGIDynamicChannelFragment.c(this.this$0).t(paramBoolean1, str);
      if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
        ReadInJoyCGIDynamicChannelFragment.a(this.this$0).setData(paramList);
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onDataRefreshed, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", refreshSize = ", Integer.valueOf(i) });
      ReadInJoyCGIDynamicChannelFragment.d(this.this$0).ad(true, true);
      return;
      i = 0;
      break;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    int i = 0;
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.c(this.this$0)) {
      return;
    }
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.this$0).ca(paramList);
      ReadInJoyCGIDynamicChannelFragment.e(this.this$0).ad(true, paramBoolean2);
    }
    for (;;)
    {
      if (paramList != null) {
        i = paramList.size();
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onLoadMoreData, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", size = ", Integer.valueOf(i), ", hasMore = ", Boolean.valueOf(paramBoolean2) });
      return;
      ReadInJoyCGIDynamicChannelFragment.f(this.this$0).ad(false, true);
    }
  }
  
  public void o(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.a(this.this$0)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.this$0).setData(paramList);
      ReadInJoyCGIDynamicChannelFragment.a(this.this$0).ad(true, true);
      return;
    }
    ReadInJoyCGIDynamicChannelFragment.b(this.this$0).aXj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     law
 * JD-Core Version:    0.7.0.1
 */