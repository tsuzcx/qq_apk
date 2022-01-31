import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.subscribe.comment.EmoView;

public class yhc
  implements AdapterView.OnItemClickListener
{
  public yhc(EmoView paramEmoView, int paramInt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 27)
    {
      if (EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView) != null) {
        bool1 = EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a();
      }
      if (!bool1) {
        EmoView.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a();
      }
    }
    do
    {
      do
      {
        return;
        paramInt = (this.jdField_a_of_type_Int - 1) * 27 + paramInt;
      } while (paramInt >= 107);
      paramAdapterView = yhp.b[yhg.b[paramInt]];
      bool1 = bool2;
      if (EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView) != null) {
        bool1 = EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a(paramAdapterView);
      }
    } while (bool1);
    EmoView.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhc
 * JD-Core Version:    0.7.0.1
 */