import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class cdc
  extends DiscussionObserver
{
  private cdc(DiscussionView paramDiscussionView) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    if (this.a.c)
    {
      this.a.c = false;
      if (paramBoolean)
      {
        DiscussionView.a(this.a).a(0);
        this.a.a(100, 800L);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
    this.a.b(2131363353);
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdc
 * JD-Core Version:    0.7.0.1
 */