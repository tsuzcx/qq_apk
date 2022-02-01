import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class aytn
  extends ReportDialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, rpg.e
{
  private View Gb;
  private ayil a;
  private TextView aib;
  private ayil.a jdField_b_of_type_Ayil$a;
  private FitSystemWindowsRelativeLayout jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private rpg.i jdField_b_of_type_Rpg$i;
  rpg.a c;
  private FrameLayout cJ;
  private int cVo;
  private String cXK = "";
  protected boolean dAi;
  protected Context mContext;
  protected EditText mEditText;
  private int mMode = 1;
  private View mRootView;
  
  public aytn(@NonNull Context paramContext, @NonNull ayil paramayil, ayil.a parama, int paramInt)
  {
    super(paramContext, 2131755374);
    this.mContext = paramContext;
    this.a = paramayil;
    this.jdField_b_of_type_Ayil$a = parama;
    this.cVo = paramInt;
  }
  
  private void b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mEditText.setHint(paramCharSequence);
      this.mEditText.getText().clear();
      return;
    }
    this.mEditText.setText(paramCharSequence);
    this.mEditText.setSelection(this.mEditText.getText().length());
  }
  
  private void bub()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = ayom.getWindowScreenHeight(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, this.mContext.getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.mRootView.findViewById(2131377568));
    this.jdField_b_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.cJ = ((FrameLayout)this.mRootView.findViewById(2131382089));
    this.mRootView.findViewById(2131363243).setOnClickListener(this);
    this.c = rpg.a(this.mContext, 0, 0, null);
    this.c.tW(false);
    this.c.a().setHint(acfp.m(2131716883));
    this.Gb = this.c.getView();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.Gb.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.cJ.addView(this.Gb);
    this.c.a(this);
    this.mEditText = ((EditText)this.mRootView.findViewById(2131382081));
    this.mEditText.setOnEditorActionListener(this);
    this.mEditText.addTextChangedListener(this);
    this.aib = ((TextView)this.mRootView.findViewById(2131382090));
    if (this.jdField_b_of_type_Ayil$a == null)
    {
      this.cVo = 0;
      this.jdField_b_of_type_Rpg$i = this.c.a();
      this.mMode = 1;
      b(this.jdField_b_of_type_Rpg$i.getHint(), true);
    }
    for (;;)
    {
      this.jdField_b_of_type_Rpg$i.ub(true);
      s(this.mEditText.getText().toString());
      return;
      if (this.cVo >= 0) {
        break;
      }
      localObject = this.c.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].setText(this.jdField_b_of_type_Ayil$a.jr[i]);
        i += 1;
      }
      this.cVo = 0;
      this.jdField_b_of_type_Rpg$i = this.c.a();
      this.mMode = 2;
      b(this.jdField_b_of_type_Rpg$i.getText(), false);
    }
    localObject = this.c.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].setText(this.jdField_b_of_type_Ayil$a.jr[i]);
      i += 1;
    }
    if (this.cVo == 0) {}
    for (this.jdField_b_of_type_Rpg$i = this.c.a();; this.jdField_b_of_type_Rpg$i = this.c.a(this.cVo - 1))
    {
      this.mMode = 3;
      b(this.jdField_b_of_type_Ayil$a.jr[this.cVo], false);
      break;
    }
  }
  
  private void s(CharSequence paramCharSequence)
  {
    if (this.cVo == 0) {}
    for (int i = 36;; i = 16)
    {
      int j = aqmr.getWordCountNeo(paramCharSequence.toString());
      if (i - j > 6) {
        break;
      }
      this.aib.setVisibility(0);
      this.aib.setText(String.format("%s/%s", new Object[] { Integer.valueOf(j / 2), Integer.valueOf(i / 2) }));
      return;
    }
    this.aib.setVisibility(4);
  }
  
  public void a(rpg.a parama, rpg.i parami)
  {
    if ((parami instanceof rpg.g))
    {
      this.cVo = 0;
      this.jdField_b_of_type_Rpg$i.ub(false);
      this.jdField_b_of_type_Rpg$i = parami;
      this.jdField_b_of_type_Rpg$i.ub(true);
      if (this.mMode != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Rpg$i.getText())) {
        break label104;
      }
      b(this.jdField_b_of_type_Rpg$i.getHint(), true);
    }
    for (;;)
    {
      s(this.mEditText.getText().toString());
      return;
      if (!(parami instanceof rpg.f)) {
        break;
      }
      this.cVo = (((rpg.f)parami).tM() + 1);
      break;
      label104:
      b(this.jdField_b_of_type_Rpg$i.getText(), false);
      continue;
      label119:
      b(this.jdField_b_of_type_Rpg$i.getText(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cXK = null;
    if (this.jdField_b_of_type_Rpg$i != null) {
      this.cXK = this.jdField_b_of_type_Rpg$i.getText().toString();
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
      dismiss();
    }
  }
  
  public void onDetachedFromWindow()
  {
    int j = 0;
    Object localObject = this.c.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    rpg.i[] arrayOfi;
    if (i < k)
    {
      arrayOfi = localObject[i];
      arrayOfi.ub(false);
      if (((arrayOfi instanceof rpg.f)) && (TextUtils.isEmpty(arrayOfi.getText()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfi instanceof rpg.f)) {
          bool = true;
        }
      }
    }
    localObject = this.c.getBitmap();
    if (localObject != null)
    {
      arrayOfi = this.c.a();
      Rect[] arrayOfRect = new Rect[arrayOfi.length];
      String[] arrayOfString = new String[arrayOfi.length];
      i = j;
      while (i < arrayOfi.length)
      {
        arrayOfRect[i] = arrayOfi[i].getRect();
        arrayOfString[i] = arrayOfi[i].getText().toString();
        i += 1;
      }
      if (this.a != null) {
        this.a.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_b_of_type_Rpg$i != null)
      {
        paramTextView = this.mEditText.getText();
        this.jdField_b_of_type_Rpg$i.setText(paramTextView);
      }
      switch (this.mMode)
      {
      default: 
        return true;
      case 1: 
        if (this.cVo < this.c.tL())
        {
          if (this.cVo == this.c.tL() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_b_of_type_Rpg$i != null) {
            this.jdField_b_of_type_Rpg$i.ub(false);
          }
          this.cVo += 1;
          this.jdField_b_of_type_Rpg$i = this.c.a(this.cVo - 1);
          if (TextUtils.isEmpty(this.jdField_b_of_type_Rpg$i.getText())) {
            b(this.jdField_b_of_type_Rpg$i.getHint(), true);
          }
          for (;;)
          {
            s(this.mEditText.getText().toString());
            this.jdField_b_of_type_Rpg$i.ub(true);
            return true;
            b(this.jdField_b_of_type_Rpg$i.getText(), false);
          }
        }
        dismiss();
        return true;
      case 2: 
        dismiss();
        return true;
      }
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.cVo == 0)
    {
      paramInt1 = 24;
      paramInt2 = aqmr.getWordCountNeo(paramCharSequence.toString());
      if (paramInt1 - paramInt2 > 6) {
        break label172;
      }
      if (paramInt1 - paramInt2 >= 0) {
        break label186;
      }
      localObject = aqmr.substringNeo(paramCharSequence.toString(), 0, paramInt1);
      paramInt2 = aqmr.getWordCountNeo(((CharSequence)localObject).toString());
      b((CharSequence)localObject, false);
    }
    for (;;)
    {
      this.aib.setVisibility(0);
      this.aib.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      for (;;)
      {
        this.jdField_b_of_type_Rpg$i.setText((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          b(this.jdField_b_of_type_Rpg$i.getHint(), true);
        }
        if ((this.cXK != null) && (!paramCharSequence.toString().equals(this.cXK))) {
          this.dAi = true;
        }
        return;
        paramInt1 = 16;
        break;
        label172:
        this.aib.setVisibility(4);
        localObject = paramCharSequence;
      }
      label186:
      localObject = paramCharSequence;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.mRootView = LayoutInflater.from(this.mContext).inflate(paramInt, null);
    bub();
    initView();
    super.setContentView(this.mRootView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytn
 * JD-Core Version:    0.7.0.1
 */