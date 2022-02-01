import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class krc
  implements ViewBase.OnClickListener
{
  krc(kqz paramkqz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramViewBase.getEventAttachedData());
    QLog.d("CommentProteusUtil", 2, "comment media url : " + paramViewBase.getEventAttachedData());
    apmj.a(this.a.jdField_b_of_type_Kte.a(), 0, localArrayList, true, "", 1888);
    if (this.a.jdField_b_of_type_Kte.a() != null) {
      this.a.jdField_b_of_type_Kte.a().g(this.a.jdField_b_of_type_Ktm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krc
 * JD-Core Version:    0.7.0.1
 */