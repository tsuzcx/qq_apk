import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lpn
  implements View.OnClickListener
{
  lpn(lpl paramlpl, Context paramContext, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    kxm.a(this.val$context, this.d, 2, false, 6, false);
    ndi.g(this.d, (int)this.d.mChannelID);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */