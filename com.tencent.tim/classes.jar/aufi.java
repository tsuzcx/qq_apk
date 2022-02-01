import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.QfileTabBarView;
import java.util.HashMap;

public class aufi
  implements TabBarView.a
{
  public aufi(QfileTabBarView paramQfileTabBarView) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.b.a(paramInt2) == null) {}
    label79:
    do
    {
      do
      {
        return;
        paramInt1 = 0;
        if (paramInt1 < this.b.lR)
        {
          localObject = this.b.a.b(paramInt1);
          if (localObject != null)
          {
            if (paramInt1 != paramInt2) {
              break label79;
            }
            ((RedDotTextView)localObject).setContentDescription("已选定" + ((RedDotTextView)localObject).getText());
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            ((RedDotTextView)localObject).setContentDescription(((RedDotTextView)localObject).getText() + "按钮");
          }
        }
        this.b.a.setSelected(true);
        this.b.hG(paramInt2);
        QfileTabBarView.a(this.b, paramInt2);
      } while ((!this.b.cgj) || (this.b.d.app == null));
      if (this.b.erq == 1)
      {
        localObject = new atsl();
        ((atsl)localObject).aaC(((Integer)this.b.N.get(Integer.valueOf(paramInt2))).intValue());
        this.b.d.app.a().a(1, (atsk)localObject);
        return;
      }
    } while (this.b.erq != 2);
    Object localObject = new atsm();
    ((atsm)localObject).aaC(((Integer)this.b.N.get(Integer.valueOf(paramInt2))).intValue());
    this.b.d.app.a().a(2, (atsk)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufi
 * JD-Core Version:    0.7.0.1
 */