import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class avkr
  extends aqju
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, View.OnClickListener, aqnt.a
{
  private int YN;
  protected aqnt a;
  protected avkr.a a;
  private ImageView cW;
  private int exm;
  private String gl;
  private Button hP;
  private AnimationDrawable mAnimationDrawable;
  protected Context mContext;
  private EditText mEditText;
  
  public avkr(Context paramContext, AppRuntime paramAppRuntime, int paramInt, avkr.a parama)
  {
    super(paramContext, 2131756467);
    this.jdField_a_of_type_Avkr$a = parama;
    this.mContext = paramContext;
    this.YN = paramInt;
    super.setContentView(2131559164);
    super.setNegativeButton(2131721058, this);
    super.setPositiveButton(2131693407, this);
    super.setTitle(2131689845);
    ((TextView)super.findViewById(2131365867)).setGravity(3);
    paramInt = aqnm.dip2px(6.0F);
    int i = aqnm.dip2px(16.0F);
    int j = aqnm.dip2px(40.0F);
    int k = aqnm.dip2px(50.0F);
    paramContext = new LinearLayout(this.mContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(16);
    paramAppRuntime = new LinearLayout.LayoutParams(j, j);
    this.cW = new ImageView(this.mContext);
    this.cW.setScaleType(ImageView.ScaleType.FIT_XY);
    paramContext.addView(this.cW, paramAppRuntime);
    this.hP = new Button(this.mContext);
    this.hP.setId(2131373735);
    this.hP.setTextColor(-1);
    this.hP.setBackgroundResource(2130845010);
    this.mAnimationDrawable = ((AnimationDrawable)this.mContext.getResources().getDrawable(2130772286));
    this.hP.setCompoundDrawablesWithIntrinsicBounds(2130845015, 0, 0, 0);
    this.hP.setHeight(k);
    paramContext.addView(this.hP);
    super.findViewById(2131365863).setVisibility(8);
    paramAppRuntime = (RelativeLayout)super.findViewById(2131365859);
    parama = new RelativeLayout.LayoutParams(0, -2);
    parama.addRule(3, 2131365867);
    parama.addRule(5, 2131365867);
    parama.addRule(7, 2131365867);
    parama.bottomMargin = i;
    parama.topMargin = paramInt;
    this.mEditText = ((EditText)super.findViewById(2131369276));
    this.mEditText.setHint(2131693413);
    Object localObject = new InputFilter.LengthFilter(60);
    this.mEditText.setFilters(new InputFilter[] { localObject });
    localObject = (RelativeLayout.LayoutParams)this.mEditText.getLayoutParams();
    paramContext.setId(2131365375);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131365375);
    paramAppRuntime.addView(paramContext, parama);
    this.hP.setOnClickListener(this);
    super.setOnDismissListener(this);
  }
  
  public boolean a(String paramString, int paramInt, Bitmap paramBitmap, Drawable paramDrawable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (ahbj.isFileExists(paramString))
      {
        bool1 = bool2;
        if (paramInt > 0)
        {
          this.hP.setText(xkx.az(paramInt));
          this.hP.setPadding(aqnm.dip2px(20.0F), 0, Math.min(xkx.a(this.mContext, paramInt, null, null, 0), aqnm.dip2px(200.0F)), 0);
          if (paramDrawable == null) {
            break label107;
          }
          this.cW.setImageDrawable(paramDrawable);
        }
      }
    }
    for (;;)
    {
      this.gl = paramString;
      this.exm = paramInt;
      bool1 = true;
      return bool1;
      label107:
      this.cW.setImageBitmap(paramBitmap);
    }
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    this.hP.setCompoundDrawablesWithIntrinsicBounds(2130845015, 0, 0, 0);
    this.mAnimationDrawable.stop();
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.cancel();
      return;
      if (this.jdField_a_of_type_Avkr$a != null) {
        this.jdField_a_of_type_Avkr$a.G(this.gl, this.exm, this.mEditText.getText().toString());
      }
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
      if ((this.jdField_a_of_type_Aqnt != null) && (this.jdField_a_of_type_Aqnt.getState() == 2))
      {
        this.jdField_a_of_type_Aqnt.pause();
        this.hP.setCompoundDrawablesWithIntrinsicBounds(2130845015, 0, 0, 0);
        this.mAnimationDrawable.stop();
      }
      else
      {
        if (this.jdField_a_of_type_Aqnt != null) {
          this.jdField_a_of_type_Aqnt.release();
        }
        this.jdField_a_of_type_Aqnt = new aqnt(this.gl, new Handler(), this.YN);
        this.jdField_a_of_type_Aqnt.cf(super.getContext());
        this.jdField_a_of_type_Aqnt.aFk();
        this.jdField_a_of_type_Aqnt.a(this);
        this.jdField_a_of_type_Aqnt.start();
        this.mAnimationDrawable.stop();
        this.hP.setCompoundDrawablesWithIntrinsicBounds(this.mAnimationDrawable, null, null, null);
        this.mAnimationDrawable.start();
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.mAnimationDrawable.stop();
    if (this.jdField_a_of_type_Aqnt != null) {
      this.jdField_a_of_type_Aqnt.release();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.dismiss();
    }
  }
  
  public static abstract interface a
  {
    public abstract void G(String paramString1, int paramInt, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avkr
 * JD-Core Version:    0.7.0.1
 */