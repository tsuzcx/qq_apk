import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

public class anuh
  extends anqv
{
  protected boolean cJU;
  
  protected int IX()
  {
    return 2;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    this.cJU = paramBundle.getBoolean("pre_dialog", false);
    Resources localResources = paramContext.getResources();
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)this.e;
    int i = wja.dp2px(10.0F, localResources);
    if (paramView == null)
    {
      paramBundle = new LinearLayout(paramContext);
      paramBundle.setOrientation(1);
      anuh.a locala = new anuh.a(null);
      paramBundle.setTag(2131375493, locala);
      paramView = paramBundle.getLayoutParams();
      if (paramView == null)
      {
        paramView = new LinearLayout.LayoutParams(-1, -2);
        paramBundle.setLayoutParams(paramView);
        paramView = new TextView(paramContext);
        paramView.setSingleLine(true);
        paramView.setCompoundDrawablePadding(i);
        paramView.setGravity(16);
        paramView.setEllipsize(TextUtils.TruncateAt.END);
        paramView.setTextColor(-16777216);
        paramView.setTextSize(2, 16.0F);
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramView.setPadding(i, i, i, i);
        paramBundle.addView(paramView);
        TextView localTextView = new TextView(paramContext);
        localTextView.setTextColor(-16777216);
        localTextView.setMaxLines(2);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setTextSize(2, 12.0F);
        localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localTextView.setPadding(i, 0, i, i);
        paramBundle.addView(localTextView);
        ImageView localImageView = new ImageView(paramContext);
        Object localObject = new LinearLayout.LayoutParams(BaseChatItemLayout.bOj, (int)(BaseChatItemLayout.bNT * 0.468D));
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramBundle.addView(localImageView);
        paramContext = new TextView(paramContext);
        paramContext.setTextColor(-7829368);
        paramContext.setTextSize(2, 12.0F);
        paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramContext.setCompoundDrawablePadding(wja.dp2px(5.0F, localResources));
        localObject = localResources.getDrawable(2130848198);
        ((Drawable)localObject).setBounds(0, 0, wja.dp2px(18.0F, localResources), wja.dp2px(10.0F, localResources));
        paramContext.setCompoundDrawables((Drawable)localObject, null, null, null);
        paramContext.setPadding(i, i, i, i);
        paramBundle.addView(paramContext);
        locala.titleView = paramView;
        locala.qp = localTextView;
        locala.imageView = localImageView;
        locala.ef = paramContext;
        locala.kF = paramBundle;
        paramView = locala;
        paramContext = paramBundle;
        label443:
        if (!this.cJU) {
          break label517;
        }
        paramContext.setPadding(i, i, i, i);
        label462:
        if (this.e != null) {
          break label528;
        }
        if (QLog.isColorLevel()) {
          QLog.d("StructMsgItemLayoutMicro", 2, "getView but parentMsg or message is null");
        }
      }
    }
    for (;;)
    {
      return paramContext;
      paramView.width = -1;
      paramView.height = -2;
      break;
      paramContext = (LinearLayout)paramView;
      paramView = (anuh.a)paramContext.getTag(2131375493);
      break label443;
      label517:
      paramContext.setPadding(0, 0, 0, 0);
      break label462;
      label528:
      i = wja.dp2px(24.0F, localResources);
      try
      {
        paramBundle = URLDrawable.URLDrawableOptions.obtain();
        paramBundle.mRequestWidth = i;
        paramBundle.mRequestHeight = i;
        paramBundle = URLDrawable.getDrawable(localAbsShareMsg.mContentCover, paramBundle);
        paramBundle.setDecodeHandler(aqbn.b);
        paramBundle.setBounds(0, 0, i, i);
        paramView.titleView.setCompoundDrawables(paramBundle, null, null, null);
        paramView.titleView.setText(localAbsShareMsg.mContentTitle);
        paramView.qp.setText(localAbsShareMsg.mContentSummary);
        paramView.ef.setText(acfp.m(2131715031));
        if (!TextUtils.isEmpty(localAbsShareMsg.mMsg_I_ActionData))
        {
          try
          {
            paramBundle = URLDrawable.getDrawable(localAbsShareMsg.mMsg_I_ActionData, null);
            paramView.imageView.setImageDrawable(paramBundle);
            return paramContext;
          }
          catch (IllegalArgumentException paramView) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsgItemLayoutMicro", 2, "getView fail");
          return paramContext;
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayoutMicro", 2, "getTitleView fail e=" + paramBundle.getMessage());
          }
        }
        paramView.imageView.setImageDrawable(null);
      }
    }
    return paramContext;
  }
  
  public String getName()
  {
    return "layoutMicro";
  }
  
  static class a
    extends BaseBubbleBuilder.e
  {
    public TextView ef;
    public ImageView imageView;
    public LinearLayout kF;
    public TextView qp;
    public TextView titleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuh
 * JD-Core Version:    0.7.0.1
 */