import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class mdo
  implements RIJRedPacketManager.f
{
  mdo(mdn parammdn, mye.b paramb, myi parammyi) {}
  
  public void lJ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRedPacketManager", 2, "onShouldDoTaskTimingCallback: shouldDoTaskTiming=" + paramBoolean);
    }
    if (paramBoolean) {
      mdn.a(this.jdField_b_of_type_Mdn).d(this.jdField_b_of_type_Mye$b.d.innerUniqueID, (int)this.jdField_b_of_type_Myi.getDuration(), 2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */