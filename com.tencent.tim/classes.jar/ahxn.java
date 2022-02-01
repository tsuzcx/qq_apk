import QC.FontInfo;
import QC.FontRecommendRsp;
import QC.ItemBase;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubblePanelView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahxn
  implements FontBubblePanelView.a<FontRecommendRsp>
{
  public String a(FontBubble paramFontBubble)
  {
    return aqqj.getUrl("fontPreview").replace("[id]", Integer.toString(paramFontBubble.fontId));
  }
  
  public List<FontBubble> a(QQAppInterface paramQQAppInterface, FontRecommendRsp paramFontRecommendRsp)
  {
    int j = ((acle)paramQQAppInterface.getBusinessHandler(13)).AS();
    paramQQAppInterface = new ArrayList();
    if (paramFontRecommendRsp.vItems != null)
    {
      paramFontRecommendRsp = paramFontRecommendRsp.vItems.iterator();
      if (paramFontRecommendRsp.hasNext())
      {
        FontInfo localFontInfo = (FontInfo)paramFontRecommendRsp.next();
        FontBubble localFontBubble = new FontBubble();
        localFontBubble.viewType = 1;
        localFontBubble.fontId = localFontInfo.item.itemId;
        if (localFontInfo.linkBubbleID > 0) {}
        for (int i = localFontInfo.linkBubbleID;; i = j)
        {
          localFontBubble.bubbleId = i;
          localFontBubble.name = localFontInfo.name;
          localFontBubble.engine = localFontInfo.engine;
          localFontBubble.feeType = localFontInfo.feeType;
          localFontBubble.payUrl = localFontInfo.payUrl;
          localFontBubble.title = localFontInfo.title;
          localFontBubble.msg = localFontInfo.msg;
          localFontBubble.btn = localFontInfo.btn;
          localFontBubble.picUrl = localFontInfo.strPicUrl;
          localFontBubble.panelType = 3;
          paramQQAppInterface.add(localFontBubble);
          break;
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public void a(acle paramacle)
  {
    paramacle.cMj();
  }
  
  public String aD(Context paramContext)
  {
    return aqqj.o(paramContext, "font", "mvip.gexinghua.mobile.font.client_tab_store");
  }
  
  public int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxn
 * JD-Core Version:    0.7.0.1
 */