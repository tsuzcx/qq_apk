import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class tnd
  implements tbu
{
  private static final String a;
  protected int a;
  public aakn a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected tne a;
  protected tnf a;
  
  static
  {
    jdField_a_of_type_JavaLangString = tnd.class.getSimpleName();
  }
  
  public tnd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Tne != null) {
      this.jdField_a_of_type_Tne.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onPullRefreshing percent:" + paramInt + " isTopRefreshing:" + paramBoolean);
    }
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = paramSlideActiveAnimController;
  }
  
  public void a(tne paramtne)
  {
    this.jdField_a_of_type_Tne = paramtne;
  }
  
  public void a(tnf paramtnf)
  {
    this.jdField_a_of_type_Tnf = paramtnf;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tnf != null) {
      this.jdField_a_of_type_Tnf.a(paramBoolean);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tnd
 * JD-Core Version:    0.7.0.1
 */