import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public abstract class vbn<T>
  extends bjwy<T>
{
  public WSVerticalPageFragment a;
  public T a;
  public ula<T> a;
  
  public vbn(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    this.jdField_a_of_type_Ula = a(paramInt2);
  }
  
  public abstract FrameLayout a();
  
  public abstract ula<T> a(int paramInt);
  
  public abstract void a(int paramInt);
  
  public void a(T paramT)
  {
    super.a(paramT);
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbn
 * JD-Core Version:    0.7.0.1
 */