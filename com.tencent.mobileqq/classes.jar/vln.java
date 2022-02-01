import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Collections;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vln
  implements Observer<vbb>
{
  public vln(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(@Nullable vbb paramvbb)
  {
    if ((this.a.jdField_a_of_type_Uzw != null) && (this.a.jdField_a_of_type_Vbe != null) && (this.a.jdField_a_of_type_Vbe.a != null))
    {
      if (paramvbb == null) {
        break label119;
      }
      paramvbb.a(uyw.a(this.a.jdField_a_of_type_Vbe.a.urlInfo.get(), "NoticeListUrl"));
      boolean bool = paramvbb.a();
      this.a.jdField_a_of_type_Uzw.a(bool);
      if (bool)
      {
        vtq.a("", 18, 1);
        this.a.jdField_a_of_type_Uzw.setDatas(new ArrayList(Collections.singletonList(paramvbb)));
        vtd.a(paramvbb.c());
      }
    }
    return;
    label119:
    this.a.jdField_a_of_type_Uzw.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vln
 * JD-Core Version:    0.7.0.1
 */