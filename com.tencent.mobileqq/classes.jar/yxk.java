import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class yxk
  extends yxr
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected zgm a;
  
  public yxk(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Zgm.a() != 0)
    {
      this.jdField_a_of_type_Zgm.a(0);
      this.jdField_a_of_type_Zgm.a.requestFocus();
      blgx.a(this.jdField_a_of_type_Zgm.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Zgm != null) && (this.jdField_a_of_type_Zgm.a() == 0))
    {
      this.jdField_a_of_type_Zgm.a(4);
      blgx.b(this.jdField_a_of_type_Zgm.a);
      this.jdField_a_of_type_Zgm.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Zgm == null)
    {
      this.jdField_a_of_type_Zgm = new zgm(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Zgm.a(new yxm(this));
      this.jdField_a_of_type_Zgm.b(new yxn(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362180));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new yxl(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      g();
      return;
    case 0: 
      g();
      return;
    }
    f();
  }
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    super.a(paramInt, paramzih);
    paramzih.a.videoLabel = a();
    yxt localyxt;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localyxt = this.jdField_a_of_type_Yxt;
        str = a();
        if (!this.jdField_a_of_type_Yxt.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramzih = "2";; paramzih = "1")
    {
      localyxt.a("pub_tag", 0, 0, new String[] { "1", str, paramzih });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Zgm != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Zgm.a() == 0)
      {
        this.jdField_a_of_type_Yxt.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */