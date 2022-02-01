package com.tencent.token.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.token.aac;
import com.tencent.token.ahg;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.sz;
import com.tencent.token.xa;

public class FaceRecognitionCreateActivity
  extends BaseActivity
{
  private Button btn_reg;
  private CheckBox chk;
  private Button fr_btn_scan;
  private boolean fromspalsh;
  private int istry;
  private TextView tv_licence;
  
  public static boolean getFlag()
  {
    try
    {
      boolean bool = RqdApplication.n().getSharedPreferences("create_notice_flag", 0).getBoolean("notice_flag", false);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xa.c(localStringBuilder.toString());
    }
    return false;
  }
  
  private void initNotice()
  {
    setTitle(2131493688);
    this.fr_btn_scan = ((Button)findViewById(2131165510));
    this.fr_btn_scan.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionCreateActivity.this, FaceRegCameraActivity.class);
        paramAnonymousView.putExtra("scene", 1);
        paramAnonymousView.putExtra("flag", 1);
        FaceRecognitionCreateActivity.this.startActivity(paramAnonymousView);
        FaceRecognitionCreateActivity.this.finish();
      }
    });
  }
  
  private void initReg()
  {
    this.chk = ((CheckBox)findViewById(2131165511));
    this.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          FaceRecognitionCreateActivity.this.btn_reg.setTextAppearance(FaceRecognitionCreateActivity.this, 2131558837);
          FaceRecognitionCreateActivity.this.btn_reg.setBackgroundResource(2131099777);
          FaceRecognitionCreateActivity.this.btn_reg.setEnabled(true);
          return;
        }
        FaceRecognitionCreateActivity.this.btn_reg.setTextAppearance(FaceRecognitionCreateActivity.this, 2131558795);
        FaceRecognitionCreateActivity.this.btn_reg.setBackgroundResource(2131099875);
        FaceRecognitionCreateActivity.this.btn_reg.setEnabled(false);
      }
    });
    this.tv_licence = ((TextView)findViewById(2131165520));
    this.tv_licence.setText(Html.fromHtml(getResources().getString(2131493159)));
    this.tv_licence.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = FaceRecognitionCreateActivity.this;
        aac.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131493439), FaceRecognitionCreateActivity.this.getResources().getString(2131493440));
      }
    });
    this.btn_reg = ((Button)findViewById(2131165509));
    this.btn_reg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (FaceRecognitionCreateActivity.this.chk.isChecked())
        {
          if (sz.a().k.b() == null)
          {
            paramAnonymousView = FaceRecognitionCreateActivity.this;
            paramAnonymousView.showNoAccountTipDialog(paramAnonymousView, 3, 0);
            return;
          }
          if (!sz.a().k.b().mIsBinded)
          {
            paramAnonymousView = FaceRecognitionCreateActivity.this;
            paramAnonymousView.showNoAccountTipDialog(paramAnonymousView, 3, 1);
            return;
          }
          if (FaceRecognitionCreateActivity.getFlag())
          {
            paramAnonymousView = new Intent(FaceRecognitionCreateActivity.this, FaceRegCameraActivity.class);
            paramAnonymousView.putExtra("scene", 1);
            paramAnonymousView.putExtra("flag", 1);
            FaceRecognitionCreateActivity.this.startActivity(paramAnonymousView);
            FaceRecognitionCreateActivity.this.finish();
            return;
          }
          FaceRecognitionCreateActivity.this.setContentView(2131296339);
          FaceRecognitionCreateActivity.this.initNotice();
        }
      }
    });
  }
  
  public static void saveFlag()
  {
    try
    {
      SharedPreferences.Editor localEditor = RqdApplication.n().getSharedPreferences("create_notice_flag", 0).edit();
      localEditor.putBoolean("notice_flag", true);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xa.c(localStringBuilder.toString());
    }
  }
  
  public void onBackPressed()
  {
    if (this.fromspalsh)
    {
      Intent localIntent = new Intent(this, IndexActivity.class);
      localIntent.putExtra("index_from", 21);
      startActivity(localIntent);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.istry = getIntent().getIntExtra("istry", -1);
    this.fromspalsh = getIntent().getBooleanExtra("fromsplash", false);
    setContentView(2131296338);
    initReg();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          FaceRecognitionCreateActivity.this.onBackPressed();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionCreateActivity
 * JD-Core Version:    0.7.0.1
 */