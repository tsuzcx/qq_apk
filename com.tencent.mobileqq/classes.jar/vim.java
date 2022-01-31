import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.util.LRULinkedHashMap;

public class vim
  implements Runnable
{
  public vim(TextItemBuilder paramTextItemBuilder, CharSequence paramCharSequence, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_Long);
    if (localObject1 != null) {}
    synchronized (TextItemBuilder.a)
    {
      TextItemBuilder.a.put(Long.valueOf(this.b), localObject1);
      ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.b.obtainMessage();
      ((Message)???).what = 1;
      ((Message)???).obj = localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("msg_id", this.b);
      ((Message)???).setData((Bundle)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.b.sendMessage((Message)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vim
 * JD-Core Version:    0.7.0.1
 */