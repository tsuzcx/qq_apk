import android.content.Context;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class vgw
{
  private final PhotoDanmakuDrawer jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer;
  private final BlockingQueue<vhb> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private final vgp jdField_a_of_type_Vgp;
  private final vhc jdField_a_of_type_Vhc;
  private final vhe jdField_a_of_type_Vhe;
  private final BlockingQueue<vhb> b;
  
  public vgw(Context paramContext, vhe paramvhe, int paramInt)
  {
    this.jdField_a_of_type_Vhe = paramvhe;
    this.jdField_a_of_type_Vgp = vgp.a(paramContext, 1, paramInt);
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer = new PhotoDanmakuDrawer(paramContext, null);
    this.jdField_a_of_type_Vhc = new vhc(this.jdField_a_of_type_Vgp.d);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
    this.b = new LinkedBlockingQueue();
  }
  
  public vhb a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    vhb localvhb;
    do
    {
      return localObject;
      localvhb = (vhb)this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.poll();
      localObject = localvhb;
    } while (localvhb != null);
    return new vhf(this.jdField_a_of_type_Vgp, this.jdField_a_of_type_Vhc.a(), this.jdField_a_of_type_Vhe);
  }
  
  public vhb a(int paramInt1, long paramLong, String paramString, CharSequence paramCharSequence, int paramInt2, float paramFloat, int paramInt3)
  {
    vhb localvhb = a(paramInt1);
    if (localvhb != null)
    {
      localvhb.a(paramLong);
      localvhb.c(paramString);
      localvhb.a(paramCharSequence);
      localvhb.d(paramFloat);
      localvhb.d(paramInt3);
      localvhb.a(paramInt2);
    }
    return localvhb;
  }
  
  public vhb a(vhb paramvhb)
  {
    switch (paramvhb.a())
    {
    }
    do
    {
      return paramvhb;
    } while (paramvhb.a());
    paramvhb.b(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
    return paramvhb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgw
 * JD-Core Version:    0.7.0.1
 */