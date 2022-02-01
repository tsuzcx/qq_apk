import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class aasd
  implements aasb.a
{
  aasd(aasb paramaasb) {}
  
  public void Gr(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.b.mTemplateList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      do
      {
        return;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.b.mTemplateList.get(paramInt);
      } while (localPtvTemplateInfo == null);
      this.b.mListView.smoothScrollToPositionFromLeftOrRight(paramInt, (int)(-this.b.mItemWidth * (0.75F + this.b.cju - 1.0F)), 400);
    } while (localPtvTemplateInfo.usable);
    aaqi.ec("", "0X8006A1A");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasd
 * JD-Core Version:    0.7.0.1
 */