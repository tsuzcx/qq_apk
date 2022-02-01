import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zda
  implements View.OnClickListener
{
  public zda(ImgPreviewAdapter paramImgPreviewAdapter) {}
  
  public void onClick(View paramView)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = this.a.a(ImgPreviewAdapter.a(this.a).getCurrentItem());
    if (localEmoticonFromGroupEntity != null) {
      if (localEmoticonFromGroupEntity.msg != null) {
        ImgPreviewAdapter.a(this.a).a(ImgPreviewAdapter.a(this.a), localEmoticonFromGroupEntity.msg, paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ImgPreviewAdapter.msgnull", 1, "img click msg is null.");
      continue;
      QLog.e("ImgPreviewAdapter.emonull", 1, "img click emo is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zda
 * JD-Core Version:    0.7.0.1
 */