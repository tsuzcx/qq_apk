import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.statistics.ReportController;

class dzm
  implements Runnable
{
  dzm(dzl paramdzl, Emoticon paramEmoticon, String paramString) {}
  
  public void run()
  {
    ((ChatActivity)this.jdField_a_of_type_Dzl.a.b).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
    ReportController.b(MarketFaceItemBuilder.i(this.jdField_a_of_type_Dzl.a), "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzm
 * JD-Core Version:    0.7.0.1
 */