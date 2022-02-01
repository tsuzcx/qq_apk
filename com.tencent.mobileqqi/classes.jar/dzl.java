import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonController.MagicFaceDownloader;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import java.util.Iterator;
import java.util.List;

public class dzl
  implements EmoticonController.MagicFaceDownloader
{
  public dzl(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    label16:
    Object localObject1;
    Emoticon localEmoticon;
    boolean bool;
    label156:
    Object localObject2;
    if (!MarketFaceItemBuilder.g(this.a).a().a())
    {
      return;
    }
    else
    {
      localObject1 = ((EmoticonManager)MarketFaceItemBuilder.h(this.a).getManager(12)).a(paramEmoticonPackage.epId).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localEmoticon = (Emoticon)((Iterator)localObject1).next();
        localObject1 = this.a.a.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            dzs localdzs = (dzs)((Iterator)localObject1).next();
            if ((localdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
            {
              localObject1 = localdzs.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if ((localdzs.jdField_a_of_type_Boolean) && (localdzs.e.hasWindowFocus()))
              {
                bool = true;
                localObject2 = Boolean.valueOf(bool);
                localdzs.jdField_a_of_type_Boolean = false;
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
        ((ChatActivity)this.a.b).runOnUiThread(new dzm(this, localEmoticon, (String)localObject1));
      }
      localObject1 = this.a.a.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label16;
      }
      localObject2 = (dzs)((Iterator)localObject1).next();
      if ((((dzs)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(((dzs)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        break;
      }
      ((ChatActivity)this.a.b).runOnUiThread(new dzn(this));
      this.a.a.remove(localObject2);
      return;
      bool = false;
      break label156;
      localObject1 = null;
      localObject2 = Boolean.valueOf(false);
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      dzs localdzs = (dzs)localIterator.next();
      if ((localdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localdzs.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
      {
        localdzs.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localdzs.f.setVisibility(8);
        this.a.a.remove(localdzs);
      }
    }
  }
  
  public void c(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzl
 * JD-Core Version:    0.7.0.1
 */