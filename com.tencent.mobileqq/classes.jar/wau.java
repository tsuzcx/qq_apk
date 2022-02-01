import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayout;
import com.tencent.biz.qqcircle.widgets.QCircleGiftRecordView;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class wau
  extends vsn<QQCircleFeedBase.StPolyLike>
{
  public wau(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    super(localList);
  }
  
  public View a(QCircleFlowLayout paramQCircleFlowLayout, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    paramQCircleFlowLayout = LayoutInflater.from(this.a.getContext()).inflate(2131560771, paramQCircleFlowLayout, false);
    URLImageView localURLImageView = (URLImageView)paramQCircleFlowLayout.findViewById(2131373912);
    QCircleGiftRecordView localQCircleGiftRecordView = (QCircleGiftRecordView)paramQCircleFlowLayout.findViewById(2131374055);
    if (paramStPolyLike.articleType.get() == 0)
    {
      localQCircleGiftRecordView.setVisibility(8);
      localURLImageView.setVisibility(0);
      uys.a(paramStPolyLike.polyIconUrl.get(), localURLImageView);
      return paramQCircleFlowLayout;
    }
    localURLImageView.setVisibility(8);
    localQCircleGiftRecordView.setVisibility(0);
    localQCircleGiftRecordView.setIconUrl(paramStPolyLike.polyIconUrl.get());
    localQCircleGiftRecordView.setGiftCount(paramStPolyLike.count.get(), true);
    localQCircleGiftRecordView.setUIStyle(paramStPolyLike.polyTxtColor.get(), paramStPolyLike.polyUnderColor.get());
    return paramQCircleFlowLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wau
 * JD-Core Version:    0.7.0.1
 */