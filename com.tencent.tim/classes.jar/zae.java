import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SingleLineTextView;

public class zae
  extends zap
{
  public zae(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.mMenuFlag = 0;
  }
  
  @TargetApi(11)
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    paramInt2 = 1;
    paramInt1 = 1;
    ImageView localImageView = null;
    paramOnClickListener = null;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof zap.a)) || (((paramView.getTag() instanceof zap.a)) && (((zap.a)paramView.getTag()).bqn)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559075, paramViewGroup, false);
      paramViewGroup = ((FriendItemLayout)paramView).a();
      paramView.setTag(paramViewGroup);
      fN(paramView.findViewById(2131368698));
      localObject = (FrameLayout.LayoutParams)paramViewGroup.hE.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = wja.dp2px(68.0F, this.mContext.getResources());
      paramViewGroup.hE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (View)paramViewGroup.pQ.getParent();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.leftMargin = wja.dp2px(16.0F, this.mContext.getResources());
      ((View)localObject).setLayoutParams(localLayoutParams);
      paramViewGroup.item = this.f;
      paramViewGroup.uin = this.f.uin;
      if (!acbn.bkw.equals(this.f.uin)) {
        break label367;
      }
      if (this.f.status != 0) {
        break label356;
      }
      paramInt1 = 1;
      label224:
      localImageView = paramViewGroup.pQ;
      if (paramInt1 == 0) {
        break label361;
      }
      paramOnClickListener = aH();
      label241:
      localImageView.setImageDrawable(paramOnClickListener);
      paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
      label265:
      paramOnClickListener = this.f.getFriendNickWithAlias();
      paramViewGroup.l.setText(paramOnClickListener);
      if (AppSetting.enableTalkBack)
      {
        paramViewGroup = paramViewGroup.H;
        if (paramViewGroup != null) {
          break label646;
        }
        paramViewGroup = new StringBuilder(24);
      }
    }
    for (;;)
    {
      paramViewGroup.append(paramOnClickListener).append(".");
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup = (zap.a)paramView.getTag();
      paramViewGroup.l.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break;
      label356:
      paramInt1 = 0;
      break label224;
      label361:
      paramOnClickListener = null;
      break label241;
      label367:
      if (acbn.bkx.equals(this.f.uin))
      {
        if (this.f.status == 0) {}
        for (;;)
        {
          localImageView = paramViewGroup.pQ;
          if (paramInt1 != 0) {
            paramOnClickListener = aH();
          }
          localImageView.setImageDrawable(paramOnClickListener);
          paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
          break;
          paramInt1 = 0;
        }
      }
      if (acbn.bkX.equals(this.f.uin))
      {
        if (this.f.status == 0)
        {
          paramInt1 = paramInt2;
          label470:
          if (this.f.status != 11) {
            break label537;
          }
          paramInt2 = 0;
        }
        for (;;)
        {
          localObject = paramViewGroup.pQ;
          paramOnClickListener = localImageView;
          if (paramInt2 != 0) {
            paramOnClickListener = aH();
          }
          ((ImageView)localObject).setImageDrawable(paramOnClickListener);
          paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
          break;
          paramInt1 = 0;
          break label470;
          label537:
          paramInt2 = paramInt1;
          if (this.f.status == 12) {
            paramInt2 = paramInt1;
          }
        }
      }
      if (acbn.bky.equals(this.f.uin))
      {
        paramViewGroup.pQ.setImageDrawable(null);
        paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
        break label265;
      }
      if (!acbn.bkv.equals(this.f.uin)) {
        break label265;
      }
      paramViewGroup.pQ.setImageDrawable(null);
      paramViewGroup.l.setTextColor(getColorStateList(this.mContext, 2131167311));
      break label265;
      label646:
      paramViewGroup.delete(0, paramViewGroup.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zae
 * JD-Core Version:    0.7.0.1
 */