import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;

public class mld
  implements mll
{
  public mld(CoverSelectTabFragment paramCoverSelectTabFragment) {}
  
  public void nG(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.CoverSelectTabFragment", 2, "OutputPicListener outPath:" + paramString);
    }
    CoverSelectTabFragment.a(this.a, paramString, CoverSelectTabFragment.a(this.a).getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mld
 * JD-Core Version:    0.7.0.1
 */