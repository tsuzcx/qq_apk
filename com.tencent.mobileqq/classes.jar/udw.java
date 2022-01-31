import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public class udw
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  anhs jdField_a_of_type_Anhs = new udy(this);
  private SystemEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private udz jdField_a_of_type_Udz;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public udw(Context paramContext, View paramView, udz paramudz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Udz = paramudz;
    d();
    e();
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131300153));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300033));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299125);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131300014));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_Anhs);
  }
  
  private void e()
  {
    ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131301272)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new udx(this);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  private void f()
  {
    urk.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard up. mIsForceChange = %s.", Boolean.valueOf(this.d));
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = true;
      h();
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Udz != null) {
      this.jdField_a_of_type_Udz.b(this.d);
    }
    this.d = false;
  }
  
  private void g()
  {
    urk.b("Q.qqstory.detail.KeyboardAndEmojiManager", "on keyboard down. mIsForceChange = %s.", Boolean.valueOf(this.d));
    this.jdField_a_of_type_Boolean = false;
    boolean bool;
    if (!this.c) {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Udz != null) {
        this.jdField_a_of_type_Udz.c(bool);
      }
      this.c = false;
      this.d = false;
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  private void h()
  {
    boolean bool;
    if (!this.c) {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Udz != null) {
        this.jdField_a_of_type_Udz.c(bool);
      }
      this.c = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void a(String paramString)
  {
    ((PatchedButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131301272)).setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = true;
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!paramBoolean) {
        break label79;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      }
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 1);
    }
    for (;;)
    {
      urk.b("Q.qqstory.detail.KeyboardAndEmojiManager", "setKeyBoardState: %s." + paramBoolean);
      return;
      label79:
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewView.getWindowToken(), 0);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = true;
      a(false);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.isFocused()) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    }
    if (this.jdField_a_of_type_Udz != null) {
      this.jdField_a_of_type_Udz.b(this.d);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    if (this.jdField_b_of_type_Boolean) {
      h();
    }
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      } while ((this.jdField_a_of_type_Udz != null) && (this.jdField_a_of_type_Udz.b()));
      this.c = true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        h();
        a(true);
        return;
      }
      a(false);
      new Handler().postDelayed(new KeyboardAndEmojiManager.2(this), 200L);
      return;
    } while (this.jdField_a_of_type_Udz == null);
    this.jdField_a_of_type_Udz.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udw
 * JD-Core Version:    0.7.0.1
 */