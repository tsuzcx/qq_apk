import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;

public class aavs
{
  private static final int clI = Color.rgb(123, 113, 30);
  private static final int clJ = Color.rgb(38, 87, 178);
  private static final int clK = Color.argb(64, 125, 113, 30);
  private static final int clL = Color.argb(64, 6, 59, 156);
  private static final int clM = Color.rgb(162, 116, 4);
  private static final int clN = Color.argb(64, 213, 185, 118);
  private static final int clO = Color.argb(102, 213, 185, 118);
  public int clP = 0;
  private final wki h;
  public QQAppInterface mApp;
  
  public aavs(wki paramwki, QQAppInterface paramQQAppInterface)
  {
    this.h = paramwki;
    this.mApp = paramQQAppInterface;
  }
  
  private aawc a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof aawc)) {
        return (aawc)paramView.getParent();
      }
    } while (!(paramView instanceof aawc));
    return (aawc)paramView;
  }
  
  public boolean R(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = wja.a(paramView);
    boolean bool1;
    if (AppSetting.enableTalkBack)
    {
      bool1 = false;
      if (!bool1) {
        break label173;
      }
      paramView = a(paramView);
      if (paramView == null) {
        break label154;
      }
      if (paramView.contentLength() <= 0) {
        break label135;
      }
      bool1 = true;
    }
    label135:
    label154:
    label173:
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((localChatMessage instanceof MessageForText))
          {
            if ((!(localChatMessage instanceof MessageForWantGiftMsg)) && (!(localChatMessage instanceof MessageForFoldMsg)))
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((localChatMessage instanceof MessageForMixedMsg))
          {
            bool1 = ((MessageForMixedMsg)localChatMessage).canSelectable();
            break;
          }
          if ((localChatMessage instanceof MessageForReplyText))
          {
            bool1 = true;
            break;
          }
          if ((localChatMessage instanceof MessageForLongMsg))
          {
            bool1 = ((MessageForLongMsg)localChatMessage).canSelectable();
            break;
          }
          bool1 = false;
          break;
          bool1 = bool2;
        } while (!aavp.a().isSelected());
        aavp.a().detach();
        return false;
        bool1 = bool2;
      } while (!aavp.a().isSelected());
      aavp.a().detach();
      return false;
      bool1 = bool2;
    } while (!aavp.a().isSelected());
    aavp.a().detach();
    return false;
  }
  
  public void a(View paramView, aavv paramaavv)
  {
    aawc localaawc = a(paramView);
    if (localaawc == null) {}
    aawe localaawe;
    ChatMessage localChatMessage;
    do
    {
      return;
      localaawe = localaawc.delegate();
      localChatMessage = wja.a(paramView);
    } while ((localaawe == null) || (!localaawe.isSelectable()) || (localaawc.hasSelected()) || (localChatMessage == null));
    if (this.clP == 2) {
      if (this.mApp.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localaawe.Ci(clM);
        localaawe.GG(clN);
      }
    }
    for (;;)
    {
      localaawe.a(paramaavv);
      localaawc.doSelecting(localChatMessage);
      return;
      localaawe.Ci(clM);
      localaawe.GG(clO);
      continue;
      if (this.clP != 1) {
        break;
      }
      if (this.mApp.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localaawe.Ci(clI);
        localaawe.GG(clK);
      }
      else
      {
        localaawe.Ci(clJ);
        localaawe.GG(clL);
      }
    }
    paramView = paramView.getResources();
    int j;
    if (this.mApp.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131167281).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131167283).getDefaultColor();; i = paramView.getColorStateList(2131167282).getDefaultColor())
    {
      localaawe.Ci(j);
      localaawe.GG(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131167280).getDefaultColor();
    }
  }
  
  public boolean a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramView = a(paramView);
    if (paramView == null) {}
    do
    {
      do
      {
        return false;
      } while ((!paramView.hasTouchSelectableArea((int)paramFloat1, (int)paramFloat2)) || (aofy.b(paramView.content().toString(), 0, paramInt2, false).length() < paramInt2));
      paramView = paramView.delegate();
    } while ((paramView == null) || (!paramView.XB()) || (paramView.b(paramFloat1, paramFloat2, paramInt1, paramInt2) == -1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavs
 * JD-Core Version:    0.7.0.1
 */