import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class vhg
  extends vhn
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected vqi a;
  
  public vhg(@NonNull vhp paramvhp)
  {
    super(paramvhp);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Vqi.a() != 0)
    {
      this.jdField_a_of_type_Vqi.a(0);
      this.jdField_a_of_type_Vqi.a.requestFocus();
      bfmr.a(this.jdField_a_of_type_Vqi.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Vqi != null) && (this.jdField_a_of_type_Vqi.a() == 0))
    {
      this.jdField_a_of_type_Vqi.a(4);
      bfmr.b(this.jdField_a_of_type_Vqi.a);
      this.jdField_a_of_type_Vqi.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vqi == null)
    {
      this.jdField_a_of_type_Vqi = new vqi(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Vqi.a(new vhi(this));
      this.jdField_a_of_type_Vqi.b(new vhj(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362109));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new vhh(this));
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
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    super.a(paramInt, paramvsd);
    paramvsd.a.videoLabel = a();
    vhp localvhp;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localvhp = this.jdField_a_of_type_Vhp;
        str = a();
        if (!this.jdField_a_of_type_Vhp.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramvsd = "2";; paramvsd = "1")
    {
      localvhp.a("pub_tag", 0, 0, new String[] { "1", str, paramvsd });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Vqi != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Vqi.a() == 0)
      {
        this.jdField_a_of_type_Vhp.a(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhg
 * JD-Core Version:    0.7.0.1
 */