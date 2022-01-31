import android.view.View;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import com.tencent.widget.XListView;

public class ecw
  implements IFriendObserver
{
  public ecw(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void a(String paramString)
  {
    int j;
    int i;
    if (this.a.jdField_a_of_type_Int == 0)
    {
      j = CircleMemberListActivity.a(this.a).getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = CircleMemberListActivity.a(this.a).getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof edf)))
        {
          localObject = (edf)localObject;
          if (((edf)localObject).a.uin.equals(paramString)) {
            this.a.a(CircleMemberListActivity.a(this.a).getChildAt(i), ((edf)localObject).a);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Int == 0)) {
      this.a.jdField_a_of_type_Ede.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ecw
 * JD-Core Version:    0.7.0.1
 */