import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ltf
  implements View.OnClickListener
{
  public ltf(NativeAwesomeCommentView paramNativeAwesomeCommentView, mgt parammgt) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView)) {
      NativeAwesomeCommentView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Mgt != null)
      {
        kxm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView.getContext(), this.jdField_b_of_type_Mgt.d, this.jdField_b_of_type_Mgt.jump_url);
        mgt.d(NativeAwesomeCommentView.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).d, "0X8009B77");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltf
 * JD-Core Version:    0.7.0.1
 */