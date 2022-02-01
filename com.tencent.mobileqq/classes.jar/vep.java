import android.graphics.Paint;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class vep
  implements aoci
{
  public vep(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, long paramLong, vex paramvex, float paramFloat1, float paramFloat2, Paint paramPaint) {}
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoDanmakuDrawer", 2, "onLoadingStateChanged uin= " + this.jdField_a_of_type_Long + ", oldState=" + paramInt1 + ", curState=" + paramInt2);
    }
    if (paramInt2 == 1)
    {
      aoch localaoch = aoch.a(((BaseActivity)PhotoDanmakuDrawer.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer)).app, 1, 4, String.valueOf(this.jdField_a_of_type_Long));
      PhotoDanmakuDrawer.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.jdField_a_of_type_Vex, this.jdField_a_of_type_Float, this.b, localaoch);
      return;
    }
    PhotoDanmakuDrawer.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer, this.jdField_a_of_type_Vex, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_Float, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vep
 * JD-Core Version:    0.7.0.1
 */