import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class noh
  extends acnn
{
  noh(nof paramnof) {}
  
  public void k(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void v(List<amrb> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 6) {}
    while (((this.this$0.a != null) && (this.this$0.a.Gb != null) && (this.this$0.a.Gb.size() != 0)) || (paramList == null) || (paramList.size() <= 0) || (!(paramList.get(0) instanceof HotWordSearchEntryDataModel))) {
      return;
    }
    this.this$0.a = ((HotWordSearchEntryDataModel)paramList.get(0));
    nof.baF = 0;
    this.this$0.aZH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     noh
 * JD-Core Version:    0.7.0.1
 */