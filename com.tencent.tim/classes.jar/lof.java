import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class lof
  implements ndc
{
  lof(loe paramloe, lsb paramlsb, lie paramlie, Container paramContainer) {}
  
  public void aMQ()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    loe.a(this.this$0, true);
    if (loe.a(this.this$0) != null) {
      loe.a(this.this$0).stop();
    }
    if (this.a != null) {
      this.a.resumeAnimation();
    }
    Object localObject = this.b.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((loe.a(this.this$0)) && (ljp.oH() != 0))
    {
      i = ljp.o(this.c.getContext(), str);
      int k = ljp.p(this.c.getContext(), str);
      if ((i < ljp.oI()) && (k < ljp.oJ()))
      {
        ((mhz)localObject).JP = 2;
        ljp.g(this.c.getContext(), str, i + 1);
        ljp.j(this.c.getContext(), str, k + 1);
      }
    }
    if ((ljp.oH() == 1) && (ljp.o(this.c.getContext(), str) > 0))
    {
      localObject = this.c.getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label290;
          }
        }
      }
    }
    label290:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.1.1(this), 1000L);
      }
      loe.b(this.this$0, false);
      localObject = this.b.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        lcc.a().aCi();
      }
      return;
    }
  }
  
  public void aMR()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    loe.a(this.this$0, false);
    if (this.a != null) {
      this.a.pauseAnimation();
    }
    loe.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lof
 * JD-Core Version:    0.7.0.1
 */