import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.MagicFaceDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bwl
  implements MagicFaceDownloadListener
{
  public bwl(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    label16:
    Object localObject1;
    boolean bool;
    label155:
    Object localObject2;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a())
    {
      return;
    }
    else
    {
      localObject1 = ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramEmoticonPackage.epId).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject1 = (Emoticon)((Iterator)localObject1).next();
        localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            bwt localbwt = (bwt)((Iterator)localObject1).next();
            if ((localbwt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localbwt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
            {
              localObject1 = localbwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if ((localbwt.jdField_a_of_type_Boolean) && (localbwt.e.hasWindowFocus()))
              {
                bool = true;
                localObject2 = Boolean.valueOf(bool);
                localbwt.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((((Boolean)localObject2).booleanValue()) && (localObject1 != null))
      {
        localObject1 = ((ChatMessage)localObject1).senderuin;
        ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new bwm(this));
      }
      localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label16;
      }
      localObject2 = (bwt)((Iterator)localObject1).next();
      if ((((bwt)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(((bwt)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        break;
      }
      ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new bwn(this));
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject2);
      return;
      bool = false;
      break label155;
      localObject1 = null;
      localObject2 = Boolean.valueOf(false);
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bwt localbwt = (bwt)localIterator.next();
      if ((localbwt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localbwt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "Download magic Emoji fail!");
        }
        ((ChatActivity)this.a.jdField_b_of_type_AndroidContentContext).runOnUiThread(new bwo(this, localbwt));
        this.a.jdField_a_of_type_JavaUtilList.remove(localbwt);
      }
    }
  }
  
  public void c(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwl
 * JD-Core Version:    0.7.0.1
 */