import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager.b;

public class jgk
  extends DataSetObserver
{
  public jgk(EffectCycleViewPager.b paramb, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_b_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_b_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgk
 * JD-Core Version:    0.7.0.1
 */