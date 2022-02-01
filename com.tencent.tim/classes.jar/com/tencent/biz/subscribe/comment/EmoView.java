package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import ankt;
import sdm;
import sdn;
import sdo;
import sdq;
import sdt;

public class EmoView
  extends LinearLayout
  implements WorkSpaceView.a, sdt
{
  private a jdField_a_of_type_ComTencentBizSubscribeCommentEmoView$a;
  private WorkSpaceView.a jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$a;
  private boolean aKY = true;
  private EditText ah;
  private a jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$a = new sdo(this);
  private WorkSpaceView jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView;
  private int bwo = 2130839242;
  private int bwp = this.bwo;
  private final int bwq = 28;
  private int bwr = 1;
  private int bws = -1;
  private LinearLayout fh;
  private Handler handler;
  private boolean[] m = { 1, 0, 0, 0 };
  private Activity mActivity;
  
  public EmoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    initView();
  }
  
  private static void a(EditText paramEditText, int paramInt, String paramString)
  {
    paramEditText.getText().insert(paramInt, paramString);
    String str = paramEditText.getText().toString();
    if (paramString.length() + paramInt > str.length())
    {
      paramEditText.setSelection(str.length());
      return;
    }
    paramEditText.setSelection(paramString.length() + paramInt);
  }
  
  public static void a(EditText paramEditText, String paramString)
  {
    int i = paramEditText.getSelectionStart();
    if (i >= paramEditText.length()) {
      try
      {
        paramEditText.append(paramString);
        return;
      }
      catch (Exception localException)
      {
        a(paramEditText, i, paramString);
        return;
      }
    }
    a(paramEditText, i, paramString);
  }
  
  private void bxY()
  {
    ImageView localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(10, 0, 10, 0);
    localImageView.setLayoutParams(localLayoutParams);
    try
    {
      localImageView.setImageDrawable(getContext().getResources().getDrawable(this.bwp));
      if (this.aKY)
      {
        localImageView.setSelected(true);
        this.aKY = false;
      }
      this.fh.addView(localImageView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localImageView.setImageResource(this.bwo);
      }
    }
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView = new WorkSpaceView(getContext());
    this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setOnScreenChangeListener(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 81;
    this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setLayoutParams(localLayoutParams);
    this.handler = new sdm(this);
    this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView.setHandler(this.handler);
    this.fh = new LinearLayout(getContext());
    this.fh.setOrientation(0);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 81;
    this.fh.setPadding(0, 13, 0, 13);
    this.fh.setLayoutParams(localLayoutParams);
    super.addView(this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView);
    super.addView(this.fh);
  }
  
  private void yo(int paramInt)
  {
    int i = 27;
    int j = (int)Math.ceil(107.0D / (27 * 1.0D));
    GridView localGridView = (GridView)LayoutInflater.from(getContext()).inflate(2131558875, null);
    localGridView.setNumColumns(7);
    if (paramInt == j) {
      i = 26;
    }
    sdq localsdq = new sdq(getContext(), paramInt, i, 28, paramInt, this);
    localGridView.setAdapter(localsdq);
    localGridView.setColumnWidth(this.mActivity.getWindowManager().getDefaultDisplay().getWidth() / 7);
    localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, ankt.dip2px(196.0F)));
    this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView.addView(localGridView);
    postDelayed(new EmoView.2(this, paramInt, localGridView, localsdq), 1000L);
    localGridView.setOnItemClickListener(new sdn(this, paramInt));
  }
  
  private void yp(int paramInt)
  {
    int j = this.fh.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.fh.getChildAt(i).setSelected(false);
      i += 1;
    }
    View localView = this.fh.getChildAt(paramInt);
    if (localView != null) {
      localView.setSelected(true);
    }
  }
  
  public void a(Activity paramActivity, Context paramContext, EditText paramEditText, a parama)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView$a = parama;
    this.mActivity = paramActivity;
    resetView();
    this.ah = paramEditText;
    int j = (int)Math.ceil(107.0D / (27 * 1.0D));
    int i = 1;
    while (i <= j)
    {
      bxY();
      i += 1;
    }
    yo(1);
  }
  
  public void cJ(int paramInt)
  {
    this.bwr = (paramInt + 1);
    yp(paramInt);
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$a != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$a.cJ(paramInt);
    }
  }
  
  public void eB(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 27) {
      this.jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$a.MD();
    }
    do
    {
      return;
      paramInt1 = (paramInt2 - 1) * 27 + paramInt1;
    } while (paramInt1 >= 107);
    String str = sdy.EMO_FAST_SYMBOL[sdq.ex[paramInt1]];
    this.jdField_b_of_type_ComTencentBizSubscribeCommentEmoView$a.fT(str);
  }
  
  public void resetView()
  {
    setOrientation(1);
    if (this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView != null) {
      super.removeView(this.jdField_b_of_type_ComTencentBizSubscribeCommentWorkSpaceView);
    }
    if (this.fh != null) {
      super.removeView(this.fh);
    }
    initView();
    this.aKY = true;
  }
  
  public void setNavgationVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.fh != null)
    {
      localLinearLayout = this.fh;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.a parama)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentWorkSpaceView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean MD();
    
    public abstract boolean fT(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView
 * JD-Core Version:    0.7.0.1
 */