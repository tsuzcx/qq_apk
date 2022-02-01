package com.tencent.moai.nativepages;

import com.tencent.moai.nativepages.component.ALLandingAutoPlay;
import com.tencent.moai.nativepages.component.ALLandingAutoPlayListener;
import com.tencent.moai.nativepages.component.AdLandingPageBaseComp;
import java.util.LinkedList;

class AdLandingPagesUI$1
  implements ALLandingAutoPlayListener
{
  AdLandingPagesUI$1(AdLandingPagesUI paramAdLandingPagesUI) {}
  
  public void onAutoPlay(ALLandingAutoPlay paramALLandingAutoPlay, boolean paramBoolean)
  {
    if (AdLandingPagesUI.access$000(this.this$0) == null) {
      return;
    }
    int j = AdLandingPagesUI.access$000(this.this$0).indexOf(paramALLandingAutoPlay);
    if ((!paramBoolean) && (j != 0))
    {
      AdLandingPageBaseComp localAdLandingPageBaseComp = (AdLandingPageBaseComp)AdLandingPagesUI.access$000(this.this$0).get(0);
      if (((localAdLandingPageBaseComp instanceof ALLandingAutoPlay)) && (((ALLandingAutoPlay)localAdLandingPageBaseComp).isAutoPlaying()))
      {
        paramALLandingAutoPlay.setSilence(true);
        return;
      }
    }
    int i = 0;
    if (i < j)
    {
      paramALLandingAutoPlay = (AdLandingPageBaseComp)AdLandingPagesUI.access$000(this.this$0).get(i);
      if (!(paramALLandingAutoPlay instanceof ALLandingAutoPlay)) {}
      for (;;)
      {
        i += 1;
        break;
        paramALLandingAutoPlay = (ALLandingAutoPlay)paramALLandingAutoPlay;
        if (paramALLandingAutoPlay.isAutoPlaying()) {
          paramALLandingAutoPlay.setSilence(false);
        }
      }
    }
    i = j + 1;
    label144:
    if (i < AdLandingPagesUI.access$000(this.this$0).size())
    {
      paramALLandingAutoPlay = (AdLandingPageBaseComp)AdLandingPagesUI.access$000(this.this$0).get(i);
      if ((paramALLandingAutoPlay instanceof ALLandingAutoPlay)) {
        break label187;
      }
    }
    label187:
    do
    {
      i += 1;
      break label144;
      break;
      paramALLandingAutoPlay = (ALLandingAutoPlay)paramALLandingAutoPlay;
    } while (!paramALLandingAutoPlay.isAutoPlaying());
    paramALLandingAutoPlay.setSilence(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.1
 * JD-Core Version:    0.7.0.1
 */