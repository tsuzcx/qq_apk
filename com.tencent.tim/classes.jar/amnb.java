import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amnb
  extends acnl
{
  public amnb(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void R(int paramInt, List<BusinessGroupWord> paramList)
  {
    HotWordsForSubBussFragment.expireTime = paramInt;
    HotWordsForSubBussFragment.a(this.this$0, paramList);
    if (QLog.isColorLevel()) {
      QLog.i(HotWordsForSubBussFragment.TAG, 2, "unify handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.expireTime);
    }
  }
  
  public void ce(int paramInt, String paramString)
  {
    super.ce(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w(HotWordsForSubBussFragment.TAG, 2, "unify handleBusiHotWordError code=" + paramInt + " errorMsg;" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnb
 * JD-Core Version:    0.7.0.1
 */