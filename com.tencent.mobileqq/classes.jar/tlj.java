import android.text.TextUtils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class tlj
  extends aogk
{
  tlj(tli paramtli) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void handleSearchDiscoveryResult(List<bcgq> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    String str;
    do
    {
      return;
      str = bbzh.b;
    } while ((paramList == null) || (paramList.size() <= 0));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bcgq localbcgq = (bcgq)paramList.next();
      if (localbcgq.c == 1) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localbcgq);
      }
      if ((localbcgq.c == 7) && (TextUtils.equals(str, "Recom_word"))) {
        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localbcgq);
      }
    }
    tli.jdField_a_of_type_Int = 0;
    this.a.a(true, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tlj
 * JD-Core Version:    0.7.0.1
 */