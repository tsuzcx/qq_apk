import android.content.Context;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ves
{
  private final PhotoDanmakuDrawer jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer;
  private final BlockingQueue<vex> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private final vel jdField_a_of_type_Vel;
  private final vey jdField_a_of_type_Vey;
  private final vfa jdField_a_of_type_Vfa;
  private final BlockingQueue<vex> b;
  
  public ves(Context paramContext, vfa paramvfa, int paramInt)
  {
    this.jdField_a_of_type_Vfa = paramvfa;
    this.jdField_a_of_type_Vel = vel.a(paramContext, 1, paramInt);
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer = new PhotoDanmakuDrawer(paramContext, null);
    this.jdField_a_of_type_Vey = new vey(this.jdField_a_of_type_Vel.d);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
    this.b = new LinkedBlockingQueue();
  }
  
  public vex a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    vex localvex;
    do
    {
      return localObject;
      localvex = (vex)this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.poll();
      localObject = localvex;
    } while (localvex != null);
    return new vfb(this.jdField_a_of_type_Vel, this.jdField_a_of_type_Vey.a(), this.jdField_a_of_type_Vfa);
  }
  
  public vex a(int paramInt1, long paramLong, String paramString, CharSequence paramCharSequence, int paramInt2, float paramFloat, int paramInt3)
  {
    vex localvex = a(paramInt1);
    if (localvex != null)
    {
      localvex.a(paramLong);
      localvex.c(paramString);
      localvex.a(paramCharSequence);
      localvex.d(paramFloat);
      localvex.d(paramInt3);
      localvex.a(paramInt2);
    }
    return localvex;
  }
  
  public vex a(vex paramvex)
  {
    switch (paramvex.a())
    {
    }
    do
    {
      return paramvex;
    } while (paramvex.a());
    paramvex.b(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuCorePhotoDanmakuDrawer);
    return paramvex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ves
 * JD-Core Version:    0.7.0.1
 */