import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.util.WeakReferenceHandler;

class gjj
  implements Runnable
{
  gjj(gji paramgji, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a).sendEmptyMessageDelayed(8877, 800L);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a).a(0);
      QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a, QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gji.a));
    }
    for (;;)
    {
      if ((QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a) != null) && (QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gji.a) != null))
      {
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a).a(QZoneShareAlbumAssistantActivity.b(this.jdField_a_of_type_Gji.a));
        QZoneShareAlbumAssistantActivity.a(this.jdField_a_of_type_Gji.a).notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_Gji.a.a(1, this.jdField_a_of_type_Gji.a.getString(2131562097));
      this.jdField_a_of_type_Gji.a.a.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjj
 * JD-Core Version:    0.7.0.1
 */