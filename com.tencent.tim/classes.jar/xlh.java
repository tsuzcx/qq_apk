import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qphone.base.util.QLog;

public class xlh
  extends BaseBubbleBuilder
{
  protected static final int PADDING_BOTTOM = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  protected static final int PADDING_TOP = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  protected static final int bUw = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  protected static final int bUx = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  final int bUy = aqcx.dip2px(this.mContext, 50.0F);
  View.OnClickListener onClickListener = new xli(this);
  
  public xlh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    parame = (xlh.b)parame;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561993, null);
      parame.hJ = ((RelativeLayout)paramChatMessage.findViewById(2131378804));
      parame.hI = ((RelativeLayout)paramChatMessage.findViewById(2131378805));
      parame.wI = paramChatMessage.findViewById(2131368610);
      parame.mCover = ((ImageView)paramChatMessage.findViewById(2131365477));
      parame.mTitle = ((TextView)paramChatMessage.findViewById(2131379769));
      parame.kG = ((TextView)paramChatMessage.findViewById(2131379661));
      parame.qH = ((TextView)paramChatMessage.findViewById(2131364968));
    }
    parame.qH.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = rpn.gm(paramBaseChatItemLayout.coverUrl);
      localObject = this.mContext.getResources().getDrawable(2130847328);
      if (jqc.isValidUrl(paramView))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        localURLDrawableOptions.mRequestWidth = this.bUy;
        localURLDrawableOptions.mRequestHeight = this.bUy;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        parame.mCover.setImageDrawable(paramView);
        parame.mTitle.setText(paramBaseChatItemLayout.title);
        paramView = parame.mTitle;
        parame.kG.setText(paramBaseChatItemLayout.summary);
        parame.hI.setOnClickListener(this.onClickListener);
        parame.hI.setOnTouchListener(paramwlz);
        parame.hI.setOnLongClickListener(paramwlz);
      }
    }
    for (;;)
    {
      parame.hJ.setOnTouchListener(new xlh.a(paramwlz));
      paramChatMessage.setOnTouchListener(paramwlz);
      paramChatMessage.setOnLongClickListener(paramwlz);
      return paramChatMessage;
      parame.mCover.setImageDrawable((Drawable)localObject);
      break;
      parame.hI.setVisibility(8);
      parame.wI.setVisibility(8);
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xlh.b();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      rar.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131365509: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.mContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        rar.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQStoryCommentItemBuilder", 2, paramContext.toString());
          }
        }
      }
    case 2131367523: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.bOY);
      paramContext.putInt("forward_source_uin_type", this.sessionInfo.cZ);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      ahgq.f((Activity)this.mContext, paramChatMessage, 21);
      rar.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131372030: 
      super.j(paramChatMessage);
      rar.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.m(paramChatMessage);
    rar.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bUx, PADDING_TOP, bUw, PADDING_BOTTOM);
      return;
    }
    paramView.setPadding(bUw, PADDING_TOP, bUx, PADDING_BOTTOM);
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    parame = (xlh.b)parame;
    if (paramadxp.mTextColor == 0)
    {
      parame.mTitle.setTextColor(Color.argb(178, 0, 0, 0));
      parame.kG.setTextColor(Color.argb(127, 0, 0, 0));
      parame.qH.setTextColor(-16777216);
      parame.wI.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramadxp.mTextColor);
    int j = Color.green(paramadxp.mTextColor);
    int k = Color.blue(paramadxp.mTextColor);
    parame.mTitle.setTextColor(Color.argb(178, i, j, k));
    parame.kG.setTextColor(Color.argb(127, i, j, k));
    parame.qH.setTextColor(paramadxp.mTextColor);
    parame.wI.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    localaqoa.Z(2131365509, this.mContext.getString(2131721060), 2130839077);
    localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    paramView = ((BaseBubbleBuilder.e)wja.a(paramView)).mMessage;
    super.a(localaqoa, this.sessionInfo.cZ, paramView);
    a(localaqoa, paramView);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  class a
    implements View.OnTouchListener
  {
    final wlz b;
    GestureDetector gestureDetector = new GestureDetector(new xlj(this));
    View mView = null;
    
    public a(wlz paramwlz)
    {
      this.b = paramwlz;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (this.b != null) {
        this.b.onTouch(paramView, paramMotionEvent);
      }
      if (this.gestureDetector != null)
      {
        this.mView = paramView;
        this.gestureDetector.onTouchEvent(paramMotionEvent);
        return true;
      }
      this.mView = null;
      return false;
    }
  }
  
  public class b
    extends BaseBubbleBuilder.e
  {
    public RelativeLayout hI;
    public RelativeLayout hJ;
    public TextView kG;
    public ImageView mCover;
    public TextView mTitle;
    public TextView qH;
    public View wI;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */