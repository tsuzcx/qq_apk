import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class lbb
  implements View.OnClickListener
{
  lbb(lba paramlba) {}
  
  public void onClick(View paramView)
  {
    int i = ((lba.a)paramView.getTag()).getAdapterPosition() - lba.a(this.a).getHeaderViewsCount();
    int j = this.a.getItemViewType(i);
    ArticleInfo localArticleInfo = (ArticleInfo)lba.a(this.a, i);
    if (localArticleInfo == null) {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick onClick articleInfo is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onItemClick, position = ", Integer.valueOf(i), ", itemViewType = ", Integer.valueOf(j) });
      this.a.j(i, paramView);
      localArticleInfo.invalidateProteusTemplateBean();
      kxm.c = localArticleInfo;
      lbz.a().H(localArticleInfo.mArticleID, System.currentTimeMillis());
      this.a.notifyItemChanged(i);
      kxm.b(lba.a(this.a), localArticleInfo, (int)localArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbb
 * JD-Core Version:    0.7.0.1
 */