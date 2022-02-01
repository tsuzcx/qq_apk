import com.tencent.mobileqq.activity.NearPeopleActivity;
import com.tencent.mobileqq.app.NearHornHandler;
import com.tencent.mobileqq.app.NearHornObserver;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.widget.HornAnimationView;
import java.util.Iterator;
import java.util.List;

public class cxh
  extends NearHornObserver
{
  public cxh(NearPeopleActivity paramNearPeopleActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, String paramString)
  {
    if ((paramBoolean) && (NearPeopleActivity.a(this.a) != null) && (!paramBoolean2.booleanValue()) && (NearPeopleActivity.a(this.a) != null))
    {
      this.a.jdField_a_of_type_JavaLangBoolean = NearPeopleActivity.a(this.a).jdField_a_of_type_JavaLangBoolean;
      NearPeopleActivity.a(this.a, paramString);
      if (NearPeopleActivity.a(this.a) != null)
      {
        NearPeopleActivity.a(this.a).clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramBoolean1 = (HornDetail)paramList.next();
          NearPeopleActivity.a(this.a).add(paramBoolean1);
        }
        if (NearPeopleActivity.a(this.a).size() <= 0) {
          break label147;
        }
        this.a.e();
      }
    }
    label147:
    while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView.c();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetHornAnimationView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cxh
 * JD-Core Version:    0.7.0.1
 */