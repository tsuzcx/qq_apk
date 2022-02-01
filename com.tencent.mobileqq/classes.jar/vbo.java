import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vbo
  extends vct
{
  public vbo(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560023, paramInt, paramWSVerticalPageFragment);
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_Ula instanceof vbl)) {
      return ((vbl)this.jdField_a_of_type_Ula).a();
    }
    return null;
  }
  
  public vbl a(int paramInt)
  {
    return new vcu(a(), this);
  }
  
  public void a() {}
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((((vaq)this.jdField_a_of_type_JavaLangObject).a() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((vaq)this.jdField_a_of_type_JavaLangObject).a();
      uya.e("WS_VIDEO_PLAY_TIME", "[WSVerticalCommonVideoHolder.java][isPlayLoop] isLoop:" + localstSimpleMetaFeed.isLoop);
      return localstSimpleMetaFeed.isLoop;
    }
    return super.a();
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
 * Qualified Name:     vbo
 * JD-Core Version:    0.7.0.1
 */