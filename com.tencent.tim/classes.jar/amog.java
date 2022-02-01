import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.teamwork.PadInfo;

public class amog
  implements ampx
{
  private atkw a;
  private QQAppInterface app;
  public String keyword;
  
  public amog(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void a(atkw paramatkw)
  {
    this.a = paramatkw;
  }
  
  public void a(AsyncImageView paramAsyncImageView)
  {
    if (this.a.relatedType == 7)
    {
      PadInfo localPadInfo = (PadInfo)this.a.fQ;
      if (localPadInfo.type == 1) {
        paramAsyncImageView.setImageResource(2130851565);
      }
      do
      {
        return;
        if (localPadInfo.type == 2)
        {
          paramAsyncImageView.setImageResource(2130851566);
          return;
        }
        if (localPadInfo.type == 3)
        {
          paramAsyncImageView.setImageResource(2130851567);
          return;
        }
      } while (localPadInfo.type != 4);
      paramAsyncImageView.setImageResource(2130851577);
      return;
    }
    athu.a(paramAsyncImageView, this.a);
  }
  
  public void cR(View paramView)
  {
    if (this.a == null) {
      return;
    }
    this.a.n(this.app, paramView.getContext());
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    return "";
  }
  
  public CharSequence g()
  {
    if (this.a == null) {
      return null;
    }
    Object localObject;
    long l;
    if (this.a.relatedType == 7)
    {
      localObject = (PadInfo)this.a.fQ;
      l = Math.max(((PadInfo)localObject).lastEditTime, ((PadInfo)localObject).currentUserBrowseTime);
      if (l <= 0L) {
        break label182;
      }
      if (l == ((PadInfo)localObject).lastEditTime) {
        localObject = String.format(this.app.getApp().getResources().getString(2131720944), new Object[] { "我" });
      }
    }
    for (;;)
    {
      return localObject;
      if (l == ((PadInfo)localObject).currentUserBrowseTime)
      {
        localObject = String.format(this.app.getApp().getResources().getString(2131720947), new Object[] { "我" });
        continue;
        localObject = audx.a(this.app.getApp(), this.a.a) + " " + athu.c((float)this.a.fileSize);
      }
      else
      {
        label182:
        localObject = null;
      }
    }
  }
  
  public CharSequence getDescription()
  {
    if (this.a == null) {
      return null;
    }
    PadInfo localPadInfo;
    if (this.a.relatedType == 7)
    {
      localPadInfo = (PadInfo)this.a.fQ;
      if (localPadInfo == null) {
        return "";
      }
    }
    for (long l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);; l = this.a.getSortTime()) {
      return auqb.bG(l);
    }
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.a == null) {
      return null;
    }
    if (this.a.relatedType == 7)
    {
      localObject = (PadInfo)this.a.fQ;
      if (localObject == null) {
        return "";
      }
    }
    for (Object localObject = ((PadInfo)localObject).title.toLowerCase();; localObject = this.a.fileName) {
      return amxk.a((String)localObject, this.keyword);
    }
  }
  
  public String getUin()
  {
    return "##cloudrecent##";
  }
  
  public int pE()
  {
    return 0;
  }
  
  public int pF()
  {
    return 0;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amog
 * JD-Core Version:    0.7.0.1
 */