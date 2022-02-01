import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class non
  extends acnn
{
  non(nom paramnom) {}
  
  public void k(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void v(List<amrb> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    amrb localamrb;
    do
    {
      do
      {
        return;
        while ((paramList == null) || (paramList.size() <= 0)) {}
        paramList = paramList.iterator();
      } while (!paramList.hasNext());
      localamrb = (amrb)paramList.next();
    } while (!(localamrb instanceof HotWordSearchEntryDataModel));
    this.this$0.a = ((HotWordSearchEntryDataModel)localamrb);
    nom.baF = 0;
    this.this$0.i(false, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     non
 * JD-Core Version:    0.7.0.1
 */