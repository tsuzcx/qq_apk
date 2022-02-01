import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class kru
  implements ViewBase.OnClickListener
{
  kru(kqz paramkqz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_b_of_type_Ktm.a != null)
    {
      kxm.aJ(this.a.jdField_b_of_type_Kte.getVafContext().getContext(), this.a.jdField_b_of_type_Ktm.a.activityJumpUrl);
      if (this.a.jdField_b_of_type_Kte.a() != null) {
        this.a.jdField_b_of_type_Kte.a().f(this.a.jdField_b_of_type_Ktm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kru
 * JD-Core Version:    0.7.0.1
 */