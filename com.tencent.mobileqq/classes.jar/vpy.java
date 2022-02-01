import android.content.Context;
import com.tencent.biz.qqcircle.polylike.QCirclePolyBaseLikeView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFreeView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeMoreView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView;

public class vpy
{
  static QCirclePolyBaseLikeView a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramInt1 |= paramInt2;
    switch (paramInt2)
    {
    default: 
      return new vpz(paramContext, paramInt1);
    case 1: 
      return new QCirclePolyLikeFreeView(paramContext, paramInt1);
    case 2: 
      return new QCirclePolyLikePayView(paramContext, paramInt1);
    }
    return new QCirclePolyLikeMoreView(paramContext, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpy
 * JD-Core Version:    0.7.0.1
 */