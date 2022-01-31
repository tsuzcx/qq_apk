import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.util.WeakReferenceHandler;

class gns
  implements Runnable
{
  gns(gnr paramgnr, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a).sendEmptyMessageDelayed(8877, 800L);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a).a(0);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a, QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gnr.a));
    }
    for (;;)
    {
      if ((QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a) != null) && (QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gnr.a) != null))
      {
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a).a(QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gnr.a));
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gnr.a).notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_Gnr.a.a(1, this.jdField_a_of_type_Gnr.a.getString(2131562097));
      this.jdField_a_of_type_Gnr.a.a.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gns
 * JD-Core Version:    0.7.0.1
 */