package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MoreCommentPanelView
  extends RelativeLayout
{
  private ImageView arrowIcon;
  private TextView hintText;
  private boolean isAlphaBg;
  private Context mContext;
  
  public MoreCommentPanelView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public MoreCommentPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public MoreCommentPanelView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.isAlphaBg = paramBoolean;
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131562855, this);
    this.hintText = ((TextView)findViewById(2131371940));
    this.arrowIcon = ((ImageView)findViewById(2131371938));
    if (this.isAlphaBg)
    {
      setBackgroundColor(this.mContext.getResources().getColor(2131167128));
      setBackgroundResource(2130850070);
      this.hintText.setTextColor(this.mContext.getResources().getColor(2131165385));
      this.arrowIcon.setImageResource(2130850068);
      return;
    }
    setBackgroundColor(this.mContext.getResources().getColor(2131166103));
    setBackgroundResource(2130850069);
  }
  
  public void setHintText(CharSequence paramCharSequence)
  {
    if (this.hintText != null) {
      this.hintText.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.MoreCommentPanelView
 * JD-Core Version:    0.7.0.1
 */