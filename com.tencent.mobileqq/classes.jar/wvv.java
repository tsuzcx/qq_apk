import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class wvv
  extends wwc
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected xex a;
  
  public wvv(@NonNull wwe paramwwe)
  {
    super(paramwwe);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Xex.a() != 0)
    {
      this.jdField_a_of_type_Xex.a(0);
      this.jdField_a_of_type_Xex.a.requestFocus();
      bhoc.a(this.jdField_a_of_type_Xex.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Xex != null) && (this.jdField_a_of_type_Xex.a() == 0))
    {
      this.jdField_a_of_type_Xex.a(4);
      bhoc.b(this.jdField_a_of_type_Xex.a);
      this.jdField_a_of_type_Xex.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Xex == null)
    {
      this.jdField_a_of_type_Xex = new xex(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Xex.a(new wvx(this));
      this.jdField_a_of_type_Xex.b(new wvy(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362113));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new wvw(this));
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    super.a(paramInt, paramxgs);
    paramxgs.a.videoLabel = a();
    wwe localwwe;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localwwe = this.jdField_a_of_type_Wwe;
        str = a();
        if (!this.jdField_a_of_type_Wwe.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramxgs = "2";; paramxgs = "1")
    {
      localwwe.a("pub_tag", 0, 0, new String[] { "1", str, paramxgs });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Xex != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Xex.a() == 0)
      {
        this.jdField_a_of_type_Wwe.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvv
 * JD-Core Version:    0.7.0.1
 */