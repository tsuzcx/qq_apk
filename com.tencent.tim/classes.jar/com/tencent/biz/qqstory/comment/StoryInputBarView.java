package com.tencent.biz.qqstory.comment;

import acfp;
import afmf;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import atau.a;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import pqj;
import pqz;
import pra;
import prb;
import prc;
import prd;
import psr;
import psx;
import ptq;
import qrj;
import qrx;
import qyk.e;
import rar;
import rpq;

public class StoryInputBarView
  extends RelativeLayout
  implements View.OnClickListener
{
  private long Ap;
  public ImageButton Z;
  public CommentLikeFeedItem a;
  public BubbleTextView a;
  protected SystemEmoticonPanel a;
  public qrj a;
  private qyk.e a;
  public boolean aBk;
  public boolean aBl = true;
  public FrameLayout aE;
  public XEditTextEx b;
  private int bjV;
  public pqj c;
  public Button ce;
  public CommentEntry d;
  afmf e = new prd(this);
  public Context mContext;
  public int mFeedType;
  private Rect mRect = new Rect();
  public View mRootView;
  public View ob;
  
  public StoryInputBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryInputBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StoryInputBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sn);
    this.bjV = paramAttributeSet.getResourceId(0, 0);
    paramAttributeSet.recycle();
    this.mContext = paramContext;
    initView(paramContext);
  }
  
  public static BubbleTextView a(Context paramContext, View paramView, EditText paramEditText, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      psr localpsr = (psr)psx.a(10);
      if (!((Boolean)localpsr.c("has_show_at_video_intro", Boolean.valueOf(false))).booleanValue())
      {
        BubbleTextView localBubbleTextView = new BubbleTextView(paramContext);
        localBubbleTextView.setPadding(rpq.dip2px(paramContext, 10.0F), rpq.dip2px(paramContext, 11.0F), rpq.dip2px(paramContext, 10.0F), rpq.dip2px(paramContext, 11.0F));
        localBubbleTextView.setIncludeFontPadding(false);
        localBubbleTextView.setTextSize(1, 16.0F);
        localBubbleTextView.setTextColor(-1);
        localBubbleTextView.setText(acfp.m(2131714857));
        localBubbleTextView.initView();
        Object localObject = paramView.getParent();
        if ((localObject != null) && (!(localObject instanceof RelativeLayout))) {
          localObject = ((ViewParent)localObject).getParent();
        }
        for (int i = 1;; i = 0)
        {
          RelativeLayout.LayoutParams localLayoutParams;
          if ((localObject != null) && ((localObject instanceof RelativeLayout)))
          {
            localObject = (RelativeLayout)localObject;
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (i == 0) {
              break label265;
            }
            localLayoutParams.addRule(8, ((ViewGroup)paramView.getParent()).getId());
          }
          for (localLayoutParams.bottomMargin = rpq.dip2px(paramContext, 55.0F);; localLayoutParams.bottomMargin = (-rpq.dip2px(paramContext, 1.0F)))
          {
            localLayoutParams.leftMargin = rpq.dip2px(paramContext, 12.0F);
            ((RelativeLayout)localObject).addView(localBubbleTextView, localLayoutParams);
            localBubbleTextView.setOnClickListener(new prc(paramEditText));
            localpsr.n("has_show_at_video_intro", Boolean.valueOf(true));
            rar.a("home_page", "guide_at", 0, 0, new String[0]);
            return localBubbleTextView;
            label265:
            localLayoutParams.addRule(2, paramView.getId());
          }
        }
      }
    }
    return null;
  }
  
  private void bmy()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.ob.setVisibility(0);
    this.Z.setSelected(true);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
    {
      i = rar.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label103;
      }
    }
    label103:
    for (String str = "1";; str = "2")
    {
      rar.a("home_page", "switch_face", i, 0, new String[] { str, rar.bX(this.mFeedType), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  private void bmz()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.ob.setVisibility(8);
    this.Z.setSelected(false);
  }
  
  public void a(pqj parampqj, CommentEntry paramCommentEntry)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) {
      return;
    }
    show();
    this.c = parampqj;
    this.d = paramCommentEntry;
    boolean bool;
    if (this.d != null)
    {
      parampqj = this.d.authorName;
      if (TextUtils.isEmpty(this.d.authorName))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
          break label158;
        }
        bool = true;
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
          break label177;
        }
        parampqj = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
        if (!bool) {
          break label177;
        }
      }
    }
    label158:
    label177:
    for (parampqj = parampqj.qq;; parampqj = null)
    {
      parampqj = qrx.a(this.d.authorUnionId, this.d.authorUin, bool, parampqj);
      this.b.setHint(acfp.m(2131714856) + parampqj + "：");
      return;
      bool = false;
      break;
      this.b.setHint(acfp.m(2131714858));
      return;
    }
  }
  
  public void bmx()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null)
    {
      ViewParent localViewParent2 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.getParent();
      ViewParent localViewParent1 = localViewParent2;
      if (localViewParent2 != null)
      {
        localViewParent1 = localViewParent2;
        if (!(localViewParent2 instanceof RelativeLayout)) {
          localViewParent1 = localViewParent2.getParent();
        }
      }
      if ((localViewParent1 != null) && ((localViewParent1 instanceof RelativeLayout))) {
        ((RelativeLayout)localViewParent1).removeView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = null;
    }
  }
  
  public void destroy()
  {
    if ((this.b != null) && (this.jdField_a_of_type_Qrj != null)) {
      this.b.removeTextChangedListener(this.jdField_a_of_type_Qrj);
    }
  }
  
  public void hide()
  {
    this.mRootView.setVisibility(8);
    setKeyBoardState(false);
    bmz();
    if (this.jdField_a_of_type_Qyk$e != null) {
      this.jdField_a_of_type_Qyk$e.bqJ();
    }
  }
  
  public void initView(Context paramContext)
  {
    this.mRootView = LayoutInflater.from(this.mContext).inflate(2131561839, this, true);
    if (this.bjV != 0) {}
    for (View localView = LayoutInflater.from(this.mContext).inflate(2131561931, null, false);; localView = LayoutInflater.from(this.mContext).inflate(2131561809, null, false))
    {
      ((FrameLayout)this.mRootView.findViewById(2131375181)).addView(localView);
      this.b = ((XEditTextEx)this.mRootView.findViewById(2131366528));
      this.aE = ((FrameLayout)this.mRootView.findViewById(2131366380));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.mContext, this.aE, this.b, this.e);
      this.ob = this.mRootView.findViewById(2131365353);
      if (QQStoryContext.isNightMode())
      {
        localView.setBackgroundColor(paramContext.getResources().getColor(2131166760));
        this.b.setBackgroundColor(paramContext.getResources().getColor(2131166759));
        this.b.setHintTextColor(paramContext.getResources().getColor(2131166761));
      }
      this.Z = ((ImageButton)this.mRootView.findViewById(2131366345));
      this.Z.setOnClickListener(this);
      this.ce = ((Button)this.mRootView.findViewById(2131367817));
      this.ce.setOnClickListener(this);
      this.b.setOnEditorActionListener(new pqz(this));
      this.b.setOnTouchListener(new pra(this));
      this.b.setOnFocusChangeListener(new prb(this));
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (System.currentTimeMillis() - this.Ap >= 500L)
      {
        this.Ap = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          bmz();
          if (this.jdField_a_of_type_Qyk$e != null) {
            this.jdField_a_of_type_Qyk$e.bqL();
          }
          setKeyBoardState(true);
        }
        else
        {
          setKeyBoardState(false);
          new Handler().postDelayed(new StoryInputBarView.5(this), 200L);
          continue;
          String str = this.b.getText().toString();
          if (str.length() > 0)
          {
            setKeyBoardState(false);
            if (this.c != null) {
              this.c.a(str, this.d);
            }
            hide();
            this.b.setText("");
            if (this.jdField_a_of_type_Qyk$e != null) {
              this.jdField_a_of_type_Qyk$e.b(str, this.d);
            }
          }
        }
      }
    }
  }
  
  public void setFeedItemData(CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.equals(paramCommentLikeFeedItem))) {
      this.b.setText("");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.mFeedType = paramInt1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId)))
    {
      if (this.jdField_a_of_type_Qrj == null)
      {
        this.jdField_a_of_type_Qrj = new qrj(this.mContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, "1_", paramInt2, paramBoolean);
        this.b.addTextChangedListener(this.jdField_a_of_type_Qrj);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Qrj.mFeedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    this.jdField_a_of_type_Qrj.aET = paramBoolean;
  }
  
  public void setInputViewHideListener(qyk.e parame)
  {
    this.jdField_a_of_type_Qyk$e = parame;
  }
  
  public void setKeyBoardState(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!paramBoolean) {
        break label83;
      }
      this.aBl = true;
      this.b.requestFocus();
      localInputMethodManager.showSoftInput(this.b, 1);
      bmz();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory:StoryInputBarView", 2, "setKeyBoardState: " + paramBoolean);
      }
      return;
      label83:
      this.aBl = false;
      this.b.clearFocus();
      localInputMethodManager.hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
    }
  }
  
  public void show()
  {
    this.mRootView.setVisibility(0);
    setKeyBoardState(true);
    if (this.jdField_a_of_type_Qyk$e != null) {
      this.jdField_a_of_type_Qyk$e.bqK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView
 * JD-Core Version:    0.7.0.1
 */