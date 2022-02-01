package com.tencent.mobileqq.apollo.game;

import able;
import ablv;
import ablx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class WebGameFakeView
{
  public static AtomicBoolean cn = new AtomicBoolean(false);
  public Director a = new Director();
  public Bundle au;
  public ablv b;
  public ApolloFragment b;
  public CmGameInitParams b;
  public boolean bDI;
  public boolean bDJ;
  public Context mContext;
  private View mRootView;
  public Window mWindow;
  
  public WebGameFakeView(Window paramWindow, Bundle paramBundle)
  {
    j(paramWindow);
    this.au = paramBundle;
  }
  
  public void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameView", 2, new Object[] { "[notifyEngineSharedResult], aioType:", Integer.valueOf(paramInt3), ",gameId:", Integer.valueOf(paramInt2), ",ret:", Integer.valueOf(paramInt1) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt1);
      localJSONObject.put("gameId", paramInt2);
      localJSONObject.put("aioType", paramInt3);
      localJSONObject.put("shareTo", paramInt4);
      en("sc.share_game_to_friend_result.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameView", 1, localThrowable, new Object[0]);
    }
  }
  
  public CmGameInitParams a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  }
  
  public void a(ablv paramablv)
  {
    this.jdField_b_of_type_Ablv = paramablv;
  }
  
  public void a(CmGameInitParams paramCmGameInitParams)
  {
    this.jdField_b_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.aP(paramCmGameInitParams);
    }
  }
  
  public void cCT()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.NF();
    }
  }
  
  public void cCU()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.cCJ();
    }
  }
  
  public void cCV()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.cCI();
    }
  }
  
  public void cCW()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.cCK();
    }
  }
  
  public void cCX()
  {
    RelativeLayout localRelativeLayout1;
    RelativeLayout localRelativeLayout2;
    TextView localTextView;
    ImageView localImageView;
    if ((this.a != null) && (this.mRootView != null))
    {
      localRelativeLayout1 = (RelativeLayout)this.mRootView.findViewById(2131362789);
      localRelativeLayout2 = (RelativeLayout)this.mRootView.findViewById(2131365356);
      localTextView = (TextView)this.mRootView.findViewById(2131362788);
      localTextView.setVisibility(0);
      localImageView = (ImageView)this.mRootView.findViewById(2131362790);
      if (!TextUtils.isEmpty(this.a.frontColor))
      {
        if (!this.a.frontColor.trim().toLowerCase().equals("#000000")) {
          break label234;
        }
        localImageView.setImageResource(2130840579);
        localRelativeLayout2.setBackgroundResource(0);
        if (ImmersiveUtils.eB()) {
          ImmersiveUtils.a(this.mWindow, false);
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.a.bgColor)) && (this.mContext != null) && ((this.mContext instanceof ApolloGameActivity))) {
        ((ApolloGameActivity)this.mContext).setStatusColor(Color.parseColor(this.a.bgColor));
      }
      localTextView.setTextColor(Color.parseColor(this.a.frontColor));
      localTextView.setText(this.a.title);
      localTextView.setTextSize(this.a.titleSize);
      localRelativeLayout1.setBackgroundColor(Color.parseColor(this.a.bgColor));
      return;
      label234:
      if (this.a.frontColor.trim().toLowerCase().equals("#ffffff"))
      {
        localImageView.setImageResource(2130848574);
        localRelativeLayout2.setBackgroundResource(2130838577);
        if (ImmersiveUtils.eB()) {
          ImmersiveUtils.a(this.mWindow, true);
        }
      }
    }
  }
  
  public void dX(View paramView)
  {
    if ((this.bDI) && (paramView != null))
    {
      this.mRootView = paramView;
      TextView localTextView = (TextView)paramView.findViewById(2131362788);
      paramView = (FrameLayout)paramView.findViewById(2131367885);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.addRule(3, 2131362789);
      paramView.setLayoutParams(localLayoutParams);
      paramView.requestLayout();
      localTextView.setVisibility(0);
    }
  }
  
  public void da(Intent paramIntent)
  {
    ImageView localImageView;
    if (this.mRootView != null)
    {
      localImageView = (ImageView)this.mRootView.findViewById(2131362790);
      if (able.a().zD() <= 1) {
        break label84;
      }
      localImageView.setVisibility(0);
      localImageView.setOnClickListener(new ablx(this, localImageView));
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getSerializableExtra("Director");
        if ((paramIntent != null) && ((paramIntent instanceof Director)))
        {
          this.a = ((Director)paramIntent);
          cCX();
        }
      }
      return;
      label84:
      localImageView.setVisibility(8);
    }
  }
  
  public void db(Intent paramIntent)
  {
    if ((this.mContext != null) && ((this.mContext instanceof Activity))) {
      ((Activity)this.mContext).runOnUiThread(new WebGameFakeView.2(this, paramIntent));
    }
  }
  
  public void destroy(boolean paramBoolean)
  {
    this.mWindow = null;
    this.jdField_b_of_type_Ablv = null;
    this.au = null;
    this.jdField_b_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    this.mRootView = null;
    this.jdField_b_of_type_ComTencentMobileqqApolloGameApolloFragment = null;
    if (paramBoolean)
    {
      if ((this.mContext != null) && ((this.mContext instanceof Activity)))
      {
        ((Activity)this.mContext).finish();
        this.mContext = null;
      }
      return;
    }
    this.mContext = null;
  }
  
  public void en(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.en(paramString1, paramString2);
    }
  }
  
  public int getGameId()
  {
    if (this.au != null)
    {
      Serializable localSerializable = this.au.getSerializable("game_init");
      if ((localSerializable != null) && ((localSerializable instanceof CmGameStartChecker.StartCheckParam))) {
        return ((CmGameStartChecker.StartCheckParam)localSerializable).gameId;
      }
    }
    return -1;
  }
  
  public void j(Window paramWindow)
  {
    this.mWindow = paramWindow;
    this.mContext = this.mWindow.getContext();
  }
  
  public Bundle l()
  {
    return this.au;
  }
  
  public void onBackground()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.onBackground();
    }
  }
  
  public void onForeground()
  {
    if (this.jdField_b_of_type_Ablv != null) {
      this.jdField_b_of_type_Ablv.onForeground();
    }
  }
  
  public static class Director
    implements Serializable
  {
    public static String BACKGROUND_COLOR = "backgroundColor";
    public static String FOREGROUND_COLOR;
    public static final String TAG = "Director";
    public static String TITLE = "title";
    public static String TITLE_SIZE = "titleSize";
    public String bgColor = "#000000";
    public String frontColor = "#ffffff";
    public String title = "";
    public float titleSize = 18.0F;
    
    static
    {
      FOREGROUND_COLOR = "foregroundColor";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.WebGameFakeView
 * JD-Core Version:    0.7.0.1
 */