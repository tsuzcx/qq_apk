package cooperation.qzone.stickynote;

import awbq;
import com.tencent.mobileqq.data.Card;
import com.tencent.widget.ListView;

public class QzoneStickyNoteManager$2
  implements Runnable
{
  public QzoneStickyNoteManager$2(awbq paramawbq, ListView paramListView, Card paramCard) {}
  
  public void run()
  {
    awbq.a(this.this$0, awbq.a(this.this$0, this.jdField_c_of_type_ComTencentWidgetListView));
    awbq.a(this.this$0, this.this$0.getAdapter());
    awbq.a(this.this$0, true);
    awbq.a(this.this$0);
    this.this$0.updateFriendProfileCard(this.jdField_c_of_type_ComTencentMobileqqDataCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.2
 * JD-Core Version:    0.7.0.1
 */