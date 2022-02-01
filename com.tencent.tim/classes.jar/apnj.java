import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apnj
  extends apmr
{
  public apnj(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 24;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.sessionInfo.aTl;
    Object localObject = (acfs)this.app.getManager(255);
    paramList = "";
    if (localObject != null)
    {
      localObject = ((acfs)localObject).b(paramObject);
      if ((localObject != null) && (((HotChatItemData)localObject).mGameId > 0))
      {
        paramObject = HotChatCenterFragment.a(this.app, ((HotChatItemData)localObject).mHotChatCode, ((HotChatItemData)localObject).mGameId);
        if (paramObject != null)
        {
          paramList = paramObject.wording;
          paramInt1 = 1;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "[showNavigateBarIfNeeded] for " + ((HotChatItemData)localObject).mHotChatCode + " " + ((HotChatItemData)localObject).mGameId);
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        return new apmr.a(true, paramList, null, null, paramObject);
        paramInt1 = 0;
        paramObject = null;
        break;
      }
      return null;
      paramObject = null;
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramString = acfp.m(2131715517);
    paramTextView2.setMaxWidth((int)paramTextView2.getPaint().measureText(paramString));
    paramTextView2.requestLayout();
    paramTextView1.setVisibility(8);
    paramTextView2.setTextColor(this.context.getResources().getColor(2131166500));
    paramImageView.setBackgroundResource(2130838615);
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "[onClick] into page");
    }
  }
  
  public int getIconRes(int paramInt)
  {
    return 2130838614;
  }
  
  public boolean lX(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnj
 * JD-Core Version:    0.7.0.1
 */