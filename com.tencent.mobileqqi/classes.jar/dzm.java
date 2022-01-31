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

public class dzm
  implements EmoticonController.MagicFaceDownloader
{
  public dzm(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
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
            dzt localdzt = (dzt)((Iterator)localObject1).next();
            if ((localdzt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localdzt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
            {
              localObject1 = localdzt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if ((localdzt.jdField_a_of_type_Boolean) && (localdzt.e.hasWindowFocus()))
              {
                bool = true;
                localObject2 = Boolean.valueOf(bool);
                localdzt.jdField_a_of_type_Boolean = false;
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
        ((ChatActivity)this.a.b).runOnUiThread(new dzn(this, localEmoticon, (String)localObject1));
      }
      localObject1 = this.a.a.iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label16;
      }
      localObject2 = (dzt)((Iterator)localObject1).next();
      if ((((dzt)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (!paramEmoticonPackage.epId.equals(((dzt)localObject2).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId))) {
        break;
      }
      ((ChatActivity)this.a.b).runOnUiThread(new dzo(this));
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
      dzt localdzt = (dzt)localIterator.next();
      if ((localdzt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (paramEmoticonPackage.epId.equals(localdzt.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId)))
      {
        localdzt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localdzt.f.setVisibility(8);
        this.a.a.remove(localdzt);
      }
    }
  }
  
  public void c(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzm
 * JD-Core Version:    0.7.0.1
 */