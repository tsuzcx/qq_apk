import android.widget.ImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.1;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.2;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.3;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class xju
  extends afkn
{
  public xju(MarketFaceItemBuilder paramMarketFaceItemBuilder) {}
  
  private void a(EmoticonPackage paramEmoticonPackage, Boolean paramBoolean, List<Emoticon> paramList)
  {
    Boolean localBoolean = null;
    paramList = paramList.iterator();
    Emoticon localEmoticon;
    boolean bool;
    if (paramList.hasNext())
    {
      localEmoticon = (Emoticon)paramList.next();
      Iterator localIterator = this.this$0.se.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (MarketFaceItemBuilder.b)localIterator.next();
          if ((paramList.c != null) && (paramEmoticonPackage.epId.equals(paramList.c.e.epId)))
          {
            paramBoolean = paramList.mMessage;
            if ((paramList.bgZ) && (paramList.image.hasWindowFocus()))
            {
              bool = true;
              localBoolean = Boolean.valueOf(bool);
              paramList.bgZ = false;
              paramEmoticonPackage = paramList;
              paramList = paramBoolean;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localBoolean.booleanValue()) {
        if (paramList != null)
        {
          paramBoolean = paramList.senderuin;
          ((BaseActivity)this.this$0.mContext).runOnUiThread(new MarketFaceItemBuilder.6.2(this, localEmoticon, paramBoolean, paramEmoticonPackage));
        }
      }
      while ((localEmoticon == null) || (localEmoticon.jobType != 4))
      {
        return;
        bool = false;
        break;
      }
      ((BaseActivity)this.this$0.mContext).runOnUiThread(new MarketFaceItemBuilder.6.3(this, paramEmoticonPackage, localEmoticon));
      return;
      paramList = null;
      paramEmoticonPackage = localBoolean;
      localBoolean = paramBoolean;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    Object localObject;
    MarketFaceItemBuilder.b localb;
    if (paramInt != 0)
    {
      localObject = this.this$0.se.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localb = (MarketFaceItemBuilder.b)((Iterator)localObject).next();
        if ((localb.c != null) && (paramEmoticonPackage.epId.equals(localb.c.e.epId)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MarketFaceItemBuilder", 2, "Download magic Emoji fail!");
          }
          ((BaseActivity)this.this$0.mContext).runOnUiThread(new MarketFaceItemBuilder.6.1(this, localb));
        }
      }
    }
    label118:
    do
    {
      do
      {
        do
        {
          this.this$0.se.remove(localb);
          return;
          break label118;
          while ((!this.this$0.app.b().Op()) || (paramEmoticonPackage == null)) {}
          localObject = ((ajdg)this.this$0.app.getManager(14)).az(paramEmoticonPackage.epId);
        } while (localObject == null);
        a(paramEmoticonPackage, Boolean.valueOf(false), (List)localObject);
        localObject = this.this$0.se.iterator();
      } while (!((Iterator)localObject).hasNext());
      localb = (MarketFaceItemBuilder.b)((Iterator)localObject).next();
    } while ((localb.c == null) || (!paramEmoticonPackage.epId.equals(localb.c.e.epId)));
    if (localb.c.e.jobType == 2) {
      aqnl.cT(this.this$0.mContext, null);
    }
    this.this$0.se.remove(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xju
 * JD-Core Version:    0.7.0.1
 */