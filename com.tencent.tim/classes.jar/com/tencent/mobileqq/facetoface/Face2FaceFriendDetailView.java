package com.tencent.mobileqq.facetoface;

import agax;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import wja;

public class Face2FaceFriendDetailView
  extends Face2FaceDetailBaseView
{
  private Face2FaceAddFriendActivity a;
  private HashMap<String, String> ky;
  private String mFriendUin;
  
  public Face2FaceFriendDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, String paramString, HashMap<String, String> paramHashMap, View.OnClickListener paramOnClickListener)
  {
    this.a = paramFace2FaceAddFriendActivity;
    this.mFriendUin = paramString;
    this.ky = paramHashMap;
    this.mHeadView.setOnClickListener(paramOnClickListener);
    super.a(paramView, paramFace2FaceFriendBubbleView);
  }
  
  public boolean akG()
  {
    deG();
    return true;
  }
  
  public void hide()
  {
    deG();
    EditText localEditText = (EditText)findViewById(2131367669);
    this.ky.put(this.mFriendUin, localEditText.getText().toString());
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.a.des();
  }
  
  protected void initView()
  {
    this.mHeadView = findViewById(2131367670);
    this.CG = findViewById(2131367721);
    this.CJ = findViewById(2131367664);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.CJ.setPadding(wja.dp2px(10.0F, this.CJ.getResources()), wja.dp2px(15.0F, this.CJ.getResources()) + ImmersiveUtils.getStatusBarHeight(this.CJ.getContext()), wja.dp2px(10.0F, this.CJ.getResources()), wja.dp2px(15.0F, this.CJ.getResources()));
    }
    this.CJ.setOnClickListener(new agax(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView
 * JD-Core Version:    0.7.0.1
 */