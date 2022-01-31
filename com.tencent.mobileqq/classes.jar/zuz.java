import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy.LoadMoreAioMessageCb;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.Iterator;
import java.util.List;

class zuz
  implements Runnable
{
  zuz(zuy paramzuy, List paramList) {}
  
  public void run()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = j;
      if (DataLineMsgProxy.a(this.jdField_a_of_type_Zuy.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy) != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          if (!DataLineMsgProxy.a(this.jdField_a_of_type_Zuy.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy).insertFrontToList(localDataLineMsgRecord)) {
            break label107;
          }
          i += 1;
        }
      }
    }
    label107:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_Zuy.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$LoadMoreAioMessageCb != null) {
        this.jdField_a_of_type_Zuy.jdField_a_of_type_ComTencentMobileqqAppProxyDataLineMsgProxy$LoadMoreAioMessageCb.a(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zuz
 * JD-Core Version:    0.7.0.1
 */