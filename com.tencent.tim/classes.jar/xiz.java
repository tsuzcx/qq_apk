import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import java.net.MalformedURLException;
import java.net.URL;

public class xiz
  extends BaseBubbleBuilder
{
  Drawable dQ = aC();
  float mDensity = 2.0F;
  View.OnClickListener onClickListener = new xja(this);
  
  public xiz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable aC()
  {
    Bitmap localBitmap1 = aqcu.decodeResource(this.mContext.getResources(), 2130840149);
    if (localBitmap1 == null) {
      return null;
    }
    int i = localBitmap1.getWidth();
    int j = localBitmap1.getHeight();
    Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap2.setDensity(160);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    Rect localRect = new Rect(0, 0, i, j);
    RectF localRectF = new RectF(localRect);
    float f = 11.0F * this.mDensity;
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(localBitmap1, localRect, localRect, localPaint);
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
      localBitmap1.recycle();
    }
    return new BitmapDrawable(localBitmap2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    paramView = (xiz.a)paramChatMessage.getTag();
    paramInt1 = wja.dp2px(1.0F, this.mContext.getResources());
    paramInt2 = paramView.E.getPaddingLeft();
    int i = paramView.E.getPaddingRight();
    int j = paramView.E.getPaddingTop();
    int k = paramView.E.getPaddingBottom();
    paramView.E.setPadding(paramInt2 + paramInt1, j + paramInt1, i + paramInt1, paramInt1 + k);
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xiz.a locala = (xiz.a)parame;
    paramBaseChatItemLayout = (MessageForText)paramChatMessage;
    parame = paramView;
    if (paramView == null)
    {
      parame = LayoutInflater.from(this.mContext).inflate(2131558907, null);
      locala.mTextView = ((TextView)parame.findViewById(2131364506));
      locala.mImageView = ((ImageView)parame.findViewById(2131364502));
    }
    paramView = paramBaseChatItemLayout.location;
    if ((paramView == null) || (paramView.length() == 0)) {
      locala.mTextView.setVisibility(8);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.locationUrl;
      try
      {
        paramBaseChatItemLayout = new URL("location", paramView.getAuthority(), paramView.getFile());
        paramView = paramBaseChatItemLayout;
      }
      catch (MalformedURLException paramBaseChatItemLayout)
      {
        for (;;)
        {
          paramBaseChatItemLayout.printStackTrace();
        }
      }
      paramView = URLDrawable.getDrawable(paramView, this.dQ, this.dQ);
      paramView.setTag(paramChatMessage);
      locala.mImageView.setBackgroundDrawable(paramView);
      parame.setOnClickListener(this.onClickListener);
      parame.setOnLongClickListener(paramwlz);
      parame.setOnTouchListener(paramwlz);
      return parame;
      locala.mTextView.setVisibility(0);
      locala.mTextView.setText(paramView);
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xiz.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131367523)
    {
      paramChatMessage = (MessageForText)paramChatMessage;
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -2);
      paramContext.putString("forward_latitude", paramChatMessage.latitude);
      paramContext.putString("forward_longitude", paramChatMessage.longitude);
      paramContext.putString("forward_location", paramChatMessage.location);
      paramContext.putString("forward_filepath", paramChatMessage.url);
      paramContext.putString("forward_thumb", b(paramChatMessage));
      paramContext.putString("forward_location_string", paramChatMessage.location);
      paramContext.putInt("selection_mode", this.bOY);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ahgq.f((Activity)this.mContext, paramChatMessage, 21);
      anot.a(this.app, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 2131365686)
      {
        ujt.b(this.mContext, this.app, paramChatMessage);
        return;
      }
      if (paramInt == 2131372073)
      {
        super.m(paramChatMessage);
        return;
      }
      if (paramInt == 2131366733)
      {
        paramContext = (MessageForText)paramChatMessage;
        aviz.a(Float.valueOf(paramContext.latitude).floatValue(), Float.valueOf(paramContext.longitude).floatValue(), null, paramContext.location, null).b(this.app, paramContext).b((Activity)this.mContext, this.app.getAccount());
        avjg.a(this.app, 6, 7);
        return;
      }
    } while (paramInt != 2131372062);
    super.m(paramChatMessage);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    paramView.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    ujt.a(paramView, this.mContext, this.sessionInfo.cZ);
    if (wja.eU(5) == 1) {
      paramView.Z(2131366733, this.mContext.getString(2131693407), 2130839085);
    }
    super.c(paramView, this.mContext);
    super.e(paramView, this.mContext);
    return paramView.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131707904);
  }
  
  String b(MessageForText paramMessageForText)
  {
    return acbn.bmW + paramMessageForText.latitude + "_" + paramMessageForText.longitude + ".png";
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)wja.a(paramView);
      str1 = this.mContext.getString(2131690230);
      str2 = this.mContext.getString(2131690231);
    } while (!paramView.isSendFromLocal());
    aqha.a(this.mContext, 230, str1, str2, new xjb(this, paramView), new xjc(this)).show();
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    ImageView mImageView;
    TextView mTextView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xiz
 * JD-Core Version:    0.7.0.1
 */