import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.util.WeakReferenceHandler;

class gji
  implements Runnable
{
  gji(gjh paramgjh, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a).sendEmptyMessageDelayed(8877, 800L);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a).a(0);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a, QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gjh.a));
    }
    for (;;)
    {
      if ((QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a) != null) && (QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gjh.a) != null))
      {
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a).a(QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gjh.a));
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gjh.a).notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_Gjh.a.a(1, this.jdField_a_of_type_Gjh.a.getString(2131562097));
      this.jdField_a_of_type_Gjh.a.a.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gji
 * JD-Core Version:    0.7.0.1
 */