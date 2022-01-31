import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class vhd
  extends vhk
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected vqf a;
  
  public vhd(@NonNull vhm paramvhm)
  {
    super(paramvhm);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Vqf.a() != 0)
    {
      this.jdField_a_of_type_Vqf.a(0);
      this.jdField_a_of_type_Vqf.a.requestFocus();
      bfni.a(this.jdField_a_of_type_Vqf.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Vqf != null) && (this.jdField_a_of_type_Vqf.a() == 0))
    {
      this.jdField_a_of_type_Vqf.a(4);
      bfni.b(this.jdField_a_of_type_Vqf.a);
      this.jdField_a_of_type_Vqf.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vqf == null)
    {
      this.jdField_a_of_type_Vqf = new vqf(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Vqf.a(new vhf(this));
      this.jdField_a_of_type_Vqf.b(new vhg(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362108));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new vhe(this));
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    super.a(paramInt, paramvsa);
    paramvsa.a.videoLabel = a();
    vhm localvhm;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localvhm = this.jdField_a_of_type_Vhm;
        str = a();
        if (!this.jdField_a_of_type_Vhm.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramvsa = "2";; paramvsa = "1")
    {
      localvhm.a("pub_tag", 0, 0, new String[] { "1", str, paramvsa });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Vqf != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Vqf.a() == 0)
      {
        this.jdField_a_of_type_Vhm.a(0);
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
 * Qualified Name:     vhd
 * JD-Core Version:    0.7.0.1
 */