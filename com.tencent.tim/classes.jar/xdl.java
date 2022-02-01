import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class xdl
  extends ClickableSpan
{
  xdl(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    if (aqiw.isNetSupport(this.this$0.mContext))
    {
      paramView = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.this$0.sessionInfo.aTl);
      paramView.a((short)1, localArrayList, false);
      return;
    }
    QQToast.a(this.this$0.mContext, this.this$0.mContext.getResources().getString(2131693404), 1).show(((BaseActivity)this.this$0.mContext).getTitleBarHeight());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdl
 * JD-Core Version:    0.7.0.1
 */