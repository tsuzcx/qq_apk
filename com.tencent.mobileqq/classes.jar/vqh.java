import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class vqh
  extends vrn
{
  private static final int a;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(45.0F);
  }
  
  public vqh(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560067, paramInt, paramWSVerticalPageFragment);
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Uyx instanceof vqe)) {
      return ((vqe)this.jdField_a_of_type_Uyx).a();
    }
    return null;
  }
  
  public vqe a(int paramInt)
  {
    return new vrp(a(), this);
  }
  
  public void a() {}
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((((vpj)this.jdField_a_of_type_JavaLangObject).a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((vpj)this.jdField_a_of_type_JavaLangObject).a();
      vmp.e("WS_VIDEO_PLAY_TIME", "[WSVerticalCommonVideoHolder.java][isPlayLoop] isLoop:" + localstSimpleMetaFeed.isLoop);
      return localstSimpleMetaFeed.isLoop;
    }
    return super.a();
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  protected boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqh
 * JD-Core Version:    0.7.0.1
 */