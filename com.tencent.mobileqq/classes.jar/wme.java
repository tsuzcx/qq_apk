import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.qphone.base.util.QLog;

public class wme
  implements View.OnClickListener
{
  public wme(ImgPreviewAdapter paramImgPreviewAdapter) {}
  
  public void onClick(View paramView)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = this.a.a(ImgPreviewAdapter.a(this.a).getCurrentItem());
    if (localEmoticonFromGroupEntity != null)
    {
      if (localEmoticonFromGroupEntity.msg != null)
      {
        ImgPreviewAdapter.a(this.a).a(ImgPreviewAdapter.a(this.a), localEmoticonFromGroupEntity.msg, paramView);
        return;
      }
      QLog.e("ImgPreviewAdapter.msgnull", 1, "img click msg is null.");
      return;
    }
    QLog.e("ImgPreviewAdapter.emonull", 1, "img click emo is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wme
 * JD-Core Version:    0.7.0.1
 */