import android.content.Context;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController.1;

public class ory
  extends ogm<oqr>
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSPlayerControlBar jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  private boolean ayc;
  private osf c;
  private SeekBar.OnSeekBarChangeListener mSeekListener = new osa(this);
  
  public ory(Context paramContext, osf paramosf)
  {
    super(paramContext);
    this.c = paramosf;
    if ((paramosf != null) && ((paramosf.a instanceof orb)))
    {
      paramContext = (orb)paramosf.a;
      if ((paramContext.d() instanceof WSVerticalVideoRelativeLayout)) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)paramContext.d());
      }
    }
    if ((this.c != null) && (this.c.c != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = this.c.c.a();
    }
  }
  
  private void initTouchEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout == null) {
      return;
    }
    WSVerticalItemVideoProgressController.1 local1 = new WSVerticalItemVideoProgressController.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout.setDispatchTouchEventListener(new orz(this, local1));
  }
  
  public boolean Hn()
  {
    return this.ayc;
  }
  
  protected void Hp() {}
  
  public void bgI()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.bga();
    }
  }
  
  public void bgb()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.bgb();
    }
  }
  
  public void bgc()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.bgc();
    }
  }
  
  protected int gn()
  {
    return 2131560222;
  }
  
  protected void initView()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar = ((WSPlayerControlBar)findViewById(2131381854));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setSeekBarChangeListener(this.mSeekListener);
    initTouchEvent();
  }
  
  protected void onRecycle()
  {
    bgc();
  }
  
  protected void onUpdateUI()
  {
    setProgress(0.0F);
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setProgress(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ory
 * JD-Core Version:    0.7.0.1
 */