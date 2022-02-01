import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class krt
  implements ViewBase.OnClickListener
{
  krt(kqz paramkqz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_b_of_type_Ktm.a == null) {}
    do
    {
      return;
      if (kmt.a(this.a.jdField_b_of_type_Ktm))
      {
        kmt.a(this.a.jdField_b_of_type_Kte.getVafContext().getContext(), this.a.c, this.a.jdField_b_of_type_Ktm, 2);
        return;
      }
      paramViewBase = this.a.jdField_b_of_type_Ktm.a.medalInfo;
    } while ((paramViewBase == null) || (this.a.c == null));
    kxm.a(this.a.c.getContext(), paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krt
 * JD-Core Version:    0.7.0.1
 */