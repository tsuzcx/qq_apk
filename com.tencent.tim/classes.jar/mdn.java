import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class mdn
  implements mye.a
{
  @Nullable
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private mdn.a jdField_a_of_type_Mdn$a;
  private mes jdField_a_of_type_Mes;
  
  public mdn()
  {
    this(null);
  }
  
  public mdn(@Nullable RIJRedPacketProgressView paramRIJRedPacketProgressView)
  {
    if (paramRIJRedPacketProgressView == null)
    {
      paramRIJRedPacketProgressView = kxm.a(BaseActivity.sTopActivity);
      if (paramRIJRedPacketProgressView == null) {}
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView.a();; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = paramRIJRedPacketProgressView)
    {
      this.jdField_a_of_type_Mdn$a = new mdn.a(null);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.refresh();
      }
      return;
    }
  }
  
  private void a(mye.b paramb, myi parammyi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "startRedPacketTiming:view=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView + ", title=" + paramb.title);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
      RIJRedPacketManager.a().a(new mdo(this, paramb, parammyi));
    }
  }
  
  private void aOJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "stopRedPacketTiming: ");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.stopTiming();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.aOP();
    }
  }
  
  public boolean Dw()
  {
    return (this.jdField_a_of_type_Mes != null) && (this.jdField_a_of_type_Mes.isShowing());
  }
  
  public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramb == null) || (paramb.aqp)) {
      aOJ();
    }
    do
    {
      return;
      if (paramInt2 == 3)
      {
        a(paramb, parammyi);
        return;
      }
    } while (paramInt1 != 3);
    aOJ();
  }
  
  public void onDestory()
  {
    lcc.a().c(this.jdField_a_of_type_Mdn$a);
  }
  
  public void onPause()
  {
    lcc.a().c(this.jdField_a_of_type_Mdn$a);
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.refresh();
    }
    lcc.a().b(this.jdField_a_of_type_Mdn$a);
  }
  
  class a
    extends lce
  {
    private a() {}
    
    public void o(boolean paramBoolean, String paramString)
    {
      if ((paramBoolean) && (mdn.a(mdn.this) != null) && (mdn.a(mdn.this).getVisibility() == 0))
      {
        mdn.a(mdn.this, new mes(mdn.a(mdn.this).getContext()));
        mdn.a(mdn.this).setTips(paramString);
        mdn.a(mdn.this).rI(RIJRedPacketManager.a().oW());
        mdn.a(mdn.this).showAsDropDown(mdn.a(mdn.this), 0, aqnm.dip2px(6.0F));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdn
 * JD-Core Version:    0.7.0.1
 */