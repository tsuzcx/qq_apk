import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class krq
  implements ViewBase.OnClickListener
{
  krq(kqz paramkqz, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((kmt.a(this.a.jdField_b_of_type_Ktm)) && (this.a.jdField_b_of_type_Ktm.a.advertisementInfo != null))
    {
      paramViewBase = this.a.c.getVirtualView().findViewBaseByName("id_comment_tail_3_dot");
      this.a.jdField_b_of_type_Kte.b.a(paramViewBase.getNativeView(), this.a.jdField_b_of_type_Ktm.a.advertisementInfo);
    }
    do
    {
      return;
      if ((this.c instanceof kvf)) {
        this.c.getNativeView().setBackgroundColor(Color.parseColor("#DBE5EF"));
      }
    } while (this.a.jdField_b_of_type_Kte == null);
    this.a.jdField_b_of_type_Kte.a(this.a.jdField_b_of_type_Kte.mActivity, this.c.getNativeView(), this.a.jdField_b_of_type_Ktm, new krr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krq
 * JD-Core Version:    0.7.0.1
 */