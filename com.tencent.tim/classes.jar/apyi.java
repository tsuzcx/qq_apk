import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class apyi
  extends aquy
{
  apyi(apyh paramapyh, File paramFile, apyh.a parama) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupCatalogTool", 2, "getChoiceListFromServer download suc ");
    }
    if ((paramaquz.errCode == 0) && (this.aZ.exists()) && (this.b.bG(BaseApplicationImpl.getContext())) && (this.b.bH(BaseApplicationImpl.getContext())))
    {
      this.b.s(BaseApplicationImpl.getContext(), System.currentTimeMillis());
      if (this.a != null) {
        this.a.onResult(true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.a != null))
      {
        QLog.e("GroupCatalogTool", 1, "getChoiceListFromServer failed!");
        this.a.onResult(false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyi
 * JD-Core Version:    0.7.0.1
 */