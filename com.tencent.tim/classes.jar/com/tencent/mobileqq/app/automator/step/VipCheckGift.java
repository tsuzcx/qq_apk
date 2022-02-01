package com.tencent.mobileqq.app.automator.step;

import anfc;
import aqxg;
import aqxh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int od()
  {
    Object localObject = (aqxh)this.a.app.getManager(76);
    aqxg localaqxg = ((aqxh)localObject).a();
    if (localaqxg != null)
    {
      if ((localaqxg.status != 0L) || (localaqxg.uniseq == 0L)) {
        break label54;
      }
      ((aqxh)localObject).me(localaqxg.uniseq);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localaqxg.status == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), anfc.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localaqxg.uniseq);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */