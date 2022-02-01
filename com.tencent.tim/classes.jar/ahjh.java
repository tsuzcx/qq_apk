import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardPreviewMixedMsgController.1;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahjh
  extends ahjf
{
  protected LinearLayout iX;
  protected QQAppInterface mApp;
  private int mMinHeight;
  
  public ahjh(aqju paramaqju, QQAppInterface paramQQAppInterface)
  {
    super(paramaqju);
    this.mApp = paramQQAppInterface;
  }
  
  private void W(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramChatMessage = (MessageForMixedMsg)paramChatMessage;
      if (paramChatMessage.msgElemList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewMixedMsgController", 2, " initMixMsgLayout size:" + paramChatMessage.msgElemList.size());
        }
        int i = aqnm.dip2px(4.0F);
        paramChatMessage = new ArrayList(paramChatMessage.msgElemList).iterator();
        while (paramChatMessage.hasNext())
        {
          Object localObject2 = (MessageRecord)paramChatMessage.next();
          Object localObject1;
          if ((localObject2 instanceof MessageForText))
          {
            localObject1 = new AnimationTextView(this.mContext);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131165823));
            ((AnimationTextView)localObject1).setSpannableFactory(aofk.a);
            if (!TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
              ((AnimationTextView)localObject1).setText(new aofk(((MessageForText)localObject2).sb2.toString(), 5, 20));
            }
            for (;;)
            {
              localObject2 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject2).gravity = 3;
              ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
              this.iX.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
              break;
              if (!TextUtils.isEmpty(((MessageForText)localObject2).sb)) {
                ((AnimationTextView)localObject1).setText(new aofk(((MessageForText)localObject2).sb.toString(), 5, 20));
              } else if (!TextUtils.isEmpty(((MessageForText)localObject2).msg)) {
                ((AnimationTextView)localObject1).setText(new aofk(((MessageForText)localObject2).msg, 5, 20));
              }
            }
          }
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            localObject1 = new ImageView(this.mContext);
            localObject2 = xkl.b(this.mContext, (MessageForPic)localObject2);
            if (localObject2 != null)
            {
              if (((((URLDrawable)localObject2).getCurrDrawable() instanceof RoundRectDrawable)) && (anH()))
              {
                RoundRectDrawable localRoundRectDrawable = (RoundRectDrawable)((URLDrawable)localObject2).getCurrDrawable();
                ((ImageView)localObject1).setImageDrawable(new afei(0, localRoundRectDrawable.getIntrinsicWidth(), localRoundRectDrawable.getIntrinsicHeight()));
                ((ImageView)localObject1).postDelayed(new ForwardPreviewMixedMsgController.1(this, (ImageView)localObject1, (URLDrawable)localObject2), 300L);
              }
              for (;;)
              {
                ((ImageView)localObject1).setAdjustViewBounds(true);
                localObject2 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject2).gravity = 3;
                ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
                this.iX.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                break;
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              }
            }
          }
          else if ((localObject2 instanceof MessageForReplyText))
          {
            localObject2 = (MessageForReplyText)localObject2;
            localObject1 = new AnimationTextView(this.mContext);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.mContext.getResources().getColor(2131165823));
            ((AnimationTextView)localObject1).setSpannableFactory(aofk.a);
            if (!TextUtils.isEmpty(((MessageForReplyText)localObject2).sb))
            {
              ((AnimationTextView)localObject1).setText(new aofk(((MessageForReplyText)localObject2).sb.toString(), 5, 20));
              ((AnimationTextView)localObject1).setVisibility(0);
            }
            for (;;)
            {
              localObject2 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject2).gravity = 3;
              ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
              this.iX.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
              break;
              ((AnimationTextView)localObject1).setVisibility(8);
            }
          }
        }
      }
      this.iX.getViewTreeObserver().addOnGlobalLayoutListener(new ahji(this));
    }
  }
  
  private boolean anH()
  {
    String str = Build.MODEL;
    if ((str.equals("vivo X20A")) || (str.equals("vivo X20")) || (str.equals("vivo X20Plus A")) || (str.equals("vivo X20Plus")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardPreviewMixedMsgController", 2, "isVivoBlackModel  ");
      }
      return true;
    }
    return false;
  }
  
  private void dor()
  {
    if (this.iX.getHeight() >= aqnm.dip2px(this.mMinHeight + 1))
    {
      this.b.setMaxHeight(aqnm.dip2px(450.0F));
      this.b.requestLayout();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardPreviewMixedMsgController", 2, " reset height ");
      }
    }
  }
  
  protected int EZ()
  {
    if (this.mMinHeight == 0) {
      this.mMinHeight = ((int)((this.mDialog.getRootViewHeight() - this.mContext.getResources().getDimensionPixelSize(2131297368)) / aqnm.mDensity));
    }
    return this.mMinHeight;
  }
  
  public void a(String paramString, MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewMixedMsgController", 2, " bindData ");
    }
    if (paramString != null) {
      dQ(paramString);
    }
    if ((paramMessageForMixedMsg != null) && (this.iX != null)) {
      W(paramMessageForMixedMsg);
    }
  }
  
  protected View getContentView()
  {
    ScrollView localScrollView = new ScrollView(this.mContext);
    localScrollView.setOverScrollMode(2);
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.iX = new LinearLayout(this.mContext);
    int i = aqnm.dip2px(15.0F);
    int j = aqnm.dip2px(8.0F);
    this.iX.setPadding(i, j, i, j);
    this.iX.setOrientation(1);
    localScrollView.addView(this.iX, new ViewGroup.LayoutParams(-1, -2));
    return localScrollView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjh
 * JD-Core Version:    0.7.0.1
 */