import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.RoundRectRelativeLayout;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;

public class xaf
  extends BaseBubbleBuilder
{
  private static final int VIDEO_HEIGHT = aqnm.dpToPx(180.0F);
  private static final Drawable dK = new ColorDrawable(-1);
  private static final Drawable dL = new ColorDrawable(-1);
  private final View.OnClickListener clickListener = new xag(this);
  
  static
  {
    dL.setBounds(0, 0, aqnm.getScreenWidth(), VIDEO_HEIGHT);
  }
  
  public xaf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(URLImageView paramURLImageView, String paramString, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      paramURLImageView.setTag("");
    }
    while (paramString.equals((String)paramURLImageView.getTag())) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mGifRoundCorner = aqnm.dpToPx(2.0F);
    localURLDrawableOptions.mUseSharpPImage = true;
    localURLDrawableOptions.mExtraInfo = paramString;
    localURLDrawableOptions.mPlayGifImage = true;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramURLImageView.setTag(paramString);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramwlz = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    xaf.a locala = (xaf.a)paramwlz.getTag();
    locala.a.setHeadIconVisible(false);
    if ((locala.a.mCheckBox != null) && (locala.a.mCheckBox.getVisibility() == 0)) {}
    for (paramInt2 = aqnm.dpToPx(33.0F);; paramInt2 = 0)
    {
      paramView = (ViewGroup.MarginLayoutParams)xaf.a.a(locala).getLayoutParams();
      if (paramView.leftMargin != paramInt2)
      {
        paramView.leftMargin = paramInt2;
        xaf.a.a(locala).setLayoutParams(paramView);
      }
      StructMsgSubImageVideo.VideoItem localVideoItem;
      try
      {
        paramView = (StructMsgSubImageVideo)((MessageForStructing)paramChatMessage).structingMsg;
        if (paramView != null)
        {
          localVideoItem = paramView.getVideoItem();
          if (localVideoItem == null)
          {
            paramViewGroup = paramView.getImageItem();
            paramView = paramViewGroup;
            if (paramViewGroup != null) {
              break label188;
            }
          }
        }
        else
        {
          shq.a().c(locala, paramInt1);
          paramwlz.setVisibility(8);
          return paramwlz;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.w("AutoVideoItemBuilder", "getView: ", paramView);
          paramView = null;
        }
        paramView = null;
        label188:
        paramwlz.setVisibility(0);
        if (localVideoItem == null) {
          break label387;
        }
      }
      locala.videoWidth = localVideoItem.width;
      locala.videoHeight = localVideoItem.height;
      locala.videoUrl = localVideoItem.videoUrl;
      if (locala.videoHeight != 0) {}
      for (paramInt2 = VIDEO_HEIGHT * locala.videoWidth / locala.videoHeight;; paramInt2 = 0)
      {
        paramView = (RelativeLayout.LayoutParams)locala.as.getLayoutParams();
        paramView.width = paramInt2;
        locala.as.setLayoutParams(paramView);
        xaf.a.a(locala).setVisibility(8);
        locala.hy.setVisibility(0);
        xaf.a.a(locala).setText(localVideoItem.title);
        xaf.a.a(locala, localVideoItem.schema);
        a(locala.as, localVideoItem.coverUrl, dL);
        shq.a().a(locala, paramInt1);
        if ((this.sessionInfo != null) && ("3046055438".equals(this.sessionInfo.aTl))) {
          kds.a(this.app, paramChatMessage, paramwlz);
        }
        return paramwlz;
        label387:
        locala.hy.setVisibility(8);
        xaf.a.a(locala).setText(paramView.title);
        xaf.a.a(locala, paramView.schema);
        if (TextUtils.isEmpty(paramView.imageUrl)) {
          xaf.a.a(locala).setVisibility(8);
        }
        for (;;)
        {
          shq.a().c(locala, paramInt1);
          break;
          xaf.a.a(locala).setVisibility(0);
          a(xaf.a.a(locala), paramView.imageUrl, dK);
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.mContext.getResources();
      paramChatMessage = new RelativeLayout(this.mContext);
      paramChatMessage.setId(2131364503);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131299515);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131368698);
      paramView.addRule(1, 2131364529);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.mContext);
      ((RelativeLayout)localObject2).setId(2131364535);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = aqnm.dpToPx(2.0F);
      paramView = new RoundRectUrlImageView(this.mContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131364536);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(wja.dp2px(133.0F, paramBaseChatItemLayout), wja.dp2px(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(wja.dp2px(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.mContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(acfp.m(2131702979));
      ((TextView)localObject1).setId(2131364537);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.mContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, VIDEO_HEIGHT);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131364535);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, wja.dp2px(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.mContext);
      ((URLImageView)localObject3).setId(2131364544);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.mContext);
      ((TextView)localObject4).setBackgroundResource(2130838063);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(wja.dp2px(43.0F, paramBaseChatItemLayout), wja.dp2px(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = wja.dp2px(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.mContext);
      ((ImageView)localObject5).setBackgroundResource(2130838062);
      ((ImageView)localObject5).setImageResource(2130848567);
      i = wja.dp2px(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = wja.dp2px(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(parame);
      paramChatMessage.setOnTouchListener(paramwlz);
      paramChatMessage.setOnLongClickListener(paramwlz);
      paramChatMessage.setOnClickListener(this.clickListener);
      parame = (xaf.a)parame;
      xaf.a.a(parame, paramChatMessage);
      parame.hy = ((RelativeLayout)localObject2);
      parame.as = ((URLImageView)localObject3);
      parame.sR = ((ImageView)localObject5);
      parame.IU = ((TextView)localObject4);
      xaf.a.a(parame, paramView);
      xaf.a.a(parame, (TextView)localObject1);
    }
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xaf.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    if (paramInt == 2131372073) {
      super.m(paramChatMessage);
    }
    while (paramInt != 2131365686) {
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.e parame, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    parame.E.setBackgroundResource(2130838061);
    paramInt1 = wja.dp2px(10.0F, paramChatMessage);
    paramInt2 = wja.dp2px(14.0F, paramChatMessage);
    parame.E.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    super.c(paramView, this.mContext);
    super.e(paramView, this.mContext);
    a(paramView, this.mContext);
    return paramView.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (aqiu.ms(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append("视频按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    public TextView IU;
    public URLImageView as;
    private URLImageView at;
    public RelativeLayout hy;
    private View rootView;
    public ImageView sR;
    private String schema;
    private TextView titleView;
    public int videoHeight = 960;
    public String videoUrl = "https://v.qqstory.qq.com/shg_1206944563_50009_a1390c0bd23148e29d598d780ad1vid.f30.mp4";
    public int videoWidth = 544;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xaf
 * JD-Core Version:    0.7.0.1
 */