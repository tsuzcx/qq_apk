import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.SubtitleDataManagerListener;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem.FontItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class xwl
  implements Runnable
{
  public xwl(SubtitleDataManager paramSubtitleDataManager, SubtitleItem.FontItem paramFontItem) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      SubtitleDataManager.SubtitleDataManagerListener localSubtitleDataManagerListener = (SubtitleDataManager.SubtitleDataManagerListener)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager.jdField_a_of_type_JavaLangRefWeakReference.get();
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleDataManager.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        SubtitleItem localSubtitleItem = (SubtitleItem)localIterator.next();
        if ((localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem) && (localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem != null)) {
          localSubtitleDataManagerListener.a(localSubtitleItem.jdField_a_of_type_Int, 0, localSubtitleItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSubtitleItem$FontItem.f);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwl
 * JD-Core Version:    0.7.0.1
 */