import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class uuk
  extends uur
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected vdm a;
  
  public uuk(@NonNull uut paramuut)
  {
    super(paramuut);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Vdm.a() != 0)
    {
      this.jdField_a_of_type_Vdm.a(0);
      this.jdField_a_of_type_Vdm.a.requestFocus();
      beex.a(this.jdField_a_of_type_Vdm.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Vdm != null) && (this.jdField_a_of_type_Vdm.a() == 0))
    {
      this.jdField_a_of_type_Vdm.a(4);
      beex.b(this.jdField_a_of_type_Vdm.a);
      this.jdField_a_of_type_Vdm.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vdm == null)
    {
      this.jdField_a_of_type_Vdm = new vdm(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Vdm.a(new uum(this));
      this.jdField_a_of_type_Vdm.b(new uun(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131296568));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new uul(this));
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
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    super.a(paramInt, paramvfh);
    paramvfh.a.videoLabel = a();
    uut localuut;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localuut = this.jdField_a_of_type_Uut;
        str = a();
        if (!this.jdField_a_of_type_Uut.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramvfh = "2";; paramvfh = "1")
    {
      localuut.a("pub_tag", 0, 0, new String[] { "1", str, paramvfh });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Vdm != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Vdm.a() == 0)
      {
        this.jdField_a_of_type_Uut.a(0);
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
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */