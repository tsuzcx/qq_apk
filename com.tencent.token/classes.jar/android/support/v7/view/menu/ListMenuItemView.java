package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.token.ex;
import com.tencent.token.gp.a;
import com.tencent.token.gp.f;
import com.tencent.token.gp.g;
import com.tencent.token.gp.j;
import com.tencent.token.hm;
import com.tencent.token.ho;
import com.tencent.token.hu.a;
import com.tencent.token.jf;

public class ListMenuItemView
  extends LinearLayout
  implements hu.a
{
  private ho a;
  private ImageView b;
  private RadioButton c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private ImageView g;
  private Drawable h;
  private int i;
  private Context j;
  private boolean k;
  private Drawable l;
  private int m;
  private LayoutInflater n;
  private boolean o;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, gp.a.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = jf.a(getContext(), paramAttributeSet, gp.j.MenuView, paramInt, 0);
    this.h = paramAttributeSet.a(gp.j.MenuView_android_itemBackground);
    this.i = paramAttributeSet.g(gp.j.MenuView_android_itemTextAppearance, -1);
    this.k = paramAttributeSet.a(gp.j.MenuView_preserveIconSpacing, false);
    this.j = paramContext;
    this.l = paramAttributeSet.a(gp.j.MenuView_subMenuArrow);
    paramAttributeSet.a.recycle();
  }
  
  private void b()
  {
    this.c = ((RadioButton)getInflater().inflate(gp.g.abc_list_menu_item_radio, this, false));
    addView(this.c);
  }
  
  private void c()
  {
    this.e = ((CheckBox)getInflater().inflate(gp.g.abc_list_menu_item_checkbox, this, false));
    addView(this.e);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.n == null) {
      this.n = LayoutInflater.from(getContext());
    }
    return this.n;
  }
  
  private void setShortcut$25d965e(boolean paramBoolean)
  {
    int i1;
    if ((paramBoolean) && (this.a.d())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (i1 == 0)
    {
      TextView localTextView = this.f;
      char c1 = this.a.c();
      Object localObject;
      if (c1 == 0)
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder(ho.e);
        if (c1 != '\b')
        {
          if (c1 != '\n')
          {
            if (c1 != ' ') {
              ((StringBuilder)localObject).append(c1);
            } else {
              ((StringBuilder)localObject).append(ho.h);
            }
          }
          else {
            ((StringBuilder)localObject).append(ho.f);
          }
        }
        else {
          ((StringBuilder)localObject).append(ho.g);
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      localTextView.setText((CharSequence)localObject);
    }
    if (this.f.getVisibility() != i1) {
      this.f.setVisibility(i1);
    }
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    if (localImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  public final void a(ho paramho)
  {
    this.a = paramho;
    int i2 = 0;
    this.m = 0;
    int i1;
    if (paramho.isVisible()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
    setTitle(paramho.a(this));
    setCheckable(paramho.isCheckable());
    if ((paramho.d()) && (this.a.d())) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    if (i1 == 0)
    {
      TextView localTextView = this.f;
      char c1 = this.a.c();
      Object localObject;
      if (c1 == 0)
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder(ho.e);
        if (c1 != '\b')
        {
          if (c1 != '\n')
          {
            if (c1 != ' ') {
              ((StringBuilder)localObject).append(c1);
            } else {
              ((StringBuilder)localObject).append(ho.h);
            }
          }
          else {
            ((StringBuilder)localObject).append(ho.f);
          }
        }
        else {
          ((StringBuilder)localObject).append(ho.g);
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      localTextView.setText((CharSequence)localObject);
    }
    if (this.f.getVisibility() != i1) {
      this.f.setVisibility(i1);
    }
    setIcon(paramho.getIcon());
    setEnabled(paramho.isEnabled());
    setSubMenuArrowVisible(paramho.hasSubMenu());
    setContentDescription(paramho.getContentDescription());
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public ho getItemData()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ex.a(this, this.h);
    this.d = ((TextView)findViewById(gp.f.title));
    int i1 = this.i;
    if (i1 != -1) {
      this.d.setTextAppearance(this.j, i1);
    }
    this.f = ((TextView)findViewById(gp.f.shortcut));
    this.g = ((ImageView)findViewById(gp.f.submenuarrow));
    ImageView localImageView = this.g;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.l);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.k))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c == null) && (this.e == null)) {
      return;
    }
    Object localObject2;
    if (this.a.e())
    {
      if (this.c == null) {
        b();
      }
      localObject1 = this.c;
      localObject2 = this.e;
    }
    else
    {
      if (this.e == null) {
        c();
      }
      localObject1 = this.e;
      localObject2 = this.c;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(this.a.isChecked());
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      if (((CompoundButton)localObject1).getVisibility() != i1) {
        ((CompoundButton)localObject1).setVisibility(i1);
      }
      if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
        ((CompoundButton)localObject2).setVisibility(8);
      }
      return;
    }
    Object localObject1 = this.e;
    if (localObject1 != null) {
      ((CheckBox)localObject1).setVisibility(8);
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((RadioButton)localObject1).setVisibility(8);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (this.a.e())
    {
      if (this.c == null) {
        b();
      }
      localObject = this.c;
    }
    else
    {
      if (this.e == null) {
        c();
      }
      localObject = this.e;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.k = paramBoolean;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if ((!this.a.b.i) && (!this.o)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 == 0) && (!this.k)) {
      return;
    }
    if ((this.b == null) && (paramDrawable == null) && (!this.k)) {
      return;
    }
    if (this.b == null)
    {
      this.b = ((ImageView)getInflater().inflate(gp.g.abc_list_menu_item_icon, this, false));
      addView(this.b, 0);
    }
    if ((paramDrawable == null) && (!this.k))
    {
      this.b.setVisibility(8);
      return;
    }
    ImageView localImageView = this.b;
    if (i1 == 0) {
      paramDrawable = null;
    }
    localImageView.setImageDrawable(paramDrawable);
    if (this.b.getVisibility() != 0)
    {
      this.b.setVisibility(0);
      return;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
    }
    else if (this.d.getVisibility() != 8)
    {
      this.d.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */