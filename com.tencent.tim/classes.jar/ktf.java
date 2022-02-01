import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class ktf
  implements AbsListView.e
{
  ktf(kte paramkte) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d.jdField_b_of_type_Ksk$a != null)
    {
      int i = kte.a(this.d, paramInt1);
      this.d.jdField_b_of_type_Ksk$a.onScroll(i);
    }
    if (this.d.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher != null) {
      this.d.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.d.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher != null) {
      this.d.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventCommentItemShowDispatcher.l(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktf
 * JD-Core Version:    0.7.0.1
 */