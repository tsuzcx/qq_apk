import android.content.Context;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1;

public class vrf
  extends uyw<vpj>
{
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new vrh(this);
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSPlayerControlBar jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  private vrn jdField_a_of_type_Vrn;
  private boolean jdField_a_of_type_Boolean;
  
  public vrf(Context paramContext, vrn paramvrn, WSVerticalVideoRelativeLayout paramWSVerticalVideoRelativeLayout)
  {
    super(paramContext);
    this.jdField_a_of_type_Vrn = paramvrn;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = paramWSVerticalVideoRelativeLayout;
    if ((this.jdField_a_of_type_Vrn != null) && (this.jdField_a_of_type_Vrn.a != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = this.jdField_a_of_type_Vrn.a.a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout == null) {
      return;
    }
    WSVerticalItemVideoProgressController.1 local1 = new WSVerticalItemVideoProgressController.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout.setDispatchTouchEventListener(new vrg(this, local1));
  }
  
  protected void a() {}
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setProgress(paramFloat);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected int b()
  {
    return 2131560079;
  }
  
  protected void b()
  {
    a(0.0F);
  }
  
  protected void c()
  {
    h();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar = ((WSPlayerControlBar)a(2131381079));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    i();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */