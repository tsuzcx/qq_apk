import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class lmq
  implements ViewBase.OnClickListener
{
  lmq(lmp paramlmp, Container paramContainer, lie paramlie, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    lmp.a(this.a, this.c.getContext(), this.b, this.val$position);
    if (QLog.isColorLevel()) {
      QLog.d("BiuPgcProteusItem", 2, "click gallery summary for jumping to gallery articleinfo = " + this.b.a() + " position = " + this.val$position);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmq
 * JD-Core Version:    0.7.0.1
 */